package org.eclipse.eXXXtreme.ui.launch;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class TutorialJavaElementDelegate implements IAdaptable {
	private static final Logger log = Logger.getLogger(TutorialJavaElementDelegate.class);

	private IEditorPart editor;
	private IResource resource;
	
	private IResourceServiceProvider resourceServiceProvider;
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegisty;

	
	@Inject
	private IWorkbench workbench;

	public void initializeWith(IEditorPart editorInput) {
		this.editor = editorInput;
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		this.resource = input.getFile();
		resourceServiceProvider = resourceServiceProviderRegisty.getResourceServiceProvider(URI.createPlatformResourceURI(resource.getFullPath().toPortableString(),true));
	}

	public void initializeWith(IFileEditorInput editorInput) {
		this.resource = editorInput.getFile();
		resourceServiceProvider = resourceServiceProviderRegisty.getResourceServiceProvider(URI.createPlatformResourceURI(resource.getFullPath().toPortableString(),true));
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
			this.editor = activePage != null ? activePage.findEditor(editorInput) : null;
		}
	}

	public void initializeWith(IResource resource) {
		this.resource = resource;
		resourceServiceProvider = resourceServiceProviderRegisty.getResourceServiceProvider(URI.createPlatformResourceURI(resource.getFullPath().toPortableString(),true));
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (IJavaElement.class.equals(adapter)) {
			if (editor != null) {
				IJavaElement javaMethod = getJavaElementForXtextEditor(editor);
				if (javaMethod != null) {
					return javaMethod;
				}
			}
			if (resource != null && resourceServiceProvider.get(FileExtensionProvider.class).isValid(resource.getFileExtension())) {
				return getJavaElementForResource(resource);
			}
		}
		return null;
	}

	protected IJavaElement findJavaElement(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult == null)
			return null;
		INode root = parseResult.getRootNode();
		INode node = NodeModelUtils.findLeafNodeAtOffset(root, offset);
		if (node == null)
			return null;
		INode previousSementic = null, nextSemantic = null;
		NodeIterator backwards = new NodeIterator(node);
		while (backwards.hasPrevious()) {
			INode n = backwards.previous();
			if (n instanceof ILeafNode && !((ILeafNode) n).isHidden()) {
				previousSementic = n;
				break;
			}
		}
		NodeIterator forward = new NodeIterator(node);
		while (forward.hasNext()) {
			INode n = forward.next();
			if (n instanceof ILeafNode && !((ILeafNode) n).isHidden()) {
				nextSemantic = n;
				break;
			}
		}
		if (previousSementic == null || nextSemantic == null)
			return null;
		EObject prevObj = NodeModelUtils.findActualSemanticObjectFor(previousSementic);
		EObject nextObj = NodeModelUtils.findActualSemanticObjectFor(nextSemantic);
		if (prevObj == null || nextObj == null)
			return null;
		EObject element = findCommonContainer(prevObj, nextObj);
		JvmIdentifiableElement jvmElement = findAssociatedJvmElement(element);
		if (jvmElement == null)
			return null;
		IJavaElement javaElement = resourceServiceProvider.get(IJavaElementFinder.class).findElementFor(jvmElement);
		return javaElement;
	}

	protected JvmIdentifiableElement findAssociatedJvmElement(EObject element) {
		if (element == null)
			return null;
		Set<EObject> elements = resourceServiceProvider.get(IJvmModelAssociations.class).getJvmElements(element);
		if (elements.isEmpty()) {
			return findAssociatedJvmElement(element.eContainer());
		}
		EObject next = elements.iterator().next();
		if (next instanceof JvmIdentifiableElement)
			return (JvmIdentifiableElement) next;
		return EcoreUtil2.getContainerOfType(next, JvmIdentifiableElement.class);
	}

	protected EObject findCommonContainer(EObject prevObj, EObject nextObj) {
		if (prevObj == null)
			return nextObj;
		if (nextObj == null)
			return null;
		if (prevObj == nextObj)
			return prevObj;
		if (EcoreUtil.isAncestor(prevObj, nextObj)) {
			return prevObj;
		} 
		if (EcoreUtil.isAncestor(nextObj, prevObj)) {
			return nextObj;
		} 
		return findCommonContainer(prevObj.eContainer(), nextObj.eContainer());
	}

	protected IJavaElement getJavaElementForXtextEditor(IEditorPart editor) {
		if (!(editor instanceof XtextEditor))
			return null;
		IJavaProject jp = null;
		if (editor.getEditorInput() instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
			if (!resourceServiceProvider.get(FileExtensionProvider.class).isValid(file.getFileExtension())) {
				return null;
			}
			jp = JavaCore.create(file.getProject());
			if (jp == null || !jp.exists() || !jp.isOpen())
				return null;
		} else {
			return null;
		}
		XtextEditor xtextEditor = (XtextEditor) editor;
		ISelection selection = xtextEditor.getSelectionProvider().getSelection();
		if (!(selection instanceof ITextSelection))
			return null;
		final int offset = ((ITextSelection) selection).getOffset();
		IJavaElement func = xtextEditor.getDocument().readOnly(new IUnitOfWork<IJavaElement, XtextResource>() {
			@Override
			public IJavaElement exec(XtextResource state) throws Exception {
				return findJavaElement(state, offset);
			}
		});
		return func;
	}

	protected IJavaElement getJavaElementForEditor(IEditorPart editor) {
		if (editor.getEditorInput() instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) editor.getEditorInput()).getFile();
			if (resourceServiceProvider.get(FileExtensionProvider.class).isValid(file.getFileExtension())) {
				return getJavaElementForResource(file);
			}
		}
		return null;
	}

	protected IJavaElement getJavaElementForResource(IResource resource) {
		try {
			final String getSourcePath = URI.createPlatformResourceURI(resource.getFullPath().toString(), true).toString();
			List<IFile> resources = resourceServiceProvider.get(IDerivedResourceMarkers.class).findDerivedResources(resource.getProject(), getSourcePath);
			for (IFile file : resources) {
				if (containsElementsSearchedFor(file))
					return JavaCore.create(file);
			}
		} catch (CoreException e) {
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
		return null;
	}

	protected boolean containsElementsSearchedFor(IFile file) {
		return false;
	}

}
