package org.bimserver.o3d;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class FieldData extends SceneJsonObject {
	private JSONArray data;

	public FieldData(int id, String type, int numComponents) throws JSONException {
		super(id);
		data = new JSONArray();
		put("type", type);
		put("numComponents", numComponents);
		put("data", data);
	}
	
	public void addData(float value) throws JSONException {
		data.put(value);
	}

	public void addDataFloats(List<Float> vertices) throws JSONException {
		for (float f : vertices) {
			data.put(f);
		}
	}

	public void addDataIntegers(int offset, List<Integer> list) throws JSONException {
		for (Integer val : list) {
			data.put(offset + val);
		}
	}

	public int getSize() {
		return data.length();
	}
}
