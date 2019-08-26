package com.github.loganblack88.wpm.models;

public class WebSphereProfile {

	private String name;
	private String location;


	public WebSphereProfile() {}

	public WebSphereProfile(String name, String location) {
		this.name = name;
		this.location = location;
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

}
