<%@page import="org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"%>
<%@page import="java.util.Set"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.comparators.SRevisionIdComparator"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimwebserver.jsp.LoginManager"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	long poid = Long.parseLong(request.getParameter("poid"));
	SProject sProject = loginManager.getService(request).getProjectByPoid(poid);
%>
<a href="#" id="uploadlink">This project has subprojects, click here if you still want to checkin a new revision</a>
<div id="uploads">
<%
	Set<String> checkoutWarnings = loginManager.getService(request).getCheckinWarnings(poid);
	for (String warning : checkoutWarnings) {
		out.write("<div class=\"warning\"><img src=\"images/warning.png\" alt=\"warning\" /><div>" + warning + "</div></div>");
	}
%>
<div id="upload">
<div id="uploadStatus"></div>
<div id="uploadProgressBar"></div>
<table id="uploadTable">
<tr><td><label for="file">File</label></td><td><input id="fileupload" type="file" name="data"/></td></tr>
<tr><td><label for="deserializerOid">Deserializer</label></td><td><select id="deserializerOid" name="deserializerOid">
<option value="[NONE]">Select a deserializer</option>
<%
	for (SDeserializerPluginConfiguration deserializer : loginManager.getService(request).getAllDeserializers(true)) {
		out.println("<option value=\"" + deserializer.getOid() + "\">" + deserializer.getName() + "</option>");
	}
%>
</select></td></tr>
<tr><td><label for="comment">Comment</label></td><td><textarea id="comment" name="comment" cols="57" rows="4"></textarea></td></tr>
<%
	if (loginManager.getService(request).isSettingCheckinMergingEnabled() && sProject.getRevisions().size() > 0) {
%>
<tr><td><label for="merge">Merge</label></td><td><input id="merge" name="merge" type="checkbox"/></td></tr>
<%
	}
%>
</table>
<input id="poid" type="hidden" name="poid" value="<%=poid %>"/>
<input id="uploadButton" type="button" name="upload" value="Upload"/><br/>
</div>
<div id="uploadbranch">
	<%
		List<SProject> projects = loginManager.getService(request).getAllReadableProjects();
		Collections.sort(projects, new SProjectNameComparator());
		if (!projects.isEmpty() && (projects.size() > 1 || !projects.get(0).getRevisions().isEmpty())) {
			boolean atLeastOne = false;
			for (SProject p : projects) {
				if (!p.getRevisions().isEmpty()) {
					atLeastOne = true;
					break;
				}
			}
			if (atLeastOne) {
	%>
	<form method="post" action="branch.jsp">
		<label>Project/Revision</label> <select name="roid">
			<%
				for (SProject p : projects) {
					if (!p.getRevisions().isEmpty()) {
			%>
			<optgroup label="<%=p.getName()%>">
				<%
					List<SRevision> checkinRevisions = loginManager.getService(request).getAllRevisionsOfProject(p.getOid());
												Collections.sort(checkinRevisions, new SRevisionIdComparator(false));
												for (SRevision sRevision : checkinRevisions) {
				%>
				<option value="<%=sRevision.getOid()%>"><%=sRevision.getId()%></option>
				<%
					}
				%>
			</optgroup>
			<%
				}
			}
			%>
		</select> <label>Comment</label> <input type="text" name="comment" /> <input
			type="submit" value="Checkin as new revision" /> <input
			type="hidden" name="action" value="branchtoexistingproject" /> <input
			type="hidden" name="destpoid" value="<%=poid%>" />
	</form>
	<br/>
	<%
		}
	}
	%>
