function loadBimServerApi(address, notifier, callback, errorCallback) {
	var timeoutId = window.setTimeout(function() {
		notifier.error("Could not connect");
		errorCallback();
	}, 3000);
	$.getScript(address + "/js/bimserverapi.js").done(function(){
		window.clearTimeout(timeoutId);
		if (typeof BimServerApi != 'function') {
			notifier.error("Could not connect");
			errorCallback();
		} else {
			if (BimServerApi != null) {
				Global.bimServerApi = new BimServerApi(address, notifier);
				Global.bimServerApi.init(function(){
					Global.bimServerApi.call("AdminInterface", "getServerInfo", {}, function(serverInfo){
						callback(serverInfo);
					});
				});
			} else {
				window.clearTimeout(timeoutId);
				notifier.error("Could not find BIMserver API");
				errorCallback();
			}
		}
	}).fail(function(jqxhr, settings, exception){
		window.clearTimeout(timeoutId);
		notifier.error("Could not connect");
		errorCallback();
	});
}