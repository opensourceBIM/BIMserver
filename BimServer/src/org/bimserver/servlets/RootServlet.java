package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.plugins.web.WebModulePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RootServlet extends HttpServlet {

	private static final long serialVersionUID = -6631574771887074019L;

	private static final Logger LOGGER = LoggerFactory.getLogger(RootServlet.class);
	private WebServiceServlet11 soap11Servlet;
	private WebServiceServlet12 soap12Servlet;
	private SyndicationServlet syndicationServlet;
	private JsonApiServlet jsonApiServlet;
	private UploadServlet uploadServlet;
	private DownloadServlet downloadServlet;

	private BimServer bimServer;

	@Override
	public void init() throws ServletException {
		super.init();
		bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		jsonApiServlet = new JsonApiServlet(bimServer, getServletContext());
		syndicationServlet = new SyndicationServlet(bimServer, getServletContext());
		uploadServlet = new UploadServlet(bimServer, getServletContext());
		downloadServlet = new DownloadServlet(bimServer, getServletContext());
		soap11Servlet = new WebServiceServlet11(bimServer, getServletContext());
		soap11Servlet.init(getServletConfig());
		soap12Servlet = new WebServiceServlet12(bimServer, getServletContext());
		soap12Servlet.init(getServletConfig());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (request.getRequestURI().endsWith("getbimserveraddress")) {
				response.setContentType("application/json");
				String siteAddress = bimServer.getServerSettingsCache().getServerSettings().getSiteAddress();
				if (siteAddress == null || siteAddress.trim().isEmpty()) {
					// Only when in setup-mode
					siteAddress = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
				}
				response.getWriter().print("{\"address\":\"" + siteAddress + "\"}");
				return;
			} else if (request.getRequestURI().startsWith("/openid")) {
				bimServer.getOpenIdManager().verifyResponse(request, response);
			} else if (request.getRequestURI().endsWith(".js")) {
				response.setContentType("application/javascript");
			} else if (request.getRequestURI().endsWith(".css")) {
				response.setContentType("text/css");
			} else if (request.getRequestURI().endsWith(".png")) {
				response.setContentType("image/png");
			} else if (request.getRequestURI().endsWith(".gif")) {
				response.setContentType("image/gif");
			}
			String pathInfo = request.getPathInfo();
			if (pathInfo == null) {
				LOGGER.error("PathInfo of Request is null");
			} else if (pathInfo.startsWith("/soap11/") || pathInfo.equals("/soap11")) {
				soap11Servlet.service(request, response);
			} else if (pathInfo.startsWith("/soap12/") || pathInfo.equals("/soap12")) {
				soap12Servlet.service(request, response);
			} else if (pathInfo.startsWith("/syndication/") || pathInfo.equals("/syndication")) {
				syndicationServlet.service(request, response);
			} else if (pathInfo.startsWith("/json/") || pathInfo.equals("/json")) {
				jsonApiServlet.service(request, response);
			} else if (pathInfo.startsWith("/upload/") || pathInfo.equals("/upload")) {
				uploadServlet.service(request, response);
			} else if (pathInfo.startsWith("/download/") || pathInfo.equals("/download")) {
				downloadServlet.service(request, response);
			} else {
				if (pathInfo.equals("") || pathInfo.equals("/") || pathInfo == null) {
					pathInfo = "/index.html";
				}
				if (bimServer.getWebModules() != null) {
					for (Entry<String, WebModulePlugin> entry : bimServer.getWebModules().entrySet()) {
						if (pathInfo != null && entry.getValue() != null && pathInfo.startsWith(entry.getKey())) {
							if (entry.getValue().service(request, response)) {
								return;
							}
						}
					}
				}
				if (bimServer.getDefaultWebModule() != null) {
					if (bimServer.getDefaultWebModule().service(request, response)) {
						return;
					}
				}

				InputStream resourceAsStream = getServletContext().getResourceAsStream(pathInfo);
				if (resourceAsStream != null) {
					IOUtils.copy(resourceAsStream, response.getOutputStream());
				} else {
					response.setStatus(404);
					try {
						response.getWriter().println("404 - Not Found");
					} catch (IllegalStateException e) {
					}
				}
			}
		} catch (Throwable e) {
			if (e instanceof IOException) {
				// Ignore
			} else {
				LOGGER.error("", e);
			}
		}
	}
}