package org.bimserver.test.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteShellScript {
	public static void main(String[] args) {
		new WriteShellScript().start();
	}

	private void start() {
		try {
			PrintWriter out = new PrintWriter(new File("test.sh"));
			out.print("java -classpath ");
			File workspace = new File("..");
			for (File project : workspace.listFiles()) {
				if (!project.getName().startsWith(".")) {
					File srcFolder = new File(project, "src");
					if (srcFolder.exists()) {
						out.print(project.getName() + "/" + srcFolder.getName() + File.pathSeparator);
					}
					File generatedFolder = new File(project, "generated");
					if (generatedFolder.exists()) {
						out.print(project.getName() + "/" + generatedFolder.getName() + File.pathSeparator);
					}
					File libFolder = new File(project, "lib");
					if (libFolder.exists()) {
						for (File lib : libFolder.listFiles()) {
							if (lib.getName().endsWith(".jar")) {
								out.print(project.getName() + "/" + libFolder.getName() + "/" + lib.getName() + File.pathSeparator);
							} else if (lib.isDirectory()) {
								for (File f : lib.listFiles()) {
									if (f.getName().endsWith(".jar")) {
										out.print(project.getName() + "/" + libFolder.getName() + "/" + lib.getName() + "/" + f.getName() + File.pathSeparator);
									}
								}
							}
						}
					}
				}
			}
			out.println(" org.bimserver.test.framework.RemoteTest");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
