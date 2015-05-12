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

public class StreamModel extends Model {

	public static final List<String> DefaultDimensions = Arrays.asList(new String[] {"group", "date", "size"});
	public static final List<String> AllDimensions = Arrays.asList(new String[] {"group", "date", "size"});

	public StreamModel() {
		this(StreamModel.DefaultDimensions);
	}

	public StreamModel(final List<String> dimensions) {
		super(
			"stream",
			"Stream data model.",
			new ArrayList<ModelDimension> () {{
				// Group.
				if (dimensions.contains("group")) 
					add(
						new ModelDimension(
							"Group",
							"group",
							"This dimension is used to classify data into categories.",
							ModelDimension.DefaultTypes,
							1,
							false
						)
					);
				// Date.
				if (dimensions.contains("date")) 
					add(
						new ModelDimension(
							"Date",
							"date",
							"This dimension is used to timestamp data.",
							ModelDimension.NumbersAndDatesOnly,
							1,
							false
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
