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

public class BinCollection extends ArrayList<Bin> {

	/**
	 * Lowest non-zero amount of items in 1 bin. Cached. Only determined in collection-based constructor.
	 */
	public Integer MinimumObservedLength = null;
	/**
	 * Highest non-zero amount of items in 1 bin. Cached. Only determined in collection-based constructor.
	 */
	public Integer MaximumObservedLength = null;

	/**
	 * 
	 */
	public BinCollection() {
		super();
	}

	/**
	 * @param c
	 */
	public BinCollection(Collection<? extends Bin> c) {
		super(c);
		// Cache the minimum and maximum number of items in the collective bins. 
		for (Bin bin : this) {
			int binSize = bin.size();
			if (MinimumObservedLength == null || binSize < MinimumObservedLength)
				MinimumObservedLength = binSize;
			if (MaximumObservedLength == null || binSize > MaximumObservedLength)
				MaximumObservedLength = binSize;
		}
	}

	/**
	 * @param initialCapacity
	 */
	public BinCollection(int initialCapacity) {
		super(initialCapacity);
	}

}
