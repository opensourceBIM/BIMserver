package org.bimserver.shared;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.RegistryInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;

public interface ServiceHolder {
	public <T extends PublicInterface> T get(Class<T> clazz) throws PublicInterfaceNotFoundException;
	public RegistryInterface getRegistry() throws PublicInterfaceNotFoundException;
	public AuthInterface getAuth() throws PublicInterfaceNotFoundException;
	public SettingsInterface getSettings() throws PublicInterfaceNotFoundException;
	public LowLevelInterface getLowLevel() throws PublicInterfaceNotFoundException;
	public AdminInterface getAdmin() throws PublicInterfaceNotFoundException;
	public MetaInterface getMeta() throws PublicInterfaceNotFoundException;
	public PluginInterface getPlugin() throws PublicInterfaceNotFoundException;
	public ServiceInterface getService() throws PublicInterfaceNotFoundException;
}