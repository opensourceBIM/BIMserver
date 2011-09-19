package org.bimserver.webservices;

import java.util.List;

import org.bimserver.interfaces.objects.SCompareContainer;
import org.bimserver.interfaces.objects.SCompareItem;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SObjectAdded;
import org.bimserver.interfaces.objects.SObjectModified;
import org.bimserver.interfaces.objects.SObjectRemoved;
import org.bimserver.interfaces.objects.SProject;

public class CompareWriter {
	public static String writeCompareResult(SCompareResult compareResult, int rid1, int rid2, SCompareType sCompareType, SProject project, boolean webPage) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>Building Model Comparator</h1>");
		builder.append("Compare results for revisions '" + rid1 + "' and '" + rid2 + "' of project '" + project.getName() + "'<br/>");
		builder.append("Total number of differences: " + compareResult.getItems().size() + "<br/>");
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
					builder.append("<option selected=\"selected\" value=\"" + cr.name() + "\">" + cr.name() + "</option>");
				} else {
					builder.append("<option value=\"" + cr.name() + "\">" + cr.name() + "</option>");
				}
			}
			builder.append("</select>");
			builder.append("</th>");
			builder.append("</tr>");
		}

		List<SCompareContainer> items = compareResult.getItems();
		for (SCompareContainer container : items) {
			for (SCompareItem item : container.getItems()) {
				String name = "";
				String guid = "";
				if (item.getDataObject().getGuid() != null) {
					guid = item.getDataObject().getGuid();
				}
				if (item.getDataObject().getName() != null) {
					name = item.getDataObject().getName();
				}
				builder.append("<tr>");
				if (item instanceof SObjectAdded) {
					builder.append("<td>" + container.getType() + "</td>");
					builder.append("<td>" + guid + "</td>");
					builder.append("<td>" + name + "</td>");
					builder.append("<td>Added</td>");
				} else if (item instanceof SObjectRemoved) {
					builder.append("<td>" + container.getType() + "</td>");
					builder.append("<td>" + guid + "</td>");
					builder.append("<td>" + name + "</td>");
					builder.append("<td>Deleted</td>");
				} else if (item instanceof SObjectModified) {
					SObjectModified objectModified = (SObjectModified) item;
					builder.append("<td>" + container.getType() + "</td>");
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