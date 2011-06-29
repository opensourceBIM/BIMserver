/*
 * Copyright 2009, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


/**
 * @fileoverview This file provides support for deserializing (loading)
 *     transform graphs from JSON files.
 *
 */

o3djs.provide('o3djs.serialization');

o3djs.require('o3djs.error');
o3djs.require('o3djs.texture');

/**
 * A Module for deserializing a scene created by the sample o3dConverter.
 * @namespace
 */
o3djs.serialization = o3djs.serialization || {};

/**
 * The oldest supported version of the serializer. It isn't necessary to
 * increment this version whenever the format changes. Only change it when the
 * deserializer becomes incapable of deserializing an older version.
 * @type {number}
 */
o3djs.serialization.supportedVersion = 5;

/**
 * These are the values the sample o3dConverter uses to identify curve key
 * types.
 * @type {!Object}
 */
o3djs.serialization.CURVE_KEY_TYPES = {
  step: 1,
  linear: 2,
  bezier: 3};

/**
 * Options for deserialization.
 *
 * opt_animSource is an optional ParamFloat that will be bound as the source
 * param for all animation time params in the scene. opt_async is a bool that
 * will make the deserialization process async.
 *
 * @type {{opt_animSource: !o3d.ParamFloat, opt_async: boolean}}
 */
o3djs.serialization.Options = goog.typedef;

/**
 * A Deserializer incrementally deserializes a transform graph.
 * @constructor
 * @param {!o3d.Pack} pack The pack to deserialize into.
 * @param {!Object} json An object tree conforming to the JSON rules.
 */
