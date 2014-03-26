function CountingPromise() {
	var o = this;
	o.count = 0;
	o.doneSomething = false;
	
	this.inc = function(){
		o.count++;
		o.doneSomething = true;
	};
	
	this.dec = function(){
		o.count--;
		if (o.count == 0) {
			o.fire();
		}
	};
	
	this.done = function(callback){
		if (o.doneSomething && o.count == 0) {
			callback();
		} else {
			o.callback = callback;
		}
	};
	
	this.fire = function(){
		if (o.callback != null) {
			o.callback();
		}
	};
}


function Promise() {
	var o = this;

	this.isDone = false;
	
	this.done = function(callback){
		if (o.isDone) {
			callback();
		} else {
			o.callback = callback;
		}
	};

	this.fire = function(){
		o.isDone = true;
		if (o.callback != null) {
			o.callback();
		}
	};
}

function formatAccessMethod(accessMethod) {
	if (accessMethod == "INTERNAL") {
		return "Internal";
	} else if (accessMethod == "JSON") {
		return "JSON";
	} else if (accessMethod == "WEB_INTERFACE") {
		return "Web Interface";
	} else {
		return accessMethod;
	}
}

function formatUserType(type) {
	if (type == "SYSTEM") {
		return "System";
	} else if (type == "ADMIN") {
		return "Administrator";
	} else if (type == "USER") {
		return "User";
	} else if (type == "READ_ONLY") {
		return "Read only";
	}
}

function formatTrigger(trigger) {
	if (trigger == "NEW_REVISION") {
		return "New revision";
	} else if (trigger == "NEW_EXTENDED_DATA") {
		return "New extended data";
	} else if (trigger == "NEW_PROJECT") {
		return "New project";
	}
}

function stripIfc(input) {
	if (input.startsWith("Ifc")) {
		return input.substring(3);
	} else {
		return input;
	}
}