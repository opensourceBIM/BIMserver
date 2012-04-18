package org.bimserver.test.framework.actions;

public class ActionResults {

	private String text;
	private String type;

	public ActionResults(String text) {
		this.text = text;
	}

	public ActionResults() {
		this.text = "";
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}
}
