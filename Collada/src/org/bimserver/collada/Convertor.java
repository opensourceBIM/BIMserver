package org.bimserver.collada;

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

// Templated class that provides a generic, class-level (IfcDoor, IfcWindow, etc.) colored material. Ignores IfcMaterial, IfcMaterialLayerSet, IfcMaterialProfileSet [IFC2x4], and IfcMaterialConstituentSet [IFC2x4].
public class Convertor {
	private ColladaMaterial material;

	public Convertor(ColladaMaterial material) {
		this.material = material;
	}

	public Convertor(Class<?> cl, double[] colors, double opacity) {
		// ColladaMaterial internally adds the suffix "-fx" only on writing. Simple name refers to the end of a package string, like IfcWindow. Warning: 
		this.material = new ColladaMaterial(cl.getSimpleName());
		ColladaProfile profile = this.material.getProfile("Common");
		profile.diffuseColor = colors;
		profile.transparency = 1 - opacity;
	}

	// One use of key is to find {class-name}-fx and the other use of key is to find {ifc-product-oid}-fx.
	public String getKey() {
		return getMaterialName();
	}

	public String getMaterialName() {
		return material.name;
	}

	public double[] getColors() {
		ColladaProfile profile = material.getProfile("Common");
		return profile.diffuseColor;
	}

	public double getOpacity() {
		ColladaProfile profile = material.getProfile("Common");
		return profile.transparency;
	}
	
	public String getEffectString() {
		return material.getEffectString();
	}
}