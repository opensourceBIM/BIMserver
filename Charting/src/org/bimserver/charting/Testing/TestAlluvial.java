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

import org.bimserver.charting.Charts.Alluvial;

public class TestAlluvial extends BaseChartTest {

	public static void main(String[] args) {
		//
		getCocktailData(rawData);
		// Get chart.
		Alluvial chart = new Alluvial();
		chart.setDimensionLookupKeys("steps", Arrays.asList("A", "B"));
		// chart.setDimensionLookupKeys("steps", Arrays.asList("B", "A"));
		chart.setDimensionLookupKey("size", "C");
		chart.setOption("Width", 720);
		chart.setOption("Height", 500);
		chart.setOption("Sort", "name");
		//chart.setOption("Color Scale", new LinearColorScale());
		// Save chart.
		chart.saveToSVGInUserDirectory(rawData, "test.svg");
		// Print data.
		// System.out.println(chart.getRawTextDataSet(rawData));
	}

	public static void getCocktailData(ArrayList<LinkedHashMap<String, Object>> rawData) {
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Bloody Mary");
				put("B", "vodka");
				put("C", 9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Bloody Mary");
				put("B", "Tomato juice");
				put("C", 18);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Bloody Mary");
				put("B", "lemon juice");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Gin and Tonic");
				put("B", "Gin");
				put("C", 12);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Gin and Tonic");
				put("B", "Tonic Water");
				put("C", 29);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Screwdriver");
				put("B", "vodka");
				put("C", 10);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Screwdriver");
				put("B", "orange juice");
				put("C", 20);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "White Russian");
				put("B", "vodka");
				put("C", 10);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "White Russian");
				put("B", "coffee liqueur");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "White Russian");
				put("B", "cream");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cosmopolitan");
				put("B", "vodka");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cosmopolitan");
				put("B", "cointreau");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cosmopolitan");
				put("B", "lime juice");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cosmopolitan");
				put("B", "cranberry juice");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Apple Martini");
				put("B", "vodka");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Apple Martini");
				put("B", "apple schnapps");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Apple Martini");
				put("B", "cointreau");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "vodka");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "tequila");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "rum");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "triple sec");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "Gin");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "lemon juice");
				put("C", 5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Long Island Iced Tea");
				put("B", "gomme syrup");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mudslide");
				put("B", "vodka");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mudslide");
				put("B", "coffee liqueur");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mudslide");
				put("B", "bailey's");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mudslide");
				put("B", "cream");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Margarita");
				put("B", "tequila");
				put("C", 7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Margarita");
				put("B", "cointreau");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Margarita");
				put("B", "lime juice");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Kamikaze");
				put("B", "vodka");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Kamikaze");
				put("B", "triple sec");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Kamikaze");
				put("B", "lime juice");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mojito");
				put("B", "rum");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mojito");
				put("B", "lime juice");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mojito");
				put("B", "sugar");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mojito");
				put("B", "mint");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mojito");
				put("B", "soda");
				put("C", 12);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Caribou Lou");
				put("B", "rum");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Caribou Lou");
				put("B", "pineapple juice");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cuba Libre");
				put("B", "Cola");
				put("C", 12);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Cuba Libre");
				put("B", "rum");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Jager Monster");
				put("B", "Jagermeister");
				put("C", 9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Jager Monster");
				put("B", "orange juice");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Daiquiri");
				put("B", "rum");
				put("C", 9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Daiquiri");
				put("B", "lime juice");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Daiquiri");
				put("B", "syrup");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Whiskey Sour");
				put("B", "whiskey");
				put("C", 3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Whiskey Sour");
				put("B", "lemon juice");
				put("C", 2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Whiskey Sour");
				put("B", "syrup");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mint Julep");
				put("B", "whiskey");
				put("C", 18);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mint Julep");
				put("B", "mint");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Mint Julep");
				put("B", "sugar");
				put("C", 1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Pina Colada");
				put("B", "rum");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Pina Colada");
				put("B", "cream");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Pina Colada");
				put("B", "pineapple juice");
				put("C", 6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Sex on the Beach");
				put("B", "vodka");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Sex on the Beach");
				put("B", "peach schnapps");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Sex on the Beach");
				put("B", "orange juice");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "Sex on the Beach");
				put("B", "cranberry juice");
				put("C", 8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "B-52");
				put("B", "coffee liqueur");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "B-52");
				put("B", "bailey's");
				put("C", 4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", "B-52");
				put("B", "cointreau");
				put("C", 4);
			}
		});
	}

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
		// if (true) return;
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1980);
				put("B", "Cassete");
				put("C", 19.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1981);
				put("B", "Cassete");
				put("C", 26.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1982);
				put("B", "Cassete");
				put("C", 38.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1983);
				put("B", "Cassete");
				put("C", 47.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1984);
				put("B", "Cassete");
				put("C", 55);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1985);
				put("B", "Cassete");
				put("C", 55.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1986);
				put("B", "Cassete");
				put("C", 53.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1987);
				put("B", "Cassete");
				put("C", 53.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1988);
				put("B", "Cassete");
				put("C", 54.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1989);
				put("B", "Cassete");
				put("C", 50.8);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1990);
				put("B", "Cassete");
				put("C", 46);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1991);
				put("B", "Cassete");
				put("C", 38.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1992);
				put("B", "Cassete");
				put("C", 34.5);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1993);
				put("B", "Cassete");
				put("C", 29);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1994);
				put("B", "Cassete");
				put("C", 24.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1995);
				put("B", "Cassete");
				put("C", 18.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1996);
				put("B", "Cassete");
				put("C", 15.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1997);
				put("B", "Cassete");
				put("C", 12.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1998);
				put("B", "Cassete");
				put("C", 7.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 1999);
				put("B", "Cassete");
				put("C", 7.3);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2000);
				put("B", "Cassete");
				put("C", 4.4);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2001);
				put("B", "Cassete");
				put("C", 2.6);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2002);
				put("B", "Cassete");
				put("C", 1.7);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2003);
				put("B", "Cassete");
				put("C", 0.9);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2004);
				put("B", "Cassete");
				put("C", 0.2);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2005);
				put("B", "Cassete");
				put("C", 0.1);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2006);
				put("B", "Cassete");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2007);
				put("B", "Cassete");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2008);
				put("B", "Cassete");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2009);
				put("B", "Cassete");
				put("C", 0);
			}
		});
		rawData.add(new LinkedHashMap<String, Object>() {
			{
				put("A", 2010);
				put("B", "Cassete");
				put("C", 0);
			}
		});
	}
}
