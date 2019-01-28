package org.bimserver.validationreport;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode header = OBJECT_MAPPER.createObjectNode();
		header.put("type", "header");
		header.put("text", text);
		return header;
	}

	@Override
	public Type getType() {
		return null;
	}
}