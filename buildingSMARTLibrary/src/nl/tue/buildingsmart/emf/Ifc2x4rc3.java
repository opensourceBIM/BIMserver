package nl.tue.buildingsmart.emf;

import java.io.File;

public class Ifc2x4rc3 {
	public static void main(String[] args) {
		Express2EMF express2emf = new Express2EMF(new File("schema/IFC2X4_RC3.exp"), "ifc2x4rc3");
		express2emf.writeEMF("../BimServer/src/org/bimserver/database/migrations/steps/" + "IFC2X4_RC3.ecore");
	}
}