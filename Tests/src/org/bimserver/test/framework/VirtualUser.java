package org.bimserver.test.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bimserver.client.BimServerClient;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.actions.Action;
import org.bimserver.test.framework.actions.ActionFactory;
import org.bimserver.test.framework.actions.LoginAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VirtualUser extends Thread {
	private final Logger LOGGER;
	private final BimServerClient bimServerClient;
	private final TestFramework testFramework;
	private final Random random = new Random();
	private final List<SProject> createdProjects = new ArrayList<SProject>();
	private final List<SUser> createdUsers = new ArrayList<SUser>();
	private final ActionFactory actionFactory;
	private volatile boolean running;

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
				} catch (ServerException e) {
					LOGGER.error("", e);
				} catch (UserException e) {
					LOGGER.error("", e);
				}
			}
		} finally {
			bimServerClient.disconnect();
			testFramework.unsubsribe(this);
		}
	}

	public SUser getRandomUser() {
		return createdUsers.get(random.nextInt(createdUsers.size()));
	}

	public SProject getRandomProject() {
		return createdProjects.get(random.nextInt(createdProjects.size()));
	}

	public List<SProject> getCreatedProjects() {
		return createdProjects;
	}

	public BimServerClient getBimServerClient() {
		return bimServerClient;
	}

	public List<SUser> getCreatedUsers() {
		return createdUsers;
	}
}