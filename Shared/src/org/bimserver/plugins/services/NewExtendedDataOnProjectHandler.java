package org.bimserver.plugins.services;

import org.bimserver.interfaces.objects.SObjectType;

public interface NewExtendedDataOnProjectHandler {
	void newExtendedDataOnProject(BimServerClientInterface bimServerClientInterface, long poid, long edid, String userToken, long soid, SObjectType settings);
}
