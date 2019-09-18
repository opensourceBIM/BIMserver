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

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.BimTransaction;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.KeyValueStore;
import org.bimserver.database.Record;
import org.bimserver.database.RecordIterator;
import org.bimserver.database.SearchingRecordIterator;
import org.bimserver.utils.PathUtils;
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
	private long committedWrites;
	private long reads;
	private final Map<String, TableWrapper> tables = new HashMap<>();
	private boolean isNew;
	private TransactionConfig transactionConfig;
	private CursorConfig safeCursorConfig;
	private long lastPrintedReads = 0;
	private long lastPrintedCommittedWrites = 0;
	private static final boolean MONITOR_CURSOR_STACK_TRACES = false;
	private final AtomicLong cursorCounter = new AtomicLong();
	private final Map<Long, StackTraceElement[]> openCursors = new ConcurrentHashMap<>();
	private final boolean useTransactions = true;
	private final boolean keyPrefixing = true;
	private CursorConfig unsafeCursorConfig;

	public BerkeleyKeyValueStore(Path dataDir, Properties properties) throws DatabaseInitException {
		if (Files.isDirectory(dataDir)) {
			try {
				if (PathUtils.list(dataDir).size() > 0) {
					LOGGER.info("Non-empty database directory found \"" + dataDir.toString() + "\"");
					isNew = false;
				} else {
					LOGGER.info("Empty database directory found \"" + dataDir.toString() + "\"");
					isNew = true;
				}
			} catch (IOException e) {
				LOGGER.error("", e);
			}
		} else {
			isNew = true;
			LOGGER.info("No database directory found, creating \"" + dataDir.toString() + "\"");
			try {
				Files.createDirectory(dataDir);
				LOGGER.info("Successfully created database dir \"" + dataDir.toString() + "\"");
			} catch (Exception e) {
				LOGGER.error("Error creating database dir \"" + dataDir.toString() + "\"");
			}
		}
		EnvironmentConfig envConfig = null;
		if (properties == null) {
			envConfig = new EnvironmentConfig();
			envConfig.setCachePercent(30);
		} else {
			envConfig = new EnvironmentConfig(properties);
		}
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(useTransactions);
		envConfig.setTxnTimeout(10, TimeUnit.SECONDS);
		envConfig.setLockTimeout(2000, TimeUnit.MILLISECONDS);
		envConfig.setConfigParam(EnvironmentConfig.CHECKPOINTER_HIGH_PRIORITY, "true");
		envConfig.setConfigParam(EnvironmentConfig.CLEANER_THREADS, "5");
		try {
			environment = new Environment(dataDir.toFile(), envConfig);
		} catch (EnvironmentLockedException e) {
			String message = "Environment locked exception. Another process is using the same database, or the current user has no write access (database location: \""
					+ dataDir.toString() + "\")";
			throw new DatabaseInitException(message);
		} catch (DatabaseException e) {
			String message = "A database initialisation error has occured (" + e.getMessage() + ")";
			throw new DatabaseInitException(message);
		}
		
		transactionConfig = new TransactionConfig();
		transactionConfig.setReadCommitted(true);

		safeCursorConfig = new CursorConfig();
		safeCursorConfig.setReadCommitted(true);

		unsafeCursorConfig = new CursorConfig();
		unsafeCursorConfig.setReadUncommitted(true);
	}

	public boolean isNew() {
		return isNew;
	}

	public BimTransaction startTransaction() {
		if (useTransactions) {
			try {
				return new BerkeleyTransaction(environment.beginTransaction(null, transactionConfig));
			} catch (DatabaseException e) {
				LOGGER.error("", e);
			}
		}
		return null;
	}

	public boolean createTable(String tableName, DatabaseSession databaseSession, boolean transactional) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already created");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setKeyPrefixing(keyPrefixing);
		databaseConfig.setAllowCreate(true);
		boolean finalTransactional = transactional && useTransactions;
		databaseConfig.setDeferredWrite(!finalTransactional);
