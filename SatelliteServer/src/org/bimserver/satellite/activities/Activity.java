package org.bimserver.satellite.activities;

import java.util.HashSet;
import java.util.Set;

import org.bimserver.satellite.SatelliteServer;
import org.bimserver.satellite.gui.ActivityLogger;

public abstract class Activity {
	private final Set<ActivityLogger> activityLoggers = new HashSet<ActivityLogger>();
	
	public abstract void activate(SatelliteServer satelliteServer);
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
