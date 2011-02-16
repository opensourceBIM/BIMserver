package org.bimserver.emf;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	private static enum State {
		NONE,
		LOADING,
		LOADED
	}
	
	private long oid = -1;
	private int rid;
	private int pid;
	private State state = State.NONE;
	private LazyLoader lazyLoader;
	
	@Override
	public long getOid() {
		return oid;
	}

	@Override
	public void setOid(long oid) {
		this.oid = oid;
	}

	@Override
	public int getPid() {
		return pid;
	}

	@Override
	public int getRid() {
		return rid;
	}

	@Override
	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
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

	@Override
	public void setLazyLoader(LazyLoader lazyLoader) {
		this.lazyLoader = lazyLoader;
	}

	@Override
	public void setLoaded() {
		this.state = State.LOADED;
	}
	
	public boolean isLoadedOrLoading() {
		return lazyLoader == null || state != State.NONE;
	}

	@Override
	public void setLoading() {
		state = State.LOADING;
	}
}