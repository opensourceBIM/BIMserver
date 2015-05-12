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

import org.bimserver.charting.Charts.SmallMultiplesArea;

public class TestSmallMultiplesArea extends BaseChartTest {

	public static void main(String[] args) {
		// Get data.
		getOrderedRandomData(rawData);
		// Get chart.
		SmallMultiplesArea chart = new SmallMultiplesArea();
		chart.setDimensionLookupKey("group", "A");
		chart.setDimensionLookupKey("date", "B");
		chart.setDimensionLookupKey("size", "C");
		chart.setOption("Width", 700);
		chart.setOption("Height", 700);
		chart.setOption("Padding", 10);
		chart.setOption("Use Same Scale", false);
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getOrderedRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		final int groups = 5;
		final int range = 1000000;
		final Random r = new Random();
		for (int i = groups; i > 0; i--) {
			int n = 100;
			while (n > 0) {
				LinkedHashMap<String, Object> row = new LinkedHashMap<>();
				row.put("A", i);
				row.put("B", n);
				row.put("C", r.nextInt(range));
				//
				rawData.add(row);
				n--;
			}
		}
	}
}
