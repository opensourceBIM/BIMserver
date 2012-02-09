package org.bimserver.test.framework;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.io.IOUtils;
import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSIPrefix;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualUser extends Thread {
	private final Logger LOGGER;
	private final BimServerClient bimServerClient;
	private final TestFramework testFramework;
	private Random random = new Random();
	private final List<SProject> createdProjects = new ArrayList<SProject>();
	private final List<SUser> createdUsers = new ArrayList<SUser>();
	private volatile boolean running;

	public VirtualUser(TestFramework testFramework, BimServerClient bimServerClient, String name) {
		setName(name);
		this.testFramework = testFramework;
		this.bimServerClient = bimServerClient;
		LOGGER = LoggerFactory.getLogger(name);
	}

	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				try {
					if (!bimServerClient.getServiceInterface().isLoggedIn()) {
						login();
					}
					int nextInt = random.nextInt(10);
					if (nextInt == 0) {
						createProject();
					} else if (nextInt == 1) {
						checkinRevision();
					} else if (nextInt == 2) {
						createSubProject();
					} else if (nextInt == 3) {
						downloadRevision();
					} else if (nextInt == 4) {
						updateProject();
					} else if (nextInt == 5) {
						createUser();
					} else if (nextInt == 6) {
						addUserToProject();
					} else if (nextInt == 7) {
						removeUserFromProject();
					} else if (nextInt == 8) {
						checkout();
					} else if (nextInt == 9) {
						logout();
					}
				} catch (UserException e) {
					LOGGER.info(e.getMessage());
				} catch (ServerException e) {
					LOGGER.error("", e);
				}
			}
		} finally {
			bimServerClient.disconnect();
			testFramework.unsubsribe(this);
		}
	}

	private void logout() throws ServerException, UserException {
		if (!createdUsers.isEmpty()) {
			LOGGER.info("Logging out");
			bimServerClient.getServiceInterface().logout();
		}
	}

	private void login() throws ServerException, UserException {
		if (random.nextInt(createdUsers.size() + 1) == 0) {
			bimServerClient.getServiceInterface().login("admin@bimserver.or", "admin");
		} else {
			if (!createdUsers.isEmpty()) {
				SUser user = getRandomUser();
				LOGGER.info("Logging in as " + user.getUsername());
				bimServerClient.getServiceInterface().login(user.getUsername(), "test");
			}
		}
	}

	private void checkout() throws ServerException, UserException {
		if (!createdProjects.isEmpty()) {
			SProject project = getRandomProject();
			if (project.getLastRevisionId() != -1) {
				List<SSerializer> allSerializers = bimServerClient.getServiceInterface().getAllSerializers(true);
				SSerializer serializer = allSerializers.get(random.nextInt(allSerializers.size()));
				boolean sync = random.nextBoolean();
				LOGGER.info("Checking out revision " + project.getLastRevisionId() + " of project " + project.getName() + " with serializer " + serializer.getName() + " sync: " + sync);
				Integer download = bimServerClient.getServiceInterface().checkout(project.getLastRevisionId(), serializer.getName(), sync);
				while (bimServerClient.getServiceInterface().getDownloadState(download).getState() != SActionState.FINISHED) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				LOGGER.info("Done preparing checkout, downloading");
				SDownloadResult downloadData = bimServerClient.getServiceInterface().getDownloadData(download);
				try {
					ByteArrayOutputStream data = new ByteArrayOutputStream();
					IOUtils.copy(downloadData.getFile().getInputStream(), data);
					LOGGER.info(data.size() + " bytes downloaded");
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		}
	}

	private void removeUserFromProject() throws ServerException, UserException {
		if (!createdProjects.isEmpty()) {
			SProject project = getRandomProject();
			if (!project.getHasAuthorizedUsers().isEmpty()) {
				Long uoid = project.getHasAuthorizedUsers().get(random.nextInt(project.getHasAuthorizedUsers().size()));
				LOGGER.info("Removing user " + uoid + " from project " + project.getName());
				bimServerClient.getServiceInterface().removeUserFromProject(uoid, project.getOid());
			}
		}
	}

	private void addUserToProject() throws ServerException, UserException {
		if (!createdProjects.isEmpty() && !createdUsers.isEmpty()) {
			SProject project = getRandomProject();
			SUser user = getRandomUser();
			LOGGER.info("Adding user " + user.getName() + " to project " + project.getName());
			bimServerClient.getServiceInterface().addUserToProject(user.getOid(), project.getOid());
			createdProjects.set(createdProjects.indexOf(project), bimServerClient.getServiceInterface().getProjectByPoid(project.getOid()));
		}
	}

	private SUser getRandomUser() {
		return createdUsers.get(random.nextInt(createdUsers.size()));
	}

	private void createUser() throws ServerException, UserException {
		String username = randomString() + "@bimserver.org";
		LOGGER.info("Creating new user: " + username);
		SUser user = bimServerClient.getServiceInterface().addUser(username, randomString(), SUserType.values()[random.nextInt(SUserType.values().length)], random.nextBoolean());
		bimServerClient.getServiceInterface().changePassword(user.getOid(), "", "test");
		createdUsers.add(user);
	}

	private void updateProject() throws ServerException, UserException {
		if (!createdProjects.isEmpty()) {
			SProject project = getRandomProject();
			LOGGER.info("Changing settings of project " + project.getName());
			project.setDescription(randomString());
			project.setExportLengthMeasurePrefix(SSIPrefix.values()[random.nextInt(SSIPrefix.values().length)]);
			project.setName(randomString());
			bimServerClient.getServiceInterface().updateProject(project);
		}		
	}

	private void downloadRevision() throws ServerException, UserException {
		if (!createdProjects.isEmpty()) {
			SProject project = getRandomProject();
			if (project.getLastRevisionId() != -1) {
				List<SSerializer> allSerializers = bimServerClient.getServiceInterface().getAllSerializers(true);
				SSerializer serializer = allSerializers.get(random.nextInt(allSerializers.size()));
				boolean sync = random.nextBoolean();
				LOGGER.info("Downloading revision " + project.getLastRevisionId() + " of project " + project.getName() + " with serializer " + serializer.getName() + " sync: " + sync);
				Integer download = bimServerClient.getServiceInterface().download(project.getLastRevisionId(), serializer.getName(), true, sync);
				while (bimServerClient.getServiceInterface().getDownloadState(download).getState() != SActionState.FINISHED) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				LOGGER.info("Done preparing download, downloading");
				SDownloadResult downloadData = bimServerClient.getServiceInterface().getDownloadData(download);
				try {
					ByteArrayOutputStream data = new ByteArrayOutputStream();
					IOUtils.copy(downloadData.getFile().getInputStream(), data);
					LOGGER.info(data.size() + " bytes downloaded");
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		}
	}

	private void createSubProject() throws ServerException, UserException {
		if (!createdProjects.isEmpty()) {
			SProject parentProject = getRandomProject();
			String name = "Project " + randomString();
			LOGGER.info("Creating new project: " + name + " as subproject of " + parentProject.getName());
			SProject project = bimServerClient.getServiceInterface().addProjectAsSubProject(name, parentProject.getOid());
			createdProjects.add(project);
		}
	}

	private SProject getRandomProject() {
		return createdProjects.get(random.nextInt(createdProjects.size()));
	}

	private void checkinRevision() throws UserException, ServerException {
		if (!createdProjects.isEmpty()) {
			SProject sProject = getRandomProject();
			File randomFile = testFramework.getRandomFile();
			FileDataSource dataSource = new FileDataSource(randomFile);
			String deserializerName = null;
			if (randomFile.getName().endsWith(".ifc")) {
				deserializerName = "IfcStepDeserializer";
			} else if (randomFile.getName().endsWith(".ifcxml")) {
				deserializerName = "IfcXmlDeserializer";
			}
			boolean sync = random.nextBoolean();
			boolean merge = random.nextBoolean();
			LOGGER.info("Checking in new revision on project " + sProject.getName() + " (" + randomFile.getName() + ") " + "sync: " + sync + ", merge: " + merge);
			bimServerClient.getServiceInterface().checkin(sProject.getOid(), randomString(), deserializerName, randomFile.length(), new DataHandler(dataSource),
					merge, sync);
		}
	}

	private void createProject() throws UserException, ServerException {
		String name = "Project " + randomString();
		LOGGER.info("Creating new project: " + name);
		SProject project = bimServerClient.getServiceInterface().addProject(name);
		createdProjects.add(project);
	}

	private String randomString() {
		return "" + Math.abs(random.nextInt());
	}
}