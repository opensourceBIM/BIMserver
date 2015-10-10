define(function(){
	return function(fetcher) {
		var othis = this;
		othis.result = null;
		othis.state = "none";
		othis.waiters = [];

		this.notify = function(result){
			othis.result = result;
			othis.state = "done";
			othis.waiters.forEach(function(waiter){
				waiter(result);
			});
			othis.waiters = [];
		};

		this.fetch = function(callback){
			if (othis.state == "none") {
				othis.waiters.push(callback)
				othis.state = "fetching";
				fetcher(othis.notify);
			} else if (othis.state == "done") {
				callback(othis.result);
			} else if (othis.state == "fetching") {
				othis.waiters.push(callback)
			}
		};
	}
});