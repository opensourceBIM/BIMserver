<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.EmfSerializerFactory"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
	long roid = Long.parseLong(request.getParameter("roid"));
	List<String> classes = loginManager.getService().getAvailableClasses();
	Collections.sort(classes);
	if (loginManager.getUserType() == SUserType.ADMIN) {
%><a id="simplequerylink" href="#">Simple</a> | <a id="advancedquerylink" href="#">Advanced</a><br/><br/><%
	}
%>
<div id="simplequery">
<form action="<%=request.getContextPath() %>/download" method="post">
<input type="hidden" name="roid" value="<%=roid %>"/>
<table>
<tr>
	<td width="120">Object ID</td>
	<td width="320"><input type="text" name="oid" id="oid"/></td>
	<td>Type</td><td><select name="resultType">
<%
	for (ResultType resultType : emfSerializerFactory.getSingleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
<%	
	}
%>
	</select></td><td> <label for="queryoidzip_<%=roid %>">Zip</label><input type="checkbox" name="zip" id="queryoidzip_<%=roid %>"/> <input type="submit" value="Query"></td>
</tr>
</table>
</form>
<form action="<%=request.getContextPath() %>/download" method="post">
<input type="hidden" name="roid" value="<%=roid %>"/>
<table>
<tr>
	<td width="120">Globally Unique ID</td>
	<td width="320"><input type="text" name="guids" id="guids"/></td>
	<td>Type</td><td><select name="resultType">
<%
	for (ResultType resultType : emfSerializerFactory.getSingleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
<%	
	}
%>
	</select></td><td> <label for="queryguidzip_<%=roid %>">Zip</label><input type="checkbox" name="zip" id="queryguidzip_<%=roid %>"/> <input type="submit" value="Query"></td>
</tr>
</table>
</form>
<form action="<%=request.getContextPath() %>/download" method="post">
<input type="hidden" name="roid" value="<%=roid %>"/>
<table>
<tr>
	<td width="120">IFC Class</td>
	<td width="320">
		<select name="class" id="cid">
<%
	for (String className : classes) {
%><option value="<%=className%>"><%=className %></option>
<%
	}
%>
		</select>
	</td>
	<td>Type</td><td><select name="resultType">
<%
	for (ResultType resultType : emfSerializerFactory.getMultipleResultTypes()) {
%>
	<option value="<%=resultType.name() %>"<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : "" %>><%= resultType.getNiceName() %></option>
<%	
	}
%>
	</select></td><td> <label for="querycidzip_<%=roid %>">Zip</label><input type="checkbox" name="zip" id="querycidzip_<%=roid %>"/> <input type="submit" value="Query"></td>
</tr>
</table>
</form>
</div>
<div id="advancedquery">
Examples: <a href="#" id="defaultbutton">Default</a> <a href="#" id="plumbingbutton">Plumbing</a> <a href="#" id="doorsbutton">Doors</a><br/>
Get even <a href="http://extend.bimserver.org" target="_blank">more advanced Querys or share yours with others</a><br/>
<textarea cols="106" rows="16" id="code">
</textarea>
<div style="float: right">
	<span id="ajaxloader">
	<span id="ajaxloadertext"></span> <img src="images/ajax-loader.gif"/>
	</span>
	<button id="compilebutton">Compile</button>
	<button id="compileandrunbutton">Compile &amp; Run</button>
</div>
<textarea cols="106" rows="16" id="console">
</textarea>
<script>
	$(document).ready(function(){
		if ($("#code").val().trim() == "") {
			$.ajax({
				url: '<%=request.getContextPath() %>/queries/DefaultQuery.java',
				success: function(data) {
					$("#code").val(data);
				}
			});
		}
		$("#defaultbutton").click(function(){
			$.ajax({
				url: '<%=request.getContextPath() %>/queries/DefaultQuery.java',
				success: function(data) {
					$("#code").val(data);
				}
			});
		});
		$("#plumbingbutton").click(function(){
			$.ajax({
				url: '<%=request.getContextPath() %>/queries/Plumbing.java',
				success: function(data) {
					$("#code").val(data);
				}
			});
		});
		$("#doorsbutton").click(function(){
			$.ajax({
				url: '<%=request.getContextPath() %>/queries/Doors.java',
				success: function(data) {
					$("#code").val(data);
				}
			});
		});
		$("#ajaxloader").hide();
		$("#advancedquerylink").click(function(){
			$("#simplequery").hide();
			$("#advancedquery").show();
			$("#advancedquerylink").addClass("linkactive");
			$("#simplequerylink").removeClass("linkactive");
		});
		$("#simplequerylink").click(function(){
			$("#advancedquery").hide();
			$("#simplequery").show();
			$("#simplequerylink").addClass("linkactive");
			$("#advancedquerylink").removeClass("linkactive");
		});
		$("#simplequerylink").addClass("linkactive");
		$("#simplequery").show();
		$("#advancedquery").hide();
		
		function success(data) {
			$("#ajaxloader").hide();
			$("#console").val("");
			if (data.compileErrors != null && data.compileErrors.length > 0) {
				$("#console").addClass("compile_error");
				for (var i=0; i<data.compileErrors.length; i++) {
					$("#console").val(data.compileErrors[i]);
				}
			}
			if (data.output != null) {
				$("#console").removeClass("compile_error");
				$("#console").val(data.output);
			}
		}
		
		$("#compilebutton").click(function(){
			$("#ajaxloader").show();
			$("#ajaxloadertext").text("Compiling...");
			$.ajax({
				url: "<%=request.getContextPath() %>/compile", 
				type: "POST",
				dataType: "json",
				data: {roid:<%=roid%>, action: "compile", code:$("#code").val()},
				success: success
			});
		});
		$("#compileandrunbutton").click(function(){
			$("#ajaxloader").show();
			$("#ajaxloadertext").text("Compiling & Running...");
			$.ajax({
				url: "<%=request.getContextPath() %>/compile",
				type: "POST",
				dataType: "json",
				data: {roid:<%=roid%>, action: "compileandrun", code:$("#code").val()},
				success: success
			});
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