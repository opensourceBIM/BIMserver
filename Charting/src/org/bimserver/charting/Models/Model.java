package org.bimserver.charting.Models;

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
import java.util.LinkedHashMap;

import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Delegates.IModulateValueDelegate;
import org.bimserver.charting.Dimensions.ModelDimension;

public class Model {

	public String Title = "Untitled";
	public String Description = null;
	public ArrayList<ModelDimension> Dimensions = new ArrayList<>();

	/**
	 * @param title
	 * @param description
	 * @param dimensions
	 */
	public Model(String title, String description, ArrayList<ModelDimension> dimensions) {
		super();
		Title = title;
		Description = description;
		Dimensions = dimensions;
	}

	public boolean isValid()
	{
		// If there are not dimensions, the model is automatically valid (since there's nothing to show).
		if (Dimensions.size() == 0)
			return true;
		// Iterate dimensions.
		for (ModelDimension dimension : Dimensions) {
			// If some dimension requires more data, the model is invalid.
			if (!dimension.hasEnoughData())
				return false;
		}
		// If there are zero things left, it's valid.
		return true;
	}

	public String getInstruction()
	{
		StringBuilder builder = new StringBuilder();
		for (ModelDimension dimension : Dimensions)
		{
			if (!dimension.hasEnoughData()) {
				int missingDataDimensions = dimension.DataSetMustContainAtLeastXDimensions - dimension.getLength();
				String noun = (missingDataDimensions > 1) ? "dimensions" : "dimension";
				builder.append(String.format("%s requires at least %d more %s. ", dimension.Title, missingDataDimensions, noun));
			}
		}
		return builder.toString();
	}

	/**
	 * This method filters a list of data rows, rewriting them into a list of transformed data rows. The transformation goes from a string key to a model dimension key. Actual transformation is handled during {@link ModelDimension#filterDataEntry ModelDimension.filterDataEntry}.
	 *
	 * @param data
	 * @return
	 */
	public ChartRows filterData(ArrayList<LinkedHashMap<String, Object>> data)
	{
		// Prepare storage for the transformed data rows.
		ChartRows list = new ChartRows();
		// Iterate the existing data (in its raw and otherwise default arrangement).
		for (LinkedHashMap<String, Object> dataRow : data)
		{
			// Prepare storage for this particular data row to be transformed into.
			ChartRow transformedDataRow = new ChartRow();
			// Iterate the dimensions of the model, filtering the values such that only the necessary data is associated with the requested model dimension.
			for (ModelDimension dimension : Dimensions) {
				ArrayList<Object> filteredValue = dimension.filterDataEntry(dataRow);
				transformedDataRow.put(dimension, filteredValue);
			}
			// Add this transformed data row to the returning list.
			list.add(transformedDataRow);
		}
		// Return the list.
		return list;
	}

	/**
	 * Provide a method to facilitate getting a dimension of this model by its key.
	 *
	 * @param key
	 * @return
	 */
	public ModelDimension getDimensionByKey(String key) {
		// Iterate dimensions to find ModelDimension in question.
		for (ModelDimension dimension : Dimensions)
			if (dimension.StoreAsKey == key)
				return dimension;
		// Return an empty object.
		return null;
	}

	/**
	 * @param key
	 * @param filteredData
	 * @return
	 */
	public Object[] getDataOfDimensionAsObjectsByKey(String key, ChartRows filteredData) {
		// Get ModelDimension in question.
		ModelDimension dimension = getDimensionByKey(key);
		// Return the data.
		return filteredData.getDataOfDimensionAsObjectsByKey(dimension);
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
	public Integer getMaximumIntegerFromDimensionGivenKey(String key, Integer lowerLimit, ChartRows filteredData, IModulateValueDelegate<Integer> valueHandler) {
		ModelDimension dimension = getDimensionByKey(key);
		return filteredData.getMaximumIntegerFromDimensionGivenKey(dimension, lowerLimit, valueHandler);
	}

	public Double getMaximumDoubleFromDimensionGivenKey(String key, Double lowerLimit, ChartRows filteredData, IModulateValueDelegate<Double> valueHandler) {
		ModelDimension dimension = getDimensionByKey(key);
		return filteredData.getMaximumDoubleFromDimensionGivenKey(dimension, lowerLimit, valueHandler);
	}

	public ChartExtent getExtentFromDimensionGivenKey(String key, boolean lowerBoundIsZero, ChartRows filteredData) {
		ModelDimension dimension = getDimensionByKey(key);
		return filteredData.getExtentFromDimension(dimension, lowerBoundIsZero);
	}

	public ChartExtent getExtentFromDimensionGivenKey(String key, boolean lowerBoundIsZero, ChartRows filteredData, double worldSpaceStart, double worldSpaceEnd) {
		ModelDimension dimension = getDimensionByKey(key);
		ChartExtent extent = filteredData.getExtentFromDimension(dimension, lowerBoundIsZero);
		extent.setWorldSpace(worldSpaceStart, worldSpaceEnd);
		return extent;
	}

	public ChartExtent getExtentFromDimensionGivenKey(String key, boolean lowerBoundIsZero, ChartRows filteredData, double worldSpaceStart, double worldSpaceEnd, double defaultTickCount) {
		ModelDimension dimension = getDimensionByKey(key);
		ChartExtent extent = filteredData.getExtentFromDimension(dimension, lowerBoundIsZero);
		extent.setWorldSpace(worldSpaceStart, worldSpaceEnd);
		extent.setDefaultTickCount(defaultTickCount);
		return extent;
	}

	public boolean setDimensionLookupKey(String dimensionKey, String dataKey) {
		ModelDimension dimension = getDimensionByKey(dimensionKey);
		if (dimension != null)
			return dimension.addLookupKey(dataKey);
		return false;
	}

	public boolean setDimensionLookupKeys(String dimensionKey, Collection<String> dataKeys) {
		ModelDimension dimension = getDimensionByKey(dimensionKey);
		boolean overallSuccess = false;
		if (dimension != null) {
			overallSuccess = true;
			for (String dataKey : dataKeys) {
				boolean success = dimension.addLookupKey(dataKey);
				if (!success)
					overallSuccess = false;
			}
		}
		return overallSuccess;
	}

	public static Double getNumberOfFiguresFromDouble(Double value) {
		if (value != null) {
			String stringRepresentationOfDouble = String.format("%s", value);
			return (double)stringRepresentationOfDouble.replace(".", "").length();
		}
		else
			return 0.0;
	}

	public static int getNumberOfFiguresFromInteger(int n){
		return (n<100000)?((n<100)?((n<10)?1:2):(n<1000)?3:((n<10000)?4:5)):((n<10000000)?((n<1000000)?6:7):((n<100000000)?8:((n<1000000000)?9:10)));
	}
}
