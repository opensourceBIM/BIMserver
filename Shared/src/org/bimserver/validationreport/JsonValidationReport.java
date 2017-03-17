package org.bimserver.validationreport;

import org.bimserver.emf.IdEObject;
import org.bimserver.models.ifc2x3tc1.IfcProduct;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Charsets;

public class JsonValidationReport implements IssueContainerSerializer {

	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public JsonValidationReport() {
	}

	public ObjectNode toJson(IssueContainer issueContainer) {
		ObjectNode result = OBJECT_MAPPER.createObjectNode();
		ArrayNode itemsJson = OBJECT_MAPPER.createArrayNode();
		result.set("items", itemsJson);
		for (Issue issue : issueContainer.list()) {
			ObjectNode jsonIssue = OBJECT_MAPPER.createObjectNode();
			if (issue.getMessage() != null) {
				jsonIssue.put("message", issue.getMessage());
			}
			if (issue.getIs() != null) {
				jsonIssue.put("is", issue.getIs().toString());
			}
			if (issue.getShouldBe() != null) {
				jsonIssue.put("shouldBe", issue.getShouldBe().toString());
			}
			if (issue.getType() != null) {
				jsonIssue.put("type", issue.getType().name());
			}
			if (issue.getIfcBuildingStorey() != null) {
				jsonIssue.set("ifcBuildingStorey", objectToJson(issue.getIfcBuildingStorey()));
			}
			if (issue.getObject() != null) {
				jsonIssue.set("object", objectToJson(issue.getObject()));
			}
			itemsJson.add(jsonIssue);
		}
		return result;
	}
	
	private ObjectNode objectToJson(IdEObject idEObject) {
		ObjectNode objectNode = OBJECT_MAPPER.createObjectNode();
		if (idEObject.getOid() != -1) {
			objectNode.put("oid", idEObject.getOid());
		}
		if (idEObject instanceof IfcProduct) {
			IfcProduct ifcProduct = (IfcProduct)idEObject;
			if (ifcProduct.getName() != null) {
				objectNode.put("name", ifcProduct.getName());
			}
			if (ifcProduct.getGlobalId() != null) {
				objectNode.put("guid", ifcProduct.getGlobalId());
			}
		}
		return objectNode;
	}
	
	@Override
	public byte[] getBytes(IssueContainer issueContainer) {
		return toJson(issueContainer).toString().getBytes(Charsets.UTF_8);
	}
}