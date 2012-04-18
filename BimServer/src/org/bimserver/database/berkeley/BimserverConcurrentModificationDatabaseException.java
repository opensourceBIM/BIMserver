package org.bimserver.database.berkeley;

import org.bimserver.database.BimserverDatabaseException;

public class BimserverConcurrentModificationDatabaseException extends BimserverDatabaseException {

	private static final long serialVersionUID = -2109619498156905565L;

	public BimserverConcurrentModificationDatabaseException(String message) {
		super(message);
	}
}