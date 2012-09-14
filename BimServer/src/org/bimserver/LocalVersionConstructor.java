package org.bimserver;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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
					BufferedReader reader = null;
					try {
						fis = new FileInputStream(entries);
						reader = new BufferedReader(new InputStreamReader(fis));
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
						if (reader != null) {
							try {
								reader.close();
							} catch (IOException e) {
							}
						}
					}
				}
			}
			
		}
	}
}