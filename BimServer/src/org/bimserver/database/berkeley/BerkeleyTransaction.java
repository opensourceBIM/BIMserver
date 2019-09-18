package org.bimserver.database.berkeley;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimTransaction;
import org.bimserver.database.BimserverLockConflictException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.Transaction;

public class BerkeleyTransaction implements BimTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyTransaction.class);
	private final Transaction transaction;
	private boolean transactionAlive = true;
	private long updates;

	public BerkeleyTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public void incUpdates(long updates) {
		this.updates += updates;
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
	public void commit() throws BimserverLockConflictException, BimserverDatabaseException {
		try {
			transaction.commit();
			transactionAlive = false;
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			throw new BimserverDatabaseException(e);
		}
	}

	@Override
	public long getId() {
		return transaction.getId();
	}

	@Override
	public long updates() {
		return updates;
	}
}