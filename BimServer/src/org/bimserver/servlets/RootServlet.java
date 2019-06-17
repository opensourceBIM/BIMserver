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
import java.io.InputStream;

import javax.servlet.ServletContext;
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
	private OAuthAuthorizationServlet oAuthAuthorizationServlet;
	private OAuthRegistrationServlet oAuthRegistrationServlet;
	private OAuthAccessTokenServlet oAuthAccesssTokenServlet;
	private ServiceRunnerServlet serviceRunner;
	private BulkUploadServlet bulkUploadServlet;

	private BimServer bimServer;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext servletContext = getServletContext();
		bimServer = (BimServer) servletContext.getAttribute("bimserver");
		if (bimServer == null) {
			throw new ServletException("No bimserver context attribute");
		}
		jsonApiServlet = new JsonApiServlet(bimServer, servletContext);
		syndicationServlet = new SyndicationServlet(bimServer, servletContext);
		uploadServlet = new UploadServlet(bimServer, servletContext);
		bulkUploadServlet = new BulkUploadServlet(bimServer, servletContext);
		downloadServlet = new DownloadServlet(bimServer, servletContext);
		soap11Servlet = new WebServiceServlet11(bimServer, servletContext);
//		soap11Servlet.init(getServletConfig());
		soap12Servlet = new WebServiceServlet12(bimServer, servletContext);
//		soap12Servlet.init(getServletConfig());
		oAuthAuthorizationServlet = new OAuthAuthorizationServlet(bimServer, servletContext);
		oAuthAccesssTokenServlet = new OAuthAccessTokenServlet(bimServer, servletContext);
		oAuthRegistrationServlet = new OAuthRegistrationServlet(bimServer, servletContext);
		serviceRunner = new ServiceRunnerServlet(bimServer, servletContext);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String requestOrigin = request.getHeader("Origin");
			if (requestOrigin != null && !bimServer.getServerSettingsCache().isHostAllowed(requestOrigin)) {
				response.setStatus(403);
				return;
			}
			if (requestOrigin != null) {
				response.setHeader("Access-Control-Allow-Origin", requestOrigin);
			} else {
				response.setHeader("Access-Control-Allow-Origin", "*");
			}
			response.setHeader("Access-Control-Allow-Headers", "Content-Type, Input-Type, Token");
			response.setHeader("Access-Control-Expose-Headers", "Content-Length, Data-Title, Output-Type");
			
			if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
				return;
			}

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
			if (request.getRequestURI().endsWith(".getbimserveraddress")) {
				response.setContentType("application/json; charset=utf-8");
				String siteAddress = bimServer.getServerSettingsCache().getServerSettings().getSiteAddress();
				if (siteAddress == null || siteAddress.trim().isEmpty()) {
					// Only when in setup-mode
					String forwardedProtocol = request.getHeader("X-Forwarded-Proto");
					if (forwardedProtocol != null) {
						LOGGER.info("X-Forwarded-Proto " + forwardedProtocol);
						String port = "" + request.getServerPort();
						if (request.getHeader("X-Forwarded-Port") != null) {
							port = request.getHeader("X-Forwarded-Port");
						}
						siteAddress = forwardedProtocol + "://" + request.getServerName() + ":" + port + request.getContextPath();
					} else {
						siteAddress = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
					}
				}
				response.getWriter().print("{\"address\":\"" + siteAddress + "\"}");
				return;
			} else if (requestUri.startsWith("/stream")) {
				LOGGER.warn("Stream request should not be going to this servlet!");
			} else if (requestUri.startsWith("/soap11/") || requestUri.equals("/soap11")) {
				soap11Servlet.service(request, response);
			} else if (requestUri.startsWith("/soap12/") || requestUri.equals("/soap12")) {
				try {
					soap12Servlet.service(request, response);
				} catch (ClassCastException e) {
					LOGGER.debug("", e);
				}
			} else if (requestUri.startsWith("/syndication/") || requestUri.equals("/syndication")) {
				syndicationServlet.service(request, response);
			} else if (requestUri.startsWith("/json/") || requestUri.equals("/json")) {
				jsonApiServlet.service(request, response);
			} else if (requestUri.startsWith("/oauth/register")) {
				oAuthRegistrationServlet.service(request, response);
			} else if (requestUri.startsWith("/oauth/authorize")) {
				oAuthAuthorizationServlet.service(request, response);
			} else if (requestUri.startsWith("/oauth/access")) {
				oAuthAccesssTokenServlet.service(request, response);
			} else if (requestUri.startsWith("/services") || requestUri.startsWith("/servicelist")) {
				serviceRunner.service(request, response);
			} else if (requestUri.startsWith("/upload/") || requestUri.equals("/upload")) {
				uploadServlet.service(request, response);
			} else if (requestUri.startsWith("/bulkupload/") || requestUri.equals("/bulkupload")) {
				bulkUploadServlet.service(request, response);
			} else if (requestUri.startsWith("/download/") || requestUri.equals("/download")) {
				downloadServlet.service(request, response);
			} else {
				if (requestUri == null || requestUri.equals("") || requestUri.equals("/")) {
					requestUri = "/index.html";
				}
				String modulePath = requestUri;
				if (modulePath.startsWith("/apps")) {
					if (modulePath.equals("/apps") || modulePath.equals("/apps/")) {
						response.setStatus(404);
						response.getWriter().println("Nothing here, go up one level to list all apps");
						return;
					}
					modulePath = modulePath.substring(6);
					if (modulePath.indexOf("/", 1) != -1) {
						modulePath = modulePath.substring(0, modulePath.indexOf("/", 1));
					}
					if (modulePath.startsWith("/")) {
						modulePath = modulePath.substring(1);
					}
					if (bimServer.getWebModules().containsKey(modulePath)) {
						String substring = requestUri.substring(6 + modulePath.length());
						WebModulePlugin webModulePlugin = bimServer.getWebModules().get(modulePath);
						if (webModulePlugin == null) {
							response.setStatus(404);
							response.getWriter().println("No webmodule " + modulePath + " found");
							return;
						} else {
							if (webModulePlugin.service(substring, request, response)) {
								return;
							}
						}
					}
				}

				if (bimServer.getDefaultWebModule() != null) {
					if (bimServer.getDefaultWebModule().service(requestUri, request, response)) {
						return;
					}
				}
				
				InputStream resourceAsStream = getServletContext().getResourceAsStream(requestUri);
				if (resourceAsStream != null) {
					try {
						IOUtils.copy(resourceAsStream, response.getOutputStream());
					} finally {
						resourceAsStream.close();
					}
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
			response.setContentType("application/javascript; charset=utf-8");
		} else if (requestUri.endsWith(".css")) {
			response.setContentType("text/css; charset=utf-8");
		} else if (requestUri.endsWith(".png")) {
			response.setContentType("image/png");
		} else if (requestUri.endsWith(".gif")) {
			response.setContentType("image/gif");
		} else {
			response.setContentType("text/html; charset=utf-8");
		}
	}
}