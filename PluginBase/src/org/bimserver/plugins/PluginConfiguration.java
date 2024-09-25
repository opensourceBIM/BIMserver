package org.bimserver.plugins;

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

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;
import org.apache.commons.lang3.NotImplementedException;
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
import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ObjectType;
import org.bimserver.models.store.Parameter;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveType;
import org.bimserver.models.store.StringType;
import org.bimserver.models.store.Type;

/**
 * This is basically just a wrapper for ObjectType with the values mapped in a hashmap for more efficient access
 *
 */
public class PluginConfiguration {
	private final Map<String, Object> values;

	public PluginConfiguration() {
		values = new HashMap<>();
	}

	public PluginConfiguration(SObjectType settings) {
		values = convertS(settings.getParameters());
	}

	public PluginConfiguration(ObjectType settings) {
		values = convert(settings.getParameters());
	}


	private Map<String, Object> convertS(List<SParameter> parameters){
		Map<String, Object> values = new HashMap<>();
		for (SParameter parameter : parameters) {
			SType value = parameter.getValue();
			if(value != null){
				String name = parameter.getIdentifier();
				values.put(name, convert(value));
			}
		}
		return values;
	}

	private Object convert(SType value){
		if (value instanceof SBooleanType) {
			return ((SBooleanType)value).isValue();
		} else if (value instanceof SStringType) {
			return ((SStringType)value).getValue();
		} else if (value instanceof SLongType) {
			return ((SLongType)value).getValue();
		} else if (value instanceof SDoubleType) {
			return ((SDoubleType)value).getValue();
		} else if (value instanceof SArrayType) {
			List<Object> values = new ArrayList<>();
			for (SType val: ((SArrayType)value).getValues()){
				values.add(convert(val));
			}
			return values;
		} else if (value instanceof SByteArrayType) {
			return ((SByteArrayType)value).getValue();
		} else if (value instanceof SObjectType) {
			return convertS(((SObjectType) value).getParameters());
		} else {
			throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
		}

	}
	
	private Map<String, Object> convert(List<Parameter> parameters) {
		Map<String, Object> settings = new HashMap<>();
		for(Parameter parameter : parameters) {
			String settingName = parameter.getIdentifier();
			Type parameterValue = parameter.getValue();
			if (parameterValue!= null) {
				Object settingValue = convert(parameterValue);
				settings.put(settingName, settingValue);
			}
		}
		return settings;
	}

