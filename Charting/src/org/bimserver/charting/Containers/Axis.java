package org.bimserver.charting.Containers;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openmali.vecmath2.Colord;
import org.openmali.vecmath2.Vector2d;

public class Axis {

	public static enum Movement {
		LeftToRight,
		BottomToTop
	};

	public static final SimpleDateFormat DefaultHorizontalDateFormat = new SimpleDateFormat("MMM dd'\n('yyyy')'");
	public static final SimpleDateFormat DefaultVerticalDateFormat = new SimpleDateFormat("MMM dd '('yyyy')'");

	public String Name = null;
	public ChartExtent Extent = null;
	public Vector2d StartingLocation = Vector2d.ZERO;
	public Vector2d P2OfConstructedLine = Vector2d.ZERO;
	public Movement Direction = Movement.LeftToRight;
	//
	public double VerticalLineHeightInPixels = 10;
	public AxisLineSettings LineSettings = new AxisLineSettings(0, 0, new Colord(0, 0, 0, 1), false);

	/**
	 * Provide a means to look up whether the axis requires reversing order of data (specifically, to deal with top-down Y values versus bottom-up Y values).
	 *
	 * @return
	 */
	public boolean requiresReverseOrder() {
		return (Direction == Movement.BottomToTop) ? true : false;
	}

	/**
	 * @param name
	 * @param extent
	 * @param startingLocation
	 * @param p2OfConstructedLine
	 * @param direction
	 */
	public Axis(String name, ChartExtent extent, Vector2d startingLocation, Vector2d p2OfConstructedLine, Movement direction) {
		super();
		Name = name;
		Extent = extent;
		StartingLocation = startingLocation;
		P2OfConstructedLine = p2OfConstructedLine;
		Direction = direction;
	}

