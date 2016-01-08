define([], function(){
	return function(baseUrl, bimServerApi) {
		var othis = this;
		this.connected = false;
		this.openCallbacks = [];
		this.endPointId = null;
		this.listener = null;
		this.tosend = [];
		this.tosendAfterConnect = [];
		this.messagesReceived = 0;
		this.intervalId = null;
	
		this.connect = function(callback) {
			if (callback != null && typeof callback === "function") {
				othis.openCallbacks.push(callback);
			} else {
				console.error("Callback was not a function", callback);
			}
			var location = bimServerApi.baseUrl.toString().replace('http://', 'ws://').replace('https://', 'wss://') + "/stream";
			if ("WebSocket" in window) {
				try {
					this._ws = new WebSocket(location);
					this._ws.binaryType = "arraybuffer";
					this._ws.onopen = this._onopen;
					this._ws.onmessage = this._onmessage;
					this._ws.onclose = this._onclose;
					this._ws.onerror = this._onerror;
				} catch (err) {
					bimServerApi.notifier.setError("WebSocket error" + (err.message != null ? (": " + err.message) : ""));
				}
			} else {
				bimServerApi.notifier.setError("This browser does not support websockets <a href=\"https://github.com/opensourceBIM/bimvie.ws/wiki/Requirements\"></a>");
			}
		};
	
		this._onerror = function(err) {
			console.log(err);
			bimServerApi.notifier.setError("WebSocket error" + (err.message != null ? (": " + err.message) : ""));
		};
	
		this._onopen = function() {
			othis.intervalId = window.setInterval(function(){
				othis.send({"hb": true});
			}, 30 * 1000); // Send hb every 30 seconds
			while (othis.tosendAfterConnect.length > 0 && othis._ws.readyState == 1) {
				var messageArray = othis.tosendAfterConnect.splice(0, 1);
				othis._sendWithoutEndPoint(messageArray[0]);
			}
		};
	
		this._sendWithoutEndPoint = function(message) {
			if (othis._ws && othis._ws.readyState == 1) {
				othis._ws.send(message);
			} else {
				othis.tosendAfterConnect.push(message);
			}		
		};
		
		this._send = function(message) {
			if (othis._ws && othis._ws.readyState == 1 && othis.endPointId != null) {
				othis._ws.send(message);
			} else {
				console.log("Waiting", message);
				othis.tosend.push(message);
			}
		};
	
		this.send = function(object) {
			var str = JSON.stringify(object);
			bimServerApi.log("Sending", str);
			othis._send(str);
		};
	
		this._onmessage = function(message) {
			othis.messagesReceived++;
			if (othis.messagesReceived % 10 == 0) {
	//			console.log(othis.messagesReceived);
			}
			if (message.data instanceof ArrayBuffer) {
				othis.listener(message.data);
			} else {
				var incomingMessage = JSON.parse(message.data);
				bimServerApi.log("incoming", incomingMessage);
				if (incomingMessage.welcome != null) {
					othis._sendWithoutEndPoint(JSON.stringify({"token": bimServerApi.token}));
				} else if (incomingMessage.endpointid != null) {
					othis.endPointId = incomingMessage.endpointid;
					othis.connected = true;
					othis.openCallbacks.forEach(function(callback){
						callback();
					});
					while (othis.tosend.length > 0 && othis._ws.readyState == 1) {
						var messageArray = othis.tosend.splice(0, 1);
						console.log(messageArray[0]);
						othis._send(messageArray[0]);
					}
					othis.openCallbacks = [];
				} else {
					if (incomingMessage.request != null) {
						othis.listener(incomingMessage.request);
					} else if (incomingMessage.requests != null) {
						incomingMessage.requests.forEach(function(request){
							othis.listener(request);
						});
					}
				}
			}
		};
	
		this._onclose = function(m) {
			console.log("WebSocket closed");
			window.clearInterval(othis.intervalId);
			othis._ws = null;
			othis.connected = false;
			othis.openCallbacks = [];
			othis.endpointid = null;
		};
	}
});