<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	try {
		loginManager.getService().logout();
	} catch (ServiceException e) {
		// Probably a session timeout
	}
	request.getSession().setAttribute("loggingout", "true");
	Cookie autologinCookie = new Cookie("autologin", "");
	autologinCookie.setMaxAge(0);
	response.addCookie(autologinCookie);
	Cookie usernameCookie = new Cookie("username", "");
	usernameCookie.setMaxAge(0);
	response.addCookie(usernameCookie);
	response.sendRedirect("main.jsp");
%>