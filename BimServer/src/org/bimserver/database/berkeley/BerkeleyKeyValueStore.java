package org.bimserver.database.berkeley;

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

import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.BimTransaction;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.SearchingRecordIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.JEVersion;
import com.sleepycat.je.LockConflictException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

public class BerkeleyKeyValueStore implements KeyValueStore {

	private static final Logger LOGGER = LoggerFactory.getLogger(BerkeleyKeyValueStore.class);
	private Environment environment;
	private int committedWrites;
	private int reads;
	private final Map<String, Database> tables = new HashMap<String, Database>();
	private boolean isNew;
	private TransactionConfig transactionConfig;
	private CursorConfig cursorConfig;
	private long lastPrintedReads = 0;
	private long lastPrintedCommittedWrites = 0;

	public BerkeleyKeyValueStore(File dataDir) throws DatabaseInitException {
		if (dataDir.isDirectory()) {
			if (dataDir.listFiles().length > 0) {
				LOGGER.info("Non-empty database directory found \"" + dataDir.getAbsolutePath() + "\"");
				isNew = false;
			} else {
				LOGGER.info("Empty database directory found \"" + dataDir.getAbsolutePath() + "\"");
				isNew = true;
			}
		} else {
			isNew = true;
			LOGGER.info("No database directory found, creating \"" + dataDir.getAbsolutePath() + "\"");
			if (dataDir.mkdir()) {
				LOGGER.info("Successfully created database dir \"" + dataDir.getAbsolutePath() + "\"");
			} else {
				LOGGER.error("Error creating database dir \"" + dataDir.getAbsolutePath() + "\"");
			}
		}
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setCachePercent(25);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(true);
		envConfig.setTxnTimeout(5, TimeUnit.SECONDS);
		envConfig.setLockTimeout(100, TimeUnit.MILLISECONDS);
		try {
			environment = new Environment(dataDir, envConfig);
		} catch (EnvironmentLockedException e) {
			String message = "Environment locked exception. Another process is using the same database, or the current user has no write access (database location: \""
					+ dataDir.getAbsolutePath() + "\")";
			throw new DatabaseInitException(message);
		} catch (DatabaseException e) {
			String message = "A database initialisation error has occured (" + e.getMessage() + ")";
			throw new DatabaseInitException(message);
		}
		
		transactionConfig = new TransactionConfig();
		transactionConfig.setReadCommitted(true);

		cursorConfig = new CursorConfig();
	}

	public boolean isNew() {
		return isNew;
	}

	public BimTransaction startTransaction() {
		try {
			return new BerkeleyTransaction(environment.beginTransaction(null, transactionConfig));
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public boolean createTable(String tableName, DatabaseSession databaseSession) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already created");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setAllowCreate(true);
		databaseConfig.setDeferredWrite(false);
		databaseConfig.setTransactional(true);
		databaseConfig.setSortedDuplicates(false);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			return false;
		}
		tables.put(tableName, database);
		return true;
	}

