package org.bimserver.client;

import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.exceptions.ServiceException;

public class NotifierImpl implements NotificationInterface{

	@Override
	public void newLogAction(SLogAction logAction) throws ServiceException {
		System.out.println(logAction);
	}
}