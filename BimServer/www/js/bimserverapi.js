if (typeof console === "undefined") {
	console = {
		log: function(msg){
			print(msg);
		}
	};
}

function BimServerApi(baseUrl, notifier) {
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
	
	othis.jsonSerializerFetcher = new Synchronizer(function(callback){
		othis.call("PluginInterface", "getSerializerByPluginClassName", {pluginClassName: "org.bimserver.serializers.JsonSerializerPlugin"}, function(serializer){
			callback(serializer.oid);
		});
	});
	
	othis.translations = {
		GETDATAOBJECTSBYTYPE_BUSY: "Loading objects",
		REQUESTPASSWORDCHANGE_BUSY: "Busy sending password reset e-mail",
		REQUESTPASSWORDCHANGE_DONE: "A password reset e-mail has been sent",
		SETSERVERSETTINGS_DONE: "Server settings successfully updated",
		ENABLEPLUGIN_DONE: "Plugin successfully enabled",
		DISABLEPLUGIN_DONE: "Plugin successfully disabled",
		SETDEFAULTWEBMODULE_DONE: "Default webmodule changed, a restart of the BIMserver is required for the changes to take effect",
		SETDEFAULTQUERYENGINE_DONE: "Default Query Engine successfully changed",
		SETDEFAULTMODELMERGER_DONE: "Default Model Merger successfully changed",
		SETDEFAULTSERIALIZER_DONE: "Default Serializer successfully changed",
		SETDEFAULTOBJECTIDM_DONE: "Default ObjectIDM successfully changed",
		SETDEFAULTRENDERENGINE_DONE: "Default Render Engine successfully changed",
		SETDEFAULTMODELCOMPARE_DONE: "Default Model Compare successfully changed",
		LOGIN_BUSY: "Trying to login"
	}
	
	othis.token = null;
	othis.baseUrl = baseUrl;
	if (othis.baseUrl.substring(othis.baseUrl.length - 1) == "/") {
		othis.baseUrl = othis.baseUrl.substring(0, othis.baseUrl.length - 1);
	}
	othis.address = othis.baseUrl + "/json";
	othis.notifier = notifier;
	if (othis.notifier == null) {
		othis.notifier = {
			error: function(){},
			info: function(){},
			warn: function(){},
			setStatus: function(message, timeout){},
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

	this.init = function(callback) {
		$.getJSON(othis.baseUrl + "/js/ifc2x3tc1.js", function(result){
			othis.schema = result.classes;
			callback();
		});
	};
	
	this.translate = function(key) {
		key = key.toUpperCase();
		if (othis.translations[key] != null) {
			return othis.translations[key];
		}
		console.log("translation for " + key + " not found");
		return key;
	};

	this.login = function(username, password, rememberme, callback, errorCallback) {
		var request = {
			username: username,
			password: password
		};
		othis.call("Bimsie1AuthInterface", "login", request, function(data){
			othis.token = data;
			if (rememberme) {
				$.cookie("autologin", othis.token, { expires: 31, path: "/"});
				$.cookie("address", othis.baseUrl, { expires: 31, path: "/" });
			} else {
				$.cookie("autologin", othis.token, { path: "/" });
				$.cookie("address", othis.baseUrl, { path: "/"});
			}
			othis.notifier.info("Login successful");
			othis.resolveUser();
			callback();
		}, errorCallback);
	};

	this.processNotification = function(message) {
		var intf = message["interface"];
		if (othis.listeners[intf] != null) {
			if (othis.listeners[intf][message.method] != null) {
				othis.listeners[intf][message.method].forEach(function(listener) {
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
	
	this.resolveUser = function(callback) {
		othis.call("AuthInterface", "getLoggedInUser", {}, function(data){
			othis.user = data;
			if (callback != null) {
				callback(othis.user);
			}
		});
	};

	this.logout = function(callback) {
		$.removeCookie("autologin", {path: "/"});
		othis.call("Bimsie1AuthInterface", "logout", {}, function(){
			othis.notifier.info("Logout successful");
			callback();
		});
	};
	
	this.generateRevisionDownloadUrl = function(settings) {
		return othis.baseUrl + "/download?token=" + othis.token + "&longActionId=" + settings.laid + (settings.zip ? "&zip=on" : "") + "&serializerOid=" + settings.serializerOid;
	};

	this.generateExtendedDataDownloadUrl = function(edid) {
		return othis.baseUrl + "/download?token=" + othis.token + "&action=extendeddata&edid=" + edid;
	};
	
	this.openWebSocket = function(callback) {
		if (othis.server.connected) {
			callback();
		} else {
			othis.server.connect(callback);
		}
	};
	
	this.register = function(interfaceName, methodName, callback, registerCallback) {
		if (othis.listeners[interfaceName] == null) {
			othis.listeners[interfaceName] = {};
		}
		if (othis.listeners[interfaceName][methodName] == null) {
			othis.listeners[interfaceName][methodName] = [];
		}
		othis.listeners[interfaceName][methodName].push(callback);
		othis.openWebSocket(function(){
			if (registerCallback != null) {
				registerCallback();
			}
		});
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
		othis.call("Bimsie1NotificationRegistryInterface", "unregisterNewProjectHandler", {endPointId: othis.server.endPointId}, function(){
			if (callback != null) {
				callback();
			}
		});
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
			if (callback != null) {
				callback();
			}
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
		object["interface"] = interfaceName;
		object.method = method;
		object.parameters = data;
		
		return object;
	};
	
	this.multiCall = function(requests, callback, showBusy, showDone, showError) {
		var request = null;
		if (requests.length == 1) {
			var request = requests[0];
			if (othis.interfaceMapping[request[0]] == null) {
				console.log("Interface " + request[0] + " not found");
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
		}

		othis.notifier.clear();
		
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
					othis.notifier.setStatus(othis.translate(key + "_BUSY"), -1);
					showedBusy = true;
				}, 200);
			}
		}
		
		othis.notifier.resetStatusQuick();
		
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
					if (showBusy) {
						if (othis.lastBusyTimeOut != null) {
							clearTimeout(othis.lastBusyTimeOut);
						}
						if (showedBusy) {
							othis.notifier.resetStatus();
						}
					}
					if (data.response.exception != null) {
						if (data.response.exception.message == "Invalid token" && !othis.autoLoginTried && $.cookie("username") != null && $.cookie("autologin") != null) {
							othis.autologin($.cookie("username"), $.cookie("autologin"), function(){
								console.log("Trying to connect with autologin");
								othis.multiCall(requests, callback, errorCallback);
							});
						} else {
							if (showError) {
								if (othis.lastTimeOut != null) {
									clearTimeout(othis.lastTimeOut);
								}
								othis.notifier.setError(data.response.exception.message);
							}
						}
					} else {
						if (showDone) {
							othis.notifier.setStatus(othis.translate(key + "_DONE"), 5000);
						}
					}
				} else if (requests.length > 1) {
					data.responses.forEach(function(response){
						if (response.exception != null) {
							if (errorCallback == null) {
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
			error: function(jqXHR, textStatus, errorThrown){
				if (textStatus == "abort") {
					// ignore
				} else {
					console.log(errorThrown);
					console.log(textStatus);
					console.log(jqXHR);
					if (othis.lastTimeOut != null) {
						clearTimeout(othis.lastTimeOut);
					}
					othis.notifier.error("ERROR_REMOTE_METHOD_CALL");
				}
				if (callback != null) {
					var result = new Object();
					result.error = textStatus;
					result.ok = false;
					callback(result);
				}
			}
		});		
	};
	
	this.getModel = function(poid, roid, deep, callback) {
		var model = new Model(othis, poid, roid, deep);
		model.load(deep, callback);
		return model;
	};
	
	this.createModel = function(poid, callback) {
		var model = new Model(othis, poid);
		model.init(callback);
		return model;
	};
	
	this.callWithFullIndication = function(interfaceName, methodName, data, callback) {
		othis.call(interfaceName, methodName, data, callback, true, true, true);
	};

	this.callWithUserErrorIndication = function(action, data, callback) {
		othis.call(interfaceName, methodName, data, callback, false, false, true);
	};

	this.callWithUserErrorAndDoneIndication = function(action, data, callback) {
		othis.call(interfaceName, methodName, data, callback, false, true, true);
	};
	
	this.setToken = function(token) {
		othis.token = token;
	};
	
	this.call = function(interfaceName, methodName, data, callback, errorCallback, showBusy, showDone, showError) {
		var showBusy = typeof showBusy !== 'undefined' ? showBusy : true;
		var showDone = typeof showDone !== 'undefined' ? showDone : false;
		var showError = typeof showError !== 'undefined' ? showError : true;

		othis.multiCall([[
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
					errorCallback();
				}
			}
		}, showBusy, showDone, showError);
	};
	
	othis.server.listener = othis.processNotification;
}

function Synchronizer(fetcher) {
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

function Model(bimServerApi, poid, roid) {
	var othis = this;
	othis.bimServerApi = bimServerApi;
	othis.poid = poid;
	othis.roid = roid;
	othis.waiters = [];
	
	othis.objects = {};
	othis.objectsByGuid = {};
	othis.objectsByName = {};
	
	othis.oidsFetching = {};
	othis.guidsFetching = {};
	othis.namesFetching = {};

	othis.loadedTypes = [];
	othis.loadedDeep = false;
	othis.changedObjectOids = {};
	othis.doneCallbacks = [];
	othis.runningCalls = 0;
	othis.loading = false;
	othis.logging = true;
	
	othis.transactionSynchronizer = new Synchronizer(function(callback){
		bimServerApi.call("Bimsie1LowLevelInterface", "startTransaction", {poid: othis.poid}, function(tid){
			callback(tid);
		});
	});
	
	this.init = function(callback){
		othis.incrementRunningCalls("init");
		othis.transactionSynchronizer.fetch(function(){
			callback(othis);
			othis.decrementRunningCalls("init");
		});
	};
	
	this.load = function(deep, modelLoadCallback) {
		if (deep) {
			othis.loading = true;
			othis.incrementRunningCalls("load");
			othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
				bimServerApi.call("ServiceInterface", "download", {
					roid: roid,
					serializerOid: jsonSerializerOid,
					showOwn: true,
					sync: true
				}, function(laid){
					var url = bimServerApi.generateRevisionDownloadUrl({
						laid: laid,
						serializerOid: jsonSerializerOid
					});
					$.getJSON(url, function(data, textStatus, jqXHR){
						data.objects.forEach(function(object){
							othis.objects[object.__oid] = object;
						});
						for (var oid in othis.objects) {
							othis.resolveReferences(othis.objects[oid]);
						}
						othis.loading = false;
						othis.loadedDeep = true;
						othis.waiters.forEach(function(waiter){
							waiter();
						});
						othis.waiters = [];
						bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
							modelLoadCallback(othis);
							othis.decrementRunningCalls("load");
						});
					});
				});
			});
		} else {
			othis.loaded = true;
			modelLoadCallback(othis);
		}
	};
	
	this.create = function(className, object, callback) {
		othis.incrementRunningCalls("create (" + className + ")");
		othis.transactionSynchronizer.fetch(function(tid){
			object.__type = className;
			othis.resolveReferences(object, function(){
				bimServerApi.call("Bimsie1LowLevelInterface", "createObject", {tid: tid, className: className}, function(oid){
					object.__oid = oid;
					if (callback != null) {
						callback(object);
					}
					othis.decrementRunningCalls("create (" + className + ")");
				});
			});
		});
		return object;
	};

	this.incrementRunningCalls = function(method){
		othis.runningCalls++;
		console.log("inc", method, othis.runningCalls);
	};
	
	this.decrementRunningCalls = function(method){
		othis.runningCalls--;
		console.log("dec", method, othis.runningCalls);
		if (othis.runningCalls == 0) {
			othis.doneCallbacks.forEach(function(cb){
				cb(othis);
			});
		}
	};
	
	this.done = function(doneCallback){
		if (othis.runningCalls == 0) {
			console.log("immediately done");
			doneCallback(othis);
		} else {
			othis.doneCallbacks.push(doneCallback);
		}
	};
	
	this.waitForLoaded = function(callback) {
		if (othis.loaded) {
			callback();
		} else {
			othis.waiters.push(callback);
		}
	};

	this.commit = function(comment, callback){
		othis.transactionSynchronizer.fetch(function(tid){
			bimServerApi.call("Bimsie1LowLevelInterface", "commitTransaction", {tid: tid, comment: comment}, function(roid){
				if (callback != null) {
					callback(roid);
				}
			});
		});
	};
	
	this.resolveFields = function(object, type) {
		object.oid = object.__oid;
		for (var fieldName in type.fields){
			var field = type.fields[fieldName];
			if (field.reference) {
				(function(object, field, fieldName){
					object["set" + fieldName.firstUpper()] = function(value) {
						othis.transactionSynchronizer.fetch(function(tid){
							object[fieldName] = value;
							othis.incrementRunningCalls("set" + fieldName.firstUpper());
							if (value == null) {
								bimServerApi.call("Bimsie1LowLevelInterface", "unsetReference", {
									tid: tid,
									oid: object.__oid,
									referenceName: fieldName,
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
									if (object.changedFields == null) {
										object.changedFields = {};
									}
									object.changedFields[fieldName] = true;
									othis.changedObjectOids[object.oid] = true;
								});
							} else {
								bimServerApi.call("Bimsie1LowLevelInterface", "setReference", {
									tid: tid,
									oid: object.__oid,
									referenceName: fieldName,
									referenceOid: value.__oid
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
									if (object.changedFields == null) {
										object.changedFields = {};
									}
									object.changedFields[fieldName] = true;
									othis.changedObjectOids[object.oid] = true;
								});
							}
						});
					};
					object["get" + fieldName.firstUpper()] = function(callback) {
						if (object[fieldName] != null) {
							return object[fieldName];
						}
						var value = object["__ref" + fieldName];
						if (field.many) {
							if (object[fieldName] == null) {
								object[fieldName] = [];
							}
							value.forEach(function(val){
								var ref = othis.objects[val];
								if (ref == null) {
									othis.get(value, function(v){
										object[fieldName].push(v);
										callback(v);
									});
								} else {
									object[fieldName].push(ref);
									callback(ref);
								}
							});
							return object[fieldName];
						} else if (value != null) {
							var ref = othis.objects[value];
							if (value == -1) {
								callback(null);
							} else if (ref == null) {
								othis.get(value, function(v){
									object[fieldName] = v;
									callback(v);
								});
							} else {
								object[fieldName] = ref;
								callback(ref);
							}
						}
					};
				})(object, field, fieldName);
			} else {
				(function(object, field, fieldName){
					object["get" + fieldName.firstUpper()] = function(callback) {
						if (field.many) {
							if (object[fieldName] == null) {
								object[fieldName] = [];
							}
							object[fieldName].push = function(val){
								othis.transactionSynchronizer.fetch(function(tid){
									bimServerApi.call("Bimsie1LowLevelInterface", "addDoubleAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: val
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								});
							};
						}
						if (callback != null) {
							callback(object[fieldName]);
						}
						return object[fieldName];
					};
					object["set" + fieldName.firstUpper()] = function(value) {
						othis.incrementRunningCalls("set" + fieldName.firstUpper());
						othis.transactionSynchronizer.fetch(function(tid){
							if (field.many) {
								bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttributes", {
									tid: tid,
									oid: object.__oid,
									attributeName: fieldName,
									values: value
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
								});
							} else {
								if (value == null) {
									bimServerApi.call("Bimsie1LowLevelInterface", "unsetAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "string") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setStringAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "double") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "boolean") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setBooleanAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "int") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setIntegerAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "enum") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setEnumAttribute", {
										tid: tid,
										oid: object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else {									
									console.log("Unimplemented type " + typeof value);
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
								}
								object[fieldName] = value;								
							}
							if (object.changedFields == null) {
								object.changedFields = {};
							}
							object.changedFields[fieldName] = true;
							othis.changedObjectOids[object.oid] = true;
						});
					};
				})(object, field, fieldName);
			}
		}
	};

	this.resolveType = function(schema, object, realType){
		realType.superclasses.forEach(function(typeName){
			othis.resolveType(schema, object, schema[typeName]);
		});
		othis.resolveFields(object, realType);
	};
	
	this.resolveReferences = function(object, callback){
		// TODO move this function to prototype
		object.remove = function(removeCallback){
			othis.incrementRunningCalls("removeObject");
			othis.transactionSynchronizer.fetch(function(tid){
				bimServerApi.call("Bimsie1LowLevelInterface", "removeObject", {tid: tid, oid: object.__oid}, function(){
					if (removeCallback != null) {
						removeCallback();
					}
					delete othis.objects[object.__oid];
					othis.decrementRunningCalls("removeObject");
				});
			});
		};
		var realType = othis.bimServerApi.schema[object.__type];
		if (realType == null) {
			throw "Type " + object.__type + " not found";
		}
		othis.resolveType(othis.bimServerApi.schema, object, realType);
		callback();
	};
	
	this.size = function(callback){
		bimServerApi.call("Bimsie1ServiceInterface", "getRevision", {roid: roid}, function(revision){
			callback(revision.size);
		});
	};
	
	this.count = function(type, includeAllSubTypes, callback) {
		// TODO use includeAllSubTypes
		othis.incrementRunningCalls("count (" + type + ")");
		bimServerApi.call("Bimsie1LowLevelInterface", "count", {roid: roid, className: type}, function(size){
			callback(size);
			othis.decrementRunningCalls("count (" + type + ")");
		});		
	};
	
	this.getByX = function(methodName, keyname, fetchingMap, targetMap, interfaceMethodName, interfaceFieldName, getValueMethod, list, callback) {
		othis.incrementRunningCalls(methodName + "(" + list + ")");
		if (typeof list == "string" || typeof list == "number") {
			list = [list];
		}
		othis.waitForLoaded(function(){
			list.forEach(function(item){
				if (fetchingMap[item] != null) {
					// Already loaded? Remove from list and call callback
					callback(fetchingMap[item]);
					var index = list.indexOf(item);
					list.splice(index, 1);
				} else if (fetchingMap[item] != null) {
					// Already loading? Add the callback to the list and remove from fetching list
					fetchingMap[item].push(callback);
					var index = list.indexOf(item);
					list.splice(index, 1);
				}
			});
			// Any left?
			if (list.length > 0) {
				list.forEach(function(item){
					fetchingMap[item] = [];
				});
				othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
					var request = {
						roids: [roid],
						serializerOid: jsonSerializerOid,
						deep: false,
						sync: true
					};
					request[interfaceFieldName] = list;
					bimServerApi.call("Bimsie1ServiceInterface", interfaceMethodName, request, function(laid){
						var url = bimServerApi.generateRevisionDownloadUrl({
							laid: laid,
							serializerOid: jsonSerializerOid
						});
						$.getJSON(url, function(data, textStatus, jqXHR){
							if (data.objects.length > 0) {
								var done = 0;
								data.objects.forEach(function(object){
									othis.resolveReferences(object, function(){
										var item = getValueMethod(object);
										// Checking the value again, because sometimes serializers send more objects...
										if (item != null) {
											targetMap[item] = object;
											if (fetchingMap[item] != null) {
												fetchingMap[item].forEach(function(cb){
													cb(object);
												});
												delete fetchingMap[item];
											}
											callback(object);
										}
										done++;
										if (done == data.objects.length) {
											bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
												othis.decrementRunningCalls(methodName + "(" + list + ")");
											});
										}
									});
								});
							} else {
								console.log("Object with " + keyname + " " + list + " not found");
							}
						});
					});
				});
			} else {
				othis.decrementRunningCalls(methodName + "(" + list + ")");
			}
		});		
	};
	
	this.getByGuid = function(guids, callback) {
		othis.getByX("getByGuid", "guid", othis.guidsFetching, othis.objectsByGuid, "downloadByGuids", "guids", function(object){return object.getGlobalId()}, guids, callback);
	};
	
	this.get = function(oids, callback) {
		othis.getByX("get", "OID", othis.oidsFetching, othis.objects, "downloadByOids", "oids", function(object){return object.__oid}, oids, callback);
	};
	
	this.getByName = function(names, callback) {
		othis.getByX("getByName", "name", othis.namesFetching, othis.objectsByName, "downloadByNames", "names", function(object){return object.getName == null ? null : object.getName()}, names, callback);
	};
	
	this.getAllOfType = function(type, includeAllSubTypes, callback) {
		othis.incrementRunningCalls("getAllOfType");
		othis.waitForLoaded(function(){
			if (othis.loadedDeep) {
				for (var oid in othis.objects) {
					var object = othis.objects[oid];
					if (object.__type == type) {
						callback(object);
					}
				}
				othis.decrementRunningCalls("getAllOfType");
			} else {
				othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
					bimServerApi.call("Bimsie1ServiceInterface", "downloadByTypes", {
						roids: [roid],
						classNames: [type],
						includeAllSubtypes: includeAllSubTypes,
						serializerOid: jsonSerializerOid,
						useObjectIDM: true,
						deep: false,
						sync: true
					}, function(laid){
						var url = bimServerApi.generateRevisionDownloadUrl({
							laid: laid,
							serializerOid: jsonSerializerOid
						});
						$.getJSON(url, function(data, textStatus, jqXHR){
							data.objects.forEach(function(object){
								othis.objects[object.oid] = object;
							});
							for (var oid in othis.objects) {
								var object = othis.objects[oid];
								othis.resolveReferences(object, function(){
									callback(object);
								});
							}
							bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
								othis.decrementRunningCalls("getAllOfType");
							});
						});
					});
				});
			}
		});
	};
}

function BimServerWebSocket(baseUrl, bimServerApi) {
	var othis = this;
	this.connected = false;
	this.openCallbacks = [];
	this.endPointId = null;
	this.listener = null;
	
	this.connect = function(callback) {
		othis.openCallbacks.push(callback);
		var location = bimServerApi.baseUrl.toString().replace('http://', 'ws://').replace('https://', 'wss://') + "/stream";
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
		var str = JSON.stringify(object);
		console.log("Sending", str);
		othis._send(str);
	};

	this._onmessage = function(message) {
		var incomingMessage = JSON.parse(message.data);
		console.log("incoming", incomingMessage);
		if (incomingMessage.welcome != null) {
			othis.send({"token": bimServerApi.token});
		} else if (incomingMessage.endpointid != null) {
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