o3djs.serialization.Deserializer = function(pack, json) {
  /**
   * The pack to deserialize into.
   * @type {!o3d.Pack}
   */
  this.pack = pack;

  /**
   * An object tree conforming to the JSON rules.
   * @type {!Object}
   */
  this.json = json;

  /**
   * The archive from which assets referenced from JSON are retreived.
   * @type {o3djs.io.ArchiveInfo}
   */
  this.archiveInfo = null;

  /**
   * Deserializes a Buffer .
   * @param {!o3djs.serialization.Deserializer} deserializer The deserializer.
   * @param {!Object} json The json for this buffer.
   * @param {string} type The type of buffer to create.
   * @param {string} uri The uri of the file containing the binary data.
   */
  function deserializeBuffer(deserializer, json, type, uri) {
    var object = deserializer.pack.createObject(type);
    if ('custom' in json) {
      if ('fieldData' in json.custom) {
        var fieldDataArray = json.custom.fieldData;
        if (fieldDataArray.length > 0) {
          var fields = [];
          // First create all the fields
          for (var ii = 0; ii < fieldDataArray.length; ++ii) {
            var data = fieldDataArray[ii];
            var field = object.createField(data.type, data.numComponents);
            fields.push(field);
            deserializer.addObject(data.id, field);
          }
          var firstData = fieldDataArray[0];
          var numElements = firstData.data.length / firstData.numComponents;
          object.allocateElements(numElements);
          // Now set the data.
          for (var ii = 0; ii < fieldDataArray.length; ++ii) {
            var data = fieldDataArray[ii];
            fields[ii].setAt(0, data.data);
          }
        }
      } else {
        var rawData = deserializer.archiveInfo.getFileByURI(uri);
        object.set(rawData,
                   json.custom.binaryRange[0],
                   json.custom.binaryRange[1] - json.custom.binaryRange[0]);
        for (var i = 0; i < json.custom.fields.length; ++i) {
          deserializer.addObject(json.custom.fields[i], object.fields[i]);
        }
      }
    }
    return object;
  }

  /**
   * A map from classname to a function that will create
   * instances of objects. Add entries to support additional classes.
   * @type {!Object}
   */
  this.createCallbacks = {
    'o3djs.DestinationBuffer': function(deserializer, json) {
      var object = deserializer.pack.createObject('o3d.VertexBuffer');
      if ('custom' in json) {
        for (var i = 0; i < json.custom.fields.length; ++i) {
          var fieldInfo = json.custom.fields[i]
          var field = object.createField(fieldInfo.type,
                                         fieldInfo.numComponents);
          deserializer.addObject(fieldInfo.id, field);
        }
        object.allocateElements(json.custom.numElements);
      }
      return object;
    },

    'o3d.VertexBuffer': function(deserializer, json) {
      return deserializeBuffer(
          deserializer, json, 'o3d.VertexBuffer', 'vertex-buffers.bin');
    },

    'o3d.SourceBuffer': function(deserializer, json) {
      return deserializeBuffer(
          deserializer, json, 'o3d.SourceBuffer', 'vertex-buffers.bin');
    },

    'o3d.IndexBuffer': function(deserializer, json) {
      return deserializeBuffer(
          deserializer, json, 'o3d.IndexBuffer', 'index-buffers.bin');
    },

    'o3d.Texture2D': function(deserializer, json) {
      if ('o3d.uri' in json.params) {
        var uri = json.params['o3d.uri'].value;
        var rawData = deserializer.archiveInfo.getFileByURI(uri);
        if (!rawData) {
          throw 'Could not find texture ' + uri + ' in the archive';
        }
        return o3djs.texture.createTextureFromRawData(pack, rawData, true);
      } else {
        return deserializer.pack.createTexture2D(
            json.custom.width,
            json.custom.height,
            json.custom.format,
            json.custom.levels,
            json.custom.renderSurfacesEnabled);
      }
    },

    'o3d.TextureCUBE': function(deserializer, json) {
      if ('o3d.negx_uri' in json.params) {
        // Cube map comprised of six separate textures.
        var param_names = [
            'o3d.posx_uri',
            'o3d.negx_uri',
            'o3d.posy_uri',
            'o3d.negy_uri',
            'o3d.posz_uri',
            'o3d.negz_uri'
        ];
        var rawDataArray = [];
        for (var i = 0; i < param_names.length; i++) {
          var uri = json.params[param_names[i]].value;
          var rawData = deserializer.archiveInfo.getFileByURI(uri);
          if (!rawData) {
            throw 'Could not find texture ' + uri + ' in the archive';
          }
          rawDataArray.push(rawData);
        }
        // Cube map faces should not be flipped.
        return o3djs.texture.createTextureFromRawDataArray(
            pack, rawDataArray, true, false);
      } else if ('o3d.uri' in json.params) {
        var uri = json.params['o3d.uri'].value;
        var rawData = deserializer.archiveInfo.getFileByURI(uri);
        if (!rawData) {
          throw 'Could not find texture ' + uri + ' in the archive';
        }
        return o3djs.texture.createTextureFromRawData(pack, rawData, true);
      } else {
        return deserializer.pack.createTextureCUBE(
            json.custom.edgeLength,
            json.custom.format,
            json.custom.levels,
            json.custom.renderSurfacesEnabled);
      }
    }
  };

  /**
   * A map from classname to a function that will initialize
   * instances of the given class from JSON data. Add entries to support
   * additional classes.
   * @type {!Object}
   */
  this.initCallbacks = {
    'o3d.Curve': function(deserializer, object, json) {
      if ('custom' in json) {
        if ('keys' in json.custom) {
          var keys = json.custom.keys;
          var stepType = o3djs.serialization.CURVE_KEY_TYPES.step;
          var linearType = o3djs.serialization.CURVE_KEY_TYPES.linear;
          var bezierType = o3djs.serialization.CURVE_KEY_TYPES.bezier;
          for (var ii = 0; ii < keys.length; ++ii) {
            var key = keys[ii];
            switch (key[0]) {
            case stepType:  // Step
              object.addStepKeys(key.slice(1));
              break;
            case linearType:  // Linear
              object.addLinearKeys(key.slice(1));
              break;
            case bezierType:  // Bezier
              object.addBezierKeys(key.slice(1));
              break;
            }
          }
        } else {
          var rawData = deserializer.archiveInfo.getFileByURI('curve-keys.bin');
          object.set(rawData,
                     json.custom.binaryRange[0],
                     json.custom.binaryRange[1] - json.custom.binaryRange[0]);
        }
      }
    },

    'o3d.Effect': function(deserializer, object, json) {
      var uriParam = object.getParam('o3d.uri');
      if (uriParam) {
        var rawData = deserializer.archiveInfo.getFileByURI(uriParam.value);
        if (!rawData) {
          throw 'Cannot find shader ' + uriParam.value + ' in archive.';
        }
        if (!object.loadFromFXString(rawData.stringValue)) {
          throw 'Cannot load shader ' + uriParam.value + ' in archive.';
        }
      }
    },

    'o3d.Skin': function(deserializer, object, json) {
      if ('custom' in json) {
        if ('binaryRange' in json.custom) {
          var rawData = deserializer.archiveInfo.getFileByURI('skins.bin');
          object.set(rawData,
                     json.custom.binaryRange[0],
                     json.custom.binaryRange[1] - json.custom.binaryRange[0]);
        }
      }
    },

    'o3d.SkinEval': function(deserializer, object, json) {
      if ('custom' in json) {
        for (var i = 0; i < json.custom.vertexStreams.length; ++i) {
          var streamJson = json.custom.vertexStreams[i];
          var field = deserializer.getObjectById(streamJson.stream.field);
          object.setVertexStream(streamJson.stream.semantic,
                                 streamJson.stream.semanticIndex,
                                 field,
                                 streamJson.stream.startIndex);
          if ('bind' in streamJson) {
            var source = deserializer.getObjectById(streamJson.bind);
            object.bindStream(source,
                              streamJson.stream.semantic,
                              streamJson.stream.semanticIndex);
          }
        }
      }
    },

    'o3d.StreamBank': function(deserializer, object, json) {
      if ('custom' in json) {
        for (var i = 0; i < json.custom.vertexStreams.length; ++i) {
          var streamJson = json.custom.vertexStreams[i];
          var field = deserializer.getObjectById(streamJson.stream.field);
          object.setVertexStream(streamJson.stream.semantic,
                                 streamJson.stream.semanticIndex,
                                 field,
                                 streamJson.stream.startIndex);
          if ('bind' in streamJson) {
            var source = deserializer.getObjectById(streamJson.bind);
            object.bindStream(source,
                              streamJson.stream.semantic,
                              streamJson.stream.semanticIndex);
          }
        }
      }
    }
  };

  if (!('version' in json)) {
    throw 'Version in JSON file was missing.';
  }

  if (json.version < o3djs.serialization.supportedVersion) {
    throw 'Version in JSON file was ' + json.version +
        ' but expected at least version ' +
        o3djs.serialization.supportedVersion + '.';
  }

  if (!('objects' in json)) {
    throw 'Objects array in JSON file was missing.';
  }

  /**
   * An array of all objects deserialized so far, indexed by object id. Id zero
   * means null.
   * @type {!Array.<(Object|undefined)>}
   * @private
   */
  this.objectsById_ = [null];

  /**
   * An array of objects deserialized so far, indexed by position in the JSON.
   * @type {!Array.<Object>}
   * @private
   */
  this.objectsByIndex_ = [];

  /**
   * Array of all classes present in the JSON.
   * @type {!Array.<string>}
   * @private
   */
  this.classNames_ = [];
  for (var className in json.objects) {
    this.classNames_.push(className);
  }

  /**
   * The current phase_ of deserialization. In phase_ 0, objects
   * are created and their ids registered. In phase_ 1, objects are
   * initialized from JSON data.
   * @type {number}
   * @private
   */
  this.phase_ = 0;

  /**
   * Index of the next class to be deserialized in classNames_.
   * @type {number}
   * @private
   */
  this.nextClassIndex_ = 0;

  /**
   * Index of the next object of the current class to be deserialized.
   * @type {number}
   * @private
   */
  this.nextObjectIndex_ = 0;

  /**
   * Index of the next object to be deserialized in objectsByIndex_.
   * @type {number}
   * @private
   */
  this.globalObjectIndex_ = 0;
};

