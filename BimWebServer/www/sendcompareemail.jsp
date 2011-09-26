<%@page import="org.bimserver.interfaces.objects.SCompareIdentifier"%>
<%@page import="org.bimserver.interfaces.objects.SCompareType"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	Logger logger = LoggerFactory.getLogger(JspHelper.class);
	try {
		String address = request.getParameter("address");
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService().getProjectByPoid(poid);
		long roid1 = Long.parseLong(request.getParameter("roid1"));
		long roid2 = Long.parseLong(request.getParameter("roid2"));

		loginManager.getService().sendCompareEmail(SCompareType.valueOf(request.getParameter("type")), SCompareIdentifier.valueOf(request.getParameter("identifier")), poid, roid1, roid2, address);
		
		out.append("Compare results successfully e-mailed to " + address);
	} catch (Exception e) {
		logger.error("", e);
		out.append("An error has occured while sending compare results: " + e.getMessage());
	}
%>