package org.bimserver.shared.json;

import org.apache.http.conn.HttpHostConnectException;
import org.bimserver.plugins.deserializers.DeserializerErrorCode;
import org.bimserver.shared.exceptions.DefaultErrorCode;

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

import org.bimserver.shared.exceptions.ErrorCode;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.bimserver.shared.reflector.ReflectorException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class JsonReflector implements Reflector {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final JsonConverter converter;
	private final SServicesMap servicesMap;

	public JsonReflector(SServicesMap servicesMap) {
		if (servicesMap == null) {
			throw new IllegalArgumentException("servicesMap cannot be null");
		}
		this.servicesMap = servicesMap;
		this.converter = new JsonConverter(servicesMap);
	}

	@Override
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
		try {
			ObjectNode request = OBJECT_MAPPER.createObjectNode();
			request.put("interface", interfaceName);
			request.put("method", methodName);
			ObjectNode parameters = OBJECT_MAPPER.createObjectNode();
			for (KeyValuePair arg : args) {
				parameters.set(arg.getFieldName(), converter.toJson(arg.getValue()));
			}
			request.set("parameters", parameters);
			ObjectNode requestObject = OBJECT_MAPPER.createObjectNode();
			requestObject.set("request", request);
			JsonNode jsonResult = call(requestObject);
			if (!isOneWay()) {
				if (jsonResult == null) {
					return null;
				}
				ObjectNode response = (ObjectNode) jsonResult.get("response");
				if (response.has("exception")) {
					ObjectNode exceptionJson = (ObjectNode) response.get("exception");
					String exceptionType = exceptionJson.get("__type").asText();
					String message = exceptionJson.has("message") ? exceptionJson.get("message").asText() : "unknown";
					if (exceptionType.equals(UserException.class.getSimpleName())) {
						if (exceptionJson.has("errorCode")) {
							String errorType = exceptionJson.get("errorType").asText();
							if (errorType.equals("DefaultErrorCode")) {
								throw new UserException(message, DefaultErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
							} else if (errorType.contentEquals("DeserializerErrorCode")) {
								throw new UserException(message, DeserializerErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
							} else {
								throw new UserException(message, ErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
							}
						} else {
							throw new UserException(message);
						}
					} else if (exceptionType.equals(ServerException.class.getSimpleName())) {
						String errorType = exceptionJson.get("errorType").asText();
						if (errorType.equals("DefaultErrorCode")) {
							throw new ServerException(message, DefaultErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
						} else if (errorType.contentEquals("DeserializerErrorCode")) {
							throw new ServerException(message, DeserializerErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
						} else {
							throw new ServerException(message, ErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
						}
					} else {
						if (exceptionJson.has("errorCode")) {
							throw new ServerException(message, ErrorCode.fromCode(exceptionJson.get("errorCode").asInt()));
						} else {
							throw new ServerException(message);
						}
					}
				} else if (response.has("result")) {
					Object result = response.get("result");
					SMethod method = servicesMap.getBySimpleName(interfaceName).getSMethod(methodName);
					return converter.fromJson(method.getReturnType(), method.getGenericReturnType(), result);
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (HttpHostConnectException e) {
			throw new UserException(e.getMessage(), DefaultErrorCode.HTTP_CONNECTION_REFUSED);
		} catch (UserException e) {
			throw e;
		} catch (ServerException e) {
			throw e;
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	protected boolean isOneWay() {
		return false;
	}

	public abstract JsonNode call(ObjectNode request) throws ReflectorException;

	public void close() {
	}
	
	public JsonConverter getConverter() {
		return converter;
	}
}