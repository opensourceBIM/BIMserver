package nl.tue.buildingsmart.emf;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;

import org.bimserver.plugins.schema.SchemaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaLoader {
	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaLoader.class);
	public static final File DEFAULT_SCHEMA_FILE = new File((".." + File.separator + "BimServer" + File.separator + "build" + File.separator + "targets" + File.separator
			+ "shared" + File.separator + "IFC2X3_TC1.exp"));

	private SchemaLoader() {
	}

	public static SchemaDefinition loadDefaultSchema() {
		return loadSchema(DEFAULT_SCHEMA_FILE);
	}

	public static SchemaDefinition loadSchema(File schemaFile) {
		ExpressSchemaParser schemaParser = new ExpressSchemaParser(DEFAULT_SCHEMA_FILE);
		schemaParser.parse();
		SchemaDefinition schema = schemaParser.getSchema();
		try {
			new DerivedReader(schemaFile, schema);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
		return schema;
	}
}
