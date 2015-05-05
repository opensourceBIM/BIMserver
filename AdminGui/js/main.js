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

function removeA(arr) {
    var what, a = arguments, L = a.length, ax;
    while (L > 1 && arr.length) {
        what = a[--L];
        while ((ax= arr.indexOf(what)) !== -1) {
            arr.splice(ax, 1);
        }
    }
    return arr;
}

function createUserLink(main, uoid) {
	if (uoid == -1) {
		return "";			
	} else {
		var link = $("<a>Loading...</a>");
		link.attr("uoid", uoid);
		link.click(function(){
			main.showUser(uoid, null, true);
		});
		loadUser(link);
		return link;
	}
};

function getBaseURL () {
	var loc = document.location;
	if (loc.endsWith(".html")) {
		loc = loc.substring(0, loc.lastIndexOf("/"));
	}
	return loc;
}

function loadGeneric(targetElement, oidField, displayField, interfaceName, methodName, objectField, paramFunction) {
	var oid = targetElement.attr(oidField);
	if (Global.objectcache[oid] != null) {
		if (Global.objectcache[oid] instanceof Array) {
			Global.objectcache[oid].push(targetElement);
		} else {
			targetElement.html(Global.objectcache[oid][displayField]);
			targetElement.data(objectField, Global.objectcache[oid]);
		}
	} else {
		Global.objectcache[oid] = [targetElement];
		Global.bimServerApi.call(interfaceName, methodName, paramFunction(oid), function(data){
			if (Global.objectcache[oid] instanceof Array) {
				for(var i in Global.objectcache[oid]) {
					var target = Global.objectcache[oid][i];
					target.html(data[displayField]);
					target.data(objectField, data);
				}
				Global.objectcache[oid] = data;
			} else {
				targetElement.html(data[displayField]);
				targetElement.data(objectField, data);
			}
		});
	}
}

Math.clamp = function(s, min, max) {
    return Math.min(Math.max(s, min), max);
  };

var  __indexOf = Array.prototype.indexOf || function(item) { for (var i = 0, l = this.length; i < l; i++) { if (i in this && this[i] === item) return i; } return -1; };

RegExp.escape = function(str) {
  return str.replace(/[[\]\\$().{},?*+|^-]/g, "\\$&");
};

function pushHistoryAppend(obj, title) {
	pushing = true;
	var current = History.getState();
	for (var k in current.data) {
		if (obj[k] == null) {
			obj[k] = current.data[k];
		}
	}
	for (var k in obj) {
		if (obj[k] == false) {
			delete obj[k];
		}
	}
	var str = "?";
	for (var i in obj) {
		str += i + "=" + obj[i] + "&";
	}
	if (str.endsWith("&")) {
		str = str.substring(0, str.length - 1);
	}
	if (!current.cleanUrl.endsWith(str)) {
		History.pushState(obj, Settings.getTitle() + (title == null ? "" : " - " + title), str);
	}
	pushing = false;
}

function pushHistory(obj, title, initial) {
	pushing = true;
	var current = History.getState();
	var str = "?";
	for (var i in obj) {
		str += i + "=" + obj[i] + "&";
	}
	if (str.endsWith("&")) {
		str = str.substring(0, str.length - 1);
	}
	if (title != null) {
		if (!title.startsWith(Settings.getTitle())) {
			title = Settings.getTitle() + " - " + title;
		}
	} else {
		title = current.title;
	}
	if (initial) {
		History.replaceState(obj, title, str);
	} else {
		if (!current.cleanUrl.endsWith(str)) {
			History.pushState(obj, title, str);
		} else {
			document.title = title;
		}
	}
	pushing = false;
}

function pushInitialState() {
	var loc = new String(document.location);
	if (loc.indexOf("?") != -1) {
		var obj = {};
		loc = loc.substring(loc.indexOf("?") + 1);
		var splitted = loc.split("&");
		for (var i in splitted) {
			var s = splitted[i];
			obj[s.substring(0, s.indexOf("="))] = s.substring(s.indexOf("=") + 1);
		}
		pushHistory(obj, $("title").text(), true);
		return obj;
	} else {
		return {};
	}
}

function loadService(targetElement) {
	loadGeneric(targetElement, "soid", "name", "ServiceInterface", "getService", "service", function(oid){return{soid: oid};});
}

function loadUser(targetElement) {
	loadGeneric(targetElement, "uoid", "name", "ServiceInterface", "getUserByUoid", "user", function(oid){return{uoid: oid};});
}

