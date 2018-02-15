package org.bimserver.changes;

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.eclipse.emf.ecore.EClass;

public class ChangeHelper {
	public static boolean canBeChanged(EClass eClass) {
		return eClass.getEPackage() == Ifc2x3tc1Package.eINSTANCE || eClass.getEPackage() == Ifc4Package.eINSTANCE;
	}
}
