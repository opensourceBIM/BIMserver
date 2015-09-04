package org.bimserver;

import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;

public class Recording {
	private long start;
	private MetricsRegistry metricsRegistry;
	private long end;
	private SMethod method;

	public Recording(MetricsRegistry metricsRegistry, SService sService, SMethod method) {
		this.metricsRegistry = metricsRegistry;
		this.method = method;
		start = System.nanoTime();
	}

	public void finish() {
		end = System.nanoTime();
		metricsRegistry.getMethodStats(method).add(this);
	}

	public long getTotalTime() {
		return end - start;
	}
}
