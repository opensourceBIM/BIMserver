package org.bimserver.ifc;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.eclipse.emf.common.util.AbstractEList;
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
//			System.out.println("Re-attaching S " + getReferredObject() + " to " + mainObject + " on " + getIdEObject() + "." + geteReference().getName());
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
//			System.out.println("Re-attaching M " + getReferredObject() + " to " + mainObject + " on " + getIdEObject() + "." + geteReference().getName());
			AbstractEList list = (AbstractEList) getIdEObject().eGet(geteReference());
			int index = list.indexOf(getReferredObject());
			if (index != -1) {
				try {
					list.set(index, mainObject);
				} catch (IllegalArgumentException e) {
//					e.printStackTrace();
				}
			}

			// TODO if the old object really does exist multiple times, the new object should also exist multiple times... but it's probably a bug that it's there multiple times in the first place...
			while (list.contains(getReferredObject())) {
				list.remove(getReferredObject());
			}
			return new MultiReference(getIdEObject(), mainObject, geteReference());
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
					List list = (List) idEObject.eGet(eReference);
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
		removeInternal(idEObject);
//		LOGGER.info("Removing " + idEObject + " (" + totalRemoved + ")");
	}

	@SuppressWarnings("rawtypes")
	public int removeInternal(IdEObject idEObject) {
		int totalRemoved = 1;
		for (EReference eReference : idEObject.eClass().getEAllReferences()) {
			if (eReference.isMany()) {
				List list = (List) idEObject.eGet(eReference);
				for (Object o : list) {
					IdEObject refObject = (IdEObject) o;
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
		if (references.containsKey(reference.getReferredObject()))
			references.get(reference.getReferredObject()).add(reference);
		else {
			Set<Reference> rSet = new HashSet<Reference>();
			rSet.add(reference);
			references.put(reference.getReferredObject(), rSet);
		}
		if (reference.geteReference().getEOpposite() != null) {
			if (reference.geteReference().getEOpposite().isMany()) {
				MultiReference backReference = new MultiReference(reference.getReferredObject(), reference.getIdEObject(), reference.geteReference().getEOpposite());
				if (references.containsKey(reference.getIdEObject()))
					references.get(reference.getIdEObject()).add(backReference);
				else {
					Set<Reference> rSet = new HashSet<Reference>();
					rSet.add(backReference);
					references.put(reference.getIdEObject(), rSet);
				}
			} else {
				SingleReference backReference = new SingleReference(reference.getReferredObject(), reference.getIdEObject(), reference.geteReference().getEOpposite());
				if (references.containsKey(reference.getIdEObject()))
					references.get(reference.getIdEObject()).add(backReference);
				else {
					Set<Reference> rSet = new HashSet<Reference>();
					rSet.add(backReference);
					references.put(reference.getIdEObject(), rSet);
				}
			}
		}
	}
}