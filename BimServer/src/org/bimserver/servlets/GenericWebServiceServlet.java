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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.headers.HeaderProcessor;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.transport.DestinationFactory;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.transport.http.DestinationRegistry;
import org.apache.cxf.transport.http.HTTPTransportFactory;
import org.apache.cxf.transport.servlet.ServletContextResourceResolver;
import org.apache.cxf.transport.servlet.ServletController;
import org.apache.cxf.transport.servlet.servicelist.ServiceListGeneratorServlet;
import org.apache.cxf.wsdl.WSDLConstants;
import org.bimserver.BimServer;
import org.bimserver.Environment;
import org.bimserver.shared.Token;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.webservices.CustomInvoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericWebServiceServlet extends SubServlet {

	public GenericWebServiceServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(GenericWebServiceServlet.class);
	private String bindingId;

	public void setBindingId(String bindingId) {
		this.bindingId = bindingId;
	}

	private static final String REDIRECTS_PARAMETER = "redirects-list";
	private static final String REDIRECT_SERVLET_NAME_PARAMETER = "redirect-servlet-name";
	private static final String REDIRECT_SERVLET_PATH_PARAMETER = "redirect-servlet-path";
	private static final String REDIRECT_QUERY_CHECK_PARAMETER = "redirect-query-check";

	private static final Map<String, String> STATIC_CONTENT_TYPES;

	static {
		STATIC_CONTENT_TYPES = new HashMap<String, String>();
		STATIC_CONTENT_TYPES.put("html", "text/html");
		STATIC_CONTENT_TYPES.put("txt", "text/plain");
		STATIC_CONTENT_TYPES.put("css", "text/css");
		STATIC_CONTENT_TYPES.put("pdf", "application/pdf");
		// TODO : add more types if needed
	}

	private List<String> redirectList;
	private String dispatcherServletPath;
	private String dispatcherServletName;
	private boolean redirectQueryCheck;
	private DestinationRegistry destinationRegistry;
	private Bus bus;
	private ServletController controller;
	private ClassLoader loader;

	public void init(ServletConfig sc) throws ServletException {
		// Setting this property because otherwise a file named
		// "wsdl.properties" will be read from the JRE, which is not possible
		// due to restrictive permissions
		System.setProperty("javax.wsdl.factory.WSDLFactory", "com.ibm.wsdl.factory.WSDLFactoryImpl");

		if (this.bus == null) {
			loadBus(sc);
		}
		loader = bus.getExtension(ClassLoader.class);
		ResourceManager resourceManager = bus.getExtension(ResourceManager.class);
		resourceManager.addResourceResolver(new ServletContextResourceResolver(sc.getServletContext()));

		if (destinationRegistry == null) {
			this.destinationRegistry = getDestinationRegistryFromBus(this.bus);
		}
		this.controller = createServletController(sc);

		redirectList = parseListSequence(sc.getInitParameter(REDIRECTS_PARAMETER));
		redirectQueryCheck = Boolean.valueOf(sc.getInitParameter(REDIRECT_QUERY_CHECK_PARAMETER));
		dispatcherServletName = sc.getInitParameter(REDIRECT_SERVLET_NAME_PARAMETER);
		dispatcherServletPath = sc.getInitParameter(REDIRECT_SERVLET_PATH_PARAMETER);
	}

	private static DestinationRegistry getDestinationRegistryFromBus(Bus bus) {
		DestinationFactoryManager dfm = bus.getExtension(DestinationFactoryManager.class);
		try {
			DestinationFactory df = dfm.getDestinationFactory("http://cxf.apache.org/transports/http/configuration");
			if (df instanceof HTTPTransportFactory) {
				HTTPTransportFactory transportFactory = (HTTPTransportFactory) df;
				return transportFactory.getRegistry();
			}
		} catch (BusException e) {
			// why are we throwing a busexception if the DF isn't found?
		}
		return null;
	}

	private ServletController createServletController(ServletConfig servletConfig) {
		HttpServlet serviceListGeneratorServlet = new ServiceListGeneratorServlet(destinationRegistry, bus);
		ServletController newController = new ServletController(destinationRegistry, servletConfig, serviceListGeneratorServlet);
		return newController;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	protected void invoke(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
		try {
			if (loader != null) {
				Thread.currentThread().setContextClassLoader(loader);
			}
			BusFactory.setThreadDefaultBus(bus);
			// TODO this check is only here to avoid the very long list of npe's in the log file, most probably this is an indication that SOAP is not currently working
			if (controller != null) {
				controller.invoke(request, response);
			}
		} catch (ClassCastException e) {
			// Since updating to CXF 3.1.3 we are getting java.lang.ClassCastException: org.apache.cxf.message.MessageImpl cannot be cast to org.apache.cxf.binding.soap.SoapMessage
		} finally {
			BusFactory.setThreadDefaultBus(null);
			Thread.currentThread().setContextClassLoader(origLoader);
		}
	}

	public void destroy() {
		for (String path : destinationRegistry.getDestinationsPaths()) {
			// clean up the destination in case the destination itself can no
			// longer access the registry later
			AbstractHTTPDestination dest = destinationRegistry.getDestinationForPath(path);
			synchronized (dest) {
				destinationRegistry.removeDestination(path);
				dest.releaseRegistry();
			}
		}
		destinationRegistry = null;
		destroyBus();
	}

	public void destroyBus() {
		bus.shutdown(true);
	}

	private static List<String> parseListSequence(String values) {
		if (values != null) {
			List<String> list = new LinkedList<String>();
			String[] pathValues = values.split(" ");
			for (String value : pathValues) {
				String theValue = value.trim();
				if (theValue.length() > 0) {
					list.add(theValue);
				}
			}
			return list;
		} else {
			return null;
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		invoke(request, response);
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		if ((dispatcherServletPath != null || dispatcherServletName != null) && (redirectList != null && matchPath(redirectList, request) || redirectList == null)) {
			// if no redirectList is provided then this servlet is redirecting
			// only
			redirect(request, response, request.getPathInfo());
			return;
		}

		invoke(request, response);
	}

	private boolean matchPath(List<String> values, HttpServletRequest request) {
		String path = request.getPathInfo();
		if (redirectQueryCheck) {
			String queryString = request.getQueryString();
			if (queryString != null && queryString.length() > 0) {
				path += "?" + queryString;
			}
		}
		for (String value : values) {
			if (path.matches(value)) {
				return true;
			}
		}
		return false;
	}

	protected void serveStaticContent(HttpServletRequest request, HttpServletResponse response, String pathInfo) throws ServletException {
		InputStream is = super.getServletContext().getResourceAsStream(pathInfo);
		if (is == null) {
			throw new ServletException("Static resource " + pathInfo + " is not available");
		}
		try {
			int ind = pathInfo.lastIndexOf(".");
			if (ind != -1 && ind < pathInfo.length()) {
				String type = STATIC_CONTENT_TYPES.get(pathInfo.substring(ind + 1));
				if (type != null) {
					response.setContentType(type);
				}
			}

			ServletOutputStream os = response.getOutputStream();
			IOUtils.copy(is, os);
			os.flush();
		} catch (IOException ex) {
			throw new ServletException("Static resource " + pathInfo + " can not be written to the output stream");
		}
	}

	protected void redirect(HttpServletRequest request, HttpServletResponse response, String pathInfo) throws ServletException {

		String theServletPath = dispatcherServletPath == null ? "/" : dispatcherServletPath;

		ServletContext sc = super.getServletContext();
		RequestDispatcher rd = dispatcherServletName != null ? sc.getNamedDispatcher(dispatcherServletName) : sc.getRequestDispatcher(theServletPath + pathInfo);
		if (rd == null) {
			throw new ServletException("No RequestDispatcher can be created for path " + pathInfo);
		}
		try {
			HttpServletRequestFilter servletRequest = new HttpServletRequestFilter(request, pathInfo, theServletPath);
			rd.forward(servletRequest, response);
		} catch (Throwable ex) {
			throw new ServletException("RequestDispatcher for path " + pathInfo + " has failed");
		}
	}

	private static class HttpServletRequestFilter extends HttpServletRequestWrapper {

		private String pathInfo;
		private String servletPath;

		public HttpServletRequestFilter(HttpServletRequest request, String pathInfo, String servletPath) {
			super(request);
			this.pathInfo = pathInfo;
			this.servletPath = servletPath;
		}

		@Override
		public String getServletPath() {
			return servletPath;
		}

		@Override
		public String getPathInfo() {
			return pathInfo;
		}

		@Override
		public String getRequestURI() {
			String contextPath = getContextPath();
			if ("/".equals(contextPath)) {
				contextPath = "";
			}
			return contextPath + servletPath + pathInfo;
		}

		@Override
		public String getParameter(String name) {
			if (AbstractHTTPDestination.SERVICE_REDIRECTION.equals(name)) {
				return "true";
			}
			return super.getParameter(name);
		}
	}

	public void loadBus(ServletConfig servletConfig) {
		this.bus = BusFactory.newInstance().createBus();
		Bus bus = getBus();
		HeaderManager headerManager = bus.getExtension(HeaderManager.class);
		headerManager.registerHeaderProcessor(new HeaderProcessor() {
			@Override
			public String getNamespace() {
				return "uri:org.bimserver.shared";
			}

			@Override
			public DataBinding getDataBinding() {
				try {
					return new JAXBDataBinding(Token.class);
				} catch (JAXBException e) {
					LOGGER.error("", e);
				}
				return null;
			}
		});
		BusFactory.setDefaultBus(bus);
		
//		org.apache.cxf.javascript.JavascriptQueryHandlerRegistry
		
		for (Class<? extends PublicInterface> clazz : getBimServer().getServicesMap().getInterfaceClasses()) {
			JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("mtom-enabled", Boolean.TRUE);
			serverFactoryBean.setBindingId(bindingId);
			serverFactoryBean.setProperties(properties);
			serverFactoryBean.setServiceClass(clazz);
			serverFactoryBean.getOutFaultInterceptors().add(new StatusCodeModifyingFaultInterceptor());
			serverFactoryBean.setInvoker(new CustomInvoker(getBimServer().getServiceFactory(), clazz));
			if (getBimServer().getConfig().getEnvironment() != Environment.WAR) {
				serverFactoryBean.setAddress((bindingId == WSDLConstants.NS_SOAP11 ? "/soap11/" : "/soap12/") + clazz.getSimpleName()); // equals check allowed, just keep using the constant
			} else {
				serverFactoryBean.setAddress("/" + clazz.getSimpleName()); // equals check allowed, just keep using the constant
			}
			serverFactoryBean.setTransportId("http://schemas.xmlsoap.org/soap/http");
			serverFactoryBean.create();
		}
	}
}