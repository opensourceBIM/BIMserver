package org.bimserver.shared;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;

public interface ServiceMapInterface {

	<T extends PublicInterface> T get(Class<T> clazz);

	void add(Class<ServiceInterface> class1, RemoteServiceInterface remoteServiceInterface);
}