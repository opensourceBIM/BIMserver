package org.bimserver.database.berkeley;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.BimTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.Transaction;

public class BerkeleyTransaction implements BimTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyTransaction.class);
	private final Transaction transaction;
	private boolean transactionAlive = true;

	public BerkeleyTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	@Override
	public void setName(String name) {
		transaction.setName(name);
	}

	@Override
	public void close() {
		if (transactionAlive) {
			rollback();
		}
	}

	@Override
	public void rollback() {
		try {
			transaction.abort();
			transactionAlive = false;
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public void commit() throws BimDeadlockException, BimDatabaseException {
		try {
			transaction.commit();
			transactionAlive = false;
		} catch (LockConflictException e) {
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			throw new BimDatabaseException(e);
		}
	}
}