package org.bimserver.emf;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	private long oid = -1;
	private int rid;
	private int pid;
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
	public Object eGet(EStructuralFeature eFeature) {
		if (eFeature instanceof EReference) {
			if (lazyLoader != null) {
				if (!lazyLoader.isLoaded(this, (EReference)eFeature)) {
					eSet(eFeature, lazyLoader.load(this, (EReference)eFeature));
				}
			}
		}
		return super.eGet(eFeature);
	}
}