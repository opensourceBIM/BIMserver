function loadBimServerApi(address, notifier, version, callback, errorCallback) {
	requirejs.config({
	    baseUrl: address + "/js",
	    urlArgs: "bust=" + version
	});

	requirejs(["bimserverapi_BimServerApi", "bimserverapi_BimServerApiPromise"], function(BimServerApi, BimServerApiPromise) {
		if (window.Global == null) {
			window.Global = {};
		}
		// Convenience hack for now, until BIMvie.ws is converted to requirejs as well
		window.BimServerApiPromise = BimServerApiPromise;
		
		if (address.endsWith("/")) {
			address = address.substring(0, address.length - 1);
		}
		if (BimServerApi != null) {
			var bimServerApi = new BimServerApi(address, notifier);
			bimServerApi.init(callback);
		} else {
			notifier.setError("Could not find BIMserver API");
			errorCallback();
		}
	}, function (err) {
		console.log(err);
		notifier.setError("Error " + err);
		errorCallback();
	});
}