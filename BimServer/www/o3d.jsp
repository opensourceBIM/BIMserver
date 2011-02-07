<script type="text/javascript" src="js/o3d-webgl/base.js"></script>
<script type="text/javascript" src="js/o3djs/base.js"></script>
<script type="text/javascript" id="o3dscript"> 
o3djs.base.o3d = o3d;
o3djs.require('o3djs.webgl');
o3djs.require('o3djs.dump');
o3djs.require('o3djs.util');
o3djs.require('o3djs.math');
o3djs.require('o3djs.quaternions');
o3djs.require('o3djs.rendergraph');
o3djs.require('o3djs.pack');
o3djs.require('o3djs.arcball');
o3djs.require('o3djs.scene');

var g_root;
var g_o3d;
var g_math;
var g_quaternions;
var g_client;
var g_aball;
var g_thisRot;
var g_lastRot;
var g_pack = null;
var g_mainPack;
var g_viewInfo;
var g_lightPosParam;
var g_o3dWidth = -1;
var g_o3dHeight = -1;
var g_o3dElement;
var g_finished = false;
var g_idOfLoader;
var _callback;

var g_camera = {
  farPlane: 5000,
  nearPlane:0.1
};

var g_dragging = false;

function startDragging(e) {
  g_lastRot = g_thisRot;
 
  g_aball.click([e.x, e.y]);
 
  g_dragging = true;
}

function drag(e) {
  if (g_dragging) {
    var rotationQuat = g_aball.drag([e.x, e.y]);
    var rot_mat = g_quaternions.quaternionToRotation(rotationQuat);
    g_thisRot = g_math.matrix4.mul(g_lastRot, rot_mat);
 
    var m = g_root.localMatrix;
    g_math.matrix4.setUpper3x3(m, g_thisRot);
    g_root.localMatrix = m;
  }
}

function stopDragging(e) {
  g_dragging = false;
}

function updateCamera() {
  var up = [0, 1, 0];
  g_viewInfo.drawContext.view = g_math.matrix4.lookAt(g_camera.eye,
                                                      g_camera.target,
                                                      up);
  g_lightPosParam.value = g_camera.eye;
}

function updateProjection() {
  g_viewInfo.drawContext.projection = g_math.matrix4.perspective(
    g_math.degToRad(45), g_o3dWidth / g_o3dHeight, g_camera.nearPlane,
    g_camera.farPlane);
}

function scrollMe(e) {
  if (e.deltaY) {
    var t = 1;
    if (e.deltaY > 0)
      t = 11 / 12;
    else
      t = 13 / 12;
    g_camera.eye = g_math.lerpVector(g_camera.target, g_camera.eye, t);
 
    updateCamera();
  }
}

function setClientSize() {
  var newWidth  = parseInt(g_client.width);
  var newHeight = parseInt(g_client.height);
 
  if (newWidth != g_o3dWidth || newHeight != g_o3dHeight) {
    g_o3dWidth = newWidth;
    g_o3dHeight = newHeight;
 
    updateProjection();
 
    g_aball.setAreaSize(g_o3dWidth, g_o3dHeight);
  }
}
 
function onRender() {
  setClientSize();
}

function createClient(element, callback) {
	 g_o3dElement = o3djs.webgl.createClient(element, "", "");
	 try {
       o3djs.base.init(g_o3dElement);
	   g_o3d = g_o3dElement.o3d;
	   g_math = o3djs.math;
	   g_quaternions = o3djs.quaternions;
	   g_client = g_o3dElement.client;
	 } catch (e) {
	 }
	 if (!o3djs.base.ready()) {
	   $("#" + g_idOfLoader).html("O3D Plugin Required, please follow installation <a target=\"_blank\" href=\"http://code.google.com/apis/o3d/docs/gettingstarted.html#install\">instructions</a>");
	     return;
	  }
	  g_mainPack = g_client.createPack();
	 
	  g_viewInfo = o3djs.rendergraph.createBasicView(
	      g_mainPack,
	      g_client.root,
	      g_client.renderGraphRoot);
	  g_viewInfo.clearBuffer.clearColor = [1, 1, 1, 1];
	  g_lastRot = g_math.matrix4.identity();
	  g_thisRot = g_math.matrix4.identity();
	 
	  var root = g_client.root;
	 
	  g_aball = o3djs.arcball.create(1, 1);
	  setClientSize();
	 
	  var paramObject = g_mainPack.createObject('ParamObject');
	  g_lightPosParam = paramObject.createParam('lightWorldPos', 'ParamFloat3');
	  g_camera.target = [0, 0, 0];
	  g_camera.eye = [0, 0, 0];
	  updateCamera();
	 
	  o3djs.event.addEventListener(g_o3dElement, 'mousedown', startDragging);
	  o3djs.event.addEventListener(g_o3dElement, 'mousemove', drag);
	  o3djs.event.addEventListener(g_o3dElement, 'mouseup', stopDragging);
	  o3djs.event.addEventListener(g_o3dElement, 'wheel', scrollMe);
	 
	  g_client.setRenderCallback(onRender);
	  callback();
}
 
