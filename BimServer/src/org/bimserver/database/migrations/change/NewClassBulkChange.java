package org.bimserver.database.migrations.change;

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

import java.util.Set;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Schema;
import org.bimserver.models.geometry.GeometryPackage;
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
		boolean transactional = !(ePackage == Ifc2x3tc1Package.eINSTANCE || ePackage == Ifc4Package.eINSTANCE || ePackage == GeometryPackage.eINSTANCE);
		LOGGER.debug("Creating " + eClasses.size() + " " + (transactional ? "transactional" : "non transactional")  + " tables for package " + ePackage.getName());
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
	
	public void doSchemaChanges(Schema schema) {
		for (EClass eClass : eClasses) {
			schema.addEClass(eClass);
		}
	}
}
