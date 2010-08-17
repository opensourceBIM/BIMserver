package org.bimserver.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCompareResult {

	public static class Item {

		public final DataObject dataObject;
		public final Type type;

		public Item(DataObject dataObject, Type type) {
			this.dataObject = dataObject;
			this.type = type;
		}
	}

	public static enum Type {
		ADDED, DELETED, MODIFIED;
	}

	private Map<String, List<Item>> items = new HashMap<String, List<Item>>();

	public int size() {
		int size = 0;
		for (List<Item> list : items.values()) {
			size += list.size();
		}
		return size;
	}

	public Map<String, List<Item>> getItems() {
		return items;
	}

	public void add(Item item) {
		if (!items.containsKey(item.dataObject.getType())) {
			items.put(item.dataObject.getType(), new ArrayList<Item>());
		}
		items.get(item.dataObject.getType()).add(item);
	}
}