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

public class LinearColorScale extends GroupedChartExtents<String> {

	// Provide an extent that goes from 0 to 1, transforming data to #f7fbff to #08306b.
	private static final List<ChartExtent> DefaultExtents = Arrays.asList(
		// Red.
		new ChartExtent(0.0, 1.0, 100 * 247.0 / 255.0, 100 * 8.0 / 255.0),
		// Green.
		new ChartExtent(0.0, 1.0, 100 * 251.0 / 255.0, 100 * 48.0 / 255.0),
		// Blue.
		new ChartExtent(0.0, 1.0, 100 * 255.0 / 255.0, 100 * 107.0 / 255.0)
	);
	private static final IModulateObjectDelegate<String> DefaultHandler = new IModulateObjectDelegate<String>() {
		@Override
		public String modulate(Object[] args) {
			// Format RGB color using r, g, b values in terms of 0 to 100.
			if (args.length == 3)
				return String.format("rgb(%s%%, %s%%, %s%%)", args[0], args[1], args[2]);
			return "none";
		}
	}; 

	public LinearColorScale() {
		super(DefaultExtents, DefaultHandler);
	}
}