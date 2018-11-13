package org.bimserver.bimbots;

public interface BimBotContext {

	void updateProgress(String label, int percentage);
	String getCurrentUser();
}
