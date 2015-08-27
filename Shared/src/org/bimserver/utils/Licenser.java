package org.bimserver.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Licenser {

	private static final Logger LOGGER = LoggerFactory.getLogger(Licenser.class);
	private int same;
	private int changed;
	private int skipped;
	
	public static void main(String[] args) {
		new Licenser().start();
	}

	private void start() {
		File workspace = new File("../").getAbsoluteFile();
		for (File project : workspace.listFiles()) {
			if (!project.getName().startsWith(".")) {
				File srcFolder = new File(project, "src");
				if (srcFolder.exists()) {
					String license = getCommentedLicenseText(new File(project, "license.txt"));
					if (license != null) {
						process(srcFolder, license);
					}
				}
			}
		}
		System.out.println("Unchanged: " + same);
		System.out.println("Changed: " + changed);
		System.out.println("Skipped: " + skipped);
	}

	private void process(File srcFolder, String license) {
		for (File file : srcFolder.listFiles()) {
			if (file.isDirectory()) {
				if (!file.getName().startsWith(".")) {
					process(file, license);
				}
			} else {
				if (file.getName().endsWith(".java") && !file.getName().equals("Licenser.java")) {
					processFile(file, license);
				}
			}
		}
	}

	public static String getCommentedLicenseText(File file) {
		if (!file.exists()) { 
			return null;
		}
		try {
			String content = FileUtils.readFileToString(file);
			StringBuilder newContent = new StringBuilder();
			Scanner scanner = new Scanner(content);
			try {
				newContent.append("/******************************************************************************\n");
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					newContent.append(" * " + line + "\n");
				}
				newContent.append(" *****************************************************************************/");
			} finally {
				scanner.close();
			}
			return newContent.toString();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}
	
	private void processFile(File file, String license) {
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
					String total = first + "\n\n" + license + "\n\n" + second;
					if (total.equals(content)) {
						same++;
					} else {
						changed++;
					}
					FileUtils.writeStringToFile(file, total);
				} else {
					skipped++;
				}
			}
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}