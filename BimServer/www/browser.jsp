<%@page import="org.bimserver.shared.DataObject"%>
<%@page import="org.bimserver.shared.DataObject.DataValue"%>
<%@page import="org.bimserver.shared.DataObject.ReferenceDataValue"%>
<%@page import="org.bimserver.shared.DataObject.SimpleDataValue"%>
<%@page import="java.util.List"%>
<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<div id="browser">
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
  	<%
  		long roid = Long.parseLong(request.getParameter("roid"));
  		SRevision revision = loginManager.getService().getRevision(roid);
  		SProject project = loginManager.getService().getProjectByPoid(revision.getProjectId());
  		DataObject dataObject = null;
  		if (request.getParameter("guid") != null) {
  			String guid = request.getParameter("guid");
	  		dataObject = loginManager.getService().getDataObjectByGuid(roid, guid);
  		} else if (request.getParameter("oid") != null) {
  			long oid = Long.parseLong(request.getParameter("oid"));
  			String className = request.getParameter("className");
	  		dataObject = loginManager.getService().getDataObjectByOid(roid, oid, className);
  		}
  		if (dataObject != null) {
			out.println("<a href=\"#\" class=\"browserlink\" browserUrl=\"" + request.getRequestURI() + "?roid=" + roid + "\">Home</a>");
  			out.println("<h1>" + dataObject.getType() + "</h1>");
  			out.println("<table>");
  			for (String fieldName : dataObject.getFields().keySet()) {
  				DataObject.DataValue dataValue = dataObject.getFields().get(fieldName);
  				if (dataValue instanceof DataObject.SimpleDataValue) {
	  				out.println("<tr><td>" + fieldName + "</td><td>" + dataValue.toString() +"</td></tr>");
  				} else if (dataValue instanceof DataObject.ReferenceDataValue) {
  					DataObject.ReferenceDataValue referenceDataValue = (DataObject.ReferenceDataValue)dataValue;
  					if (referenceDataValue.getGuid() != null) {
		  				out.println("<tr><td>" + fieldName + "</td><td><a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&guid=" + referenceDataValue.getGuid() + "\">" + referenceDataValue.getTypeName() +"</a></td></tr>");
  					} else {
		  				out.println("<tr><td>" + fieldName + "</td><td><a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + referenceDataValue.getOid() + "&className=" + referenceDataValue.getTypeName() + "\">" + referenceDataValue.getTypeName() +"</a></td></tr>");
  					}
  				} else if (dataValue instanceof DataObject.ListDataValue) {
  					DataObject.ListDataValue listDataValue = (DataObject.ListDataValue)dataValue;
  					out.println("<tr><td>" + fieldName + "</td><td>");
  					for (DataObject.DataValue item : listDataValue.getValues()) {
  						if (item instanceof DataObject.ReferenceDataValue) {
  							DataObject.ReferenceDataValue referenceDataValue = (DataObject.ReferenceDataValue)item;
  							if (referenceDataValue.getGuid() != null) {
				  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&guid=" + referenceDataValue.getGuid() + "\">" + referenceDataValue.getTypeName() +"</a> ");
  							} else {
				  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + referenceDataValue.getOid() + "&className=" + referenceDataValue.getTypeName() + "\">" + referenceDataValue.getTypeName() +"</a> ");
  							}
  						} else if (item instanceof DataObject.SimpleDataValue) {
  							DataObject.SimpleDataValue simpleDataValue = (DataObject.SimpleDataValue)item;
			  				out.println(simpleDataValue.toString() + " ");
  						}
  					}
  					out.println("</td></tr>");
  				}
  			}
  			out.println("</table>");
%>
	<br/>
	<div id="browservisualizeloader">
		  Retrieving visualization... <img src="images/ajax-loader.gif"/>
  	</div>
  	<div id="browservisualizediv" style="background-color:white">
	  	<a href="#" id="browservisualizelink">Load visualization</a>
  	</div>
<%
  		} else if (request.getParameter("className") != null) { 
			String className = request.getParameter("className");
			List<DataObject> dataObjects = loginManager.getService().getDataObjectsByType(roid, className);
			out.println("<a href=\"#\" class=\"browserlink\" browserUrl=\"" + request.getRequestURI() + "?roid=" + roid + "\">Home</a>");
			out.println("<table class=\"formatted\">");
			out.println("<tr><th>Link</th><th>GUID</th><th>Name</th><th>Type</th><th>Query</th></tr>");
			for (DataObject object : dataObjects) {
				out.println("<tr><td>");
				if (object.getGuid() != null) {
	  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&guid=" + object.getGuid() + "\">link</a> ");
				} else {
	  				out.println("<a href=\"#\" class=\"browserlink\" browserurl=\"" + request.getRequestURI() + "?roid=" + roid + "&oid=" + object.getOid() + "&className=" + object.getType() + "\">link</a> ");
				}
				out.println("</td>");
				String guid = null;
				String name = null;
				for (String fieldName : object.getFields().keySet()) {
					if (fieldName.equals("Name")) {
						name = (object.getFields().get(fieldName) == null ? "" : object.getFields().get(fieldName).toString());
						out.println("<td>" + name + "</td>");
					} else if (fieldName.equals("GlobalId")) {
						guid = (object.getFields().get(fieldName) == null ? "" : object.getFields().get(fieldName).toString());
						out.println("<td>" + guid + "</td>");
					}
				}
				if (name == null) {
					out.println("<td></td>");
				}
				if (guid == null) {
					out.println("<td></td>");
				}
				out.println("<td>" + object.getType() + "</td>");
				if (guid != null) {
					out.println("<td><a href=\"#\" class=\"guidquerylink\" guid=\"" + guid + "\">query</a></td>");
				} else {
					out.println("<td><a href=\"#\" class=\"oidquerylink\" oid=\"" + object.getOid() + "\">query</a></td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
  		} else {
  			SRevisionSummary revisionSummary = loginManager.getService().getRevisionSummary(roid);
  			out.print(JspHelper.writeSummaryTable(project, roid, revisionSummary, request));
  		}
  	%>
</div>
<script>
$(document).ready(function(){
	$("#browservisualizeloader").hide();
	$("#browservisualizelink").click(function (){
		$("#browservisualizelink").hide();
		$("#browservisualizeloader").show();
		var o3dId = "o3d" + (o3dcounter++);
		$("<div id='" + o3dId + "' style='width: 100%; height: 500px'></div>").appendTo("#browservisualizediv");
		createClient(document.getElementById(o3dId), function(){
			doload(o3djs.util.getCurrentURI() + 'download?roid=<%=request.getParameter("roid") %>&guids=<%=request.getParameter("guid")%>&resultType=O3D_JSON', "browservisualizeloader");
		});
	});	
	instrumentBrowserLinks();
});
</script>