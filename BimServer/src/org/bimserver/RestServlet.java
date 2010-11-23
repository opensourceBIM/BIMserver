package org.bimserver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.bimserver.shared.ServiceInterface;

public class RestServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 6288864278630843847L;

	@Override
	public void loadBus(ServletConfig servletConfig) throws ServletException {
//		super.loadBus(servletConfig);
//		Bus bus = getBus();
//		BusFactory.setDefaultBus(bus);
//		JAXRSServerFactoryBean serverFactoryBean = new JAXRSServerFactoryBean();
//		serverFactoryBean.setServiceClass(ServiceInterface.class);
//		serverFactoryBean.setBindingId(JAXRSBindingFactory.JAXRS_BINDING_ID);
//		serverFactoryBean.setResourceClasses(ServiceInterface.class);
//		serverFactoryBean.setInvoker(new CustomInvoker(ServiceFactory.getINSTANCE()));
//		JAXRSServiceFactoryBean serviceFactory = new JAXRSServiceFactoryBean();
//		serviceFactory.setInvoker(new CustomInvoker(ServiceFactory.getINSTANCE()));
//		serviceFactory.setDataBinding(new JAXBDataBinding());
//		serverFactoryBean.setServiceFactory(serviceFactory);
//		serverFactoryBean.setAddress("/");
//		serverFactoryBean.create();
		
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		sf.setResourceClasses(ServiceInterface.class);
		sf.setResourceProvider(ServiceInterface.class, new SingletonResourceProvider(new ResourceProvider() {
			@Override
			public void releaseInstance(Message m, Object o) {
			}
			
			@Override
			public boolean isSingleton() {
				return false;
			}
			
			@Override
			public Class<?> getResourceClass() {
				return null;
			}
			
			@Override
			public Object getInstance(Message m) {
				return null;
			}
		}));
		sf.setAddress("/");
		BindingFactoryManager manager = sf.getBus().getExtension(BindingFactoryManager.class);
		JAXRSBindingFactory factory = new JAXRSBindingFactory();
		factory.setBus(getBus());
		manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
		sf.create();
	}
}
