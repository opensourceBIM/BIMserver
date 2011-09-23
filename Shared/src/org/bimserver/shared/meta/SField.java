package org.bimserver.shared.meta;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

public class SField {
	private String name;
	private final Class<?> type;
	private final boolean many;
	
	public SField(String name, Class<?> type) {
		this(name, type, false);
	}

	public SField(String name, Class<?> type, boolean many) {
		this.name = name;
		this.type = type;
		this.many = many;
	}

	public boolean isMany() {
		return many;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
}
