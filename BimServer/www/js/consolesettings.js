var ConsoleSettings = {
	title: "BIMserver API",
	subtitle: "Execute your own calls and get to learn the way of the BIMserver",
	getBaseUrl: function(){
		return "http://sandbox.bimserver.org"
	},
	getVersion: function(){
		return "1.2";
	}, getServiceInterfaces: function(consoleObject, callback){
		var request = {
			request: {
				interface: "org.bimserver.MetaInterface",
				method: "getServiceInterfaces"
			}
		};
		consoleObject.call(request, function(data){
			callback(data.response.result);
		});
	}, getServiceMethods: function(consoleObject, serviceInterfaces, callback){
		console.log(serviceInterfaces);
		var request = {
			requests: [
			]
		}
		serviceInterfaces.forEach(function(serviceInterface){
			request.requests.push({
				interface: "org.bimserver.MetaInterface",
				method: "getServiceMethods",
				parameters: serviceInterface
			});
		});
		consoleObject.call(request, function(data){
			callback(data.responses);
		});
	}
}