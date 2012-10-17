package org.bimserver.ifcengine;

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
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TNOJvmIfcEnginePlugin implements IfcEnginePlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(TNOJvmIfcEnginePlugin.class);
	private PluginManager pluginManager;
	private boolean initialized = false;
	private File nativeFolder;
	private File schemaFile;

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
		try {
			SchemaPlugin schemaPlugin = pluginManager.getFirstSchemaPlugin(true);
			schemaFile = schemaPlugin.getExpressSchemaFile();
			if (schemaFile == null) {
				throw new PluginException("No schema file");
			}
			PluginContext pluginContext = pluginManager.getPluginContext(this);
			String os = System.getProperty("os.name").toLowerCase();
			String libraryName = "";
			if (os.contains("windows")) {
				libraryName = "IFCEngine.dll";
			} else if (os.contains("osx") || os.contains("os x") || os.contains("darwin")) {
				libraryName = "libIFCEngine.dylib";
			} else if (os.contains("linux")) {
				libraryName = "libIFCEngine.so";
			}
			InputStream inputStream = pluginContext.getResourceAsInputStream("lib/" + System.getProperty("sun.arch.data.model") + "/" + libraryName);
			if (inputStream != null) {
				File tmpFolder = pluginManager.getTempDir();
				nativeFolder = new File(tmpFolder, "TNOEngineSeries");
				try {
					File file = new File(nativeFolder, libraryName);
					if (nativeFolder.exists()) {
						try {
							FileUtils.deleteDirectory(nativeFolder);
						} catch (IOException e) {
							// Ignore
						}
					}
					FileUtils.forceMkdir(nativeFolder);
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					IOUtils.copy(inputStream, fileOutputStream);
					fileOutputStream.close();
					initialized = true;
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public String getDescription() {
		return "Native implementation of an IFC Engine";
	}

	@Override
	public IfcEngine createIfcEngine() throws IfcEngineException {
		return new JvmIfcEngine(schemaFile, nativeFolder, pluginManager.getTempDir(), pluginManager.getCompleteClassPath());
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public String getDefaultName() {
		return "TNO Engine Series";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}