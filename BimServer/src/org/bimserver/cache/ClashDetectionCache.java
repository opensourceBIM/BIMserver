package org.bimserver.cache;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.Revision;

public class ClashDetectionCache extends GenericCache<ClashDetectionCache.ClashDetectionSettingsKey, ClashDetectionCache.ClashDetectionValue> {
	private static final int MAX_UNACCESSED_TIME_MILLIS = 1000 * 60 * 30; // 30 minutes

	public static class ClashDetectionSettingsKey extends GenericCacheKey {
		private final double margin;
		private final List<String> ignoredClasses = new ArrayList<String>();
		private final List<Long> revisions = new ArrayList<Long>();

		public ClashDetectionSettingsKey(ClashDetectionSettings clashDetectionSettings) {
			super();
			this.margin = clashDetectionSettings.getMargin();
			for (Revision revision : clashDetectionSettings.getRevisions()) {
				this.revisions.add(revision.getOid());
			}
			for (String className : clashDetectionSettings.getIgnoredClasses()) {
				this.ignoredClasses.add(className);
			}
		}

		@Override
		public String toString() {
			return "margin: " + margin + ", ignoredClasses: " + ignoredClasses.toString() + ", revisions: " + revisions.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ignoredClasses == null) ? 0 : ignoredClasses.hashCode());
			long temp;
			temp = Double.doubleToLongBits(margin);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((revisions == null) ? 0 : revisions.hashCode());
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
			ClashDetectionSettingsKey other = (ClashDetectionSettingsKey) obj;
			if (ignoredClasses == null) {
				if (other.ignoredClasses != null)
					return false;
			} else if (!ignoredClasses.equals(other.ignoredClasses))
				return false;
			if (Double.doubleToLongBits(margin) != Double.doubleToLongBits(other.margin))
				return false;
			if (revisions == null) {
				if (other.revisions != null)
					return false;
			} else if (!revisions.equals(other.revisions))
				return false;
			return true;
		}
	}

	public static class ClashDetectionValue extends GenericCacheValue {
		private final Set<EidClash> clashes;

		public ClashDetectionValue(Set<EidClash> clashes) {
			super(MAX_UNACCESSED_TIME_MILLIS);
			this.clashes = clashes;
		}

		public Set<EidClash> getClashes() {
			return clashes;
		}
	}

	public ClashDetectionCache() {
		super();
	}

	public synchronized void storeClashDetection(ClashDetectionSettings clashDetectionSettings, Set<EidClash> clashes) {
		store(new ClashDetectionSettingsKey(clashDetectionSettings), new ClashDetectionValue(clashes));
	}

	public synchronized Set<EidClash> getClashDetection(ClashDetectionSettings clashDetectionSettings) {
		ClashDetectionValue value = getValue(new ClashDetectionSettingsKey(clashDetectionSettings));
		if (value == null) {
			return null;
		}
		return value.getClashes();
	}
}