function loadBimServerApi(address, notifier, version, callback, errorCallback) {
	if (window.Global == null) {
		window.Global = {};
	}
	var timeoutId = window.setTimeout(function() {
		notifier.setError("Could not connect");
		errorCallback();
	}, 3000);
	if (address.endsWith("/")) {
		address = address.substring(0, address.length - 1);
	}
	$.ajax({
		  url: address + "/js/bimserverapi.js?_v=" + version,
		  dataType: "script",
		  cache: true,
		  success: function(){
				window.clearTimeout(timeoutId);
				if (typeof BimServerApi != 'function') {
					notifier.setError("Could not connect");
					errorCallback();
				} else {
					if (BimServerApi != null) {
						var bimServerApi = new BimServerApi(address, notifier);
						bimServerApi.init(callback);
					} else {
						window.clearTimeout(timeoutId);
						notifier.setError("Could not find BIMserver API");
						errorCallback();
					}
				}
		  }
		}).fail(function(jqxhr, settings, exception){
		window.clearTimeout(timeoutId);
		notifier.setError("Could not connect");
		errorCallback();
	});
}