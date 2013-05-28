package org.bimserver.validationreport;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ValidationReport {

	private final List<Item> items = new ArrayList<Item>();

	public void addHeader(String value) {
		items.add(new Header(value));
	}

	public String toHtml(String header, String footer) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		for (Item item : items) {
			item.toHtml(sb);
		}
		sb.append(footer);
		return sb.toString();
	}
	
	public JSONObject toJson() throws JSONException {
		JSONObject result = new JSONObject();
		JSONArray itemsJson = new JSONArray();
		result.put("items", itemsJson);
		for (Item item : items) {
			itemsJson.put(item.toJson());
		}
		return result;
	}

	public void add(Type type, long oid, String key, String is, String shouldBe) {
		items.add(new Line(type, oid, key, is, shouldBe));
	}
}