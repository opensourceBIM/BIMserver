package org.bimserver.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.bimserver.shared.SDataObject.SDataValue;

public class MapAdapter extends XmlAdapter<List<SDataValue>, Map<String, SDataValue>> {

	@Override
	public Map<String, SDataValue> unmarshal(List<SDataValue> list) throws Exception {
		Map<String, SDataValue> values = new HashMap<String, SDataObject.SDataValue>();
		for (SDataValue value : list) {
			values.put(value.getFieldName(), value);
		}
		return values;
	}

	@Override
	public List<SDataValue> marshal(Map<String, SDataValue> values) throws Exception {
		List<SDataValue> list = new ArrayList<SDataObject.SDataValue>();
		for (String key : values.keySet()) {
			list.add(values.get(key));
		}
		return list;
	}
}