function BimServerApi(baseUrl, notifier) {
	var othis = this;
	othis.token = null;
	othis.baseUrl = baseUrl;
	othis.address = baseUrl + "/jsonapi";
	othis.notifier = notifier;
	othis.server = new BimServerWebSocket(baseUrl);
	othis.user = null;
	othis.listeners = {};
	othis.autoLoginTried = false;

	this.autologin = function(username, autologin, callback, errorCallback) {
		var request = {
			username: username,
			hash: autologin
		};
		othis.call("ServiceInterface", "autologin", request, function(data){
			othis.token = data;
			if (notifier != null) {
				othis.notifier.info("Auto login successful, logout to disable autologin");
			}
			othis.resolveUser();
			callback();
			othis.autoLoginTried = false;
		}, errorCallback);
	};
	
	this.login = function(username, password, rememberme, callback) {
		var request = {
			username: username,
			password: password
		};
		othis.call("ServiceInterface", "login", request, function(data){
			othis.token = data;
			if (rememberme) {
				var autologin = Sha256.hash(username + Sha256.hash(password));
				$.cookie("username", username, { expires: 31 });
				$.cookie("autologin", autologin, { expires: 31 });
				$.cookie("address", othis.baseUrl, { expires: 31 });
			}
			if (notifier != null) {
				othis.notifier.info("Login successful");
			}
			othis.resolveUser();
			callback();
		});
	};

	this.processNotification = function(message) {
		if (othis.listeners[message.interface] != null) {
			if (othis.listeners[message.interface][message.method] != null) {
				othis.listeners[message.interface][message.method].forEach(function(listener) {
					var ar = [];
					var i=0;
					for (var key in message.parameters) {
						ar[i++] = message.parameters[key]; 
					}
					listener.apply(null, ar);
				});
			}
		}
	};
	
	this.resolveUser = function() {
		othis.call("ServiceInterface", "getCurrentUser", {}, function(data){
			othis.user = data;
		});
	};
	
	this.logout = function(callback) {
		$.removeCookie("username");
		$.removeCookie("autologin");
		$.removeCookie("address");
		othis.call("ServiceInterface", "logout", {}, function(){
			if (notifier != null) {
				othis.notifier.info("Logout successful");
			}
			callback();
		});
	};
	
	this.generateRevisionDownloadUrl = function(settings) {
		return othis.baseUrl + "/download?tokenString=" + othis.token.tokenString + "&tokenExpires=" + othis.token.expires + "&longActionId=" + settings.laid + (settings.zip ? "&zip=on" : "") + "&serializerOid=" + settings.serializerOid;
	};

	this.generateExtendedDataDownloadUrl = function(edid) {
		return othis.baseUrl + "/download?tokenString=" + othis.token.tokenString + "&tokenExpires=" + othis.token.expires + "&action=extendeddata&edid=" + edid;
	};
	
	this.openWebSocket = function(callback) {
		if (othis.server.connected) {
			callback();
		} else {
			othis.server.connect(callback);			
		}
	};
	
	this.register = function(interfaceName, methodName, callback) {
		if (othis.listeners[interfaceName] == null) {
			othis.listeners[interfaceName] = {};
		}
		if (othis.listeners[interfaceName][methodName] == null) {
			othis.listeners[interfaceName][methodName] = [];
		}
		othis.listeners[interfaceName][methodName].push(callback);
		othis.openWebSocket(function(){
			othis.callWs("ServiceInterface", "registerAll", {endPointId: othis.server.endPointId});
		});
	};
	
	this.unregister = function(listener) {
		for (var i in othis.listeners) {
			for (var j in othis.listeners[i]) {
				var list = othis.listeners[i][j];
				for (var k=0; k < list.length; k++) {
					if (list[k] === listener){
						list.splice(k, 1);
						return;
					}
				}
			}
		}
	};
	
	this.callWs = function(interfaceName, method, data) {
		var requestObject = {
			request: othis.createRequest(interfaceName, method, data)
		};
		if (othis.token != null) {
			requestObject.token = othis.token;
		}
		othis.server.send(requestObject);
	};
	
	this.createRequest = function(interfaceName, method, data) {
		var object = {};
		object.interface = interfaceName;
		object.method = method;
		object.parameters = data;
		
		return object;
	};
	
	this.multiCall = function(requests, callback, errorCallback) {
		var request = null;
		if (requests.length == 1) {
			var request = requests[0];
			request = {request: othis.createRequest(request[0], request[1], request[2])};
		} else if (requests.length > 1) {
			var requestObjects = [];
			requests.forEach(function(request){
				requestObjects.push(othis.createRequest(request[0], request[1], request[2]));
			});
			request = {
				requests: requestObjects
			};
		}

		if (notifier != null) {
			notifier.clear();
		}
		
		if (othis.token != null) {
			request.token = othis.token;
		}
		
		console.log("request", request);

		$.ajax(othis.address, {
			type: "POST",
			contentType: 'application/json',
			data: JSON.stringify(request),
			dataType: "json",
			success: function(data) {
				console.log("response", data);
				var errorsToReport = [];
				if (requests.length == 1) {
					if (data.response.exception != null) {
						if (data.response.exception.message == "Invalid token" && !othis.autoLoginTried && $.cookie("username") != null && $.cookie("autologin") != null) {
							othis.autologin($.cookie("username"), $.cookie("autologin"), function(){
								console.log("Trying to connect with autologin");
								othis.multiCall(requests, callback, errorCallback);
							});
						} else {
							if (errorCallback == null && notifier != null) {
								othis.notifier.error(data.response.exception.message);
							} else {
								errorsToReport.push(data.response.exception);
							}
						}
					}
				} else if (requests.length > 1) {
					data.responses.forEach(function(response){
						if (response.exception != null) {
							if (errorCallback == null && notifier != null) {
								othis.notifier.error(response.exception.message);
							} else {
								errorsToReport.push(response.exception);
							}
						}
					});
				}
				if (errorsToReport.length > 0) {
					errorCallback(errorsToReport);
				} else {
					if (requests.length == 1) {
						callback(data.response);
					} else if (requests.length > 1) {
						callback(data.responses);
					}
				}
			},
			error: function(){
				if (notifier != null) {
					othis.notifier.error("connection error");
				}
				if (errorCallback != null) {
					errorCallback();
				}
			}
		});		
	};
	
	this.call = function(interfaceName, method, data, callback, errorCallback) {
		othis.multiCall([[
		    interfaceName,
			method,
			data
		]], function(data){
			if (data.exception == null) {
				callback(data.result);
			}
		}, errorCallback == null ? null : function(error){
			errorCallback(error);
		});
	};
	
	othis.server.listener = othis.processNotification;
}

