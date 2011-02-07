package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Primitive extends SceneJsonObject {
	private JSONObject properties;
	private JSONObject material;
	private JSONObject streamBank;
	private JSONObject custom;

	public Primitive(int id) throws JSONException {
		super(id);
		properties = new JSONObject();
		put("properties", properties);
		properties.put("name", "test");
		properties.put("primitiveType", 4);
		JSONObject params = new JSONObject();
		put("params", params);
		streamBank = new JSONObject();
		params.put("o3d.streamBank", streamBank);
		material = new JSONObject();
		params.put("o3d.material", material);
		custom = new JSONObject();
		put("custom", custom);
		JSONObject boundingBox = new JSONObject();
		params.put("o3d.boundingBox", boundingBox);
		boundingBox.put("value", new JSONArray());
//		JSONObject cull = new JSONObject();
//		cull.put("value", false);
//		JSONObject priority = new JSONObject();
//		priority.put("value", 0);
//		params.put("o3d.priority", priority);
//		params.put("o3d.cull", cull);
//		JSONObject zSortPoint = new JSONObject();
//		params.put("o3d.zSortPoint", zSortPoint);
//		JSONArray value = new JSONArray();
//		value.put(0);
//		value.put(0);
//		value.put(0);
//		zSortPoint.put("value", value);
	}
	
	public void setNumberVertices(int nrVertices) throws JSONException {
		properties.put("numberVertices", nrVertices);
	}
	
	public void setNumberPrimitives(int nrPrimitives) throws JSONException {
		properties.put("numberPrimitives", nrPrimitives);
	}
	
	public void setStartIndex(int startIndex) throws JSONException {
		properties.put("startIndex", startIndex);
	}

	public void setOwner(SceneJsonObject shape) throws JSONException {
		properties.put("owner", createRef(shape.getId()));
	}

	public void setMaterial(Material material) throws JSONException {
		this.material.put("value", createRef(material.getId()));
	}

	public void setStreamBank(StreamBank streamBank) throws JSONException {
		this.streamBank.put("value", createRef(streamBank.getId()));
	}
	
	public void setIndexBuffer(IndexBuffer indexBuffer) throws JSONException {
		properties.put("indexBuffer", createRef(indexBuffer.getId()));
		custom.put("indexBuffer", indexBuffer.getId());
	}
}