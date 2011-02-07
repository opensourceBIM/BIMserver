package org.bimserver.o3d;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Transformation extends SceneJsonObject {
	public Transformation(int id, int parentId) throws JSONException {
		super(id);
		JSONObject properties = new JSONObject();
		properties.put("name", "untitled");
		JSONArray shapes = new JSONArray();
		properties.put("shapes", shapes);
		properties.put("parent", createRef(parentId));
		put("properties", properties);
		JSONObject params = new JSONObject();
		JSONObject boundingBox = new JSONObject();
		boundingBox.put("value", new JSONArray());
		params.put("o3d.boundingBox", boundingBox);
		JSONObject cull = new JSONObject();
		cull.put("value", false);
		params.put("o3d.cull", cull);
		JSONObject matrix = new JSONObject();
		JSONArray matrixArray = new JSONArray();
		matrixArray.put(makeIntArray(1, 0, 0, 0));
		matrixArray.put(makeIntArray(0, 1, 0, 0));
		matrixArray.put(makeIntArray(0, 0, 1, 0));
		matrixArray.put(makeIntArray(0, 0, 0, 1));
		matrix.put("value", matrixArray);
		params.put("o3d.localMatrix", matrix);
		JSONObject visible = new JSONObject();
		visible.put("value", true);
		params.put("o3d.visible", visible);
		put("params", params);
	}

	public void addShape(Shape shape) throws JSONException {
		getJSONObject("properties").getJSONArray("shapes").put(createRef(shape.getId()));
	}
}