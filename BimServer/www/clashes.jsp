<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SClash"%>
<%@page	import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.interfaces.objects.SEidClash"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@page import="org.bimserver.interfaces.objects.SSerializer"%><jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long poid = Long.parseLong(request.getParameter("poid"));
	SProject project = loginManager.getService().getProjectByPoid(poid);
	SRevision lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
	SClashDetectionSettings defaultClashDetectionSettings = loginManager.getService().getClashDetectionSettings(project.getClashDetectionSettingsId());
	if (request.getParameter("action") == null) {
%>
<div id="clashesinput">
<form>
<table>
	<tr>
		<td>Margin</td>
		<td><input type="text" id="margin" name="margin"
			value="<%=request.getParameter("margin") != null ? request.getParameter("margin") : defaultClashDetectionSettings.getMargin()%>" /></td>
	</tr>
</table>
<script>
<%=JspHelper.writeDownloadProjectTreeJavaScript(project, loginManager)%>
</script>
<table class="formatted maintable">
	<tr>
		<th>Project</th>
		<th>Last revision</th>
		<th>Revision</th>
	</tr>
	<%
		Set<Long> revisions = null;
			if (request.getParameter("revisions") != null) {
				revisions = new HashSet<Long>();
				String[] revisionsSplit = request.getParameter("revisions").split(";");
				for (String r : revisionsSplit) {
					revisions.add(Long.parseLong(r));
				}
			}
			out.write(JspHelper.writeDownloadProjectTree("clash", project, loginManager, 0, revisions));

			Set<String> ignored = new HashSet<String>();
			if (request.getParameter("ignored") != null) {
				String[] ignoreSplit = request.getParameter("ignored").split(";");
				for (String i : ignoreSplit) {
					ignored.add(i);
				}
			}
	%>
</table>
<div style="height: 220px">
<div style="float: left">Ignored types<br />
<select multiple="multiple" size="10" id="ignored">
	<%
		if (ignored.size() > 1) {
				for (String i : ignored) {
	%>
	<option value="<%=i%>"><%=i%></option>
	<%
		}
			} else {
	%>
	<option value="none">No ignored types</option>
	<%
		}
	%>
</select></div>
<div
	style="float: left; padding-left: 10px; padding-right: 10px; padding-top: 15px">
<button id="moveright">&gt;</button>
<br />
<button id="moveleft">&lt;</button>
</div>
<div style="float: left">Included types<br />
<select multiple="multiple" size="10" id="queried">
	<%
		for (String className : loginManager.getService().getAvailableClasses()) {
				if (!ignored.contains(className)) {
	%><option value="<%=className%>"><%=className%></option>
	<%
		}
			}
	%>
</select></div>
</div>
<input type="button" id="findclashesajaxlink" value="Find clashes" /></form>
</div>
<div id="findclashesajaxloader">Searching for clashes... <img
	src="images/ajax-loader.gif" /></div>
<div id="clashresults"></div>
<script>
$(document).ready(function(){
	var toLeft = function(event){
		event.preventDefault();
		var queried = document.getElementById("queried");
		var ignored = document.getElementById("ignored");
		if (ignored.options.length == 1 && ignored.options[0].value == "none") {
			$("#ignored option:eq(0)").remove();
		}
		for (var i=0; i<queried.options.length; i++) {
			if (queried.options[i].selected) {
				var item = queried.options[i];
				$("#ignored").append("<option value='" + item.value + "'>" + item.value + "</option>");
			}
		}
		for (var i=0; i<queried.options.length; i++) {
			if (queried.options[i].selected) {
				var item = queried.options[i];
				$("#queried option:eq(" + i + ")").remove();
				i--;
			}
		}
	};
	var toRight = function(event){
		event.preventDefault();
		var ignored = document.getElementById("ignored");
		for (var i=0; i<ignored.options.length; i++) {
			if (ignored.options[i].selected) {
				var item = ignored.options[i];
				$("#queried").append("<option value='" + item.value + "'>" + item.value + "</option>");
			}
		}
		for (var i=0; i<ignored.options.length; i++) {
			if (ignored.options[i].selected) {
				var item = ignored.options[i];
				$("#ignored option:eq(" + i + ")").remove();
				i--;
			}
		}
		if (ignored.options.length == 0) {
			$("#ignored").append("<option value='none'>No ignored types</option>");
		}
	};
	$("#ignored").dblclick(toRight);
	$("#moveleft").click(toLeft);
	$("#queried").dblclick(toLeft);
	$("#moveright").click(toRight);	
	$("#findclashesajaxloader").hide();
	$("#findclashesajaxlink").click(function(){
		var data = new Object();
		data.action = "findclashes";
		data.poid = <%=poid%>;
		data.margin = $("#margin").val();
//		var url = "clashes.jsp?action=findclashes&poid=<%=poid%>&margin=" + $("#margin").val() + "&ignored=";
		var ignored = document.getElementById("ignored");
		var ignoreString = "";
		for (var i=0; i<ignored.options.length; i++) {
			var item = ignored.options[i];
			ignoreString += item.value + ";";
		}
		data.ignored = ignoreString;
		var revisionsString = "";
//		url += "&revisions=";
		var revisionFound = false;
		for (var project in projects) {
			var val = $("#clash_" + projects[project].id).val();
			if (val != "[off]" && val != undefined) {
				revisionsString += val + ";";
				revisionFound = true;
			}
		}
		data.revisions = revisionsString;
		if (!revisionFound) {
			alert("At least one revision must be selected");
		} else {
			$("#findclashesajaxloader").show();
			$("#clashresults").empty();
			$("#clashresults").load("clashes.jsp", data);
		}
	});
	updateTreeSelectListeners();
});
</script>
<%
	}
	if (request.getParameter("action") != null && request.getParameter("action").equals("findclashes")) {
%>
<br />
<%
		SClashDetectionSettings sClashDetectionSettings = JspHelper.createSClashDetectionSettings(request);
		Map<Long, Long> revisionUsers = new HashMap<Long, Long>();
		Map<Long, String> revisionUserNames = new HashMap<Long, String>();
		List<SEidClash> clashes = loginManager.getService().findClashesByEid(sClashDetectionSettings);
		if (clashes.isEmpty()) {
			out.println("No clashes found<br/>");
		} else {
			out.println("<table class=\"formatted maintable\">");
			out.println("<tr><th>Name</th><th>Type</th><th>User</th><th></th><th>Name</th><th>Type</th><th>User</th></tr>");
			for (SEidClash sClash : clashes) {
				if (!revisionUsers.containsKey(sClash.getRevision1Id())) {
					long uoid = loginManager.getService().getRevision(sClash.getRevision1Id()).getUserId();
					revisionUsers.put(sClash.getRevision1Id(), uoid);
					revisionUserNames.put(sClash.getRevision1Id(), loginManager.getService().getUserByUoid(uoid).getName());
				}
				if (!revisionUsers.containsKey(sClash.getRevision2Id())) {
					long uoid = loginManager.getService().getRevision(sClash.getRevision2Id()).getUserId();
					revisionUsers.put(sClash.getRevision2Id(), uoid);
					revisionUserNames.put(sClash.getRevision2Id(), loginManager.getService().getUserByUoid(uoid).getName());
				}
				out.println("<tr>");
				if (sClash.getName1().equals("")) {
					out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + sClash.getRevision1Id() + "&className=" + sClash.getType1()
							+ "&oid=" + sClash.getEid1() + "\">No name</a></td>");
				} else {
					out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + sClash.getRevision1Id() + "&className=" + sClash.getType1()
						+ "&oid=" + sClash.getEid1() + "\">" + sClash.getName1() + "</a></td>");
				}
				out.println("<td>" + sClash.getType1() + "</td>");
				out.println("<td><a href=\"user.jsp?uoid=" + revisionUsers.get(sClash.getRevision1Id()) + "\">" + revisionUserNames.get(sClash.getRevision1Id())
						+ "</a></td>");
				out.println("<td>&nbsp;&nbsp;&nbsp;</td>");
				if (sClash.getName2().equals("")) {
					out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + sClash.getRevision2Id() + "&className=" + sClash.getType2()
							+ "&oid=" + sClash.getEid2() + "\">No name</a></td>");
				} else {
					out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + sClash.getRevision2Id() + "&className=" + sClash.getType2()
							+ "&oid=" + sClash.getEid2() + "\">" + sClash.getName2() + "</a></td>");
				}
				out.println("<td>" + sClash.getType2() + "</td>");
				out.println("<td><a href=\"user.jsp?uoid=" + revisionUsers.get(sClash.getRevision2Id()) + "\">" + revisionUserNames.get(sClash.getRevision2Id())
						+ "</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
%>
<a href="#" id="emailclasheslink">E-mail clashes</a>
<div id="emailclashesform">
<div id="emailclashesajaxloader">E-mailing clash results... <img
	src="images/ajax-loader.gif" /></div>
<form method="post" action="sendclashesemail.jsp" id="emailclashesform">
Send summary to <input type="text" id="address" name="address" /> <input
	type="hidden" id="emailmargin" name="margin"
	value="<%=request.getParameter("margin")%>" /> <input type="hidden"
	id="emailrevisions" name="revisions"
	value="<%=request.getParameter("revisions")%>" /><input type="hidden" name="poid" value="<%=poid %>"/> <input type="hidden"
	id="emailignored" name="ignored"
	value="<%=request.getParameter("ignored")%>" /> <input type="submit"
	name="email" value="Send" /></form>
</div>
<br />
<br />
<form action="<%=request.getContextPath()%>/download" method="post">
Download: <input type="hidden" name="clashes" value="true" /> <input
	type="hidden" name="margin" value="<%=request.getParameter("margin")%>" />
<input type="hidden" name="revisions"
	value="<%=request.getParameter("revisions")%>" /> <input type="hidden"
	name="ignored" value="<%=request.getParameter("ignored")%>" /> <select
	name="resultType">
	<%
		for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
	%>
	<option value="<%=serializer.getName()%>"
		<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
		}
	%>
</select> <label for="clasheszip_<%=lastRevision.getId()%>">Zip</label> <input type="checkbox" name="zip" id="clasheszip_<%=lastRevision.getId()%>" />
<input name="download" type="submit" value="Download"></form>
<script>
$(document).ready(function(){
	$("#findclashesajaxloader").hide();
	$("#emailclashesform").hide();
	$("#emailclashesajaxloader").hide();
	$("#emailclasheslink").click(function(){
		$("#emailclasheslink").hide();
		$("#emailclashesform").show();
		$("#address").focus();
		return false;
	});
	$("#downloadclashes").click(function(){		
		return false;
	});
	$("#emailclashesform").submit(function(){
		$("#emailclashesajaxloader").show();
		var data = new Object();
		data.poid = <%=poid%>;
		data.address = $("#address").val();
		data.margin = $("#emailmargin").val();
		data.revisions = $("#emailrevisions").val();
		data.ignored = $("#emailignored").val();
		$("#emailclashesform").load("sendclashesemail.jsp", data);
		return false;
	});
	instrumentBrowserLinks();
});
</script>
<%
	}
%>