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

public class JsonFactory {
	int counter = 2;
	
	public IndexBuffer createIndexBuffer(int fieldId) throws JSONException {
		return new IndexBuffer(incCounter(), fieldId);
	}
	
	public VertexBuffer createVertexBuffer(int fieldId1, int fieldId2) throws JSONException {
		return new VertexBuffer(incCounter(), fieldId1, fieldId2);
	}

	public int incCounter() {
		return counter++;
	}

	public StreamBank createStreamBank() throws JSONException {
		return new StreamBank(incCounter());
	}

	public Primitive createPrimitive() throws JSONException {
		return new Primitive(incCounter());
	}

	public Shape createShape(String name) throws JSONException {
		return new Shape(incCounter(), name);
	}

	public Material createMaterial(String name, Color color) throws JSONException {
		return new Material(incCounter(), name, color);
	}

	public Transformation createTransformation(int parentId) throws JSONException {
		return new Transformation(incCounter(), parentId);
	}

	public Transformation createRootTransformation() throws JSONException {
		return new Transformation(incCounter(), 1);
	}

	public Stream createStream(int semantic, int fieldId, int startIndex) throws JSONException {
		return new Stream(incCounter(), semantic, fieldId, startIndex);
	}

	public Material createMaterial(String name, Color color, float opacity) throws JSONException {
		return new Material(incCounter(), name, color, opacity);
	}

	public FieldData createFieldData(int id, String type, int numComponents) throws JSONException {
		return new FieldData(id, type, numComponents);
	}
}