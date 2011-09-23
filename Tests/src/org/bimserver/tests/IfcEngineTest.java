package org.bimserver.tests;

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

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEnginePlugin;

public class IfcEngineTest {
	public static void main(String[] args) {
		new IfcEngineTest().start();
	}

	private void start() {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager();
			IfcEnginePlugin ifcEnginePlugin = pluginManager.requireIfcEngine();
			IfcEngine ifcEngine = ifcEnginePlugin.createIfcEngine();
			ifcEngine.close();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
