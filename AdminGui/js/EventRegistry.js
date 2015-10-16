function EventRegistry(){
	var o = this;
	o.registry = [];
	
	this.register = function(fn) {
		var skip = false;
		o.registry.forEach(function(existing){
			if (existing == fn) {
				skip = true;
			}
		});
		if (!skip) {
			o.registry.push(fn);
		}
	};
	
	this.unregister = function(fn) {
		var len = o.registry.length;
		while (len--) {
			if (o.registry[len] == fn) {
				o.registry.splice(len, 1);
			}
		}
	};
	
	this.size = function(){
		return o.registry.length;
	};
	
	this.trigger = function(callback){
		o.registry.forEach(callback);
	};
	
	this.clear = function(){
		o.registry = [];
	};
}