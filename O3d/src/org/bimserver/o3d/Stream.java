package org.bimserver.o3d;


import org.codehaus.jettison.json.JSONException;

public class Stream extends SceneJsonObject {

	public Stream(int id, int semantic, int fieldId, int startIndex) throws JSONException {
		super(id);
		put("semantic", semantic);
		put("semanticIndex", 0);
		put("field", fieldId);
		put("startIndex", startIndex);
	}
}