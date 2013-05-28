package org.bimserver.validationreport;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Header extends Item {
	private String text;

	public Header(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public void toHtml(StringBuilder sb) {
		sb.append("<tr><td colspan=\"3\" class=\"header\">" + text + "</td></tr>\n");
	}

	@Override
	public JSONObject toJson() throws JSONException {
		JSONObject header = new JSONObject();
		header.put("type", "header");
		header.put("text", text);
		return header;
	}
}