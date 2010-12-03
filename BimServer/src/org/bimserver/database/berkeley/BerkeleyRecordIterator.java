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
			OperationStatus next = cursor.getNext(key, value, LockMode.READ_UNCOMMITTED);
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
}
