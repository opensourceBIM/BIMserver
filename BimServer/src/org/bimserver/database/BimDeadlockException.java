package org.bimserver.database;

import com.sleepycat.je.LockConflictException;

public class BimDeadlockException extends Exception {

	private static final long serialVersionUID = 9043339658520339789L;

	public BimDeadlockException(LockConflictException e) {
		super(e);
	}
}