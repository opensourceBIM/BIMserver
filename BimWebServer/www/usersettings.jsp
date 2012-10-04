<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<h1>User Settings</h1>
User the menu on the left.<br/><br/>
<div class="not initialhide">
	Click <a class="desktopNotificationsLink" href="#">here</a> to enable desktop notifications.
</div>
<script>
$(function(){
	if (window.webkitNotifications) {
		if (window.webkitNotifications.checkPermission() != 0) {
			$(".not").show();		
		}
		$(".desktopNotificationsLink").click(function(event){
			event.preventDefault();
			window.webkitNotifications.requestPermission();
		});
	}
});
</script>