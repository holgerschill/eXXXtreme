package org.eclipse.eXXXtreme.ui.launch;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

public class TutorialLaunchShortcutUtil {
	public static IStructuredSelection replaceWithJavaElementDelegates(IStructuredSelection selection,
			Class<? extends TutorialJavaElementDelegate> delegateType) {
		Object[] originalSelection = selection.toArray();
		Object[] fakeSelection = new Object[originalSelection.length];
		for (int i = 0; i < originalSelection.length; i++) {
			Object original = originalSelection[i];
			if (original == null || original instanceof IJavaElement || original instanceof TutorialJavaElementDelegate
					|| !(original instanceof IAdaptable)) {
				fakeSelection[i] = original;
			} else {
				IAdaptable adaptable = (IAdaptable) original;
				TutorialJavaElementDelegate javaElementDelegate = (TutorialJavaElementDelegate) adaptable.getAdapter(delegateType);
				if (javaElementDelegate != null) {
					fakeSelection[i] = javaElementDelegate;
				} else {
					fakeSelection[i] = original;
				}
			}
		}
		StructuredSelection newSelection = new StructuredSelection(fakeSelection);
		return newSelection;
	}
}
