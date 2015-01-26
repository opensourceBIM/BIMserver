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
import java.util.List;

import org.bimserver.charting.Delegates.IModulateObjectDelegate;
import org.bimserver.charting.Delegates.ITranslateToWorldSpace;

public class GroupedChartExtents<T> implements ITranslateToWorldSpace<T> {

	public List<ChartExtent> Extents = null;
	public IModulateObjectDelegate<T> Handler = null;

	/**
	 * @param extents
	 */
	public GroupedChartExtents(List<ChartExtent> extents, IModulateObjectDelegate<T> handler) {
		super();
		Extents = extents;
		Handler = handler;
	}

	/* (non-Javadoc)
	 * @see org.bimserver.charting.Containers.ITranslateToWorldSpace#getLinearWorldSpaceValueAtXGivenActualValue(double, boolean)
	 */
	@Override
	public T getModulatedLinearWorldSpaceValueAtXGivenActualValue(final double actualValue, boolean reverseTransformedDataOrder) {
		ArrayList<Object> worldSpaceValues = new ArrayList<Object>();
		for (ChartExtent extent : Extents) {
			Double thisWorldSpaceValue = extent.getLinearWorldSpaceValueAtXGivenActualValue(actualValue, reverseTransformedDataOrder);
			worldSpaceValues.add(thisWorldSpaceValue);
		}
		return Handler.modulate(worldSpaceValues.toArray());
	}
}
