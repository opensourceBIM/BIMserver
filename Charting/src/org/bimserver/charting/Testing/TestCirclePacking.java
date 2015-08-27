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

import org.bimserver.charting.Charts.Packing;
import org.bimserver.charting.ColorScales.LinearColorScale;

public class TestCirclePacking extends BaseChartTest {

	public static void main(String[] args) {
		//
		getTestData(rawData);
		//
		Packing chart = new Packing();
		// chart.setDimensionLookupKeys("hierarchy", Arrays.asList("B", "A"));
		chart.setDimensionLookupKeys("hierarchy", Arrays.asList("hierarchy1", "hierarchy2"));
		chart.setDimensionLookupKey("size", "size");
		chart.setDimensionLookupKey("color", "size");
		chart.setDimensionLookupKey("label", "hierarchy2");
		chart.setOption("Diameter", 1000);
		chart.setOption("Padding", 5);
		chart.setOption("Show Labels", true);
		chart.setOption("Color Scale", new LinearColorScale());
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getTestData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Spatial Structure Element");
				put("hierarchy2", " Space (99)");
				put("size", 99);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Railing (10)");
				put("size", 10);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Covering (83)");
				put("size", 83);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Wall");
				put("hierarchy2", " Wall Standard Case (487)");
				put("size", 487);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Feature Element Subtraction");
				put("hierarchy2", " Opening Element (181)");
				put("size", 181);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Window (69)");
				put("size", 69);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Distribution Flow Element");
				put("hierarchy2", " Flow Terminal (31)");
				put("size", 31);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Door (102)");
				put("size", 102);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Stair (2)");
				put("size", 2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Element");
				put("hierarchy2", " Furnishing Element (7)");
				put("size", 7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Spatial Structure Element");
				put("hierarchy2", " Building Storey (3)");
				put("size", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Stair Flight (4)");
				put("size", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Member (8)");
				put("size", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Building Element");
				put("hierarchy2", " Slab (2)");
				put("size", 2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Spatial Structure Element");
				put("hierarchy2", " Site (1)");
				put("size", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("hierarchy1", "Spatial Structure Element");
				put("hierarchy2", " Building (1)");
				put("size", 1);
			}
		});
	}
}
