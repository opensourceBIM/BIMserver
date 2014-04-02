package org.bimserver.schemaconverter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.emf.Schema;

public class SchemaConverterManager {
	private final Map<SchemaKey, SchemaConverter> converters = new HashMap<SchemaKey, SchemaConverter>();
	
	public void registerConverter(SchemaConverter schemaConverter) {
		converters.put(new SchemaKey(schemaConverter.getSourceSchema(), schemaConverter.getTargetSchema()), schemaConverter);
	}
	
	public SchemaConverter getSchemaConverter(Schema source, Schema target) {
		return converters.get(new SchemaKey(source, target));
	}

	public Set<Schema> getSchemaTargets(Schema source) {
		Set<Schema> result = new HashSet<>();
		for (SchemaConverter schemaConverter : converters.values()) {
			if (schemaConverter.getSourceSchema() == source) {
				result.add(schemaConverter.getTargetSchema());
			}
		}
		return result;
	}
}
