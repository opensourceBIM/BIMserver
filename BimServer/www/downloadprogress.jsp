<%@page import="org.bimserver.shared.LongActionState.ActionState"%>
<%@page import="org.bimserver.shared.LongActionState"%>
<jsp:useBean id="loginManager" scope="session"
	class="org.bimserver.web.LoginManager" />
<%
	int longActionId = Integer.parseInt(request.getParameter("longActionId"));
	String zip = request.getParameter("zip");
%>
<div id="downloadStateSpan">
<%
	LongActionState dls = loginManager.getService().getDownloadState(longActionId);
%>
	<div id="progressbar" style="width: 100px; position: relative; border: 1px solid black;">
		<div style="width: <%=dls.getProgress()%>px; background-color: #0000ff; position: absolute; top: 0; left: 0; height: 100%;"></div>
		<div style="width: 100px; text-align: center; position: relative;"><%=dls.getProgress()%>%</div>
	</div>
<%
	if (dls.getState() == ActionState.FINISHED) {
%> 
<a id="downloadlink" href="/download?longActionId=<%=longActionId%>&zip=<%=zip%>"><label id="downloadlinkclick" for="downloadlink">Download</label></a>

<script>
	window.clearInterval(downloadUpdateFunctionHandle);
	$("#progressbar").hide();
	$('button[value="Download"]').show();
	$('button[value="Checkout"]').show();
	$('button[value="Query"]').show();
</script> 
<%
	}
%>
</div>

<script>
	$(document).ready(function() {
		$("#downloadlinkclick").click(function() {
			$("#downloadlink").hide();
			$(".downloadResult").empty();
		});
	})
</script>