<%@page import="org.bimserver.webservices.CompareWriter"%>
<%@page import="org.bimserver.ifc.compare.CompareResult.Item"%>
<%@page import="java.util.List"%>
<%@page import="org.eclipse.emf.ecore.EClass"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.PrintStream"%>
<%@page import="org.bimserver.ifc.compare.CompareResult"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.SCompareResult"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.SCompareResult.SCompareType"%>
<%@page import="org.bimserver.shared.SCompareResult.SCompareIdentifier"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ include file="header.jsp" %>
<%
	if (request.getParameter("compare") != null) {
		long roid1 = Long.parseLong(request.getParameter("roid1"));
		long roid2 = Long.parseLong(request.getParameter("roid2"));
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService().getProjectByPoid(poid);
		SRevision revision1 = loginManager.getService().getRevision(roid1);
		SRevision revision2 = loginManager.getService().getRevision(roid2);
		SCompareType sCompareType = SCompareResult.SCompareType.valueOf(request.getParameter("type"));
		SCompareResult.SCompareIdentifier sCompareIdentifier = SCompareResult.SCompareIdentifier.valueOf(request.getParameter("identifier"));
		SCompareResult compareResult = loginManager.getService().compare(roid1, roid2, sCompareType, sCompareIdentifier);
%>
Back to 
<a href="project.jsp?poid=<%=poid %>">project '<%= project.getName() %>'</a><br/><br/>
  <a href="#" id="emaillink">E-mail summary</a>
  <div id="emailform">
	<div id="emailajaxloader">
	E-mailing compare results... <img src="images/ajax-loader.gif"/>
	</div>
  	<form method="post" action="sendcompareemail.jsp" id="emailcompareform">
  		Send summary to <input type="text" id="address" name="address"/>
  		<input type="hidden" name="poid" value="<%=poid %>"/>
  		<input type="hidden" name="roid1" value="<%=roid1 %>"/>
  		<input type="hidden" name="roid2" value="<%=roid2 %>"/>
  		<input type="hidden" name="type" value="<%=request.getParameter("type") %>"/>
  		<input type="hidden" name="identifier" value="<%=request.getParameter("identifier") %>"/>
  		<input type="submit" name="email" value="Send"/>
  	</form>
  </div>
<%= CompareWriter.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), sCompareType, project, true) %>

<form action="<%=request.getContextPath() %>/download" method="get">
Download: 
<input type="hidden" name="compare" value="true" />
<input type="hidden" name="type" value="<%=request.getParameter("type") %>" />
<input type="hidden" name="identifier" value="<%=request.getParameter("identifier") %>" />
<input type="hidden" name="roid1" value="<%=request.getParameter("roid1") %>" />
<input type="hidden" name="roid2" value="<%=request.getParameter("roid2") %>" />
<select name="resultType">
	<%
		for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
	%>
	<option value="<%=serializer.getName()%>"
		<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
		}
	%>
</select> <label for="zip">Zip</label> <input type="checkbox" name="zip" id="zip" />
		<input name="download" type="submit" value="Download">
</form>

<script>
	$(document).ready(function(){
		$("#emailform").hide();
		$("#emailajaxloader").hide();
		$("#typeselector").change(function(){
			document.location = 'compare.jsp?roid1=<%=roid1%>&roid2=<%=roid2%>&poid=<%=poid%>&compare=Compare&type=' + $("#typeselector").val() + '&identifier=<%=request.getParameter("identifier")%>';
		});
		$("#emaillink").click(function(){
			$("#emaillink").hide();
			$("#emailform").show();
			$("#address").focus();
		});
		$("#emailcompareform").submit(function(){
			$("#emailcompareform").hide();
			$("#emailajaxloader").show();
			$("#emailform").load("sendcompareemail.jsp?type=<%=request.getParameter("type")%>&poid=<%=poid%>&roid1=<%=roid1%>&roid2=<%=roid2%>&address=" + $("#address").val() + '&identifier=<%=request.getParameter("identifier")%>');
			return false;
		});
	});
</script>
<%}%>