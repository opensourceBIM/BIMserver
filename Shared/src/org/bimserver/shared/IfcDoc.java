package org.bimserver.shared;

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
								System.out.println(domain + " -> " + classname);
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
		return classesToDomain.get(name);
	}
	
	public Set<String> getClassNames(String domain) {
		return domainToClasses.get(domain);
	}

	public Set<String> getDomains() {
		return domainToClasses.keySet();
	}
}
