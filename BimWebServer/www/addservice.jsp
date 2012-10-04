<%@page import="org.bimserver.interfaces.objects.STrigger"%>
<%@page import="org.bimserver.interfaces.objects.SAccessMethod"%>
<%@page import="org.bimserver.interfaces.objects.SService"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	SProject project = loginManager.getService(request).getProjectByPoid(Long.parseLong(request.getParameter("oid")));
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("add")) {
			SService sService = new SService();
			sService.setDescription(request.getParameter("description"));
			sService.setName(request.getParameter("name"));
			sService.setNotificationProtocol(SAccessMethod.valueOf(request.getParameter("notificationProtocol")));
			sService.setTrigger(STrigger.valueOf(request.getParameter("trigger")));
			sService.setUrl(request.getParameter("url"));
			//sService.setReadExtendedDataId(request.getParameter("readExtendedData));
			sService.setReadRevision(request.getParameter("readRevision") != null);
			sService.setWriteRevisionId(Long.parseLong(request.getParameter("writeRevision")));
			//sService.setWriteExtendedData(request.getParameter("writeExtendedData") != null);
			sService.setUrl(request.getParameter("url"));
			loginManager.getService(request).addServiceToProject(project.getOid(), sService);
		}
	}
%>
<label for="servers">Server </label><select id="servers" name="servers" class="servers">
				<option value="[SELECT]">[Select]</option>
	<optgroup label="Internal"></optgroup>
		<option value="[INTERNAL]">Internal BIMserver</option>
	<optgroup label="External"></optgroup>
<%
	//for (SServerDescriptor externalServer : loginManager.getService(request).getExternalServers()) {
	//	out.println("<option class=\"external\" value=\"" + externalServer.getUrl() + "\">" + externalServer.getTitle() + "</option>");
	//} 
%>
			</select>
			<label class="serviceslabel initialhide" for="services">Service </label>
			<select class="services initialhide" id="services" name="services">
			</select>
			<div class="servicediv initialhide">
				<input type="hidden" class="oid"/>
				<input type="hidden" class="name"/>
				<input type="hidden" class="notificationProtocol"/>
				<input type="hidden" class="trigger"/>
				<input type="hidden" class="url"/>
				<div class="description"></div>
				<div class="readRevision initialhide"><label><span>Read Revision</span><input type="checkbox" disabled="disabled" checked="checked"/></label></div>
				<div class="writeRevision initialhide"><label><span>Write Revision</span><select>
<%
	for (SProject sProject : loginManager.getService(request).getAllProjects(true)) {
%><option value="<%=sProject.getOid()%>"><%=sProject.getName() %></option><%
	}
%>
				</select></label></div>
				<div class="readExtendedData initialhide"><label><span>Read Extended Data</span><input type="checkbox" disabled="disabled" checked="checked"/></label></div>
				<div class="writeExtendedData initialhide"><label><span>Write Extended Data</span><input type="checkbox" disabled="disabled" checked="checked"/></label></div>
				<input type="button" class="saveButton" value="Save"/>
			</div>
<script>
$(function(){
	$(".servers").change(function(){
		var val = $(this).attr("value");
		var selected = $(this).find(":selected");
		if (val == "[SELECT]") {
			$(".services, .serviceslabel, .servicediv").hide();
		} else if (val == "[INTERNAL]") {
			bimServerApi.call("ServiceInterface", "getAllInternalServices", {onlyEnabled: true}, function(data){
				$(".services").empty();
				$(".services").append($("<option value=\"[SELECT]\">[Select]</option>"));
				data.forEach(function(service){
					var option = $("<option value=\"" + service.name + "\">" + service.name + "</option>");
					option.data("service", service);
					$(".services").append(option);
				});
				$(".services, .serviceslabel").show();
			});
		} else {
			bimServerApi.call("ServiceInterface", "getExternalServices", {remoteUrl: val}, function(data){
				$(".services").empty();
				$(".services").append($("<option value=\"[SELECT]\">[Select]</option>"));
				data.forEach(function(service){
					var option = $("<option value=\"" + service.name + "\">" + service.name + "</option>");
					option.data("service", service);
					$(".services").append(option);
				});
				$(".services, .serviceslabel").show();
			});
		}
	});
	
	$(".services").change(function(){
		if ($(this).find(":selected").val() == "[SELECT]") {
			$(".servicediv").hide();
		} else {
			$(".servicediv").show();
			var service = $(this).find(":selected").data("service");
			$(".description").html(service.description);
			$(".notificationProtocol").val(service.notificationProtocol);
			$(".name").val(service.name);
			$(".url").val(service.url);
			$(".trigger").val(service.trigger);
			if (service.readRevision == true) {
				$(".readRevision").show();
			} else {
				$(".readRevision").hide();
			}
			if (service.writeRevision == true) {
				$(".writeRevision").show();
			} else {
				$(".writeRevision").hide();
			}
			if (service.readExtendedData == true) {
				$(".readExtendedData").show();
			} else {
				$(".readExtendedData").hide();
			}
			if (service.writeExtendedData == true) {
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
				name: $(".name").val(),
				url: $(".url").val(),
				oid: "<%=project.getOid()%>",
				notificationProtocol: $(".servicediv .notificationProtocol").val(),
				trigger: $(".servicediv .trigger").val(),
				description: $(".description").html(),
				readRevision: $(".readRevision input").is(":checked"),
				readExtendedData: $(".readExtendedData input").is(":checked"),
				writeRevision: $(".writeRevision select").val(),
				writeExtendedData: $(".writeExtendedData input").is(":checked")
			}, success: function(){
				$("#servicestab").load("services.jsp?poid=<%=project.getOid()%>");
			}
		});
	});
});
</script>