package org.bimserver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.BimServerEStore;
import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

public class ServerEStore implements BimServerEStore {

	protected Map<Entry, Object> map = new HashMap<Entry, Object>();
	private DatabaseSession databaseSession;

	public ServerEStore(DatabaseSession databaseSession) {
		this.databaseSession = databaseSession;
	}

	@Override
	public void load(IdEObject idEObject) {
		databaseSession.load(idEObject);
	}

	@Override
	public void remove(IdEObject object) {
	}
	
	@SuppressWarnings({ "unchecked" })
	protected EList<Object> getList(Entry entry) {
		EList<Object> result = (EList<Object>) map.get(entry);
		if (result == null) {
			if (entry.eStructuralFeature.isUnique()) {
				result = new UniqueEList<Object>();
			} else {
				result = new BasicEList<Object>();
			}
			map.put(entry, result);
		}
		return result;
	}

	public Object get(InternalEObject eObject, EStructuralFeature feature, int index) {
		((IdEObject) eObject).load();
		Entry entry = new Entry(eObject, feature);
		if (index == NO_INDEX) {
			return map.get(entry);
		} else {
			return getList(entry).get(index);
		}
	}

	public Object set(InternalEObject eObject, EStructuralFeature feature, int index, Object value) {
		Entry entry = new Entry(eObject, feature);
		if (index == NO_INDEX) {
			return map.put(entry, value);
		} else {
			List<Object> list = getList(entry);
			return list.set(index, value);
		}
	}

	public void add(InternalEObject eObject, EStructuralFeature feature, int index, Object value) {
		try {
			Entry entry = new Entry(eObject, feature);
			getList(entry).add(index, value);
		} catch (Exception e) {
			// DO NOTHING
		}
	}

	public Object remove(InternalEObject eObject, EStructuralFeature feature, int index) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).remove(index);
	}

	public Object move(InternalEObject eObject, EStructuralFeature feature, int targetIndex, int sourceIndex) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).move(targetIndex, sourceIndex);
	}

	public void clear(InternalEObject eObject, EStructuralFeature feature) {
		Entry entry = new Entry(eObject, feature);
		map.remove(entry);
		// getList(entry).clear();
	}

	public boolean isSet(InternalEObject eObject, EStructuralFeature feature) {
		Entry entry = new Entry(eObject, feature);
		return map.containsKey(entry);
	}

	public void unset(InternalEObject eObject, EStructuralFeature feature) {
		Entry entry = new Entry(eObject, feature);
		map.remove(entry);
	}

	public int size(InternalEObject eObject, EStructuralFeature feature) {
		((IdEObject) eObject).load();
		Entry entry = new Entry(eObject, feature);
		return getList(entry).size();
	}

	public int indexOf(InternalEObject eObject, EStructuralFeature feature, Object value) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).indexOf(value);
	}

	public int lastIndexOf(InternalEObject eObject, EStructuralFeature feature, Object value) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).lastIndexOf(value);
	}

	public Object[] toArray(InternalEObject eObject, EStructuralFeature feature) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).toArray();
	}

	public <T> T[] toArray(InternalEObject eObject, EStructuralFeature feature, T[] array) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).toArray(array);
	}

	public boolean isEmpty(InternalEObject eObject, EStructuralFeature feature) {
		((IdEObject) eObject).load();
		Entry entry = new Entry(eObject, feature);
		return getList(entry).isEmpty();
	}

	public boolean contains(InternalEObject eObject, EStructuralFeature feature, Object value) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).contains(value);
	}

	public int hashCode(InternalEObject eObject, EStructuralFeature feature) {
		Entry entry = new Entry(eObject, feature);
		return getList(entry).hashCode();
	}

	public InternalEObject getContainer(InternalEObject eObject) {
		return null;
	}

	public EStructuralFeature getContainingFeature(InternalEObject eObject) {
		throw new UnsupportedOperationException();
	}

	public EObject create(EClass eClass) {
		return null;
//		InternalEObject result = new EStoreEObjectImpl(eClass, this);
//		return result;
	}
}