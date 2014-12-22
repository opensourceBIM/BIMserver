package org.bimserver.emf;

import java.util.Iterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl.BasicEStoreEList;

public class SpecialList extends BasicEStoreEList<Object>{
	private static final long serialVersionUID = 6865419120828460240L;

	public SpecialList(InternalEObject owner, EStructuralFeature eStructuralFeature) {
		super(owner, eStructuralFeature);
	}
	
	public boolean addNoOppositeLoading(Object object) {
		return add(object);
//		if (isUnique() && contains(object)) {
//			return false;
//		} else {
//			addNoOppositeLoadingUnique(object);
//			return true;
//		}
	}
	
	public void addNoOppositeLoadingUnique(Object object) {
		addUnique(object);
//		if (isNotificationRequired()) {
//			int index = size();
//			boolean oldIsSet = isSet();
//			doAddUnique(index, object);
//			NotificationImpl notification = createNotification(Notification.ADD, null, object, index, oldIsSet);
//			dispatchNotification(notification);
//		} else {
//			doAddUnique(object);
//		}
	}

	@Override
	public boolean add(Object object) {
		return super.add(object);
	}
	
	@Override
	public void addUnique(Object object) {
		super.addUnique(object);
	}
	
	@Override
	public int size() {
		((IdEObjectImpl)owner).load();
		return super.size();
	}
	
	@Override
	public boolean isEmpty() {
		((IdEObjectImpl)owner).load();
		return super.isEmpty();
	}
	
	@Override
	public Iterator<Object> iterator() {
		((IdEObjectImpl)owner).load();
		return super.iterator();
	}
}
