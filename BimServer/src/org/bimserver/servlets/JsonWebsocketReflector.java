package org.bimserver.servlets;

import org.bimserver.shared.json.JsonReflector;
import org.bimserver.shared.meta.ServicesMap;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonWebsocketReflector extends JsonReflector {

	private StreamingSocketInterface streamingSocket;

	public JsonWebsocketReflector(ServicesMap servicesMap, StreamingSocketInterface streamingSocket) {
		super(servicesMap);
		this.streamingSocket = streamingSocket;
	}

	@Override
	public JSONObject call(JSONObject request) throws JSONException {
		streamingSocket.send(request);
		return new JSONObject();
	}

	@Override
	protected boolean isOneWay() {
		return true;
	}
}