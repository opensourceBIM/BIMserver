package org.bimserver.generatedclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.ws.BindingProvider;

public class Test {
	private ServiceInterfaceService service;
	private Soap soapPort;

	public static void main(String[] args) {
		new Test().start();
	}

	private void start() {
		service = new ServiceInterfaceService();
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
		SDownloadResult downloadOfType = soapPort.downloadOfType(firstProject.getLastRevisionId(), "IfcSlab", ResultType.IFCXML);
		DataHandler file = downloadOfType.getFile();
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

	private void testAddUser() throws UserException_Exception, ServerException_Exception {
		long addUser = soapPort.addUser("tes43@bimserver.org", "Test", SUserType.USER, true);
		System.out.println("User successfully added: " + addUser);
	}
}
