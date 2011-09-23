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

public class VertexBuffer extends SceneJsonObject {

	private JSONArray fieldData;

	public VertexBuffer(int id, int fieldId1, int fieldId2) throws JSONException {
		super(id);
		JSONObject indexProperties = new JSONObject();
		put("properties", indexProperties);
		indexProperties.put("name", "vertexbuffer");
		JSONObject custom = new JSONObject();
		put("custom", custom);
//		JSONArray fields = new JSONArray();
		fieldData = new JSONArray();
		custom.put("fieldData", fieldData);
//		JSONArray binaryRange = new JSONArray();
//		custom.put("fields", fields);
//		custom.put("binaryRange", binaryRange);
//		fields.put(fieldId1);
//		fields.put(fieldId2);
	}
	
	public void addFieldData(FieldData fieldData) {
		this.fieldData.put(fieldData);
	}

//	public void setBinaryRange(int start, int end) throws JSONException {
//		getJSONObject("custom").getJSONArray("binaryRange").put(start);
//		getJSONObject("custom").getJSONArray("binaryRange").put(end);
//	}
}