package org.bimserver;

import java.util.Map;

import org.bimserver.database.DatabaseSession;
import org.bimserver.database.DatabaseSession.SessionState;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IdEObjectImpl.State;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.ifc.IfcModel;

public class ServerIfcModel extends IfcModel {

	private DatabaseSession databaseSession;

	public ServerIfcModel(PackageMetaData packageMetaData, Map<Integer, Long> pidRoidMap, DatabaseSession databaseSession) {
		super(packageMetaData, pidRoidMap);
		this.databaseSession = databaseSession;
	}

	public void load(IdEObject idEObject) {
		if (databaseSession == null) {
			return;
		}
		if (databaseSession.getState() == SessionState.OPEN) {
			((IdEObjectImpl)idEObject).setLoadingState(State.LOADING);
			databaseSession.load(idEObject);
			((IdEObjectImpl)idEObject).setLoadingState(State.LOADED);
		}
	}

//	@SuppressWarnings({ "unchecked" })
//	protected EList<Object> getList(final IdEObject idEObject, EStructuralFeature eStructuralFeature) {
//		Map<EStructuralFeature, Object> objectMap = getObjectMap(idEObject);
//		EList<Object> result = (EList<Object>)objectMap.get(eStructuralFeature);
//		if (result == null) {
//			if (eStructuralFeature.isUnique()) {
//				result = new UniqueEList<Object>(){
//					private static final long serialVersionUID = -1331649607984463166L;
//
//					@Override
//					public int size() {
//						((IdEObject)idEObject).load();
//						return super.size();
//					}
//					
//					@Override
//					public boolean isEmpty() {
//						((IdEObject)idEObject).load();
//						return super.isEmpty();
//					}
//					
//					@Override
//					public Iterator<Object> iterator() {
//						((IdEObject)idEObject).load();
//						return super.iterator();
//					}
//				};
//			} else {
//				result = new BasicEList<Object>(){
//					private static final long serialVersionUID = -2646843411311359243L;
//
//					@Override
//					public int size() {
//						((IdEObject)idEObject).load();
//						return super.size();
//					}
//					
//					@Override
//					public boolean isEmpty() {
//						((IdEObject)idEObject).load();
//						return super.isEmpty();
//					}
//					
//					@Override
//					public Iterator<Object> iterator() {
//						((IdEObject)idEObject).load();
//						return super.iterator();
//					}
//				};
//			}
//			objectMap.put(eStructuralFeature, result);
//		}
//		return result;
//	}
//
//	private Map<EStructuralFeature, Object> getObjectMap(final IdEObject idEObject) {
//		Map<EStructuralFeature, Object> objectMap = map.get(idEObject);
//		if (objectMap == null) {
//			objectMap = new HashMap<EStructuralFeature, Object>();
//			map.put(idEObject, objectMap);
//		}
//		return objectMap;
//	}

//	public Object get(InternalEObject eObject, EStructuralFeature feature, int index) {
//		((IdEObject) eObject).load();
//		if (index == NO_INDEX) {
//			return getObjectMap((IdEObject) eObject).get(feature);
//		} else {
//			return getList((IdEObject) eObject, feature).get(index);
//		}
//	}
//
//	public Object set(InternalEObject eObject, EStructuralFeature feature, int index, Object value) {
//		((IdEObject) eObject).load();
//		if (index == NO_INDEX) {
//			return getObjectMap((IdEObject) eObject).put(feature, value);
//		} else {
//			List<Object> list = getList((IdEObject) eObject, feature);
//			return list.set(index, value);
//		}
//	}

//	public void add(InternalEObject eObject, EStructuralFeature feature, int index, Object value) {
//		((IdEObject) eObject).load();
//		try {
//			getList((IdEObject) eObject, feature).add(index, value);
//		} catch (Exception e) {
//			// DO NOTHING
//		}
//	}
//
//	public Object remove(InternalEObject eObject, EStructuralFeature feature, int index) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).remove(index);
//	}
//
//	public Object move(InternalEObject eObject, EStructuralFeature feature, int targetIndex, int sourceIndex) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).move(targetIndex, sourceIndex);
//	}
//
//	public void clear(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		getObjectMap((IdEObject) eObject).put(feature, null);
//	}
//
//	public boolean isSet(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		return getObjectMap((IdEObject) eObject).containsKey(feature);
//	}
//
//	public void unset(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		getObjectMap((IdEObject) eObject).remove(feature);
//	}
//
//	public int size(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).size();
//	}
//
//	public int indexOf(InternalEObject eObject, EStructuralFeature feature, Object value) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).indexOf(value);
//	}
//
//	public int lastIndexOf(InternalEObject eObject, EStructuralFeature feature, Object value) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).lastIndexOf(value);
//	}
//
//	public Object[] toArray(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).toArray();
//	}
//
//	public <T> T[] toArray(InternalEObject eObject, EStructuralFeature feature, T[] array) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).toArray(array);
//	}
//
//	public boolean isEmpty(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).isEmpty();
//	}
//
//	public boolean contains(InternalEObject eObject, EStructuralFeature feature, Object value) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).contains(value);
//	}
//
//	public int hashCode(InternalEObject eObject, EStructuralFeature feature) {
//		((IdEObject) eObject).load();
//		return getList((IdEObject) eObject, feature).hashCode();
//	}
//
//	public InternalEObject getContainer(InternalEObject eObject) {
//		return null;
//	}
//
//	public EStructuralFeature getContainingFeature(InternalEObject eObject) {
//		throw new UnsupportedOperationException();
//	}
//
//	public EObject create(EClass eClass) {
//		return null;
////		InternalEObject result = new EStoreEObjectImpl(eClass, this);
////		return result;
//	}
	
	@Override
	public void close() throws Exception {
		databaseSession = null;
	}
}