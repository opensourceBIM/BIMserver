package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.List;
import java.util.Set;

import org.bimserver.database.berkeley.BimserverConcurrentModificationDatabaseException;

public interface KeyValueStore {

	boolean containsTable(String tableName);

	boolean createTable(String tableName, DatabaseSession databaseSession) throws BimserverDatabaseException;

	boolean openTable(String tableName) throws BimserverDatabaseException;

	void store(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException;

	RecordIterator getRecordIterator(String tableName, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException;

	SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession) throws BimserverLockConflictException,
			BimserverDatabaseException;

	long count(String tableName);

	byte[] get(String tableName, byte[] key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException;

	byte[] getFirstStartingWith(String tableName, byte[] key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException;

	void sync();

	void close();

	boolean isNew();

	void delete(String tableName, byte[] key, DatabaseSession databaseSession) throws BimserverLockConflictException;

	String getLocation();

	String getStats();

	BimTransaction startTransaction();

	void commit(DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException;

	String getType();

	long getDatabaseSizeInBytes();

	Set<String> getAllTableNames();

	void storeNoOverwrite(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException, BimserverConcurrentModificationDatabaseException;

	void incrementCommittedWrites(long committedWrites);

	void incrementReads(long reads);

	void storeNoOverwrite(String tableName, byte[] key, byte[] value, int offset, int length, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException;
	
	void store(String tableName, byte[] key, byte[] value, int offset, int length, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException;

	void dumpOpenCursors();

	boolean createIndexTable(String tableName, DatabaseSession databaseSession) throws BimserverDatabaseException;

	void openIndexTable(String indexTableName) throws BimserverDatabaseException;

	List<byte[]> getDuplicates(String tableName, byte[] keyBytes, DatabaseSession databaseSession) throws BimserverDatabaseException;

	void delete(String indexTableName, byte[] featureBytesOldIndex, byte[] array, DatabaseSession databaseSession) throws BimserverLockConflictException;
}