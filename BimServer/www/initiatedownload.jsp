<%@page import="org.bimserver.shared.ResultType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	String longActionId = loginManager.getService().download(roid, ResultType.IFC, false);
%>
	<jsp:include page="downloadprogress.jsp">
		<jsp:param name="longActionId" value="<%=longActionId %>"/>
	</jsp:include>
<script>
$(document).ready(function(){
	var updateFunction = function() {
		$.ajax({
			url: "/progress",
			cache: false,
			context: document.body,
			success: 
				function(data){
					var state = data.state;
					$("#downloadStateDiv").html(state);
					if (state == "ready") {
						$("#downloadStateDiv").append("<a href=\"/download?longActionId=<%=longActionId%>\">Download</a>");
					}
				},
			data: {laid: '<%=longActionId%>'}
		});
	};
	window.setInterval(updateFunction, 1000);
});
</script>	