function BimServerWebSocket(baseUrl) {
	var othis = this;
	this.connected = false;
	this.openCallbacks = [];
	this.endPointId = null;
	this.listener = null;
	
	this.connect = function(callback) {
		othis.openCallbacks.push(callback);
		var location = baseUrl.toString().replace('http://', 'ws://').replace('https://', 'wss://');
		var index = location.indexOf("/", 5);
		if (index == -1) {
			location = location + "/stream";
		} else {
			location = location.substring(0, index) + "/stream";
		}
		this._ws = new WebSocket(location);
		this._ws.onopen = this._onopen;
		this._ws.onmessage = this._onmessage;
		this._ws.onclose = this._onclose;
	};

	this._onopen = function() {
	};

	this._send = function(message) {
		if (this._ws) {
			this._ws.send(message);
		}
	};

	this.send = function(object) {
		othis._send(JSON.stringify(object));
	};

	this._onmessage = function(message) {
		var incomingMessage = JSON.parse(message.data);
		console.log("incoming", incomingMessage);
		if (incomingMessage.endpointid != null) {
			othis.endPointId = incomingMessage.endpointid;
			othis.connected = true;
			othis.openCallbacks.forEach(function(callback){
				callback();
			});
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
	};

	this._onclose = function(m) {
		othis._ws = null;
		othis.connected = false;
		othis.openCallbacks = [];
		othis.endpointid = null;
	};
}