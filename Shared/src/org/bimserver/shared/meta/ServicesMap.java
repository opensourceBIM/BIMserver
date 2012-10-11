package org.bimserver.shared.meta;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ServicesMap {
	private final Map<String, SService> services = new LinkedHashMap<String, SService>();
	
	public void add(SService sService) {
		services.put(sService.getName(), sService);
	}

	public SService get(String name) {
		return services.get(name);
	}
	
	public SClass getType(String name) {
		for (SService sService : services.values()) {
			SClass type = sService.getSType(name);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	public Set<String> keySet() {
		return services.keySet();
	}
}