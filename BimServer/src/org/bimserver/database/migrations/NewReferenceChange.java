package org.bimserver.database.migrations;

import java.nio.ByteBuffer;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
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
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimDatabaseException {
		EClass eClass = eReference.getEContainingClass();
		ColumnDatabase columnDatabase = database.getColumnDatabase();
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				RecordIterator recordIterator = columnDatabase.getRecordIterator(subClass.getName(), databaseSession);
				try {
					Record record = recordIterator.next();
					while (record != null) {
						ByteBuffer buffer = ByteBuffer.wrap(record.getValue());
						if (eReference.isMany()) {
							buffer.putShort((short)0);
						} else {
							buffer.putShort((short)-1);
						}
						columnDatabase.store(subClass.getName(), record.getKey(), buffer.array(), databaseSession);
						record = recordIterator.next();
					}
				} catch (BimDatabaseException e) {
					LOGGER.error("", e);
				} finally {
					recordIterator.close();
				}
			} catch (BimDeadlockException e) {
				LOGGER.error("", e);
			}
		}
	}
}