package com.github.loganblack88.wpm;

import com.github.loganblack88.wpm.io.WasCmdFacade;
import com.github.loganblack88.wpm.models.WebSphereProfile;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileManagerAction extends AnAction {
	@Override
	public void actionPerformed(@NotNull AnActionEvent e) {

		//TODO: Remove
		WasCmdFacade cmd = new WasCmdFacade("C://Program Files/IBM/WebSphere9/AppServer/");
		List<WebSphereProfile> profiles = cmd.getServerProfiles();

		ProfileManagerDialog.main(null);
	}
}
