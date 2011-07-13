<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.pb.Service.LoginAnonymousRequest"%>
<%@page import="org.bimserver.shared.SPlugin"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="org.bimserver.shared.SPlugin.SPluginState"%>
<%@page import="org.bimserver.shared.SPlugin.SPluginState"%>
<%@page import="org.bimserver.shared.SPlugin.SPluginState"%>
<%@ include file="header.jsp" %>
<%@page import="org.bimserver.shared.SPlugin.SPluginState"%>
<jsp:include page="serversettingsmenu.jsp"/>
<div class="content">
<h1>Plugins</h1>
<%
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		if (request.getParameter("action") != null) {
			String action = request.getParameter("action");
			if (action.equals("enable")) {
				String pluginName = request.getParameter("plugin");
				loginManager.getService().enablePlugin(pluginName);
			} else if (action.equals("disable")) {
				String pluginName = request.getParameter("plugin");
				loginManager.getService().disablePlugin(pluginName);
			}
		}
		List<SPlugin> plugins = loginManager.getService().getAllPlugins();
%>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Location</th><th>State</th><th>Actions</th></tr>
<%
	for (SPlugin plugin : plugins) {
%>
<tr>
	<td><%=plugin.getName() %></td>
	<td><%=plugin.getDescription() %></td>
	<td><%=plugin.getLocation() %></td>
	<td class="<%=plugin.getState() == SPlugin.SPluginState.ENABLED ? "enabledPlugin" : "disabledPlugin" %>"><%=plugin.getState().getNiceName() %></td>
	<td>
<%
	if (plugin.getState() == SPlugin.SPluginState.ENABLED) {
%>
<a href="plugins.jsp?action=disable&plugin=<%=plugin.getName() %>">Disable</a>
<%
	} else if (plugin.getState() == SPlugin.SPluginState.DISABLED) {
%>
<a href="plugins.jsp?action=enable&plugin=<%=plugin.getName() %>">Enable</a>
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