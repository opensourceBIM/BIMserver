<%@ page import="org.bimserver.shared.SRevisionSummary"%>
<%@ page import="org.bimserver.web.JspHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="org.bimserver.interfaces.objects.SProject"%>
<%@ page import="org.bimserver.interfaces.objects.SRevision"%>
<%@ page import="org.bimserver.shared.UserException"%>
<jsp:useBean id="loginManager" scope="session"
	class="org.bimserver.web.LoginManager" />

<%
	try {
		long roid = Long.parseLong(request.getParameter("roid"));
		String tag = request.getParameter("tagLabel");
		loginManager.getService().setRevisionTag(roid, tag);
		response.sendRedirect("revision.jsp?roid=" + request.getParameter("roid"));
	} catch (UserException e) {
		JspHelper.showException(out, e);
	}
%>