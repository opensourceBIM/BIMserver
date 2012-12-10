package org.bimserver.database.berkeley;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

public class BerkeleyRecordIterator implements RecordIterator {
	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyRecordIterator.class);
	private final Cursor cursor;

	public BerkeleyRecordIterator(Cursor cursor) {
		this.cursor = cursor;
	}

	public Record next() {
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus next = cursor.getNext(key, value, LockMode.DEFAULT);
			if (next == OperationStatus.SUCCESS) {
				return new BerkeleyRecord(key, value);
			} else {
				return null;
			}
		} catch (DatabaseException e) {
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
	public Record last() throws BimserverLockConflictException {
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus next = cursor.getLast(key, value, LockMode.DEFAULT);
			if (next == OperationStatus.SUCCESS) {
				return new BerkeleyRecord(key, value);
			} else {
				return null;
			}
		} catch (DatabaseException e) {
		}
		return null;
	}
}