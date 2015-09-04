package org.bimserver;

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
	
	public MethodStats getMethodStats(SMethod sMethod) {
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
	
	public SMetrics getMetrics() {
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