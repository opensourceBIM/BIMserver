<div class="tabbertab" id="visualizetab" title="Visualize">
<div id="visualizeloader">Retrieving visualization... <img src="images/ajax-loader.gif" /></div>
<!-- <div id="visualizediv" style="background-color: white"><a href="#" id="load">Load</a></div>  -->
<h1>Sorry... this is a BIMserver, not a BIM-viewer. The BIM-viewer is now a seperate project. Have a look at <a href="http://www.osbim.org" target="_blank">www.osbim.org</a> for more info.</h1>
</div>
<script>
$(document).ready(function(){
	$("#visualizeloader").hide();
	$("#load").click(function(){
		$("#load").hide();
		$("#visualizeloader").show();
		var o3dId = "o3d" + (o3dcounter++);
		$("<div id='" + o3dId + "' style='width: " + (($(document).width() * 0.7)-20) + "px; height: " + (($(document).height() * 0.7)-30) + "px'></div>").appendTo("#visualizediv");
		g_idOfLoader = "visualizeloader";
		createClient(document.getElementById(o3dId), function(){
			loadFile(o3djs.util.getCurrentURI() + 'download?roid=<%=request.getParameter("roid") %>&serializerName=O3DJSON', "visualizeloader");
		});
		return false;
	});
});
</script>