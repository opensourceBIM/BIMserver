package org.bimserver.database.migrations;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
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
					keyValueStore.createIndexTable(indexTableName, databaseSession);

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
}