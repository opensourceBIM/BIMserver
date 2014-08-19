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

import java.util.ArrayList;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSlabTypeEnum;

// A keyed collection for storing convertors. Convertors exist in a pool that can be checked against by a generic class name (like IfcRoof-fx)
public class ConvertorsKeyedCollection {
	List<Convertor> list;

	public ConvertorsKeyedCollection() {
		list = new ArrayList<Convertor>();
	}

	public void add(Convertor convertor)
	{
		if (!list.contains(convertor))
			list.add(convertor);
	}

	public boolean hasKey(String name) {
		for (Convertor convertor : list)
			if (convertor.getKey().equalsIgnoreCase(name))
				return true;
		return false;
	}

	// Look up by class name to provide default materials.
	public boolean hasKey(Class<?> genericClass) {
		String thisKey = String.format("%s", genericClass.getClass().getSimpleName());
		thisKey = stripImpl(thisKey);
		return hasKey(thisKey);
	}

	private String stripImpl(String thisKey) {
		if (thisKey.endsWith("Impl"))
			thisKey = thisKey.substring(0, thisKey.length() - 4);
		return thisKey;
	}

	// Look up by IfcProduct identifier.
	public boolean hasKey(IfcProduct ifcProduct) {
		String thisKey = String.format("%d", ifcProduct.getOid());
		boolean hasExact = hasKey(thisKey);
		if (hasExact)
			return true;
		else {
			thisKey = sanitizeGenericIfcProductKey(ifcProduct);
			return hasKey(thisKey);
		}
	}

	private String sanitizeGenericIfcProductKey(IfcProduct ifcProduct) {
		String simpleClassName;
		// Check if the IfcProduct is actually an IfcSlab, which might internally overlap with the IfcRoof class.
		if (ifcProduct instanceof IfcSlab) {
			IfcSlab thisSlab = (IfcSlab) ifcProduct;
			simpleClassName = (thisSlab.getPredefinedType() != IfcSlabTypeEnum.ROOF) ? "IfcSlab" : "IfcRoof";
		} else
			simpleClassName = stripImpl(ifcProduct.getClass().getSimpleName());
		// Send back: {simple-class-name}
		return String.format("%s", simpleClassName);
	}

	public Convertor get(String exactName) {
		for (Convertor convertor : list)
			if (convertor.getKey().equalsIgnoreCase(exactName))
				return convertor;
		return null;
	}

	public Convertor getByEffect(String nameWithDashFX) {
		String exactName = nameWithDashFX.substring(0, nameWithDashFX.length() - 3);
		return get(exactName);
	}

	public String getValidDefaultMaterialName(IfcProduct ifcProduct) {
		return sanitizeGenericIfcProductKey(ifcProduct);
	}

	// Returns: {ifc-product-oid} (or) {ifc-product-class-simple-name}
	public String getValidMaterialName(IfcProduct ifcProduct) {
		String thisKey = String.format("%d", ifcProduct.getOid());
		String classKey = sanitizeGenericIfcProductKey(ifcProduct);
		if (hasKey(thisKey))
			return thisKey;
		else if (hasKey(classKey))
			return classKey;
		else
			return "IfcProduct";
	}
}