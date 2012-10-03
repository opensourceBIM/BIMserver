<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="org.bimwebserver.jsp.JspHelper"%>
<%@ page import="java.util.List"%>
<%@ page import="org.bimserver.interfaces.objects.SProject"%>
<%@ page import="org.bimserver.interfaces.objects.SRevision"%>
<%@ page import="org.bimserver.shared.exceptions.ServiceException"%>
<jsp:useBean id="loginManager" scope="session"
	class="org.bimwebserver.jsp.LoginManager" />

<%
	try {
		long roid = Long.parseLong(request.getParameter("roid"));
		String tag = request.getParameter("tagLabel");
		loginManager.getService(request).setRevisionTag(roid, tag);
		response.sendRedirect("revision.jsp?roid=" + request.getParameter("roid"));
	} catch (ServiceException e) {
		JspHelper.showException(out, e);
	}
%>