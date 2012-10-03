<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.LoginManager"%>
</div>
<div class="footer">    
	<%=((LoginManager)request.getSession().getAttribute("loginManager")).getService(request).getSettingFooterAddition() %>
	<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        <div><a href="http://www.bimserver.org"><img src="images/footerlogo.gif" alt="Open Source BIMserver" /></a><br/><a href="http://www.bimserver.org/license/" target="_blank">(C) GNU Affero GPL v3 and others</a>
       <!--  <a href="<%=getServletContext().getContextPath()%>/settings?action=downloadlog">Download Logfile</a>  -->
       </div> 
</div><!-- end footer --> 
</div>
<script>
$(function(){
	$(".focusme").focus();
	instrumentBrowserLinks();

	$(".errorLink").click(function(event){
		$(event.target).parent().find(".errorBody").toggle();
	});
	
	var showDeleted = getCookie("showdeleted") == "true";
	$("#showdeleted").attr("checked", showDeleted);
	if (showDeleted) {
		$(".deleted").show();
	}
	
	$("#showdeleted").change(function(){
		$(".deleted").toggle();
		setCookie("showdeleted", $("#showdeleted").attr("checked"));
	});
});

	function showOverlay(title, url) {
		tb_show(title, url + "&width=" + $(document).width() * 0.7 + "&height=" + Math.min($(document).height(), $(window).height()) * 0.8);
	}

	function instrumentBrowserLinks() {
		$(".browserlink").unbind('click');
		$(".browserlink").click(function(event){
			showOverlay("Browser", $(event.target).attr('browserurl'));
			return false;
		});
		$(".querylink").click(function(event){
			var className = $(event.currentTarget).attr("cName");
			$("#cid").val(className);
			activateTab("Query");
			$("#simplequerylink").click();
			return false;
		});
		$(".guidquerylink").click(function(event){
			var guid = $(event.currentTarget).attr("guid");
			$("#guids").val(guid);
			activateTab("Query");
			$("#simplequerylink").click();
			return false;
		});
		$(".oidquerylink").click(function(event){
			var oid = $(event.currentTarget).attr("oid");
			$("#oids").val(oid);
			activateTab("Query");
			$("#simplequerylink").click();
			return false;
		});
	}
</script>
</body>
</html>