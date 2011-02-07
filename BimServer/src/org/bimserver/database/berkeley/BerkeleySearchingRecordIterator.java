package org.bimserver.database.berkeley;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Arrays;

import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Record;
import org.bimserver.database.SearchingRecordIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class BerkeleySearchingRecordIterator implements SearchingRecordIterator {

	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleySearchingRecordIterator.class);
	private final Cursor cursor;
	private final byte[] mustStartWith;
	private byte[] nextStartSearchingAt;

	public BerkeleySearchingRecordIterator(Cursor cursor, byte[] mustStartWith, byte[] startSearchingAt) throws BimDeadlockException {
		this.cursor = cursor;
		this.mustStartWith = mustStartWith;
		this.nextStartSearchingAt = startSearchingAt;
	}

	private Record getFirstNext(byte[] startSearchingAt) throws BimDeadlockException {
		this.nextStartSearchingAt = null;
		DatabaseEntry key = new DatabaseEntry(startSearchingAt);
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus next = cursor.getSearchKeyRange(key, value, LockMode.READ_UNCOMMITTED);
			if (next == OperationStatus.SUCCESS) {
				byte[] firstBytes = new byte[mustStartWith.length];
				System.arraycopy(key.getData(), 0, firstBytes, 0, mustStartWith.length);
				if (Arrays.equals(firstBytes, mustStartWith)) {
					return new BerkeleyRecord(key, value);
				}
			}
		} catch (LockConflictException e) {
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public Record next() throws BimDeadlockException {
		if (nextStartSearchingAt != null) {
			return getFirstNext(nextStartSearchingAt);
		}
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus next = cursor.getNext(key, value, LockMode.READ_UNCOMMITTED);
			if (next == OperationStatus.SUCCESS) {
				byte[] firstBytes = new byte[mustStartWith.length];
				System.arraycopy(key.getData(), 0, firstBytes, 0, mustStartWith.length);
				if (Arrays.equals(firstBytes, mustStartWith)) {
					return new BerkeleyRecord(key, value);
				}
			}
		} catch (LockConflictException e) {
			throw new BimDeadlockException(e);
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public void close() {
		try {
			cursor.close();
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public Record next(byte[] startSearchingAt) throws BimDeadlockException {
		return getFirstNext(startSearchingAt);
	}
}