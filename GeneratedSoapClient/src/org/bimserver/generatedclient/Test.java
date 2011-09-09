package org.bimserver.generatedclient;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.ws.BindingProvider;

public class Test {
	private ServiceInterfaceService service;
	private Soap soapPort;

	public static void main(String[] args) {
		try {
			new Test().start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private void start() throws MalformedURLException {
		URL url = new URL("http://localhost:8082/soap?wsdl");
		service = new ServiceInterfaceService(url);
		soapPort = service.getSoapPort();
		((BindingProvider) soapPort).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
		try {
			soapPort.login("test@bimserver.org", "test");
			testDownloadFirstProjectFirstRevision();
		} catch (UserException_Exception e) {
			e.printStackTrace();
		} catch (ServerException_Exception e) {
			e.printStackTrace();
		}
	}

	private void testDownloadFirstProjectFirstRevision() throws UserException_Exception, ServerException_Exception {
		List<SProject> allProjects = soapPort.getAllProjects();
		SProject firstProject = allProjects.get(0);
		int downloadId = soapPort.downloadOfType(firstProject.getLastRevisionId(), "IfcSlab", "IFC", true);
		SDownloadResult downloadData = soapPort.getDownloadData(downloadId);
		DataHandler file = downloadData.getFile();
		try {
			InputStream inputStream = file.getInputStream();
			byte[] buffer = new byte[1024];
			int red = inputStream.read(buffer);
			while (red != -1) {
				System.out.print(new String(buffer, 0, red));
				red = inputStream.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
