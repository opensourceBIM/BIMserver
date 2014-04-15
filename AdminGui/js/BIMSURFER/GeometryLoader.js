function GeometryLoader(bimServerApi, viewer) {
	var o = this;
	o.bimServerApi = bimServerApi;
	o.viewer = viewer;
	o.state = {};
	o.asyncStream = null;
	o.progressListeners = [];

	this.addProgressListener = function(progressListener) {
		o.progressListeners.push(progressListener);
	};
	
	this.addReadObject = function() {
		o.asyncStream.addReadUTF8(function(type){
			o.state.type = type;
//			console.log("type", type);
		});
		o.asyncStream.addReadLong(function(objectId){
//			console.log("objectid", objectId);
			o.state.objectId = objectId;
		});
		o.asyncStream.addReadByte(function(geometryType){
//			console.log("type", geometryType);
			if (geometryType == GEOMETRY_TYPE_TRIANGLES) {
				o.asyncStream.addReadLong(function(coreId){
//					console.log("coreid", coreId);
					o.state.coreId = coreId;
				});
				o.asyncStream.addReadFloats(6, function(objectBounds){
				});
				o.asyncStream.addReadInt(function(nrIndices){
//					console.log("indices", nrIndices);
					o.asyncStream.addReadIntArray(nrIndices, function(indices){
						o.asyncStream.addReadInt(function(nrVertices){
//							console.log("vertices", nrVertices)
							o.asyncStream.addReadFloatArray(nrVertices, function(vertices){
								o.asyncStream.addReadInt(function(nrNormals){
//									console.log("normals", nrNormals);
									o.asyncStream.addReadFloatArray(nrNormals, function(normals){
										o.asyncStream.addReadInt(function(nrColors){
//											console.log("colors", nrColors);
											o.asyncStream.addReadFloatArray(nrColors * 4, function(colors){
//												console.log("add");
												o.state.nrObjectsRead++;
//												console.log(o.state.nrObjectsRead, o.state.nrObjects);
												o.processGeometry(geometryType, indices, vertices, normals, colors);
												o.updateProgress();
											});
										});
									});
								});
							});
						});
					});
				});
			} else if (geometryType == GEOMETRY_TYPE_INSTANCE) {
				o.asyncStream.addReadLong(function(coreId){
					o.state.coreId = coreId;
					o.state.nrObjectsRead++;
					
					o.processGeometry(geometryType, null, null, null, null);
					o.updateProgress();
				});
			}
		});
		o.asyncStream.addReadFloatArray(16, function(transformationMatrix){
			o.state.transformationMatrix = transformationMatrix;
		});
	};
	
	this.updateProgress = function() {
		if (o.state.nrObjectsRead < o.state.nrObjects) {
			var progress = Math.ceil(50 * o.state.nrObjectsRead / o.state.nrObjects);
			if (progress != o.state.lastProgress) {
				o.progressListeners.forEach(function(progressListener){
					progressListener(50 + progress);
				});
				o.viewer.SYSTEM.events.trigger('progressChanged', [progress]);
				o.state.lastProgress = progress;
			}
			o.addReadObject();
		} else {
			o.viewer.SYSTEM.events.trigger('progressDone');
			o.progressListeners.forEach(function(progressListener){
				progressListener(100);
			});
			o.viewer.events.trigger('sceneLoaded', [o.viewer.scene]);
			o.bimServerApi.call("ServiceInterface", "cleanupLongAction", {actionId: o.topicId}, function(){
			});
		}
	};
	
	this.downloadInitiated = function(){
		o.state = {
			nrObjectsRead: 0,
			nrObjects: 0
		};
		o.asyncStream = new AsyncStream();
		o.viewer.SYSTEM.events.trigger('progressStarted', ['Loading Geometry']);
		o.viewer.SYSTEM.events.trigger('progressBarStyleChanged', BIMSURFER.Constants.ProgressBarStyle.Continuous);
		o.viewer.SYSTEM.events.trigger('progressChanged', [0]);
		o.asyncStream.addReadUTF8(function(start){
			if (start != "BGS") {
				return false;
			}
			o.asyncStream.addReadByte(function(version){
				if (version != 4) {
					return false;
				}
				o.asyncStream.addReadFloats(6, function(modelBounds){
					var modelBounds = {
						min: {x: modelBounds[0], y: modelBounds[1], z: modelBounds[2]},
						max: {x: modelBounds[3], y: modelBounds[4], z: modelBounds[5]}
					};
					
					var center = {
						x: (modelBounds.max.x + modelBounds.min.x) / 2,
						y: (modelBounds.max.y + modelBounds.min.y) / 2,
						z: (modelBounds.max.z + modelBounds.min.z) / 2,
					};
					
//					console.log("Model Bounds", modelBounds);
//					console.log("Center", center);
					
					o.boundsTranslate = o.viewer.scene.findNode("bounds_translate");
					var firstModel = false;
					if (o.boundsTranslate == null) {
						var firstModel = true;
						o.boundsTranslate = {
							id: "bounds_translate",
							type: "translate",
							x: -center.x,
							y: -center.y,
							z: -center.z,
							nodes: []
						}
						o.boundsTranslate = o.viewer.scene.findNode("my-lights").addNode(o.boundsTranslate);
					}
					
					o.modelNode = {
						id: "model_node_" + o.groupId,
						type: "translate",
						x: 0,
						y: 0,
						z: 0,
						data: {
							groupId: o.groupId
						},
						nodes: []
					};
					o.modelNode = o.boundsTranslate.addNode(o.modelNode);
					
					if (firstModel) {
						var lookat = o.viewer.scene.findNode("main-lookAt");
						var eye = { x: (modelBounds.max.x - modelBounds.min.x) * 0.5, y: (modelBounds.max.y - modelBounds.min.y) * -1, z: (modelBounds.max.z - modelBounds.min.z) * 0.5 };
						lookat.set("eye", eye);
						
						var maincamera = o.viewer.scene.findNode("main-camera");
						
						var far = Math.max(modelBounds.max.x - modelBounds.min.x, modelBounds.max.y - modelBounds.min.y, modelBounds.max.z - modelBounds.min.z) * 5;
						
						maincamera.setOptics({
							type: 'perspective',
							far: far,
							near: far / 1000,
							aspect: jQuery(o.viewer.canvas).width() / jQuery(o.viewer.canvas).height(),
							fovy: 37.8493
						});
					}
				}); // model bounds
				o.asyncStream.addReadInt(function(nrObjects){
					o.state.nrObjects = nrObjects;
					if (o.state.nrObjects > 0) {
						o.addReadObject();
					} else {
						o.updateProgress();
					}
				});
			});
		});
		
		o.viewer.refreshMask();

		o.library = o.viewer.scene.findNode("library-" + o.groupId);
		if (o.library == null) {
			o.library = o.viewer.scene.addNode({
				id: "library-" + o.groupId,
				type: "library"
			});
		}
		
		var msg = {
			longActionId: o.topicId,
			topicId: o.groupId
		};
		
		o.bimServerApi.setBinaryDataListener(o.groupId, function(data){
			o.asyncStream.newData(data);
		});
		o.bimServerApi.downloadViaWebsocket(msg);
	};
	
	this.processGeometry = function(geometryType, indices, vertices, normals, colors) {
		if (geometryType == GEOMETRY_TYPE_TRIANGLES) {
			var geometry = {
				type: "geometry",
				primitive: "triangles"
			};
			
			geometry.coreId = o.state.coreId;
			geometry.indices = indices;
			geometry.positions = vertices;
			geometry.normals = normals;
			
			if (colors != null && colors.length > 0) {
				geometry.colors = colors;
			}
			o.library.add("node", geometry);
		}

		var material = BIMSURFER.Constants.materials[o.state.type];
		var hasTransparency = false;
		if (material == null) {
			console.log("material not found", o.state.type);
			material = BIMSURFER.Constants.materials["DEFAULT"];
		}
		if (material.a < 1) {
			hasTransparency = true;
		}

		var enabled = false;
		var state = o.types[o.state.type];
		if (state != null) {
			enabled = state.mode == 0;
		}
		
		var flags = {
			type : "flags",
			flags : {
				transparent : hasTransparency
			},
			nodes : [{
				type: "enable",
				enabled: enabled,
				nodes : [{
					type : "material",
					baseColor: material,
					alpha: material.a,
					nodes : [{
						type : "name",
						id : o.state.objectId,
						nodes : [{
							type: "matrix",
                            elements: o.state.transformationMatrix,
                            nodes:[{
								type: "geometry",
								coreId: o.state.coreId
							}]
						}]
					}]
				}]
			}]
		};
		o.modelNode.addNode(flags);
	};
	
	this.process = function(count){
		if (o.asyncStream != null) {
			o.asyncStream.process(Math.ceil(1 + o.state.nrObjects / 12));
		}
	};
	
	this.progressHandler = function(topicId, state){
		if (topicId == o.topicId) {
			o.progressListeners.forEach(function(progressListener){
				progressListener(state.progress / 2);
			});
			if (state.state == "FINISHED") {
				o.downloadInitiated();
				o.bimServerApi.unregisterProgressHandler(o.topicId, o.progressHandler);
			}
		}
	};

	// Loads everything, but only show the types given in types
	this.setLoadRevision = function(roid, types) {
		o.options = {type: "revision", roid: roid, types: types};
	};
	
	// Only loads the given types
	this.setLoadTypes = function(roid, types) {
		o.options = {type: "types", roid: roid, types: types};
	};
	
	this.start = function(){
		if (o.options != null) {
			if (o.options.type == "types") {
				o.groupId = o.options.roid;
				o.types = o.options.types;
				o.bimServerApi.getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin", function(serializer){
					o.bimServerApi.call("Bimsie1ServiceInterface", "downloadByTypes", {
						roids: [o.options.roid],
						classNames : o.options.types,
						serializerOid : serializer.oid,
						includeAllSubtypes : false,
						useObjectIDM : false,
						sync : false,
						deep: true
					}, function(topicId){
						o.topicId = topicId;
						o.bimServerApi.registerProgressHandler(o.topicId, o.progressHandler);
					});
				});
			} else if (o.options.type == "revision") {
				o.groupId = o.options.roid;
				o.types = o.options.types;
				o.bimServerApi.getSerializerByPluginClassName("org.bimserver.serializers.binarygeometry.BinaryGeometrySerializerPlugin", function(serializer){
					o.bimServerApi.call("Bimsie1ServiceInterface", "download", {
						roid: o.options.roid,
						serializerOid : serializer.oid,
						sync : false,
						showOwn: true
					}, function(topicId){
						o.topicId = topicId;
						o.bimServerApi.registerProgressHandler(o.topicId, o.progressHandler);
					});
				});
			}
		}
	};
}