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

public abstract class AggregationType  implements BaseType, UnderlyingType{
	/**
	 * the base type this aggregation collects
	 */
	private BaseType element_type;

	
	/** Standard constructor
	 * @param element_type a base element type this aggregation collects
	 */
	public AggregationType( BaseType element_type) {
		
		this.element_type = element_type;
	}

	/**
	 * @return the element type this type aggregates
	 */
	public BaseType getElement_type() {
		return element_type;
	}

	/**
	 * @param element_type set the base type this type aggregates
	 */
	public void setElement_type(BaseType element_type) {
		this.element_type = element_type;
	}
}
