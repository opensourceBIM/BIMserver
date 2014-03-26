"use strict"

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
		LOGIN_BUSY: "Trying to login",
		CHANGEUSERTYPE_DONE: "Type of user successfully changed",
		ADDUSER_DONE: "User successfully added",
		UPDATEINTERNALSERVICE_DONE: "Internal service successfully updated",
		UPDATEMODELCOMPARE_DONE: "Model compare plugin successfully updated",
		UPDATEMODELMERGER_DONE: "Model merger successfully updated",
		UPDATEQUERYENGINE_DONE: "Query engine plugin successfully updated",
		UPDATEOBJECTIDM_DONE: "ObjectIDM succesfully updated",
		UPDATEDESERIALIZER_DONE: "Serializer succesfully updated",
		ADDUSERTOPROJECT_DONE: "User successfully added to project",
		REMOVEUSERFROMPROJECT_DONE: "User successfully removed from project",
		UNDELETEPROJECT_DONE: "Project successfully undeleted",
		DELETEPROJECT_DONE: "Project successfully deleted",
		ADDPROJECT_DONE: "Project successfully added",
		DOWNLOAD_BUSY: "Busy downloading...",
		VALIDATEACCOUNT_DONE: "Account successfully validated, you can now login"
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

	this.init = function(callback) {
		$.getJSON(othis.baseUrl + "/js/ifc2x3tc1.js", function(result){
			othis.schema = result.classes;
			callback();
		});
	};

	this.log = function(message, message2){
		if (othis.debug) {
			console.log(message, message2);
		}
	};
	
	this.translate = function(key) {
		key = key.toUpperCase();
		if (othis.translations[key] != null) {
			return othis.translations[key];
		}
		othis.log("translation for " + key + " not found");
		return key;
	};

	this.login = function(username, password, rememberme, callback, errorCallback, options) {
		var request = {
			username: username,
			password: password
		};
		othis.call("Bimsie1AuthInterface", "login", request, function(data){
			othis.token = data;
			if (rememberme) {
				$.cookie("autologin" + window.document.location.port, othis.token, { expires: 31, path: "/"});
				$.cookie("address" + window.document.location.port, othis.baseUrl, { expires: 31, path: "/"});
			} else {
				$.cookie("autologin" + window.document.location.port, othis.token, { path: "/"});
				$.cookie("address" + window.document.location.port, othis.baseUrl, { path: "/"});
			}
			othis.notifier.setInfo("Login successful", 2000);
			othis.resolveUser();
			othis.server.connect(callback);
		}, errorCallback);
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
		return othis.baseUrl + "/download?token=" + othis.token + "&longActionId=" + settings.laid + (settings.zip ? "&zip=on" : "") + "&serializerOid=" + settings.serializerOid;
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

	this.multiCall = function(requests, callback, errorCallback, showBusy, showDone, showError) {
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
			callback();
		}

//		othis.notifier.clear();

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

//		othis.notifier.resetStatusQuick();

		othis.log("request", request);

		$.ajax(othis.address, {
			type: "POST",
			contentType: 'application/json',
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

	this.callWithNoIndication = function(interfaceName, methodName, data, callback) {
		othis.call(interfaceName, methodName, data, callback, null, false, false, false);
	};

	this.callWithFullIndication = function(interfaceName, methodName, data, callback) {
		othis.call(interfaceName, methodName, data, callback, null, true, true, true);
	};

	this.callWithUserErrorIndication = function(action, data, callback) {
		othis.call(interfaceName, methodName, data, callback, null, false, false, true);
	};

	this.callWithUserErrorAndDoneIndication = function(action, data, callback) {
		othis.call(interfaceName, methodName, data, callback, null, false, true, true);
	};

	this.isA = function(typeSubject, typeName){
		var isa = false;
		if (typeSubject == typeName) {
			return true;
		}
		var subject = othis.schema[typeSubject];
		if (subject == null) {
			console.log(typeSubject, "not found");
		}
		subject.superclasses.forEach(function(superclass){
			if (superclass == typeName) {
				isa = true;
			}
			if (othis.isA(superclass, typeName)) {
				isa = true;
			}
		});
		return isa;
	};
	
	this.setToken = function(token, callback, errorCallback) {
		othis.token = token;
		Global.bimServerApi.call("AuthInterface", "getLoggedInUser", {}, function(data){
			othis.user = data;
			othis.server.connect(callback);
		}, function(){
			errorCallback();
		});
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
					errorCallback(data.exception);
				}
			}
		}, errorCallback, showBusy, showDone, showError);
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
	
	othis.changes = 0;

	othis.changeListeners = [];
	
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
				bimServerApi.call("Bimsie1ServiceInterface", "download", {
					roid: othis.roid,
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
							othis.objects[object.__oid] = othis.createWrapper(object, object.__type);
						});
						othis.loading = false;
						othis.loadedDeep = true;
						othis.waiters.forEach(function(waiter){
							waiter();
						});
						othis.waiters = [];
						bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
							if (modelLoadCallback != null) {
								modelLoadCallback(othis);
							}
							othis.decrementRunningCalls("load");
						});
					});
				});
			});
		} else {
			othis.loaded = true;
			if (modelLoadCallback != null) {
				modelLoadCallback(othis);
			}
		}
	};

	this.create = function(className, object, callback) {
		othis.incrementRunningCalls("create (" + className + ")");
		othis.transactionSynchronizer.fetch(function(tid){
			object.__type = className;
			var wrapper = othis.createWrapper({}, className);
			bimServerApi.call("Bimsie1LowLevelInterface", "createObject", {tid: tid, className: className}, function(oid){
				wrapper.__oid = oid;
				othis.objects[object.__oid] = wrapper;
				object.__state = "LOADED";
				if (callback != null) {
					callback(object);
				}
				othis.decrementRunningCalls("create (" + className + ")");
			});
		});
		return object;
	};

	this.incrementRunningCalls = function(method){
		othis.runningCalls++;
		othis.bimServerApi.log("inc", method, othis.runningCalls);
	};

	this.decrementRunningCalls = function(method){
		othis.runningCalls--;
		othis.bimServerApi.log("dec", method, othis.runningCalls);
		if (othis.runningCalls == 0) {
			othis.doneCallbacks.forEach(function(cb){
				cb(othis);
			});
		}
	};

	this.done = function(doneCallback){
		if (othis.runningCalls == 0) {
			othis.bimServerApi.log("immediately done");
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
	
	this.abort = function(callback){
		othis.transactionSynchronizer.fetch(function(tid){
			bimServerApi.call("Bimsie1LowLevelInterface", "abortTransaction", {tid: tid}, function(roid){
				if (callback != null) {
					callback();
				}
			});
		});
	};
	
	this.addChangeListener = function(changeListener){
		othis.changeListeners.push(changeListener);
	};

	this.incrementChanges = function(){
		othis.changes++;
		othis.changeListeners.forEach(function(changeListener){
			changeListener(othis.changes);
		});
	};

	this.extendClass = function(wrapperClass, typeName){
		var realType = othis.bimServerApi.schema[typeName];
		realType.superclasses.forEach(function(typeName){
			othis.extendClass(wrapperClass, typeName);
		});
		for (var fieldName in realType.fields){
			var field = realType.fields[fieldName];
			(function(field, fieldName){
				if (field.reference) {
					wrapperClass["set" + fieldName.firstUpper() + "Wrapped"] = function(typeName, value) {
						this.object[fieldName] = {__type: typeName, value: value};
						othis.incrementRunningCalls("set" + fieldName.firstUpper() + "Wrapped");
						othis.transactionSynchronizer.fetch(function(tid){
							var type = othis.bimServerApi.schema[typeName];
							var wrappedValueType = type.fields.wrappedValue;
							if (wrappedValueType.type == "string") {
								bimServerApi.call("Bimsie1LowLevelInterface", "setWrappedStringAttribute", {
									tid: tid,
									oid: this.object.__oid,
									attributeName: fieldName,
									type: typeName,
									value: value
								}, function(){
									if (this.object.changedFields == null) {
										this.object.changedFields = {};
									}
									this.object.changedFields[fieldName] = true;
									othis.changedObjectOids[this.object.oid] = true;
									othis.incrementChanges();
									othis.decrementRunningCalls("set" + fieldName.firstUpper() + "Wrapped");
								});
							}
						});
					};
					wrapperClass["set" + fieldName.firstUpper()] = function(value) {
						othis.transactionSynchronizer.fetch(function(tid){
							this.object[fieldName] = value;
							othis.incrementRunningCalls("set" + fieldName.firstUpper());
							if (value == null) {
								bimServerApi.call("Bimsie1LowLevelInterface", "unsetReference", {
									tid: tid,
									oid: this.object.__oid,
									referenceName: fieldName,
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
									if (this.object.changedFields == null) {
										this.object.changedFields = {};
									}
									this.object.changedFields[fieldName] = true;
									othis.changedObjectOids[this.object.oid] = true;
								});
							} else {
								bimServerApi.call("Bimsie1LowLevelInterface", "setReference", {
									tid: tid,
									oid: this.object.__oid,
									referenceName: fieldName,
									referenceOid: value.__oid
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
									if (this.object.changedFields == null) {
										this.object.changedFields = {};
									}
									this.object.changedFields[fieldName] = true;
									othis.changedObjectOids[this.object.oid] = true;
								});
							}
						});
					};
					wrapperClass["add" + fieldName.firstUpper()] = function(value, callback) {
						othis.transactionSynchronizer.fetch(function(tid){
							if (this.object[fieldName] == null) {
								this.object[fieldName] = [];
							}
							this.object[fieldName].push(value);
							othis.incrementRunningCalls("add" + fieldName.firstUpper());
							bimServerApi.call("Bimsie1LowLevelInterface", "addReference", {
								tid: tid,
								oid: this.object.__oid,
								referenceName: fieldName,
								referenceOid: value.__oid
							}, function(){
								othis.decrementRunningCalls("add" + fieldName.firstUpper());
								if (this.object.changedFields == null) {
									this.object.changedFields = {};
								}
								this.object.changedFields[fieldName] = true;
								othis.changedObjectOids[this.object.oid] = true;
								if (callback != null) {
									callback();
								}
							});
						});
					};
					wrapperClass["remove" + fieldName.firstUpper()] = function(value, callback) {
						othis.transactionSynchronizer.fetch(function(tid){
							var list = this.object[fieldName];
							var index = list.indexOf(value);
							list.splice(index, 1);
							
							othis.incrementRunningCalls("remove" + fieldName.firstUpper());
							bimServerApi.call("Bimsie1LowLevelInterface", "removeReference", {
								tid: tid,
								oid: this.object.__oid,
								referenceName: fieldName,
								index: index
							}, function(){
								othis.decrementRunningCalls("remove" + fieldName.firstUpper());
								if (this.object.changedFields == null) {
									this.object.changedFields = {};
								}
								this.object.changedFields[fieldName] = true;
								othis.changedObjectOids[this.object.oid] = true;
								if (callback != null) {
									callback();
								}
							});
						});
					};
					wrapperClass["get" + fieldName.firstUpper()] = function(callback) {
						var object = this.object;
						var model = this.model;
						var promise = model.createPromise();
						if (object[fieldName] != null) {
							if (field.many) {
								object[fieldName].forEach(function(item){
									if (item.object.__state == "NOT_LOADED") {
										console.log("oho");
									}
									callback(item);
								});
							} else {
								if (object[fieldName].object.__state == "NOT_LOADED") {
									console.log("oho");
								}
								callback(object[fieldName]);
							}							
							promise.fire();
							return promise;
						}
						var embValue = object["__emb" + fieldName];
						if (embValue != null) {
							callback(embValue);
							promise.fire();
							return promise;
						}
						var value = object["__ref" + fieldName];
						if (field.many) {
							if (object[fieldName] == null) {
								object[fieldName] = [];
							}
							if (value != null) {
								model.get(value, function(v){
									if (v.object.__state == "NOT_LOADED") {
										console.log("oho");
									}
									object[fieldName].push(v);
									callback(v);
								}).done(function(){
									promise.fire();
								});
							} else {
								promise.fire();
							}
						} else {
							if (value != null) {
								var ref = othis.objects[value];
								if (value == -1) {
									callback(null);
									promise.fire();
								} else if (ref == null || ref.object.__state == "NOT_LOADED") {
									model.get(value, function(v){
										object[fieldName] = v;
										if (v.object.__state == "NOT_LOADED") {
											console.log("oho");
										}
										callback(v);
									}).done(function(){
										promise.fire();
									});
								} else {
									if (ref.object.__state == "NOT_LOADED") {
										console.log("oho");
									}
									object[fieldName] = ref;
									callback(ref);
									promise.fire();
								}
							} else {
								callback(null);
								promise.fire();
							}
						}
						return promise;
					};
				} else {
					wrapperClass["get" + fieldName.firstUpper()] = function(callback) {
						var object = this.object;
						if (field.many) {
							if (object[fieldName] == null) {
								object[fieldName] = [];
							}
							object[fieldName].push = function(val){
							};
						}
						if (callback != null) {
							callback(object[fieldName]);
						}
						return object[fieldName];
					};
					wrapperClass["set" + fieldName.firstUpper()] = function(value) {
						this.object[fieldName] = value;
						othis.incrementRunningCalls("set" + fieldName.firstUpper());
						othis.transactionSynchronizer.fetch(function(tid){
							if (field.many) {
								bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttributes", {
									tid: tid,
									oid: this.object.__oid,
									attributeName: fieldName,
									values: value
								}, function(){
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
								});
							} else {
								if (value == null) {
									bimServerApi.call("Bimsie1LowLevelInterface", "unsetAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "string") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setStringAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "double") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "boolean") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setBooleanAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "int") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setIntegerAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else if (field.type == "enum") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setEnumAttribute", {
										tid: tid,
										oid: this.object.__oid,
										attributeName: fieldName,
										value: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else {
									othis.bimServerApi.log("Unimplemented type " + typeof value);
									othis.decrementRunningCalls("set" + fieldName.firstUpper());
								}
								this.object[fieldName] = value;
							}
							if (this.object.changedFields == null) {
								this.object.changedFields = {};
							}
							this.object.changedFields[fieldName] = true;
							othis.changedObjectOids[object.oid] = true;
						});
					};
				}
			})(field, fieldName);
		}
	};
	
	this.getClass = function(typeName){
		if (othis.bimServerApi.classes[typeName] == null) {
			var realType = othis.bimServerApi.schema[typeName];
			if (realType == null) {
				throw "Type " + object.__type + " not found";
			}

			var wrapperClass = {};
			
			wrapperClass.isA = function(typeName){
				return othis.bimServerApi.isA(this.object.__type, typeName);
			};
			wrapperClass.getType = function(){
				return this.object.__type;
			};
			wrapperClass.remove = function(removeCallback){
				othis.incrementRunningCalls("removeObject");
				othis.transactionSynchronizer.fetch(function(tid){
					bimServerApi.call("Bimsie1LowLevelInterface", "removeObject", {tid: tid, oid: this.object.__oid}, function(){
						if (removeCallback != null) {
							removeCallback();
						}
						delete othis.objects[this.object.__oid];
						othis.decrementRunningCalls("removeObject");
					});
				});
			};
			
			othis.extendClass(wrapperClass, typeName);

			othis.bimServerApi.classes[typeName] = wrapperClass;
		}
		return othis.bimServerApi.classes[typeName];
	};
	
	this.createWrapper = function(object, typeName) {
		if (othis.objects[object.__oid] != null) {
			console.log("Warning!", object);
		}
		object.oid = object.__oid;
		var cl = othis.getClass(typeName);
		var wrapper = Object.create(cl);
		// transient variables
		wrapper.trans = {
			mode: 0
		};
		wrapper.oid = object.oid;
		wrapper.model = othis;
		wrapper.object = object;
		return wrapper;
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
		var promise = othis.createPromise();
		othis.incrementRunningCalls(methodName + "(" + list + ")");
		if (typeof list == "string" || typeof list == "number") {
			list = [list];
		}
		othis.waitForLoaded(function(){
			var len = list.length;
			// Iterating in reverse order because we remove items from this array
			while (len--) {
				var item = list[len];
				if (targetMap[item] != null) {
					// Already loaded? Remove from list and call callback
					if (targetMap[item].object.__state == "LOADED") {
						var index = list.indexOf(item);
						list.splice(index, 1);
						callback(targetMap[item]);
					}
				} else if (fetchingMap[item] != null) {
					// Already loading? Add the callback to the list and remove from fetching list
					fetchingMap[item].push(callback);
					var index = list.indexOf(item);
					list.splice(index, 1);
				}
			}
			// Any left?
			if (list.length > 0) {
				list.forEach(function(item){
					fetchingMap[item] = [];
				});
				othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
					var request = {
						roids: [othis.roid],
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
									var wrapper = null;
									if (othis.objects[object.__oid] != null) {
										wrapper = othis.objects[object.__oid];
										if (wrapper.object.__state != "LOADED") {
											wrapper.object = object;
										}											
									} else {
										wrapper = othis.createWrapper(object, object.__type);
									}
									var item = getValueMethod(object);
									// Checking the value again, because sometimes serializers send more objects...
									if ($.inArray(item, list) != -1) {
										targetMap[item] = wrapper;
										if (fetchingMap[item] != null) {
											fetchingMap[item].forEach(function(cb){
												cb(wrapper);
											});
											delete fetchingMap[item];
										}
										callback(wrapper);
									}
									done++;
									if (done == data.objects.length) {
										bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
											othis.decrementRunningCalls(methodName + "(" + list + ")");
											promise.fire();
										});
									}
								});
							} else {
								othis.bimServerApi.log("Object with " + keyname + " " + list + " not found");
								callback(null);
								promise.fire();
							}
						});
					});
				});
			} else {
				othis.decrementRunningCalls(methodName + "(" + list + ")");
				promise.fire();
			}
		});
		return promise;
	};

	this.getByGuid = function(guids, callback) {
		othis.getByX("getByGuid", "guid", othis.guidsFetching, othis.objectsByGuid, "downloadByGuids", "guids", function(object){return object.getGlobalId()}, guids, callback);
	};

	this.get = function(oids, callback) {
		return othis.getByX("get", "OID", othis.oidsFetching, othis.objects, "downloadByOids", "oids", function(object){return object.__oid}, oids, callback);
	};

	this.getByName = function(names, callback) {
		othis.getByX("getByName", "name", othis.namesFetching, othis.objectsByName, "downloadByNames", "names", function(object){return object.getName == null ? null : object.getName()}, names, callback);
	};

	this.createPromise = function(){
		var promise = {
			isDone: false,
			done: function(callback){
				if (promise.isDone) {
					callback();
				} else {
					promise.callback = callback;
				}
			},
			fire: function(){
				promise.isDone = true;
				if (promise.callback != null) {
					promise.callback();
				}
			}
		};
		return promise;
	};

	this.query = function(query, callback){
		var promise = othis.createPromise();
		var fullTypesLoading = {};
		query.queries.forEach(function(subQuery){
			if (subQuery.type != null) {
				fullTypesLoading[subQuery.type] = true;
				othis.loadedTypes[subQuery.type] = {};
			}
		});
		othis.waitForLoaded(function(){
			othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
				bimServerApi.call("Bimsie1ServiceInterface", "downloadByJsonQuery", {
					roids: [othis.roid],
					jsonQuery: JSON.stringify(query),
					serializerOid: jsonSerializerOid,
					sync: true
				}, function(laid){
					var url = bimServerApi.generateRevisionDownloadUrl({
						laid: laid,
						serializerOid: jsonSerializerOid
					});
					$.getJSON(url, function(data, textStatus, jqXHR){
						data.objects.forEach(function(object){
							var wrapper = othis.objects[object.__oid];
							if (wrapper == null) {
								wrapper = othis.createWrapper(object, object.__type);
								othis.objects[object.__oid] = wrapper;
								if (fullTypesLoading[object.__type] != null) {
									othis.loadedTypes[object.__type][wrapper.oid] = wrapper;
								}
							} else {
								if (object.__state == "LOADED") {
									wrapper.object = object;
								}
							}
//							if (othis.loadedTypes[wrapper.getType()] == null) {
//								othis.loadedTypes[wrapper.getType()] = {};
//							}
//							othis.loadedTypes[wrapper.getType()][object.__oid] = wrapper;
							if (object.__state == "LOADED") {
								callback(wrapper);
							}
						});
						bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
							promise.fire();
						});
					});
				});
			});
		});
		return promise;
	};
	
	this.getAllOfType = function(type, includeAllSubTypes, callback) {
		var promise = othis.createPromise();
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
			} if (othis.loadedTypes[type] != null) {
				for (var oid in othis.loadedTypes[type]) {
					callback(othis.loadedTypes[type][oid]);
				}
				othis.decrementRunningCalls("getAllOfType");
			} else {
				othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
					bimServerApi.call("Bimsie1ServiceInterface", "downloadByTypes", {
						roids: [othis.roid],
						classNames: [type],
						includeAllSubtypes: includeAllSubTypes,
						serializerOid: jsonSerializerOid,
						useObjectIDM: false,
						deep: false,
						sync: true
					}, function(laid){
						var url = bimServerApi.generateRevisionDownloadUrl({
							laid: laid,
							serializerOid: jsonSerializerOid
						});
						$.getJSON(url, function(data, textStatus, jqXHR){
							if (othis.loadedTypes[type] == null) {
								othis.loadedTypes[type] = {};
							}
							data.objects.forEach(function(object){
								if (othis.objects[object.__oid] != null) {
									// Hmm we are doing a query on type, but some objects have already loaded, let's use those instead
									var wrapper = othis.objects[object.__oid];
									if (wrapper.object.__state == "LOADED") {
										if (wrapper.isA(type)) {
											othis.loadedTypes[type][object.__oid] = wrapper;
											callback(wrapper);
										}
									} else {
										// Replace the value with something that's LOADED
										wrapper.object = object;
										if (wrapper.isA(type)) {
											othis.loadedTypes[type][object.__oid] = wrapper;
											callback(wrapper);
										}
									}
								} else {
									var wrapper = othis.createWrapper(object, object.__type);
									othis.objects[object.__oid] = wrapper;
									if (wrapper.isA(type) && object.__state == "LOADED") {
										othis.loadedTypes[type][object.__oid] = wrapper;
										callback(wrapper);
									}
								}
							});
							bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
								othis.decrementRunningCalls("getAllOfType");
								promise.fire();
							});
						});
					});
				});
			}
		});
		return promise;
	};
}

