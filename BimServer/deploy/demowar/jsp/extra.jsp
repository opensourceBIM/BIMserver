<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	if (loginManager.getService().getCurrentUser().getUsername().contains("@")) {
%>
<div class="info">
Think this userinterface is bad?<br/>
We think so too... Please donate so we can improve it!<br/>
Get info on sponsor packages on <a href="mailto:info@bimserver.org">info@bimserver.org</a>
</div>
<%
}
%>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try {
var pageTracker = _gat._getTracker("UA-12170438-1");
pageTracker._trackPageview();
} catch(err) {}</script>