//		if (!transactional) {
//			databaseConfig.setCacheMode(CacheMode.EVICT_BIN);
//		}
		databaseConfig.setTransactional(finalTransactional);
		databaseConfig.setSortedDuplicates(false);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			return false;
		}
		tables.put(tableName, new TableWrapper(database, finalTransactional));
		
		return true;
	}

	public boolean createIndexTable(String tableName, DatabaseSession databaseSession, boolean transactional) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already created");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setKeyPrefixing(keyPrefixing);
		databaseConfig.setAllowCreate(true);
		boolean finalTransactional = transactional && useTransactions;
//		if (!transactional) {
//			databaseConfig.setCacheMode(CacheMode.EVICT_BIN);
//		}
		databaseConfig.setDeferredWrite(!finalTransactional);
		databaseConfig.setTransactional(finalTransactional);
		databaseConfig.setSortedDuplicates(true);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			return false;
		}
		tables.put(tableName, new TableWrapper(database, finalTransactional));
		
		return true;
	}
	
	public boolean openTable(DatabaseSession databaseSession, String tableName, boolean transactional) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already opened");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setKeyPrefixing(keyPrefixing);
		databaseConfig.setAllowCreate(false);
		boolean finalTransactional = transactional && useTransactions;
//		if (!transactional) {
//			databaseConfig.setCacheMode(CacheMode.EVICT_BIN);
//		}
		databaseConfig.setDeferredWrite(!finalTransactional);
		databaseConfig.setTransactional(finalTransactional);
		databaseConfig.setSortedDuplicates(false);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			throw new BimserverDatabaseException("Table " + tableName + " not found in database");
		}
		tables.put(tableName, new TableWrapper(database, finalTransactional));
		return true;
	}

	public void openIndexTable(DatabaseSession databaseSession, String tableName, boolean transactional) throws BimserverDatabaseException {
		if (tables.containsKey(tableName)) {
			throw new BimserverDatabaseException("Table " + tableName + " already opened");
		}
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setKeyPrefixing(keyPrefixing);
		databaseConfig.setAllowCreate(false);
		boolean finalTransactional = transactional && useTransactions;
//		if (!transactional) {
//			databaseConfig.setCacheMode(CacheMode.EVICT_BIN);
//		}
		databaseConfig.setDeferredWrite(!finalTransactional);
		databaseConfig.setTransactional(finalTransactional);
		databaseConfig.setSortedDuplicates(true);
		Database database = environment.openDatabase(null, tableName, databaseConfig);
		if (database == null) {
			throw new BimserverDatabaseException("Table " + tableName + " not found in database");
		}
		tables.put(tableName, new TableWrapper(database, finalTransactional));
	}
	
	private Database getDatabase(String tableName) throws BimserverDatabaseException {
		return getTableWrapper(tableName).getDatabase();
	}

	private TableWrapper getTableWrapper(String tableName) throws BimserverDatabaseException {
		TableWrapper tableWrapper = tables.get(tableName);
		if (tableWrapper == null) {
			throw new BimserverDatabaseException("Table " + tableName + " not found");
		}
		return tableWrapper;
	}

	private Transaction getTransaction(DatabaseSession databaseSession) {
		if (databaseSession != null) {
			BerkeleyTransaction berkeleyTransaction = (BerkeleyTransaction) databaseSession.getBimTransaction();
			if (berkeleyTransaction != null) {
				return berkeleyTransaction.getTransaction();
			}
		}
		return null;
	}

	public void close() {
		for (TableWrapper tableWrapper : tables.values()) {
			try {
				tableWrapper.getDatabase().close();
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

	public LockMode getLockMode(TableWrapper tableWrapper) {
		if (tableWrapper.isTransactional()) {
			return LockMode.READ_COMMITTED;
		} else {
			return LockMode.READ_UNCOMMITTED;
		}
	}
	
	public boolean isTransactional(DatabaseSession databaseSession, String tableName) throws BimserverDatabaseException {
		return getTableWrapper(tableName).isTransactional() ? getTransaction(databaseSession) != null : false;
	}
	
	public Transaction getTransaction(DatabaseSession databaseSession, TableWrapper tableWrapper) {
		return tableWrapper.isTransactional() ? getTransaction(databaseSession) : null;
	}
	
	public CursorConfig getCursorConfig(TableWrapper tableWrapper) {
		if (tableWrapper.isTransactional()) {
			return safeCursorConfig;
		} else {
			return unsafeCursorConfig;
		}
	}
	
	@Override
	public byte[] get(String tableName, byte[] keyBytes, DatabaseSession databaseSession) throws BimserverDatabaseException {
		DatabaseEntry key = new DatabaseEntry(keyBytes);
		DatabaseEntry value = new DatabaseEntry();
		try {
			TableWrapper tableWrapper = getTableWrapper(tableName);
			OperationStatus operationStatus = tableWrapper.getDatabase().get(getTransaction(databaseSession, tableWrapper), key, value, getLockMode(tableWrapper));
			if (operationStatus == OperationStatus.SUCCESS) {
				return value.getData();
			}
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public List<byte[]> getDuplicates(String tableName, byte[] keyBytes, DatabaseSession databaseSession) throws BimserverDatabaseException {
		DatabaseEntry key = new DatabaseEntry(keyBytes);
		DatabaseEntry value = new DatabaseEntry();
		try {
			TableWrapper tableWrapper = getTableWrapper(tableName);
			Cursor cursor = tableWrapper.getDatabase().openCursor(getTransaction(databaseSession, tableWrapper), getCursorConfig(tableWrapper));
			try {
				OperationStatus operationStatus = cursor.getSearchKey(key, value, LockMode.DEFAULT);
				List<byte[]> result = new ArrayList<byte[]>();
				while (operationStatus == OperationStatus.SUCCESS) {
					result.add(value.getData());
					operationStatus = cursor.getNextDup(key, value, LockMode.DEFAULT);
				}
				return result;
			} finally {
				cursor.close();
			}
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	public long getTotalWrites() {
		return committedWrites;
	}

	public void sync() {
		try {
			environment.sync();
//			environment.flushLog(true);
//			environment.evictMemory();
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
			TableWrapper tableWrapper = getTableWrapper(tableName);
			cursor = tableWrapper.getDatabase().openCursor(getTransaction(databaseSession, tableWrapper), getCursorConfig(tableWrapper));
			BerkeleyRecordIterator berkeleyRecordIterator = new BerkeleyRecordIterator(cursor, this, cursorCounter.incrementAndGet());
			if (MONITOR_CURSOR_STACK_TRACES) {
				openCursors.put(berkeleyRecordIterator.getCursorId(), new Exception().getStackTrace());
			}
			return berkeleyRecordIterator;
		} catch (DatabaseException e) {
			LOGGER.error("", e);
		}
		return null;
	}

	@Override
	public SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession, boolean keysOnly) throws BimserverLockConflictException, BimserverDatabaseException {
		Cursor cursor = null;
		try {
			TableWrapper tableWrapper = getTableWrapper(tableName);
			cursor = tableWrapper.getDatabase().openCursor(getTransaction(databaseSession, tableWrapper), getCursorConfig(tableWrapper));
			BerkeleySearchingRecordIterator berkeleySearchingRecordIterator = new BerkeleySearchingRecordIterator(cursor, this, cursorCounter.incrementAndGet(), mustStartWith, startSearchingAt, keysOnly);
			if (MONITOR_CURSOR_STACK_TRACES) {
				openCursors.put(berkeleySearchingRecordIterator.getCursorId(), new Exception().getStackTrace());
			}
			return berkeleySearchingRecordIterator;
		} catch (BimserverLockConflictException e) {
			if (cursor != null) {
				try {
					cursor.close();
					throw e;
				} catch (DatabaseException e1) {
					LOGGER.error("", e1);
				}
			}
		} catch (DatabaseException e1) {
			LOGGER.error("", e1);
		}
		return null;
	}

	@Override
	public SearchingRecordIterator getRecordIterator(String tableName, byte[] mustStartWith, byte[] startSearchingAt, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		return getRecordIterator(tableName, mustStartWith, startSearchingAt, databaseSession, false);
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
			TableWrapper tableWrapper = getTableWrapper(tableName);
			tableWrapper.getDatabase().delete(getTransaction(databaseSession, tableWrapper), entry);
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
	public void delete(String indexTableName, byte[] featureBytesOldIndex, byte[] array, DatabaseSession databaseSession) throws BimserverLockConflictException {
		try {
			TableWrapper tableWrapper = getTableWrapper(indexTableName);
			Cursor cursor = tableWrapper.getDatabase().openCursor(getTransaction(databaseSession, tableWrapper), getCursorConfig(tableWrapper));
			try {
				if (cursor.getSearchBoth(new DatabaseEntry(featureBytesOldIndex), new DatabaseEntry(array), LockMode.DEFAULT) == OperationStatus.SUCCESS) {
					cursor.delete();
				}
			} finally {
				cursor.close();
			}
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
		store(tableName, key, value, 0, value.length, databaseSession);
	}
	
	@Override
	public void store(String tableName, byte[] key, byte[] value, int offset, int length, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException {
		DatabaseEntry dbKey = new DatabaseEntry(key);
		DatabaseEntry dbValue = new DatabaseEntry(value, offset, length);
		try {
			TableWrapper tableWrapper = getTableWrapper(tableName);
			tableWrapper.getDatabase().put(getTransaction(databaseSession, tableWrapper), dbKey, dbValue);
		} catch (LockConflictException e) {
			throw new BimserverLockConflictException(e);
		} catch (DatabaseException e) {
			throw new BimserverDatabaseException("", e);
		}
	}

	@Override
	public void storeNoOverwrite(String tableName, byte[] key, byte[] value, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException, BimserverConcurrentModificationDatabaseException {
		storeNoOverwrite(tableName, key, value, 0, value.length, databaseSession);
	}
	
	@Override
	public void storeNoOverwrite(String tableName, byte[] key, byte[] value, int index, int length, DatabaseSession databaseSession) throws BimserverDatabaseException, BimserverLockConflictException, BimserverConcurrentModificationDatabaseException {
		DatabaseEntry dbKey = new DatabaseEntry(key);
		DatabaseEntry dbValue = new DatabaseEntry(value, index, length);
		try {
			TableWrapper tableWrapper = getTableWrapper(tableName);
			OperationStatus putNoOverwrite = tableWrapper.getDatabase().putNoOverwrite(getTransaction(databaseSession, tableWrapper), dbKey, dbValue);
			if (putNoOverwrite == OperationStatus.KEYEXIST) {
				// TODO temporary test
				tableWrapper.getDatabase().put(getTransaction(databaseSession, tableWrapper), dbKey, dbValue);
				ByteBuffer keyBuffer = ByteBuffer.wrap(key);
				if (key.length == 16) {
					int pid = keyBuffer.getInt();
					long oid = keyBuffer.getLong();
					int rid = -keyBuffer.getInt();
//					LOGGER.warn("Key exists: pid: " + pid + ", oid: " + oid + ", rid: " + rid + ", " + databaseSession.getEClassForOid(oid).getName());
					throw new BimserverConcurrentModificationDatabaseException("Key exists: pid: " + pid + ", oid: " + oid + ", rid: " + rid);
				} else {
					LOGGER.warn("Key exists");
//					throw new BimserverConcurrentModificationDatabaseException("Key exists: " );
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
		return new HashSet<String>(environment.getDatabaseNames());
	}
	
	public synchronized void incrementReads(long reads) {
		this.reads += reads;
		if (this.reads / 1000000 != lastPrintedReads) {
			LOGGER.info("reads: " + this.reads);
			lastPrintedReads = this.reads / 1000000;
		}
	}
	
	@Override
	public synchronized void incrementCommittedWrites(long committedWrites) {
		this.committedWrites += committedWrites;
		int printThreshold = 1000000;
		if (this.committedWrites / printThreshold != lastPrintedCommittedWrites) {
			lastPrintedCommittedWrites = this.committedWrites / printThreshold;
			long start = System.nanoTime();
			
			// This is a test, when writing large amount of data (IFC data), this should keep memory usage limited because it'll write the data to disk
			sync();
			long end = System.nanoTime();
			LOGGER.info("writes: " + this.committedWrites + ", " + (((end - start) / printThreshold) + " ms sync"));
		}
	}

	public void removeOpenCursor(long cursorId) {
		if (MONITOR_CURSOR_STACK_TRACES) {
			openCursors.remove(cursorId);
		}
	}

	@Override
	public void dumpOpenCursors() {
		for (StackTraceElement[] ste : openCursors.values()) {
			System.out.println("Open cursor");
			for (StackTraceElement stackTraceElement : ste) {
				LOGGER.info("\t" + stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber() + "."
						+ stackTraceElement.getMethodName());
			}
		}
	}
}