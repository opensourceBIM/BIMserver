package org.bimserver.database;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.bimserver.utils.BinUtils;

public class Registry {
	public static final String REGISTRY_TABLE = "INT-Registry";
	private final ColumnDatabase columnDatabase;

	public Registry(ColumnDatabase columnDatabase) {
		this.columnDatabase = columnDatabase;
	}

	public void save(String key, long value, DatabaseSession databaseSession) throws BimDeadlockException {
		try {
			columnDatabase.store(REGISTRY_TABLE, key.getBytes(Database.DEFAULT_ENCODING), BinUtils.longToByteArray(value), databaseSession);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		}
	}

	public void save(String key, int value, DatabaseSession databaseSession) throws BimDeadlockException {
		try {
			columnDatabase.store(REGISTRY_TABLE, key.getBytes(Database.DEFAULT_ENCODING), BinUtils.intToByteArray(value), databaseSession);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		}
	}

	public long readLong(String key, DatabaseSession databaseSession) throws BimDeadlockException {
		try {
			byte[] bytes = columnDatabase.get(REGISTRY_TABLE, key.getBytes(Database.DEFAULT_ENCODING), databaseSession);
			if (bytes == null) {
				return 1;
			} else {
				return BinUtils.byteArrayToLong(bytes);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int readInt(String key, DatabaseSession databaseSession) throws BimDeadlockException {
		try {
			byte[] bytes = columnDatabase.get(REGISTRY_TABLE, key.getBytes(Database.DEFAULT_ENCODING), databaseSession);
			if (bytes == null) {
				return 1;
			} else {
				return BinUtils.byteArrayToInt(bytes);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public int readInt(String key, DatabaseSession databaseSession, int defaultValue) throws BimDeadlockException {
		try {
			byte[] bytes = columnDatabase.get(REGISTRY_TABLE, key.getBytes(Database.DEFAULT_ENCODING), databaseSession);
			if (bytes == null) {
				return defaultValue;
			} else {
				return BinUtils.byteArrayToInt(bytes);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	public void ensureExists(DatabaseSession databaseSession) {
		columnDatabase.createTableIfNotExists(REGISTRY_TABLE, databaseSession);
	}

	public Date readDate(String key, DatabaseSession databaseSession) throws BimDeadlockException {
		long readLong = readLong(key, databaseSession);
		if (readLong == -1) {
			return null;
		}
		return new Date(readLong);
	}

	public void save(String key, Date date, DatabaseSession databaseSession) throws BimDeadlockException {
		save(key, date.getTime(), databaseSession);
	}
}
