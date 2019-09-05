package org.bimserver.emf;

import java.util.UUID;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.InternalSettingDelegateMany;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.InternalSettingDelegateSingleEObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.InternalSettingDelegateSingleEObjectUnsettable;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	public static enum State {
		NO_LAZY_LOADING, TO_BE_LOADED, LOADING, LOADED, OPPOSITE_SETTING
	}

	private long oid = -1;
	private UUID uuid;
	private int pid;
	private int rid;
	private long expressId = -1;
	private IfcModelInterface model;
	private State loadingState = State.NO_LAZY_LOADING;
	private QueryInterface queryInterface;
	private boolean useInverses = true;

	@Override
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	@Override
	public Object dynamicGet(int dynamicFeatureID) {
		load();
		return super.dynamicGet(dynamicFeatureID);
	}

	@Override
	public void dynamicSet(int dynamicFeatureID, Object newValue) {
		super.dynamicSet(dynamicFeatureID, newValue);
	}

	public void useInverses(boolean useInverses) {
		this.useInverses = useInverses;
	}
	
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		super.eSet(eFeature, newValue);
	}

	protected EStructuralFeature.Internal.SettingDelegate eSettingDelegate(EStructuralFeature eFeature) {
		SettingDelegate eSettingDelegate = super.eSettingDelegate(eFeature);
		if (useInverses) {
			return eSettingDelegate;
		}
		if (eFeature instanceof EReference && ((EReference)eFeature).getEOpposite() != null) {
			// TODO cache/pre-generate the objects created in this block
			if (eFeature.isMany()) {
				if (eFeature.isUnsettable()) {
					return new InternalSettingDelegateMany(InternalSettingDelegateMany.EOBJECT_UNSETTABLE, eFeature);
				} else {
					return new InternalSettingDelegateMany(InternalSettingDelegateMany.EOBJECT, eFeature);
				}
			} else {
				if (eFeature.isUnsettable()) {
					return new InternalSettingDelegateSingleEObjectUnsettable((EClass) eFeature.getEType(), eFeature);
				} else {
					return new InternalSettingDelegateSingleEObject((EClass) eFeature.getEType(), eFeature);
				}
			}
		} else {
			return eSettingDelegate;
		}
	}

	public void setModel(IfcModelInterface model) {
		this.model = model;
	}

	@Override
	public int getPid() {
		return this.pid;
	}

	@Override
	public int getRid() {
		if (rid != 0) {
			return rid;
		}
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
			model.load(this);
		}
	}

	public void forceLoad() {
		if (loadingState != State.LOADED && loadingState != State.LOADING && oid != -1) {
			if (model == null) {
				throw new RuntimeException("Object has no model");
			}
			model.load(this);
		}
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

	public long getExpressId() {
		return expressId;
	}

	public void setExpressId(long expressId) {
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
		model.remove(this);
	}

	public void setLoadingState(State state) {
		this.loadingState = state;
	}

	public State getLoadingState() {
		return loadingState;
	}
	
	@Override
	public void eSet(int featureID, Object newValue) {
		if (model != null) {
			model.set(this, eClass().getEStructuralFeature(featureID), newValue);
		}
		super.eSet(featureID, newValue);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
}