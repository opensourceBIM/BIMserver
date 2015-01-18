package org.bimserver;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.Project;
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
			if (users.containsKey(createdById)) {
				newUser.setCreatedBy(users.get(createdById));
			} else {
				newUser.setCreatedBy(createUser(databaseSession, createdById));
			}
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
		public Key(File file, long oid, String comment) {
			this.file = file;
			poid = oid;
			this.comment = comment;
		}
		public File file;
		public long poid;
	}
	
	public void start() {
		try {
			LOGGER.info("Importing...");
			BimServerClientFactory factory = new JsonBimServerClientFactory(bimServer.getMetaDataManager(), address);
			remoteClient = factory.create(new UsernamePasswordAuthenticationInfo(username, password));
			BimDatabase database = bimServer.getDatabase();
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
				e.printStackTrace();
			} finally {
				databaseSession.close();
			}
			BimServerClientInterface client = bimServer.getBimServerClientFactory().create(new UsernamePasswordAuthenticationInfo("admin@bimserver.org", "admin"));
			
			for (SRenderEnginePluginConfiguration renderEnginePluginConfiguration : client.getPluginInterface().getAllRenderEngines(true)) {
				if (renderEnginePluginConfiguration.getName().equals("IFC Engine DLL")) {
					client.getPluginInterface().setDefaultRenderEngine(renderEnginePluginConfiguration.getOid());
				}
			}
			try {
				File incoming = new File(path);
				Map<GregorianCalendar, Key> comments = new TreeMap<>();
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
									comments.put(gregorianCalendar, new Key(file, project.getOid(), revision.getComment()));
									found = true;
									break;
								}
							}
							if (!found) {
								System.out.println("Not found: " + revision.getComment());
							}
						}
					}
				}
				for (GregorianCalendar gregorianCalendar : comments.keySet()) {
					Key key = comments.get(gregorianCalendar);
					System.out.println("Checking in: " + key.file.getName() + " " + Formatters.bytesToString(key.file.length()));
					Project project = projects.get(key.poid);
					SDeserializerPluginConfiguration desserializer = client.getBimsie1ServiceInterface().getSuggestedDeserializerForExtension("ifc", project.getOid());
					try {
						client.checkin(project.getOid(), key.comment, desserializer.getOid(), false, true, key.file);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} finally {
				databaseSession.close();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ChannelConnectionException e) {
			e.printStackTrace();
		} catch (PublicInterfaceNotFoundException e) {
			e.printStackTrace();
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
			newProject.setParent(createProject(databaseSession, project.getParentId()));
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