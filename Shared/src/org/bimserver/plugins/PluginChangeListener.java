package org.bimserver.plugins;

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

import org.bimserver.BimserverDatabaseException;
import org.bimserver.interfaces.objects.SPluginInformation;

public interface PluginChangeListener {
	void pluginInstalled(long pluginBundleVersionId, PluginContext pluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException;
	void pluginStateChanged(PluginContext pluginContext, boolean enabled);
	void pluginUninstalled(PluginContext pluginContext);
	long pluginBundleInstalled(PluginBundle pluginBundle);
	long pluginBundleUpdated(PluginBundle pluginBundle);
	void pluginBundleUninstalled(PluginBundle pluginBundle);
	void pluginUpdated(long pluginBundleVersionId, PluginContext newPluginContext, SPluginInformation sPluginInformation) throws BimserverDatabaseException;
}