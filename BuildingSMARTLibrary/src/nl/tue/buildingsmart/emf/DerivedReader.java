package nl.tue.buildingsmart.emf;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bimserver.plugins.schema.BaseType;
import org.bimserver.plugins.schema.DerivedAttribute2;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerivedReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(DerivedReader.class);

	public DerivedReader(InputStream inputStream, SchemaDefinition schema) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line = reader.readLine();
			String entityName = null;
			boolean derive = false;
			while (line != null) {
				if (line.startsWith("ENTITY ")) {
					entityName = line.substring(7);
					if (entityName.endsWith(";")) {
						entityName = entityName.substring(0, entityName.length() - 1);
					}
					derive = false;
				} else if (line.startsWith(" DERIVE")) {
					if (entityName != null) {
						derive = true;
					}
				} else if (line.startsWith("END_ENTITY")) {
					entityName = null;
					derive = false;
				} else if (line.startsWith(" WHERE")) {
					derive = false;
				} else if (line.startsWith(" INVERSE")) {
					derive = false;
				} else if (derive == true) {
					if (line.indexOf(":") != -1) {
						String derivedName = line.substring(0, line.indexOf(":")).trim();
						if (derivedName.indexOf("SELF\\") != -1) {
							derivedName = derivedName.substring(derivedName.indexOf(".") + 1);
						}
						String expressCode = line.substring(line.indexOf(":=") + 2);
						if (line.trim().endsWith(",")) {
							expressCode += reader.readLine();
						}
						String type = line.substring(line.indexOf(":") + 1);
						type = type.substring(0, type.indexOf(":=")).trim();
						BaseType entityBN2 = null;
						boolean collection = false;
						if (type.startsWith("LIST") || type.startsWith("ARRAY") || type.startsWith("SET")) {
							type = type.substring(type.indexOf(" OF ") + 4).trim();
							if (type.startsWith("LIST") || type.startsWith("ARRAY") || type.startsWith("SET")) {
								type = type.substring(type.indexOf(" OF ") + 4).trim();
							}
							collection = true;
						}
						entityBN2 = schema.getEntityBN(type);
						if (entityBN2 == null) {
							entityBN2 = schema.getBaseTypeBN(type);
						}
						if (entityBN2 == null) {
							System.out.println("Not found: " + type);
						}
						DerivedAttribute2 derivedAttribute2 = new DerivedAttribute2(derivedName, entityBN2, expressCode, collection, false);
						EntityDefinition entityBN = schema.getEntityBN(entityName);
						if (entityBN == null) {
							System.out.println("unknown entity " + entityName);
						} else {
							entityBN.addDerived(derivedAttribute2, true);
						}
					}
				}
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public DerivedReader(File schemaFile, SchemaDefinition schemaDefinition) throws FileNotFoundException {
		this(new FileInputStream(schemaFile), schemaDefinition);
	}
}