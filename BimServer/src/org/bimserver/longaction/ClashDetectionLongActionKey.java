package org.bimserver.longaction;

public class ClashDetectionLongActionKey extends LongActionKey {

	private final long poid;

	public ClashDetectionLongActionKey(long poid) {
		this.poid = poid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (poid ^ (poid >>> 32));
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
		ClashDetectionLongActionKey other = (ClashDetectionLongActionKey) obj;
		if (poid != other.poid)
			return false;
		return true;
	}
}