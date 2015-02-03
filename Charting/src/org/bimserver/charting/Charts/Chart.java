package org.bimserver.charting.Charts;

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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.bimserver.charting.Containers.ChartOption;
import org.bimserver.charting.Containers.ChartRow;
import org.bimserver.charting.Containers.ChartRows;
import org.bimserver.charting.Dimensions.ModelDimension;

public class Chart {

	// Removed.
	//public int ID = 0;
	public String Title = "Untitled";
	public String Description = null;
	public String Category = null;
	// Removed.
	//public String Thumbnail = "";
	public ArrayList<ChartOption> Options = new ArrayList<>();
	public org.bimserver.charting.Models.Model Model = null;
	// Convenience shortcut, skipping a need to keep such a variable on the ChartOption object. Controls SVG export. 100% versus actual value in header.
	public boolean FitToSize = false;

	/**
	 * @param title
	 * @param description
	 * @param category
	 * @param options
	 * @param model
	 * @param fitToSize
	 */
	public Chart(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model, boolean fitToSize) {
		super();
		Title = title;
		Description = description;
		Category = category;
		Options = options;
		Model = model;
		FitToSize = fitToSize;
	}

	/**
	 * @param title
	 * @param description
	 * @param category
	 * @param options
	 * @param model
	 */
	public Chart(String title, String description, String category, ArrayList<ChartOption> options, org.bimserver.charting.Models.Model model) {
		this(title, description, category, options, model, false);
	}

	/**
	 * @param title
	 * @param description
	 * @param category
	 * @param model
	 */
	public Chart(String title, String description, String category, org.bimserver.charting.Models.Model model) {
		this(title, description, category, new ArrayList<ChartOption>(), model);
	}

	public boolean hasOption(String optionTitle) {
		for (ChartOption option : Options)
			if (option.Title.equals(optionTitle))
				return true;
		return false;
	}

	public Object getOptionValue(String optionTitle) {
		for (ChartOption option : Options)
			if (option.Title.equals(optionTitle))
				return option.getValue();
		return null;
	}

	public ChartOption getOption(String optionTitle) {
		for (ChartOption option : Options)
			if (option.Title.equals(optionTitle))
				return option;
		return null;
	}

	public boolean setOption(String optionTitle, Object value) {
		if (hasOption(optionTitle)) {
			ChartOption option = getOption(optionTitle);
			option.setValue(value);
			return true;
		}
		return false;
	}

	// SVG Tiny profile removes/ignores scripting and styling. It is meant for mobile devices.
	/*
<svg version="1.1" baseProfile="tiny" id="chart-id" width="100%" height="100%" viewBox="0 0 480 360" xmlns="http://www.w3.org/2000/svg">
  <title id="chart-title">Title</title>
  <g id="body-content" font-family="sans-serif" font-size="18">
    <g stroke="black" stroke-width="5">
      <line x1="0" y1="0" x2="150" y2="0"/>
      <line x1="0" y1="0" x2="0" y2="150"/>
    </g>
    <g fill="blue">
      <rect width="15" height="15"/>
      <rect x="150" width="15" height="15"/>
      <rect y="150" width="15" height="15"/>
    </g>
    <g fill="yellow">
      <rect x="0" y="0" width="10" height="10"/>
      <rect x="150" y="0" width="10" height="10"/>
      <rect x="0" y="150" width="10" height="10"/>
    </g>
  </g>
  <g font-family="sans-serif" font-size="32">
    <text id="title" x="10" y="340" stroke="none" fill="black">Title Text</text>
  </g>
  <rect id="frame" x="1" y="1" width="478" height="358" fill="none" stroke="#000"/>
</svg>
	 */
	/**
	 * Writes out an SVG file given raw format of data. This method is not meant to be overriden.
	 *
	 * @param data
	 * @return
	 */
	public StringBuilder writeSVG(ArrayList<LinkedHashMap<String, Object>> data) {
		StringBuilder builder = new StringBuilder();
		// Create a chart identification string based around the chart's title.
		String chartId = Title.toLowerCase().replace(' ', '-');
		// If there is a diameter option, treat as both width and height. Otherwise, specifically look for them.
		if (hasOption("Diameter")) {
			// Look for "Diameter" in options (in pixels).
			int diameter = (hasOption("Diameter")) ? ((Number)getOptionValue("Diameter")).intValue() : 1000;
			// Write the SVG header.
			String svgWidth = (FitToSize) ? "100%" : String.format("%d", diameter);
			String svgHeight = (FitToSize) ? "100%" : String.format("%d", diameter);
			// Write the SVG header.
			builder.append(
				String.format(
					"<svg version=\"1.1\" baseProfile=\"%s\" id=\"%s\" width=\"%s\" height=\"%s\" viewBox=\"0 0 %d %d\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">",
					"tiny", chartId, svgWidth, svgHeight, diameter, diameter
				)
			);
		}
		else {
			// Look for "Width" in options (in pixels).
			int width = (hasOption("Width")) ? ((Number)getOptionValue("Width")).intValue() : 1000;
			// Look for "Height" in options (in pixels).
			int height = (hasOption("Height")) ? ((Number)getOptionValue("Height")).intValue() : 500;
			// Write the SVG header.
			String svgWidth = (FitToSize) ? "100%" : String.format("%d", width);
			String svgHeight = (FitToSize) ? "100%" : String.format("%d", height);
			//
			builder.append(
				String.format(
					"<svg version=\"1.1\" baseProfile=\"%s\" id=\"%s\" width=\"%s\" height=\"%s\" viewBox=\"0 0 %d %d\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">",
					"tiny", chartId, svgWidth, svgHeight, width, height
				)
			);
		}
		builder.append("\n");
		// Write title (undrawn).
		builder.append(
			String.format(
				"	<title id=\"chart-title\">%s</title>",
				Title
			)
		);
		builder.append("\n");
		// Defer to model functionality to write SVG.
		writeSVGBody(builder, data);
		// Close the SVG.
		builder.append("</svg>");
		// Return builder.
		return builder;
	}

