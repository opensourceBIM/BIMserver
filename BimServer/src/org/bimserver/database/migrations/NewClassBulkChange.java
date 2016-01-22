package org.bimserver.database.migrations;

import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewClassBulkChange implements Change {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewClassChange.class);
	private final Set<EClass> eClasses;
	private final EPackage ePackage;

	public NewClassBulkChange(EPackage ePackage, Set<EClass> eClasses) {
		this.ePackage = ePackage;
		this.eClasses = eClasses;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws BimserverDatabaseException {
		LOGGER.info("Creating " + eClasses.size() + " tables for package " + ePackage.getName());
		for (EClass eClass : eClasses) {
			String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
			if (eClass.getEAnnotation("nodatabase") == null) {
				try {
					boolean created = database.createTable(eClass, databaseSession);
					if (!created) {
						throw new BimserverDatabaseException("Could not create table " + tableName);
					}
//				for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
//					if (eStructuralFeature.getEAnnotation("index") != null) {
//						database.createIndexTable(eClass, eStructuralFeature, databaseSession);
//					}
//				}
				} catch (BimserverLockConflictException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
}
