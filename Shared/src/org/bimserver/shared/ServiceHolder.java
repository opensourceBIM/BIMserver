package org.bimserver.shared;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
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