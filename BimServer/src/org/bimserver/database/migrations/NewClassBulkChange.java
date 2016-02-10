package org.bimserver.database.migrations;

import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
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
		boolean transactional = !(ePackage.getName().equals(Ifc2x3tc1Package.eINSTANCE.getName()) || ePackage.getName().equals(Ifc4Package.eINSTANCE.getName()));
		LOGGER.info("Creating " + eClasses.size() + " " + (transactional ? "transactional" : "non transactional")  + " tables for package " + ePackage.getName());
		for (EClass eClass : eClasses) {
			String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
			if (eClass.getEAnnotation("nodatabase") == null) {
				try {
					boolean created = database.createTable(eClass, databaseSession, transactional);
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
