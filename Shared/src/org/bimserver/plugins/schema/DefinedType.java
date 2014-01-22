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

public class DefinedType extends NamedType implements UnderlyingType{
	private UnderlyingType domain;
		
	public UnderlyingType getDomain() {
		return domain;
	}

	public void setDomain(UnderlyingType domain) {
		this.domain = domain;
	}

	public DefinedType(String name, UnderlyingType domain) {
		super(name);
		this.domain = domain;
	}

	public DefinedType(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public UnderlyingType getDomain(boolean includeSubtypes){
		UnderlyingType ut = this.domain;
		if (ut instanceof DefinedType ){
			ut = ((DefinedType)domain).getDomain(includeSubtypes);
		}
		return ut;
	}

	
}
