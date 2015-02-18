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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

public class ElementLike {

	/**
	 * Get a rectangle that can be used to remove the things that fall outside of it.
	 *
	 * @param idName
	 * @param marginLeft
	 * @param marginBottom
	 * @param xAxisTickHeight
	 * @param yAxisTickWidth
	 * @return
	 */
	public static ElementLike createRectangularClipPath(String idName, double marginLeft, double marginBottom, double xAxisTickHeight, double yAxisTickWidth) {
		// Create clip path.
		ElementLike clipPath = new ElementLike("clipPath");
		clipPath.attribute("id", idName);
		// Create a rectangle.
		ElementLike rect = new ElementLike("rect");
		rect.attribute("class", "mesh");
		rect.attribute("width", String.format("%s", yAxisTickWidth - 0.5));
		rect.attribute("height", String.format("%s", -xAxisTickHeight - 1.05));
		// NOTE: Measured from top of SVG down.
		rect.attribute("transform", String.format("translate(%s, %s)", marginLeft + 0.25, marginBottom + 0));
		// Reparenting.
		clipPath.child(rect);
		return clipPath;
	}

	public String Name = "Element";
	public String Text = null;
	public LinkedHashMap<String, String> Attributes = new LinkedHashMap<>();
	public ArrayList<ElementLike> Children = new ArrayList<>();

	/**
	 * @param name
	 */
	public ElementLike(String name) {
		super();
		Name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = buildString(0);
		// Write closing element.
		return builder.toString();
	}

	public String getValidName() {
		String lowerCaseName = Name.toLowerCase();
		if (lowerCaseName.equals("clippath"))
			return "clipPath";
		else if (lowerCaseName.equals("textpath"))
			return "textPath";
		else
			return lowerCaseName;
	}

	public void attribute(String name, String value) {
		Attributes.put(name, value);
	}

	public void text(String text) {
		Text = text;
	}

	public void child(ElementLike element) {
		Children.add(element);
	}

	/**
	 * @param valueAtLocation
	 * @return
	 */
	public static String getNumberStringForDisplay(Double valueAtLocation) {
		String textAtLocation = String.format("%s", valueAtLocation);
		// Do a check to make sure the number's decimal component isn't a nuisance to readability. NOTE: This will not prevent a long number from being a nuisance.
		String[] parts = textAtLocation.split("\\.");
		if (parts.length > 1 && parts[1].length() > 5)
			textAtLocation = String.format("%.2f", valueAtLocation);
		return textAtLocation;
	}

	public ElementLike clone() {
		ElementLike copy = new ElementLike(Name);
		for (Entry<String, String> entry : Attributes.entrySet())
			copy.attribute(entry.getKey(), entry.getValue());
		copy.text(Text);
		for (ElementLike child : Children)
			copy.child(child.clone());
		return copy;
	}

	/**
	 * @param indentation
	 * @return
	 */
	public StringBuilder buildString(int indentation) {
		// Calculate indentation.
		String indentationString = "";
		for (int level = 0; level < indentation; level++)
			indentationString += "	";
		// Prepare a builder.
		StringBuilder builder = new StringBuilder();
		// Write opening element.
		builder.append(indentationString + String.format("<%s", getValidName()));
		if (Attributes.size() > 0)
		{
			for (Entry<String, String> attribute : Attributes.entrySet()) {
				builder.append(String.format(" %s=\"%s\"", attribute.getKey(), attribute.getValue()));
			}
		}
		boolean canCloseRightAway = (Children.size() == 0 && Text == null);
		if (canCloseRightAway)
			builder.append("/>");
		else {
			// Close opening tag declaration.
			builder.append(">");
			boolean canSimplifyToOneLine = (Children.size() == 0);
			// Write text.
			if (Text != null) {
				boolean textContainsBadCharacter = Text.contains("&") || Text.contains("<") || Text.contains(">");
				String thisText = (!textContainsBadCharacter) ? Text : String.format("<![CDATA[%s]]>", Text);
				if (canSimplifyToOneLine)
					builder.append(thisText);
				else {
					builder.append("\n");
					builder.append(indentationString + String.format("	%s", thisText));
				}
			}
			// Write child elements.
			if (Children.size() > 0) {
				builder.append("\n");
				for (ElementLike element : Children) {
					builder.append(element.buildString(indentation + 1));
				}
			}
			// Close tag.
			if (canSimplifyToOneLine)
				builder.append(String.format("</%s>", getValidName()));
			else {
				builder.append(indentationString + String.format("</%s>", getValidName()));
			}
		}
		builder.append("\n");
		return builder;
	}

	/**
	 * @param polygon
	 * @param absoluteCoordinates
	 * @param implicitlyClosePath
	 */
	public void d(Geometry polygon, boolean absoluteCoordinates, boolean implicitlyClosePath) {
		String dString = generateSVGDataAttribute(polygon, absoluteCoordinates, implicitlyClosePath);
		attribute("d", dString);
	}

	/**
	 * Generates a String that represents the "d" attribute of an SVG path. This attribute is responsible for drawing commands.
	 * @param polygon
	 * @param absoluteCoordinates
	 * @param implicitlyClosePath
	 * @return
	 */
	public String generateSVGDataAttribute(Geometry polygon, boolean absoluteCoordinates, boolean implicitlyClosePath) {
		ArrayList<String> d = new ArrayList<String>();
		String dString = "";
		for (Coordinate vertex : polygon.getCoordinates()) {
			// Write relative points as (using periods to represent decimal points): px, py
			d.add(String.format(Locale.US, "%f,%f", new Double(vertex.x), new Double(vertex.y)));
		}
		// Set something in format of: M px1,py1 L px2,py2 ... L pxn, pyn Z
		if (d.size() > 0) {
			if (absoluteCoordinates)
				dString = "M " + StringUtils.join(d, " L ");
			else
				dString = "m " + StringUtils.join(d, " l ");
			if (implicitlyClosePath)
				dString += (absoluteCoordinates) ? " Z" : " z";
		}
		return dString;
	}
}
