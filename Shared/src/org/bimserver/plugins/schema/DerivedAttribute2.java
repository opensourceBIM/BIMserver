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

public class DerivedAttribute2 {
	private String name;
	private BaseType type;
	private String expressCode;
	private final boolean collection;
	private boolean hasSuper;

	public DerivedAttribute2 (String name, BaseType type, String expressCode, boolean collection, boolean hasSuper) {
		this.name = name;
		this.type = type;
		this.expressCode = expressCode;
		this.collection = collection;
		this.hasSuper = hasSuper;
	}

	public String getName() {
		return name;
	}
	
	public BaseType getType() {
		return type;
	}

	public String getExpressCode() {
		return expressCode;
	}
	
	public boolean isCollection() {
		return collection;
	}

	public boolean hasSuper() {
		return hasSuper;
	}
}