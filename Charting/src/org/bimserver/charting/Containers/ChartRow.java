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
import java.util.LinkedHashMap;
import java.util.Map;

import org.bimserver.charting.Dimensions.ModelDimension;

public class ChartRow extends LinkedHashMap<ModelDimension, ArrayList<Object>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4225308622615898898L;

	/**
	 * This class is intended to replace a generic class, LinkedHashMap<ModelDimension, ArrayList<Object>>, to better logically represent a row in a chart's final data structure.
	 */
	public ChartRow() {
		super();
	}

	/**
	 * @param initialCapacity
	 * @param loadFactor
	 * @param accessOrder
	 */
	public ChartRow(int initialCapacity, float loadFactor, boolean accessOrder) {
		super(initialCapacity, loadFactor, accessOrder);
	}

	/**
	 * @param initialCapacity
	 * @param loadFactor
	 */
	public ChartRow(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * @param initialCapacity
	 */
	public ChartRow(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param m
	 */
	public ChartRow(Map<? extends ModelDimension, ? extends ArrayList<Object>> m) {
		super(m);
	}

	public ArrayList<Object> getValueListByDimensionId(String id) {
		for (ModelDimension dimension : keySet())
			if (dimension.StoreAsKey == id)
				return get(dimension);
		return null;
	}
}
