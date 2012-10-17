package org.bimserver.shared;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.reflector.Reflector;

public interface ReflectorFactory {
	<T extends PublicInterface> T createReflector(Class<T> clazz, Reflector reflector);
}
