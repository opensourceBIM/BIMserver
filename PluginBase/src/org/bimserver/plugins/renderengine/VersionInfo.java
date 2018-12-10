package org.bimserver.plugins.renderengine;

import java.util.GregorianCalendar;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class VersionInfo {
	private String branch;
	private String commitsha;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private GregorianCalendar datetime;
	
	public VersionInfo(String branch, String commitsha, GregorianCalendar datetime) {
		this.branch = branch;
		this.commitsha = commitsha;
		this.datetime = datetime;
	}

	public JsonNode toJson() {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		result.put("branch", branch);
		result.put("commitsha", commitsha);
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
}