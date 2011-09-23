package org.bimserver.guidanceproviders;

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

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.guidanceproviders.GuidanceProvider;
import org.bimserver.plugins.guidanceproviders.GuidanceProviderPlugin;
import org.bimserver.utils.CollectionUtils;

public class FileBasedGuidanceProviderPlugin implements GuidanceProviderPlugin {

	private boolean initialized;
	private FileBasedGuidanceProvider fileBasedGuidanceProvider;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		fileBasedGuidanceProvider = new FileBasedGuidanceProvider(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE));
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "FileBasedGuidanceProviderPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public GuidanceProvider getGuidanceProvider() {
		return fileBasedGuidanceProvider;
	}

	@Override
	public String getDefaultGuidanceProviderName() {
		return "FileBasedGuidanceProviderPlugin";
	}
}