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

import java.util.ArrayList;
import java.util.Comparator;

import org.bimserver.charting.Dimensions.ModelDimension;
import org.openmali.vecmath2.Vector2d;

public class SankeyNode {

	public static Comparator<SankeyNode> ascendingDepth = new Comparator<SankeyNode>() {
		public int compare(SankeyNode p1, SankeyNode p2) {
			//
			double a = p1.Location.y();
			double b = p2.Location.y();
			// Sort larger values to end of collection. Sort smaller values to start of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public static Comparator<SankeyNode> ascendingBreadth = new Comparator<SankeyNode>() {
		public int compare(SankeyNode p1, SankeyNode p2) {
			//
			double a = p1.Location.x();
			double b = p2.Location.x();
			// Sort larger values to end of collection. Sort smaller values to start of collection.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public static Comparator<SankeyNode> ascendingName = new Comparator<SankeyNode>() {
		public int compare(SankeyNode p1, SankeyNode p2) {
			String a = p1.Name.toLowerCase();
			String b = p2.Name.toLowerCase();
			return ModelDimension.compareNatural(a, b);
		}
	};


	public static Comparator<SankeyNode> advancingXValue = new Comparator<SankeyNode>() {
		public int compare(SankeyNode p1, SankeyNode p2) {
			double a = p1.Location.x();
			double b = p2.Location.x();
			// If A is farther right than B, move A towards back of list.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	public static Comparator<SankeyNode> ascendingValue = new Comparator<SankeyNode>() {
		public int compare(SankeyNode p1, SankeyNode p2) {
			double a = p1.getValue();
			double b = p2.getValue();
			// If A is larger than B, move A towards back of list.
			if (a > b)
				return 1;
			else if (a < b)
				return -1;
			else
				return 0;
		}
	};

	// Used for screen printing.
	public String Name = null;
	public double ColorId = 0;
	// Necessary for the algorithm.
	public ArrayList<SankeyLink> SourceLinks = new ArrayList<>();
	public ArrayList<SankeyLink> TargetLinks = new ArrayList<>();
	public Vector2d Location = new Vector2d(0, 0);
	public Vector2d Delta = new Vector2d(0, 0);
	public Double Value = null;

	/**
	 * @param name
	 */
	public SankeyNode(String name) {
		super();
		Name = name;
	}

	/**
	 * @param name
	 * @param value
	 */
	public SankeyNode(String name, Double value) {
		super();
		Name = name;
		Value = value;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return (Value != null) ? Value : 0.0;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Double value) {
		Value = value;
	}

	public double getCenterY() {
		return Location.y() + Delta.y() / 2.0;
	}
}
