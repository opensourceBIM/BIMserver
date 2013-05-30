package org.bimserver;

import java.util.Iterator;

import org.bimserver.emf.IdEObjectImpl;
import org.eclipse.emf.common.util.BasicEList;

public class ETestList<E> extends BasicEList<E> {

	private static final long serialVersionUID = -2279268594154682938L;
	private IdEObjectImpl objectImpl;
	
	public ETestList(IdEObjectImpl objectImpl) {
		this.objectImpl = objectImpl;
	}
	
	@Override
	public Iterator<E> iterator() {
		objectImpl.load();
		return super.iterator();
	}
}