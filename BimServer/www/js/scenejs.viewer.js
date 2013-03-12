/*
 * BIMsurfer
 * Copyright 2012, Bimsurfer.org.
 */
"use strict";

var SceneJsViewer = function(viewportDiv, canvasDiv) {
	var othis = this;
  
  this.modifySubAttr = function(node, attr, subAttr, value) {
    var attrRecord;
    attrRecord = node.get(attr);
    attrRecord[subAttr] = value;
    return node.set(attr, attrRecord);
  };

  this.recordToVec3 = function(record) {
    return [record.x, record.y, record.z];
  };

  this.recordToVec4 = function(record) {
    return [record.x, record.y, record.z, record.w];
  };

  this.vec3ToRecord = function(vec) {
    return {
      x: vec[0],
      y: vec[1],
      z: vec[2]
    };
  };

  this.vec4ToRecord = function(vec) {
    return {
      x: vec[0],
      y: vec[1],
      z: vec[2],
      w: vec[3]
    };
  };

  this.lookAtToQuaternion = function(lookAt) {
    var eye, look, up, x, y, z;
    eye = othis.recordToVec3(lookAt.eye);
    look = othis.recordToVec3(lookAt.look);
    up = othis.recordToVec3(lookAt.up);
    x = [0.0, 0.0, 0.0];
    y = [0.0, 0.0, 0.0];
    z = [0.0, 0.0, 0.0];
    SceneJS_math_subVec3(look, eye, z);
    SceneJS_math_cross3Vec3(up, z, x);
    SceneJS_math_cross3Vec3(z, x, y);
    SceneJS_math_normalizeVec3(x);
    SceneJS_math_normalizeVec3(y);
    SceneJS_math_normalizeVec3(z);
    return SceneJS_math_newQuaternionFromMat3(x.concat(y, z));
  };

  this.orbitLookAt = function(dAngles, orbitUp, lookAt) {
    var axes, axesNorm, dAngle, eye0, eye1, look, result, rotAxis, rotMat, tangent1, tangentError, transformedX, transformedZ, up0, up1;
    if (dAngles[0] === 0.0 && dAngles[1] === 0.0) {
      return {
        eye: lookAt.eye,
        look: lookAt.look,
        up: lookAt.up
      };
    }
    eye0 = othis.recordToVec3(lookAt.eye);
    up0 = othis.recordToVec3(lookAt.up);
    look = othis.recordToVec3(lookAt.look);
    axes = [[0.0, 0.0, 0.0], [0.0, 0.0, 0.0], [0.0, 0.0, 0.0]];
    axesNorm = [[0.0, 0.0, 0.0], [0.0, 0.0, 0.0], [0.0, 0.0, 0.0]];
    SceneJS_math_subVec3(eye0, look, axes[2]);
    SceneJS_math_cross3Vec3(up0, axes[2], axes[0]);
    SceneJS_math_normalizeVec3(axes[0], axesNorm[0]);
    SceneJS_math_normalizeVec3(axes[2], axesNorm[2]);
    SceneJS_math_cross3Vec3(axesNorm[2], axesNorm[0], axesNorm[1]);
    rotAxis = [axesNorm[0][0] * -dAngles[1] + axesNorm[1][0] * -dAngles[0], axesNorm[0][1] * -dAngles[1] + axesNorm[1][1] * -dAngles[0], axesNorm[0][2] * -dAngles[1] + axesNorm[1][2] * -dAngles[0]];
    dAngle = SceneJS_math_lenVec2(dAngles);
    rotMat = SceneJS_math_rotationMat4v(dAngle, rotAxis);
    transformedX = SceneJS_math_transformVector3(rotMat, axesNorm[0]);
    transformedZ = SceneJS_math_transformVector3(rotMat, axes[2]);
    eye1 = [0.0, 0.0, 0.0];
    SceneJS_math_addVec3(look, transformedZ, eye1);
    tangent1 = transformedX;
    tangentError = [0.0, 0.0, 0.0];
    SceneJS_math_mulVec3(tangent1, orbitUp, tangentError);
    SceneJS_math_subVec3(tangent1, tangentError);
    up1 = [0.0, 0.0, 0.0];
    SceneJS_math_cross3Vec3(transformedZ, tangent1, up1);
    return result = {
      eye: othis.vec3ToRecord(eye1),
      look: lookAt.look,
      up: othis.vec3ToRecord(up1)
    };
  };

  this.orbitLookAtNode = function(node, dAngles, orbitUp) {
    return node.set(othis.orbitLookAt(dAngles, orbitUp, {
      eye: node.get('eye'),
      look: node.get('look'),
      up: node.get('up')
    }));
  };

  this.zoomLookAt = function(distance, limits, lookAt) {
    var eye0, eye0len, eye1, eye1len, look, result;
    eye0 = othis.recordToVec3(lookAt.eye);
    look = othis.recordToVec3(lookAt.look);
    eye0len = SceneJS_math_lenVec3(eye0);
    eye1len = Math.clamp(eye0len + distance, limits[0], limits[1]);
    eye1 = [0.0, 0.0, 0.0];
    SceneJS_math_mulVec3Scalar(eye0, eye1len / eye0len, eye1);
    return result = {
      eye: othis.vec3ToRecord(eye1),
      look: lookAt.look,
      up: lookAt.up
    };
  };

  this.zoomLookAtNode = function(node, distance, limits) {
    return node.set(othis.zoomLookAt(distance, limits, {
      eye: node.get('eye'),
      look: node.get('look'),
      up: node.get('up')
    }));
  };

  this.lookAtPanRelative = function(dPosition, lookAt) {
    var axes, dPositionProj, eye, look, result, up;
    if (dPosition[0] === 0.0 && dPosition[1] === 0.0) {
      return {
        eye: lookAt.eye,
        look: lookAt.look,
        up: lookAt.up
      };
    }
    eye = othis.recordToVec3(lookAt.eye);
    look = othis.recordToVec3(lookAt.look);
    up = othis.recordToVec3(lookAt.up);
    axes = [[0.0, 0.0, 0.0], [0.0, 0.0, 0.0], [0.0, 0.0, 0.0]];
    SceneJS_math_subVec3(eye, look, axes[2]);
    SceneJS_math_cross3Vec3(up, axes[2], axes[0]);
    SceneJS_math_normalizeVec3(axes[0]);
    SceneJS_math_cross3Vec3(axes[2], axes[0], axes[1]);
    SceneJS_math_normalizeVec3(axes[1]);
    SceneJS_math_mulVec3Scalar(axes[0], dPosition[0]);
    SceneJS_math_mulVec3Scalar(axes[1], dPosition[1]);
    dPositionProj = [0.0, 0.0, 0.0];
    SceneJS_math_addVec3(axes[0], axes[1], dPositionProj);
    return result = {
      eye: othis.vec3ToRecord(SceneJS_math_addVec3(eye, dPositionProj)),
      look: othis.vec3ToRecord(SceneJS_math_addVec3(look, dPositionProj)),
      up: lookAt.up
    };
  };

  this.lookAtNodePanRelative = function(node, dPosition) {
    return node.set(othis.lookAtPanRelative(dPosition, {
      eye: node.get('eye'),
      look: node.get('look'),
      up: node.get('up')
    }));
  };

  this.lerpLookAt = function(t, lookAt0, lookAt1) {
    var q, q0, q1, result;
    q0 = lookAtToQuaternion(lookAt0);
    q1 = lookAtToQuaternion(lookAt1);
    q = SceneJS_math_slerp(t, q0, q1);
    return result = {
      eye: SceneJS_math_lerpVec3(t, 0.0, 1.0, lookAt0.eye, lookAt1.eye),
      look: SceneJS_math_lerpVec3(t, 0.0, 1.0, lookAt0.look, lookAt1.look),
      up: othis.vec3ToRecord(SceneJS_math_newUpVec3FromQuaternion(q))
    };
  };

  this.lerpLookAtNode = function(node, t, lookAt0, lookAt1) {
    return node.set(lerpLookAt(t, lookAt0, lookAt1));
  };

  SceneJS.FX = {};

  SceneJS.FX.Tween = {};

  SceneJS.FX.TweenSpline = (function() {
    var TweenSpline, _dt, _intervalID, _r, _tick, _tweens;
    TweenSpline = (function() {

      function TweenSpline(lookAtNode, play) {
        this._target = lookAtNode;
        this._sequence = [];
        this._timeline = [];
        this._play = play != null ? play : true;
        this._t = 0.0;
      }

      TweenSpline.prototype.tick = function(dt) {
        if (this._play) return this._t += dt;
      };

      TweenSpline.prototype.start = function(lookAt) {
        this._sequence = [
          lookAt != null ? lookAt : {
            eye: this._target.get('eye'),
            look: this._target.get('look'),
            up: this._target.get('up')
          }
        ];
        this._timeline = [0.0];
        return this._t = 0.0;
      };

      TweenSpline.prototype.push = function(lookAt, dt) {
        var dt_prime;
        if (this._sequence.length === 0) this._t = 0.0;
        dt_prime = dt != null ? dt : 5000;
        if (this._timeline.length === 0) dt_prime = 0.0;
        this._timeline.push(this.totalTime() + dt_prime);
        return this._sequence.push(lookAt);
      };

      TweenSpline.prototype.sequence = function(lookAts, dt) {
        var dt_prime, lookAt, _i, _len;
        if (this._sequence.length === 0) this._t = 0.0;
        for (_i = 0, _len = lookAts.length; _i < _len; _i++) {
          lookAt = lookAts[_i];
          dt_prime = dt != null ? dt : 5000;
          if (this._timeline.length === 0) dt_prime = 0.0;
          this._timeline.push(this.totalTime() + dt_prime);
          this._sequence.push(lookAt);
        }
        return null;
      };

      TweenSpline.prototype.pause = function() {
        return this._play = false;
      };

      TweenSpline.prototype.play = function() {
        return this._play = true;
      };

      TweenSpline.prototype.totalTime = function() {
        if (this._timeline.length > 0) {
          return this._timeline[this._timeline.length - 1];
        }
        return 0;
      };

      TweenSpline.prototype.update = function() {
        var dt, i;
        if (this._sequence.length === 0) return false;
        if (!this._play) return true;
        if (this._t >= this.totalTime() || this._sequence.length === 1) {
          this._target.set(this._sequence[this._sequence.length - 1]);
          return false;
        }
        i = 0;
        while (this._timeline[i] <= this._t) {
          ++i;
        }
        dt = this._timeline[i] - this._timeline[i - 1];
        lerpLookAtNode(this._target, (this._t - this._timeline[i - 1]) / dt, this._sequence[i - 1], this._sequence[i]);
        return true;
      };

      return TweenSpline;

    })();
    _tweens = [];
    _intervalID = null;
    _dt = 0;
    _tick = function() {
      var tween, _i, _len;
      for (_i = 0, _len = _tweens.length; _i < _len; _i++) {
        tween = _tweens[_i];
        tween.tick(_dt);
      }
      return null;
    };
    _r = function(lookAtNode, interval) {
      var tween;
      _dt = interval || 50;
      if (_intervalID !== null) clearInterval(_intervalID);
      _intervalID = setInterval(_tick, _dt);
      tween = new TweenSpline(lookAtNode);
      _tweens.push(tween);
      return tween;
    };
    _r.update = function() {
      var i, tween, _results;
      i = 0;
      _results = [];
      while (i < _tweens.length) {
        tween = _tweens[i];
        if (!tween.update()) {
          _results.push(_tweens.splice(i, 1));
        } else {
          _results.push(i += 1);
        }
      }
      return _results;
    };
    return _r;
  })();

  SceneJS.FX.idle = function() {
    SceneJS.FX.TweenSpline.update();
    return null;
  };

  othis.constants = {
    camera: {
      maxOrbitSpeed: Math.PI * 0.1,
      orbitSpeedFactor: 0.01,
      zoomSpeedFactor: 0.05,
      panSpeedFactor: 0.1
    },
    mouse: {
      pickDragThreshold: 10
    },
    canvas: {
      defaultSize: [1024, 512],
      topOffset: 122
    },
    thumbnails: {
      size: [125, 100],
      scale: 2
    },
    highlightMaterial: {
      type: 'material',
      id: 'highlight',
      emit: 0.0,
      baseColor: {
        r: 0.0,
        g: 0.5,
        b: 0.5
      }
    }
  };

  this.mouseCoordsWithinElement = function(event) {
    var coords, element, totalOffsetLeft, totalOffsetTop;
    coords = [0, 0];
    if (!event) {
      event = window.event;
      coords = [event.x, event.y];
    } else {
      element = event.target;
      totalOffsetLeft = 0;
      totalOffsetTop = 0;
      while (element.offsetParent) {
        totalOffsetLeft += element.offsetLeft;
        totalOffsetTop += element.offsetTop;
        element = element.offsetParent;
      }
      coords = [event.pageX - totalOffsetLeft, event.pageY - totalOffsetTop];
    }
    return coords;
  };

  this.mouseDown = function(event) {
    var coords;
    if (!(othis.state.scene != null)) return;
    othis.state.viewport.mouse.last = [event.clientX, event.clientY];
    switch (event.which) {
      case 1:
        othis.state.viewport.mouse.leftDown = true;
        break;
      case 2:
        othis.state.viewport.mouse.middleDown = true;
    }
    if (event.which === 1) {
      coords = othis.mouseCoordsWithinElement(event);
      return othis.state.viewport.mouse.pickRecord = othis.state.scene.pick(coords[0], coords[1]);
    }
  };

  this.mouseUp = function(event) {
    if (!(othis.state.scene != null)) return;
    if (event.which === 1 && othis.state.viewport.mouse.leftDragDistance < othis.constants.mouse.pickDragThreshold) {
      if (othis.state.viewport.mouse.pickRecord != null) {
        othis.controlsTreeSelectObject(othis.state.viewport.mouse.pickRecord.name);
      } else {
        othis.controlsTreeSelectObject();
      }
      othis.state.viewport.mouse.pickRecord = null;
    }
    switch (event.which) {
      case 1:
        othis.state.viewport.mouse.leftDown = false;
        return othis.state.viewport.mouse.leftDragDistance = 0;
      case 2:
        othis.state.viewport.mouse.middleDown = false;
        return othis.state.viewport.mouse.middleDragDistance = 0;
    }
  };

  this.mouseMove = function(event) {
	  event.preventDefault();
    var delta, deltaLength, orbitAngles, panVector;
    delta = [event.clientX - othis.state.viewport.mouse.last[0], event.clientY - othis.state.viewport.mouse.last[1]];
    deltaLength = SceneJS_math_lenVec2(delta);
    if (othis.state.viewport.mouse.leftDown) {
      othis.state.viewport.mouse.leftDragDistance += deltaLength;
    }
    if (othis.state.viewport.mouse.middleDown) {
      othis.state.viewport.mouse.middleDragDistance += deltaLength;
    }
    if (othis.state.viewport.mouse.leftDown && event.which === 1) {
      orbitAngles = [0.0, 0.0];
      SceneJS_math_mulVec2Scalar(delta, othis.constants.camera.orbitSpeedFactor / deltaLength, orbitAngles);
      orbitAngles = [Math.clamp(orbitAngles[0], -othis.constants.camera.maxOrbitSpeed, othis.constants.camera.maxOrbitSpeed), Math.clamp(orbitAngles[1], -othis.constants.camera.maxOrbitSpeed, othis.constants.camera.maxOrbitSpeed)];
      if ((isNaN(orbitAngles[0])) || (Math.abs(orbitAngles[0])) === Infinity) {
        orbitAngles[0] = 0.0;
      }
      if ((isNaN(orbitAngles[1])) || (Math.abs(orbitAngles[1])) === Infinity) {
        orbitAngles[1] = 0.0;
      }
      othis.orbitLookAtNode(othis.state.scene.findNode('main-lookAt'), orbitAngles, [0.0, 0.0, 1.0]);
    } else if (othis.state.viewport.mouse.middleDown && event.which === 2) {
      panVector = [0.0, 0.0];
      SceneJS_math_mulVec2Scalar([-delta[0], delta[1]], othis.constants.camera.panSpeedFactor / deltaLength, panVector);
      othis.lookAtNodePanRelative(othis.state.scene.findNode('main-lookAt'), panVector);
    }
    return othis.state.viewport.mouse.last = [event.clientX, event.clientY];
  };

  this.mouseWheel = function(event) {
	event.preventDefault();
    var delta, zoomDistance;
    if (!(othis.state.scene != null)) return;
    delta = event.originalEvent.wheelDelta != null ? event.originalEvent.wheelDelta / -120.0 : Math.clamp(event.originalEvent.detail, -1.0, 1.0);
    zoomDistance = delta * othis.state.camera.distanceLimits[1] * othis.constants.camera.zoomSpeedFactor;
    return othis.zoomLookAtNode(othis.state.scene.findNode('main-lookAt'), zoomDistance, othis.state.camera.distanceLimits);
  };

  this.keyDown = function(event) {
    switch (event.which) {
      case 72:
        return topmenuHelp();
    }
  };

  this.controlsPropertiesSelectObject = function(id) {
    var html, key, keyStack, objectProperties, properties, tableItem, tableItemObject, value, _i, _len;
    properties = othis.state.scene.data().properties;
    if (!(id != null)) {
      return ($('#controls-properties')).html("<p class='controls-message'>Select an object to see its properties.</p>");
    }
    if (!(properties != null)) {
      return ($('#controls-properties')).html("<p class='controls-message'>No properties could be found in the scene.</p>");
    }
    keyStack = id.split('/');
    objectProperties = properties;
    for (_i = 0, _len = keyStack.length; _i < _len; _i++) {
      key = keyStack[_i];
      objectProperties = objectProperties[key];
    }
    tableItemObject = function(keyStack, key, value) {
      var html, k, _j, _len2;
      html = "<a class='ifc-link' href='#";
      if ((value.link != null) && typeof value.link === 'string') {
        return html += value.link + ("'>" + value.link + "</a>");
      } else {
        for (_j = 0, _len2 = keyStack.length; _j < _len2; _j++) {
          k = keyStack[_j];
          html += k + "/";
        }
        return html += key + "'>...</a>";
      }
    };
    tableItem = function(key, value) {
      var arrayValue, html, i, _ref;
      html = "<li class='controls-table-item'>";
      html += "<label class='controls-table-label'>" + key + "</label>";
      html += "<div class='controls-table-value'>";
      if (typeof value === 'string' || typeof value === 'number' || typeof value === 'boolean') {} else if (Array.isArray(value)) {
        for (i = 0, _ref = value.length; 0 <= _ref ? i < _ref : i > _ref; 0 <= _ref ? i++ : i--) {
          arrayValue = value[i];
          if (i > 0) html += ",<br>";
          if (typeof arrayValue === 'string' || typeof arrayValue === 'number' || typeof arrayValue === 'boolean') {
            html += arrayValue;
          } else if (typeof value === 'object') {
            html += tableItemObject(keyStack, key, arrayValue);
          } else {
            html += arrayValue;
          }
        }
      } else if (typeof value === 'object') {
        html += tableItemObject(keyStack, key, value);
      } else {
        html += value;
      }
      html += "</div>";
      return html += "</li>";
    };
    html = "<ul class='controls-table'>";
    if (keyStack.length === 1) html += tableItem('Global Id', id);
    if (objectProperties != null) {
      for (key in objectProperties) {
        value = objectProperties[key];
        html += tableItem(key, value);
      }
    }
    html += "</ul>";
    if (!objectProperties) {
      html += "<p class='controls-message'>No additional properties could be found for the object with id '" + id + "'.</p>";
    }
    return ($('#controls-properties')).html(html);
  };

  this.controlsToggleTreeOpen = function(event) {
    var $parent, id;
    $parent = ($(event.target)).parent();
    id = $parent.attr('id');
    $parent.toggleClass('controls-tree-open');
    othis.controlsTreeSelectObject(id);
    return othis.controlsPropertiesSelectObject(id);
  };

  this.controlsToggleTreeVisibility = function(event) {
    var $parent, collectNodes, disableNode, disableTagJson, disabledNodes, ids, node, parentId, parentNode, tag, tagNode, _i, _j, _k, _len, _len2, _len3, _ref, _ref2;
    $parent = ($(event.target)).closest('.controls-tree-rel');
    parentId = $parent.attr('id');
    ids = [parentId];
    if (event.target.checked) {
      disabledNodes = othis.state.scene.findNodes('^disable-.*?-' + (RegExp.escape(parentId)) + '$');
      for (_i = 0, _len = disabledNodes.length; _i < _len; _i++) {
        node = disabledNodes[_i];
        node.splice();
      }
      return;
    }
    ($parent.find('.controls-tree-rel')).each(function() {
      return ids.push(this.id);
    });
    _ref = othis.state.scene.data().ifcTypes;
    for (_j = 0, _len2 = _ref.length; _j < _len2; _j++) {
      tag = _ref[_j];
      tag = tag.toLowerCase();
      tagNode = othis.state.scene.findNode(tag);
      disableTagJson = {
        type: 'tag',
        tag: 'disable',
        id: 'disable-' + tag + '-' + parentId
      };
      if (tagNode != null) {
        collectNodes = [];
        tagNode.eachNode((function() {
          var _ref2;
          if ((this.get('type')) === 'name' && (_ref2 = this.get('id'), __indexOf.call(ids, _ref2) >= 0) && (this.parent().get('id')) !== disableTagJson.id) {
            collectNodes.push(this);
          }
          return false;
        }), {
          depthFirst: true
        });
        for (_k = 0, _len3 = collectNodes.length; _k < _len3; _k++) {
          node = collectNodes[_k];
          parentNode = node.parent();
          disableNode = (_ref2 = parentNode.node(disableTagJson.id)) != null ? _ref2 : (parentNode.add('node', disableTagJson)).node(disableTagJson.id);
          disableNode.add('node', node.disconnect());
        }
      }
    }
    return false;
  };

  this.controlsTreeSelectObject = function(id) {
    var $treeItem, node, oldHighlight, parentEl;
    ($('.controls-tree-selected')).removeClass('controls-tree-selected');
    ($('.controls-tree-selected-parent')).removeClass('controls-tree-selected-parent');
    oldHighlight = othis.state.scene.findNode(othis.constants.highlightMaterial.id);
    if (oldHighlight != null) oldHighlight.splice();
    if (id != null) {
      parentEl = document.getElementById(id);
      $treeItem = ($(parentEl)).children('.controls-tree-item');
      $treeItem.addClass('controls-tree-selected');
      ($('.controls-tree:has(.controls-tree-selected)')).addClass('controls-tree-selected-parent');
      othis.controlsPropertiesSelectObject(id);
      node = othis.state.scene.findNode(id);
      if (node != null) {
        node.insert('node', othis.constants.highlightMaterial);
      }
    }
  };

  this.controlsShowProperties = function(event) {
    if ((event != null) && event.target.nodeName === 'INPUT') return;
  };

  this.controlsNavigateLink = function(event) {
    othis.controlsPropertiesSelectObject((($(event.target)).attr('href')).slice(1));
    return false;
  };

  this.controlsToggleLayer = function(event) {
    var el, elements, tags;
    elements = ($('#controls-layers input:checked')).toArray();
    tags = (function() {
      var _i, _len, _results;
      _results = [];
      for (_i = 0, _len = elements.length; _i < _len; _i++) {
        el = elements[_i];
        _results.push(((($(el)).attr('id')).split(/^layer\-/))[1]);
      }
      return _results;
    })();
    return othis.state.scene.set('tagMask', '^(' + (tags.join('|')) + ')$');
  };

  this.registerDOMEvents = function() {
    $(othis.state.viewport.domElement).mousedown(othis.mouseDown);
    $(othis.state.viewport.domElement).mouseup(othis.mouseUp);
    $(othis.state.viewport.domElement).mousemove(othis.mouseMove);
    $(othis.state.viewport.domElement).bind('mousewheel', othis.mouseWheel);
    $(othis.state.viewport.domElement).bind('DOMMouseScroll', othis.mouseWheel);
    document.addEventListener('keydown', othis.keyDown, true);
  };

  this.registerControlEvents = function() {
    ($('#controls-relationships')).delegate('.controls-tree-item', 'click', othis.controlsToggleTreeOpen);
    ($('#controls-relationships')).delegate('.controls-tree-item', 'dblclick', othis.controlsShowProperties);
    ($('#controls-relationships')).delegate('input', 'change', othis.controlsToggleTreeVisibility);
    ($('#controls-properties')).delegate('.ifc-link', 'click', othis.controlsNavigateLink);
    ($('#controls-layers')).delegate('input', 'change', othis.controlsToggleLayer);
    return ($(othis.state.viewport.domElement)).dblclick(othis.controlsShowProperties);
  };

  this.controlsInit = function() {
    var ifcType, layersHtml, sceneData;
    sceneData = othis.state.scene.data();
    layersHtml = (function() {
      var _i, _len, _ref, _results;
      _ref = sceneData.ifcTypes;
      _results = [];
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        ifcType = _ref[_i];
        _results.push("<div><input id='layer-" + ifcType.toLowerCase() + "' type='checkbox' checked='checked'> " + ifcType + "</div>");
      }
      return _results;
    })();
    ($('#controls-layers')).html(layersHtml.join(''));
    othis.controlsPropertiesSelectObject();
    return ($('#main-view-controls')).removeAttr('style');
  };

  this.ifcTreeInit = function() {
    var ifcContains, ifcDecomposedBy, ifcDefinedBy, ifcObjectDescription, ifcProject, ifcRelationships, project, sceneData, treeHtml, _i, _len, _ref;
    sceneData = othis.state.scene.data();
    ifcObjectDescription = function(obj, indent) {
      return "<li class='controls-tree-rel' id='" + obj.id + "'><div class='controls-tree-item'><span class='indent-" + String(indent) + "'/>" + "<input type='checkbox' checked='checked'> " + obj.name + "<span class='controls-tree-postfix'>(" + obj.type + ")</span></div>" + (ifcDefinedBy(obj.decomposedBy, indent)) + (ifcDefinedBy(obj.definedBy, indent)) + (ifcContains(obj.contains, indent)) + "</li>";
    };
    ifcProject = function(obj) {
      return "<li class='controls-tree-root' id='" + obj.id + "'><div class='controls-tree-item'>" + obj.name + "<span class='controls-tree-postfix'>(" + obj.type + ")</span></div>" + (ifcDefinedBy(obj.decomposedBy, 0)) + (ifcDefinedBy(obj.definedBy, 0)) + (ifcContains(obj.contains, 0)) + "</li>";
    };
    ifcRelationships = function(type, rel, indent) {
      var html, obj, _i, _len;
      if ((rel != null) && rel.length > 0) {
        indent = Math.min(indent + 1, 6);
        html = "<ul class='controls-tree'>";
        html += "<div class='controls-tree-heading'><hr><h4>" + type + "</h4></div>";
        for (_i = 0, _len = rel.length; _i < _len; _i++) {
          obj = rel[_i];
          html += ifcObjectDescription(obj, indent);
        }
        return html += "</ul>";
      } else {
        return "";
      }
    };
    ifcDecomposedBy = function(rel, indent) {
      return ifcRelationships('Decomposed By', rel, indent);
    };
    ifcDefinedBy = function(rel, indent) {
      return ifcRelationships('Defined By', rel, indent);
    };
    ifcContains = function(rel, indent) {
      return ifcRelationships('Contains', rel, indent);
    };
    treeHtml = "<ul class='controls-tree'>";
    _ref = sceneData.relationships;
    for (_i = 0, _len = _ref.length; _i < _len; _i++) {
      project = _ref[_i];
      treeHtml += ifcProject(project);
    }
    treeHtml += "</ul>";
    return ($('#controls-relationships')).html(treeHtml);
  };

  this.parseQueryArguments = function() {
    var arg, argKeyVal, args, argsParts, part, _i, _len;
    args = {};
    argsParts = (document.location.search.substring(1)).split('&');
    for (_i = 0, _len = argsParts.length; _i < _len; _i++) {
      part = argsParts[_i];
      arg = unescape(part);
      if ((arg.indexOf('=')) === -1) {
        args[arg.trim()] = true;
      } else {
        argKeyVal = arg.split('=');
        args[argKeyVal[0].trim()] = argKeyVal[1].trim();
      }
    }
    if ((args.model != null) && (args.model.substr(-1)) === '/') {
      args.model = args.model.substr(0, args.model.length - 1);
    }
    return args;
  };

  this.initLoadModel = function(modelUrl) {
    ($.get(modelUrl, void 0, void 0, 'json')).done(function(data, textStatus, jqXHR) {
      try {
        return loadScene(data);
      } catch (error) {
        return typeof console !== "undefined" && console !== null ? typeof console.log === "function" ? console.log(error) : void 0 : void 0;
      }
    }).fail(function(jqXHR, textStatus, errorThrown) {
      console.log(textStatus);
    });
  };

  this.destroy = function() {
    if (othis.state.scene != null) {
	  othis.state.scene.scene().destroy();
	  othis.state.scene = null;
	}
  };
  
  othis.sceneInit = function() {
    var lookAtNode, sceneDiameter, tag, tags;
    othis.modifySubAttr(othis.state.scene.findNode('main-camera'), 'optics', 'aspect', othis.state.canvas.width / othis.state.canvas.height);
    sceneDiameter = SceneJS_math_lenVec3(othis.state.scene.data().bounds);
    othis.state.camera.distanceLimits = [sceneDiameter * 0.1, sceneDiameter * 2.0];
    tags = (function() {
      var _i, _len, _ref, _results;
      _ref = othis.state.scene.data().ifcTypes;
      _results = [];
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        tag = _ref[_i];
        _results.push(tag.toLowerCase());
      }
      return _results;
    })();
