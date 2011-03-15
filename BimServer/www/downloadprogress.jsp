<%@page import="org.bimserver.shared.LongActionState.ActionState"%>
<%@page import="org.bimserver.shared.LongActionState"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
	<%
		String longActionId = request.getParameter("longActionId");
	%>
<span id="downloadStateSpan">
	<%
		LongActionState dls = loginManager.getService().getDownloadState(longActionId);
	%>
	<%=dls.getState()%> <%=dls.getProgress()%>%
	
	<div style="width: 100px; position: relative; border: 1px solid black;">
		<div style="width: <%=dls.getProgress()%>px; background-color: #0000ff; position: absolute; top: 0; left: 0; height: 100%;"></div>
		<div style="width: 100px; text-align: center; position: relative;"><%=dls.getProgress()%>%</div>
	</div>
	<%
		if (dls.getState() == ActionState.FINISHED) {
	%>
<a href="/download?longActionId=<%=longActionId %>">Download</a>
 
<script>
	window.clearInterval(downloadUpdateFunctionHandle);
	
	$("#simpleDownloadButton").show();
	$("#detailscheckoutbutton").show();
</script>
	<%
		}
	%>
</span>
