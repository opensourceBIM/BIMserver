var Project = function(main, project) {
	var othis = this;
	othis.lastRevision = null;

	this.close = function () {
		Global.bimServerApi.unregister(othis.newLogAction);
	};

	this.show = function() {
		if (typeof project == "number" || typeof project == "string") {
			othis.reloadProject(project);
		} else {
			othis.project = project;
			othis.updateProject();
		}
		Global.bimServerApi.register("NotificationInterface", "newLogAction", othis.newLogAction);
	};
	
	this.revisionClick = function(event) {
		if (!$(event.target).is("a, button, span.caret")) {
			main.showRevision($(this).parents("tr").andSelf().data("revision"), null, true);
			othis.close();
		}
	};

	this.loadDetails = function(event) {
		event.preventDefault();
		pushHistory({tab: "details"});
		$(".project .nav li").removeClass("active");
		$(".project .detailsLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .details").show();
	};

	this.projectClick = function(event) {
		if (!$(event.target).is("a, button, span.caret")) {
			main.showProject($(this).parents("tr").andSelf().data("project"), event);
			othis.close();
		}
	};
	
	this.addSubProject = function(subProject) {
		$(".project .nosubprojects").hide();
		$(".project .subprojectsTable").show();
		var subProjectRow = $("<tr class=\"project\">");
		subProjectRow.click(othis.projectClick);
		subProjectRow.data("project", subProject);
		
		subProjectRow.append("<td>" + subProject.name + "</td>");

		var actions = $("<td></td>");
		var dd = $(".dropdowntemplateproject").clone();
		dd.removeClass("dropdowntemplateproject");
		dd.show();
		actions.append(dd);
		subProjectRow.append(actions);

		$(".project .subprojectsTable").append(subProjectRow);
	};
	
	this.loadSubProjects = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .subprojectsLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .subprojects").show();
		Global.bimServerApi.call("ServiceInterface", "getSubProjects", {poid: othis.project.oid}, function(data){
			$(".project .subprojectsTable tr.project").remove();
			data.forEach(function(subProject){
				othis.addSubProject(subProject);
			});
		});
	};
	
	this.userClick = function(event) {
		if (!$(event.target).is("a, button, span.caret")) {
			main.showUser($(this).data("user"), event);
			othis.close();
		}
	};

	this.revokeUser = function() {
		var user = $(this).parents("tr").data("user");
		Global.bimServerApi.call("ServiceInterface", "removeUserFromProject", {
			uoid: user.oid,
			poid: othis.project.oid
		}, function(data){
			othis.loadUsers();
		});
	};
	
	this.addUser = function(user) {
		$(".project .nousers").hide();
		$(".project .usersTable").show();
		
		var tr = $("<tr>");
		tr.data("user", user);
		tr.click(othis.userClick);
		tr.append("<td>" + user.name + "</td>");
		tr.append(newButtonTd("Revoke", othis.revokeUser));
		$(".project .usersTable").append(tr);
	};
	
	this.share = function(roid) {
		var div = $("<div class=\"modal fade\">");
		$(document.body).append(div);
		div.load("share.html", function(){
			new Share(roid);
		}).modal({keyboard:true});
	};

	this.addRevision = function(revision) {
		$(".project .norevisions").hide();
		$(".project .revisionsTable").show();
		var revisionRow = $("<tr>");
		revisionRow.data("revision", revision);
		revisionRow.click(othis.revisionClick);

		revisionRow.append("<td>" + revision.id + "</td>");
		revisionRow.append("<td><span title=\"" + formatDateTime(new Date(revision.date)) + "\" class=\"timespan\" datetime=\"" + revision.date + "\">" + formatTimeSpan(new Date().getTime() - revision.date, false) + "</span></td>");
		var userTd = $("<td></td>");
		var userA = $("<a>loading...</a>");
		userA.attr("uoid", revision.userId);
		userA.click(othis.userClick);
		userTd.append(userA);
		loadUser(userA);
		revisionRow.append(userTd);
		revisionRow.append("<td>" + revision.comment + "</td>");
		revisionRow.append("<td>" + revision.size + "</td>");

		var actions = newSplitDropDownTd("Download", othis.downloadCheckoutClick);
		actions.find("button.dropdown-toggle").click(function(){
			Global.bimServerApi.call("ServiceInterface", "getAllServicesOfProject", {poid: othis.project.oid}, function(data){
				actions.find("ul li").remove();
				var added = 0;
				data.forEach(function(service){
					if (service.trigger == "NEW_REVISION") {
						var li = $("<li><a>Run \"" + service.name + "\"</a></li>");
						added++;
						li.find("a").click(function(event){
							Global.bimServerApi.call("ServiceInterface", "triggerNewRevision", {roid: revision.oid, soid: service.oid}, function(data){
							});
						});
						actions.find("ul").append(li);
					}
				});
				if (added == 0) {
					var li = $("<li><a>No services configured</a></li>");
					actions.find("ul").append(li);
				}
				var shareLi = $("<li><a>Share...</a></li>");
				shareLi.find("a").click(function(){
					othis.share(revision.oid);
				});
				actions.find("ul").append(shareLi);
			});
		});
		revisionRow.append(actions);
		$(".project .revisionsTable tbody").prepend(revisionRow);
	};

	this.addCheckout = function(checkout) {
		$(".project .nocheckouts").hide();
		$(".project .checkoutsTable").show();
		var checkoutRow = $("<tr>");
		checkoutRow.data("checkout", checkout);
		checkoutRow.data("revision", checkout.revision);
		checkoutRow.click(othis.checkoutClick);

		checkoutRow.append("<td>" + checkout.revision.id + "</td>");
		checkoutRow.append("<td><span title=\"" + formatDateTime(new Date(checkout.date)) + "\" class=\"timespan\" datetime=\"" + checkout.date + "\">" + formatTimeSpan(new Date().getTime() - checkout.date, false) + "</span></td>");
		var userTd = $("<td></td>");
		var userA = $("<a>loading...</a>");
		userA.attr("uoid", checkout.userId);
		userA.click(othis.userClick);
		userTd.append(userA);
		loadUser(userA);
		checkoutRow.append(userTd);

		var actions = newSplitDropDownTd("Download", othis.downloadCheckoutClick);
		checkoutRow.append(actions);
		$(".project .checkoutsTable tbody").prepend(checkoutRow);
	};

	this.serviceClick = function(event){
		if (!$(event.target).is("a, button, span.caret")) {
			var service = $(this).parents("tr").andSelf().data("service");
			event.preventDefault();
			$(".project .services").load("service.html", function(){
				new Service(main, service);
			});
		}
	};
	
	this.createServiceLink = function(soid) {
		var link = $("<a></a>");
		link.attr("soid", soid);
		loadService(link);
		link.click(othis.serviceClick);
		return link;
	};

	this.triggerService = function() {
		var service = $(this).parents("tr").data("service");
		alert("Triggering service "  + service);
	};
	
	this.addService = function(service) {
		$(".project .noservices").hide();
		$(".project .servicesTable").show();
		var tr = $("<tr class=\"service\">");
		tr.data("service", service);
		tr.click(othis.serviceClick);
		var td = $("<td soid=\"" + service.oid + "\"></td>");
		loadService(td);
		tr.append(td);
		tr.append("<td>" + service.profileName + "</td>");
		var dropdowntd = newSplitDropDownTd("Trigger", othis.triggerService); 
		tr.append(dropdowntd);
		$(".project .servicesTable tbody").append(tr);
	};
	
	this.loadExtendedData = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .extendedDataLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .extendeddata").show();
		$(".project .extendeddata").load("extendeddatalist.html", function(){
			new ExtendedDataList(main, othis.lastRevision);
		});
	};
	
	this.loadRevisions = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .revisionsLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .revisions").show();
		Global.bimServerApi.call("ServiceInterface", "getAllRevisionsOfProject", {poid: othis.project.oid}, function(data){
			$(".project .revisionsTable tbody tr").remove();
			data.forEach(function(revision){
				othis.addRevision(revision);
			});
		});
	};

	this.loadCheckouts = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .checkoutsLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .checkouts").show();
		Global.bimServerApi.call("ServiceInterface", "getAllCheckoutsOfProject", {poid: othis.project.oid}, function(data){
			$(".project .checkoutsTable tbody tr").remove();
			data.forEach(function(checkout){
				othis.addCheckout(checkout);
			});
		});
	};

	this.loadUsers = function() {
		$(".project .nav li").removeClass("active");
		$(".project .usersLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .users").show();
		Global.bimServerApi.call("ServiceInterface", "getAllAuthorizedUsersOfProject", {poid: othis.project.oid}, function(data){
			$(".project .usersTable tbody tr").remove();
			data.forEach(function(user){
				othis.addUser(user);
			});
		});
	};

	this.loadServices = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .servicesLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .services").show();
		Global.bimServerApi.call("ServiceInterface", "getAllServicesOfProject", {poid: othis.project.oid}, function(data){
			$(".servicesTable tr.service").remove();
			data.forEach(function(service){
				othis.addService(service);
			});
		});
	};

	this.downloadCheckoutClick = function(event) {
		event.preventDefault();
		othis.showDownloadCheckoutPopup($(this).parents("tr").andSelf().data("revision").oid);
	};
	
	this.showDownloadCheckoutPopup = function(roid) {
		var div = $("<div class=\"modal fade\">");
		$(document.body).append(div);
		var params = {
			downloadType: "single",
			allowCheckouts: true,
			poid: othis.project.oid,
			roid: roid
		};
		div.load("download.html", function(){
			new Download(params);
		}).modal({keyboard:true});
	};
	
	this.showCheckinPopup = function() {
		var div = $("<div class=\"modal fade\">");
		$(document.body).append(div);
		div.load("checkin.html", function(){
			new Checkin(othis.project, function(){
			});
		}).modal({keyboard:true});
	};

	this.reloadProject = function(poid) {
		if (poid == null) {
			poid = othis.project.oid;
		}
		Global.bimServerApi.call("ServiceInterface", "getProjectByPoid", {poid: poid}, function(project){
			othis.project = project;
			othis.updateProject();
		});
	};
	
	this.addServiceClick = function(event) {
		main.showAddService(othis.project, event);
	};
	
	this.updateProject = function() {
		$(".project h1").html(othis.project.name);
		$(".project .subprojectsLink a").html("Sub Projects" + (othis.project.subProjects.length == 0 ? "" : (" (" + othis.project.subProjects.length + ")")));
		$(".project .revisionsLink a").html("Revisions" + (othis.project.revisions.length == 0 ? "" : (" (" + othis.project.revisions.length + ")")));
		$(".project .servicesLink a").html("Services" + (othis.project.services.length == 0 ? "" : (" (" + othis.project.services.length + ")")));
		if (othis.project.lastRevisionId != -1) {
			Global.bimServerApi.call("Bimsie1ServiceInterface", "getRevision", {roid: othis.project.lastRevisionId}, function(data){
				othis.lastRevision = data;
			});
			$(".project .browserLink").show();
			$(".project .surferLink").show();
			$(".project .queryLink").show();
			$(".project .extendedDataLink").show();
		} else {
			$(".project .browserLink").hide();
			$(".project .surferLink").hide();
			$(".project .queryLink").hide();
			$(".project .extendedDataLink").hide();
		}
		var history = History.getState().data;
		if (history.tab == "details") {
			othis.loadDetails();
		} else if (history.tab == "query") {
			othis.loadQuery();
		} else if (history.tab == "browser") {
			othis.loadBrowser();
		} else if (history.tab == "services") {
			othis.loadServices();
		} else if (history.tab == "users") {
			othis.loadUsers();
		} else if (history.tab == "revisions") {
			othis.loadRevisions();
		} else if (history.tab == "subprojects") {
			othis.loadSubProjects();
		}
	};
	
	this.loadBrowser = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .browserLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .browser").show();
		$(".project .browser").load("browser.html", function(){
			new Browser(othis.lastRevision);
		});
	};

	this.loadQuery = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .queryLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .query").show();
		$(".project .query").load("query.html", function(){
			new Query($(this), main, othis.project.oid, othis.lastRevision.oid);
		});
	};

	this.addSubProjectClick = function(event) {
		main.showAddProject(event, null, othis.project);
	};

	this.loadSurfer = function(event) {
		event.preventDefault();
		$(".project .nav li").removeClass("active");
		$(".project .surferLink").addClass("active");
		$(".project .content > div").hide();
		$(".project .surfer").show();
		$(".project .surfer").load("surfer.html", function(){
			new Surfer(othis.lastRevision);
		});
	};
	
	this.addUserLinkClick = function() {
		Global.bimServerApi.call("ServiceInterface", "getAllNonAuthorizedUsersOfProject", {poid: othis.project.oid}, function(data){
			$(".project .addUserToProjectDiv select option").remove();
			if (data.length == 0) {
				$(".project .addUserLink").show();
				$(".project .addUserToProjectDiv").hide();
			} else {
				data.forEach(function(user){
					var option = $("<option value=\"" + user.oid + "\">" + user.name + "</option>");
					$(".project .addUserToProjectDiv select").append(option);
				});
				$(".project .addUserLink").hide();
				$(".project .addUserToProjectDiv").show();
			}
		});
	};

	this.addUserToProject = function(event){
		event.preventDefault();
		Global.bimServerApi.call("ServiceInterface", "addUserToProject", {
			uoid: $(".project .addUserToProjectDiv select option:selected").val(),
			poid: othis.project.oid
		}, function(data){
			othis.loadUsers();
			othis.addUserLinkClick();
		});
	};
	
	$(".project .detailsLink").click(othis.loadDetails);
	$(".project .subprojectsLink").click(othis.loadSubProjects);
	$(".project .revisionsLink").click(othis.loadRevisions);
	$(".project .checkoutsLink").click(othis.loadCheckouts);
	$(".project .servicesLink").click(othis.loadServices);
	$(".project .queryLink").click(othis.loadQuery);
	$(".project .extendedDataLink").click(othis.loadExtendedData);
	$(".project .browserLink").click(othis.loadBrowser);
	$(".project .usersLink").click(othis.loadUsers);
	$(".project .surferLink").click(othis.loadSurfer);

	$(".project .addUserToProjectDiv button").click(othis.addUserToProject);
	
	$(".project .addUserLink").click(othis.addUserLinkClick);
	
	$(".project .checkinButton").click(othis.showCheckinPopup);
	$(".project .addServiceButton").click(othis.a ddServiceClick);
	$(".project .addSubProjectButton").click(othis.addSubProjectClick);

	this.newLogAction = function(uuid, logAction, serviceIdentifier, profileIdentifier, token, apiUrl){
		if (logAction.__type == "SNewRevisionAdded") {
			Global.bimServerApi.call("Bimsie1ServiceInterface", "getRevision", {roid: logAction.revisionId}, function(data){
				othis.reloadProject(logAction.projectId);
				othis.addRevision(data);
			});
		}
	};
}
</script>