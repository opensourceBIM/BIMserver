package org.bimserver.shared;

import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.emf.ecore.EClass;

public class OpenConnectionCounter {
	private final AtomicLong atomicLong = new AtomicLong();
	private EClass eClass;
	
	public OpenConnectionCounter(EClass eClass) {
		this.eClass = eClass;
	}

	public long incrementAndGet() {
		return atomicLong.getAndIncrement();
	}

	public long decrementAndGet() {
		return atomicLong.decrementAndGet();
	}
	
	@Override
	public String toString() {
		return eClass.getName() + ": " + atomicLong.get();
	}
}
