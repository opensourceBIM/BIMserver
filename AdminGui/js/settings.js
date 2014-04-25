var Settings = {
	getServerList: function(callback){
		$.getJSON("http://extend.bimserver.org/serverlist", function(data, textStatus, jqXHR){
			callback(data.servers);
		}).error(function(error) {console.log(error); });
	},
	createStartPage: function(container, main){
		main.pageChanger.changePage($(".serverinfoLink"), "start.html", function(){
			return new Start($(this), main);
		});
	},
	getStaticServerAddress: function(callback){
		$.getJSON("getbimserveraddress", function(data){
			callback(data.address);
		});
	},
	getTitle: function(){
		return "BIMserver Admin GUI";
	},
	usableBimServerVersion: function(version) {
		return version.major == 1 && version.minor == 3 && version.revision == 0;
	},
	getMenuItems: function(){
		return [
	        "serversettingsLink",
	        "gettingStartedLink"
		];
	},
	allowBimServerAddress: function() {
		return false;
	},
	getPlugins: function(){
		return {
		};
	},
}