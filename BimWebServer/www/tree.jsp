<%@page import="java.util.List"%>
<%@page import="org.bimserver.shared.SDataObject"%>
<%@ include file="header.jsp"%>

<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.models.ifc2x3.IfcOpeningElement"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%><script> 
$(document).ready(function(){
	$(".root").css("padding-left", "5px");
	$(".node").css("padding-left", "15px");
	$(".showContent").click(function(event){
		$(event.target).parent().find(".content").toggle();
	});
	$(".showNodeContent").click(function(event){
		alert($(event.target).attr("oid"));
	});
	$("#projectSelect").change(function(){
		$("#projectSelect").
	});
});
</script>
Project <select id="projectSelect">
<%
	for (SProject project : loginManager.getService().getAllProjects()) {
%><option><%=project.getName() %></option><%
	}
%>
</select>




</select>
<%
	long roid = 83241;
	String[] types = new String[]{"IfcSite", "IfcBuilding", "IfcBuildingStorey", "IfcWall", "IfcDoor", "IfcWallStandardCase", "IfcWindow", "IfcOpeningElement", "IfcSlab", "IfcRoof", "IfcSpace"};
	for (String type : types) {
%>
<div class="root"><a href="#" class="showContent"><%=type %></a>
<div class="content" style="display: none">  
<%
		List<SDataObject> objects = loginManager.getService().getDataObjectsByType(roid, type);
		if (objects.size() > 0) {
			for (SDataObject object : objects) {
				%>
				<div class = "node"  ><a href="#" class="showNodeContent" oid="<%= object.getOid() %>"><%= object.getName() %></a></div>
				<%
			}
		}
		%></div></div>
	
<%  } %>
