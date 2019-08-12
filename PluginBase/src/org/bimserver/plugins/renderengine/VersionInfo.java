package org.bimserver.plugins.renderengine;

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

import java.util.GregorianCalendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class VersionInfo {
	private String branch;
	private String commitsha;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private GregorianCalendar datetime;
	private String protocolVersion;
	private String platform;
	
	public VersionInfo(String branch, String commitsha, String protocolVersion, GregorianCalendar datetime, String platform) {
		this.branch = branch;
		this.commitsha = commitsha;
		this.protocolVersion = protocolVersion;
		this.datetime = datetime;
		this.platform = platform;
	}

	public JsonNode toJson() {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("branch", branch);
		result.put("commitsha", commitsha);
		result.put("datetime", datetime.getTimeInMillis());
		result.put("protocolVersion", protocolVersion);
		result.put("platform", platform);
		return result;
	}

	public String getBranch() {
		return branch;
	}
	
	public String getCommitsha() {
		return commitsha;
	}

	public GregorianCalendar getDateTime() {
		return datetime;
	}
	
	public String getProtocolVersion() {
		return protocolVersion;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}