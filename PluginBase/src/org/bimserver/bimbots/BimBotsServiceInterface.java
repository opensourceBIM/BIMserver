package org.bimserver.bimbots;

import org.bimserver.interfaces.objects.SObjectType;

public interface BimBotsServiceInterface {
	BimBotsOutput runBimBot(BimBotsInput input, SObjectType settings) throws BimBotsException;
}
