package org.bimserver.shared.reflector;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface Reflector {

	Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException;
}