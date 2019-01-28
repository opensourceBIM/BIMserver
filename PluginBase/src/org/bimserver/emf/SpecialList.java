package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

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
