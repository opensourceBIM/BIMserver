<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SClash"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>

<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.EmfSerializerFactory"%><jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
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
<tr><td>Margin</td><td><input type="text" id="margin" name="margin" value="<%=request.getParameter("margin") != null ? request.getParameter("margin") : defaultClashDetectionSettings.getMargin() %>"/></td></tr>
</table>
<script>
<%=JspHelper.writeDownloadProjectTreeJavaScript(project, loginManager) %>
</script>
<table class="formatted maintable">
	<tr><th>Project</th><th>Last revision</th><th>Revision</th></tr>
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
		if (request.getParameter("ignore") != null) {
			String[] ignoreSplit = request.getParameter("ignore").split(";");
			for (String i : ignoreSplit) {
				ignored.add(i);
			}
		}
	%>
</table>
<div style="height: 220px">
<div style="float: left">
Ignored types<br/>
  <select multiple="multiple" size="10" id="ignored">
<%
if (ignored.size() > 1) {
	for (String i : ignored) {
%>
  <option value="<%=i%>"><%=i %></option>
<%
	}
} else {
%>
  <option value="none">No ignored types</option>
<%
}
%>
  </select>
</div>
<div style="float: left; padding-left: 10px; padding-right: 10px; padding-top: 15px">
  <button id="moveright">&gt;</button><br/>
  <button id="moveleft">&lt;</button>
</div>
<div style="float: left">
Included types<br/>
  <select multiple="multiple" size="10" id="queried">
<%
for (String className : loginManager.getService().getAvailableClasses()) {
	if (!ignored.contains(className)) {
		%><option value="<%=className%>"><%=className%></option><%
	}
}
%>
  </select>
</div>
</div>
  <input type="button" id="findclashesajaxlink" value="Find clashes"/>
</form>
</div>
<div id="findclashesajaxloader">
 Searching for clashes... <img src="images/ajax-loader.gif"/>
</div>
<div id="clashresults">
</div>
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
		var url = "clashes.jsp?action=findclashes&poid=<%=poid%>&margin=" + $("#margin").val() + "&ignored=";
		var ignored = document.getElementById("ignored");
		for (var i=0; i<ignored.options.length; i++) {
			var item = ignored.options[i];
			url += item.value + ";";
		}
		url += "&revisions=";
		var revisionFound = false;
		for (var project in projects) {
			var val = $("#clash_" + projects[project].id).val();
			if (val != "[off]" && val != undefined) {
				url += val + ";";
				revisionFound = true;
			}
		}
		if (!revisionFound) {
			alert("At least one revision must be selected");
		} else {
			$("#findclashesajaxloader").show();
			$("#clashresults").empty();
			$("#clashresults").load(url);
		}
	});
	updateTreeSelectListeners();
});
</script>
<%
}
	if (request.getParameter("action") != null && request.getParameter("action").equals("findclashes")) {
%>		
		  <br/>
<%	
		EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
		float margin = Float.parseFloat(request.getParameter("margin"));
		SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(project.getClashDetectionSettingsId());
		sClashDetectionSettings.setMargin(margin);
		String[] ignoredSplit = request.getParameter("ignored").split(";");
		for (String ignore : ignoredSplit) {
			sClashDetectionSettings.getIgnoredClasses().add(ignore);
		}
		String[] revisions = request.getParameter("revisions").split(";");
		for (String revisionOidString : revisions) {
			sClashDetectionSettings.getRevisions().add(Long.parseLong(revisionOidString));
		}
		List<SClash> clashes = loginManager.getService().findClashes(sClashDetectionSettings);
		if (clashes.isEmpty()) {
			out.println("No clashes found<br/>");
		} else {
			out.println("<table class=\"formatted maintable\">");
			out.println("<tr><th>Guid 1</th><th>Name 1</th><th>Type 1</th><th>Guid 2</th><th>Name 2</th><th>Type 2</th></tr>");
			for (SClash sClash : clashes) {
				out.println("<tr>");
				out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + lastRevision.getOid() + "&guid=" + sClash.getGuid1() + "\">" + sClash.getGuid1() + "</a></td>");
				out.println("<td>" + sClash.getName1() + "</td>");
				out.println("<td>" + sClash.getType1() + "</td>");
				out.println("<td><a href=\"#\" class=\"browserlink\" browserurl=\"browser.jsp?roid=" + lastRevision.getOid() + "&guid=" + sClash.getGuid2() + "\">" + sClash.getGuid2() + "</a></td>");
				out.println("<td>" + sClash.getName2() + "</td>");
				out.println("<td>" + sClash.getType2() + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}
		%>
		  <a href="#" id="emailclasheslink">E-mail clashes</a>
		  <div id="emailclashesform">
			<div id="emailclashesajaxloader">
			E-mailing clash results... <img src="images/ajax-loader.gif"/>
			</div>
		  	<form method="post" action="sendclashesemail.jsp" id="emailclashesform">
		  		Send summary to <input type="text" id="address" name="address"/>
		  		<input type="hidden" id="emailmargin" name="margin" value="<%=request.getParameter("margin") %>"/>
		  		<input type="hidden" id="emailrevisions" name="revisions" value="<%=request.getParameter("revisions") %>"/>
		  		<input type="hidden" id="emailignored" name="ignored" value="<%=request.getParameter("ignored") %>"/>
		  		<input type="submit" name="email" value="Send"/>
		  	</form>
		  </div>
<form action="<%=request.getContextPath() %>/download" method="post">
Download: 
<input type="hidden" name="clashes" value="true" />
<input type="hidden" name="margin" value="<%=request.getParameter("margin") %>" />
<input type="hidden" name="revisions" value="<%=request.getParameter("revisions") %>" />
<input type="hidden" name="ignore" value="<%=request.getParameter("ignore") %>" />
<select name="resultType">
	<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"
		<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
	<%	
	}
%>
</select> <label for="clasheszip_<%=lastRevision.getId() %>">Zip</label><input type="checkbox" name="zip" id="clasheszip_<%=lastRevision.getId() %>" />
		<input name="download" type="submit" value="Download">
	</form>
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
		$("#emailclashesform").load("sendclashesemail.jsp?poid=" + <%=poid%> + "&address=" + $("#address").val() + "&margin=" + $("#emailmargin").val() + "&revisions=" + $("#emailrevisions").val() + "&ignore=" + $("#emailignored").val());
		return false;
	});
	instrumentBrowserLinks();
});
</script>
		<%
	}
%>