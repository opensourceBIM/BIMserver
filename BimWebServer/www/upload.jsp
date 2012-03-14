<%@page import="org.bimserver.shared.comparators.SRevisionIdComparator"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SDeserializer"%>
<%@page import="org.bimserver.web.LoginManager"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long poid = Long.parseLong(request.getParameter("poid"));
	SProject sProject = loginManager.getService().getProjectByPoid(poid);
%>
<a href="#" id="uploadlink">Upload (note: Subprojects present)</a>
<div id="upload">
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
<tr><td><label for="comment">Comment</label></td><td><textarea id="comment" name="comment" cols="57" rows="4"></textarea></td></tr>
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
<a href="#" id="uploadbranchlink">Checkin existing revision</a>
<div id="uploadbranch">
	<%
		List<SProject> projects = loginManager.getService().getAllReadableProjects();
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
		<fieldset>
			<legend>Checkin existing revision</legend>
			<label>Project/Revision</label> <select name="roid">
				<%
					for (SProject p : projects) {
											if (!p.getRevisions().isEmpty()) {
				%>
				<optgroup label="<%=p.getName()%>">
					<%
						List<SRevision> checkinRevisions = loginManager.getService().getAllRevisionsOfProject(sProject.getOid());
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
		</fieldset>
	</form>
	<%
		}
	}
	%>
</div>
</div>
<script>
	var lastVal = "";

	$(document).ready(function(){
		$("#uploadajaxloader").hide();

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
						if (data.status == "CH_FINISHED") {
							location.reload(true);
						} else if (data.status == "CH_STARTED" || data.status == "CH_NONE") {
							window.setTimeout(refreshFunction, 500);
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
			replaceFileInput: false,
			submit: function(e, data){
				if (!shouldsend) {
					shouldsend = false;
			        submitdata = data;
			        $("#uploadButton").show();
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
					$("#uploadButton").show();
				}
			},
			fail: function(e, data) {
				$("#uploadStatus").html("Error: " + data.textStatus);
				$("#uploadTable").show();
				$("#uploadProgressBar").hide();
				$("#uploadButton").show();
			},
			always: function() {
			}
	    });

		$("#uploadButton").click(function(event){
			shouldsend = true;
			submitdata.formData = {
				deserializerName: $("#deserializerName").val(),
				comment: $("#comment").val(),
				merge: $("#merge").is(':checked'),
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

		$("#uploadbranch").hide();
		$("#uploadbranchlink").click(function(event){
			event.preventDefault();
			$("#uploadbranch").show();
			$("#uploadbranchlink").hide();
		});
		
		$("#uploadButton").hide();
		<%if (!loginManager.getService().getSubProjects(poid).isEmpty()) {%>
		$("#uploadlink").show();
		$("#uploadlink").click(function(){
			$("#upload").show();
			$("#uploadlink").hide();
		});
		$("#upload").hide();
		<%} else {%>
		$("#upload").show();
		$("#uploadlink").hide();
		<%}%>
	
	});
</script>