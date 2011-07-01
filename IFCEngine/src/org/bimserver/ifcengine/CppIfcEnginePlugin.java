package org.bimserver.ifcengine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;
import org.bimserver.plugins.schema.SchemaPlugin;

public class CppIfcEnginePlugin implements IfcEnginePlugin {

	private PluginManager pluginManager;
	private boolean initialized = false;
	private File nativeFolder;
	private File schemaFile;

	@Override
	public String getName() {
		return getClass().getName();
	}

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
			} else if (os.contains("osx")) {
				libraryName = "libIFCEngine.dylib";
			} else if (os.contains("linux")) {
				libraryName = "libIFCEngine.so";
			}
			InputStream inputStream = pluginContext.getResourceAsInputStream("lib/" + System.getProperty("sun.arch.data.model") + "/" + libraryName);
			if (inputStream != null) {
				File tmpFolder = new File(pluginManager.getHomeDir(), "tmp");
				nativeFolder = new File(tmpFolder, "ifcengine");
				try {
					if (nativeFolder.exists()) {
						FileUtils.deleteDirectory(nativeFolder);
					}
					nativeFolder.mkdir();
					IOUtils.copy(inputStream, new FileOutputStream(new File(nativeFolder, libraryName)));
					initialized = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public Set<Class<? extends Plugin>> getRequiredPlugins() {
		return new HashSet<Class<? extends Plugin>>();
	}

	@Override
	public String getDescription() {
		return "Native implementation of an IFC Engine";
	}

	@Override
	public IfcEngine createIfcEngine() throws IfcEngineException {
		return new FailSafeIfcEngine(schemaFile, nativeFolder, new File(pluginManager.getHomeDir(), "tmp"), pluginManager.getCompleteClassPath());
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}
}