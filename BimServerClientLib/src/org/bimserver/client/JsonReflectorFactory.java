package org.bimserver.client;

import org.bimserver.shared.TokenHolder;
import org.bimserver.shared.json.JsonReflector;

public interface JsonReflectorFactory {

	JsonReflector create(String address, TokenHolder tokenHolder);
}
