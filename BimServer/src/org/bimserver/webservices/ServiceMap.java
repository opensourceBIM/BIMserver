package org.bimserver.webservices;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.ServiceHolder;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.RegistryInterface;
import org.bimserver.shared.interfaces.RemoteServiceInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.webservices.authorization.Authorization;

public class ServiceMap implements ServiceMapInterface, ServiceHolder {
	private BimServer bimServer;
	private AccessMethod accessMethod;
	private String remoteAddress;
	private Authorization authorization;
	private final Map<Class<? extends PublicInterface>, PublicInterface> interfaces = new HashMap<Class<? extends PublicInterface>, PublicInterface>();

	public ServiceMap(BimServer bimServer, Authorization authorization, AccessMethod accessMethod, String remoteAddress) {
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.accessMethod = accessMethod;
		this.remoteAddress = remoteAddress;
	}

	public void put(Class<PublicInterface> clazz, PublicInterface publicInterface) {
		interfaces.put(clazz, publicInterface);
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
	
	public AccessMethod getAccessMethod() {
		return accessMethod;
	}
	
	public String getRemoteAddress() {
		return remoteAddress;
	}
	
	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	@SuppressWarnings("unchecked")
	public <T extends PublicInterface> T get(Class<T> clazz) {
		PublicInterface publicInterface = interfaces.get(clazz);
		if (publicInterface != null) {
			return (T) publicInterface;
		}
		if (clazz == ServiceInterface.class) {
			publicInterface = new ServiceImpl(this);
		} else if (clazz == AuthInterface.class) {
			publicInterface = new AuthServiceImpl(this);
		} else if (clazz == AdminInterface.class) {
			publicInterface = new AdminServiceImpl(this);
		} else if (clazz == LowLevelInterface.class) {
			publicInterface = new LowLevelServiceImpl(this);
		} else if (clazz == MetaInterface.class) {
			publicInterface = new MetaServiceImpl(this);
		} else if (clazz == SettingsInterface.class) {
			publicInterface = new SettingsServiceImpl(this);
		} else if (clazz == RemoteServiceInterface.class) {
			publicInterface = new RemoteServiceImpl(this);
		} else if (clazz == NotificationInterface.class) {
			publicInterface = new NotificationImpl(bimServer);
		} else if (clazz == RegistryInterface.class) {
			publicInterface = new RegistryServiceImpl(this);
		} else if (clazz == PluginInterface.class) {
			publicInterface = new PluginServiceImpl(this);
		} else {
			throw new RuntimeException("Unknown interface: " + clazz.getName());
		}
		interfaces.put((Class<PublicInterface>) clazz, publicInterface);
		return (T) publicInterface;
	}

	@Override
	public <T extends PublicInterface> void add(Class<T> class1, T remoteServiceInterface) {
		interfaces.put(class1, remoteServiceInterface);
	}
	
	@Override
	public AdminInterface getAdmin() throws PublicInterfaceNotFoundException {
		return get(AdminInterface.class);
	}
	
	@Override
	public AuthInterface getAuth() throws PublicInterfaceNotFoundException {
		return get(AuthInterface.class);
	}
	
	@Override
	public LowLevelInterface getLowLevel() throws PublicInterfaceNotFoundException {
		return get(LowLevelInterface.class);
	}
	
	@Override
	public MetaInterface getMeta() throws PublicInterfaceNotFoundException {
		return get(MetaInterface.class);
	}
	
	@Override
	public PluginInterface getPlugin() throws PublicInterfaceNotFoundException {
		return get(PluginInterface.class);
	}
	
	@Override
	public RegistryInterface getRegistry() throws PublicInterfaceNotFoundException {
		return get(RegistryInterface.class);
	}
	
	@Override
	public ServiceInterface getService() throws PublicInterfaceNotFoundException {
		return get(ServiceInterface.class);
	}
	
	@Override
	public SettingsInterface getSettings() throws PublicInterfaceNotFoundException {
		return get(SettingsInterface.class);
	}
}