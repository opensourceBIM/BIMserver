<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SListDataValue"%>
<%@page import="org.bimserver.interfaces.objects.SSimpleDataValue"%>
<%@page import="org.bimserver.interfaces.objects.SDataObject"%>
<%@page import="org.bimserver.interfaces.objects.SDataValue"%>
<%@page import="org.bimserver.interfaces.objects.SReferenceDataValue"%>
<%@page import="org.bimserver.interfaces.objects.SSimpleDataValue"%>
<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SRevisionSummary"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.shared.comparators.SRevisionIdComparator"%><div id="browser">
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	SRevision revision = loginManager.getService(request).getRevision(roid);
	SProject project = loginManager.getService(request).getProjectByPoid(revision.getProjectId());
	List<SRevision> revisionsInc = loginManager.getService(request).getAllRevisionsOfProject(revision.getProjectId());
	Collections.sort(revisionsInc, new SRevisionIdComparator(false));
%>
<a href="#" class="browserlink" browserUrl="<%=request.getRequestURI()%>?roid=<%=roid%>">Home</a><br/>
Revision <select name="roid" id="roidchanger">
<%
for (SRevision sRevision : revisionsInc) {
%>
	<option value="<%=sRevision.getOid() %>"<%=(sRevision.getOid() == roid ? " selected=\"selected\"" : "") %>><%=sRevision.getId() %></option>
<%
}
%>
</select>
<%
  		SDataObject dataObject = null;
		try {
	  		if (request.getParameter("oid") != null) {
	  			long oid = Long.parseLong(request.getParameter("oid"));
	  			String className = request.getParameter("className");
		  		dataObject = loginManager.getService(request).getDataObjectByOid(roid, oid);
	  			out.println("<br/><br/><h1>" + dataObject.getType() + "</h1>");
	  			out.println("<table>");
	  			for (SDataValue dataValue : dataObject.getValues()) {
	  				String fieldName = dataValue.getFieldName();
	  				if (dataValue instanceof SSimpleDataValue) {
	  					SSimpleDataValue simpleDataValue = (SSimpleDataValue)dataValue;
		  				out.println("<tr><td>" + fieldName + "</td><td>" + simpleDataValue.getStringValue() +"</td></tr>");
	  				} else if (dataValue instanceof SReferenceDataValue) {
	  					SReferenceDataValue referenceDataValue = (SReferenceDataValue)dataValue;
		  				out.println("<tr><td>" + fieldName + "</td><td><a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + referenceDataValue.getOid() + "&className=" + referenceDataValue.getTypeName() + "\">" + referenceDataValue.getTypeName() +"</a></td></tr>");
	  				} else if (dataValue instanceof SListDataValue) {
	  					SListDataValue listDataValue = (SListDataValue)dataValue;
	  					out.println("<tr><td>" + fieldName + "</td><td>");
	  					for (SDataValue item : listDataValue.getValues()) {
	  						if (item instanceof SReferenceDataValue) {
	  							SReferenceDataValue referenceDataValue = (SReferenceDataValue)item;
				  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + referenceDataValue.getOid() + "&className=" + referenceDataValue.getTypeName() + "\">" + referenceDataValue.getTypeName() +"</a> ");
	  						} else if (item instanceof SSimpleDataValue) {
	  							SSimpleDataValue simpleDataValue = (SSimpleDataValue)item;
				  				out.println(simpleDataValue.getStringValue() + " ");
	  						}
	  					}
	  					out.println("</td></tr>");
	  				}
	  			}
	  			out.println("</table>");
	  		} else if (request.getParameter("className") != null) { 
				String className = request.getParameter("className");
				List<SDataObject> dataObjects = loginManager.getService(request).getDataObjectsByType(roid, className);
				out.println("<table class=\"formatted\">");
				out.println("<tr><th>Link</th><th>GUID</th><th>Name</th><th>Type</th><th>Query</th></tr>");
				for (SDataObject object : dataObjects) {
					out.println("<tr><td>");
	  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + object.getOid() + "&className=" + request.getParameter("className") + "\">link</a> ");
					out.println("</td>");
					String guid = null;
					String name = null;
					for (SDataValue sDataValue : object.getValues()) {
						if (sDataValue instanceof SSimpleDataValue) {
							SSimpleDataValue simpleDataValue = (SSimpleDataValue)sDataValue;
							if (sDataValue.getFieldName().equals("Name")) {
								name = (simpleDataValue.getStringValue() == null ? "" : simpleDataValue.getStringValue());
								out.println("<td>" + name + "</td>");
							} else if (sDataValue.getFieldName().equals("GlobalId")) {
								guid = (simpleDataValue.getStringValue() == null ? "" : simpleDataValue.getStringValue());
								out.println("<td>" + guid + "</td>");
							}
						}
					}
					if (name == null) {
						out.println("<td></td>");
					}
					if (guid == null) {
						out.println("<td></td>");
					}
					out.println("<td>" + object.getType() + "</td>");
					out.println("<td><a href=\"#\" class=\"oidquerylink\" oid=\"" + object.getOid() + "\">query</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
	  		} else {
	  			SRevisionSummary revisionSummary = loginManager.getService(request).getRevisionSummary(roid);
	  			out.print(JspHelper.writeSummaryTable(project, roid, revisionSummary, request));
	  		}
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
  	%>
</div>
<script>
$(function(){
	$("#roidchanger").change(function(){
		<%
			String urlAdd = "";
			if (request.getParameter("oid") != null) {
				urlAdd += "+ \"&oid=" + request.getParameter("oid") + "&className=" + request.getParameter("className") + "\"";
			} else if (request.getParameter("className") != null) {
				urlAdd += "+ \"&className=" + request.getParameter("className") + "\"";
			}
		%>
		showOverlay("Browser", "browser.jsp?roid=" + $("#roidchanger").val()<%=urlAdd %>);
	});
	instrumentBrowserLinks();
});
</script>