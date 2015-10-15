package org.bimserver.ifcgeometryremover;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bimserver.utils.PathUtils;

public class IfcGeometryRemoverTest {
	public static void main(String[] args) throws IOException {
		Path baseDir = Paths.get("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\simple changes");
		IfcGeometryRemover ifcGeometryRemover = new IfcGeometryRemover();
		for (Path inputFile : PathUtils.getDirectories(baseDir)) {
			if (inputFile.getFileName().toString().endsWith(".ifc") && !inputFile.getFileName().toString().startsWith("NOGEOM_")) {
				System.out.println(inputFile.getFileName().toString());
				ifcGeometryRemover.removeGeometry(inputFile, inputFile.getParent().resolve("NOGEOM_" + inputFile.getFileName().toString()));
			}
		}
	}
}