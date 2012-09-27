package org.bimserver.tests;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TestJson {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("test", "235031605553397778");
			System.out.println(jsonObject.getLong("test"));
			System.out.println(Long.parseLong(jsonObject.getString("test")));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
