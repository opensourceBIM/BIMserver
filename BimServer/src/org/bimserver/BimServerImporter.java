package org.bimserver;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.ChannelConnectionException;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BimServerImporter {

	private String address;
	private String username;
	private String password;
	private BimServer bimServer;
	private BimServerClientInterface remoteClient;
	Map<Long, User> users = new HashMap<>();
	Map<Long, Project> projects = new HashMap<>();
	private static final Logger LOGGER = LoggerFactory.getLogger(BimServerImporter.class);
	private String path;

	public BimServerImporter(BimServer bimServer, String address, String username, String password, String path) {
		this.bimServer = bimServer;
		this.address = address;
		this.username = username;
		this.password = password;
		this.path = path;
	}
	
	public User createUser(DatabaseSession databaseSession, long remoteUoid) throws BimserverDatabaseException, ServerException, UserException, PublicInterfaceNotFoundException {
		if (users.containsKey(remoteUoid)) {
			return users.get(remoteUoid);
		}
		SUser remoteUser = remoteClient.getServiceInterface().getUserByUoid(remoteUoid);
		User newUser = databaseSession.create(User.class);
		users.put(remoteUoid, newUser);
		long createdById = remoteUser.getCreatedById();
		if (createdById != -1) {
			newUser.setCreatedBy(createUser(databaseSession, createdById));
		}
		newUser.setCreatedOn(remoteUser.getCreatedOn());
		newUser.setLastSeen(remoteUser.getLastSeen());
		newUser.setName(remoteUser.getName());
		newUser.setPasswordHash(remoteUser.getPasswordHash());
		newUser.setPasswordSalt(remoteUser.getPasswordSalt());
		newUser.setState(bimServer.getSConverter().convertFromSObject(remoteUser.getState()));
		newUser.setToken(remoteUser.getToken());
		newUser.setUsername(remoteUser.getUsername());
		newUser.setUserType(bimServer.getSConverter().convertFromSObject(remoteUser.getUserType()));
		bimServer.updateUserSettings(databaseSession, newUser);
		databaseSession.store(newUser);
		return newUser;
	}
	
	class Key {
		public String comment;
		public long userId;
		public Date date;
		public File file;
		public long poid;

		public Key(File file, long oid, String comment, Date date, long userId) {
			this.file = file;
			poid = oid;
			this.comment = comment;
			this.date = date;
			this.userId = userId;
		}
	}
	
	public void start() {
		try {
			LOGGER.info("Importing...");
			BimServerClientFactory factory = new JsonBimServerClientFactory(bimServer.getMetaDataManager(), address);
			remoteClient = factory.create(new UsernamePasswordAuthenticationInfo(username, password));
			final BimDatabase database = bimServer.getDatabase();
			DatabaseSession databaseSession = database.createSession();
			try {
				LOGGER.info("Users...");
				for (SUser user : remoteClient.getServiceInterface().getAllUsers()) {
					createUser(databaseSession, user.getOid());
				}
				LOGGER.info("Projects...");
				for (SProject project : remoteClient.getBimsie1ServiceInterface().getAllProjects(false, false)) {
					createProject(databaseSession, project.getOid());
				}
				LOGGER.info("Done");
				databaseSession.commit();
			} catch (BimserverDatabaseException e) {
				LOGGER.error("", e);
			} finally {
				databaseSession.close();
			}
			final BimServerClientInterface client = bimServer.getBimServerClientFactory().create(new UsernamePasswordAuthenticationInfo(username, password));
			
//			for (SRenderEnginePluginConfiguration renderEnginePluginConfiguration : client.getPluginInterface().getAllRenderEngines(true)) {
//				if (renderEnginePluginConfiguration.getName().equals("IFC Engine DLL")) {
//					client.getPluginInterface().setDefaultRenderEngine(renderEnginePluginConfiguration.getOid());
//				}
//			}
			File incoming = new File(path);
			final Map<GregorianCalendar, Key> comments = new TreeMap<>();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			for (SProject project : remoteClient.getBimsie1ServiceInterface().getAllProjects(false, false)) {
				for (SRevision revision : remoteClient.getBimsie1ServiceInterface().getAllRevisionsOfProject(project.getOid())) {
					GregorianCalendar gregorianCalendar = new GregorianCalendar();
					gregorianCalendar.setTime(revision.getDate());
					if (!revision.getComment().startsWith("generated for")) {
						User user = users.get(revision.getUserId());
						File userFolder = new File(incoming, user.getUsername());
						boolean found = false;
						for (File file : userFolder.listFiles()) {
							if (file.getName().endsWith(revision.getComment())) {
								String dateStr = file.getName().substring(0, 19);
								Date parse = dateFormat.parse(dateStr);
								GregorianCalendar fileDate = new GregorianCalendar();
								fileDate.setTime(parse);
								long millisDiff = Math.abs(fileDate.getTimeInMillis() - revision.getDate().getTime());
								if (millisDiff > 1000 * 60 * 120) { // 120 minutes
									continue;
								}
								comments.put(gregorianCalendar, new Key(file, project.getOid(), revision.getComment(), revision.getDate(), revision.getUserId()));
								found = true;
								break;
							}
						}
						if (!found) {
							LOGGER.info("Not found: " + revision.getComment());
						}
					}
				}
			}
			ExecutorService executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.DAYS, new ArrayBlockingQueue<Runnable>(1000));

			for (final GregorianCalendar gregorianCalendar : comments.keySet()) {
				executorService.submit(new Runnable(){
					@Override
					public void run() {
						Key key = comments.get(gregorianCalendar);
						LOGGER.info("Checking in: " + key.file.getName() + " " + Formatters.bytesToString(key.file.length()));
						Project sProject = projects.get(key.poid);
						try {
							SDeserializerPluginConfiguration desserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", sProject.getOid());
							client.checkin(sProject.getOid(), key.comment, desserializer.getOid(), false, true, key.file);
							SProject updatedProject = client.getBimsie1ServiceInterface().getProjectByPoid(sProject.getOid());
							DatabaseSession databaseSession = database.createSession();
							try {
								LOGGER.info("Done");
								Project project = databaseSession.get(updatedProject.getOid(), Query.getDefault());
								Revision revision = project.getLastRevision();
								DateFormat m = new SimpleDateFormat("dd-MM-yyyy");
								LOGGER.info("Setting date to " + m.format(key.date));
								revision.setUser((User)databaseSession.get(users.get(key.userId).getOid(), Query.getDefault()));
								revision.setDate(key.date);
								databaseSession.store(revision);
								databaseSession.commit();
							} catch (BimserverDatabaseException | ServiceException e) {
								LOGGER.error("", e);
							} finally {
								databaseSession.close();
							}
						} catch (IOException | UserException | ServerException | PublicInterfaceNotFoundException e) {
							LOGGER.error("", e);
						}
					}					
				});
				
			}
			executorService.shutdown();
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} catch (ChannelConnectionException e) {
			LOGGER.error("", e);
		} catch (PublicInterfaceNotFoundException e) {
			LOGGER.error("", e);
		} catch (ParseException e) {
			LOGGER.error("", e);
		}
	}

	private Project createProject(DatabaseSession databaseSession, long poid) throws BimserverDatabaseException, ServerException, UserException, PublicInterfaceNotFoundException {
		SProject project = remoteClient.getBimsie1ServiceInterface().getProjectByPoid(poid);
		if (projects.containsKey(project.getOid())) {
			return projects.get(project.getOid());
		}
		Project newProject = databaseSession.create(Project.class);
		projects.put(project.getOid(), newProject);
		newProject.setId(databaseSession.newPid());
		GeoTag geoTag = databaseSession.create(GeoTag.class);
		geoTag.setEnabled(false);
		newProject.setGeoTag(geoTag);
		databaseSession.store(geoTag);
		newProject.setCreatedBy(createUser(databaseSession, project.getCreatedById()));
		newProject.setCreatedDate(project.getCreatedDate());
		newProject.setDescription(project.getDescription());
		newProject.setExportLengthMeasurePrefix(bimServer.getSConverter().convertFromSObject(project.getExportLengthMeasurePrefix()));
		newProject.setName(project.getName());
		if (project.getParentId() != -1) {
			Project createProject = createProject(databaseSession, project.getParentId());
			createProject.getSubProjects().add(newProject);
			newProject.setParent(createProject);
		}
		for (long uoid : project.getHasAuthorizedUsers()) {
			newProject.getHasAuthorizedUsers().add(createUser(databaseSession, uoid));
		}
		newProject.setSchema("ifc2x3tc1");
		newProject.setState(bimServer.getSConverter().convertFromSObject(project.getState()));
		databaseSession.store(newProject);
		return newProject;
	}
}