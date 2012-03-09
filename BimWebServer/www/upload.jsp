<%@ page contentType="text/html; charset=UTF-8" %>
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
<div id="uploadStatus"></div>
<div id="uploadProgressBar"></div>
<table id="uploadTable">
<tr><td><label for="file">File</label></td><td><input id="fileupload" type="file" name="data"/></td></tr>
<tr><td><label for="deserializerName">Deserializer</label></td><td><select id="deserializerName" name="deserializerName">
<%
	for (SDeserializer deserializer : loginManager.getService().getAllDeserializers(true)) {
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
<input id="poid" type="hidden" name="poid" value="<%=poid %>"/>
<input id="uploadButton" type="button" name="upload" value="Upload"/>
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

		var submitdata = null;
		var shouldsend = false;
		var currentCheckinId = null;

		var refreshFunction = function() {
			$.ajax({
				url: "progress",
				cache: false,
				context: document.body,
				type: "post",
				dataType: "json",
				data: {checkinid: currentCheckinId},
				success: function(data){
					if (data.error == null) {
						$("#uploadProgressBar").progressbar({value: parseInt(data.progress, 10)});
						if (data.status == "FINISHED") {
							location.reload(true);
						} else if (data.status == "STARTED" || data.status == "NONE") {
							window.setTimeout(refreshFunction, 1000);
						}
					} else {
						$("#uploadStatus").html("Error: " + data.error);
					}
				}, error: function(jqXHR, textStatus, errorThrown) {
					$("#uploadStatus").html("Error: " + textStatus);
				}
			});
		};
		
		$("#fileupload").fileupload({
			dataType: "json",
	        url: '/upload',
			submit: function(e, data){
				if (!shouldsend) {
					shouldsend = false;
			        submitdata = data;
			        $("#uploadButton").show();
			        return false;
				}
	        },
			progress: function(e, data) {
				$("#uploadProgressBar").progressbar({value: parseInt(data.loaded / data.total * 100, 10)});
				if (data.loaded == data.total) {
					$("#uploadStatus").html("Done uploading file...");
				}
			},
			done: function(e, data) {
				if (data.result.error == null) {
					$("#uploadStatus").html("Processing file...");
					$("#uploadProgressBar").progressbar({value: 0});
					currentCheckinId = data.result.checkinid;
					refreshFunction();
				} else {
					$("#uploadStatus").html("Error: " + data.result.error);
					$("#uploadTable").show();
					$("#uploadProgressBar").hide();
				}
			},
			fail: function(e, data) {
				$("#uploadStatus").html("Error: " + data.textStatus);
				$("#uploadTable").show();
				$("#uploadProgressBar").hide();
			},
			always: function() {
			}
	    });

		$("#uploadButton").click(function(event){
			shouldsend = true;
			submitdata.formData = {
				deserializerName: $("#deserializerName").val(),
				comment: $("#comment").val(),
				merge: $("#merge").val(),
				poid: $("#poid").val()
			};
			$("#uploadTable").hide();
			$("#uploadStatus").show();
			$("#uploadButton").hide();
			$("#uploadProgressBar").show();
			$("#uploadStatus").html("Uploading file...");
			$("#fileupload").fileupload('send', submitdata);
			event.preventDefault();
		});
		$("#uploadButton").hide();
	});
</script>