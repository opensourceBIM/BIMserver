<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.shared.AutologinAuthenticationInfo"%>
<%@page import="org.bimserver.interfaces.objects.SVersion"%>
<%@page import="org.bimserver.interfaces.objects.SServerState"%>
<%@page import="org.bimserver.interfaces.objects.SServerInfo"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<jsp:useBean id="errorMessages" scope="request" class="org.bimwebserver.jsp.ErrorMessages" />
<jsp:include page="htmlheader.jsp" />
<body class="default">
<%
	SServerInfo serverInfo = loginManager.getService(request).getServerInfo();
	if (serverInfo.getServerState() == SServerState.RUNNING) {
%>
<div class="sitewrapper">
<div class="header"><a href="main.jsp"> <%
	SVersion version = loginManager.getService(request).getVersion();
 %> <img class="headerimage"
	src="<%=loginManager.getService(request).getSettingCustomLogoAddress() != null ? loginManager.getService(request).getSettingCustomLogoAddress() : "images/logo.gif"%>" alt="BIMserver" title="BIMserver <%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision()%>" /></a> <%
 	if (loginManager.isLoggedIn()) {
 		SUser loggedInUser = loginManager.getService(request).getLoggedInUser();
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loggedInUser.getOid()%>"><%=loggedInUser.getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<br/>
<jsp:include page="mainmenu.jsp" />
</div>
<jsp:include page="extra.jsp" /> <%
 	} else {
 			if (request.getSession().getAttribute("loggingout") == null) {
 				Map<String, String> cookies = new HashMap<String, String>();
 				if (request.getCookies() != null) {
 				for (Cookie cookie : request.getCookies()) {
 					cookies.put(cookie.getName(), cookie.getValue());
 				}
 				if (cookies.containsKey("autologin") && cookies.containsKey("username")) {
 					AutologinAuthenticationInfo auth = new AutologinAuthenticationInfo(cookies.get("username"), cookies.get("autologin"));
 					if (loginManager.login(auth, request.getRemoteAddr(), request)) {
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loginManager.getService(request).getLoggedInUser().getOid()%>"><%=loginManager.getService(request).getLoggedInUser().getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<br/>
<jsp:include page="mainmenu.jsp" />
</div>
<br />
<br />
<jsp:include page="extra.jsp" /> <%
 	}
 				}
 				}
 			}
 			if (!loginManager.isLoggedIn()) {
 				if (!request.getServletPath().equals("/login.jsp")) {
 					if (request.getQueryString() == null || request.getQueryString().trim().isEmpty()) {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI(), "UTF-8"));
	 					return;
 					} else {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "UTF-8"));
	 					return;
 					}
 				}
 			}
 		}
 	} else if (serverInfo.getServerState() == SServerState.NOT_SETUP) {
 		response.sendRedirect("setup.jsp");
 		return;
 	} else if (serverInfo.getServerState() == SServerState.MIGRATION_REQUIRED || serverInfo.getServerState() == SServerState.MIGRATION_IMPOSSIBLE) {
 		response.sendRedirect("migrations.jsp");
 		return;
 	} else if (serverInfo.getServerState() == SServerState.FATAL_ERROR || serverInfo.getServerState() == SServerState.UNDEFINED) {
 		response.sendRedirect("error.jsp");
 		return;
	}
%>
</div>
<div class="main">
<%=loginManager.getService(request).getSettingHeaderAddition() %>