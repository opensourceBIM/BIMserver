package org.bimserver.database.migrations;

import java.nio.ByteBuffer;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.ColumnDatabase;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
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
	public void change(Database database, DatabaseSession databaseSession) throws NotImplementedException, BimDatabaseException {
		EClass eClass = eAttribute.getEContainingClass();
		ColumnDatabase columnDatabase = database.getColumnDatabase();
		for (EClass subClass : schema.getSubClasses(eClass)) {
			try {
				RecordIterator recordIterator = columnDatabase.getRecordIterator(subClass.getName(), databaseSession);
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
						columnDatabase.store(subClass.getName(), record.getKey(), growingByteBuffer.array(), databaseSession);
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