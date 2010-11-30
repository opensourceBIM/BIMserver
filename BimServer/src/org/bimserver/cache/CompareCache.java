package org.bimserver.cache;

import org.bimserver.ifc.file.compare.CompareResult;
import org.bimserver.shared.SCompareResult.SCompareType;

public class CompareCache extends GenericCache<CompareCache.CompareKey, CompareCache.CompareValue> {
	private static final int MAX_UNACCESSED_TIME_MS = 1000 * 60 * 30; // 30 minutes
	private static final CompareCache INSTANCE = new CompareCache();

	public static class CompareKey extends GenericCacheKey {
		private final long roid1;
		private final long roid2;
		private final SCompareType sCompareType;

		public CompareKey(long roid1, long roid2, SCompareType sCompareType) {
			super();
			this.roid1 = roid1;
			this.roid2 = roid2;
			this.sCompareType = sCompareType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (roid1 ^ (roid1 >>> 32));
			result = prime * result + (int) (roid2 ^ (roid2 >>> 32));
			result = prime * result + ((sCompareType == null) ? 0 : sCompareType.hashCode());
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

	private CompareCache() {
		super();
	}

	public static CompareCache getInstance() {
		return INSTANCE;
	}

	public CompareResult getCompareResults(long roid1, long roid2, SCompareType sCompareType) {
		CompareValue compareValue = getValue(new CompareKey(roid1, roid2, sCompareType));
		if (compareValue != null) {
			compareValue.access();
			return compareValue.getCompareResults();
		}
		return null;
	}

	public void storeResults(long roid1, long roid2, SCompareType sCompareType, CompareResult compareResults) {
		store(new CompareKey(roid1, roid2, sCompareType), new CompareValue(compareResults));
	}
}