package org.bimserver.servlets;

import java.io.IOException;
import java.io.InputStream;

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
			if (request.getRequestURI().endsWith(".js")) {
				response.setContentType("application/javascript");
			} else if (request.getRequestURI().endsWith(".css")) {
				response.setContentType("text/css");
			} else if (request.getRequestURI().endsWith(".png")) {
				response.setContentType("image/png");
			} else if (request.getRequestURI().endsWith(".gif")) {
				response.setContentType("image/gif");
			}
			String pathInfo = request.getPathInfo();
			if (pathInfo.startsWith("/soap11/") || pathInfo.equals("/soap11")) {
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
					for (WebModulePlugin webModulePlugin : bimServer.getWebModules()) {
						if (pathInfo != null && webModulePlugin != null && pathInfo.startsWith(webModulePlugin.getContextPath())) {
							if (webModulePlugin.service(request, response)) {
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
				}
			}
		} catch (Throwable e) {
			LOGGER.error("", e);
		}
	}
}