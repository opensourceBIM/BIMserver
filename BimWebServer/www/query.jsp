<%@page import="org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	SRevision revision = loginManager.getService(request).getRevision(roid);
	List<String> classes = loginManager.getService(request).getAvailableClasses();
	Collections.sort(classes);
%>
<div class="tabber" id="querytab">
<div class="tabbertab" title="Simple" id="simple">
<table>
<tr class="downloadframe">
	<td width="120">Object ID</td>
	<td width="320">
		<input type="text" name="oids" id="oids"/>
	</td>
	<td>
		<a href="#" id="queryoidsbutton" value="">Download</a>
	</td>
	<td>
		<input type="hidden" name="roid" value="<%=roid %>"/>
	</td>
	<td>
		<div class="downloadResult" style="display: none"></div>
	</td>
</tr>
</table>

<table>
<tr class="downloadframe">
	<td width="120">Globally Unique ID</td>
	<td width="320">
		<input type="text" name="guids" id="guids"/>
	</td>
	<td>
		<a href="#" id="queryguidsbutton">Download</a>
	</td>
	<td> 
		<input type="hidden" name="roid" value="<%=roid %>"/>
	</td>
	<td>
		<div class="downloadResult" style="display: none"></div>
	</td>
</tr>
</table>

<!--  <form action="<%=request.getContextPath() %>/download" method="get"> -->
<table>
<tr class="downloadframe">
	<td width="120">IFC Class</td>
	<td width="320">
		<select name="class" id="cid">
<%
	for (String className : classes) {
%>
		<option value="<%=className%>"><%=className %></option>
<%
	}
%>
		</select>
	</td>
	<td>
		<a href="#" id="queryclassesbutton">Download</a>
	</td>
	<td>
		<input type="hidden" name="roid" value="<%=roid %>"/>
	</td>
	<td>
		<div class="downloadResult" style="display: none"></div>
	</td>
</tr>
</table>
<!-- </form> -->

</div>
<%
		for (SQueryEnginePluginConfiguration queryEngine : loginManager.getService(request).getAllQueryEngines(true)) {
%>
<div class="tabbertab" title="<%=queryEngine.getName()%>" id="<%=queryEngine.getOid() %>">
Examples: <%
	for (String key : loginManager.getService(request).getQueryEngineExampleKeys(queryEngine.getOid())) {
%><a href="#" qeid="<%=queryEngine.getOid() %>" key="<%=key%>" class="examplebutton"><%=key%></a> <%
	}
%>
<textarea cols="93" rows="25" class="code">
</textarea>
<div style="float: right">
	<span class="ajaxloader">
	<span class="ajaxloadertext"></span> <img src="images/ajax-loader.gif"/>
	</span>
	<button class="downloadbutton" qeid="<%=queryEngine.getOid()%>">Download</button>
</div>
</div>
<%
		}
