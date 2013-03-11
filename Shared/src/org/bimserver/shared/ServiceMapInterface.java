package org.bimserver.shared;

import org.bimserver.shared.interfaces.PublicInterface;

public interface ServiceMapInterface {

	<T extends PublicInterface> T get(Class<T> clazz);
}