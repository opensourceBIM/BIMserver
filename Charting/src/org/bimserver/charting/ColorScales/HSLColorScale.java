package org.bimserver.charting.ColorScales;

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

import java.util.Arrays;
import java.util.List;

import org.bimserver.charting.Containers.ChartExtent;
import org.bimserver.charting.Containers.GroupedChartExtents;
import org.bimserver.charting.Delegates.IModulateObjectDelegate;

public class HSLColorScale extends GroupedChartExtents<String> {

	// Provide an extent that goes from 0 to 1, transforming data to 0 to 340.
	private static final List<ChartExtent> DefaultExtents = Arrays.asList(new ChartExtent(0.0, 1.0, 0, 340));
	private static final IModulateObjectDelegate<String> DefaultHandler = new IModulateObjectDelegate<String>() {
		@Override
		public String modulate(Object[] args) {
			// Format HSL color using hue value, only.
			if (args.length == 1)
				return String.format("hsl(%s, 40%%, 58%%)", args[0]);
			return "none";
		}
	}; 

	public HSLColorScale() {
		super(DefaultExtents, DefaultHandler);
	}
}
