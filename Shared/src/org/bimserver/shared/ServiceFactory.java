package org.bimserver.shared;

import org.bimserver.models.log.AccessMethod;

public interface ServiceFactory {
	Object newService(AccessMethod accessMethod);
}
