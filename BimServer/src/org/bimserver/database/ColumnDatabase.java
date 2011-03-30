package org.bimserver.database;

import java.util.Set;


/******************************************************************************
 * (c) Copyright bimserver.org 2009 Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt For more information mail to
 * license@bimserver.org
 * 
 * Bimserver.org is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * Bimserver.org is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License a long with
 * Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public interface ColumnDatabase {

	boolean containsTable(String tableName);
	
	boolean createTable(String tableName, boolean useTransactions);

	boolean openTable(String tableName, boolean useTransactions) throws BimDatabaseException;

	void store(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	RecordIterator getRecordIterator(String tableName, DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession)
			throws BimDeadlockException, BimDatabaseException;

	long count(String tableName);

	byte[] get(String tableName, byte[] key, DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	byte[] getFirstStartingWith(String tableName, byte[] key, DatabaseSession databaseSession) throws BimDeadlockException, BimDatabaseException;

	void sync();

	void close();

	boolean isNew();

	void delete(String tableName, byte[] key, DatabaseSession databaseSession) throws BimDeadlockException;

	String getLocation();

	String getStats();

	BimTransaction startTransaction();

	void commit(DatabaseSession databaseSession) throws BimDatabaseException, BimDeadlockException;

	String getType();

	long getDatabaseSizeInBytes();

	Set<String> getAllTableNames();
}