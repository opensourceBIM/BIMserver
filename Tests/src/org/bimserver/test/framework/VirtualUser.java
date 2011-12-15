package org.bimserver.test.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.shared.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualUser extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(VirtualUser.class);
	private final BimServerClient bimServerClient;
	private final TestFramework testFramework;
	private Random random = new Random();
	private final List<SProject> createdProjects = new ArrayList<SProject>();
	private volatile boolean running;

	public VirtualUser(TestFramework testFramework, BimServerClient bimServerClient) {
		this.testFramework = testFramework;
		this.bimServerClient = bimServerClient;
	}

	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				try {
					int nextInt = random.nextInt(2);
					if (nextInt == 0) {
						createProject();
					} else if (nextInt == 1) {
						checkinRevision();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						LOGGER.error("", e);
					}
				} catch (ServiceException e) {
					LOGGER.error("", e);
				}
			}
		} finally {
			bimServerClient.disconnect();
			testFramework.unsubsribe(this);
		}
	}

	private void checkinRevision() throws ServiceException {
		if (!createdProjects.isEmpty()) {
			SProject sProject = createdProjects.get(random.nextInt(createdProjects.size()));
			File randomFile = testFramework.getRandomFile();
			LOGGER.info("Checking in new revision on project " + sProject.getName() + " (" + randomFile.getName() + ")");
			FileDataSource dataSource = new FileDataSource(randomFile);
			String deserializerName = null;
			if (randomFile.getName().endsWith(".ifc")) {
				deserializerName = "IfcStepDeserializer";
			} else if (randomFile.getName().endsWith(".ifcxml")) {
				deserializerName = "IfcXmlDeserializer";
			}
			bimServerClient.getServiceInterface().checkin(sProject.getOid(), randomString(), deserializerName, randomFile.length(), new DataHandler(dataSource),
					random.nextBoolean(), random.nextBoolean());
		}
	}

	private void createProject() throws ServiceException {
		LOGGER.info("Creating new project");
		SProject project = bimServerClient.getServiceInterface().addProject("Project " + randomString());
		createdProjects.add(project);
	}

	private String randomString() {
		return "" + Math.abs(random.nextInt());
	}
}