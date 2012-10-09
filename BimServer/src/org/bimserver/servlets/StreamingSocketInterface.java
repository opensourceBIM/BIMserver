package org.bimserver.servlets;

import org.codehaus.jettison.json.JSONObject;

public interface StreamingSocketInterface {

	void send(JSONObject request);
}
