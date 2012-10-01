package org.bimserver.client;

import java.util.Map;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public abstract class JsonReflector implements Reflector {

	private JsonConverter converter;
	private Map<String, SService> services;

	public JsonReflector(Map<String, SService> services) {
		this.services = services;
		converter = new JsonConverter(services);
	}

	@Override
	public Object callMethod(String interfaceName, String methodName, Class<?> definedReturnType, KeyValuePair... args) throws ServerException, UserException {
		try {
			JSONObject request = new JSONObject();
			request.put("interface", interfaceName);
			request.put("method", methodName);
			JSONObject parameters = new JSONObject();
			for (KeyValuePair arg : args) {
				parameters.put(arg.getFieldName(), converter.toJson(arg.getValue()));
			}
			request.put("parameters", parameters);
			JSONObject requestObject = new JSONObject();
			JSONArray requests = new JSONArray();
			requests.put(request);
			requestObject.put("requests", requests);
			JSONObject jsonResult = call(requestObject);
			if (!isOneWay()) {
				JSONArray responses = jsonResult.getJSONArray("responses");
				JSONObject response = responses.getJSONObject(0);
				if (response.has("exception")) {
					JSONObject exceptionJson = response.getJSONObject("exception");
					String exceptionType = exceptionJson.getString("__type");
					String message = exceptionJson.has("message") ? exceptionJson.getString("message") : "unknown";
					if (exceptionType.equals(UserException.class.getSimpleName())) {
						throw new UserException(message);
					} else if (exceptionType.equals(ServerException.class.getSimpleName())) {
						throw new ServerException(message);
					}
				} else if (response.has("result")) {
					Object result = response.get("result");
					SMethod method = services.get(interfaceName).getSMethod(methodName);
					return converter.fromJson(method.getReturnType(), method.getGenericReturnType(), result);
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected boolean isOneWay() {
		return false;
	}

	public abstract JSONObject call(JSONObject request) throws JSONException;
}