/**
 * Get the object with the given id.
 * @param {number} id The id to lookup.
 * @return {(Object|undefined)} The object with the given id.
 */
o3djs.serialization.Deserializer.prototype.getObjectById = function(id) {
  return this.objectsById_[id];
};

/**
 * When a creation or init callback creates an object that the Deserializer
 * is not aware of, it can associate it with an id using this function, so that
 * references to the object can be resolved.
 * @param {number} id The is of the object.
 * @param {!Object} object The object to register.
 */
o3djs.serialization.Deserializer.prototype.addObject = function(
    id, object) {
  this.objectsById_[id] = object;
};

/**
 * Deserialize a value. Identifies reference values and converts
 * their object id into an object reference. Otherwise returns the
 * value unchanged.
 * @param {*} valueJson The JSON representation of the value.
 * @return {*} The JavaScript representation of the value.
 */
o3djs.serialization.Deserializer.prototype.deserializeValue = function(
    valueJson) {
  if (typeof(valueJson) === 'object') {
    if (valueJson === null) {
      return null;
    }

    var valueAsObject = /** @type {!Object} */ (valueJson);
    if ('length' in valueAsObject) {
      for (var i = 0; i != valueAsObject.length; ++i) {
        valueAsObject[i] = this.deserializeValue(valueAsObject[i]);
      }
      return valueAsObject;
    }

    var refId = valueAsObject['ref'];
    if (refId !== undefined) {
      var referenced = this.objectsById_[refId];
      if (referenced === undefined) {
        throw 'Could not find object with id ' + refId + '.';
      }
      return referenced;
    }
  }

  return valueJson;
};

