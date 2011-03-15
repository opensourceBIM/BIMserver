<%@page import="org.bimserver.shared.ResultType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	ResultType resultType = ResultType.IFC;
	if (request.getParameter("resultType") != null) {
		resultType = ResultType.valueOf(request.getParameter("resultType"));
	}
	String longActionId = null;
	if (request.getParameter("checkout") != null) {
		longActionId = loginManager.getService().checkout(roid, resultType, false);
	} else if (request.getParameter("download") != null) {
		longActionId = loginManager.getService().download(roid, resultType, false);
	}
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
				$("#downloadStateSpan").html(data);
			},
		data: {longActionId: '<%=longActionId%>'}
	});
};

$(document).ready(function(){
	downloadUpdateFunctionHandle = window.setInterval(downloadUpdateFunction, 1000);
});
</script>	
