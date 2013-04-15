package org.bimserver.ifcgeometryremover;

import java.io.File;

public class IfcGeometryRemoverTest {
	public static void main(String[] args) {
		File baseDir = new File("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\simple changes");
		IfcGeometryRemover ifcGeometryRemover = new IfcGeometryRemover();
		for (File inputFile : baseDir.listFiles()) {
			if (inputFile.getName().endsWith(".ifc") && !inputFile.getName().startsWith("NOGEOM_")) {
				System.out.println(inputFile.getName());
				ifcGeometryRemover.removeGeometry(inputFile, new File(inputFile.getParentFile(), "NOGEOM_" + inputFile.getName()));
			}
		}
	}
}