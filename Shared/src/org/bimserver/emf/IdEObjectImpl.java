package org.bimserver.emf;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EStoreEObjectImpl;

public class IdEObjectImpl extends EStoreEObjectImpl implements IdEObject {

	public static enum State {
		NO_LAZY_LOADING, TO_BE_LOADED, LOADING, LOADED, OPPOSITE_SETTING
	}

	private long oid = -1;
	private int pid;
	private int rid;
	private int expressId = -1;
	private IfcModelInterface model;
	private State loadingState = State.NO_LAZY_LOADING;
	private QueryInterface queryInterface;

	public IdEObjectImpl() {
		eSetStore(new DefaultBimServerEStore());
	}
	
	@Override
	public long getOid() {
		return oid;
	}

	@Override
	protected EList<?> createList(EStructuralFeature eStructuralFeature) {
		return new BasicEStoreEList<Object>(this, eStructuralFeature){
			private static final long serialVersionUID = 6865419120828460240L;

			@Override
			public int size() {
				load();
				return super.size();
			}
			
			@Override
			public boolean isEmpty() {
				load();
				return super.isEmpty();
			}
			
			@Override
			public Iterator<Object> iterator() {
				load();
				return super.iterator();
			}
		};
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}

	public void setModel(IfcModelInterface model) throws IfcModelInterfaceException {
		this.model = model;
	}

	@Override
	public int getPid() {
		return this.pid;
	}

	@Override
	public int getRid() {
		load();
		return this.rid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public void load() {
		if (loadingState == State.TO_BE_LOADED && oid != -1) {
			loadExplicit();
		}
	}

	public void loadExplicit() {
		setLoadingState(State.LOADING);
		internalLoad();
		setLoadingState(State.LOADED);
	}

	private void internalLoad() {
		((BimServerEStore)eStore).load(this);
	}

	public void setLoaded() {
		setLoadingState(State.LOADED);
	}

	public IfcModelInterface getModel() {
		return model;
	}

	public boolean hasModel() {
		return getModel() != null;
	}

	public int getExpressId() {
		return expressId;
	}

	public void setExpressId(int expressId) {
		this.expressId = expressId;
	}

	public boolean isLoadedOrLoading() {
		return loadingState != State.TO_BE_LOADED;
	}

	public void setLoading() {
		setLoadingState(State.LOADING);
	}

	public void setQueryInterface(QueryInterface queryInterface) {
		this.queryInterface = queryInterface;
		if (queryInterface == null || queryInterface.isDeep()) {
			setLoadingState(State.NO_LAZY_LOADING);
		} else {
			setLoadingState(State.TO_BE_LOADED);
		}
	}

	public QueryInterface getQueryInterface() {
		return queryInterface;
	}

	public void remove() {
		((BimServerEStore)eStore).remove(this);
	}

	public void setLoadingState(State state) {
		this.loadingState = state;
	}

	public State getLoadingState() {
		return loadingState;
	}
}