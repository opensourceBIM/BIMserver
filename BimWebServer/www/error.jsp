<%@page import="java.util.Set"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<body>
<div style="width: 1000px; margin-left: auto; margin-right: auto; padding-top: 20px">
<a href="error.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a>
<h1>Don't Panic</h1>
<h2>and carry a towel</h2>
<br/>
<div class="error"><%=loginManager.getService().getServerInfo().getErrorMessage()%></div>
</div>
</body>
</html>