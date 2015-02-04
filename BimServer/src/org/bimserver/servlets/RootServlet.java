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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
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
			String requestUri = request.getRequestURI();
			String servletContextPath = getServletContext().getContextPath();
			if (requestUri.startsWith(servletContextPath)) {
				requestUri = requestUri.substring(servletContextPath.length());
			}
			if (requestUri == null) {
				LOGGER.error("RequestURI is null");
			} else {
				LOGGER.debug(requestUri);
//				LOGGER.info(requestUri);
			}
			setContentType(response, requestUri);
			if (request.getRequestURI().endsWith("getbimserveraddress")) {
				response.setContentType("application/json");
				String siteAddress = bimServer.getServerSettingsCache().getServerSettings().getSiteAddress();
				if (siteAddress == null || siteAddress.trim().isEmpty()) {
					// Only when in setup-mode
					siteAddress = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
				}
				if (siteAddress.contains("http://")) {
					siteAddress = siteAddress.replace("http://", request.getScheme() + "://");
				}
				response.getWriter().print("{\"address\":\"" + siteAddress + "\"}");
				return;
			} else if (requestUri.startsWith("/stream")) {
				LOGGER.warn("Stream request should not be going to this servlet!");
			} else if (requestUri.startsWith("/openid")) {
				bimServer.getOpenIdManager().verifyResponse(request, response);
			} else if (requestUri.startsWith("/soap11/") || requestUri.equals("/soap11")) {
				soap11Servlet.service(request, response);
			} else if (requestUri.startsWith("/soap12/") || requestUri.equals("/soap12")) {
				soap12Servlet.service(request, response);
			} else if (requestUri.startsWith("/syndication/") || requestUri.equals("/syndication")) {
				syndicationServlet.service(request, response);
			} else if (requestUri.startsWith("/json/") || requestUri.equals("/json")) {
				jsonApiServlet.service(request, response);
			} else if (requestUri.startsWith("/upload/") || requestUri.equals("/upload")) {
				uploadServlet.service(request, response);
			} else if (requestUri.startsWith("/download/") || requestUri.equals("/download")) {
				downloadServlet.service(request, response);
			} else {
				if (requestUri.equals("") || requestUri.equals("/") || requestUri == null) {
					requestUri = "/index.html";
				}
				if (bimServer.getDefaultWebModule() != null) {
					LOGGER.info("" + bimServer.getDefaultWebModule());
				} else {
					LOGGER.info("No default web module");
				}
				String modulePath = requestUri;
				if (modulePath.indexOf("/", 1) != -1) {
					modulePath = modulePath.substring(0, modulePath.indexOf("/", 1));
				}
				if (bimServer.getWebModules().containsKey(modulePath)) {
					LOGGER.info("Sub path: " + modulePath + " found");
					String substring = requestUri.substring(modulePath.length());
					LOGGER.info(substring);
					if (bimServer.getWebModules().get(modulePath).service(substring, response)) {
						return;
					}
				} else {
					LOGGER.info("Sub path: " + modulePath + " NOT found");
				}
				if (bimServer.getDefaultWebModule() != null) {
					if (bimServer.getDefaultWebModule().service(requestUri, response)) {
						return;
					}
				}
				
				LOGGER.info("Trying local resource: " + requestUri);
				InputStream resourceAsStream = getServletContext().getResourceAsStream(requestUri);
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

	private void setContentType(HttpServletResponse response, String requestUri) {
		if (requestUri.endsWith(".js")) {
			response.setContentType("application/javascript");
		} else if (requestUri.endsWith(".css")) {
			response.setContentType("text/css");
		} else if (requestUri.endsWith(".png")) {
			response.setContentType("image/png");
		} else if (requestUri.endsWith(".gif")) {
			response.setContentType("image/gif");
		}
	}
}