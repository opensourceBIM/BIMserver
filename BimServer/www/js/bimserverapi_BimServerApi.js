"use strict"

define(
     
    ["bimserverapi_BimServerWebSocket", "bimserverapi_Synchronizer", "bimserverapi_BimServerApiPromise", "bimserverapi_Model", "bimserverapi_Ifc2x3tc1", "bimserverapi_Ifc4", "bimserverapi_Translations_EN"], 
    function(BimServerWebSocket, Synchronizer, BimServerApiPromise, Model, ifc2x3tc1, ifc4, translations){
    	return function(baseUrl, notifier) {
	    	var othis = this;
	    	
	    	// Convenience method for non-requirejs dependants...	    	
	    	othis.BimServerApiPromise = BimServerApiPromise;
	    	
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
	
	    	othis.jsonSerializerFetcher = new Synchronizer(function(callback){
	    		othis.call("PluginInterface", "getSerializerByPluginClassName", {pluginClassName: "org.bimserver.serializers.JsonSerializerPlugin"}, function(serializer){
	    			callback(serializer.oid);
	    		});
	    	});
	
	    	othis.token = null;
	    	othis.baseUrl = baseUrl;
	    	if (othis.baseUrl.substring(othis.baseUrl.length - 1) == "/") {
	    		othis.baseUrl = othis.baseUrl.substring(0, othis.baseUrl.length - 1);
	    	}
	    	othis.address = othis.baseUrl + "/json";
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
	    	othis.server = new BimServerWebSocket(baseUrl, othis);
	    	othis.user = null;
	    	othis.listeners = {};
	    	othis.autoLoginTried = false;
	    	othis.serializersByPluginClassName = [];
	    	othis.debug = false;
	    	othis.classes = {};
	    	othis.binaryDataListener = {};
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
	
	    	this.login = function(username, password, rememberme, callback, errorCallback, options) {
	    		if (options == null) {
	    			options = {};
	    		}
	    		var request = {
	    			username: username,
	    			password: password
	    		};
	    		othis.call("Bimsie1AuthInterface", "login", request, function(data){
	    			othis.token = data;
	    			if (rememberme) {
	    				// Stored cookie
	    				$.cookie("autologin" + window.document.location.port, othis.token, { expires: 31, path: "/"});
	    				$.cookie("address" + window.document.location.port, othis.baseUrl, { expires: 31, path: "/"});
	    			} else if (!options.suppressSessionCookie) {
	    				// Session cookie
	    				$.cookie("autologin" + window.document.location.port, othis.token, { path: "/"});
	    				$.cookie("address" + window.document.location.port, othis.baseUrl, { path: "/"});
	    			}
	    			if (options.done != false) {
	    				othis.notifier.setInfo("Login successful", 2000);
	    			}
	    			othis.resolveUser();
	    			othis.server.connect(callback);
	    		}, errorCallback, options.busy == false ? false : true, options.done == false ? false : true, options.error == false ? false : true);
	    	};
	
	    	this.downloadViaWebsocket = function(msg){
	    		msg.action = "download";
	    		msg.token = othis.token;
	    		othis.server.send(msg);
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
	    		$.removeCookie("autologin" + window.document.location.port, {path: "/"});
	    		othis.call("Bimsie1AuthInterface", "logout", {}, function(){
	    			othis.notifier.setInfo("Logout successful");
	    			callback();
	    		});
	    	};
	
	    	this.generateRevisionDownloadUrl = function(settings) {
	    		return othis.baseUrl + "/download?token=" + othis.token + "&longActionId=" + settings.laid + (settings.zip ? "&zip=on" : "") + "&serializerOid=" + settings.serializerOid + "&topicId=" + settings.topicId;
	    	};
	
	    	this.generateExtendedDataDownloadUrl = function(edid) {
	    		return othis.baseUrl + "/download?token=" + othis.token + "&action=extendeddata&edid=" + edid;
	    	};
	
	    	this.getSerializerByPluginClassName = function(pluginClassName, callback) {
	    		if (othis.serializersByPluginClassName[name] == null) {
	    			othis.call("PluginInterface", "getSerializerByPluginClassName", {pluginClassName : pluginClassName}, function(serializer) {
	    				othis.serializersByPluginClassName[name] = serializer;
	    				callback(serializer);
	    			});
	    		} else {
	    			callback(othis.serializersByPluginClassName[name]);
	    		}
	    	},
	
	    	this.getMessagingSerializerByPluginClassName = function(pluginClassName, callback) {
	    		if (othis.serializersByPluginClassName[name] == null) {
	    			othis.call("PluginInterface", "getMessagingSerializerByPluginClassName", {pluginClassName : pluginClassName}, function(serializer) {
	    				othis.serializersByPluginClassName[name] = serializer;
	    				callback(serializer);
	    			});
	    		} else {
	    			callback(othis.serializersByPluginClassName[name]);
	    		}
	    	},
	
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
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewRevisionOnSpecificProjectHandler", {endPointId: othis.server.endPointId, poid: poid}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	
	    	this.registerNewExtendedDataOnRevisionHandler = function(roid, handler, callback){
	    		othis.register("Bimsie1NotificationInterface", "newExtendedData", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewExtendedDataOnRevisionHandler", {endPointId: othis.server.endPointId, roid: roid}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	    	
	    	this.registerNewUserHandler = function(handler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newUser", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewUserHandler", {endPointId: othis.server.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	
	    	this.unregisterNewUserHandler = function(handler, callback) {
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewUserHandler", {endPointId: othis.server.endPointId}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.unregisterChangeProgressProjectHandler = function(poid, newHandler, closedHandler, callback) {
	    		othis.unregister(newHandler);
	    		othis.unregister(closedHandler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnProject", {poid: poid, endPointId: othis.server.endPointId}, callback);
	    	};
	
	    	this.registerChangeProgressProjectHandler = function(poid, newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnProjectTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnProjectTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnProject", {poid: poid, endPointId: othis.server.endPointId}, function(){
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
	    		if (othis.server.endPointId != null) {
	    			othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnServer", {endPointId: othis.server.endPointId}, callback);
	    		}
	    	};
	
	    	this.registerChangeProgressServerHandler = function(newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnServerTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnServerTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnServer", {endPointId: othis.server.endPointId}, function(){
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
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnProject", {roid: roid, endPointId: othis.server.endPointId}, callback);
	    	};
	
	    	this.registerChangeProgressRevisionHandler = function(poid, roid, newHandler, closedHandler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProgressOnRevisionTopic", newHandler, function(){
	    			othis.register("Bimsie1NotificationInterface", "closedProgressOnRevisionTopic", closedHandler, function(){
	    				othis.call("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnRevision", {poid: poid, roid: roid, endPointId: othis.server.endPointId}, function(){
	    					if (callback != null) {
	    						callback();
	    					}
	    				});
	    			});
	    		});
	    	}
	
	    	this.registerNewProjectHandler = function(handler, callback) {
	    		othis.register("Bimsie1NotificationInterface", "newProject", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerNewProjectHandler", {endPointId: othis.server.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	}
	
	    	this.unregisterNewProjectHandler = function(handler, callback){
	    		othis.unregister(handler);
	    		if (othis.server.endPointId != null) {
	    			othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewProjectHandler", {endPointId: othis.server.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		}
	    	};
	
	    	this.unregisterNewRevisionOnSpecificProjectHandler = function(poid, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewRevisionOnSpecificProjectHandler", {endPointId: othis.server.endPointId, poid: poid}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.unregisterNewExtendedDataOnRevisionHandler = function(roid, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewExtendedDataOnRevisionHandler", {endPointId: othis.server.endPointId, roid: roid}, function(){
	    			if (callback != null) {
	    				callback();
	    			}
	    		});
	    	};
	
	    	this.registerProgressHandler = function(topicId, handler, callback){
	    		othis.register("Bimsie1NotificationInterface", "progress", handler, function(){
	    			othis.call("Bimsie1NotificationRegistryInterface", "registerProgressHandler", {topicId: topicId, endPointId: othis.server.endPointId}, function(){
	    				if (callback != null) {
	    					callback();
	    				}
	    			});
	    		});
	    	};
	
	    	this.unregisterProgressHandler = function(topicId, handler, callback){
	    		othis.unregister(handler);
	    		othis.call("Bimsie1NotificationRegistryInterface", "unregisterProgressHandler", {topicId: topicId, endPointId: othis.server.endPointId}, function(){
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
	    		object["interface"] = interfaceName;
	    		object.method = method;
	    		object.parameters = data;
	
	    		return object;
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
	
	    		$.ajax(othis.address, {
	    			type: "POST",
	    			contentType: 'application/json; charset=UTF-8',
	    			data: JSON.stringify(request),
	    			dataType: "json",
	    			success: function(data) {
	    				othis.log("response", data);
	    				var errorsToReport = [];
	    				if (requests.length == 1) {
	    					if (showBusy) {
	    						if (othis.lastBusyTimeOut != null) {
	    							clearTimeout(othis.lastBusyTimeOut);
	    						}
	    					}
	    					if (data.response.exception != null) {
	    						if (data.response.exception.message == "Invalid token" && !othis.autoLoginTried && $.cookie("username" + window.document.location.port) != null && $.cookie("autologin" + window.document.location.port) != null) {
	    							othis.autologin($.cookie("username" + window.document.location.port), $.cookie("autologin" + window.document.location.port), function(){
	    								othis.log("Trying to connect with autologin");
	    								othis.multiCall(requests, callback, errorCallback);
	    							});
	    						} else {
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
	    						}
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
	    			error: function(jqXHR, textStatus, errorThrown){
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
	    			}
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
	
	    	this.checkin = function(project, file, deserializerOid, progressListener, success, error){
	    		var reader = new FileReader();
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
	    				success(result.checkinid);
	    			} else {
	    				error(result.exception);
	    			}
	    		}, false);
	    		xhr.open("POST", Global.bimServerApi.baseUrl + "/upload");
	    		reader.onload = function(evt) {
	    			var formData = new FormData();
	    			formData.append("token", othis.token);
	    			formData.append("deserializerOid", deserializerOid);
	    			formData.append("comment", file.name);
	    			formData.append("merge", false);
	    			formData.append("poid", project.oid);
	    			formData.append("sync", false);
	    			formData.append("file", file);
	    			
	    			xhr.send(formData);
	    		};
	    		reader.readAsBinaryString(file);
	    	};
	    	
	    	this.setToken = function(token, callback, errorCallback) {
	    		othis.token = token;
	    		othis.call("AuthInterface", "getLoggedInUser", {}, function(data){
	    			othis.user = data;
	    			othis.server.connect(callback);
	    		}, function(){
	    			if (errorCallBack != null) {
	    				errorCallback();
	    			}
	    		});
	    	};
	
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
	
	    	othis.server.listener = othis.processNotification;
	    }
    }
);