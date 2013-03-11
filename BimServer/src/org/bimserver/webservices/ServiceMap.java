package org.bimserver.webservices;

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

	public ServiceMap(BimServer bimServer, Authorization authorization, AccessMethod accessMethod, String remoteAddress) {
		this.bimServer = bimServer;
		this.authorization = authorization;
		this.accessMethod = accessMethod;
		this.remoteAddress = remoteAddress;
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
		if (clazz == ServiceInterface.class) {
			return (T) new Service(this);
		} else if (clazz == AuthInterface.class) {
			return (T) new AuthServiceImpl(this);
		} else if (clazz == AdminInterface.class) {
			return (T) new AdminServiceImpl(this);
		} else if (clazz == LowLevelInterface.class) {
			return (T) new LowLevelServiceImpl(this);
		} else if (clazz == MetaInterface.class) {
			return (T) new MetaServiceImpl(this);
		} else if (clazz == SettingsInterface.class) {
			return (T) new SettingsServiceImpl(this);
		} else if (clazz == NotificationInterface.class) {
			return (T) new NotificationImpl(bimServer);
		} else {
			throw new RuntimeException("Unknown interface: " + clazz.getName());
		}
	}
}