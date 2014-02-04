package org.bimserver.plugins.services;

import org.bimserver.interfaces.objects.SObjectType;

public interface NewExtendedDataOnRevisionHandler {
	void newExtendedDataOnRevision(BimServerClientInterface bimServerClientInterface, long poid, long roid, long edid, String userToken, long soid, SObjectType settings);
}
