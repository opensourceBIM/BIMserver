<%@page import="org.bimserver.shared.DownloadState.DownloadActionState"%>
<%@page import="org.bimserver.shared.DownloadState"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	String longActionId = request.getParameter("longActionId");
%>
<div id="downloadStateDiv">
	<%
		DownloadState dls = loginManager.getService().getDownloadState(longActionId);
	%>
	<%=dls.getState()%> <%=dls.getProgress()%>%
<%
	if (dls.getState() == DownloadActionState.FINISHED) {
%>
 <a href="/download?longActionId=<%=longActionId %>">Download</a>
<script>
window.clearInterval(downloadUpdateFunctionHandle);
</script>
<%
	}
%>
</div>