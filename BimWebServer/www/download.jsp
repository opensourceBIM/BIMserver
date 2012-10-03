<%@page import="java.net.URLDecoder"%>
<%@page import="com.google.common.base.Charsets"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.codehaus.jettison.json.JSONTokener"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="java.util.Set"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%@page import="org.bimwebserver.jsp.LoginManager"%>
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
		revision = loginManager.getService(request).getRevision(roid);
		Set<String> checkoutWarnings = loginManager.getService(request).getCheckoutWarnings(revision.getProjectId());
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
	boolean userHasCheckinRights = poid == -1 || loginManager.getService(request).userHasCheckinRights(loginManager.getUoid(), poid);
%>
<div class="message"></div>
<div class="progressbar"></div>
<div class="fields">
<table>
<tr><td><label for="serializerOid">Serializer</label></td>
<td><select name="serializerOid" class="revisionsdownloadcheckoutselect">
<%
	for (SSerializerPluginConfiguration serializer : loginManager.getService(request).getAllSerializers(true)) {
	%>
	<option value="<%=serializer.getOid()%>"
		<%=loginManager.getService(request).getDefaultSerializer() != null && loginManager.getService(request).getDefaultSerializer().getOid() == serializer.getOid() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
	}
	%>
</select>
<label for="downloadCheckoutZip">Zip </label><input id="downloadCheckoutZip" type="checkbox" name="zip">
</td></tr>
</table>
<div class="resultsarea"></div>
<div class="buttons">
<input type="button" class="downloadButton" value="Download"/>
<input type="button" class="downloadTextButton" value="Download (text)"/>
<input type="button" class="checkoutButton" value="Checkout"/>
</div>
</div>
</div>
<script>
var userHasCheckinRights = <%=userHasCheckinRights%>;
var json = Base64.decode('<%=new String(Base64.encodeBase64(data.toString().getBytes(Charsets.UTF_8)), Charsets.UTF_8)%>');
var data = JSON.parse(json);
var mimeTypeOverride = null;

function checkRevisionsCheckoutButton(event) {
	if (!data.allowCheckouts) {
		$(".checkoutButton").hide();
		return;
	}
	var el = $(".downloadpopup .revisionsdownloadcheckoutselect");
	var val = el.val();
	var text = el.find(":selected").text();
	if ((text != "Ifc2x3" && text != "IfcXML") || !userHasCheckinRights) {
		$(".downloadpopup .checkoutButton").button("disable");
	} else {
		$(".downloadpopup .checkoutButton").button("enable");
	}
	if (!userHasCheckinRights) {
		$(".checkoutMessage").html("Checkout unavailable because you have no rights on the project");
	} else if (text != "Ifc2x3" && text != "IfcXML") {
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
				if (data.errors.length > 0) {
					$(".downloadpopup .fields, .downloadpopup .checkoutMessage").show();
					$(".downloadpopup .progressbar").hide();
					data.errors.map(function(error){
						$(".downloadpopup .resultsarea").append(error + "<br/>");
					});
					$(".downloadpopup .message").html("");
				} else if (data.state == "FINISHED") {
					if (data.warnings.length > 0) {
						data.warnings.map(function(warning){
							$(".downloadpopup .resultsarea").append(warning + "<br/>");
						});
					}
					$(".downloadpopup .progressbar").hide();
					$(".downloadpopup .fields, .downloadpopup .checkoutMessage").show();
					var zip = $("#downloadCheckoutZip").attr('checked') == undefined ? "" : "&zip=on";
					var serializerOid = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
					var url = "<%=request.getContextPath()%>/download?longActionId=" + laid + zip + "&serializerOid=" + serializerOid;
					if (mimeTypeOverride != null) {
						url += "&mime=" + mimeTypeOverride;
						window.open(url);
					} else {
						window.location = url;
					}
					$(".downloadpopup .message").html("Prepare complete, initiating download, click <a href=\"" + url + "\">here</a> if the download does not start automatically<br/><br/>");
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

function start(url, data) {
	$(".downloadpopup .message").html("Preparing download...");
	$(".downloadpopup .progressbar").show();
	$(".downloadpopup .fields").hide();
	$(".downloadpopup .checkoutMessage").hide();
	$.ajax({
		url: url,
		cache: false,
		data: {data: JSON.stringify(data)},
		context: document.body,
		type: "post",
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
	data.serializerOid = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	mimeTypeOverride = null;
	data.downloadType = "checkout";
	start('initiatedownload.jsp', data);
}

function initDownload() {
	data.serializerOid = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	console.log(data.serializerOid);
	mimeTypeOverride = null;
	start('initiatedownload.jsp', data);
}

function initTextDownload() {
	data.serializerOid = $(".downloadpopup .revisionsdownloadcheckoutselect").val();
	mimeTypeOverride = "text/plain";
	start('initiatedownload.jsp', data);
}

$(function(){
	$(".downloadpopup .revisionsdownloadcheckoutselect").change(checkRevisionsCheckoutButton);
	$(".downloadpopup .downloadButton").click(initDownload);
	$(".downloadpopup .downloadTextButton").click(initTextDownload);
	$(".downloadpopup .checkoutButton").click(initCheckout);

	$("#downloadCheckoutZip").change(function(){
		if ($(this).is(":checked")) {
			$(".downloadpopup .downloadTextButton").button("disable");
		} else {
			$(".downloadpopup .downloadTextButton").button("enable");
		}	
	});
	
	$(".downloadpopup input[type=\"button\"]").button();
	checkRevisionsCheckoutButton();
});
</script>