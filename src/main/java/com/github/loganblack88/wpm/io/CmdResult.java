package com.github.loganblack88.wpm.io;

import java.util.List;

public class CmdResult {

	private List<String> output;
	private List<String> errors;

	public CmdResult() {}


	public List<String> getOutput() {
		return output;
	}

	public void setOutput(List<String> output) {
		this.output = output;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
