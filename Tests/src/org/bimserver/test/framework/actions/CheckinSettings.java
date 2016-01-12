package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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