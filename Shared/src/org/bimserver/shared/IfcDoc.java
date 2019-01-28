package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IfcDoc {
	private final Map<String, Set<String>> domainToClasses = new HashMap<String, Set<String>>(); 
	private final Map<String, String> classesToDomain = new HashMap<String, String>(); 

	public IfcDoc(File dir) {
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				for (File x : f.listFiles()) {
					if (x.isDirectory() && x.getName().equals("lexical")) {
						for (File y : x.listFiles()) {
							if (y.getName().endsWith(".htm")) {
								String domain = f.getName();
								String classname = y.getName().substring(0, y.getName().length() - 4);
								if (!domainToClasses.containsKey(domain)) {
									domainToClasses.put(domain, new HashSet<String>());
								}
								domainToClasses.get(domain).add(classname);
								classesToDomain.put(classname, domain);
							}
						}
					}
				}
			}
		}
	}

	public String getDomain(String name) {
		return classesToDomain.get(name.toLowerCase());
	}
	
	public Set<String> getClassNames(String domain) {
		return domainToClasses.get(domain);
	}

	public Set<String> getDomains() {
		return domainToClasses.keySet();
	}
}
