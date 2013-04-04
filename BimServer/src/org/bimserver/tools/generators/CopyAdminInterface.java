package org.bimserver.tools.generators;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CopyAdminInterface {
	public static void main(String[] args) {
		new CopyAdminInterface().start();
	}

	private void start() {
		File bootstrap = new File("C:\\Users\\Ruben\\git\\BootstrapBIM\\BootstrapBIM");
		File www = new File("www");
		try {
			FileUtils.copyFileToDirectory(new File(bootstrap, "setup.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "index.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "login.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "basicserversettings.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serversettings.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "serverinfo.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "plugins.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschemas.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "extendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addnewextendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "addrepoextendeddataschema.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "main.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "json.html"), www);
			FileUtils.copyFileToDirectory(new File(bootstrap, "migrations.html"), www);
			
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
			FileUtils.copyDirectory(new File(bootstrap, "css"), new File(www, "css"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
