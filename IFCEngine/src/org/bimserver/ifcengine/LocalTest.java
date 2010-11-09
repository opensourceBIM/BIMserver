package org.bimserver.ifcengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sun.jna.Pointer;

public class LocalTest {
	public static void main(String[] args) {
		new LocalTest().start();
	}

	private void start() {
		IfcEngineJNA engineJNA = new IfcEngineJNA();
		try {
			File file = new File("../TestData/data/AC11-FZK-Haus-IFC.ifc");
			Pointer loadFromInputStream = engineJNA.loadFromInputStream(new FileInputStream(file), (int) file.length(), "../BimServer/deploy/shared/IFC2X3_FINAL.exp");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
