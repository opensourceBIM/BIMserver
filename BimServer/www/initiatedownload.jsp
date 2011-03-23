<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<jsp:useBean id="loginManager" scope="session"
	class="org.bimserver.web.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	ResultType resultType = ResultType.IFC;
	if (request.getParameter("resultType") != null) {
		resultType = ResultType.valueOf(request
				.getParameter("resultType"));
	}
	String zip = request.getParameter("zip");
	String longActionId = null;
	if (request.getParameter("checkout") != null) {
		longActionId = loginManager.getService().checkout(roid,
				resultType, false);
	} else if (request.getParameter("download") != null) {
		if (request.getParameter("guids") != null){
			Set<String> guids = new HashSet<String>();
			for (String guid : request.getParameter("guids").split(";")) {
				guids.add(guid);
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByGuids(roids, guids, resultType, false);
		} else if (request.getParameter("oids") != null) {
			Set<Long> oids = new HashSet<Long>();
			for (String oidString : request.getParameter("oids").split(";")) {
				oids.add(Long.parseLong(oidString));
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByOids(roids, oids, resultType, false);
		} else if (request.getParameter("class") != null){
			longActionId = loginManager.getService().downloadOfType(roid, request.getParameter("class"), resultType, false);
		}
		else {
			longActionId = loginManager.getService().download(roid, resultType, false);
		}
	}
%>

<jsp:include page="downloadprogress.jsp">
	<jsp:param name="longActionId" value="<%=longActionId %>" />
</jsp:include>

<script>
var downloadUpdateFunctionHandle;

var downloadUpdateFunction = function() {
	$.ajax({
		url: "downloadprogress.jsp",
		cache: false,
		context: document.body,
		success: 
			function(data){
				$("#downloadStateSpan").html(data);
			},
		data: {	longActionId: '<%=longActionId%>' ;
				zip: '<%=zip%>'
			}
		});
	};

	$(document).ready(
			function() {
				downloadUpdateFunctionHandle = window.setInterval(
						downloadUpdateFunction, 1000);
			});
</script>
