package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SceneJsonObject extends JSONObject {

	public SceneJsonObject(int id) throws JSONException {
		put("id", id);
	}
	
	protected JSONObject createRef(int id) throws JSONException {
		JSONObject object = new JSONObject();
		object.put("ref", id);
		return object;
	}

	protected JSONArray makeIntArray(int... numers) {
		JSONArray array = new JSONArray();
		for (int nr : numers) {
			array.put(nr);
		}
		return array;
	}
	
	protected JSONArray makeFloatArray(float... floats) throws JSONException {
		JSONArray array = new JSONArray();
		for (float f : floats) {
			array.put(f);
		}
		return array;
	}

	protected JSONObject createClass(String type, int... values) throws JSONException {
		JSONObject ambient = new JSONObject();
		ambient.put("class", type);
		JSONArray ambientValues = new JSONArray();
		for (int i : values) {
			ambientValues.put(i);
		}
		ambient.put("value", ambientValues);
		return ambient;
	}
	
	protected JSONObject createClassFromFloat(String type, float... values) throws JSONException {
		JSONObject ambient = new JSONObject();
		ambient.put("class", type);
		JSONArray ambientValues = new JSONArray();
		for (float i : values) {
			ambientValues.put(i);
		}
		ambient.put("value", ambientValues);
		return ambient;
	}
	
	public int getId() throws JSONException {
		return getInt("id");
	}
}