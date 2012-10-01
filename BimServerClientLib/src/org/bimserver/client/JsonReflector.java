package org.bimserver.client;

import java.util.Map;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.json.JsonConverter;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.LoggerFactory;

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
				LoggerFactory.getLogger(JsonReflector.class).info(jsonResult.toString(2));
				JSONArray responses = jsonResult.getJSONArray("responses");
				JSONObject response = responses.getJSONObject(0);
				if (response.has("exception")) {
					JSONObject exceptionJson = jsonResult.getJSONObject("exception");
					String exceptionType = exceptionJson.getString("__type");
					if (exceptionType.equals(UserException.class.getName())) {
						throw new UserException(exceptionJson.getString("message"));
					} else if (exceptionType.equals(ServerException.class.getName())) {
						throw new ServerException(exceptionJson.getString("message"));
					}
				} else if (response.has("result")) {
					Object result = jsonResult.get("result");
					return converter.fromJson(services.get(interfaceName).getSMethod(methodName).getBestReturnType(), result);
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