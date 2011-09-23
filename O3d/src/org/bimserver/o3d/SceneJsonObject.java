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