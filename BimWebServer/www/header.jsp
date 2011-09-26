<%@page import="org.bimserver.interfaces.objects.SVersion"%>
<%@page import="org.bimserver.interfaces.objects.SServerState"%>
<%@page import="org.bimserver.interfaces.objects.SServerInfo"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:useBean id="errorMessages" scope="request" class="org.bimserver.web.ErrorMessages" />
<jsp:include page="htmlheader.jsp" />
<body class="default">
<%
	SServerInfo serverInfo = loginManager.getService().getServerInfo();
	if (serverInfo.getServerState() == SServerState.RUNNING) {
%>
<div class="sitewrapper">
<div class="header"><a href="main.jsp"> <%
	SVersion version = loginManager.getService().getVersion();
 %> <img class="headerimage"
	src="<%=loginManager.getService().getSettingCustomLogoAddress() != null ? loginManager.getService().getSettingCustomLogoAddress() : "images/logo.gif"%>" alt="BIMserver" title="BIMserver <%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision()%>" /></a> <%
 	if (loginManager.getService().isLoggedIn()) {
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loginManager.getService().getLoggedInUser().getOid()%>"><%=loginManager.getService().getLoggedInUser().getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
<br/>
<jsp:include page="mainmenu.jsp" />
</div>
<jsp:include page="extra.jsp" /> <%
 	} else {
 			if (request.getSession().getAttribute("loggingout") == null) {
 				request.getSession().removeAttribute("loggingout");
 				Map<String, String> cookies = new HashMap<String, String>();
 				if (request.getCookies() != null) {
 				for (Cookie cookie : request.getCookies()) {
 					cookies.put(cookie.getName(), cookie.getValue());
 				}
 				if (cookies.containsKey("autologin") && cookies.containsKey("username")) {
 					if (loginManager.getService().autologin(cookies.get("username"), cookies.get("autologin"))) {
 %>
<div class="menubar">
You are logged in as: <a href="user.jsp?uoid=<%=loginManager.getService().getLoggedInUser().getOid()%>"><%=loginManager.getService().getLoggedInUser().getName()%></a> - <a href="logout.jsp">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;<br/>
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
 			if (!loginManager.getService().isLoggedIn()) {
 				if (!request.getServletPath().equals("/login.jsp")) {
 					if (request.getQueryString() == null || request.getQueryString().trim().isEmpty()) {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI(), "UTF-8"));
 					} else {
	 					response.sendRedirect(request.getContextPath() + "/login.jsp?origurl="
	 							+ URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "UTF-8"));
 					}
 				}
 			}
 		}
 	} else if (serverInfo.getServerState() == SServerState.NOT_SETUP) {
 		response.sendRedirect("setup.jsp");
 	} else if (serverInfo.getServerState() == SServerState.MIGRATION_REQUIRED || serverInfo.getServerState() == SServerState.MIGRATION_IMPOSSIBLE) {
 		response.sendRedirect("migrations.jsp");
 	} else if (serverInfo.getServerState() == SServerState.FATAL_ERROR || serverInfo.getServerState() == SServerState.UNDEFINED) {
 		response.sendRedirect("error.jsp");
	}
%>
</div>
<div class="main">
<%=loginManager.getService().getSettingHeaderAddition() %>