package org.bimserver.webservices;

import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.ServiceMapInterface;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.interfaces.LowLevelInterface;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.interfaces.NotificationInterface;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.webservices.authorization.Authorization;

public class ServiceMap implements ServiceMapInterface {
	private BimServer bimServer;
	private AccessMethod accessMethod;
	private String remoteAddress;
	private Authorization authorization;
	private final Map<Class<PublicInterface>, PublicInterface> interfaces = new HashMap<Class<PublicInterface>, PublicInterface>();

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
			publicInterface = new Service(this);
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
		} else if (clazz == NotificationInterface.class) {
			publicInterface = new NotificationImpl(bimServer);
		} else {
			throw new RuntimeException("Unknown interface: " + clazz.getName());
		}
		interfaces.put((Class<PublicInterface>) clazz, publicInterface);
		return (T) publicInterface;
	}
}