package org.bimserver.servlets;

import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;

public class AuthenticationInterceptor extends SoapHeaderInterceptor {
	@Override
	public void handleMessage(Message m) throws Fault {
		super.handleMessage(m);
	}
}
