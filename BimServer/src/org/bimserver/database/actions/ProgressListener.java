package org.bimserver.database.actions;

public interface ProgressListener {
	void updateProgress(String state, int percentage);
}
