package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StreamBank extends SceneJsonObject {

	private JSONArray vertexStreams;

	public StreamBank(int id) throws JSONException {
		super(id);
		JSONObject properties = new JSONObject();
		properties.put("name", "test");
		put("properties", properties);
		JSONObject custom = new JSONObject();
		put("custom", custom);
		vertexStreams = new JSONArray();
		custom.put("vertexStreams", vertexStreams);
	}

	public void addStream(Stream stream) throws JSONException {
		JSONObject streamObject = new JSONObject();
		streamObject.put("stream", stream);
		vertexStreams.put(streamObject);
	}
}