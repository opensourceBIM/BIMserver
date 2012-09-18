<%@page import="org.bimserver.interfaces.objects.SExternalProfile"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SExternalServer"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	SProject project = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("oid")));
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("add")) {
			SExternalProfile sExternalProfile = new SExternalProfile();
			sExternalProfile.setDescription(request.getParameter("description"));
			sExternalProfile.setName(request.getParameter("name"));
			sExternalProfile.setReadExtendedData(request.getParameter("readExtendedData") != null);
			sExternalProfile.setReadRevision(request.getParameter("readRevision") != null);
			sExternalProfile.setWriteRevisionId(Long.parseLong(request.getParameter("writeRevision")));
			sExternalProfile.setWriteRevisionId(Long.parseLong(request.getParameter("writeExtendedData")));
			sExternalProfile.setServerId(Long.parseLong(request.getParameter("serveroid")));
			loginManager.getService().addProfileToProject(project.getOid(), sExternalProfile);
		}
	}
%>
<label for="servers">External Server </label><select id="servers" name="servers" class="servers">
				<option value="[SELECT]">[Select]</option>
<%
	for (SExternalServer externalServer : loginManager.getService().getRepositoryServers()) {
		out.println("<option value=\"" + externalServer.getUrl() + "\">" + externalServer.getTitle() + "</option>");
	} 
%>
			</select>
			<label for="profiles"></label>
			<select class="profiles initialhide" id="profiles" name="profiles">
			</select>
			<div class="profilediv initialhide">
				<input type="hidden" class="serveroid"/>
				<input type="hidden" class="profileoid"/>
				<input type="hidden" class="profileName"/>
				<div class="profileDescription"></div>
				<div class="readRevision initialhide"><label><span>Read Revision</span><input type="checkbox" disabled="disabled" checked="checked"/></label></div>
				<div class="writeRevision initialhide"><label><span>Write Revision</span><select><option value="<%=project.getOid()%>"><%=project.getName() %></option></select></label></div>
				<div class="readExtendedData initialhide"><label><span>Read Extended Data</span><input type="checkbox" disabled="disabled" checked="checked"/></label></div>
				<div class="writeExtendedData initialhide"><label><span>Write Extended Data</span><select><option value="<%=project.getOid()%>"><%=project.getName() %></option></select></label></div>
				<input type="button" class="saveButton" value="Save"/>
			</div>
<script>
$(function(){
	$(".servers").change(function(){
		var val = $(this).attr("value");
		if (val == "[SELECT]") {
			$(".profiles, .profilediv").hide();
		} else {
			$.getJSON("getprofiles.jsp?url=" + val, function(data) {
				$(".profiles").empty();
				$(".profiles").append($("<option value=\"[SELECT]\">[Select]</option>"));
				data.profiles.forEach(function(profile){
					var option = $("<option value=\"" + profile.name + "\">" + profile.name + "</option>");
					option.data("profile", profile);
					$(".profiles").append(option);
				});
				$(".profiles").show();
			});
		}
	});
	
	$(".profiles").change(function(){
		if ($(this).find(":selected").val() == "[SELECT]") {
			$(".profilediv").hide();
		} else {
			$(".profilediv").show();
			var profile = $(this).find(":selected").data("profile");
			$(".profileDescription").html(profile.description);
			$(".serveroid").val(profile.serveroid);
			if (profile.readRevision == true) {
				$(".readRevision").show();
			} else {
				$(".readRevision").hide();
			}
			if (profile.writeRevision == 1) {
				$(".writeRevision").show();
			} else {
				$(".writeRevision").hide();
			}
			if (profile.readExtendedData == true) {
				$(".readExtendedData").show();
			} else {
				$(".readExtendedData").hide();
			}
			if (profile.writeExtendedData == 1) {
				$(".writeExtendedData").show();
			} else {
				$(".writeExtendedData").hide();
			}
		}
	});
	
	$(".saveButton").click(function(){
		$.ajax("addservice.jsp", {
			data: {
				action: "add",
				name: $(".profileName").val(),
				oid: "<%=project.getOid()%>",
				serveroid: $(".profilediv .serveroid").val(),
				description: $(".profileDescription").html(),
				readRevision: $(".readRevision input").is(":checked"),
				readExtendedData: $(".readExtendedData input").is(":checked"),
				writeRevision: $(".writeRevision select").val(),
				writeExtendedData: $(".writeExtendedData select").val()
			}, success: function(){
				$("#servicestab").load("services.jsp?oid=<%=project.getOid()%>");
			}
		});
	});
});
</script>