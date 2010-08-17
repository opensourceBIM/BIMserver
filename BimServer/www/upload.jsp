<fieldset>
<legend>Upload IFC file</legend>
<div id="uploadajaxloader">
Uploading... <img src="images/ajax-loader.gif"/>
</div>
<form action="upload" method="post" enctype="multipart/form-data" id="uploadform">
<table>
<tr><td>IFC File</td><td><input type="file" name="file"/></td></tr>
<tr><td>Comment</td><td><textarea name="comment" cols="80" rows="4"></textarea></td></tr>
</table>
<input type="hidden" name="poid" value="<%=request.getParameter("poid") %>"/>
<input type="hidden" name="type" value="ifc"/>
<input type="submit" name="upload" value="Upload"/>
</form>
</fieldset>
<script>
	$(document).ready(function(){
		$("#uploadajaxloader").hide();
	});
	$("#uploadform").submit(function(){
		$("#uploadform").hide();
		$("#uploadajaxloader").show();
	});
</script>