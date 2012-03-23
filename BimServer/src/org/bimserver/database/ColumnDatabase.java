package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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

import java.util.Set;

public interface ColumnDatabase {

	boolean containsTable(String tableName);

	boolean createTable(String tableName, BimDatabaseSession databaseSession);

	boolean openTable(String tableName) throws BimDatabaseException;

	void store(String tableName, byte[] key, byte[] value, BimDatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	RecordIterator getRecordIterator(String tableName, BimDatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, BimDatabaseSession databaseSession) throws BimDeadlockException,
			BimDatabaseException;

	long count(String tableName);

	byte[] get(String tableName, byte[] key, BimDatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	byte[] getFirstStartingWith(String tableName, byte[] key, BimDatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	void sync();

	void close();

	boolean isNew();

	void delete(String tableName, byte[] key, BimDatabaseSession databaseSession) throws BimDeadlockException;

	String getLocation();

	String getStats();

	BimTransaction startTransaction();

	void commit(BimDatabaseSession databaseSession) throws BimDatabaseException, BimDeadlockException;

	String getType();

	long getDatabaseSizeInBytes();

	Set<String> getAllTableNames();
}