	/**
	 * Functionality to call functionality to write out non-header components of the SVG file, representing the chart. 
	 *
	 * @param builder
	 * @param data
	 * @return
	 */
	public StringBuilder writeSVGBody(StringBuilder builder, ArrayList<LinkedHashMap<String, Object>> data) {
		// Obtain data, filtered by dimension.
		ChartRows filteredData = Model.filterData(data);
		// Write axes and/or backgrounds.
		writeSVGChartSpecificPayload(builder, filteredData);
		// Send it back.
		return builder;
	}

	/**
	 * Functionality to calculate and write out axes and/or backgrounds.
	 *
	 * @param builder
	 * @param filteredData
	 * @return
	 */
	public StringBuilder writeSVGChartSpecificPayload(StringBuilder builder, ChartRows filteredData) {
		// Pass-through. Calculate necessary metrics and backgrounds.
		// Pass-through. Write necessary metrics and backgrounds.
		// Pass-through.
		return builder;
	}

	public boolean setDimensionLookupKey(String dimensionKey, String dataKey) {
		return Model.setDimensionLookupKey(dimensionKey, dataKey);
	}

	public boolean setDimensionLookupKeys(String dimensionKey, Collection<String> dataKeys) {
		return Model.setDimensionLookupKeys(dimensionKey, dataKeys);
	}

	public StringBuilder getRawTextDataSet(ArrayList<LinkedHashMap<String, Object>> data) {
		// Obtain data, filtered by dimension.
		ChartRows filteredData = Model.filterData(data);
		//
		StringBuilder builder = new StringBuilder();
		// Handle headers.
		ArrayList<String> headers = new ArrayList<>();
		for(ModelDimension dimension : Model.Dimensions) {
			String key = dimension.StoreAsKey;
			int count = dimension.getLength();
			for (int i = 0; i < count; i++) {
				// Make a numbered column.
				String thisKey = (count > 1) ? String.format("%s%s", key, (i + 1)) : key;
				if (thisKey.contains(","))
					headers.add(String.format("\"%s\"", thisKey));
				else
					headers.add(thisKey);
			}
		}
		builder.append(StringUtils.join(headers, ", "));
		builder.append("\n");
		// Handle data.
		for (ChartRow row : filteredData) {
			ArrayList<Object> values = new ArrayList<>();
			for (Entry<ModelDimension, ArrayList<Object>> value : row.entrySet()) {
				for (Object thisValue : value.getValue()) {
					if (thisValue instanceof String) {
						String thisValueString = (String)thisValue;
						if (thisValueString.contains(","))
							values.add(String.format("\"%s\"", thisValueString));
						else
							values.add(thisValueString);
					} else
						values.add(thisValue);
				}
			}
			//
			builder.append(StringUtils.join(values, ", "));
			builder.append("\n");
		}
		// Send it back.
		return builder;
	}

	public void saveToSVGInUserDirectory(ArrayList<LinkedHashMap<String, Object>> rawData) {
		String home = System.getProperty("user.home");
		String directoryPath = ((System.getProperty("os.name").startsWith("Windows"))) ? FilenameUtils.concat(home, "Desktop") : home;
		saveToSVG(rawData, directoryPath);
	}

	public void saveToSVGInUserDirectory(ArrayList<LinkedHashMap<String, Object>> rawData, String filename) {
		String home = System.getProperty("user.home");
		String directoryPath = ((System.getProperty("os.name").startsWith("Windows"))) ? FilenameUtils.concat(home, "Desktop") : home;
		saveToSVG(rawData, directoryPath, filename);
	}

	public void saveToSVG(ArrayList<LinkedHashMap<String, Object>> rawData, String directoryPath) {
		saveToSVG(rawData, directoryPath, String.format("%s.svg", Title));
	}

	public void saveToSVG(ArrayList<LinkedHashMap<String, Object>> rawData, String directoryPath, String filename) {
		StringBuilder builder = this.writeSVG(rawData);
		String data = builder.toString();
		PrintWriter writer;
		String file = FilenameUtils.concat(directoryPath, filename);
		try {
			writer = new PrintWriter(file, "UTF-8");
			writer.println(data);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
