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

public class IntegerBound extends Bound {
	//-1 == unbounded
	private int bound_value = -1;

	public int getBound_value() {
		return bound_value;
	}

	public void setBound_value(int bound_value) {
		this.bound_value = bound_value;
	}

	public IntegerBound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IntegerBound(int bound_value) {
		super();
		this.bound_value = bound_value;
	}
	
}
