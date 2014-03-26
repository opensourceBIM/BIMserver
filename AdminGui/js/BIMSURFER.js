var BIMSURFER = {
	CLASS: "BIMSURFER",
	VERSION_NUMBER: "2.0 Dev"
};


/**
 * Constructor: BIMSURFER.Class
 * Base class used to construct all other classes. Includes support for multiple inheritance.
 */
BIMSURFER.Class = function(baseClass, subClass){
	var constructor = null;
	var classObject = subClass || baseClass;

	if(typeof classObject.__construct == 'function') {
		constructor = classObject.__construct;
	} else if(typeof baseClass.prototype.__construct == 'function') {
		constructor = function() {
			baseClass.prototype.__construct.apply(this, arguments);
		}
	} else {
		constructor = function() { };
	}

	var Class = constructor;

	if(typeof subClass == 'undefined') {
		Class.prototype = classObject
	} else {
		var newClass = function() {};
		newClass.prototype = jQuery.extend({}, baseClass.prototype);
		jQuery.extend(newClass.prototype, subClass);
		Class.prototype = new newClass;
	}

	return Class;
};


(function() {
	var js_files = [
		'SceneJS.js',
	  	'BIMSURFER/Constants.js',
		'BIMSURFER/ProgressLoader.js',
		'BIMSURFER/Types/Light.js',
		'BIMSURFER/Types/Light/Ambient.js',
		'BIMSURFER/Types/Light/Sun.js',
		'BIMSURFER/Control.js',
		'BIMSURFER/Control/ClickSelect.js',
		'BIMSURFER/Control/LayerList.js',
		'BIMSURFER/Control/ProgressBar.js',
		'BIMSURFER/Control/PickFlyOrbit.js',
		'BIMSURFER/Control/ObjectTreeView.js',
	 	'BIMSURFER/Events.js',
	 	'BIMSURFER/Project.js',
	 	'BIMSURFER/ProjectRevision.js',
	 	'BIMSURFER/StringView.js',
	 	'BIMSURFER/AsyncStream.js',
	 	'BIMSURFER/DataInputStream.js',
	  	'BIMSURFER/Server.js',
		'BIMSURFER/Viewer.js',
	  	'BIMSURFER/Util.js'
	];

	var scriptPath = jQuery('script').last()[0].src;
	scriptFolder = scriptPath.substr(0, scriptPath.lastIndexOf('/')+1)

	var prefix = '<script type="text/javascript" src="' + scriptFolder;
	var suffix = '"></script>' + "\r\n";

	var scripts = prefix + js_files.join(suffix + prefix) + suffix;

	var css_files = [
		'BIMSURFER/Control/LayerList.css',
		'BIMSURFER/Control/ProgressBar.css',
		'BIMSURFER/Control/ObjectTreeView.css'
	];

	prefix = '<link rel="stylesheet" href="' + scriptFolder;
	suffix = '" type="text/css" />' + "\r\n";

	var stylesheets = prefix + css_files.join(suffix + prefix) + suffix;

	document.write(stylesheets);
	document.write(scripts);
})();