	public StringBuilder buildString(int indentation) {
		ElementLike svgGroupElementRepresentingAxis = new ElementLike("g");
		// Provide class names that double as a comment about which axis this is. 
		if (Name != null && !Name.isEmpty())
			svgGroupElementRepresentingAxis.attribute("class", String.format("%s axis", Name));
		else
			svgGroupElementRepresentingAxis.attribute("class", "axis");
		// Set the location and default style of lines and text.
		svgGroupElementRepresentingAxis.attribute("transform", String.format("translate(%s, %s)", new Double(StartingLocation.getX()), new Double(StartingLocation.getY())));
		svgGroupElementRepresentingAxis.attribute("style", "stroke-width: 1px; font-size: 10px; font-family: Arial, Helvetica;");
		//
		boolean reverseOrder = requiresReverseOrder();
		String lineColorString = LineSettings.getStrokeColor();
		// Prepare something that draws a line away.
		ElementLike lowLinePrototype = null;
		if (LineSettings.StartLineCapAmount != 0) {
			lowLinePrototype = new ElementLike("line");
			lowLinePrototype.attribute("style", String.format("shape-rendering: crispedges; fill: none; stroke: %s;", lineColorString));
			if (Direction == Movement.LeftToRight) {
				lowLinePrototype.attribute("x2", String.format("%s", new Double(0)));
				lowLinePrototype.attribute("y2", String.format("%s", new Double(LineSettings.StartLineCapAmount)));
			}
			else if (Direction == Movement.BottomToTop) {
				lowLinePrototype.attribute("x2", String.format("%s", new Double(-LineSettings.StartLineCapAmount)));
				lowLinePrototype.attribute("y2", String.format("%s", new Double(0)));
			}
		}
		// Prepare something that draws a line backwards from location.
		ElementLike middleLinePrototype = new ElementLike("line");
		middleLinePrototype.attribute("style", String.format("shape-rendering: crispedges; fill: none; stroke: %s;", lineColorString));
		middleLinePrototype.attribute("x2", String.format("%s", new Double(P2OfConstructedLine.getX())));
		middleLinePrototype.attribute("y2", String.format("%s", new Double(P2OfConstructedLine.getY())));
		// Prepare something that draws a line away.
		ElementLike highLinePrototype = null;
		if (LineSettings.StartLineCapAmount != 0) {
			highLinePrototype = new ElementLike("line");
			highLinePrototype.attribute("style", String.format("shape-rendering: crispedges; fill: none; stroke: %s;", lineColorString));
			if (Direction == Movement.LeftToRight) {
				highLinePrototype.attribute("y1", String.format("%s", new Double(P2OfConstructedLine.getY())));
				highLinePrototype.attribute("x2", String.format("%s", new Double(0)));
				highLinePrototype.attribute("y2", String.format("%s", new Double(P2OfConstructedLine.getY()- LineSettings.EndLineCapAmount)));
			}
			else if (Direction == Movement.BottomToTop) {
				highLinePrototype.attribute("x1", String.format("%s", new Double(P2OfConstructedLine.getX())));
				highLinePrototype.attribute("x2", String.format("%s", new Double(P2OfConstructedLine.getX() + LineSettings.EndLineCapAmount)));
				highLinePrototype.attribute("y2", String.format("%s", new Double(0)));
			}
		}
		//
		ArrayList<Pair<Double, Double>> pairs = Extent.getWorldSpaceToActualValuePairsLinearSchedule(reverseOrder);
		int pairCount = pairs.size();
		List<Integer> edges = Arrays.asList(0, pairCount - 1);
		for (int i = 0; i < pairCount; i++)
		{
			Pair<Double, Double> pair = pairs.get(i);
			// Get value. Transform pixel space to domain of values.
			Double currentWorldSpaceLocation = pair.getWorldSpaceValue();
			Double valueAtLocation = pair.getActualValue();
			// Make the line group.
			ElementLike lineGroup = new ElementLike("g");
			if (Direction == Movement.LeftToRight)
				lineGroup.attribute("transform", String.format("translate(%s, %s)", new Double(currentWorldSpaceLocation), new Double(0)));
			else if (Direction == Movement.BottomToTop)
				lineGroup.attribute("transform", String.format("translate(%s, %s)", new Double(0), new Double(currentWorldSpaceLocation)));
			lineGroup.attribute("style", "opacity: 1;");
			lineGroup.attribute("class", "tick");
			// Draw line backwards from location.
			ElementLike line = (LineSettings.OnlyDrawLineForFirstAndLastTick == false || edges.contains(i)) ? middleLinePrototype.clone() : null;
			if (i + 1 == pairCount && LineSettings.DoNotDrawLastAxisLine)
				line = null;
			// Draw text beneath start of line.
			ElementLike text = new ElementLike("text");
			Double inheritableY = 0.0;
			if (Direction == Movement.LeftToRight) {
				text.attribute("style", "text-anchor: middle;");
				text.attribute("x", "0");
				inheritableY = new Double(3 + Math.max(0, LineSettings.StartLineCapAmount));
				text.attribute("y", String.format("%s", inheritableY));
				text.attribute("dy", ".71em");
			}
			else if (Direction == Movement.BottomToTop) {
				text.attribute("style", "text-anchor: end;");
				text.attribute("x", String.format("%s", new Double(-3 - Math.abs(LineSettings.StartLineCapAmount))));
				text.attribute("y", String.format("%s", new Double(inheritableY)));
				text.attribute("dy", ".32em");
			}
			// If the data should be treated as the milliseconds of a date, attempt to format it as such. Otherwise, just print it (NOTE: ignores new lines).
			if (Extent.ShouldFormatAsDate) {
				// Turn the lerp'd double value into a valid amount of milliseconds. 
				long milliseconds = (long)Math.round(valueAtLocation);
				// Create the date object.
				Date date = new Date(milliseconds);
				// Create a place to store the formatted date.
				String initialFormattedDate = null;
				if (Direction == Movement.LeftToRight)
					initialFormattedDate = DefaultHorizontalDateFormat.format(date);
				else if (Direction == Movement.BottomToTop)
					initialFormattedDate = DefaultVerticalDateFormat.format(date);
				// If there is a formatted date available, try to print it as plainly as possible.
				if (initialFormattedDate != null) {
					// Split the the formatted string at each new line.
					List<String> parts = Arrays.asList(initialFormattedDate.split("\n"));
					// Track the direction the text spans will be going.
					int direction = 1;
					// Track the total change in SVG y coordinates.
					double runningTotal = inheritableY;
					// Get how many parts there are.
					int partCount = parts.size();
					// Calculate the total change in SVG y coordinates.
					double targetHeightFromLineHeight = partCount * VerticalLineHeightInPixels;
					// For left-to-right, print out the text in reverse order.
					if (Direction == Movement.LeftToRight) {
						// Remove the relative SVG y coordinate.
						text.attribute("dy", "0em");
						runningTotal += 0.5 * targetHeightFromLineHeight;
					}
					// For bottom-to-top, print out the text in reverse order.
					else if (Direction == Movement.BottomToTop) {
						//text.attribute("dx", "-0.1em");
						Collections.reverse(parts);
						direction = -1;
						runningTotal += (partCount > 1) ? -0.5 * direction * targetHeightFromLineHeight : 0;
					}
					Double x = (Direction == Movement.BottomToTop) ? Math.min(0, -LineSettings.StartLineCapAmount) : 0;
					// Render out the parts as SVG TSPAN elements.
					for (String part : parts) {
						ElementLike textSpan = new ElementLike("tspan");
						textSpan.attribute("x", String.format("%s", x));
						textSpan.attribute("y", String.format("%s", runningTotal));
						textSpan.text(part);
						// Step the running total along.
						runningTotal += direction * VerticalLineHeightInPixels;
						// Reparenting.
						text.child(textSpan);
					}
				}
			}
			else
				text.text(ElementLike.getNumberStringForDisplay(valueAtLocation));
			// TODO: Add units. NOTE: Not in densitydesign/raw.
			// Reparenting.
			if (line != null)
				lineGroup.Children.add(line);
			if (lowLinePrototype != null)
				lineGroup.Children.add(lowLinePrototype.clone());
			if (highLinePrototype != null)
				lineGroup.Children.add(highLinePrototype.clone());
			// Add text if requested.
			if (LineSettings.IncludeLabels)
				lineGroup.Children.add(text);
			// Add line group.
			svgGroupElementRepresentingAxis.Children.add(lineGroup);
		}
		return svgGroupElementRepresentingAxis.buildString(indentation);
	}

	public double getWorldSpaceValueGivenActualValue(double actualValue) {
		return Extent.getLinearWorldSpaceValueAtXGivenActualValue(actualValue, requiresReverseOrder());
	}
}
