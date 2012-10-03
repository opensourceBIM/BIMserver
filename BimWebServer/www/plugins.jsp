<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SPluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<jsp:include page="serversettingsmenu.jsp"/>
<div class="content">
<h1>Plugins</h1>
<%
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("enable")) {
				String pluginName = request.getParameter("plugin");
				loginManager.getService(request).enablePlugin(pluginName);
			} else if (action.equals("disable")) {
				String pluginName = request.getParameter("plugin");
				loginManager.getService(request).disablePlugin(pluginName);
			}
		}
		List<SPluginDescriptor> plugins = loginManager.getService(request).getAllPlugins();
%>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Location</th><th>State</th><th>Actions</th></tr>
<%
	for (SPluginDescriptor plugin : plugins) {
%>
<tr>
	<td><%=plugin.getDefaultName() %></td>
	<td><%=plugin.getDescription() %></td>
	<td><%=plugin.getLocation() %></td>
	<td class="<%=plugin.getEnabled() ? "enabledPlugin" : "disabledPlugin" %>"><%=plugin.getEnabled() ? "Enabled" : "Disabled" %></td>
	<td>
<%
	if (plugin.getEnabled()) {
%>
<a href="plugins.jsp?action=disable&plugin=<%=plugin.getDefaultName() %>">Disable</a>
<%
	} else {
%>
<a href="plugins.jsp?action=enable&plugin=<%=plugin.getDefaultName() %>">Enable</a>
<%
	}
%>
	</td>
</tr>
<%
	}
%>
</table>
<%
} else {
	out.println("Insufficient rights");	
}
%>
</div>
<%@ include file="footer.jsp"%>