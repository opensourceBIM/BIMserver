<script src="js/jquery-1.8.1.min.js"></script>
<script src="js/String.js"></script>
<style>
	html{height: 100%}
	body{padding: 0; margin: 0; height: 100%}
	.error {color: red}
	.success {color: black}
	.methodlist {width: 20%; float: left}
	.main {clear: both; height: 100%; width: 100%; position: absolute;}
	.inner {padding-top: 35px; height: 90%}
	* {font: 13px/1.5 'Helvetica Neue', Arial, 'Liberation Sans', FreeSans, sans-serif; color: #333}
	li {list-style: none; }
	ul {padding-left: 5px}
	.methodlist {max-height: 100%; overflow: auto}
	.methoddoc {height: 20%; background-color: #dddddd}
	.input {height: 80%; width: 100%}
	.output {height: 50%; width: 100%}
	.console {height: 50%; width: 100%}
	.right{height: 100%; width: 40%; float: left}
	.left{height: 100%; width: 40%; float: left}
	h1 {font-size: 2em; margin: 0}
	h2 {font-size: 1.5em}
	h3 {font-size: 1em; font-weight: bold; margin: 0}
	.sendButton {float: right}
	.top {height: 35px; float: left;}
	textarea{padding: 0}
</style>
<div class="top">
	<label>Server address: <input class="address" type="text" width="100" value="http://localhost:8080/jsonapi"/></label>
	<label>Username: <input class="username" type="text" value=""/></label>
	<label>Password: <input class="password" type="password" value=""/></label>
	<input type="button" class="sendLoginRequest" value="Send login request"/>
</div>
<div class="main">
	<div class="inner">
		<div class="methodlist">
			<a href="#" class="loadMethods">loadMethods</a><br/>
		</div>
		<div class="left">
			<div class="methoddoc">
				<input class="sendButton" type="button" value="Send"/>
				<h1></h1>
				<div></div>
			</div>
			<textarea class="input">
			</textarea>
		</div>
		<div class="right">
			<textarea class="output"></textarea>
			<br/>
			<textarea class="console"></textarea>
		</div>
	</div>
</div>
<script>
$(function(){
	var token = null;

	function sendLoginRequest() {
		var request = {
			"interface": "ServiceInterface",
			"method": "login",
			"username": $(".username").val(),
			"password": $(".password").val()
		};
		$(".output").val("");
		$(".console").val("");
		call(request, function(data){
			token = data.response;
			$(".console").val("Login successful");
		});
	}

	function call(request, callback) {
		var requestObject = {
			request: request
		};
		if (token != null) {
			requestObject.token = token;
		}
		$.ajax({
			url: $(".address").val(),
			username: $(".username").val(),
			password: $(".password").val(),
			data: JSON.stringify(requestObject),
			contentType: "application/json",
			type: "POST",
			dataType: "json",
			success: function(data){
				if (data.exception == null) {
					callback(data.response);
				} else {
					$(".output").removeClass("success").addClass("error");
					$(".output").val(JSON.stringify(data, null, '  '));
					$(".console").val(data.exception.message);
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				$(".output").removeClass("success").addClass("error");
				$(".output").val(textStatus);
			}
		});
	}
	
	function loadMethods(event) {
		if (event != null) {
			event.preventDefault();
		}
		var request = {
			interface: "ServiceInterface",
			method: "getServiceInterfaces"
		};
		call(request, function(data){
			$(".methodlist").empty();
			data.forEach(function(serviceInterface){
				$(".methodlist").append("<h1>" + serviceInterface.name + "</h1>");
				var ul = $("<ul>");
				$(".methodlist").append(ul);
				
				var request = {
					interface: "ServiceInterface",
					method: "getServiceMethods",
					serviceInterfaceName: serviceInterface.name
				};
				call(request, function(data){
					data.forEach(function(serviceMethod){
						var li = $("<li></li>");
						var a = $("<a href=\"#\">" + serviceMethod.name + "</a>");
						a.data("serviceInterfaceName", serviceInterface.name);
						a.data("serviceMethodName", serviceMethod.name);
						a.data("doc", serviceMethod.doc);
						a.click(getExample);
						li.append(a);
						ul.append(li);
					});
				});
			});
		});
	}
	
	function makeExampleFromType(type, genericType, doc) {
		if (doc == "") {
			doc = null;
		}
		var example = "";
		if (type.simpleName == "String") {
			example += "\"<<" + "string" + (doc == null ? "" : (", " + doc)) + ">>\"";
		} else if (type.name.contains("org.bimserver")) {
			example += "{\n";
			type.fields.forEach(function(field, index){
				example += "    \"" + field.name + "\": " + makeExampleFromType(field.type, field.genericType, field.doc);
				if (index != type.fields.length - 1) {
					example += ",";
				}
				example += "\n";
			});
			example += "    }";
		} else if (type.simpleName == "List") {
			example += "[<<" + genericType.simpleName.toLowerCase() + (doc == null ? "" : (", " + doc)) + ">>]";
		} else {
			example += "<<" + type.simpleName.toLowerCase() + (doc == null ? "" : (", " + doc)) + ">>";
		}
		return example;
	}
	
	function getExample(event) {
		event.preventDefault();
		var request = {
			interface: "ServiceInterface",
			method: "getServiceMethodParameters",
			serviceInterfaceName: $(this).data("serviceInterfaceName"),
			serviceMethodName: $(this).data("serviceMethodName")
		};
		$(".methoddoc div").html($(this).data("doc"));
		$(".methoddoc h1").html($(this).data("serviceInterfaceName") + "." + $(this).data("serviceMethodName"));
		var example = "{\n";
		example += "  \"interface\": \"" + $(this).data("serviceInterfaceName") + "\", \n";
		example += "  \"method\": \"" + $(this).data("serviceMethodName") + "\"";
		call(request, function(data){
			data.forEach(function(parameter, index){
				example += ",\n  \"" + parameter.name + "\": ";
				example += makeExampleFromType(parameter.type, parameter.genericType, parameter.doc);
			});
			example += "\n}";
			$(".input").val(example);
		});
	}
	
	function sendClick() {
		$(".output").val("");
		$(".console").val("");
		var input = $(".input").val();
		try {
			input = JSON.parse(input);
			call(input, function(data){
				$(".output").removeClass("error").addClass("success");
				$(".output").val(JSON.stringify(data, null, '  '));
			});
		} catch (e) {
			$(".output").removeClass("success").addClass("error");
			$(".output").val("Invalid json");
		}
	}

	$(".sendLoginRequest").click(sendLoginRequest);
	$(".sendButton").click(sendClick);
	$(".loadMethods").click(loadMethods);
	
	loadMethods();
});
</script>