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
var downloadUpdateFunctionHandle;

var downloadUpdateFunction = function() {
	$.ajax({
		url: "downloadprogress.jsp",
		cache: false,
		context: document.body,
		success: 
			function(data){
				$("#downloadStateDiv").html(data);
			},
		data: {longActionId: '<%=longActionId%>'}
	});
};

$(document).ready(function(){
	downloadUpdateFunctionHandle = window.setInterval(downloadUpdateFunction, 1000);
});
</script>	
