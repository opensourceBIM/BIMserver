package org.bimserver.charting.Dimensions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Provides a class that consumes 1 or more keys in a data entry, yielding a correctly named entry. This class does not store data. In densitydesign/raw, objects of the analogous class are used directly as functions, like: dimensionObject(fullDataEntryInSet). After the use, the data is translated into just the applicable data. So, the first element of [{'A': 1, 'B': '2', 'C': 3}, ...] pushed into some dimension, "X", that looks for key "A" would yield the value: 1. In this version, this functionality is covered by {@link ModelDimension#filterDataEntry ModelDimension.filterDataEntry}.
 */
public class ModelDimension {

	public static final int compareNatural(String s1, String s2) {
		// Skip all identical characters.
		int len1 = s1.length();
		int len2 = s2.length();
		int i;
		char c1, c2;
		// Iterate to the appropriate part.
		for (i = 0, c1 = 0, c2 = 0; (i < len1) && (i < len2) && (c1 = s1.charAt(i)) == (c2 = s2.charAt(i)); i++)
			;
		// Check end of string.
		if (c1 == c2)
			return (len1 - len2);
		// Check digit in first string.
		if (Character.isDigit(c1)) {
			// Check digit only in first string.
			if (!Character.isDigit(c2))
				return ((i > 0) && Character.isDigit(s1.charAt(i - 1)) ? 1 : c1 - c2);
			// Scan all integer digits.
			int x1, x2;
			for (x1 = i + 1; (x1 < len1) && Character.isDigit(s1.charAt(x1)); x1++)
				;
			for (x2 = i + 1; (x2 < len2) && Character.isDigit(s2.charAt(x2)); x2++)
				;
			// Longer integer wins, first digit otherwise.
			return (x2 == x1 ? c1 - c2 : x1 - x2);
		}
		// Check digit only in second string.
		if (Character.isDigit(c2))
			return ((i > 0) && Character.isDigit(s2.charAt(i - 1)) ? -1 : c1 - c2);
		// No digits
		return (c1 - c2);
	}

	/**
	 * Non-primitive numbers only.
	 */
	public static final ArrayList<Class> NumbersOnly = new ArrayList<Class>() {{
		add(Number.class);
	}};
	/**
	 * Strings only.
	 */
	public static final ArrayList<Class> TextOnly = new ArrayList<Class>() {{
		add(String.class);
	}};
	/**
	 * Dates (java.util.Date) only.
	 */
	public static final ArrayList<Class> DatesOnly = new ArrayList<Class>() {{
		add(Date.class);
	}};
	/**
	 * Non-primitive numbers and dates (java.util.Date).
	 */
	public static final ArrayList<Class> NumbersAndDatesOnly = new ArrayList<Class>() {{
		add(Number.class);
		add(Date.class);
	}};
	/**
	 * Non-primitive numbers, strings, and dates (java.util.Date).
	 */
	public static final ArrayList<Class> DefaultTypes = new ArrayList<Class>() {{
		add(Number.class);
		add(String.class);
		add(Date.class);
	}};

	//
	public String Title = "Untitled";
	public String StoreAsKey = null;
	public String Description = "";
	// Internally, these types are never checked as most things are converted to numbers (specifically, Double objects); the exception are String objects.
	public ArrayList<Class> Types = DefaultTypes;
	// Replaces "required" variable in densitydesign/raw.
	public int DataSetMustContainAtLeastXDimensions = 0;
	// Determines whether or not multiple values can be used. Specifically, if more than one value will be stored in KeysToBeFiltered. Replaces "multiple" variable in densitydesign/raw.
	public boolean AllowMultipleValues = false;
	// Should contain a map able to translate between the keys of incoming data entry sets and dimension names, such that a data entry set, {"A": 1, "B": 2, "C": 3}, with key "A" for dimension containing entries, {"X": "A", ...}, would help yield a new data entry set containing {"X": 1, ...}.
	public ArrayList<String> KeysToBeFiltered = new ArrayList<>();

	/**
	 * Construct a completely explicit definition of this object.
	 * 
	 * @param title
	 * @param storeAsKey
	 * @param description
	 * @param types
	 * @param dataSetMustContainAtLeastXDimensions
	 * @param allowMultipleValues
	 * @param keysToBeFiltered
	 */
	public ModelDimension(String title, String storeAsKey, String description, ArrayList<Class> types, int dataSetMustContainAtLeastXDimensions, boolean allowMultipleValues, ArrayList<String> keysToBeFiltered) {
		super();
		Title = title;
		StoreAsKey = storeAsKey;
		Description = description;
		Types = types;
		DataSetMustContainAtLeastXDimensions = dataSetMustContainAtLeastXDimensions;
		AllowMultipleValues = allowMultipleValues;
		KeysToBeFiltered = keysToBeFiltered;
	}

	/**
	 * @param title
	 * @param storeAsKey
	 * @param description
	 * @param types
	 * @param dataSetMustContainAtLeastXDimensions
	 * @param allowMultipleValues
	 */
	public ModelDimension(String title, String storeAsKey, String description, ArrayList<Class> types, int dataSetMustContainAtLeastXDimensions, boolean allowMultipleValues) {
		this(title, storeAsKey, description, types, dataSetMustContainAtLeastXDimensions, allowMultipleValues, new ArrayList<String>());
	}

	public int getLength() {
		return getCurrentDataKeyConsumptionCount();
	}

	public boolean hasEnoughData() {
		return (DataSetMustContainAtLeastXDimensions <= getCurrentDataKeyConsumptionCount());
	}

	public int getCurrentDataKeyConsumptionCount() {
		return KeysToBeFiltered.size();
	}

	public boolean canBeMultidimensional() {
		return AllowMultipleValues;
	}

	/**
	 * Filter data entry such that a data row's data will be rewritten to just a standard list of values. These values are used as the values accessible via this ModelDimension object, as put together by {@link Model#filterData Model.filterData}.
	 * 
	 * @param dataRow
	 * @return
	 */
	public ArrayList<Object> filterDataEntry(HashMap<String, Object> dataRow) {
		// Prepare storage for the list of values.
		ArrayList<Object> list = new ArrayList<>();
		// Iterate the keys.
		for (String dataRowKey : KeysToBeFiltered) {
			if (dataRow.containsKey(dataRowKey))
				list.add(dataRow.get(dataRowKey));
		}
		// Send out: ArrayList<Object>
		return list;
	}

	public boolean addLookupKey(String key) {
		boolean alreadyExists = KeysToBeFiltered.contains(key);
		boolean canAdd = (AllowMultipleValues && !alreadyExists) || (KeysToBeFiltered.size() == 0);
		if (canAdd)
			KeysToBeFiltered.add(key);
		return canAdd;
	}
}
