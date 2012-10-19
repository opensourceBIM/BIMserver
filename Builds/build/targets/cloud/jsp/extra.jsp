<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	if (loginManager.getService().getCurrentUser().getUsername().contains("@")) {
%>
<div>
Tell a friend<br/>
<form action="tellafriend.jsp" method="post">
<label for="email">E-mail address</label> <input id="email" type="text" name="email"/>
<input type="submit" value="Send"/>
</form>
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
