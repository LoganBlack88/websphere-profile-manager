package com.github.loganblack88.wpm.io;

import com.github.loganblack88.wpm.models.WebSphereProfile;
import org.apache.maven.model.profile.ProfileSelector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WasCmdFacade {

	private static final String MANAGE_PROFILES_BAT = "/bin/manageprofiles.bat";
	private static final String LIST_PROFILES_CMD = " -listProfiles";
	private static final String GET_PROFILE_PATH_CMD = " -getPath -profileName ";
	private static final String DELETE_PROFILE_CMD = " -delete -profileName ";

	private final String path;


	public WasCmdFacade(final String path) {
		this.path = path;
	}

	// https://www.ibm.com/support/knowledgecenter/en/SSSH27_9.0.1/com.ibm.rational.clearcase.cc_ms_install.doc/topics/was_install/r_WAS_IHS_tools.htm
	//      manageprofiles.bat -getPath -profileName <profile_name>
	//      manageprofiles.bat -delete -profileName <profile_name>
	public List<WebSphereProfile> getServerProfiles() {
		List<WebSphereProfile> profiles = new ArrayList<>();
		List<String> profileNames = getProfileNames();
		for (String profileName : profileNames) {
			String profilePath = getProfilePath(profileName);
			profiles.add(new WebSphereProfile(profileName, profilePath));
		}
		return profiles;
	}

	private List<String> getProfileNames() {
		final String[] getProfilesCmd = { this.path + MANAGE_PROFILES_BAT, LIST_PROFILES_CMD };
		CmdResult result = runCommand(getProfilesCmd);

		if (result.getOutput() != null && result.getOutput().size() > 0) {
			return parseStringArray(result.getOutput().get(0));
		}
		return new ArrayList<>();
	}

	private String getProfilePath(String profileName) {
		String[] getPathCmd = { this.path + MANAGE_PROFILES_BAT, GET_PROFILE_PATH_CMD, profileName };
		CmdResult pathResult = runCommand(getPathCmd);
		return (pathResult.getOutput() != null && pathResult.getOutput().size() > 0) ? pathResult.getOutput().get(0) : null;
	}


	private CmdResult runCommand(String[] command) {
		CmdResult cmdResult = new CmdResult();
		try {
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

			cmdResult.setOutput(readLines(stdInput));
			cmdResult.setErrors(readLines(stdError));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return cmdResult;
	}

	private List<String> readLines(BufferedReader std) throws IOException {
		List<String> results = new ArrayList<>();
		String s;
		while ((s = std.readLine()) != null) {
			results.add(s);
		}
		return results;
	}

	private List<String> parseStringArray(String str) {
		List<String> results = new ArrayList<>();
		if (str != null) {
			String[] tokens = str.replace("[", "").replace("]", "").split(",");
			for (String token : tokens) {
				results.add(token.trim());
			}
		}
		return results;
	}

}
