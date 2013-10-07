package org.bimserver.emf;

import org.eclipse.emf.ecore.EClass;

public interface ObjectFactory {

	<T extends IdEObject> T create(Class<T> clazz) throws IfcModelInterfaceException;
	<T extends IdEObject> T create(EClass eClass) throws IfcModelInterfaceException;
}