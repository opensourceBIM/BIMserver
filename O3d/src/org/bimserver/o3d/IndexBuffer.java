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

public class IndexBuffer extends SceneJsonObject {

	public IndexBuffer(int id, int fieldId) throws JSONException {
		super(id);
		JSONObject indexProperties = new JSONObject();
		put("properties", indexProperties);
		JSONObject custom = new JSONObject();
		put("custom", custom);
//		JSONArray fields = new JSONArray();
//		JSONArray binaryRange = new JSONArray();
//		custom.put("fields", fields);
//		custom.put("binaryRange", binaryRange);
		custom.put("fieldData", new JSONArray());
//		fields.put(fieldId);
	}
	
	public void addFieldData(FieldData fieldData) throws JSONException {
		getJSONObject("custom").getJSONArray("fieldData").put(fieldData);
	}
	
//	public void setBinaryRange(int from, int to) throws JSONException {
//		getJSONObject("custom").getJSONArray("binaryRange").put(from);
//		getJSONObject("custom").getJSONArray("binaryRange").put(to);
//	}
}