package org.bimserver.webservices;

import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.invoker.AbstractInvoker;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.shared.Token;
import org.bimserver.shared.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomInvoker extends AbstractInvoker {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomInvoker.class);
	private final ServiceFactory serviceFactory;

	public CustomInvoker(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@Override
	public Object getServiceObject(Exchange context) {
		if (context.getSession().get("token") != null) {
			try {
				return serviceFactory.getService((Token) context.getSession().get("token"));
			} catch (UserException e) {
				LOGGER.error("", e);
				return null;
			}
		} else {
			ServiceInterface newService = serviceFactory.newService(AccessMethod.WEB_INTERFACE);
			try {
				context.getSession().put("token", newService.getCurrentToken());
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}
			return newService;
		}
	}

	@Override
	public void releaseServiceObject(Exchange context, Object obj) {
		((Service) obj).close();
	}
}