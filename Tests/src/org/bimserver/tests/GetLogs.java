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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.client.BimServerClient;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.interfaces.objects.SDatabaseCreated;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SNewUserAdded;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectDeleted;
import org.bimserver.interfaces.objects.SProjectUpdated;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SServerStarted;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserAddedToProject;
import org.bimserver.interfaces.objects.SUserChanged;
import org.bimserver.interfaces.objects.SUserRemovedFromProject;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;

public class GetLogs {
	private PrintWriter writer;
	private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
	private BimServerClient client;
	private Map<Long, SUser> users = new HashMap<>();
	private Map<Long, SProject> projects = new HashMap<>();
	private Map<Long, SRevision> revisions = new HashMap<>();

	public static void main(String[] args) {
		new GetLogs().start();
	}

	private void start() {
		try (JsonBimServerClientFactory factory = new JsonBimServerClientFactory(null, "[ADD]")){
			client = factory.create(new UsernamePasswordAuthenticationInfo("[ADD]", "[ADD]"));
			List<SLogAction> logs = client.getAdminInterface().getLogs();
			Path file = Paths.get("log.txt");
			writer = new PrintWriter(file.toFile());
			try {
				for (SLogAction sLogAction : logs) {
					if (sLogAction instanceof SDatabaseCreated) {
						write(sLogAction, "Database created");
					} else if (sLogAction instanceof SUserAddedToProject) {
						SUserAddedToProject sUserAddedToProject = (SUserAddedToProject)sLogAction;
						SProject project = getProject(sUserAddedToProject.getProjectId());
						SUser user = getUser(sUserAddedToProject.getUserId());
						write(sLogAction, "User " + user.getUsername() + " added to project " + project.getName());
					} else if (sLogAction instanceof SUserRemovedFromProject) {
						SUserRemovedFromProject sUserRemovedFromProject = (SUserRemovedFromProject)sLogAction;
						SProject project = getProject(sUserRemovedFromProject.getProjectId());
						SUser user = getUser(sUserRemovedFromProject.getUserId());
						write(sLogAction, "User " + user.getUsername() + " removed from project " + project.getName());
					} else if (sLogAction instanceof SNewUserAdded) {
						SNewUserAdded sNewUserAdded = (SNewUserAdded)sLogAction;
						SUser user = getUser(sNewUserAdded.getUserId());
						write(sLogAction, "User " + user.getUsername() + " created");
					} else if (sLogAction instanceof SNewProjectAdded) {
						SNewProjectAdded sNewProject = (SNewProjectAdded)sLogAction;
						SProject project = getProject(sNewProject.getProjectId());
						write(sLogAction, "Project " + project.getName() + " created");
					} else if (sLogAction instanceof SNewRevisionAdded) {
						SNewRevisionAdded sNewRevisionAdded = (SNewRevisionAdded)sLogAction;
						SProject project = getProject(sNewRevisionAdded.getProjectId());
						SRevision revision = getRevision(sNewRevisionAdded.getRevisionId());
						write(sLogAction, "Revision " + revision.getId() + " with comment " + revision.getComment() + " added to project " + project.getName());
					} else if (sLogAction instanceof SProjectUpdated) {
						SProjectUpdated sProjectUpdated = (SProjectUpdated)sLogAction;
						SProject project = getProject(sProjectUpdated.getProjectId());
						write(sLogAction, "Project " + project.getName() + " updated");
					} else if (sLogAction instanceof SProjectDeleted) {
						SProjectDeleted sProjectDeleted = (SProjectDeleted)sLogAction;
						SProject project = getProject(sProjectDeleted.getProjectId());
						write(sLogAction, "Project " + project.getName() + " deleted");
					} else if (sLogAction instanceof SUserChanged) {
						SUserChanged sUserChanged = (SUserChanged)sLogAction;
						SUser user = getUser(sUserChanged.getUserId());
						write(sLogAction, "User " + user.getUsername() + " updated");
					} else if (sLogAction instanceof SServerStarted) {
						write(sLogAction, "Server started");
					} else {
						write(sLogAction, "NOT IMPL " + sLogAction.getClass().getSimpleName());
					}
				}
			} finally {
				writer.close();
			}
		} catch (ServiceException | ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BimServerClientException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private SRevision getRevision(long roid) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SRevision revision = revisions.get(roid);
		if (revision == null) {
			revision = client.getServiceInterface().getRevision(roid);
			revisions.put(roid, revision);
		}
		return revision;
	}

	private SProject getProject(long poid) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SProject project = projects.get(poid);
		if (project == null) {
			project = client.getServiceInterface().getProjectByPoid(poid);
			projects.put(poid, project);
		}
		return project;
	}
	
	private SUser getUser(long uoid) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SUser user = users.get(uoid);
		if (user == null) {
			user = client.getServiceInterface().getUserByUoid(uoid);
			users.put(uoid, user);
		}
		return user;
	}
	
	private void write(SLogAction logAction, String text) {
		try {
			SUser user = users.get(logAction.getExecutorId());
			if (user == null) {
				user = client.getServiceInterface().getUserByUoid(logAction.getExecutorId());
				users.put(logAction.getExecutorId(), user);
			}
			writer.println(dateFormat.format(logAction.getDate()) + " " + logAction.getAccessMethod() + " " + (user == null ? "" : user.getUsername()) + ": " + text);
		} catch (ServerException | UserException | PublicInterfaceNotFoundException e) {
			e.printStackTrace();
		}
	}
}
