package org.bimserver.satellite.activities;

import org.bimserver.satellite.SatelliteServer;

public abstract class Activity {
	public abstract void activate(SatelliteServer satelliteServer);
}
