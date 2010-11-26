</div>
<div class="footer">    
	<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        <div><img src="images/footerlogo.gif" alt="Open Source BIMserver" /><br/>(C) GNU GPL v3
       <!--  <a href="<%=getServletContext().getContextPath()%>/settings?action=downloadlog">Download Logfile</a>  -->
       </div> 
</div><!-- end footer --> 
</div>
<script>
$(document).ready(function(){
	instrumentBrowserLinks();
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