function loadExtendedDataSchema(targetElement) {
	loadGeneric(targetElement, "soid", "name", "Bimsie1ServiceInterface", "getExtendedDataSchemaById", "extendeddataschema", function(oid){return{oid: oid};});
}

function loadProject(targetElement) {
	loadGeneric(targetElement, "poid", "name", "Bimsie1ServiceInterface", "getProjectByPoid", "project", function(oid){return{poid: oid};});
}

function newDropdown(title) {
	var div = $("<div class=\"btn-group\">");
	var a = $("<a class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">");
	a.append(title);
	var span = $("<span class=\"caret\"></span>");
	a.append(span);
	div.append(a);
	var ul = $("<ul class=\"dropdown-menu\">");
	div.append(ul);
	return div;
}

function newSplitDropdown(title, clickCallback) {
	var div = $("<div class=\"btn-group\">");
	var button1 = $("<button class=\"btn btn-default btnMain\">" + title + "</button>");
	button1.click(clickCallback);
	div.append(button1);
	var button2 = $("<button class=\"btn btn-default dropdown-toggle\" data-toggle=\"dropdown\">");
	button2.append("<span class=\"caret\"></span>");
	div.append(button2);
	var ul = $("<ul class=\"dropdown-menu\">");
	div.append(ul);
	return div;
}

function newButton(title, click) {
	var button = $("<button class=\"btn btn-default\">" + title + "</button>");
	button.click(click);
	return button;
}

function newLiLink(title, callback) {
	var link = $("<a>");
	link.html(title);
	link.click(callback);
	var li = $("<li>");
	li.append(link);
	return li;
}

function newButtonTd(title, click) {
	var td = $("<td>");
	td.append(newButton(title, click));
	return td;
}

function newSplitDropDownTd(title, clickCallback) {
	var td = $("<td>");
	td.append(newSplitDropdown(title, clickCallback));
	return td;
}

function newDropdownTd(title) {
	var td = $("<td>");
	td.append(newDropdown(title));
	return td;
}

function stripHttps(url) {
	if (url.startsWith("http://")) {
		return url.substring(7);
	} else if (url.startsWith("https://")) {
		return url.substring(8);
	}
	return url;
}

// http://stackoverflow.com/questions/4498866/actual-numbers-to-the-human-readable-values/4506030#4506030 //
var SizePrefixes = ' KMGTPEZYXWVU';

function getHumanSize(bytes) {
	var s = ['bytes', 'kB', 'MB', 'GB', 'TB', 'PB'];
    var e = Math.floor(Math.log(bytes) / Math.log(1024));
    var result = (bytes / Math.pow(1024, e)).toFixed(2);
    if (result.endsWith(".00")) {
    	result = result.substring(0, result.length - 3);
    }
    return result + " " + s[e];
}
//http://stackoverflow.com/questions/4498866/actual-numbers-to-the-human-readable-values/4506030#4506030 //

function getParameterByName(name)
{
  name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
  var regexS = "[\\?&]" + name + "=([^&#]*)";
  var regex = new RegExp(regexS);
  var results = regex.exec(window.location.search);
  if(results == null)
    return null;
  else
    return decodeURIComponent(results[1].replace(/\+/g, " "));
}

function formatLogState(state) {
	if (state == "STARTED") {
		return "Running";
	} else if (state == "AS_ERROR") {
		return "Error";
	} else if (state == "UNKNOWN") {
		return "Unknown";
	} else if (state == "FINISHED") {
		return "Done";
	}
}

function load(element, url, constructor) {
	var promise = new Promise();
	element.load(url, function(){
		var res = constructor.call(element);
		if (res instanceof Promise) {
			promise.chain(res);
		} else {
			promise.fire();
		}
	});
	return promise;
}

function Tab(tabs, label) {
	var o = this;

	this.setActive = function(){
		tabs.tabsDiv.find("label").removeClass("active");
		label.addClass("active");
		label.find("input").attr("selected", "selected");
		console.log(label);
		tabs.contentDiv.load(o.page, o.callback);
	};
	
	label.find("input").change(function(){
		o.setActive();
	});
}

function Tabs(tabsDiv, contentDiv) {
	var o = this;
	o.tabsDiv = tabsDiv;
	o.contentDiv = contentDiv;
	
	this.addTab = function(title, page, callback){
		var label = $("<label class=\"btn btn-default\"> <input type=\"radio\" name=\"options\" id=\"" + title + "\" autocomplete=\"off\" />" + title + "</label>");
		var tab = new Tab(o, label);
		tab.page = page;
		tab.callback = callback;
		tabsDiv.append(label);
		return tab;
	};
}