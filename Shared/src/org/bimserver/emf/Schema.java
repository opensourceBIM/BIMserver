package org.bimserver.emf;

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
}