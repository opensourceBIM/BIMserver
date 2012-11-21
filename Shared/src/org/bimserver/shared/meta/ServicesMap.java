package org.bimserver.shared.meta;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.shared.reflector.ReflectorFactory;

public class ServicesMap {
	private final Map<String, SService> servicesByName = new LinkedHashMap<String, SService>();
	private final Map<String, SService> servicesBySimpleName = new LinkedHashMap<String, SService>();
	private ReflectorFactory reflectorFactory;
	
	public void add(SService sService) {
		servicesByName.put(sService.getName(), sService);
		servicesBySimpleName.put(sService.getSimpleName(), sService);
		sService.setServicesMap(this);
	}

	public SService getByName(String name) {
		return servicesByName.get(name);
	}

	public SService getBySimpleName(String name) {
		return servicesBySimpleName.get(name);
	}
	
	public SClass getType(String name) {
		for (SService sService : servicesByName.values()) {
			SClass type = sService.getSType(name);
			if (type != null) {
				return type;
			}
		}
		return null;
	}

	public Set<String> keySetName() {
		return servicesByName.keySet();
	}

	public Set<String> keySetSimpleName() {
		return servicesBySimpleName.keySet();
	}

	public void setReflectorFactory(ReflectorFactory reflectorFactory) {
		this.reflectorFactory = reflectorFactory;
	}
	
	public ReflectorFactory getReflectorFactory() {
		return reflectorFactory;
	}
}