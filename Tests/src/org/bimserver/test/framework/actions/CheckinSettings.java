package org.bimserver.test.framework.actions;

import java.util.Random;

public class CheckinSettings {
	private boolean allowAsync;
	private boolean allowMerge;

	public CheckinSettings() {
	}
	
	public CheckinSettings(boolean allowAsync, boolean allowMerge) {
		setAllowAsync(allowAsync);
		setAllowMerge(allowMerge);
	}
	
	public boolean isAllowMerge() {
		return allowMerge;
	}

	public void setAllowMerge(boolean allowMerge) {
		this.allowMerge = allowMerge;
	}
	
	public boolean shouldAsync() {
		if (allowAsync) {
			return new Random().nextBoolean();
		}
		return false;
	}

	public boolean shouldMerge() {
		if (allowMerge) {
			return new Random().nextBoolean();
		}
		return false;
	}

	public boolean isAllowAsync() {
		return allowAsync;
	}

	public void setAllowAsync(boolean allowAsync) {
		this.allowAsync = allowAsync;
	}
}