package org.bimserver.cache;

import org.bimserver.ifc.compare.CompareResult;
import org.bimserver.shared.SCompareResult.SCompareIdentifier;
import org.bimserver.shared.SCompareResult.SCompareType;

public class CompareCache extends GenericCache<CompareCache.CompareKey, CompareCache.CompareValue> {
	private static final int MAX_UNACCESSED_TIME_MS = 1000 * 60 * 30; // 30 minutes

	public static class CompareKey extends GenericCacheKey {
		private final long roid1;
		private final long roid2;
		private final SCompareType sCompareType;
		private final SCompareIdentifier sCompareIdentifier;

		public CompareKey(long roid1, long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier) {
			super();
			this.roid1 = roid1;
			this.roid2 = roid2;
			this.sCompareType = sCompareType;
			this.sCompareIdentifier = sCompareIdentifier;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (roid1 ^ (roid1 >>> 32));
			result = prime * result + (int) (roid2 ^ (roid2 >>> 32));
			result = prime
					* result
					+ ((sCompareIdentifier == null) ? 0 : sCompareIdentifier
							.hashCode());
			result = prime * result
					+ ((sCompareType == null) ? 0 : sCompareType.hashCode());
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
			CompareKey other = (CompareKey) obj;
			if (roid1 != other.roid1)
				return false;
			if (roid2 != other.roid2)
				return false;
			if (sCompareIdentifier == null) {
				if (other.sCompareIdentifier != null)
					return false;
			} else if (!sCompareIdentifier.equals(other.sCompareIdentifier))
				return false;
			if (sCompareType == null) {
				if (other.sCompareType != null)
					return false;
			} else if (!sCompareType.equals(other.sCompareType))
				return false;
			return true;
		}
	}

	public static class CompareValue extends GenericCacheValue {

		private final CompareResult compareResults;

		public CompareValue(CompareResult compareResults) {
			super(MAX_UNACCESSED_TIME_MS);
			this.compareResults = compareResults;
		}

		public CompareResult getCompareResults() {
			return compareResults;
		}
	}

	public CompareCache() {
		super();
	}

	public CompareResult getCompareResults(long roid1, long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier) {
		CompareValue compareValue = getValue(new CompareKey(roid1, roid2, sCompareType, sCompareIdentifier));
		if (compareValue != null) {
			compareValue.access();
			return compareValue.getCompareResults();
		}
		return null;
	}

	public void storeResults(long roid1, long roid2, SCompareType sCompareType, SCompareIdentifier sCompareIdentifier, CompareResult compareResults) {
		store(new CompareKey(roid1, roid2, sCompareType, sCompareIdentifier), new CompareValue(compareResults));
	}
}