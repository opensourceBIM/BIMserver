function PluginManager() {
	var o = this;
	o.byType = {};

	this.allOfType = function(type, callback){
		if (o.byType[type] != null) {
			o.byType[type].forEach(function(plugin){
				var pluginInstance = Object.create(plugin.prototype);
				if (Settings.getPlugins()[pluginInstance.getName()].enabled) {
					callback(plugin);
				}
			});
		}
	};
	
	this.register = function(pluginConstructor){
		var plugin = Object.create(pluginConstructor.prototype);
		var type = plugin.getType();
		if (o.byType[type] == null) {
			o.byType[type] = [];
		}
		o.byType[type].push(pluginConstructor);
	};
}

Global.pluginManager = new PluginManager();