<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.compare.CompareWriter"%>
<%@page import="org.bimserver.interfaces.objects.SCompareResult"%>
<%@page import="org.bimserver.interfaces.objects.SCompareType"%>
<%@page import="java.util.List"%>
<%@page import="org.eclipse.emf.ecore.EClass"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.PrintStream"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@ include file="header.jsp" %>
<%
	if (request.getParameter("compare") != null) {
		long roid1 = Long.parseLong(request.getParameter("roid1"));
		long roid2 = Long.parseLong(request.getParameter("roid2"));
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService(request).getProjectByPoid(poid);
		SRevision revision1 = loginManager.getService(request).getRevision(roid1);
		SRevision revision2 = loginManager.getService(request).getRevision(roid2);
		SCompareType sCompareType = SCompareType.valueOf(request.getParameter("type"));
		SCompareResult compareResult = loginManager.getService(request).compare(roid1, roid2, sCompareType, Long.parseLong(request.getParameter("mcid")));
%>
<div id="downloadcheckoutpopup"></div>
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
  		<input type="hidden" name="mcid" value="<%=request.getParameter("mcid") %>"/>
  		<input type="submit" name="email" value="Send"/>
  	</form>
  </div>
<%= CompareWriter.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), sCompareType, project, true) %>
<a href="#" class="downloadCheckoutButton">Download</a>
<script>
	$(function(){
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
		$(".downloadCheckoutButton").click(function(event){
			event.preventDefault();
			$("#downloadcheckoutpopup").dialog({
				title: "Download/Checkout",
				width: 600,
				height: 300,
				modal: true
			});
			var params = {
				downloadType: "compare",
				type: '<%=request.getParameter("type")%>',
				poid: <%=poid%>,
				roid1: <%=roid1%>,
				roid2: <%=roid2%>,
				mcid: '<%=request.getParameter("mcid")%>'
			};
			$("#downloadcheckoutpopup").load("download.jsp", {data: JSON.stringify(params)});
		});
		$("#emailcompareform").submit(function(){
			$("#emailcompareform").hide();
			$("#emailajaxloader").show();
			$("#emailform").load("sendcompareemail.jsp?type=<%=request.getParameter("type")%>&poid=<%=poid%>&roid1=<%=roid1%>&roid2=<%=roid2%>&address=" + $("#address").val() + '&mcid=<%=request.getParameter("mcid")%>');
			return false;
		});
	});
</script>
<%}%>