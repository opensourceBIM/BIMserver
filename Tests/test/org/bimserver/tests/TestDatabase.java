package org.bimserver.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
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
			Project p = session.get(StorePackage.eINSTANCE.getProject(), poid, false, null);
			User u = session.get(StorePackage.eINSTANCE.getUser(), uoid, false, null);
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
	
	private void removeWithAllOfType() {
		DatabaseSession session = database.createSession();
		try {
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class);
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class);
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
			List<User> users = session.getAllOfType(StorePackage.eINSTANCE.getUser(), User.class);
			for (User user : users) {
				if (user.getName().equals("testuser")) {
					System.out.println(user.getName() + ": " + user.getHasRightsOn());
				}
			}
			List<Project> projects = session.getAllOfType(StorePackage.eINSTANCE.getProject(), Project.class);
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
