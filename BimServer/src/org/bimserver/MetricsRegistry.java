package org.bimserver;

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

import java.util.HashMap;
import java.util.Map;

import org.bimserver.interfaces.objects.SInterfaceMetric;
import org.bimserver.interfaces.objects.SMethodMetric;
import org.bimserver.interfaces.objects.SMetrics;
import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;

public class MetricsRegistry {

	private final Map<SService, Map<SMethod, MethodStats>> methodStats = new HashMap<>();
	
	public Recording startRecording(SService sService, SMethod method) {
		return new Recording(this, sService, method);
	}
	
	public synchronized MethodStats getMethodStats(SMethod sMethod) {
		Map<SMethod, MethodStats> map = this.methodStats.get(sMethod.getService());
		if (map == null) {
			map = new HashMap<SMethod, MethodStats>();
			this.methodStats.put(sMethod.getService(), map);
		}
		MethodStats methodStats = map.get(sMethod);
		if (methodStats == null) {
			methodStats = new MethodStats(sMethod.getService(), sMethod);
			map.put(sMethod, methodStats);
		}
		return methodStats;
	}
	
	public synchronized SMetrics getMetrics() {
		SMetrics sMetrics = new SMetrics();
		for (SService sService : methodStats.keySet()) {
			SInterfaceMetric interfaceMetric = new SInterfaceMetric();
			interfaceMetric.setName(sService.getSimpleName());
			
			sMetrics.getInterfaces().add(interfaceMetric);
			for (SMethod sMethod : methodStats.get(sService).keySet()) {
				SMethodMetric sMethodMetric = new SMethodMetric();
				sMethodMetric.setName(sMethod.getName());
				
				interfaceMetric.getMethods().add(sMethodMetric);
				
				MethodStats methodStats = getMethodStats(sMethod);
				sMethodMetric.setNrCalls(methodStats.getNrCalls());
				sMethodMetric.setAverageMs(methodStats.getAverageNanoSecondsPerCall() / 1000000);
			}
		}
		return sMetrics;
	}
}