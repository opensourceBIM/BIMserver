package org.bimserver.emf;

import org.eclipse.emf.ecore.EReference;

public interface LazyLoader {

	boolean isLoaded(IdEObjectImpl idEObjectImpl, EReference eFeature);

	Object load(IdEObjectImpl idEObjectImpl, EReference eFeature);
}