<%@ page contentType="application/xhtml+xml; charset=UTF-8" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>BIMserver.org | Open Source Building Information Model server</title>
<meta name="description" content="BIMserver is free and Open Source software for setting up a Building Information Model server based on IFC." />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="css/bim.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/tabber.css" type="text/css" media="all" />
<link rel="shortcut icon" type="image/ico" href="images/logo_small.png"/>
<%
	if (request.getRequestURI().endsWith("main.jsp")) {
%>
		<link rel="alternate" type="application/atom+xml" title="BIMserver.org projects feed" href="<%=request.getContextPath() %>/syndication/projects" />
<%	
	}
%>
<script src="js/main.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-1.8.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery-ui-1.8.23.custom.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.iframe.transport.js" type="text/javascript" charset="utf-8"></script>
<script src="js/String.js" type="text/javascript" charset="utf-8"></script>
<script src="js/base64.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bimserverapi.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.fileupload.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.ui.progressbar.js" type="text/javascript" charset="utf-8"></script>
<script src="js/thickbox-compressed.js" type="text/javascript" charset="utf-8"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />	
<link rel="stylesheet" href="css/lightwindow.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/thickbox.css" type="text/css" media="screen" />
<script type="text/javascript">
	/************************************************************
	 * (c) Copyright bimserver.org
	 * Licensed under GNU GPLv3
	 * http://www.gnu.org/licenses/gpl-3.0.txt
	 * For more information mail to license@bimserver.org
	 ***********************************************************/
	var bimServerApi = new BimServerApi("<%=getServletContext().getContextPath() %>", {
		error: function(message){
		},
		info: function(message) {
		},
		clear: function() {
		}
	});
	 
	$.ajaxSetup ({
	    // Disable caching of AJAX responses
	    cache: false
	});
	 
	var tabberOptions = {
		'cookie' :"tabber",
		'onLoad' : function(argsObj) {
			var t = argsObj.tabber;
			if (t.id) {
				t.cookie = t.id + t.cookie;
			}
			cookie = getCookie(t.cookie);
			for (i in t.tabs) {
				if (t.tabs[i] != null && t.tabs[i].div != null && t.tabs[i].div.id == cookie) {
					t.tabShow(i);
					break;
				}
			}
		},

		'onClick' : function(argsObj) {
			setCookie(argsObj.tabber.cookie, argsObj.tabber.tabs[argsObj.index].div.id);
		}
	};

	function setCookie(name, value, expires, path, domain, secure) {
		document.cookie = name + "=" + escape(value)
				+ ((expires) ? "; expires=" + expires.toGMTString() : "")
				+ ((path) ? "; path=" + path : "")
				+ ((domain) ? "; domain=" + domain : "")
				+ ((secure) ? "; secure" : "");
	}

	function getCookie(name) {
		var dc = document.cookie;
		var prefix = name + "=";
		var begin = dc.indexOf("; " + prefix);
		if (begin == -1) {
			begin = dc.indexOf(prefix);
			if (begin != 0)
				return null;
		} else {
			begin += 2;
		}
		var end = document.cookie.indexOf(";", begin);
		if (end == -1) {
			end = dc.length;
		}
		return unescape(dc.substring(begin + prefix.length, end));
	}
	
	function deleteCookie(name, path, domain) {
		if (getCookie(name)) {
			document.cookie = name + "=" + ((path) ? "; path=" + path : "")
					+ ((domain) ? "; domain=" + domain : "")
					+ "; expires=Thu, 01-Jan-70 00:00:01 GMT";
		}
	}
</script>
<script src="js/tabber-minimized.js" type="text/javascript" charset="utf-8"></script>
</head>