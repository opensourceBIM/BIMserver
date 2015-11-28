package org.bimserver;

import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.shared.HashMapVirtualObject;

public class ObjectProviderProxy implements ObjectProvider {

	private ObjectProvider objectProvider;
	private ObjectListener objectListener;

	public ObjectProviderProxy(ObjectProvider objectProvider, ObjectListener objectListener) {
		this.objectProvider = objectProvider;
		this.objectListener = objectListener;
	}

	@Override
	public HashMapVirtualObject next() throws BimserverDatabaseException {
		HashMapVirtualObject next = objectProvider.next();
		if (next != null) {
			objectListener.newObject(next);
		}
		return next;
	}
}