	public boolean openTable(String tableName) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already opened");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setAllowCreate(false);
		databaseConfig.setDeferredWrite(false);
		databaseConfig.setTransactional(true);
		databaseConfig.setSortedDuplicates(false);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			throw new BimserverDatabaseException("Table " + tableName + " not found in database");
		}
		tables.put(tableName, database);
		return true;
	}
	
	private Database getDatabase(String tableName) throws BimserverDatabaseException {
		Database database = tables.get(tableName);
		if (database == null) {
			throw new BimserverDatabaseException("Table " + tableName + " not found");
		}
		return database;
	}

	private Transaction getTransaction(DatabaseSession databaseSession) {
		if (databaseSession != null) {
			return ((BerkeleyTransaction) databaseSession.getBimTransaction()).getTransaction();
		}
		return null;
	}

	public void close() {
		for (Database database : tables.values()) {
			try {
				database.close();
			} catch (DatabaseException e) {
				LOGGER.error("", e);
			}
		}
		if (environment != null) {
			try {
				environment.close();
			} catch (DatabaseException e) {
				LOGGER.error("", e);
			}
		}
	}

	@Override
	public byte[] get(String tableName, byte[] keyBytes, DatabaseSession databaseSession) throws BimserverDatabaseException {
		DatabaseEntry key = new DatabaseEntry(keyBytes);
		DatabaseEntry value = new DatabaseEntry();
		try {
			OperationStatus operationStatus = getDatabase(tableName).get(getTransaction(databaseSession), key, value, LockMode.DEFAULT);
			if (operationStatus == OperationStatus.SUCCESS) {
				return value.getData();
			}
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public int getTotalWrites() {
		return committedWrites;
	}

	public void sync() {
		try {
			environment.flushLog(true);
			environment.evictMemory();
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public boolean containsTable(String tableName) {
		try {
			return environment.getDatabaseNames().contains(tableName);
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return false;
	}

	@Override
	public RecordIterator getRecordIterator(String tableName, DatabaseSession databaseSession) throws BimserverDatabaseException {
		Cursor cursor = null;
		try {
			cursor = getDatabase(tableName).openCursor(getTransaction(databaseSession), cursorConfig);
			return new BerkeleyRecordIterator(cursor);
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		Cursor cursor = null;
		try {
			cursor = getDatabase(tableName).openCursor(getTransaction(databaseSession), cursorConfig);
			return new BerkeleySearchingRecordIterator(cursor, mustStartWith, startSearchingAt);
		} catch (BimserverLockConflictException e) {
			try {
				cursor.close();
				throw e;
			} catch (DatabaseException e1) {
				LOGGER.error("", e1);
			}
		} catch (DatabaseException e1) {
			LOGGER.error("", e1);
		}
		return null;
	}

	@Override
	public long count(String tableName) {
		try {
			return getDatabase(tableName).count();
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
		return -1;
	}

	@Override
	public byte[] getFirstStartingWith(String tableName, byte[] key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		SearchingRecordIterator recordIterator = getRecordIterator(tableName, key, key, databaseSession);
		try {
			Record record = recordIterator.next(key);
			if (record == null) {
				return null;
			}
			return record.getValue();
		} finally {
			recordIterator.close();
		}
	}

	public void delete(String tableName, byte[] key, DatabaseSession databaseSession) throws BimserverLockConflictException {
		DatabaseEntry entry = new DatabaseEntry(key);
		try {
			getDatabase(tableName).delete(getTransaction(databaseSession), entry);
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		} catch (UnsupportedOperationException e) {
			LOGGER.error("", e);
		} catch (IllegalArgumentException e) {
			LOGGER.error("", e);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	@Override
	public String getLocation() {
		try {
			return environment.getHome().getAbsolutePath();
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return "unknown";
	}

	@Override
	public String getStats() {
		try {
			return environment.getStats(null).toString();
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public void commit(DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		Transaction bdbTransaction = getTransaction(databaseSession);
		try {
			bdbTransaction.commit();
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			throw new BimserverDatabaseException("", e);
		}
	}

	@Override
	public void store(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException {
		DatabaseEntry dbKey = new DatabaseEntry(key);
		DatabaseEntry dbValue = new DatabaseEntry(value);
		try {
			Database database = getDatabase(tableName);
			database.put(getTransaction(databaseSession), dbKey, dbValue);
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			throw new BimserverDatabaseException("", e);
		}
	}

	@Override
	public void storeNoOverwrite(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException, BimserverConcurrentModificationDatabaseException {
		DatabaseEntry dbKey = new DatabaseEntry(key);
		DatabaseEntry dbValue = new DatabaseEntry(value);
		try {
			Database database = getDatabase(tableName);
			OperationStatus putNoOverwrite = database.putNoOverwrite(getTransaction(databaseSession), dbKey, dbValue);
			if (putNoOverwrite == OperationStatus.KEYEXIST) {
				ByteBuffer keyBuffer = ByteBuffer.wrap(key);
				if (key.length == 16) {
					int pid = keyBuffer.getInt();
					long oid = keyBuffer.getLong();
					int rid = -keyBuffer.getInt();
					throw new BimserverConcurrentModificationDatabaseException("Key exists: pid: " + pid + ", oid: " + oid + ", rid: " + rid);
				} else {
					throw new BimserverConcurrentModificationDatabaseException("Key exists: " );
				}
			}
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			throw new BimserverDatabaseException("", e);
		}
	}
	
	@Override
	public String getType() {
		return "Berkeley DB Java Edition " + JEVersion.CURRENT_VERSION.toString();
	}

	@Override
	public long getDatabaseSizeInBytes() {
		long size = 0;
		try {
			File home = environment.getHome();
			for (File file : home.listFiles()) {
				size += file.length();
			}
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return size;
	}
	
	public Set<String> getAllTableNames() {
		return tables.keySet();
	}
	
	public synchronized void incrementReads(int reads) {
		this.reads += reads;
		if (this.reads / 100000 != lastPrintedReads) {
			LOGGER.info("reads: " + this.reads);
			lastPrintedReads = this.reads / 100000;
		}
	}
	
	@Override
	public synchronized void incrementCommittedWrites(int committedWrites) {
		this.committedWrites += committedWrites;
		if (this.committedWrites / 100000 != lastPrintedCommittedWrites) {
			LOGGER.info("writes: " + this.committedWrites);
			lastPrintedCommittedWrites = this.committedWrites / 100000;
		}
	}
}