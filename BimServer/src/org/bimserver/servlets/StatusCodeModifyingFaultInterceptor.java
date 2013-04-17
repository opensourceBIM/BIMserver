package org.bimserver.servlets;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 *	Normally when SOAP faults are returned, the HTTP status code should be 500, but this class will change it to 200, because the Apache CXF JS client requires it to be 200.
 */
public class StatusCodeModifyingFaultInterceptor extends AbstractSoapInterceptor {

	public StatusCodeModifyingFaultInterceptor() {
		super(Phase.POST_STREAM_ENDING);
	}
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		message.put(SoapMessage.RESPONSE_CODE, 200);
	}
}
