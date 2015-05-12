function loadBimServerApi(address, notifier, callback, errorCallback) {
	var timeoutId = window.setTimeout(function() {
		notifier.setError("Could not connect");
		errorCallback();
	}, 3000);
	if (address.endsWith("/")) {
		address = address.substring(0, address.length - 1);
	}
	$.getScript(address + "/js/bimserverapi.js").done(function(){
		window.clearTimeout(timeoutId);
		if (typeof BimServerApi != 'function') {
			notifier.setError("Could not connect");
			errorCallback();
		} else {
			if (BimServerApi != null) {
				Global.bimServerApi = new BimServerApi(address, notifier);
				Global.bimServerApi.init(function(){
					// TODO make 1 call
					Global.bimServerApi.call("AdminInterface", "getServerInfo", {}, function(serverInfo){
						Global.bimServerApi.call("AdminInterface", "getVersion", {}, function(version){
							Global.bimServerApi.version = version;
							callback(serverInfo);
						});
					});
				});
			} else {
				window.clearTimeout(timeoutId);
				notifier.setError("Could not find BIMserver API");
				errorCallback();
			}
		}
	}).fail(function(jqxhr, settings, exception){
		window.clearTimeout(timeoutId);
		notifier.setError("Could not connect");
		errorCallback();
	});
}