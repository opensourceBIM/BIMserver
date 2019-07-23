package org.bimserver.client;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.plugins.ObjectAlreadyExistsException;

public interface GeometryTarget {

	<T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException, ObjectAlreadyExistsException;

	IdEObject get(long geometryInfoOid);

	void add(long geometryInfoOid, IdEObject idEObject) throws IfcModelInterfaceException, ObjectAlreadyExistsException;
}
