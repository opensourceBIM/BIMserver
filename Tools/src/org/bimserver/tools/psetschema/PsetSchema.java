package org.bimserver.tools.psetschema;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.HashMap;
import java.util.Map;

public class PsetSchema {

	private final Map<String, ClassDefinition> classes = new HashMap<String, ClassDefinition>();
	
	public ClassDefinition addOrGetClass(String name) {
		if (classes.containsKey(name)) {
			return classes.get(name);
		}
		ClassDefinition classDefinition = new ClassDefinition(name);
		classes.put(name, classDefinition);
		return classDefinition;
	}

	public ClassDefinition getClass(String name) {
		return classes.get(name);
	}
}