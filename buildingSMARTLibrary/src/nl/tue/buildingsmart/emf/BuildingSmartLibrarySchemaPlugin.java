package nl.tue.buildingsmart.emf;

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.apache.commons.io.IOUtils;
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.schema.SchemaPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildingSmartLibrarySchemaPlugin implements SchemaPlugin {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingSmartLibrarySchemaPlugin.class);
	private SchemaDefinition schemaDefinition;
	private boolean initialized = false;
	private File schemaFile;

	@Override
	public SchemaDefinition getSchemaDefinition() {
		return schemaDefinition;
	}

	@Override
	public String getDescription() {
		return "BuildingSmartLibrarySchemaPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void init(PluginManager pluginManager) {
		PluginContext pluginContext = pluginManager.getPluginContext(this);
		InputStream inputStream = pluginContext.getResourceAsInputStream("schema/IFC2X3_TC1.exp");
		if (!pluginManager.getTempDir().exists()) {
			pluginManager.getTempDir().mkdir();
		}
		schemaFile = new File(pluginManager.getTempDir(), "IFC2X3_TC1.exp");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(schemaFile);
			IOUtils.copy(inputStream, fileOutputStream);
			fileOutputStream.close();
			schemaDefinition = loadIfcSchema(schemaFile);
			initialized = true;
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	private SchemaDefinition loadIfcSchema(File schemaFile) {
		try {
			ExpressSchemaParser schemaParser = new ExpressSchemaParser(schemaFile);
			schemaParser.parse();
			SchemaDefinition schema = schemaParser.getSchema();
			new DerivedReader(schemaFile, schema);
			if (schema != null) {
				LOGGER.info("IFC-Schema successfully loaded from " + schemaFile.getAbsolutePath());
			} else {
				LOGGER.error("Error loading IFC-Schema");
			}
			return schema;
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public File getExpressSchemaFile() {
		return schemaFile;
	}

	@Override
	public String getDefaultName() {
		return "BuildingSmartLibrarySchemaPlugin";
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		return null;
	}
}