<%@page import="org.bimserver.interfaces.objects.SDeserializer"%>
<%@page import="org.bimserver.web.LoginManager"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long poid = Long.parseLong(request.getParameter("poid"));
	SProject sProject = loginManager.getService().getProjectByPoid(poid);
%>
<fieldset>
<legend>Upload file</legend>
<div id="uploadajaxloader">
Uploading... <img src="images/ajax-loader.gif"/>
</div>
<form action="upload" method="post" enctype="multipart/form-data" id="uploadform">
<table>
<tr><td><label for="file">File</label></td><td><input id="file" type="file" name="file"/></td></tr>
<tr><td><label for="deserializerName">Deserializer</label></td><td><select name="deserializerName">
<%
	for (SDeserializer deserializer : loginManager.getService().getEnabledDeserializers()) {
		out.println("<option value=\"" + deserializer.getName() + "\">" + deserializer.getName() + "</option>");
	}
%>
</select></td></tr>
<tr><td><label for="comment">Comment</label></td><td><textarea id="comment" name="comment" cols="80" rows="4"></textarea></td></tr>
<%
	if (loginManager.getService().isSettingCheckinMergingEnabled() && sProject.getRevisions().size() > 0) {
%>
<tr><td><label for="merge">Merge</label></td><td><input id="merge" name="merge" type="checkbox"/></td></tr>
<%
	}
%>
</table>
<input type="hidden" name="poid" value="<%=poid %>"/>
<input type="hidden" name="type" value="ifc"/>
<input type="submit" name="upload" value="Upload"/>
</form>
</fieldset>
<script>
	var lastVal = "";

	$(document).ready(function(){
		$("#uploadajaxloader").hide();
		$("#file").change(function(){
			if ($("#comment").attr("value") == "" || $("#comment").attr("value") == lastVal) {
				var path = $("#file").val();
				if (path.indexOf("/") != -1) {
					path = path.substr(path.lastIndexOf("/") + 1);
				} else if (path.indexOf("\\") != -1) {
					path = path.substr(path.lastIndexOf("\\") + 1);
				}
				$("#comment").attr("value", path);
				lastVal = path;
			}
		});
	});
	$("#uploadform").submit(function(){
		$("#uploadform").hide();
		$("#uploadajaxloader").show();
	});
</script>