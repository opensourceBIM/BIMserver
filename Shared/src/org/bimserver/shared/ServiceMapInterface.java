package org.bimserver.shared;

import org.bimserver.shared.interfaces.PublicInterface;

public interface ServiceMapInterface {

	<T extends PublicInterface> T get(Class<T> clazz);

	<T extends PublicInterface> void add(Class<T> class1, T remoteServiceInterface);
}