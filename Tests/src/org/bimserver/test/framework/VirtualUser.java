package org.bimserver.test.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.actions.Action;
import org.bimserver.test.framework.actions.ActionFactory;
import org.bimserver.test.framework.actions.CheckinAction;
import org.bimserver.test.framework.actions.CreateProjectAction;
import org.bimserver.test.framework.actions.CreateUserAction;
import org.bimserver.test.framework.actions.LoginAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualUser extends Thread {
	private final Logger LOGGER;
	private final BimServerClient bimServerClient;
	private final TestFramework testFramework;
	private final Random random = new Random();
	private final ActionFactory actionFactory;
	private volatile boolean running;
	private final List<String> usernames = new ArrayList<String>();
	private boolean stopOnException;

	public VirtualUser(TestFramework testFramework, BimServerClient bimServerClient, ActionFactory actionFactory, String name) {
		setName(name);
		this.actionFactory = actionFactory;
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
						new LoginAction(testFramework).execute(this);
					} else {
						Action action = actionFactory.createAction();
						action.execute(this);
					}
				} catch (Exception e) {
					LOGGER.info(e.getMessage());
					if (stopOnException) {
						break;
					}
				}
			}
		} finally {
			bimServerClient.disconnect();
			testFramework.unsubsribe(this);
		}
	}

	public SUser getRandomUser() {
		try {
			List<SUser> users = bimServerClient.getServiceInterface().getAllUsers();
			if (users.isEmpty()) {
				CreateUserAction createUserAction = new CreateUserAction(testFramework);
				createUserAction.execute(this);
			}
			users = bimServerClient.getServiceInterface().getAllUsers();
			if (!users.isEmpty()) {
				return users.get(random.nextInt(users.size()));
			}
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public SProject getRandomProject() {
		try {
			List<SProject> allProjects = bimServerClient.getServiceInterface().getAllProjects();
			if (allProjects.isEmpty()) {
				CreateProjectAction createProjectAction = new CreateProjectAction(testFramework);
				createProjectAction.execute(this);
			}
			allProjects = bimServerClient.getServiceInterface().getAllProjects();
			if (!allProjects.isEmpty()) {
				return allProjects.get(random.nextInt(allProjects.size()));
			}
		} catch (ServerException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public Logger getLogger() {
		return LOGGER;
	}

	public void addUsername(String username) {
		usernames.add(username);
	}

	public List<String> getUserNames() {
		return usernames;
	}

	public String getRandomUserName() {
		return usernames.get(random.nextInt(usernames.size()));
	}

	public SRevision getRandomRevision() throws ServerException, UserException {
		SProject project = getRandomProject();
		if (project.getLastRevisionId() == -1) {
			CheckinAction checkinAction = new CheckinAction(testFramework);
			checkinAction.execute(this);
		}
		project = getBimServerClient().getServiceInterface().getProjectByPoid(project.getOid());
		if (project.getLastRevisionId() != -1) {
			return bimServerClient.getServiceInterface().getRevision(project.getLastRevisionId());
		}
		return null;
	}

	public void setStopOnException(boolean stopOnException) {
		this.stopOnException = stopOnException;
	}
}