package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;

public interface ServiceHolder {
	<T extends PublicInterface> T get(Class<T> clazz) throws PublicInterfaceNotFoundException;
	Bimsie1NotificationRegistryInterface getRegistry() throws PublicInterfaceNotFoundException;
	Bimsie1AuthInterface getBimsie1AuthInterface() throws PublicInterfaceNotFoundException;
	SettingsInterface getSettingsInterface() throws PublicInterfaceNotFoundException;
	Bimsie1LowLevelInterface getBimsie1LowLevelInterface() throws PublicInterfaceNotFoundException;
	AdminInterface getAdminInterface() throws PublicInterfaceNotFoundException;
	MetaInterface getMeta() throws PublicInterfaceNotFoundException;
	PluginInterface getPluginInterface() throws PublicInterfaceNotFoundException;
	ServiceInterface getServiceInterface() throws PublicInterfaceNotFoundException;
	Bimsie1ServiceInterface getBimsie1ServiceInterface() throws PublicInterfaceNotFoundException;
}