package org.bimserver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.JAXRSServiceFactoryBean;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.bimserver.shared.ServiceInterface;

public class RestServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 6288864278630843847L;

	@Override
	public void loadBus(ServletConfig servletConfig) throws ServletException {
		super.loadBus(servletConfig);
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		JAXRSServerFactoryBean serverFactoryBean = new JAXRSServerFactoryBean();
		serverFactoryBean.setServiceClass(ServiceInterface.class);
		serverFactoryBean.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
		serverFactoryBean.setResourceClasses(ServiceInterface.class);
		serverFactoryBean.setInvoker(new CustomInvoker(ServiceFactory.getINSTANCE()));
		serverFactoryBean.setServiceClass(ServiceInterface.class);
		JAXRSServiceFactoryBean serviceFactory = new JAXRSServiceFactoryBean();
		serviceFactory.setInvoker(new CustomInvoker(ServiceFactory.getINSTANCE()));
		serviceFactory.setResourceClass(ServiceInterface.class);
		serviceFactory.setDataBinding(new JAXBDataBinding());
		serverFactoryBean.setServiceFactory(serviceFactory);
		serverFactoryBean.setAddress("/");
		serverFactoryBean.create();
	}
}
