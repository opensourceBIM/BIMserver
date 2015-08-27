package org.bimserver.charting.Containers;

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
import java.util.Collection;
import java.util.Date;

import org.bimserver.charting.Delegates.IModulateValueDelegate;
import org.bimserver.charting.Dimensions.ModelDimension;

public class ChartRows extends ArrayList<ChartRow> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4418653975462360616L;

	/**
	 * 
	 */
	public ChartRows() {
		super();
	}

	/**
	 * @param c
	 */
	public ChartRows(Collection<? extends ChartRow> c) {
		super(c);
	}

	/**
	 * @param initialCapacity
	 */
	public ChartRows(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param dimension
	 * @return
	 */
	public Object[] getDataOfDimensionAsObjectsByKey(ModelDimension dimension) {
		// Prepare a place to store flattened data.
		ArrayList<Object> list = new ArrayList<>();
		// If the dimension is found, iterate the filtered data, looking for the model dimension as a key of each entry.
		if (dimension != null)
			for (ChartRow row : this)
				for (Object dataValue : row.get(dimension))
					list.add(dataValue);
		// Send it back.
		return list.toArray();
	}

	/**
	 * Provide a way to get the maximum value of a sequence. Includes ability to specify a lower limit. Includes ability to specify a per-row handler.
	 *
	 * @param key
	 * @param lowerLimit
	 * @param filteredData
	 * @param valueHandler
	 * @return
	 */
	public Integer getMaximumIntegerFromDimensionGivenKey(ModelDimension dimension, Integer lowerLimit, IModulateValueDelegate<Integer> valueHandler) {
		Integer max = lowerLimit;
		if (dimension != null) {
			for (ChartRow row : this) {
				for (Object dataValue : row.get(dimension)) {
					Integer value = (Integer)dataValue;
					if (valueHandler != null)
						value = valueHandler.modulate(value);
					if (max == null || max < value)
						max = value;
				}
			}
		}
		return max;
	}

	/**
	 * Provide a way to get the maximum value of a sequence. Includes ability to specify a lower limit. Includes ability to specify a per-row handler.
	 *
	 * @param dimension
	 * @param lowerLimit
	 * @param filteredData
	 * @param valueHandler
	 * @return
	 */
	public Double getMaximumDoubleFromDimensionGivenKey(ModelDimension dimension, Double lowerLimit, IModulateValueDelegate<Double> valueHandler) {
		Double max = lowerLimit;
		if (dimension != null) {
			for (ChartRow row : this) {
				for (Object dataValue : row.get(dimension)) {
					Double value = null;
					// Coerce desired type.
					if (dataValue instanceof Double)
						value = (Double)dataValue;
					else if (dataValue instanceof Number)
						value = ((Number)dataValue).doubleValue();
					else if (dataValue instanceof Date)
						value = (double)((Date)dataValue).getTime(); 
					//
					if (valueHandler != null)
						value = valueHandler.modulate(value);
					if (max == null || max < value)
						max = value;
				}
			}
		}
		return max;
	}

	public ChartExtent getExtentFromDimension(ModelDimension dimension, boolean lowerBoundIsZero) {
		ArrayList<Number> list = new ArrayList<>();
		boolean canTreatAllDataAsDates = false;
		if (dimension != null) {
			canTreatAllDataAsDates = true;
			for (Object data : getDataOfDimensionAsObjectsByKey(dimension))
				// Pass the number through.
				if (data instanceof Number) {
					list.add((Number)data);
					canTreatAllDataAsDates = false;
				}
				// Get date as time in milliseconds from January 1st, 1970.
				else if (data instanceof Date)
					list.add((Number)((Date)data).getTime());
				// Get hash code of String as integer.
				else if (data instanceof String) {
					list.add(((String)data).hashCode());
					canTreatAllDataAsDates = false;
				}
		}
		return new ChartExtent(lowerBoundIsZero, canTreatAllDataAsDates, list);
	}

	public boolean isDataInDimensionAllDates(ModelDimension dimension) {
		boolean canTreatAllDataAsDates = false;
		if (dimension != null) {
			canTreatAllDataAsDates = true;
			for (Object data : getDataOfDimensionAsObjectsByKey(dimension))
				if (!(data instanceof Date))
					canTreatAllDataAsDates = false;
		}
		return canTreatAllDataAsDates;
	}
}
