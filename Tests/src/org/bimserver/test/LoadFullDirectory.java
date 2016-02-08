package org.bimserver.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.PathUtils;

public class LoadFullDirectory {
	private Path path;
	private BimServerClientInterface client;

	public static void main(String[] args) {
		new LoadFullDirectory(Paths.get("D:\\Dropbox\\Shared\\IFC files")).start();
	}

	public LoadFullDirectory(Path path) {
		this.path = path;
	}

	private void start() {
		client = LocalDevSetup.setupJson("http://localhost:8080");
		loadDirectoryRecursive(path, null);
	}
	
	private void loadDirectoryRecursive(Path path, SProject parent) {
		try {
			for (Path p : PathUtils.list(path)) {
				if (Files.isDirectory(p)) {
					SProject project = null;
					String projectName = p.getFileName().toString();
					try {
						System.out.println("Creating project " + projectName);
						if (parent == null) {
							project = client.getBimsie1ServiceInterface().addProject(projectName, "ifc2x3tc1");
						} else {
							project = client.getBimsie1ServiceInterface().addProjectAsSubProject(projectName, parent.getOid(), "ifc2x3tc1");
						}
					} catch (ServerException e) {
						e.printStackTrace();
					} catch (UserException e) {
						if (e.getMessage().equals("Project name must be unique")) {
							if (parent == null) {
								try {
									project = client.getBimsie1ServiceInterface().getProjectsByName(projectName).get(0);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							} else {
								for (Long oid : parent.getSubProjects()) {
									try {
										SProject p2 = client.getBimsie1ServiceInterface().getProjectByPoid(oid);
										if (p2.getName().equals(projectName)) {
											project = p2;
										}
									} catch (Exception e1) {
										e1.printStackTrace();
									}
								}
							}
						}
					} catch (PublicInterfaceNotFoundException e) {
						e.printStackTrace();
					}
					if (project != null) {
						loadDirectoryRecursive(p, project);
					}
				} else {
					loadFile(p, parent);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadFile(Path p, SProject project) {
		String filename = p.getFileName().toString().toLowerCase();
		String extension = filename.substring(filename.indexOf(".") + 1);
		System.out.println("Loading file " + filename);
		if (filename.endsWith(".ifc") || filename.endsWith(".xml") || filename.endsWith(".zip") || filename.endsWith(".ifczip")) {
			try {
				SDeserializerPluginConfiguration deserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension(extension, project.getOid());
				client.getServiceInterface().checkin(project.getOid(), filename, deserializer.getOid(), Files.size(p), filename, new DataHandler(new FileDataSource(p.toFile())), false, true);
			} catch (ServerException e) {
				e.printStackTrace();
			} catch (UserException e) {
				e.printStackTrace();
			} catch (PublicInterfaceNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}			
	}
}
