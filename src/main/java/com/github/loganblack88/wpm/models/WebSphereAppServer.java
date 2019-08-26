package com.github.loganblack88.wpm.models;

import java.util.List;

public class WebSphereAppServer {

	private String name;
	private String location;
	private List<WebSphereProfile> serverProfiles;

	public WebSphereAppServer() {}

	public WebSphereAppServer(String name, String location, List<WebSphereProfile> serverProfiles) {
		this.name = name;
		this.location = location;
		this.serverProfiles = serverProfiles;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<WebSphereProfile> getServerProfiles() {
		return serverProfiles;
	}

	public void setProfiles(List<WebSphereProfile> serverProfiles) {
		this.serverProfiles = serverProfiles;
	}

}
