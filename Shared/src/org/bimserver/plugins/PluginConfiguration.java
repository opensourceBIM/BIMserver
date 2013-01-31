package org.bimserver.plugins;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.models.store.ArrayType;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Type;

/**
 * This is basically just a wrapper for ObjectType with the values mapped in a hashmap for more efficient access
 *
 */
public class PluginConfiguration {
	private final Map<String, Object> values = new HashMap<String, Object>();
	
	public PluginConfiguration(ObjectType settings) {
		for (Parameter parameter : settings.getParameters()) {
			Type value = parameter.getValue();
			if (value instanceof BooleanType) {
				values.put(parameter.getName(), ((BooleanType)value).isValue());
			} else if (value instanceof StringType) {
				values.put(parameter.getName(), ((StringType)value).getValue());
			} else if (value instanceof LongType) {
				values.put(parameter.getName(), ((LongType)value).getValue());
			} else if (value instanceof DoubleType) {
				values.put(parameter.getName(), ((DoubleType)value).getValue());
			} else if (value instanceof ArrayType) {
				// TODO
				values.put(parameter.getName(), ((ArrayType)value).getValues());
			} else if (value instanceof ObjectType) {
				// TODO
			} else {
				throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
			}
		}
	}

	public PluginConfiguration() {
	}

	public String getString(String name) {
		return (String) get(name);
	}
	
	public Object get(String name) {
		return values.get(name);
	}
	
	public Boolean getBoolean(String name) {
		return (Boolean)get(name);
	}
	
	public Double getDouble(String name) {
		return (Double)get(name);
	}
	
	public Long getLong(String name) {
		return (Long)get(name);
	}
}
