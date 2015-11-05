package org.bimserver.database.migrations;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.ecore.EClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewClassChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewClassChange.class);
	private final EClass eClass;

	public NewClassChange(EClass eClass) {
		this.eClass = eClass;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws BimserverDatabaseException {
		String tableName = getEClass().getEPackage().getName() + "_" + getEClass().getName();
		if (eClass.getEAnnotation("nodatabase") == null) {
			LOGGER.info("Creating table: " + tableName);
			try {
				boolean created = database.createTable(getEClass(), databaseSession);
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

	public EClass getEClass() {
		return eClass;
	}
}