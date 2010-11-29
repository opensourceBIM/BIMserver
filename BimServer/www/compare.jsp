<%@page import="org.bimserver.ifc.emf.Ifc2x3.IfcRoot"%>
<%@page import="org.bimserver.ifc.file.compare.CompareResult.Item"%>
<%@page import="java.util.List"%>
<%@page import="org.eclipse.emf.ecore.EClass"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.PrintStream"%>
<%@page import="org.bimserver.ifc.file.compare.CompareResult"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="org.bimserver.shared.SCompareResult"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@ include file="header.jsp" %>
<%
	if (request.getParameter("compare") != null) {
		long roid1 = Long.parseLong(request.getParameter("roid1"));
		long roid2 = Long.parseLong(request.getParameter("roid2"));
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService().getProjectByPoid(poid);
		SRevision revision1 = loginManager.getService().getRevision(roid1);
		SRevision revision2 = loginManager.getService().getRevision(roid2);
		SCompareResult compareResult = loginManager.getService().compare(roid1, roid2);
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
  		<input type="submit" name="email" value="Send"/>
  	</form>
  </div>
<%= JspHelper.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), project) %>
<script>
	$(document).ready(function(){
		$("#emailform").hide();
		$("#emailajaxloader").hide();
	});
	$("#emaillink").click(function(){
		$("#emaillink").hide();
		$("#emailform").show();
		$("#address").focus();
	});
	$("#emailcompareform").submit(function(){
		$("#emailcompareform").hide();
		$("#emailajaxloader").show();
		$("#emailform").load("sendcompareemail.jsp?poid=<%=poid%>&roid1=<%=roid1%>&roid2=<%=roid2%>&address=" + $("#address").val());
		return false;
	});
</script>
<%}%>