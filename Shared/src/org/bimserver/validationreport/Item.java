package org.bimserver.validationreport;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public abstract class Item {

	public abstract void toHtml(StringBuilder sb);
	public abstract JSONObject toJson() throws JSONException;
}
