package org.bimserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.store.ClashDetectionSettings;
import org.bimserver.database.store.EidClash;
import org.bimserver.database.store.Revision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClashDetectionCache {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClashDetectionCache.class);

	public static class ClashDetectionSettingsKey {
		private final float margin;
		private final List<String> ignoredClasses = new ArrayList<String>();
		private final List<Long> revisions = new ArrayList<Long>();

		public ClashDetectionSettingsKey(ClashDetectionSettings clashDetectionSettings) {
			this.margin = clashDetectionSettings.getMargin();
			for (Revision revision : clashDetectionSettings.getRevisions()) {
				this.revisions.add(revision.getOid());
			}
			for (String className : clashDetectionSettings.getIgnoredClasses()) {
				this.ignoredClasses.add(className);
			}
		}

		public float getMargin() {
			return margin;
		}

		public List<String> getIgnoredClasses() {
			return ignoredClasses;
		}

		public List<Long> getRevisions() {
			return revisions;
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
	
	public static class ClashDetectionResult {
		private static final int MAX_UNACCESSED_TIME_MILLIS = 1800000; // 30 minutes
		private final Set<EidClash> clashes;
		private Date lastAccessed;
		
		public ClashDetectionResult(Set<EidClash> clashes) {
			this.clashes = clashes;
			lastAccessed = new Date();
		}
		
		public Set<EidClash> getClashes() {
			return clashes;
		}

		public boolean shouldCleanUp() {
			return new Date().getTime() - lastAccessed.getTime() > MAX_UNACCESSED_TIME_MILLIS;
		}

		public void access() {
			lastAccessed = new Date();
		}
	}

	private static final ClashDetectionCache INSTANCE = new ClashDetectionCache();

	private final Map<ClashDetectionSettingsKey, ClashDetectionResult> clashes = new HashMap<ClashDetectionSettingsKey, ClashDetectionResult>();
	
	public synchronized void storeClashDetection(ClashDetectionSettings clashDetectionSettings, Set<EidClash> clashes) {
		this.clashes.put(new ClashDetectionSettingsKey(clashDetectionSettings), new ClashDetectionResult(clashes));
	}
	
	public synchronized Set<EidClash> getClashDetection(ClashDetectionSettings clashDetectionSettings) {
		ClashDetectionResult clashDetectionResult = clashes.get(new ClashDetectionSettingsKey(clashDetectionSettings));
		if (clashDetectionResult != null) {
			clashDetectionResult.access();
			return clashDetectionResult.getClashes();
		}
		return null;
	}

	public static ClashDetectionCache getInstance() {
		return INSTANCE;
	}

	public synchronized void cleanup() {
		Iterator<ClashDetectionSettingsKey> iterator = clashes.keySet().iterator();
		while (iterator.hasNext()) {
			ClashDetectionSettingsKey clashDetectionSettingsKey = iterator.next();
			if (clashes.get(clashDetectionSettingsKey).shouldCleanUp()) {
				LOGGER.info("Removing one clash detection cache item");
				iterator.remove();
			}
		}
	}
}