package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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
import java.util.Map;

import org.bimserver.interfaces.objects.SArrayType;
import org.bimserver.interfaces.objects.SBooleanType;
import org.bimserver.interfaces.objects.SByteArrayType;
import org.bimserver.interfaces.objects.SDoubleType;
import org.bimserver.interfaces.objects.SLongType;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SParameter;
import org.bimserver.interfaces.objects.SStringType;
import org.bimserver.interfaces.objects.SType;
import org.bimserver.models.store.ArrayType;
import org.bimserver.models.store.BooleanType;
import org.bimserver.models.store.ByteArrayType;
import org.bimserver.models.store.DoubleType;
import org.bimserver.models.store.LongType;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Type;
import org.eclipse.emf.common.util.EList;

/**
 * This is basically just a wrapper for ObjectType with the values mapped in a hashmap for more efficient access
 *
 */
public class PluginConfiguration {
	private final Map<String, Object> values = new HashMap<String, Object>();
	
	public PluginConfiguration(SObjectType settings) {
		for (SParameter parameter : settings.getParameters()) {
			SType value = parameter.getValue();
			if (value instanceof SBooleanType) {
				values.put(parameter.getIdentifier(), ((SBooleanType)value).isValue());
			} else if (value instanceof SStringType) {
				values.put(parameter.getIdentifier(), ((SStringType)value).getValue());
			} else if (value instanceof SLongType) {
				values.put(parameter.getIdentifier(), ((SLongType)value).getValue());
			} else if (value instanceof SDoubleType) {
				values.put(parameter.getIdentifier(), ((SDoubleType)value).getValue());
			} else if (value instanceof SArrayType) {
				// TODO
				values.put(parameter.getIdentifier(), ((SArrayType)value).getValues());
			} else if (value instanceof SByteArrayType) {
				values.put(parameter.getIdentifier(), ((SByteArrayType)value).getValue());
			} else if (value instanceof SObjectType) {
				// TODO
			} else {
				throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
			}
		}
	}
	
	public PluginConfiguration(ObjectType settings) {
		EList<Parameter> parameters = settings.getParameters();
		for (Parameter parameter : parameters) {
			Type value = parameter.getValue();
			if (value != null) {
				if (value instanceof BooleanType) {
					values.put(parameter.getIdentifier(), ((BooleanType)value).isValue());
				} else if (value instanceof StringType) {
					values.put(parameter.getIdentifier(), ((StringType)value).getValue());
				} else if (value instanceof LongType) {
					values.put(parameter.getIdentifier(), ((LongType)value).getValue());
				} else if (value instanceof ByteArrayType) {
					values.put(parameter.getIdentifier(), ((ByteArrayType)value).getValue());
				} else if (value instanceof DoubleType) {
					values.put(parameter.getIdentifier(), ((DoubleType)value).getValue());
				} else if (value instanceof ArrayType) {
					// TODO
					values.put(parameter.getIdentifier(), ((ArrayType)value).getValues());
				} else if (value instanceof ObjectType) {
					// TODO
				} else {
					throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
				}
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

	public byte[] getByteArray(String name) {
		return (byte[])get(name);
	}
	
	public Double getDouble(String name) {
		return (Double)get(name);
	}
	
	public Long getLong(String name) {
		return (Long)get(name);
	}

	public boolean has(String fullIdentifier) {
		return values.containsKey(fullIdentifier);
	}
}