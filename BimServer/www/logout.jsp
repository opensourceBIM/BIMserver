<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	loginManager.logout();
	request.getSession().setAttribute("loggingout", "true");
	Cookie autologinCookie = new Cookie("autologin", "");
	autologinCookie.setMaxAge(0);
	response.addCookie(autologinCookie);
	Cookie usernameCookie = new Cookie("username", "");
	usernameCookie.setMaxAge(0);
	response.addCookie(usernameCookie);
	response.sendRedirect("main.jsp");
%>