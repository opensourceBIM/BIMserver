function Variable(initialValue) {
	var o = this;
	o.value = initialValue;
	o.eventRegistry = new EventRegistry();
	
	this.set = function(value){
		o.value = value;
		o.eventRegistry.trigger(function(cb){
			cb(value);
		});
	};
	
	this.get = function(){
		return o.value;
	};
	
	this.register = o.eventRegistry.register;
	this.unregister = o.eventRegistry.unregister;	
}
