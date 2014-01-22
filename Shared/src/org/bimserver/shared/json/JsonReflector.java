package org.bimserver.shared.json;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.shared.exceptions.ErrorCode;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONException;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public abstract class JsonReflector implements Reflector {

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
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException, ReflectorException {
		try {
			JsonObject request = new JsonObject();
			request.add("interface", new JsonPrimitive(interfaceName));
			request.add("method", new JsonPrimitive(methodName));
			JsonObject parameters = new JsonObject();
			for (KeyValuePair arg : args) {
				parameters.add(arg.getFieldName(), converter.toJson(arg.getValue()));
			}
			request.add("parameters", parameters);
			JsonObject requestObject = new JsonObject();
			requestObject.add("request", request);
			JsonObject jsonResult = call(requestObject);
			if (!isOneWay()) {
				if (jsonResult == null) {
					return null;
				}
				JsonObject response = jsonResult.getAsJsonObject("response");
				if (response.has("exception")) {
					JsonObject exceptionJson = response.getAsJsonObject("exception");
					String exceptionType = exceptionJson.get("__type").getAsString();
					String message = exceptionJson.has("message") ? exceptionJson.get("message").getAsString() : "unknown";
					if (exceptionType.equals(UserException.class.getSimpleName())) {
						if (exceptionJson.has("errorCode")) {
							throw new UserException(message, ErrorCode.parse(exceptionJson.get("errorCode").getAsInt()));
						} else {
							throw new UserException(message);
						}
					} else if (exceptionType.equals(ServerException.class.getSimpleName())) {
						if (exceptionJson.has("errorCode")) {
							throw new ServerException(message, ErrorCode.parse(exceptionJson.get("errorCode").getAsInt()));
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
		} catch (ReflectorException e) {
			throw e;
		} catch (UserException e) {
			throw e;
		} catch (ServerException e) {
			throw e;
		} catch (Exception e) {
			throw new ReflectorException(e);
		}
		return null;
	}

	protected boolean isOneWay() {
		return false;
	}

	public abstract JsonObject call(JsonObject request) throws JSONException, ReflectorException;

	public void close() {
	}
}