package com.github.loganblack88.wpm;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public class ProfileManagerAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {
		ProfileManagerDialog.main(null);
	}
}
