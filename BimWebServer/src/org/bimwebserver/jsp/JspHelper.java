package org.bimwebserver.jsp;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SObjectState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SRevisionSummaryContainer;
import org.bimserver.interfaces.objects.SRevisionSummaryType;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.comparators.SProjectNameComparator;
import org.bimserver.shared.comparators.SRevisionIdComparator;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JspHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(JspHelper.class);

	public static String generateBreadCrumbPath(SRevision revision, ServiceInterface serviceWrapper) throws ServiceException {
		String projectPath = generateBreadCrumbPath(serviceWrapper.getProjectByPoid(revision.getProjectId()), serviceWrapper);
		return projectPath + " <a href=\"revision.jsp?roid=" + revision.getOid() + "\">" + revision.getId() + "</a>";
	}

	public static String generateBreadCrumbPath(SProject project, ServiceInterface serviceWrapper) throws ServiceException {
		String path = "";
		while (project != null) {
			path = "<a id=\"usernav-home\" href=\"project.jsp?poid=" + project.getOid() + "\">" + project.getName() + "</a> " + path;
			if (project.getParentId() != -1) {
				project = serviceWrapper.getProjectByPoid(project.getParentId());
			} else {
				project = null;
			}
		}
		return path;
	}

	public static String writeProjectTree(SProject project, LoginManager loginManager, int level, boolean includeHeaders) throws ServiceException {
		StringBuilder result = new StringBuilder();
		SRevision lastRevision = null;
		if (project.getLastRevisionId() != -1) {
			lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
		}
		if (includeHeaders) {
			result.append("<tr class=\"" + (project.getState() == SObjectState.DELETED ? "deleted" : "") + "\">");
			result.append("<th>Name</th>");
			result.append("<th>Last revision</th>");
			result.append("<th>Revisions</th>");
			result.append("<th>Checkouts</th>");
			result.append("<th>Authorized users</th>");
			result.append("<th>Actions</th>");
			result.append("</tr>");
		}
		result.append("<tr class=\"" + (loginManager.getService().userHasCheckinRights(loginManager.getService().getCurrentUser().getOid(), project.getOid()) ? "" : "checkinrights")
				+ (project.getState() == SObjectState.DELETED ? " deleted" : "") + "\">");
		result.append("<td>");
		for (int i = 0; i < level; i++) {
			result.append("&nbsp;&nbsp;");
		}
		if (level != 0) {
			result.append("<img src=\"images/subproject.gif\" alt=\"|->\" />");
		}
		result.append("<a href=\"project.jsp?poid=" + project.getOid() + "\">");
		result.append(project.getName());
		result.append("</a></td>");
		result.append("<td>"
				+ (lastRevision == null ? "No revisions"
						: ("<a href=\"revision.jsp?roid=" + lastRevision.getOid() + "\">" + lastRevision.getId() + "</a> by <a href=\"user.jsp?uoid=" + lastRevision.getUserId()
								+ "\">" + loginManager.getService().getUserByUoid(lastRevision.getUserId()).getUsername() + "</a>")) + "</td>");
		result.append("<td>" + project.getRevisions().size() + "</td>");
		result.append("<td>" + project.getCheckouts().size() + "</td>");
		result.append("<td>" + project.getHasAuthorizedUsers().size() + "</td>");
		if (project.getState() == SObjectState.ACTIVE) {
			result.append("<td><a href=\"deleteproject.jsp?poid=" + project.getOid() + "\">delete</a></td>");
		} else {
			result.append("<td><a href=\"undeleteproject.jsp?poid=" + project.getOid() + "\">undelete</a></td>");
		}
		result.append("</tr>");
		Set<SProject> subProjects = new TreeSet<SProject>(new SProjectNameComparator());
		for (long subPoid : project.getSubProjects()) {
			try {
				SProject subProject = loginManager.getService().getProjectByPoid(subPoid);
				subProjects.add(subProject);
			} catch (UserException e) {
			}
		}
		for (SProject subProject : subProjects) {
			if (loginManager.getService().userHasRights(subProject.getOid())
					&& (loginManager.getService().getProjectByPoid(subProject.getOid()).getState() != SObjectState.DELETED) || loginManager.getUserType() == SUserType.ADMIN) {
				result.append(writeProjectTree(subProject, loginManager, level + 1, false));
			}
		}
		if (includeHeaders) {
			result.append("<tr class=\"separator " + (project.getState() == SObjectState.DELETED ? "deleted" : "") + "\"><td colspan=\"6\" class=\"seperator\"></td></tr>");
		}
		return result.toString();
	}

	public static String writeDownloadProjectTreeJavaScript(SProject project, LoginManager loginManager) throws ServiceException {
		StringBuilder result = new StringBuilder();
		result.append("projects.project" + project.getId() + " = new Object();\n");
		result.append("projects.project" + project.getId() + ".id = " + project.getId() + ";\n");
		result.append("projects.project" + project.getId() + ".name = \"" + project.getName() + "\";\n");
		result.append("projects.project" + project.getId() + ".subprojects = new Array();\n");
		int i = 0;
		for (long subProjectPoid : project.getSubProjects()) {
			SProject subProject = loginManager.getService().getProjectByPoid(subProjectPoid);
			result.append(writeDownloadProjectTreeJavaScript(subProject, loginManager));
			result.append("projects.project" + project.getId() + ".subprojects[" + (i++) + "] = projects.project" + subProject.getId() + ";\n");
			result.append("projects.project" + subProject.getId() + ".superproject = projects.project" + project.getId() + ";\n");
		}
		return result.toString();
	}

	public static String writeDownloadProjectTree(String baseName, SProject project, LoginManager loginManager, int level, Set<Long> revisions) throws ServiceException {
		StringBuilder result = new StringBuilder();
		SRevision lastRevision = null;
		if (project.getLastRevisionId() != -1) {
			lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
		}
		result.append("<tr" + (project.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "") + ">");
		result.append("<td>");
		for (int i = 0; i < level; i++) {
			result.append("&nbsp;&nbsp;");
		}
		if (level != 0) {
			result.append("<img src=\"images/subproject.gif\" alt=\"|->\" />");
		}
		result.append("<a href=\"project.jsp?poid=" + project.getOid() + "\">");
		result.append(project.getName());
		result.append("</a></td>");
		result.append("<td>"
				+ (lastRevision == null ? "No revisions"
						: ("<a href=\"revision.jsp?roid=" + lastRevision.getOid() + "\">" + lastRevision.getId() + "</a> by <a href=\"user.jsp?uoid=" + lastRevision.getUserId()
								+ "\">" + loginManager.getService().getUserByUoid(lastRevision.getUserId()).getUsername() + "</a>")) + "</td>");
		result.append("<td><select class=\"treeselect\" name=\"" + baseName + "_" + project.getId() + "\" id=\"" + baseName + "_" + project.getId() + "\">");
		List<SRevision> allRevisionsOfProject = loginManager.getService().getAllRevisionsOfProject(project.getOid());
		Collections.sort(allRevisionsOfProject, new SRevisionIdComparator(false));
		boolean selectedSomething = false;
		for (SRevision revision : allRevisionsOfProject) {
			boolean selected = false;
			if (revisions != null) {
				if (revisions.contains(revision.getOid())) {
					selected = true;
				}
			} else {
				selected = ((project.getParentId() == -1 || level == 0) && allRevisionsOfProject.get(0) == revision);
			}
			if (selected) {
				selectedSomething = true;
			}
			result.append("<option value=\"" + revision.getOid() + "\"" + (selected ? " SELECTED=\"SELECTED\"" : "") + ">" + revision.getId() + "</option>");
		}
		result.append("<option value=\"[off]\"" + (selectedSomething ? "" : " SELECTED=\"SELECTED\"") + ">Off</option>");
		result.append("</select></td>");
		result.append("</tr>");
		Set<SProject> subProjects = new TreeSet<SProject>(new SProjectNameComparator());
		for (long subPoid : project.getSubProjects()) {
			SProject subProject = loginManager.getService().getProjectByPoid(subPoid);
			subProjects.add(subProject);
		}
		for (SProject subProject : subProjects) {
			if (subProject.getRevisions().size() > 0) {
				result.append(writeDownloadProjectTree(baseName, subProject, loginManager, level + 1, revisions));
			}
		}
		return result.toString();
	}

	public static String writeSummaryTable(SProject project, long roid, SRevisionSummary revisionSummary, HttpServletRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append("<table class=\"formatted\">");
		builder.append("<tr><th>Entity</th><th>Query</th><th>Amount</th></tr>");
		List<SRevisionSummaryContainer> list = revisionSummary.getList();
		for (SRevisionSummaryContainer container : list) {
			builder.append("<tr><td colspan=\"3\" class=\"summarygroup\">" + container.getName() + "</td></tr>");
			for (SRevisionSummaryType type : container.getTypes()) {
				builder.append("<tr><td><span class=\"summaryitem\"><a class=\"browserlink\" href=\"#\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&className="
						+ type.getName() + "\">" + type.getName() + "</a></span></td><td><a href=\"#\" class=\"querylink\" cName=\"" + type.getName() + "\">query</a></td><td>" + type.getCount()
						+ "</td></tr>");
			}
		}
		builder.append("</table>");
		return builder.toString();
	}

	public static String completeProjectName(ServiceInterface service, SProject sProject) {
		if (sProject.getParentId() != -1) {
			try {
				return completeProjectName(service, service.getProjectByPoid(sProject.getParentId())) + "." + sProject.getName();
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}
		}
		return sProject.getName();
	}

	public static String getNiceUserTypeName(SUserType userType) {
		switch (userType) {
		case ADMIN:
			return "Admin";
		case USER:
			return "User";
		case SYSTEM:
			return "System";
		case READ_ONLY:
			return "ReadOnly";
		}
		return "unknown";
	}

	public static String getNiceAccessMethodName(SAccessMethod accessMethod) {
		switch (accessMethod) {
		case INTERNAL:
			return "Internal";
		case REST:
			return "Rest";
		case SOAP:
			return "Soap";
		case WEB_INTERFACE:
			return "Web interface";
		case SYNDICATION:
			return "Syndication";
		case PROTOCOL_BUFFERS:
			return "Protocol Buffers";
		case JSON:
			return "JSON";
		}
		return "unknown";
	}

	public static String showProjectTree(SProject activeProject, ServiceInterface serviceInterface) throws ServiceException {
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class=\"projectTreeFirst\">");
		SProject mainProject = activeProject;
		while (mainProject.getParentId() != -1) {
			mainProject = serviceInterface.getProjectByPoid(mainProject.getParentId());
		}
		showProjectTree(sb, mainProject, activeProject, serviceInterface, false);
		sb.append("</ul>");
		return sb.toString();
	}

	private static void showProjectTree(StringBuilder sb, SProject mainProject, SProject activeProject, ServiceInterface serviceInterface, boolean isLast) throws ServiceException {
		sb.append("<li" + (isLast ? " class=\"last\"" : "") + ">");
		boolean hasRights = serviceInterface.userHasCheckinRights(serviceInterface.getCurrentUser().getOid(), mainProject.getOid());
		sb.append("<a class=\"projectTreeItem" + (activeProject.getOid() == mainProject.getOid() ? " activeTreeItem" : "") + (hasRights ? "" : " norightsTreeItem")
				+ "\" href=\"project.jsp?poid=" + mainProject.getOid() + "\"/>" + mainProject.getName() + "</a>");
		List<SProject> subProjects = serviceInterface.getSubProjects(mainProject.getOid());
		Collections.sort(subProjects, new SProjectNameComparator());
		if (!subProjects.isEmpty()) {
			sb.append("<ul class=\"projectTree\">");
			for (SProject subProject : subProjects) {
				showProjectTree(sb, subProject, activeProject, serviceInterface, subProject == subProjects.get(subProjects.size() - 1));
			}
			sb.append("</ul>");
		}
		sb.append("</li>");
	}
	
	public static void showException(JspWriter out, ServiceException e) throws IOException {
		out.println("<div class=\"error\">" + e.getUserMessage() + " <a class=\"errorLink\" href=\"#\">Show origin</a>");
		out.println("<div class=\"errorBody\" style=\"display: none\">");
		for (StackTraceElement element : e.getStackTrace()) {
			out.print(element + "<br/>");
		}
		out.println("</div></div>");
	}
}