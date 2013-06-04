package org.bimserver.shared.reflector;

import org.bimserver.reflector.ReflectorFactoryImpl1;

public class FileBasedReflectorFactoryBuilder implements ReflectorFactoryBuilder{

	@Override
	public ReflectorFactory newReflectorFactory() {
		return new ReflectorFactoryImpl1();
	}
}
