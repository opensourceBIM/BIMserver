package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopyAdminAndBIMsieInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(CopyAdminAndBIMsieInterface.class);
	private static final File baseGitDir = new File("C:\\git");
//	private static final File baseGitDir = new File("D:\\git");
	private static final File bootstrap = new File(baseGitDir, "bimvie.ws");
	private static final File admin = new File(baseGitDir, "BIMserver3\\AdminGui");;

	public static void main(String[] args) {
		CopyAdminAndBIMsieInterface copyAdminAndBIMsieInterface = new CopyAdminAndBIMsieInterface();
		copyAdminAndBIMsieInterface.copyAdminInterface();
	}

	private void copyAdminInterface() {
		try {
			FileUtils.copyFileToDirectory(new File(bootstrap, "setup.html"), admin);
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
			FileUtils.copyFileToDirectory(new File(bootstrap, "addextendeddataschema.html"), admin);
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
			FileUtils.copyFileToDirectory(new File(bootstrap, "plugin.html"), admin);
			FileUtils.copyFileToDirectory(new File(bootstrap, "modelchecker.html"), admin);
			
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