function BimServerWebSocket(baseUrl, bimServerApi) {
	var othis = this;
	this.connected = false;
	this.openCallbacks = [];
	this.endPointId = null;
	this.listener = null;
	this.tosend = [];

	this.connect = function(callback) {
		othis.openCallbacks.push(callback);
		var location = bimServerApi.baseUrl.toString().replace('http://', 'ws://').replace('https://', 'wss://') + "/stream";
		if (typeof(WebSocket) == "function") {
			this._ws = new WebSocket(location);
			this._ws.binaryType = "arraybuffer";
			this._ws.onopen = this._onopen;
			this._ws.onmessage = this._onmessage;
			this._ws.onclose = this._onclose;
		}
	};

	this._onopen = function() {
	};

	this._send = function(message) {
		if (othis._ws && othis.endPointId != null && othis._ws.readyState == 1) {
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
		if (message.data instanceof ArrayBuffer) {
			othis.listener(message.data);
		} else {
			var incomingMessage = JSON.parse(message.data);
			bimServerApi.log("incoming", incomingMessage);
			if (incomingMessage.welcome != null) {
				othis._ws.send(JSON.stringify({"token": bimServerApi.token}));
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
		othis._ws = null;
		othis.connected = false;
		othis.openCallbacks = [];
		othis.endpointid = null;
	};
}