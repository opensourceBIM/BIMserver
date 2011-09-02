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
<!-- Pro features checkboxes -->
<tr><td>
<label for="checkbox">Validate Business Rules</label></td>
<td><input name="checkbox" type="checkbox" onclick="$(this).is(':checked') && $('#idmchecked').slideDown('slow') || $('#idmchecked').slideUp('slow');" /></td>
<p id="idmchecked" style="display: none; padding: 10px" >Sorry... Checking data against business rules is only available in a custom made release. It will be in the generic release soon!</p>
</tr>

<tr><td>
<label for="checkbox">Check IFC validity</label></td>
<td><input name="checkbox" type="checkbox" onclick="$(this).is(':checked') && $('#ifcchecked').slideDown('slow') || $('#ifcchecked').slideUp('slow');" /></td>
<p id="ifcchecked" style="display: none; padding: 10px" >Sorry... Checking the validity of the IFC data is only available in a custom made release. It will be in the generic release soon!</p>
</tr>



<!-- Comment -->
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