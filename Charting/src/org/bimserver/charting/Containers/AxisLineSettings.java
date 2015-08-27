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

import org.openmali.vecmath2.Colord;

public class AxisLineSettings {
	public double StartLineCapAmount;
	public double EndLineCapAmount;
	public Colord LineColor;
	public boolean OnlyDrawLineForFirstAndLastTick;
	public boolean DoNotDrawLastAxisLine;
	public boolean IncludeLabels = true;

	public AxisLineSettings(double startLineCapAmount, double endLineCapAmount, Colord lineColor, boolean onlyDrawLineForFirstAndLastTick) {
		this(startLineCapAmount, endLineCapAmount, lineColor, onlyDrawLineForFirstAndLastTick, true);
	}

	public AxisLineSettings(double startLineCapAmount, double endLineCapAmount, Colord lineColor, boolean onlyDrawLineForFirstAndLastTick, boolean includeLabels) {
		StartLineCapAmount = startLineCapAmount;
		EndLineCapAmount = endLineCapAmount;
		LineColor = lineColor;
		OnlyDrawLineForFirstAndLastTick = onlyDrawLineForFirstAndLastTick;
		IncludeLabels = includeLabels;
	}

	public String getStrokeColor() {
		return String.format("rgb(%s%%, %s%%, %s%%)", 100.0 * LineColor.r(), 100.0 * LineColor.g(), 100.0 * LineColor.b());
	}
}