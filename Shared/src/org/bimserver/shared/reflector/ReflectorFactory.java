package org.bimserver.shared.reflector;

import org.bimserver.shared.interfaces.PublicInterface;

public interface ReflectorFactory {
	<T extends PublicInterface> T createReflector(Class<T> clazz, Reflector reflector);
	<T extends PublicInterface, K extends PublicInterface> Reflector createReflector(Class<K> clazz, T t);
}