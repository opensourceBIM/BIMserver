package org.bimserver.test.framework;

import java.io.File;

import org.bimserver.client.factories.BimServerClientFactory;
import org.bimserver.test.framework.actions.ActionFactory;

public class TestConfiguration {
	private int nrVirtualUsers = 1;
	private int nrRunsPerVirtualUser = -1;
	private boolean startEmbeddedBimServer = true;
	private boolean cleanEnvironmentFirst = true;
	private boolean stopOnUserException = false;
	private boolean stopOnServerException = true;
	private boolean stopNoVirtualUsers = true;
	private ActionFactory actionFactory;
	private File outputFolder;
	private BimServerClientFactory bimServerClientFactory;
	private File homeDir = new File("home");
	private TestFileProvider testFileProvider;
	
	public int getNrVirtualUsers() {
		return nrVirtualUsers;
	}

	public void setNrVirtualUsers(int nrVirtualUsers) {
		this.nrVirtualUsers = nrVirtualUsers;
	}

	public int getNrRunsPerVirtualUser() {
		return nrRunsPerVirtualUser;
	}

	public void setNrRunsPerVirtualUser(int nrRunsPerVirtualUser) {
		this.nrRunsPerVirtualUser = nrRunsPerVirtualUser;
	}

	public boolean isStartEmbeddedBimServer() {
		return startEmbeddedBimServer;
	}

	public void setStartEmbeddedBimServer(boolean startEmbeddedBimServer) {
		this.startEmbeddedBimServer = startEmbeddedBimServer;
	}

	public boolean isCleanEnvironmentFirst() {
		return cleanEnvironmentFirst;
	}

	public void setCleanEnvironmentFirst(boolean cleanEnvironmentFirst) {
		this.cleanEnvironmentFirst = cleanEnvironmentFirst;
	}

	public boolean isStopOnUserException() {
		return stopOnUserException;
	}

	public void setStopOnUserException(boolean stopOnUserException) {
		this.stopOnUserException = stopOnUserException;
	}

	public boolean isStopOnServerException() {
		return stopOnServerException;
	}

	public void setStopOnServerException(boolean stopOnServerException) {
		this.stopOnServerException = stopOnServerException;
	}

	public ActionFactory getActionFactory() {
		return actionFactory;
	}

	public void setActionFactory(ActionFactory actionFactory) {
		this.actionFactory = actionFactory;
	}

	public File getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(File outputFolder) {
		this.outputFolder = outputFolder;
	}

	public BimServerClientFactory getBimServerClientFactory() {
		return bimServerClientFactory;
	}

	public void setBimServerClientFactory(BimServerClientFactory bimServerClientFactory) {
		this.bimServerClientFactory = bimServerClientFactory;
	}
	
	public File getHomeDir() {
		return homeDir;
	}

	public void setHomeDir(File homeDir) {
		this.homeDir = homeDir;
	}

	public void setTestFileProvider(TestFileProvider testFileProvider) {
		this.testFileProvider = testFileProvider;
	}
	
	public TestFileProvider getTestFileProvider() {
		return testFileProvider;
	}

	public boolean isStopNoVirtualUsers() {
		return stopNoVirtualUsers;
	}

	public void setStopNoVirtualUsers(boolean stopNoVirtualUsers) {
		this.stopNoVirtualUsers = stopNoVirtualUsers;
	}
}