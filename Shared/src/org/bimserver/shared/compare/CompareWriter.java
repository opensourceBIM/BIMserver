package org.bimserver.shared.compare;

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
	private static String formatCompareType(SCompareType sCompareType) {
		if (sCompareType == SCompareType.ADD) {
			return "Added";
		} else if (sCompareType == SCompareType.ALL) {
			return "All";
		} else if (sCompareType == SCompareType.DELETE) {
			return "Deleted";
		} else if (sCompareType == SCompareType.MODIFY) {
			return "Modified";
		}
		return sCompareType.name();
	}
	
	public static String writeCompareResult(SCompareResult compareResult, int rid1, int rid2, SCompareType sCompareType, SProject project, boolean webPage) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>Building Model Comparator</h1>");
		builder.append("Compare results for revisions '" + rid1 + "' and '" + rid2 + "' of project '" + project.getName() + "'<br/>");
		int total = 0;
		for (SCompareContainer sCompareContainer : compareResult.getItems()) {
			total += sCompareContainer.getItems().size();
		}
		builder.append("Total number of differences: " + total + "<br/>");
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
					builder.append("<option selected=\"selected\" value=\"" + cr.name() + "\">" + formatCompareType(cr) + "</option>");
				} else {
					builder.append("<option value=\"" + cr.name() + "\">" + formatCompareType(cr) + "</option>");
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