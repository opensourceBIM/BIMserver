package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.plugins.web.WebModulePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebModuleServlet extends HttpServlet {
	private static final long serialVersionUID = -6171114430760535167L;
	private static final Logger LOGGER = LoggerFactory.getLogger(WebModuleServlet.class);
	private WebModulePlugin webModule;

	public WebModuleServlet(WebModulePlugin webModule) {
		this.webModule = webModule;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getRequestURI().endsWith(".css")) {
				response.setContentType("text/css");
			} else if (request.getRequestURI().endsWith(".js")) {
				response.setContentType("application/javascript");
			} else if (request.getRequestURI().endsWith(".png")) {
				response.setContentType("image/png");
			} else if (request.getRequestURI().endsWith(".gif")) {
				response.setContentType("image/gif");
			}
			webModule.service(request.getRequestURI(), request, response);
		} catch (Throwable e) {
			LOGGER.error("", e);
		}
	}
}