</div>
<a href="#" id="showuploadlink" class="initialhide">OR Checkin new revision</a>
<a href="#" id="uploadbranchlink">OR Checkin existing revision</a>
</div>
<script>
	var lastVal = "";

	function hideUpload() {
		$("#uploadbranchlink").hide();			
		$("#uploadTable").hide();
		$("#uploadProgressBar").show();
		$("#uploadButton").hide();
		$("#uploadStatus").show();
	}

	function showUpload() {
		$("#uploadbranchlink").show();			
		$("#uploadTable").show();
		$("#uploadProgressBar").hide();
		$("#uploadButton").show();
	}
	
	$(function(){
		$("#uploadajaxloader").hide();

		var submitdata = null;
		var shouldsend = false;
		var currentCheckinId = null;
		var fileselected = false;

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
						if (data.status == "CH_ERROR") {
							$("#uploadStatus").html("Error: " + data.lastError);
							showUpload();
						} else {
							$("#uploadProgressBar").progressbar({value: parseInt(data.progress, 10)});
							if (data.status == "CH_FINISHED") {
								location.reload(true);
							} else if (data.status == "CH_STARTED" || data.status == "CH_NONE") {
								window.setTimeout(refreshFunction, 500);
							}
						}
					} else {
						$("#uploadStatus").html("Error: " + data.error);
						showUpload();
					}
				}, error: function(jqXHR, textStatus, errorThrown) {
					$("#uploadStatus").html("Error: " + textStatus);
				}
			});
		};
		
		function updateSubmitButton() {
	        if ($("#deserializerOid").val() != "[NONE]" && fileselected) {
		        $("#uploadButton").show();
	        } else {
		        $("#uploadButton").hide();
	        }
		}
		
		$("#deserializerOid").change(updateSubmitButton);
		
		$("#fileupload").fileupload({
			dataType: "json",
	        url: '<%=request.getContextPath()%>/upload',
			replaceFileInput: false,
			submit: function(e, data){
				if (!shouldsend) {
					shouldsend = false;
			        submitdata = data;
			        updateSubmitButton();
					if ($("#comment").attr("value") == "" || $("#comment").attr("value") == lastVal) {
						var path = null;
						$.each(data.files, function (index, file) {
							path = file.name;
					    });
						if (path.indexOf("/") != -1) {
							path = path.substr(path.lastIndexOf("/") + 1);
						} else if (path.indexOf("\\") != -1) {
							path = path.substr(path.lastIndexOf("\\") + 1);
						}
						$("#comment").attr("value", path);
						lastVal = path;
					}
			        return false;
				}
	        },
	        change: function(e, data) {
	        	fileselected = true;
	        	var path = null;
				$.each(data.files, function (index, file) {
					path = file.name;
			    });
			    var lastIndex = path.lastIndexOf(".");
			    if (lastIndex != -1) {
				    var extension = path.substring(path.lastIndexOf(".") + 1);
					$.ajax({
						url: "getbestdeserializer.jsp?extension=" + extension,
						cache: false,
						context: document.body,
						success: function(data){
							if (data.error == null) {
								$("#deserializerOid").val(data.trim());
								updateSubmitButton();
							} else {
								$("#uploadStatus").html("Error: " + data.error);
								showUpload();
							}
						}, error: function(jqXHR, textStatus, errorThrown) {
							$("#uploadStatus").html("Error: " + textStatus);
						}
					});
			    }
	        },
			progress: function(e, data) {
				$("#uploadProgressBar").progressbar({value: parseInt(data.loaded / data.total * 100, 10)});
				if (data.loaded == data.total) {
					$("#uploadStatus").html("Processing file...");
					$("#uploadProgressBar").progressbar({value: 0});
				}
			},
			done: function(e, data) {
				if (data.result.error == null) {
					currentCheckinId = data.result.checkinid;
					refreshFunction();
				} else {
					$("#uploadStatus").html("Error: " + data.result.error);
					showUpload();
				}
			},
			fail: function(e, data) {
				$("#uploadStatus").html("Error: " + data.textStatus);
				showUpload();
			}
	    });

		$("#uploadButton").click(function(event){
			shouldsend = true;
			submitdata.formData = {
				deserializerOid: $("#deserializerOid").val(),
				comment: $("#comment").val(),
				merge: $("#merge").is(':checked'),
				poid: $("#poid").val()
			};
			hideUpload();
			$("#uploadStatus").html("Uploading file...");
			$("#fileupload").fileupload('send', submitdata);
			shouldsend = false;
			event.preventDefault();
		});

		$("#uploadbranch").hide();
		$("#uploadbranchlink").click(function(event){
			event.preventDefault();
			$("#upload").hide();
			$("#showuploadlink").show();
			$("#uploadbranch").show();
			$("#uploadbranchlink").hide();
			$("#checkinpopup").dialog("option", "title", "Checkin existing revision");
		});
		$("#showuploadlink").hide();
		$("#showuploadlink").click(function(event){
			event.preventDefault();
			$("#upload").show();
			$("#showuploadlink").hide();
			$("#uploadbranch").hide();
			$("#uploadbranchlink").show();
			$("#checkinpopup").dialog("option", "title", "Checkin new revision");
		});
		
		$("#uploadButton").hide();
		<%if (!loginManager.getService(request).getSubProjects(poid).isEmpty()) {%>
		$("#uploadlink").show();
		$("#uploadlink").click(function(){
			$("#uploads").show();
			$("#uploadlink").hide();
		});
		$("#uploads").hide();
		<%} else {%>
		$("#uploads").show();
		$("#uploadlink").hide();
		<%}%>
	});
</script>