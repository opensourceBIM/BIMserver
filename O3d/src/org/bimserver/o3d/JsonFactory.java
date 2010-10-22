package org.bimserver.o3d;

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