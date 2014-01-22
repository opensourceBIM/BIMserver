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

public class ArrayType extends AggregationType {
	private Bound lower_index;
	private Bound upper_index;
	private boolean unique_flag;
	private boolean optional_flag;
	
	public ArrayType(BaseType element_type) {
		super(element_type);
		// TODO Auto-generated constructor stub
	}



	public Bound getLower_index() {
		return lower_index;
	}

	public void setLower_index(Bound lower_index) {
		this.lower_index = lower_index;
	}

	public boolean isOptional_flag() {
		return optional_flag;
	}

	public void setOptional_flag(boolean optional_flag) {
		this.optional_flag = optional_flag;
	}

	public boolean isUnique_flag() {
		return unique_flag;
	}

	public void setUnique_flag(boolean unique_flag) {
		this.unique_flag = unique_flag;
	}

	public Bound getUpper_index() {
		return upper_index;
	}

	public void setUpper_index(Bound upper_index) {
		this.upper_index = upper_index;
	}

}
