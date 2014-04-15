function RelaticsPlugin() {
}

RelaticsPlugin.prototype.init = function(containerDiv, projectPage){
	this.containerDiv = containerDiv;
	this.projectPage = projectPage;
	projectPage.selectListeners.push(this.pick.bind(this));
};

RelaticsPlugin.prototype.show = function(){
	this.containerDiv.show();
};

RelaticsPlugin.prototype.getType = function(){
	return "TabPlugin";
};

RelaticsPlugin.prototype.close = function(){
	//this.projectPage.selectListeners.remove(o);
};

RelaticsPlugin.prototype.hide = function(){
	this.containerDiv.hide();
};

RelaticsPlugin.prototype.getName = function(){
	return "relatics";
};

RelaticsPlugin.prototype.getTabTitle = function(){
	return "Relatics";
};

RelaticsPlugin.prototype.loadData = function(username, password, object, callback){
	var o = this;
	o.containerDiv.find("table").remove();
	o.containerDiv.append("<span>Loading...</span>");
	var ifcGuid = object.getGlobalId();
	var request = {
		"bimdataservice_request": {
			"ifc_guid": "3e_Z0UB95FzQ84RHxlySBA",
			"data_report_name": "test-report"
		}
	};
	$.ajax({
		type: "POST",
		crossDomain: true,
		url: "[ENTER URL]",
		dataType: "json",
		cache: false,
		contentType: "application/json",
		accepts: "application/json",
		async: false,
//				headers: {
//				    "Authorization": btoa(username + ":" + password)
//				  },
		data: JSON.stringify(request),
		success: function (response){
			$.cookie("relatics-wso2-username", username);
			$.cookie("relatics-wso2-password", password);
			var realResponse = response.bimdataservice_response;
			if (realResponse.succesfull == true) {
				var table = $("<table class=\"table table-no-top\">");
				table.append("<thead></thead>");
				var tbody = $("<tbody>");
				table.append(tbody);
				var array = realResponse.result.element;
				array.forEach(function(item){
					tbody.append("<tr><td>" + item + "</td></tr>");
				});
				o.containerDiv.find("span").remove();
				o.containerDiv.append(table);
			} else {
				console.log("Error");
			}
		}
	});
};

RelaticsPlugin.prototype.pick = function(groupId, id){
	var o = this;
	
	var username = $.cookie("relatics-wso2-username");
	var password = $.cookie("relatics-wso2-password");
	if (username == null || password == null) {
		var modal = $("<div class=\"modal\">");
		var dialog = $("<div class=\"modal-dialog\">");
		var content = $("<div class=\"modal-content\">");
		var header = $("<div class=\"modal-header\">");
		var body = $("<div class=\"modal-body\">");
		var footer = $("<div class=\"modal-footer\">");
		modal.append(dialog);
		dialog.append(content);
		content.append(header);
		content.append(body);
		content.append(footer);
		
		o.message = $("<div class=\"message\">");
		body.append(o.message);
		
		var form = $("<form>");
		form.append("<div class=\"form-group\"><label>Username</label><input class=\"usernameInp form-control\"/></div>");
		form.append("<div class=\"form-group\"><label>Password</label><input type=\"password\" class=\"passwordInp form-control\"/></div>");
		body.append(form);
		
		header.append("<h3>Relatics Login</h3>");
		footer.append("<a class=\"btn btn-default closeButton\" data-dismiss=\"modal\">Close</a>");
		footer.append("<a class=\"btn btn-primary loginButton\">Login</a>");
		$(document.body).append(modal);
		modal.on("shown.bs.modal", function(){
			modal.find("input").first().focus();
		});
		modal.find(".loginButton").click(function(){
			o.message.addClass("alert alert-info").html("Logging in...");
			o.projectPage.models[groupId].get(id, function(object){
				o.loadData(form.find(".usernameInp").val(), form.find(".passwordInp").val(), object, function(){
					o.message.removeClass("alert-info").addClass("alert-success").html("Successfully retrieved Relatics data");
				});
			});
		});
		modal.modal();
	} else {
		o.projectPage.models[groupId].get(id, function(object){
			o.loadData(username, password, object);
		});
	}
}

Global.pluginManager.register(RelaticsPlugin);