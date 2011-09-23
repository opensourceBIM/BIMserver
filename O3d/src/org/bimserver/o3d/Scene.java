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

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Scene extends JSONObject {
	private JSONArray shapes;
	private JSONArray transformations;
	private JSONArray indexBuffers;
	private JSONArray primitives;
	private JSONArray streamBanks;
	private JSONArray vertexBuffers;
	private JSONArray materials;
	private final List<Integer> indices = new ArrayList<Integer>();
	private final List<Float> vertices = new ArrayList<Float>();

	public Scene() throws JSONException {
		put("version", 6);
		put("o3d_rootObject_root", 1);
		JSONObject objects = new JSONObject();
		put("objects", objects);
		objects.put("o3d.Material", materials);
		shapes = new JSONArray();
		objects.put("o3d.Shape", shapes);
		transformations = new JSONArray();
		objects.put("o3d.Transform", transformations);
		indexBuffers = new JSONArray();
		objects.put("o3d.IndexBuffer", indexBuffers);
		primitives = new JSONArray();
		objects.put("o3d.Primitive", primitives);
		streamBanks = new JSONArray();
		objects.put("o3d.StreamBank", streamBanks);
		vertexBuffers = new JSONArray();
		objects.put("o3d.VertexBuffer", vertexBuffers);
		materials = new JSONArray();
		objects.put("o3d.Material", materials);
		put("objects", objects);
	}
	
	public List<Integer> getIndices() {
		return indices;
	}
	
	public List<Float> getVertices() {
		return vertices;
	}

	public void addStreamBank(StreamBank streamBank) {
		streamBanks.put(streamBank);
	}

	public void addMaterial(Material material) {
		materials.put(material);
	}

	public void addTransformation(Transformation transformation) {
		transformations.put(transformation);
	}

	public void addShape(Shape shape) {
		shapes.put(shape);
	}

	public void addPrimitive(Primitive primitive) {
		primitives.put(primitive);
	}

	public void addIndexBuffer(IndexBuffer indexBuffer) {
		indexBuffers.put(indexBuffer);
	}

	public void addVertexBuffer(VertexBuffer vertexBuffer) {
		vertexBuffers.put(vertexBuffer);
	}

	public void addIndex(int index) {
		indices.add(index);
	}

	public void addVertex(float vertex) {
		vertices.add(vertex);
	}
}
