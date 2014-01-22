package org.bimserver.validationreport;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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