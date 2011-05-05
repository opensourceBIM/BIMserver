package org.bimserver;

import org.bimserver.merging.Merger;
import org.bimserver.merging.Merger.GuidMergeIdentifier;
import org.bimserver.merging.Merger.NameMergeIdentifier;
import org.bimserver.models.store.MergeIdentifier;
import org.bimserver.models.store.Settings;

public class MergerFactory {
	private SettingsManager settingsManager;

	public MergerFactory(SettingsManager settingsManager) {
		this.settingsManager = settingsManager;
	}

	public Merger createMerger() {
		Settings settings = settingsManager.getSettings();
		if (settings.getMergeIdentifier() == MergeIdentifier.GUID) {
			return new Merger(new GuidMergeIdentifier());
		} else if (settings.getMergeIdentifier() == MergeIdentifier.NAME) {
			return new Merger(new NameMergeIdentifier());
		}
		return null;
	}
}
