package org.bimserver;

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
