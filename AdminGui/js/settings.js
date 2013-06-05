var Settings = {
	getServerList: function(callback){
		$.getJSON("http://extend.bimserver.org/serverlist", function(data, textStatus, jqXHR){
			callback(data.servers);
		}).error(function(error) {console.log(error); });
	},
	getStaticServerAddress: function(callback){
		$.getJSON("getbimserveraddress", function(data){
			callback(data.address);
		});
	},
	getMenuItems: function(){
		return [
		        "serversettingsLink",
		        "serverinfoLink"
		];
	},
	allowBimServerAddress: function() {
		return false;
	}
}