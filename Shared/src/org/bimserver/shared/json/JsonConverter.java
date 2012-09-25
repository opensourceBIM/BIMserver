package org.bimserver.shared.json;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;
import org.bimserver.shared.meta.SService;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.common.base.Charsets;

public class JsonConverter {

	private Map<String, SService> services;

	public JsonConverter(Map<String, SService> services) {
		this.services = services;
	}
	
	public Object toJson(Object object) throws JSONException {
		if (object instanceof SBase) {
			SBase base = (SBase)object;
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("__type", base.getSClass().getName());
			for (SField field : base.getSClass().getAllFields()) {
				jsonObject.put(field.getName(), toJson(base.sGet(field)));
			}
			return jsonObject;
		} else if (object instanceof Collection) {
			Collection<?> collection = (Collection<?>)object;
			JSONArray jsonArray = new JSONArray();
			for (Object value : collection) {
				jsonArray.put(toJson(value));
			}
			return jsonArray;
		} else if (object instanceof Date) {
			return ((Date)object).getTime();
		} else if (object instanceof DataHandler) {
			DataHandler dataHandler = (DataHandler)object;
			try {
				InputStream inputStream = dataHandler.getInputStream();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				IOUtils.copy(inputStream, out);
				return new String(Base64.encodeBase64(out.toByteArray()), Charsets.UTF_8);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return object;
	}

	public SClass getType(String name) {
		for (SService sService : services.values()) {
			SClass type = sService.getSType(name);
			if (type != null) {
				return type;
			}
		}
		return null;
	}
	
	public Object fromJson(SClass definedType, Object object) throws JSONException {
		if (object instanceof JSONObject) {
			JSONObject jsonObject = (JSONObject) object;
			if (jsonObject.has("__type")) {
				String type = jsonObject.getString("__type");
				SClass sClass = getType(type);
				SBase newObject = sClass.newInstance();
				for (SField field : newObject.getSClass().getAllFields()) {
					if (jsonObject.has(field.getName())) {
						newObject.sSet(field, fromJson(field.getType(), jsonObject.get(field.getName())));
					}
				}
				return newObject;
			}
		} else if (object instanceof JSONArray) {
			JSONArray array = (JSONArray)object;
			List<Object> list = new ArrayList<Object>();
			for (int i=0; i<array.length(); i++) {
				list.add(fromJson(definedType, array.get(i)));
			}
			return list;
		} else if (definedType.isByteArray()) {
			String dataString = (String)object;
			return Base64.decodeBase64(dataString.getBytes(Charsets.UTF_8));
		} else if (definedType.isDataHandler()) {
			String dataString = (String)object;
			byte[] data = Base64.decodeBase64(dataString.getBytes(Charsets.UTF_8));
			try {
				DataHandler dataHandler = new DataHandler(new ByteArrayDataSource(new ByteArrayInputStream(data), null));
				return dataHandler;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (definedType.isLong()) {
			return ((Integer)object).longValue();
		} else if (definedType.isEnum()) {
			for (Object enumConstantObject : definedType.getInstanceClass().getEnumConstants()) {
				Enum<?> enumConstant = (Enum<?>)enumConstantObject;
				if (enumConstant.name().equals(object)) {
					return enumConstant;
				}
			}
		} else if (definedType.isDate()) {
			return new Date((Long)object);
		}
		return object;
	}
}