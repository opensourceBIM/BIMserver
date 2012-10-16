package org.bimserver.servlets;

import com.google.gson.JsonObject;

public interface StreamingSocketInterface {

	void send(JsonObject request);
}
