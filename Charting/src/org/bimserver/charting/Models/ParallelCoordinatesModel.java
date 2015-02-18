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

public class ParallelCoordinatesModel extends Model {

	public static final List<String> DefaultDimensions = Arrays.asList(new String[] {"dimensions"});
	public static final List<String> AllDimensions = Arrays.asList(new String[] {"dimensions", "color"});

	public ParallelCoordinatesModel() {
		this(ParallelCoordinatesModel.DefaultDimensions);
	}

	public ParallelCoordinatesModel(final List<String> dimensions) {
		super(
			"parallel coordinates",
			"Parallel coordinates data model.",
			new ArrayList<ModelDimension> () {{
				// Dimensions (as axes).
				if (dimensions.contains("dimensions")) 
					add(
						new ModelDimension(
							"Dimensions",
							"dimensions",
							"This dimension is used to transform data into vertical axes.",
							ModelDimension.DefaultTypes,
							1,
							true
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
			}}
		);
	}
}