/**
 * Sets the value of a param on an object or binds a param to another.
 * @param {!Object} object The object holding the param.
 * @param {(string|number)} paramName The name of the param.
 * @param {!Object} propertyJson The JSON representation of the value.
 * @private
 */
o3djs.serialization.Deserializer.prototype.setParamValue_ = function(
    object, paramName, propertyJson) {
  var param = object.getParam(paramName);
  if (param === null)
    return;

  var valueJson = propertyJson['value'];
  if (valueJson !== undefined) {
    param.value = this.deserializeValue(valueJson);
  }

  var bindId = propertyJson['bind'];
  if (bindId !== undefined) {
    var referenced = this.objectsById_[bindId];
    if (referenced === undefined) {
      throw 'Could not find output param with id ' + bindId + '.';
    }
    param.bind(referenced);
  }
};

/**
 * Creates a param on an object and adds it's id so that other objects can
 * reference it.
 * @param {!Object} object The object to hold the param.
 * @param {(string|number)} paramName The name of the param.
 * @param {!Object} propertyJson The JSON representation of the value.
 * @private
 */
o3djs.serialization.Deserializer.prototype.createAndIdentifyParam_ =
    function(object, paramName, propertyJson) {
  var propertyClass = propertyJson['class'];
  var param;
  if (propertyClass !== undefined) {
    param = object.createParam(paramName, propertyClass);
  } else {
    param = object.getParam(paramName);
  }

  var paramId = propertyJson['id'];
  if (paramId !== undefined && param !== null) {
    this.objectsById_[paramId] = param;
  }
};

/**
 * First pass: create all objects and additional params. We need two
 * passes to support references to objects that appear later in the
 * JSON.
 * @param {number} amountOfWork The number of loop iterations to perform of
 *     this phase_.
 * @private
 */
o3djs.serialization.Deserializer.prototype.createObjectsPhase_ =
     function(amountOfWork) {
  for (; this.nextClassIndex_ < this.classNames_.length;
       ++this.nextClassIndex_) {
    var className = this.classNames_[this.nextClassIndex_];
    var classJson = this.json.objects[className];
    var numObjects = classJson.length;
    for (; this.nextObjectIndex_ < numObjects; ++this.nextObjectIndex_) {
      if (amountOfWork-- <= 0)
        return;

      var objectJson = classJson[this.nextObjectIndex_];
      var object = undefined;
      if ('id' in objectJson) {
        object = this.objectsById_[objectJson.id];
      }
      if (object === undefined) {
        if (className in this.createCallbacks) {
          object = this.createCallbacks[className](this, objectJson);
        } else {
          object = this.pack.createObject(className);
        }
      }
      this.objectsByIndex_[this.globalObjectIndex_++] = object;
      if ('id' in objectJson) {
        this.objectsById_[objectJson.id] = object;
      }
      if ('params' in objectJson) {
        if ('length' in objectJson.params) {
          for (var paramIndex = 0; paramIndex != objectJson.params.length;
              ++paramIndex) {
            var paramJson = objectJson.params[paramIndex];
            this.createAndIdentifyParam_(object, paramIndex,
                                         paramJson);
          }
        } else {
          for (var paramName in objectJson.params) {
            var paramJson = objectJson.params[paramName];
            this.createAndIdentifyParam_(object, paramName, paramJson);
          }
        }
      }
    }
    this.nextObjectIndex_ = 0;
  }

  if (this.nextClassIndex_ === this.classNames_.length) {
    this.nextClassIndex_ = 0;
    this.nextObjectIndex_ = 0;
    this.globalObjectIndex_ = 0;
    ++this.phase_;
  }
};

