package org.bimserver.geometry;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bimserver.Color4f;

import com.google.common.primitives.UnsignedBytes;

public class ColorMap {

	private static class A {

		private int index;
		private Color4f color;
		public int count = 3;

		public A(int index, Color4f color) {
			this.index = index;
			this.color = color;
		}
	}
	
	private Color4f lastColor;
	private final List<A> list = new ArrayList<>();
	private final Map<Color4f, Double> colorToArea = new HashMap<>();
	private int index;
	private boolean hasTransparency;
	private A lastA;
	private int totalVertices = 0;
	
	public ColorMap() {
	}
	
	public void addTriangle(double[] triangle, Color4f color) {
		if (lastColor == null || !lastColor.equals(color)) {
			lastA = new A(index, color);
			list.add(lastA);
			lastColor = color;
		} else {
			lastA.count += 3;
		}
		index += 3;
		
		if (colorToArea.containsKey(color)) {
			colorToArea.put(color, colorToArea.get(color) + area(triangle));
		} else {
			colorToArea.put(color, area(triangle));
		}
		
		if (color.getA() < 1) {
			hasTransparency = true;
		}
	}
	
	public double area(double[] triangle) {
		return (0.5d * 
			Math.sqrt(
				Math.pow(((triangle[3] * triangle[7]) - (triangle[6] * triangle[4])), 2) +
				Math.pow(((triangle[6] * triangle[1]) - (triangle[0] * triangle[7])), 2) +
				Math.pow(((triangle[0] * triangle[4]) - (triangle[3] * triangle[1])), 2)));
	}

	public boolean hasTransparency() {
		return hasTransparency;
	}

	public int usedColors() {
		return colorToArea.size();
	}

	public Color4f getFirstColor() {
		return colorToArea.keySet().iterator().next();
	}

	public Color4f getMostUsedColor() {
		double totalArea = 0;
		Color4f mostUsed = null;
		for (Entry<Color4f, Double> entry : colorToArea.entrySet()) {
			if (mostUsed == null || entry.getValue() > totalArea) {
				mostUsed = entry.getKey();
				totalArea = entry.getValue();
			}
		}
		return mostUsed;
	}

	public byte[] toByteArray() {
		ByteBuffer buffer = ByteBuffer.allocate(list.size() * 8).order(ByteOrder.LITTLE_ENDIAN);
		for (A a : list) {
			Color4f color = a.color;
			int count = a.count;
			buffer.putInt(count);
			buffer.put(UnsignedBytes.checkedCast((int)(color.getR() * 255)));
			buffer.put(UnsignedBytes.checkedCast((int)(color.getG() * 255)));
			buffer.put(UnsignedBytes.checkedCast((int)(color.getB() * 255)));
			buffer.put(UnsignedBytes.checkedCast((int)(color.getA() * 255)));
		}
		return buffer.array();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	public void setHasTransparency(boolean hasTransparency) {
		this.hasTransparency = hasTransparency;
	}
}
