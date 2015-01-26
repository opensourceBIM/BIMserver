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

import org.bimserver.charting.Charts.ClusterForce;
import org.bimserver.charting.ColorScales.LinearColorScale;

public class TestClusterForce extends BaseChartTest {

	public static void main(String[] args) {
		// Get data.
		getOrderedRandomData(rawData);
		// Get chart.
		ClusterForce chart = new ClusterForce();
		chart.setDimensionLookupKey("clusters", "A");
		chart.setDimensionLookupKey("size", "B");
		chart.setDimensionLookupKey("color", "A");
		chart.setDimensionLookupKey("label", "C");
		chart.setOption("Diameter", 700);
		chart.setOption("Padding", 5);
		chart.setOption("Show Labels", true);
		chart.setOption("Color Scale", new LinearColorScale());
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		//
		int n = 50;
		final int groups = 3;
		final int range = 1000000;
		final Random r = new Random();
		while (n > 0) {
			rawData.add(new LinkedHashMap<String, Object>() {{
				put("A", r.nextInt(groups));
				put("B", r.nextInt(range));
				put("C", r.nextInt(range));
			}});
			n--;
		}
	}

	public static void getOrderedRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		final int groups = 5;
		final int range = 1000000;
		final Random r = new Random();
		for (int i = groups; i > 0; i--) {
			int n = 10;
			while (n > 0) {
				LinkedHashMap<String, Object> row = new LinkedHashMap<>();
				row.put("A", i);
				row.put("B", r.nextInt(range));
				row.put("C", r.nextInt(range));
				//
				rawData.add(row);
				n--;
			}
		}
	}

	/**
	 * @param rawData
	 */
	public static void getCarData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Ambassador Brougham");
				put("B", 3821);
				put("C", 73);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Ambassador DPL");
				put("B", 3850);
				put("C", 70);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Ambassador SST");
				put("B", 3672);
				put("C", 72);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Concord");
				put("B", 3265);
				put("C", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Concord");
				put("B", 3035);
				put("C", 82);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Concord");
				put("B", 3210);
				put("C", 78);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "AMC Concord");
				put("B", 3003);
				put("C", 80);
			}
		});
	}
}
