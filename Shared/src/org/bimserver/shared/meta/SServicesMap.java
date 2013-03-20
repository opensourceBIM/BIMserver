package org.bimserver.shared.meta;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.reflector.ReflectorFactory;

public class SServicesMap {
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

	@SuppressWarnings("unchecked")
	public Set<Class<? extends PublicInterface>> getInterfaceClasses() {
		Set<Class<? extends PublicInterface>> result = new HashSet<Class<? extends PublicInterface>>();
		for (SService sService : servicesByName.values()) {
			result.add((Class<? extends PublicInterface>) sService.getInstanceClass());
		}
		return result;
	}
	
	public void setReflectorFactory(ReflectorFactory reflectorFactory) {
		this.reflectorFactory = reflectorFactory;
	}
	
	public ReflectorFactory getReflectorFactory() {
		return reflectorFactory;
	}

	/**
	 * Inefficient method of getting a SMethod
	 * @param methodName
	 * @return
	 */
	public SMethod findMethod(String methodName) {
		for (SService sService : servicesByName.values()) {
			SMethod method = sService.getSMethod(methodName);
			if (method != null) {
				return method;
			}
		}
		return null;
	}
}