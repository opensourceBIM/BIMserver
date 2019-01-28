package org.bimserver.tests;

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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.LocalDevSetup;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.PathUtils;

public class FileLoader {
	public static void main(String[] args) {
		new FileLoader().load(Paths.get("C:\\Users\\Ruben de Laat\\Dropbox\\Shared\\BIMserver\\LOD modellen"));
	}

	private void load(Path dir) {
//		JsonBimServerClientFactory factory = new JsonBimServerClientFactory("http://sandbox.bimserver.org");
		try {
			final BimServerClientInterface client = LocalDevSetup.setupJson("http://localhost:8080");
			ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(200));
			for (final Path file : PathUtils.list(dir)) {
				executorService.submit(new Runnable(){
					@Override
					public void run() {
						System.out.println(file.getFileName());
						SProject project;
						try {
							project = client.getServiceInterface().addProject(file.getFileName().toString(), "ifc2x3tc1");
							SDeserializerPluginConfiguration deserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
							client.checkinSync(project.getOid(), file.getFileName().toString(), deserializer.getOid(), false, file);
						} catch (ServerException e) {
							e.printStackTrace();
						} catch (UserException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (PublicInterfaceNotFoundException e) {
							e.printStackTrace();
						}
					}});
			}
			executorService.awaitTermination(1, TimeUnit.HOURS);
			System.out.println("Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}