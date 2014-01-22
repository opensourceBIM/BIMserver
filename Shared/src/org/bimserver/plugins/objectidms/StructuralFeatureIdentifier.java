package org.bimserver.plugins.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class StructuralFeatureIdentifier {
	private final String eClass;
	private final String eStructuralFeature;
	
	public StructuralFeatureIdentifier(String eClass, String eStructuralFeature) {
		this.eClass = eClass;
		this.eStructuralFeature = eStructuralFeature;
	}
	
	public String geteClass() {
		return eClass;
	}
	
	public String geteStructuralFeature() {
		return eStructuralFeature;
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