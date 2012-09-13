package nl.tue.buildingsmart.emf;

import java.io.File;

public class Ifc2x3tc1 {
	public static void main(String[] args) {
		Express2EMF express2emf = new Express2EMF(new File("schema/IFC2X3_TC1.exp"), "ifc2x3tc1");
		express2emf.writeEMF("../BimServer/src/org/bimserver/database/migrations/steps/" + "IFC2X3_TC1.ecore");
	}
}