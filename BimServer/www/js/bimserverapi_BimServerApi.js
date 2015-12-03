"use strict"

// NodeJS stuff
if (XMLHttpRequest == null) {
	XMLHttpRequest = require("xhr2");
}

define(
    ["bimserverapi_BimServerWebSocket", "bimserverapi_BimServerApiPromise", "bimserverapi_Model", "bimserverapi_Ifc2x3tc1", "bimserverapi_Ifc4", "bimserverapi_Translations_EN"], 
    function(BimServerWebSocket, BimServerApiPromise, Model, ifc2x3tc1, ifc4, translations){
    	return function(baseUrl, notifier) {
	    	var othis = this;
	    	
	    	othis.interfaceMapping = {
	    		"ServiceInterface": "org.bimserver.ServiceInterface",
	    		"AuthInterface": "org.bimserver.AuthInterface",
	    		"SettingsInterface": "org.bimserver.SettingsInterface",
	    		"AdminInterface": "org.bimserver.AdminInterface",
	    		"PluginInterface": "org.bimserver.PluginInterface",
	    		"MetaInterface": "org.bimserver.MetaInterface",
	    		"Bimsie1LowLevelInterface": "org.buildingsmart.bimsie1.Bimsie1LowLevelInterface",
	    		"Bimsie1NotificationRegistryInterface": "org.buildingsmart.bimsie1.Bimsie1NotificationRegistryInterface",
	    		"Bimsie1AuthInterface": "org.buildingsmart.bimsie1.Bimsie1AuthInterface",
	    		"Bimsie1ServiceInterface": "org.buildingsmart.bimsie1.Bimsie1ServiceInterface"
	    	};
	
	    	// Current BIMserver token
	    	othis.token = null;
	    	
	    	// Base URL of the BIMserver
	    	othis.baseUrl = baseUrl;
	    	if (othis.baseUrl.substring(othis.baseUrl.length - 1) == "/") {
	    		othis.baseUrl = othis.baseUrl.substring(0, othis.baseUrl.length - 1);
	    	}
	    	
	    	// JSON endpoint on BIMserver
	    	othis.address = othis.baseUrl + "/json";
	    	
	    	// Notifier, default implementation does nothing
	    	othis.notifier = notifier;
	    	if (othis.notifier == null) {
	    		othis.notifier = {
	    			setInfo: function(message, timeout){},
	    			setSuccess: function(message, timeout){},
	    			setError: function(){},
	    			resetStatus: function(){},
	    			resetStatusQuick: function(){},
	    			clear: function(){}
	    		};
	    	}
	    	
	    	// The websocket client
	    	othis.webSocket = new BimServerWebSocket(baseUrl, othis);
	    	
	    	// Cached user object
	    	othis.user = null;
	    	
	    	othis.listeners = {};   	
	    	
//	    	othis.autoLoginTried = false;
	    	
	    	// Cache for serializers, PluginClassName(String) -> Serializer
	    	othis.serializersByPluginClassName = [];

	    	// Whether debugging is enabled, just a lot more logging
	    	othis.debug = false;
	    	
	    	// Mapping from ChannelId -> Listener (function)
	    	othis.binaryDataListener = {};
	    	
	    	// This mapping keeps track of the prototype objects per class, will be lazily popuplated by the getClass method
	    	othis.classes = {};
	    	
	    	// Schema name (String) -> Schema
	    	othis.schemas = {};
	
	    	this.init = function(callback) {
	    		othis.call("AdminInterface", "getServerInfo", {}, function(serverInfo){
	    			othis.version = serverInfo.version;
	    			var versionString = othis.version.major + "." + othis.version.minor + "." + othis.version.revision;
	
					othis.schemas["ifc2x3tc1"] = ifc2x3tc1.classes;
					othis.addSubtypesToSchema(ifc2x3tc1.classes);

					othis.schemas["ifc4"] = ifc4.classes;
					othis.addSubtypesToSchema(ifc4.classes);

					callback(othis, serverInfo);
	    		});
	    	};
	
	    	this.addSubtypesToSchema = function(classes) {
	    		for (var typeName in classes) {
	    			var type = classes[typeName];
	    			if (type.superclasses != null) {
	    				type.superclasses.forEach(function(superClass){
	    					var directSubClasses = classes[superClass].directSubClasses;
	    					if (directSubClasses == null) {
	    						directSubClasses = [];
	    						classes[superClass].directSubClasses = directSubClasses;
	    					}
	    					directSubClasses.push(typeName);
	    				});
	    			}
	    		}
	    	};
	    	
	    	this.getAllSubTypes = function(schema, typeName, callback) {
	    		var type = schema[typeName];
	    		if (type.directSubClasses != null) {
	    			type.directSubClasses.forEach(function(subTypeName){
	    				callback(subTypeName);
	    				othis.getAllSubTypes(schema, subTypeName, callback);
	    			});
	    		}
	    	};
	    	
	    	this.log = function(message, message2){
	    		if (othis.debug) {
	    			console.log(message, message2);
	    		}
	    	};
	    	
	    	this.translate = function(key) {
	    		key = key.toUpperCase();
	    		if (translations != null) {
	    			return translations[key];
	    		}
	    		othis.log("translation for " + key + " not found");
	    		return key;
	    	};
	
	    	this.login = function(username, password, callback, errorCallback, options) {
	    		if (options == null) {
	    			options = {};
	    		}
	    		var request = {
	    			username: username,
	    			password: password
	    		};
	    		othis.call("Bimsie1AuthInterface", "login", request, function(data){
	    			othis.token = data;
	    			if (options.done != false) {
	    				othis.notifier.setInfo("Login successful", 2000);
	    			}
	    			othis.resolveUser();
	    			othis.webSocket.connect(callback);
	    		}, errorCallback, options.busy == false ? false : true, options.done == false ? false : true, options.error == false ? false : true);
	    	};
	
	    	this.downloadViaWebsocket = function(msg){
	    		msg.action = "download";
	    		msg.token = othis.token;
	    		othis.webSocket.send(msg);
	    	};
	    	
	    	this.setBinaryDataListener = function(channelId, listener){
	    		othis.binaryDataListener[channelId] = listener;
	    	};
	    	
	    	this.processNotification = function(message) {
	    		if (message instanceof ArrayBuffer) {
	    			var view = new DataView(message, 0, 4);
	    			var channelId = view.getInt32(0);
	    			var listener = othis.binaryDataListener[channelId];
	    			listener(message);
	    		} else {
	    			var intf = message["interface"];
	    			if (othis.listeners[intf] != null) {
	    				if (othis.listeners[intf][message.method] != null) {
	    					var ar = null;
	    					othis.listeners[intf][message.method].forEach(function(listener) {
	    						if (ar == null) {
	    							// Only parse the arguments once, or when there are no listeners, not even once
	    							ar = [];
	    							var i=0;
	    							for (var key in message.parameters) {
	    								ar[i++] = message.parameters[key];
	    							}
	    						}
	    						listener.apply(null, ar);
	    					});
	    				} else {
	    					console.log("No listeners on interface " + intf + " for method " + message.method);
	    				}
	    			} else {
	    				console.log("No listeners for interface " + intf);
	    			}
	    		}
	    	};
	
	    	this.resolveUser = function(callback) {
	    		othis.call("AuthInterface", "getLoggedInUser", {}, function(data){
	    			othis.user = data;
	    			if (callback != null) {
	    				callback(othis.user);
	    			}
	    		});
	    	};
	
	    	this.logout = function(callback) {
	    		othis.call("Bimsie1AuthInterface", "logout", {}, function(){
	    			othis.notifier.setInfo("Logout successful");
	    			callback();
	    		});
	    	};
	
	    	this.generateRevisionDownloadUrl = function(settings) {
	    		return othis.baseUrl + "/download?token=" + othis.token + (settings.zip ? "&zip=on" : "") + "&serializerOid=" + settings.serializerOid + "&topicId=" + settings.topicId;
	    	};
	
	    	this.generateExtendedDataDownloadUrl = function(edid) {
	    		return othis.baseUrl + "/download?token=" + othis.token + "&action=extendeddata&edid=" + edid;
	    	};

	    	this.getJsonSerializer = function(callback) {
	    		othis.getSerializerByPluginClassName("org.bimserver.serializers.JsonSerializerPlugin", callback);
	    	};

	    	this.getJsonStreamingSerializer = function(callback) {
	    		othis.getSerializerByPluginClassName("org.bimserver.serializers.JsonStreamingSerializerPlugin", callback);
	    	};
	    	
	    	this.getSerializerByPluginClassName = function(pluginClassName, callback) {
	    		if (othis.serializersByPluginClassName[pluginClassName] == null) {
	    			othis.call("PluginInterface", "getSerializerByPluginClassName", {pluginClassName : pluginClassName}, function(serializer) {
	    				othis.serializersByPluginClassName[pluginClassName] = serializer;
	    				callback(serializer);
	    			});
	    		} else {
	    			callback(othis.serializersByPluginClassName[pluginClassName]);
	    		}
	    	};
	
	    	this.getMessagingSerializerByPluginClassName = function(pluginClassName, callback) {
	    		if (othis.serializersByPluginClassName[pluginClassName] == null) {
	    			othis.call("PluginInterface", "getMessagingSerializerByPluginClassName", {pluginClassName : pluginClassName}, function(serializer) {
	    				othis.serializersByPluginClassName[pluginClassName] = serializer;
	    				callback(serializer);
	    			});
	    		} else {
	    			callback(othis.serializersByPluginClassName[pluginClassName]);
	    		}
	    	};
	
	    	this.register = function(interfaceName, methodName, callback, registerCallback) {
	    		if (callback == null) {
	    			throw "Cannot register null callback";
	    		}
	    		if (othis.listeners[interfaceName] == null) {
	    			othis.listeners[interfaceName] = {};
	    		}
	    		if (othis.listeners[interfaceName][methodName] == null) {
	    			othis.listeners[interfaceName][methodName] = [];
	    		}
	    		othis.listeners[interfaceName][methodName].push(callback);
	    		if (registerCallback != null) {
	    			registerCallback();
	    		}
	    	};
	
	    	this.registerNewRevisionOnSpecificProjectHandler = function(poid, handler, callback){
	    		othis.register("Bimsie1NotificationInterface", "newRevision", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewRevisionOnSpecificProjectHandler", {endPointId: othis.webSocket.endPointId, poid: poid}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	
	    	this.registerNewExtendedDataOnRevisionHandler = function(roid, handler, callback){
	    		othis.register("Bimsie1NotificationInterface", "newExtendedData", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewExtendedDataOnRevisionHandler", {endPointId: othis.webSocket.endPointId, roid: roid}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	    	
	    	this.registerNewUserHandler = function(handler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newUser", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewUserHandler", {endPointId: othis.webSocket.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	
	    	this.unregisterNewUserHandler = function(handler, callback) {
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewUserHandler", {endPointId: othis.webSocket.endPointId}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.unregisterChangeProgressProjectHandler = function(poid, newHandler, closedHandler, callback) {
	    		othis.unregister(newHandler);
	    		othis.unregister(closedHandler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnProject", {poid: poid, endPointId: othis.webSocket.endPointId}, callback);
	    	};
	
	    	this.registerChangeProgressProjectHandler = function(poid, newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnProjectTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnProjectTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnProject", {poid: poid, endPointId: othis.webSocket.endPointId}, function(){
	    					if (callback != null) {
	    						callback();
	    					}
	    				});
	    			});
	    		});
	    	}
	
	    	this.unregisterChangeProgressServerHandler = function(newHandler, closedHandler, callback) {
	    		othis.unregister(newHandler);
	    		othis.unregister(closedHandler);
	    		if (othis.webSocket.endPointId != null) {
	    			othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnServer", {endPointId: othis.webSocket.endPointId}, callback);
	    		}
	    	};
	
	    	this.registerChangeProgressServerHandler = function(newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnServerTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnServerTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnServer", {endPointId: othis.webSocket.endPointId}, function(){
	    					if (callback != null) {
	    						callback();
	    					}
	    				});
	    			});
	    		});
	    	}
	
	    	this.unregisterChangeProgressRevisionHandler = function(roid, newHandler, closedHandler, callback) {
	    		othis.unregister(newHandler);
	    		othis.unregister(closedHandler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnProject", {roid: roid, endPointId: othis.webSocket.endPointId}, callback);
	    	};
	
	    	this.registerChangeProgressRevisionHandler = function(poid, roid, newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnRevisionTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnRevisionTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnRevision", {poid: poid, roid: roid, endPointId: othis.webSocket.endPointId}, function(){
	    					if (callback != null) {
	    						callback();
	    					}
	    				});
	    			});
	    		});
	    	}
	
	    	this.registerNewProjectHandler = function(handler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProject", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewProjectHandler", {endPointId: othis.webSocket.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	}
	
	    	this.unregisterNewProjectHandler = function(handler, callback){
	    		othis.unregister(handler);
	    		if (othis.webSocket.endPointId != null) {
	    			othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewProjectHandler", {endPointId: othis.webSocket.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		}
	    	};
	
	    	this.unregisterNewRevisionOnSpecificProjectHandler = function(poid, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewRevisionOnSpecificProjectHandler", {endPointId: othis.webSocket.endPointId, poid: poid}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.unregisterNewExtendedDataOnRevisionHandler = function(roid, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewExtendedDataOnRevisionHandler", {endPointId: othis.webSocket.endPointId, roid: roid}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.registerProgressHandler = function(topicId, handler, callback){
	    		othis.register("Bimsie1NotificationInterface", "progress", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerProgressHandler", {topicId: topicId, endPointId: othis.webSocket.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				} else {
	    					othis.call("Bimsie1NotificationRegistryInterface", "getProgress", {
	    						topicId: topicId
	    					}, function(state){
	    						handler(topicId, state);
	    					});
	    				}
	    			});
	    		});
	    	};
	
	    	this.unregisterProgressHandler = function(topicId, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterProgressHandler", {topicId: topicId, endPointId: othis.webSocket.endPointId}, function(){
	    		}).done(callback);
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
	
	    	this.createRequest = function(interfaceName, method, data) {
	    		var object = {};
	    		object["interface"] = interfaceName;
	    		object.method = method;
	    		object.parameters = data;
	
	    		return object;
	    	};
	    	
	    	this.getJson = function(address, data, success, error){
	    		var xhr = new XMLHttpRequest();
	    		xhr.open("POST", address);
	    		xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8");
	    		xhr.onload = function(jqXHR, textStatus, errorThrown) {
	    		    if (xhr.status === 200) {
	    		    	try {
	    		    		var data = JSON.parse(xhr.responseText);
	    		    		success(data);
	    		    	} catch (e) {
	    		    		if (error != null) {
	    		    			error(e);
	    		    		} else {
	    		    			othis.notifier.setError(e);
	    		    			console.error(e);
	    		    		}
	    		    	}
	    		    } else {
	    		    	if (error != null) {
	    		    		error(jqXHR, textStatus, errorThrown);
	    		    	} else {
	    		    		othis.notifier.setError(textStatus);
	    		    		console.error(jqXHR, textStatus, errorThrown);
	    		    	}
	    		    }
	    		};
	    		xhr.send(JSON.stringify(data));
	    	};
	    	
	    	this.multiCall = function(requests, callback, errorCallback, showBusy, showDone, showError) {
	    		var promise = new BimServerApiPromise();
	    		var request = null;
	    		if (requests.length == 1) {
	    			request = requests[0];
	    			if (othis.interfaceMapping[request[0]] == null) {
	    				othis.log("Interface " + request[0] + " not found");
	    			}
	    			request = {request: othis.createRequest(othis.interfaceMapping[request[0]], request[1], request[2])};
	    		} else if (requests.length > 1) {
	    			var requestObjects = [];
	    			requests.forEach(function(request){
	    				requestObjects.push(othis.createRequest(othis.interfaceMapping[request[0]], request[1], request[2]));
	    			});
	    			request = {
	    				requests: requestObjects
	    			};
	    		} else if (requests.length == 0) {
	    			promise.fire();
	    			callback();
	    		}
	
	//    		othis.notifier.clear();
	
	    		if (othis.token != null) {
	    			request.token = othis.token;
	    		}
	
	    		var key = requests[0][1];
	    		requests.forEach(function(item, index){
	    			if (index > 0) {
	    				key += "_" + item;
	    			}
	    		});
	
	    		var showedBusy = false;
	    		if (showBusy) {
	    			if (othis.lastBusyTimeOut != null) {
	    				clearTimeout(othis.lastBusyTimeOut);
	    				othis.lastBusyTimeOut = null;
	    			}
	    			if (typeof window !== 'undefined' && window.setTimeout != null) {
	    				othis.lastBusyTimeOut = window.setTimeout(function(){
	    					othis.notifier.setInfo(othis.translate(key + "_BUSY"), -1);
	    					showedBusy = true;
	    				}, 200);
	    			}
	    		}
	
	//    		othis.notifier.resetStatusQuick();
	
	    		othis.log("request", request);
	
	    		othis.getJson(othis.address, request, function(data) {
    				othis.log("response", data);
    				var errorsToReport = [];
    				if (requests.length == 1) {
    					if (showBusy) {
    						if (othis.lastBusyTimeOut != null) {
    							clearTimeout(othis.lastBusyTimeOut);
    						}
    					}
    					if (data.response.exception != null) {
//	    						if (data.response.exception.message == "Invalid token" && !othis.autoLoginTried && $.cookie("username" + window.document.location.port) != null && $.cookie("autologin" + window.document.location.port) != null) {
//	    							othis.autologin($.cookie("username" + window.document.location.port), $.cookie("autologin" + window.document.location.port), function(){
//	    								othis.log("Trying to connect with autologin");
//	    								othis.multiCall(requests, callback, errorCallback);
//	    							});
//	    						} else {
    							if (showError) {
    								if (othis.lastTimeOut != null) {
    									clearTimeout(othis.lastTimeOut);
    								}
    								othis.notifier.setError(data.response.exception.message);
    							} else {
    								if (showedBusy) {
    									othis.notifier.resetStatus();
    								}
    							}
//	    						}
    					} else {
    						if (showDone) {
    							othis.notifier.setSuccess(othis.translate(key + "_DONE"), 5000);
    						} else {
    							if (showedBusy) {
    								othis.notifier.resetStatus();
    							}
    						}
    					}
    				} else if (requests.length > 1) {
    					data.responses.forEach(function(response){
    						if (response.exception != null) {
    							if (errorCallback == null) {
    								othis.notifier.setError(response.exception.message);
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
    				promise.fire();
    			},
    			function(jqXHR, textStatus, errorThrown){
    				if (textStatus == "abort") {
    					// ignore
    				} else {
    					othis.log(errorThrown);
    					othis.log(textStatus);
    					othis.log(jqXHR);
    					if (othis.lastTimeOut != null) {
    						clearTimeout(othis.lastTimeOut);
    					}
    					othis.notifier.setError("ERROR_REMOTE_METHOD_CALL");
    				}
    				if (callback != null) {
    					var result = new Object();
    					result.error = textStatus;
    					result.ok = false;
    					callback(result);
    				}
    				promise.fire();
    			});
	    		return promise;
	    	};
	
	    	this.getModel = function(poid, roid, schema, deep, callback) {
	    		var model = new Model(othis, poid, roid, schema);
	    		model.load(deep, callback);
	    		return model;
	    	};
	
	    	this.createModel = function(poid, callback) {
	    		var model = new Model(othis, poid);
	    		model.init(callback);
	    		return model;
	    	};
	
	    	this.callWithNoIndication = function(interfaceName, methodName, data, callback) {
	    		return othis.call(interfaceName, methodName, data, callback, null, false, false, false);
	    	};
	
	    	this.callWithFullIndication = function(interfaceName, methodName, data, callback) {
	    		return othis.call(interfaceName, methodName, data, callback, null, true, true, true);
	    	};
	
	    	this.callWithUserErrorIndication = function(action, data, callback) {
	    		return othis.call(interfaceName, methodName, data, callback, null, false, false, true);
	    	};
	
	    	this.callWithUserErrorAndDoneIndication = function(action, data, callback) {
	    		return othis.call(interfaceName, methodName, data, callback, null, false, true, true);
	    	};
	
	    	this.isA = function(schema, typeSubject, typeName){
	    		var isa = false;
	    		if (typeSubject == typeName) {
	    			return true;
	    		}
	    		var subject = othis.schemas[schema][typeSubject];
	    		if (subject == null) {
	    			console.log(typeSubject, "not found");
	    		}
	    		subject.superclasses.some(function(superclass){
	    			if (superclass == typeName) {
	    				isa = true;
	    				return true;
	    			}
	    			if (othis.isA(schema, superclass, typeName)) {
	    				isa = true;
	    				return true;
	    			}
	    			return false;
	    		});
	    		return isa;
	    	};
	
	    	this.initiateCheckin = function(project, deserializerOid, callback){
	    		othis.call("ServiceInterface", "initiateCheckin", {
	    			deserializerOid: deserializerOid,
	    			poid: project.oid
	    		}, function(topicId){
	    			if (callback != null) {
	    				callback(topicId);
	    			}
	    		});
	    	};
	    	
	    	this.checkin = function(topicId, project, comment, file, deserializerOid, progressListener, success, error){
	    		var xhr = new XMLHttpRequest();
	    		
	    		xhr.upload.addEventListener("progress",
	    			function(e) {
	    				if (e.lengthComputable) {
	    					var percentage = Math.round((e.loaded * 100) / e.total);
	    					progressListener(percentage);
	    				}
	    			}, false);
	
	    		xhr.addEventListener("load", function(e) {
	    			var result = JSON.parse(this.response);
	    			
	    			if (result.exception == null) {
	    				if (success != null) {
	    					success(result.checkinid);
	    				}
	    			} else {
	    				if (error == null) {
	    					console.error(result.exception);
	    				} else {
	    					error(result.exception);
	    				}
	    			}
	    		}, false);
	    		xhr.open("POST", Global.bimServerApi.baseUrl + "/upload");

	    		var formData = new FormData();
    			formData.append("token", othis.token);
    			formData.append("deserializerOid", deserializerOid);
    			formData.append("comment", comment);
    			formData.append("poid", project.oid);
    			formData.append("topicId", topicId);
    			formData.append("file", file);

    			xhr.send(formData);
	    	};

	    	this.addExtendedData = function(roid, file, success, error){
	    		var reader = new FileReader();
	    		var xhr = new XMLHttpRequest();
	    		
	    		xhr.addEventListener("load", function(e) {
	    			var result = JSON.parse(this.response);
	    			
	    			if (result.exception == null) {
	    				Global.bimServerApi.call("Bimsie1ServiceInterface", "addExtendedDataToRevision", {
	    					roid: roid,
	    					extendedData: {
	    						__type: "SExtendedData",
	    						title: $(".addextendeddata .title").val(),
	    						schemaId: $(".addextendeddata .schemaSelect").val(),
	    						fileId: result.fileId
	    					}
	    				}, function(){
		    				success(result.checkinid);
	    				});
	    			} else {
	    				error(result.exception);
	    			}
	    		}, false);
	    		xhr.open("POST", Global.bimServerApi.baseUrl + "/upload");
	    		reader.onload = function(evt) {
	    			var formData = new FormData();
	    			formData.append("action", "file");
	    			formData.append("token", othis.token);
	    			formData.append("file", file);
	    			
	    			xhr.send(formData);
	    		};
	    		reader.readAsBinaryString(file);
	    	};
	    	
	    	this.setToken = function(token, callback, errorCallback) {
	    		othis.token = token;
	    		othis.call("AuthInterface", "getLoggedInUser", {}, function(data){
	    			othis.user = data;
	    			othis.webSocket.connect(callback);
	    		}, function(){
	    			if (errorCallback != null) {
	    				errorCallback();
	    			}
	    		});
	    	};
	
	    	/**
	    	 * Call a single method, this method delegates to the multiCall method
	    	 * @param {string} interfaceName - Interface name, e.g. "Bimsie1ServiceInterface"
	    	 * @param {string} methodName - Methodname, e.g. "addProject"
	    	 * @param {Object} data - Object with a field per arument
	    	 * @param {Function} callback - Function to callback, first argument in callback will be the returned object
	    	 * @param {Function} errorCallback - Function to callback on error
	    	 * @param {boolean} showBusy - Whether to show busy indication
	    	 * @param {boolean} showDone - Whether to show done indication
	    	 * @param {boolean} showError - Whether to show errors
	    	 * 
	    	 */
	    	this.call = function(interfaceName, methodName, data, callback, errorCallback, showBusy, showDone, showError) {
	    		var showBusy = typeof showBusy !== 'undefined' ? showBusy : true;
	    		var showDone = typeof showDone !== 'undefined' ? showDone : false;
	    		var showError = typeof showError !== 'undefined' ? showError : true;
	
	    		return othis.multiCall([[
	    		    interfaceName,
	    		    methodName,
	    			data
	    		]], function(data){
	    			if (data.exception == null) {
	    				if (callback != null) {
	    					callback(data.result);
	    				}
	    			} else {
	    				if (errorCallback != null) {
	    					errorCallback(data.exception);
	    				}
	    			}
	    		}, errorCallback, showBusy, showDone, showError);
	    	};
	
	    	othis.webSocket.listener = othis.processNotification;
	    }
    }
);