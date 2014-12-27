package org.bimserver.schemaconverter;

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