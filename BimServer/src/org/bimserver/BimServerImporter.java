package org.bimserver;

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
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
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
import org.bimserver.shared.UsernamePasswordAuthenticationInfo;
import org.bimserver.shared.exceptions.BimServerClientException;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.utils.Formatters;
import org.bimserver.utils.PathUtils;
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
		public Path file;
		public long poid;

		public Key(Path file, long oid, String comment, Date date, long userId) {
			this.file = file;
			poid = oid;
			this.comment = comment;
			this.date = date;
			this.userId = userId;
		}
	}
	
	public void start() {
		try (BimServerClientFactory factory = new JsonBimServerClientFactory(bimServer.getMetaDataManager(), address)) {
			LOGGER.info("Importing...");
			remoteClient = factory.create(new UsernamePasswordAuthenticationInfo(username, password));
			final BimDatabase database = bimServer.getDatabase();
			DatabaseSession databaseSession = database.createSession(OperationType.POSSIBLY_WRITE);
			try {
				LOGGER.info("Users...");
				for (SUser user : remoteClient.getServiceInterface().getAllUsers()) {
					createUser(databaseSession, user.getOid());
				}
				LOGGER.info("Projects...");
				for (SProject project : remoteClient.getServiceInterface().getAllProjects(false, false)) {
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
			Path incoming = Paths.get(path);
			final Map<GregorianCalendar, Key> comments = new TreeMap<>();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			for (SProject project : remoteClient.getServiceInterface().getAllProjects(false, false)) {
				for (SRevision revision : remoteClient.getServiceInterface().getAllRevisionsOfProject(project.getOid())) {
					GregorianCalendar gregorianCalendar = new GregorianCalendar();
					gregorianCalendar.setTime(revision.getDate());
					if (!revision.getComment().startsWith("generated for")) {
						User user = users.get(revision.getUserId());
						Path userFolder = incoming.resolve(user.getUsername());
						boolean found = false;
						for (Path file : PathUtils.list(userFolder)) {
							if (file.getFileName().toString().endsWith(revision.getComment())) {
								String dateStr = file.getFileName().toString().substring(0, 19);
								Date parse = dateFormat.parse(dateStr);
								GregorianCalendar fileDate = new GregorianCalendar();
								fileDate.setTime(parse);
								long millisDiff = Math.abs(fileDate.getTimeInMillis() - revision.getDate().getTime());
								if (millisDiff > 1000 * 60 * 120) { // 120 minutes
									continue;
								}
								
								if (revision.getOid() == project.getLastRevisionId()) {
									comments.put(gregorianCalendar, new Key(file, project.getOid(), revision.getComment(), revision.getDate(), revision.getUserId()));
								}
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
						LOGGER.info("Checking in: " + key.file.getFileName().toString() + " " + Formatters.bytesToString(key.file.toFile().length()));
						Project sProject = projects.get(key.poid);
						try {
							SDeserializerPluginConfiguration desserializer = client.getServiceInterface().getSuggestedDeserializerForExtension("ifc", sProject.getOid());
							client.checkinSync(sProject.getOid(), key.comment, desserializer.getOid(), false, key.file);
							SProject updatedProject = client.getServiceInterface().getProjectByPoid(sProject.getOid());
							DatabaseSession databaseSession = database.createSession(OperationType.POSSIBLY_WRITE);
							try {
								LOGGER.info("Done");
								Project project = databaseSession.get(updatedProject.getOid(), OldQuery.getDefault());
								Revision revision = project.getLastRevision();
								User user = (User)databaseSession.get(users.get(key.userId).getOid(), OldQuery.getDefault());
								for (Revision otherRevision : revision.getConcreteRevisions().get(0).getRevisions()) {
									otherRevision.load();
									otherRevision.setDate(key.date);
									otherRevision.setComment(otherRevision.getComment().replace("Administrator", user.getName()));
									databaseSession.store(otherRevision);
								}
								DateFormat m = new SimpleDateFormat("dd-MM-yyyy");
								LOGGER.info("Setting date to " + m.format(key.date));
								revision.setUser(user);
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
		} catch (IOException e) {
			LOGGER.error("", e);
		} catch (BimServerClientException e1) {
			LOGGER.error("", e1);
		} catch (Exception e2) {
			LOGGER.error("", e2);
		}
	}

	private Project createProject(DatabaseSession databaseSession, long poid) throws BimserverDatabaseException, ServerException, UserException, PublicInterfaceNotFoundException {
		SProject project = remoteClient.getServiceInterface().getProjectByPoid(poid);
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