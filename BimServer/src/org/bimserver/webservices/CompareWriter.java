package org.bimserver.webservices;

import java.util.List;
import java.util.Map;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.SCompareResult.SObjectModified;

public class CompareWriter {
	public static String writeCompareResult(SCompareResult compareResult, int rid1, int rid2, SCompareType sCompareType, SProject project, boolean webPage) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>Building Model Comparator</h1>");
		builder.append("Compare results for revisions '" + rid1 + "' and '" + rid2 + "' of project '" + project.getName() + "'<br/>");
		builder.append("Total number of differences: " + compareResult.size() + "<br/>");
		if (compareResult.getItems().size() == 0) {
			return builder.toString();
		}
		builder.append("<table class=\"formatted\">");
		builder.append("<tr>");
		builder.append("<th>Type</th>");
		builder.append("<th>Guid</th>");
		builder.append("<th>Name</th>");
		builder.append("<th>Difference</th>");
		builder.append("</tr>");

		if (webPage) {
			builder.append("<tr>");
			builder.append("<th style=\"padding: 5px\"></th>");
			builder.append("<th style=\"padding: 5px\"></th>");
			builder.append("<th style=\"padding: 5px\"></th>");
			builder.append("<th style=\"padding: 5px\">");
			builder.append("<select id=\"typeselector\" name=\"type\">");
			for (SCompareType cr : SCompareType.values()) {
				if (cr == sCompareType) {
					builder.append("<option selected=\"selected\" value=\"" + cr.name() + "\">" + cr.getNiceName() + "</option>");
				} else {
					builder.append("<option value=\"" + cr.name() + "\">" + cr.getNiceName() + "</option>");
				}
			}
			builder.append("</select>");
			builder.append("</th>");
			builder.append("</tr>");
		}

		Map<String, List<SCompareResult.SItem>> items = compareResult.getItems();
		for (String eClass : items.keySet()) {
			for (SCompareResult.SItem item : items.get(eClass)) {
				String name = "";
				String guid = "";
				if (item.dataObject.getGuid() != null) {
					guid = item.dataObject.getGuid();
				}
				if (item.dataObject.getName() != null) {
					name = item.dataObject.getName();
				}
				builder.append("<tr>");
				if (item instanceof SCompareResult.SObjectAdded) {
					builder.append("<td>" + eClass + "</td>");
					builder.append("<td>" + guid + "</td>");
					builder.append("<td>" + name + "</td>");
					builder.append("<td>Added</td>");
				} else if (item instanceof SCompareResult.SObjectRemoved) {
					builder.append("<td>" + eClass + "</td>");
					builder.append("<td>" + guid + "</td>");
					builder.append("<td>" + name + "</td>");
					builder.append("<td>Deleted</td>");
				} else if (item instanceof SCompareResult.SObjectModified) {
					SObjectModified objectModified = (SObjectModified) item;
					builder.append("<td>" + eClass + "</td>");
					builder.append("<td>" + guid + "</td>");
					builder.append("<td>" + name + "</td>");
					builder.append("<td>Modified " + objectModified.getFieldName() + " (" + objectModified.getOldValue() + " -> " + objectModified.getNewValue() + ")" + "</td>");
				}
				builder.append("</tr>");
			}
		}
		builder.append("</table>");
		return builder.toString();
	}
}
