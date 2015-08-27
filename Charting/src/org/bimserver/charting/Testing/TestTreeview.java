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

import org.bimserver.charting.Charts.Treeview;

public class TestTreeview extends BaseChartTest {

	public static void main(String[] args) {
		//
		getMusicData(rawData);
		//
		Treeview chart = new Treeview();
		chart.setDimensionLookupKeys("hierarchy", Arrays.asList("B", "A", "C"));
		chart.setDimensionLookupKey("label", "C");
		chart.setOption("Width", 600);
		chart.setOption("Height", 500);
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	/**
	 * @param rawData
	 */
	public static void getMusicData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "8-track");
				put("C", 14.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "8-track");
				put("C", 7.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "8-track");
				put("C", 1.0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "Cassette");
				put("C", 19.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "Cassette");
				put("C", 26.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "Cassette");
				put("C", 38.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "CD");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "CD");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "CD");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "CD single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "CD single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "CD single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "Download Super Long Album");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "Download Super Long Album");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "Download Super Long Album");
				put("C", 0);
			}
		});
	}
}
