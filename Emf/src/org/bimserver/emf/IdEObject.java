package org.bimserver.emf;

import org.eclipse.emf.ecore.EObject;

public interface IdEObject extends EObject {
	void setOid(long oid);
	long getOid();
	void setRid(int rid);
	int getRid();
	void setPid(int pid);
	int getPid();
	void setLazyLoader(LazyLoader lazyLoader);
	void setLoaded();
	void load();
	boolean isLoadedOrLoading();
	void setLoading();
}