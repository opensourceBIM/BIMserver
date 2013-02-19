package org.bimserver.plugins.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.plugins.Plugin;

public interface WebModulePlugin extends Plugin {

	/**
	 * Handles the individual requests, just like a servlet
	 * 
	 * @param request The HTTP request
	 * @param response The HTTP response
	 */
	void service(HttpServletRequest request, HttpServletResponse response);

	/**
	 * @return The context path on which to serve this webmodule
	 */
	String getContextPath();
}