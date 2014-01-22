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
