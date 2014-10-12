function RelaticsPlugin() {
}

RelaticsPlugin.prototype.init = function(containerDiv, projectPage){
	this.containerDiv = containerDiv;
	this.projectPage = projectPage;
	projectPage.selectListeners.register(this.pick.bind(this));
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
//	ifcGuid = "3e_Z0UB95FzQ84RHxlySBA";
	var request = {
			"bimdataservice_request": {
				"ifc_guid": ifcGuid,
				"data_report_name": "test-report"
			}
	};
	
	function processJson(report) {
		var table = $("<table class=\"table table-no-top\">");
		table.append("<caption>Ruimte</caption>");
		table.append("<thead></thead>");
		var tbody = $("<tbody>");
		table.append(tbody);
		o.containerDiv.append(table);

		tbody.append("<tr><td>" + report.Algemeen.ruimte['@naam'] + "</td></tr>");

		var table = $("<table class=\"table table-no-top\">");
		table.append("<caption>Algemeen</caption>");
		table.append("<thead></thead>");
		var tbody = $("<tbody>");
		table.append(tbody);
		o.containerDiv.append(table);
		
		tbody.append("<tr><td>naam</td><td>" + report.Algemeen.ruimte['@naam'] + "</td></tr>");
		tbody.append("<tr><td>definitie</td><td>" + report.Algemeen.ruimte['@definitie'] + "</td></tr>");
		tbody.append("<tr><td>opmerking</td><td>" + report.Algemeen.ruimte['@opmerking'] + "</td></tr>");
		tbody.append("<tr><td>type</td><td>" + report.Algemeen.ruimte.type['@type'] + "</td></tr>");
		tbody.append("<tr><td>toegankelijkheid</td><td>" + report.Algemeen.ruimte.toegankelijkheid['@toegankelijkheid'] + "</td></tr>");
		tbody.append("<tr><td>bedrijfstijd week / weekend</td><td>" + report.Algemeen.ruimte.bedrijfstijd_week__weekeind['@bedrijfstijd_week__weekeind'] + "</td></tr>");
		tbody.append("<tr><td>ID</td><td>" + report.Algemeen.ruimte.ID['@ID'] + "</td></tr>");
		tbody.append("<tr><td>GUID</td><td>" + report.Algemeen.ruimte['@GUID'] + "</td></tr>");

		if (report.Kenmerken_bibliotheek != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Kenmerken (bibliotheek)</caption>");
			table.append("<thead><tr><th>naam</th><th>waarde</th><th>opmerking</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			report.Kenmerken_bibliotheek.Property.forEach(function(kenmerk){
				tbody.append("<tr><td>" + kenmerk["@naam"] + "</td><td>" + kenmerk["@waarde"] + "</td><td>" + kenmerk["@opmerking"] + "</td></tr>");
			});
		}

		if (report.Kenmerken_Fase_I__II != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Kenmerken Fase I & II</caption>");
			table.append("<thead><tr><th>naam</th><th>waarde</th><th>opmerking</th><th>fase</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			report.Kenmerken_Fase_I__II.Property.forEach(function(kenmerk){
				tbody.append("<tr><td>" + kenmerk["@naam"] + "</td><td>" + kenmerk["@waarde"] + "</td><td>" + kenmerk["@opmerking"] + "</td><td>" + kenmerk.fase["@fase"] + "</td></tr>");
			});
		}

		if (report.Kenmerken_Fase_II != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Kenmerken Fase II</caption>");
			table.append("<thead><tr><th>naam</th><th>waarde</th><th>opmerking</th><th>fase</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			report.Kenmerken_Fase_II.Property.forEach(function(kenmerk){
				tbody.append("<tr><td>" + kenmerk["@naam"] + "</td><td>" + kenmerk["@waarde"] + "</td><td>" + kenmerk["@opmerking"] + "</td><td>" + kenmerk.fase["@fase"] + "</td></tr>");
			});
		}

		if (report.Kenmerken_bij_Vervanging != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Kenmerken bij Vervanging</caption>");
			table.append("<thead><tr><th>naam</th><th>waarde</th><th>opmerking</th><th>fase</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			if (Array.isArray(report.Kenmerken_bij_Vervanging.Property)) {
				report.Kenmerken_bij_Vervanging.Property.forEach(function(kenmerk){
					tbody.append("<tr><td>" + kenmerk["@naam"] + "</td><td>" + kenmerk["@waarde"] + "</td><td>" + kenmerk["@opmerking"] + "</td><td>" + kenmerk.fase["@fase"] + "</td></tr>");
				});
			} else {
				var kenmerk = report.Kenmerken_bij_Vervanging.Property;
				tbody.append("<tr><td>" + kenmerk["@naam"] + "</td><td>" + kenmerk["@waarde"] + "</td><td>" + kenmerk["@opmerking"] + "</td><td>" + kenmerk.fase["@fase"] + "</td></tr>");
			}
		}
		
		function doComfort(title, comfort) {
			if (comfort != null) {
				var table = $("<table class=\"table table-no-top\">");
				table.append("<caption>" + title + "</caption>");
				table.append("<thead><tr><th>naam</th><th>fase</th><th>waarde</th><th>fase</th></tr></thead>");
				var tbody = $("<tbody>");
				table.append(tbody);
				o.containerDiv.append(table);
				comfort.comfort.forEach(function(item){
					if (Array.isArray(item.Property)) {
						tbody.append("<tr><td rowspan=\"" + item.Property.length + "\">" + item["@naam"] + "</td></tr>");
						item.Property.forEach(function(property){
							tbody.append("<tr><td>" + property["@kenmerk"] + "</td><td>" + property["@waarde"] + "</td><td>" + (property.fase == null ? "" : property.fase["@fase"]) + "</td></tr>");
						});
					} else {
						var property = item.Property;
						tbody.append("<tr><td>" + property["@kenmerk"] + "</td><td>" + property["@kenmerk"] + "</td><td>" + property["@waarde"] + "</td><td>" + (property.fase == null ? "" : property.fase["@fase"]) + "</td></tr>");
					}
				});
			}
		}

		doComfort("Comfort", report.Comfort);
		doComfort("Comfort Fase I & II", report.Comfort_Fase_I__II);
		doComfort("Comfort Fase II", report.Comfort_Fase_II);
		doComfort("Comfort bij Vervanging", report.Comfort_bij_Vervanging);
		
		if (report.Voorziening != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Voorziening</caption>");
			table.append("<thead><tr><th>naam</th><th>fase</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			var fase = report.Voorziening.fase["@fase"];
			if (Array.isArray(report.Voorziening.Element)) {
				report.Voorziening.Element.forEach(function(element){
					tbody.append("<tr><td>" + element["@naam"] + "</td><td>" + fase + "</td></tr>");
				});
			} else {
				var element = report.Voorziening.Element;
				tbody.append("<tr><td>" + element["@naam"] + "</td><td>" + fase + "</td></tr>");
			}
		}

		if (report.Normen != null) {
			var table = $("<table class=\"table table-no-top\">");
			table.append("<caption>Normen</caption>");
			table.append("<thead><tr><th>titel</th><th>fase</th></tr></thead>");
			var tbody = $("<tbody>");
			table.append(tbody);
			o.containerDiv.append(table);
			report.Normen.norm.forEach(function(element){
				tbody.append("<tr><td>" + element["@Element"] + "</td><td>" + "" + "</td></tr>");
			});
		}

		o.containerDiv.find("span").remove();
	}
	
	if ('localStorage' in window && window['localStorage'] !== null) {
		var localItem = localStorage.getItem(ifcGuid);
		if (localItem != null) {
			processJson(JSON.parse(localItem));
			return;
		}
	}
	$.ajax({
		type: "POST",
		crossDomain: true,
		url: "https://23.253.203.178:8243/services/bim-client-dataservice",
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
			
			var report = response.GetResultResponse.GetResultResult.Report;
			
			if ('localStorage' in window && window['localStorage'] !== null) {
				localStorage.setItem(ifcGuid, JSON.stringify(report));
			}
			
			processJson(report);
		},
		error: function(jqXHR, textStatus, error) {
			o.containerDiv.find("span").remove();
			o.containerDiv.append("<span>Error loading data</span>");
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
		var loginFn = function(){
			o.message.addClass("alert alert-info").html("Logging in...");
			o.projectPage.models[groupId].get(id, function(object){
				o.loadData(form.find(".usernameInp").val(), form.find(".passwordInp").val(), object, function(){
					o.message.removeClass("alert-info").addClass("alert-success").html("Successfully retrieved Relatics data");
				});
			});
		}
		form.find("input").enterpress(loginFn);
		modal.find(".loginButton").click(loginFn);
		modal.modal();
	} else {
		o.projectPage.models[groupId].get(id, function(object){
			o.loadData(username, password, object);
		});
	}
}

Global.pluginManager.register(RelaticsPlugin);