package org.bimserver.shared.json;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.io.IOException;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public abstract class JsonReflector implements Reflector {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonReflector.class);
	private final JsonConverter converter;
	private final ServicesMap servicesMap;

	public JsonReflector(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
		this.converter = new JsonConverter(servicesMap);
	}

	@Override
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
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
						throw new UserException(message);
					} else if (exceptionType.equals(ServerException.class.getSimpleName())) {
						throw new ServerException(message);
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
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (ConvertException e) {
			LOGGER.error("", e);
		} catch (ReflectorException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	protected boolean isOneWay() {
		return false;
	}

	public abstract JsonObject call(JsonObject request) throws JSONException, ReflectorException;
}