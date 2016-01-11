package org.bimserver.plugins.serializers;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.shared.HashMapVirtualObject;

public interface ObjectProvider {

	HashMapVirtualObject next() throws BimserverDatabaseException;
}
