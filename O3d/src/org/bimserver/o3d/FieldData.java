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
