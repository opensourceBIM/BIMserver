define(["bimserverapi_Synchronizer", "bimserverapi_BimServerApiPromise"], function(Synchronizer, BimServerPromise){
	return function(bimServerApi, poid, roid, schema) {
		var othis = this;
		othis.schema = schema;
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

		// Those are only fully loaded types (all of them), should not be stored here if loaded partially
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
							topicId: laid,
							serializerOid: jsonSerializerOid
						});
						$.getJSON(url, function(data, textStatus, jqXHR){
							data.objects.forEach(function(object){
								othis.objects[object._i] = othis.createWrapper(object, object._t);
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
				object._t = className;
				var wrapper = othis.createWrapper({}, className);
				bimServerApi.call("Bimsie1LowLevelInterface", "createObject", {tid: tid, className: className}, function(oid){
					wrapper._i = oid;
					othis.objects[object._i] = wrapper;
					object._s = 1;
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
			if (othis.loaded || othis.loadedDeep) {
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
			var realType = othis.bimServerApi.schemas[othis.schema][typeName];
			realType.superclasses.forEach(function(typeName){
				othis.extendClass(wrapperClass, typeName);
			});
			for (var fieldName in realType.fields){
				var field = realType.fields[fieldName];
				(function(field, fieldName){
					if (field.reference) {
						wrapperClass["set" + fieldName.firstUpper() + "Wrapped"] = function(typeName, value) {
							var object = this.object;
							object[fieldName] = {_t: typeName, value: value};
							othis.incrementRunningCalls("set" + fieldName.firstUpper() + "Wrapped");
							othis.transactionSynchronizer.fetch(function(tid){
								var type = othis.bimServerApi.schemas[othis.schema][typeName];
								var wrappedValueType = type.fields.wrappedValue;
								if (wrappedValueType.type == "string") {
									bimServerApi.call("Bimsie1LowLevelInterface", "setWrappedStringAttribute", {
										tid: tid,
										oid: object._i,
										attributeName: fieldName,
										type: typeName,
										value: value
									}, function(){
										if (object.changedFields == null) {
											object.changedFields = {};
										}
										object.changedFields[fieldName] = true;
										othis.changedObjectOids[object.oid] = true;
										othis.incrementChanges();
										othis.decrementRunningCalls("set" + fieldName.firstUpper() + "Wrapped");
									});
								}
							});
						};
						wrapperClass["set" + fieldName.firstUpper()] = function(value) {
							var object = this.object;
							othis.transactionSynchronizer.fetch(function(tid){
								object[fieldName] = value;
								othis.incrementRunningCalls("set" + fieldName.firstUpper());
								if (value == null) {
									bimServerApi.call("Bimsie1LowLevelInterface", "unsetReference", {
										tid: tid,
										oid: object._i,
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
										oid: object._i,
										referenceName: fieldName,
										referenceOid: value._i
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
						wrapperClass["add" + fieldName.firstUpper()] = function(value, callback) {
							var object = this.object;
							othis.transactionSynchronizer.fetch(function(tid){
								if (object[fieldName] == null) {
									object[fieldName] = [];
								}
								object[fieldName].push(value);
								othis.incrementRunningCalls("add" + fieldName.firstUpper());
								bimServerApi.call("Bimsie1LowLevelInterface", "addReference", {
									tid: tid,
									oid: object._i,
									referenceName: fieldName,
									referenceOid: value._i
								}, function(){
									othis.decrementRunningCalls("add" + fieldName.firstUpper());
									if (object.changedFields == null) {
										object.changedFields = {};
									}
									object.changedFields[fieldName] = true;
									othis.changedObjectOids[object.oid] = true;
									if (callback != null) {
										callback();
									}
								});
							});
						};
						wrapperClass["remove" + fieldName.firstUpper()] = function(value, callback) {
							var object = this.object;
							othis.transactionSynchronizer.fetch(function(tid){
								var list = object[fieldName];
								var index = list.indexOf(value);
								list.splice(index, 1);
								
								othis.incrementRunningCalls("remove" + fieldName.firstUpper());
								bimServerApi.call("Bimsie1LowLevelInterface", "removeReference", {
									tid: tid,
									oid: object._i,
									referenceName: fieldName,
									index: index
								}, function(){
									othis.decrementRunningCalls("remove" + fieldName.firstUpper());
									if (object.changedFields == null) {
										object.changedFields = {};
									}
									object.changedFields[fieldName] = true;
									othis.changedObjectOids[object.oid] = true;
									if (callback != null) {
										callback();
									}
								});
							});
						};
						wrapperClass["get" + fieldName.firstUpper()] = function(callback) {
							var object = this.object;
							var model = this.model;
							var promise = new BimServerPromise();
							if (object[fieldName] != null) {
								if (field.many) {
									object[fieldName].forEach(function(item){
										callback(item);
									});
								} else {
									callback(object[fieldName]);
								}							
								promise.fire();
								return promise;
							}
							var embValue = object["_e" + fieldName];
							if (embValue != null) {
								callback(embValue);
								promise.fire();
								return promise;
							}
							var value = object["_r" + fieldName];
							if (field.many) {
								if (object[fieldName] == null) {
									object[fieldName] = [];
								}
								if (value != null) {
									model.get(value, function(v){
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
									} else if (ref == null || ref.object._s == 0) {
										model.get(value, function(v){
											object[fieldName] = v;
											callback(v);
										}).done(function(){
											promise.fire();
										});
									} else {
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
							var object = this.object;
							object[fieldName] = value;
							othis.incrementRunningCalls("set" + fieldName.firstUpper());
							othis.transactionSynchronizer.fetch(function(tid){
								if (field.many) {
									bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttributes", {
										tid: tid,
										oid: object._i,
										attributeName: fieldName,
										values: value
									}, function(){
										othis.decrementRunningCalls("set" + fieldName.firstUpper());
									});
								} else {
									if (value == null) {
										bimServerApi.call("Bimsie1LowLevelInterface", "unsetAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else if (field.type == "string") {
										bimServerApi.call("Bimsie1LowLevelInterface", "setStringAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName,
											value: value
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else if (field.type == "double") {
										bimServerApi.call("Bimsie1LowLevelInterface", "setDoubleAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName,
											value: value
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else if (field.type == "boolean") {
										bimServerApi.call("Bimsie1LowLevelInterface", "setBooleanAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName,
											value: value
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else if (field.type == "int") {
										bimServerApi.call("Bimsie1LowLevelInterface", "setIntegerAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName,
											value: value
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else if (field.type == "enum") {
										bimServerApi.call("Bimsie1LowLevelInterface", "setEnumAttribute", {
											tid: tid,
											oid: object._i,
											attributeName: fieldName,
											value: value
										}, function(){
											othis.decrementRunningCalls("set" + fieldName.firstUpper());
										});
									} else {
										othis.bimServerApi.log("Unimplemented type " + typeof value);
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
					}
				})(field, fieldName);
			}
		};
		
		this.dumpByType = function(){
			var mapLoaded = {};
			var mapNotLoaded = {};
			for (var oid in othis.objects) {
				var object = othis.objects[oid];
				var type = object.getType();
				var counter = mapLoaded[type];
				if (object.object._s == 1) {
					if (counter == null) {
						mapLoaded[type] = 1;
					} else {
						mapLoaded[type] = counter + 1;
					}
				}
				if (object.object._s == 0) {
					var counter = mapNotLoaded[type];
					if (counter == null) {
						mapNotLoaded[type] = 1;
					} else {
						mapNotLoaded[type] = counter + 1;
					}
				}
			}
			console.log("LOADED");
			for (var type in mapLoaded) {
				console.log(type, mapLoaded[type]);
			}
			console.log("NOT_LOADED");
			for (var type in mapNotLoaded) {
				console.log(type, mapNotLoaded[type]);
			}
		};
		
		this.getClass = function(typeName){
			if (othis.bimServerApi.classes[typeName] == null) {
				var realType = othis.bimServerApi.schemas[othis.schema][typeName];
				if (realType == null) {
					if (typeName == "GeometryInfo") {
						return null;
					}
					throw "Type " + typeName + " not found in schema " + othis.schema;
				}

				var wrapperClass = {};
				
				wrapperClass.isA = function(typeName){
					return othis.bimServerApi.isA(othis.schema, this.object._t, typeName);
				};
				wrapperClass.getType = function(){
					return this.object._t;
				};
				wrapperClass.remove = function(removeCallback){
					othis.incrementRunningCalls("removeObject");
					othis.transactionSynchronizer.fetch(function(tid){
						bimServerApi.call("Bimsie1LowLevelInterface", "removeObject", {tid: tid, oid: this.object._i}, function(){
							if (removeCallback != null) {
								removeCallback();
							}
							delete othis.objects[this.object._i];
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
			if (othis.objects[object._i] != null) {
				console.log("Warning!", object);
			}
			if (typeName == null) {
				console.warn("typeName = null", object);
			}
			object.oid = object._i;
			var cl = othis.getClass(typeName);
			var wrapper = Object.create(cl);
			// transient variables
			wrapper.trans = {
				mode: 2
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
			var promise = new BimServerPromise();
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
						var existingObject = targetMap[item].object;
						if (existingObject._s == 1) {
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
								topicId: laid,
								serializerOid: jsonSerializerOid
							});
							$.getJSON(url, function(data, textStatus, jqXHR){
								if (data.objects.length > 0) {
									var done = 0;
									data.objects.forEach(function(object){
										var wrapper = null;
										if (othis.objects[object._i] != null) {
											wrapper = othis.objects[object._i];
											if (wrapper.object._s != 1) {
												wrapper.object = object;
											}											
										} else {
											wrapper = othis.createWrapper(object, object._t);
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

		this.getByGuids = function(guids, callback) {
			return othis.getByX("getByGuid", "guid", othis.guidsFetching, othis.objectsByGuid, "downloadByGuids", "guids", function(object){return object.GlobalId}, guids, callback);
		};

		this.get = function(oids, callback) {
			return othis.getByX("get", "OID", othis.oidsFetching, othis.objects, "downloadByOids", "oids", function(object){return object._i}, oids, callback);
		};

		this.getByName = function(names, callback) {
			return othis.getByX("getByName", "name", othis.namesFetching, othis.objectsByName, "downloadByNames", "names", function(object){return object.getName == null ? null : object.getName()}, names, callback);
		};

		this.query = function(query, callback){
			var promise = new BimServerPromise();
			var fullTypesLoading = {};
			query.queries.forEach(function(subQuery){
				if (subQuery.type != null) {
					fullTypesLoading[subQuery.type] = true;
					othis.loadedTypes[subQuery.type] = {};
					if (subQuery.includeAllSubTypes) {
						var schema = othis.bimServerApi.schemas[othis.schema];
						othis.bimServerApi.getAllSubTypes(schema, subQuery.type, function(subTypeName){
							fullTypesLoading[subTypeName] = true;
							othis.loadedTypes[subTypeName] = {};
						});
					}
				}
			});
			othis.waitForLoaded(function(){
				othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
					bimServerApi.callWithFullIndication("Bimsie1ServiceInterface", "downloadByJsonQuery", {
						roids: [othis.roid],
						jsonQuery: JSON.stringify(query),
						serializerOid: jsonSerializerOid,
						sync: true
					}, function(laid){
						var url = bimServerApi.generateRevisionDownloadUrl({
							laid: laid,
							topicId: laid,
							serializerOid: jsonSerializerOid
						});
						othis.bimServerApi.notifier.setInfo("Getting model data...", -1);
						$.getJSON(url, function(data, textStatus, jqXHR){
//							console.log("query", data.objects.length);
							data.objects.forEach(function(object){
								var wrapper = othis.objects[object._i];
								if (wrapper == null) {
									wrapper = othis.createWrapper(object, object._t);
									othis.objects[object._i] = wrapper;
									if (fullTypesLoading[object._t] != null) {
										othis.loadedTypes[object._t][wrapper.oid] = wrapper;
									}
								} else {
									if (object._s == 1) {
										wrapper.object = object;
									}
								}
//								if (othis.loadedTypes[wrapper.getType()] == null) {
//									othis.loadedTypes[wrapper.getType()] = {};
//								}
//								othis.loadedTypes[wrapper.getType()][object._i] = wrapper;
								if (object._s == 1) {
									callback(wrapper);
								}
							});
//							othis.dumpByType();
							bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: laid}, function(){
								promise.fire();
								othis.bimServerApi.notifier.setSuccess("Model data successfully downloaded...");
							});
						});
					});
				});
			});
			return promise;
		};
		
		this.getAllOfType = function(type, includeAllSubTypes, callback) {
			var promise = new BimServerPromise();
			othis.incrementRunningCalls("getAllOfType");
			othis.waitForLoaded(function(){
				if (othis.loadedDeep) {
					for (var oid in othis.objects) {
						var object = othis.objects[oid];
						if (object._t == type) {
							callback(object);
						}
					}
					othis.decrementRunningCalls("getAllOfType");
					promise.fire();
				} else {
					var types = [];
					types.push(type);
					if (includeAllSubTypes) {
						othis.bimServerApi.getAllSubTypes(othis.bimServerApi.schemas[othis.schema], type, function(subType){
							types.push(subType);	
						});
					}
					
					var typesToLoad = [];
					
					types.forEach(function(type){
						if (othis.loadedTypes[type] != null) {
							for (var oid in othis.loadedTypes[type]) {
								callback(othis.loadedTypes[type][oid]);
							}
						} else {
							typesToLoad.push(type);
						}
					});

					if (typesToLoad.length > 0) {
						othis.bimServerApi.jsonSerializerFetcher.fetch(function(jsonSerializerOid){
							bimServerApi.call("Bimsie1ServiceInterface", "downloadByTypes", {
								roids: [othis.roid],
								classNames: typesToLoad,
								schema: othis.schema,
								includeAllSubtypes: false,
								serializerOid: jsonSerializerOid,
								useObjectIDM: false,
								deep: false,
								sync: true
							}, function(laid){
								var url = bimServerApi.generateRevisionDownloadUrl({
									laid: laid,
									topicId: laid,
									serializerOid: jsonSerializerOid
								});
								$.getJSON(url, function(data, textStatus, jqXHR){
									if (othis.loadedTypes[type] == null) {
										othis.loadedTypes[type] = {};
									}
									data.objects.forEach(function(object){
										if (othis.objects[object._i] != null) {
											// Hmm we are doing a query on type, but some objects have already loaded, let's use those instead
											var wrapper = othis.objects[object._i];
											if (wrapper.object._s == 1) {
												if (wrapper.isA(type)) {
													othis.loadedTypes[type][object._i] = wrapper;
													callback(wrapper);
												}
											} else {
												// Replace the value with something that's LOADED
												wrapper.object = object;
												if (wrapper.isA(type)) {
													othis.loadedTypes[type][object._i] = wrapper;
													callback(wrapper);
												}
											}
										} else {
											var wrapper = othis.createWrapper(object, object._t);
											othis.objects[object._i] = wrapper;
											if (wrapper.isA(type) && object._s == 1) {
												othis.loadedTypes[type][object._i] = wrapper;
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
					} else {
						othis.decrementRunningCalls("getAllOfType");
						promise.fire();
					}
				}
			});
			return promise;
		};
	}
});
