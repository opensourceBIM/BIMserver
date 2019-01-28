package org.bimserver.emf;

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

import java.util.HashSet;
import java.util.Set;

import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EPackage;

public enum Schema {
	STORE(StorePackage.eINSTANCE, "STORE"),
	GEOMETRY(GeometryPackage.eINSTANCE, "GEOMETRY"),
	LOG(LogPackage.eINSTANCE, "LOG"),
	IFC2X3TC1(Ifc2x3tc1Package.eINSTANCE, "IFC2X3"),
	IFC4(Ifc4Package.eINSTANCE, "IFC4");
	
	private String headerName;
	private EPackage ePackage;

	Schema(EPackage ePackage, String headerName) {
		this.ePackage = ePackage;
		this.headerName = headerName;
	}
	
	public String getHeaderName() {
		return headerName;
	}
	
	public Set<Schema> toSet() {
		Set<Schema> set = new HashSet<>();
		set.add(this);
		return set;
	}
	
	public static Set<Schema> asSet(Schema... schemas) {
		Set<Schema> set = new HashSet<>();
		for (Schema schema : schemas) {
			set.add(schema);
		}
		return set;
	}

	public String getEPackageName() {
		return ePackage.getName();
	}

	public static Set<Schema> getIfcSchemas() {
		Set<Schema> schemas = new HashSet<>();
		schemas.add(IFC2X3TC1);
		schemas.add(IFC4);
		return schemas;
	}

	public static Schema fromIfcHeader(String schema) {
		if ("IFC2X3".equals(schema.toUpperCase())) {
			return Schema.IFC2X3TC1;
		} else if ("IFC4".equals(schema.toUpperCase())) {
			return Schema.IFC4;
		}
		return null;
	}
}