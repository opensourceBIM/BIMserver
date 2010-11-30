package org.bimserver.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SObjectState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.SCompareResult;
import org.bimserver.shared.SProjectNameComparator;
import org.bimserver.shared.SRevisionSummary;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.UserException;
import org.bimserver.shared.SCompareResult.SCompareType;
import org.bimserver.shared.SCompareResult.SObjectModified;

public class JspHelper {
	public static String generateBreadCrumbPath(SRevision revision, ServiceInterface serviceWrapper) throws UserException {
		String projectPath = generateBreadCrumbPath(serviceWrapper.getProjectByPoid(revision.getProjectId()), serviceWrapper);
		return projectPath + " <a href=\"revision.jsp?roid=" + revision.getOid() + "\">" + revision.getId() + "</a>";
	}

	public static String generateBreadCrumbPath(SProject project, ServiceInterface serviceWrapper) throws UserException {
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

	public static String writeProjectTree(SProject project, LoginManager loginManager, int level) throws UserException {
		StringBuilder result = new StringBuilder();
		SRevision lastRevision = null;
		if (project.getLastRevisionId() != -1) {
			lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
		}
		result.append("<tr" + (loginManager.getService().userHasCheckinRights(project.getOid()) ? "" : " class=\"checkinrights\"")
				+ (project.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "") + ">");
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
			SProject subProject = loginManager.getService().getProjectByPoid(subPoid);
			subProjects.add(subProject);
		}
		for (SProject subProject : subProjects) {
			if (loginManager.getService().userHasRights(subProject.getOid()) && (loginManager.getService().getProjectByPoid(subProject.getOid()).getState() != SObjectState.DELETED)
					|| loginManager.getUserType() == SUserType.ADMIN) {
				result.append(writeProjectTree(subProject, loginManager, level + 1));
			}
		}
		return result.toString();
	}

	public static String writeDownloadProjectTreeJavaScript(SProject project, LoginManager loginManager) throws UserException {
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

	public static String writeDownloadProjectTree(String baseName, SProject project, LoginManager loginManager, int level, Set<Long> revisions) throws UserException {
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
		result.append("<option value=\"[off]\">Off</option>");
		List<SRevision> allRevisionsOfProject = loginManager.getService().getAllRevisionsOfProject(project.getOid());
		Collections.sort(allRevisionsOfProject, new Comparator<SRevision>() {
			@Override
			public int compare(SRevision o1, SRevision o2) {
				return o1.getId() - o2.getId();
			}
		});
		for (SRevision revision : allRevisionsOfProject) {
			boolean selected = false;
			if (revisions != null) {
				if (revisions.contains(revision.getOid())) {
					selected = true;
				}
			} else {
				selected = ((project.getParentId() == -1 || level == 0) && allRevisionsOfProject.get(allRevisionsOfProject.size() - 1) == revision);
			}
			result.append("<option value=\"" + revision.getOid() + "\"" + (selected ? " SELECTED=\"SELECTED\"" : "") + ">" + revision.getId() + "</option>");
		}
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
		Map<String, Map<String, Integer>> map = revisionSummary.getMap();
		for (String group : map.keySet()) {
			builder.append("<tr><td colspan=\"3\" class=\"summarygroup\">" + group + "</td></tr>");
			Map<String, Integer> subMap = map.get(group);
			for (String className : subMap.keySet()) {
				Integer amount = subMap.get(className);
				builder.append("<tr><td><span class=\"summaryitem\"><a class=\"browserlink\" href=\"#\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&className="
						+ className + "\">" + className + "</a></span></td><td><a href=\"#\" class=\"querylink\" cName=\"" + className + "\">query</a></td><td>" + amount
						+ "</td></tr>");
			}
		}
		builder.append("</table>");
		return builder.toString();
	}

	public static String writeCompareResult(SCompareResult compareResult, long roid1, long roid2, SCompareType sCompareType, SProject project) {
		StringBuilder builder = new StringBuilder();
		builder.append("<h1>Building Model Comparator</h1>");
		builder.append("Compare results for revisions '" + roid1 + "' and '" + roid2 + "' of project '" + project.getName() + "'<br/>");
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
		
		builder.append("<tr>");
		builder.append("<th style=\"padding: 5px\"></th>");
		builder.append("<th style=\"padding: 5px\"></th>");
		builder.append("<th style=\"padding: 5px\"></th>");
		builder.append("<th style=\"padding: 5px\"><select id=\"typeselector\" name=\"type\">");
		for (SCompareType cr : SCompareType.values()) {
			if (cr == sCompareType) {
				builder.append("<option selected=\"selected\" value=\"" + cr.name() + "\">" + cr.getNiceName() + "</option>");
			} else {
				builder.append("<option value=\"" + cr.name() + "\">" + cr.getNiceName() + "</option>");
			}
		}
		builder.append("</select></th>");
		builder.append("</tr>");

		Map<String, List<SCompareResult.SItem>> items = compareResult.getItems();
		for (String eClass : items.keySet()) {
			for (SCompareResult.SItem item : items.get(eClass)) {
				String name = "";
				String guid = "";
				if (item.dataObject.getGuid() != null) {
					guid = item.dataObject.getGuid();
				} else if (item.dataObject.getName() != null) {
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
					SObjectModified objectModified = (SObjectModified)item;
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

	public static String completeProjectName(ServiceInterface service, SProject sProject) throws UserException {
		if (sProject.getParentId() != -1) {
			return completeProjectName(service, service.getProjectByPoid(sProject.getParentId())) + "." + sProject.getName();
		}
		return sProject.getName();
	}

	public static String getNiceUserTypeName(SUserType userType) {
		switch (userType) {
		case ADMIN:
			return "Admin";
		case ANONYMOUS:
			return "Anonymous";
		case USER:
			return "User";
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
		}
		return "unknown";
	}
}