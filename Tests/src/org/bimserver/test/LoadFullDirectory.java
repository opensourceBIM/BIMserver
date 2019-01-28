package org.bimserver.test;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
	private ThreadPoolExecutor threadPoolExecutor;

	public static void main(String[] args) {
		new LoadFullDirectory(Paths.get("D:\\Dropbox\\Shared\\IFC files")).start();
	}

	public LoadFullDirectory(Path path) {
		this.path = path;
	}

	private void start() {
		threadPoolExecutor = new ThreadPoolExecutor(8, 8, 1, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(100000));
		
		client = LocalDevSetup.setupJson("http://localhost:8080");
		loadDirectoryRecursive(path, null);
		
		threadPoolExecutor.shutdown();
		try {
			threadPoolExecutor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void loadDirectoryRecursive(Path path, SProject parent) {
		try {
			for (Path p : PathUtils.list(path)) {
				if (Files.isDirectory(p)) {
					String projectName = p.getFileName().toString();
					SProject project = createProjectIfNotExists(parent, projectName);
					if (project != null) {
						loadDirectoryRecursive(p, project);
					}
				} else {
					String projectName = p.getFileName().toString();
					SProject project = createProjectIfNotExists(parent, projectName);
					loadFile(p, project);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private SProject createProjectIfNotExists(SProject parent, String projectName) {
		SProject project = null;
		try {
			System.out.println("Creating project " + projectName);
			if (parent == null) {
				project = client.getServiceInterface().addProject(projectName, "ifc2x3tc1");
			} else {
				project = client.getServiceInterface().addProjectAsSubProject(projectName, parent.getOid(), "ifc2x3tc1");
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			if (e.getMessage().equals("Project name must be unique")) {
				if (parent == null) {
					try {
						project = client.getServiceInterface().getProjectsByName(projectName).get(0);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					for (Long oid : parent.getSubProjects()) {
						try {
							SProject p2 = client.getServiceInterface().getProjectByPoid(oid);
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
		return project;
	}

	private void loadFile(Path p, SProject project) {
		threadPoolExecutor.submit(new Runnable(){
			@Override
			public void run() {
				String filename = p.getFileName().toString().toLowerCase();
				String extension = filename.substring(filename.indexOf(".") + 1);
				System.out.println("Loading file " + filename);
				if (filename.endsWith(".ifc") || filename.endsWith(".xml") || filename.endsWith(".zip") || filename.endsWith(".ifczip")) {
					try {
						SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension(extension, project.getOid());
						client.getServiceInterface().checkinSync(project.getOid(), filename, deserializer.getOid(), Files.size(p), filename, new DataHandler(new FileDataSource(p.toFile())), false);
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
			}});
	}
}
