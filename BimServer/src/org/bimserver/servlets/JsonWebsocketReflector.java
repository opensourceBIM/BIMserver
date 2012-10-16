package org.bimserver.servlets;

import org.bimserver.shared.json.JsonReflector;
import org.bimserver.shared.meta.ServicesMap;
import org.codehaus.jettison.json.JSONException;

import com.google.gson.JsonObject;

public class JsonWebsocketReflector extends JsonReflector {

	private StreamingSocketInterface streamingSocket;

	public JsonWebsocketReflector(ServicesMap servicesMap, StreamingSocketInterface streamingSocket) {
		super(servicesMap);
		this.streamingSocket = streamingSocket;
	}

	@Override
	public JsonObject call(JsonObject request) throws JSONException {
		streamingSocket.send(request);
		return new JsonObject();
	}

	@Override
	protected boolean isOneWay() {
		return true;
	}
}