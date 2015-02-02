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
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

import org.bimserver.charting.Charts.BumpChart;

public class TestBumpChart extends BaseChartTest {

	public static void main(String[] args) {
		// Get data.
		getOrderedRandomData(rawData);
		//getMusicData(rawData);
		turnYearsInDataToDates();
		// Get chart.
		BumpChart chart = new BumpChart();
		chart.setDimensionLookupKey("group", "B");
		chart.setDimensionLookupKey("date", "A");
		chart.setDimensionLookupKey("size", "C");
		chart.setOption("Width", 400);
		chart.setOption("Height", 300);
		chart.setOption("Padding", 1);
		chart.setOption("Interpolation", "basis spline");
		chart.setOption("Normalize", true);
		chart.setOption("Sort", "value (ascending)");
		chart.setOption("Show Labels", true);
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	@SuppressWarnings("deprecation")
	public static void turnYearsInDataToDates() {
		for (LinkedHashMap<String, Object> data : rawData) {
			int year = (int) data.get("A");
			java.util.Date date = new Date();
			date.setMonth(12);
			date.setDate(1);
			date.setYear(year - 1900);
			data.put("A", date);
		}
	}

	public static void getOrderedRandomData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		final int groups = 15;
		final int range = 1000000;
		final Random r = new Random();
		for (int i = groups; i > 0; i--) {
			int n = 10;
			while (n > 0) {
				LinkedHashMap<String, Object> row = new LinkedHashMap<>();
				row.put("A", 1990 + r.nextInt(20));
				row.put("B", i);
				row.put("C", r.nextInt(range));
				//
				rawData.add(row);
				n--;
			}
		}
	}

	@SuppressWarnings("serial")
	public static void getMusicData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		add8TrackData(rawData);
		addCassetteData(rawData);
		addCassetteSingleData(rawData);
		addCDData(rawData);
	}

	/**
	 * @param rawData
	 */
	public static void addCDData(ArrayList<LinkedHashMap<String, Object>> rawData) {
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
				put("A", 1983);
				put("B", "CD");
				put("C", 0.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1984);
				put("B", "CD");
				put("C", 2.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1985);
				put("B", "CD");
				put("C", 8.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1986);
				put("B", "CD");
				put("C", 20);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1987);
				put("B", "CD");
				put("C", 28.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1988);
				put("B", "CD");
				put("C", 33.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1989);
				put("B", "CD");
				put("C", 39.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1990);
				put("B", "CD");
				put("C", 45.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1991);
				put("B", "CD");
				put("C", 55.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1992);
				put("B", "CD");
				put("C", 59.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1993);
				put("B", "CD");
				put("C", 64.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1994);
				put("B", "CD");
				put("C", 70.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1995);
				put("B", "CD");
				put("C", 76.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1996);
				put("B", "CD");
				put("C", 79.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1997);
				put("B", "CD");
				put("C", 81.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1998);
				put("B", "CD");
				put("C", 87.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1999);
				put("B", "CD");
				put("C", 87.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2000);
				put("B", "CD");
				put("C", 92.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2001);
				put("B", "CD");
				put("C", 94);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2002);
				put("B", "CD");
				put("C", 95.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2003);
				put("B", "CD");
				put("C", 94.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2004);
				put("B", "CD");
				put("C", 92.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2005);
				put("B", "CD");
				put("C", 85.6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2006);
				put("B", "CD");
				put("C", 79.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2007);
				put("B", "CD");
				put("C", 70);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2008);
				put("B", "CD");
				put("C", 62.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2009);
				put("B", "CD");
				put("C", 55.6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2010);
				put("B", "CD");
				put("C", 49.1);
			}
		});
	}

	/**
	 * @param rawData
	 */
	public static void addCassetteSingleData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1983);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1984);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1985);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1986);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1987);
				put("B", "Cassette single");
				put("C", 0.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1988);
				put("B", "Cassette single");
				put("C", 0.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1989);
				put("B", "Cassette single");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1990);
				put("B", "Cassette single");
				put("C", 3.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1991);
				put("B", "Cassette single");
				put("C", 2.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1992);
				put("B", "Cassette single");
				put("C", 3.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1993);
				put("B", "Cassette single");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1994);
				put("B", "Cassette single");
				put("C", 2.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1995);
				put("B", "Cassette single");
				put("C", 1.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1996);
				put("B", "Cassette single");
				put("C", 1.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1997);
				put("B", "Cassette single");
				put("C", 1.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1998);
				put("B", "Cassette single");
				put("C", 0.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1999);
				put("B", "Cassette single");
				put("C", 0.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2000);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2001);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2002);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2003);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2004);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2005);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2006);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2007);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2008);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2009);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2010);
				put("B", "Cassette single");
				put("C", 0);
			}
		});
	}

	/**
	 * @param rawData
	 */
	public static void addCassetteData(ArrayList<LinkedHashMap<String, Object>> rawData) {
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
				put("A", 1983);
				put("B", "Cassette");
				put("C", 47.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1984);
				put("B", "Cassette");
				put("C", 55);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1985);
				put("B", "Cassette");
				put("C", 55.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1986);
				put("B", "Cassette");
				put("C", 53.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1987);
				put("B", "Cassette");
				put("C", 53.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1988);
				put("B", "Cassette");
				put("C", 54.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1989);
				put("B", "Cassette");
				put("C", 50.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1990);
				put("B", "Cassette");
				put("C", 46);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1991);
				put("B", "Cassette");
				put("C", 38.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1992);
				put("B", "Cassette");
				put("C", 34.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1993);
				put("B", "Cassette");
				put("C", 29);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1994);
				put("B", "Cassette");
				put("C", 24.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1995);
				put("B", "Cassette");
				put("C", 18.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1996);
				put("B", "Cassette");
				put("C", 15.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1997);
				put("B", "Cassette");
				put("C", 12.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1998);
				put("B", "Cassette");
				put("C", 7.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1999);
				put("B", "Cassette");
				put("C", 7.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2000);
				put("B", "Cassette");
				put("C", 4.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2001);
				put("B", "Cassette");
				put("C", 2.6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2002);
				put("B", "Cassette");
				put("C", 1.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2003);
				put("B", "Cassette");
				put("C", 0.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2004);
				put("B", "Cassette");
				put("C", 0.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2005);
				put("B", "Cassette");
				put("C", 0.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2006);
				put("B", "Cassette");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2007);
				put("B", "Cassette");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2008);
				put("B", "Cassette");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2009);
				put("B", "Cassette");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2010);
				put("B", "Cassette");
				put("C", 0);
			}
		});
	}

	/**
	 * @param rawData
	 */
	public static void add8TrackData(ArrayList<LinkedHashMap<String, Object>> rawData) {
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
				put("A", 1983);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1984);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1985);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1986);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1987);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1988);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1989);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1990);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1991);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1992);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1993);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1994);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1995);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1996);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1997);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1998);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1999);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2000);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2001);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2002);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2003);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2004);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2005);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2006);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2007);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2008);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2009);
				put("B", "8-track");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2010);
				put("B", "8-track");
				put("C", 0);
			}
		});
	}
}
