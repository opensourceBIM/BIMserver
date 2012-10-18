package org.bimserver.shared.json;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.ServicesMap;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONException;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public abstract class JsonReflector implements Reflector {

	private JsonConverter converter;
	private ServicesMap servicesMap;

	public JsonReflector(ServicesMap servicesMap) {
		this.servicesMap = servicesMap;
		converter = new JsonConverter(servicesMap);
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
					SMethod method = servicesMap.get(interfaceName).getSMethod(methodName);
					return converter.fromJson(method.getReturnType(), method.getGenericReturnType(), result);
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ConvertException e) {
			e.printStackTrace();
		} catch (ReflectorException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected boolean isOneWay() {
		return false;
	}

	public abstract JsonObject call(JsonObject request) throws JSONException, ReflectorException;
}