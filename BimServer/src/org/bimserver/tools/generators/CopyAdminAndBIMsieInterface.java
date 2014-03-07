package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyAdminAndBIMsieInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(CopyAdminAndBIMsieInterface.class);
	private static final File baseGitDir = new File("E:\\git");
//	private static final File baseGitDir = new File("D:\\git");
	private static final File bootstrap = new File(baseGitDir, "bimvie.ws");
	private static final File bimsie = new File(baseGitDir, "BIMSie");
	private static final File admin = new File(baseGitDir, "BIMserver\\AdminGui");;

	public static void main(String[] args) {
		CopyAdminAndBIMsieInterface copyAdminAndBIMsieInterface = new CopyAdminAndBIMsieInterface();
		copyAdminAndBIMsieInterface.copyAdminInterface();
		copyAdminAndBIMsieInterface.copyBimsieInterface();
	}

	private void copyBimsieInterface() {
		SServicesMap servicesMap = InterfaceList.createBimsie1SServicesMap();
		try {
			FileUtils.writeStringToFile(new File(bimsie, "js/services.json"), servicesMap.toJson().toString(2));
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
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
			FileUtils.copyDirectory(new File(bootstrap, "fonts"), new File(bimsie, "fonts"));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	private void copyAdminInterface() {
		try {
			FileUtils.copyFileToDirectory(new File(bootstrap, "setup.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "header.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "index.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "login.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "basicserversettings.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serversettings.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serverinfo.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "gettingstarted.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "plugins.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "console.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschemas.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschema.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addnewextendeddataschema.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addrepoextendeddataschema.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "main.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "migrations.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "webmodules.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "log.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "usersettings.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "basicusersettings.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "genericpluginsettingslist.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "genericpluginsettings.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "modelcheckers.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addrepomodelchecker.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addnewmodelchecker.html"), admin);
			
			FileUtils.copyDirectory(new File(bootstrap, "js"), new File(admin, "js"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("settings.js")) {
						return false;
					}
					return true;
				}
			});
			FileUtils.copyDirectory(new File(bootstrap, "img"), new File(admin, "img"));
			FileUtils.copyDirectory(new File(bootstrap, "css"), new File(admin, "css"), new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					if (pathname.getName().equals("magic-bootstrap-min.css")) {
						return false;
					}
					return true;
				}
			});
			FileUtils.copyDirectory(new File(bootstrap, "fonts"), new File(admin, "fonts"));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}
}
