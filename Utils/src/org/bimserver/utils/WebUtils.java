package org.bimserver.utils;

public class WebUtils {
	public static String getWebServer(String url) {
		if (url.startsWith("http://")) {
			url = url.substring(7);
		}
		url = url.substring(0, url.indexOf("/") + 1);
		return url;
	}
}