/**
 * Second pass: set property and parameter values and bind parameters.
 * @param {number} amountOfWork The number of loop iterations to perform of
 *     this phase_.
 * @private
 */
o3djs.serialization.Deserializer.prototype.setPropertiesPhase_ = function(
    amountOfWork) {
  for (; this.nextClassIndex_ < this.classNames_.length;
       ++this.nextClassIndex_) {
    var className = this.classNames_[this.nextClassIndex_];
    var classJson = this.json.objects[className];
    var numObjects = classJson.length;
    for (; this.nextObjectIndex_ < numObjects; ++this.nextObjectIndex_) {
      if (amountOfWork-- <= 0)
        return;

      var objectJson = classJson[this.nextObjectIndex_];
      var object = this.objectsByIndex_[this.globalObjectIndex_++];
      if ('properties' in objectJson) {
        for (var propertyName in objectJson.properties) {
          if (propertyName in object) {
            var propertyJson = objectJson.properties[propertyName];
            var propertyValue = this.deserializeValue(propertyJson);
            object[propertyName] = propertyValue;
          }
        };
      }
      if ('params' in objectJson) {
        if ('length' in objectJson.params) {
          for (var paramIndex = 0; paramIndex != objectJson.params.length;
              ++paramIndex) {
            var paramJson = objectJson.params[paramIndex];
            this.setParamValue_(/** @type {!Object} */ (object),
                                paramIndex,
                                paramJson);
          }
        } else {
          for (var paramName in objectJson.params) {
            var paramJson = objectJson.params[paramName];
            this.setParamValue_(/** @type {!Object} */ (object),
                                paramName,
                                paramJson);
          }
        }
      }
      if (className in this.initCallbacks) {
        this.initCallbacks[className](this, object, objectJson);
      }
    }
    this.nextObjectIndex_ = 0;
  }

  if (this.nextClassIndex_ === this.classNames_.length) {
    this.nextClassIndex_ = 0;
    this.nextObjectIndex_ = 0;
    this.globalObjectIndex_ = 0;
    ++this.phase_;
  }
};

/**
 * Perform a certain number of iterations of the deserializer. Keep calling this
 * function until it returns false.
 * @param {number} opt_amountOfWork The number of loop iterations to run. If
 *     not specified, runs the deserialization to completion.
 * @return {boolean} Whether work remains to be done.
 */
o3djs.serialization.Deserializer.prototype.run = function(
    opt_amountOfWork) {
  if (!opt_amountOfWork) {
    while (this.run(10000)) {
    }
    return false;
  } else {
    switch (this.phase_) {
    case 0:
      this.createObjectsPhase_(opt_amountOfWork);
      break;
    case 1:
      this.setPropertiesPhase_(opt_amountOfWork);
      break;
    }
    return this.phase_ < 2;
  }
};

/**
 * Deserializes (loads) a transform graph in the background. Invokes
 * a callback function on completion passing the pack and the thrown
 * exception on failure or the pack and a null exception on success.
 * @param {!o3d.Client} client An O3D client object.
 * @param {!o3d.Pack} pack The pack to create the deserialized objects
 *     in.
 * @param {number} time The amount of the time (in seconds) the deserializer
 *     should aim to complete in.
 * @param {!function(o3d.Pack, *): void} callback The function that
 *     is called on completion. The second parameter is null on success or
 *     the thrown exception on failure.
 */
o3djs.serialization.Deserializer.prototype.runBackground = function(
    client, pack, time, callback) {
  // TODO: This seems like it needs to be more granular than the
  //    top level.
  // TODO: Passing in the time you want it to take seems counter
  //   intuitive. I want pass in a % of CPU so I can effectively say
  //   "deserialize this in such a way so as not to affect my app's
  //   performance".  callbacksRequired = numObjects / amountPerCallback where
  //   amountPerCallback = number I can do per frame and not affect performance
  //   too much.
  var workToDo = this.json.objects.length * 2;
  var timerCallbacks = time * 60;
  var amountPerCallback = workToDo / timerCallbacks;
  var intervalId;
  var that = this;
  function deserializeMore() {
    var exception = null;
    var finished = false;
    var failed = false;
    var errorCollector = o3djs.error.createErrorCollector(client);
    try {
      finished = !that.run(amountPerCallback);
    } catch(e) {
      failed = true;
      finished = true;
      exception = e;
    }
    if (errorCollector.errors.length > 0) {
      finished = true;
      exception = errorCollector.errors.join('\n') +
                  (exception ? ('\n' + exception.toString()) : '');
    }
    errorCollector.finish();
    if (finished) {
      window.clearInterval(intervalId);
      callback(pack, exception);
    }
  }

  intervalId = window.setInterval(deserializeMore, 1000 / 60);
};

