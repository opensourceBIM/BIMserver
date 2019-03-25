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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.migrations.Schema;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
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
			boolean transactional = !(eClass.getEPackage() == Ifc2x3tc1Package.eINSTANCE || eClass.getEPackage() == Ifc4Package.eINSTANCE || eClass.getEPackage() == GeometryPackage.eINSTANCE);
			LOGGER.debug("Creating " + (transactional ? "transactional" : "non transactional") + " table: " + tableName);
			try {
				boolean created = database.createTable(getEClass(), databaseSession, transactional);
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
	
	public void doSchemaChanges(Schema schema) {
		schema.addEClass(eClass);
	}

	public EClass getEClass() {
		return eClass;
	}
}