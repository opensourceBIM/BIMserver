package org.bimserver.longaction;

public class LongCheckinActionKey extends LongActionKey {

	private final long croid;

	public LongCheckinActionKey(long croid) {
		this.croid = croid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (croid ^ (croid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LongCheckinActionKey other = (LongCheckinActionKey) obj;
		if (croid != other.croid)
			return false;
		return true;
	}
}