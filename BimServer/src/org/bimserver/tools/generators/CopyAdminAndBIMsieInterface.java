package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bimserver.shared.InterfaceList;
import org.bimserver.shared.meta.SServicesMap;
import org.codehaus.jettison.json.JSONException;

public class CopyAdminAndBIMsieInterface {
	public static void main(String[] args) {
		CopyAdminAndBIMsieInterface copyAdminAndBIMsieInterface = new CopyAdminAndBIMsieInterface();
		copyAdminAndBIMsieInterface.copyAdminInterface();
		copyAdminAndBIMsieInterface.copyBimsieInterface();
	}

	private void copyBimsieInterface() {
		File bootstrap = new File("C:\\Users\\Ruben\\git\\BootstrapBIM");
		File bimsie = new File("BIMsie");
		SServicesMap servicesMap = InterfaceList.createBimsie1SServicesMap();
		try {
			FileUtils.writeStringToFile(new File(bimsie, "js/services.json"), servicesMap.toJson().toString(2));
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileUtils.copyFile(new File(bootstrap, "console.html"), new File(bimsie, "index.html"));

			FileUtils.copyDirectory(new File(bootstrap, "js"), new File(bimsie, "js"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("settings.js") || pathname.getName().equals("consolesettings.js")) {
						return false;
					}
					return true;
				}
			});
			FileUtils.copyDirectory(new File(bootstrap, "img"), new File(bimsie, "img"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("consolelogo.png") || pathname.getName().equals("consolelogolarge.png")) {
						return false;
					}
					return true;
				}
			});
			FileUtils.copyDirectory(new File(bootstrap, "css"), new File(bimsie, "css"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void copyAdminInterface() {
		File bootstrap = new File("BootstrapBIM");
		File www = new File("../AdminGui");
		try {
			FileUtils.copyFileToDirectory(new File(bootstrap, "setup.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "index.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "login.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "basicserversettings.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serversettings.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serverinfo.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "plugins.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "console.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschemas.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addnewextendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addrepoextendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "main.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "migrations.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "webmodules.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "log.html"), www);
			
			FileUtils.copyDirectory(new File(bootstrap, "js"), new File(www, "js"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("settings.js")) {
						return false;
					}
					return true;
				}
			});
			FileUtils.copyDirectory(new File(bootstrap, "img"), new File(www, "img"));
			FileUtils.copyDirectory(new File(bootstrap, "css"), new File(www, "css"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("bootstrap.min.css")) {
						return false;
					}
					return true;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
