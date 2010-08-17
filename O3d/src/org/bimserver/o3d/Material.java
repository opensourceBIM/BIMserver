package org.bimserver.o3d;

import java.awt.Color;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Material extends SceneJsonObject {

	public Material(int id, String name, Color color) throws JSONException {
		this(id, name, color, 1.0f);
	}

	public Material(int id, String name, Color color, float opacity) throws JSONException {
		super(id);
		put("id", id);
		JSONObject properties = new JSONObject();
		properties.put("name", name);
		put("properties", properties);
		float r = color.getRed() / 255f;
		float g = color.getGreen() / 255f;
		float b = color.getBlue() / 255f;
		JSONObject params = new JSONObject();
		put("params", params);
		JSONObject ligtingType = new JSONObject();
		ligtingType.put("class", "o3d.ParamString");
		ligtingType.put("value", "lambert");
		params.put("collada.lightingType", ligtingType);
		params.put("diffuse", createClassFromFloat("o3d.ParamFloat4", r, g, b, 1));
//		params.put("ambient", createClass("o3d.ParamFloat4", 0, 0, 0, 1));
		if (opacity < 1.0) {
			params.put("emissive", createClassFromFloat("o3d.ParamFloat4", opacity, opacity, opacity, 0));
		}
//		JSONObject shininess = new JSONObject();
//		params.put("shininess", shininess);
//		shininess.put("class", "o3d.ParamFloat");
//		shininess.put("value", 20);
//		params.put("specular", createClass("o3d.ParamFloat4", 0, 0, 0, 1));
//		JSONObject specularFactor = new JSONObject();
//		params.put("specularFactor", specularFactor);
//		specularFactor.put("class", "o3d.ParamFloat");
//		specularFactor.put("value", 1);
	}
}