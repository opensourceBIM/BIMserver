<%@page import="org.bimserver.web.WebServerHelper"%>
<%@page import="java.util.Set"%>
<%@page import="org.bimserver.shared.ServerException"%>
<%@page import="org.bimserver.ServerInfo"%>
<%@page import="org.bimserver.ServerInfo.ServerState"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<body>
<div style="width: 1000px; margin-left: auto; margin-right: auto; padding-top: 20px">
<a href="error.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a>
<h1>BIMserver Error</h1>
<div class="error"><%=WebServerHelper.getBimServer().getServerInfo().getErrorMessage()%></div>
</div>
</body>
</html>