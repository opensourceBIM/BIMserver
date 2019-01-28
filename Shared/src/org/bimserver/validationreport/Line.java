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

public class Line extends Item {
	private String fieldOrClass;
	private String value;
	private String shouldBe;
	private Type type;
	private long oid = -1;

	public Line(Type type, Long oid, String fieldOrClass, String value, String shouldBe) {
		this.type = type;
		if (oid == null) {
			this.oid = -1;
		} else {
			this.oid = oid;
		}
		this.fieldOrClass = fieldOrClass;
		this.value = value;
		this.shouldBe = shouldBe;
	}
	
	public void toHtml(StringBuilder sb) {
		sb.append("<tr>");
		sb.append("<td>");
		sb.append(fieldOrClass);
		sb.append("</td>");
		sb.append("<td class=\"" + type.name().toLowerCase() + "\">");
		sb.append(value);
		sb.append("</td>");
		sb.append("<td>");
		sb.append(shouldBe);
		sb.append("</td>");
		sb.append("</tr>\n");
	}

	@Override
	public ObjectNode toJson(ObjectMapper OBJECT_MAPPER) {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("type", "line");
		result.put("status", type.name());
		result.put("oid", oid);
		result.put("identification", fieldOrClass);
		result.put("value", value);
		result.put("shouldBe", shouldBe);
		return result;
	}
	
	public long getOid() {
		return oid;
	}
	
	public Type getType() {
		return type;
	}
}