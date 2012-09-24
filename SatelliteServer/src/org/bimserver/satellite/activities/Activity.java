package org.bimserver.satellite.activities;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Set;

import org.bimserver.satellite.SatelliteServer;
import org.bimserver.satellite.gui.ActivityLogger;
import org.bimserver.shared.NotificationInterfaceAdapter;

public abstract class Activity extends NotificationInterfaceAdapter {
	private final Set<ActivityLogger> activityLoggers = new HashSet<ActivityLogger>();
	
	public abstract void activate(SatelliteServer satelliteServer);
	public abstract void deactivate(SatelliteServer satelliteServer);
	public abstract String getName();
	
	protected void log(String message) {
		for (ActivityLogger activityLogger : activityLoggers) {
			activityLogger.log(message);
		}
	}
	
	public void registerLogger(ActivityLogger activityLogger) {
		activityLoggers.add(activityLogger);
	}
}