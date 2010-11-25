<fieldset>
<legend>Upload IFC file</legend>
<div id="uploadajaxloader">
Uploading... <img src="images/ajax-loader.gif"/>
</div>
<form action="upload" method="post" enctype="multipart/form-data" id="uploadform">
<table>
<tr><td>IFC File</td><td><input id="file" type="file" name="file"/></td></tr>
<tr><td>Comment</td><td><textarea id="comment" name="comment" cols="80" rows="4"></textarea></td></tr>
</table>
<input type="hidden" name="poid" value="<%=request.getParameter("poid") %>"/>
<input type="hidden" name="type" value="ifc"/>
<input type="submit" name="upload" value="Upload"/>
</form>
</fieldset>
<script>
	var lastVal = "";

	$(document).ready(function(){
		$("#uploadajaxloader").hide();
		$("#file").change(function(){
			if ($("#comment").attr("value") == "" || $("#comment").attr("value") == lastVal) {
				var path = $("#file").val();
				if (path.indexOf("/") != -1) {
					path = path.substr(path.lastIndexOf("/") + 1);
				} else if (path.indexOf("\\") != -1) {
					path = path.substr(path.lastIndexOf("\\") + 1);
				}
				$("#comment").attr("value", path);
				lastVal = path;
			}
		});
	});
	$("#uploadform").submit(function(){
		$("#uploadform").hide();
		$("#uploadajaxloader").show();
	});
</script>