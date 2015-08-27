package org.bimserver.shared.json;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class StreamingJsonConverter {

	public <T> T fromJson(JsonReader jsonReader, Class<T> cl) throws IOException {
		jsonReader.beginObject();
		
		jsonReader.endObject();
		return null;
	}
}
