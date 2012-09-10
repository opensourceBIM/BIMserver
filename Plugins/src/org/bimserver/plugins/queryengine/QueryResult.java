package org.bimserver.plugins.queryengine;

import java.util.ArrayList;
import java.util.List;

import org.bimserver.plugins.serializers.IfcModelInterface;

public class QueryResult {
	private boolean isRunOke;
	private final List<String> warnings = new ArrayList<String>();
	private final List<String> errors = new ArrayList<String>();
	private String output = "";
	private IfcModelInterface model;

	public void addWarning(String warning) {
		warnings.add(warning);
	}
	
	public void addError(String error) {
		errors.add(error);
	}

	public IfcModelInterface getModel() {
		return model;
	}

	public void setModel(IfcModelInterface model) {
		this.model = model;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public boolean isRunOke() {
		return isRunOke;
	}

	public void setRunOke(boolean isRunOke) {
		this.isRunOke = isRunOke;
	}
	
	public List<String> getErrors() {
		return errors;
	}
	
	public List<String> getWarnings() {
		return warnings;
	}
}