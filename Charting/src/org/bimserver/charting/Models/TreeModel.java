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

public class TreeModel extends Model {

	public static final List<String> DefaultDimensions = Arrays.asList(new String[] {"hierarchy"});
	public static final List<String> AllDimensions = Arrays.asList(new String[] {"hierarchy", "size", "color", "label"});

	public TreeModel() {
		this(TreeModel.DefaultDimensions);
	}

	public TreeModel(final List<String> dimensions) {
		super(
			"tree",
			"Tree data model.",
			new ArrayList<ModelDimension> () {{
				// Hierarchy Axis (multiple/stacked).
				if (dimensions.contains("hierarchy")) 
					add(
						new ModelDimension(
							"Hierarchy",
							"hierarchy",
							"This dimension is used to classify data into categories.",
							ModelDimension.DefaultTypes,
							1,
							true
						)
					);
				// Cluster Axis (single). Alternative to hierarchy dimension.
				if (dimensions.contains("clusters")) 
					add(
						new ModelDimension(
							"Clusters",
							"clusters",
							"This dimension is used to classify data by a single category.",
							ModelDimension.DefaultTypes,
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
							"Size of data block.",
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
							"Color of block.",
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
							"Block labels.",
							ModelDimension.DefaultTypes,
							0,
							true
						)
					);
			}}
		);
	}
}
