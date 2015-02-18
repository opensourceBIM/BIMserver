package org.bimserver.charting.Algorithms.Sankey;

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

import java.util.Comparator;

import org.openmali.vecmath2.Vector2d;

public class SankeyLink {

	public static Comparator<SankeyLink> ascendingSourceDepth = new Comparator<SankeyLink>() {
		public int compare(SankeyLink p1, SankeyLink p2) {
			//
			double a = p1.Source.Location.y();
			double b = p2.Source.Location.y();
			// Sort larger values to end of collection. Sort smaller values to start of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public static Comparator<SankeyLink> ascendingTargetDepth = new Comparator<SankeyLink>() {
		public int compare(SankeyLink p1, SankeyLink p2) {
			//
			double a = p1.Target.Location.y();
			double b = p2.Target.Location.y();
			// Sort larger values to end of collection. Sort smaller values to start of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public double Curvature = 0.5;
	public SankeyNode Source = null;
	public SankeyNode Target = null;
	public Double Value = null;
	public Vector2d Delta = new Vector2d(0, 0);
	public Double sy = 0.0;
	public Double ty = 0.0;

	/**
	 * @param source
	 * @param target
	 */
	public SankeyLink(SankeyNode source, SankeyNode target) {
		super();
		Source = source;
		Target = target;
	}

	/**
	 * @param source
	 * @param target
	 * @param value
	 */
	public SankeyLink(SankeyNode source, SankeyNode target, double value) {
		super();
		Source = source;
		Target = target;
		Value = value;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return (Value != null) ? Value : 0.0;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Double value) {
		Value = value;
	}

	public String link() {
		double x0 = Source.Location.x() + Source.Delta.x();
		double x1 = Target.Location.x();
		double x2 = lerp(Curvature, x0, x1);
		double x3 = lerp(1 - Curvature, x0, x1);
		double y0 = Source.Location.y() + sy + Delta.y() / 2.0;
		double y1 = Target.Location.y() + ty + Delta.y() / 2.0;
		return String.format("M %s, %s C %s, %s %s, %s %s, %s", x0, y0, x2, y0, x3, y1, x1, y1);
	}

	public double lerp(double t, double a, double b) {
		return a * (1 - t) + b * t;
	}
}