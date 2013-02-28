package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import org.bimserver.emf.Delegate.State;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	private Delegate delegate;
	
	@Override
	public long getOid() {
		return getDelegate().getOid();
	}

	public void setOid(long oid) {
		getDelegate().setOid(oid);
	}

	public void setModel(IfcModelInterface model) throws IfcModelInterfaceException {
		getDelegate().setModel(model);
	}

	public Delegate getDelegate() {
		if (delegate == null) {
			delegate = new DefaultDelegate(this, null);
		}
		return delegate;
	}
	
	@Override
	public int getPid() {
		return getDelegate().getPid();
	}

	@Override
	public int getRid() {
		return getDelegate().getRid();
	}

	public void setPid(int pid) {
		getDelegate().setPid(pid);
	}

	public void setRid(int rid) {
		getDelegate().setRid(rid);
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		getDelegate().eUnset(eFeature);
		super.eUnset(eFeature);
	}
	
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		getDelegate().eSet(eFeature, newValue);
		super.eSet(eFeature, newValue);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature) {
		getDelegate().eGet(eFeature);
		return super.eGet(eFeature);
	}
	
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		getDelegate().eIsSet(eFeature);
		return super.eIsSet(eFeature);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		getDelegate().eGet(eFeature, resolve);
		return super.eGet(eFeature, resolve);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
		getDelegate().eGet(eFeature, resolve, coreType);
		return super.eGet(eFeature, resolve, coreType);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		getDelegate().eGet(featureID, resolve, coreType);
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		getDelegate().eSet(featureID, newValue);
		super.eSet(featureID, newValue);
	}

	public void load() {
		if (getDelegate() != null) {
			getDelegate().load();
		}
	}

	public void loadExplicit() {
		if (getDelegate() != null) {
			getDelegate().loadExplicit();
		}
	}
	
	public void loadForEdit() {
		if (getDelegate() != null) {
			getDelegate().loadForEdit();
		}
	}
	
	public void setLoaded() {
		getDelegate().setState(State.LOADED);
	}

	public State getLoadingState() {
		return getDelegate().getState();
	}
	
	public IfcModelInterface getModel() {
		return getDelegate().getModel();
	}
	
	public boolean hasModel() {
		return getModel() != null;
	}

	public int getExpressId() {
		return getDelegate().getExpressId();
	}

	public void setExpressId(int expressId) {
		this.getDelegate().setExpressId(expressId);
	}

	public boolean isLoadedOrLoading() {
		return getDelegate().isLoadedOrLoading();
	}

	public void setLoading() {
		getDelegate().setLoading();
	}

	public void setDelegate(Delegate delegate) {
		this.delegate = delegate;
	}

	public void setQueryInterface(QueryInterface queryInterface) {
		getDelegate().setQueryInterface(queryInterface);
	}

	public QueryInterface getQueryInterface() {
		return getDelegate().getQueryInterface();
	}
	
	public void remove() {
		delegate.remove();
	}

	public void setState(State state) {
		this.getDelegate().setState(state);
	}
}