//	    state.scene.set('tagMask', '^(' + (tags.join('|')) + ')$');
    lookAtNode = othis.state.scene.findNode('main-lookAt');
    othis.state.lookAt.defaultParameters.eye = lookAtNode.get('eye');
    othis.state.lookAt.defaultParameters.look = lookAtNode.get('look');
    return othis.state.lookAt.defaultParameters.up = lookAtNode.get('up');
  };
  
  this.loadScene = function(scene) {
    if (othis.state.scene != null) {
      othis.state.scene.scene().destroy();
      othis.state.scene = null;
    }
    try {
      SceneJS.createScene(scene);
      othis.state.scene = SceneJS.scene(scene.id);
      if (othis.state.scene != null) {
        othis.state.scene.start({
          idleFunc: SceneJS.FX.idle
        });
      othis.sceneInit();
      othis.controlsInit();
      othis.ifcTreeInit();
      othis.registerDOMEvents();
      othis.registerControlEvents();
      othis.state.application.initialized = true;

      return othis.state.scene;
      }
    } catch (error) {
      console.log(error);
      console.log('...Errors occured');
    }
    return null;
  };
  
  this.loadGeometry = function(data) {
		othis.state.scene.stop();
		data.geometry.forEach(function(node){
			if (node.type == "geometry") {
				console.log("adding", node);
				othis.state.scene.findNode("library").add("node", node);
			}
		});
		var sunLight = othis.state.scene.findNode("sun-light");
		data.geometry.forEach(function(node){
			if (node.type == "geometry") {
				sunLight.add("node", {
					type: "geometry",
					coreId: node.id
				});
			}
		});
		othis.state.scene.start();
  };
  
  othis.state = {
    scene: (function() {
      try {
        return SceneJS.scene('Scene');
      } catch (error) {
        return null;
      }
    })(),
    canvas: canvasDiv.get(),
    settings: {
      performance: 'quality',
      mode: 'basic'
    },
    viewport: {
      domElement: viewportDiv.get(),
      selectedIfcObject: null,
      mouse: {
        last: [0, 0],
        leftDown: false,
        middleDown: false,
        leftDragDistance: 0,
        middleDragDistance: 0,
        pickRecord: null
      }
    },
    queryArgs: {},
    camera: {
      distanceLimits: [0.0, 0.0]
    },
    lookAt: {
      defaultParameters: {
        look: {
          x: 0.0,
          y: 0.0,
          z: 0.0
        },
        eye: {
          x: 10.0,
          y: 10.0,
          z: 10.0
        },
        up: {
          x: 0.0,
          y: 0.0,
          z: 1.0
        }
      }
    },
    snapshots: {
      lookAts: []
    },
    application: {
      initialized: false
    }
  };
}