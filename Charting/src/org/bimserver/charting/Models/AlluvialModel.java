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

public class AlluvialModel extends Model {

	public static final List<String> DefaultDimensions = Arrays.asList(new String[] {"steps", "size"});
	public static final List<String> AllDimensions = Arrays.asList(new String[] {"steps", "size"});

	public AlluvialModel() {
		this(AlluvialModel.DefaultDimensions);
	}

	public AlluvialModel(final List<String> dimensions) {
		super(
			"alluvial",
			"Alluvial data model.",
			new ArrayList<ModelDimension> () {{
				// Group.
				if (dimensions.contains("steps")) 
					add(
						new ModelDimension(
							"Steps",
							"steps",
							"This dimension is used to classify data into relations.",
							ModelDimension.DefaultTypes,
							2,
							true
						)
					);
				// Size.
				if (dimensions.contains("size"))
					add(
						new ModelDimension(
							"Size",
							"size",
							"Size of data block.",
							ModelDimension.NumbersOnly,
							1,
							false
						)
					);
			}}
		);
	}
}
