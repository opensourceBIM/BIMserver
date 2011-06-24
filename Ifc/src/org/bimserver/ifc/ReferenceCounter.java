package org.bimserver.ifc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.ecore.EReference;

public class ReferenceCounter {
	
	public static abstract class Reference {
		private final IdEObject idEObject;
		private final EReference eReference;
		private final IdEObject referredObject;

		public Reference(IdEObject idEObject, IdEObject referredObject, EReference eReference) {
			this.idEObject = idEObject;
			this.referredObject = referredObject;
			this.eReference = eReference;
		}

		public IdEObject getIdEObject() {
			return idEObject;
		}

		public EReference geteReference() {
			return eReference;
		}

		public abstract Reference reAttach(IdEObject mainObject);

		public IdEObject getReferredObject() {
			return referredObject;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((eReference == null) ? 0 : eReference.hashCode());
			result = prime * result + ((idEObject == null) ? 0 : idEObject.hashCode());
			result = prime * result + ((referredObject == null) ? 0 : referredObject.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reference other = (Reference) obj;
			if (eReference == null) {
				if (other.eReference != null)
					return false;
			} else if (!eReference.equals(other.eReference))
				return false;
			if (idEObject == null) {
				if (other.idEObject != null)
					return false;
			} else if (!idEObject.equals(other.idEObject))
				return false;
			if (referredObject == null) {
				if (other.referredObject != null)
					return false;
			} else if (!referredObject.equals(other.referredObject))
				return false;
			return true;
		}
	}
	
	public static class SingleReference extends Reference {
		
		public SingleReference(IdEObject idEObject, IdEObject referredObject, EReference eReference) {
			super(idEObject, referredObject, eReference);
		}

		@Override
		public Reference reAttach(IdEObject mainObject) {
			getIdEObject().eSet(geteReference(), mainObject);
			return new SingleReference(getIdEObject(), mainObject, geteReference());
		}
	}
	
	public static class MultiReference extends Reference {

		public MultiReference(IdEObject idEObject, IdEObject referredObject, EReference eReference) {
			super(idEObject, referredObject, eReference);
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Reference reAttach(IdEObject mainObject) {
			List list = (List)getIdEObject().eGet(geteReference());
			list.remove(getReferredObject());
			list.add(mainObject);
			return new SingleReference(getIdEObject(), mainObject, geteReference());
		}
	}
	
	private final Map<IdEObject, Set<Reference>> references = new HashMap<IdEObject, Set<Reference>>();
	private final IfcModelInterface ifcModel;

	public ReferenceCounter(IfcModelInterface ifcModel) {
		this.ifcModel = ifcModel;
	}

	@SuppressWarnings("rawtypes")
	public void updateReferences() {
		references.clear();
		for (IdEObject idEObject : ifcModel.getValues()) {
			for (EReference eReference : idEObject.eClass().getEAllReferences()) {
				if (eReference.isMany()) {
					List list = (List)idEObject.eGet(eReference);
					for (Object o : list) {
						if (!references.containsKey(o)) {
							references.put((IdEObject) o, new HashSet<Reference>());
						}
						references.get(o).add(new MultiReference(idEObject, (IdEObject) o, eReference));
					}
				} else {
					Object o = idEObject.eGet(eReference);
					if (!references.containsKey(o)) {
						references.put((IdEObject) o, new HashSet<Reference>());
					}
					references.get(o).add(new SingleReference(idEObject, (IdEObject) o, eReference));
				}
			}
		}
	}
	
	public void remove(IdEObject idEObject) {
		int totalRemoved = removeInternal(idEObject);
		System.out.println("Removing " + idEObject + " (" + totalRemoved + ")");
	}
	
	@SuppressWarnings("rawtypes")
	public int removeInternal(IdEObject idEObject) {
		int totalRemoved = 1;
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			if (eReference.isMany()) {
				List list = (List)idEObject.eGet(eReference);
				for (Object o : list) {
					IdEObject refObject = (IdEObject)o;
					references.get(refObject).remove(idEObject);
					if (references.get(refObject).size() == 0) {
						totalRemoved += removeInternal(refObject);
					}
				}
			} else {
				IdEObject refObject = (IdEObject) idEObject.eGet(eReference);
				if (references.containsKey(refObject)) {
					references.get(refObject).remove(idEObject);
					if (references.get(refObject).size() == 0) {
						totalRemoved += removeInternal(refObject);
					}
				}
			}
		}
		return totalRemoved;
	}

	public Set<Reference> getReferencesTo(IdEObject objectToRemove) {
		return references.get(objectToRemove);
	}

	public void addReference(Reference reference) {
		references.get(reference.getReferredObject()).add(reference);
		if (reference.geteReference().getEOpposite() != null) {
			if (reference.geteReference().getEOpposite().isMany()) {
				MultiReference backReference = new MultiReference(reference.getReferredObject(), reference.getIdEObject(), reference.geteReference().getEOpposite());
				references.get(reference.getIdEObject()).add(backReference);
			} else {
				SingleReference backReference = new SingleReference(reference.getReferredObject(), reference.getIdEObject(), reference.geteReference().getEOpposite());
				references.get(reference.getIdEObject()).add(backReference);
			}
		}
	}
}