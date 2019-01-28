package org.bimserver.schemaconverter;

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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.Schema;

public class SchemaConverterManager {
	private final Map<SchemaKey, SchemaConverterFactory> converters = new HashMap<SchemaKey, SchemaConverterFactory>();
	
	public void registerConverter(SchemaConverterFactory schemaConverterFactory) {
		converters.put(new SchemaKey(schemaConverterFactory.getSourceSchema(), schemaConverterFactory.getTargetSchema()), schemaConverterFactory);
	}
	
	public SchemaConverterFactory getSchemaConverterFactory(Schema source, Schema target) {
		return converters.get(new SchemaKey(source, target));
	}

	public SchemaConverter getSchemaConverter(Schema source, Schema target, IfcModelInterface sourceModel, IfcModelInterface targetModel) {
		SchemaConverterFactory factory = getSchemaConverterFactory(source, target);
		return factory.create(sourceModel, targetModel);
	}

	public Set<Schema> getSchemaTargets(Schema source) {
		Set<Schema> result = new HashSet<>();
		for (SchemaConverterFactory factory : converters.values()) {
			if (factory.getSourceSchema() == source) {
				result.add(factory.getTargetSchema());
			}
		}
		return result;
	}
}