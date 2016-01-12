package org.bimserver.logcreater;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SNewProjectAdded;
import org.bimserver.interfaces.objects.SNewRevisionAdded;
import org.bimserver.interfaces.objects.SNewUserAdded;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectDeleted;
import org.bimserver.interfaces.objects.SProjectRelated;
import org.bimserver.interfaces.objects.SProjectUndeleted;
import org.bimserver.interfaces.objects.SProjectUpdated;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionRelated;
import org.bimserver.interfaces.objects.SServerStarted;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserAddedToProject;
import org.bimserver.interfaces.objects.SUserRelated;
import org.bimserver.interfaces.objects.SUserRemovedFromProject;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;

import com.opencsv.CSVWriter;

public class CreateLog {
	private final Map<GregorianCalendar, Event> timeline = new TreeMap<>();

	public static abstract class Event {
	}
	
	public static class ProjectCreated extends Event {

		private SProject sProject;
		private SUser sUser;

		public ProjectCreated(SProject sProject, SUser sUser) {
			this.sProject = sProject;
			this.sUser = sUser;
		}
		
		@Override
		public String toString() {
			return sProject.getName() + " created by " + sUser.getName() + "(" + sUser.getUsername() + ")";
		}
	}
	
	public static class UserCreated extends Event {
		private SUser sUser;

		public UserCreated(SUser sUser) {
			this.sUser = sUser;
		}

		@Override
		public String toString() {
			return sUser.getName() + " (" + sUser.getUsername() + ")";
		}
	}
	
	public static class RevisionCreated extends Event {
		private SRevision sRevision;
		private SUser sUser;

		public RevisionCreated(SRevision sRevision, SUser sUser) {
			this.sRevision = sRevision;
			this.sUser = sUser;
		}
		
		@Override
		public String toString() {
			return sRevision.getId() + " (" + sRevision.getComment() + ") by " + sUser.getName() + " (" + sUser.getUsername() + ")";
		}
	}
	
	public static void main(String[] args) {
		new CreateLog().create(args[0], args[1], args[2]);
	}

	private void create(String address, String username, String password) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Path home = Paths.get("home");
			if (!Files.isDirectory(home)) {
				Files.createDirectory(home);
			}
			PluginManager pluginManager = new PluginManager(home.resolve("tmp"), System.getProperty("java.class.path"), null, null, null);
			pluginManager.loadAllPluginsFromEclipseWorkspace(Paths.get("../"), true);
			
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			metaDataManager.init();

			pluginManager.initAllLoadedPlugins();
			
