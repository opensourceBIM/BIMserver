var ConsoleSettings = {
	title: "BIMserver API",
	subtitle: "Execute your own calls and get to learn the way of the BIMserver",
	getBaseUrl: function(){
		return "http://sandbox.bimserver.org"
	},
	getStaticServerAddress: function(callback){
		$.getJSON("getbimserveraddress", function(data){
			callback(data.address);
		});
	},
	getVersion: function(){
		return "1.3";
	}, getServiceInterfaces: function(consoleObject, callback){
		var request = {
			request: {
				interface: "org.bimserver.MetaInterface",
				method: "getAllAsJson"
			}
		};
		consoleObject.call(request, function(data){
			callback(JSON.parse(data.response.result).services);
		});
	}
}