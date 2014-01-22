package org.bimserver.plugins.schema;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

public abstract class VariableSizeAggregationType extends AggregationType {

	private Bound lower_bound;
	private Bound upper_bound;
	


	public VariableSizeAggregationType(BaseType element_type) {
		super(element_type);
		// TODO Auto-generated constructor stub
	}

	public Bound getLower_bound() {
		return lower_bound;
	}

	public void setLower_bound(Bound lower_bound) {
		this.lower_bound = lower_bound;
	}

	public Bound getUpper_bound() {
		return upper_bound;
	}

	public void setUpper_bound(Bound upper_bound) {
		this.upper_bound = upper_bound;
	}

}
