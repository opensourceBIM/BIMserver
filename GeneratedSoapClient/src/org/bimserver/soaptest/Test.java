package org.bimserver.soaptest;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.bimserver.generatedclient.SProject;
import org.bimserver.generatedclient.ServiceException_Exception;
import org.bimserver.generatedclient.ServiceInterfaceService;
import org.bimserver.generatedclient.Soap;

public class Test {
	public static void main(String[] args) {
		new Test().start();
	}

	private void start() {
		try {
			URL url = new URL("http://localhost/soap?wsdl");
			ServiceInterfaceService service = new ServiceInterfaceService(url);
			Soap soapPort = service.getSoapPort();
			((BindingProvider) soapPort).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
			try {
				soapPort.login("admin@bimserver.org", "admin");
				for (SProject sProject : soapPort.getAllProjects()) {
					System.out.println(sProject.getName());
				}
			} catch (ServiceException_Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}
}
