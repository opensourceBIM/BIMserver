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
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;

import org.bimserver.charting.Charts.ParallelCoordinates;
import org.bimserver.charting.ColorScales.LinearColorScale;

public class TestParallelCoordinates extends BaseChartTest {

	public static void main(String[] args) {
		//
		getRandomData(rawData);
		//
		ParallelCoordinates chart = new ParallelCoordinates();
		chart.setOption("Width", 400);
		chart.setOption("Height", 300);
		// plot.setOption("Color Scale", new HSLColorScale());
		chart.setOption("Color Scale", new LinearColorScale());
		chart.setDimensionLookupKeys("dimensions", Arrays.asList("A", "B", "C", "D"));
		chart.setDimensionLookupKey("color", "E");
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		int n = 50;
		final int range = 1000000;
		final Random r = new Random();
		while (n > 0) {
			rawData.add(new LinkedHashMap<String, Object>() {
				{
					put("A", r.nextInt(range));
					put("B", r.nextInt(range));
					put("C", r.nextInt(range));
					put("D", r.nextInt(range));
					put("E", r.nextInt(range));
				}
			});
			n--;
		}
	}
}
