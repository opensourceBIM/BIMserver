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
import java.nio.ByteOrder;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.migrations.NotImplementedException;
import org.bimserver.database.migrations.Schema;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewReferenceChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewReferenceChange.class);
	private final EReference eReference;
	private final Schema schema;
	private int nrFeaturesBefore;

	public NewReferenceChange(Schema schema, int nrFeaturesBefore, EReference eReference) {
		this.schema = schema;
		this.nrFeaturesBefore = nrFeaturesBefore;
		this.eReference = eReference;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimserverDatabaseException {
		EClass eClass = eReference.getEContainingClass();
		KeyValueStore keyValueStore = database.getKeyValueStore();
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				if (subClass.getEAnnotation("nodatabase") == null) {
					RecordIterator recordIterator = keyValueStore.getRecordIterator(subClass.getEPackage().getName() + "_" + subClass.getName(), databaseSession);
					try {
						Record record = recordIterator.next();
						while (record != null) {
							ByteBuffer buffer = ByteBuffer.wrap(record.getValue());

							int nrStartBytesBefore = (int) Math.ceil(nrFeaturesBefore / 8.0);
							int newIndex = nrFeaturesBefore + 1;
							int nrStartBytesAfter = (int) Math.ceil(newIndex / 8.0);
							
							byte[] unsetted = new byte[nrStartBytesAfter];
							buffer.get(unsetted, 0, nrStartBytesBefore);
							
							if (eReference.isUnsettable()) {
								unsetted[newIndex / 8] |= (1 << (newIndex % 8));
							}
							
							int extra = 0;
							
							if (!eReference.isUnsettable()) {
								if (eReference.isMany()) {
									extra = 4;
								} else {
									extra = 2;
								}
							}
							
							ByteBuffer newBuffer = ByteBuffer.allocate(record.getValue().length + (nrStartBytesAfter - nrStartBytesBefore) + extra);
							newBuffer.put(unsetted);
							buffer.position(nrStartBytesBefore);
							newBuffer.put(buffer);
							
							if (!eReference.isUnsettable()) {
								if (eReference.isMany()) {
									newBuffer.putInt(0);
								} else {
									buffer.order(ByteOrder.LITTLE_ENDIAN);
									newBuffer.putShort((short)-1);
									buffer.order(ByteOrder.BIG_ENDIAN);
								}
							}
							
							keyValueStore.store(subClass.getEPackage().getName() + "_" + subClass.getName(), record.getKey(), newBuffer.array(), databaseSession);
							record = recordIterator.next();
						}
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