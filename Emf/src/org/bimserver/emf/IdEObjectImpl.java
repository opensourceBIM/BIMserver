package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	public static enum State {
		NONE,
		LOADING,
		LOADED
	}

	private IfcModelInterface model;
	private long oid = -1;
	private int rid;
	private int pid;
	private State state = State.NONE;
	private LazyLoader lazyLoader;
	
	@Override
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public void setModel(IfcModelInterface model) throws IfcModelInterfaceException {
		if (this.model != null) {
			throw new IfcModelInterfaceException("This object already has a model");
		}
		this.model = model;
	}

	@Override
	public int getPid() {
		return pid;
	}

	@Override
	public int getRid() {
		load();
		return rid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		load();
		super.eUnset(eFeature);
	}
	
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		load();
		super.eSet(eFeature, newValue);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature) {
		load();
		return super.eGet(eFeature);
	}
	
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		load();
		return super.eIsSet(eFeature);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		load();
		return super.eGet(eFeature, resolve);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
		load();
		return super.eGet(eFeature, resolve, coreType);
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		load();
		return super.eGet(featureID, resolve, coreType);
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		load();
		super.eSet(featureID, newValue);
	}

	public void load() {
		if (!isLoadedOrLoading()) {
			state = State.LOADING;
			lazyLoader.load(this);
			state = State.LOADED;
		}
	}

	public void setLazyLoader(LazyLoader lazyLoader) {
		this.lazyLoader = lazyLoader;
	}

	public void setLoaded() {
		this.state = State.LOADED;
	}
	
	public boolean isLoadedOrLoading() {
		return lazyLoader == null || state != State.NONE;
	}

	public void setLoading() {
		state = State.LOADING;
	}
	
	public State getLoadingState() {
		return state;
	}
	
	public IfcModelInterface getModel() {
		return model;
	}
	
	public boolean hasModel() {
		return getModel() != null;
	}
}