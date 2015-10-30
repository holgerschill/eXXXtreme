package org.eclipse.eXXXtreme.ui.launch;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@SuppressWarnings("all")
@Singleton
public class TutorialJavaElementDelegateAdapterFactory implements IAdapterFactory {

	@Inject
	private Provider<TutorialJavaElementDelegate> delegateProvider;
	
	@Inject
	private Provider<TutorialJavaElementDelegateMainLaunch> mainDelegateProvider;
	
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof TutorialJavaElementDelegate) {
			return ((TutorialJavaElementDelegate) adaptableObject).getAdapter(adapterType);
		}
		TutorialJavaElementDelegate result = null;
		if (TutorialJavaElementDelegateMainLaunch.class.equals(adapterType)) {
			result = mainDelegateProvider.get();
		} else if (TutorialJavaElementDelegate.class.equals(adapterType)) {
			result = delegateProvider.get();
		}
		if (result != null) {
			if (adaptableObject instanceof IFileEditorInput) {
				result.initializeWith((IFileEditorInput) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IResource) {
				result.initializeWith((IResource) adaptableObject);
				return result;
			}
			if (adaptableObject instanceof IEditorPart) {
				result.initializeWith((IEditorPart) adaptableObject);
				return result;
			}
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { TutorialJavaElementDelegate.class };
	}
	
}
