<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
long poid = Long.parseLong(request.getParameter("poid"));
SProject project = loginManager.getService().getProjectByPoid(poid);
long roid = Long.parseLong(request.getParameter("roid"));
SRevisionSummary revisionSummary = loginManager.getService().getRevisionSummary(roid);
%>
  <a href="#" id="emaillink">E-mail summary</a>
  <div id="emailform">
	<div id="emailajaxloader">
	E-mailing revision summary... <img src="images/ajax-loader.gif"/>
	</div>
  	<form method="post" action="sendsummaryemail.jsp" id="emailsummaryform">
  		Send summary to <input type="text" id="address" name="address"/>
  		<input type="hidden" name="roid" value="<%=roid %>"/>
  		<input type="submit" name="email" value="Send"/>
  	</form>
  </div>
  <br/>
<%= JspHelper.writeSummaryTable(project, roid, revisionSummary, request) %>
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
	$("#emailsummaryform").submit(function(){
		$("#emailsummaryform").hide();
		$("#emailajaxloader").show();
		$("#emailform").load("sendsummaryemail.jsp?roid=<%=roid%>&address=" + $("#address").val());
		return false;
	});
</script>