			BimServerClientFactory factory = new JsonBimServerClientFactory(metaDataManager, address);
			BimServerClientInterface client = factory.create(new UsernamePasswordAuthenticationInfo(username, password));

//			for (SLogAction logAction : client.getAdminInterface().getLogs()) {
//				System.out.println(dateFormat.format(logAction.getDate()) + " " + logAction.getClass().getSimpleName());
//			}

//			List<SProject> projects = client.getBimsie1ServiceInterface().getAllProjects(false, false);
//			for (SProject sProject : projects) {
//				GregorianCalendar created = new GregorianCalendar();
//				created.setTime(sProject.getCreatedDate());
//				timeline.put(created, new ProjectCreated(sProject, client.getServiceInterface().getUserByUoid(sProject.getCreatedById())));
//				List<SRevision> revisions = client.getBimsie1ServiceInterface().getAllRevisionsOfProject(sProject.getOid());
//				for (SRevision sRevision : revisions) {
//					GregorianCalendar gregorianCalendar = new GregorianCalendar();
//					gregorianCalendar.setTime(sRevision.getDate());
//					timeline.put(gregorianCalendar, new RevisionCreated(sRevision, client.getServiceInterface().getUserByUoid(sRevision.getUserId())));
//				}
//			}
//			List<SUser> users = client.getServiceInterface().getAllUsers();
//			for (SUser sUser : users) {
//				GregorianCalendar created = new GregorianCalendar();
//				created.setTime(sUser.getCreatedOn());
//				timeline.put(created, new UserCreated(sUser));
//			}
			try (CSVWriter csvWriter = new CSVWriter(new FileWriter(new File("elassticlog.csv")))) {
				csvWriter.writeNext(new String[]{"Date/Time", "Type", "User", "Description"});
				
				for (SLogAction logAction : client.getAdminInterface().getLogs()) {
					String description = null;
					SProject project = null;
					SUser actingUser = client.getServiceInterface().getUserByUoid(logAction.getExecutorId());
					SUser user = null;
					SRevision revision = null;
					if (logAction instanceof SProjectRelated) {
						project = client.getBimsie1ServiceInterface().getProjectByPoid(((SProjectRelated)logAction).getProjectId());
					}
					if (logAction instanceof SRevisionRelated) {
						revision = client.getBimsie1ServiceInterface().getRevision(((SRevisionRelated)logAction).getRevisionId());
					}
					if (logAction instanceof SUserRelated) {
						user = client.getServiceInterface().getUserByUoid(((SUserRelated)logAction).getUserId());
					}
					
					if (logAction instanceof SProjectDeleted) {
						description = "Project " + project.getName() + " deleted";
					} else if (logAction instanceof SNewProjectAdded) {
						SNewProjectAdded sNewProjectAdded =  (SNewProjectAdded)logAction;
						SProject parentProject = null;
						description = "Project " + project.getName() + " added";
						if (sNewProjectAdded.getParentProjectId() != -1) {
							parentProject = client.getBimsie1ServiceInterface().getProjectByPoid(sNewProjectAdded.getParentProjectId());
							description += " as a subproject of " + parentProject.getName();
						}
					} else if (logAction instanceof SNewUserAdded) {
						description = "New user added " + user.getName() + " (" + user.getUsername() + ")";
					} else if (logAction instanceof SProjectUndeleted) {
						description = "Project " + project.getName() + " undeleted";
					} else if (logAction instanceof SServerStarted) {
						description = "Server started";
					} else if (logAction instanceof SExtendedDataAddedToRevision) {
						SExtendedDataAddedToRevision sExtendedDataAddedToRevision = (SExtendedDataAddedToRevision)logAction;
						SRevision revision2 = client.getBimsie1ServiceInterface().getRevision(sExtendedDataAddedToRevision.getRevisionId());
						SProject project2 = client.getBimsie1ServiceInterface().getProjectByPoid(revision2.getProjectId());
						description = "Extended data added to revision " + revision2.getId() + " of project " + project2.getName();
					} else if (logAction instanceof SProjectUpdated) {
						description = "Project " + project.getName() + " updated";
					} else if (logAction instanceof SNewRevisionAdded) {
						SNewRevisionAdded sNewRevisionAdded = (SNewRevisionAdded)logAction;
						description = "New revision added to project " + client.getBimsie1ServiceInterface().getProjectByPoid(sNewRevisionAdded.getProjectId()).getName() + " with comment " + revision.getComment();
					} else if (logAction instanceof SUserAddedToProject) {
						SUserAddedToProject sUserAddedToProject = (SUserAddedToProject)logAction;
						description = "User " + user.getName() + " added to project " + client.getBimsie1ServiceInterface().getProjectByPoid(sUserAddedToProject.getProjectId()).getName();
					} else if (logAction instanceof SUserRemovedFromProject) {
						SUserRemovedFromProject sUserRemovedFromProject = (SUserRemovedFromProject)logAction;
						description = "User " + client.getServiceInterface().getUserByUoid(sUserRemovedFromProject.getUserId()).getName() + " removed from project " + client.getBimsie1ServiceInterface().getProjectByPoid(sUserRemovedFromProject.getProjectId()).getName();
					} else {
						description = "no description";
					}

					csvWriter.writeNext(new String[]{dateFormat.format(logAction.getDate().getTime()), logAction.getClass().getSimpleName().substring(1), actingUser == null ? "" : (actingUser.getName() + " (" + actingUser.getUsername() + ")"), description});
				}
				
				
//				for (GregorianCalendar date : timeline.keySet()) {
//					Event event = timeline.get(date);
//					csvWriter.writeNext(new String[]{dateFormat.format(date.getTime()), event.getClass().getSimpleName(), event.toString()});
//				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}