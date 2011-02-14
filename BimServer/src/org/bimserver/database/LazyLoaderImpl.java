package org.bimserver.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.LazyLoader;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class LazyLoaderImpl implements LazyLoader {
	private final Map<EObject, Set<EReference>> loaded = new HashMap<EObject, Set<EReference>>();
	private final Map<EObject, Map<EReference, Object>> notLoaded = new HashMap<EObject, Map<EReference,Object>>();
	private DatabaseSession databaseSession;

	@Override
	public boolean isLoaded(IdEObjectImpl idEObjectImpl, EReference eFeature) {
		return loaded.containsKey(idEObjectImpl) && loaded.get(idEObjectImpl).contains(eFeature);
	}

	@Override
	public Object load(IdEObjectImpl idEObjectImpl, EReference eFeature) {
		return null;
	}
}
