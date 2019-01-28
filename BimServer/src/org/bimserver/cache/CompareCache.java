package org.bimserver.cache;

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

import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;

public class CompareCache extends GenericCache<CompareCache.CompareKey, CompareCache.CompareValue> {
	private static final int MAX_UNACCESSED_TIME_MS = 1000 * 60 * 30; // 30 minutes

	public static class CompareKey extends GenericCacheKey {
		private final long roid1;
		private final long roid2;
		private final CompareType sCompareType;

		public CompareKey(long roid1, long roid2, CompareType sCompareType) {
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
			result = prime * result	+ ((sCompareType == null) ? 0 : sCompareType.hashCode());
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

	public CompareCache() {
		super();
	}

	public CompareResult getCompareResults(long roid1, long roid2, CompareType sCompareType) {
		CompareValue compareValue = getValue(new CompareKey(roid1, roid2, sCompareType));
		if (compareValue != null) {
			compareValue.access();
			return compareValue.getCompareResults();
		}
		return null;
	}

	public void storeResults(long roid1, long roid2, CompareType sCompareType, CompareResult compareResults) {
		store(new CompareKey(roid1, roid2, sCompareType), new CompareValue(compareResults));
	}
}