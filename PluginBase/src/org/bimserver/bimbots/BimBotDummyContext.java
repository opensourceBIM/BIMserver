package org.bimserver.bimbots;

public class BimBotDummyContext implements BimBotContext {

	@Override
	public void updateProgress(String label, int percentage) {
	}

	@Override
	public String getCurrentUser() {
		return "dummy user";
	}
}