package org.bimserver.charting.Testing;

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
import java.util.Random;

import org.bimserver.charting.Charts.ScatterPlot;
import org.bimserver.charting.ColorScales.HSLColorScale;

public class TestScatterPlot extends BaseChartTest {

	public static void main(String[] args) {
		//
		getRandomData(rawData);
		//
		ScatterPlot plot = new ScatterPlot();
		plot.setOption("Color Scale", new HSLColorScale());
		plot.setDimensionLookupKey("x", "A");
		plot.setDimensionLookupKey("y", "B");
		plot.setDimensionLookupKey("size", "C");
		plot.setDimensionLookupKey("color", "D");
		//plot.setDimensionLookupKey("label", "E");
		// Save chart.
		plot.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(plot.getRawTextDataSet(rawData));
	}

	public static void getRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		int n = 120;
		final Random r = new Random();
		while (n > 0) {
			rawData.add(new LinkedHashMap<String, Object>() {{
				put("A", r.nextInt(100));
				put("B", r.nextInt(100));
				put("C", r.nextInt(100));
				put("D", r.nextInt(100));
				put("E", r.nextInt(100));
			}});
			n--;
		}
	}
}