function uninit() {
  if (g_client) {
    g_client.cleanup();
  }
}

function loadFile(path, idOfLoader) {
  g_idOfLoader = idOfLoader;	
  context = g_viewInfo.drawContext;
  function callback(pack, parent, exception) {
    if (exception) {
      alert("Could not load: " + path + "\n" + exception);
      $("#" + g_idOfLoader).hide();
    } else {
      $("#" + g_idOfLoader).hide();
      // Generate draw elements and setup material draw lists.
      o3djs.pack.preparePack(pack, g_viewInfo);
      var bbox = o3djs.util.getBoundingBoxOfTree(g_client.root);
      g_camera.target = g_math.lerpVector(bbox.minExtent, bbox.maxExtent, 0.5);
      var diag = g_math.length(g_math.subVector(bbox.maxExtent,
                                                bbox.minExtent));
      g_camera.eye = g_math.addVector(g_camera.target, [0, 0, 1.5 * diag]);
      g_camera.nearPlane = diag / 1000;
      g_camera.farPlane = diag * 10;
//      g_camera.farPlane = diag * 10000; Somehow large models (by diameter) need this, so diag seems to not always be right
      setClientSize();
      updateCamera();
      updateProjection();
 
      // Manually connect all the materials' lightWorldPos params to the context
      var materials = pack.getObjectsByClassName('o3d.Material');
      for (var m = 0; m < materials.length; ++m) {
        var material = materials[m];
        var param = material.getParam('lightWorldPos');
        if (param) {
          param.bind(g_lightPosParam);
        }
      }
 
      g_finished = true;  // for selenium

   // Comment out the next line to dump lots of info.
      if (true) {
        o3djs.dump.dump('---dumping context---\n');
        o3djs.dump.dumpParamObject(context);

        o3djs.dump.dump('---dumping root---\n');
        o3djs.dump.dumpTransformTree(g_client.root);

        o3djs.dump.dump('---dumping render root---\n');
        o3djs.dump.dumpRenderNodeTree(g_client.renderGraphRoot);

        o3djs.dump.dump('---dump g_pack shapes---\n');
        var shapes = pack.getObjectsByClassName('o3d.Shape');
        for (var t = 0; t < shapes.length; t++) {
          o3djs.dump.dumpShape(shapes[t]);
        }

        o3djs.dump.dump('---dump g_pack materials---\n');
        var materials = pack.getObjectsByClassName('o3d.Material');
        for (var t = 0; t < materials.length; t++) {
          o3djs.dump.dump (
              '  ' + t + ' : ' + materials[t].className +
              ' : "' + materials[t].name + '"\n');
          o3djs.dump.dumpParams(materials[t], '    ');
        }

        o3djs.dump.dump('---dump g_pack textures---\n');
        var textures = pack.getObjectsByClassName('o3d.Texture');
        for (var t = 0; t < textures.length; t++) {
          o3djs.dump.dumpTexture(textures[t]);
        }

        o3djs.dump.dump('---dump g_pack effects---\n');
        var effects = pack.getObjectsByClassName('o3d.Effect');
        for (var t = 0; t < effects.length; t++) {
          o3djs.dump.dump ('  ' + t + ' : ' + effects[t].className +
                  ' : "' + effects[t].name + '"\n');
          o3djs.dump.dumpParams(effects[t], '    ');
        }
      }
    }
  }

  g_pack = g_client.createPack();

  // Create a new transform for the loaded file
  g_root = g_pack.createObject('Transform');
  g_root.parent = g_client.root;
  if (path != null) {
    try {
      o3djs.scene.loadScene(g_client, g_pack, g_root, path, callback);
    } catch (e) {
    }
  }
}
</script>