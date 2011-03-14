package org.bimserver.shared;

public class DownloadState {
	public enum DownloadActionState {
		UNKNOWN, STARTED, FINISHED
	};

	private int progress;
	private DownloadActionState state;

	public DownloadActionState getState() {
		return state;
	}

	public void setState(DownloadActionState state) {
		this.state = state;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

}