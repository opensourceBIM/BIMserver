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