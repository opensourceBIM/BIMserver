package org.bimserver.plugins.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.plugins.Plugin;

public interface WebModulePlugin extends Plugin {

	void service(HttpServletRequest request, HttpServletResponse response);
}