%>
<script>
	$(function(){
		$(".examplebutton").click(function(event){
			event.preventDefault();
			$.ajax({
				url: 'getqueryexample.jsp?key=' + $(event.target).attr("key") + '&qeid=' + $(event.target).attr("qeid"),
				context: $(this).parent(),
				success: function(data) {
					$(this).find(".code").val(data);
				}
			});
		});
		$(".ajaxloader").hide();
		
		function success(data) {
			$(this).find(".ajaxloader").hide();
			$(this).find(".console").val("");
			if (data.compileErrors != null && data.compileErrors.length > 0) {
				$(this).find(".console").addClass("compile_error");
				for (var i=0; i<data.compileErrors.length; i++) {
					$(this).find(".console").val(data.compileErrors[i]);
				}
			} else {
				if (data.output != null) {
					$(this).find(".console").removeClass("compile_error");
					$(this).find(".console").val(data.output);
				}
			}
		}
		
		$(".downloadbutton").click(function(){
			var params = {
				downloadType: "query",
				qeid: $(this).attr("qeid"),
				code: $(this).parent().parent().find(".code").val(),
				poid: "<%=revision.getProjectId()%>",
				roid: <%=roid%>
			};
			showDownloadCheckoutPopup(params);
		});
		
		$("textarea").keydown(checkTab);
		 
		// Set desired tab- defaults to four space softtab
		var tab = "    ";
		       
		function checkTab(evt) {
		    var t = evt.target;
		    var ss = t.selectionStart;
		    var se = t.selectionEnd;
		 
		    // Tab key - insert tab expansion
		    if (evt.keyCode == 9) {
		        evt.preventDefault();
		               
		        // Special case of multi line selection
		        if (ss != se && t.value.slice(ss,se).indexOf("\n") != -1) {
		            // In case selection was not of entire lines (e.g. selection begins in the middle of a line)
		            // we ought to tab at the beginning as well as at the start of every following line.
		            var pre = t.value.slice(0,ss);
		            var sel = t.value.slice(ss,se).replace(/\n/g,"\n"+tab);
		            var post = t.value.slice(se,t.value.length);
		            t.value = pre.concat(tab).concat(sel).concat(post);
		                   
		            t.selectionStart = ss + tab.length;
		            t.selectionEnd = se + tab.length;
		        }
		               
		        // "Normal" case (no selection or selection on one line only)
		        else {
		            t.value = t.value.slice(0,ss).concat(tab).concat(t.value.slice(ss,t.value.length));
		            if (ss == se) {
		                t.selectionStart = t.selectionEnd = ss + tab.length;
		            }
		            else {
		                t.selectionStart = ss + tab.length;
		                t.selectionEnd = se + tab.length;
		            }
		        }
		    }
		           
		    // Backspace key - delete preceding tab expansion, if exists
		   else if (evt.keyCode==8 && t.value.slice(ss - 4,ss) == tab) {
		        evt.preventDefault();
		               
		        t.value = t.value.slice(0,ss - 4).concat(t.value.slice(ss,t.value.length));
		        t.selectionStart = t.selectionEnd = ss - tab.length;
		    }
		           
		    // Delete key - delete following tab expansion, if exists
		    else if (evt.keyCode==46 && t.value.slice(se,se + 4) == tab) {
		        evt.preventDefault();
		             
		        t.value = t.value.slice(0,ss).concat(t.value.slice(ss + 4,t.value.length));
		        t.selectionStart = t.selectionEnd = ss;
		    }
		    // Left/right arrow keys - move across the tab in one go
		    else if (evt.keyCode == 37 && t.value.slice(ss - 4,ss) == tab) {
		        evt.preventDefault();
		        t.selectionStart = t.selectionEnd = ss - 4;
		    }
		    else if (evt.keyCode == 39 && t.value.slice(ss,ss + 4) == tab) {
		        evt.preventDefault();
		        t.selectionStart = t.selectionEnd = ss + 4;
		    }
		}
	});
</script>
</div>
<script>
	$(function(){
		$("#queryoidsbutton").click(function(event){
			event.preventDefault();
			var downloadframe = $(this).parents(".downloadframe");
			var roid = downloadframe.find('input[name="roid"]');
			var oids = downloadframe.find('input[name="oids"]');
			var params = {
				downloadType: "oids",
				allowCheckout: false,
				roid: roid.val(),
				oids: [oids.val()]
			};
			showDownloadCheckoutPopup(params);
		});
		$("#queryguidsbutton").click(function(event){
			event.preventDefault();
			var downloadframe = $(this).parents(".downloadframe");
			var roid = downloadframe.find('input[name="roid"]');
			var guids = downloadframe.find('input[name="guids"]');
			var params = {
				downloadType: "guids",
				allowCheckout: false,
				roid: roid.val(),
				guids: [guids.val()]
			};
			showDownloadCheckoutPopup(params);
		});
		$("#queryclassesbutton").click(function(event){
			event.preventDefault();
			var downloadframe = $(this).parents(".downloadframe");
			var roid = downloadframe.find('input[name="roid"]');
			var ifcClass = downloadframe.find("#cid");
			var params = {
				downloadType: "classes",
				allowCheckout: false,
				roid: roid.val(),
				classes: [ifcClass.val()]
			};
			showDownloadCheckoutPopup(params);
		});
	});
</script>