package org.bimserver.shared.json;

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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.activation.DataHandler;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.utils.ByteArrayDataSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.google.common.base.Charsets;

public class JsonConverter {

	private final SServicesMap servicesMap;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public JsonConverter(SServicesMap servicesMap) {
		this.servicesMap = servicesMap;
	}

//	public void toJson(Object object, ObjectMapper objectMapper) throws IOException, SerializerException {
//		if (object instanceof SBase) {
//			SBase base = (SBase) object;
//			out.beginObject();
//			out.name("__type");
//			out.value(base.getSClass().getSimpleName());
//			for (SField field : base.getSClass().getAllFields()) {
//				out.name(field.getName());
//				toJson(base.sGet(field), out);
//			}
//			out.endObject();
//		} else if (object instanceof Collection) {
//			Collection<?> collection = (Collection<?>) object;
//			out.beginArray();
//			for (Object value : collection) {
//				toJson(value, out);
//			}
//			out.endArray();
//		} else if (object instanceof Date) {
//			out.value(((Date) object).getTime());
//		} else if (object instanceof DataHandler) {
//			DataHandler dataHandler = (DataHandler) object;
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			if (dataHandler.getDataSource() instanceof CacheStoringEmfSerializerDataSource) {
//				CacheStoringEmfSerializerDataSource cacheStoringEmfSerializerDataSource = (CacheStoringEmfSerializerDataSource) dataHandler.getDataSource();
//				cacheStoringEmfSerializerDataSource.writeToOutputStream(baos, null);
//				out.value(new String(Base64.encodeBase64(baos.toByteArray()), Charsets.UTF_8));
//			} else {
//				InputStream inputStream = dataHandler.getInputStream();
//				IOUtils.copy(inputStream, baos);
//				out.value(new String(Base64.encodeBase64(baos.toByteArray()), Charsets.UTF_8));
//			}
//		} else if (object instanceof byte[]) {
//			byte[] data = (byte[]) object;
//			out.value(new String(Base64.encodeBase64(data), Charsets.UTF_8));
//		} else if (object instanceof String) {
//			out.value((String) object);
//		} else if (object instanceof Number) {
//			out.value((Number) object);
//		} else if (object instanceof Enum) {
//			out.value(object.toString());
//		} else if (object instanceof Boolean) {
//			out.value((Boolean) object);
//		} else if (object == null) {
//			out.nullValue();
//		} else {
//			throw new UnsupportedOperationException(object.toString());
//		}
//	}

	public JsonNode toJson(Object object) throws IOException {
		if (object instanceof SBase) {
			SBase base = (SBase) object;
			ObjectNode jsonObject = OBJECT_MAPPER.createObjectNode();
			jsonObject.put("__type", base.getSClass().getSimpleName());
			for (SField field : base.getSClass().getAllFields()) {
				jsonObject.set(field.getName(), toJson(base.sGet(field)));
			}
			return jsonObject;
		} else if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>) object;
			ArrayNode jsonArray = OBJECT_MAPPER.createArrayNode();
			for (Object value : collection) {
				jsonArray.add(toJson(value));
			}
			return jsonArray;
		} else if (object instanceof Date) {
			return new LongNode(((Date) object).getTime());
		} else if (object instanceof DataHandler) {
			DataHandler dataHandler = (DataHandler) object;
			InputStream inputStream = dataHandler.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			IOUtils.copy(inputStream, out);
			return new TextNode(new String(Base64.encodeBase64(out.toByteArray()), Charsets.UTF_8));
		} else if (object instanceof Boolean) {
			return BooleanNode.valueOf((Boolean) object);
		} else if (object instanceof String) {
			return new TextNode((String) object);
		} else if (object instanceof Long) {
			return new LongNode((Long) object);
		} else if (object instanceof UUID) {
			return new TextNode(((UUID) object).toString());
		} else if (object instanceof Integer) {
			return new IntNode((Integer) object);
		} else if (object instanceof Double) {
			return new DoubleNode((Double) object);
		} else if (object instanceof Float) {
			return new FloatNode((Float) object);
		} else if (object instanceof Enum) {
			return new TextNode(object.toString());
		} else if (object == null) {
			return NullNode.getInstance();
		} else if (object instanceof byte[]) {
			byte[] data = (byte[]) object;
			return new TextNode(new String(Base64.encodeBase64(data), Charsets.UTF_8));
		}
		throw new UnsupportedOperationException(object.getClass().getName());
	}
	
	public Object fromJson(SClass definedType, SClass genericType, Object object) throws ConvertException, IOException {
		try {
			if (object instanceof ObjectNode) {
				ObjectNode jsonObject = (ObjectNode) object;
				if (jsonObject.has("__type")) {
					String type = jsonObject.get("__type").asText();
					SClass sClass = servicesMap.getType(type);
					if (sClass == null) {
						throw new ConvertException("Unknown type: " + type);
					}
					SBase newObject = sClass.newInstance();
					for (SField field : newObject.getSClass().getAllFields()) {
						if (jsonObject.has(field.getName())) {
							newObject.sSet(field, fromJson(field.getType(), field.getGenericType(), jsonObject.get(field.getName())));
						}
					}
					return newObject;
				} else {
					Iterator<String> fieldNames = jsonObject.fieldNames();
					int nrFields = 0;
					while (fieldNames.hasNext()) {
						nrFields++;
						fieldNames.next();
					}
					if (nrFields != 0) {
						throw new ConvertException("Missing __type field in " + jsonObject.toString());
					} else {
						return null;
					}
				}
			} else if (object instanceof ArrayNode) {
				ArrayNode array = (ArrayNode) object;
				if (definedType.isList()) {
					List<Object> list = new ArrayList<Object>();
					for (int i = 0; i < array.size(); i++) {
						list.add(fromJson(definedType, genericType, array.get(i)));
					}
					return list;
				} else if (definedType.isSet()) {
					Set<Object> set = new HashSet<Object>();
					for (int i = 0; i < array.size(); i++) {
						set.add(fromJson(definedType, genericType, array.get(i)));
					}
					return set;
				}
			} else if (object instanceof NullNode) {
				return null;
			} else if (definedType.isByteArray()) {
				if (object instanceof ValueNode) {
					ValueNode jsonPrimitive = (ValueNode) object;
					return Base64.decodeBase64(jsonPrimitive.asText().getBytes(Charsets.UTF_8));
				}
			} else if (definedType.isDataHandler()) {
				if (object instanceof ValueNode) {
					ValueNode jsonPrimitive = (ValueNode) object;
					byte[] data = Base64.decodeBase64(jsonPrimitive.asText().getBytes(Charsets.UTF_8));
					return new DataHandler(new ByteArrayDataSource(null, data));
				}
			} else if (definedType.isInteger()) {
				if (object instanceof ValueNode) {
					return ((ValueNode) object).asInt();
				}
			} else if (definedType.isLong()) {
				if (object instanceof ValueNode) {
					return ((ValueNode) object).asLong();
				}
			} else if (definedType.isShort()) {
				if (object instanceof ValueNode) {
					return (short)((ValueNode) object).asInt();
				}
			} else if (definedType.isEnum()) {
				ValueNode primitive = (ValueNode) object;
				for (Object enumConstantObject : definedType.getInstanceClass().getEnumConstants()) {
					Enum<?> enumConstant = (Enum<?>) enumConstantObject;
					if (enumConstant.name().equals(primitive.asText())) {
						return enumConstant;
					}
				}
			} else if (definedType.isDate()) {
				if (object instanceof ValueNode) {
					return new Date(((ValueNode) object).asLong());
				}
			} else if (definedType.isString()) {
				if (object instanceof ValueNode) {
					return ((ValueNode) object).asText();
				} else if (object instanceof NullNode) {
					return null;
				}
			} else if (definedType.isUuid()) {
				if (object instanceof TextNode) {
					return UUID.fromString(((TextNode) object).asText());
				} else if (object instanceof NullNode) {
					return null;
				}
			} else if (definedType.isBoolean()) {
				if (object instanceof ValueNode) {
					return ((ValueNode) object).asBoolean();
				}
			} else if (definedType.isList()) {
				if (genericType.isLong()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asLong();
					}
				} else if (genericType.isInteger()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asInt();
					}
				} else if (genericType.isString()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asText();
					}
				} else if (genericType.isDouble()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asDouble();
					}
				}
			} else if (definedType.isSet()) {
				if (genericType.isLong()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asLong();
					}
				} else if (genericType.isInteger()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asInt();
					}
				} else if (genericType.isString()) {
					if (object instanceof ValueNode) {
						return ((ValueNode) object).asText();
					}
				}
			} else if (definedType.isDouble()) {
				if (object instanceof ValueNode) {
					return ((ValueNode) object).asDouble();
				}
			} else if (definedType.isFloat()) {
				if (object instanceof ValueNode) {
					return (float)((ValueNode) object).asDouble();
				}
			} else if (definedType.isVoid()) {
				return null;
			}
		} catch (NumberFormatException e) {
			throw new ConvertException(e);
		}
		throw new UnsupportedOperationException(object.toString());
	}
}