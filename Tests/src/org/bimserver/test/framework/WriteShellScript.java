package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
