package org.bimserver.merging;

import org.bimserver.plugins.serializers.OidProvider;

public class IncrementingOidProvider implements OidProvider {

	private long counter;

	public IncrementingOidProvider(long start) {
		this.counter = start;
	}

	@Override
	public long newOid() {
		return counter++;
	}
}
