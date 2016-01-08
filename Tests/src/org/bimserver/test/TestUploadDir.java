package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.bimserver.utils.PathUtils;

public class TestUploadDir {
	private BimServerClientInterface client;

	public static void main(String[] args) {
		new TestUploadDir().start();
	}

	private void start() {
		try {
			client = LocalDevSetup.setupJson("http://localhost:8080");
			client.getSettingsInterface().setGenerateGeometryOnCheckin(false);
			
			Path directory = Paths.get("d:\\testfiles");
			for (Path f :  PathUtils.list(directory)) {
				process(f, null);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void process(Path directory, SProject parentProject) throws ServerException, UserException, PublicInterfaceNotFoundException, IOException {
		if (Files.isDirectory(directory)) {
			SProject project = null;
			if (parentProject == null) {
				project = client.getBimsie1ServiceInterface().addProject(directory.getFileName().toString(), "ifc2x3tc1");
			} else {
				project = client.getBimsie1ServiceInterface().addProjectAsSubProject(directory.getFileName().toString(), parentProject.getOid(), "ifc2x3tc1");
			}
			for (Path file : PathUtils.list(directory)) {
				process(file, project);
			}
		} else {
			String lowerCase = directory.getFileName().toString().toLowerCase();
			if (lowerCase.endsWith("ifc") || lowerCase.endsWith("ifcxml") || lowerCase.endsWith("ifczip")) {
				SDeserializerPluginConfiguration deserializerForExtension = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension(directory.getFileName().toString().substring(directory.getFileName().toString().lastIndexOf(".") + 1), parentProject.getOid());
				System.out.println("Checking in " + directory.toString() + " - " + Formatters.bytesToString(directory.toFile().length()));
				try {
					client.checkin(parentProject.getOid(), "", deserializerForExtension.getOid(), false, true, directory);
				} catch (UserException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Ignoring " + directory.toString());
			}
		}
	}
}