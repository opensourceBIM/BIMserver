package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.nio.ByteBuffer;

import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.utils.GrowingByteBuffer;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EcorePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewAttributeChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewAttributeChange.class);
	private final EAttribute eAttribute;
	private final Schema schema;

	public NewAttributeChange(Schema schema, EAttribute eAttribute) {
		this.schema = schema;
		this.eAttribute = eAttribute;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimserverDatabaseException {
		EClass eClass = eAttribute.getEContainingClass();
		KeyValueStore keyValueStore = database.getKeyValueStore();
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				RecordIterator recordIterator = keyValueStore.getRecordIterator(subClass.getEPackage().getName() + "_" + subClass.getName(), databaseSession);
				try {
					Record record = recordIterator.next();
					while (record != null) {
						ByteBuffer buffer = ByteBuffer.wrap(record.getValue());
						GrowingByteBuffer growingByteBuffer = new GrowingByteBuffer(buffer);
						growingByteBuffer.position(growingByteBuffer.capacity() - 1);
						if (eAttribute.isMany()) {
							growingByteBuffer.putInt((short)0);
						} else {
							if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEString()) {
								growingByteBuffer.putShort((short)-1);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEInt()) {
								growingByteBuffer.putInt(0);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDouble()) {
								growingByteBuffer.putDouble(0.0);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEFloat()) {
								growingByteBuffer.putFloat(0.0f);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getELong()) {
								growingByteBuffer.putLong(0L);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
								growingByteBuffer.put((byte) 0);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEDate()) {
								growingByteBuffer.putLong(-1L);
							} else if (eAttribute.getEType().getName().equals("Tristate")) {
								growingByteBuffer.putInt(0);
							} else if (eAttribute.getEType() == EcorePackage.eINSTANCE.getEByteArray()) {
								growingByteBuffer.putInt(0);
							} else if (eAttribute.getEType() instanceof EEnum) {
								growingByteBuffer.putInt(-1);
							} else {
								throw new NotImplementedException("Type " + eAttribute.getEType().getName() + " has not been implemented");
							}
						}
						keyValueStore.store(subClass.getEPackage().getName() + "_" + subClass.getName(), record.getKey(), growingByteBuffer.array(), databaseSession);
						record = recordIterator.next();
					}
				} catch (BimserverDatabaseException e) {
					LOGGER.error("", e);
				} finally {
					recordIterator.close();
				}
			} catch (BimserverLockConflictException e) {
				LOGGER.error("", e);
			}
		}
	}
}