<%@page import="org.codehaus.jettison.json.JSONTokener"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="java.util.Set"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%@page import="org.bimserver.web.LoginManager"%>
<div class="downloadpopup">
<div class="checkoutMessage"></div>
<%
	long roid = -1;
	JSONObject data = new JSONObject(new JSONTokener(request.getParameter("data")));
	if (data.has("roid")) {
		roid = data.getLong("roid");
	}
	SRevision revision = null;
	if (roid != -1) {
		revision = loginManager.getService().getRevision(roid);
		Set<String> checkoutWarnings = loginManager.getService().getCheckoutWarnings(revision.getProjectId());
		for (String warning : checkoutWarnings) {
			out.write("<div class=\"warning\"><img src=\"images/warning.png\" alt=\"warning\" />" + warning + "</div>");
		}
	}
	long poid = -1;
	if (revision != null) {
		poid = revision.getProjectId();
	}
	if (request.getParameter("poid") != null && data.has("poid")) {
		poid = data.getLong("poid");
	}
	boolean userHasCheckinRights = poid == -1 || loginManager.getService().userHasCheckinRights(poid);
%>
<div class="message"></div>
<div class="progressbar"></div>
<div class="fields">
<table>
<tr><td><label for="serializerName">Serializer</label></td>
<td><select name="serializerName" class="revisionsdownloadcheckoutselect">
<%
	for (SSerializer serializer : loginManager.getService().getAllSerializers(true)) {
	%>
	<option value="<%=serializer.getName()%>"
		<%=serializer.getDefaultSerializer() != null && serializer.getDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
	}
	%>
</select>
<label for="downloadCheckoutZip">Zip </label><input id="downloadCheckoutZip" type="checkbox" name="zip">
</td></tr>
</table>
<input type="button" class="downloadButton" value="Download"/>
<input type="button" class="checkoutButton" value="Checkout"/>
</div>
</div>
<script>
var userHasCheckinRights = <%=userHasCheckinRights%>;
var data = eval('(<%=data%>)');

function checkRevisionsCheckoutButton(event) {
	if (!data.allowCheckouts) {
		$(".checkoutButton").hide();
		return;
	}
	var val = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	$(".downloadpopup .checkoutButton").attr("disabled", (val != "Ifc2x3" && val != "IfcXML") || !userHasCheckinRights);
	if (!userHasCheckinRights) {
		$(".checkoutMessage").html("Checkout unavailable because you have no rights on the project");
	} else if (val != "Ifc2x3" && val != "IfcXML") {
		$(".checkoutMessage").html("Checkout unavailable for formats other than Ifc2x3 and IfcXML");
	} else {
		$(".checkoutMessage").html("");
	}
}

var laid;

function update() {
	$.ajax({
		url: "downloadprogress.jsp?laid=" + laid,
		cache: false,
		context: document.body,
		type: "get",
		dataType: "json",
		success: function(data){
			if (data.error == null) {
				$(".downloadpopup .progressbar").progressbar({value: data.progress});
				if (data.state == "FINISHED") {
					$(".downloadpopup .progressbar").hide();
					$(".downloadpopup .fields, .downloadpopup .checkoutMessage").show();
					var zip = $("#downloadCheckoutZip").attr('checked') == undefined ? "" : "&zip=on";
					var serializerName = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
					var url = "<%=request.getContextPath()%>/download?longActionId=" + laid + zip + "&serializerName=" + serializerName;
					$(".downloadpopup .message").html("Prepare complete, initiating download, click <a href=\"" + url + "\">here</a> if the download does not start automatically<br/><br/>");
					window.location = url;
				} else {
					setTimeout(update, 500);
				}
			} else {
				$(".downloadpopup .fields, .downloadpopup .checkoutMessage").show();
				$(".downloadpopup .message").html("Error: " + data.error);
			}
		}, error: function(jqXHR, textStatus, errorThrown) {
			$(".downloadpopup .fields, .downloadpopup .checkoutMessage").show();
			$(".downloadpopup .message").html("Error: " + textStatus);
		}
	});
}

function start(url) {
	$(".downloadpopup .message").html("Preparing download...");
	$(".downloadpopup .progressbar").show();
	$(".downloadpopup .fields").hide();
	$(".downloadpopup .checkoutMessage").hide();
	$.ajax({
		url: url,
		cache: false,
		context: document.body,
		type: "get",
		dataType: "json",
		success: function(data){
			if (data.error == null) {
				$(".downloadpopup .message").html("Preparing download");
				laid = data.laid;
				update();
			} else {
				$(".downloadpopup .message").html("Error: " + data.error);
			}
		}, error: function(jqXHR, textStatus, errorThrown) {
			$(".downloadpopup .message").html("Error: " + textStatus);
			$(".downloadpopup .checkoutMessage").show();
		}
	});
}

function initCheckout() {
	data.serializerName = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	data.downloadType = "checkout";
	var url = 'initiatedownload.jsp?data=' + JSON.stringify(data);
	start(url);
}

function initDownload() {
	data.serializerName = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	var url = 'initiatedownload.jsp?data=' + JSON.stringify(data);
	start(url);
}

$(function(){
	$(".downloadpopup .revisionsdownloadcheckoutselect").change(checkRevisionsCheckoutButton);
	$(".downloadpopup .downloadButton").click(initDownload);
	$(".downloadpopup .checkoutButton").click(initCheckout);

	checkRevisionsCheckoutButton();
});
</script>