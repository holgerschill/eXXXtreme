package org.eclipse.eXXXtreme.ui.launch;

import org.eclipse.jdt.debug.ui.launchConfigurations.JavaApplicationLaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;

public class TutorialJavaApplicationLaunchShortcut extends JavaApplicationLaunchShortcut {
	@Override
	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection newSelection = TutorialLaunchShortcutUtil
					.replaceWithJavaElementDelegates((IStructuredSelection) selection, TutorialJavaElementDelegateMainLaunch.class);
			super.launch(newSelection, mode);
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		TutorialJavaElementDelegate javaElementDelegate = (TutorialJavaElementDelegate) editor.getAdapter(TutorialJavaElementDelegateMainLaunch.class);
		if (javaElementDelegate != null) {
			launch(new StructuredSelection(javaElementDelegate), mode);
		} else {
			super.launch(editor, mode);
		}
	}
}
