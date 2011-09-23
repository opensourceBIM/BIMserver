package org.bimserver.o3d;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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