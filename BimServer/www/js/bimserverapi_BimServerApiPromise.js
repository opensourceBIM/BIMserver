define(function(){
	return function(counter){
		var o = this;
		
		o.isDone = false;
		o.chains = [];
		o.callback = null;
		o.counter = counter;

		this.done = function(callback){
			if (o.isDone) {
				callback();
			} else {
				if (o.callback != null) {
					if (o.callback instanceof Array) {
						o.callback.push(callback);
					} else {
						o.callback = [o.callback, callback];
					}
				} else {
					o.callback = callback;
				}
			}
			return o;
		};
		
		this.inc = function(){
			if (o.counter == null) {
				o.counter = 0;
			}
			o.counter++;
		};

		this.dec = function(){
			if (o.counter == null) {
				o.counter = 0;
			}
			o.counter--;
			if (o.counter == 0) {
				o.done = true;
				o.fire();
			}
		};

		this.fire = function(){
			if (o.isDone) {
				console.log("Promise already fired, not triggering again...");
				return;
			}
			o.isDone = true;
			if (o.callback != null) {
				if (o.callback instanceof Array) {
					o.callback.forEach(function(cb){
						cb();
					});
				} else {
					o.callback();
				}
			}
		};
		
		this.chain = function(otherPromise) {
			var promises;
			if (otherPromise instanceof Array) {
				promises = otherPromise;
			} else {
				promises = [otherPromise];
			}
			promises.forEach(function(promise){
				if (!promise.isDone) {
					o.chains.push(promise);
					promise.done(function(){
						for (var i=o.chains.length-1; i>=0; i--) {
							if (o.chains[i] == promise) {
								o.chains.splice(i, 1);
							}
						}
						if (o.chains.length == 0) {
							o.fire();
						}
					});
				}
			});
			if (o.chains.length == 0) {
				o.fire();
			}
		};
	};
});