package org.bimserver.database.queries;

import java.nio.ByteBuffer;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession.GetResult;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.database.actions.ObjectProvidingStackFrame;
import org.bimserver.database.queries.om.InBoundingBox;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.HashMapWrappedVirtualObject;
import org.bimserver.shared.QueryContext;
import org.bimserver.shared.QueryException;
import org.bimserver.utils.BinUtils;
import org.eclipse.emf.ecore.EClass;

public class QueryBoundingBoxStackFrame extends DatabaseReadingStackFrame implements ObjectProvidingStackFrame {
	private EClass eClass;
	private SearchingRecordIterator typeRecordIterator;
	private Record record;
	private InBoundingBox inBoundingBox;

	public QueryBoundingBoxStackFrame(QueryObjectProvider queryObjectProvider, EClass eClass, QueryPart queryPart, QueryContext reusable, InBoundingBox inBoundingBox) throws BimserverDatabaseException {
		super(reusable, queryObjectProvider, queryPart);
		this.eClass = eClass;
		this.inBoundingBox = inBoundingBox;

		String tableName = eClass.getEPackage().getName() + "_" + eClass.getName();
		if (reusable.getOidCounters() != null) {
			if (!reusable.getOidCounters().containsKey(eClass)) {
				return; // will skip to next one
			}
			long startOid = reusable.getOidCounters().get(eClass);
			ByteBuffer tmp = ByteBuffer.allocate(12);
			tmp.putInt(reusable.getPid());
			tmp.putLong(startOid + 1);
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), tmp.array(), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		} else {
//			LOGGER.warn("Potential too-many-reads");
			typeRecordIterator = queryObjectProvider.getDatabaseSession().getKeyValueStore().getRecordIterator(tableName, BinUtils.intToByteArray(getReusable().getPid()), BinUtils.intToByteArray(getReusable().getPid()), queryObjectProvider.getDatabaseSession());
			record = typeRecordIterator.next();
		}
	}
	
	@Override
	public boolean process() throws BimserverDatabaseException, QueryException {
		if (typeRecordIterator == null) {
			return true;
		}
		if (record == null) {
			currentObject = null;
			typeRecordIterator.close();
			return true;
		}

		currentObject = null;
		
		ByteBuffer nextKeyStart = ByteBuffer.allocate(12);
		getQueryObjectProvider().incReads();
		ByteBuffer keyBuffer = ByteBuffer.wrap(record.getKey());
		int keyPid = keyBuffer.getInt();
		long keyOid = keyBuffer.getLong();
		int keyRid = -keyBuffer.getInt();
		ByteBuffer valueBuffer = ByteBuffer.wrap(record.getValue());
		GetResult map = getMap(eClass, eClass, valueBuffer, keyPid, keyOid, keyRid);
		if (map == GetResult.CONTINUE_WITH_NEXT_OID) {
			nextKeyStart.position(0);
			nextKeyStart.putInt(getReusable().getPid());
			nextKeyStart.putLong(keyOid + 1);
			record = typeRecordIterator.next(nextKeyStart.array());
		} else {
			record = typeRecordIterator.next();
		}

		if (currentObject != null) {
			if (currentObject.has("geometry")) {
				long geometryInfoId = (Long) currentObject.get("geometry");
				HashMapVirtualObject geometryInfo = getByOid(geometryInfoId);
				HashMapWrappedVirtualObject minBounds = (HashMapWrappedVirtualObject) geometryInfo.get("minBounds");
				HashMapWrappedVirtualObject maxBounds = (HashMapWrappedVirtualObject) geometryInfo.get("maxBounds");
				float minX = (float) minBounds.eGet("x");
				float minY = (float) minBounds.eGet("y");
				float minZ = (float) minBounds.eGet("z");
				float maxX = (float) maxBounds.eGet("x");
				float maxY = (float) maxBounds.eGet("y");
				float maxZ = (float) maxBounds.eGet("z");
				if (
						minX > inBoundingBox.getX() &&
						minY > inBoundingBox.getY() &&
						minZ > inBoundingBox.getZ() &&
						maxX < inBoundingBox.getX() + inBoundingBox.getWidth() &&
						maxY < inBoundingBox.getY() + inBoundingBox.getHeight() &&
						maxZ < inBoundingBox.getZ() + inBoundingBox.getDepth()) {
					
				} else {
					currentObject = null;
				}
			} else {
				currentObject = null;
			}
		}
		
		processPossibleIncludes(eClass, getQueryPart());
		
		return false;
	}
	
	public HashMapVirtualObject getCurrentObject() {
		return currentObject;
	}
}
