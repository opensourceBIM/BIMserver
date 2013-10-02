var Settings = {
	getServerList: function(callback){
		$.getJSON("http://extend.bimserver.org/serverlist", function(data, textStatus, jqXHR){
			callback(data.servers);
		}).error(function(error) {console.log(error); });
	},
	getMenuItems: function(){
		return [
		        "serversettingsLink",
		        "serverinfoLink"
		];
	},
	allowBimServerAddress: function() {
		return true;
	}
}