	private Object convert(Type value){
			if (value instanceof BooleanType) {
				return ((BooleanType)value).isValue();
			} else if (value instanceof StringType) {
				return ((StringType)value).getValue();
			} else if (value instanceof LongType) {
				return ((LongType)value).getValue();
			} else if (value instanceof ByteArrayType) {
				return ((ByteArrayType)value).getValue();
			} else if (value instanceof DoubleType) {
				return ((DoubleType)value).getValue();
			} else if (value instanceof ArrayType) {
				List<Object> values = new ArrayList<>();
				for (Type val : ((ArrayType)value).getValues()){
					values.add(convert(val));
				}
				return values;
			} else if (value instanceof ObjectType) {
				return convert(((ObjectType) value).getParameters());
			} else {
				throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
			}
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

	public Boolean getBoolean(String name, boolean defaultValue) {
		Boolean value = (Boolean)get(name);
		if (value == null) {
			return defaultValue;
		}
		return value;
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

	public SObjectType toSObjectType() {
		SObjectType objectType = new SObjectType();
		
		return objectType;
	}

	public static PluginConfiguration fromDefaults(ObjectDefinition settingsDefinition) {
		if (settingsDefinition == null) {
			return null;
		}
		PluginConfiguration pluginConfiguration = new PluginConfiguration();
		for (ParameterDefinition parameterDefinition : settingsDefinition.getParameters()) {
			if (parameterDefinition.getDefaultValue() != null) {
				Type value = parameterDefinition.getDefaultValue();
				Object newValue = null;
				if (value instanceof PrimitiveType) {
					if (value instanceof BooleanType) {
						newValue = ((BooleanType)value).isValue();
					} else if (value instanceof StringType) {
						newValue = ((StringType)value).getValue();
					} else if (value instanceof DoubleType) {
						newValue = ((DoubleType)value).getValue();
					} else if (value instanceof LongType) {
						newValue = ((LongType)value).getValue();
					} else if (value instanceof ByteArrayType) {
						newValue = ((ByteArrayType)value).getValue();
					}
				} else if (value instanceof ArrayType) {
					throw new NotImplementedException("ArrayType not implemented");
				} else if (value instanceof ObjectType) {
					throw new NotImplementedException("ObjectType not implemented");
				}
				pluginConfiguration.values.put(parameterDefinition.getIdentifier(), newValue);
			}
		}
		return pluginConfiguration;
	}

	public ObjectNode convertToReportJson(ObjectMapper objectMapper){
		return convertToReportJson(values, objectMapper);
	}

	private ObjectNode convertToReportJson(Map<String, Object> parameters, ObjectMapper mapper) {
		ObjectNode jsonSettings = mapper.createObjectNode();
		for(Map.Entry<String, Object> parameter : parameters.entrySet()) {
			String settingName = parameter.getKey();
			Object settingValue = parameter.getValue();
			JsonNode jsonValue = convertToReportJson(settingValue, mapper);
			jsonSettings.put(settingName, jsonValue);
		}
		return jsonSettings;
	}

	private JsonNode convertToReportJson(Object value, ObjectMapper mapper){
		if(value instanceof Boolean) {
			return mapper.convertValue(value, BooleanNode.class);
		} else if (value instanceof Double){
			return mapper.convertValue(value, DoubleNode.class);
		} else  if (value instanceof Long) {
			return mapper.convertValue(value, LongNode.class);
		} else if (value instanceof String) {
			return mapper.convertValue(value, TextNode.class);
		} else if(value instanceof Map){
			return convertToReportJson((Map<String, Object>) value, mapper);
		} else if (value instanceof List){
			ArrayNode arrayNode = mapper.createArrayNode();
			for(Object element: (List<Object>) value){
				arrayNode.add(convertToReportJson(element, mapper));
			}
			return arrayNode;
		} else if(value instanceof byte[]){
			return mapper.convertValue(value, BinaryNode.class);
		} else {
			throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
		}
	}

	public void convertToReportHtml(StringBuilder builder){
		convertToReportHtml(values, builder);
	}

	private void convertToReportHtml(Map<String, Object> parameters, StringBuilder builder) {
		builder.append("<table><tbody>");
		for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
			String settingName = parameter.getKey();
			Object settingValue = parameter.getValue();
			builder.append("<tr><td>" + settingName + "</td><td>");
			convertToReportHtml(settingValue, builder);
			builder.append("</td></tr>");
		}
		builder.append("</tbody></table>");
	}

	private void convertToReportHtml(Object value, StringBuilder builder) {
		if (value instanceof Boolean) {
			builder.append(value);
		} else if (value instanceof Double) {
			builder.append(value);
		} else if (value instanceof Long) {
			builder.append(value);
		} else if (value instanceof String) {
			builder.append(value);
		} else if (value instanceof Map) {
			convertToReportHtml((Map<String, Object>) value, builder);
		} else if (value instanceof List) {
			builder.append("<table><tbody>");
			for (Object element : (List<Object>) value) {
				builder.append("<tr><td>.</td><td>");
				convertToReportHtml(element, builder);
				builder.append("</td></tr>");
			}
			builder.append("</tbody></table>");
		} else if (value instanceof byte[]) {
			builder.append("binary data: " + Base64.getEncoder().encodeToString((byte[]) value));
		} else {
			throw new RuntimeException("Unimplemented type: " + value.getClass().getName());
		}
	}

}