package org.bimserver.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.xml.bind.JAXBException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.databinding.DataBinding;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.headers.HeaderProcessor;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.bimserver.BimServer;
import org.bimserver.shared.Token;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.webservices.CustomInvoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericWebServiceServlet extends CXFNonSpringServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceServlet11.class);
	private static final long serialVersionUID = 3633266184012679113L;
	private String bindingId;

	public void setBindingId(String bindingId) {
		this.bindingId = bindingId;
	}
	
	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		BimServer bimServer = (BimServer) servletConfig.getServletContext().getAttribute("bimserver");
		Bus bus = getBus();
		HeaderManager headerManager = bus.getExtension(HeaderManager.class);
		headerManager.registerHeaderProcessor(new HeaderProcessor() {
			@Override
			public String getNamespace() {
				return "uri:org.bimserver.shared";
			}
			
			@Override
			public InterceptorProvider getInterceptorProvider() {
				return null;
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
		
		for (Class<? extends PublicInterface> clazz : bimServer.getServicesMap().getInterfaceClasses()) {
			JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
			Map<String,Object> properties = new HashMap<String, Object>();
			properties.put("mtom-enabled", Boolean.TRUE);
			serverFactoryBean.setBindingId(bindingId);
			serverFactoryBean.setProperties(properties);
			serverFactoryBean.setServiceClass(clazz);
			serverFactoryBean.setInvoker(new CustomInvoker(bimServer.getServiceFactory(), clazz));
			serverFactoryBean.setAddress("/" + clazz.getSimpleName());
			serverFactoryBean.setTransportId("http://schemas.xmlsoap.org/soap/http");
			serverFactoryBean.create();
		}
	}
}