package org.bimserver;

import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.shared.meta.SMethod;
import org.bimserver.shared.meta.SService;

public class MethodStats {
	private final AtomicLong nrCalls = new AtomicLong();
	private final AtomicLong totalNanoSeconds = new AtomicLong();

	public MethodStats(SService sService, SMethod sMethod) {
	}

	public void add(Recording recording) {
		nrCalls.incrementAndGet();
		totalNanoSeconds.addAndGet(recording.getTotalTime());
	}
	
	public long getAverageNanoSecondsPerCall() {
		return totalNanoSeconds.get() / nrCalls.get();
	}

	public long getNrCalls() {
		return nrCalls.get();
	}
}