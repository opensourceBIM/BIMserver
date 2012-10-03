<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Set"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<body>
<div style="width: 1000px; margin-left: auto; margin-right: auto; padding-top: 20px">
<a href="error.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a>
<h1>Don't Panic</h1>
<h2>and carry a towel</h2>
<br/>
<div class="error"><%=loginManager.getService(request).getServerInfo().getErrorMessage()%></div>
<p>If you plan to post this error on <a href="http://support.bimserver.org" target="_blank">http://support.bimserver.org</a>, please make sure you accompany it with the <a href="<%=getServletContext().getContextPath()%>/settings?action=downloadlog">server logfile</a>.</p> 
</div>
</body>
</html>