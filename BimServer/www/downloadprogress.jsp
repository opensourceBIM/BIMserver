<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	String longActionId = request.getParameter("longActionId");
%>
<div id="downloadStateDiv">
	<%=loginManager.getService().getDownloadState(longActionId)%>
</div>