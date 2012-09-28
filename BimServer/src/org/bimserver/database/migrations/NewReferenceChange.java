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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewReferenceChange implements Change {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewReferenceChange.class);
	private final EReference eReference;
	private final Schema schema;

	public NewReferenceChange(Schema schema, EReference eReference) {
		this.schema = schema;
		this.eReference = eReference;
	}

	@Override
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimserverDatabaseException {
		EClass eClass = eReference.getEContainingClass();
		KeyValueStore keyValueStore = database.getKeyValueStore();
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				RecordIterator recordIterator = keyValueStore.getRecordIterator(subClass.getEPackage().getName() + "_" + subClass.getName(), databaseSession);
				try {
					Record record = recordIterator.next();
					while (record != null) {
						ByteBuffer buffer = ByteBuffer.wrap(record.getValue());
						if (eReference.isMany()) {
							buffer.putShort((short)0);
						} else {
							buffer.putShort((short)-1);
						}
						keyValueStore.store(subClass.getEPackage().getName() + "_" + subClass.getName(), record.getKey(), buffer.array(), databaseSession);
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