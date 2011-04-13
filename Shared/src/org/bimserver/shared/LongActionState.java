package org.bimserver.shared;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LongActionState {
	public enum ActionState {
		UNKNOWN, STARTED, FINISHED
	};

	private int progress;
	private ActionState state;

	public ActionState getState() {
		return state;
	}

	public void setState(ActionState state) {
		this.state = state;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}
}