package com.github.loganblack88.wpm;

import com.github.loganblack88.wpm.models.WebSphereAppServer;
import com.github.loganblack88.wpm.models.WebSphereProfile;

import java.util.Arrays;
import java.util.List;

public class ProfileManagerCtrl {

	private List<WebSphereAppServer> appServers;


	public ProfileManagerCtrl() {
		appServers = Arrays.asList(
				new WebSphereAppServer("WebSphere Application Server 8.5.5", "C://Program Files/IBM/WebSphere85/AppServer/",
						Arrays.asList(new WebSphereProfile("WAS85GL", "C://BuildWorkspace/ServerProfiles/Was85GL/"))),
				new WebSphereAppServer("WebSphere Application Server 9.0", "C://Program Files/IBM/WebSphere9/AppServer/",
						Arrays.asList(new WebSphereProfile("WAS9GL", "C://BuildWorkspace/ServerProfiles/WAS9GL/"),
									  new WebSphereProfile("Was9AC", "C://BuildWorkspace/ServerProfiles/WAS9AC/")))
		);
	}


	public List<WebSphereAppServer> getAppServerDataModel() {
		return appServers;
	}


}
