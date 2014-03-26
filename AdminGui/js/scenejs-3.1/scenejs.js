/*
 * SceneJS WebGL Scene Graph Library for JavaScript
 * http://scenejs.org/
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://scenejs.org/license
 * Copyright 2010, Lindsay Kay
 *
 *
 */// Only define RequireJS if not already present
if (undefined === require) {/*
 RequireJS 2.1.6 Copyright (c) 2010-2012, The Dojo Foundation All Rights Reserved.
 Available via the MIT or new BSD license.
 see: http://github.com/jrburke/requirejs for details
 */
var requirejs,require,define;
(function(ba){function J(b){return"[object Function]"===N.call(b)}function K(b){return"[object Array]"===N.call(b)}function z(b,c){if(b){var d;for(d=0;d<b.length&&(!b[d]||!c(b[d],d,b));d+=1);}}function O(b,c){if(b){var d;for(d=b.length-1;-1<d&&(!b[d]||!c(b[d],d,b));d-=1);}}function t(b,c){return ha.call(b,c)}function m(b,c){return t(b,c)&&b[c]}function H(b,c){for(var d in b)if(t(b,d)&&c(b[d],d))break}function S(b,c,d,m){c&&H(c,function(c,l){if(d||!t(b,l))m&&"string"!==typeof c?(b[l]||(b[l]={}),S(b[l],
    c,d,m)):b[l]=c});return b}function v(b,c){return function(){return c.apply(b,arguments)}}function ca(b){throw b;}function da(b){if(!b)return b;var c=ba;z(b.split("."),function(b){c=c[b]});return c}function B(b,c,d,m){c=Error(c+"\nhttp://requirejs.org/docs/errors.html#"+b);c.requireType=b;c.requireModules=m;d&&(c.originalError=d);return c}function ia(b){function c(a,f,C){var e,n,b,c,d,T,k,g=f&&f.split("/");e=g;var l=j.map,h=l&&l["*"];if(a&&"."===a.charAt(0))if(f){e=m(j.pkgs,f)?g=[f]:g.slice(0,g.length-
    1);f=a=e.concat(a.split("/"));for(e=0;f[e];e+=1)if(n=f[e],"."===n)f.splice(e,1),e-=1;else if(".."===n)if(1===e&&(".."===f[2]||".."===f[0]))break;else 0<e&&(f.splice(e-1,2),e-=2);e=m(j.pkgs,f=a[0]);a=a.join("/");e&&a===f+"/"+e.main&&(a=f)}else 0===a.indexOf("./")&&(a=a.substring(2));if(C&&l&&(g||h)){f=a.split("/");for(e=f.length;0<e;e-=1){b=f.slice(0,e).join("/");if(g)for(n=g.length;0<n;n-=1)if(C=m(l,g.slice(0,n).join("/")))if(C=m(C,b)){c=C;d=e;break}if(c)break;!T&&(h&&m(h,b))&&(T=m(h,b),k=e)}!c&&
    T&&(c=T,d=k);c&&(f.splice(0,d,c),a=f.join("/"))}return a}function d(a){A&&z(document.getElementsByTagName("script"),function(f){if(f.getAttribute("data-requiremodule")===a&&f.getAttribute("data-requirecontext")===k.contextName)return f.parentNode.removeChild(f),!0})}function p(a){var f=m(j.paths,a);if(f&&K(f)&&1<f.length)return d(a),f.shift(),k.require.undef(a),k.require([a]),!0}function g(a){var f,b=a?a.indexOf("!"):-1;-1<b&&(f=a.substring(0,b),a=a.substring(b+1,a.length));return[f,a]}function l(a,
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          f,b,e){var n,D,i=null,d=f?f.name:null,l=a,h=!0,j="";a||(h=!1,a="_@r"+(N+=1));a=g(a);i=a[0];a=a[1];i&&(i=c(i,d,e),D=m(r,i));a&&(i?j=D&&D.normalize?D.normalize(a,function(a){return c(a,d,e)}):c(a,d,e):(j=c(a,d,e),a=g(j),i=a[0],j=a[1],b=!0,n=k.nameToUrl(j)));b=i&&!D&&!b?"_unnormalized"+(O+=1):"";return{prefix:i,name:j,parentMap:f,unnormalized:!!b,url:n,originalName:l,isDefine:h,id:(i?i+"!"+j:j)+b}}function s(a){var f=a.id,b=m(q,f);b||(b=q[f]=new k.Module(a));return b}function u(a,f,b){var e=a.id,n=m(q,
    e);if(t(r,e)&&(!n||n.defineEmitComplete))"defined"===f&&b(r[e]);else if(n=s(a),n.error&&"error"===f)b(n.error);else n.on(f,b)}function w(a,f){var b=a.requireModules,e=!1;if(f)f(a);else if(z(b,function(f){if(f=m(q,f))f.error=a,f.events.error&&(e=!0,f.emit("error",a))}),!e)h.onError(a)}function x(){U.length&&(ja.apply(I,[I.length-1,0].concat(U)),U=[])}function y(a){delete q[a];delete W[a]}function G(a,f,b){var e=a.map.id;a.error?a.emit("error",a.error):(f[e]=!0,z(a.depMaps,function(e,c){var d=e.id,
    g=m(q,d);g&&(!a.depMatched[c]&&!b[d])&&(m(f,d)?(a.defineDep(c,r[d]),a.check()):G(g,f,b))}),b[e]=!0)}function E(){var a,f,b,e,n=(b=1E3*j.waitSeconds)&&k.startTime+b<(new Date).getTime(),c=[],i=[],g=!1,l=!0;if(!X){X=!0;H(W,function(b){a=b.map;f=a.id;if(b.enabled&&(a.isDefine||i.push(b),!b.error))if(!b.inited&&n)p(f)?g=e=!0:(c.push(f),d(f));else if(!b.inited&&(b.fetched&&a.isDefine)&&(g=!0,!a.prefix))return l=!1});if(n&&c.length)return b=B("timeout","Load timeout for modules: "+c,null,c),b.contextName=
    k.contextName,w(b);l&&z(i,function(a){G(a,{},{})});if((!n||e)&&g)if((A||ea)&&!Y)Y=setTimeout(function(){Y=0;E()},50);X=!1}}function F(a){t(r,a[0])||s(l(a[0],null,!0)).init(a[1],a[2])}function L(a){var a=a.currentTarget||a.srcElement,b=k.onScriptLoad;a.detachEvent&&!Z?a.detachEvent("onreadystatechange",b):a.removeEventListener("load",b,!1);b=k.onScriptError;(!a.detachEvent||Z)&&a.removeEventListener("error",b,!1);return{node:a,id:a&&a.getAttribute("data-requiremodule")}}function M(){var a;for(x();I.length;){a=
    I.shift();if(null===a[0])return w(B("mismatch","Mismatched anonymous define() module: "+a[a.length-1]));F(a)}}var X,$,k,P,Y,j={waitSeconds:7,baseUrl:"./",paths:{},pkgs:{},shim:{},config:{}},q={},W={},aa={},I=[],r={},V={},N=1,O=1;P={require:function(a){return a.require?a.require:a.require=k.makeRequire(a.map)},exports:function(a){a.usingExports=!0;if(a.map.isDefine)return a.exports?a.exports:a.exports=r[a.map.id]={}},module:function(a){return a.module?a.module:a.module={id:a.map.id,uri:a.map.url,config:function(){var b=
    m(j.pkgs,a.map.id);return(b?m(j.config,a.map.id+"/"+b.main):m(j.config,a.map.id))||{}},exports:r[a.map.id]}}};$=function(a){this.events=m(aa,a.id)||{};this.map=a;this.shim=m(j.shim,a.id);this.depExports=[];this.depMaps=[];this.depMatched=[];this.pluginMaps={};this.depCount=0};$.prototype={init:function(a,b,c,e){e=e||{};if(!this.inited){this.factory=b;if(c)this.on("error",c);else this.events.error&&(c=v(this,function(a){this.emit("error",a)}));this.depMaps=a&&a.slice(0);this.errback=c;this.inited=
    !0;this.ignore=e.ignore;e.enabled||this.enabled?this.enable():this.check()}},defineDep:function(a,b){this.depMatched[a]||(this.depMatched[a]=!0,this.depCount-=1,this.depExports[a]=b)},fetch:function(){if(!this.fetched){this.fetched=!0;k.startTime=(new Date).getTime();var a=this.map;if(this.shim)k.makeRequire(this.map,{enableBuildCallback:!0})(this.shim.deps||[],v(this,function(){return a.prefix?this.callPlugin():this.load()}));else return a.prefix?this.callPlugin():this.load()}},load:function(){var a=
    this.map.url;V[a]||(V[a]=!0,k.load(this.map.id,a))},check:function(){if(this.enabled&&!this.enabling){var a,b,c=this.map.id;b=this.depExports;var e=this.exports,n=this.factory;if(this.inited)if(this.error)this.emit("error",this.error);else{if(!this.defining){this.defining=!0;if(1>this.depCount&&!this.defined){if(J(n)){if(this.events.error&&this.map.isDefine||h.onError!==ca)try{e=k.execCb(c,n,b,e)}catch(d){a=d}else e=k.execCb(c,n,b,e);this.map.isDefine&&((b=this.module)&&void 0!==b.exports&&b.exports!==
    this.exports?e=b.exports:void 0===e&&this.usingExports&&(e=this.exports));if(a)return a.requireMap=this.map,a.requireModules=this.map.isDefine?[this.map.id]:null,a.requireType=this.map.isDefine?"define":"require",w(this.error=a)}else e=n;this.exports=e;if(this.map.isDefine&&!this.ignore&&(r[c]=e,h.onResourceLoad))h.onResourceLoad(k,this.map,this.depMaps);y(c);this.defined=!0}this.defining=!1;this.defined&&!this.defineEmitted&&(this.defineEmitted=!0,this.emit("defined",this.exports),this.defineEmitComplete=
    !0)}}else this.fetch()}},callPlugin:function(){var a=this.map,b=a.id,d=l(a.prefix);this.depMaps.push(d);u(d,"defined",v(this,function(e){var n,d;d=this.map.name;var g=this.map.parentMap?this.map.parentMap.name:null,C=k.makeRequire(a.parentMap,{enableBuildCallback:!0});if(this.map.unnormalized){if(e.normalize&&(d=e.normalize(d,function(a){return c(a,g,!0)})||""),e=l(a.prefix+"!"+d,this.map.parentMap),u(e,"defined",v(this,function(a){this.init([],function(){return a},null,{enabled:!0,ignore:!0})})),
    d=m(q,e.id)){this.depMaps.push(e);if(this.events.error)d.on("error",v(this,function(a){this.emit("error",a)}));d.enable()}}else n=v(this,function(a){this.init([],function(){return a},null,{enabled:!0})}),n.error=v(this,function(a){this.inited=!0;this.error=a;a.requireModules=[b];H(q,function(a){0===a.map.id.indexOf(b+"_unnormalized")&&y(a.map.id)});w(a)}),n.fromText=v(this,function(e,c){var d=a.name,g=l(d),i=Q;c&&(e=c);i&&(Q=!1);s(g);t(j.config,b)&&(j.config[d]=j.config[b]);try{h.exec(e)}catch(D){return w(B("fromtexteval",
    "fromText eval for "+b+" failed: "+D,D,[b]))}i&&(Q=!0);this.depMaps.push(g);k.completeLoad(d);C([d],n)}),e.load(a.name,C,n,j)}));k.enable(d,this);this.pluginMaps[d.id]=d},enable:function(){W[this.map.id]=this;this.enabling=this.enabled=!0;z(this.depMaps,v(this,function(a,b){var c,e;if("string"===typeof a){a=l(a,this.map.isDefine?this.map:this.map.parentMap,!1,!this.skipMap);this.depMaps[b]=a;if(c=m(P,a.id)){this.depExports[b]=c(this);return}this.depCount+=1;u(a,"defined",v(this,function(a){this.defineDep(b,
    a);this.check()}));this.errback&&u(a,"error",v(this,this.errback))}c=a.id;e=q[c];!t(P,c)&&(e&&!e.enabled)&&k.enable(a,this)}));H(this.pluginMaps,v(this,function(a){var b=m(q,a.id);b&&!b.enabled&&k.enable(a,this)}));this.enabling=!1;this.check()},on:function(a,b){var c=this.events[a];c||(c=this.events[a]=[]);c.push(b)},emit:function(a,b){z(this.events[a],function(a){a(b)});"error"===a&&delete this.events[a]}};k={config:j,contextName:b,registry:q,defined:r,urlFetched:V,defQueue:I,Module:$,makeModuleMap:l,
    nextTick:h.nextTick,onError:w,configure:function(a){a.baseUrl&&"/"!==a.baseUrl.charAt(a.baseUrl.length-1)&&(a.baseUrl+="/");var b=j.pkgs,c=j.shim,e={paths:!0,config:!0,map:!0};H(a,function(a,b){e[b]?"map"===b?(j.map||(j.map={}),S(j[b],a,!0,!0)):S(j[b],a,!0):j[b]=a});a.shim&&(H(a.shim,function(a,b){K(a)&&(a={deps:a});if((a.exports||a.init)&&!a.exportsFn)a.exportsFn=k.makeShimExports(a);c[b]=a}),j.shim=c);a.packages&&(z(a.packages,function(a){a="string"===typeof a?{name:a}:a;b[a.name]={name:a.name,
        location:a.location||a.name,main:(a.main||"main").replace(ka,"").replace(fa,"")}}),j.pkgs=b);H(q,function(a,b){!a.inited&&!a.map.unnormalized&&(a.map=l(b))});if(a.deps||a.callback)k.require(a.deps||[],a.callback)},makeShimExports:function(a){return function(){var b;a.init&&(b=a.init.apply(ba,arguments));return b||a.exports&&da(a.exports)}},makeRequire:function(a,f){function d(e,c,g){var i,j;f.enableBuildCallback&&(c&&J(c))&&(c.__requireJsBuild=!0);if("string"===typeof e){if(J(c))return w(B("requireargs",
        "Invalid require call"),g);if(a&&t(P,e))return P[e](q[a.id]);if(h.get)return h.get(k,e,a,d);i=l(e,a,!1,!0);i=i.id;return!t(r,i)?w(B("notloaded",'Module name "'+i+'" has not been loaded yet for context: '+b+(a?"":". Use require([])"))):r[i]}M();k.nextTick(function(){M();j=s(l(null,a));j.skipMap=f.skipMap;j.init(e,c,g,{enabled:!0});E()});return d}f=f||{};S(d,{isBrowser:A,toUrl:function(b){var d,f=b.lastIndexOf("."),g=b.split("/")[0];if(-1!==f&&(!("."===g||".."===g)||1<f))d=b.substring(f,b.length),b=
        b.substring(0,f);return k.nameToUrl(c(b,a&&a.id,!0),d,!0)},defined:function(b){return t(r,l(b,a,!1,!0).id)},specified:function(b){b=l(b,a,!1,!0).id;return t(r,b)||t(q,b)}});a||(d.undef=function(b){x();var c=l(b,a,!0),d=m(q,b);delete r[b];delete V[c.url];delete aa[b];d&&(d.events.defined&&(aa[b]=d.events),y(b))});return d},enable:function(a){m(q,a.id)&&s(a).enable()},completeLoad:function(a){var b,c,e=m(j.shim,a)||{},d=e.exports;for(x();I.length;){c=I.shift();if(null===c[0]){c[0]=a;if(b)break;b=!0}else c[0]===
        a&&(b=!0);F(c)}c=m(q,a);if(!b&&!t(r,a)&&c&&!c.inited){if(j.enforceDefine&&(!d||!da(d)))return p(a)?void 0:w(B("nodefine","No define call for "+a,null,[a]));F([a,e.deps||[],e.exportsFn])}E()},nameToUrl:function(a,b,c){var d,g,l,i,k,p;if(h.jsExtRegExp.test(a))i=a+(b||"");else{d=j.paths;g=j.pkgs;i=a.split("/");for(k=i.length;0<k;k-=1)if(p=i.slice(0,k).join("/"),l=m(g,p),p=m(d,p)){K(p)&&(p=p[0]);i.splice(0,k,p);break}else if(l){a=a===l.name?l.location+"/"+l.main:l.location;i.splice(0,k,a);break}i=i.join("/");
        i+=b||(/\?/.test(i)||c?"":".js");i=("/"===i.charAt(0)||i.match(/^[\w\+\.\-]+:/)?"":j.baseUrl)+i}return j.urlArgs?i+((-1===i.indexOf("?")?"?":"&")+j.urlArgs):i},load:function(a,b){h.load(k,a,b)},execCb:function(a,b,c,d){return b.apply(d,c)},onScriptLoad:function(a){if("load"===a.type||la.test((a.currentTarget||a.srcElement).readyState))R=null,a=L(a),k.completeLoad(a.id)},onScriptError:function(a){var b=L(a);if(!p(b.id))return w(B("scripterror","Script error for: "+b.id,a,[b.id]))}};k.require=k.makeRequire();
    return k}var h,x,y,E,L,F,R,M,s,ga,ma=/(\/\*([\s\S]*?)\*\/|([^:]|^)\/\/(.*)$)/mg,na=/[^.]\s*require\s*\(\s*["']([^'"\s]+)["']\s*\)/g,fa=/\.js$/,ka=/^\.\//;x=Object.prototype;var N=x.toString,ha=x.hasOwnProperty,ja=Array.prototype.splice,A=!!("undefined"!==typeof window&&navigator&&window.document),ea=!A&&"undefined"!==typeof importScripts,la=A&&"PLAYSTATION 3"===navigator.platform?/^complete$/:/^(complete|loaded)$/,Z="undefined"!==typeof opera&&"[object Opera]"===opera.toString(),G={},u={},U=[],Q=
    !1;if("undefined"===typeof define){if("undefined"!==typeof requirejs){if(J(requirejs))return;u=requirejs;requirejs=void 0}"undefined"!==typeof require&&!J(require)&&(u=require,require=void 0);h=requirejs=function(b,c,d,p){var g,l="_";!K(b)&&"string"!==typeof b&&(g=b,K(c)?(b=c,c=d,d=p):b=[]);g&&g.context&&(l=g.context);(p=m(G,l))||(p=G[l]=h.s.newContext(l));g&&p.configure(g);return p.require(b,c,d)};h.config=function(b){return h(b)};h.nextTick="undefined"!==typeof setTimeout?function(b){setTimeout(b,
    4)}:function(b){b()};require||(require=h);h.version="2.1.6";h.jsExtRegExp=/^\/|:|\?|\.js$/;h.isBrowser=A;x=h.s={contexts:G,newContext:ia};h({});z(["toUrl","undef","defined","specified"],function(b){h[b]=function(){var c=G._;return c.require[b].apply(c,arguments)}});if(A&&(y=x.head=document.getElementsByTagName("head")[0],E=document.getElementsByTagName("base")[0]))y=x.head=E.parentNode;h.onError=ca;h.load=function(b,c,d){var h=b&&b.config||{},g;if(A)return g=h.xhtml?document.createElementNS("http://www.w3.org/1999/xhtml",
    "html:script"):document.createElement("script"),g.type=h.scriptType||"text/javascript",g.charset="utf-8",g.async=!0,g.setAttribute("data-requirecontext",b.contextName),g.setAttribute("data-requiremodule",c),g.attachEvent&&!(g.attachEvent.toString&&0>g.attachEvent.toString().indexOf("[native code"))&&!Z?(Q=!0,g.attachEvent("onreadystatechange",b.onScriptLoad)):(g.addEventListener("load",b.onScriptLoad,!1),g.addEventListener("error",b.onScriptError,!1)),g.src=d,M=g,E?y.insertBefore(g,E):y.appendChild(g),
    M=null,g;if(ea)try{importScripts(d),b.completeLoad(c)}catch(l){b.onError(B("importscripts","importScripts failed for "+c+" at "+d,l,[c]))}};A&&O(document.getElementsByTagName("script"),function(b){y||(y=b.parentNode);if(L=b.getAttribute("data-main"))return s=L,u.baseUrl||(F=s.split("/"),s=F.pop(),ga=F.length?F.join("/")+"/":"./",u.baseUrl=ga),s=s.replace(fa,""),h.jsExtRegExp.test(s)&&(s=L),u.deps=u.deps?u.deps.concat(s):[s],!0});define=function(b,c,d){var h,g;"string"!==typeof b&&(d=c,c=b,b=null);
    K(c)||(d=c,c=null);!c&&J(d)&&(c=[],d.length&&(d.toString().replace(ma,"").replace(na,function(b,d){c.push(d)}),c=(1===d.length?["require"]:["require","exports","module"]).concat(c)));if(Q){if(!(h=M))R&&"interactive"===R.readyState||O(document.getElementsByTagName("script"),function(b){if("interactive"===b.readyState)return R=b}),h=R;h&&(b||(b=h.getAttribute("data-requiremodule")),g=G[h.getAttribute("data-requirecontext")])}(g?g.defQueue:U).push([b,c,d])};define.amd={jQuery:!0};h.exec=function(b){return eval(b)};
    h(u)}})(this);}
WebGLDebugUtils = function() {

/**
 * Wrapped logging function.
 * @param {string} msg Message to log.
 */
var log = function(msg) {
  if (window.console && window.console.log) {
    window.console.log(msg);
  }
};

/**
 * Which arguements are enums.
 * @type {!Object.<number, string>}
 */
var glValidEnumContexts = {

  // Generic setters and getters

  'enable': { 0:true },
  'disable': { 0:true },
  'getParameter': { 0:true },

  // Rendering

  'drawArrays': { 0:true },
  'drawElements': { 0:true, 2:true },

  // Shaders

  'createShader': { 0:true },
  'getShaderParameter': { 1:true },
  'getProgramParameter': { 1:true },

  // Vertex attributes

  'getVertexAttrib': { 1:true },
  'vertexAttribPointer': { 2:true },

  // Textures

  'bindTexture': { 0:true },
  'activeTexture': { 0:true },
  'getTexParameter': { 0:true, 1:true },
  'texParameterf': { 0:true, 1:true },
  'texParameteri': { 0:true, 1:true, 2:true },
  'texImage2D': { 0:true, 2:true, 6:true, 7:true },
  'texSubImage2D': { 0:true, 6:true, 7:true },
  'copyTexImage2D': { 0:true, 2:true },
  'copyTexSubImage2D': { 0:true },
  'generateMipmap': { 0:true },

  // Buffer objects

  'bindBuffer': { 0:true },
  'bufferData': { 0:true, 2:true },
  'bufferSubData': { 0:true },
  'getBufferParameter': { 0:true, 1:true },

  // Renderbuffers and framebuffers

  'pixelStorei': { 0:true, 1:true },
  'readPixels': { 4:true, 5:true },
  'bindRenderbuffer': { 0:true },
  'bindFramebuffer': { 0:true },
  'checkFramebufferStatus': { 0:true },
  'framebufferRenderbuffer': { 0:true, 1:true, 2:true },
  'framebufferTexture2D': { 0:true, 1:true, 2:true },
  'getFramebufferAttachmentParameter': { 0:true, 1:true, 2:true },
  'getRenderbufferParameter': { 0:true, 1:true },
  'renderbufferStorage': { 0:true, 1:true },

  // Frame buffer operations (clear, blend, depth test, stencil)

  'clear': { 0:true },
  'depthFunc': { 0:true },
  'blendFunc': { 0:true, 1:true },
  'blendFuncSeparate': { 0:true, 1:true, 2:true, 3:true },
  'blendEquation': { 0:true },
  'blendEquationSeparate': { 0:true, 1:true },
  'stencilFunc': { 0:true },
  'stencilFuncSeparate': { 0:true, 1:true },
  'stencilMaskSeparate': { 0:true },
  'stencilOp': { 0:true, 1:true, 2:true },
  'stencilOpSeparate': { 0:true, 1:true, 2:true, 3:true },

  // Culling

  'cullFace': { 0:true },
  'frontFace': { 0:true },
};

/**
 * Map of numbers to names.
 * @type {Object}
 */
var glEnums = null;

/**
 * Initializes this module. Safe to call more than once.
 * @param {!WebGLRenderingContext} ctx A WebGL context. If
 *    you have more than one context it doesn't matter which one
 *    you pass in, it is only used to pull out constants.
 */
function init(ctx) {
  if (glEnums == null) {
    glEnums = { };
    for (var propertyName in ctx) {
      if (typeof ctx[propertyName] == 'number') {
        glEnums[ctx[propertyName]] = propertyName;
      }
    }
  }
}

/**
 * Checks the utils have been initialized.
 */
function checkInit() {
  if (glEnums == null) {
    throw 'WebGLDebugUtils.init(ctx) not called';
  }
}

/**
 * Returns true or false if value matches any WebGL enum
 * @param {*} value Value to check if it might be an enum.
 * @return {boolean} True if value matches one of the WebGL defined enums
 */
function mightBeEnum(value) {
  checkInit();
  return (glEnums[value] !== undefined);
}

/**
 * Gets an string version of an WebGL enum.
 *
 * Example:
 *   var str = WebGLDebugUtil.glEnumToString(ctx.getError());
 *
 * @param {number} value Value to return an enum for
 * @return {string} The string version of the enum.
 */
function glEnumToString(value) {
  checkInit();
  var name = glEnums[value];
  return (name !== undefined) ? name :
      ("*UNKNOWN WebGL ENUM (0x" + value.toString(16) + ")");
}

/**
 * Returns the string version of a WebGL argument.
 * Attempts to convert enum arguments to strings.
 * @param {string} functionName the name of the WebGL function.
 * @param {number} argumentIndx the index of the argument.
 * @param {*} value The value of the argument.
 * @return {string} The value as a string.
 */
function glFunctionArgToString(functionName, argumentIndex, value) {
  var funcInfo = glValidEnumContexts[functionName];
  if (funcInfo !== undefined) {
    if (funcInfo[argumentIndex]) {
      return glEnumToString(value);
    }
  }
  if (value === null) {
    return "null";
  } else if (value === undefined) {
    return "undefined";
  } else {
    return value.toString();
  }
}

/**
 * Converts the arguments of a WebGL function to a string.
 * Attempts to convert enum arguments to strings.
 *
 * @param {string} functionName the name of the WebGL function.
 * @param {number} args The arguments.
 * @return {string} The arguments as a string.
 */
function glFunctionArgsToString(functionName, args) {
  // apparently we can't do args.join(",");
  var argStr = "";
  for (var ii = 0; ii < args.length; ++ii) {
    argStr += ((ii == 0) ? '' : ', ') +
        glFunctionArgToString(functionName, ii, args[ii]);
  }
  return argStr;
};


function makePropertyWrapper(wrapper, original, propertyName) {
  //log("wrap prop: " + propertyName);
  wrapper.__defineGetter__(propertyName, function() {
    return original[propertyName];
  });
  // TODO(gmane): this needs to handle properties that take more than
  // one value?
  wrapper.__defineSetter__(propertyName, function(value) {
    //log("set: " + propertyName);
    original[propertyName] = value;
  });
}

// Makes a function that calls a function on another object.
function makeFunctionWrapper(original, functionName) {
  //log("wrap fn: " + functionName);
  var f = original[functionName];
  return function() {
    //log("call: " + functionName);
    var result = f.apply(original, arguments);
    return result;
  };
}

/**
 * Given a WebGL context returns a wrapped context that calls
 * gl.getError after every command and calls a function if the
 * result is not gl.NO_ERROR.
 *
 * @param {!WebGLRenderingContext} ctx The webgl context to
 *        wrap.
 * @param {!function(err, funcName, args): void} opt_onErrorFunc
 *        The function to call when gl.getError returns an
 *        error. If not specified the default function calls
 *        console.log with a message.
 * @param {!function(funcName, args): void} opt_onFunc The
 *        function to call when each webgl function is called.
 *        You can use this to log all calls for example.
 */
function makeDebugContext(ctx, opt_onErrorFunc, opt_onFunc) {
  init(ctx);
  opt_onErrorFunc = opt_onErrorFunc || function(err, functionName, args) {
        // apparently we can't do args.join(",");
        var argStr = "";
        for (var ii = 0; ii < args.length; ++ii) {
          argStr += ((ii == 0) ? '' : ', ') +
              glFunctionArgToString(functionName, ii, args[ii]);
        }
        log("WebGL error "+ glEnumToString(err) + " in "+ functionName +
            "(" + argStr + ")");
      };

  // Holds booleans for each GL error so after we get the error ourselves
  // we can still return it to the client app.
  var glErrorShadow = { };

  // Makes a function that calls a WebGL function and then calls getError.
  function makeErrorWrapper(ctx, functionName) {
    return function() {
      if (opt_onFunc) {
        opt_onFunc(functionName, arguments);
      }
      var result = ctx[functionName].apply(ctx, arguments);
      var err = ctx.getError();
      if (err != 0) {
        glErrorShadow[err] = true;
        opt_onErrorFunc(err, functionName, arguments);
      }
      return result;
    };
  }

  // Make a an object that has a copy of every property of the WebGL context
  // but wraps all functions.
  var wrapper = {};
  for (var propertyName in ctx) {
    if (typeof ctx[propertyName] == 'function') {
       wrapper[propertyName] = makeErrorWrapper(ctx, propertyName);
     } else {
       makePropertyWrapper(wrapper, ctx, propertyName);
     }
  }

  // Override the getError function with one that returns our saved results.
  wrapper.getError = function() {
    for (var err in glErrorShadow) {
      if (glErrorShadow.hasOwnProperty(err)) {
        if (glErrorShadow[err]) {
          glErrorShadow[err] = false;
          return err;
        }
      }
    }
    return ctx.NO_ERROR;
  };

  return wrapper;
}

function resetToInitialState(ctx) {
  var numAttribs = ctx.getParameter(ctx.MAX_VERTEX_ATTRIBS);
  var tmp = ctx.createBuffer();
  ctx.bindBuffer(ctx.ARRAY_BUFFER, tmp);
  for (var ii = 0; ii < numAttribs; ++ii) {
    ctx.disableVertexAttribArray(ii);
    ctx.vertexAttribPointer(ii, 4, ctx.FLOAT, false, 0, 0);
    ctx.vertexAttrib1f(ii, 0);
  }
  ctx.deleteBuffer(tmp);

  var numTextureUnits = ctx.getParameter(ctx.MAX_TEXTURE_IMAGE_UNITS);
  for (var ii = 0; ii < numTextureUnits; ++ii) {
    ctx.activeTexture(ctx.TEXTURE0 + ii);
    ctx.bindTexture(ctx.TEXTURE_CUBE_MAP, null);
    ctx.bindTexture(ctx.TEXTURE_2D, null);
  }

  ctx.activeTexture(ctx.TEXTURE0);
  ctx.useProgram(null);
  ctx.bindBuffer(ctx.ARRAY_BUFFER, null);
  ctx.bindBuffer(ctx.ELEMENT_ARRAY_BUFFER, null);
  ctx.bindFramebuffer(ctx.FRAMEBUFFER, null);
  ctx.bindRenderbuffer(ctx.RENDERBUFFER, null);
  ctx.disable(ctx.BLEND);
  ctx.disable(ctx.CULL_FACE);
  ctx.disable(ctx.DEPTH_TEST);
  ctx.disable(ctx.DITHER);
  ctx.disable(ctx.SCISSOR_TEST);
  ctx.blendColor(0, 0, 0, 0);
  ctx.blendEquation(ctx.FUNC_ADD);
  ctx.blendFunc(ctx.ONE, ctx.ZERO);
  ctx.clearColor(0, 0, 0, 0);
  ctx.clearDepth(1);
  ctx.clearStencil(-1);
  ctx.colorMask(true, true, true, true);
  ctx.cullFace(ctx.BACK);
  ctx.depthFunc(ctx.LESS);
  ctx.depthMask(true);
  ctx.depthRange(0, 1);
  ctx.frontFace(ctx.CCW);
  ctx.hint(ctx.GENERATE_MIPMAP_HINT, ctx.DONT_CARE);
  ctx.lineWidth(1);
  ctx.pixelStorei(ctx.PACK_ALIGNMENT, 4);
  ctx.pixelStorei(ctx.UNPACK_ALIGNMENT, 4);
  ctx.pixelStorei(ctx.UNPACK_FLIP_Y_WEBGL, false);
  ctx.pixelStorei(ctx.UNPACK_PREMULTIPLY_ALPHA_WEBGL, false);
  // TODO: Delete this IF.
  if (ctx.UNPACK_COLORSPACE_CONVERSION_WEBGL) {
    ctx.pixelStorei(ctx.UNPACK_COLORSPACE_CONVERSION_WEBGL, ctx.BROWSER_DEFAULT_WEBGL);
  }
  ctx.polygonOffset(0, 0);
  ctx.sampleCoverage(1, false);
  ctx.scissor(0, 0, ctx.canvas.width, ctx.canvas.height);
  ctx.stencilFunc(ctx.ALWAYS, 0, 0xFFFFFFFF);
  ctx.stencilMask(0xFFFFFFFF);
  ctx.stencilOp(ctx.KEEP, ctx.KEEP, ctx.KEEP);
  ctx.viewport(0, 0, ctx.canvas.width, ctx.canvas.height);
  ctx.clear(ctx.COLOR_BUFFER_BIT | ctx.DEPTH_BUFFER_BIT | ctx.STENCIL_BUFFER_BIT);

  // TODO: This should NOT be needed but Firefox fails with 'hint'
  while(ctx.getError());
}

function makeLostContextSimulatingCanvas(canvas) {
  var unwrappedContext_;
  var wrappedContext_;
  var onLost_ = [];
  var onRestored_ = [];
  var wrappedContext_ = {};
  var contextId_ = 1;
  var contextLost_ = false;
  var resourceId_ = 0;
  var resourceDb_ = [];
  var numCallsToLoseContext_ = 0;
  var numCalls_ = 0;
  var canRestore_ = false;
  var restoreTimeout_ = 0;

  // Holds booleans for each GL error so can simulate errors.
  var glErrorShadow_ = { };

  canvas.getContext = function(f) {
    return function() {
      var ctx = f.apply(canvas, arguments);
      // Did we get a context and is it a WebGL context?
      if (ctx instanceof WebGLRenderingContext) {
        if (ctx != unwrappedContext_) {
          if (unwrappedContext_) {
            throw "got different context"
          }
          unwrappedContext_ = ctx;
          wrappedContext_ = makeLostContextSimulatingContext(unwrappedContext_);
        }
        return wrappedContext_;
      }
      return ctx;
    }
  }(canvas.getContext);

  function wrapEvent(listener) {
    if (typeof(listener) == "function") {
      return listener;
    } else {
      return function(info) {
        listener.handleEvent(info);
      }
    }
  }

  var addOnContextLostListener = function(listener) {
    onLost_.push(wrapEvent(listener));
  };

  var addOnContextRestoredListener = function(listener) {
    onRestored_.push(wrapEvent(listener));
  };


  function wrapAddEventListener(canvas) {
    var f = canvas.addEventListener;
    canvas.addEventListener = function(type, listener, bubble) {
      switch (type) {
        case 'webglcontextlost':
          addOnContextLostListener(listener);
          break;
        case 'webglcontextrestored':
          addOnContextRestoredListener(listener);
          break;
        default:
          f.apply(canvas, arguments);
      }
    };
  }

  wrapAddEventListener(canvas);

  canvas.loseContext = function() {
    if (!contextLost_) {
      contextLost_ = true;
      numCallsToLoseContext_ = 0;
      ++contextId_;
      while (unwrappedContext_.getError());
      clearErrors();
      glErrorShadow_[unwrappedContext_.CONTEXT_LOST_WEBGL] = true;
      var event = makeWebGLContextEvent("context lost");
      var callbacks = onLost_.slice();
      setTimeout(function() {
          //log("numCallbacks:" + callbacks.length);
          for (var ii = 0; ii < callbacks.length; ++ii) {
            //log("calling callback:" + ii);
            callbacks[ii](event);
          }
          if (restoreTimeout_ >= 0) {
            setTimeout(function() {
                canvas.restoreContext();
              }, restoreTimeout_);
          }
        }, 0);
    }
  };

  canvas.restoreContext = function() {
    if (contextLost_) {
      if (onRestored_.length) {
        setTimeout(function() {
            if (!canRestore_) {
              throw "can not restore. webglcontestlost listener did not call event.preventDefault";
            }
            freeResources();
            resetToInitialState(unwrappedContext_);
            contextLost_ = false;
            numCalls_ = 0;
            canRestore_ = false;
            var callbacks = onRestored_.slice();
            var event = makeWebGLContextEvent("context restored");
            for (var ii = 0; ii < callbacks.length; ++ii) {
              callbacks[ii](event);
            }
          }, 0);
      }
    }
  };

  canvas.loseContextInNCalls = function(numCalls) {
    if (contextLost_) {
      throw "You can not ask a lost contet to be lost";
    }
    numCallsToLoseContext_ = numCalls_ + numCalls;
  };

  canvas.getNumCalls = function() {
    return numCalls_;
  };

  canvas.setRestoreTimeout = function(timeout) {
    restoreTimeout_ = timeout;
  };

  function isWebGLObject(obj) {
    //return false;
    return (obj instanceof WebGLBuffer ||
            obj instanceof WebGLFramebuffer ||
            obj instanceof WebGLProgram ||
            obj instanceof WebGLRenderbuffer ||
            obj instanceof WebGLShader ||
            obj instanceof WebGLTexture);
  }

  function checkResources(args) {
    for (var ii = 0; ii < args.length; ++ii) {
      var arg = args[ii];
      if (isWebGLObject(arg)) {
        return arg.__webglDebugContextLostId__ == contextId_;
      }
    }
    return true;
  }

  function clearErrors() {
    var k = Object.keys(glErrorShadow_);
    for (var ii = 0; ii < k.length; ++ii) {
      delete glErrorShadow_[k];
    }
  }

  function loseContextIfTime() {
    ++numCalls_;
    if (!contextLost_) {
      if (numCallsToLoseContext_ == numCalls_) {
        canvas.loseContext();
      }
    }
  }

  // Makes a function that simulates WebGL when out of context.
  function makeLostContextFunctionWrapper(ctx, functionName) {
    var f = ctx[functionName];
    return function() {
      // log("calling:" + functionName);
      // Only call the functions if the context is not lost.
      loseContextIfTime();
      if (!contextLost_) {
        //if (!checkResources(arguments)) {
        //  glErrorShadow_[wrappedContext_.INVALID_OPERATION] = true;
        //  return;
        //}

        var result = f.apply(ctx, arguments);
        return result;
      }
    };
  }

  function freeResources() {
    for (var ii = 0; ii < resourceDb_.length; ++ii) {
      var resource = resourceDb_[ii];
      if (resource instanceof WebGLBuffer) {
        unwrappedContext_.deleteBuffer(resource);
      } else if (resource instanceof WebGLFramebuffer) {
        unwrappedContext_.deleteFramebuffer(resource);
      } else if (resource instanceof WebGLProgram) {
        unwrappedContext_.deleteProgram(resource);
      } else if (resource instanceof WebGLRenderbuffer) {
        unwrappedContext_.deleteRenderbuffer(resource);
      } else if (resource instanceof WebGLShader) {
        unwrappedContext_.deleteShader(resource);
      } else if (resource instanceof WebGLTexture) {
        unwrappedContext_.deleteTexture(resource);
      }
    }
  }

  function makeWebGLContextEvent(statusMessage) {
    return {
      statusMessage: statusMessage,
      preventDefault: function() {
          canRestore_ = true;
        }
    };
  }

  return canvas;

  function makeLostContextSimulatingContext(ctx) {
    // copy all functions and properties to wrapper
    for (var propertyName in ctx) {
      if (typeof ctx[propertyName] == 'function') {
         wrappedContext_[propertyName] = makeLostContextFunctionWrapper(
             ctx, propertyName);
       } else {
         makePropertyWrapper(wrappedContext_, ctx, propertyName);
       }
    }

    // Wrap a few functions specially.
    wrappedContext_.getError = function() {
      loseContextIfTime();
      if (!contextLost_) {
        var err;
        while (err = unwrappedContext_.getError()) {
          glErrorShadow_[err] = true;
        }
      }
      for (var err in glErrorShadow_) {
        if (glErrorShadow_[err]) {
          delete glErrorShadow_[err];
          return err;
        }
      }
      return wrappedContext_.NO_ERROR;
    };

    var creationFunctions = [
      "createBuffer",
      "createFramebuffer",
      "createProgram",
      "createRenderbuffer",
      "createShader",
      "createTexture"
    ];
    for (var ii = 0; ii < creationFunctions.length; ++ii) {
      var functionName = creationFunctions[ii];
      wrappedContext_[functionName] = function(f) {
        return function() {
          loseContextIfTime();
          if (contextLost_) {
            return null;
          }
          var obj = f.apply(ctx, arguments);
          obj.__webglDebugContextLostId__ = contextId_;
          resourceDb_.push(obj);
          return obj;
        };
      }(ctx[functionName]);
    }

    var functionsThatShouldReturnNull = [
      "getActiveAttrib",
      "getActiveUniform",
      "getBufferParameter",
      "getContextAttributes",
      "getAttachedShaders",
      "getFramebufferAttachmentParameter",
      "getParameter",
      "getProgramParameter",
      "getProgramInfoLog",
      "getRenderbufferParameter",
      "getShaderParameter",
      "getShaderInfoLog",
      "getShaderSource",
      "getTexParameter",
      "getUniform",
      "getUniformLocation",
      "getVertexAttrib"
    ];
    for (var ii = 0; ii < functionsThatShouldReturnNull.length; ++ii) {
      var functionName = functionsThatShouldReturnNull[ii];
      wrappedContext_[functionName] = function(f) {
        return function() {
          loseContextIfTime();
          if (contextLost_) {
            return null;
          }
          return f.apply(ctx, arguments);
        }
      }(wrappedContext_[functionName]);
    }

    var isFunctions = [
      "isBuffer",
      "isEnabled",
      "isFramebuffer",
      "isProgram",
      "isRenderbuffer",
      "isShader",
      "isTexture"
    ];
    for (var ii = 0; ii < isFunctions.length; ++ii) {
      var functionName = isFunctions[ii];
      wrappedContext_[functionName] = function(f) {
        return function() {
          loseContextIfTime();
          if (contextLost_) {
            return false;
          }
          return f.apply(ctx, arguments);
        }
      }(wrappedContext_[functionName]);
    }

    wrappedContext_.checkFramebufferStatus = function(f) {
      return function() {
        loseContextIfTime();
        if (contextLost_) {
          return wrappedContext_.FRAMEBUFFER_UNSUPPORTED;
        }
        return f.apply(ctx, arguments);
      };
    }(wrappedContext_.checkFramebufferStatus);

    wrappedContext_.getAttribLocation = function(f) {
      return function() {
        loseContextIfTime();
        if (contextLost_) {
          return -1;
        }
        return f.apply(ctx, arguments);
      };
    }(wrappedContext_.getAttribLocation);

    wrappedContext_.getVertexAttribOffset = function(f) {
      return function() {
        loseContextIfTime();
        if (contextLost_) {
          return 0;
        }
        return f.apply(ctx, arguments);
      };
    }(wrappedContext_.getVertexAttribOffset);

    wrappedContext_.isContextLost = function() {
      return contextLost_;
    };

    return wrappedContext_;
  }
}

return {
    /**
     * Initializes this module. Safe to call more than once.
     * @param {!WebGLRenderingContext} ctx A WebGL context. If
    }
   *    you have more than one context it doesn't matter which one
   *    you pass in, it is only used to pull out constants.
   */
  'init': init,

  /**
   * Returns true or false if value matches any WebGL enum
   * @param {*} value Value to check if it might be an enum.
   * @return {boolean} True if value matches one of the WebGL defined enums
   */
  'mightBeEnum': mightBeEnum,

  /**
   * Gets an string version of an WebGL enum.
   *
   * Example:
   *   WebGLDebugUtil.init(ctx);
   *   var str = WebGLDebugUtil.glEnumToString(ctx.getError());
   *
   * @param {number} value Value to return an enum for
   * @return {string} The string version of the enum.
   */
  'glEnumToString': glEnumToString,

  /**
   * Converts the argument of a WebGL function to a string.
   * Attempts to convert enum arguments to strings.
   *
   * Example:
   *   WebGLDebugUtil.init(ctx);
   *   var str = WebGLDebugUtil.glFunctionArgToString('bindTexture', 0, gl.TEXTURE_2D);
   *
   * would return 'TEXTURE_2D'
   *
   * @param {string} functionName the name of the WebGL function.
   * @param {number} argumentIndx the index of the argument.
   * @param {*} value The value of the argument.
   * @return {string} The value as a string.
   */
  'glFunctionArgToString': glFunctionArgToString,

  /**
   * Converts the arguments of a WebGL function to a string.
   * Attempts to convert enum arguments to strings.
   *
   * @param {string} functionName the name of the WebGL function.
   * @param {number} args The arguments.
   * @return {string} The arguments as a string.
   */
  'glFunctionArgsToString': glFunctionArgsToString,

  /**
   * Given a WebGL context returns a wrapped context that calls
   * gl.getError after every command and calls a function if the
   * result is not NO_ERROR.
   *
   * You can supply your own function if you want. For example, if you'd like
   * an exception thrown on any GL error you could do this
   *
   *    function throwOnGLError(err, funcName, args) {
   *      throw WebGLDebugUtils.glEnumToString(err) +
   *            " was caused by call to " + funcName;
   *    };
   *
   *    ctx = WebGLDebugUtils.makeDebugContext(
   *        canvas.getContext("webgl"), throwOnGLError);
   *
   * @param {!WebGLRenderingContext} ctx The webgl context to wrap.
   * @param {!function(err, funcName, args): void} opt_onErrorFunc The function
   *     to call when gl.getError returns an error. If not specified the default
   *     function calls console.log with a message.
   * @param {!function(funcName, args): void} opt_onFunc The
   *     function to call when each webgl function is called. You
   *     can use this to log all calls for example.
   */
  'makeDebugContext': makeDebugContext,

  /**
   * Given a canvas element returns a wrapped canvas element that will
   * simulate lost context. The canvas returned adds the following functions.
   *
   * loseContext:
   *   simulates a lost context event.
   *
   * restoreContext:
   *   simulates the context being restored.
   *
   * lostContextInNCalls:
   *   loses the context after N gl calls.
   *
   * getNumCalls:
   *   tells you how many gl calls there have been so far.
   *
   * setRestoreTimeout:
   *   sets the number of milliseconds until the context is restored
   *   after it has been lost. Defaults to 0. Pass -1 to prevent
   *   automatic restoring.
   *
   * @param {!Canvas} canvas The canvas element to wrap.
   */
  'makeLostContextSimulatingCanvas': makeLostContextSimulatingCanvas,

  /**
   * Resets a context to the initial state.
   * @param {!WebGLRenderingContext} ctx The webgl context to
   *     reset.
   */
  'resetToInitialState': resetToInitialState
};

}();
/**
 * @class Generic map of IDs to items - can generate own IDs or accept given IDs. IDs should be strings in order to not
 * clash with internally generated IDs, which are numbers.
 * @private
 */
var SceneJS_Map = function(items, _baseId) {

    /**
     * @property Items in this map
     */
    this.items = items || [];


    var baseId = _baseId || 0;
    var lastUniqueId = baseId + 1;

    /**
     * Adds an item to the map and returns the ID of the item in the map. If an ID is given, the item is
     * mapped to that ID. Otherwise, the map automatically generates the ID and maps to that.
     *
     * id = myMap.addItem("foo") // ID internally generated
     *
     * id = myMap.addItem("foo", "bar") // ID is "foo"
     *
     */
    this.addItem = function() {

        var item;

        if (arguments.length == 2) {

            var id = arguments[0];

            item = arguments[1];

            if (this.items[id]) { // Won't happen if given ID is string
                throw SceneJS_error.fatalError(SceneJS.errors.ID_CLASH, "ID clash: '" + id + "'");
            }

            this.items[id] = item;

            return id;

        } else {

            while (true) {

                item = arguments[0];
                var findId = lastUniqueId++;

                if (!this.items[findId]) {
                    this.items[findId] = item;
                    return findId;
                }
            }
        }
    };

    /**
     * Removes the item of the given ID from the map
     */
    this.removeItem = function(id) {
        delete this.items[id];
    };
};/**
 * The SceneJS object.
 */
var SceneJS = new (function () {

    /**
     * This SceneJS version
     */
    this.VERSION = '3.2';

    this._baseStateId = 0;

    // Pub/sub support
    this._handleMap = new SceneJS_Map(); // Subscription handle pool
    this._topicSubs = {}; // A [handle -> callback] map for each topic name
    this._handleTopics = {}; // Maps handles to topic names
    this._topicPubs = {}; // Maps topics to publications

    /**
     * @property {SceneJS_Engine} Engines currently in existance
     */
    this._engines = {};

    this._engineIds = new SceneJS_Map();


    /**
     * Publishes to a topic.
     *
     * Immediately notifies existing subscriptions to that topic, retains the publication to give to
     * any subsequent notifications on that topic as they are made.
     *
     * @param {String} topic Publication topic
     * @param {Object} pub The publication
     * @param {Boolean} [forget] When true, the publication will be sent to subscribers then forgotten, so that any
     * subsequent subscribers will not receive it
     * @private
     */
    this.publish = function (topic, pub, forget) {
        if (!forget) {
            this._topicPubs[topic] = pub; // Save notification
        }
        var subsForTopic = this._topicSubs[topic];
        if (subsForTopic) { // Notify subscriptions
            for (var handle in subsForTopic) {
                if (subsForTopic.hasOwnProperty(handle)) {
                    subsForTopic[handle].call(this, pub);
                }
            }
        }
    };

    /**
     * Removes a topic publication
     *
     * Immediately notifies existing subscriptions to that topic, sending them each a null publication.
     *
     * @param topic Publication topic
     * @private
     */
    this.unpublish = function (topic) {
        var subsForTopic = this._topicSubs[topic];
        if (subsForTopic) { // Notify subscriptions
            for (var handle in subsForTopic) {
                if (subsForTopic.hasOwnProperty(handle)) {
                    subsForTopic[handle].call(this, null);
                }
            }
        }
        delete this._topicPubs[topic];
    };


    /**
     * Listen for data changes at a particular location
     *
     * <p>Your callback will be triggered for
     * the initial data and again whenever the data changes. Use {@link #off} to stop receiving updates.</p>
     *
     * <p>The callback is be called with SceneJS as scope.</p>
     *
     * @param {String} location Publication location
     * @param {Function(data)} callback Called when fresh data is available at the location
     * @return {String} Handle to the subscription, which may be used to unsubscribe with {@link #off}.
     */
    this.on = function (topic, callback) {
        var subsForTopic = this._topicSubs[topic];
        if (!subsForTopic) {
            subsForTopic = {};
            this._topicSubs[topic] = subsForTopic;
        }
        var handle = this._handleMap.addItem(); // Create unique handle
        subsForTopic[handle] = callback;
        this._handleTopics[handle] = topic;
        var pub = this._topicPubs[topic];
        if (pub) { // A publication exists, notify callback immediately
            callback.call(this, pub);
        }
        return handle;
    };

    /**
     * Unsubscribes from a publication that was previously made with {@link #on}.
     * @param handle Publication handle
     */
    this.off = function (handle) {
        var topic = this._handleTopics[handle];
        if (topic) {
            delete this._handleTopics[handle];
            var topicSubs = this._topicSubs[topic];
            if (topicSubs) {
                delete topicSubs[handle];
            }
            this._handleMap.removeItem(handle); // Release handle
            if (topic == "rendered") {
                this._engine.branchDirty(this);
            }
        }
    };

    /**
     * Listens for exactly one data update at the specified location, and then stops listening.
     * <p>This is equivalent to calling {@link #on}, and then calling {@link #off} inside the callback function.</p>
     * @param {String} location Data location to listen to
     * @param {Function(data)} callback Called when fresh data is available at the location
     */
    this.once = function (topic, callback) {
        var self = this;
        var sub = this.on(topic,
            function (pub) {
                self.off(sub);
                callback(pub);
            });
    };

    /**
     * Creates a new scene from the given JSON description and begins rendering it
     *
     * @param {String} json JSON scene description
     * @param {*} options Optional options
     * @param {Boolean} options.simulateWebGLContextLost Set true to enable simulation of lost WebGL context (has performance impact)
     * @returns {SceneJS.Scene} New scene
     */
    this.createScene = function (json, options) {

       json = json || {};

        if (json.id) {
            if (this._engines[json.id]) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "Scene already exists with this ID: '" + json.id + "'");
            }
            this._engineIds.addItem(json.id, {});
        } else {
            json.id = this._engineIds.addItem({});
        }

        var engine = new SceneJS_Engine(json, options);

        this._engines[json.id] = engine;

        SceneJS_events.fireEvent(SceneJS_events.SCENE_CREATED, {    // Notify modules that need to know about new scene
            engine:engine
        });

        engine.scene.start(options);

        return engine.scene;
    };

    /**
     * Gets an existing scene
     *
     * @param {String} sceneId ID of target scene
     * @deprecated
     * @returns {SceneJS.Scene} The selected scene
     */
    this.scene = function (sceneId) {

        var engine = this._engines[sceneId];

        return engine ? engine.scene : null;
    };

    /**
     * Gets an existing scene.
     *
     * When no scene ID is given, the first scene found is returned. This is a shorthand convenience for
     * easy scripting when only one scene is defined.
     *
     * @param {String} [sceneId] ID of target scene
     * @returns {SceneJS.Scene} The selected scene
     */
    this.getScene = function (sceneId) {

        if (!sceneId) {
            for (var sceneId in this._engines) {
                if (this._engines.hasOwnProperty(sceneId)) {
                    return this._engines[sceneId].scene;
                }
            }
        }

        var engine = this._engines[sceneId];

        return engine ? engine.scene : null;
    };

    /**
     * Gets existing scenes
     *
     * @returns  Existing scenes, mapped to their IDs
     */
    this.getScenes = function () {

        var scenes = {};

        for (var sceneId in this._engines) {
            if (this._engines.hasOwnProperty(sceneId)) {
                scenes[sceneId] = this._engines[sceneId].scene;
            }
        }

        return scenes;
    };

    /**
     * Tests if the given object is an array
     * @private
     */
    this._isArray = function (testObject) {
        return testObject && !(testObject.propertyIsEnumerable('length'))
            && typeof testObject === 'object' && typeof testObject.length === 'number';
    };

    /**
     *
     */
    this._shallowClone = function (o) {
        var o2 = {};
        for (var name in o) {
            if (o.hasOwnProperty(name)) {
                o2[name] = o[name];
            }
        }
        return o2;
    };

    /**
     * Add properties of o to o2 where undefined or null on o2
     * @private
     */
    this._applyIf = function (o, o2) {
        for (var name in o) {
            if (o.hasOwnProperty(name)) {
                if (o2[name] == undefined || o2[name] == null) {
                    o2[name] = o[name];
                }
            }
        }
        return o2;
    };

    /**
     * Add properties of o to o2, overwriting them on o2 if already there.
     * The optional clear flag causes properties on o2 to be cleared first
     * @private
     */
    this._apply = function (o, o2, clear) {
        var name;
        if (clear) {
            for (name in o2) {
                if (o2.hasOwnProperty(name)) {
                    delete o2[name];
                }
            }
        }
        for (name in o) {
            if (o.hasOwnProperty(name)) {
                o2[name] = o[name];
            }
        }
        return o2;
    };


    /**
     * Resets SceneJS, destroying all existing scenes
     */
    this.reset = function () {

        var temp = [];

        for (var id in this._engines) { // Collect engines to destroy
            if (this._engines.hasOwnProperty(id)) {

                temp.push(this._engines[id]);

                delete this._engines[id];

                this._engineIds.removeItem(id);
            }
        }

        while (temp.length > 0) { // Destroy the engines
            temp.pop().destroy();
        }

        SceneJS_events.fireEvent(SceneJS_events.RESET);
    };

})();
// Configure RequireJS to find plugins relative to plugins location
(function () {

    var pluginPath;

    SceneJS.on("configs",
        function (configs) {
            if (configs.pluginPath != pluginPath) {
                pluginPath = configs.pluginPath;
                var libPath = pluginPath + "/lib";
                require.config({
                    paths:{
                        "scenejsPluginDeps":libPath
                    }
                });
            }
        });
})();/**
 *  @private
 */
var SceneJS_eventManager = function () {

    this._handlerIds = new SceneJS_Map();

    this.typeHandlers = {};
};

/**
 *
 */
SceneJS_eventManager.prototype.createEvent = function (type) {

    if (this.typeHandlers[type]) {
        return;
    }

    this.typeHandlers[type] = {
        handlers:{},
        numSubs:0
    };
};

/**
 * Subscribes to an event defined on this event manager
 *
 * @param {String} type Event type one of the values in SceneJS_events
 * @param {Function} callback Handler function that will accept whatever parameter object accompanies the event
 * @return {String} handle Handle to the event binding
 */
SceneJS_eventManager.prototype.onEvent = function (type, callback) {

    var handlersForType = this.typeHandlers[type] || (this.typeHandlers[type] = {
        handlers:{},
        numSubs:0
    });

    var handlerId = this._handlerIds.addItem(type);

    var handlers = handlersForType.handlers;
    handlers[handlerId] = callback;
    handlersForType.numSubs++;

    return handlerId;
};

/**
 *
 */
SceneJS_eventManager.prototype.fireEvent = function (type, params) {

    var handlersForType = this.typeHandlers[type] || (this.typeHandlers[type] = {
        handlers:{},
        numSubs:0
    });

    if (handlersForType.numSubs > 0) {

        var handlers = handlersForType.handlers;

        for (var handlerId in handlers) {
            if (handlers.hasOwnProperty(handlerId)) {
                handlers[handlerId](params);
            }
        }
    }
};

/**
 * Unsubscribes to an event previously subscribed to on this manager
 *
 * @param {String} handlerId Subscription handle
 */
SceneJS_eventManager.prototype.unEvent = function (handlerId) {

    var type = this._handlerIds.items[handlerId];
    if (!type) {
        return;
    }

    this._handlerIds.removeItem(handlerId);

    var handlers = this.typeHandlers[type];

    if (!handlers) {
        return;
    }

    delete handlers[handlerId];
    this.typeHandlers[type].numSubs--;
};
/**
 * SceneJS plugin registry
 */
SceneJS.Plugins = new (function () {

    // Plugin map for each node type
    var nodePlugins = {};

    // Subscribers to plugins
    var pluginSubs = {};

    /**
     * Installs a plugin into SceneJS
     * @param {String} nodeType Node type name
     * @param {String} pluginType Plugin type name
     * @param [{String}] deps List of URLs of JavaScript files that the plugin depends on
     * @param {Function} plugin Plugin constructor
     */
    this.addPlugin = function () {
        var nodeType = arguments[0];
        var pluginType = arguments[1];
        var deps;
        var plugin;
        if (arguments.length == 4) {
            deps = arguments[2];
            plugin = arguments[3];
        } else {
            plugin = arguments[2];
        }
        addPlugin(nodeType, pluginType, deps, plugin);
    };

    function addPlugin(nodeType, pluginType, deps, plugin) {
        var plugins = nodePlugins[nodeType] || (nodePlugins[nodeType] = {});
        plugins[pluginType] = plugin;
        // Load dependencies, if any
        loadDeps(deps,
            0,
            function () {
                // Notify and unsubscribe subscribers
                var subId = nodeType + pluginType;
                var subs = pluginSubs[subId] || (pluginSubs[subId] = []);
                while (subs.length > 0) {
                    subs.pop()(plugin);
                }
                delete pluginSubs[subId];
            });
    }

    // Loads list of dependencies, synchronously and in order
    function loadDeps(deps, i, ok) {
        if (!deps || i >= deps.length) {
            ok();
            return;
        }
        var src = deps[i];
        var pluginPath = SceneJS_configsModule.configs.pluginPath;
        if (!pluginPath) {
            throw "no pluginPath config"; // Build script error - should create this config
        }
        src = pluginPath + "/" + src;
        loadScript(src,
            function () {
                loadDeps(deps, i + 1, ok);
            });
    }

    /**
     * Tests if given plugin is installed
     */
    this.hasPlugin = function (nodeType, pluginType) {
        var plugins = nodePlugins[nodeType];
        return (plugins && !!plugins[pluginType]);
    };

    /**
     * Returns installed plugin of given type and ID
     */
    this.getPlugin = function (nodeType, pluginType, ok) {
        var plugins = nodePlugins[nodeType];
        if (plugins) {
            var plugin = plugins[pluginType];
            if (plugin) {
                ok(plugin);
                return;
            }
        }
        var subId = nodeType + pluginType;
        var subs = pluginSubs[subId] || (pluginSubs[subId] = []);
        subs.push(ok);
        if (subs.length > 1) { // Not first sub
            return;
        }
        var self = this;
        var pluginPath = SceneJS_configsModule.configs.pluginPath;
        if (!pluginPath) {
            throw "no pluginPath config"; // Build script error - should create this config
        }
        var pluginFilePath = pluginPath + "/" + nodeType + "/" + pluginType + ".js";
        loadScript(pluginFilePath);
    };

    function loadScript(src, ok) {
        var script = document.createElement("script");
        script.type = "text/javascript";
        if (script.readyState) {  //IE
            script.onreadystatechange = function () {
                if (script.readyState == "loaded" ||
                    script.readyState == "complete") {
                    script.onreadystatechange = null;
                    if (ok) {
                        ok();
                    }
                }
            };
        } else {  //Others
            script.onload = function () {
                if (ok) {
                    ok();
                }
            };
        }
        script.src = src;
        document.getElementsByTagName("head")[0].appendChild(script);
    }

})();/**
 *  @private
 */
var SceneJS_events = new (function () {

    this.ERROR = 0;
    this.RESET = 1;                         // SceneJS framework reset
    this.NODE_CREATED = 2;                 // Scene has just been created
    this.SCENE_CREATED = 3;                 // Scene has just been created
    this.SCENE_COMPILING = 4;               // Scene about to be compiled and drawn
    this.SCENE_DESTROYED = 5;               // Scene just been destroyed
    this.OBJECT_COMPILING = 6;
    this.WEBGL_CONTEXT_LOST = 7;
    this.WEBGL_CONTEXT_RESTORED = 8;

    /* Priority queue for each type of event
     */
    var events = [];

    /**
     * Registers a handler for the given event and returns a subscription handle
     *
     * The handler can be registered with an optional priority number which specifies the order it is
     * called among the other handler already registered for the event.
     *
     * So, with n being the number of commands registered for the given event:
     *
     * (priority <= 0)      - command will be the first called
     * (priority >= n)      - command will be the last called
     * (0 < priority < n)   - command will be called at the order given by the priority
     * @private
     * @param type Event type - one of the values in SceneJS_events
     * @param command - Handler function that will accept whatever parameter object accompanies the event
     * @param priority - Optional priority number (see above)
     * @return {String} - Subscription handle
     */
    this.addListener = function (type, command, priority) {

        var list = events[type];

        if (!list) {
            list = [];
            events[type] = list;
        }

        var handler = {
            command:command,
            priority:(priority == undefined) ? list.length : priority
        };

        var index = -1;

        for (var i = 0, len = list.length; i < len; i++) {
            if (!list[i]) {
                index = i;
                break;
            }
        }

        if (index < 0) {
            list.push(handler);
            index = list.length - 1;
        }

//
//        for (var i = 0; i < list.length; i++) {
//            if (list[i].priority > handler.priority) {
//                list.splice(i, 0, handler);
//                return i;
//            }
//        }


        var handle = type + "." + index;

        return handle;
    };

    /**
     * Removes a listener
     * @param handle Subscription handle
     */
    this.removeListener = function (handle) {

        var lastIdx = handle.lastIndexOf(".");

        var type = parseInt(handle.substr(0, lastIdx));
        var index = parseInt(handle.substr(lastIdx + 1));

        var list = events[type];

        if (!list) {
            return;
        }

        delete list[index];
    };

    /**
     * @private
     */
    this.fireEvent = function (type, params) {

        var list = events[type];

        if (list) {
            params = params || {};
            for (var i = 0; i < list.length; i++) {
                if (list[i]) {
                    list[i].command(params);
                }
            }
        }
    };

})();


/**
 * Subscribe to SceneJS events
 * @deprecated
 */
SceneJS.bind = function (name, func) {
    switch (name) {

        case "error" :

            return SceneJS_events.addListener(SceneJS_events.ERROR, func);
            break;

        case "reset" :

            return SceneJS_events.addListener(
                SceneJS_events.RESET,
                function () {
                    func();
                });
            break;

        case "webglcontextlost" :

            return SceneJS_events.addListener(
                SceneJS_events.WEBGL_CONTEXT_LOST,
                function (params) {
                    func(params);
                });
            break;

        case "webglcontextrestored" :

            return SceneJS_events.addListener(
                SceneJS_events.WEBGL_CONTEXT_RESTORED,
                function (params) {
                    func(params);
                });
            break;

        default:
            throw SceneJS_error.fatalError("SceneJS.bind - this event type not supported: '" + name + "'");
    }
};

/* Subscribe to SceneJS events
 * @deprecated
 */
SceneJS.onEvent = SceneJS.bind;

/* Unsubscribe from event
 */
SceneJS.unEvent = function (handle) {
    return SceneJS_events.removeListener(handle);
};

SceneJS.subscribe = SceneJS.addListener = SceneJS.onEvent = SceneJS.bind;

SceneJS.unsubscribe = SceneJS.unEvent;


SceneJS.on = SceneJS.onEvent;
SceneJS.off = SceneJS.unEvent;



/**
 *
 */
var SceneJS_Canvas = function (id, canvasId, contextAttr, options) {

    /**
     * ID of this canvas
     */
    this.canvasId;

    if (!canvasId) {
        // Automatic default canvas
        canvasId = "canvas-" + id;
        var body = document.getElementsByTagName("body")[0];
        var div = document.createElement('div');
        var style = div.style;
        style.height = "100%";
        style.width = "100%";
        style.padding = "0";
        style.margin = "0";
        style.left = "0";
        style.top = "0";
        style.position = "absolute";
        // style["z-index"] = "10000";
        div.innerHTML += '<canvas id="' + canvasId + '" style="width: 100%; height: 100%; margin: 0; padding: 0;"></canvas>';
        body.appendChild(div);
    }

    // Bind to canvas
    var canvas = document.getElementById(canvasId);
    if (!canvas) {
        throw SceneJS_error.fatalError(SceneJS.errors.CANVAS_NOT_FOUND,
            "SceneJS.Scene attribute 'canvasId' does not match any elements in the page");
    }
    this.canvasId = canvasId;

    /**
     * WebGL context options
     */
    this.options = options || {};

    this.canvas = (this.options.simulateWebGLContextLost)
        ? WebGLDebugUtils.makeLostContextSimulatingCanvas(canvas)
        : canvas;

    // If the canvas uses css styles to specify the sizes make sure the basic
    // width and height attributes match or the WebGL context will use 300 x 150

    this.canvas.width = this.canvas.clientWidth;
    this.canvas.height = this.canvas.clientHeight;

    /**
     * Attributes given when initialising the WebGL context
     */
    this.contextAttr = contextAttr;

    /**
     * The WebGL context
     */
    this.gl = null;

    this.initWebGL();
};

/**
 * Names of recognised WebGL contexts
 */
SceneJS_Canvas.prototype._WEBGL_CONTEXT_NAMES = [
    "webgl",
    "experimental-webgl",
    "webkit-3d",
    "moz-webgl",
    "moz-glweb20"
];

/**
 * Initialise the WebGL context

 */
SceneJS_Canvas.prototype.initWebGL = function () {

    for (var i = 0; !this.gl && i < this._WEBGL_CONTEXT_NAMES.length; i++) {
        try {
            this.gl = this.canvas.getContext(this._WEBGL_CONTEXT_NAMES[i], this.contextAttr);

        } catch (e) { // Try with next context name
        }
    }

    if (!this.gl) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.WEBGL_NOT_SUPPORTED,
            'Failed to get a WebGL context');
    }

//    this.gl.clearColor(1.0, 1.0, 1.0, 1.0);
    this.gl.clearDepth(1.0);
    this.gl.enable(this.gl.DEPTH_TEST);
    this.gl.disable(this.gl.CULL_FACE);
    this.gl.depthRange(0, 1);
    this.gl.disable(this.gl.SCISSOR_TEST);
    this.gl.viewport(0, 0, this.canvas.width, this.canvas.height);
};


/**
 * Simulate a lost WebGL context.
 * Only works if the simulateWebGLContextLost was given as an option to the canvas' constructor.
 */
SceneJS_Canvas.prototype.loseWebGLContext = function () {
    if (this.options.simulateWebGLContextLost) {
        this.canvas.loseContext();
    }
};


/**
 * @class A container for a scene graph and its display
 *
 *
 * @private
 */
var SceneJS_Engine = function (json, options) {

    json.type = "scene"; // The type property supplied by user on the root JSON node is ignored - would always be 'scene'

    /**
     * ID of this engine, also the ID of this engine's {@link SceneJS.Scene}
     * @type String
     */
    this.id = json.id;

    /**
     * Canvas and GL context for this engine
     */
    this.canvas = new SceneJS_Canvas(this.id, json.canvasId, json.contextAttr, options);

    /**
     * Manages firing of and subscription to events
     */
    this.events = new SceneJS_eventManager();

    /**
     * State core factory - creates, stores, shares and destroys cores
     */
    this._coreFactory = new SceneJS_CoreFactory();

    /**
     * Manages creation, recycle and destruction of {@link SceneJS.Node} instances for this engine's scene graph
     */
    this._nodeFactory = new SceneJS_NodeFactory();

    /**
     * The engine's scene renderer
     * @type SceneJS_Display
     */
    this.display = new SceneJS_Display({
        canvas:this.canvas
    });

    /**
     * Flags the entirety of the scene graph as needing to be (re)compiled into the display
     */
    this.sceneDirty = false;

    /**
     * Flag set when at least one branch of the scene graph needs recompilation
     */
    this._sceneBranchesDirty = false;

    /**
     * List of nodes scheduled for destruction by #destroyNode
     * Destructions are done in a batch at the end of each render so as not to disrupt the render.
     */
    this._nodesToDestroy = [];

    /**
     * Number of nodes in destruction list
     */
    this._numNodesToDestroy = 0;

    /**
     * Flag which is set while this engine is running - set after call to #start, unset after #stop or #pause
     */
    this.running = false;

    /**
     * Flag which is set while this engine is paused - set after call to #pause, unset after #stop or #start
     */
    this.paused = false;

    /**
     * Flag set once this engine has been destroyed
     */
    this.destroyed = false;

    /**
     * The current scene graph status
     */
    this.sceneStatus = {
        nodes:{}, // Status for each node
        numTasks:0  // Number of loads currently in progress
    };

    var self = this;


    // Create scene root first, then create its subnodes
    // This way nodes can access the scene in their constructors
    var nodes = json.nodes;
    json.nodes = null;
    this.scene = this.createNode(json); // Create scene root

    if (nodes) {
        json.nodes = nodes;
        this.scene.addNodes(nodes); // then create sub-nodes
    }

    this.canvas.canvas.addEventListener(// WebGL context lost
        "webglcontextlost",
        function (event) {
            event.preventDefault();
            self.stop();
            SceneJS_events.fireEvent(SceneJS_events.WEBGL_CONTEXT_LOST, { scene:self.scene });
        },
        false);

    this.canvas.canvas.addEventListener(// WebGL context recovered
        "webglcontextrestored",
        function (event) {
            self.canvas.initWebGL();
            self._coreFactory.webglRestored();  // Reallocate WebGL resources for node state cores
            self.display.webglRestored(); // Reallocate shaders and re-cache shader var locations for display state chunks
            SceneJS_events.fireEvent(SceneJS_events.WEBGL_CONTEXT_RESTORED, { scene:self.scene });
            self.start();
        },
        false);
};


/**
 * Simulate a lost WebGL context.
 * Only works if the simulateWebGLContextLost was given as an option to the engine's constructor.
 */
SceneJS_Engine.prototype.loseWebGLContext = function () {
    this.canvas.loseWebGLContext();
};

/**
 * Gets/loads the given node type
 *
 * @param {String} type Node type name
 * @param {Function(Function)} ok Callback fired when type loaded, returns the type constructor
 */
SceneJS_Engine.prototype.getNodeType = function (type, ok) {
    SceneJS_NodeFactory.getNodeType(type, ok);
};

/**
 * Returns true if the given node type is currently loaded (ie. load not required)
 * @param type
 */
SceneJS_Engine.prototype.hasNodeType = function (type) {
    return !!SceneJS_NodeFactory.nodeTypes[type];
};

/**
 * Recursively parse the given JSON scene graph representation and return a scene (sub)graph.
 *
 * @param {Object} json JSON definition of a scene graph or subgraph
 * @param {Function} ok Callback fired when node created, with the node as argument
 */
SceneJS_Engine.prototype.createNode = function (json, ok) {

    // Do buffered node destroys - don't want olds nodes
    // hanging around whose IDs may clash with the new node
    this._doDestroyNodes();

    json.type = json.type || "node"; // Nodes are SceneJS.Node type by default
    var core = this._coreFactory.getCore(json.type, json.coreId); // Create or share a core
    var self = this;

    return this._nodeFactory.getNode(
        this,
        json,
        core,
        function (node) {

            // Create child nodes
            if (!node._fromPlugin && json.nodes) {
                var numNodes = 0;
                for (var i = 0, len = json.nodes.length; i < len; i++) {
                    self.createNode(
                        json.nodes[i],
                        function (childNode) {
                            node.addNode(childNode);
                            if (++numNodes == len) {
                                if (ok) {
                                    ok(node);
                                }
                                self.scene.publish("nodes/" + node.id, node);
                            }
                        });
                }
            } else {
                if (ok) {
                    ok(node);
                    self.scene.publish("nodes/" + node.id, node);
                }
            }
        });
};

/**
 * Performs pending node destructions. When destroyed, each node and its core is released back to the
 * node and core pools for reuse, respectively.
 */
SceneJS_Engine.prototype._doDestroyNodes = function () {

    var node;

    while (this._numNodesToDestroy > 0) {

        node = this._nodesToDestroy[--this._numNodesToDestroy];

        node._doDestroy();

        this._coreFactory.putCore(node._core);    // Release state core for reuse

        this._nodeFactory.putNode(node);         // Release node for reuse
    }
};

/**
 * Finds the node with the given ID in this engine's scene graph
 * @return {SceneJS.Node} The node if found, else null
 */
SceneJS_Engine.prototype.findNode = function (nodeId) {
    return this._nodeFactory.nodes.items[nodeId];
};

/** Finds nodes in this engine's scene graph that have nodes IDs matching the given regular expression
 * @param {String} nodeIdRegex Regular expression to match on node IDs
 * @return {[SceneJS.Node]} Array of nodes whose IDs match the given regex
 */
SceneJS_Engine.prototype.findNodes = function (nodeIdRegex) {

    var regex = new RegExp(nodeIdRegex);
    var nodes = [];
    var nodeMap = this._nodeFactory.nodes.items;

    for (var nodeId in nodeMap) {
        if (nodeMap.hasOwnProperty(nodeId)) {

            if (regex.test(nodeId)) {
                nodes.push(nodeMap[nodeId]);
            }
        }
    }

    return nodes;
};

/**
 * Tests whether a core of the given ID exists for the given node type
 * @param {String} type Node type
 * @param {String} coreId
 * @returns Boolean
 */
SceneJS_Engine.prototype.hasCore = function (type, coreId) {
    return this._coreFactory.hasCore(type, coreId);
};

/**
 * Schedules the given subtree of this engine's {@link SceneJS.Scene} for recompilation
 *
 * @param {SceneJS.Node} node Root node of the subtree to recompile
 */
SceneJS_Engine.prototype.branchDirty = function (node) {

    if (this.sceneDirty) {
        return; // Whole scene will recompile anyway
    }

    /* Dealing with some weirdness with the embedded window and iframe / window fascism.
     */
    if (node == window) {
        return;
    }

    node.branchDirty = true;
    node.dirty = true;

    for (var n = node.parent; n && !(n.dirty || n.branchDirty); n = n.parent) { // Flag path down to this node
        n.dirty = true;
    }

    this._sceneBranchesDirty = true;
};

/**
 * Renders a single frame. Does any pending scene compilations or draw graph updates first.
 * Ordinarily the frame is rendered only if compilations or draw graph updates were performed,
 * but may be forced to render the frame regardless.
 *
 * @param {{String:String}} params Rendering parameters
 */
SceneJS_Engine.prototype.renderFrame = function (params) {

    if (this._tryCompile() || (params && params.force)) { // Do any pending (re)compilations

        this.display.render(params);

        return true;
    }

    return false;
};

/**
 * Starts the render loop on this engine.
 */
SceneJS_Engine.prototype.start = function () {

    if (!this.running) {

        this.running = true;
        this.paused = false;

        var self = this;
        var fnName = "__scenejs_sceneLoop" + this.id;

        var sleeping = false;

        this.sceneDirty = true;

        var tick = {
            sceneId:this.id,
            startTime:(new Date()).getTime()
        };

        self.events.fireEvent("started", tick);

        var time = (new Date()).getTime();

        var scene = this.scene;

        window[fnName] = function () {

            if (self.running && !self.paused) {  // idleFunc may have paused scene

                tick.prevTime = time;
                time = (new Date()).getTime();
                tick.time = time;

                scene.publish("tick", tick);

                if (!self.running) { // idleFunc may have destroyed scene
                    return;
                }

                if (self._tryCompile()) {         // Attempt pending compile and redraw

                    sleeping = false;

                    self.display.render();

                    scene.publish("rendered", tick);

                    if (self.running) {
                        window.requestAnimationFrame(window[fnName]);
                    }

                } else {

                    if (!sleeping) {
                        scene.publish("sleep", tick);
                    }

                    sleeping = true;

                    if (self.running) {
                        window.requestAnimationFrame(window[fnName]);
                    }
                }
            } else {

                if (self.running) {
                    window.requestAnimationFrame(window[fnName]);
                }
            }
        };

        if (self.running) {
            window.requestAnimationFrame(window[fnName]);
        }
    }
};

/**
 * Performs a pick on this engine and returns a hit record containing at least the name of the picked
 * scene object (as configured by SceneJS.Name nodes) and the canvas pick coordinates. Ordinarily, picking
 * is the simple GPU color-name mapped method, but this method can instead perform a ray-intersect pick
 * when the 'rayPick' flag is set on the options parameter for this method. For that mode, this method will
 * also find the intersection point on the picked object's near surface with a ray cast from the eye that passes
 * through the mouse position on the projection plane.
 *
 * @param {Number} canvasX X-axis canvas pick coordinate
 * @param {Number} canvasY Y-axis canvas pick coordinate
 * @param options Pick options
 * @param options.rayPick Performs additional ray-intersect pick when true
 * @returns The pick record
 */
SceneJS_Engine.prototype.pick = function (canvasX, canvasY, options) {

    this._tryCompile();  // Do any pending scene compilations

    var hit = this.display.pick({
        canvasX:canvasX,
        canvasY:canvasY,
        rayPick:options ? options.rayPick : false
    });

    return hit;
};

/**
 * Performs any pending scene compilations or display rebuilds, returns true if any of those were done,
 * in which case a display re-render is then needed
 *
 * @returns {Boolean} True when any compilations or display rebuilds were done
 */
SceneJS_Engine.prototype._tryCompile = function () {

    // this._doAddNodes();

    if (this.display.imageDirty // Frame buffer needs redraw
        || this.display.drawListDirty // Draw list needs rebuild
        || this.display.stateSortDirty // Draw list needs to redetermine state order
        || this.display.stateOrderDirty // Draw list needs state sort
        || this.display.objectListDirty // Draw list needs to be rebuilt
        || this._sceneBranchesDirty // One or more branches in scene graph need (re)compilation
        || this.sceneDirty) { // Whole scene needs recompilation

        if (this._sceneBranchesDirty || this.sceneDirty) { // Need scene graph compilation

            this._sceneBranchesDirty = false;
            this.sceneDirty = false;

            SceneJS_events.fireEvent(SceneJS_events.SCENE_COMPILING, {  // Notify compilation support start
                engine:this                                            // Compilation support modules get ready
            });

            this.pubSubProxy = new SceneJS_PubSubProxy(this.scene, null);
            var ctx = {
                pubSubProxy : this.pubSubProxy
            };

            this.scene._compileNodes(ctx); // Begin depth-first compilation descent into scene sub-nodes
        }

        this._doDestroyNodes(); // Garbage collect destroyed nodes - node destructions set imageDirty true

        return true; // Compilation was performed, need frame redraw now
    }

    return false;
};

/**
 * Pauses/unpauses the render loop
 * @param {Boolean} doPause Pauses or unpauses the render loop
 */
SceneJS_Engine.prototype.pause = function (doPause) {
    this.paused = doPause;
};

/**
 * Stops the render loop
 */
SceneJS_Engine.prototype.stop = function () {

    if (this.running) {

        this.running = false;
        this.paused = false;

        window["__scenejs_sceneLoop" + this.id] = null;

        //   this.events.fireEvent("stopped", { sceneId: this.id });
    }
};

/**
 * Destroys a node within this engine's {@link SceneJS.Scene}
 *
 * @param {SceneJS.Node} node Node to destroy
 */
SceneJS_Engine.prototype.destroyNode = function (node) {

    /* The node is actually scheduled for lazy destruction within the next invocation of #_tryCompile
     */
    this._nodesToDestroy[this._numNodesToDestroy++] = node;

    /* Stop tracking node's status
     */
    var nodeStatus = this.sceneStatus.nodes[node.id];

    if (nodeStatus) {
        this.sceneStatus.numTasks -= nodeStatus.numTasks;
        delete this.sceneStatus.nodes[node.id];
    }
};

/**
 * Destroys this engine
 */
SceneJS_Engine.prototype.destroy = function () {

    this.destroyed = true;

    // this.events.fireEvent("destroyed", { sceneId: this.id });
};

/*---------------------------------------------------------------------------------------------------------------------
 * JavaScript augmentations to support render loop
 *--------------------------------------------------------------------------------------------------------------------*/

if (!self.Int32Array) {
    self.Int32Array = Array;
    self.Float32Array = Array;
}

// Ripped off from THREE.js - https://github.com/mrdoob/three.js/blob/master/src/Three.js
// http://paulirish.com/2011/requestanimationframe-for-smart-animating/
// http://my.opera.com/emoller/blog/2011/12/20/requestanimationframe-for-smart-er-animating

(function () {
    var lastTime = 0;
    var vendors = ['ms', 'moz', 'webkit', 'o'];
    for (var x = 0; x < vendors.length && !window.requestAnimationFrame; ++x) {
        window.requestAnimationFrame = window[vendors[x] + 'RequestAnimationFrame'];
        window.cancelAnimationFrame = window[vendors[x] + 'CancelAnimationFrame']
            || window[vendors[x] + 'RequestCancelAnimationFrame'];
    }

    if (!window.requestAnimationFrame)
        window.requestAnimationFrame = function (callback, element) {
            var currTime = new Date().getTime();
            var timeToCall = Math.max(0, 16 - (currTime - lastTime));
            var id = window.setTimeout(function () {
                    callback(currTime + timeToCall);
                },
                timeToCall);
            lastTime = currTime + timeToCall;
            return id;
        };

    if (!window.cancelAnimationFrame)
        window.cancelAnimationFrame = function (id) {
            clearTimeout(id);
        };
}());
/**
 * Backend module that provides single point through which exceptions may be raised
 *
 * @class SceneJS_error
 * @private
 */
var SceneJS_error = new (function() {

    var activeSceneId;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING, // Set default logging for scene root
            function(params) {
                activeSceneId = params.engine.id;
            });

    SceneJS_events.addListener(
            SceneJS_events.RESET,
            function() {
                activeSceneId = null;
            },
            100000);  // Really low priority - must be reset last

    this.fatalError = function(code, message) {
        if (typeof code == "string") {
            message = code;
            code = SceneJS.errors.ERROR;
        }
        var error = {
            errorName: SceneJS.errors._getErrorName(code) || "ERROR",
            code: code,
            exception: message,
            fatal: true
        };
        if (activeSceneId) {
            error.sceneId = activeSceneId;
        }
        SceneJS_events.fireEvent(SceneJS_events.ERROR, error);
        return message;
    };

    this.error = function(code, message) {
        var error = {
            errorName: SceneJS.errors._getErrorName(code) || "ERROR",
            code: code,
            exception: message,
            fatal: false
        };
        if (activeSceneId) {
            error.sceneId = activeSceneId;
        }
        SceneJS_events.fireEvent(SceneJS_events.ERROR, error);
    };
})();

(function() {
    SceneJS.errors = {};

    var n = 0;
    SceneJS.errors.ERROR = n++;
    SceneJS.errors.WEBGL_NOT_SUPPORTED = n++;
    SceneJS.errors.WEBGL_CONTEXT_LOST = n++;
    SceneJS.errors.NODE_CONFIG_EXPECTED = n++;
    SceneJS.errors.ILLEGAL_NODE_CONFIG = n++;
    SceneJS.errors.SHADER_COMPILATION_FAILURE = n++;
    SceneJS.errors.SHADER_LINK_FAILURE = n++;
    SceneJS.errors.CANVAS_NOT_FOUND = n++;
    SceneJS.errors.OUT_OF_VRAM = n++;
    SceneJS.errors.WEBGL_UNSUPPORTED_NODE_CONFIG = n++;
    SceneJS.errors.NODE_NOT_FOUND = n++;
    SceneJS.errors.NODE_ILLEGAL_STATE = n++;
    SceneJS.errors.ID_CLASH = n++;
    SceneJS.errors.PLUGIN_INVALID = n++;
})();

SceneJS.errors._getErrorName = function(code) {
    for (var key in SceneJS.errors) {
        if (SceneJS.errors.hasOwnProperty(key) && SceneJS.errors[key] == code) {
            return key;
        }
    }
    return null;
};

/**
 * Backend that manages configurations.
 *
 * @class SceneJS_configsModule
 * @private
 */
var SceneJS_configsModule = new (function () {

    this.configs = {};
    var subs = {};

    /**
     * Set a config
     * @param path
     * @param data
     */
    this.setConfigs = function (path, data) {
        // Update configs
        if (!path) {
            this.configs = data;
        } else {
            var parts = path.split(".");
            var cfg = this.configs;
            var subCfg;
            var name;
            for (var i = 0; i < parts.length - 1; i++) {
                name = parts[i];
                subCfg = cfg[name];
                if (!subCfg) {
                    subCfg = cfg[name] = {};
                }
                cfg = subCfg;
            }
            cfg[parts.length - 1] = data;
        }
        // Notify subscribers
        var list = subs[path || "_all"];
        if (list) {
            for (var i = 0, len = list.length; i < len; i++) {
                list[i](cfg);
            }
        }

        SceneJS.publish("configs", this.configs);
    };

    /**
     * Get a config
     * @param path
     * @return {*}
     */
    this.getConfigs = function (path) {
        if (!path) {
            return this.configs;
        } else {
            var cfg = this.configs;
            var parts = path.split(".");
            for (var i = 0; cfg && i < parts.length; i++) {
                cfg = cfg[parts[i]];
            }
            return cfg || {};
        }
    };

    /**
     * Subscribe to updates to a config
     * @param path
     * @param ok
     */
    this.on = function (path, ok) {
        path = path || "_all";
        (subs[path] || (subs[path] = [])).push(ok);
        ok(this.getConfigs(path));
    };

})();

/** Sets configurations.
 */
SceneJS.configure = SceneJS.setConfigs = SceneJS.setDebugConfigs = function () {
    if (arguments.length == 1) {
        SceneJS_configsModule.setConfigs(null, arguments[0]);
    } else if (arguments.length == 2) {
        SceneJS_configsModule.setConfigs(arguments[0], arguments[1]);
    } else {
        throw SceneJS_error.fatalError("Illegal arguments given to SceneJS.setDebugs - should be either ({String}:name, {Object}:cfg) or ({Object}:cfg)");
    }
};

/** Gets configurations
 */
SceneJS.getConfigs = SceneJS.getDebugConfigs = function (path) {
    return SceneJS_configsModule.getConfigs(path);
};

/**
 * @class Manages logging
 *  @private
 */
SceneJS.log = new (function() {

    var activeSceneId;
    var funcs = null;
    var queues = {};
    var indent = 0;
    var indentStr = "";

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING, // Set default logging for scene root
            function(params) {
                activeSceneId = params.engine.id;
            });

    SceneJS_events.addListener(
            SceneJS_events.RESET,
            function() {
                queues = {};
                funcs = null;
                activeSceneId = null;
            },
            100000);  // Really low priority - must be reset last

    this._setIndent = function(_indent) {
        indent = _indent;
        var indentArray = [];
        for (var i = 0; i < indent; i++) {
            indentArray.push("----");
        }
        indentStr = indentArray.join("");
    };

    this.error = function(msg) {
        this._log("error", msg);
    };

    this.warn = function(msg) {
        this._log("warn", msg);
    };

    this.info = function(msg) {
        this._log("info", msg);
    };

    this.debug = function(msg) {
        this._log("debug", msg);
    };

    this.setFuncs = function(l) {
        if (l) {
            funcs = l;
            for (var channel in queues) {
                this._flush(channel);
            }
        }
    };

    this._flush = function(channel) {
        var queue = queues[channel];
        if (queue) {
            var func = funcs ? funcs[channel] : null;
            if (func) {
                for (var i = 0; i < queue.length; i++) {
                    func(queue[i]);
                }
                queues[channel] = [];
            }
        }
    };

    this._log = function(channel, message) {
        if (SceneJS._isArray(message)) {
            for (var i = 0; i < message.length; i++) {
                this.__log(channel, message[i]);
            }
        } else {
            this.__log(channel, message);
        }
    };

    this.__log = function(channel, message) {
        message = activeSceneId
                ? indentStr + activeSceneId + ": " + message
                : indentStr + message;

        if (funcs && funcs[channel]) {
            funcs[channel](message);

        } else if (console && console[channel]) {
            console[channel](message);
        }
    };

    this.getFuncs = function() {
        return funcs;
    };

})();/* 
 * Optimizations made based on glMatrix by Brandon Jones
 */

/*
 * Copyright (c) 2010 Brandon Jones
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *    1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 *
 *    2. Altered source versions must be plainly marked as such, and must not
 *    be misrepresented as being the original software.
 *
 *    3. This notice may not be removed or altered from any source
 *    distribution.
 */


/**
 * @param u vec3
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_divVec3 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] / v[0];
    dest[1] = u[1] / v[1];
    dest[2] = u[2] / v[2];

    return dest;
};

/**
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_negateVector4 = function(v, dest) {
    if (!dest) {
        dest = v;
    }
    dest[0] = -v[0];
    dest[1] = -v[1];
    dest[2] = -v[2];
    dest[3] = -v[3];

    return dest;
};

/**
 * @param u vec4
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_addVec4 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] + v[0];
    dest[1] = u[1] + v[1];
    dest[2] = u[2] + v[2];
    dest[3] = u[3] + v[3];

    return dest;
};


/**
 * @param v vec4
 * @param s scalar
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_addVec4s = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] + s;
    dest[1] = v[1] + s;
    dest[2] = v[2] + s;
    dest[3] = v[3] + s;

    return dest;
};

/**
 * @param u vec3
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_addVec3 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] + v[0];
    dest[1] = u[1] + v[1];
    dest[2] = u[2] + v[2];

    return dest;
};

/**
 * @param v vec3
 * @param s scalar
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_addVec3s = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] + s;
    dest[1] = v[1] + s;
    dest[2] = v[2] + s;

    return dest;
};

/** @private */
var SceneJS_math_addScalarVec4 = function(s, v, dest) {
    return SceneJS_math_addVec4s(v, s, dest);
};

/**
 * @param u vec4
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_subVec4 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] - v[0];
    dest[1] = u[1] - v[1];
    dest[2] = u[2] - v[2];
    dest[3] = u[3] - v[3];

    return dest;
};

/**
 * @param u vec3
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_subVec3 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] - v[0];
    dest[1] = u[1] - v[1];
    dest[2] = u[2] - v[2];

    return dest;
};

var SceneJS_math_lerpVec3 = function(t, t1, t2, p1, p2) {
    var f2 = (t - t1) / (t2 - t1);
    var f1 = 1.0 - f2;
    return  {
        x: p1.x * f1 + p2.x * f2,
        y: p1.y * f1 + p2.y * f2,
        z: p1.z * f1 + p2.z * f2
    };
};


/**
 * @param u vec2
 * @param v vec2
 * @param dest vec2 - optional destination
 * @return {vec2} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_subVec2 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] - v[0];
    dest[1] = u[1] - v[1];

    return dest;
};

/**
 * @param v vec4
 * @param s scalar
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_subVec4Scalar = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] - s;
    dest[1] = v[1] - s;
    dest[2] = v[2] - s;
    dest[3] = v[3] - s;

    return dest;
};

/**
 * @param v vec4
 * @param s scalar
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_subScalarVec4 = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = s - v[0];
    dest[1] = s - v[1];
    dest[2] = s - v[2];
    dest[3] = s - v[3];

    return dest;
};

/**
 * @param u vec4
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_mulVec4 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] * v[0];
    dest[1] = u[1] * v[1];
    dest[2] = u[2] * v[2];
    dest[3] = u[3] * v[3];

    return dest;
};

/**
 * @param v vec4
 * @param s scalar
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_mulVec4Scalar = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] * s;
    dest[1] = v[1] * s;
    dest[2] = v[2] * s;
    dest[3] = v[3] * s;

    return dest;
};


/**
 * @param v vec3
 * @param s scalar
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_mulVec3Scalar = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] * s;
    dest[1] = v[1] * s;
    dest[2] = v[2] * s;

    return dest;
};

/**
 * @param v vec2
 * @param s scalar
 * @param dest vec2 - optional destination
 * @return {vec2} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_mulVec2Scalar = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] * s;
    dest[1] = v[1] * s;

    return dest;
};


/**
 * @param u vec4
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_divVec4 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    dest[0] = u[0] / v[0];
    dest[1] = u[1] / v[1];
    dest[2] = u[2] / v[2];
    dest[3] = u[3] / v[3];

    return dest;
};

/**
 * @param v vec3
 * @param s scalar
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_divScalarVec3 = function(s, v, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = s / v[0];
    dest[1] = s / v[1];
    dest[2] = s / v[2];

    return dest;
};

/**
 * @param v vec3
 * @param s scalar
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_divVec3s = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] / s;
    dest[1] = v[1] / s;
    dest[2] = v[2] / s;

    return dest;
};

/**
 * @param v vec4
 * @param s scalar
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_divVec4s = function(v, s, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = v[0] / s;
    dest[1] = v[1] / s;
    dest[2] = v[2] / s;
    dest[3] = v[3] / s;

    return dest;
};


/**
 * @param s scalar
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_divScalarVec4 = function(s, v, dest) {
    if (!dest) {
        dest = v;
    }

    dest[0] = s / v[0];
    dest[1] = s / v[1];
    dest[2] = s / v[2];
    dest[3] = s / v[3];

    return dest;
};


/** @private */
var SceneJS_math_dotVector4 = function(u, v) {
    return (u[0] * v[0] + u[1] * v[1] + u[2] * v[2] + u[3] * v[3]);
};

/** @private */
var SceneJS_math_cross3Vec4 = function(u, v) {
    var u0 = u[0], u1 = u[1], u2 = u[2];
    var v0 = v[0], v1 = v[1], v2 = v[2];
    return [
        u1 * v2 - u2 * v1,
        u2 * v0 - u0 * v2,
        u0 * v1 - u1 * v0,
        0.0];
};

/**
 * @param u vec3
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, u otherwise
 * @private
 */
var SceneJS_math_cross3Vec3 = function(u, v, dest) {
    if (!dest) {
        dest = u;
    }

    var x = u[0], y = u[1], z = u[2];
    var x2 = v[0], y2 = v[1], z2 = v[2];

    dest[0] = y * z2 - z * y2;
    dest[1] = z * x2 - x * z2;
    dest[2] = x * y2 - y * x2;

    return dest;
};

/** @private */
var SceneJS_math_sqLenVec4 = function(v) {
    return SceneJS_math_dotVector4(v, v);
};

/** @private */
var SceneJS_math_lenVec4 = function(v) {
    return Math.sqrt(SceneJS_math_sqLenVec4(v));
};

/** @private */
var SceneJS_math_dotVector3 = function(u, v) {
    return (u[0] * v[0] + u[1] * v[1] + u[2] * v[2]);
};

/** @private */
var SceneJS_math_dotVector2 = function(u, v) {
    return (u[0] * v[0] + u[1] * v[1]);
};

/** @private */
var SceneJS_math_sqLenVec3 = function(v) {
    return SceneJS_math_dotVector3(v, v);
};

/** @private */
var SceneJS_math_sqLenVec2 = function(v) {
    return SceneJS_math_dotVector2(v, v);
};

/** @private */
var SceneJS_math_lenVec3 = function(v) {
    return Math.sqrt(SceneJS_math_sqLenVec3(v));
};

/** @private */
var SceneJS_math_lenVec2 = function(v) {
    return Math.sqrt(SceneJS_math_sqLenVec2(v));
};

/**
 * @param v vec3
 * @param dest vec3 - optional destination
 * @return {vec3} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_rcpVec3 = function(v, dest) {
    return SceneJS_math_divScalarVec3(1.0, v, dest);
};

/**
 * @param v vec4
 * @param dest vec4 - optional destination
 * @return {vec4} dest if specified, v otherwise
 * @private
 */
var SceneJS_math_normalizeVec4 = function(v, dest) {
    var f = 1.0 / SceneJS_math_lenVec4(v);
    return SceneJS_math_mulVec4Scalar(v, f, dest);
};

/** @private */
var SceneJS_math_normalizeVec3 = function(v, dest) {
    var f = 1.0 / SceneJS_math_lenVec3(v);
    return SceneJS_math_mulVec3Scalar(v, f, dest);
};

// @private
var SceneJS_math_normalizeVec2 = function(v, dest) {
    var f = 1.0 / SceneJS_math_lenVec2(v);
    return SceneJS_math_mulVec2Scalar(v, f, dest);
};

/** @private */
var SceneJS_math_mat4 = function() {
    return new Array(16);
};

/** @private */
var SceneJS_math_dupMat4 = function(m) {
    return m.slice(0, 16);
};

/** @private */
var SceneJS_math_getCellMat4 = function(m, row, col) {
    return m[row + col * 4];
};

/** @private */
var SceneJS_math_setCellMat4 = function(m, row, col, s) {
    m[row + col * 4] = s;
};

/** @private */
var SceneJS_math_getRowMat4 = function(m, r) {
    return [m[r], m[r + 4], m[r + 8], m[r + 12]];
};

/** @private */
var SceneJS_math_setRowMat4 = function(m, r, v) {
    m[r] = v[0];
    m[r + 4] = v[1];
    m[r + 8] = v[2];
    m[r + 12] = v[3];
};

/** @private */
var SceneJS_math_setRowMat4c = function(m, r, x, y, z, w) {
    SceneJS_math_setRowMat4(m, r, [x,y,z,w]);
};

/** @private */
var SceneJS_math_setRowMat4s = function(m, r, s) {
    SceneJS_math_setRowMat4c(m, r, s, s, s, s);
};

/** @private */
var SceneJS_math_getColMat4 = function(m, c) {
    var i = c * 4;
    return [m[i], m[i + 1],m[i + 2],m[i + 3]];
};

/** @private */
var SceneJS_math_setColMat4v = function(m, c, v) {
    var i = c * 4;
    m[i] = v[0];
    m[i + 1] = v[1];
    m[i + 2] = v[2];
    m[i + 3] = v[3];
};

/** @private */
var SceneJS_math_setColMat4c = function(m, c, x, y, z, w) {
    SceneJS_math_setColMat4v(m, c, [x,y,z,w]);
};

/** @private */
var SceneJS_math_setColMat4Scalar = function(m, c, s) {
    SceneJS_math_setColMat4c(m, c, s, s, s, s);
};

/** @private */
var SceneJS_math_mat4To3 = function(m) {
    return [
        m[0],m[1],m[2],
        m[4],m[5],m[6],
        m[8],m[9],m[10]
    ];
};

/** @private */
var SceneJS_math_m4s = function(s) {
    return [
        s,s,s,s,
        s,s,s,s,
        s,s,s,s,
        s,s,s,s
    ];
};

/** @private */
var SceneJS_math_setMat4ToZeroes = function() {
    return SceneJS_math_m4s(0.0);
};

/** @private */
var SceneJS_math_setMat4ToOnes = function() {
    return SceneJS_math_m4s(1.0);
};

/** @private */
var SceneJS_math_diagonalMat4v = function(v) {
    return [
        v[0], 0.0, 0.0, 0.0,
        0.0,v[1], 0.0, 0.0,
        0.0, 0.0, v[2],0.0,
        0.0, 0.0, 0.0, v[3]
    ];
};

/** @private */
var SceneJS_math_diagonalMat4c = function(x, y, z, w) {
    return SceneJS_math_diagonalMat4v([x,y,z,w]);
};

/** @private */
var SceneJS_math_diagonalMat4s = function(s) {
    return SceneJS_math_diagonalMat4c(s, s, s, s);
};

/** @private */
var SceneJS_math_identityMat4 = function() {
    return SceneJS_math_diagonalMat4v([1.0,1.0,1.0,1.0]);
};

/** @private */
var SceneJS_math_isIdentityMat4 = function(m) {
    if (m[0] !== 1.0 || m[1] !== 0.0 || m[2] !== 0.0 || m[3] !== 0.0 ||
        m[4] !== 0.0 || m[5] !== 1.0 || m[6] !== 0.0 || m[7] !== 0.0 ||
        m[8] !== 0.0 || m[9] !== 0.0 || m[10] !== 1.0 || m[11] !== 0.0 ||
        m[12] !== 0.0 || m[13] !== 0.0 || m[14] !== 0.0 || m[15] !== 1.0)
    {
        return false;
    }

    return true;
};

/**
 * @param m mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, m otherwise
 * @private
 */
var SceneJS_math_negateMat4 = function(m, dest) {
    if (!dest) {
        dest = m;
    }

    dest[0] = -m[0];
    dest[1] = -m[1];
    dest[2] = -m[2];
    dest[3] = -m[3];
    dest[4] = -m[4];
    dest[5] = -m[5];
    dest[6] = -m[6];
    dest[7] = -m[7];
    dest[8] = -m[8];
    dest[9] = -m[9];
    dest[10] = -m[10];
    dest[11] = -m[11];
    dest[12] = -m[12];
    dest[13] = -m[13];
    dest[14] = -m[14];
    dest[15] = -m[15];

    return dest;
};

/**
 * @param a mat4
 * @param b mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, a otherwise
 * @private
 */
var SceneJS_math_addMat4 = function(a, b, dest) {
    if (!dest) {
        dest = a;
    }

    dest[0] = a[0] + b[0];
    dest[1] = a[1] + b[1];
    dest[2] = a[2] + b[2];
    dest[3] = a[3] + b[3];
    dest[4] = a[4] + b[4];
    dest[5] = a[5] + b[5];
    dest[6] = a[6] + b[6];
    dest[7] = a[7] + b[7];
    dest[8] = a[8] + b[8];
    dest[9] = a[9] + b[9];
    dest[10] = a[10] + b[10];
    dest[11] = a[11] + b[11];
    dest[12] = a[12] + b[12];
    dest[13] = a[13] + b[13];
    dest[14] = a[14] + b[14];
    dest[15] = a[15] + b[15];

    return dest;
};

/**
 * @param m mat4
 * @param s scalar
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, m otherwise
 * @private
 */
var SceneJS_math_addMat4Scalar = function(m, s, dest) {
    if (!dest) {
        dest = m;
    }

    dest[0] = m[0] + s;
    dest[1] = m[1] + s;
    dest[2] = m[2] + s;
    dest[3] = m[3] + s;
    dest[4] = m[4] + s;
    dest[5] = m[5] + s;
    dest[6] = m[6] + s;
    dest[7] = m[7] + s;
    dest[8] = m[8] + s;
    dest[9] = m[9] + s;
    dest[10] = m[10] + s;
    dest[11] = m[11] + s;
    dest[12] = m[12] + s;
    dest[13] = m[13] + s;
    dest[14] = m[14] + s;
    dest[15] = m[15] + s;

    return dest;
};

/** @private */
var SceneJS_math_addScalarMat4 = function(s, m, dest) {
    return SceneJS_math_addMat4Scalar(m, s, dest);
};

/**
 * @param a mat4
 * @param b mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, a otherwise
 * @private
 */
var SceneJS_math_subMat4 = function(a, b, dest) {
    if (!dest) {
        dest = a;
    }

    dest[0] = a[0] - b[0];
    dest[1] = a[1] - b[1];
    dest[2] = a[2] - b[2];
    dest[3] = a[3] - b[3];
    dest[4] = a[4] - b[4];
    dest[5] = a[5] - b[5];
    dest[6] = a[6] - b[6];
    dest[7] = a[7] - b[7];
    dest[8] = a[8] - b[8];
    dest[9] = a[9] - b[9];
    dest[10] = a[10] - b[10];
    dest[11] = a[11] - b[11];
    dest[12] = a[12] - b[12];
    dest[13] = a[13] - b[13];
    dest[14] = a[14] - b[14];
    dest[15] = a[15] - b[15];

    return dest;
};

/**
 * @param m mat4
 * @param s scalar
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, m otherwise
 * @private
 */
var SceneJS_math_subMat4Scalar = function(m, s, dest) {
    if (!dest) {
        dest = m;
    }

    dest[0] = m[0] - s;
    dest[1] = m[1] - s;
    dest[2] = m[2] - s;
    dest[3] = m[3] - s;
    dest[4] = m[4] - s;
    dest[5] = m[5] - s;
    dest[6] = m[6] - s;
    dest[7] = m[7] - s;
    dest[8] = m[8] - s;
    dest[9] = m[9] - s;
    dest[10] = m[10] - s;
    dest[11] = m[11] - s;
    dest[12] = m[12] - s;
    dest[13] = m[13] - s;
    dest[14] = m[14] - s;
    dest[15] = m[15] - s;

    return dest;
};

/**
 * @param s scalar
 * @param m mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, m otherwise
 * @private
 */
var SceneJS_math_subScalarMat4 = function(s, m, dest) {
    if (!dest) {
        dest = m;
    }

    dest[0] = s - m[0];
    dest[1] = s - m[1];
    dest[2] = s - m[2];
    dest[3] = s - m[3];
    dest[4] = s - m[4];
    dest[5] = s - m[5];
    dest[6] = s - m[6];
    dest[7] = s - m[7];
    dest[8] = s - m[8];
    dest[9] = s - m[9];
    dest[10] = s - m[10];
    dest[11] = s - m[11];
    dest[12] = s - m[12];
    dest[13] = s - m[13];
    dest[14] = s - m[14];
    dest[15] = s - m[15];

    return dest;
};

/**
 * @param a mat4
 * @param b mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, a otherwise
 * @private
 */
var SceneJS_math_mulMat4 = function(a, b, dest) {
    if (!dest) {
        dest = a;
    }

    // Cache the matrix values (makes for huge speed increases!)
    var a00 = a[0], a01 = a[1], a02 = a[2], a03 = a[3];
    var a10 = a[4], a11 = a[5], a12 = a[6], a13 = a[7];
    var a20 = a[8], a21 = a[9], a22 = a[10], a23 = a[11];
    var a30 = a[12], a31 = a[13], a32 = a[14], a33 = a[15];

    var b00 = b[0], b01 = b[1], b02 = b[2], b03 = b[3];
    var b10 = b[4], b11 = b[5], b12 = b[6], b13 = b[7];
    var b20 = b[8], b21 = b[9], b22 = b[10], b23 = b[11];
    var b30 = b[12], b31 = b[13], b32 = b[14], b33 = b[15];

    dest[0] = b00 * a00 + b01 * a10 + b02 * a20 + b03 * a30;
    dest[1] = b00 * a01 + b01 * a11 + b02 * a21 + b03 * a31;
    dest[2] = b00 * a02 + b01 * a12 + b02 * a22 + b03 * a32;
    dest[3] = b00 * a03 + b01 * a13 + b02 * a23 + b03 * a33;
    dest[4] = b10 * a00 + b11 * a10 + b12 * a20 + b13 * a30;
    dest[5] = b10 * a01 + b11 * a11 + b12 * a21 + b13 * a31;
    dest[6] = b10 * a02 + b11 * a12 + b12 * a22 + b13 * a32;
    dest[7] = b10 * a03 + b11 * a13 + b12 * a23 + b13 * a33;
    dest[8] = b20 * a00 + b21 * a10 + b22 * a20 + b23 * a30;
    dest[9] = b20 * a01 + b21 * a11 + b22 * a21 + b23 * a31;
    dest[10] = b20 * a02 + b21 * a12 + b22 * a22 + b23 * a32;
    dest[11] = b20 * a03 + b21 * a13 + b22 * a23 + b23 * a33;
    dest[12] = b30 * a00 + b31 * a10 + b32 * a20 + b33 * a30;
    dest[13] = b30 * a01 + b31 * a11 + b32 * a21 + b33 * a31;
    dest[14] = b30 * a02 + b31 * a12 + b32 * a22 + b33 * a32;
    dest[15] = b30 * a03 + b31 * a13 + b32 * a23 + b33 * a33;

    return dest;
};

/**
 * @param m mat4
 * @param s scalar
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, m otherwise
 * @private
 */
var SceneJS_math_mulMat4s = function(m, s, dest)
{
    if (!dest) {
        dest = m;
    }

    dest[0] = m[0] * s;
    dest[1] = m[1] * s;
    dest[2] = m[2] * s;
    dest[3] = m[3] * s;
    dest[4] = m[4] * s;
    dest[5] = m[5] * s;
    dest[6] = m[6] * s;
    dest[7] = m[7] * s;
    dest[8] = m[8] * s;
    dest[9] = m[9] * s;
    dest[10] = m[10] * s;
    dest[11] = m[11] * s;
    dest[12] = m[12] * s;
    dest[13] = m[13] * s;
    dest[14] = m[14] * s;
    dest[15] = m[15] * s;

    return dest;
};

/**
 * @param m mat4
 * @param v vec4
 * @return {vec4}
 * @private
 */
var SceneJS_math_mulMat4v4 = function(m, v) {
    var v0 = v[0], v1 = v[1], v2 = v[2], v3 = v[3];

    return [
        m[0] * v0 + m[4] * v1 + m[8] * v2 + m[12] * v3,
        m[1] * v0 + m[5] * v1 + m[9] * v2 + m[13] * v3,
        m[2] * v0 + m[6] * v1 + m[10] * v2 + m[14] * v3,
        m[3] * v0 + m[7] * v1 + m[11] * v2 + m[15] * v3
    ];
};

/**
 * @param mat mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, mat otherwise
 * @private
 */
var SceneJS_math_transposeMat4 = function(mat, dest) {
    // If we are transposing ourselves we can skip a few steps but have to cache some values
    var m4 = mat[4], m14 = mat[14], m8 = mat[8];
    var m13 = mat[13], m12 = mat[12], m9 = mat[9];
    if (!dest || mat == dest) {
        var a01 = mat[1], a02 = mat[2], a03 = mat[3];
        var a12 = mat[6], a13 = mat[7];
        var a23 = mat[11];

        mat[1] = m4;
        mat[2] = m8;
        mat[3] = m12;
        mat[4] = a01;
        mat[6] = m9;
        mat[7] = m13;
        mat[8] = a02;
        mat[9] = a12;
        mat[11] = m14;
        mat[12] = a03;
        mat[13] = a13;
        mat[14] = a23;
        return mat;
    }

    dest[0] = mat[0];
    dest[1] = m4;
    dest[2] = m8;
    dest[3] = m12;
    dest[4] = mat[1];
    dest[5] = mat[5];
    dest[6] = m9;
    dest[7] = m13;
    dest[8] = mat[2];
    dest[9] = mat[6];
    dest[10] = mat[10];
    dest[11] = m14;
    dest[12] = mat[3];
    dest[13] = mat[7];
    dest[14] = mat[11];
    dest[15] = mat[15];
    return dest;
};

/** @private */
var SceneJS_math_determinantMat4 = function(mat) {
    // Cache the matrix values (makes for huge speed increases!)
    var a00 = mat[0], a01 = mat[1], a02 = mat[2], a03 = mat[3];
    var a10 = mat[4], a11 = mat[5], a12 = mat[6], a13 = mat[7];
    var a20 = mat[8], a21 = mat[9], a22 = mat[10], a23 = mat[11];
    var a30 = mat[12], a31 = mat[13], a32 = mat[14], a33 = mat[15];

    return a30 * a21 * a12 * a03 - a20 * a31 * a12 * a03 - a30 * a11 * a22 * a03 + a10 * a31 * a22 * a03 +
           a20 * a11 * a32 * a03 - a10 * a21 * a32 * a03 - a30 * a21 * a02 * a13 + a20 * a31 * a02 * a13 +
           a30 * a01 * a22 * a13 - a00 * a31 * a22 * a13 - a20 * a01 * a32 * a13 + a00 * a21 * a32 * a13 +
           a30 * a11 * a02 * a23 - a10 * a31 * a02 * a23 - a30 * a01 * a12 * a23 + a00 * a31 * a12 * a23 +
           a10 * a01 * a32 * a23 - a00 * a11 * a32 * a23 - a20 * a11 * a02 * a33 + a10 * a21 * a02 * a33 +
           a20 * a01 * a12 * a33 - a00 * a21 * a12 * a33 - a10 * a01 * a22 * a33 + a00 * a11 * a22 * a33;
};

/**
 * @param mat mat4
 * @param dest mat4 - optional destination
 * @return {mat4} dest if specified, mat otherwise
 * @private
 */
var SceneJS_math_inverseMat4 = function(mat, dest) {
    if (!dest) {
        dest = mat;
    }

    // Cache the matrix values (makes for huge speed increases!)
    var a00 = mat[0], a01 = mat[1], a02 = mat[2], a03 = mat[3];
    var a10 = mat[4], a11 = mat[5], a12 = mat[6], a13 = mat[7];
    var a20 = mat[8], a21 = mat[9], a22 = mat[10], a23 = mat[11];
    var a30 = mat[12], a31 = mat[13], a32 = mat[14], a33 = mat[15];

    var b00 = a00 * a11 - a01 * a10;
    var b01 = a00 * a12 - a02 * a10;
    var b02 = a00 * a13 - a03 * a10;
    var b03 = a01 * a12 - a02 * a11;
    var b04 = a01 * a13 - a03 * a11;
    var b05 = a02 * a13 - a03 * a12;
    var b06 = a20 * a31 - a21 * a30;
    var b07 = a20 * a32 - a22 * a30;
    var b08 = a20 * a33 - a23 * a30;
    var b09 = a21 * a32 - a22 * a31;
    var b10 = a21 * a33 - a23 * a31;
    var b11 = a22 * a33 - a23 * a32;

    // Calculate the determinant (inlined to avoid double-caching)
    var invDet = 1 / (b00 * b11 - b01 * b10 + b02 * b09 + b03 * b08 - b04 * b07 + b05 * b06);

    dest[0] = (a11 * b11 - a12 * b10 + a13 * b09) * invDet;
    dest[1] = (-a01 * b11 + a02 * b10 - a03 * b09) * invDet;
    dest[2] = (a31 * b05 - a32 * b04 + a33 * b03) * invDet;
    dest[3] = (-a21 * b05 + a22 * b04 - a23 * b03) * invDet;
    dest[4] = (-a10 * b11 + a12 * b08 - a13 * b07) * invDet;
    dest[5] = (a00 * b11 - a02 * b08 + a03 * b07) * invDet;
    dest[6] = (-a30 * b05 + a32 * b02 - a33 * b01) * invDet;
    dest[7] = (a20 * b05 - a22 * b02 + a23 * b01) * invDet;
    dest[8] = (a10 * b10 - a11 * b08 + a13 * b06) * invDet;
    dest[9] = (-a00 * b10 + a01 * b08 - a03 * b06) * invDet;
    dest[10] = (a30 * b04 - a31 * b02 + a33 * b00) * invDet;
    dest[11] = (-a20 * b04 + a21 * b02 - a23 * b00) * invDet;
    dest[12] = (-a10 * b09 + a11 * b07 - a12 * b06) * invDet;
    dest[13] = (a00 * b09 - a01 * b07 + a02 * b06) * invDet;
    dest[14] = (-a30 * b03 + a31 * b01 - a32 * b00) * invDet;
    dest[15] = (a20 * b03 - a21 * b01 + a22 * b00) * invDet;

    return dest;
};

/** @private */
var SceneJS_math_traceMat4 = function(m) {
    return (m[0] + m[5] + m[10] + m[15]);
};

/** @private */
var SceneJS_math_translationMat4v = function(v) {
    var m = SceneJS_math_identityMat4();
    m[12] = v[0];
    m[13] = v[1];
    m[14] = v[2];
    return m;
};

/** @private */
var SceneJS_math_translationMat4c = function(x, y, z) {
    return SceneJS_math_translationMat4v([x,y,z]);
};

/** @private */
var SceneJS_math_translationMat4s = function(s) {
    return SceneJS_math_translationMat4c(s, s, s);
};

/** @private */
var SceneJS_math_rotationMat4v = function(anglerad, axis) {
    var ax = SceneJS_math_normalizeVec4([axis[0],axis[1],axis[2],0.0]);
    var s = Math.sin(anglerad);
    var c = Math.cos(anglerad);
    var q = 1.0 - c;

    var x = ax[0];
    var y = ax[1];
    var z = ax[2];

    var xy,yz,zx,xs,ys,zs;

    //xx = x * x; used once
    //yy = y * y; used once
    //zz = z * z; used once
    xy = x * y;
    yz = y * z;
    zx = z * x;
    xs = x * s;
    ys = y * s;
    zs = z * s;

    var m = SceneJS_math_mat4();

    m[0] = (q * x * x) + c;
    m[1] = (q * xy) + zs;
    m[2] = (q * zx) - ys;
    m[3] = 0.0;

    m[4] = (q * xy) - zs;
    m[5] = (q * y * y) + c;
    m[6] = (q * yz) + xs;
    m[7] = 0.0;

    m[8] = (q * zx) + ys;
    m[9] = (q * yz) - xs;
    m[10] = (q * z * z) + c;
    m[11] = 0.0;

    m[12] = 0.0;
    m[13] = 0.0;
    m[14] = 0.0;
    m[15] = 1.0;

    return m;
};

/** @private */
var SceneJS_math_rotationMat4c = function(anglerad, x, y, z) {
    return SceneJS_math_rotationMat4v(anglerad, [x,y,z]);
};

/** @private */
var SceneJS_math_scalingMat4v = function(v) {
    var m = SceneJS_math_identityMat4();
    m[0] = v[0];
    m[5] = v[1];
    m[10] = v[2];
    return m;
};

/** @private */
var SceneJS_math_scalingMat4c = function(x, y, z) {
    return SceneJS_math_scalingMat4v([x,y,z]);
};

/** @private */
var SceneJS_math_scalingMat4s = function(s) {
    return SceneJS_math_scalingMat4c(s, s, s);
};

/**
 * Default lookat properties - eye at 0,0,1, looking at 0,0,0, up vector pointing up Y-axis
 */
var SceneJS_math_LOOKAT_OBJ = {
    eye:    {x: 0, y:0, z:10.0 },
    look:   {x:0, y:0, z:0.0 },
    up:     {x:0, y:1, z:0.0 }
};

/**
 * Default lookat properties in array form - eye at 0,0,1, looking at 0,0,0, up vector pointing up Y-axis
 */
var SceneJS_math_LOOKAT_ARRAYS = {
    eye:    [0, 0, 10.0],
    look:   [0, 0, 0.0 ],
    up:     [0, 1, 0.0 ]
};

/**
 * Default orthographic projection properties
 */
var SceneJS_math_ORTHO_OBJ = {
    left: -1.0,
    right: 1.0,
    bottom: -1.0,
    near: 0.1,
    top: 1.0,
    far: 5000.0
};

/**
 * @param pos vec3 position of the viewer
 * @param target vec3 point the viewer is looking at
 * @param up vec3 pointing "up"
 * @param dest mat4 Optional, mat4 frustum matrix will be written into
 *
 * @return {mat4} dest if specified, a new mat4 otherwise
 */
var SceneJS_math_lookAtMat4v = function(pos, target, up, dest) {
    if (!dest) {
        dest = SceneJS_math_mat4();
    }

    var posx = pos[0],
            posy = pos[1],
            posz = pos[2],
            upx = up[0],
            upy = up[1],
            upz = up[2],
            targetx = target[0],
            targety = target[1],
            targetz = target[2];

    if (posx == targetx && posy == targety && posz == targetz) {
        return SceneJS_math_identityMat4();
    }

    var z0,z1,z2,x0,x1,x2,y0,y1,y2,len;

    //vec3.direction(eye, center, z);
    z0 = posx - targetx;
    z1 = posy - targety;
    z2 = posz - targetz;

    // normalize (no check needed for 0 because of early return)
    len = 1 / Math.sqrt(z0 * z0 + z1 * z1 + z2 * z2);
    z0 *= len;
    z1 *= len;
    z2 *= len;

    //vec3.normalize(vec3.cross(up, z, x));
    x0 = upy * z2 - upz * z1;
    x1 = upz * z0 - upx * z2;
    x2 = upx * z1 - upy * z0;
    len = Math.sqrt(x0 * x0 + x1 * x1 + x2 * x2);
    if (!len) {
        x0 = 0;
        x1 = 0;
        x2 = 0;
    } else {
        len = 1 / len;
        x0 *= len;
        x1 *= len;
        x2 *= len;
    }

    //vec3.normalize(vec3.cross(z, x, y));
    y0 = z1 * x2 - z2 * x1;
    y1 = z2 * x0 - z0 * x2;
    y2 = z0 * x1 - z1 * x0;

    len = Math.sqrt(y0 * y0 + y1 * y1 + y2 * y2);
    if (!len) {
        y0 = 0;
        y1 = 0;
        y2 = 0;
    } else {
        len = 1 / len;
        y0 *= len;
        y1 *= len;
        y2 *= len;
    }

    dest[0] = x0;
    dest[1] = y0;
    dest[2] = z0;
    dest[3] = 0;
    dest[4] = x1;
    dest[5] = y1;
    dest[6] = z1;
    dest[7] = 0;
    dest[8] = x2;
    dest[9] = y2;
    dest[10] = z2;
    dest[11] = 0;
    dest[12] = -(x0 * posx + x1 * posy + x2 * posz);
    dest[13] = -(y0 * posx + y1 * posy + y2 * posz);
    dest[14] = -(z0 * posx + z1 * posy + z2 * posz);
    dest[15] = 1;

    return dest;
};

/** @private */
var SceneJS_math_lookAtMat4c = function(posx, posy, posz, targetx, targety, targetz, upx, upy, upz) {
    return SceneJS_math_lookAtMat4v([posx,posy,posz], [targetx,targety,targetz], [upx,upy,upz]);
};

/** @private */
var SceneJS_math_orthoMat4c = function(left, right, bottom, top, near, far, dest) {
    if (!dest) {
        dest = SceneJS_math_mat4();
    }
    var rl = (right - left);
    var tb = (top - bottom);
    var fn = (far - near);

    dest[0] = 2.0 / rl;
    dest[1] = 0.0;
    dest[2] = 0.0;
    dest[3] = 0.0;

    dest[4] = 0.0;
    dest[5] = 2.0 / tb;
    dest[6] = 0.0;
    dest[7] = 0.0;

    dest[8] = 0.0;
    dest[9] = 0.0;
    dest[10] = -2.0 / fn;
    dest[11] = 0.0;

    dest[12] = -(left + right) / rl;
    dest[13] = -(top + bottom) / tb;
    dest[14] = -(far + near) / fn;
    dest[15] = 1.0;

    return dest;
};

/** @private */
var SceneJS_math_frustumMat4v = function(fmin, fmax) {
    var fmin4 = [fmin[0],fmin[1],fmin[2],0.0];
    var fmax4 = [fmax[0],fmax[1],fmax[2],0.0];
    var vsum = SceneJS_math_mat4();
    SceneJS_math_addVec4(fmax4, fmin4, vsum);
    var vdif = SceneJS_math_mat4();
    SceneJS_math_subVec4(fmax4, fmin4, vdif);
    var t = 2.0 * fmin4[2];

    var m = SceneJS_math_mat4();
    var vdif0 = vdif[0], vdif1 = vdif[1], vdif2 = vdif[2];

    m[0] = t / vdif0;
    m[1] = 0.0;
    m[2] = 0.0;
    m[3] = 0.0;

    m[4] = 0.0;
    m[5] = t / vdif1;
    m[6] = 0.0;
    m[7] = 0.0;

    m[8] = vsum[0] / vdif0;
    m[9] = vsum[1] / vdif1;
    m[10] = -vsum[2] / vdif2;
    m[11] = -1.0;

    m[12] = 0.0;
    m[13] = 0.0;
    m[14] = -t * fmax4[2] / vdif2;
    m[15] = 0.0;

    return m;
};

/** @private */
var SceneJS_math_frustumMatrix4 = function(left, right, bottom, top, near, far, dest) {
    if (!dest) {
        dest = SceneJS_math_mat4();
    }
    var rl = (right - left);
    var tb = (top - bottom);
    var fn = (far - near);
    dest[0] = (near * 2) / rl;
    dest[1] = 0;
    dest[2] = 0;
    dest[3] = 0;
    dest[4] = 0;
    dest[5] = (near * 2) / tb;
    dest[6] = 0;
    dest[7] = 0;
    dest[8] = (right + left) / rl;
    dest[9] = (top + bottom) / tb;
    dest[10] = -(far + near) / fn;
    dest[11] = -1;
    dest[12] = 0;
    dest[13] = 0;
    dest[14] = -(far * near * 2) / fn;
    dest[15] = 0;
    return dest;
};


/** @private */
var SceneJS_math_perspectiveMatrix4 = function(fovyrad, aspectratio, znear, zfar) {
    var pmin = [];
    var pmax = [];

    pmin[2] = znear;
    pmax[2] = zfar;

    pmax[1] = pmin[2] * Math.tan(fovyrad / 2.0);
    pmin[1] = -pmax[1];

    pmax[0] = pmax[1] * aspectratio;
    pmin[0] = -pmax[0];

    return SceneJS_math_frustumMat4v(pmin, pmax);
};

/** @private */
var SceneJS_math_transformPoint3 = function(m, p) {
    var p0 = p[0], p1 = p[1], p2 = p[2];
    return [
        (m[0] * p0) + (m[4] * p1) + (m[8] * p2) + m[12],
        (m[1] * p0) + (m[5] * p1) + (m[9] * p2) + m[13],
        (m[2] * p0) + (m[6] * p1) + (m[10] * p2) + m[14],
        (m[3] * p0) + (m[7] * p1) + (m[11] * p2) + m[15]
    ];
};


/** @private */
var SceneJS_math_transformPoints3 = function(m, points) {
    var result = new Array(points.length);
    var len = points.length;
    var p0, p1, p2;
    var pi;

    // cache values
    var m0 = m[0], m1 = m[1], m2 = m[2], m3 = m[3];
    var m4 = m[4], m5 = m[5], m6 = m[6], m7 = m[7];
    var m8 = m[8], m9 = m[9], m10 = m[10], m11 = m[11];
    var m12 = m[12], m13 = m[13], m14 = m[14], m15 = m[15];

    for (var i = 0; i < len; ++i) {
        // cache values
        pi = points[i];
        p0 = pi[0];
        p1 = pi[1];
        p2 = pi[2];

        result[i] = [
            (m0 * p0) + (m4 * p1) + (m8 * p2) + m12,
            (m1 * p0) + (m5 * p1) + (m9 * p2) + m13,
            (m2 * p0) + (m6 * p1) + (m10 * p2) + m14,
            (m3 * p0) + (m7 * p1) + (m11 * p2) + m15
        ];
    }

    return result;
};

/** @private */
var SceneJS_math_transformVector3 = function(m, v) {
    var v0 = v[0], v1 = v[1], v2 = v[2];
    return [
        (m[0] * v0) + (m[4] * v1) + (m[8] * v2),
        (m[1] * v0) + (m[5] * v1) + (m[9] * v2),
        (m[2] * v0) + (m[6] * v1) + (m[10] * v2)
    ];
};

var SceneJS_math_transformVector4 = function(m, v) {
    var v0 = v[0], v1 = v[1], v2 = v[2], v3 = v[3];
    return [
        m[ 0] * v0 + m[ 4] * v1 + m[ 8] * v2 + m[12] * v3,
        m[ 1] * v0 + m[ 5] * v1 + m[ 9] * v2 + m[13] * v3,
        m[ 2] * v0 + m[ 6] * v1 + m[10] * v2 + m[14] * v3,
        m[ 3] * v0 + m[ 7] * v1 + m[11] * v2 + m[15] * v3
    ];
};

/** @private */
var SceneJS_math_projectVec4 = function(v) {
    var f = 1.0 / v[3];
    return [v[0] * f, v[1] * f, v[2] * f, 1.0];
};


/** @private */
var SceneJS_math_Plane3 = function (normal, offset, normalize) {
    this.normal = [0.0, 0.0, 1.0 ];

    this.offset = 0.0;
    if (normal && offset) {
        var normal0 = normal[0], normal1 = normal[1], normal2 = normal[2];
        this.offset = offset;

        if (normalize) {
            var s = Math.sqrt(
                    normal0 * normal0 +
                    normal1 * normal1 +
                    normal2 * normal2
                    );
            if (s > 0.0) {
                s = 1.0 / s;
                this.normal[0] = normal0 * s;
                this.normal[1] = normal1 * s;
                this.normal[2] = normal2 * s;
                this.offset *= s;
            }
        }
    }
};

/** @private */
var SceneJS_math_MAX_DOUBLE = Number.POSITIVE_INFINITY;
/** @private */
var SceneJS_math_MIN_DOUBLE = Number.NEGATIVE_INFINITY;

/** @private
 *
 */
var SceneJS_math_Box3 = function(min, max) {
    this.min = min || [ SceneJS_math_MAX_DOUBLE,SceneJS_math_MAX_DOUBLE,SceneJS_math_MAX_DOUBLE ];
    this.max = max || [ SceneJS_math_MIN_DOUBLE,SceneJS_math_MIN_DOUBLE,SceneJS_math_MIN_DOUBLE ];

    /** @private */
    this.init = function(min, max) {
        this.min[0] = min[0];
        this.min[1] = min[1];
        this.min[2] = min[2];
        this.max[0] = max[0];
        this.max[1] = max[1];
        this.max[2] = max[2];
        return this;
    };

    /** @private */
    this.fromPoints = function(points) {
        var pointsLength = points.length;

        for (var i = 0; i < pointsLength; ++i) {
            var points_i3 = points[i][3];
            var pDiv0 = points[i][0] / points_i3;
            var pDiv1 = points[i][1] / points_i3;
            var pDiv2 = points[i][2] / points_i3;

            if (pDiv0 < this.min[0]) {
                this.min[0] = pDiv0;
            }
            if (pDiv1 < this.min[1]) {
                this.min[1] = pDiv1;
            }
            if (pDiv2 < this.min[2]) {
                this.min[2] = pDiv2;
            }

            if (pDiv0 > this.max[0]) {
                this.max[0] = pDiv0;
            }
            if (pDiv1 > this.max[1]) {
                this.max[1] = pDiv1;
            }
            if (pDiv2 > this.max[2]) {
                this.max[2] = pDiv2;
            }
        }
        return this;
    };

    /** @private */
    this.isEmpty = function() {
        return (
                (this.min[0] >= this.max[0]) &&
                (this.min[1] >= this.max[1]) &&
                (this.min[2] >= this.max[2])
                );
    };

    /** @private */
    this.getCenter = function() {
        return [
            (this.max[0] + this.min[0]) / 2.0,
            (this.max[1] + this.min[1]) / 2.0,
            (this.max[2] + this.min[2]) / 2.0
        ];
    };

    /** @private */
    this.getSize = function() {
        return [
            (this.max[0] - this.min[0]),
            (this.max[1] - this.min[1]),
            (this.max[2] - this.min[2])
        ];
    };

    /** @private */
    this.getFacesAreas = function() {
        var s = this.size;
        return [
            (s[1] * s[2]),
            (s[0] * s[2]),
            (s[0] * s[1])
        ];
    };

    /** @private */
    this.getSurfaceArea = function() {
        var a = this.getFacesAreas();
        return ((a[0] + a[1] + a[2]) * 2.0);
    };

    /** @private */
    this.getVolume = function() {
        var s = this.size;
        return (s[0] * s[1] * s[2]);
    };

    /** @private */
    this.getOffset = function(half_delta) {
        this.min[0] -= half_delta;
        this.min[1] -= half_delta;
        this.min[2] -= half_delta;
        this.max[0] += half_delta;
        this.max[1] += half_delta;
        this.max[2] += half_delta;
        return this;
    };
};

/** @private
 *
 * @param min
 * @param max
 */
var SceneJS_math_AxisBox3 = function(min, max) {
    var min0 = min[0], min1 = min[1], min2 = min[2];
    var max0 = max[0], max1 = max[1], max2 = max[2];

    this.verts = [
        [min0, min1, min2],
        [max0, min1, min2],
        [max0, max1, min2],
        [min0, max1, min2],

        [min0, min1, max2],
        [max0, min1, max2],
        [max0, max1, max2],
        [min0, max1, max2]
    ];

    /** @private */
    this.toBox3 = function() {
        var box = new SceneJS_math_Box3();
        for (var i = 0; i < 8; ++i) {
            var v = this.verts[i];
            for (var j = 0; j < 3; ++j) {
                if (v[j] < box.min[j]) {
                    box.min[j] = v[j];
                }
                if (v[j] > box.max[j]) {
                    box.max[j] = v[j];
                }
            }
        }
    };
};

/** @private
 *
 * @param center
 * @param radius
 */
var SceneJS_math_Sphere3 = function(center, radius) {
    this.center = [center[0], center[1], center[2] ];
    this.radius = radius;

    /** @private */
    this.isEmpty = function() {
        return (this.radius === 0.0);
    };

    /** @private */
    this.surfaceArea = function() {
        return (4.0 * Math.PI * this.radius * this.radius);
    };

    /** @private */
    this.getVolume = function() {
        var thisRadius = this.radius;
        return ((4.0 / 3.0) * Math.PI * thisRadius * thisRadius * thisRadius);
    };
};

/** Creates billboard matrix from given view matrix
 * @private
 */
var SceneJS_math_billboardMat = function(viewMatrix) {
    var rotVec = [
        SceneJS_math_getColMat4(viewMatrix, 0),
        SceneJS_math_getColMat4(viewMatrix, 1),
        SceneJS_math_getColMat4(viewMatrix, 2)
    ];

    var scaleVec = [
        SceneJS_math_lenVec4(rotVec[0]),
        SceneJS_math_lenVec4(rotVec[1]),
        SceneJS_math_lenVec4(rotVec[2])
    ];

    var scaleVecRcp = SceneJS_math_mat4();
    SceneJS_math_rcpVec3(scaleVec, scaleVecRcp);
    var sMat = SceneJS_math_scalingMat4v(scaleVec);
    //var sMatInv = SceneJS_math_scalingMat4v(scaleVecRcp);

    SceneJS_math_mulVec4Scalar(rotVec[0], scaleVecRcp[0]);
    SceneJS_math_mulVec4Scalar(rotVec[1], scaleVecRcp[1]);
    SceneJS_math_mulVec4Scalar(rotVec[2], scaleVecRcp[2]);

    var rotMatInverse = SceneJS_math_identityMat4();

    SceneJS_math_setRowMat4(rotMatInverse, 0, rotVec[0]);
    SceneJS_math_setRowMat4(rotMatInverse, 1, rotVec[1]);
    SceneJS_math_setRowMat4(rotMatInverse, 2, rotVec[2]);

    //return rotMatInverse;
    //return SceneJS_math_mulMat4(sMatInv, SceneJS_math_mulMat4(rotMatInverse, sMat));
    return SceneJS_math_mulMat4(rotMatInverse, sMat);
    // return SceneJS_math_mulMat4(sMat, SceneJS_math_mulMat4(rotMatInverse, sMat));
    //return SceneJS_math_mulMat4(sMatInv, SceneJS_math_mulMat4(rotMatInverse, sMat));
};

/** @private */
var SceneJS_math_FrustumPlane = function(nx, ny, nz, offset) {
    var s = 1.0 / Math.sqrt(nx * nx + ny * ny + nz * nz);
    this.normal = [nx * s, ny * s, nz * s];
    this.offset = offset * s;
    this.testVertex = [
        (this.normal[0] >= 0.0) ? (1) : (0),
        (this.normal[1] >= 0.0) ? (1) : (0),
        (this.normal[2] >= 0.0) ? (1) : (0)];
};

/** @private */
var SceneJS_math_OUTSIDE_FRUSTUM = 3;
/** @private */
var SceneJS_math_INTERSECT_FRUSTUM = 4;
/** @private */
var SceneJS_math_INSIDE_FRUSTUM = 5;

/** @private */
var SceneJS_math_Frustum = function(viewMatrix, projectionMatrix, viewport) {
    var m = SceneJS_math_mat4();
    SceneJS_math_mulMat4(projectionMatrix, viewMatrix, m);

    // cache m indexes
    var m0 = m[0], m1 = m[1], m2 = m[2], m3 = m[3];
    var m4 = m[4], m5 = m[5], m6 = m[6], m7 = m[7];
    var m8 = m[8], m9 = m[9], m10 = m[10], m11 = m[11];
    var m12 = m[12], m13 = m[13], m14 = m[14], m15 = m[15];

    //var q = [ m[3], m[7], m[11] ]; just reuse m indexes instead of making new var
    var planes = [
        new SceneJS_math_FrustumPlane(m3 - m0, m7 - m4, m11 - m8, m15 - m12),
        new SceneJS_math_FrustumPlane(m3 + m0, m7 + m4, m11 + m8, m15 + m12),
        new SceneJS_math_FrustumPlane(m3 - m1, m7 - m5, m11 - m9, m15 - m13),
        new SceneJS_math_FrustumPlane(m3 + m1, m7 + m5, m11 + m9, m15 + m13),
        new SceneJS_math_FrustumPlane(m3 - m2, m7 - m6, m11 - m10, m15 - m14),
        new SceneJS_math_FrustumPlane(m3 + m2, m7 + m6, m11 + m10, m15 + m14)
    ];

    /* Resources for LOD
     */
    var rotVec = [
        SceneJS_math_getColMat4(viewMatrix, 0),
        SceneJS_math_getColMat4(viewMatrix, 1),
        SceneJS_math_getColMat4(viewMatrix, 2)
    ];

    var scaleVec = [
        SceneJS_math_lenVec4(rotVec[0]),
        SceneJS_math_lenVec4(rotVec[1]),
        SceneJS_math_lenVec4(rotVec[2])
    ];

    var scaleVecRcp = SceneJS_math_rcpVec3(scaleVec);
    var sMat = SceneJS_math_scalingMat4v(scaleVec);
    var sMatInv = SceneJS_math_scalingMat4v(scaleVecRcp);

    SceneJS_math_mulVec4Scalar(rotVec[0], scaleVecRcp[0]);
    SceneJS_math_mulVec4Scalar(rotVec[1], scaleVecRcp[1]);
    SceneJS_math_mulVec4Scalar(rotVec[2], scaleVecRcp[2]);

    var rotMatInverse = SceneJS_math_identityMat4();

    SceneJS_math_setRowMat4(rotMatInverse, 0, rotVec[0]);
    SceneJS_math_setRowMat4(rotMatInverse, 1, rotVec[1]);
    SceneJS_math_setRowMat4(rotMatInverse, 2, rotVec[2]);

    if (!this.matrix) {
        this.matrix = SceneJS_math_mat4();
    }
    SceneJS_math_mulMat4(projectionMatrix, viewMatrix, this.matrix);
    if (!this.billboardMatrix) {
        this.billboardMatrix = SceneJS_math_mat4();
    }
    SceneJS_math_mulMat4(sMatInv, SceneJS_math_mulMat4(rotMatInverse, sMat), this.billboardMatrix);
    this.viewport = viewport.slice(0, 4);

    /** @private */
    this.textAxisBoxIntersection = function(box) {
        var ret = SceneJS_math_INSIDE_FRUSTUM;
        var bminmax = [ box.min, box.max ];
        var plane = null;

        for (var i = 0; i < 6; ++i) {
            plane = planes[i];
            if (((plane.normal[0] * bminmax[plane.testVertex[0]][0]) +
                 (plane.normal[1] * bminmax[plane.testVertex[1]][1]) +
                 (plane.normal[2] * bminmax[plane.testVertex[2]][2]) +
                 (plane.offset)) < 0.0) {
                return SceneJS_math_OUTSIDE_FRUSTUM;
            }
            if (((plane.normal[0] * bminmax[1 - plane.testVertex[0]][0]) +
                 (plane.normal[1] * bminmax[1 - plane.testVertex[1]][1]) +
                 (plane.normal[2] * bminmax[1 - plane.testVertex[2]][2]) +
                 (plane.offset)) < 0.0) {
                ret = SceneJS_math_INTERSECT_FRUSTUM;
            }
        }
        return ret;
    };

    /** @private */
    this.getProjectedSize = function(box) {
        var diagVec = SceneJS_math_mat4();
        SceneJS_math_subVec3(box.max, box.min, diagVec);

        var diagSize = SceneJS_math_lenVec3(diagVec);

        var size = Math.abs(diagSize);

        var p0 = [
            (box.min[0] + box.max[0]) * 0.5,
            (box.min[1] + box.max[1]) * 0.5,
            (box.min[2] + box.max[2]) * 0.5,
            0.0];

        var halfSize = size * 0.5;
        var p1 = [ -halfSize, 0.0, 0.0, 1.0 ];
        var p2 = [  halfSize, 0.0, 0.0, 1.0 ];

        p1 = SceneJS_math_mulMat4v4(this.billboardMatrix, p1);
        p1 = SceneJS_math_addVec4(p1, p0);
        p1 = SceneJS_math_projectVec4(SceneJS_math_mulMat4v4(this.matrix, p1));

        p2 = SceneJS_math_mulMat4v4(this.billboardMatrix, p2);
        p2 = SceneJS_math_addVec4(p2, p0);
        p2 = SceneJS_math_projectVec4(SceneJS_math_mulMat4v4(this.matrix, p2));

        return viewport[2] * Math.abs(p2[0] - p1[0]);
    };


    this.getProjectedState = function(modelCoords) {
        var viewCoords = SceneJS_math_transformPoints3(this.matrix, modelCoords);

        //var canvasBox = {
        //    min: [10000000, 10000000 ],
        //    max: [-10000000, -10000000]
        //};
        // separate variables instead of indexing an array
        var canvasBoxMin0 = 10000000, canvasBoxMin1 = 10000000;
        var canvasBoxMax0 = -10000000, canvasBoxMax1 = -10000000;

        var v, x, y;

        var arrLen = viewCoords.length;
        for (var i = 0; i < arrLen; ++i) {
            v = SceneJS_math_projectVec4(viewCoords[i]);
            x = v[0];
            y = v[1];

            if (x < -0.5) {
                x = -0.5;
            }

            if (y < -0.5) {
                y = -0.5;
            }

            if (x > 0.5) {
                x = 0.5;
            }

            if (y > 0.5) {
                y = 0.5;
            }


            if (x < canvasBoxMin0) {
                canvasBoxMin0 = x;
            }
            if (y < canvasBoxMin1) {
                canvasBoxMin1 = y;
            }

            if (x > canvasBoxMax0) {
                canvasBoxMax0 = x;
            }
            if (y > canvasBoxMax1) {
                canvasBoxMax1 = y;
            }
        }

        canvasBoxMin0 += 0.5;
        canvasBoxMin1 += 0.5;
        canvasBoxMax0 += 0.5;
        canvasBoxMax1 += 0.5;

        // cache viewport indexes
        var viewport2 = viewport[2], viewport3 = viewport[3];

        canvasBoxMin0 = (canvasBoxMin0 * (viewport2 + 15));
        canvasBoxMin1 = (canvasBoxMin1 * (viewport3 + 15));
        canvasBoxMax0 = (canvasBoxMax0 * (viewport2 + 15));
        canvasBoxMax1 = (canvasBoxMax1 * (viewport3 + 15));

        var diagCanvasBoxVec = SceneJS_math_mat4();
        SceneJS_math_subVec2([canvasBoxMax0, canvasBoxMax1],
                [canvasBoxMin0, canvasBoxMin1],
                diagCanvasBoxVec);
        var diagCanvasBoxSize = SceneJS_math_lenVec2(diagCanvasBoxVec);

        if (canvasBoxMin0 < 0) {
            canvasBoxMin0 = 0;
        }
        if (canvasBoxMax0 > viewport2) {
            canvasBoxMax0 = viewport2;
        }

        if (canvasBoxMin1 < 0) {
            canvasBoxMin1 = 0;
        }
        if (canvasBoxMax1 > viewport3) {
            canvasBoxMax1 = viewport3;
        }
        return {
            canvasBox:  {
                min: [canvasBoxMin0, canvasBoxMin1 ],
                max: [canvasBoxMax0, canvasBoxMax1 ]
            },
            canvasSize: diagCanvasBoxSize
        };
    };
};

var SceneJS_math_identityQuaternion = function() {
    return [ 0.0, 0.0, 0.0, 1.0 ];
};

var SceneJS_math_angleAxisQuaternion = function(x, y, z, degrees) {
    var angleRad = (degrees / 180.0) * Math.PI;
    var halfAngle = angleRad / 2.0;
    var fsin = Math.sin(halfAngle);
    return [
        fsin * x,
        fsin * y,
        fsin * z,
        Math.cos(halfAngle)
    ];
};

var SceneJS_math_mulQuaternions = function(p, q) {
    var p0 = p[0], p1 = p[1], p2 = p[2], p3 = p[3];
    var q0 = q[0], q1 = q[1], q2 = q[2], q3 = q[3];
    return [
        p3 * q0 + p0 * q3 + p1 * q2 - p2 * q1,
        p3 * q1 + p1 * q3 + p2 * q0 - p0 * q2,
        p3 * q2 + p2 * q3 + p0 * q1 - p1 * q0,
        p3 * q3 - p0 * q0 - p1 * q1 - p2 * q2
    ];
};

var SceneJS_math_newMat4FromQuaternion = function(q) {
    var q0 = q[0], q1 = q[1], q2 = q[2], q3 = q[3];
    var tx = 2.0 * q0;
    var ty = 2.0 * q1;
    var tz = 2.0 * q2;
    var twx = tx * q3;
    var twy = ty * q3;
    var twz = tz * q3;
    var txx = tx * q0;
    var txy = ty * q0;
    var txz = tz * q0;
    var tyy = ty * q1;
    var tyz = tz * q1;
    var tzz = tz * q2;
    var m = SceneJS_math_identityMat4();
    SceneJS_math_setCellMat4(m, 0, 0, 1.0 - (tyy + tzz));
    SceneJS_math_setCellMat4(m, 0, 1, txy - twz);
    SceneJS_math_setCellMat4(m, 0, 2, txz + twy);
    SceneJS_math_setCellMat4(m, 1, 0, txy + twz);
    SceneJS_math_setCellMat4(m, 1, 1, 1.0 - (txx + tzz));
    SceneJS_math_setCellMat4(m, 1, 2, tyz - twx);
    SceneJS_math_setCellMat4(m, 2, 0, txz - twy);
    SceneJS_math_setCellMat4(m, 2, 1, tyz + twx);
    SceneJS_math_setCellMat4(m, 2, 2, 1.0 - (txx + tyy));
    return m;
};


//var SceneJS_math_slerp(t, q1, q2) {
//    var result = SceneJS_math_identityQuaternion();
//    var cosHalfAngle = q1[3] * q2[3] + q1[0] * q2[0] + q1[1] * q2[1] + q1[2] * q2[2];
//    if (Math.abs(cosHalfAngle) >= 1) {
//        return [ q1[0],q1[1], q1[2], q1[3] ];
//    } else {
//        var halfAngle = Math.acos(cosHalfAngle);
//        var sinHalfAngle = Math.sqrt(1 - cosHalfAngle * cosHalfAngle);
//        if (Math.abs(sinHalfAngle) < 0.001) {
//            return [
//                q1[0] * 0.5 + q2[0] * 0.5,
//                q1[1] * 0.5 + q2[1] * 0.5,
//                q1[2] * 0.5 + q2[2] * 0.5,
//                q1[3] * 0.5 + q2[3] * 0.5
//            ];
//        } else {
//            var a = Math.sin((1 - t) * halfAngle) / sinHalfAngle;
//            var b = Math.sin(t * halfAngle) / sinHalfAngle;
//            return [
//                q1[0] * a + q2[0] * b,
//                q1[1] * a + q2[1] * b,
//                q1[2] * a + q2[2] * b,
//                q1[3] * a + q2[3] * b
//            ];
//        }
//    }
//}

var SceneJS_math_slerp = function(t, q1, q2) {
    //var result = SceneJS_math_identityQuaternion();
    var q13 = q1[3] * 0.0174532925;
    var q23 = q2[3] * 0.0174532925;
    var cosHalfAngle = q13 * q23 + q1[0] * q2[0] + q1[1] * q2[1] + q1[2] * q2[2];
    if (Math.abs(cosHalfAngle) >= 1) {
        return [ q1[0],q1[1], q1[2], q1[3] ];
    } else {
        var halfAngle = Math.acos(cosHalfAngle);
        var sinHalfAngle = Math.sqrt(1 - cosHalfAngle * cosHalfAngle);
        if (Math.abs(sinHalfAngle) < 0.001) {
            return [
                q1[0] * 0.5 + q2[0] * 0.5,
                q1[1] * 0.5 + q2[1] * 0.5,
                q1[2] * 0.5 + q2[2] * 0.5,
                q1[3] * 0.5 + q2[3] * 0.5
            ];
        } else {
            var a = Math.sin((1 - t) * halfAngle) / sinHalfAngle;
            var b = Math.sin(t * halfAngle) / sinHalfAngle;
            return [
                q1[0] * a + q2[0] * b,
                q1[1] * a + q2[1] * b,
                q1[2] * a + q2[2] * b,
                (q13 * a + q23 * b) * 57.295779579
            ];
        }
    }
};

var SceneJS_math_normalizeQuaternion = function(q) {
    var len = SceneJS_math_lenVec4([q[0], q[1], q[2], q[3]]);
    return [ q[0] / len, q[1] / len, q[2] / len, q[3] / len ];
};

var SceneJS_math_conjugateQuaternion = function(q) {
    return[-q[0],-q[1],-q[2],q[3]];
};

var SceneJS_math_angleAxisFromQuaternion = function(q) {
    q = SceneJS_math_normalizeQuaternion(q);
    var q3 = q[3];
    var angle = 2 * Math.acos(q3);
    var s = Math.sqrt(1 - q3 * q3);
    if (s < 0.001) { // test to avoid divide by zero, s is always positive due to sqrt
        return {
            x : q[0],
            y : q[1],
            z : q[2],
            angle: angle * 57.295779579
        };
    } else {
        return {
            x : q[0] / s,
            y : q[1] / s,
            z : q[2] / s,
            angle: angle * 57.295779579
        };
    }
};
/** Maps SceneJS node parameter names to WebGL enum names
 * @private
 */
var SceneJS_webgl_enumMap = {
    funcAdd:"FUNC_ADD",
    funcSubtract:"FUNC_SUBTRACT",
    funcReverseSubtract:"FUNC_REVERSE_SUBTRACT",
    zero:"ZERO",
    one:"ONE",
    srcColor:"SRC_COLOR",
    oneMinusSrcColor:"ONE_MINUS_SRC_COLOR",
    dstColor:"DST_COLOR",
    oneMinusDstColor:"ONE_MINUS_DST_COLOR",
    srcAlpha:"SRC_ALPHA",
    oneMinusSrcAlpha:"ONE_MINUS_SRC_ALPHA",
    dstAlpha:"DST_ALPHA",
    oneMinusDstAlpha:"ONE_MINUS_DST_ALPHA",
    contantColor:"CONSTANT_COLOR",
    oneMinusConstantColor:"ONE_MINUS_CONSTANT_COLOR",
    constantAlpha:"CONSTANT_ALPHA",
    oneMinusConstantAlpha:"ONE_MINUS_CONSTANT_ALPHA",
    srcAlphaSaturate:"SRC_ALPHA_SATURATE",
    front:"FRONT",
    back:"BACK",
    frontAndBack:"FRONT_AND_BACK",
    never:"NEVER",
    less:"LESS",
    equal:"EQUAL",
    lequal:"LEQUAL",
    greater:"GREATER",
    notequal:"NOTEQUAL",
    gequal:"GEQUAL",
    always:"ALWAYS",
    cw:"CW",
    ccw:"CCW",
    linear:"LINEAR",
    nearest:"NEAREST",
    linearMipMapNearest:"LINEAR_MIPMAP_NEAREST",
    nearestMipMapNearest:"NEAREST_MIPMAP_NEAREST",
    nearestMipMapLinear:"NEAREST_MIPMAP_LINEAR",
    linearMipMapLinear:"LINEAR_MIPMAP_LINEAR",
    repeat:"REPEAT",
    clampToEdge:"CLAMP_TO_EDGE",
    mirroredRepeat:"MIRRORED_REPEAT",
    alpha:"ALPHA",
    rgb:"RGB",
    rgba:"RGBA",
    luminance:"LUMINANCE",
    luminanceAlpha:"LUMINANCE_ALPHA",
    textureBinding2D:"TEXTURE_BINDING_2D",
    textureBindingCubeMap:"TEXTURE_BINDING_CUBE_MAP",
    compareRToTexture:"COMPARE_R_TO_TEXTURE", // Hardware Shadowing Z-depth,
    unsignedByte:"UNSIGNED_BYTE"
};

var SceneJS_webgl_ProgramUniform = function (gl, program, name, type, size, location, logging) {

    var func = null;
    if (type == gl.BOOL) {
        func = function (v) {
            gl.uniform1i(location, v);
        };
    } else if (type == gl.BOOL_VEC2) {
        func = function (v) {
            gl.uniform2iv(location, v);
        };
    } else if (type == gl.BOOL_VEC3) {
        func = function (v) {
            gl.uniform3iv(location, v);
        };
    } else if (type == gl.BOOL_VEC4) {
        func = function (v) {
            gl.uniform4iv(location, v);
        };
    } else if (type == gl.INT) {
        func = function (v) {
            gl.uniform1iv(location, v);
        };
    } else if (type == gl.INT_VEC2) {
        func = function (v) {
            gl.uniform2iv(location, v);
        };
    } else if (type == gl.INT_VEC3) {
        func = function (v) {
            gl.uniform3iv(location, v);
        };
    } else if (type == gl.INT_VEC4) {
        func = function (v) {
            gl.uniform4iv(location, v);
        };
    } else if (type == gl.FLOAT) {
        func = function (v) {
            gl.uniform1f(location, v);
        };
    } else if (type == gl.FLOAT_VEC2) {
        func = function (v) {
            gl.uniform2fv(location, v);
        };
    } else if (type == gl.FLOAT_VEC3) {
        func = function (v) {
            gl.uniform3fv(location, v);
        };
    } else if (type == gl.FLOAT_VEC4) {
        func = function (v) {
            gl.uniform4fv(location, v);
        };
    } else if (type == gl.FLOAT_MAT2) {
        func = function (v) {
            gl.uniformMatrix2fv(location, gl.FALSE, v);
        };
    } else if (type == gl.FLOAT_MAT3) {
        func = function (v) {
            gl.uniformMatrix3fv(location, gl.FALSE, v);
        };
    } else if (type == gl.FLOAT_MAT4) {
        func = function (v) {
            gl.uniformMatrix4fv(location, gl.FALSE, v);
        };
    } else {
        throw "Unsupported shader uniform type: " + type;
    }

    this.setValue = func;


    this.getValue = function () {
        return gl.getUniform(program, location);
    };

    this.getLocation = function () {
        return location;
    };
};

var SceneJS_webgl_ProgramSampler = function (gl, program, name, type, size, location) {
    this.bindTexture = function (texture, unit) {
        if (texture.bind(unit)) {
            gl.uniform1i(location, unit);
            return true;
        }
        return false;
    };
};

/** An attribute within a shader
 */
var SceneJS_webgl_ProgramAttribute = function (gl, program, name, type, size, location) {
    this.bindFloatArrayBuffer = function (buffer) {
        if (buffer) {
            buffer.bind();
            gl.enableVertexAttribArray(location);
            gl.vertexAttribPointer(location, buffer.itemSize, gl.FLOAT, false, 0, 0);   // Vertices are not homogeneous - no w-element
        }
    };

};

/**
 * A vertex/fragment shader in a program
 *
 * @private
 * @param gl WebGL gl
 * @param gl.VERTEX_SHADER | gl.FRAGMENT_SHADER
 * @param source Source code for shader
 * @param logging Shader will write logging's debug channel as it compiles
 */
var SceneJS_webgl_Shader = function (gl, type, source) {

    this.handle = gl.createShader(type);

    gl.shaderSource(this.handle, source);
    gl.compileShader(this.handle);

    this.valid = (gl.getShaderParameter(this.handle, gl.COMPILE_STATUS) != 0);

    if (!this.valid) {

        if (!gl.isContextLost()) { // Handled explicitely elsewhere, so wont rehandle here

            SceneJS.log.error("Shader program failed to compile: " + gl.getShaderInfoLog(this.handle));
            SceneJS.log.error("Shader source:");
            var lines = source.split('\n');
            for (var j = 0; j < lines.length; j++) {
                SceneJS.log.error(lines[j]);
            }

            throw SceneJS_error.fatalError(
                SceneJS.errors.SHADER_COMPILATION_FAILURE, "Shader program failed to compile");
        }
    }
};

/**
 * @class Wrapper for a WebGL program
 *
 * @param hash SceneJS-managed ID for program
 * @param gl WebGL gl
 * @param vertexSources Source codes for vertex shaders
 * @param fragmentSources Source codes for fragment shaders
 * @param logging Program and shaders will write to logging's debug channel as they compile and link
 */
var SceneJS_webgl_Program = function (gl, vertexSources, fragmentSources) {

    var a, i, u, u_name, location, shader;

    this._uniforms = {};
    this._samplers = {};
    this._attributes = {};

    /* Create shaders from sources
     */
    this._shaders = [];
    for (i = 0; i < vertexSources.length; i++) {
        this._shaders.push(new SceneJS_webgl_Shader(gl, gl.VERTEX_SHADER, vertexSources[i]));
    }
    for (i = 0; i < fragmentSources.length; i++) {
        this._shaders.push(new SceneJS_webgl_Shader(gl, gl.FRAGMENT_SHADER, fragmentSources[i]));
    }

    /* Create program, attach shaders, link and validate program
     */
    var handle = gl.createProgram();

    for (i = 0; i < this._shaders.length; i++) {
        shader = this._shaders[i];
        if (shader.valid) {
            gl.attachShader(handle, shader.handle);
        }
    }
    gl.linkProgram(handle);

    this.valid = (gl.getProgramParameter(handle, gl.LINK_STATUS) != 0);

    var debugCfg = SceneJS_configsModule.getConfigs("shading");
    if (debugCfg.validate !== false) {
        gl.validateProgram(handle);
        this.valid = this.valid && (gl.getProgramParameter(handle, gl.VALIDATE_STATUS) != 0);
    }

    if (!this.valid) {

        if (!gl.isContextLost()) { // Handled explicitely elsewhere, so wont rehandle here

            SceneJS.log.error("Shader program failed to link: " + gl.getProgramInfoLog(handle));

            SceneJS.log.error("Vertex shader(s):");
            for (i = 0; i < vertexSources.length; i++) {
                SceneJS.log.error("Vertex shader #" + i + ":");
                var lines = vertexSources[i].split('\n');
                for (var j = 0; j < lines.length; j++) {
                    SceneJS.log.error(lines[j]);

                }
            }

            SceneJS.log.error("Fragment shader(s):");
            for (i = 0; i < fragmentSources.length; i++) {
                SceneJS.log.error("Fragment shader #" + i + ":");
                var lines = fragmentSources[i].split('\n');
                for (var j = 0; j < lines.length; j++) {
                    SceneJS.log.error(lines[j]);
                }
            }

            throw SceneJS_error.fatalError(
                SceneJS.errors.SHADER_LINK_FAILURE, "Shader program failed to link");
        }
    }

    /* Discover active uniforms and samplers
     */

    var numUniforms = gl.getProgramParameter(handle, gl.ACTIVE_UNIFORMS);

    for (i = 0; i < numUniforms; ++i) {
        u = gl.getActiveUniform(handle, i);
        if (u) {
            u_name = u.name;
            if (u_name[u_name.length - 1] == "\u0000") {
                u_name = u_name.substr(0, u_name.length - 1);
            }
            location = gl.getUniformLocation(handle, u_name);
            if ((u.type == gl.SAMPLER_2D) || (u.type == gl.SAMPLER_CUBE) || (u.type == 35682)) {

                this._samplers[u_name] = new SceneJS_webgl_ProgramSampler(
                    gl,
                    handle,
                    u_name,
                    u.type,
                    u.size,
                    location);
            } else {
                this._uniforms[u_name] = new SceneJS_webgl_ProgramUniform(
                    gl,
                    handle,
                    u_name,
                    u.type,
                    u.size,
                    location);
            }
        }
    }

    /* Discover attributes
     */

    var numAttribs = gl.getProgramParameter(handle, gl.ACTIVE_ATTRIBUTES);
    for (i = 0; i < numAttribs; i++) {
        a = gl.getActiveAttrib(handle, i);
        if (a) {
            location = gl.getAttribLocation(handle, a.name);
            this._attributes[a.name] = new SceneJS_webgl_ProgramAttribute(
                gl,
                handle,
                a.name,
                a.type,
                a.size,
                location);
        }
    }

    this.setProfile = function (profile) {
        this._profile = profile;
    };

    this.bind = function () {
        gl.useProgram(handle);
        if (this._profile) {
            this._profile.program++;
        }
    };

    this.getUniformLocation = function (name) {
        var u = this._uniforms[name];
        if (u) {
            return u.getLocation();
        } else {
            // SceneJS.log.warn("Uniform not found in shader : " + name);
        }
    };

    this.getUniform = function (name) {
        var u = this._uniforms[name];
        if (u) {
            return u;
        } else {
            //      SceneJS.log.warn("Shader uniform load failed - uniform not found in shader : " + name);
        }
    };

    this.setUniform = function (name, value) {
        var u = this._uniforms[name];
        if (u) {
            u.setValue(value);
            if (this._profile) {
                this._profile.uniform++;
            }
        } else {
            //      SceneJS.log.warn("Shader uniform load failed - uniform not found in shader : " + name);
        }
    };

    this.getAttribute = function (name) {
        var attr = this._attributes[name];
        if (attr) {
            return attr;
        } else {
            //  logging.warn("Shader attribute bind failed - attribute not found in shader : " + name);
        }
    };

    this.bindFloatArrayBuffer = function (name, buffer) {
        var attr = this._attributes[name];
        if (attr) {
            attr.bindFloatArrayBuffer(buffer);
            if (this._profile) {
                this._profile.varying++;
            }
        } else {
            //  logging.warn("Shader attribute bind failed - attribute not found in shader : " + name);
        }
    };

    this.bindTexture = function (name, texture, unit) {
        var sampler = this._samplers[name];
        if (sampler) {
            if (this._profile) {
                this._profile.texture++;
            }
            return sampler.bindTexture(texture, unit);
        } else {
            return false;
        }
    };

    this.unbind = function () {
        //     gl.useProgram(0);
    };

    this.destroy = function () {

        if (this.valid) {

            //   SceneJS.log.debug("Destroying shader program: '" + hash + "'");
            gl.deleteProgram(handle);
            for (var s in this._shaders) {
                gl.deleteShader(this._shaders[s].handle);
            }
            this._attributes = null;
            this._uniforms = null;
            this._samplers = null;
            this.valid = false;
        }
    };
};

var SceneJS_webgl_Texture2D = function (gl, cfg) {

    this.target = gl.TEXTURE_2D;
    this.minFilter = cfg.minFilter;
    this.magFilter = cfg.magFilter;
    this.wrapS = cfg.wrapS;
    this.wrapT = cfg.wrapT;
    this.update = cfg.update;  // For dynamically-sourcing textures (ie movies etc)
    this.texture = cfg.texture;
    this.format = gl.RGBA;
    this.isDepth = false;
    this.depthMode = 0;
    this.depthCompareMode = 0;
    this.depthCompareFunc = 0;

    try {
        gl.bindTexture(this.target, this.texture);

        if (cfg.minFilter) {
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, cfg.minFilter);
        }

        if (cfg.magFilter) {
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, cfg.magFilter);
        }

        if (cfg.wrapS) {
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, cfg.wrapS);
        }

        if (cfg.wrapT) {
            gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, cfg.wrapT);
        }

        if (cfg.minFilter == gl.NEAREST_MIPMAP_NEAREST ||
            cfg.minFilter == gl.LINEAR_MIPMAP_NEAREST ||
            cfg.minFilter == gl.NEAREST_MIPMAP_LINEAR ||
            cfg.minFilter == gl.LINEAR_MIPMAP_LINEAR) {
            gl.generateMipmap(gl.TEXTURE_2D);
        }

        gl.bindTexture(this.target, null);

    } catch (e) {
        throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Failed to create texture: " + e.message || e);
    }

    this.bind = function (unit) {
        if (this.texture) {
            gl.activeTexture(gl["TEXTURE" + unit]);
            gl.bindTexture(this.target, this.texture);
            if (this.update) {
                this.update(gl);
            }
            return true;
        }
        return false;
    };

    this.unbind = function (unit) {
        if (this.texture) {
            gl.activeTexture(gl["TEXTURE" + unit]);
            gl.bindTexture(this.target, null);
        }
    };

    this.destroy = function () {
        if (this.texture) {
            gl.deleteTexture(this.texture);
            this.texture = null;
        }
    };
};


function SceneJS_webgl_ensureImageSizePowerOfTwo(image) {
    if (!SceneJS_webgl_isPowerOfTwo(image.width) || !SceneJS_webgl_isPowerOfTwo(image.height)) {
        var canvas = document.createElement("canvas");
        canvas.width = SceneJS_webgl_nextHighestPowerOfTwo(image.width);
        canvas.height = SceneJS_webgl_nextHighestPowerOfTwo(image.height);
        var ctx = canvas.getContext("2d");
        ctx.drawImage(image,
            0, 0, image.width, image.height,
            0, 0, canvas.width, canvas.height);
        image = canvas;
    }
    return image;
}

function SceneJS_webgl_isPowerOfTwo(x) {
    return (x & (x - 1)) == 0;
}

function SceneJS_webgl_nextHighestPowerOfTwo(x) {
    --x;
    for (var i = 1; i < 32; i <<= 1) {
        x = x | x >> i;
    }
    return x + 1;
}

/** Buffer for vertices and indices
 *
 * @private
 * @param gl  WebGL gl
 * @param type     Eg. ARRAY_BUFFER, ELEMENT_ARRAY_BUFFER
 * @param values   WebGL array wrapper
 * @param numItems Count of items in array wrapper
 * @param itemSize Size of each item
 * @param usage    Eg. STATIC_DRAW
 */

var SceneJS_webgl_ArrayBuffer = function (gl, type, values, numItems, itemSize, usage) {


    this.type = type;
    this.itemSize = itemSize;

    this._allocate = function (values, numItems) {
        this.handle = gl.createBuffer();
        this.handle.numItems = numItems;
        this.handle.itemSize = itemSize;
        gl.bindBuffer(type, this.handle);
        gl.bufferData(type, values, usage);
        this.handle.numItems = numItems;
        gl.bindBuffer(type, null);
        this.numItems = numItems;
        this.length = values.length;
    };

    this._allocate(values, numItems);

    this.bind = function () {
        gl.bindBuffer(type, this.handle);
    };

    this.setData = function (data, offset) {

        if (data.length > this.length) {
            this.destroy();
            this._allocate(data, data.length);

        } else {

            if (offset || offset === 0) {
                gl.bufferSubData(type, offset, data);
            } else {
                gl.bufferData(type, data);
            }
        }
    };

    this.unbind = function () {
        gl.bindBuffer(type, null);
    };

    this.destroy = function () {
        gl.deleteBuffer(this.handle);
    };
};


var SceneJS_PickBuffer = function (cfg) {

    var canvas = cfg.canvas;
    var gl = canvas.gl;

    var pickBuf;
    var bound = false;

    /**
     * Called when WebGL context restored
     */
    this.webglRestored = function (_gl) {
        gl = _gl;
        pickBuf = null;
    };

    this._touch = function () {

        var width = canvas.canvas.width;
        var height = canvas.canvas.height;

        if (pickBuf) { // Currently have a pick buffer
            if (pickBuf.width == width && pickBuf.height == height) { // Canvas size unchanged, buffer still good
                return;
            } else { // Buffer needs reallocation for new canvas size

                gl.deleteTexture(pickBuf.texture);
                gl.deleteFramebuffer(pickBuf.framebuf);
                gl.deleteRenderbuffer(pickBuf.renderbuf);
            }
        }

        pickBuf = {
            framebuf:gl.createFramebuffer(),
            renderbuf:gl.createRenderbuffer(),
            texture:gl.createTexture(),
            width:width,
            height:height
        };

        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);

        gl.bindTexture(gl.TEXTURE_2D, pickBuf.texture);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);

        try {
            // Do it the way the spec requires
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, null);
        } catch (exception) {
            // Workaround for what appears to be a Minefield bug.
            var textureStorage = new WebGLUnsignedByteArray(width * height * 3);
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, textureStorage);
        }
        gl.bindRenderbuffer(gl.RENDERBUFFER, pickBuf.renderbuf);
        gl.renderbufferStorage(gl.RENDERBUFFER, gl.DEPTH_COMPONENT16, width, height);
        gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, pickBuf.texture, 0);
        gl.framebufferRenderbuffer(gl.FRAMEBUFFER, gl.DEPTH_ATTACHMENT, gl.RENDERBUFFER, pickBuf.renderbuf);
        gl.bindTexture(gl.TEXTURE_2D, null);
        gl.bindRenderbuffer(gl.RENDERBUFFER, null);
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);

        /* Verify framebuffer is OK
         */
        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);
        if (!gl.isFramebuffer(pickBuf.framebuf)) {
            throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Invalid framebuffer");
        }
        var status = gl.checkFramebufferStatus(gl.FRAMEBUFFER);
        switch (status) {
            case gl.FRAMEBUFFER_COMPLETE:
                break;
            case gl.FRAMEBUFFER_INCOMPLETE_ATTACHMENT:
                throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT:
                throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_DIMENSIONS:
                throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
            case gl.FRAMEBUFFER_UNSUPPORTED:
                throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Incomplete framebuffer: FRAMEBUFFER_UNSUPPORTED");
            default:
                throw SceneJS_error.fatalError(SceneJS.errors.ERROR, "Incomplete framebuffer: " + status);
        }

        bound = false;
    };

    this.bind = function () {

        this._touch();

        if (bound) {
            return;
        }

        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);

        bound = true;
    };

    this.clear = function () {

        if (!bound) {
            throw "Pick buffer not bound";
        }

        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        gl.disable(gl.BLEND);
    };


    /** Reads pick buffer pixel at given coordinates, returns index of associated object else (-1)
     */
    this.read = function (pickX, pickY) {
        var x = pickX;
        var y = canvas.canvas.height - pickY;
        var pix = new Uint8Array(4);
        gl.readPixels(x, y, 1, 1, gl.RGBA, gl.UNSIGNED_BYTE, pix);
        return pix;
    };

    this.unbind = function () {
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);
        bound = false;
    };
};

var SceneJS_PickBufferOLD = function (cfg) {

    var canvas = cfg.canvas;
    var gl = cfg.canvas.gl;

    var pickBuf;
    this.bound = false;

    /**
     * Initialises the pick buffer
     * @param _gl WebGL context
     */
    this.init = function (_gl) {

        gl = _gl;
        pickBuf = null;

        var width = canvas.canvas.width;
        var height = canvas.canvas.height;

        if (pickBuf) { // Currently have a pick buffer

            if (pickBuf.width == width && pickBuf.height == height) { // Canvas size unchanged, buffer still good
                return;

            } else { // Buffer needs reallocation for new canvas size

                gl.deleteTexture(pickBuf.texture);
                gl.deleteFramebuffer(pickBuf.framebuf);
                gl.deleteRenderbuffer(pickBuf.renderbuf);
            }
        }

        pickBuf = {
            framebuf:gl.createFramebuffer(),
            renderbuf:gl.createRenderbuffer(),
            texture:gl.createTexture(),
            width:width,
            height:height
        };

        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);

        gl.bindTexture(gl.TEXTURE_2D, pickBuf.texture);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);

        try {
            // Do it the way the spec requires
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, null);
        } catch (exception) {
            // Workaround for what appears to be a Minefield bug.
            var textureStorage = new WebGLUnsignedByteArray(width * height * 3);
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, textureStorage);
        }

        gl.bindRenderbuffer(gl.RENDERBUFFER, pickBuf.renderbuf);
        gl.renderbufferStorage(gl.RENDERBUFFER, gl.DEPTH_COMPONENT16, width, height);
        gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, pickBuf.texture, 0);
        gl.framebufferRenderbuffer(gl.FRAMEBUFFER, gl.DEPTH_ATTACHMENT, gl.RENDERBUFFER, pickBuf.renderbuf);

        gl.bindTexture(gl.TEXTURE_2D, null);
        gl.bindRenderbuffer(gl.RENDERBUFFER, null);
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);

        /* Verify framebuffer is OK
         */
        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);
        if (!gl.isFramebuffer(pickBuf.framebuf)) {
            throw  SceneJS_error.fatalError("Invalid framebuffer");
        }

        var status = gl.checkFramebufferStatus(gl.FRAMEBUFFER);

        switch (status) {
            case gl.FRAMEBUFFER_COMPLETE:
                break;
            case gl.FRAMEBUFFER_INCOMPLETE_ATTACHMENT:
                throw  SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT:
                throw  SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_DIMENSIONS:
                throw  SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
            case gl.FRAMEBUFFER_UNSUPPORTED:
                throw  SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_UNSUPPORTED");
            default:
                throw  SceneJS_error.fatalError("Incomplete framebuffer: " + status);
        }

        this.bound = false;
    };

    this.bind = function () {
        if (this.bound) {
            return;
        }
        gl.bindFramebuffer(gl.FRAMEBUFFER, pickBuf.framebuf);
        this.bound = true;
    };

    this.clear = function () {
        if (this.bound) {
            return;
        }
        gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
        gl.disable(gl.BLEND);
    };


    /** Reads pick buffer pixel at given coordinates, returns index of associated object else (-1)
     */
    this.read = function (pickX, pickY) {
        var x = pickX;
        var y = canvas.canvas.height - pickY;
        var pix = new Uint8Array(4);
        gl.readPixels(x, y, 1, 1, gl.RGBA, gl.UNSIGNED_BYTE, pix);
        return pix;
    };

    this.unbind = function () {
        if (this.bound) {
            return;
        }
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);
        this.bound = false;
    };

    this.init(cfg.canvas.gl);
};
/**
 * Backend that tracks statistics on loading states of nodes during scene traversal.
 *
 * This supports the "loading-status" events that we can listen for on scene nodes.
 *
 * When a node with that listener is pre-visited, it will call getStatus on this module to
 * save a copy of the status. Then when it is post-visited, it will call diffStatus on this
 * module to find the status for its sub-nodes, which it then reports through the "loading-status" event.
 *
 * @private
 */
var SceneJS_sceneStatusModule = new (function () {

    // Public activity summary
    this.sceneStatus = {};

    // IDs of all tasks
    var taskIds = new SceneJS_Map();
    var tasks = {};

    var sceneStates = {};

    var self = this;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_DESTROYED,
        function (params) {
            var sceneId = params.engine.id;
            delete self.sceneStatus[sceneId];
            delete sceneStates[sceneId];
        });

    /** Notifies that a node has begun loading some data
     */
    this.taskStarted = function (node, description) {
        if (false === SceneJS_configsModule.configs.statusPopups) {
            return -1;
        }
        var scene = node.getScene();
        var sceneId = scene.getId();
        var nodeId = node.getId();
        var canvas = scene.getCanvas();

        var taskId = taskIds.addItem();

        // Update public info
        var status = this.sceneStatus[sceneId];
        if (!status) {
            status = this.sceneStatus[sceneId] = {
                numTasks:0
            };
        }
        status.numTasks++;

        // Track node
        var sceneState = sceneStates[sceneId];
        if (!sceneState) {
            sceneState = sceneStates[sceneId] = {
                sceneId:sceneId,
                nodeStates:{},
                scene:scene,
                popupContainer:createPopupContainer(canvas),
                descCounts:{}
            };
        }
        var descCount = sceneState.descCounts[description];
        if (descCount == undefined) {
            descCount = sceneState.descCounts[description] = 0;
        }
        sceneState.descCounts[description]++;
        var nodeState = sceneState.nodeStates[nodeId];
        if (!nodeState) {
            nodeState = sceneState.nodeStates[nodeId] = {
                nodeId:nodeId,
                numTasks:0,
                tasks:{}
            };
        }
        description = description + " " + sceneState.descCounts[description] + "...";
        nodeState.numTasks++;
        var task = {
            sceneState:sceneState,
            nodeState:nodeState,
            description:description,
            element:createPopup(sceneState.popupContainer, description)
        };
        nodeState.tasks[taskId] = task;
        tasks[taskId] = task;
        return taskId;
    };

    function createPopupContainer(canvas) {
        var body = document.getElementsByTagName("body")[0];
        var div = document.createElement('div');
        var style = div.style;
        style.position = "absolute";
        style.width = "200px";
        style.right = "10px";
        style.top = "0";
        style.padding = "10px";
        style["z-index"] = "10000";
        body.appendChild(div);
        return div;
    }

    function createPopup(popupContainer, description) {
        var div = document.createElement('div');
        var style = div.style;
        style["font-family"] = "Helvetica";
        style["font-size"] = "14px";
        style.padding = "5px";
        style.margin = "4px";
        style["padding-left"] = "12px";
        style["border"] = "1px solid #000055";
        style.color = "black";
        style.background = "#AAAAAA";
        style.opacity = "0.8";
        style["border-radius"] = "3px";
        style["-moz-border-radius"] = "3px";
        style["box-shadow"] = "3px 3px 3px #444444";
        div.innerHTML = description;
        popupContainer.appendChild(div);
        return div;
    }

    /** Notifies that a load has finished loading some data
     */
    this.taskFinished = function (taskId) {
        if (taskId == -1 || taskId == null) {
            return null;
        }
        var task = tasks[taskId];
        if (!task) {
            return null;
        }
        var sceneState = task.sceneState;
        this.sceneStatus[sceneState.sceneId].numTasks--;
        dismissPopup(task.element);
        var nodeState = task.nodeState;
        nodeState.numTasks--;
        delete nodeState.tasks[taskId];
        if (nodeState.numTasks == 0) {
            delete sceneState.nodeStates[nodeState.nodeId];
        }
        return null;
    };

    function dismissPopup(element) {
        element.style.background = "#AAFFAA";
        var opacity = 0.8;
        var interval = setInterval(function () {
            if (opacity <= 0) {
                element.parentNode.removeChild(element);
                clearInterval(interval);
            } else {
                element.style.opacity = opacity;
                opacity -= 0.1;
            }
        }, 100);
    }

    /** Notifies that a task has failed
     */
    this.taskFailed = function (taskId) {
        if (taskId == -1 || taskId == null) {
            return null;
        }
        var task = tasks[taskId];
        if (!task) {
            return null;
        }
        failPopup(task.element);
        return null;
    };

    function failPopup(element) {
        element.style.background = "#FFAAAA";
    }
})();

/**
 * Manages scene node event listeners
 * @private
 */
var SceneJS_nodeEventsModule = new (function () {

    var idStack = [];
    var listenerStack = [];
    var stackLen = 0;
    var dirty;

    var defaultCore = {
        type:"listeners",
        stateId:SceneJS._baseStateId++,
        empty:true,
        listeners:[]
    };

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function () {
            stackLen = 0;
            dirty = true;
        });

    SceneJS_events.addListener(
        SceneJS_events.OBJECT_COMPILING,
        function (params) {
            if (dirty) {
                if (stackLen > 0) {
                    var core = {
                        type:"listeners",
                        stateId:idStack[stackLen - 1],
                        listeners:listenerStack.slice(0, stackLen)
                    };
                    params.display.renderListeners = core;
                } else {
                    params.display.renderListeners = defaultCore;
                }
                dirty = false;
            }
        });


    this.preVisitNode = function (node) {

        var renderedSubs = node._topicSubs["rendered"]; // DEPRECATED in V3.2
        var worldPosSubs = node._topicSubs["worldPos"];
        var viewPosSubs = node._topicSubs["viewPos"];
        var cameraPosSubs = node._topicSubs["cameraPos"];
        var projPosSubs = node._topicSubs["projPos"];
        var canvasPosSubs = node._topicSubs["canvasPos"];

        if (renderedSubs || worldPosSubs || viewPosSubs || cameraPosSubs || projPosSubs || canvasPosSubs) {
            idStack[stackLen] = node.id;

            listenerStack[stackLen] = function (event) {

                // Don't retain - callback must get positions for
                // required coordinate via methods on the event object.
                // That's dirty, therefore deprecated.
                if (renderedSubs) {
                    node.publish("rendered", event, true); // DEPRECATED in V3.2
                }

                // Publish retained positions for coordinate systems where subscribed
                if (worldPosSubs) {
                    node.publish("worldPos", event.getWorldPos());
                }
                if (viewPosSubs) {
                    node.publish("viewPos", event.getViewPos());
                }
                if (cameraPosSubs) {
                    node.publish("cameraPos", event.getCameraPos());
                }
                if (projPosSubs) {
                    node.publish("projPos", event.getProjPos());
                }
                if (canvasPosSubs) {
                    node.publish("canvasPos", event.getCanvasPos());
                }
            };

            stackLen++;
            dirty = true;
        }
    };

    this.postVisitNode = function (node) {
        if (node.id == idStack[stackLen - 1]) {
            stackLen--;
            dirty = true;
        }
    };

})();

/**
 * @class Holds state for one or more {@link SceneJS.Node}s.
 *
 * <p>Each {@link SceneJS.Node} has a state core to hold its state, and the core may be shared by other
 * {@link SceneJS.Nodes}s of the same type.</p>
 *
 * <p>The state held by core is rendered by a {@link SceneJS_Chunk}  
 *
 * @private
 */
var SceneJS_Core = function(type) {

    /**
     * The state core type, which will be the same value as the type property on the {@link SceneJS.Node}s that use the core
     * @type String
     * @see SceneJS.Node#type
     */
    this.type = type;

    /**
     * The state core ID, unique within the scene. This ID may be either a string assigned by the application layer via
     * scene node configs, or a number that is automatically generated by the {@link SceneJS_CoreFactory} managing
     * this core instance.
     * @type String|Number
     */
    this.coreId = null;

    /**
     * Uniquely identifies this state core within a {@link SceneJS_Display}.
     *
     * This ID is used by a {@link SceneJS_Display} to reduce redundant state changes when rendering a sequence of cores, 
     * where as a {@link SceneJS_Display} renders a frame it avoids applying consecutive cores that have the
     * same value for this ID.
     *
     * @type Number
     */
    this.stateId = null;

    /**
     * Count of {@link SceneJS.Node} instances this core holds state for
     */
    this.useCount = 0;
};/**
 * @class Manages creation, recycle and destruction of {@link SceneJS_Core} instances
 * @private
 */
var SceneJS_CoreFactory = function () {

    this._stateMap = new SceneJS_Map(null, SceneJS._baseStateId);  // For creating unique state IDs for cores

    this._cores = {}; // Map of cores for each type
};

/**
 * State core classes provided by this factory
 * @type {SceneJS.Core}
 */
SceneJS_CoreFactory.coreTypes = {};    // Supported core classes, installed by #createCoreType

/**
 * Creates a core class for instantiation by this factory
 * @param {String} type Name of type, eg. "camera"
 * @param {Node} [superType] Class of super type - SceneJS.Node by default
 * @returns The new node class
 */
SceneJS_CoreFactory.createCoreType = function (type, superType) {
    //
    //    var supa = SceneJS_CoreFactory.coreTypes[superType];
    //
    //    if (!supa) {
    //        supa = SceneJS.Core; // Super class is Core by default
    //    }
    //
    //    var nodeType = function() { // Create the class
    //        supa.apply(this, arguments);
    //        this.type = type;
    //    };
    //
    //    nodeType.prototype = new supa();            // Inherit from base class
    //    nodeType.prototype.constructor = nodeType;
    //
    //    SceneJS_CoreFactory.nodeTypes[type] = nodeType;
    //
    //    return nodeType;
};

SceneJS_CoreFactory.addCoreBuilder = function (type, factory) {

};

/* HACK - allows different types of node to have same type of core, eg. "rotate" and "translate" nodes can both have an "xform" core    
 */
SceneJS_CoreFactory.coreAliases = {
    "rotate":"xform",
    "translate":"xform",
    "scale":"xform",
    "matrix":"xform",
    "xform":"xform"
};

/**
 * Gets a core of the given type from this factory. Reuses any existing existing core of the same type and ID.
 *
 * The caller (a scene node) will then augment the core with type-specific attributes and methods.
 *
 * @param {String} type Type name of core, e.g. "material", "texture"
 * @param {String} coreId ID for the core, unique among all cores of the given type within this factory
 * @returns {Core} The core
 */
SceneJS_CoreFactory.prototype.getCore = function (type, coreId) {

    /* HACK - allows different types of node to have same type of core, eg. "rotate" and "translate" nodes can both have an "xform" core    
     */
    var alias = SceneJS_CoreFactory.coreAliases[type];
    if (alias) {
        type = alias;
    }

    var cores = this._cores[type];

    if (!cores) {
        cores = this._cores[type] = {};
    }

    var core;

    if (coreId) { // Attempt to reuse a core

        core = cores[coreId];

        if (core) {
            core.useCount++;
            return core;
        }
    }

    core = new SceneJS_Core(type);
    core.useCount = 1;  // One user so far

    core.stateId = this._stateMap.addItem(core);
    core.coreId = (coreId != undefined && coreId != null) ? coreId : core.stateId; // Use state ID as core ID by default

    cores[core.coreId] = core;

    return core;
};


/**
 * Tests if a core of the given type and ID currently exists within this factory.
 *
 * @param {String} type Type name of core, e.g. "material", "texture"
 * @param {String} coreId ID for the core, unique among all cores of the given type within this factory
 * @returns {Boolean} True if the core exists
 */
SceneJS_CoreFactory.prototype.hasCore = function (type, coreId) {
    // HACK - allows different types of node to have same type of core, eg. "rotate" and "translate" nodes can both have an "xform" core
    var alias = SceneJS_CoreFactory.coreAliases[type];
    if (alias) {
        type = alias;
    }
    var cores = this._cores[type];
    return cores && cores[coreId];
};

/**
 * Releases a state core back to this factory, destroying it if the core's use count is then zero.
 * @param {Core} core Core to release
 */
SceneJS_CoreFactory.prototype.putCore = function (core) {

    if (core.useCount == 0) {
        return; // In case of excess puts
    }

    if (--core.useCount <= 0) {                    // Release shared core if use count now zero

        var cores = this._cores[core.type];

        cores[core.coreId] = null;

        this._stateMap.removeItem(core.stateId);  // Release state ID for reuse
    }
};

/**
 * Reallocates WebGL resources for cores within this factory
 */
SceneJS_CoreFactory.prototype.webglRestored = function () {

    var cores;
    var core;

    for (var type in this._cores) {
        if (this._cores.hasOwnProperty(type)) {

            cores = this._cores[type];

            if (cores) {

                for (var coreId in cores) {
                    if (cores.hasOwnProperty(coreId)) {

                        core = cores[coreId];

                        if (core.webglRestored) { // Method augmented on core by user
                            core.webglRestored();
                        }
                    }
                }
            }
        }
    }
};
/**
 * @class The basic scene graph node type
 */
SceneJS.Node = function () {
};

/**
 * @class Basic scene graph node
 */
SceneJS.Node.prototype.constructor = SceneJS.Node;

/**
 * Called by SceneJS_Engine after it has instantiated the node
 *
 * @param {SceneJS_Engine} engine The engine which will manage this node
 * @param {SceneJS_Core} core The core which will hold state for this node, may be shared with other nodes of the same type
 * @param cfg Configuration for this node
 * @param {String} cfg.id ID for the node, unique among all nodes in the scene
 * @param {String} cfg.type type Type of this node (eg. "material", "texture" etc)
 * @param {Object} cfg.data Optional arbitrary JSON object to attach to node
 * @param {String} nodeId Optional ID for node
 */
SceneJS.Node.prototype._construct = function (engine, core, cfg, nodeId) {

    /**
     * Engine that manages this node
     * @type SceneJS_Engine
     */
    this._engine = engine;

    /**
     * The core which holds state for this node, may be shared with other nodes of the same type
     * @type SceneJS_Core
     */
    this._core = core;

    /**
     * ID of this node, unique within its scene. The ID is a string if it was defined by the application
     * via the node's JSON configuration, otherwise it is a number if it was left to SceneJS to automatically create.
     * @type String|Number
     */
    this.id = cfg.id || cfg.nodeId || nodeId;

    /**
     * Type of this node (eg. "material", "texture" etc)
     * @type String
     */
    this.type = cfg.type || "node";

    /**
     * Optional arbitrary JSON object attached to this node
     * @type JSON
     */
    this.data = cfg.data;

    /**
     * Parent node
     * @type SceneJS.Node
     */
    this.parent = null;

    /**
     * Child nodes
     * @type SceneJS.Node[]
     */
    this.nodes = [];

    // Pub/sub support
    this._handleMap = new SceneJS_Map(); // Subscription handle pool
    this._topicSubs = {}; // A [handle -> callback] map for each topic name
    this._handleTopics = {}; // Maps handles to topic names
    this._topicPubs = {}; // Maps topics to publications

    /**
     *
     */
    this._listeners = {};

    /**
     *
     */
    this._numListeners = 0; // Useful for quick check whether node observes any events

    /**
     *
     */
    this.dirty = false;

    /**
     *
     */
    this.branchDirty = false;

    if (this._init) {
        this._init(cfg);
    }
};

/**
 * Notifies that an asynchronous task has started on this node
 * @param {String} [description] Description - will be "Task" by default
 * @return {String} Unique ID for the task, which may be given to {@link #taskFinished} or {@link #taskFailed}
 */
SceneJS.Node.prototype.taskStarted = function (description) {
    return SceneJS_sceneStatusModule.taskStarted(this, description || "Task");
};

/**
 * Notifies that a task, whose initiation was previously notified with {@link #taskStarted},
 * has now completed successfully.
 * @param {String} taskId Unique ID for the task, which was got with {@link #taskStarted}
 * @return null
 */
SceneJS.Node.prototype.taskFinished = function (taskId) {
    return SceneJS_sceneStatusModule.taskFinished(taskId);
};

/**
 * Notifies that a task, whose initiation was previously notified with {@link #taskStarted},
 * has failed.
 * @param {String} taskId Unique ID for the task, which was got with {@link #taskStarted}
 * @return null
 */
SceneJS.Node.prototype.taskFailed = function (taskId) {
    return SceneJS_sceneStatusModule.taskFailed(taskId);
};

/**
 * Logs a message in the context of this node
 * @param {String} [channel] Logging channel - "error", "warn" or "info" (default)
 * @param {String} msg Message to log
 */
SceneJS.Node.prototype.log = function () {
    var channel;
    var msg;
    if (arguments.length == 1) {
        channel = "info";
        msg = arguments[0];
    } else if (arguments.length == 2) {
        channel = arguments[0];
        msg = arguments[1];
    }
    switch (channel) {
        case "warn":
            msg = "WARN;  [SceneJS.Node type=" + this.type + ", id=" + this.id + "] : " + msg;
            break;
        case "error":
            msg = "ERROR; [SceneJS.Node type=" + this.type + ", id=" + this.id + "] : " + msg;
            break;
        default:
            msg = "INFO;  [SceneJS.Node type=" + this.type + ", id=" + this.id + "] : " + msg;
            break;
    }

    if (console[channel]) {
        console[channel](msg);
    } else {
        console.log(msg);
    }
};

/**
 * Publishes to a topic on this node.
 *
 * Immediately notifies existing subscriptions to that topic, and unless the "forget' parameter is
 * true, retains the publication to give to any subsequent notifications on that topic as they are made.
 *
 * @param {String} topic Publication topic
 * @param {Object} pub The publication
 * @param {Boolean} [forget] When true, the publication will be sent to subscribers then forgotten, so that any
 * subsequent subscribers will not receive it
 */
SceneJS.Node.prototype.publish = function (topic, pub, forget) {
    if (!forget) {
        this._topicPubs[topic] = pub; // Save notification
    }
    if (this._topicSubs[topic]) { // Notify subscriptions
        var subsForTopic = this._topicSubs[topic];
        for (var handle in subsForTopic) {
            if (subsForTopic.hasOwnProperty(handle)) {
                subsForTopic[handle].call(this, pub);
            }
        }
    }
};

/**
 * Removes a topic publication
 *
 * Immediately notifies existing subscriptions to that topic, sending them each a null publication.
 *
 * @param topic Publication topic
 * @private
 */
SceneJS.Node.prototype.unpublish = function (topic) {
    var subsForTopic = this._topicSubs[topic];
    if (subsForTopic) { // Notify subscriptions
        for (var handle in subsForTopic) {
            if (subsForTopic.hasOwnProperty(handle)) {
                subsForTopic[handle].call(this, null);
            }
        }
    }
    delete this._topicPubs[topic];
};


/**
 * Listen for data changes at a particular location on this node
 *
 * <p>Your callback will be triggered for
 * the initial data and again whenever the data changes. Use {@link #off} to stop receiving updates.</p>
 *
 * <p>The callback is be called with this node as scope.</p>
 *
 * @param {String} location Publication location
 * @param {Function(data)} callback Called when fresh data is available at the location
 * @return {String} Handle to the subscription, which may be used to unsubscribe with {@link #off}.
 */
SceneJS.Node.prototype.on = function (topic, callback) {
    var subsForTopic = this._topicSubs[topic];
    if (!subsForTopic) {
        subsForTopic = {};
        this._topicSubs[topic] = subsForTopic;
    }
    var handle = this._handleMap.addItem(); // Create unique handle
    subsForTopic[handle] = callback;
    this._handleTopics[handle] = topic;
    var pub = this._topicPubs[topic];
    if (pub) { // A publication exists, notify callback immediately
        callback.call(this, pub);
    }
    //else {
    if (topic == "rendered") {
        this._engine.branchDirty(this);
    }
//    if (topic == "tick") {
//        this._engine.scene.on("tick",callback);
//    }
    // }
    return handle;
};

/**
 * Unsubscribes from a publication on this node that was previously made with {@link #on}.
 * @param handle Publication handle
 */
SceneJS.Node.prototype.off = function (handle) {
    var topic = this._handleTopics[handle];
    if (topic) {
        delete this._handleTopics[handle];
        var topicSubs = this._topicSubs[topic];
        if (topicSubs) {
            delete topicSubs[handle];
        }
        this._handleMap.removeItem(handle); // Release handle
        if (topic == "rendered") {
            this._engine.branchDirty(this);
        }
    }
//    else {
//        this._engine.scene.off(handle);
//    }
};

/**
 * Listens for exactly one data update at the specified location on this node, and then stops listening.
 * <p>This is equivalent to calling {@link #on}, and then calling {@link #off} inside the callback function.</p>
 * @param {String} location Data location to listen to
 * @param {Function(data)} callback Called when fresh data is available at the location
 */
SceneJS.Node.prototype.once = function (topic, callback) {
    var self = this;
    var sub = this.on(topic,
        function (pub) {
            self.off(sub);
            callback(pub);
        });
};

/**
 * Returns this node's {@link SceneJS.Scene}
 */
SceneJS.Node.prototype.getScene = function () {
    return this._engine.scene;
};

/**
 * Returns the ID of this node's core
 */
SceneJS.Node.prototype.getCoreId = function () {
    return this._core.coreId;
};

/**
 * Get the node's ID
 *
 */
SceneJS.Node.prototype.getID = function () {
    return this.id;
};

/**
 * Alias for getID
 *  @function
 */
SceneJS.Node.prototype.getId = function () {
    return this.id;
};

/**
 * Alias for getID
 *  @function
 */
SceneJS.Node.prototype.getNodeId = function () {
    return this.id;
};


/**
 * Returns the node's type. For the Node base class, it is "node", overridden in sub-classes.
 */
SceneJS.Node.prototype.getType = function () {
    return this.type;
};

/**
 * Returns the data object attached to this node.
 */
SceneJS.Node.prototype.getData = function () {
    return this.data;
};

/**
 * Sets a data object on this node.
 */
SceneJS.Node.prototype.setData = function (data) {
    this.data = data;
    return this;
};

/**
 * Returns the number of child nodes
 */
SceneJS.Node.prototype.getNumNodes = function () {
    return this.nodes.length;
};

/** Returns child nodes
 * @returns {Array} Child nodes
 */
SceneJS.Node.prototype.getNodes = function () {
    return this.nodes.slice(0);
};

/** Returns child node at given index. Returns null if no node at that index.
 * @param {Number} index The child index
 * @returns {Node} Child node, or null if not found
 */
SceneJS.Node.prototype.getNodeAt = function (index) {
    if (index < 0 || index >= this.nodes.length) {
        return null;
    }
    return this.nodes[index];
};

/** Returns first child node. Returns null if no child nodes.
 * @returns {Node} First child node, or null if not found
 */
SceneJS.Node.prototype.getFirstNode = function () {
    if (this.nodes.length == 0) {
        return null;
    }
    return this.nodes[0];
};

/** Returns last child node. Returns null if no child nodes.
 * @returns {Node} Last child node, or null if not found
 */
SceneJS.Node.prototype.getLastNode = function () {
    if (this.nodes.length == 0) {
        return null;
    }
    return this.nodes[this.nodes.length - 1];
};

/** Returns child node with the given ID.
 * Returns null if no such child node found.
 */
SceneJS.Node.prototype.getNode = function (id) {
    for (var i = 0; i < this.nodes.length; i++) {
        if (this.nodes[i].id == id) {
            return this.nodes[i];
        }
    }
    return null;
};

/** Disconnects the child node at the given index from its parent node
 * @param {int} index Child node index
 * @returns {Node} The disconnected child node if located, else null
 */
SceneJS.Node.prototype.disconnectNodeAt = function (index) {
    var r = this.nodes.splice(index, 1);
    if (r.length > 0) {
        r[0].parent = null;
        this._engine.display.objectListDirty = true;
        return r[0];
    } else {
        return null;
    }
};

/** Disconnects the child node from its parent, given as a node object
 * @param {String | Node} id The target child node, or its ID
 * @returns {Node} The removed child node if located
 */
SceneJS.Node.prototype.disconnect = function () {
    if (this.parent) {
        for (var i = 0; i < this.parent.nodes.length; i++) {
            if (this.parent.nodes[i] === this) {
                return this.parent.disconnectNodeAt(i);
            }
        }
    }
    return null;
};

/** Removes the child node at the given index
 * @param {int} index Child node index
 */
SceneJS.Node.prototype.removeNodeAt = function (index) {
    var child = this.disconnectNodeAt(index);
    if (child) {
        child.destroy();
        this._engine.display.objectListDirty = true;
    }
};

/** Removes the child node, given as either a node object or an ID string.
 * @param {String | Node} id The target child node, or its ID
 * @returns {Node} The removed child node if located
 */
SceneJS.Node.prototype.removeNode = function (node) {

    if (!node) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "Node#removeNode - node argument undefined");
    }

    if (!node._compile) {
        if (typeof node == "string") {
            var gotNode = this._engine.findNode(node);
            if (!gotNode) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.NODE_NOT_FOUND,
                    "Node#removeNode - node not found anywhere: '" + node + "'");
            }
            node = gotNode;
        }
    }

    if (node._compile) { //  instance of node
        for (var i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i] === node) {
                var removedNode = this.removeNodeAt(i);
                this._engine.display.objectListDirty = true;
                return removedNode;
            }
        }
    }

    throw SceneJS_error.fatalError(
        SceneJS.errors.NODE_NOT_FOUND,
        "Node#removeNode - child node not found: " + (node._compile ? ": " + node.id : node));
};

/** Disconnects all child nodes from their parent node and returns them in an array.
 */
SceneJS.Node.prototype.disconnectNodes = function () {

    var len = this.nodes.length;

    for (var i = 0; i < len; i++) {  // Unlink nodes from this
        this.nodes[i].parent = null;
    }

    var nodes = this.nodes;

    this.nodes = [];

    this._engine.display.objectListDirty = true;

    return nodes;
};

/** Removes all child nodes and returns them in an array.
 */
SceneJS.Node.prototype.removeNodes = function () {
    var nodes = this.disconnectNodes();
    for (var i = 0; i < nodes.length; i++) {
        nodes[i].destroy();
        this._engine.display.objectListDirty = true;
    }
};

/** Destroys this node and moves children up to parent, inserting them where this node resided.
 */
SceneJS.Node.prototype.splice = function () {

    var i, len;

    if (this.parent == null) {
        return null;
    }
    var parent = this.parent;
    var nodes = this.disconnectNodes();
    for (i = 0, len = nodes.length; i < len; i++) {  // Link this node's nodes to new parent
        nodes[i].parent = this.parent;
    }
    for (i = 0, len = parent.nodes.length; i < len; i++) { // Replace node on parent's nodes with this node's nodes
        if (parent.nodes[i] === this) {

            parent.nodes.splice.apply(parent.nodes, [i, 1].concat(nodes));

            this.nodes = [];
            this.parent = null;

            this.destroy();

            this._engine.branchDirty(parent);

            return parent;
        }
    }
};

/** Appends multiple child nodes
 */
SceneJS.Node.prototype.addNodes = function (nodes, ok) {

    if (!nodes) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "Node#addNodes - nodes argument is undefined");
    }

    var node;
    var result = [];
    var numNodes = nodes.length;

    for (var i = nodes.length - 1; i >= 0; i--) {
        var nodeAttr = nodes[i];
        if (nodeAttr.type == "node" || this._engine.hasNodeType(nodeAttr.type)) {

            // Add loaded node type synchronously

            node = this.addNode(nodeAttr);
            result[i] = node;
            if (--numNodes == 0) {
                if (ok) {
                    ok(nodes);
                }
                return nodes;
            }
        } else {

            // Load node type and instantiate it asynchronously

            var self = this;
            (function () {
                var nodei = i;
                self.addNode(nodeAttr,
                    function (node) {
                        result[nodei] = node;
                        if (--numNodes == 0) {
                            if (ok) {
                                ok(nodes);
                            }
                        }
                    });
            })();
        }
    }
    return null;
};

/** Appends a child node
 */
SceneJS.Node.prototype.addNode = function (node, ok) {

    node = node || {};

    // Graft node object
    if (node._compile) {
        if (node.parent != null) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Node#addNode - node argument is still attached to another parent");
        }
        this.nodes.push(node);
        node.parent = this;
        this._engine.branchDirty(node);
        if (ok) {
            ok(node);
        }
        return node;
    }

    // Graft node object by ID reference
    if (typeof node == "string") {
        var gotNode = this._engine.findNode(node);
        if (!gotNode) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Node#addNode - node not found: '" + node + "'");
        }
        node = gotNode;
        if (node.parent != null) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Node#addNode - node argument is still attached to another parent");
        }
        this.nodes.push(node);
        node.parent = this;
        this._engine.branchDirty(node);
        if (ok) {
            ok(node);
        }
        return node;
    }

    // Create node

    node.type = node.type || "node";

    if (node.type == "node" || this._engine.hasNodeType(node.type)) {

        // Root node's type is already loaded, so we are able
        // to create the root synchronously. When the caller
        // is creating a core node type, then by this contract
        // it can rely on the return value

        node = this._engine.createNode(node);
        this.nodes.push(node);
        node.parent = this;
        this._engine.branchDirty(node);
        if (ok) {
            ok(node);
        }
        return node;

    } else {

        // Otherwise the root node's type needs to be loaded,
        // so we need to create it asynchronously. By this contract,
        // the Caller would not rely on synchronous creation of
        // non-core types.
        var self = this;
        this._engine.createNode(node,
            function (node) {
                self.nodes.push(node);
                node.parent = self;
                self._engine.branchDirty(node);
                if (ok) {
                    ok(node);
                }
            });
        return null;
    }
};

/** Inserts a subgraph into child nodes
 * @param {Node} node Child node
 * @param {int} i Index for new child node
 * @return {Node} The child node
 */
SceneJS.Node.prototype.insertNode = function (node, i) {

    if (!node) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "SceneJS.Node#insertNode - node argument is undefined");
    }

    if (!node._compile) { // JSON node definition
        node = this._engine.createNode(node); // Create node
    }

    if (!node._compile) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "SceneJS.Node#insertNode - node argument is not a SceneJS.Node");
    }

    if (node.parent != null) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "SceneJS.Node#insertNode - node argument is still attached to another parent");
    }

    if (i === undefined || i === null) {
        node.addNodes(this.disconnectNodes());
        this.addNode(node);

    } else if (i < 0) {

        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "SceneJS.Node#insertNode - node index out of range: -1");

    } else if (i >= this.nodes.length) {
        this.nodes.push(node);
    } else {
        this.nodes.splice(i, 0, node);
    }

    node.parent = this;
    return node;
};

/** Calls the given function on each node in the subgraph rooted by this node, including this node.
 * The callback takes each node as it's sole argument and traversal stops as soon as the function returns
 * true and returns the node.
 * @param {function(Node)} func The function
 */
SceneJS.Node.prototype.mapNodes = function (func) {
    if (func(this)) {
        return this;
    }
    var result;
    for (var i = 0; i < this.nodes.length; i++) {
        result = this.nodes[i].mapNodes(func);
        if (result) {
            return result;
        }
    }
    return null;
};

/**
 * Registers a listener for a given event on this node. If the event type
 * is not supported by this node type, then the listener will never be called.
 * <p><b>Example:</b>
 * <pre><code>
 * var node = new Node();
 *
 * node.addListener(
 *
 *              // eventName
 *              "some-event",
 *
 *              // handler
 *              function(node,      // Node we are listening to
 *                       params) {  // Whatever params accompany the event type
 *
 *                     // ...
 *              }
 * );
 *
 *
 * </code></pre>
 *
 * @param {String} eventName One of the event types supported by this node
 * @param {Function} fn - Handler function that be called as specified
 * @param options - Optional options for the handler as specified
 * @return {Node} this
 */
SceneJS.Node.prototype.addListener = function (eventName, fn, options) {
    var list = this._listeners[eventName];
    if (!list) {
        list = [];
        this._listeners[eventName] = list;
    }
    list.push({
        eventName:eventName,
        fn:fn,
        options:options || {}
    });
    this._numListeners++;
    return this;
};

/**
 * Fires an event at this node, immediately calling listeners registered for the event
 */
SceneJS.Node.prototype._fireEvent = function (eventName, params, options) {
    var list = this._listeners[eventName];
    if (list) {
        if (!params) {
            params = {};
        }
        var event = {
            name:eventName,
            params:params,
            options:options || {}
        };
        var listener;
        for (var i = 0, len = list.length; i < len; i++) {
            listener = list[i];
            if (listener.options.scope) {
                listener.fn.call(listener.options.scope, event);
            } else {
                listener.fn.call(this, event);
            }
        }
    }
};

/**
 * Removes a handler that is registered for the given event on this node.
 * Does nothing if no such handler registered.
 */
SceneJS.Node.prototype.removeListener = function (eventName, fn) {
    var list = this._listeners[eventName];
    if (!list) {
        return null;
    }
    for (var i = 0; i < list.length; i++) {
        if (list[i].fn == fn) {
            list.splice(i, 1);
            return fn;
        }
    }
    this._numListeners--;
    return null;
};

/**
 * Returns true if this node has any listeners for the given event
 */
SceneJS.Node.prototype.hasListener = function (eventName) {
    return this._listeners[eventName];
};

/**
 * Returns true if this node has any listeners at all.
 */
SceneJS.Node.prototype.hasListeners = function () {
    return (this._numListeners > 0);
};

/** Removes all listeners registered on this node.
 */
SceneJS.Node.prototype.removeListeners = function () {
    this._listeners = {};
    this._numListeners = 0;
    return this;
};

/**
 * Returns the parent node
 * @return {SceneJS.Node}
 */
SceneJS.Node.prototype.getParent = function (type) {
    return this.parent;
};

/**
 * Finds the first node of given type on path to root.
 * @param {String} type Parent type to find on path to root
 * @return {SceneJS.Node}
 */
SceneJS.Node.prototype.getParentOfType = function (type) {
    var parent = this.parent;
    while (parent && parent.type != type) {
        parent = parent.parent;
    }
    return parent;
};

/**
 * Iterates over parent nodes on the path from the selected node to the root, executing a function
 * for each.
 * If the function returns true at any node, then traversal stops and a selector is
 * returned for that node.
 * @param {Function(node, index)} fn Function to execute on each instance node
 * @return {Object} Selector for selected node, if any
 */
SceneJS.Node.prototype.eachParent = function (fn) {

    if (!fn) {
        throw "SceneJS.Node.eachParent param 'fn' is null or undefined";
    }

    var count = 0;
    var node = this;

    while (node.parent) {
        if (fn.call(node.parent, count++) === true) {
            return node.parent;
        }
        node = node.parent;
    }

    return null;
};

/** Returns true if a child node matching given ID or index exists on this node
 * @param {Number|String} node Child node index or ID
 */
SceneJS.Node.prototype.hasNode = function (node) {

    if (node === null || node === undefined) {
        throw "SceneJS.Node.hasNode param 'node' is null or undefined";
    }

    var type = typeof node;
    var nodeGot;

    if (type == "number") {
        nodeGot = this.getNodeAt(node);

    } else if (type == "string") {
        nodeGot = this.getNode(node);

    } else {
        throw "SceneJS.Node.hasNode param 'node' should be either an index number or an ID string";
    }

    return (nodeGot != undefined && nodeGot != null);
};

/** Selects a child node matching given ID or index
 * @param {Number|String} node Child node index or ID
 */
SceneJS.Node.prototype.node = function (node) {

    if (node === null || node === undefined) {
        throw "SceneJS.Node.node param 'node' is null or undefined";
    }

    var type = typeof node;
    var nodeGot;

    if (type == "number") {
        nodeGot = this.getNodeAt(node);

    } else if (type == "string") {
        nodeGot = this.getNode(node);

    } else {
        throw "SceneJS.Node.node param 'node' should be either an index number or an ID string";
    }

    if (!nodeGot) {
        throw "SceneJS.Node.node - node not found: '" + node + "'";
    }

    return nodeGot;
};

/**
 * Iterates over sub-nodes of the selected node, executing a function
 * for each. With the optional options object we can configure is depth-first or breadth-first order.
 * If neither, then only the child nodes are iterated.
 * If the function returns true at any node, then traversal stops and a selector is
 * returned for that node.
 * @param {Function(index, node)} fn Function to execute on each child node
 * @return {Object} Selector for selected node, if any
 */
SceneJS.Node.prototype.eachNode = function (fn, options) {

    if (!fn) {
        throw "SceneJS.Node.eachNode param 'fn' is null or undefined";
    }

    if (typeof fn != "function") {
        throw "SceneJS.Node.eachNode param 'fn' should be a function";
    }

    var stoppedNode;
    options = options || {};
    var count = 0;

    if (options.andSelf) {
        if (fn.call(this, count++) === true) {
            return this;
        }
    }

    if (!options.depthFirst && !options.breadthFirst) {
        stoppedNode = this._iterateEachNode(fn, this, count);

    } else if (options.depthFirst) {
        stoppedNode = this._iterateEachNodeDepthFirst(fn, this, count, false); // Not below root yet

    } else {
        // TODO: breadth-first
    }

    if (stoppedNode) {
        return stoppedNode;
    }

    return undefined; // IDE happy now
};

SceneJS.Node.prototype.numNodes = function () {
    return this.nodes.length;
};

SceneJS.Node.prototype._iterateEachNode = function (fn, node, count) {

    var len = node.nodes.length;
    var child;

    for (var i = 0; i < len; i++) {
        child = node.nodes[i];

        if (fn.call(child, count++) === true) {
            return child;
        }
    }

    return null;
};

SceneJS.Node.prototype._iterateEachNodeDepthFirst = function (fn, node, count, belowRoot) {

    if (belowRoot) {

        /* Visit this node - if we are below root, because entry point visits the root
         */
        if (fn.call(node, count++) === true) {
            return node;
        }
    }

    belowRoot = true;

    /* Iterate nodes
     */
    var len = node.nodes.length;
    var child;
    for (var i = 0; i < len; i++) {
        child = this._iterateEachNodeDepthFirst(fn, node.nodes[i], count, belowRoot);
        if (child) {
            return child;
        }
    }

    return null;
};

/** Returns either all child or all sub-nodes of the given type, depending on whether search is recursive or not.
 */
SceneJS.Node.prototype.findNodesByType = function (type, recursive) {
    return this._findNodesByType(type, [], recursive);
};

SceneJS.Node.prototype._findNodesByType = function (type, list, recursive) {
    var i;
    for (i = 0; i < this.nodes; i++) {
        var node = this.nodes[i];
        if (node.type == type) {
            list.add(node);
        }
    }
    if (recursive) {
        for (i = 0; i < this.nodes; i++) {
            this.nodes[i]._findNodesByType(type, list, recursive);
        }
    }
    return list;
};

/** Finds the first node on path up to root whose type equals that given
 */
SceneJS.Node.prototype.findParentByType = function (type) {
    var parent = this.parent;
    while (parent && parent.type != type) {
        parent = parent.parent;
    }
    return parent;
};


/**
 * Given a map of name-value pairs, calls a getter method for each name,
 * feeding into it the corresponding value.
 *
 * @param attr
 * @param value
 * @return {*}
 */
SceneJS.Node.prototype.set = function (attr, value) {

    if (typeof attr == "object") { // Attribute map - recurse for each attribute
        for (var subAttr in attr) {
            if (attr.hasOwnProperty(subAttr)) {
                this.set(subAttr, attr[subAttr]);
            }
        }
        return;
    }

    if (this._set) {
        var method = this._set[attr];
        if (method) {
            return method.call(this, value);
        }
    }

    return this._createAccessor("set", attr, value);
};

SceneJS.Node.prototype.get = function (attr) {

    if (this._get) {
        var method = this._get[attr];
        if (method) {
            return method.call(this);
        }
    }

    return this._createAccessor("get", attr);
};

SceneJS.Node.prototype.add = function (attr, value) {

    if (typeof attr == "object") { // Attribute map - recurse for each attribute
        for (var subAttr in attr) {
            if (attr.hasOwnProperty(subAttr)) {
                this.add(subAttr, attr[subAttr]);
            }
        }
        return;
    }

    if (this._add) {
        var method = this._add[attr];
        if (method) {
            return method.call(this, value);
        }
    }

    return this._createAccessor("add", attr, value);
};

SceneJS.Node.prototype.inc = function (attr, value) {

    if (typeof attr == "object") { // Attribute map - recurse for each attribute
        for (var subAttr in attr) {
            if (attr.hasOwnProperty(subAttr)) {
                this.inc(subAttr, attr[subAttr]);
            }
        }
        return;
    }

    if (this._inc) {
        var method = this._inc[attr];
        if (method) {
            return method.call(this, value);
        }
    }

    return this._createAccessor("inc", attr, value);
};

SceneJS.Node.prototype.insert = function (attr, value) {

    if (typeof attr == "object") { // Attribute map - recurse for each attribute
        for (var subAttr in attr) {
            if (attr.hasOwnProperty(subAttr)) {
                this.insert(subAttr, attr[subAttr]);
            }
        }
        return;
    }

    if (this._set) {
        var method = this._set[attr];
        if (method) {
            return method.call(this, value);
        }
    }

    return this._createAccessor("insert", attr, value);
};

SceneJS.Node.prototype.remove = function (attr, value) {

    if (typeof attr == "object") { // Attribute map - recurse for each attribute
        for (var subAttr in attr) {
            if (attr.hasOwnProperty(subAttr)) {
                this.remove(subAttr, attr[subAttr]);
            }
        }
        return;
    }

    if (this._remove) {
        var method = this._remove[attr];
        if (method) {
            return method.call(this, value);
        }
    }

    return this._createAccessor("remove", attr, value);
};

SceneJS.Node.prototype._createAccessor = function (op, attr, value) {

    var methodName = op + attr.substr(0, 1).toUpperCase() + attr.substr(1);

    var method = this[methodName];

    if (!method) {
        throw "Method not found on node: '" + methodName + "'";
    }

    //var proto = (this.type == "node") ? SceneJS.Node.prototype : this._engine.nodeTypes[this.type].prototype;

    var proto = this.__proto__;

    var accessors;
    switch (op) {
        case "set":
            accessors = (proto._set || (proto._set = {}));
            break;

        case "get":
            accessors = (proto._get || (proto._get = {}));
            break;

        case "inc":
            accessors = (proto._inc || (proto._inc = {}));
            break;

        case "add":
            accessors = (proto._add || (proto._add = {}));
            break;

        case "insert":
            accessors = (proto._insert || (proto._insert = {}));
            break;

        case "remove":
            accessors = (proto._remove || (proto._remove = {}));
            break;
    }

    accessors[attr] = method;

    return method.call(this, value); // value can be undefined
};

/** Binds a listener to an event on the selected node
 *
 * @param {String} name Event name
 * @param {Function} handler Event handler
 */
SceneJS.Node.prototype.bind = function (name, handler) {

    if (!name) {
        throw "SceneJS.Node.bind param 'name' null or undefined";
    }

    if (typeof name != "string") {
        throw "SceneJS.Node.bind param 'name' should be a string";
    }

    if (!handler) {
        throw "SceneJS.Node.bind param 'handler' null or undefined";
    }

    if (typeof handler != "function") {
        throw "SceneJS.Node.bind param 'handler' should be a function";
    }

    this.addListener(name, handler, { scope:this });

    this._engine.branchDirty(this);

    return handler;
};

/**
 * Returns an object containing the attributes that were given when creating the node. Obviously, the map will have
 * the current values, plus any attributes that were later added through set/add methods on the node
 *
 */
SceneJS.Node.prototype.getJSON = function () {
    return this;
};


SceneJS.Node.prototype._compile = function (ctx) {
    if (this.preCompile) {
        this.preCompile();
    }
    this._compileNodes(ctx);
    if (this.postCompile) {
        this.postCompile();
    }
};

SceneJS.Node.prototype._compileNodes = function (ctx) {

    var renderSubs = this._topicSubs["rendered"];

    if (renderSubs) {
        SceneJS_nodeEventsModule.preVisitNode(this);
    }

//    var tickSubs = this._topicSubs["tick"];
//
//    if (tickSubs) {
//        ctx.pubSubProxy.on("tick", function(event) {
//            this.publish("tick", event);
//        });
//    }

    var child;

    for (var i = 0, len = this.nodes.length; i < len; i++) {

        child = this.nodes[i];

        child.branchDirty = child.branchDirty || this.branchDirty; // Compile subnodes if scene branch dirty

        if (child.dirty || child.branchDirty || this._engine.sceneDirty) {  // Compile nodes that are flagged dirty
            child._compile(ctx);
            child.dirty = false;
            child.branchDirty = false;
        }
    }

    if (renderSubs) {
        SceneJS_nodeEventsModule.postVisitNode(this);
    }
};



/**
 * Destroys this node. It is marked for destruction; when the next scene traversal begins (or the current one ends)
 * it will be destroyed and removed from it's parent.
 */
SceneJS.Node.prototype.destroy = function () {

    if (!this.destroyed) {

        if (this.parent) {

            /* Remove from parent's child node list
             */
            for (var i = 0; i < this.nodes.length; i++) {
                if (this.parent.nodes[i].id === this.id) {
                    this.parent.nodes.splice(i, 1);
                    break;
                }
            }
        }

        // Remove publication
        this._engine.scene.unpublish("nodes/" + this.id);

        /* Recusrsively destroy child nodes without
         * bothering to remove them from their parents
         */
        this._destroyTree();

        /* Need object list recompilation on display
         */
        this._engine.display.objectListDirty = true;
    }

    return this;
};

SceneJS.Node.prototype._destroyTree = function () {

    this.destroyed = true;

    this._engine.destroyNode(this); // Release node object

    for (var i = 0, len = this.nodes.length; i < len; i++) {
        this.nodes[i]._destroyTree();
    }
};

/**
 * Performs the actual destruction of this node, calling the node's optional template destroy method
 */
SceneJS.Node.prototype._doDestroy = function () {

    if (this._destroy) {  // Call destruction handler for each node subclass
        this._destroy();
    }

    return this;
};SceneJS_PubSubProxy = function (scene, proxy) {
    this.scene = scene;
    this.proxy = proxy;

};



/**
 * @class Manages creation, recycle and destruction of {@link SceneJS.Node} instances
 * @private
 */
var SceneJS_NodeFactory = function () {

    /** Nodes created by this factory
     * @type {SceneJS_Map}
     */
    this.nodes = new SceneJS_Map({});
};

/**
 * Scene graph node classes provided by the SceneJS_NodeFactory class
 *
 * @type {[SceneJS.Node]}
 */
SceneJS_NodeFactory.nodeTypes = {};

/**
 * Subscribers waiting for node types
 * @type {Object}
 * @private
 */
SceneJS_NodeFactory._subs = {};

/**
 * Creates a node class for instantiation by this factory
 *
 * @param {String} typeName Name of type, eg. "rotate"
 * @param {String} coreTypeName Optional name of core type for the node, eg. "xform" - defaults to type name of node
 * @param {Function} [augment] Augments the basic node type with our custom node methods
 * @returns The new node class
 */
SceneJS_NodeFactory.createNodeType = function (typeName, coreTypeName, augment) {
    if (SceneJS_NodeFactory.nodeTypes[typeName]) {
        throw "Node type already defined: " + typeName;
    }
    var nodeType = function () { // Create the class
        SceneJS.Node.apply(this, arguments);
        this.type = typeName;
    };
    nodeType.prototype = new SceneJS.Node();            // Inherit from base class
    nodeType.prototype.constructor = nodeType;
    SceneJS_NodeFactory.nodeTypes[typeName] = nodeType;

    var type = SceneJS_NodeFactory.nodeTypes[typeName]; // Type has installed itself
    if (!type) {
        throw "Node type plugin did not install itself correctly";
    }
    // Augment the basic node type
    if (augment) {
        augment(nodeType);
    }
    // Notify subscribers waiting for the type
    var subs = SceneJS_NodeFactory._subs[typeName];
    if (subs) {
        while (subs.length > 0) {
            subs.pop()(type);
        }
        delete subs[typeName];
    }
    return nodeType;
};

/**
 *
 */
SceneJS_NodeFactory.prototype.getNode = function (engine, json, core, ok) {
    json.type = json.type || "node"; // Nodes are SceneJS.Node type by default
    var nodeType;
    if (json.type == "node") {
        nodeType = SceneJS.Node;
    } else {
        nodeType = SceneJS_NodeFactory.nodeTypes[json.type];
    }
    if (nodeType) {
        return this._createNode(nodeType, engine, json, core, ok);
    } else {
        var self = this;
        this._getType(
            engine,
            json.type,
            function (nodeType) {
                self._createNode(nodeType, engine, json, core, ok);
            });
    }
};

SceneJS_NodeFactory.prototype._createNode = function (nodeType, engine, json, core, ok) {
    var node = new nodeType();
    var id = json.id || json.nodeId; // 'id' and 'nodeId' are aliases
    if (id) {
        this.nodes.addItem(id, node);
    } else {
        id = this.nodes.addItem(node);
    }
    node._construct(engine, core, json, id); // Instantiate node
    if (ok) {
        ok(node);
    }
    return node;
};

/**
 * Returns installed type of given type and ID
 */
SceneJS_NodeFactory.prototype._getType = function (engine, typeName, ok) {
    var type = SceneJS_NodeFactory.nodeTypes[typeName];
    if (type) {
        ok(type);
        return;
    }
    var subs = SceneJS_NodeFactory._subs[typeName] || (SceneJS_NodeFactory._subs[typeName] = []);
    subs.push(ok);
    if (subs.length > 1) { // Not first sub
        return;
    }
    var taskId = SceneJS_sceneStatusModule.taskStarted(engine.scene, "Loading plugin");
    subs.push(function () {
        SceneJS_sceneStatusModule.taskFinished(taskId);
    });
    var self = this;
    var typePath = SceneJS_configsModule.configs.pluginPath;
    if (!typePath) {
        throw "no typePath config"; // Build script error - should create this config
    }
    this._loadScript(typePath + "/node/" + typeName + ".js",
        function () {
            SceneJS_sceneStatusModule.taskFailed(taskId);
        });
};

SceneJS_NodeFactory.prototype._loadScript = function (url, error) {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = url;
    script.onerror = error;
    document.getElementsByTagName("head")[0].appendChild(script);
};

/**
 * Releases a node back to this factory
 */
SceneJS_NodeFactory.prototype.putNode = function (node) {
    this.nodes.removeItem(node.id);
};
(function () {

    var defaultMatrix = SceneJS_math_perspectiveMatrix4(
        45, // fovy
        1, // aspect
        0.1, // near
        10000); // far

    var defaultMat = new Float32Array(defaultMatrix);

    // The default state core singleton for {@link SceneJS.Camera} nodes
    var defaultCore = {
        type:"camera",
        stateId:SceneJS._baseStateId++,
        matrix:defaultMatrix,
        mat:defaultMat,
        optics:{
            type:"perspective",
            fovy:45.0,
            aspect:1.0,
            near:0.1,
            far:10000.0
        }
    };

    var coreStack = [];
    var stackLen = 0;

    // Set default core on the display at the start of each new scene compilation
    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.projTransform = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines the projection transform to apply to the {@link SceneJS.Geometry} nodes in its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Camera = SceneJS_NodeFactory.createNodeType("camera");

    SceneJS.Camera.prototype._init = function (params) {
        if (this._core.useCount == 1) {
            this.setOptics(params.optics); // Can be undefined

            // Rebuild on every scene tick
            // https://github.com/xeolabs/scenejs/issues/277
            var self = this;
            this._tick = this.getScene().on("tick", function () {
                if (self._core.dirty) {
                    self._core.rebuild();
                }
            });
        }
    };

    /**
     * Returns the default camera projection matrix
     * @return {Float32Array}
     */
    SceneJS.Camera.getDefaultMatrix = function () {
        return defaultMat;
    };

    SceneJS.Camera.prototype.setOptics = function (optics) {
        var core = this._core;
        if (!optics) {
            core.optics = {
                type:"perspective",
                fovy:60.0,
                aspect:1.0,
                near:0.1,
                far:10000.0
            };
        } else {
            var type = optics.type || core.optics.type;
            if (type == "ortho") {
                core.optics = SceneJS._applyIf(SceneJS_math_ORTHO_OBJ, {
                    type:type,
                    left:optics.left,
                    bottom:optics.bottom,
                    near:optics.near,
                    right:optics.right,
                    top:optics.top,
                    far:optics.far
                });
            } else if (type == "frustum") {
                core.optics = {
                    type:type,
                    left:optics.left || -1.0,
                    bottom:optics.bottom || -1.0,
                    near:optics.near || 0.1,
                    right:optics.right || 1.00,
                    top:optics.top || 1.0,
                    far:optics.far || 10000.0
                };
            } else if (type == "perspective") {
                core.optics = {
                    type:type,
                    fovy:optics.fovy || 60.0,
                    aspect:optics.aspect == undefined ? 1.0 : optics.aspect,
                    near:optics.near || 0.1,
                    far:optics.far || 10000.0
                };
            } else if (!optics.type) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "SceneJS.Camera configuration invalid: optics type not specified - " +
                        "supported types are 'perspective', 'frustum' and 'ortho'");
            } else {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "SceneJS.Camera configuration invalid: optics type not supported - " +
                        "supported types are 'perspective', 'frustum' and 'ortho'");
            }
        }
        this._rebuild();
        this._engine.display.imageDirty = true;
    };

    SceneJS.Camera.prototype._rebuild = function () {
        var optics = this._core.optics;
        if (optics.type == "ortho") {
            this._core.matrix = SceneJS_math_orthoMat4c(
                optics.left,
                optics.right,
                optics.bottom,
                optics.top,
                optics.near,
                optics.far);

        } else if (optics.type == "frustum") {
            this._core.matrix = SceneJS_math_frustumMatrix4(
                optics.left,
                optics.right,
                optics.bottom,
                optics.top,
                optics.near,
                optics.far);

        } else if (optics.type == "perspective") {
            this._core.matrix = SceneJS_math_perspectiveMatrix4(
                optics.fovy * Math.PI / 180.0,
                optics.aspect,
                optics.near,
                optics.far);
        }
        if (!this._core.mat) {
            this._core.mat = new Float32Array(this._core.matrix);
        } else {
            this._core.mat.set(this._core.matrix);
        }
        this.publish("matrix", this._core.matrix);
    };

    SceneJS.Camera.prototype.getOptics = function () {
        var optics = {};
        for (var key in this._core.optics) {
            if (this._core.optics.hasOwnProperty(key)) {
                optics[key] = this._core.optics[key];
            }
        }
        return optics;
    };

    SceneJS.Camera.prototype.getMatrix = function () {
        return this._core.matrix.slice(0);
    };

    /**
     * Compiles this camera node, setting this node's state core on the display, compiling sub-nodes,
     * then restoring the previous camera state core back onto the display on exit.
     */
    SceneJS.Camera.prototype._compile = function (ctx) {
        this._engine.display.projTransform = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.projTransform = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

    SceneJS.Camera.prototype._destroy = function () {
        // Stop publishing matrix on each tick
        this.getScene().off(this._tick);
    };
})();(function() {

    /**
     * The default state core singleton for {@link SceneJS.Clips} nodes
     */
    var defaultCore = {
        type: "clips",
        stateId: SceneJS._baseStateId++,
        empty: true,        
        hash: "",
        clips : []
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {
                params.engine.display.clips = defaultCore;
                stackLen = 0;
            });

    /**
     * @class Scene graph node which defines one or more arbitrarily-aligned clip planes to clip the {@link SceneJS.Geometry} nodes in its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Clips = SceneJS_NodeFactory.createNodeType("clips");

    SceneJS.Clips.prototype._init = function(params) {

        if (this._core.useCount == 1) { // This node defines the resource

            var clips = params.clips;

            if (!clips) {
                throw SceneJS_error.fatalError(
                        SceneJS.errors.NODE_CONFIG_EXPECTED,
                        "clips node attribute missing : 'clips'");
            }

            this._core.clips = this._core.clips || [];

            for (var i = 0, len = clips.length; i < len; i++) {
                this._setClip(i, clips[i]);
            }
        }
    };

    SceneJS.Clips.prototype.setClips = function(clips) {
        var indexNum;
        for (var index in clips) {
            if (clips.hasOwnProperty(index)) {
                if (index != undefined || index != null) {
                    indexNum = parseInt(index);
                    if (indexNum < 0 || indexNum >= this._core.clips.length) {
                        throw SceneJS_error.fatalError(
                                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                                "Invalid argument to set 'clips': index out of range (" + this._core.clips.length + " clips defined)");
                    }
                    this._setClip(indexNum, clips[index] || {});
                }
            }
        }
        this._engine.display.imageDirty = true;
    };

    SceneJS.Clips.prototype._setClip = function(index, cfg) {

        var clip = this._core.clips[index] || (this._core.clips[index] = {});

        clip.normalAndDist = [cfg.x || 0,  cfg.y || 0, cfg.z || 0, cfg.dist || 0];

        var mode = cfg.mode || clip.mode || "disabled";

        if (mode != "inside" && mode != "outside" && mode != "disabled") {
            throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "clips node invalid value for property 'mode': should be 'inside' or 'outside' or 'disabled'");
        }
        clip.mode = mode;

        this._core.hash = null;
    };

    SceneJS.Clips.prototype._compile = function(ctx) {

        if (!this._core.hash) {
            this._core.hash = this._core.clips.length;
        }

        this._engine.display.clips = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.clips = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };


})();(function () {

    // The default state core singleton for {@link SceneJS.Enable} nodes
    var defaultCore = {
        stateId:SceneJS._baseStateId++,
        type:"enable",
        enabled:true
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.enable = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which enables or disables rendering for its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Enable = SceneJS_NodeFactory.createNodeType("enable");

    SceneJS.Enable.prototype._init = function (params) {
        if (this._core.useCount == 1) {   // This node is first to reference the state core, so sets it up
            this._core.enabled = true;
            if (params.enabled != undefined) {
                this.setEnabled(params.enabled);
            }
        }
    };

    SceneJS.Enable.prototype.setEnabled = function (enabled) {
        if (enabled !== this._core.enabled) {
            this._core.enabled = enabled;
            this._engine.display.drawListDirty = true;
            this.publish("enabled", enabled);
        }
        return this;
    };

    SceneJS.Enable.prototype.getEnabled = function () {
        return this._core.enabled;
    };

    SceneJS.Enable.prototype._compile = function (ctx) {
        this._engine.display.enable = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.enable = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();(function() {

    /**
     * The default state core singleton for {@link SceneJS.Flags} nodes
     */
    var defaultCore = {

        stateId: SceneJS._baseStateId++,
        type: "flags",

        picking : true,             // Picking enabled
        clipping : true,            // User-defined clipping enabled
        enabled : true,             // Node not culled from traversal
        transparent: false,         // Node transparent - works in conjunction with matarial alpha properties
        backfaces: true,            // Show backfaces
        frontface: "ccw",           // Default vertex winding for front face
        backfaceLighting: true,     // Shading enabled for backfaces
        backfaceTexturing: true,    // Texturing enabled for backfaces
        diffuse: true,              // Diffuse lighting enabled
        specular: true,             // Specular lighting enabled
        ambient: true               // Ambient lighting enabled
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {
                params.engine.display.flags = defaultCore;
                stackLen = 0;
            });

    /**
     * @class Scene graph node which sets rendering mode flags for its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Flags = SceneJS_NodeFactory.createNodeType("flags");

    SceneJS.Flags.prototype._init = function(params) {

        if (this._core.useCount == 1) {         // This node is first to reference the state core, so sets it up

            this._core.picking = true;           // Picking enabled
            this._core.clipping = true;          // User-defined clipping enabled
            this._core.enabled = true;           // Node not culled from traversal
            this._core.transparent = false;      // Node transparent - works in conjunction with matarial alpha properties
            this._core.backfaces = true;         // Show backfaces
            this._core.frontface = "ccw";        // Default vertex winding for front face
            this._core.backfaceLighting = true;  // Shading enabled for backfaces
            this._core.backfaceTexturing = true; // Texturing enabled for backfaces
            this._core.diffuse = true;           // Diffuse lighting enabled by default
            this._core.specular = true;          // Specular lighting enabled by default
            this._core.ambient = true;           // Ambient lighting enabled by default

            if (params.flags) {                 // 'flags' property is actually optional in the node definition
                this.setFlags(params.flags);
            }
        }
    };

    SceneJS.Flags.prototype.setFlags = function(flags) {

        var core = this._core;

        if (flags.picking != undefined) {
            core.picking = !!flags.picking;
            this._engine.display.drawListDirty = true;
        }

        if (flags.clipping != undefined) {
            core.clipping = !!flags.clipping;
            this._engine.display.imageDirty = true;
        }

        if (flags.enabled != undefined) {
            core.enabled = !!flags.enabled;
            this._engine.display.drawListDirty = true;
        }

        if (flags.transparent != undefined) {
            core.transparent = !!flags.transparent;
            this._engine.display.drawListDirty = true;
        }

        if (flags.backfaces != undefined) {
            core.backfaces = !!flags.backfaces;
            this._engine.display.imageDirty = true;
        }

        if (flags.frontface != undefined) {
            core.frontface = flags.frontface;
            this._engine.display.imageDirty = true;
        }

        if (flags.backfaceLighting != undefined) {
            core.backfaceLighting = !!flags.backfaceLighting;
            this._engine.display.imageDirty = true;
        }

        if (flags.backfaceTexturing != undefined) {
            core.backfaceTexturing = !!flags.backfaceTexturing;
            this._engine.display.imageDirty = true;
        }

        if (flags.diffuse != undefined) {
            core.diffuse = !!flags.diffuse;
            this._engine.display.imageDirty = true;
        }

        if (flags.specular != undefined) {
            core.specular = !!flags.specular;
            this._engine.display.imageDirty = true;
        }

        if (flags.ambient != undefined) {
            core.ambient = !!flags.ambient;
            this._engine.display.imageDirty = true;
        }

        return this;
    };

    SceneJS.Flags.prototype.addFlags = function(flags) {
        return this.setFlags(flags);
        //        var core = this._core;
        //        if (flags.picking != undefined) core.picking = flags.picking;
        //        if (flags.clipping != undefined) core.clipping = flags.clipping;
        //        if (flags.enabled != undefined) core.enabled = flags.enabled;
        //        if (flags.transparent != undefined) core.transparent = flags.transparent;
        //        if (flags.backfaces != undefined) core.backfaces = flags.backfaces;
        //        if (flags.frontface != undefined) core.frontface = flags.frontface;
        //        if (flags.backfaceLighting != undefined) core.backfaceLighting = flags.backfaceLighting;
        //        if (flags.backfaceTexturing != undefined) core.backfaceTexturing = flags.backfaceTexturing;
        //        return this;
    };

    SceneJS.Flags.prototype.getFlags = function() {
        var core = this._core;
        return {
            picking : core.picking,
            clipping : core.clipping,
            enabled : core.enabled,
            transparent: core.transparent,
            backfaces: core.backfaces,
            frontface: core.frontface,
            diffuse: core.diffuse,
            specular: core.specular,
            ambient: core.ambient,
            backfaceLighting: core.backfaceLighting,
            backfaceTexturing: core.backfaceTexturing
        };
    };

    SceneJS.Flags.prototype.setPicking = function(picking) {
        picking = !!picking;
        if (this._core.picking != picking) {
            this._core.picking = picking;
            this._engine.display.drawListDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getPicking = function() {
        return this._core.picking;
    };

    SceneJS.Flags.prototype.setClipping = function(clipping) {
        clipping = !!clipping;
        if (this._core.clipping != clipping) {
            this._core.clipping = clipping;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getClipping = function() {
        return this._core.clipping;
    };

    SceneJS.Flags.prototype.setEnabled = function(enabled) {
        enabled = !!enabled;
        if (this._core.enabled != enabled) {
            this._core.enabled = enabled;
            this._engine.display.drawListDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getEnabled = function() {
        return this._core.enabled;
    };

    SceneJS.Flags.prototype.setTransparent = function(transparent) {
        transparent = !!transparent;
        if (this._core.transparent != transparent) {
            this._core.transparent = transparent;
            this._engine.display.drawListDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getTransparent = function() {
        return this._core.transparent;
    };

    SceneJS.Flags.prototype.setBackfaces = function(backfaces) {
        backfaces = !!backfaces;
        if (this._core.backfaces != backfaces) {
            this._core.backfaces = backfaces;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getBackfaces = function() {
        return this._core.backfaces;
    };

    SceneJS.Flags.prototype.setFrontface = function(frontface) {
        if (this._core.frontface != frontface) {
            this._core.frontface = frontface;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getFrontface = function() {
        return this._core.frontface;
    };

    SceneJS.Flags.prototype.setBackfaceLighting = function(backfaceLighting) {
        backfaceLighting = !!backfaceLighting;
        if (this._core.backfaceLighting != backfaceLighting) {
            this._core.backfaceLighting = backfaceLighting;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getBackfaceLighting = function() {
        return this._core.backfaceLighting;
    };

    SceneJS.Flags.prototype.setBackfaceTexturing = function(backfaceTexturing) {
        backfaceTexturing = !!backfaceTexturing;
        if (this._core.backfaceTexturing != backfaceTexturing) {
            this._core.backfaceTexturing = backfaceTexturing;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getBackfaceTexturing = function() {
        return this._core.backfaceTexturing;
    };

    SceneJS.Flags.prototype.setDiffuse = function(diffuse) {
        diffuse = !!diffuse;
        if (this._core.diffuse != diffuse) {
            this._core.diffuse = diffuse;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getDiffuse = function() {
        return this._core.diffuse;
    };

    SceneJS.Flags.prototype.setSpecular = function(specular) {
        specular = !!specular;
        if (this._core.specular != specular) {
            this._core.specular = specular;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getSpecular = function() {
        return this._core.specular;
    };
    
    SceneJS.Flags.prototype.setAmbient = function(ambient) {
        ambient = !!ambient;
        if (this._core.ambient != ambient) {
            this._core.ambient = ambient;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getAmbient = function() {
        return this._core.ambient;
    };

    SceneJS.Flags.prototype.setAmbient = function(ambient) {
        ambient = !!ambient;
        if (this._core.ambient != ambient) {
            this._core.ambient = ambient;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    SceneJS.Flags.prototype.getAmbient = function() {
        return this._core.ambient;
    };

    SceneJS.Flags.prototype._compile = function(ctx) {
        this._engine.display.flags = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.flags = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();new (function() {

    /**
     * The default state core singleton for {@link SceneJS.Framebuf} nodes
     */
    var defaultCore = {

        type: "framebuf",
        stateId: SceneJS._baseStateId++,
        empty: true,

        framebuf: null
    };

    var nodeCoreMap = {}; // Map of framebuf nodes to cores, for reallocation on WebGL context restore

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {
                params.engine.display.framebuf = defaultCore;
                stackLen = 0;
            });

    SceneJS_events.addListener(// Reallocate VBOs when context restored after loss
            SceneJS_events.WEBGL_CONTEXT_RESTORED,
            function() {

                var node;

                for (var nodeId in nodeCoreMap) {
                    if (nodeCoreMap.hasOwnProperty(nodeId)) {

                        node = nodeCoreMap[nodeId];

                        if (!node._core._loading) {
                            node._buildNodeCore();
                        }
                    }
                }
            });

    SceneJS_events.addListener(
            SceneJS_events.SCENE_DESTROYED,
            function(params) {
                //     sceneBufs[params.sceneId] = null;
            });

    /**
     * @class Scene graph node which sets up a frame buffer to which the {@link SceneJS.Geometry} nodes in its subgraph will be rendered.
     * The frame buffer may be referenced as an image source by successive {@link SceneJS.Texture} nodes.
     * @extends SceneJS.Node
     */
    SceneJS.Framebuf = SceneJS_NodeFactory.createNodeType("framebuf");

    SceneJS.Framebuf.prototype._init = function() {

        nodeCoreMap[this._core.coreId] = this; // Register for core rebuild on WEBGL_CONTEXT_RESTORED

        this._buildNodeCore();
    };

    SceneJS.Framebuf.prototype._buildNodeCore = function() {

        var canvas = this._engine.canvas;
        var gl = canvas.gl;
        var width = canvas.canvas.width;
        var height = canvas.canvas.height;

        var framebuf = gl.createFramebuffer();
        var renderbuf = gl.createRenderbuffer();
        var texture = gl.createTexture() ;

        var rendered = false;

        if (!this._core) {
            this._core = {};
        }

        gl.bindFramebuffer(gl.FRAMEBUFFER, framebuf);

        gl.bindTexture(gl.TEXTURE_2D, texture);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
        gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);

        try {
            // Do it the way the spec requires
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, null);
        } catch (exception) {
            // Workaround for what appears to be a Minefield bug.
            var textureStorage = new WebGLUnsignedByteArray(width * height * 4);
            gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, width, height, 0, gl.RGBA, gl.UNSIGNED_BYTE, textureStorage);
        }
        gl.bindRenderbuffer(gl.RENDERBUFFER, renderbuf);
        gl.renderbufferStorage(gl.RENDERBUFFER, gl.DEPTH_COMPONENT16, width, height);
        gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, texture, 0);
        gl.framebufferRenderbuffer(gl.FRAMEBUFFER, gl.DEPTH_ATTACHMENT, gl.RENDERBUFFER, renderbuf);
        gl.bindTexture(gl.TEXTURE_2D, null);
        gl.bindRenderbuffer(gl.RENDERBUFFER, null);
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);

        /* Verify framebuffer is OK
         */
        gl.bindFramebuffer(gl.FRAMEBUFFER, framebuf);

        if (!gl.isFramebuffer(framebuf)) {
            throw SceneJS_error.fatalError("Invalid framebuffer");
        }

        var status = gl.checkFramebufferStatus(gl.FRAMEBUFFER);

        gl.bindRenderbuffer(gl.RENDERBUFFER, null);
        gl.bindFramebuffer(gl.FRAMEBUFFER, null);

        switch (status) {
            case gl.FRAMEBUFFER_COMPLETE:
                break;
            case gl.FRAMEBUFFER_INCOMPLETE_ATTACHMENT:
                throw SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT:
                throw SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
            case gl.FRAMEBUFFER_INCOMPLETE_DIMENSIONS:
                throw SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
            case gl.FRAMEBUFFER_UNSUPPORTED:
                throw SceneJS_error.fatalError("Incomplete framebuffer: FRAMEBUFFER_UNSUPPORTED");
            default:
                throw SceneJS_error.fatalError("Incomplete framebuffer: " + status);
        }

        this._core.framebuf = {

            id: this.id, // TODO: maybe unused?

            /** Binds the image buffer as target for subsequent geometry renders
             */
            bind: function() {
             //   gl.bindRenderbuffer(gl.RENDERBUFFER, renderbuf);
                gl.bindFramebuffer(gl.FRAMEBUFFER, framebuf);
                gl.clearColor(0.0, 0.0, 0.0, 1.0);
                gl.clearDepth(1.0);
                gl.enable(gl.DEPTH_TEST);
                gl.disable(gl.CULL_FACE);
                gl.depthRange(0, 1);
                gl.disable(gl.SCISSOR_TEST);
                //  gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
                gl.disable(gl.BLEND);
            },

            /** Unbinds image buffer, the default buffer then becomes the rendering target
             */
            unbind:function() {
                gl.bindFramebuffer(gl.FRAMEBUFFER, null);
               // gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
                gl.bindRenderbuffer(gl.RENDERBUFFER, renderbuf);
                rendered = true;
            },

            /** Returns true if this texture has been rendered
             */
            isRendered: function() {
                return rendered;
            },

            /** Gets the texture from this image buffer
             */
            getTexture: function() {

                return {

                    bind: function(unit) {
                        gl.activeTexture(gl["TEXTURE" + unit]);
                        gl.bindTexture(gl.TEXTURE_2D, texture);
                    },

                    unbind : function(unit) {
                        gl.activeTexture(gl["TEXTURE" + unit]);
                        gl.bindTexture(gl.TEXTURE_2D, null);
                    }
                };
            }
        };
    };

    SceneJS.Framebuf.prototype._compile = function(ctx) {
        this._engine.display.framebuf = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.framebuf = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

    SceneJS.Framebuf.prototype._destroy = function() {
        if (this._core) {
            //destroyFrameBuffer(this._buf);
        }
    };


})();new (function () {

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function () {
            stackLen = 0;
        });

    /**
     * @class Scene graph node that defines geometry.
     * @extends SceneJS.Node
     * When this node is at a leaf, it defines a scene object which inherits the state set up by all the nodes above it
     * on the path up to the root. These nodes can be nested, so that child geometries inherit arrays
     * defined by parent geometries.
     */
    SceneJS.Geometry = SceneJS_NodeFactory.createNodeType("geometry");

    SceneJS.Geometry.prototype._init = function (params) {

        if (this._core.useCount == 1) { // This node defines the core

            var taskId;

            var options = {
                origin:params.origin,
                scale:params.scale,
                autoNormals:params.normals == "auto"
            };

            var self = this;

            this._sourceConfigs = null;
            this._source = null;

            if (params.plugin) {
                this._sourceConfigs = SceneJS._apply({ type:params.plugin }, params);
            } else if (params.source) {
                this._sourceConfigs = params.source;
            }

            if (this._sourceConfigs) {

                /*---------------------------------------------------------------------------------------------------
                 * Build node core (possibly asynchronously) using a factory object
                 *--------------------------------------------------------------------------------------------------*/

                this._core._loading = true;

                if (!this._sourceConfigs.type) {
                    throw SceneJS_error.fatalError(
                        SceneJS.errors.ILLEGAL_NODE_CONFIG,
                        "geometry config expected: source.type");
                }

                SceneJS.Plugins.getPlugin(
                    "geometry",
                    this._sourceConfigs.type,
                    function (plugin) {

                        if (!plugin.getSource) {
                            throw SceneJS_error.fatalError(
                                SceneJS.errors.PLUGIN_INVALID,
                                "geometry: 'getSource' method missing on plugin for geometry source type '" + self._sourceConfigs.type + "'.");
                        }

                        self._source = plugin.getSource();

                        if (!self._source.subscribe) {
                            throw SceneJS_error.fatalError(
                                SceneJS.errors.PLUGIN_INVALID,
                                "geometry: 'subscribe' method missing on plugin for geometry source type '" + self._sourceConfigs.type + "'");
                        }

                        var created = false;

                        self._source.subscribe(// Get notification when source configurees the geometry
                            function (data) { // Data contains both typed arrays and primitive name

                                if (!created) {
                                    if (options) { // HACK - should apply this on GPU
                                        data.positions = data.positions
                                            ? new Float32Array((options.scale || options.origin)
                                            ? self._applyOptions(data.positions, options)
                                            : data.positions) : undefined;
                                    }
                                    self._initNodeCore(data, options);
                                    SceneJS.Geometry._buildNodeCore(self._engine.canvas.gl, self._core);
                                    self._core._loading = false;
                                    //self._fireEvent("loaded");
                                    self._engine.display.imageDirty = true;
                                    self._engine.branchDirty(self); // TODO
                                    created = true;
                                } else {

                                    var core = self._core;

                                    if (data.positions && core.vertexBuf) {

//                                    if (data.positions.length > core.vertexBuf.length) {
//                                        alert("too long");
//                                    }

                                        core.vertexBuf.bind();
                                        core.vertexBuf.setData(data.positions, data.positionsOffset || 0);

                                        if (data.positions.length > core.arrays.positions.length) {
                                            core.arrays.positions = data.positions;

                                        } else {
                                            core.arrays.positions.set(data.positions, data.positionsOffset || 0);
                                        }
                                    }

                                    if (data.normals && core.normalBuf) {

                                        core.normalBuf.bind();
                                        core.normalBuf.setData(data.normals, data.normalsOffset || 0);

                                        if (data.normals.length > core.arrays.normals.length) {
                                            core.arrays.normals = data.normals;

                                        } else {
                                            core.arrays.normals.set(data.normals, data.normalsOffset || 0);
                                        }
                                    }

                                    if (data.uv && core.uvBuf) {

                                        core.uvBuf.bind();
                                        core.uvBuf.setData(data.uv, data.uvOffset || 0);

                                        if (data.uv.length > core.arrays.uv.length) {
                                            core.arrays.uv = data.uv;

                                        } else {
                                            core.arrays.uv.set(data.uv, data.uvOffset || 0);
                                        }
                                    }

                                    if (data.uv2 && core.uvBuf2) {

                                        core.uvBuf2.bind();
                                        core.uvBuf2.setData(data.uv2, data.uv2Offset || 0);

                                        if (data.uv2.length > core.arrays.uv2.length) {
                                            core.arrays.uv2 = data.uv2;

                                        } else {
                                            core.arrays.uv2.set(data.uv2, data.uv2Offset || 0);
                                        }
                                    }

                                    if (data.colors && core.colorBuf) {

                                        if (data.colors.length > core.arrays.colors.length) {
                                            core.arrays.colors = data.colors;

                                        } else {
                                            core.arrays.colors.set(data.colors, data.colorsOffset || 0);
                                        }

                                        core.colorBuf.bind();
                                        core.colorBuf.setData(data.colors, data.colorsOffset || 0);
                                    }

                                    if (data.indices && core.indexBuf) {

                                        if (data.indices.length > core.arrays.indices.length) {
                                            core.arrays.indices = data.indices;

                                        } else {
                                            core.arrays.indices.set(data.indices, data.indicesOffset || 0);
                                        }

                                        core.indexBuf.bind();
                                        core.indexBuf.setData(data.indices, data.indicesOffset || 0);

                                        for (var i = 0; i < data.indices.length; i++) {
                                            var idx = data.indices[i];
                                            if (idx < 0 || idx >= core.arrays.positions.length) {
                                                alert("out of range ");
                                            }
                                            if (core.arrays.normals && (idx < 0 || idx >= core.arrays.normals.length)) {
                                                alert("out of range ");
                                            }
                                            if (core.arrays.uv && (idx < 0 || idx >= core.arrays.uv.length)) {
                                                alert("out of range ");
                                            }
                                            if (core.arrays.uv2 && (idx < 0 || idx >= core.arrays.uv2.length)) {
                                                alert("out of range ");
                                            }
                                            if (core.arrays.colors && (idx < 0 || idx >= core.arrays.colors.length)) {
                                                alert("out of range ");
                                            }
                                        }
                                    }

                                    self._engine.display.imageDirty = true;
                                }
                            }
                        );

                        if (self._source.configure) {
                            self._source.configure(self._sourceConfigs);
                        }
                    });

            } else {

                // Build node core from JSON arrays and primitive name given in node properties

                this._initNodeCore(params, options);

                SceneJS.Geometry._buildNodeCore(this._engine.canvas.gl, this._core);
            }

            this._core.webglRestored = function () {
                SceneJS.Geometry._buildNodeCore(self._engine.canvas.gl, self._core);
            };

        }
    };

    /**
     * Convert JSON arrays into typed arrays,
     * apply optional baked Model-space transforms to positions
     */
    SceneJS.Geometry.prototype._initNodeCore = function (data, options) {

        options = options || {};

        var primitive = data.primitive || "triangles";
        this._core.primitive = this._getPrimitiveType(primitive);

        var normals;

        if (data.normals) {
            if (data.normals == "auto" && primitive == "triangles") {
                if (data.positions && data.indices) {
                    // Auto normal generation
                    normals = this._buildNormals(data.positions, data.indices);
                } else {
                    // TODO: log warning?
                }
            } else {
                normals = data.normals;
            }
        }

        this._core.arrays = {
            positions:data.positions
                ? new Float32Array((options.scale || options.origin)
                ? this._applyOptions(data.positions, options)
                : data.positions) : undefined,

            normals:normals ? new Float32Array(normals) : undefined,
            uv:data.uv ? new Float32Array(data.uv) : undefined,
            uv2:data.uv2 ? new Float32Array(data.uv2) : undefined,
            colors:data.colors ? new Float32Array(data.colors) : undefined,
            indices:data.indices ? new Uint16Array(data.indices) : undefined
        };
    };

    /**
     * Returns WebGL constant for primitive name
     */
    SceneJS.Geometry.prototype._getPrimitiveType = function (primitive) {

        var gl = this._engine.canvas.gl;

        switch (primitive) {

            case "points":
                return gl.POINTS;

            case "lines":
                return gl.LINES;

            case "line-loop":
                return gl.LINE_LOOP;

            case "line-strip":
                return gl.LINE_STRIP;

            case "triangles":
                return gl.TRIANGLES;

            case "triangle-strip":
                return gl.TRIANGLE_STRIP;

            case "triangle-fan":
                return gl.TRIANGLE_FAN;

            default:
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "geometry primitive unsupported: '" +
                        primitive +
                        "' - supported types are: 'points', 'lines', 'line-loop', " +
                        "'line-strip', 'triangles', 'triangle-strip' and 'triangle-fan'");
        }
    };

    /**
     * Apply baked Model-space transformations to give position array
     */
    SceneJS.Geometry.prototype._applyOptions = function (positions, options) {

        var positions2 = positions.slice ? positions.slice(0) : new Float32Array(positions);  // HACK

        if (options.scale) {

            var scaleX = options.scale.x != undefined ? options.scale.x : 1.0;
            var scaleY = options.scale.y != undefined ? options.scale.y : 1.0;
            var scaleZ = options.scale.z != undefined ? options.scale.z : 1.0;

            for (var i = 0, len = positions2.length; i < len; i += 3) {
                positions2[i    ] *= scaleX;
                positions2[i + 1] *= scaleY;
                positions2[i + 2] *= scaleZ;
            }
        }

        if (options.origin) {

            var originX = options.origin.x != undefined ? options.origin.x : 0.0;
            var originY = options.origin.y != undefined ? options.origin.y : 0.0;
            var originZ = options.origin.z != undefined ? options.origin.z : 0.0;

            for (var i = 0, len = positions2.length; i < len; i += 3) {
                positions2[i    ] -= originX;
                positions2[i + 1] -= originY;
                positions2[i + 2] -= originZ;
            }
        }

        return positions2;
    };

    /**
     * Allocates WebGL buffers for geometry arrays
     *
     * In addition to initially allocating those, this is called to reallocate them after
     * WebGL context is regained after being lost.
     */
    SceneJS.Geometry._buildNodeCore = function (gl, core) {

        var usage = gl.STATIC_DRAW; //var usage = (!arrays.fixed) ? gl.STREAM_DRAW : gl.STATIC_DRAW;

        try { // TODO: Modify usage flags in accordance with how often geometry is evicted

            var arrays = core.arrays;

            if (arrays.positions) {
                core.vertexBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, arrays.positions, arrays.positions.length, 3, usage);
            }

            if (arrays.normals) {
                core.normalBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, arrays.normals, arrays.normals.length, 3, usage);
            }

            if (arrays.uv) {
                core.uvBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, arrays.uv, arrays.uv.length, 2, usage);
            }

            if (arrays.uv2) {
                core.uvBuf2 = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, arrays.uv2, arrays.uv2.length, 2, usage);
            }

            if (arrays.colors) {
                core.colorBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, arrays.colors, arrays.colors.length, 4, usage);
            }

            if (arrays.indices) {
                core.indexBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ELEMENT_ARRAY_BUFFER, arrays.indices, arrays.indices.length, 1, usage);
            }

        } catch (e) { // Allocation failure - delete whatever buffers got allocated

            if (core.vertexBuf) {
                core.vertexBuf.destroy();
                core.vertexBuf = null;
            }

            if (core.normalBuf) {
                core.normalBuf.destroy();
                core.normalBuf = null;
            }

            if (core.uvBuf) {
                core.uvBuf.destroy();
                core.uvBuf = null;
            }

            if (core.uvBuf2) {
                core.uvBuf2.destroy();
                core.uvBuf2 = null;
            }

            if (core.colorBuf) {
                core.colorBuf.destroy();
                core.colorBuf = null;
            }

            if (core.indexBuf) {
                core.indexBuf.destroy();
                core.indexBuf = null;
            }

            throw SceneJS_error.fatalError(
                SceneJS.errors.ERROR,
                "Failed to allocate geometry: " + e);
        }
    };

    SceneJS.Geometry.prototype._updateArray = function (array, items, offset) {

        var arrayLen = array.length;
        var itemsLen = items.length;

        if (itemsLen + offset > arrayLen) {
            itemsLen -= (itemsLen + offset) - arrayLen;
        }

        for (var i = offset, j = 0; j < itemsLen; i++, j++) {
            array[i] = items[j];
        }

    };

    /** (re)builds normal vectors from vertices
     * @private
     */
    SceneJS.Geometry.prototype._buildNormals = function (positions, indices) {

        var nvecs = new Array(positions.length / 3);
        var j0;
        var j1;
        var j2;
        var v1;
        var v2;
        var v3;

        for (var i = 0, len = indices.length - 3; i < len; i += 3) {
            j0 = indices[i + 0];
            j1 = indices[i + 1];
            j2 = indices[i + 2];

            v1 = [positions[j0 * 3 + 0], positions[j0 * 3 + 1], positions[j0 * 3 + 2]];
            v2 = [positions[j1 * 3 + 0], positions[j1 * 3 + 1], positions[j1 * 3 + 2]];
            v3 = [positions[j2 * 3 + 0], positions[j2 * 3 + 1], positions[j2 * 3 + 2]];

            v2 = SceneJS_math_subVec4(v2, v1, [0, 0, 0, 0]);
            v3 = SceneJS_math_subVec4(v3, v1, [0, 0, 0, 0]);

            var n = SceneJS_math_normalizeVec4(SceneJS_math_cross3Vec4(v2, v3, [0, 0, 0, 0]), [0, 0, 0, 0]);

            if (!nvecs[j0]) nvecs[j0] = [];
            if (!nvecs[j1]) nvecs[j1] = [];
            if (!nvecs[j2]) nvecs[j2] = [];

            nvecs[j0].push(n);
            nvecs[j1].push(n);
            nvecs[j2].push(n);
        }

        var normals = new Array(positions.length);

        // now go through and average out everything
        for (var i = 0, len = nvecs.length; i < len; i++) {
            var count = nvecs[i].length;
            var x = 0;
            var y = 0;
            var z = 0;
            for (var j = 0; j < count; j++) {
                x += nvecs[i][j][0];
                y += nvecs[i][j][1];
                z += nvecs[i][j][2];
            }
            normals[i * 3 + 0] = (x / count);
            normals[i * 3 + 1] = (y / count);
            normals[i * 3 + 2] = (z / count);
        }
        return normals;
    };

    SceneJS.Geometry.prototype.setSource = function (sourceConfigs) {
        this._sourceConfigs = sourceConfigs;
        var source = this._source;
        if (source && source.configure) {
            source.configure(sourceConfigs);
        }
    };

    SceneJS.Geometry.prototype.getSource = function () {
        return this._sourceConfigs || {};
    };

    SceneJS.Geometry.prototype.setPositions = function (data) {
        if (data.positions && this._core.vertexBuf) {
            var core = this._core;
            core.vertexBuf.bind();
            core.vertexBuf.setData(new Float32Array(data.positions), data.positionsOffset || 0);
            core.arrays.positions.set(data.positions, data.positionsOffset || 0);
            this._engine.display.imageDirty = true;
        }
    };

    SceneJS.Geometry.prototype.getPositions = function () {
        return this._core.arrays ? this._core.arrays.positions : null;
    };

    SceneJS.Geometry.prototype.setNormals = function (data) {
        if (data.normals && this._core.normalBuf) {
            var core = this._core;
            core.normalBuf.bind();
            core.normalBuf.setData(new Float32Array(data.normals), data.normalsOffset || 0);
            core.arrays.normals.set(data.normals, data.normalsOffset || 0);
            this._engine.display.imageDirty = true;
        }
    };

    SceneJS.Geometry.prototype.getNormals = function () {
        return this._core.arrays ? this._core.arrays.normals : null;
    };

    SceneJS.Geometry.prototype.setColors = function (data) {
        if (data.colors && this._core.colorBuf) {
            var core = this._core;
            core.colorBuf.bind();
            core.colorBuf.setData(new Float32Array(data.colors), data.colorsOffset || 0);
            core.arrays.colors.set(data.colors, data.colorsOffset || 0);
            this._engine.display.imageDirty = true;
        }
    };

    SceneJS.Geometry.prototype.getColors = function () {
        return this._core.arrays ? this._core.arrays.colors : null;
    };

    SceneJS.Geometry.prototype.getIndices = function () {
        return this._core.arrays ? this._core.arrays.indices : null;
    };

    SceneJS.Geometry.prototype.setUV = function (data) {
        if (data.uv && this._core.colorBuf) {
            var core = this._core;
            core.colorBuf.bind();
            core.colorBuf.setData(new Float32Array(data.uv), data.uvOffset || 0);
            core.arrays.uv.set(data.uv, data.uvOffset || 0);
            this._engine.display.imageDirty = true;
        }
    };

    SceneJS.Geometry.prototype.getUV = function () {
        return this._core.arrays ? this._core.arrays.uv : null;
    };

    SceneJS.Geometry.prototype.setUV2 = function (data) {
        if (data.uv2 && this._core.colorBuf) {
            var core = this._core;
            core.colorBuf.bind();
            core.colorBuf.setData(new Float32Array(data.uv2), data.uv2Offset || 0);
            core.arrays.uv2.set(data.uv2, data.uv2Offset || 0);
            this._engine.display.imageDirty = true;
        }
    };

    SceneJS.Geometry.prototype.getUV2 = function () {
        return this._core.arrays ? this._core.arrays.uv2 : null;
    };

    SceneJS.Geometry.prototype.getPrimitive = function () {
        return this.primitive;
    };

    SceneJS.Geometry.prototype.getBoundary = function () {
        if (this._boundary) {
            return this._boundary;
        }

        var arrays = this._core.arrays;

        if (!arrays) {
            return null;
        }

        var positions = arrays.positions;

        if (!positions) {
            return null;
        }

        this._boundary = {
            xmin:SceneJS_math_MAX_DOUBLE,
            ymin:SceneJS_math_MAX_DOUBLE,
            zmin:SceneJS_math_MAX_DOUBLE,
            xmax:SceneJS_math_MIN_DOUBLE,
            ymax:SceneJS_math_MIN_DOUBLE,
            zmax:SceneJS_math_MIN_DOUBLE
        };

        var x, y, z;

        for (var i = 0, len = positions.length - 2; i < len; i += 3) {

            x = positions[i];
            y = positions[i + 1];
            z = positions[i + 2];

            if (x < this._boundary.xmin) {
                this._boundary.xmin = x;
            }
            if (y < this._boundary.ymin) {
                this._boundary.ymin = y;
            }
            if (z < this._boundary.zmin) {
                this._boundary.zmin = z;
            }
            if (x > this._boundary.xmax) {
                this._boundary.xmax = x;
            }
            if (y > this._boundary.ymax) {
                this._boundary.ymax = y;
            }
            if (z > this._boundary.zmax) {
                this._boundary.zmax = z;
            }
        }

        return this._boundary;
    };

    SceneJS.Geometry.prototype._compile = function (ctx) {

        if (this._core._loading) { // TODO: Breaks with asynch loaded cores - this node needs to recompile when target core is loaded
            this._compileNodes(ctx);
            return;
        }

        var core = this._core;

        if (!core.vertexBuf) {

            /* SceneJS.Geometry has no vertex buffer - it must be therefore be indexing a vertex/uv buffers defined
             * by a higher Geometry, as part of a composite geometry:
             *
             * It must therefore inherit the vertex buffer, along with UV coord buffers.
             *
             * We'll leave it to the render state graph traversal to ensure that the
             * vertex and UV buffers are not needlessly rebound for this geometry.
             */
            core = this._inheritVBOs(core);
        }

        if (core.indexBuf) { // Can only render when we have indices

            core.hash = ([                           // Safe to build geometry hash here - geometry is immutable
                core.normalBuf ? "t" : "f",
                core.uvBuf ? "t" : "f",
                core.uvBuf2 ? "t" : "f",
                core.colorBuf ? "t" : "f",
                core.primitive
            ]).join("");

            core.stateId = this._core.stateId;
            core.type = "geometry";

            this._engine.display.geometry = coreStack[stackLen++] = core;

            SceneJS_events.fireEvent(SceneJS_events.OBJECT_COMPILING, { // Pull in state updates from scenes nodes
                display:this._engine.display
            });

            this._engine.display.buildObject(this.id); // Use node ID since we may inherit from many cores

        } else {
            coreStack[stackLen++] = this._core;
        }

        this._compileNodes(ctx);

        stackLen--;
    };

    SceneJS.Geometry.prototype._inheritVBOs = function (core) {

        var core2 = {
            primitive:core.primitive,
            boundary:core.boundary,
            normalBuf:core.normalBuf,
            uvBuf:core.uvBuf,
            uvBuf2:core.uvBuf2,
            colorBuf:core.colorBuf,
            indexBuf:core.indexBuf
        };

        for (var i = stackLen - 1; i >= 0; i--) {
            if (coreStack[i].vertexBuf) {
                core2.vertexBuf = coreStack[i].vertexBuf;
                core2.boundary = coreStack[i].boundary;
                core2.normalBuf = coreStack[i].normalBuf;
                core2.uvBuf = coreStack[i].uvBuf;           // Vertex and UVs are a package
                core2.uvBuf2 = coreStack[i].uvBuf2;
                core2.colorBuf = coreStack[i].colorBuf;
                return core2;
            }
        }

        return core2;
    };

    SceneJS.Geometry.prototype._destroy = function () {

        this._engine.display.removeObject(this.id);

        /* Destroy core if no other references
         */
        if (this._core.useCount == 1) {

            this._destroyNodeCore();

            if (this._source && this._source.destroy) {
                this._source.destroy();
            }
        }
    };

    SceneJS.Geometry.prototype._destroyNodeCore = function () {

        if (document.getElementById(this._engine.canvas.canvasId)) { // Context won't exist if canvas has disappeared

            var core = this._core;

            if (core.vertexBuf) {
                core.vertexBuf.destroy();
            }
            if (core.normalBuf) {
                core.normalBuf.destroy();
            }
            if (core.uvBuf) {
                core.uvBuf.destroy();
            }
            if (core.uvBuf2) {
                core.uvBuf2.destroy();
            }
            if (core.colorBuf) {
                core.colorBuf.destroy();
            }
            if (core.indexBuf) {
                core.indexBuf.destroy();
            }
        }
    };

})
    ();(function() {

    /**
     * The default state core singleton for {@link SceneJS.Layer} nodes
     */
    var defaultCore = {
        type: "layer",
        stateId: SceneJS._baseStateId++,
        priority: 0,
        enabled: true
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {
                params.engine.display.layer = defaultCore;
                stackLen = 0;
            });

    /**
     * @class Scene graph node which assigns the {@link SceneJS.Geometry}s within its subgraph to a prioritised render bin
     * @extends SceneJS.Node
     */
    SceneJS.Layer = SceneJS_NodeFactory.createNodeType("layer");

    SceneJS.Layer.prototype._init = function(params) {
        if (this._core.useCount == 1) { // This node defines the resource
            this._core.priority = params.priority || 0;
            this._core.enabled = params.enabled !== false;
        }
    };

    SceneJS.Layer.prototype.setPriority = function(priority) {
        priority = priority || 0;
        if (this._core.priority != priority) {
            this._core.priority = priority;
            this._engine.display.stateOrderDirty = true;
        }
    };

    SceneJS.Layer.prototype.getPriority = function() {
        return this._core.priority;
    };

    SceneJS.Layer.prototype.setEnabled = function(enabled) {
        enabled = !!enabled;
        if (this._core.enabled != enabled) {
            this._core.enabled = enabled;
            this._engine.display.drawListDirty = true;
        }
    };

    SceneJS.Layer.prototype.getEnabled = function() {
        return this._core.enabled;
    };

    SceneJS.Layer.prototype.getEnabled = function() {
        return this._core.enabled;
    };

    SceneJS.Layer.prototype.setClearDepth = function(clearDepth) {
        clearDepth = clearDepth || 0;
        if (this._core.clearDepth != clearDepth) {
            this._core.clearDepth = clearDepth;
            this._engine.display.drawListDirty = true;
        }
    };

    SceneJS.Layer.prototype.getClearDepth = function() {
        return this._core.clearDepth;
    };

    SceneJS.Layer.prototype._compile = function(ctx) {
        this._engine.display.layer = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.layer = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();

/**
 * @class Scene graph node which assigns nodes in its subgraph to a library
 * @extends SceneJS.Node
 */
SceneJS.Library = SceneJS_NodeFactory.createNodeType("library");
SceneJS.Library.prototype._compile = function(ctx) { // Bypass child nodes
};

(function () {

    /**
     * The default state core singleton for {@link SceneJS.Lights} nodes
     */
    var defaultCore = {
        type:"lights",
        stateId:SceneJS._baseStateId++,
        hash:null,
        empty:false,
        lights:[
            {
                mode:"ambient",
                color:[0.7, 0.7, 0.8 ],
                diffuse:true,
                specular:false
            },
            {
                mode:"dir",
                color:[1.0, 1.0, 1.0 ],
                diffuse:true,
                specular:true,
                dir:[-0.5, -0.5, -1.0 ],
                space:"view"
            },
            {
                mode:"dir",
                color:[1.0, 1.0, 1.0 ],
                diffuse:false,
                specular:true,
                dir:[1.0, -0.9, -0.7 ],
                space:"view"
            }
        ]
    };

    makeHash(defaultCore);

    function makeHash(core) {
        if (core.lights && core.lights.length > 0) {
            var lights = core.lights;
            var parts = [];
            var light;
            for (var i = 0, len = lights.length; i < len; i++) {
                light = lights[i];
                parts.push(light.mode);
                if (light.specular) {
                    parts.push("s");
                }
                if (light.diffuse) {
                    parts.push("d");
                }
                parts.push((light.space == "world") ? "w" : "v");
            }
            core.hash = parts.join("");

        } else {
            core.hash = "";
        }
    }

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.lights = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines light sources to illuminate the {@link SceneJS.Geometry}s within its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Lights = SceneJS_NodeFactory.createNodeType("lights");

    SceneJS.Lights.prototype._init = function (params) {

        if (this._core.useCount == 1) { // This node defines the resource

            var lights = params.lights;

            if (!lights) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.NODE_CONFIG_EXPECTED,
                    "lights node attribute missing : 'lights'");
            }

            this._core.lights = this._core.lights || [];

            for (var i = 0, len = lights.length; i < len; i++) {
                this._initLight(i, lights[i]);
            }
        }
    };

    SceneJS.Lights.prototype._initLight = function (index, cfg) {

        var light = [];
        this._core.lights[index] = light;

        var mode = cfg.mode || "dir";
        if (mode != "dir" && mode != "point" && mode != "ambient") {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Light mode not supported - should be 'dir' or 'point' or 'ambient'");
        }

        var pos = cfg.pos;
        var dir = cfg.dir;

        var color = cfg.color;
        light.color = [
            color.r != undefined ? color.r : 1.0,
            color.g != undefined ? color.g : 1.0,
            color.b != undefined ? color.b : 1.0
        ];

        // Ambient lights hardwired to contribute to diffuse lighting
        light.mode = mode;
        light.diffuse = (mode == "ambient") ? true : ((cfg.diffuse != undefined) ? cfg.diffuse : true);
        light.specular = (mode == "ambient") ? false : ((cfg.specular != undefined) ? cfg.specular : true);
        light.pos = cfg.pos ? [ pos.x || 0, pos.y || 0, pos.z || 0 ] : undefined;
        light.dir = cfg.dir ? [dir.x || 0, dir.y || 0, dir.z || 0] : undefined;
        light.attenuation = [
            cfg.constantAttenuation != undefined ? cfg.constantAttenuation : 0.0,
            cfg.linearAttenuation || 0.0,
            cfg.quadraticAttenuation || 0.0
        ];

        var space = cfg.space;

        if (!space) {

            space = "world";

        } else if (space != "view" && space != "world") {

            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "lights node invalid value for property 'space': '" + space + "' - should be 'view' or 'world'");
        }

        light.space = space;

        this._core.hash = null;
    };


    SceneJS.Lights.prototype.setLights = function (lights) {
        var indexNum;
        for (var index in lights) {
            if (lights.hasOwnProperty(index)) {
                if (index != undefined || index != null) {
                    indexNum = parseInt(index);
                    if (indexNum < 0 || indexNum >= this._core.lights.length) {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.ILLEGAL_NODE_CONFIG,
                            "Invalid argument to set 'lights': index out of range (" + this._core.lights.length + " lights defined)");
                    }
                    this._setLight(indexNum, lights[index] || {});
                }
            }
        }
        this._engine.branchDirty(this); // Schedule recompilation of this subgraph
    };

    SceneJS.Lights.prototype._setLight = function (index, cfg) {

        var light = this._core.lights[index];

        // Impact of light update
        var imageDirty = false; // Redraw display list?
        var branchDirty = false; // Recompile scene branch?

        if (cfg.mode && cfg.mode != light.mode) {
            var mode = cfg.mode;
            if (mode != "dir" && mode != "point" && mode != "ambient") {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "Light mode not supported - should be 'dir' or 'point' or 'ambient'");
            }
            light.mode = mode;
            light.diffuse = (mode == "ambient") ? true : ((cfg.diffuse != undefined) ? cfg.diffuse : true);
            light.specular = (mode == "ambient") ? false : ((cfg.specular != undefined) ? cfg.specular : true);
            branchDirty = true;
        }

        if (cfg.color) {
            var color = cfg.color;
            light.color = [
                color.r != undefined ? color.r : 1.0,
                color.g != undefined ? color.g : 1.0,
                color.b != undefined ? color.b : 1.0
            ];
            imageDirty = true;
        }

        var pos = cfg.pos;
        if (pos) {
            light.pos = [ pos.x || 0, pos.y || 0, pos.z || 0 ];
            imageDirty = true;
        }

        var dir = cfg.dir;
        if (dir) {
            light.dir = [dir.x || 0, dir.y || 0, dir.z || 0];
            imageDirty = true;
        }

        if (cfg.constantAttenuation != undefined) {
            light.attenuation[0] = cfg.constantAttenuation;
            imageDirty = true;
        }
        if (cfg.linearAttenuation != undefined) {
            light.attenuation[1] = cfg.linearAttenuation;
            imageDirty = true;
        }
        if (cfg.quadraticAttenuation != undefined) {
            light.attenuation[2] = cfg.quadraticAttenuation;
            imageDirty = true;
        }

        if (cfg.space && cfg.space != light.space) {
            var space = cfg.space;
            if (space != "view" && space != "world") {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "lights node invalid value for property 'space': '" + space + "' - should be 'view' or 'world'");
            }
            light.space = space;
            this._core.hash = null;
            branchDirty = true;
        }

        if (cfg.specular != light.specular) {
            light.specular = cfg.specular;
            branchDirty = true;
        }
        if (cfg.diffuse != light.diffuse) {
            light.diffuse = cfg.diffuse;
            branchDirty = true;
        }

        if (branchDirty) {
            this._engine.branchDirty(this); // Schedule recompilation of this subgraph
        } else if (imageDirty) {
            this._engine.display.imageDirty = true;
        }

        this._core.hash = null;
    };

    SceneJS.Lights.prototype._compile = function (ctx) {

        if (!this._core.hash) {
            makeHash(this._core);
        }

        this._engine.display.lights = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.lights = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();(function () {

    var defaultMatrix = SceneJS_math_lookAtMat4c(0, 0, 10, 0, 0, 0, 0, 1, 0);
    var defaultMat = new Float32Array(defaultMatrix);
    var normalMat = SceneJS_math_transposeMat4(SceneJS_math_inverseMat4(defaultMat, SceneJS_math_mat4()));
    var defaultNormalMat = new Float32Array(normalMat);

    /**
     * The default state core singleton for {@link SceneJS.Lookat} nodes
     */
    var defaultCore = {
        type:"lookAt",
        stateId:SceneJS._baseStateId++,
        matrix:defaultMatrix,
        mat:defaultMat,
        normalMatrix:normalMat,
        normalMat:defaultNormalMat,
        lookAt:SceneJS_math_LOOKAT_ARRAYS
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.viewTransform = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines the viewing transform for the {@link SceneJS.Geometry}s within its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Lookat = SceneJS_NodeFactory.createNodeType("lookAt");

    SceneJS.Lookat.prototype._init = function (params) {

        this._mat = null;

        this._xf = {
            type:"lookat"
        };

        if (this._core.useCount == 1) { // This node is the resource definer

            this._core.eyeX = 0;
            this._core.eyeY = 0;
            this._core.eyeZ = 10.0;

            this._core.lookX = 0;
            this._core.lookY = 0;
            this._core.lookZ = 0;

            this._core.upX = 0;
            this._core.upY = 1;
            this._core.upZ = 0;

            if (!params.eye && !params.look && !params.up) {
                this.setEye({x:0, y:0, z:10.0 });
                this.setLook({x:0, y:0, z:0 });
                this.setUp({x:0, y:1.0, z:0 });
            } else {
                this.setEye(params.eye);
                this.setLook(params.look);
                this.setUp(params.up);
            }

            var core = this._core;

            var self = this;

            this._core.rebuild = function () {

                core.matrix = SceneJS_math_lookAtMat4c(
                    core.eyeX, core.eyeY, core.eyeZ,
                    core.lookX, core.lookY, core.lookZ,
                    core.upX, core.upY, core.upZ);

                core.lookAt = {
                    eye:[core.eyeX, core.eyeY, core.eyeZ ],
                    look:[core.lookX, core.lookY, core.lookZ ],
                    up:[core.upX, core.upY, core.upZ ]
                };

                if (!core.mat) { // Lazy-create arrays
                    core.mat = new Float32Array(core.matrix);
                    core.normalMat = new Float32Array(
                        SceneJS_math_transposeMat4(SceneJS_math_inverseMat4(core.matrix, SceneJS_math_mat4())));

                } else { // Insert into arrays
                    core.mat.set(core.matrix);
                    core.normalMat.set(SceneJS_math_transposeMat4(SceneJS_math_inverseMat4(core.matrix, SceneJS_math_mat4())));
                }

                self.publish("matrix", core.matrix);

                core.dirty = false;
            };

            this._core.dirty = true;

            // Rebuild on every scene tick
            // https://github.com/xeolabs/scenejs/issues/277
            this._tick = this.getScene().on("tick", function () {
                if (self._core.dirty) {
                    self._core.rebuild();
                }
            });
        }
    };

    /**
     * Returns the default view transformation matrix
     * @return {Float32Array}
     */
    SceneJS.Lookat.getDefaultMatrix = function () {
        return defaultMat;
    };

    SceneJS.Lookat.prototype.setEye = function (eye) {

        eye = eye || {};

        if (eye.x != undefined && eye.x != null) {
            this._core.eyeX = eye.x;
        }

        if (eye.y != undefined && eye.y != null) {
            this._core.eyeY = eye.y;
        }

        if (eye.z != undefined && eye.z != null) {
            this._core.eyeZ = eye.z;
        }

        this._core.dirty = true;
        this._engine.display.imageDirty = true;

        return this;
    };

    SceneJS.Lookat.prototype.incEye = function (eye) {
        eye = eye || {};
        this._core.eyeX += (eye.x != undefined && eye.x != null) ? eye.x : 0;
        this._core.eyeY += (eye.y != undefined && eye.y != null) ? eye.y : 0;
        this._core.eyeZ += (eye.z != undefined && eye.z != null) ? eye.z : 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setEyeX = function (x) {
        this._core.eyeX = x || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setEyeY = function (y) {
        this._core.eyeY = y || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setEyeZ = function (z) {
        this._core.eyeZ = z || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incEyeX = function (x) {
        this._core.eyeX += x;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incEyeY = function (y) {
        this._core.eyeY += y;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incEyeZ = function (z) {
        this._core.eyeZ += z;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.getEye = function () {
        return {
            x:this._core.eyeX,
            y:this._core.eyeY,
            z:this._core.eyeZ
        };
    };

    SceneJS.Lookat.prototype.setLook = function (look) {
        look = look || {};

        if (look.x != undefined && look.x != null) {
            this._core.lookX = look.x;
        }

        if (look.y != undefined && look.y != null) {
            this._core.lookY = look.y;
        }

        if (look.z != undefined && look.z != null) {
            this._core.lookZ = look.z;
        }

        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incLook = function (look) {
        look = look || {};
        this._core.lookX += (look.x != undefined && look.x != null) ? look.x : 0;
        this._core.lookY += (look.y != undefined && look.y != null) ? look.y : 0;
        this._core.lookZ += (look.z != undefined && look.z != null) ? look.z : 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setLookX = function (x) {
        this._core.lookX = x || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setLookY = function (y) {
        this._core.lookY = y || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setLookZ = function (z) {
        this._core.lookZ = z || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incLookX = function (x) {
        this._core.lookX += x;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incLookY = function (y) {
        this._core.lookY += y;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incLookZ = function (z) {
        this._core.lookZ += z;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.getLook = function () {
        return {
            x:this._core.lookX,
            y:this._core.lookY,
            z:this._core.lookZ
        };
    };

    SceneJS.Lookat.prototype.setUp = function (up) {
        up = up || {};

        if (up.x != undefined && up.x != null) {
            this._core.upX = up.x;
        }

        if (up.y != undefined && up.y != null) {
            this._core.upY = up.y;
        }

        if (up.z != undefined && up.z != null) {
            this._core.upZ = up.z;
        }

        this._core.dirty = true;
        this._engine.display.imageDirty = true;

        return this;
    };

    SceneJS.Lookat.prototype.incUp = function (up) {
        up = up || {};
        this._core.upX += (up.x != undefined && up.x != null) ? up.x : 0;
        this._core.upY += (up.y != undefined && up.y != null) ? up.y : 0;
        this._core.upZ += (up.z != undefined && up.z != null) ? up.z : 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setUpX = function (x) {
        this._core.upX = x || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setUpY = function (y) {
        this._core.upY = y || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.setUpZ = function (z) {
        this._core.upZ = z || 0;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incUpX = function (x) {
        this._core.upX += x;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incUpY = function (y) {
        this._core.upY += y;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.incUpZ = function (z) {
        this._core.upZ += z;
        this._core.dirty = true;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Lookat.prototype.getUp = function () {
        return {
            x:this._core.upX,
            y:this._core.upY,
            z:this._core.upZ
        };
    };

    /**
     * Returns a copy of the matrix as a 1D array of 16 elements
     * @returns {Number[16]}
     */
    SceneJS.Lookat.prototype.getMatrix = function () {

        if (this._core.dirty) {
            this._core.rebuild();
        }

        return  this._mat.slice(0);
    };

    SceneJS.Lookat.prototype.getAttributes = function () {
        return {
            look:{
                x:this._core.lookX,
                y:this._core.lookY,
                z:this._core.lookZ
            },
            eye:{
                x:this._core.eyeX,
                y:this._core.eyeY,
                z:this._core.eyeZ
            },
            up:{
                x:this._core.upX,
                y:this._core.upY,
                z:this._core.upZ
            }
        };
    };

    SceneJS.Lookat.prototype._compile = function (ctx) {
        this._engine.display.viewTransform = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.viewTransform = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

    SceneJS.Lookat.prototype._destroy = function () {
        // Stop publishing matrix on each tick
        this.getScene().off(this._tick);
    };

})();/*

 TODO: material system from virtualworldframework:

 "color":
 "ambient":
 "specColor":
 "shininess":
 "reflect":
 "specular":
 "emit":
 "alpha":
 "binaryAlpha":
 */
new (function () {

    /**
     * The default state core singleton for {@link SceneJS.Material} nodes
     */
    var defaultCore = {
        type:"material",
        stateId:SceneJS._baseStateId++,
        baseColor:[ 1.0, 1.0, 1.0 ],
        specularColor:[ 1.0, 1.0, 1.0 ],
        specular:1.0,
        shine:70.0,
        alpha:1.0,
        emit:0.0
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.material = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines surface material properties for the {@link SceneJS.Geometry}s within its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Material = SceneJS_NodeFactory.createNodeType("material");

    SceneJS.Material.prototype._init = function (params) {
        if (this._core.useCount == 1) {
            this.setBaseColor(params.color || params.baseColor);
            this.setSpecularColor(params.specularColor);
            this.setSpecular(params.specular);
            this.setShine(params.shine);
            this.setEmit(params.emit);
            this.setAlpha(params.alpha);
        }
    };

    /**
     * @deprecated
     * @param color
     * @return {*}
     */
    SceneJS.Material.prototype.setBaseColor = function (color) {
        var defaultBaseColor = defaultCore.baseColor;
        this._core.baseColor = color ? [
            color.r != undefined && color.r != null ? color.r : defaultBaseColor[0],
            color.g != undefined && color.g != null ? color.g : defaultBaseColor[1],
            color.b != undefined && color.b != null ? color.b : defaultBaseColor[2]
        ] : defaultCore.baseColor;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.setColor = SceneJS.Material.prototype.setBaseColor;

    /**
     * @deprecated
     * @return {Object}
     */
    SceneJS.Material.prototype.getBaseColor = function () {
        return {
            r:this._core.baseColor[0],
            g:this._core.baseColor[1],
            b:this._core.baseColor[2]
        };
    };

    SceneJS.Material.prototype.getColor = SceneJS.Material.prototype.getBaseColor;

    SceneJS.Material.prototype.setSpecularColor = function (color) {
        var defaultSpecularColor = defaultCore.specularColor;
        this._core.specularColor = color ? [
            color.r != undefined && color.r != null ? color.r : defaultSpecularColor[0],
            color.g != undefined && color.g != null ? color.g : defaultSpecularColor[1],
            color.b != undefined && color.b != null ? color.b : defaultSpecularColor[2]
        ] : defaultCore.specularColor;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.getSpecularColor = function () {
        return {
            r:this._core.specularColor[0],
            g:this._core.specularColor[1],
            b:this._core.specularColor[2]
        };
    };

    SceneJS.Material.prototype.setSpecular = function (specular) {
        this._core.specular = (specular != undefined && specular != null) ? specular : defaultCore.specular;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.getSpecular = function () {
        return this._core.specular;
    };

    SceneJS.Material.prototype.setShine = function (shine) {
        this._core.shine = (shine != undefined && shine != null) ? shine : defaultCore.shine;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.getShine = function () {
        return this._core.shine;
    };

    SceneJS.Material.prototype.setEmit = function (emit) {
        this._core.emit = (emit != undefined && emit != null) ? emit : defaultCore.emit;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.getEmit = function () {
        return this._core.emit;
    };

    SceneJS.Material.prototype.setAlpha = function (alpha) {
        this._core.alpha = (alpha != undefined && alpha != null) ? alpha : defaultCore.alpha;
        this._engine.display.imageDirty = true;
        return this;
    };

    SceneJS.Material.prototype.getAlpha = function () {
        return this._core.alpha;
    };

    SceneJS.Material.prototype._compile = function (ctx) {
        this._engine.display.material = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.material = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();new (function () {

    /**
     * The default state core singleton for {@link SceneJS.MorphGeometry} nodes
     */
    var defaultCore = {
        type:"morphGeometry",
        stateId:SceneJS._baseStateId++,
        hash:"",
        //         empty: true,
        morph:null
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.morphGeometry = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines morphing behaviour for the {@link SceneJS.Geometry}s within its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.MorphGeometry = SceneJS_NodeFactory.createNodeType("morphGeometry");

    SceneJS.MorphGeometry.prototype._init = function (params) {

        if (this._core.useCount == 1) { // This node defines the resource

            this._sourceConfigs = params.source;
            this._source = null;

            if (params.source) {

                /*---------------------------------------------------------------------------------------------------
                 * Build node core (possibly asynchronously) using a factory object
                 *--------------------------------------------------------------------------------------------------*/

                if (!params.source.type) {
                    throw SceneJS_error.fatalError(
                        SceneJS.errors.ILLEGAL_NODE_CONFIG,
                        "morphGeometry config expected: source.type");
                }

                var self = this;

                SceneJS.Plugins.getPlugin(
                    "morphGeometry",
                    this._sourceConfigs.type,
                    function (sourceService) {

                        if (!sourceService) {
                            throw SceneJS_error.fatalError(
                                SceneJS.errors.PLUGIN_INVALID,
                                "morphGeometry: no support for source type '" + self._sourceConfigs.type + "' - need to include plugin for self source type, " +
                                    "or install a custom source service with SceneJS.Plugins.addPlugin(SceneJS.Plugins.MORPH_GEO_SOURCE_PLUGIN, '" + self._sourceConfigs.type + "', <your service>).");
                        }

                        if (!sourceService.getSource) {
                            throw SceneJS_error.fatalError(
                                SceneJS.errors.PLUGIN_INVALID,
                                "morphGeometry: 'getSource' method not found on MorphGeoFactoryService (SceneJS.Plugins.MORPH_GEO_SOURCE_PLUGIN)");
                        }

                        self._source = sourceService.getSource();

                        if (!self._source.subscribe) {
                            throw SceneJS_error.fatalError(
                                SceneJS.errors.PLUGIN_INVALID,
                                "morphGeometry: 'subscribe' method not found on source provided by plugin type '" + params.source.type + "'");
                        }

                        var created = false;

                        self._source.subscribe(// Get notification when factory creates the morph
                            function (data) {

                                if (!created) {
                                    self._buildNodeCore(data);

                                    self._core._loading = false;
                                    self._fireEvent("loaded");

                                    self._engine.branchDirty(self); // TODO

                                    created = true;

                                } else {

                                    if (data.targets) {

                                        var dataTargets = data.targets;
                                        var dataTarget;
                                        var index;
                                        var morphTargets = self._core.targets;
                                        var morphTarget;

                                        for (var i = 0, len = dataTargets.length; i < len; i++) {
                                            dataTarget = dataTargets[i];
                                            index = dataTarget.targetIndex;
                                            morphTarget = morphTargets[index];

                                            if (dataTarget.positions && morphTarget.vertexBuf) {
                                                morphTarget.vertexBuf.bind();
                                                morphTarget.vertexBuf.setData(dataTarget.positions, 0);
                                            }
                                        }
                                    }

                                    // TODO: factory can update factor?
                                    // self.setFactor(params.factor);

                                    self._display.imageDirty = true;
                                }
                            });

                        self._core._loading = true;

                        self._fireEvent("loading");

                        self._source.configure(self._sourceConfigs);
                    });

            } else if (params.create instanceof Function) {

                /*---------------------------------------------------------------------------------------------------
                 * Build node core from JSON arrays and primitive name returned by factory function
                 *--------------------------------------------------------------------------------------------------*/

                this._buildNodeCore(params.create());

            } else {

                /*---------------------------------------------------------------------------------------------------
                 * Build node core from JSON arrays and primitive name given in node properties
                 *--------------------------------------------------------------------------------------------------*/

                this._buildNodeCore(params);
            }

            this._core.webglRestored = function () {
                //self._buildNodeCore(self._engine.canvas.gl, self._core);
            };

            this.setFactor(params.factor);
        }

        // TODO: factor shared on cores?
        this._core.factor = params.factor || 0;
        this._core.clamp = !!params.clamp;
    };

    SceneJS.MorphGeometry.prototype._buildNodeCore = function (data) {

        var targetsData = data.targets || [];
        if (targetsData.length < 2) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "morphGeometry node should have at least two targets");
        }

        var keysData = data.keys || [];
        if (keysData.length != targetsData.length) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "morphGeometry node mismatch in number of keys and targets");
        }

        var core = this._core;
        var gl = this._engine.canvas.gl;
        var usage = gl.STATIC_DRAW; //var usage = (!arrays.fixed) ? gl.STREAM_DRAW : gl.STATIC_DRAW;

        core.keys = keysData;
        core.targets = [];
        core.key1 = 0;
        core.key2 = 1;

        /* First target's arrays are defaults for where not given on previous and subsequent targets.
         * When target does have array, subsequent targets without array inherit it.
         */

        var positions;
        var normals;
        var uv;
        var uv2;

        var targetData;

        for (var i = 0, len = targetsData.length; i < len; i++) {
            targetData = targetsData[i];
            if (!positions && targetData.positions) {
                positions = targetData.positions;
            }
            if (!normals && targetData.normals) {
                normals = targetData.normals;
            }
            if (!uv && targetData.uv) {
                uv = targetData.uv;
            }
            if (!uv2 && targetData.uv2) {
                uv2 = targetData.uv2;
            }
        }

        try {
            var target;
            var arry;

            for (var i = 0, len = targetsData.length; i < len; i++) {
                targetData = targetsData[i];
                target = {};

                arry = targetData.positions || positions;
                if (arry) {
                    target.positions = (typeof arry == "Float32Array") ? arry : new Float32Array(arry);
                    target.vertexBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, target.positions, arry.length, 3, usage);
                    positions = arry;
                }

                arry = targetData.normals || normals;
                if (arry) {
                    target.normals = (typeof arry == "Float32Array") ? arry : new Float32Array(arry);
                    target.normalBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, target.normals, arry.length, 3, usage);
                    normals = arry;
                }

                arry = targetData.uv || uv;
                if (arry) {
                    target.uv = (typeof arry == "Float32Array") ? arry : new Float32Array(arry);
                    target.uvBuf = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, target.uv, arry.length, 2, usage);
                    uv = arry;
                }

                arry = targetData.uv2 || uv2;
                if (arry) {
                    target.uv2 = (typeof arry == "Float32Array") ? arry : new Float32Array(arry);
                    target.uvBuf2 = new SceneJS_webgl_ArrayBuffer(gl, gl.ARRAY_BUFFER, target.uv2, arry.length, 2, usage);
                    uv2 = arry;
                }

                core.targets.push(target);  // We'll iterate this to destroy targets when we recover from error
            }

        } catch (e) {

            /* Allocation failure - deallocate target VBOs
             */
            for (var i = 0, len = core.targets.length; i < len; i++) {

                target = core.targets[i];

                if (target.vertexBuf) {
                    target.vertexBuf.destroy();
                }
                if (target.normalBuf) {
                    target.normalBuf.destroy();
                }
                if (target.uvBuf) {
                    target.uvBuf.destroy();
                }
                if (target.uvBuf2) {
                    target.uvBuf2.destroy();
                }
            }

            throw SceneJS_error.fatalError(
                SceneJS.errors.ERROR,
                "Failed to allocate VBO(s) for morphGeometry: " + e);
        }
    };

    SceneJS.MorphGeometry.prototype.setSource = function (sourceConfigs) {
        this._sourceConfigs = sourceConfigs;
        var source = this._source;
        if (source) {
            source.configure(sourceConfigs);
        }
    };

    SceneJS.MorphGeometry.prototype.getSource = function () {
        return this._sourceConfigs;
    };

    SceneJS.MorphGeometry.prototype.setFactor = function (factor) {
        factor = factor || 0.0;

        var core = this._core;

        var keys = core.keys;
        var key1 = core.key1;
        var key2 = core.key2;

        if (factor < keys[0]) {
            key1 = 0;
            key2 = 1;

        } else if (factor > keys[keys.length - 1]) {
            key1 = keys.length - 2;
            key2 = key1 + 1;

        } else {
            while (keys[key1] > factor) {
                key1--;
                key2--;
            }
            while (keys[key2] < factor) {
                key1++;
                key2++;
            }
        }

        /* Normalise factor to range [0.0..1.0] for the target frame
         */
        core.factor = (factor - keys[key1]) / (keys[key2] - keys[key1]);
        core.key1 = key1;
        core.key2 = key2;

        this._engine.display.imageDirty = true;
    };

    SceneJS.MorphGeometry.prototype.getFactor = function () {
        return this._core.factor;
    };

    SceneJS.MorphGeometry.prototype.getKeys = function () {
        return this._core.keys;
    };

    SceneJS.MorphGeometry.prototype.getTargets = function () {
        return this._core.targets;
    };

    SceneJS.MorphGeometry.prototype._compile = function (ctx) {

        if (!this._core.hash) {
            this._makeHash();
        }

        this._engine.display.morphGeometry = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.morphGeometry = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

    SceneJS.MorphGeometry.prototype._makeHash = function () {
        var core = this._core;
        if (core.targets.length > 0) {
            var target0 = core.targets[0];  // All targets have same arrays
            var t = "t";
            var f = "f";
            core.hash = ([
                target0.vertexBuf ? t : f,
                target0.normalBuf ? t : f,
                target0.uvBuf ? t : f,
                target0.uvBuf2 ? t : f
            ]).join("");
        } else {
            core.hash = "";
        }
    };

    SceneJS.MorphGeometry.prototype._destroy = function () {
        if (this._core.useCount == 1) { // Destroy core if no other references
            if (document.getElementById(this._engine.canvas.canvasId)) { // Context won't exist if canvas has disappeared
                var core = this._core;
                var target;
                for (var i = 0, len = core.targets.length; i < len; i++) {
                    target = core.targets[i];
                    if (target.vertexBuf) {
                        target.vertexBuf.destroy();
                    }
                    if (target.normalBuf) {
                        target.normalBuf.destroy();
                    }
                    if (target.uvBuf) {
                        target.uvBuf.destroy();
                    }
                    if (target.uvBuf2) {
                        target.uvBuf2.destroy();
                    }
                }
            }
            if (this._source && this._source.destroy) {
                this._source.destroy();
            }
        }
    };

})();(function () {

    /**
     * The default state core singleton for {@link SceneJS.Name} nodes
     */
    var defaultCore = {
        type:"name",
        stateId:SceneJS._baseStateId++,
        name:null
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.name = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which assigns a pick name to the {@link SceneJS.Geometry} nodes in its subgraph.
     * @extends SceneJS.Node
     */
    SceneJS.Name = SceneJS_NodeFactory.createNodeType("name");

    SceneJS.Name.prototype._init = function (params) {
        this.setName(params.name);
        this._core.nodeId = this.id;
    };

    SceneJS.Name.prototype.setName = function (name) {
        this._core.name = name || "unnamed";
        this._engine.display.imageDirty = true;
    };

    SceneJS.Name.prototype.getName = function () {
        return this._core.name;
    };

    SceneJS.Name.prototype._compile = function (ctx) {

        this._engine.display.name = coreStack[stackLen++] = this._core;

        // (Re)build name path
        var path = [];
        var name;
        for (var i = 0; i < stackLen; i++) {
            name = coreStack[i].name;
            if (name) {
                path.push(name);
            }
        }
        this._core.path = path.join(".");

        this._compileNodes(ctx);
        this._engine.display.name = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };
})();new (function() {

    /**
     * The default state core singleton for {@link SceneJS.Renderer} nodes
     */
    var defaultCore = {
        type: "renderer",
        stateId: SceneJS._baseStateId++,
        props: null
    };

    var canvas;         // Currently active canvas
    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {

                canvas = params.engine.canvas;

//                // TODO: Below is a HACK
//
//                defaultCore.props = createProps({  // Dont set props - just define for restoring to on props pop
//                    clear: {
//                        depth : true,
//                        color : true
//                    },
//                    // clearColor: {r: 0, g : 0, b : 0 },
//                    clearDepth: 1.0,
//                    enableDepthTest:true,
//                    enableCullFace: false,
//                    frontFace: "ccw",
//                    cullFace: "back",
//                    depthFunc: "less",
//                    depthRange: {
//                        zNear: 0,
//                        zFar: 1
//                    },
//                    enableScissorTest: false,
//                    viewport:{
//                        x : 1,
//                        y : 1,
//                        width: canvas.canvas.width,
//                        height: canvas.canvas.height
//                    },
//                    enableClip: undefined,
//                    enableBlend: false,
//                    blendFunc: {
//                        sfactor: "srcAlpha",
//                        dfactor: "one"
//                    }
//                });

                stackLen = 0;

                params.engine.display.renderer = coreStack[stackLen++] = defaultCore;
            });

    function createProps(props) {

        var restore;
        if (stackLen > 0) {  // can't restore when no previous props set
            restore = {};
            for (var name in props) {
                if (props.hasOwnProperty(name)) {
                    if (!(props[name] == undefined)) {
                        restore[name] = getSuperProperty(name);
                    }
                }
            }
        }

        processProps(props.props);

        return {

            props: props,

            setProps: function(gl) {
                setProperties(gl, props);
            },

            restoreProps : function(gl) {
                if (restore) {
                    restoreProperties(gl, restore);
                }
            }
        };
    }

    var getSuperProperty = function(name) {
        var props;
        var prop;
        for (var i = stackLen - 1; i >= 0; i--) {
            props = coreStack[i].props;
            prop = props[name];
            if (prop != undefined && prop != null) {
                return props[name];
            }
        }
        return null; // Cause default to be set
    };

    function processProps(props) {
        var prop;
        for (var name in props) {
            if (props.hasOwnProperty(name)) {
                prop = props[name];
                if (prop != undefined && prop != null) {
                    if (glModeSetters[name]) {
                        props[name] = glModeSetters[name](null, prop);
                    } else if (glStateSetters[name]) {
                        props[name] = glStateSetters[name](null, prop);
                    }
                }
            }
        }
    }

    var setProperties = function(gl, props) {

        for (var key in props) {        // Set order-insensitive properties (modes)
            if (props.hasOwnProperty(key)) {
                var setter = glModeSetters[key];
                if (setter) {
                    setter(gl, props[key]);
                }
            }
        }

        if (props.viewport) {           // Set order-sensitive properties (states)
            glStateSetters.viewport(gl, props.viewport);
        }

        if (props.scissor) {
            glStateSetters.clear(gl, props.scissor);
        }

        if (props.clear) {
            glStateSetters.clear(gl, props.clear);
        }
    };

    /**
     * Restores previous renderer properties, except for clear - that's the reason we
     * have a seperate set and restore semantic - we don't want to keep clearing the buffer.
     */
    var restoreProperties = function(gl, props) {

        var value;

        for (var key in props) {            // Set order-insensitive properties (modes)
            if (props.hasOwnProperty(key)) {
                value = props[key];
                if (value != undefined && value != null) {
                    var setter = glModeSetters[key];
                    if (setter) {
                        setter(gl, value);
                    }
                }
            }
        }

        if (props.viewport) {               //  Set order-sensitive properties (states)
            glStateSetters.viewport(gl, props.viewport);
        }

        if (props.scissor) {
            glStateSetters.clear(gl, props.scissor);
        }
    };


    /**
     * Maps renderer node properties to WebGL gl enums
     * @private
     */
    var glEnum = function(gl, name) {
        if (!name) {
            throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "Null SceneJS.State node config: \"" + name + "\"");
        }
        var result = SceneJS_webgl_enumMap[name];
        if (!result) {
            throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "Unrecognised SceneJS.State node config value: \"" + name + "\"");
        }
        var value = gl[result];
        if (!value) {
            throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "This browser's WebGL does not support renderer node config value: \"" + name + "\"");
        }
        return value;
    };


    /**
     * Order-insensitive functions that set WebGL modes ie. not actually causing an
     * immediate change.
     *
     * These map to renderer properties and are called in whatever order their
     * property is found on the renderer config.
     *
     * Each of these wrap a state-setter function on the WebGL gl. Each function
     * also uses the glEnum map to convert its renderer node property argument to the
     * WebGL enum constant required by its wrapped function.
     *
     * When called with undefined/null gl, will condition and return the value given
     * ie. set it to default if value is undefined. When called with a gl, will
     * set the value on the gl using the wrapped function.
     *
     * @private
     */
    var glModeSetters = {

        enableBlend: function(gl, flag) {
            if (!gl) {
                if (flag == null || flag == undefined) {
                    flag = false;
                }
                return flag;
            }
            if (flag) {
                gl.enable(gl.BLEND);
            } else {
                gl.disable(gl.BLEND);
            }
        },

        blendColor: function(gl, color) {
            if (!gl) {
                color = color || {};
                return {
                    r: color.r || 0,
                    g: color.g || 0,
                    b: color.b || 0,
                    a: (color.a == undefined || color.a == null) ? 1 : color.a
                };
            }
            gl.blendColor(color.r, color.g, color.b, color.a);
        },

        blendEquation: function(gl, eqn) {
            if (!gl) {
                return eqn || "funcAdd";
            }
            gl.blendEquation(gl, glEnum(gl, eqn));
        },

        /** Sets the RGB blend equation and the alpha blend equation separately
         */
        blendEquationSeparate: function(gl, eqn) {
            if (!gl) {
                eqn = eqn || {};
                return {
                    rgb : eqn.rgb || "funcAdd",
                    alpha : eqn.alpha || "funcAdd"
                };
            }
            gl.blendEquation(glEnum(gl, eqn.rgb), glEnum(gl, eqn.alpha));
        },

        blendFunc: function(gl, funcs) {
            if (!gl) {
                funcs = funcs || {};
                return  {
                    sfactor : funcs.sfactor || "srcAlpha",
                    dfactor : funcs.dfactor || "oneMinusSrcAlpha"
                };
            }
            gl.blendFunc(glEnum(gl, funcs.sfactor || "srcAlpha"), glEnum(gl, funcs.dfactor || "oneMinusSrcAlpha"));
        },

        blendFuncSeparate: function(gl, func) {
            if (!gl) {
                func = func || {};
                return {
                    srcRGB : func.srcRGB || "zero",
                    dstRGB : func.dstRGB || "zero",
                    srcAlpha : func.srcAlpha || "zero",
                    dstAlpha :  func.dstAlpha || "zero"
                };
            }
            gl.blendFuncSeparate(
                    glEnum(gl, func.srcRGB || "zero"),
                    glEnum(gl, func.dstRGB || "zero"),
                    glEnum(gl, func.srcAlpha || "zero"),
                    glEnum(gl, func.dstAlpha || "zero"));
        },

        clearColor: function(gl, color) {
            if (!gl) {
                color = color || {};
                return {
                    r : color.r || 0,
                    g : color.g || 0,
                    b : color.b || 0,
                    a : (color.a == undefined || color.a == null) ? 1 : color.a
                };
            }
            gl.clearColor(color.r, color.g, color.b, color.a);
        },

        clearDepth: function(gl, depth) {
            if (!gl) {
                return (depth == null || depth == undefined) ? 1 : depth;
            }
            gl.clearDepth(depth);
        },

        clearStencil: function(gl, clearValue) {
            if (!gl) {
                return  clearValue || 0;
            }
            gl.clearStencil(clearValue);
        },

        colorMask: function(gl, color) {
            if (!gl) {
                color = color || {};
                return {
                    r : color.r || 0,
                    g : color.g || 0,
                    b : color.b || 0,
                    a : (color.a == undefined || color.a == null) ? 1 : color.a
                };

            }
            gl.colorMask(color.r, color.g, color.b, color.a);
        },

        enableCullFace: function(gl, flag) {
            if (!gl) {
                return flag;
            }
            if (flag) {
                gl.enable(gl.CULL_FACE);
            } else {
                gl.disable(gl.CULL_FACE);
            }
        },

        cullFace: function(gl, mode) {
            if (!gl) {
                return mode || "back";
            }
            gl.cullFace(glEnum(gl, mode));
        },

        enableDepthTest: function(gl, flag) {
            if (!gl) {
                if (flag == null || flag == undefined) {
                    flag = true;
                }
                return flag;
            }
            if (flag) {
                gl.enable(gl.DEPTH_TEST);
            } else {
                gl.disable(gl.DEPTH_TEST);
            }
        },

        depthFunc: function(gl, func) {
            if (!gl) {
                return func || "less";
            }
            gl.depthFunc(glEnum(gl, func));
        },

        enableDepthMask: function(gl, flag) {
            if (!gl) {
                if (flag == null || flag == undefined) {
                    flag = true;
                }
                return flag;
            }
            gl.depthMask(flag);
        },

        depthRange: function(gl, range) {
            if (!gl) {
                range = range || {};
                return {
                    zNear : (range.zNear == undefined || range.zNear == null) ? 0 : range.zNear,
                    zFar : (range.zFar == undefined || range.zFar == null) ? 1 : range.zFar
                };
            }
            gl.depthRange(range.zNear, range.zFar);
        } ,

        frontFace: function(gl, mode) {
            if (!gl) {
                return mode || "ccw";
            }
            gl.frontFace(glEnum(gl, mode));
        },

        lineWidth: function(gl, width) {
            if (!gl) {
                return width || 1;
            }
            gl.lineWidth(width);
        },

        enableScissorTest: function(gl, flag) {
            if (!gl) {
                return flag;
            }
            if (flag) {
                gl.enable(gl.SCISSOR_TEST);
            } else {
                flag = false;
                gl.disable(gl.SCISSOR_TEST);
            }
        }
    };

    /**
     * Order-sensitive functions that immediately effect WebGL state change.
     *
     * These map to renderer properties and are called in a particular order since they
     * affect one another.
     *
     * Each of these wrap a state-setter function on the WebGL gl. Each function
     * also uses the glEnum map to convert its renderer node property argument to the
     * WebGL enum constant required by its wrapped function.
     *
     * @private
     */
    var glStateSetters = {

        /** Set viewport on the given gl
         */
        viewport: function(gl, v) {
            if (!gl) {
                v = v || {};
                return {
                    x : v.x || 1,
                    y : v.y || 1,
                    width: v.width || canvas.canvas.width,
                    height: v.height || canvas.canvas.height
                };
            }
            gl.viewport(v.x, v.y, v.width, v.height);
        },

        /** Sets scissor region on the given gl
         */
        scissor: function(gl, s) {
            if (!gl) {
                s = s || {};
                return {
                    x : s.x || 0,
                    y : s.y || 0,
                    width: s.width || 1.0,
                    height: s.height || 1.0
                };
            }
            gl.scissor(s.x, s.y, s.width, s.height);
        },

        /** Clears buffers on the given gl as specified in mask
         */
        clear:function(gl, mask) {
            if (!gl) {
                mask = mask || {};
                return mask;
            }
            var m;
            if (mask.color) {
                m = gl.COLOR_BUFFER_BIT;
            }
            if (mask.depth) {
                m = m | gl.DEPTH_BUFFER_BIT;
            }
            if (mask.stencil) {
                m = m | gl.STENCIL_BUFFER_BIT;
            }
            if (m) {
                //    gl.clear(m);
            }
        }
    };

    SceneJS.Renderer = SceneJS_NodeFactory.createNodeType("renderer");

    SceneJS.Renderer.prototype._init = function(params) {
        if (this._core.useCount == 1) { // This node defines the resource
            for (var key in params) {
                if (params.hasOwnProperty(key)) {
                    this._core[key] = params[key];
                }
            }
            this._core.dirty = true;
        }
    };

    SceneJS.Renderer.prototype.setViewport = function(viewport) {
        this._core.viewport = viewport ? {
            x : viewport.x || 1,
            y : viewport.y || 1,
            width: viewport.width || 1000,
            height: viewport.height || 1000
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getViewport = function() {
        return this._core.viewport ? {
            x : this._core.viewport.x,
            y : this._core.viewport.y,
            width: this._core.viewport.width,
            height: this._core.viewport.height
        } : undefined;
    };

    SceneJS.Renderer.prototype.setScissor = function(scissor) {
        this._core.scissor = scissor ? {
            x : scissor.x || 1,
            y : scissor.y || 1,
            width: scissor.width || 1000,
            height: scissor.height || 1000
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getScissor = function() {
        return this._core.scissor ? {
            x : this._core.scissor.x,
            y : this._core.scissor.y,
            width: this._core.scissor.width,
            height: this._core.scissor.height
        } : undefined;
    };

    SceneJS.Renderer.prototype.setClear = function(clear) {
        this._core.clear = clear ? {
            r : clear.r || 0,
            g : clear.g || 0,
            b : clear.b || 0
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getClear = function() {
        return this._core.clear ? {
            r : this._core.clear.r,
            g : this._core.clear.g,
            b : this._core.clear.b
        } : null;
    };

    SceneJS.Renderer.prototype.setEnableBlend = function(enableBlend) {
        this._core.enableBlend = enableBlend;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getEnableBlend = function() {
        return this._core.enableBlend;
    };

    SceneJS.Renderer.prototype.setBlendColor = function(color) {
        this._core.blendColor = color ? {
            r : color.r || 0,
            g : color.g || 0,
            b : color.b || 0,
            a : (color.a == undefined || color.a == null) ? 1 : color.a
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getBlendColor = function() {
        return this._core.blendColor ? {
            r : this._core.blendColor.r,
            g : this._core.blendColor.g,
            b : this._core.blendColor.b,
            a : this._core.blendColor.a
        } : undefined;
    };

    SceneJS.Renderer.prototype.setBlendEquation = function(eqn) {
        this._core.blendEquation = eqn;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getBlendEquation = function() {
        return this._core.blendEquation;
    };

    SceneJS.Renderer.prototype.setBlendEquationSeparate = function(eqn) {
        this._core.blendEquationSeparate = eqn ? {
            rgb : eqn.rgb || "funcAdd",
            alpha : eqn.alpha || "funcAdd"
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getBlendEquationSeparate = function() {
        return this._core.blendEquationSeparate ? {
            rgb : this._core.rgb,
            alpha : this._core.alpha
        } : undefined;
    };

    SceneJS.Renderer.prototype.setBlendFunc = function(funcs) {
        this._core.blendFunc = funcs ? {
            sfactor : funcs.sfactor || "srcAlpha",
            dfactor : funcs.dfactor || "one"
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getBlendFunc = function() {
        return this._core.blendFunc ? {
            sfactor : this._core.sfactor,
            dfactor : this._core.dfactor
        } : undefined;
    };

    SceneJS.Renderer.prototype.setBlendFuncSeparate = function(eqn) {
        this._core.blendFuncSeparate = eqn ? {
            srcRGB : eqn.srcRGB || "zero",
            dstRGB : eqn.dstRGB || "zero",
            srcAlpha : eqn.srcAlpha || "zero",
            dstAlpha : eqn.dstAlpha || "zero"
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getBlendFuncSeparate = function() {
        return this._core.blendFuncSeparate ? {
            srcRGB : this._core.blendFuncSeparate.srcRGB,
            dstRGB : this._core.blendFuncSeparate.dstRGB,
            srcAlpha : this._core.blendFuncSeparate.srcAlpha,
            dstAlpha : this._core.blendFuncSeparate.dstAlpha
        } : undefined;
    };

    SceneJS.Renderer.prototype.setEnableCullFace = function(enableCullFace) {
        this._core.enableCullFace = enableCullFace;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getEnableCullFace = function() {
        return this._core.enableCullFace;
    };


    SceneJS.Renderer.prototype.setCullFace = function(cullFace) {
        this._core.cullFace = cullFace;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getCullFace = function() {
        return this._core.cullFace;
    };

    SceneJS.Renderer.prototype.setEnableDepthTest = function(enableDepthTest) {
        this._core.enableDepthTest = enableDepthTest;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getEnableDepthTest = function() {
        return this._core.enableDepthTest;
    };

    SceneJS.Renderer.prototype.setDepthFunc = function(depthFunc) {
        this._core.depthFunc = depthFunc;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getDepthFunc = function() {
        return this._core.depthFunc;
    };

    SceneJS.Renderer.prototype.setEnableDepthMask = function(enableDepthMask) {
        this._core.enableDepthMask = enableDepthMask;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getEnableDepthMask = function() {
        return this._core.enableDepthMask;
    };

    SceneJS.Renderer.prototype.setClearDepth = function(clearDepth) {
        this._core.clearDepth = clearDepth;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getClearDepth = function() {
        return this._core.clearDepth;
    };

    SceneJS.Renderer.prototype.setDepthRange = function(range) {
        this._core.depthRange = range ? {
            zNear : (range.zNear == undefined || range.zNear == null) ? 0 : range.zNear,
            zFar : (range.zFar == undefined || range.zFar == null) ? 1 : range.zFar
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getDepthRange = function() {
        return this._core.depthRange ? {
            zNear : this._core.depthRange.zNear,
            zFar : this._core.depthRange.zFar
        } : undefined;
    };

    SceneJS.Renderer.prototype.setFrontFace = function(frontFace) {
        this._core.frontFace = frontFace;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getFrontFace = function() {
        return this._core.frontFace;
    };

    SceneJS.Renderer.prototype.setLineWidth = function(lineWidth) {
        this._core.lineWidth = lineWidth;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getLineWidth = function() {
        return this._core.lineWidth;
    };

    SceneJS.Renderer.prototype.setEnableScissorTest = function(enableScissorTest) {
        this._core.enableScissorTest = enableScissorTest;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getEnableScissorTest = function() {
        return this._core.enableScissorTest;
    };

    SceneJS.Renderer.prototype.setClearStencil = function(clearStencil) {
        this._core.clearStencil = clearStencil;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getClearStencil = function() {
        return this._core.clearStencil;
    };

    SceneJS.Renderer.prototype.setColorMask = function(color) {
        this._core.colorMask = color ? {
            r : color.r || 0,
            g : color.g || 0,
            b : color.b || 0,
            a : (color.a == undefined || color.a == null) ? 1 : color.a
        } : undefined;
        this._core.dirty = true;
    };

    SceneJS.Renderer.prototype.getColorMask = function() {
        return this._core.colorMask ? {
            r : this._core.colorMask.r,
            g : this._core.colorMask.g,
            b : this._core.colorMask.b,
            a : this._core.colorMask.a
        } : undefined;
    };

    SceneJS.Renderer.prototype._compile = function(ctx) {

//        if (this._core.dirty) {
//            this._core.props = createProps(this._core);
//            this._core.dirty = false;
//        }
//
//        this._engine.display.renderer = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        //this._engine.display.renderer = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };
})();(function () {

    var lookup = {
        less:"LESS",
        equal:"EQUAL",
        lequal:"LEQUAL",
        greater:"GREATER",
        notequal:"NOTEQUAL",
        gequal:"GEQUAL"
    };

    // The default state core singleton for {@link SceneJS.DepthBuf} nodes
    var defaultCore = {
        type:"depthbuf",
        stateId:SceneJS._baseStateId++,
        enabled:true,
        clearDepth:1,
        depthFunc:null, // Lazy init depthFunc when we can get a context
        _depthFuncName:"less"
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            if (defaultCore.depthFunc === null) { // Lazy-init depthFunc now we can get a context
                defaultCore.depthFunc = params.engine.canvas.gl.LESS;
            }
            params.engine.display.depthbuf = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which configures the depth buffer for its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.DepthBuf = SceneJS_NodeFactory.createNodeType("depthbuf");

    SceneJS.DepthBuf.prototype._init = function (params) {

        if (params.enabled != undefined) {
            this.setEnabled(params.enabled);
        } else if (this._core.useCount == 1) { // This node defines the core
            this.setEnabled(true);
        }

        if (params.clearDepth != undefined) {
            this.setClearDepth(params.clearDepth);
        } else if (this._core.useCount == 1) {
            this.setClearDepth(1);
        }

        if (params.depthFunc != undefined) {
            this.setDepthFunc(params.depthFunc);
        } else if (this._core.useCount == 1) {
            this.setDepthFunc("less");
        }
    };

    /**
     * Enable or disable the depth buffer
     *
     * @param enabled Specifies whether depth buffer is enabled or not
     * @return {*}
     */
    SceneJS.DepthBuf.prototype.setEnabled = function (enabled) {
        if (this._core.enabled != enabled) {
            this._core.enabled = enabled;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Get whether or not the depth buffer is enabled
     *
     * @return Boolean
     */
    SceneJS.DepthBuf.prototype.getEnabled = function () {
        return this._core.enabled;
    };

    /**
     * Specify the clear value for the depth buffer.
     * Initial value is 1, and the given value will be clamped to [0..1].
     * @param clearDepth
     * @return {*}
     */
    SceneJS.DepthBuf.prototype.setClearDepth = function (clearDepth) {
        if (this._core.clearDepth != clearDepth) {
            this._core.clearDepth = clearDepth;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Get the clear value for the depth buffer
     *
     * @return Number
     */
    SceneJS.DepthBuf.prototype.getClearDepth = function () {
        return this._core.clearDepth;
    };

    /**
     * Sets the depth comparison function.
     * Supported values are 'less', 'equal', 'lequal', 'greater', 'notequal' and 'gequal'
     * @param {String} depthFunc The depth comparison function
     * @return {*}
     */
    SceneJS.DepthBuf.prototype.setDepthFunc = function (depthFunc) {
        if (this._core._depthFuncName != depthFunc) {
            var enumName = lookup[depthFunc];
            if (enumName == undefined) {
                throw "unsupported value for 'clearFunc' attribute on depthbuf node: '" + depthFunc
                    + "' - supported values are 'less', 'equal', 'lequal', 'greater', 'notequal' and 'gequal'";
            }
            this._core.depthFunc = this._engine.canvas.gl[enumName];
            this._core._depthFuncName = depthFunc;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Returns the depth comparison function
     * @return {*}
     */
    SceneJS.DepthBuf.prototype.getDepthFunc = function () {
        return this._core._depthFuncName;
    };

    SceneJS.DepthBuf.prototype._compile = function (ctx) {
        this._engine.display.depthbuf = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.depthbuf = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();(function () {

    // The default state core singleton for {@link SceneJS.ColorBuf} nodes
    var defaultCore = {
        type:"colorbuf",
        stateId:SceneJS._baseStateId++,
        blendEnabled:false
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.colorbuf = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which configures the color buffer for its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.ColorBuf = SceneJS_NodeFactory.createNodeType("colorbuf");

    SceneJS.ColorBuf.prototype._init = function (params) {

        if (params.blendEnabled != undefined) {
            this.setBlendEnabled(params.blendEnabled);
        } else if (this._core.useCount == 1) { // This node defines the core
            this.setBlendEnabled(false);
        }
    };

    /**
     * Enable or disable blending
     *
     * @param blendEnabled Specifies whether depth buffer is blendEnabled or not
     * @return {*}
     */
    SceneJS.ColorBuf.prototype.setBlendEnabled = function (blendEnabled) {
        if (this._core.blendEnabled != blendEnabled) {
            this._core.blendEnabled = blendEnabled;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Get whether or not blending is enabled
     *
     * @return Boolean
     */
    SceneJS.ColorBuf.prototype.getBlendEnabled = function () {
        return this._core.blendEnabled;
    };

    SceneJS.ColorBuf.prototype._compile = function (ctx) {
        this._engine.display.colorbuf = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.colorbuf = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();(function () {

    // The default state core singleton for {@link SceneJS.View} nodes
    var defaultCore = {
        type:"view",
        stateId:SceneJS._baseStateId++,
        scissorTestEnabled:false
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.view = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which configures view parameters such as depth range, scissor test and viewport
     * @extends SceneJS.Node
     * void depthRange(floatzNear, floatzFar)
     zNear: Clamped to the range 0 to 1 Must be <= zFar
     zFar: Clamped to the range 0 to 1.
     void scissor(int x, int y, long width, long height)
     void viewport(int x, int y, long width, long height)
     */
    SceneJS.View = SceneJS_NodeFactory.createNodeType("view");

    SceneJS.View.prototype._init = function (params) {

        if (params.scissorTestEnabled != undefined) {
            this.setScissorTestEnabled(params.scissorTestEnabled);
        } else if (this._core.useCount == 1) { // This node defines the core
            this.setScissorTestEnabled(false);
        }
    };

    /**
     * Enable or disables scissor test.
     *
     * When enabled, the scissor test will discards fragments that are outside the scissor box.
     *
     * Scissor test is initially disabled.
     *
     * @param scissorTestEnabled Specifies whether scissor test is enabled or not
     * @return {*}
     */
    SceneJS.View.prototype.setScissorTestEnabled = function (scissorTestEnabled) {
        if (this._core.scissorTestEnabled != scissorTestEnabled) {
            this._core.scissorTestEnabled = scissorTestEnabled;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Get whether or not scissor test is enabled.
     * Initial value will be false.
     *
     * @return Boolean
     */
    SceneJS.View.prototype.getScissorTestEnabled = function () {
        return this._core.scissorTestEnabled;
    };

    SceneJS.View.prototype._compile = function (ctx) {
        this._engine.display.view = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.view = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();/**
 * @class The root node of a scenegraph
 * @extends SceneJS.Node
 *
 */

SceneJS.Scene = SceneJS_NodeFactory.createNodeType("scene");

SceneJS.Scene.prototype._init = function (params) {

    if (params.tagMask) {
        this.setTagMask(params.tagMask);
    }

    this._tagSelector = null;
};


/**
 * Simulate a lost WebGL context for testing purposes.
 * Only works if the simulateWebGLLost was given as an option to {@link SceneJS.createScene}.
 */
SceneJS.Scene.prototype.loseWebGLContext = function () {
    this._engine.loseWebGLContext();
};


/**
 * Returns the HTML canvas for this scene
 * @return {HTMLCanvas} The canvas
 */
SceneJS.Scene.prototype.getCanvas = function () {
    return this._engine.canvas.canvas;
};

/**
 * Returns the WebGL context for this scene
 */
SceneJS.Scene.prototype.getGL = function () {
    return this._engine.canvas.gl;
};

/** Returns the Z-buffer depth in bits of the webgl context that this scene is to bound to.
 */
SceneJS.Scene.prototype.getZBufferDepth = function () {

    var gl = this._engine.canvas.gl;

    return gl.getParameter(gl.DEPTH_BITS);
};

/**
 * Sets a regular expression to select which of the scene subgraphs that are rooted by {@link SceneJS.Tag} nodes are included in scene renders
 * @param {String} [tagMask] Regular expression string to match on the tag attributes of {@link SceneJS.Tag} nodes. Nothing is selected when this is omitted.
 * @see #getTagMask
 * @see SceneJS.Tag
 */
SceneJS.Scene.prototype.setTagMask = function (tagMask) {

    tagMask = tagMask || "XXXXXXXXXXXXXXXXXXXXXXXXXX"; // HACK to select nothing by default

    if (!this._tagSelector) {
        this._tagSelector = {};
    }

    this._tagSelector.mask = tagMask;
    this._tagSelector.regex = tagMask ? new RegExp(tagMask) : null;

    this._engine.display.selectTags(this._tagSelector);
};

/**
 * Gets the regular expression which will select which of the scene subgraphs that are rooted by {@link SceneJS.Tag} nodes are included in scene renders
 * @see #setTagMask
 * @see SceneJS.Tag
 * @returns {String} Regular expression string that will be matched on the tag attributes of {@link SceneJS.Tag} nodes
 */
SceneJS.Scene.prototype.getTagMask = function () {
    return this._tagSelector ? this._tagSelector.mask : null;
};

/**
 * Render a single frame if new frame pending, or force a new frame
 * Returns true if frame rendered
 */
SceneJS.Scene.prototype.renderFrame = function (params) {
    return this._engine.renderFrame(params);
};

/**
 * Starts the render loop for this scene
 */
SceneJS.Scene.prototype.start = function (params) {
    this._engine.start(params);
};

/**
 * Pauses/unpauses current render loop that was started with {@link #start}. After this, {@link #isRunning} will return false.
 * @param {Boolean} doPause Indicates whether to pause or unpause the render loop
 */
SceneJS.Scene.prototype.pause = function (doPause) {
    this._engine.pause(doPause);
};

/**
 * Returns true if the scene's render loop is currently running.
 * @returns {Boolean} True when scene render loop is running
 */
SceneJS.Scene.prototype.isRunning = function () {
    return this._engine.running;
};

/**
 * Picks whatever geometry will be rendered at the given canvas coordinates.
 */
SceneJS.Scene.prototype.pick = function (canvasX, canvasY, options) {
    var result = this._engine.pick(canvasX, canvasY, options);
    this.renderFrame({force:true }); // HACK: canvas blanks after picking
    if (result) {
        this.publish("pick", result);
        return result;
    } else {
        this.publish("nopick");
    }
};

/**
 * Scene node's destroy handler, called by {@link SceneJS_node#destroy}
 * @private
 */
SceneJS.Scene.prototype._destroy = function () {

    if (!this.destroyed) {

        delete SceneJS._engines[this.id];  // HACK: circular dependency
        SceneJS._engineIds.removeItem(this.id); // HACK: circular dependency

        this.destroyed = true;
    }
};

/**
 * Returns true if scene active, ie. not destroyed. A destroyed scene becomes active again
 * when you render it.
 */
SceneJS.Scene.prototype.isActive = function () {
    return !this._engine.destroyed;
};

/**
 * Stops current render loop that was started with {@link #start}. After this, {@link #isRunning} will return false.
 */
SceneJS.Scene.prototype.stop = function () {
    this._engine.stop();
};

/** Determines if node exists in this scene
 * @deprecated
 */
SceneJS.Scene.prototype.containsNode = function (nodeId) {
    return !!this._engine.findNode(nodeId);
};

/**
 * Finds nodes in this scene that have nodes IDs matching the given regular expression
 *
 * @param {String} nodeIdRegex Regular expression to match on node IDs
 * @return {[SceneJS.Node]} Array of nodes whose IDs match the given regex
 */
SceneJS.Scene.prototype.findNodes = function (nodeIdRegex) {
    return this._engine.findNodes(nodeIdRegex);
};

/**
 * Finds the node with the given ID in this scene
 * @deprecated
 * @param {String} nodeId Node ID
 * @param {Function} callback Callback through which we'll get the node asynchronously if it's being instantiated on-demand from a node type plugin
 * @return {SceneJS.Node} The node if found, else null
 */
SceneJS.Scene.prototype.findNode = function (nodeId, callback) {
    return this.getNode(nodeId, callback);
};

/**
 * @function Finds the node with the given ID in this scene
 * @param {String} nodeId Node ID
 * @param {Function} callback Callback through which we'll get the node asynchronously if it's being instantiated on-demand from a node type plugin
 * @return {SceneJS.Node} The node if found, else null
 */
SceneJS.Scene.prototype.getNode = function (nodeId, callback) {
    var node = this._engine.findNode(nodeId);
    if (node) {
        if (callback) {
            callback(node);
        }
        return node;
    } else {
        if (!callback) {
            return null;
        }
        // Subscribe to instantiation of node from plugin
        this.once("nodes/" + nodeId, callback);
    }
};

/**
 * Tests whether a node core of the given ID exists for the given node type
 * @param {String} type Node type
 * @param {String} coreId
 * @returns Boolean
 */
SceneJS.Scene.prototype.hasCore = function (type, coreId) {
    return this._engine.hasCore(type, coreId);
};

/**
 * Returns the current status of this scene.
 *
 * When the scene has been destroyed, the returned status will be a map like this:
 *
 * {
 *      destroyed: true
 * }
 *
 * Otherwise, the status will be:
 *
 * {
 *      numTasks: Total number of asset loads (eg. texture, geometry stream etc.) currently in progress for this scene
 * }
 *
 */
SceneJS.Scene.prototype.getStatus = function () {
    var sceneStatus = SceneJS_sceneStatusModule.sceneStatus[this.id];
    if (!sceneStatus) {
        return {
            destroyed:true
        };
    }
    return SceneJS._shallowClone(sceneStatus);
};
new (function() {

    /**
     * The default state core singleton for {@link SceneJS.Shader} nodes
     */
    var defaultCore = {
        type: "shader",
        stateId: SceneJS._baseStateId++,
        hash: "",
        empty: true,
        shader : {}
    };

    var idStack = [];
    var shaderVertexCodeStack = [];
    var shaderVertexHooksStack = [];
    var shaderFragmentCodeStack = [];
    var shaderFragmentHooksStack = [];
    var shaderParamsStack = [];

    var stackLen = 0;

    var dirty = true;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {

                params.engine.display.shader = defaultCore;

                stackLen = 0;

                dirty = true;
            });

    SceneJS_events.addListener(
            SceneJS_events.OBJECT_COMPILING,
            function(params) {
                if (dirty) {

                    if (stackLen > 0) {

                        var core = {
                            type: "shader",
                            stateId: idStack[stackLen - 1],
                            hash: idStack.slice(0, stackLen).join("."),

                            shaders: {
                                fragment: {
                                    code: shaderFragmentCodeStack.slice(0, stackLen).join("\n"),
                                    hooks: combineMapStack(shaderFragmentHooksStack)
                                },
                                vertex: {
                                    code: shaderVertexCodeStack.slice(0, stackLen).join("\n"),
                                    hooks: combineMapStack(shaderVertexHooksStack)
                                }
                            },

                            paramsStack: shaderParamsStack.slice(0, stackLen)
                        };

                        params.display.shader = core;

                    } else {

                        params.display.shader = defaultCore;
                    }

                    dirty = false;
                }
            });

    function combineMapStack(maps) {
        var map1;
        var map2 = {};
        var name;
        for (var i = 0; i < stackLen; i++) {
            map1 = maps[i];
            for (name in map1) {
                if (map1.hasOwnProperty(name)) {
                    map2[name] = map1[name];
                }
            }
        }
        return map2;
    }

    function pushHooks(hooks, hookStacks) {
        var stack;
        for (var key in hooks) {
            if (hooks.hasOwnProperty(key)) {
                stack = hookStacks[key];
                if (!stack) {
                    stack = hookStacks[key] = [];
                }
                stack.push(hooks[key]);
            }
        }
    }

    SceneJS.Shader = SceneJS_NodeFactory.createNodeType("shader");

    SceneJS.Shader.prototype._init = function(params) {
        if (this._core.useCount == 1) { // This node is the resource definer
            this._setShaders(params.shaders);
            this.setParams(params.params);
        }
    };

    SceneJS.Shader.prototype._setShaders = function(shaders) {
        shaders = shaders || [];
        this._core.shaders = {};
        var shader;

        for (var i = 0, len = shaders.length; i < len; i++) {
            shader = shaders[i];

            if (!shader.stage) {
                throw SceneJS_error.fatalError(
                        SceneJS.errors.ILLEGAL_NODE_CONFIG,
                        "shader 'stage' attribute expected");
            }

            var code;
            if (shader.code) {
                if (SceneJS._isArray(shader.code)) {
                    code = shader.code.join("");
                } else {
                    code = shader.code;
                }
            }

            this._core.shaders[shader.stage] = {
                code: code,
                hooks: shader.hooks
            };
        }
    };

    SceneJS.Shader.prototype.setParams = function(params) {
        params = params || {};
        var coreParams = this._core.params;
        if (!coreParams) {
            coreParams = this._core.params = {};
        }
        for (var name in params) {
            if (params.hasOwnProperty(name)) {
                coreParams[name] = params[name];
            }
        }
        this._engine.display.imageDirty = true;
    };

    SceneJS.Shader.prototype.getParams = function() {
        var coreParams = this._core.params;
        if (!coreParams) {
            return {};
        }
        var params = {};
        for (var name in coreParams) {
            if (coreParams.hasOwnProperty(name)) {
                params[name] = coreParams[name];
            }
        }
        return params;
    };

    SceneJS.Shader.prototype._compile = function(ctx) {

        idStack[stackLen] = this._core.coreId; // Draw list node tied to core, not node

        var shaders = this._core.shaders;

        var fragment = shaders.fragment || {};
        var vertex = shaders.vertex || {};

        shaderFragmentCodeStack[stackLen] = fragment.code || "";
        shaderFragmentHooksStack[stackLen] = fragment.hooks || {};

        shaderVertexCodeStack[stackLen] = vertex.code || "";
        shaderVertexHooksStack[stackLen] = vertex.hooks || {};

        shaderParamsStack[stackLen] = this._core.params || {};

        stackLen++;
        dirty = true;

        this._compileNodes(ctx);

        stackLen--;
        dirty = true;
    };

})();new (function() {

    /**
     * The default state core singleton for {@link SceneJS.ShaderParams} nodes
     */
    var defaultCore = {
        type: "shaderParams",
        stateId: SceneJS._baseStateId++,
        empty: true
    };

    var idStack = [];
    var shaderParamsStack = [];
    var stackLen = 0;
    var dirty;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {

                params.engine.display.shaderParams = defaultCore;

                stackLen = 0;
                dirty = true;
            });

    SceneJS_events.addListener(
            SceneJS_events.OBJECT_COMPILING,
            function(params) {
                if (dirty) {

                    if (stackLen > 0) {
                        var core = {
                            type: "shaderParams",
                            stateId: idStack[stackLen - 1],
                            paramsStack: shaderParamsStack.slice(0, stackLen)
                        };
                        params.display.shaderParams = core;

                    } else {
                        params.display.shaderParams = defaultCore;
                    }

                    dirty = false;
                }
            });

    SceneJS.ShaderParams = SceneJS_NodeFactory.createNodeType("shaderParams");

    SceneJS.ShaderParams.prototype._init = function(params) {
        if (this._core.useCount == 1) { // This node is the resource definer
            this.setParams(params.params);
        }
    };

    SceneJS.ShaderParams.prototype.setParams = function(params) {
        params = params || {};
        var core = this._core;
        if (!core.params) {
            core.params = {};
        }
        for (var name in params) {
            if (params.hasOwnProperty(name)) {
                core.params[name] = params[name];
            }
        }
        this._engine.display.imageDirty = true;
    };

    SceneJS.ShaderParams.prototype.getParams = function() {
        var coreParams = this._core.params;
        if (!coreParams) {
            return {};
        }
        var params = {};
        for (var name in coreParams) {
            if (coreParams.hasOwnProperty(name)) {
                params[name] = coreParams[name];
            }
        }
        return params;
    };

    SceneJS.ShaderParams.prototype._compile = function(ctx) {

        idStack[stackLen] = this._core.coreId; // Tie draw list state to core, not to scene node
        shaderParamsStack[stackLen] = this._core.params;
        stackLen++;
        dirty = true;

        this._compileNodes(ctx);

        stackLen--;
        dirty = true;
    };

})();(function () {

    // The default state core singleton for {@link SceneJS.Line} nodes
    var defaultCore = {
        type:"style",
        stateId:SceneJS._baseStateId++,
        lineWidth:1.0
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.style = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which configures style parameters such as line width for subnodes
     * @extends SceneJS.Node
     */
    SceneJS.Style = SceneJS_NodeFactory.createNodeType("style");

    SceneJS.Style.prototype._init = function (params) {
        if (params.lineWidth != undefined) {
            this.setLineWidth(params.lineWidth);
        }
    };

    /**
     * Sets the line width
     *
     * Line width is initially 1.
     *
     * @param lineWidth The line width
     * @return {*}
     */
    SceneJS.Style.prototype.setLineWidth = function (lineWidth) {
        if (this._core.lineWidth != lineWidth) {
            this._core.lineWidth = lineWidth;
            this._engine.display.imageDirty = true;
        }
        return this;
    };

    /**
     * Gets the line width
     * Initial value will be 1.
     *
     * @return Boolean
     */
    SceneJS.Style.prototype.getLineWidth = function () {
        return this._core.lineWidth;
    };

    SceneJS.Style.prototype._compile = function (ctx) {
        this._engine.display.style = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.style = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

})();(function() {

    /**
     * The default state core singleton for {@link SceneJS.Tag} nodes
     */
    var defaultCore = {
        type: "tag",
        stateId: SceneJS._baseStateId++,
        tag : null
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
            SceneJS_events.SCENE_COMPILING,
            function(params) {
                params.engine.display.tag = defaultCore;
                stackLen = 0;
            });

    /**
     * @class Scene graph node which assigns a symbolic tag name to the {@link SceneJS.Geometry} nodes in its subgraph.
     * The subgraph can then be included or excluded from scene rendering using {@link SceneJS.Scene#setTagMask}.
     * @extends SceneJS.Node
     */
    SceneJS.Tag = SceneJS_NodeFactory.createNodeType("tag");

    SceneJS.Tag.prototype._init = function(params) {
        if (this._core.useCount == 1) { // This node defines the resource
            if (!params.tag) {
                throw SceneJS_error.fatalError(
                        SceneJS.errors.NODE_CONFIG_EXPECTED,
                        "tag node attribute missing : 'tag'");
            }
            this.setTag(params.tag);
        }
    };

    SceneJS.Tag.prototype.setTag = function(tag) {

        var core = this._core;

        core.tag = tag;
        core.pattern = null;    // To be recomputed
        core.matched = false;   // To be rematched

        this._engine.display.drawListDirty = true;
    };

    SceneJS.Tag.prototype.getTag = function() {
        return this._core.tag;
    };

    SceneJS.Tag.prototype._compile = function(ctx) {
        this._engine.display.tag = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.tag = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };
})();/**
 * @class Scene graph node which defines textures to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
new (function () {

    var imageBasePath = window.location.hostname + window.location.pathname;

    // The default state core singleton for {@link SceneJS.Texture} nodes
    var defaultCore = {
        type:"texture",
        stateId:SceneJS._baseStateId++,
        empty:true,
        hash:""
    };

    var coreStack = [];
    var stackLen = 0;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function (params) {
            params.engine.display.texture = defaultCore;
            stackLen = 0;
        });

    /**
     * @class Scene graph node which defines one or more textures to apply to the {@link SceneJS.Geometry} nodes in its subgraph
     * @extends SceneJS.Node
     */
    SceneJS.Texture = SceneJS_NodeFactory.createNodeType("texture");

    SceneJS.Texture.prototype._init = function (params) {

        if (this._core.useCount == 1) { // This node is the resource definer

            this._core.layers = [];
            this._core.params = {};

            // By default, wait for texture to load before building subgraph
            var waitForLoad = params.waitForLoad == undefined ? true : params.waitForLoad;

            if (!params.layers) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.NODE_CONFIG_EXPECTED,
                    "texture layers missing");
            }

            if (!SceneJS._isArray(params.layers)) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.NODE_CONFIG_EXPECTED,
                    "texture layers should be an array");
            }

            var layerParams;
            var gl = this._engine.canvas.gl;

            for (var i = 0; i < params.layers.length; i++) {

                layerParams = params.layers[i];

                if (!layerParams.source && !layerParams.uri && !layerParams.src && !layerParams.framebuf && !layerParams.video) {

                    throw SceneJS_error.fatalError(
                        SceneJS.errors.NODE_CONFIG_EXPECTED,
                        "texture layer " + i + "  has no uri, src, source, framebuf, video or canvasId specified");
                }

                if (layerParams.applyFrom) {
                    if (layerParams.applyFrom != "uv" &&
                        layerParams.applyFrom != "uv2" &&
                        layerParams.applyFrom != "normal" &&
                        layerParams.applyFrom != "geometry") {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.NODE_CONFIG_EXPECTED,
                            "texture layer " + i + "  applyFrom value is unsupported - " +
                                "should be either 'uv', 'uv2', 'normal' or 'geometry'");
                    }
                }

                if (layerParams.applyTo) {
                    if (layerParams.applyTo != "baseColor" && // Colour map (deprecated)
                        layerParams.applyTo != "color" && // Colour map
                        layerParams.applyTo != "specular" && // Specular map
                        layerParams.applyTo != "emit" && // Emission map
                        layerParams.applyTo != "alpha" && // Alpha map
                        layerParams.applyTo != "normals") {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.NODE_CONFIG_EXPECTED,
                            "texture layer " + i + " applyTo value is unsupported - " +
                                "should be either 'color', 'baseColor', 'specular' or 'normals'");
                    }
                }

                if (layerParams.blendMode) {
                    if (layerParams.blendMode != "add" && layerParams.blendMode != "multiply") {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.NODE_CONFIG_EXPECTED,
                            "texture layer " + i + " blendMode value is unsupported - " +
                                "should be either 'add' or 'multiply'");
                    }
                }

                if (layerParams.applyTo == "color") {
                    layerParams.applyTo = "baseColor";
                }

                var layer = SceneJS._apply(layerParams, {
                    waitForLoad:waitForLoad,
                    texture:null,
                    applyFrom:layerParams.applyFrom || "uv",
                    applyTo:layerParams.applyTo || "baseColor",
                    blendMode:layerParams.blendMode || "multiply",
                    blendFactor:(layerParams.blendFactor != undefined && layerParams.blendFactor != null) ? layerParams.blendFactor : 1.0,
                    translate:{ x:0, y:0},
                    scale:{ x:1, y:1 },
                    rotate:{ z:0.0 }
                });

                this._core.layers.push(layer);

                this._setLayerTransform(layerParams, layer);

                if (layer.framebuf) { // Create from a framebuf node preceeding this texture in the scene graph
                    var targetNode = this._engine.findNode(layer.framebuf);
                    if (targetNode && targetNode.type == "framebuf") {
                        layer.texture = targetNode._core.framebuf.getTexture(); // TODO: what happens when the framebuf is destroyed?
                    }
                } else { // Create from texture node's layer configs
                    this._loadLayerTexture(gl, layer);
                }
            }

            var self = this;

            // WebGL restored handler - rebuilds the texture layers
            this._core.webglRestored = function () {

                var layers = self._core.layers;
                var gl = self._engine.canvas.gl;

                for (var i = 0, len = layers.length; i < len; i++) {
                    self._loadLayerTexture(gl, layers[i]);
                }
            };
        }
    };

    SceneJS.Texture.prototype._loadLayerTexture = function (gl, layer) {

        var self = this;

        var sourceConfigs = layer.source;

        if (sourceConfigs) {

            if (!sourceConfigs.type) {
                throw SceneJS_error.fatalError(
                    SceneJS.errors.ILLEGAL_NODE_CONFIG,
                    "texture layer config expected: source.type");
            }

            SceneJS.Plugins.getPlugin(
                "texture",
                sourceConfigs.type,
                function (plugin) {

                    if (!plugin.getSource) {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.PLUGIN_INVALID,
                            "texture: 'getSource' method missing on plugin for texture source type '" + sourceConfigs.type + "'.");
                    }

                    var source = plugin.getSource({ gl:gl });

                    if (!source.subscribe) {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.PLUGIN_INVALID,
                            "texture: 'subscribe' method missing on plugin for texture source type '" + sourceConfigs.type + "'");
                    }

                    var taskId = SceneJS_sceneStatusModule.taskStarted(self, "Loading texture");

                    source.subscribe(// Get notification whenever source updates the texture
                        (function () {
                            var loaded = false;
                            return function (texture) {
                                if (!loaded) { // Texture first initialised - create layer
                                    loaded = true;
                                    self._setLayerTexture(gl, layer, texture);
                                    SceneJS_sceneStatusModule.taskFinished(taskId);
                                } else { // Texture updated - layer already has the handle to it, so just signal a redraw
                                    self._engine.display.imageDirty = true;
                                }
                            };
                        })());

                    if (source.configure) {
                        source.configure(sourceConfigs); // Configure the source, which may cause it to update the texture
                    }

                    layer._source = source;
                });

        } else {

            /* Load from URL
             */

            var src = layer.uri || layer.src;

            var taskId = SceneJS_sceneStatusModule.taskStarted(this, "Loading texture");

            var image = new Image();

            image.onload = function () {
                var texture = gl.createTexture();
                gl.bindTexture(gl.TEXTURE_2D, texture);
                gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, self._ensureImageSizePowerOfTwo(image));
                self._setLayerTexture(gl, layer, texture);
                SceneJS_sceneStatusModule.taskFinished(taskId);
            };

            image.onerror = function () {
                SceneJS_sceneStatusModule.taskFailed(taskId);
            };

            if (src.indexOf("data") == 0) {  // Image data
                image.src = src;
            } else { // Image file
                image.crossOrigin = "Anonymous";
                image.src = src;
            }
        }
    };

    SceneJS.Texture.prototype._ensureImageSizePowerOfTwo = function (image) {

        if (!this._isPowerOfTwo(image.width) || !this._isPowerOfTwo(image.height)) {

            var canvas = document.createElement("canvas");
            canvas.width = this._nextHighestPowerOfTwo(image.width);
            canvas.height = this._nextHighestPowerOfTwo(image.height);

            var ctx = canvas.getContext("2d");

            ctx.drawImage(image,
                0, 0, image.width, image.height,
                0, 0, canvas.width, canvas.height);

            image = canvas;
            image.crossOrigin = "";
        }
        return image;
    };

    SceneJS.Texture.prototype._isPowerOfTwo = function (x) {
        return (x & (x - 1)) == 0;
    };

    SceneJS.Texture.prototype._nextHighestPowerOfTwo = function (x) {
        --x;
        for (var i = 1; i < 32; i <<= 1) {
            x = x | x >> i;
        }
        return x + 1;
    };

    SceneJS.Texture.prototype._setLayerTexture = function (gl, layer, texture) {

        layer.texture = new SceneJS_webgl_Texture2D(gl, {
            texture:texture, // WebGL texture object
            minFilter:this._getGLOption("minFilter", gl, layer, gl.LINEAR_MIPMAP_NEAREST),
            magFilter:this._getGLOption("magFilter", gl, layer, gl.LINEAR),
            wrapS:this._getGLOption("wrapS", gl, layer, gl.REPEAT),
            wrapT:this._getGLOption("wrapT", gl, layer, gl.REPEAT),
            isDepth:this._getOption(layer.isDepth, false),
            depthMode:this._getGLOption("depthMode", gl, layer, gl.LUMINANCE),
            depthCompareMode:this._getGLOption("depthCompareMode", gl, layer, gl.COMPARE_R_TO_TEXTURE),
            depthCompareFunc:this._getGLOption("depthCompareFunc", gl, layer, gl.LEQUAL),
            flipY:this._getOption(layer.flipY, true),
            width:this._getOption(layer.width, 1),
            height:this._getOption(layer.height, 1),
            internalFormat:this._getGLOption("internalFormat", gl, layer, gl.LEQUAL),
            sourceFormat:this._getGLOption("sourceType", gl, layer, gl.ALPHA),
            sourceType:this._getGLOption("sourceType", gl, layer, gl.UNSIGNED_BYTE),
            update:null
        });

        if (this.destroyed) { // Node was destroyed while loading
            layer.texture.destroy();
        }

        this._engine.display.imageDirty = true;
    };

    SceneJS.Texture.prototype._getGLOption = function (name, gl, layer, defaultVal) {
        var value = layer[name];
        if (value == undefined) {
            return defaultVal;
        }
        var glName = SceneJS_webgl_enumMap[value];
        if (glName == undefined) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Unrecognised value for texture node property '" + name + "' value: '" + value + "'");
        }
        var glValue = gl[glName];
        //                if (!glValue) {
        //                    throw new SceneJS.errors.WebGLUnsupportedNodeConfigException(
        //                            "This browser's WebGL does not support value of SceneJS.texture node property '" + name + "' value: '" + value + "'");
        //                }
        return glValue;
    };

    SceneJS.Texture.prototype._getOption = function (value, defaultVal) {
        return (value == undefined) ? defaultVal : value;
    };

    /**
     * Set some writeable properties on a layer
     */
    SceneJS.Texture.prototype.setLayer = function (cfg) {

        if (cfg.index == undefined || cfg.index == null) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Invalid texture set layer argument: index null or undefined");
        }

        if (cfg.index < 0 || cfg.index >= this._core.layers.length) {
            throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "Invalid texture set layer argument: index out of range (" + this._core.layers.length + " layers defined)");
        }

        this._setLayer(parseInt(cfg.index), cfg);

        this._engine.display.imageDirty = true;
    };

    /**
     * Set some writeable properties on multiple layers
     */
    SceneJS.Texture.prototype.setLayers = function (layers) {
        var indexNum;
        for (var index in layers) {
            if (layers.hasOwnProperty(index)) {
                if (index != undefined || index != null) {
                    indexNum = parseInt(index);
                    if (indexNum < 0 || indexNum >= this._core.layers.length) {
                        throw SceneJS_error.fatalError(
                            SceneJS.errors.ILLEGAL_NODE_CONFIG,
                            "Invalid texture set layer argument: index out of range (" + this._core.layers.length + " layers defined)");
                    }
                    this._setLayer(indexNum, layers[index] || {});
                }
            }
        }
        this._engine.display.imageDirty = true;
    };

    SceneJS.Texture.prototype._setLayer = function (index, cfg) {

        cfg = cfg || {};

        var layer = this._core.layers[index];

        if (cfg.blendFactor != undefined && cfg.blendFactor != null) {
            layer.blendFactor = cfg.blendFactor;
        }

        if (cfg.source) {
            var source = layer._source;
            if (source && source.configure) {
                source.configure(cfg.source);
            }
        }

        if (cfg.translate || cfg.rotate || cfg.scale) {
            this._setLayerTransform(cfg, layer);
        }
    };

    SceneJS.Texture.prototype._setLayerTransform = function (cfg, layer) {

        var matrix;
        var t;

        if (cfg.translate) {
            var translate = cfg.translate;
            if (translate.x != undefined) {
                layer.translate.x = translate.x;
            }
            if (translate.y != undefined) {
                layer.translate.y = translate.y;
            }
            matrix = SceneJS_math_translationMat4v([ translate.x || 0, translate.y || 0, 0]);
        }

        if (cfg.scale) {
            var scale = cfg.scale;
            if (scale.x != undefined) {
                layer.scale.x = scale.x;
            }
            if (scale.y != undefined) {
                layer.scale.y = scale.y;
            }
            t = SceneJS_math_scalingMat4v([ scale.x || 1, scale.y || 1, 1]);
            matrix = matrix ? SceneJS_math_mulMat4(matrix, t) : t;
        }

        if (cfg.rotate) {
            var rotate = cfg.rotate;
            if (rotate.z != undefined) {
                layer.rotate.z = rotate.z || 0;
            }
            t = SceneJS_math_rotationMat4v(rotate.z * 0.0174532925, [0, 0, 1]);
            matrix = matrix ? SceneJS_math_mulMat4(matrix, t) : t;
        }

        if (matrix) {
            layer.matrix = matrix;
            if (!layer.matrixAsArray) {
                layer.matrixAsArray = new Float32Array(layer.matrix);
            } else {
                layer.matrixAsArray.set(layer.matrix);
            }

            layer.matrixAsArray = new Float32Array(layer.matrix); // TODO - reinsert into array
        }
    };

    SceneJS.Texture.prototype._compile = function (ctx) {
        if (!this._core.hash) {
            this._makeHash();
        }
        this._engine.display.texture = coreStack[stackLen++] = this._core;
        this._compileNodes(ctx);
        this._engine.display.texture = (--stackLen > 0) ? coreStack[stackLen - 1] : defaultCore;
    };

    SceneJS.Texture.prototype._makeHash = function () {
        var core = this._core;
        var hash;
        if (core.layers && core.layers.length > 0) {
            var layers = core.layers;
            var hashParts = [];
            var texLayer;
            for (var i = 0, len = layers.length; i < len; i++) {
                texLayer = layers[i];
                hashParts.push("/");
                hashParts.push(texLayer.applyFrom);
                hashParts.push("/");
                hashParts.push(texLayer.applyTo);
                hashParts.push("/");
                hashParts.push(texLayer.blendMode);
                if (texLayer.matrix) {
                    hashParts.push("/anim");
                }
            }
            hash = hashParts.join("");
        } else {
            hash = "";
        }
        if (core.hash != hash) {
            core.hash = hash;
        }
    };

    SceneJS.Texture.prototype._destroy = function () {
        if (this._core.useCount == 1) { // Last resource user
            var layers = this._core.layers;
            var layer;
            var source;
            for (var i = 0, len = layers.length; i < len; i++) {
                layer = layers[i];
                if (layer.texture) {
                    layer.texture.destroy();
                }
                source = layer._source;
                if (source && source.destroy) {
                    source.destroy();
                }
            }
        }
    };

})();/**
 * @class Scene graph node which defines the modelling transform to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
SceneJS.XForm = SceneJS_NodeFactory.createNodeType("xform");

SceneJS.XForm.prototype._init = function (params) {

    if (this._core.useCount == 1) { // This node is the resource definer

        SceneJS_modelXFormStack.buildCore(this._core);

        this.setElements(params.elements);
    }
};

/**
 * Get Model matrix
 * @return {*}
 */
SceneJS.XForm.prototype.getModelMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return this._core.matrix;
};

/**
 * Get World matrix. That's the multiplication of this node's Model matrix by the World matrix of the the next
 * tranform (scale, XForm, translate etc) node on the path to the scene root.
 * @return {*}
 */
SceneJS.XForm.prototype.getWorldMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return Array.apply( [], this._core.mat);
};


SceneJS.XForm.prototype.setElements = function (elements) {

    elements = elements || SceneJS_math_identityMat4();

    if (elements.length != 16) {
        throw SceneJS_error.fatalError(
            SceneJS.errors.ILLEGAL_NODE_CONFIG,
            "SceneJS.XForm elements should number 16");
    }

    var core = this._core;

    if (!core.matrix) {
        core.matrix = elements;

    } else {

        for (var i = 0; i < 16; i++) {
            core.matrix[i] = elements[i];
        }
    }

//    core.mat.set(core.matrix);
//    core.normalMat.set(
//        SceneJS_math_transposeMat4(
//            SceneJS_math_inverseMat4(core.matrix, SceneJS_math_mat4())));


    core.setDirty();

    this._engine.display.imageDirty = true;

    return this;
};

SceneJS.XForm.prototype._compile = function (ctx) {
    SceneJS_modelXFormStack.push(this._core);
    this._compileNodes(ctx);
    SceneJS_modelXFormStack.pop();
};

/**
 * @class Scene graph node which defines a modelling transform matrix to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
SceneJS.Matrix = SceneJS_NodeFactory.createNodeType("matrix");

SceneJS.Matrix.prototype._init = function(params) {

    if (this._core.useCount == 1) { // This node is the resource definer

        SceneJS_modelXFormStack.buildCore(this._core);

        this.setElements(params.elements);
    }
};

/**
 * Get Model matrix
 * @return {*}
 */
SceneJS.Matrix.prototype.getModelMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return this._core.matrix;
};

/**
 * Get World matrix. That's the multiplication of this node's Model matrix by the World matrix of the the next
 * tranform (scale, matrix, translate etc) node on the path to the scene root.
 * @return {*}
 */
SceneJS.Matrix.prototype.getWorldMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return Array.apply( [], this._core.mat);
};

/**
 * Sets the matrix elements
 * @type {Function}
 */
SceneJS.Matrix.prototype.setMatrix = function(elements) {

    elements = elements || SceneJS_math_identityMat4();

    if (elements.length != 16) {
        throw SceneJS_error.fatalError(
                SceneJS.errors.ILLEGAL_NODE_CONFIG,
                "SceneJS.Matrix elements should number 16");
    }

    var core = this._core;

    if (!core.matrix) {
        core.matrix = elements;

    } else {

        for (var i = 0; i < 16; i++) {
            core.matrix[i] = elements[i];
        }
    }

    core.setDirty();

    this._engine.display.imageDirty = true;

    return this;
};

/**
 * Sets the matrix elements
 * @deprecated
 * @type {Function}
 */
SceneJS.Matrix.prototype.setElements = SceneJS.Matrix.prototype.setMatrix;

SceneJS.Matrix.prototype._compile = function(ctx) {
    SceneJS_modelXFormStack.push(this._core);
    this._compileNodes(ctx);
    SceneJS_modelXFormStack.pop();
};
/**
 * @class Scene graph node which defines a rotation modelling transform to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
SceneJS.Rotate = SceneJS_NodeFactory.createNodeType("rotate");

SceneJS.Rotate.prototype._init = function(params) {

    if (this._core.useCount == 1) { // This node is the resource definer

        SceneJS_modelXFormStack.buildCore(this._core);
        
        this.setMultOrder(params.multOrder);

        this.setAngle(params.angle);

        this.setXYZ({
            x: params.x,
            y: params.y,
            z: params.z
        });

        var core = this._core;

        this._core.buildMatrix = function() {
            core.matrix = SceneJS_math_rotationMat4v(core.angle * Math.PI / 180.0, [core.x, core.y, core.z]);
        };
    }
};

/**
 * Get Model matrix
 * @return {*}
 */
SceneJS.Rotate.prototype.getModelMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return this._core.matrix;
};

/**
 * Get World matrix. That's the multiplication of this node's Model matrix by the World matrix of the the next
 * tranform (scale, rotate, translate etc) node on the path to the scene root.
 * @return {*}
 */
SceneJS.Rotate.prototype.getWorldMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return Array.apply( [], this._core.mat);
};

/**
 * Sets the multiplication order of this node's transform matrix with respect to the parent modeling transform
 * in the scene graph.
 *
 * @param {String} multOrder Mulplication order - "post" and "pre"
 */
SceneJS.Rotate.prototype.setMultOrder = function(multOrder) {

    multOrder = multOrder || "post";

    if (multOrder != "post" && multOrder != "pre") {

        throw SceneJS_error.fatalError(
                SceneJS.errors.NODE_CONFIG_EXPECTED,
                "Illegal multOrder for rotate node - '" + multOrder + "' should be 'pre' or 'post'");
    }

    this._core.multOrder = multOrder;

    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.setAngle = function(angle) {
    this._core.angle = angle || 0;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.getAngle = function() {
    return this._core.angle;
};

SceneJS.Rotate.prototype.setXYZ = function(xyz) {

    xyz = xyz || {};

    this._core.x = xyz.x || 0;
    this._core.y = xyz.y || 0;
    this._core.z = xyz.z || 0;

    this._core.setDirty();

    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.getXYZ = function() {
    return {
        x: this._core.x,
        y: this._core.y,
        z: this._core.z
    };
};

SceneJS.Rotate.prototype.setX = function(x) {
    this._core.x = x;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.getX = function() {
    return this._core.x;
};

SceneJS.Rotate.prototype.setY = function(y) {
    this._core.y = y;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.getY = function() {
    return this._core.y;
};

SceneJS.Rotate.prototype.setZ = function(z) {
    this._core.z = z;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype.getZ = function() {
    return this._core.z;
};

SceneJS.Rotate.prototype.incAngle = function(angle) {
    this._core.angle += angle;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Rotate.prototype._compile = function(ctx) {
    SceneJS_modelXFormStack.push(this._core);
    this._compileNodes(ctx);
    SceneJS_modelXFormStack.pop();
};
/**
 * @class Scene graph node which defines a translation modelling transform to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
SceneJS.Translate = SceneJS_NodeFactory.createNodeType("translate");

SceneJS.Translate.prototype._init = function(params) {

    if (this._core.useCount == 1) { // This node is the resource definer

        SceneJS_modelXFormStack.buildCore(this._core);
        
        this.setMultOrder(params.multOrder);

        this.setXYZ({
            x: params.x,
            y: params.y,
            z: params.z
        });

        var core = this._core;

        this._core.buildMatrix = function() {
            core.matrix = SceneJS_math_translationMat4v([core.x, core.y, core.z], core.matrix);
        };
    }
};

/**
 * Get Model matrix
 * @return {*}
 */
SceneJS.Translate.prototype.getModelMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return this._core.matrix;
};

/**
 * Get World matrix. That's the multiplication of this node's Model matrix by the World matrix of the the next
 * tranform (scale, translate, translate etc) node on the path to the scene root.
 * @return {*}
 */
SceneJS.Translate.prototype.getWorldMatrix = function() {
    if (this._core.dirty) {
        this._core.build();
    }
    return Array.apply( [], this._core.mat);
};


/**
 * Sets the multiplication order of this node's transform matrix with respect to the parent modeling transform
 * in the scene graph.
 *
 * @param {String} multOrder Mulplication order - "post" and "pre"
 */
SceneJS.Translate.prototype.setMultOrder = function(multOrder) {

    multOrder = multOrder || "post";

    if (multOrder != "post" && multOrder != "pre") {

        throw SceneJS_error.fatalError(
                SceneJS.errors.NODE_CONFIG_EXPECTED,
                "Illegal multOrder for translate node - '" + multOrder + "' should be 'pre' or 'post'");
    }

    this._core.multOrder = multOrder;

    this._core.setDirty();

    this._engine.display.imageDirty = true;
};

SceneJS.Translate.prototype.setXYZ = function(xyz) {

    xyz = xyz || {};

    this._core.x = xyz.x || 0;
    this._core.y = xyz.y || 0;
    this._core.z = xyz.z || 0;

    this._core.setDirty();

    this._engine.display.imageDirty = true;

    return this;
};

SceneJS.Translate.prototype.getXYZ = function() {
    return {
        x: this._core.x,
        y: this._core.y,
        z: this._core.z
    };
};

SceneJS.Translate.prototype.setX = function(x) {
    this._core.x = x;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype.getX = function() {
    return this._core.x;
};

SceneJS.Translate.prototype.setY = function(y) {
    this._core.y = y;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype.getY = function() {
    return this._core.y;
};

SceneJS.Translate.prototype.setZ = function(z) {
    this._core.z = z;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype.getZ = function() {
    return this._core.z;
};

SceneJS.Translate.prototype.incX = function(x) {
    this._core.x += x;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype.incY = function(y) {
    this._core.y += y;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype.incZ = function(z) {
    this._core.z += z;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
    return this;
};

SceneJS.Translate.prototype._compile = function(ctx) {
    SceneJS_modelXFormStack.push(this._core);
    this._compileNodes(ctx);
    SceneJS_modelXFormStack.pop();
};
/**
 * @class Scene graph node which defines a rotation modelling transform to apply to the objects in its subgraph
 * @extends SceneJS.Node
 */
SceneJS.Scale = SceneJS_NodeFactory.createNodeType("scale");

SceneJS.Scale.prototype._init = function (params) {

    if (this._core.useCount == 1) { // This node is the resource definer

        SceneJS_modelXFormStack.buildCore(this._core);

        this.setMultOrder(params.multOrder);

        this.setXYZ({
            x:params.x,
            y:params.y,
            z:params.z
        });

        var core = this._core;

        this._core.buildMatrix = function () {
            core.matrix = SceneJS_math_scalingMat4v([core.x, core.y, core.z]);
        };
    }
};

/**
 * Get Model matrix
 * @return {*}
 */
SceneJS.Scale.prototype.getModelMatrix = function () {
    if (this._core.dirty) {
        this._core.build();
    }
    return this._core.matrix;
};

/**
 * Get World matrix. That's the multiplication of this node's Model matrix by the World matrix of the the next
 * tranform (scale, scale, translate etc) node on the path to the scene root.
 * @return {*}
 */
SceneJS.Scale.prototype.getWorldMatrix = function () {
    if (this._core.dirty) {
        this._core.build();
    }
    return Array.apply([], this._core.mat);
};


/**
 * Sets the multiplication order of this node's transform matrix with respect to the parent modeling transform
 * in the scene graph.
 *
 * @param {String} multOrder Mulplication order - "post" and "pre"
 */
SceneJS.Scale.prototype.setMultOrder = function (multOrder) {

    multOrder = multOrder || "post";

    if (multOrder != "post" && multOrder != "pre") {

        throw SceneJS_error.fatalError(
            SceneJS.errors.NODE_CONFIG_EXPECTED,
            "Illegal multOrder for scale node - '" + multOrder + "' should be 'pre' or 'post'");
    }

    this._core.multOrder = multOrder;

    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.getAngle = function () {
    return this._core.angle;
};

SceneJS.Scale.prototype.setXYZ = function (xyz) {

    xyz = xyz || {};

    this._core.x = xyz.x == undefined ? 1 : xyz.x;
    this._core.y = xyz.y == undefined ? 1 : xyz.y;
    this._core.z = xyz.z == undefined ? 1 : xyz.z;

    this._core.setDirty();

    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.getXYZ = function () {
    return {
        x:this._core.x,
        y:this._core.y,
        z:this._core.z
    };
};

SceneJS.Scale.prototype.setX = function (x) {
    this._core.x = x;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.getX = function () {
    return this._core.x;
};

SceneJS.Scale.prototype.setY = function (y) {
    this._core.y = y;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.getY = function () {
    return this._core.y;
};

SceneJS.Scale.prototype.setZ = function (z) {
    this._core.z = z;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.getZ = function () {
    return this._core.z;
};

SceneJS.Scale.prototype.incX = function (x) {
    this._core.x += x;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype.incY = function (y) {
    this._core.y += y;
    this._core.matrixDirty = true;
};

SceneJS.Scale.prototype.incZ = function (z) {
    this._core.z += z;
    this._core.setDirty();
    this._engine.display.imageDirty = true;
};

SceneJS.Scale.prototype._compile = function (ctx) {
    SceneJS_modelXFormStack.push(this._core);
    this._compileNodes(ctx);
    SceneJS_modelXFormStack.pop();
};
/**
 * Provides a model transform stack in front of the renderer.
 * Nodes peek push and pop to the stack, while the renderer peeks at
 * the transform on the top of the stack whenever it builds a renderer node.
 *
 */
var SceneJS_modelXFormStack = new (function () {

    var defaultMatrix = SceneJS_math_identityMat4();
    var defaultMat = new Float32Array(defaultMatrix);

    var defaultNormalMatrix = SceneJS_math_transposeMat4(
        SceneJS_math_inverseMat4(
            SceneJS_math_identityMat4(),
            SceneJS_math_mat4()));
    var defaultNormalMat = new Float32Array(defaultNormalMatrix);

    var defaultCore = {
        type:"xform",
        stateId:SceneJS._baseStateId++,

        matrix:defaultMatrix,
        mat:defaultMat,

        normalMatrix:defaultNormalMatrix,
        normalMat:defaultNormalMat,

        parent:null, // Parent transform core
        cores:[], // Child transform cores
        numCores:0, // Number of child transform cores
        dirty:false, // Does this subtree need matrices rebuilt
        matrixDirty:false
    };

    var transformStack = [];
    var stackLen = 0;

    this.top = defaultCore;

    var dirty;

    var self = this;

    SceneJS_events.addListener(
        SceneJS_events.SCENE_COMPILING,
        function () {
            stackLen = 0;
            self.top = defaultCore;
            dirty = true;
        });

    SceneJS_events.addListener(
        SceneJS_events.OBJECT_COMPILING,
        function (params) {

            if (dirty) {

                if (stackLen > 0) {

                    params.display.modelTransform = transformStack[stackLen - 1];

                } else {

                    params.display.modelTransform = defaultCore;
                }

                dirty = false;
            }
        });

    /**
     * Creates a fresh transformation core
     * @param core
     */
    this.buildCore = function (core) {

        /*
         * Transform tree node properties
         */
        core.parent = null;         // Parent transform core
        core.cores = [];            // Child transform cores
        core.numCores = 0;          // Number of child transform cores
        core.matrixDirty = false;

        core.matrix = SceneJS_math_identityMat4();

        core.mat = new Float32Array(core.matrix);
        core.normalMat = new Float32Array(
            SceneJS_math_transposeMat4(
                SceneJS_math_inverseMat4(core.matrix, SceneJS_math_mat4())));

        core.dirty = false;         // Does this subtree need matrices rebuilt

        core.setDirty = function () {

            core.matrixDirty = true;

            if (core.dirty) {
                // return;
            }

            setDirty(core);
        };

        /**
         * Recursively flag this subtree of transforms cores as dirty,
         * ie. needing their matrices rebuilt.
         */
        function setDirty(core) {

            core.dirty = true;
            core.matrixDirty = true;

            for (var i = 0, len = core.numCores; i < len; i++) {
                setDirty(core.cores[i]);
            }
        }

        /**
         * Pre-multiply matrices at cores on path up to root into matrix at this core
         */
        core.build = function () {

            if (core.matrixDirty) {
                if (core.buildMatrix) { // Matrix might be explicit property on some transform node types
                    core.buildMatrix();
                }
                core.matrixDirty = false;
            }

            var parent = core.parent;

            var matrix;

            if (parent) {

                matrix = core.matrix.slice(0);

                while (parent) {

                    if (parent.matrixDirty) {

                        if (parent.buildMatrix) { // Matrix might be explicit property on some transform node types
                            parent.buildMatrix();
                        }
                        parent.mat.set(parent.matrix);
                        parent.normalMat.set(
                            SceneJS_math_transposeMat4(
                                SceneJS_math_inverseMat4(parent.matrix, SceneJS_math_mat4())));

                        parent.matrixDirty = false;
                    }

                    SceneJS_math_mulMat4(parent.matrix, matrix, matrix);

                    if (!parent.dirty) {
                        //   break;
                    }

                    //  parent.dirty = false;

                    parent = parent.parent;
                }

            } else {

                matrix = core.matrix;
            }

            //            if (!core.mat) {
            //
            //                core.mat = new Float32Array(matrix);
            //
            //                core.normalMat = new Float32Array(
            //                        SceneJS_math_transposeMat4(
            //                                SceneJS_math_inverseMat4(matrix, SceneJS_math_mat4())));
            //            } else {

            core.mat.set(matrix);

            core.normalMat.set(
                SceneJS_math_transposeMat4(
                    SceneJS_math_inverseMat4(matrix, SceneJS_math_mat4())));
            //}

           core.dirty = false;
        };
    };

    this.push = function (core) {

        transformStack[stackLen++] = core;

        core.parent = this.top;
        core.dirty = true;

        if (this.top) {
            this.top.cores[this.top.numCores++] = core;
        }

        core.numCores = 0;

        this.top = core;

        dirty = true;
    };

    this.pop = function () {

        this.top = (--stackLen > 0) ? transformStack[stackLen - 1] : defaultCore;


        dirty = true;
    };

})();
/**
 * Container for custom node types
 */
SceneJS.Types = new (function () {

    /**
     * Installs a node type
     * @param typeName
     * @param methods
     */
    this.addType = function (typeName, methods) {
        SceneJS_NodeFactory.createNodeType(typeName, methods,
            // Augments the basic node type with our custom type's methods
            function (type) {
                var method;
                for (var methodName in methods) {
                    if (methods.hasOwnProperty(methodName)) {
                        method = methods[methodName];
                        switch (methodName) {
                            case "init": // Deprecated
                            case "construct":
                                (function () {
                                    var _method = methods[methodName];
                                    type.prototype._init = function (params) {
                                        _method.call(this, params);
                                    };

                                    // Mark node type as a plugin
                                    type.prototype._fromPlugin = true;
                                })();
                                break;
                            case "destroy": // Deprecated
                            case "destruct":
                                type.prototype._destroy = method;
                                break;
                            default:
                                type.prototype[methodName] = method;
                        }
                    }
                }
            });
    };

    /**
     * Tests if given node type is installed
     * @param typeName
     * @param methods
     */
    this.hasType = function (typeName) {
        return !!SceneJS_NodeFactory.nodeTypes[typeName];
    };
})();

/**
 * @class Renders and picks a {@link SceneJS.Scene}
 * @private
 *
 * <p>A Display is a container of {@link SceneJS_Object}s which are created (or updated) by a depth-first
 * <b>compilation traversal</b> of the nodes within a {@link SceneJS.Scene}.</b>
 *
 * <h2>Rendering Pipeline</h2>
 *
 * <p>Conceptually, a Display implements a pipeline with the following stages:</p>
 *
 * <ol>
 * <li>Create or update {@link SceneJS_Object}s during scene compilation</li>
 * <li>Organise the {@link SceneJS_Object} into an <b>object list</b></li>
 * <li>Determine the GL state sort order for the object list</li>
 * <li>State sort the object list</li>
 * <li>Create a <b>draw list</b> containing {@link SceneJS_Chunk}s belonging to the {@link SceneJS_Object}s in the object list</li>
 * <li>Render the draw list to draw the image</li>
 * </ol>
 *
 * <p>An update to the scene causes the pipeline to be re-executed from one of these stages, and SceneJS is designed
 * so that the pipeline is always re-executed from the latest stage possible to avoid redoing work.</p>
 *
 * <p>For example:</p>
 *
 * <ul>
 * <li>when an object is created or updated, we need to (re)do stages 2, 3, 4, 5 and 6</li>
 * <li>when an object is made invisible, we need to redo stages 5 and 6</li>
 * <li>when an object is assigned to a different scene render layer (works like a render bin), we need to redo
 *   stages 3, 4, 5, and 6</li>
 *<li>when the colour of an object changes, or maybe when the viewpoint changes, we simplt redo stage 6</li>
 * </ul>
 *
 * <h2>Object Creation</h2>
 * <p>The object soup (stage 1) is constructed by a depth-first traversal of the scene graph, which we think of as
 * "compiling" the scene graph into the Display. As traversal visits each scene node, the node's state core is
 * set on the Display (such as {@link #flags}, {@link #layer}, {@link #renderer} etc), which we think of as the
 * cores that are active at that instant during compilation. Each of the scene's leaf nodes is always
 * a {@link SceneJS.Geometry}, and when traversal visits one of those it calls {@link #buildObject} to create an
 * object in the soup. For each of the currently active cores, the object is given a {@link SceneJS_Chunk}
 * containing the WebGL calls for rendering it.</p>
 *
 * <p>The object also gets a shader (implemented by {@link SceneJS_Program}), taylored to render those state cores.</p>
 *
 * <p>Limited re-compilation may also be done on portions of a scene that have been added or sufficiently modified. When
 * traversal visits a {@link SceneJS.Geometry} for which an object already exists in the display, {@link #buildObject}
 * may update the {@link SceneJS_Chunk}s on the object as required for any changes in the core soup since the
 * last time the object was built. If differences among the cores require it, then {@link #buildObject} may also replace
 * the object's {@link SceneJS_Program} in order to render the new core soup configuration.</p>
 *
 * <p>So in summary, to each {@link SceneJS_Object} it builds, {@link #buildObject} creates a list of
 * {@link SceneJS_Chunk}s to render the set of node state cores that are currently set on the {@link SceneJS_Display}.
 * When {@link #buildObject} is re-building an existing object, it may replace one or more {@link SceneJS_Chunk}s
 * for state cores that have changed from the last time the object was built or re-built.</p>

 * <h2>Object Destruction</h2>
 * <p>Destruction of a scene graph branch simply involves a call to {@link #removeObject} for each {@link SceneJS.Geometry}
 * in the branch.</p>
 *
 * <h2>Draw List</h2>
 * <p>The draw list is actually comprised of three lists of state chunks: a "pick" list to render a pick buffer
 * for colour-indexed GPU picking, along with an "opaque" list and "transparent" list for normal image rendering.
 * For normal rendering the opaque list is rendered, then blending is enabled and the transparent list is rendered.
 * The chunks in these lists are held in the state-sorted order of their objects in #_objectList, with runs of
 * duplicate states removed, as mentioned.</p>
 *
 * <p>After a scene update, we set a flag on the display to indicate the stage we will need to redo from. The pipeline is
 * then lazy-redone on the next call to #render or #pick.</p>
 */
var SceneJS_Display = function (cfg) {

    /* Display is bound to the lifetime of an HTML5 canvas
     */
    this._canvas = cfg.canvas;

    /* Factory which creates and recycles {@link SceneJS_Program} instances
     */
    this._programFactory = new SceneJS_ProgramFactory({
        canvas:cfg.canvas
    });

    /* Factory which creates and recycles {@link SceneJS.Chunk} instances
     */
    this._chunkFactory = new SceneJS_ChunkFactory();

    /**
     * Node state core for the last {@link SceneJS.Enable} visited during scene graph compilation traversal
     * @type Object
     */
    this.enable = null;

    /**
     * Node state core for the last {@link SceneJS.Flags} visited during scene graph compilation traversal
     * @type Object
     */
    this.flags = null;

    /**
     * Node state core for the last {@link SceneJS.Layer} visited during scene graph compilation traversal
     * @type Object
     */
    this.layer = null;

    /**
     * Node state core for the last {@link SceneJS.Renderer} visited during scene graph compilation traversal
     * @type Object
     */
    this.renderer = null;

    /**
     * Node state core for the last {@link SceneJS.DepthBuf} visited during scene graph compilation traversal
     * @type Object
     */
    this.depthbuf = null;

    /**
     * Node state core for the last {@link SceneJS.ColorBuf} visited during scene graph compilation traversal
     * @type Object
     */
    this.colorbuf = null;

    /**
     * Node state core for the last {@link SceneJS.View} visited during scene graph compilation traversal
     * @type Object
     */
    this.view = null;

    /**
     * Node state core for the last {@link SceneJS.Lights} visited during scene graph compilation traversal
     * @type Object
     */
    this.lights = null;

    /**
     * Node state core for the last {@link SceneJS.Material} visited during scene graph compilation traversal
     * @type Object
     */
    this.material = null;

    /**
     * Node state core for the last {@link SceneJS.Texture} visited during scene graph compilation traversal
     * @type Object
     */
    this.texture = null;

    /**
     * Node state core for the last {@link SceneJS.XForm} visited during scene graph compilation traversal
     * @type Object
     */
    this.modelTransform = null;

    /**
     * Node state core for the last {@link SceneJS.LookAt} visited during scene graph compilation traversal
     * @type Object
     */
    this.viewTransform = null;

    /**
     * Node state core for the last {@link SceneJS.Camera} visited during scene graph compilation traversal
     * @type Object
     */
    this.projTransform = null;

    /**
     * Node state core for the last {@link SceneJS.Framebuf} visited during scene graph compilation traversal
     * @type Object
     */
    this.framebuf = null;

    /**
     * Node state core for the last {@link SceneJS.Clips} visited during scene graph compilation traversal
     * @type Object
     */
    this.clips = null;

    /**
     * Node state core for the last {@link SceneJS.MorphGeometry} visited during scene graph compilation traversal
     * @type Object
     */
    this.morphGeometry = null;

    /**
     * Node state core for the last {@link SceneJS.Name} visited during scene graph compilation traversal
     * @type Object
     */
    this.name = null;

    /**
     * Node state core for the last {@link SceneJS.Tag} visited during scene graph compilation traversal
     * @type Object
     */
    this.tag = null;

    /**
     * Node state core for the last render {@link SceneJS.Node} listener encountered during scene graph compilation traversal
     * @type Object
     */
    this.renderListeners = null;

    /**
     * Node state core for the last {@link SceneJS.Shader} visited during scene graph compilation traversal
     * @type Object
     */
    this.shader = null;

    /**
     * Node state core for the last {@link SceneJS.ShaderParams} visited during scene graph compilation traversal
     * @type Object
     */
    this.shaderParams = null;

    /**
     * Node state core for the last {@link SceneJS.Style} visited during scene graph compilation traversal
     * @type Object
     */
    this.style = null;

    /**
     * Node state core for the last {@link SceneJS.Geometry} visited during scene graph compilation traversal
     * @type Object
     */
    this.geometry = null;

    /* Factory which creates and recycles {@link SceneJS_Object} instances
     */
    this._objectFactory = new SceneJS_ObjectFactory();

    /**
     * The objects in the display
     */
    this._objects = {};

    /**
     * Ambient color, which must be given to gl.clearColor before draw list iteration
     */
    this._ambientColor = [0, 0, 0];

    /**
     * The object list, containing all elements of #_objects, kept in GL state-sorted order
     */
    this._objectList = [];
    this._objectListLen = 0;

    /* The "draw list", comprised collectively of three lists of state chunks belong to visible objects
     * within #_objectList: a "pick" list to render a pick buffer for colour-indexed GPU picking, along with an
     * "opaque" list and "transparent" list for normal image rendering. For normal rendering the opaque list is
     * rendered, then blending is enabled and the transparent list is rendered. The chunks in these lists
     * are held in the state-sorted order of their objects in #_objectList, with runs of duplicate states removed.
     */
    this._opaqueDrawList = [];         // State chunk list to render opaque objects
    this._opaqueDrawListLen = 0;

    this._transparentDrawList = [];    // State chunk list to render transparent objects
    this._transparentDrawListLen = 0;

    this._pickDrawList = [];           // State chunk list to render scene to pick buffer
    this._pickDrawListLen = 0;

    /* The frame context holds state shared across a single render of the draw list, along with any results of
     * the render, such as pick hits
     */
    this._frameCtx = {
        pickNames:[], // Pick names of objects hit during pick render
        canvas:this._canvas            // The canvas
    };

    /* The frame context has this facade which is given to scene node "rendered" listeners
     * to allow application code to access things like transform matrices from within those listeners.
     */
    this._frameCtx.renderListenerCtx = new SceneJS.RenderContext(this._frameCtx);

    /*-------------------------------------------------------------------------------------
     * Flags which schedule what the display is to do when #render is next called.
     *------------------------------------------------------------------------------------*/

    /**
     * Flags the object list as needing to be rebuilt from existing objects on the next call to {@link #render} or {@link #pick}.
     * Setting this will cause the rendering pipeline to be executed from stage #2 (see class comment),
     * causing object list rebuild, state order determination, state sort, draw list construction and image render.
     * @type Boolean
     */
    this.objectListDirty = true;

    /**
     * Flags the object list as needing state orders to be computed on the next call to {@link #render} or {@link #pick}.
     * Setting this will cause the rendering pipeline to be executed from stage #3 (see class comment),
     * causing state order determination, state sort, draw list construction and image render.
     * @type Boolean
     */
    this.stateOrderDirty = true;

    /**
     * Flags the object list as needing to be state sorted on the next call to {@link #render} or {@link #pick}.
     * Setting this will cause the rendering pipeline to be executed from stage #4 (see class comment),
     * causing state sort, draw list construction and image render.
     * @type Boolean
     */
    this.stateSortDirty = true;

    /**
     * Flags the draw list as needing to be rebuilt from the object list on the next call to {@link #render} or {@link #pick}.
     * Setting this will cause the rendering pipeline to be executed from stage #5 (see class comment),
     * causing draw list construction and image render.
     * @type Boolean
     */
    this.drawListDirty = true;

    /**
     * Flags the image as needing to be redrawn from the draw list on the next call to {@link #render} or {@link #pick}.
     * Setting this will cause the rendering pipeline to be executed from stage #6 (see class comment),
     * causing the image render.
     * @type Boolean
     */
    this.imageDirty = true;

    /**
     * Flags the neccessity for the image buffer to be re-rendered from the draw list.
     * @type Boolean
     */
    this.pickBufDirty = true;           // Redraw pick buffer
    this.rayPickBufDirty = true;        // Redraw raypick buffer
};

/**
 * Reallocates WebGL resources for objects within this display
 */
SceneJS_Display.prototype.webglRestored = function () {

    this._programFactory.webglRestored();// Reallocate programs

    this._chunkFactory.webglRestored(); // Recache shader var locations

    var gl = this._canvas.gl;

    if (this.pickBuf) {
        this.pickBuf.webglRestored(gl);          // Rebuild pick buffers
    }

    if (this.rayPickBuf) {
        this.rayPickBuf.webglRestored(gl);
    }

    this.imageDirty = true;             // Need redraw
};

/**
 * Internally creates (or updates) a {@link SceneJS_Object} of the given ID from whatever node state cores are currently set
 * on this {@link SceneJS_Display}. The object is created if it does not already exist in the display, otherwise it is
 * updated with the current state cores, possibly replacing cores already referenced by the object.
 *
 * @param {String} objectId ID of object to create or update
 */
SceneJS_Display.prototype.buildObject = function (objectId) {

    var object = this._objects[objectId];

    if (!object) { // Create object

        object = this._objects[objectId] = this._objectFactory.getObject(objectId);

        this.objectListDirty = true;
    }

    object.layer = this.layer;
    object.texture = this.texture;
    object.geometry = this.geometry;
    object.enable = this.enable;
    object.flags = this.flags;
    object.tag = this.tag;

    //if (!object.hash) {

    var hash = ([                   // Build current state hash
        this.geometry.hash,
        this.shader.hash,
        this.clips.hash,
        this.morphGeometry.hash,
        this.texture.hash,
        this.lights.hash

    ]).join(";");

    if (!object.program || hash != object.hash) {

        /* Get new program for object if no program or hash mismatch
         */

        if (object.program) {
            this._programFactory.putProgram(object.program);
        }

        object.program = this._programFactory.getProgram(hash, this);
        object.hash = hash;
    }
    //}

    /* Build draw chunks for object
     */
    this._setChunk(object, 0, "program");          // Must be first
    this._setChunk(object, 1, "xform", this.modelTransform);
    this._setChunk(object, 2, "lookAt", this.viewTransform);
    this._setChunk(object, 3, "camera", this.projTransform);
    this._setChunk(object, 4, "flags", this.flags);
    this._setChunk(object, 5, "shader", this.shader);
    this._setChunk(object, 6, "shaderParams", this.shaderParams);
    this._setChunk(object, 7, "style", this.style);
    this._setChunk(object, 8, "depthbuf", this.depthbuf);
    this._setChunk(object, 9, "colorbuf", this.colorbuf);
    this._setChunk(object, 10, "view", this.view);
    this._setChunk(object, 11, "name", this.name);
    this._setChunk(object, 12, "lights", this.lights);
    this._setChunk(object, 13, "material", this.material);
    this._setChunk(object, 14, "texture", this.texture);
    this._setChunk(object, 15, "framebuf", this.framebuf);
    this._setChunk(object, 16, "clips", this.clips);
    this._setChunk(object, 17, "morphGeometry", this.morphGeometry);
    this._setChunk(object, 18, "listeners", this.renderListeners);      // Must be after the above chunks
    this._setChunk(object, 19, "geometry", this.geometry); // Must be last
};

SceneJS_Display.prototype._setChunk = function (object, order, chunkType, core, unique) {

    var chunkId;
    var chunkClass = this._chunkFactory.chunkTypes[chunkType];

    if (chunkClass.unique) {

        // Suppress run culling for this core type
        chunkId = core.stateId + 1;

    } else if (core) {

        // Core supplied
        if (core.empty) { // Only set default cores for state types that have them

            var oldChunk = object.chunks[order];

            if (oldChunk) {
                this._chunkFactory.putChunk(oldChunk); // Release previous chunk to pool
            }

            object.chunks[order] = null;

            return;
        }

        chunkId = chunkClass.programGlobal
            ? core.stateId + 1
            : ((object.program.id + 1) * 50000) + core.stateId + 1;

    } else {

        // No core supplied, probably a program.
        // Only one chunk of this type per program.
        chunkId = ((object.program.id + 1) * 50000);
    }

    var oldChunk = object.chunks[order];

    if (oldChunk) {

        if (oldChunk.id == chunkId) { // Avoid needless chunk reattachment
            return;
        }

        this._chunkFactory.putChunk(oldChunk); // Release previous chunk to pool
    }

    object.chunks[order] = this._chunkFactory.getChunk(chunkId, chunkType, object.program, core); // Attach new chunk

    // Ambient light is global across everything in display, and
    // can never be disabled, so grab it now because we want to
    // feed it to gl.clearColor before each display list render
    if (chunkType == "lights") {
        this._setAmbient(core);
    }
};

SceneJS_Display.prototype._setAmbient = function (core) {
    var lights = core.lights;
    var light;
    for (var i = 0, len = lights.length; i < len; i++) {
        light = lights[i];
        if (light.mode == "ambient") {
            this._ambientColor = light.color;
        }
    }
};

/**
 * Removes an object from this display
 *
 * @param {String} objectId ID of object to remove
 */
SceneJS_Display.prototype.removeObject = function (objectId) {

    var object = this._objects[objectId];

    if (!object) {
        return;
    }

    this._programFactory.putProgram(object.program);

    object.program = null;
    object.hash = null;

    this._objectFactory.putObject(object);

    delete this._objects[objectId];

    this.objectListDirty = true;
};

/**
 * Set a tag selector to selectively activate objects that have matching SceneJS.Tag nodes
 */
SceneJS_Display.prototype.selectTags = function (tagSelector) {
    this._tagSelector = tagSelector;
    this.drawListDirty = true;
};

/**
 * Render this display. What actually happens in the method depends on what flags are set.
 */
SceneJS_Display.prototype.render = function (params) {

    params = params || {};

    if (this.objectListDirty) {

        this._buildObjectList();          // Build object render bin

        this.objectListDirty = false;
        this.stateOrderDirty = true;        // Now needs state ordering
    }

    if (this.stateOrderDirty) {

        this._makeStateSortKeys();       // Compute state sort order

        this.stateOrderDirty = false;
        this.stateSortDirty = true;     // Now needs state sorting
    }

    if (this.stateSortDirty) {

        this._stateSort();              // State sort the object render bin

        this.stateSortDirty = false;
        this.drawListDirty = true;      // Now needs new visible object bin
    }

    if (this.drawListDirty) {           // Render visible list while building transparent list

        this._buildDrawList();

        this.imageDirty = true;
    }

    if (this.imageDirty || params.force) {

        this._doDrawList(false);        // Render, no pick

        this.imageDirty = false;
        this.pickBufDirty = true;       // Pick buff will now need rendering on next pick
    }
};

SceneJS_Display.prototype._buildObjectList = function () {
    this._objectListLen = 0;
    for (var objectId in this._objects) {
        if (this._objects.hasOwnProperty(objectId)) {
            this._objectList[this._objectListLen++] = this._objects[objectId];
        }
    }
};

SceneJS_Display.prototype._makeStateSortKeys = function () { // TODO: state sort for sound objects?
    var object;
    for (var i = 0, len = this._objectListLen; i < len; i++) {
        object = this._objectList[i];
        object.sortKey = object.program
            ? (((object.layer.priority + 1) * 100000000)
            + ((object.program.id + 1) * 100000)
            + (object.texture.stateId * 1000))
            //    + i // Force stability among same-priority objects across multiple sorts
            : -1;   // Non-visual object (eg. sound)
    }
};

//SceneJS_Display.prototype._makeStateSortKeys = function () { // TODO: state sort for sound objects?
//    var object;
//    for (var i = 0, len = this._objectListLen; i < len; i++) {
//        object = this._objectList[i];
//        object.sortKey = object.program
//            ? (((object.layer.priority + 1) * 1000000000)
//            + ((object.program.id + 1) * 1000000)
//            + (object.texture.stateId * 10000)
//            + (object.geometry.stateId))
//            //    + i // Force stability among same-priority objects across multiple sorts
//            : -1;   // Non-visual object (eg. sound)
//    }
//};

SceneJS_Display.prototype._stateSort = function () {
    this._objectList.length = this._objectListLen;
    this._objectList.sort(this._stateSortObjects);
};

SceneJS_Display.prototype._stateSortObjects = function (a, b) {
    return a.sortKey - b.sortKey;
};

SceneJS_Display.prototype._buildDrawList = function () {

    this._lastStateId = this._lastStateId || [];
    this._lastPickStateId = this._lastPickStateId || [];

    for (var i = 0; i < 22; i++) {
        this._lastStateId[i] = null;
        this._lastPickStateId[i] = null;
    }

    this._opaqueDrawListLen = 0;
    this._pickDrawListLen = 0;
    this._transparentDrawListLen = 0;

    var object;
    var tagMask;
    var tagRegex;
    var tagCore;
    var flags;
    var chunks;
    var chunk;
    var transparent;
    var picking;

    if (this._tagSelector) {
        tagMask = this._tagSelector.mask;
        tagRegex = this._tagSelector.regex;
    }

    if (!this._xpBuf) {
        this._xpBuf = [];
    }
    this._xpBufLen = 0;

    for (var i = 0, len = this._objectListLen; i < len; i++) {

        object = this._objectList[i];

        // Cull invisible objects
        if (object.enable.enabled === false) {
            continue;
        }

        flags = object.flags;

        // Cull invisible objects
        if (flags.enabled === false) {
            continue;
        }

        if (!object.layer.enabled) { // Skip disabled layers
            continue;
        }

        if (tagMask) { // Skip unmatched tags. No tag matching in visible bin prevent this being done on every frame.

            tagCore = object.tag;

            if (tagCore.tag) {

                if (tagCore.mask != tagMask) { // Scene tag mask was updated since last render
                    tagCore.mask = tagMask;
                    tagCore.matches = tagRegex.test(tagCore.tag);
                }

                if (!tagCore.matches) {
                    continue;
                }
            }
        }

        transparent = flags.transparent;

        if (transparent) {
            this._xpBuf[this._xpBufLen++] = object;
        }

        /* Add object's chunks to appropriate chunk list
         */

        chunks = object.chunks;

        picking = flags.picking;

        for (var j = 0, lenj = chunks.length; j < lenj; j++) {

            chunk = chunks[j];

            if (chunk) {

                // As we apply the state chunk lists we track the ID of most types of chunk in order
                // to cull redundant re-applications of runs of the same chunk - except for those chunks with a
                // 'unique' flag. We don't want to cull runs of geometry chunks because they contain the GL
                // drawElements calls which render the objects.

                // Chunk IDs are only considered unique within the same program. Therefore, whenever we do a
                // program switch, we'll be applying all the different types of chunk again.

                if (!transparent && chunk.draw) {
                    if (chunk.unique || this._lastStateId[j] != chunk.id) {
                        this._opaqueDrawList[this._opaqueDrawListLen++] = chunk;
                        this._lastStateId[j] = chunk.id;
                    }
                }

                if (chunk.pick) { // Transparent objects are pickable
                    if (picking) { // Don't pick unpickable objects
                        if (chunk.unique || this._lastPickStateId[j] != chunk.id) {
                            this._pickDrawList[this._pickDrawListLen++] = chunk;
                            this._lastPickStateId[j] = chunk.id;
                        }
                    }
                }
            }
        }
    }

    if (this._xpBufLen > 0) {

        for (var i = 0; i < 22; i++) {  // TODO: magic number!
            this._lastStateId[i] = null;
        }

        for (var i = 0; i < this._xpBufLen; i++) {

            object = this._xpBuf[i];
            chunks = object.chunks;

            for (var j = 0, lenj = chunks.length; j < lenj; j++) {

                chunk = chunks[j];

                if (chunk && chunk.draw) {

                    if (chunk.unique || this._lastStateId[j] != chunk.id) {
                        this._transparentDrawList[this._transparentDrawListLen++] = chunk;
                        this._lastStateId[j] = chunk.id;
                    }
                }
            }
        }
    }

    this.drawListDirty = false;
};

SceneJS_Display.prototype.pick = function (params) {

    //  return null;

    var canvas = this._canvas.canvas;

    var hit = null;

    var canvasX = params.canvasX;
    var canvasY = params.canvasY;

    /*-------------------------------------------------------------
     * Pick object using normal GPU colour-indexed pick
     *-----------------------------------------------------------*/

    var pickBuf = this.pickBuf;                                                   // Lazy-create pick buffer

    if (!pickBuf) {
        pickBuf = this.pickBuf = new SceneJS_PickBuffer({ canvas:this._canvas });
        this.pickBufDirty = true;                                                 // Freshly-created pick buffer is dirty
    }

    this.render(); // Do any pending visible render

    pickBuf.bind();                                                                 // Bind pick buffer

    if (this.pickBufDirty) {                          // Render pick buffer

        pickBuf.clear();

        this._doDrawList(true);

        this._canvas.gl.finish();

        this.pickBufDirty = false;                                                  // Pick buffer up to date
        this.rayPickBufDirty = true;                                                // Ray pick buffer now dirty
    }

    var pix = pickBuf.read(canvasX, canvasY);                                       // Read pick buffer
    var pickedObjectIndex = pix[0] + pix[1] * 256 + pix[2] * 65536;
    var pickIndex = (pickedObjectIndex >= 1) ? pickedObjectIndex - 1 : -1;

    pickBuf.unbind();                                                               // Unbind pick buffer

    var pickName = this._frameCtx.pickNames[pickIndex];                                   // Map pixel to name

    if (pickName) {

        hit = {
            name:pickName.name,
            path:pickName.path,
            nodeId:pickName.nodeId,
            canvasPos:[canvasX, canvasY]
        };

        if (params.rayPick) { // Ray pick to find position

            var rayPickBuf = this.rayPickBuf; // Lazy-create Z-pick buffer
            if (!rayPickBuf) {
                rayPickBuf = this.rayPickBuf = new SceneJS_PickBuffer({ canvas:this._canvas });
            }

            rayPickBuf.bind();

            if (this.rayPickBufDirty) {

                rayPickBuf.clear();

                this._doDrawList(true, true); // pick, rayPick

                this.rayPickBufDirty = false;
            }

            pix = rayPickBuf.read(canvasX, canvasY);

            rayPickBuf.unbind();

            /* Read normalised device Z coordinate, which will be
             * in range of [0..1] with z=0 at front
             */
            var screenZ = this._unpackDepth(pix);

            var w = canvas.width;
            var h = canvas.height;

            /* Calculate clip space coordinates, which will be in range
             * of x=[-1..1] and y=[-1..1], with y=(+1) at top
             */
            var x = (canvasX - w / 2) / (w / 2);           // Calculate clip space coordinates
            var y = -(canvasY - h / 2) / (h / 2);

            var projMat = this._frameCtx.cameraMat;
            var viewMat = this._frameCtx.viewMat;

            var pvMat = SceneJS_math_mulMat4(projMat, viewMat, []);
            var pvMatInverse = SceneJS_math_inverseMat4(pvMat, []);

            var world1 = SceneJS_math_transformVector4(pvMatInverse, [x, y, -1, 1]);
            world1 = SceneJS_math_mulVec4Scalar(world1, 1 / world1[3]);

            var world2 = SceneJS_math_transformVector4(pvMatInverse, [x, y, 1, 1]);
            world2 = SceneJS_math_mulVec4Scalar(world2, 1 / world2[3]);

            var dir = SceneJS_math_subVec3(world2, world1, []);

            var vWorld = SceneJS_math_addVec3(world1, SceneJS_math_mulVec4Scalar(dir, screenZ, []), []);

            hit.worldPos = vWorld;
        }
    }

    return hit;
};

SceneJS_Display.prototype._unpackDepth = function (depthZ) {
    var vec = [depthZ[0] / 256.0, depthZ[1] / 256.0, depthZ[2] / 256.0, depthZ[3] / 256.0];
    var bitShift = [1.0 / (256.0 * 256.0 * 256.0), 1.0 / (256.0 * 256.0), 1.0 / 256.0, 1.0];
    return SceneJS_math_dotVector4(vec, bitShift);
};

SceneJS_Display.prototype._doDrawList = function (pick, rayPick) {

    var frameCtx = this._frameCtx;                                                // Reset rendering context

    var gl = this._canvas.gl;

    frameCtx.program = null;
    frameCtx.framebuf = null;
    frameCtx.viewMat = null;
    frameCtx.modelMat = null;
    frameCtx.cameraMat = null;
    frameCtx.renderer = null;

    frameCtx.depthbufEnabled = null;
    frameCtx.clearDepth = null;
    frameCtx.depthFunc = gl.LESS;

    frameCtx.scissorTestEnabled = false;

    frameCtx.blendEnabled = false;

    frameCtx.vertexBuf = false;
    frameCtx.normalBuf = false;
    frameCtx.uvBuf = false;
    frameCtx.uvBuf2 = false;
    frameCtx.colorBuf = false;
    frameCtx.backfaces = true;
    frameCtx.frontface = "ccw";
    frameCtx.pick = !!pick;

    frameCtx.lineWidth = 1;

    frameCtx.transparencyPass = false;

    gl.viewport(0, 0, this._canvas.canvas.width, this._canvas.canvas.height);
    gl.clearColor(this._ambientColor[0], this._ambientColor[1], this._ambientColor[2], 0.0);
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT | gl.STENCIL_BUFFER_BIT);
    gl.frontFace(gl.CCW);
    gl.disable(gl.CULL_FACE);

    if (pick) { // Pick

        frameCtx.pickIndex = 0;
        frameCtx.rayPick = !!rayPick;

        for (var i = 0, len = this._pickDrawListLen; i < len; i++) {        // Push picking chunks
            this._pickDrawList[i].pick(frameCtx);
        }

    } else { // Draw

        for (var i = 0, len = this._opaqueDrawListLen; i < len; i++) {      // Push opaque rendering chunks
            this._opaqueDrawList[i].draw(frameCtx);
        }

        if (this._transparentDrawListLen > 0) {

            // Disables some types of state changes during
            // transparency pass, such as blending disable
            frameCtx.transparencyPass = true;

            //  Enable blending
            gl.enable(gl.BLEND);
            frameCtx.blendEnabled = true;

            gl.blendFunc(gl.SRC_ALPHA, gl.ONE_MINUS_SRC_ALPHA);

            for (var i = 0, len = this._transparentDrawListLen; i < len; i++) { // Push transparent rendering chunks
                this._transparentDrawList[i].draw(frameCtx);
            }

            //  Disable blending
            gl.disable(gl.BLEND);
            frameCtx.blendEnabled = false;

            frameCtx.transparencyPass = false;
        }
    }

    gl.flush();                                                         // Flush GL

    if (frameCtx.program) {                                                  // Unbind remaining program
        //frameCtx.program.unbind();
    }

    if (frameCtx.framebuf) {                                                 // Unbind remaining frame buffer
        gl.finish();
        // frameCtx.framebuf.unbind();
    }

    if (frameCtx.renderer) {                           // Forget last call-time renderer properties
        //     frameCtx.renderer.props.restoreProps(gl);
    }
};

SceneJS_Display.prototype.destroy = function () {
    this._programFactory.destroy();
};

/**
 * @class Manages creation, sharing and recycle of {@link SceneJS_ProgramSource} instances
 * @private
 */
var SceneJS_ProgramSourceFactory = new (function () {

    this._sourceCache = {}; // Source codes are shared across all scenes


    /**
     * Get sourcecode for a program to render the given states
     */
    this.getSource = function (hash, states) {

        var source = this._sourceCache[hash];
        if (source) {
            source.useCount++;
            return source;
        }

        return this._sourceCache[hash] = new SceneJS_ProgramSource(

            hash,

            this._composePickingVertexShader(states), // pickVertexSrc
            this._composePickingFragmentShader(states), // pickFragmentSrc
            this._composeRenderingVertexShader(states), // drawVertexSrc
            this._composeRenderingFragmentShader(states)  // drawfragmentSrc
        );
    };

    /**
     * Releases program source code
     */
    this.putSource = function (hash) {
        var source = this._sourceCache[hash];
        if (source) {
            if (--source.useCount == 0) {
                this._sourceCache[source.hash] = null;
            }
        }
    };

    this._composePickingVertexShader = function (states) {

        var customShaders = states.shader.shaders || {};

        var customVertexShader = customShaders.vertex || {};
        var vertexHooks = customVertexShader.hooks || {};

        var customFragmentShader = customShaders.fragment || {};
        var fragmentHooks = customFragmentShader.hooks || {};

        var clipping = states.clips.clips.length > 0;
        var morphing = !!states.morphGeometry.targets;
        var normals = this._hasNormals(states);

        var src = [
            "precision mediump float;",
            "attribute vec3 SCENEJS_aVertex;",
            "uniform mat4 SCENEJS_uMMatrix;",
            "uniform mat4 SCENEJS_uMNMatrix;",
            "uniform mat4 SCENEJS_uVMatrix;",
            "uniform mat4 SCENEJS_uVNMatrix;",
            "uniform mat4 SCENEJS_uPMatrix;"
        ];

        if (normals) {
            src.push("attribute vec3 SCENEJS_aNormal;");
        }

        if (normals && (fragmentHooks.worldNormal || fragmentHooks.viewNormal)) {
            src.push("varying   vec3 SCENEJS_vWorldNormal;");   // Output world-space vertex normal
            src.push("varying   vec3 SCENEJS_vViewNormal;");   // Output world-space vertex normal
        }

        // if (clipping || fragmentHooks.worldPosClip) {
        src.push("varying vec4 SCENEJS_vWorldVertex;");
        // }


        src.push("varying vec4 SCENEJS_vViewVertex;\n");
        src.push("varying vec4 SCENEJS_vProjVertex;\n");

        src.push("uniform vec3 SCENEJS_uWorldEye;");                     // World-space eye position
        src.push("varying vec3 SCENEJS_vWorldEyeVec;");

        if (customVertexShader.code) {
            src.push("\n" + customVertexShader.code + "\n");
        }

        if (morphing) {
            src.push("uniform float SCENEJS_uMorphFactor;");       // LERP factor for morph
            if (states.morphGeometry.targets[0].vertexBuf) {      // target2 has these arrays also
                src.push("attribute vec3 SCENEJS_aMorphVertex;");
            }
        }

        src.push("void main(void) {");
        src.push("   vec4 tmpVertex=vec4(SCENEJS_aVertex, 1.0); ");

        if (normals) {
            src.push("  vec4 modelNormal = vec4(SCENEJS_aNormal, 0.0); ");
        }

        if (vertexHooks.modelPos) {
            src.push("tmpVertex=" + vertexHooks.modelPos + "(tmpVertex);");
        }

        if (morphing) {
            if (states.morphGeometry.targets[0].vertexBuf) {
                src.push("  vec4 vMorphVertex = vec4(SCENEJS_aMorphVertex, 1.0); ");

                if (vertexHooks.modelPos) {
                    src.push("vMorphVertex=" + vertexHooks.modelPos + "(vMorphVertex);");
                }

                src.push("  tmpVertex = vec4(mix(tmpVertex.xyz, vMorphVertex.xyz, SCENEJS_uMorphFactor), 1.0); ");
            }
        }


        src.push("  tmpVertex = SCENEJS_uMMatrix * tmpVertex; ");

        if (vertexHooks.worldPos) {
            src.push("tmpVertex=" + vertexHooks.worldPos + "(tmpVertex);");
        }

        // if (clipping || fragmentHooks.worldPosClip) {
        src.push("  SCENEJS_vWorldVertex = tmpVertex; ");
        //    }

        src.push("SCENEJS_vWorldEyeVec = normalize(SCENEJS_uWorldEye - tmpVertex.xyz);");

        src.push("  tmpVertex = SCENEJS_uVMatrix * tmpVertex; ");

        if (vertexHooks.viewPos) {
            src.push("tmpVertex=" + vertexHooks.viewPos + "(tmpVertex);");
        }

        src.push("  SCENEJS_vViewVertex = tmpVertex;");

        if (normals && (fragmentHooks.worldNormal || fragmentHooks.viewNormal)) {
            src.push("  vec3 worldNormal = normalize((SCENEJS_uMNMatrix * modelNormal).xyz); ");
            src.push("  SCENEJS_vWorldNormal = worldNormal;");
            src.push("  SCENEJS_vViewNormal = (SCENEJS_uVNMatrix * vec4(worldNormal, 1.0)).xyz;");
        }

        src.push("  SCENEJS_vProjVertex = SCENEJS_uPMatrix * tmpVertex;");


        src.push("  gl_Position = SCENEJS_vProjVertex;");
        src.push("}");

        if (false && debugCfg.logScripts == true) {
            SceneJS.log.info(src);
        }
        return src;
    };

    /**
     * Composes a fragment shader script for rendering mode in current scene state
     * @private
     */
    this._composePickingFragmentShader = function (states) {

        var customShaders = states.shader.shaders || {};
        var customFragmentShader = customShaders.fragment || {};
        var fragmentHooks = customFragmentShader.hooks || {};

        var clipping = states.clips.clips.length > 0;

        var normals = this._hasNormals(states);

        var src = [
            "precision mediump float;"
        ];

        src.push("vec4 packDepth(const in float depth) {");
        src.push("  const vec4 bitShift = vec4(256.0*256.0*256.0, 256.0*256.0, 256.0, 1.0);");
        src.push("  const vec4 bitMask  = vec4(0.0, 1.0/256.0, 1.0/256.0, 1.0/256.0);");
        src.push("  vec4 res = fract(depth * bitShift);");
        src.push("  res -= res.xxyz * bitMask;");
        src.push("  return res;");
        src.push("}");


        src.push("varying vec4 SCENEJS_vWorldVertex;");
        src.push("varying vec4 SCENEJS_vViewVertex;");                  // View-space vertex
        src.push("varying vec4 SCENEJS_vProjVertex;");

        src.push("uniform bool SCENEJS_uRayPickMode;");                   // Z-pick mode when true else colour-pick

        src.push("uniform vec3 SCENEJS_uPickColor;");                   // Used in colour-pick mode

        src.push("uniform float SCENEJS_uZNear;");                      // Used in Z-pick mode
        src.push("uniform float SCENEJS_uZFar;");                       // Used in Z-pick mode

        src.push("varying vec3 SCENEJS_vWorldEyeVec;");                          // Direction of view-space vertex from eye

        src.push("uniform bool  SCENEJS_uClipping;");

        if (normals && (fragmentHooks.worldNormal || fragmentHooks.viewNormal)) {

            src.push("varying vec3 SCENEJS_vWorldNormal;");                  // World-space normal
            src.push("varying vec3 SCENEJS_vViewNormal;");                   // View-space normal
        }
        /*-----------------------------------------------------------------------------------
         * Variables - Clipping
         *----------------------------------------------------------------------------------*/

        if (clipping) {
            for (var i = 0; i < states.clips.clips.length; i++) {
                src.push("uniform float SCENEJS_uClipMode" + i + ";");
                src.push("uniform vec4  SCENEJS_uClipNormalAndDist" + i + ";");
            }
        }

        /*-----------------------------------------------------------------------------------
         * Custom GLSL
         *----------------------------------------------------------------------------------*/

        if (customFragmentShader.code) {
            src.push("\n" + customFragmentShader.code + "\n");
        }

        src.push("void main(void) {");

        if (fragmentHooks.worldPosClip) {
            src.push("if (" + fragmentHooks.worldPosClip + "(SCENEJS_vWorldVertex) == false) { discard; };");
        }
        if (fragmentHooks.viewPosClip) {
            src.push("if (!" + fragmentHooks.viewPosClip + "(SCENEJS_vViewVertex) == false) { discard; };");
        }

        if (clipping) {
            src.push("if (SCENEJS_uClipping) {");
            src.push("  float   dist;");
            for (var i = 0; i < states.clips.clips.length; i++) {
                src.push("    if (SCENEJS_uClipMode" + i + " != 0.0) {");
                src.push("        dist = dot(SCENEJS_vWorldVertex.xyz, SCENEJS_uClipNormalAndDist" + i + ".xyz) - SCENEJS_uClipNormalAndDist" + i + ".w;");
                src.push("        if (SCENEJS_uClipMode" + i + " == 1.0) {");
                src.push("            if (dist > 0.0) { discard; }");
                src.push("        }");
                src.push("        if (SCENEJS_uClipMode" + i + " == 2.0) {");
                src.push("            if (dist > 0.0) { discard; }");
                src.push("        }");
                src.push("    }");
            }
            src.push("}");
        }

        if (fragmentHooks.worldPos) {
            src.push(fragmentHooks.worldPos + "(SCENEJS_vWorldVertex);");
        }

        if (fragmentHooks.viewPos) {
            src.push(fragmentHooks.viewPos + "(SCENEJS_vViewVertex);");
        }

        if (fragmentHooks.worldEyeVec) {
            src.push(fragmentHooks.worldEyeVec + "(SCENEJS_vWorldEyeVec);");
        }

        if (normals && fragmentHooks.worldNormal) {
            src.push(fragmentHooks.worldNormal + "(SCENEJS_vWorldNormal);");
        }

        if (normals && fragmentHooks.viewNormal) {
            src.push(fragmentHooks.viewNormal + "(SCENEJS_vViewNormal);");
        }

        src.push("    if (SCENEJS_uRayPickMode) {");
        src.push("          float zNormalizedDepth = abs((SCENEJS_uZNear + SCENEJS_vViewVertex.z) / (SCENEJS_uZFar - SCENEJS_uZNear));");
        src.push("          gl_FragColor = packDepth(zNormalizedDepth); ");

        src.push("    } else {");
        src.push("          gl_FragColor = vec4(SCENEJS_uPickColor.rgb, 1.0);  ");
        src.push("    }");
        src.push("}");


        if (false && debugCfg.logScripts == true) {
            SceneJS.log.info(src);
        }
        return src;
    };


    /*===================================================================================================================
     *
     * Rendering vertex shader
     *
     *==================================================================================================================*/

    this._isTexturing = function (states) {
        if (states.texture.layers && states.texture.layers.length > 0) {
            if (states.geometry.uvBuf || states.geometry.uvBuf2) {
                return true;
            }
            if (states.morphGeometry.targets && (states.morphGeometry.targets[0].uvBuf || states.morphGeometry.targets[0].uvBuf2)) {
                return true;
            }
        }
        return false;
    };

    this._hasNormals = function (states) {
        if (states.geometry.normalBuf) {
            return true;
        }
        if (states.morphGeometry.targets && states.morphGeometry.targets[0].normalBuf) {
            return true;
        }
        return false;
    };

    this._composeRenderingVertexShader = function (states) {

        var customShaders = states.shader.shaders || {};

        /* Do a full custom shader replacement if code supplied without hooks
         */
        if (customShaders.vertex && customShaders.vertex.code && !customShaders.vertex.hooks) {
            return customShaders.vertex.code;
        }

        var customVertexShader = customShaders.vertex || {};
        var vertexHooks = customVertexShader.hooks || {};

        var customFragmentShader = customShaders.fragment || {};
        var fragmentHooks = customFragmentShader.hooks || {};

        var texturing = this._isTexturing(states);
        var normals = this._hasNormals(states);
        var clipping = states.clips.clips.length > 0;
        var morphing = !!states.morphGeometry.targets;

        var src = [
            "precision mediump float;"
        ];

        src.push("attribute vec3 SCENEJS_aVertex;");                // Model coordinates

        src.push("uniform vec3 SCENEJS_uWorldEye;");                     // World-space eye position
        src.push("varying vec3 SCENEJS_vWorldEyeVec;");                  // Output world-space eye vector

        /*-----------------------------------------------------------------------------------
         * Variables - normals
         *----------------------------------------------------------------------------------*/

        if (normals) {

            src.push("attribute vec3 SCENEJS_aNormal;");        // Normal vectors
            src.push("uniform   mat4 SCENEJS_uMNMatrix;");      // Model normal matrix
            src.push("uniform   mat4 SCENEJS_uVNMatrix;");      // View normal matrix

            src.push("varying   vec3 SCENEJS_vWorldNormal;");   // Output world-space vertex normal
            src.push("varying   vec3 SCENEJS_vViewNormal;");    // Output view-space vertex normal

            for (var i = 0; i < states.lights.lights.length; i++) {
                var light = states.lights.lights[i];
                if (light.mode == "ambient") {
                    continue;
                }
                if (light.mode == "dir") {
                    src.push("uniform vec3 SCENEJS_uLightDir" + i + ";");
                }
                if (light.mode == "point") {
                    src.push("uniform vec3 SCENEJS_uLightPos" + i + ";");
                }
                if (light.mode == "spot") {
                    src.push("uniform vec3 SCENEJS_uLightPos" + i + ";");
                }

                /* Vector from vertex to light, packaged with the pre-computed length of that vector
                 */
                src.push("varying vec4 SCENEJS_vViewLightVecAndDist" + i + ";");    // varying for fragment lighting
            }
        }

        if (texturing) {
            if (states.geometry.uvBuf) {
                src.push("attribute vec2 SCENEJS_aUVCoord;");      // UV coords
            }
            if (states.geometry.uvBuf2) {
                src.push("attribute vec2 SCENEJS_aUVCoord2;");     // UV2 coords
            }
        }

        /* Vertex color variables
         */
        if (states.geometry.colorBuf) {
            src.push("attribute vec4 SCENEJS_aVertexColor;");       // UV2 coords
            src.push("varying vec4 SCENEJS_vColor;");               // Varying for fragment texturing
        }

        src.push("uniform mat4 SCENEJS_uMMatrix;");                 // Model matrix
        src.push("uniform mat4 SCENEJS_uVMatrix;");                 // View matrix
        src.push("uniform mat4 SCENEJS_uPMatrix;");                 // Projection matrix

        if (clipping || fragmentHooks.worldPos) {
            src.push("varying vec4 SCENEJS_vWorldVertex;");         // Varying for fragment clip or world pos hook
        }

        if (fragmentHooks.viewPos) {
            src.push("varying vec4 SCENEJS_vViewVertex;");          // Varying for fragment view clip hook
        }

        if (texturing) {                                            // Varyings for fragment texturing
            if (states.geometry.uvBuf) {
                src.push("varying vec2 SCENEJS_vUVCoord;");
            }
            if (states.geometry.uvBuf2) {
                src.push("varying vec2 SCENEJS_vUVCoord2;");
            }
        }

        /*-----------------------------------------------------------------------------------
         * Variables - Morphing
         *----------------------------------------------------------------------------------*/

        if (morphing) {
            src.push("uniform float SCENEJS_uMorphFactor;");       // LERP factor for morph
            if (states.morphGeometry.targets[0].vertexBuf) {      // target2 has these arrays also
                src.push("attribute vec3 SCENEJS_aMorphVertex;");
            }
            if (normals) {
                if (states.morphGeometry.targets[0].normalBuf) {
                    src.push("attribute vec3 SCENEJS_aMorphNormal;");
                }
            }
        }

        if (customVertexShader.code) {
            src.push("\n" + customVertexShader.code + "\n");
        }


        src.push("void main(void) {");
        src.push("vec4 tmpVertex=vec4(SCENEJS_aVertex, 1.0); ");

        if (vertexHooks.modelPos) {
            src.push("tmpVertex=" + vertexHooks.modelPos + "(tmpVertex);");
        }

        src.push("  vec4 modelVertex = tmpVertex; ");
        if (normals) {
            src.push("  vec4 modelNormal = vec4(SCENEJS_aNormal, 0.0); ");
        }

        /*
         * Morphing - morph targets are in same model space as the geometry
         */
        if (morphing) {
            if (states.morphGeometry.targets[0].vertexBuf) {
                src.push("  vec4 vMorphVertex = vec4(SCENEJS_aMorphVertex, 1.0); ");
                src.push("  modelVertex = vec4(mix(modelVertex.xyz, vMorphVertex.xyz, SCENEJS_uMorphFactor), 1.0); ");
            }
            if (normals) {
                if (states.morphGeometry.targets[0].normalBuf) {
                    src.push("  vec4 vMorphNormal = vec4(SCENEJS_aMorphNormal, 1.0); ");
                    src.push("  modelNormal = vec4( mix(modelNormal.xyz, vMorphNormal.xyz, SCENEJS_uMorphFactor), 1.0); ");
                }
            }
        }

        src.push("  vec4 worldVertex = SCENEJS_uMMatrix * modelVertex; ");

        if (vertexHooks.worldPos) {
            src.push("worldVertex=" + vertexHooks.worldPos + "(worldVertex);");
        }

        if (vertexHooks.viewMatrix) {
            src.push("vec4 viewVertex = " + vertexHooks.viewMatrix + "(SCENEJS_uVMatrix) * worldVertex;");
        } else {
            src.push("vec4 viewVertex  = SCENEJS_uVMatrix * worldVertex; ");
        }

        if (vertexHooks.viewPos) {
            src.push("viewVertex=" + vertexHooks.viewPos + "(viewVertex);");    // Vertex hook function
        }

        if (normals) {
            src.push("  vec3 worldNormal = normalize((SCENEJS_uMNMatrix * modelNormal).xyz); ");
            src.push("  SCENEJS_vWorldNormal = worldNormal;");
            src.push("  SCENEJS_vViewNormal = (SCENEJS_uVNMatrix * vec4(worldNormal, 1.0)).xyz;");
        }

        if (clipping || fragmentHooks.worldPos) {
            src.push("  SCENEJS_vWorldVertex = worldVertex;");                  // Varying for fragment world clip or hooks
        }

        if (fragmentHooks.viewPos) {
            src.push("  SCENEJS_vViewVertex = viewVertex;");                    // Varying for fragment hooks
        }

        if (vertexHooks.projMatrix) {
            src.push("gl_Position = " + vertexHooks.projMatrix + "(SCENEJS_uPMatrix) * viewVertex;");
        } else {
            src.push("  gl_Position = SCENEJS_uPMatrix * viewVertex;");
        }

        /*-----------------------------------------------------------------------------------
         * Logic - normals
         *
         * Transform the world-space lights into view space
         *----------------------------------------------------------------------------------*/

        src.push("  vec3 tmpVec3;");
        if (normals) {

            for (var i = 0; i < states.lights.lights.length; i++) {

                light = states.lights.lights[i];

                if (light.mode == "ambient") {
                    continue;
                }

                if (light.mode == "dir") {

                    /* Directional light
                     */
                    if (light.space == "world") {

                        /* World space light - transform vector to View space
                         */
                        src.push("SCENEJS_vViewLightVecAndDist" + i + " = vec4(-normalize((SCENEJS_uVMatrix * vec4(SCENEJS_uLightDir" + i + ", 0.0)).xyz), 0.0);");

                    } else {

                        /* View space light
                         */
                        src.push("SCENEJS_vViewLightVecAndDist" + i + " = vec4(-normalize(SCENEJS_uLightDir" + i + "), 0.0);");
                    }
                }

                if (light.mode == "point") {

                    /* Positional light
                     */
                    if (light.space == "world") {

                        /* World space light - transform position to View space
                         */
                        src.push("tmpVec3 = ((SCENEJS_uVMatrix * vec4(SCENEJS_uLightPos" + i + ", 1.0)).xyz - worldVertex.xyz);");
                        src.push("SCENEJS_vViewLightVecAndDist" + i + " = vec4(normalize(tmpVec3), length(tmpVec3));");

                    } else {

                        /* View space light
                         */
                        src.push("tmpVec3 = (SCENEJS_uLightPos" + i + ".xyz - worldVertex.xyz);");
                        src.push("SCENEJS_vViewLightVecAndDist" + i + " = vec4(normalize(tmpVec3), length(tmpVec3));");
                    }
                }
            }
        }

        src.push("SCENEJS_vWorldEyeVec = normalize(SCENEJS_uWorldEye - worldVertex.xyz);");

        if (texturing) {                                                        // varyings for fragment texturing
            if (states.geometry.uvBuf) {
                src.push("SCENEJS_vUVCoord = SCENEJS_aUVCoord;");
            }
            if (states.geometry.uvBuf2) {
                src.push("SCENEJS_vUVCoord2 = SCENEJS_aUVCoord2;");
            }
        }

        if (states.geometry.colorBuf) {
            src.push("SCENEJS_vColor = SCENEJS_aVertexColor;");                 // Varyings for fragment interpolated vertex coloring
        }
        src.push("}");


        if (false && debugCfg.logScripts === true) {
            SceneJS.log.info(src);
        }
        return src;
    };

    /*-----------------------------------------------------------------------------------------------------------------
     * Rendering Fragment shader
     *---------------------------------------------------------------------------------------------------------------*/

    this._composeRenderingFragmentShader = function (states) {

        var customShaders = states.shader.shaders || {};

        /* Do a full custom shader replacement if code supplied without hooks
         */
        if (customShaders.fragment && customShaders.fragment.code && !customShaders.fragment.hooks) {
            return customShaders.fragment.code;
        }

        var customFragmentShader = customShaders.fragment || {};
        var fragmentHooks = customFragmentShader.hooks || {};

        var texturing = this._isTexturing(states);
        var normals = this._hasNormals(states);
        var clipping = states.clips.clips.length > 0;

        var src = ["\n"];

        src.push("precision mediump float;");


        if (clipping || fragmentHooks.worldPos) {
            src.push("varying vec4 SCENEJS_vWorldVertex;");             // World-space vertex
        }

        if (fragmentHooks.viewPos) {
            src.push("varying vec4 SCENEJS_vViewVertex;");              // View-space vertex
        }

        /*-----------------------------------------------------------------------------------
         * Variables - Clipping
         *----------------------------------------------------------------------------------*/

        if (clipping) {
            for (var i = 0; i < states.clips.clips.length; i++) {
                src.push("uniform float SCENEJS_uClipMode" + i + ";");
                src.push("uniform vec4  SCENEJS_uClipNormalAndDist" + i + ";");
            }
        }

        if (texturing) {
            if (states.geometry.uvBuf) {
                src.push("varying vec2 SCENEJS_vUVCoord;");
            }
            if (states.geometry.uvBuf2) {
                src.push("varying vec2 SCENEJS_vUVCoord2;");
            }
            var layer;
            for (var i = 0, len = states.texture.layers.length; i < len; i++) {
                layer = states.texture.layers[i];
                src.push("uniform sampler2D SCENEJS_uSampler" + i + ";");
                if (layer.matrix) {
                    src.push("uniform mat4 SCENEJS_uLayer" + i + "Matrix;");
                }
                src.push("uniform float SCENEJS_uLayer" + i + "BlendFactor;");
            }
        }

        /* True when lighting
         */
        src.push("uniform bool  SCENEJS_uBackfaceTexturing;");
        src.push("uniform bool  SCENEJS_uBackfaceLighting;");
        src.push("uniform bool  SCENEJS_uSpecularLighting;");
        src.push("uniform bool  SCENEJS_uClipping;");
        src.push("uniform bool  SCENEJS_uAmbient;");
        src.push("uniform bool  SCENEJS_uDiffuse;");

        /* True when rendering transparency
         */
        src.push("uniform bool  SCENEJS_uTransparent;");

        /* Vertex color variable
         */
        if (states.geometry.colorBuf) {
            src.push("varying vec4 SCENEJS_vColor;");
        }

        src.push("uniform vec3  SCENEJS_uAmbientColor;");                         // Scene ambient colour - taken from clear colour

        src.push("uniform vec3  SCENEJS_uMaterialBaseColor;");
        src.push("uniform float SCENEJS_uMaterialAlpha;");
        src.push("uniform float SCENEJS_uMaterialEmit;");
        src.push("uniform vec3  SCENEJS_uMaterialSpecularColor;");
        src.push("uniform float SCENEJS_uMaterialSpecular;");
        src.push("uniform float SCENEJS_uMaterialShine;");

        src.push("varying vec3 SCENEJS_vWorldEyeVec;");                          // Direction of view-space vertex from eye

        if (normals) {

            src.push("varying vec3 SCENEJS_vWorldNormal;");                  // World-space normal
            src.push("varying vec3 SCENEJS_vViewNormal;");                   // View-space normal

            var light;
            for (var i = 0; i < states.lights.lights.length; i++) {
                light = states.lights.lights[i];
                if (light.mode == "ambient") {
                    continue;
                }
                src.push("uniform vec3  SCENEJS_uLightColor" + i + ";");
                if (light.mode == "point") {
                    src.push("uniform vec3  SCENEJS_uLightAttenuation" + i + ";");
                }
                src.push("varying vec4  SCENEJS_vViewLightVecAndDist" + i + ";");         // Vector from light to vertex
            }
        }

        if (customFragmentShader.code) {
            src.push("\n" + customFragmentShader.code + "\n");
        }

        src.push("void main(void) {");

        src.push("  vec3    ambient= SCENEJS_uAmbient ? SCENEJS_uAmbientColor : vec3(0.0, 0.0, 0.0);");

        /*-----------------------------------------------------------------------------------
         * Logic - Clipping
         *----------------------------------------------------------------------------------*/

        if (clipping) {
            src.push("if (SCENEJS_uClipping) {");
            src.push("  float   dist;");
            for (var i = 0; i < states.clips.clips.length; i++) {
                src.push("    if (SCENEJS_uClipMode" + i + " != 0.0) {");
                src.push("        dist = dot(SCENEJS_vWorldVertex.xyz, SCENEJS_uClipNormalAndDist" + i + ".xyz) - SCENEJS_uClipNormalAndDist" + i + ".w;");
                src.push("        if (SCENEJS_uClipMode" + i + " == 1.0) {");
                src.push("            if (dist > 0.0) { discard; }");
                src.push("        }");
                src.push("        if (SCENEJS_uClipMode" + i + " == 2.0) {");
                src.push("            if (dist > 0.0) { discard; }");
                src.push("        }");
                src.push("    }");
            }
            src.push("}");
        }

        if (texturing && states.geometry.uvBuf && fragmentHooks.texturePos) {
            src.push(fragmentHooks.texturePos + "(SCENEJS_vUVCoord);");
        }

        if (fragmentHooks.worldPos) {
            src.push(fragmentHooks.worldPos + "(SCENEJS_vWorldVertex);");
        }

        if (fragmentHooks.viewPos) {
            src.push(fragmentHooks.viewPos + "(SCENEJS_vViewVertex);");
        }

        if (fragmentHooks.worldEyeVec) {
            src.push(fragmentHooks.worldEyeVec + "(SCENEJS_vWorldEyeVec);");
        }

        if (normals && fragmentHooks.worldNormal) {
            src.push(fragmentHooks.worldNormal + "(SCENEJS_vWorldNormal);");
        }

        if (normals && fragmentHooks.viewNormal) {
            src.push(fragmentHooks.viewNormal + "(SCENEJS_vViewNormal);");
        }

        if (states.geometry.colorBuf) {
            src.push("  vec3    color   = SCENEJS_vColor.rgb;");
        } else {
            src.push("  vec3    color   = SCENEJS_uMaterialBaseColor;")
        }

        src.push("  float alpha         = SCENEJS_uMaterialAlpha;");
        src.push("  float emit          = SCENEJS_uMaterialEmit;");
        src.push("  float specular      = SCENEJS_uMaterialSpecular;");
        src.push("  vec3  specularColor = SCENEJS_uMaterialSpecularColor;");
        src.push("  float shine         = SCENEJS_uMaterialShine;");

        if (fragmentHooks.materialBaseColor) {
            src.push("color=" + fragmentHooks.materialBaseColor + "(color);");
        }
        if (fragmentHooks.materialAlpha) {
            src.push("alpha=" + fragmentHooks.materialAlpha + "(alpha);");
        }
        if (fragmentHooks.materialEmit) {
            src.push("emit=" + fragmentHooks.materialEmit + "(emit);");
        }
        if (fragmentHooks.materialSpecular) {
            src.push("specular=" + fragmentHooks.materialSpecular + "(specular);");
        }
        if (fragmentHooks.materialSpecularColor) {
            src.push("specularColor=" + fragmentHooks.materialSpecularColor + "(specularColor);");
        }
        if (fragmentHooks.materialShine) {
            src.push("shine=" + fragmentHooks.materialShine + "(shine);");
        }

        if (normals) {
            src.push("  float   attenuation = 1.0;");
            src.push("  vec3    viewNormalVec = SCENEJS_vViewNormal;");
        }

        var layer;
        if (texturing) {

            if (normals) {
                src.push("if (SCENEJS_uBackfaceTexturing || dot(SCENEJS_vWorldNormal, SCENEJS_vWorldEyeVec) > 0.0) {");
            }

            src.push("  vec4    texturePos;");
            src.push("  vec2    textureCoord=vec2(0.0,0.0);");

            for (var i = 0, len = states.texture.layers.length; i < len; i++) {
                layer = states.texture.layers[i];

                /* Texture input
                 */
                if (layer.applyFrom == "normal" && normals) {
                    if (states.geometry.normalBuf) {
                        src.push("texturePos=vec4(viewNormalVec.xyz, 1.0);");
                    } else {
                        SceneJS.log.warn("Texture layer applyFrom='normal' but geo has no normal vectors");
                        continue;
                    }
                }
                if (layer.applyFrom == "uv") {
                    if (states.geometry.uvBuf) {
                        src.push("texturePos = vec4(SCENEJS_vUVCoord.s, SCENEJS_vUVCoord.t, 1.0, 1.0);");
                    } else {
                        SceneJS.log.warn("Texture layer applyTo='uv' but geometry has no UV coordinates");
                        continue;
                    }
                }
                if (layer.applyFrom == "uv2") {
                    if (states.geometry.uvBuf2) {
                        src.push("texturePos = vec4(SCENEJS_vUVCoord2.s, SCENEJS_vUVCoord2.t, 1.0, 1.0);");
                    } else {
                        SceneJS.log.warn("Texture layer applyTo='uv2' but geometry has no UV2 coordinates");
                        continue;
                    }
                }

                /* Texture matrix
                 */
                if (layer.matrix) {
                    src.push("textureCoord=(SCENEJS_uLayer" + i + "Matrix * texturePos).xy;");
                } else {
                    src.push("textureCoord=texturePos.xy;");
                }

                /* Alpha from Texture
                 * */
                if (layer.applyTo == "alpha") {
                    if (layer.blendMode == "multiply") {
                        src.push("alpha = alpha * (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).b);");
                    } else if (layer.blendMode == "add") {
                        src.push("alpha = ((1.0 - SCENEJS_uLayer" + i + "BlendFactor) * alpha) + (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).b);");
                    }
                }

                /* Texture output
                 */
                if (layer.applyTo == "baseColor") {
                    if (layer.blendMode == "multiply") {
                        src.push("color = color * (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).rgb);");
                    } else {
                        src.push("color = ((1.0 - SCENEJS_uLayer" + i + "BlendFactor) * color) + (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).rgb);");
                    }
                }

                if (layer.applyTo == "emit") {
                    if (layer.blendMode == "multiply") {
                        src.push("emit  = emit * (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).r);");
                    } else {
                        src.push("emit = ((1.0 - SCENEJS_uLayer" + i + "BlendFactor) * emit) + (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).r);");
                    }
                }

                if (layer.applyTo == "specular" && normals) {
                    if (layer.blendMode == "multiply") {
                        src.push("specular  = specular * (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).r);");
                    } else {
                        src.push("specular = ((1.0 - SCENEJS_uLayer" + i + "BlendFactor) * specular) + (SCENEJS_uLayer" + i + "BlendFactor * texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, 1.0 - textureCoord.y)).r);");
                    }
                }

                if (layer.applyTo == "normals" && normals) {
                    src.push("vec3 bump = normalize(texture2D(SCENEJS_uSampler" + i + ", vec2(textureCoord.x, -textureCoord.y)).xyz * 2.0 - 1.0);");
                    src.push("viewNormalVec *= -bump;");
                }
            }
            if (normals) {
                src.push("}");
            }
        }

        src.push("  vec4    fragColor;");

        if (normals) {

            src.push("if (SCENEJS_uBackfaceLighting || dot(SCENEJS_vWorldNormal, SCENEJS_vWorldEyeVec) > 0.0) {");

            src.push("  vec3    lightValue      = vec3(0.0, 0.0, 0.0);");
            src.push("  vec3    specularValue   = vec3(0.0, 0.0, 0.0);");
            src.push("  vec3    viewLightVec;");
            src.push("  float   dotN;");
            src.push("  float   lightDist;");

            var light;

            for (var i = 0, len = states.lights.lights.length; i < len; i++) {
                light = states.lights.lights[i];

                if (light.mode == "ambient") {
                    continue;
                }

                src.push("viewLightVec = SCENEJS_vViewLightVecAndDist" + i + ".xyz;");

                if (light.mode == "point") {

                    src.push("dotN = max(dot(viewNormalVec, viewLightVec), 0.0);");

                    //src.push("if (dotN > 0.0) {");

                    src.push("lightDist = SCENEJS_vViewLightVecAndDist" + i + ".w;");

                    src.push("attenuation = 1.0 - (" +
                        "  SCENEJS_uLightAttenuation" + i + "[0] + " +
                        "  SCENEJS_uLightAttenuation" + i + "[1] * lightDist + " +
                        "  SCENEJS_uLightAttenuation" + i + "[2] * lightDist * lightDist);");

                    if (light.diffuse) {
                        src.push("if (SCENEJS_uDiffuse) {");
                        src.push("      lightValue += dotN * SCENEJS_uLightColor" + i + " * attenuation;");
                        src.push("}");
                    }

                    if (light.specular) {
                        src.push("if (SCENEJS_uSpecularLighting) {");
                        src.push("    specularValue += specularColor * SCENEJS_uLightColor" + i +
                            " * specular * pow(max(dot(reflect(-viewLightVec, -viewNormalVec), vec3(0.0,0.0,1.0)), 0.0), shine) * attenuation;");
                        src.push("}");
                    }
                    //src.push("}");
                }

                if (light.mode == "dir") {

                    src.push("dotN = max(dot(viewNormalVec, viewLightVec), 0.0);");

                    //src.push("if (dotN > 0.0) {");
                    if (light.diffuse) {
                        src.push("if (SCENEJS_uDiffuse) {");
                        src.push("      lightValue += dotN * SCENEJS_uLightColor" + i + ";");
                        src.push("}");
                    }

                    if (light.specular) {
                        src.push("if (SCENEJS_uSpecularLighting) {");
                        src.push("    specularValue += specularColor * SCENEJS_uLightColor" + i +
                            " * specular * pow(max(dot(reflect(-viewLightVec, -viewNormalVec), vec3(0.0,0.0,1.0)), 0.0), shine);");
                        src.push("}");
                    }
                    // src.push("}");
                }
            }

            src.push("      fragColor = vec4((specularValue.rgb + color.rgb * (lightValue.rgb + ambient.rgb)) + (emit * color.rgb), alpha);");
            src.push("   } else {");
            src.push("      fragColor = vec4((color.rgb + (emit * color.rgb)) *  (vec3(1.0, 1.0, 1.0) + ambient.rgb), alpha);");
            src.push("   }");

        } else { // No normals
            src.push("fragColor = vec4((color.rgb + (emit * color.rgb)) *  (vec3(1.0, 1.0, 1.0) + ambient.rgb), alpha);");
        }

        if (fragmentHooks.pixelColor) {
            src.push("fragColor=" + fragmentHooks.pixelColor + "(fragColor);");
        }

        if (false && debugCfg.whitewash === true) {
            src.push("    gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);");
        } else {
            src.push("    gl_FragColor = fragColor;");
        }
        src.push("}");

        return src;
    };

})();/**
 * @class Source code for pick and draw shader programs, to be compiled into one or more {@link SceneJS_Program}s
 * @private
 * 
 * @param {String} hash Hash code identifying the rendering capabilities of the programs
 * @param {String} pickVertexSrc Source code of the pick vertex shader
 * @param {String} pickFragmentSrc Source code of the pick fragment shader
 * @param {String} drawVertexSrc Source code of the draw vertex shader
 * @param {String} drawFragmentSrc Source code of the draw fragment shader
 */
var SceneJS_ProgramSource = function(hash, pickVertexSrc, pickFragmentSrc, drawVertexSrc, drawFragmentSrc) {

    /**
     * Hash code identifying the capabilities of the {@link SceneJS_Program} that is compiled from this source
     * @type String
     */
    this.hash = hash;

    /**
     * Source code for pick vertex shader
     * @type String
     */
    this.pickVertexSrc = pickVertexSrc;

    /**
     * Source code for pick fragment shader
     * @type String
     */
    this.pickFragmentSrc = pickFragmentSrc;

    /**
     * Source code for draw vertex shader
     * @type String
     */
    this.drawVertexSrc = drawVertexSrc;

    /**
     * Source code for draw fragment shader
     * @type String
     */
    this.drawFragmentSrc = drawFragmentSrc;

    /**
     * Count of {@link SceneJS_Program}s compiled from this program source code
     * @type Number
     */
    this.useCount = 0;
};

/**  
 * @class Manages creation, sharing and recycle of {@link SceneJS_Program} instances
 * @private
 */
var SceneJS_ProgramFactory = function(cfg) {

    this._canvas = cfg.canvas;

    this._programs = {};

    this._nextProgramId = 0;
};

/**
 * Gets a program to render the given states
 */
SceneJS_ProgramFactory.prototype.getProgram = function(hash, states) {

    var program = this._programs[hash];

    if (!program) {

        var source = SceneJS_ProgramSourceFactory.getSource(hash, states);

        program = new SceneJS_Program(this._nextProgramId++, hash, source, this._canvas.gl);

        this._programs[hash] = program;
    }

    program.useCount++;

    return program;
};

/**
 * Releases a program back to the shader factory
 */
SceneJS_ProgramFactory.prototype.putProgram = function(program) {

    if (--program.useCount <= 0) {

        program.draw.destroy();
        program.pick.destroy();

        SceneJS_ProgramSourceFactory.putSource(program.hash);

        this._programs[program.hash] = null;
    }
};

/**
 * Notifies this shader factory that the WebGL context has been restored after previously being lost
 */
SceneJS_ProgramFactory.prototype.webglRestored = function() {

    var gl = this._canvas.gl;

    for (var id in this._programs) {
        if (this._programs.hasOwnProperty(id)) {
            this._programs[id].build(gl);
        }
    }
};

/**
 * Destroys this shader factory
 */
SceneJS_ProgramFactory.prototype.destroy = function() {
};
/**
 * @class Vertex and fragment shaders for pick and draw
 * @private
 *
 * @param {Number} id ID unique among all programs in the owner {@link SceneJS_ProgramFactory}
 * @param {String} hash Hash code which uniquely identifies the capabilities of the program, computed from hashes on the {@link Scene_Core}s that the {@link SceneJS_ProgramSource} composed to render
 * @param {SceneJS_ProgramSource} source Sourcecode from which the the program is compiled in {@link #build}
 * @param {WebGLRenderingContext} gl WebGL context 
 */
var SceneJS_Program = function(id, hash, source, gl) {

    /**
     * ID for this program, unique among all programs in the display
     * @type Number
     */
    this.id = id;

    /**
     * Hash code for this program's capabilities, same as the hash on {@link #source}
     * @type String
     */
    this.hash = source.hash;

    /**
     * Source code for this program's shaders
     * @type SceneJS_ProgramSource
     */
    this.source = source;

    /**
     * WebGL context on which this program's shaders are allocated
     * @type WebGLRenderingContext
     */
    this.gl = gl;

    /**
     * The drawing program
     * @type SceneJS_webgl_Program
     */
    this.draw = null;

    /**
     * The picking program
     * @type SceneJS_webgl_Program
     */
    this.pick = null;

    /**
     * The count of display objects using this program
     * @type Number
     */
    this.useCount = 0;

    this.build(gl);
};

/**
 *  Creates the render and pick programs.
 * This is also re-called to re-create them after WebGL context loss.
 */
SceneJS_Program.prototype.build = function(gl) {
    this.gl = gl;
    this.draw = new SceneJS_webgl_Program(gl, [this.source.drawVertexSrc.join("\n")], [this.source.drawFragmentSrc.join("\n")]);
    this.pick = new SceneJS_webgl_Program(gl, [this.source.pickVertexSrc.join("\n")], [this.source.pickFragmentSrc.join("\n")]);
};/**
 * @class Manages creation and recycle of {@link SceneJS_Object} instances
 * @private
 */
var SceneJS_ObjectFactory = function() {

};

/**
 * @property {[SceneJS_Object]} _freeObjects Pool of free display objects, shared by all object factories
 */
SceneJS_ObjectFactory.prototype._freeObjects = [];

/**
 * @property {Number} _numFreeObjects Number of free objects
 */
SceneJS_ObjectFactory.prototype._numFreeObjects = 0;

/**
 * Gets a display object from this factory
 *
 * @param {String} id ID to assign to the object
 * @returns {SceneJS_Object} The object
 */
SceneJS_ObjectFactory.prototype.getObject = function(id) {

    var object;

    if (this._numFreeObjects > 0) {

        object = this._freeObjects[--this._numFreeObjects];
        object.id = id;

        return object;
    }

    return new SceneJS_Object(id);
};

/**
 * Releases a display object back to this factory
 * @param {SceneJS_Object} object Object to release
 */
SceneJS_ObjectFactory.prototype.putObject = function (object) {

    this._freeObjects[this._numFreeObjects++] = object;
};/**
 * @class An object within a {@link SceneJS_Display}
 * @private
 */
var SceneJS_Object = function(id) {

    /**
     * ID for this objects, unique among all objects in the display
     * @type Number
     */
    this.id = id;

    /**
     * Hash code for this object, unique among all objects in the display
     * @type String
     */
    this.hash = null;

    /**
     * State sort key, computed from {@link #layer}, {@link #program} and {@link #texture}
     * @type Number
     */
    this.sortKey = null;

    /**
     * Sequence of state chunks applied to render this object
     * @type {[SceneJS_Chunk]} chunks
     */
    this.chunks = [];

    /**
     * Number of state chunks applied to render this object
     * @type Number
     */
    this.chunksLen = 0;

    /**
     * Shader programs that render this object, also used for (re)computing {@link #sortKey}
     * @type SceneJS_Program
     */
    this.program = null;

    /**
     * State core for the {@link SceneJS.Layer} that this object was compiled from, used for (re)computing {@link #sortKey} and visibility cull
     */
    this.layer = null;

     /**
     * State core for the {@link SceneJS.Texture} that this object was compiled from, used for (re)computing {@link #sortKey}
     */
    this.texture = null;

    /**
     * State core for the {@link SceneJS.Flags} that this object was compiled from, used for visibility cull
     */
    this.flags = null;

    /**
     * State core for the {@link SceneJS.Tag} that this object was compiled from, used for visibility cull
     */
    this.tag = null;
};/**
 * @class A facade which exposes internal scene rendering state to "rendered" event listeners bound to scene graph nodes with {@link SceneJS.Node#bind}.
 *
 * <p>The listener is fired for each {@link SceneJS.Geometry} that is rendered within the subgraph of the bound node.
 * An instance of this facade is passed into the listener's handler, enabling the listener to obtain the various transform
 * matrices that are active at that {@link SceneJS.Geometry}.</p>
 *
 * <p>The facade instance is only valid within the callback's execution; internally, SceneJS reuses the same instance of the
 * facade with each scene.</p>
 */
SceneJS.RenderContext = function(frameCtx) {
    this._frameCtx = frameCtx;
};

/**
 * Get the projection matrix, as defined by the active {@link SceneJS.Camera} node.
 */
SceneJS.RenderContext.prototype.getCameraMatrix = function() {
    return this._frameCtx.cameraMat;
};

/**
 * Get the view matrix, as defined by the active {@link SceneJS.LookAt} node.
 */
SceneJS.RenderContext.prototype.getViewMatrix = function() {
    return this._frameCtx.viewMat;
};

/**
 * Get the model matrix, as defined by the active {@link SceneJS.XForm} node.
 */
SceneJS.RenderContext.prototype.getModelMatrix = function() {
    return this._frameCtx.modelMat;
};

/**
 * Transforms the given world coordinate by the model, view and projection matrices defined by the active {@link SceneJS.XForm}, {@link SceneJS.LookAt} and {@link SceneJS.Camera} nodes.
 * @returns [Number] The 2D Canvas-space coordinate
 */
SceneJS.RenderContext.prototype.getCanvasPos = function(offset) {

    this.getProjPos(offset);

    var canvas = this._frameCtx.canvas.canvas;
    var canvasWidth = canvas.width;
    var canvasHeight = canvas.height;

    /* Projection division and map to canvas
     */
    var pc = this._pc;

    var x = (pc[0] / pc[3]) * canvasWidth * 0.5;
    var y = (pc[1] / pc[3]) * canvasHeight * 0.5;

    return {
        x: x + (canvasWidth * 0.5),
        y: canvasHeight - y - (canvasHeight * 0.5)
    };
};

/**
 * Transforms the given world coordinate by the model and view matrices defined by the active {@link SceneJS.XForm} and {@link SceneJS.LookAt} nodes.
 * @returns [Number] The 3D Projection-space coordinate
 */
SceneJS.RenderContext.prototype.getCameraPos = function(offset) {
    this.getProjPos(offset);
    this._camPos = SceneJS_math_normalizeVec3(this._pc, [0,0,0]);
    return { x: this._camPos[0], y: this._camPos[1], z: this._camPos[2] }; // TODO: return _camPos and lose the temp object
};


SceneJS.RenderContext.prototype.getProjPos = function(offset) {
    this.getViewPos(offset);
    this._pc = SceneJS_math_transformPoint3(this._frameCtx.cameraMat, this._vc);
    return { x: this._pc[0], y: this._pc[1], z: this._pc[2],  w: this._pc[3] };
};

SceneJS.RenderContext.prototype.getViewPos = function(offset) {
    this.getWorldPos(offset);
    this._vc = SceneJS_math_transformPoint3(this._frameCtx.viewMat, this._wc);
    return { x: this._vc[0], y: this._vc[1], z: this._vc[2],  w: this._vc[3] };
};

SceneJS.RenderContext.prototype.getWorldPos = function(offset) {
    this._wc = SceneJS_math_transformPoint3(this._frameCtx.modelMat, offset || [0,0,0]);
    return { x: this._wc[0], y: this._wc[1], z: this._wc[2],  w: this._wc[3] };
};
/**
 * @class A chunk of WebGL state changes to render a {@link SceneJS_Core} for drawing and picking (if applicable to the core type).
 *
 * <p>Instances of this class are created and recycled by a {@link SceneJS_ChunkFactory}.</p>
 *
 * <p>Each {@link SceneJS_Object} has a list of chunks to render it's {@link SceneJS_Core}s</p>
 *
 * @private
 */
var SceneJS_Chunk = function(id, type, program, core) {

    /**
     * The type of the corresponding {@link SceneJS_Core}
     * @type String
     * @see {SceneJS_Core#type}
     */
    this.type = type;

    /**
     * The chunk ID
     * @type Number
     */
    this.id = id;

    /**
     * The program this chunk will render with
     * @type {SceneJS_Program}
     */
    this.program = program;

    /**
     * The state core rendered by this chunk
     * @type {SceneJS_Core}
     */
    this.core = core;

    /**
     * Count of {@link SceneJS_Object} instances using this chunk
     * @type Number
     */
    this.useCount = 0;

    if (this.build) {
        this.build();
    }
};

/**
 * Initialises the chunk. This is called within the constructor, and also to by the owner {@link SceneJS_ChunkFactory}
 * when recycling a chunk from its free chunk pool. This method sets the given properties on the chunk, then calls the
 * chunk instance's <b>build</b> method if the chunk has been augmented with one.
 *
 * @param {Number} id Chunk ID
 * @param {SceneJS_Program} program Program to render the chunk
 * @param {SceneJS_Core} core The state core rendered by this chunk
 */
SceneJS_Chunk.prototype.init = function(id, program, core) {

    this.id = id;
    this.program = program;
    this.core = core;

    if (this.build) {
        this.build();
    }
};
/**
 * @class Manages creation, reuse and destruction of {@link SceneJS_Chunk}s for the nodes within a single {@link SceneJS_Display}.
 * @private
 */
var SceneJS_ChunkFactory = function() {

    this._chunks = {};
    this.chunkTypes = SceneJS_ChunkFactory.chunkTypes;
};

/**
 * Sub-classes of {@link SceneJS_Chunk} provided by this factory
 */
SceneJS_ChunkFactory.chunkTypes = {};    // Supported chunk classes, installed by #createChunkType

/**
 * Free pool of unused {@link SceneJS_Chunk} instances
 */
SceneJS_ChunkFactory._freeChunks = {};    // Free chunk pool for each type

/**
 * Creates a chunk class for instantiation by this factory
 *
 * @param params Members to augment the chunk class prototype with
 * @param params.type Type name for the new chunk class
 * @param params.draw Method to render the chunk in draw render
 * @param params.pick Method to render the chunk in pick render
 * @param params.drawAndPick Method to render the chunk in both draw and pick renders
 */
SceneJS_ChunkFactory.createChunkType = function(params) {

    if (!params.type) {
        throw "'type' expected in params";
    }

    var supa = SceneJS_Chunk;

    var chunkClass = function() { // Create the class
        supa.apply(this, arguments);
        this.type = params.type;
    };

    chunkClass.prototype = new supa();              // Inherit from base class
    chunkClass.prototype.constructor = chunkClass;

    if (params.drawAndPick) {                       // Common method for draw and pick render
        params.draw = params.pick = params.drawAndPick;
    }

    SceneJS_ChunkFactory.chunkTypes[params.type] = chunkClass;

    SceneJS._apply(params, chunkClass.prototype);   // Augment subclass

    SceneJS_ChunkFactory._freeChunks[params.type] = { // Set up free chunk pool for this type
        chunks: [],
        chunksLen: 0
    };

    return chunkClass;
};

/**
 *
 */
SceneJS_ChunkFactory.prototype.getChunk = function(chunkId, type, program, core) {

    var chunkClass = SceneJS_ChunkFactory.chunkTypes[type]; // Check type supported

    if (!chunkClass) {
        throw "chunk type not supported: '" + type + "'";
    }

    var chunk = this._chunks[chunkId];  // Try to reference an existing chunk

    if (chunk) {
        chunk.useCount++;
        return chunk;
    }

    var freeChunks = SceneJS_ChunkFactory._freeChunks[type]; // Try to recycle a free chunk

    if (freeChunks.chunksLen > 0) {
        chunk = freeChunks.chunks[--freeChunks.chunksLen];
    }

    if (chunk) {    // Reinitialise the recycled chunk

        chunk.init(chunkId, program, core);

    } else {        // Instantiate a fresh chunk

        chunk = new chunkClass(chunkId, type, program, core); // Create new chunk
    }

    chunk.useCount = 1;

    this._chunks[chunkId] = chunk;

    return chunk;
};

/**
 * Releases a display state chunk back to this factory, destroying it if the chunk's use count is then zero.
 *
 * @param {SceneJS_Chunk} chunk Chunk to release
 */
SceneJS_ChunkFactory.prototype.putChunk = function (chunk) {

    if (chunk.useCount == 0) {
        return; // In case of excess puts
    }

    if (--chunk.useCount <= 0) {    // Release shared core if use count now zero

        this._chunks[chunk.id] = null;

        var freeChunks = SceneJS_ChunkFactory._freeChunks[chunk.type];

        freeChunks.chunks[freeChunks.chunksLen++] = chunk;
    }
};

/**
 * Re-cache shader variable locations for each active chunk
 */
SceneJS_ChunkFactory.prototype.webglRestored = function () {

    var chunk;

    for (var chunkId in this._chunks) {

        if (this._chunks.hasOwnProperty(chunkId)) {

            chunk = this._chunks[chunkId]; // Re-cache chunk's shader variable locations

            if (chunk.build) {
                chunk.build();
            }
        }
    }
};
SceneJS_ChunkFactory.createChunkType({

    type: "camera",

    build : function() {

        this._uPMatrixDraw = this.program.draw.getUniformLocation("SCENEJS_uPMatrix");

        this._uPMatrixPick = this.program.pick.getUniformLocation("SCENEJS_uPMatrix");
        this._uZNearPick = this.program.pick.getUniformLocation("SCENEJS_uZNear");
        this._uZFarPick = this.program.pick.getUniformLocation("SCENEJS_uZFar");
    },

    draw : function(ctx) {

        if (this.core.dirty) {
            this.core.rebuild();
        }

        var gl = this.program.gl;

        if (this._uPMatrixDraw) {
            gl.uniformMatrix4fv(this._uPMatrixDraw, gl.FALSE, this.core.mat);
        }

        ctx.cameraMat = this.core.mat; // Query only in draw pass
    },


    pick : function(ctx) {

        var gl = this.program.gl;

        if (this._uPMatrixPick) {
            gl.uniformMatrix4fv(this._uPMatrixPick, gl.FALSE, this.core.mat);
        }

        if (ctx.rayPick) { // Z-pick pass: feed near and far clip planes into shader

            if (this._uZNearPick) {
                gl.uniform1f(this._uZNearPick, this.core.optics.near);
            }

            if (this._uZFarPick) {
                gl.uniform1f(this._uZFarPick, this.core.optics.far);
            }
        }

        ctx.cameraMat = this.core.mat; // Query only in draw pass
    }
});/**
 * Create display state chunk type for draw and pick render of user clipping planes
 */
SceneJS_ChunkFactory.createChunkType({

    type: "clips",

    build : function() {

        this._draw = this._draw || [];

        var draw = this.program.draw;

        for (var i = 0, len = this.core.clips.length; i < len; i++) {
            this._draw[i] = {
                uClipMode :draw.getUniformLocation("SCENEJS_uClipMode" + i),
                uClipNormalAndDist: draw.getUniformLocation("SCENEJS_uClipNormalAndDist" + i)
            };
        }

        this._pick = this._pick || [];

        var pick = this.program.pick;

        for (var i = 0, len = this.core.clips.length; i < len; i++) {
            this._pick[i] = {
                uClipMode :pick.getUniformLocation("SCENEJS_uClipMode" + i),
                uClipNormalAndDist: pick.getUniformLocation("SCENEJS_uClipNormalAndDist" + i)
            };
        }
    },

    drawAndPick: function(ctx) {

        var vars = (ctx.pick) ? this._pick : this._draw;

        var mode;
        var normalAndDist;
        var clips = this.core.clips;
        var clip;
        var gl = this.program.gl;

        for (var i = 0, len = clips.length; i < len; i++) {

            if (ctx.pick) {
                mode = vars[i].uClipMode;
                normalAndDist = vars[i].uClipNormalAndDist;
            } else {
                mode = vars[i].uClipMode;
                normalAndDist = vars[i].uClipNormalAndDist;
            }

            if (mode && normalAndDist) {

                clip = clips[i];

                if (clip.mode == "inside") {

                    gl.uniform1f(mode, 2);
                    gl.uniform4fv(normalAndDist, clip.normalAndDist);

                } else if (clip.mode == "outside") {

                    gl.uniform1f(mode, 1);
                    gl.uniform4fv(normalAndDist, clip.normalAndDist);

                } else { // disabled
                    gl.uniform1f(mode, 0);
                }
            }
        }
    }
});/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type:"draw",

    /**
     * As we apply a list of state chunks in a {@link SceneJS_Display}, we track the ID of each chunk
     * in order to avoid redundantly re-applying the same chunk.
     *
     * We don't want that for draw chunks however, because they contain GL drawElements calls,
     * which we need to do for each object.
     */
    unique:true,

    build:function () {},

    drawAndPick:function (ctx) {

        var gl = this.program.gl;

        gl.drawElements(this.core.primitive, this.core.indexBuf.numItems, gl.UNSIGNED_SHORT, 0);
    }
});/**
 *  Create display state chunk type for draw and pick render of flags
 */
SceneJS_ChunkFactory.createChunkType({

    type:"flags",

    build:function () {

        var draw = this.program.draw;

        this._uBackfaceTexturingDraw = draw.getUniformLocation("SCENEJS_uBackfaceTexturing");
        this._uBackfaceLightingDraw = draw.getUniformLocation("SCENEJS_uBackfaceLighting");
        this._uSpecularLightingDraw = draw.getUniformLocation("SCENEJS_uSpecularLighting");
        this._uClippingDraw = draw.getUniformLocation("SCENEJS_uClipping");
        this._uAmbientDraw = draw.getUniformLocation("SCENEJS_uAmbient");
        this._uDiffuseDraw = draw.getUniformLocation("SCENEJS_uDiffuse");

        var pick = this.program.pick;

        this._uClippingPick = pick.getUniformLocation("SCENEJS_uClipping");
    },

    drawAndPick:function (ctx) {

        var gl = this.program.gl;

        var backfaces = this.core.backfaces;

        if (ctx.backfaces != backfaces) {
            if (backfaces) {
                gl.disable(gl.CULL_FACE);
            } else {
                gl.enable(gl.CULL_FACE);
            }
            ctx.backfaces = backfaces;
        }

        var frontface = this.core.frontface;

        if (ctx.frontface != frontface) {
            if (frontface == "ccw") {
                gl.frontFace(gl.CCW);
            } else {
                gl.frontFace(gl.CW);
            }
            ctx.frontface = frontface;
        }

        if (ctx.pick) {
            gl.uniform1i(this._uClippingPick, this.core.clipping);

        } else {
            gl.uniform1i(this._uBackfaceTexturingDraw, this.core.backfaceTexturing);
            gl.uniform1i(this._uBackfaceLightingDraw, this.core.backfaceLighting);
            gl.uniform1i(this._uSpecularLightingDraw, this.core.specular);
            gl.uniform1i(this._uClippingDraw, this.core.clipping);
            gl.uniform1i(this._uAmbientDraw, this.core.ambient);
            gl.uniform1i(this._uDiffuseDraw, this.core.diffuse);
        }
    }
});/**
 *   Create display state chunk type for draw and pick render of framebuf
 */
SceneJS_ChunkFactory.createChunkType({

    type: "framebuf",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    build: function() {
    },

    drawAndPick: function(ctx) {

        if (ctx.framebuf) {

            this.program.gl.finish(); // Force framebuf to complete

            ctx.framebuf.unbind();
        }

        var framebuf = this.core.framebuf;

        if (framebuf) {

            framebuf.bind();

            ctx.framebuf = framebuf;  // Must flush on cleanup
        }
    }
});/**
 *  Create display state chunk type for draw and pick render of geometry
 */
SceneJS_ChunkFactory.createChunkType({

    type:"geometry",

    /**
     * As we apply a list of state chunks in a {@link SceneJS_Display}, we track the ID of each chunk
     * in order to avoid redundantly re-applying the same chunk.
     *
     * We don't want that for draw chunks however, because they contain GL drawElements calls,
     * which we need to do for each object.
     */
    unique:true,

    build:function () {

        var draw = this.program.draw;

        this._aVertexDraw = draw.getAttribute("SCENEJS_aVertex");
        this._aNormalDraw = draw.getAttribute("SCENEJS_aNormal");
        this._aUVDraw = draw.getAttribute("SCENEJS_aUVCoord");
        this._aUV2Draw = draw.getAttribute("SCENEJS_aUVCoord2");
        this._aColorDraw = draw.getAttribute("SCENEJS_aVertexColor");

        var pick = this.program.pick;

        this._aVertexPick = pick.getAttribute("SCENEJS_aVertex");
        this._aNormalPick = pick.getAttribute("SCENEJS_aNormal");
        this._aUVPick = pick.getAttribute("SCENEJS_aUVCoord");
        this._aUV2Pick = pick.getAttribute("SCENEJS_aUVCoord2");
        this._aColorPick = pick.getAttribute("SCENEJS_aVertexColor");
    },

    draw:function (ctx) {

        var gl = this.program.gl;

        if (ctx.geoChunkId != this.id) { // HACK until we have distinct state chunks for VBOs and draw call

            if (this._aVertexDraw && !ctx.vertexBuf) {
                this._aVertexDraw.bindFloatArrayBuffer(this.core.vertexBuf);
            }

            if (this._aNormalDraw && !ctx.normalBuf) {
                this._aNormalDraw.bindFloatArrayBuffer(this.core.normalBuf);
            }

            if (this._aUVDraw && !ctx.uvBuf) {
                this._aUVDraw.bindFloatArrayBuffer(this.core.uvBuf);
            }

            if (this._aUV2Draw && !ctx.uvBuf2) {
                this._aUV2Draw.bindFloatArrayBuffer(this.core.uvBuf2);
            }

            if (this._aColorDraw && !ctx.colorBuf) {
                this._aColorDraw.bindFloatArrayBuffer(this.core.colorBuf);
            }

            this.core.indexBuf.bind();

            ctx.geoChunkId = this.id;
        }

        gl.drawElements(this.core.primitive, this.core.indexBuf.numItems, gl.UNSIGNED_SHORT, 0);
    },

    pick:function (ctx) {

        var gl = this.program.gl;

        if (ctx.geoChunkId != this.id) { // HACK until we have distinct state chunks for VBOs and draw call

            if (this._aVertexPick && !ctx.vertexBuf) {
                this._aVertexPick.bindFloatArrayBuffer(this.core.vertexBuf);
            }

            if (this._aNormalPick && !ctx.normalBuf) {
                this._aNormalPick.bindFloatArrayBuffer(this.core.normalBuf);
            }

            if (this._aUVPick && !ctx.uvBuf) {
                this._aUVPick.bindFloatArrayBuffer(this.core.uvBuf);
            }

            if (this._aUV2Pick && !ctx.uvBuf2) {
                this._aUV2Pick.bindFloatArrayBuffer(this.core.uvBuf2);
            }

            this.core.indexBuf.bind();

            ctx.geoChunkId = this.id;
        }

        gl.drawElements(this.core.primitive, this.core.indexBuf.numItems, gl.UNSIGNED_SHORT, 0);
    }
});/**
 *  Create display state chunk type for draw render of lights projection
 */
SceneJS_ChunkFactory.createChunkType({

    type:"lights",

    build:function () {

        this._uAmbientColor = this._uAmbientColor || [];
        this._uLightColor = this._uLightColor || [];
        this._uLightDir = this._uLightDir || [];
        this._uLightPos = this._uLightPos || [];
        this._uLightCutOff = this._uLightCutOff || [];
        this._uLightSpotExp = this._uLightSpotExp || [];
        this._uLightAttenuation = this._uLightAttenuation || [];

        var lights = this.core.lights;
        var program = this.program;

        for (var i = 0, len = lights.length; i < len; i++) {

            switch (lights[i].mode) {

                case "ambient":
                    this._uAmbientColor[i] = (program.draw.getUniformLocation("SCENEJS_uAmbientColor"));
                    break;

                case "dir":
                    this._uLightColor[i] = program.draw.getUniformLocation("SCENEJS_uLightColor" + i);
                    this._uLightPos[i] = null;
                    this._uLightDir[i] = program.draw.getUniformLocation("SCENEJS_uLightDir" + i);
                    break;

                case "point":
                    this._uLightColor[i] = program.draw.getUniformLocation("SCENEJS_uLightColor" + i);
                    this._uLightPos[i] = program.draw.getUniformLocation("SCENEJS_uLightPos" + i);
                    this._uLightDir[i] = null;
                    this._uLightAttenuation[i] = program.draw.getUniformLocation("SCENEJS_uLightAttenuation" + i);
                    break;
            }
        }
    },

    draw:function (ctx) {

        if (ctx.dirty) {
            this.build();
        }

        var lights = this.core.lights;
        var light;

        var gl = this.program.gl;

        for (var i = 0, len = lights.length; i < len; i++) {

            light = lights[i];

            if (this._uAmbientColor[i]) {
                gl.uniform3fv(this._uAmbientColor[i], light.color);

            } else {

                if (this._uLightColor[i]) {
                    gl.uniform3fv(this._uLightColor[i], light.color);
                }

                if (this._uLightPos[i]) {
                    gl.uniform3fv(this._uLightPos[i], light.pos);

                    if (this._uLightAttenuation[i]) {
                        gl.uniform3fv(this._uLightAttenuation[i], light.attenuation);
                    }
                }

                if (this._uLightDir[i]) {
                    gl.uniform3fv(this._uLightDir[i], light.dir);
                }
            }
        }
    }
});/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type: "listeners",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    build : function() {
    },

    draw : function(ctx) {

        var listeners = this.core.listeners;
        var renderListenerCtx = ctx.renderListenerCtx;

        for (var i = listeners.length - 1; i >= 0; i--) { // Child listeners first
            if (listeners[i](renderListenerCtx) === true) { // Call listener with query facade object as scope
                return true;
            }
        }
    }
});/**
 * Create display state chunk type for draw and pick render of lookAt transform
 */
SceneJS_ChunkFactory.createChunkType({

    type: "lookAt",

    build : function() {

        this._uvMatrixDraw = this.program.draw.getUniformLocation("SCENEJS_uVMatrix");
        this._uVNMatrixDraw = this.program.draw.getUniformLocation("SCENEJS_uVNMatrix");
        this._uWorldEyeDraw = this.program.draw.getUniformLocation("SCENEJS_uWorldEye");

        this._uvMatrixPick = this.program.pick.getUniformLocation("SCENEJS_uVMatrix");
    },

    draw : function(ctx) {

        if (this.core.dirty) {
            this.core.rebuild();
        }

        var gl = this.program.gl;

        if (this._uvMatrixDraw) {
            gl.uniformMatrix4fv(this._uvMatrixDraw, gl.FALSE, this.core.mat);
        }

        if (this._uVNMatrixDraw) {
            gl.uniformMatrix4fv(this._uVNMatrixDraw, gl.FALSE, this.core.normalMat);
        }

        if (this._uWorldEyeDraw) {
            gl.uniform3fv(this._uWorldEyeDraw, this.core.lookAt.eye);
        }

        ctx.viewMat = this.core.mat;
    },

    pick : function(ctx) {

        var gl = this.program.gl;

        if (this._uvMatrixPick) {
            gl.uniformMatrix4fv(this._uvMatrixPick, gl.FALSE, this.core.mat);
        }

        ctx.viewMat = this.core.mat;
    }
});/**
 * Create display state chunk type for draw render of material transform
 */
SceneJS_ChunkFactory.createChunkType({

    type: "material",

    build : function() {

        var draw = this.program.draw;

        this._uMaterialBaseColor = draw.getUniformLocation("SCENEJS_uMaterialBaseColor");
        this._uMaterialSpecularColor = draw.getUniformLocation("SCENEJS_uMaterialSpecularColor");
        this._uMaterialSpecular = draw.getUniformLocation("SCENEJS_uMaterialSpecular");
        this._uMaterialShine = draw.getUniformLocation("SCENEJS_uMaterialShine");
        this._uMaterialEmit = draw.getUniformLocation("SCENEJS_uMaterialEmit");
        this._uMaterialAlpha = draw.getUniformLocation("SCENEJS_uMaterialAlpha");
    },

    draw : function() {

        var gl = this.program.gl;

        if (this._uMaterialBaseColor) {
            gl.uniform3fv(this._uMaterialBaseColor, this.core.baseColor);
        }

        if (this._uMaterialSpecularColor) {
            gl.uniform3fv(this._uMaterialSpecularColor, this.core.specularColor);
        }

        if (this._uMaterialSpecular) {
            gl.uniform1f(this._uMaterialSpecular, this.core.specular);
        }

        if (this._uMaterialShine) {
            gl.uniform1f(this._uMaterialShine, this.core.shine);
        }

        if (this._uMaterialEmit) {
            gl.uniform1f(this._uMaterialEmit, this.core.emit);
        }

        if (this._uMaterialAlpha) {
            gl.uniform1f(this._uMaterialAlpha, this.core.alpha);
        }
    }
});/**
 * Create display state chunk type for draw render of material transform
 */
SceneJS_ChunkFactory.createChunkType({

    type:"morphGeometry",

    build:function () {

        var draw = this.program.draw;

        this._aVertexDraw = draw.getAttribute("SCENEJS_aVertex");
        this._aNormalDraw = draw.getAttribute("SCENEJS_aNormal");
        this._aUVDraw = draw.getAttribute("SCENEJS_aUVCoord");
        this._aUV2Draw = draw.getAttribute("SCENEJS_aUVCoord2");
        this._aColorDraw = draw.getAttribute("SCENEJS_aVertexColor");

        this._aMorphVertexDraw = draw.getAttribute("SCENEJS_aMorphVertex");
        this._aMorphNormalDraw = draw.getAttribute("SCENEJS_aMorphNormal");
        this._aMorphUVDraw = draw.getAttribute("SCENEJS_aMorphUVCoord");
        this._aMorphUV2Draw = draw.getAttribute("SCENEJS_aMorphUVCoord2");
        this._aMorphColorDraw = draw.getAttribute("SCENEJS_aMorphColor");
        this._uMorphFactorDraw = draw.getUniformLocation("SCENEJS_uMorphFactor");

        var pick = this.program.pick;

        this._aVertexPick = pick.getAttribute("SCENEJS_aVertex");
        this._aNormalPick = pick.getAttribute("SCENEJS_aNormal");
        this._aUVPick = pick.getAttribute("SCENEJS_aUVCoord");
        this._aUV2Pick = pick.getAttribute("SCENEJS_aUVCoord2");
        this._aColorPick = pick.getAttribute("SCENEJS_aVertexColor");

        this._aMorphVertexPick = pick.getAttribute("SCENEJS_aMorphVertex");
        this._aMorphNormalPick = pick.getAttribute("SCENEJS_aMorphNormal");
        this._aMorphUVPick = pick.getAttribute("SCENEJS_aMorphUVCoord");
        this._aMorphUV2Pick = pick.getAttribute("SCENEJS_aMorphUVCoord2");
        this._aMorphColorPick = pick.getAttribute("SCENEJS_aMorphColor");
        this._uMorphFactorPick = pick.getUniformLocation("SCENEJS_uMorphFactor");
    },

    draw:function (ctx) {

        var targets = this.core.targets;

        if (!targets || targets.length == 0) {
            ctx.vertexBuf = false;
            ctx.normalBuf = false;
            ctx.uvBuf = false;
            ctx.uvBuf2 = false;
            ctx.colorBuf = false;
            return;
        }

        var gl = this.program.gl;

        var target1 = this.core.targets[this.core.key1]; // Keys will update
        var target2 = this.core.targets[this.core.key2];

        if (this._aMorphVertexDraw) {
            this._aVertexDraw.bindFloatArrayBuffer(target1.vertexBuf);
            this._aMorphVertexDraw.bindFloatArrayBuffer(target2.vertexBuf);
            ctx.vertexBuf = true;
        } else {
            ctx.vertexBuf = false;
        }

        if (this._aMorphNormalDraw) {
            this._aNormalDraw.bindFloatArrayBuffer(target1.normalBuf);
            this._aMorphNormalDraw.bindFloatArrayBuffer(target2.normalBuf);
            ctx.normalBuf = true;
        } else {
            ctx.normalBuf = false;
        }

        if (this._aMorphUVDraw) {
            this._aUVDraw.bindFloatArrayBuffer(target1.uvBuf);
            this._aMorphUVDraw.bindFloatArrayBuffer(target2.uvBuf);
            ctx.uvBuf = true;
        } else {
            ctx.uvBuf = false;
        }

        if (this._aMorphUV2Draw) {
            this._aUV2Draw.bindFloatArrayBuffer(target1.uvBuf2);
            this._aMorphUV2Draw.bindFloatArrayBuffer(target2.uvBuf2);
            ctx.uvBuf2 = true;
        } else {
            ctx.uvBuf2 = false;
        }

        if (this._aMorphColorDraw) {
            this._aColorDraw.bindFloatArrayBuffer(target1.colorBuf);
            this._aMorphColorDraw.bindFloatArrayBuffer(target2.colorBuf);
            ctx.colorBuf = true;
        } else {
            ctx.colorBuf = false;
        }

        if (this._uMorphFactorDraw) {
            gl.uniform1f(this._uMorphFactorDraw, this.core.factor); // Bind LERP factor
        }
    },

    pick:function (ctx) {

        var targets = this.core.targets;

        if (!targets || targets.length == 0) {
            ctx.vertexBuf = false;
            ctx.normalBuf = false;
            ctx.uvBuf = false;
            ctx.uvBuf2 = false;
            ctx.colorBuf = false;
            return;
        }

        var gl = this.program.gl;

        var target1 = targets[this.core.key1]; // Keys will update
        var target2 = targets[this.core.key2];

        if (this._aMorphVertexPick) {
            this._aVertexPick.bindFloatArrayBuffer(target1.vertexBuf);
            this._aMorphVertexPick.bindFloatArrayBuffer(target2.vertexBuf);
            ctx.vertexBuf = true;
        } else {
            ctx.vertexBuf = false;
        }

        if (this._aMorphNormalPick) {
            this._aNormalPick.bindFloatArrayBuffer(target1.normalBuf);
            this._aMorphNormalPick.bindFloatArrayBuffer(target2.normalBuf);
            ctx.normalBuf = true;
        } else {
            ctx.normalBuf = false;
        }

        if (this._aMorphUVPick) {
            this._aUVPick.bindFloatArrayBuffer(target1.uvBuf);
            this._aMorphUVPick.bindFloatArrayBuffer(target2.uvBuf);
            ctx.uvBuf = true;
        } else {
            ctx.uvBuf = false;
        }

        if (this._aMorphUV2Pick) {
            this._aUV2Pick.bindFloatArrayBuffer(target1.uvBuf2);
            this._aMorphUV2Pick.bindFloatArrayBuffer(target2.uvBuf2);
            ctx.uvBuf2 = true;
        } else {
            ctx.uvBuf2 = false;
        }

        if (this._aMorphColorPick) {
            this._aColorPick.bindFloatArrayBuffer(target1.colorBuf);
            this._aMorphColorPick.bindFloatArrayBuffer(target2.colorBuf);
            ctx.colorBuf = true;
        } else {
            ctx.colorBuf = false;
        }

        if (this._uMorphFactorPick) {
            gl.uniform1f(this._uMorphFactorPick, this.core.factor); // Bind LERP factor
        }
    }
});
/**
 * Create display state chunk type for draw render of material transform
 */
SceneJS_ChunkFactory.createChunkType({

    type: "name",

    build : function() {
        this._uPickColor = this.program.pick.getUniformLocation("SCENEJS_uPickColor");
    },

    pick : function(ctx) {

        if (this._uPickColor && this.core.name) {

            ctx.pickNames[ctx.pickIndex++] = this.core;

            var b = ctx.pickIndex >> 16 & 0xFF;
            var g = ctx.pickIndex >> 8 & 0xFF;
            var r = ctx.pickIndex & 0xFF;

            this.program.gl.uniform3fv(this._uPickColor, [r / 255, g / 255, b / 255]);
        }
    }
});SceneJS_ChunkFactory.createChunkType({

    type: "program",

    build : function() {
        this._rayPickMode = this.program.pick.getUniformLocation("SCENEJS_uRayPickMode");
    },

    draw : function(frameCtx) {

        var drawProgram = this.program.draw;

        if (frameCtx.program) {
            frameCtx.program.unbind();
        }

        drawProgram.bind();

        frameCtx.program = drawProgram;

        /*
         * HACK until we have distinct chunk for each VBO (maybe)
         */
        frameCtx.vertexBuf = false;
        frameCtx.normalBuf = false;
        frameCtx.uvBuf = false;
        frameCtx.uvBuf2 = false;
        frameCtx.colorBuf = false;

        frameCtx.geoChunkId = null; // HACK until we have distinct state chunks for VBOs and draw call

        var gl = this.program.gl;

        for (var i = 0; i < 10; i++) {
            gl.disableVertexAttribArray(i);
        }
    },

    pick : function(frameCtx) {

        var pickProgram = this.program.pick;

        if (frameCtx.program) {
            frameCtx.program.unbind();
        }

        pickProgram.bind();

        var gl = this.program.gl;

        gl.uniform1i(this._rayPickMode, frameCtx.rayPick);

        frameCtx.program = pickProgram;

        /*
        * HACK until we have distinct chunk for each VBO (maybe)
         */
        frameCtx.vertexBuf = false;
        frameCtx.normalBuf = false;
        frameCtx.uvBuf = false;
        frameCtx.uvBuf2 = false;
        frameCtx.colorBuf = false;

        frameCtx.geoChunkId = null; // HACK until we have distinct state chunks for VBOs and draw call

        for (var i = 0; i < 10; i++) {
            gl.disableVertexAttribArray(i);
        }
    }
});



/**
 *
 */
SceneJS_ChunkFactory.createChunkType({
    
    type: "renderer",

    build : function() {
    },

    drawAndPick : function(ctx) {

        if (this.core.props) {

            var gl = this.program.gl;

            if (ctx.renderer) {
                ctx.renderer.props.restoreProps(gl);
                ctx.renderer = this.core;
            }

            this.core.props.setProps(gl);
        }
    }
});
/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type:"depthbuf",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    drawAndPick:function (ctx) {

        var enabled = this.core.enabled;

        if (ctx.depthbufEnabled != enabled) {
            var gl = this.program.gl;
            if (enabled) {
                gl.enable(gl.DEPTH_TEST);
            } else {
                gl.disable(gl.DEPTH_TEST);
            }
            ctx.depthbufEnabled = enabled;
        }

        var clearDepth = this.core.clearDepth;

        if (ctx.clearDepth != clearDepth) {
            gl.clearDepth(clearDepth);
            ctx.clearDepth = clearDepth;
        }

        var depthFunc = this.core.depthFunc;

        if (ctx.depthFunc != depthFunc) {
            gl.depthFunc(depthFunc);
            ctx.depthFunc = depthFunc;
        }
    }
});
/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type:"colorbuf",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    build:function () {
    },

    drawAndPick:function (ctx) {

        if (!ctx.transparencyPass) { // Blending forced when rendering transparent bin

            var blendEnabled = this.core.blendEnabled;

            if (ctx.blendEnabled != blendEnabled) {
                var gl = this.program.gl;
                if (blendEnabled) {
                    gl.enable(gl.BLEND);
                } else {
                    gl.disable(gl.BLEND);
                }
                ctx.blendEnabled = blendEnabled;
            }
        }
    }
});
/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type:"view",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    build:function () {
    },

    drawAndPick:function (ctx) {

        var scissorTestEnabled = this.core.scissorTestEnabled;

        if (ctx.scissorTestEnabled != scissorTestEnabled) {
            var gl = this.program.gl;
            if (scissorTestEnabled) {
                gl.enable(gl.SCISSOR_TEST);
            } else {
                gl.disable(gl.SCISSOR_TEST);
            }
            ctx.scissorTestEnabled = scissorTestEnabled;
        }
    }
});
/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type: "shader",

    build : function() {
    },

    drawAndPick : function(ctx) {

        var paramsStack = this.core.paramsStack;

        if (paramsStack) {

            var program = ctx.pick ? this.program.pick : this.program.draw;
            var params;
            var name;

            for (var i = 0, len = paramsStack.length; i < len; i++) {
                params = paramsStack[i];
                for (name in params) {
                    if (params.hasOwnProperty(name)) {
                        program.setUniform(name, params[name]);  // TODO: cache locations
                    }
                }
            }
        }
    }
});/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type: "shaderParams",

    build : function() {
    },

    drawAndPick: function(ctx) {

        var paramsStack = this.core.paramsStack;

        if (paramsStack) {

            var program = ctx.pick ? this.program.pick : this.program.draw;
            var params;
            var name;

            for (var i = 0, len = paramsStack.length; i < len; i++) {
                params = paramsStack[i];
                for (name in params) {
                    if (params.hasOwnProperty(name)) {
                        program.setUniform(name, params[name]);  // TODO: cache locations
                    }
                }
            }
        }
    }
});/**
 *
 */
SceneJS_ChunkFactory.createChunkType({

    type:"style",

    // Avoid reapplication of a chunk after a program switch.
    programGlobal:true,

    drawAndPick:function (ctx) {

        var lineWidth = this.core.lineWidth;

        if (ctx.lineWidth != lineWidth) {
            var gl = this.program.gl;
            gl.lineWidth(lineWidth);
            ctx.lineWidth = lineWidth;
        }
    }
});
SceneJS_ChunkFactory.createChunkType({

    type: "texture",

    build : function() {

        this._uTexSampler = this._uTexSampler || [];
        this._uTexMatrix = this._uTexMatrix || [];
        this._uTexBlendFactor = this._uTexBlendFactor || [];

        var layers = this.core.layers;

        if (layers) {

            var layer;
            var draw = this.program.draw;

            for (var i = 0, len = layers.length; i < len; i++) {

                layer = layers[i];

                this._uTexSampler[i] = "SCENEJS_uSampler" + i;

                this._uTexMatrix[i] = layer.matrixAsArray
                        ? draw.getUniform("SCENEJS_uLayer" + i + "Matrix")
                        : null;

                this._uTexBlendFactor[i] = draw.getUniform("SCENEJS_uLayer" + i + "BlendFactor");
            }
        }
    },

    draw : function() {

        var layers = this.core.layers;

        if (layers) {

            var draw = this.program.draw;
            var layer;

            for (var i = 0, len = layers.length; i < len; i++) {

                layer = layers[i];

                if (this._uTexSampler[i] && layer.texture) {    // Lazy-loads

                    draw.bindTexture(this._uTexSampler[i], layer.texture, i);

                    if (this._uTexMatrix[i]) {
                        this._uTexMatrix[i].setValue(layer.matrixAsArray);
                    }

                    if (this._uTexBlendFactor[i]) {
                        this._uTexBlendFactor[i].setValue(layer.blendFactor);
                    }

                } else {
                   //   draw.bindTexture(this._uTexSampler[i], null, i); // Unbind
                }
            }
        }
    }
});SceneJS_ChunkFactory.createChunkType({

    type: "xform",

    build : function() {

        var draw = this.program.draw;

        this._uMatLocationDraw = draw.getUniformLocation("SCENEJS_uMMatrix");
        this._uNormalMatLocationDraw = draw.getUniformLocation("SCENEJS_uMNMatrix");

        var pick = this.program.pick;

        this._uMatLocationPick = pick.getUniformLocation("SCENEJS_uMMatrix");
        this._uNormalMatLocationPick = pick.getUniformLocation("SCENEJS_uMNMatrix");
    },

    draw : function(ctx) {

        /* Rebuild core's matrix from matrices at cores on path up to root
         */
        if (SceneJS_configsModule.configs.forceXFormCoreRebuild === true || this.core.dirty && this.core.build) {
            this.core.build();
        }

        var gl = this.program.gl;

        if (this._uMatLocationDraw) {
            gl.uniformMatrix4fv(this._uMatLocationDraw, gl.FALSE, this.core.mat);
        }

        if (this._uNormalMatLocationDraw) {
            gl.uniformMatrix4fv(this._uNormalMatLocationDraw, gl.FALSE, this.core.normalMat);
        }

        ctx.modelMat = this.core.mat;
    },

    pick : function(ctx) {

        /* Rebuild core's matrix from matrices at cores on path up to root
         */
        if (this.core.dirty) {
            this.core.build();
        }

        var gl = this.program.gl;

        if (this._uMatLocationPick) {
            gl.uniformMatrix4fv(this._uMatLocationPick, gl.FALSE, this.core.mat);
        }

        if (this._uNormalMatLocationPick) {
            gl.uniformMatrix4fv(this._uNormalMatLocationPick, gl.FALSE, this.core.normalMat);
        }

        ctx.modelMat = this.core.mat;
    }
});
SceneJS.configure({ pluginPath: "http://xeolabs.github.com/scenejs/api/latest/plugins" });