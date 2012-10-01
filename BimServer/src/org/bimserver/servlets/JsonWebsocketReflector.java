package org.bimserver.servlets;

import java.util.Map;

import org.bimserver.client.JsonReflector;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonWebsocketReflector extends JsonReflector {

	private StreamingSocket streamingSocket;

	public JsonWebsocketReflector(Map<String, SService> services, StreamingSocket streamingSocket) {
		super(services);
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