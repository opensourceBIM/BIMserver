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

import org.bimserver.charting.Charts.HexagonalBinning;
import org.bimserver.charting.ColorScales.LinearColorScale;

public class TestHexagonBinning extends BaseChartTest {

	public static void main(String[] args) {
		//
		getLongTestableData(rawData);
		//
		HexagonalBinning chart = new HexagonalBinning();
		// chart.setOption("Color Scale", new HSLColorScale());
		chart.setOption("Color Scale", new LinearColorScale());
		chart.setDimensionLookupKey("x", "A");
		chart.setDimensionLookupKey("y", "B");
		chart.setOption("Width", 698);
		chart.setOption("Height", 500);
		chart.setOption("Use Zeroed Origin", false);
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getLongTestableData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		// Run data through chart.getRawTextDataSet to retrieve.
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 360);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 390);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 199);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 199);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 114);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 115);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 5);
				put("B", 131);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 5);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 181);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 455);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 455);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 111);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 305);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 305);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 112);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 112);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 112);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 307);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 305);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 307);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 173);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 173);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 454);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 267);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 305);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 262);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 307);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 360);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 440);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 72);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 168);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 86);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 108);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 119);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 83);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 146);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 146);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 135);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 383);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 135);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 383);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 135);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 116);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 88);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 68);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 360);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 429);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 171);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 81);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 86);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 3);
				put("B", 70);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 78);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 86);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 3);
				put("B", 70);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 3);
				put("B", 80);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 3);
				put("B", 70);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 146);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 168);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 5);
				put("B", 183);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 155);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 351);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 429);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 429);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 302);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 200);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 262);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 260);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 260);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 260);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 173);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 116);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 116);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 116);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 110);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 141);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 141);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 163);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 340);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 86);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 91);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 360);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 198);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 198);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 198);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 440);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 135);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 135);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 318);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 225);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 140);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 455);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 112);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 400);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 250);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 96);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 101);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 100);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 85);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 104);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 108);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 134);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 144);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 71);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 71);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 89);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 108);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 108);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 108);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 113);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 134);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 113);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 134);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 113);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 134);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 76);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 168);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 156);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 89);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 120);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 122);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 89);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 79);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 89);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 105);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 90);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 89);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 130);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 163);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 145);
			}
		});
	}

	/**
	 * @param rawData
	 */
	public static void getTestableData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		// Run data through chart.getRawTextDataSet to retrieve.
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 360);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 390);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 151);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 199);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 199);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 258);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 232);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 304);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 114);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 115);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 107);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 97);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 5);
				put("B", 131);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 5);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 98);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 121);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 181);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 455);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 455);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 8);
				put("B", 350);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 4);
				put("B", 111);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 6);
				put("B", 231);
			}
		});
	}
}
