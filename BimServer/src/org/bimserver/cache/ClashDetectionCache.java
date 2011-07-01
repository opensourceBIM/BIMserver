package org.bimserver.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.Revision;

public class ClashDetectionCache extends GenericCache<ClashDetectionCache.ClashDetectionSettingsKey, ClashDetectionCache.ClashDetectionValue> {
	private static final int MAX_UNACCESSED_TIME_MILLIS = 1000 * 60 * 30; // 30 minutes

	public static class ClashDetectionSettingsKey extends GenericCacheKey {
		private final float margin;
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
			result = prime * result + Float.floatToIntBits(margin);
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
			if (Float.floatToIntBits(margin) != Float.floatToIntBits(other.margin))
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