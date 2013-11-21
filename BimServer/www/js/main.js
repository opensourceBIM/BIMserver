"use strict";
var pushing = false;

$.ajaxSetup({
	cache: false
})

function stripLastSlash(str) {
	if(str.substr(-1) == '/') {
        return str.substr(0, str.length - 1);
    }
    return str;
}

function getBaseURL () {
	var loc = document.location;
	if (loc.endsWith(".html")) {
		loc = loc.substring(0, loc.lastIndexOf("/"));
	}
	return loc;
}

Math.clamp = function(s, min, max) {
    return Math.min(Math.max(s, min), max);
  };

var  __indexOf = Array.prototype.indexOf || function(item) { for (var i = 0, l = this.length; i < l; i++) { if (i in this && this[i] === item) return i; } return -1; };

RegExp.escape = function(str) {
  return str.replace(/[[\]\\$().{},?*+|^-]/g, "\\$&");
};

function stripHttp(url) {
	if (url.startsWith("http://")) {
		return url.substring(7);
	}
	return url;
}

function getParameterByName(name)
{
  name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
  var regexS = "[\\?&]" + name + "=([^&#]*)";
  var regex = new RegExp(regexS);
  var results = regex.exec(window.location.search);
  if(results == null)
    return "";
  else
    return decodeURIComponent(results[1].replace(/\+/g, " "));
}