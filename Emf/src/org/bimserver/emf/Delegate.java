//package org.bimserver.emf;
//
///******************************************************************************
// * Copyright (C) 2009-2013  BIMserver.org
// * 
// * This program is free software: you can redistribute it and/or modify
// * it under the terms of the GNU Affero General Public License as
// * published by the Free Software Foundation, either version 3 of the
// * License, or (at your option) any later version.
// * 
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU Affero General Public License for more details.
// * 
// * You should have received a copy of the GNU Affero General Public License
// * along with this program.  If not, see <http://www.gnu.org/licenses/>.
// *****************************************************************************/
//
//import org.eclipse.emf.common.util.EList;
//import org.eclipse.emf.ecore.EStructuralFeature;
//
//public abstract class Delegate {
//	public static enum State {
//		NO_LAZY_LOADING,
//		TO_BE_LOADED,
//		LOADING,
//		LOADED
//	}
//
//	private IfcModelInterface model;
//	private long oid = -1;
//	private int expressId = -1;
//	private int rid;
//	private int pid;
//	private State state = State.NO_LAZY_LOADING;
//	private IdEObject idEObject;
//	private QueryInterface queryInterface;
//
//	public Delegate(IdEObject idEObject, QueryInterface queryInterface) {
//		this.idEObject = idEObject;
//		this.queryInterface = queryInterface;
//	}
//	
//	public IdEObject getIdEObject() {
//		return idEObject;
//	}
//	
//	public long getOid() {
//		return oid;
//	}
//
//	public void setOid(long oid) {
//		this.oid = oid;
//	}
//
//	public int getPid() {
//		return pid;
//	}
//
//	public int getRid() {
//		load();
//		return rid;
//	}
//	
//	public boolean isLoadedOrLoading() {
//		return state != State.TO_BE_LOADED;
//	}
//
//	public void setLoading() {
//		state = State.LOADING;
//	}
//
//	public void loadExplicit() {
//		state = State.LOADING;
//		internalLoad(idEObject);
//		state = State.LOADED;
//	}
//	
//	public void load() {
//		if (!isLoadedOrLoading() && oid != -1) {
//			state = State.LOADING;
//			internalLoad(idEObject);
//			state = State.LOADED;
//		}
//	}
//
//	protected abstract void internalLoad(IdEObject idEObject);
//
//	public void setRid(int rid) {
//		this.rid = rid;
//	}
//
//	public void setPid(int pid) {
//		this.pid = pid;
//	}
//
//	public State getState() {
//		return state;
//	}
//
//	public void setState(State state) {
//		this.state = state;
//	}
//
//	public int getExpressId() {
//		return expressId;
//	}
//
//	public void setExpressId(int expressId) {
//		this.expressId = expressId;
//	}
//
//	public IfcModelInterface getModel() {
//		return model;
//	}
//
//	public void setModel(IfcModelInterface model) throws IfcModelInterfaceException {
//		if (this.model != null) {
//			throw new IfcModelInterfaceException("This object already has a model");
//		}
//		this.model = model;
//	}
//
//	public abstract void loadForEdit();
//
//	public abstract void eUnset(EStructuralFeature eFeature);
//
//	public abstract void eSet(EStructuralFeature eFeature, Object newValue);
//
//	public abstract void eGet(EStructuralFeature eFeature);
//
//	public abstract void eIsSet(EStructuralFeature eFeature);
//
//	public abstract  void eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType);
//
//	public abstract void eGet(EStructuralFeature eFeature, boolean resolve);
//
//	public abstract void eGet(int featureID, boolean resolve, boolean coreType);
//
//	public abstract void eSet(int featureID, Object newValue);
//
//	public void setQueryInterface(QueryInterface queryInterface) {
//		this.queryInterface = queryInterface;
//	}
//	
//	public QueryInterface getQueryInterface() {
//		return queryInterface;
//	}
//
//	public void remove() {
//		this.model.remove(getIdEObject());
//	}
//
//	public <T> EList<T> createList(EList<T> delegate, EStructuralFeature feature) {
//		return delegate;
//	}
//}