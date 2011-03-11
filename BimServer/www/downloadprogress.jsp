<jsp:useBean id="downloadStateBean" scope="session"
	class="org.bimserver.web.DownloadState" />
<%@ include file="header.jsp"%>
<p>Status download action: <B><%=downloadStateBean.getState()%></B></p>
<form action="<%=request.getContextPath()%>/progress" method="get">
<input type="hidden" name="laid"
	value="<%=downloadStateBean.getActionId()%>" /> <input name="update"
	type="submit" value="Update"></form>

<jsp:include page="footer.jsp" />