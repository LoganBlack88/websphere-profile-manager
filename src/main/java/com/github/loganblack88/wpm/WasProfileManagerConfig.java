package com.github.loganblack88.wpm;

import com.github.loganblack88.wpm.io.WasCmdFacade;
import com.github.loganblack88.wpm.models.WebSphereAppServer;
import com.github.loganblack88.wpm.models.WebSphereProfile;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@State(name="WasProfileManagerConfig", storages={ @Storage("WasProfileManagerConfig.xml") })
public class WasProfileManagerConfig implements PersistentStateComponent<WasProfileManagerConfig> {

	private List<WebSphereAppServer> webSphereAppServers;

	@Nullable
	@Override
	public WasProfileManagerConfig getState() {
		return this;
	}

	@Override
	public void loadState(@NotNull WasProfileManagerConfig state) {
		XmlSerializerUtil.copyBean(state, this);

		WasCmdFacade cmd = new WasCmdFacade("C://Program Files/IBM/WebSphere85/AppServer/");
		List<WebSphereProfile> profiles = cmd.getServerProfiles();
		//TODO: Iterate through server installations and load server profiles.


	}

	/*
	@Override
	public void noStateLoaded() {

	}
	*/

	@Nullable
	public static WasProfileManagerConfig getInstance(Project project) {
		return ServiceManager.getService(project, WasProfileManagerConfig.class);
	}


	public List<WebSphereAppServer> getWebSphereAppServers() {
		return webSphereAppServers;
	}

	public void setWebSphereAppServers(List<WebSphereAppServer> webSphereAppServers) {
		this.webSphereAppServers = webSphereAppServers;
	}

}
