package org.bimserver.ifc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TracingGarbageCollector {
	private static final Logger LOGGER = LoggerFactory.getLogger(TracingGarbageCollector.class);
	private final IfcModel ifcModel;
	private final Set<IdEObject> referencedObjects = new HashSet<IdEObject>();
	private final SchemaDefinition schema;

	public TracingGarbageCollector(IfcModel ifcModel, SchemaDefinition schema) {
		this.ifcModel = ifcModel;
		this.schema = schema;
	}

	@SuppressWarnings("rawtypes")
	public void mark(Set<? extends IdEObject> rootObjects) {
		referencedObjects.addAll(rootObjects);
		for (IdEObject rootObject : rootObjects) {
			for (EReference eReference : rootObject.eClass().getEAllReferences()) {
				Attribute attributeBNWithSuper = null;
				if (schema != null) {
					EntityDefinition entityBN = schema.getEntityBN(rootObject.eClass().getName());
					if (entityBN == null) {
						System.out.println(rootObject.eClass().getName() + " not found");
					} else {
						attributeBNWithSuper = entityBN.getAttributeBNWithSuper(eReference.getName());
						if (attributeBNWithSuper == null) {
							System.out.println(eReference.getName() + " not found");
						}
					}
				}
				if (schema == null || !(attributeBNWithSuper instanceof InverseAttribute)) {
					Object referredObject = rootObject.eGet(eReference);
					if (eReference.isMany()) {
						List list = (List) referredObject;
						for (Object o : list) {
							if (!referencedObjects.contains(o)) {
								mark(makeSet((IdEObject) o));
							}
						}
					} else {
						IdEObject referredIdEObject = (IdEObject) referredObject;
						if (referredIdEObject != null) {
							if (!referencedObjects.contains(referredObject)) {
								mark(makeSet(referredIdEObject));
							}
						}
					}
				}
			}
		}
	}

	private Set<? extends IdEObject> makeSet(IdEObject idEObject) {
		Set<IdEObject> set = new HashSet<IdEObject>();
		set.add(idEObject);
		return set;
	}
	
	public void sweep() {
		Map<Long, IdEObject> objects = ifcModel.getObjects();
		Iterator<Long> iterator = objects.keySet().iterator();
		int removed = 0;
		while (iterator.hasNext()) {
			Long next = iterator.next();
			IdEObject idEObject = objects.get(next);
			if (!referencedObjects.contains(idEObject)) {
				removed++;
				iterator.remove();
			}
		}
		LOGGER.info(removed + " objects swept");
	}
}