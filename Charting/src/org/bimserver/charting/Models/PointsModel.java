package org.bimserver.charting.Models;

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
import java.util.List;

import org.bimserver.charting.Dimensions.ModelDimension;

public class PointsModel extends Model {

	public static final List<String> DefaultDimensions = Arrays.asList(new String[] {"x", "y"});
	public static final List<String> AllDimensions = Arrays.asList(new String[] {"x", "y", "size", "color", "label"});

	public PointsModel() {
		this(PointsModel.DefaultDimensions);
	}

	public PointsModel(final List<String> dimensions) {
		super(
			"points",
			"Facilitate the display of singular data points on a chart.",
			new ArrayList<ModelDimension> () {{
				// X Axis.
				if (dimensions.contains("x")) 
					add(
						new ModelDimension(
							"X Axis",
							"x",
							"Numeric horizontal advance.",
							ModelDimension.NumbersAndDatesOnly,
							1,
							false
						)
					);
				// Y Axis.
				if (dimensions.contains("y"))
					add(
						new ModelDimension(
							"Y Axis",
							"y",
							"Numeric vertical advance.",
							ModelDimension.NumbersAndDatesOnly,
							1,
							false
						)
					);
				// Optional: Size.
				if (dimensions.contains("size"))
					add(
						new ModelDimension(
							"Size",
							"size",
							"Size of data point.",
							ModelDimension.NumbersOnly,
							0,
							false
						)
					);
				// Optional: Color.
				if (dimensions.contains("color"))
					add(
						new ModelDimension(
							"Color",
							"color",
							"Color of points.",
							ModelDimension.DefaultTypes,
							0,
							false
						)
					);
				// Optional: Label (multiple).
				if (dimensions.contains("label"))
					add(
						new ModelDimension(
							"Label",
							"label",
							"Point labels.",
							ModelDimension.DefaultTypes,
							0,
							true
						)
					);
			}}
		);
	}
}