/**
 * Creates a deserializer that will incrementally deserialize a
 * transform graph. The deserializer object has a method
 * called run that does a fixed amount of work and returns.
 * It returns true until the transform graph is fully deserialized.
 * It returns false from then on.
 * @param {!o3d.Pack} pack The pack to create the deserialized
 *     objects in.
 * @param {!Object} json An object tree conforming to the JSON rules.
 * @return {!o3djs.serialization.Deserializer} A deserializer object.
 */
o3djs.serialization.createDeserializer = function(pack, json) {
  return new o3djs.serialization.Deserializer(pack, json);
};

/**
 * Deserializes a transform graph.
 * @param {!o3d.Pack} pack The pack to create the deserialized
 *     objects in.
 * @param {!Object} json An object tree conforming to the JSON rules.
 */
o3djs.serialization.deserialize = function(pack, json) {
  var deserializer = o3djs.serialization.createDeserializer(pack, json);
  deserializer.run();
};

/**
 * Deserializes a single json object named 'scene.json' from a loaded
 * o3djs.io.ArchiveInfo.
 * @param {!o3djs.io.ArchiveInfo} archiveInfo Archive to load from.
 * @param {string} sceneJsonUri The relative URI of the scene JSON file within
 *     the archive.
 * @param {!o3d.Client} client An O3D client object.
 * @param {!o3d.Pack} pack The pack to create the deserialized objects
 *     in.
 * @param {!o3d.Transform} parent Transform to parent loaded stuff from.
 * @param {!function(!o3d.Pack, !o3d.Transform, *): void} callback A function
 *     that will be called when deserialization is finished. It will be passed
 *     the pack, the parent transform, and an exception which will be null on
 *     success.
 * @param {!o3djs.serialization.Options} opt_options Options.
 */
o3djs.serialization.deserializeArchive = function(archiveInfo,
                                                  sceneJsonUri,
                                                  client,
                                                  pack,
                                                  parent,
                                                  callback,
                                                  opt_options) {
  opt_options = opt_options || { };
  var jsonFile = archiveInfo.getFileByURI(sceneJsonUri);
  if (!jsonFile) {
    throw 'Could not find ' + sceneJsonUri + ' in archive';
  }
  var parsed = eval('(' + jsonFile.stringValue + ')');
  var deserializer = o3djs.serialization.createDeserializer(pack, parsed);

  deserializer.addObject(parsed.o3d_rootObject_root, parent);
  deserializer.archiveInfo = archiveInfo;

  var finishCallback = function(pack, exception) {
    if (!exception) {
      var objects = pack.getObjects('o3d.animSourceOwner', 'o3d.ParamObject');
      if (objects.length > 0) {
        // Rebind the output connections of the animSource to the user's param.
        if (opt_options.opt_animSource) {
          var animSource = objects[0].getParam('animSource');
          var outputConnections = animSource.outputConnections;
          for (var ii = 0; ii < outputConnections.length; ++ii) {
            outputConnections[ii].bind(opt_options.opt_animSource);
          }
        }
        // Remove special object from pack.
        for (var ii = 0; ii < objects.length; ++ii) {
          pack.removeObject(objects[ii]);
        }
      }
    }
    callback(pack, parent, exception);
  };

  if (opt_options.opt_async) {
    // TODO: Remove the 5. See deserializer.runBackground comments.
    deserializer.runBackground(client, pack, 5, finishCallback);
  } else {
    var exception = null;
    var errorCollector = o3djs.error.createErrorCollector(client);
    try {
      deserializer.run();
    } catch (e) {
      exception = e;
    }
    if (errorCollector.errors.length > 0) {
      exception = errorCollector.errors.join('\n') +
                  (exception ? ('\n' + exception.toString()) : '');
    }
    errorCollector.finish();
    finishCallback(pack, exception);
  }
};


