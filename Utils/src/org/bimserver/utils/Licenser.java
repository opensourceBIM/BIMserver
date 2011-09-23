package org.bimserver.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Licenser {
	private String license;

	public static void main(String[] args) {
		new Licenser().start();
	}

	private void start() {
		try {
			license = FileUtils.readFileToString(new File("license.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		File workspace = new File("C:\\Users\\Ruben de Laat\\Workspaces\\BIMserver");
		for (File project : workspace.listFiles()) {
			if (!project.getName().startsWith(".")) {
				File srcFolder = new File(project, "src");
				if (srcFolder.exists()) {
					process(srcFolder);
				}
			}
		}
	}

	private void process(File srcFolder) {
		for (File file : srcFolder.listFiles()) {
			if (file.isDirectory()) {
				if (!file.getName().startsWith(".")) {
					process(file);
				}
			} else {
				if (file.getName().endsWith(".java") && !file.getName().equals("Licenser.java")) {
					processFile(file);
				}
			}
		}
	}

	private void processFile(File file) {
		try {
			String content = FileUtils.readFileToString(file);
			int indexOfPackageStart = content.indexOf("package ");
			if (indexOfPackageStart != -1) {
				int indexOfPackageEnd = content.indexOf(";", indexOfPackageStart + 1);
				int indexOfFirstImport = content.indexOf("import ", indexOfPackageEnd);
				if (indexOfFirstImport != -1) {
					if (content.substring(indexOfFirstImport - 2, indexOfFirstImport).equals("//")) {
						indexOfFirstImport = indexOfFirstImport - 2;
					}
				}
				if (indexOfFirstImport == -1) {
					int indexOfFirstPublic = content.indexOf("public ", indexOfPackageEnd);
					int indexOfFirstPrivate = content.indexOf("private ", indexOfPackageEnd);
					if (indexOfFirstPublic != -1 && indexOfFirstPrivate != -1) {
						if (indexOfFirstPublic < indexOfFirstPrivate) {
							indexOfFirstImport = indexOfFirstPublic;
						} else {
							indexOfFirstImport = indexOfFirstPrivate;
						}
					} else {
						if (indexOfFirstPrivate != -1) {
							indexOfFirstImport = indexOfFirstPrivate;
						} else if (indexOfFirstPublic != -1) {
							indexOfFirstImport = indexOfFirstPublic;
						}
					}
  				}
				if (indexOfFirstImport != -1) {
					String first = content.substring(0, indexOfPackageEnd + 1);
					String second = content.substring(indexOfFirstImport);
					String total = first + license + second;
					FileUtils.writeStringToFile(file, total);
				} else {
					System.out.println("Skipping " + file.getName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}