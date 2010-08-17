</div>
<div class="footer">    
	<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        <div><img src="images/footerlogo.gif" alt="Open Source BIMserver" /><br/>
        <a href="<%=getServletContext().getContextPath()%>/settings?action=downloadlog" target="_blank">Download Logfile</a></div> 
</div><!-- end footer --> 
</div>
<script>
$(document).ready(function(){
	instrumentBrowserLinks();
});
	function instrumentBrowserLinks() {
		$(".browserlink").unbind('click');
		$(".browserlink").click(function(event){
			tb_show("Browser", $(event.target).attr('browserurl') + "&width=500&height=500");
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
			$("#guid").val(guid);
			activateTab("Query");
			$("#simplequerylink").click();
			return false;
		});
		$(".oidquerylink").click(function(event){
			var oid = $(event.currentTarget).attr("oid");
			$("#oid").val(oid);
			activateTab("Query");
			$("#simplequerylink").click();
			return false;
		});
	}
$(window).unload(function(){
	uninit();	
});
</script>
</body>
</html>