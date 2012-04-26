package org.bimserver.database;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class ObjectCache {
	private final BiMap<RecordIdentifier, IdEObjectImpl> cache = HashBiMap.create();
	private final BiMap<Long, IdEObjectImpl> oidCache = HashBiMap.create();

	public void put(RecordIdentifier recordIdentifier, IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			if (!oidCache.containsValue(object)) {
				oidCache.put(recordIdentifier.getOid(), (IdEObjectImpl) object);
			}
		} else {
			if (!cache.containsValue(object)) {
				cache.put(recordIdentifier, (IdEObjectImpl) object);
			}
		}
	}
	
	private boolean useRecordLevelVersioning(IdEObject idEObject) {
		return idEObject.eClass().getEPackage() != Ifc2x3tc1Package.eINSTANCE;
	}
	
	public IdEObjectImpl get(RecordIdentifier recordIdentifier) {
		if (recordIdentifier.getPid() == Database.STORE_PROJECT_ID) {
			return oidCache.get(recordIdentifier.getOid());
		} else {
			return cache.get(recordIdentifier);
		}
	}

	public long get(IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			return oidCache.inverse().get(object);
		} else {
			return cache.inverse().get(object).getOid();
		}
	}
	
	public boolean contains(IdEObject object) {
		if (useRecordLevelVersioning(object)) {
			return oidCache.inverse().containsKey(object);
		} else {
			return cache.inverse().containsKey(object);
		}
	}

	public boolean contains(RecordIdentifier recordIdentifier) {
		if (recordIdentifier.getPid() == Database.STORE_PROJECT_ID) {
			return oidCache.containsKey(recordIdentifier.getOid());
		} else {
			return cache.containsKey(recordIdentifier);
		}
	}

	public void clear() {
		cache.clear();
		oidCache.clear();
	}
}