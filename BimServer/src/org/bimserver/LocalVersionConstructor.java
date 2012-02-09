package org.bimserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.bimserver.interfaces.objects.SVersion;

public class LocalVersionConstructor {

	public static void augmentWithSvn(SVersion version) {
		File currentDir = new File(".").getAbsoluteFile();
		File workspaceDir = currentDir.getParentFile();
		for (File projectDir : workspaceDir.listFiles()) {
			File svn = new File(projectDir, ".svn");
			if (svn.isDirectory()) {
				File entries = new File(svn, "entries");
				if (entries.isFile()) {
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(entries);
						BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
						reader.readLine();
						reader.readLine();
						reader.readLine();
						int versionNumber = Integer.parseInt(reader.readLine());
						if (versionNumber > version.getRevision()) {
							version.setRevision(versionNumber);
							version.setDate(new Date());
						}
					} catch (FileNotFoundException e1) {
					} catch (IOException e) {
					} catch (NumberFormatException e) {
					} finally {
						if (fis != null) {
							try {
								fis.close();
							} catch (IOException e) {
							}
						}
					}
				}
			}
			
		}
	}
}