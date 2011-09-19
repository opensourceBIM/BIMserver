package org.bimserver.shared;

import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.shared.exceptions.ServiceException;

public interface NotificationInterface {
	void newLogAction(SLogAction logAction) throws ServiceException;
}
