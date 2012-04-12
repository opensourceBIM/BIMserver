package org.bimserver.plugins.objectidms;

public class StructuralFeatureIdentifier {
	private final String eClass;
	private final String eStructuralFeature;
	
	public StructuralFeatureIdentifier(String eClass, String eStructuralFeature) {
		this.eClass = eClass;
		this.eStructuralFeature = eStructuralFeature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eClass == null) ? 0 : eClass.hashCode());
		result = prime * result + ((eStructuralFeature == null) ? 0 : eStructuralFeature.hashCode());
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
		StructuralFeatureIdentifier other = (StructuralFeatureIdentifier) obj;
		if (eClass == null) {
			if (other.eClass != null)
				return false;
		} else if (!eClass.equals(other.eClass))
			return false;
		if (eStructuralFeature == null) {
			if (other.eStructuralFeature != null)
				return false;
		} else if (!eStructuralFeature.equals(other.eStructuralFeature))
			return false;
		return true;
	}
}