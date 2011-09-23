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

import java.util.HashMap;
import java.util.Map;

public class SClass {
	private final Map<String, SField> fields = new HashMap<String, SField>();
	private final String name;
	
	public SClass(String name) {
		this.name = name;
	}
	
	public void addField(SField sField) {
		fields.put(sField.getName(), sField);
	}
	
	public String getName() {
		return name;
	}
	
	public SField getField(String name) {
		return fields.get(name);
	}
}
