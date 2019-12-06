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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.utils.CollectionUtils;
import org.bimserver.utils.PathUtils;

public class TestDatabase {
	private Database database;
	private Path dataDir;
	private KeyValueStore keyValueStore;
	private long poid;
	private long uoid;

	public static void main(String[] args) {
		new TestDatabase().start();
	}

	private void start() {
		try {
			dataDir = Paths.get("database");
			if (Files.exists(dataDir)) {
				try {
					PathUtils.removeDirectoryWithContent(dataDir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			init();
			try {
				create();
				checkWithAllOfType();
				removeWithOid();
				checkWithAllOfType();
				checkLists();
				checkLists2();
				checkLists3();
			} finally {
				database.close();
			}
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		}
	}
	
	private void checkLists2() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		long uoid = -1;
		try {
			User user = session.create(User.class);
			UserSettings userSettings = session.create(UserSettings.class);
			SerializerPluginConfiguration serializerPluginConfiguration = session.create(SerializerPluginConfiguration.class);
			user.setUserSettings(userSettings);
			uoid = user.getOid();
			serializerPluginConfiguration.setUserSettings(userSettings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
			session = database.createSession(OperationType.READ_WRITE);
			try {
				User user = session.get(uoid, OldQuery.getDefault());
				UserSettings userSettings = user.getUserSettings();
				List<SerializerPluginConfiguration> serializers = userSettings.getSerializers();
				for (SerializerPluginConfiguration serializerPluginConfiguration : serializers) {
					System.out.println(serializerPluginConfiguration);
				}
			} catch (BimserverDatabaseException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
	
	private void checkLists3() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		long xid = -1;
		try {
			User user = session.create(User.class);
			UserSettings userSettings = session.create(UserSettings.class);
			SerializerPluginConfiguration serializerPluginConfiguration1 = session.create(SerializerPluginConfiguration.class);
			SerializerPluginConfiguration serializerPluginConfiguration2 = session.create(SerializerPluginConfiguration.class);
			xid = serializerPluginConfiguration2.getOid();
			user.setUserSettings(userSettings);
			serializerPluginConfiguration1.setUserSettings(userSettings);
			serializerPluginConfiguration2.setUserSettings(userSettings);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
			session = database.createSession(OperationType.READ_WRITE);
			try {
				SerializerPluginConfiguration p1 = session.get(xid, OldQuery.getDefault());
				UserSettings userSettings = p1.getUserSettings();
				for (SerializerPluginConfiguration p2 : userSettings.getSerializers()) {
					System.out.println(p2.getOid() + " - " + p2);
				}
			} catch (BimserverDatabaseException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
	
	private void checkLists() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		long uoid = -1;
		try {
			Project p1 = session.create(Project.class);
			p1.setName("p1");
			Project p2 = session.create(Project.class);
			p2.setName("p2");
			User u1 = session.create(User.class);
			uoid = u1.getOid();
			p1.getHasAuthorizedUsers().add(u1);
			p2.getHasAuthorizedUsers().add(u1);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
			session = database.createSession(OperationType.READ_WRITE);
			try {
				User user = session.get(uoid, OldQuery.getDefault());
				for (Project p : user.getHasRightsOn()) {
					System.out.println(p.getName());
				}
			} catch (BimserverDatabaseException e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	private void removeWithOid() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		try {
			Project p = session.get(StorePackage.eINSTANCE.getProject(), poid, OldQuery.getDefault());
			User u = session.get(StorePackage.eINSTANCE.getUser(), uoid, OldQuery.getDefault());
			if (!u.getHasRightsOn().remove(p)) {
				System.err.println("Not removed");
			}
			session.store(u);
			session.store(p);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unused")
	private void removeWithAllOfType() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		try {
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class, OldQuery.getDefault());
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class, OldQuery.getDefault());
			Project p = null;
			for (Project project : projects) {
				if (project.getName().equals("testproject")) {
					p = project;
					break;
				}
			}
			for (User user : users) {
				if (user.getName().equals("testuser")) {
					if (!user.getHasRightsOn().remove(p)) {
						System.err.println("No project removed");
					}
					session.store(user);
				}
			}
			session.store(p);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void checkWithAllOfType() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		try {
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class, OldQuery.getDefault());
			for (User user : users) {
				if (user.getName().equals("testuser")) {
					System.out.println(user.getName() + ": " + user.getHasRightsOn());
				}
			}
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class, OldQuery.getDefault());
			for (Project project : projects) {
				if (project.getName().equals("testproject")) {
					System.out.println(project.getName() + ": " + project.getHasAuthorizedUsers());
				}
			}
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void create() {
		DatabaseSession session = database.createSession(OperationType.READ_WRITE);
		try {
			Project project = session.create(Project.class);
			poid = project.getOid();
			project.setName("testproject");
			User user = session.create(User.class);
			uoid = user.getOid();
			user.setName("testuser");
			project.getHasAuthorizedUsers().add(user);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void init() throws DatabaseInitException {
		keyValueStore = new BerkeleyKeyValueStore(dataDir, null);
		database = new Database(null, CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), keyValueStore, null);
		try {
			database.init();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			database.close();
			init();
		} catch (InconsistentModelsException e) {
			e.printStackTrace();
		}
	}
}
