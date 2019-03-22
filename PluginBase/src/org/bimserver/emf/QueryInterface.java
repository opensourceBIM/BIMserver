package org.bimserver.emf;

import org.bimserver.database.OidCounters;

public interface QueryInterface {

	int getPid();
	int getRid();
	boolean isDeep();
	int getStopRid();
	PackageMetaData getPackageMetaData();
	long getRoid();
	OidCounters getOidCounters();
}
