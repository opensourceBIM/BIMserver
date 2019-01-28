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

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.migrations.NotImplementedException;
import org.bimserver.database.migrations.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddIndexChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddIndexChange.class);
	private EStructuralFeature eStructuralFeature;
	private Schema schema;

	public AddIndexChange(Schema schema, EStructuralFeature eStructuralFeature) {
		this.schema = schema;
		this.eStructuralFeature = eStructuralFeature;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimserverDatabaseException {
		EClass eClass = eStructuralFeature.getEContainingClass();
		KeyValueStore keyValueStore = database.getKeyValueStore();
		
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				if (subClass.getEAnnotation("nodatabase") == null) {
					String indexTableName = subClass.getEPackage().getName() + "_" + subClass.getName() + "_" + eStructuralFeature.getName();
					boolean transactional = !(subClass.getEPackage() == Ifc4Package.eINSTANCE || subClass.getEPackage() == Ifc2x3tc1Package.eINSTANCE);
					keyValueStore.createIndexTable(indexTableName, databaseSession, transactional);

					RecordIterator recordIterator = keyValueStore.getRecordIterator(subClass.getEPackage().getName() + "_" + subClass.getName(), databaseSession);
					try {
						Record record = recordIterator.next();
						while (record != null) {
							ByteBuffer buffer = ByteBuffer.wrap(record.getValue());

							byte[] featureBytes = databaseSession.extractFeatureBytes(databaseSession, buffer, subClass, eStructuralFeature);
							if (featureBytes != null) {
								keyValueStore.store(indexTableName, featureBytes, record.getKey(), databaseSession);
							}
							
							record = recordIterator.next();
						}
					} catch (BimserverDatabaseException e) {
						LOGGER.error("", e);
					} finally {
						recordIterator.close();
					}
				}
			} catch (BimserverLockConflictException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public void doSchemaChanges(Schema schema) {
		
	}
}