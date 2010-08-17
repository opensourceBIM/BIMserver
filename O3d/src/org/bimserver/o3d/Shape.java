package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Shape extends SceneJsonObject {

	public Shape(int id, String name) throws JSONException {
		super(id);
		JSONObject properties = new JSONObject();
		put("properties", properties);
		properties.put("name", name);
		JSONArray elements = new JSONArray();
		properties.put("elements", elements);
	}

	public void setPrimitive(Primitive primitive) throws JSONException {
		getJSONObject("properties").getJSONArray("elements").put(createRef(primitive.getInt("id")));
	}
}