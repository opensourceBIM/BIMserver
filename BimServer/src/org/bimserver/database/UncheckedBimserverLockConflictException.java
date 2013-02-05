package org.bimserver.database;

/**
 * This exception is an unchecked exception and only used for lazy loading of objects 
 * (which cannot throw checked exceptions, because EMF generates the classes initiating 
 * the lazy loading)
 *
 */
public class UncheckedBimserverLockConflictException extends RuntimeException {

	public UncheckedBimserverLockConflictException(BimserverLockConflictException e) {
		super(e);
	}
}