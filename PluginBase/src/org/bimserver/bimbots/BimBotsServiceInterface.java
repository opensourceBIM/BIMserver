package org.bimserver.bimbots;

import org.bimserver.models.store.ObjectType;

public interface BimBotsServiceInterface {
	BimBotsOutput runBimBot(BimBotsInput input, ObjectType settings) throws BimBotsException;
}
