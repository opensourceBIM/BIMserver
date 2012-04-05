/*
 * BIMsurfer Embedded API
 * Copyright 2011, Bimserver.org.
 */
"use strict";

var BimSurferEmbedded = (function() {

  var log = (console != null && console.log != null)? function() { return console.log.apply(console, arguments); } : function() {};

  // Public API

  /* Construct the BimSurferEmbedded object inside an (optional) container div
   */
  function BimSurferEmbedded(src, container) {
    var errorHtml = "<div style='width:800px;height:600px;background:#eee;color:#f88;'>Could not load BIMsurfer. Please see the console for error messages.</div>";

    // Check pre-conditions
    if (typeof container !== 'string' && (typeof container !== 'object' || container.nodeName !== 'DIV')) {
      log("BIMsurfer API: (ERROR) Invalid containerId supplied, expected type 'string' or dom element of type 'DIV'.");
      return false;
    }
    var containerEl = (typeof container === 'string'? document.getElementById(container) : container);
    if (containerEl == null) { // check for undefined and null
      log("BIMsurfer API: (WARNING) Could not find container element with id, '" + container + "'. Creating a div element here...");

      // TODO: Busy here



      containerEl.innerHTML = errorHtml;
      return false;
    }
    if (containerEl.nodeName !== 'DIV') {
      log("BIMsurfer API: (WARNING) Expected container element of type 'DIV'.");
    }

    // Clear the container contents
    containerEl.innerHTML = "";

    // Create an iframe for the BIMsurfer application to run in
    var frameEl = document.createElement('iframe');
    if (frameEl == null) { // check for undefined and null
      containerEl.innerHTML = errorHtml;
      return false;
    }
    frameEl.setAttribute('src', src);
    frameEl.setAttribute('width', 800);
    frameEl.setAttribute('height', 600);
    
    containerEl.appendChild(frameEl);
  }
  BimSurferEmbedded.prototype.pick = function(callback) {};
  return BimSurferEmbedded;
})();

