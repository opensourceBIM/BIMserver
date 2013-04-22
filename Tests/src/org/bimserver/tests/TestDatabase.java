package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Query;
import org.bimserver.database.berkeley.BerkeleyKeyValueStore;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.database.migrations.InconsistentModelsException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.utils.CollectionUtils;

public class TestDatabase {
	private Database database;
	private File dataDir;
	private KeyValueStore keyValueStore;
	private long poid;
	private long uoid;

	public static void main(String[] args) {
		new TestDatabase().start();
	}

	private void start() {
		try {
			dataDir = new File("database");
			if (dataDir.exists()) {
				try {
					FileUtils.deleteDirectory(dataDir);
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
			} finally {
				database.close();
			}
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		}
	}

	private void removeWithOid() {
		DatabaseSession session = database.createSession();
		try {
			Project p = session.get(StorePackage.eINSTANCE.getProject(), poid, Query.getDefault());
			User u = session.get(StorePackage.eINSTANCE.getUser(), uoid, Query.getDefault());
			if (!u.getHasRightsOn().remove(p)) {
				System.err.println("Not removed");
			}
			session.store(u);
			session.store(p);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unused")
	private void removeWithAllOfType() {
		DatabaseSession session = database.createSession();
		try {
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class, Query.getDefault());
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class, Query.getDefault());
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
		} finally {
			session.close();
		}
	}

	private void checkWithAllOfType() {
		DatabaseSession session = database.createSession();
		try {
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class, Query.getDefault());
			for (User user : users) {
				if (user.getName().equals("testuser")) {
					System.out.println(user.getName() + ": " + user.getHasRightsOn());
				}
			}
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class, Query.getDefault());
			for (Project project : projects) {
				if (project.getName().equals("testproject")) {
					System.out.println(project.getName() + ": " + project.getHasAuthorizedUsers());
				}
			}
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void create() {
		DatabaseSession session = database.createSession();
		try {
			Project project = session.create(StorePackage.eINSTANCE.getProject());
			poid = project.getOid();
			project.setName("testproject");
			User user = session.create(StorePackage.eINSTANCE.getUser());
			uoid = user.getOid();
			user.setName("testuser");
			project.getHasAuthorizedUsers().add(user);
			session.commit();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private void init() throws DatabaseInitException {
		keyValueStore = new BerkeleyKeyValueStore(dataDir);
		database = new Database(null, CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), keyValueStore);
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
