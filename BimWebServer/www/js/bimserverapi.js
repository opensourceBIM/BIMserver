function BimServerApi(baseUrl) {
	var othis = this;

	var url = baseUrl + "/jsonapi";
	
	this.call = function(method, data, callback) {
		data.interface = "ServiceInterface";
		data.method = method;

		var request = {
			request: data
		};

		$.ajax(url, {
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(request),
			dataType: "json",
			success: function(data) {
				if (data.response != null) {
					callback(data.response);
				} else {
					console.log("Error: " + data.exception.message);
				}
			}
		});
	}
}