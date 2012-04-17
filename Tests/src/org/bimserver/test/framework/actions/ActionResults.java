package org.bimserver.test.framework.actions;

public class ActionResults {

	private String text;

	public ActionResults(String text) {
		this.text = text;
	}

	public ActionResults() {
		this.text = "";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
