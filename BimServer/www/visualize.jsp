<div class="tabbertab" id="visualizetab" title="Visualize">
<div id="visualizeloader">Retrieving visualization... <img src="images/ajax-loader.gif" /></div>
<div id="visualizediv" style="background-color: white"><a href="#" id="load">Load</a></div>
</div>
<script>
$(document).ready(function(){
	$("#visualizeloader").hide();
	$("#load").click(function(){
		$("#load").hide();
		$("#visualizeloader").show();
		var o3dId = "o3d" + (o3dcounter++);
		$("<div id='" + o3dId + "' style='width: 500px; height: 500px'></div>").appendTo("#visualizediv");
		createClient(document.getElementById(o3dId), function(){
			doload(o3djs.util.getCurrentURI() + 'download?roid=<%=request.getParameter("roid") %>&resultType=O3D_JSON', "visualizeloader");
		});
		return false;
	});
});
</script>