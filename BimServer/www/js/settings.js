var Settings = {
	getServerList: function(callback){
		$.getJSON("http://extend.bimserver.org/serverlist", function(data, textStatus, jqXHR){
			console.log(data);
			callback(data.servers);
		}).error(function(error) {console.log(error); });
	},
	getMenuItems: function(){
		return [
		        "serversettingsLink",
		        "serverinfoLink"
		];
	}
}