package org.bimserver.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCompareResult {

	public enum SCompareIdentifier {
		GUID_ID("GUID"),
		NAME_ID("Name");
		
		private final String niceName;

		private SCompareIdentifier(String niceName) {
			this.niceName = niceName;
		}

		public String getNiceName() {
			return niceName;
		}
	}
	
	public enum SCompareType {
		ALL("All"),
		ADD("Added"),
		MODIFY("Modified"),
		DELETE("Deleted");
		
		private final String niceName;

		SCompareType(String niceName) {
			this.niceName = niceName;
		}
		
		public String getNiceName() {
			return niceName;
		}
	}
	
	public static abstract class SItem {

		public final SDataObject dataObject;

		public SItem(SDataObject dataObject) {
			this.dataObject = dataObject;
		}
	}

	public static class SObjectAdded extends SItem {
		public SObjectAdded(SDataObject dataObject) {
			super(dataObject);
		}
	}
	
	public static class SObjectRemoved extends SItem {
		public SObjectRemoved(SDataObject dataObject) {
			super(dataObject);
		}
	}
	
	public static class SObjectModified extends SItem {
		private final String fieldName;
		private final String oldValue;
		private final String newValue;

		public SObjectModified(SDataObject dataObject, String fieldName, String oldValue, String newValue) {
			super(dataObject);
			this.fieldName = fieldName;
			this.oldValue = oldValue;
			this.newValue = newValue;
		}

		public String getFieldName() {
			return fieldName;
		}

		public String getOldValue() {
			return oldValue;
		}

		public String getNewValue() {
			return newValue;
		}
	}

	private final Map<String, List<SItem>> items = new HashMap<String, List<SItem>>();

	public int size() {
		int size = 0;
		for (List<SItem> list : items.values()) {
			size += list.size();
		}
		return size;
	}

	public Map<String, List<SItem>> getItems() {
		return items;
	}

	public void add(SItem item) {
		if (!items.containsKey(item.dataObject.getType())) {
			items.put(item.dataObject.getType(), new ArrayList<SItem>());
		}
		items.get(item.dataObject.getType()).add(item);
	}
}