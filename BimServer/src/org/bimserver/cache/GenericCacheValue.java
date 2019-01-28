package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.util.Date;

public abstract class GenericCacheValue {
	private Date lastAccess;
	private final int maxUnaccessedTimeMillis;

	public GenericCacheValue(int maxUnaccessedTime) {
		this.maxUnaccessedTimeMillis = maxUnaccessedTime;
		access();
	}

	public void access() {
		lastAccess = new Date();
	}
	
	public boolean shouldCleanUp() {
		return new Date().getTime() - lastAccess.getTime() > maxUnaccessedTimeMillis;
	}
}
