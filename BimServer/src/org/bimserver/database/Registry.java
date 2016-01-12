package org.bimserver.database;

/******************************************************************************
 * Copyright (C) 2009-2016  BIMserver.org
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

import java.util.Date;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.utils.BinUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class Registry {
	private static final Logger LOGGER = LoggerFactory.getLogger(Registry.class);
	public static final String REGISTRY_TABLE = "INT-Registry";
	private final KeyValueStore keyValueStore;

	public Registry(KeyValueStore keyValueStore) {
		this.keyValueStore = keyValueStore;
	}

	public void save(String key, long value, DatabaseSession databaseSession) throws BimserverLockConflictException {
		try {
			keyValueStore.store(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), BinUtils.longToByteArray(value), databaseSession);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public void save(String key, byte[] value, DatabaseSession databaseSession) throws BimserverLockConflictException {
		try {
			keyValueStore.store(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), value, databaseSession);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public void save(String key, boolean value, DatabaseSession databaseSession) throws BimserverLockConflictException {
		try {
			keyValueStore.store(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), BinUtils.booleanToByteArray(value), databaseSession);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public void save(String key, int value, DatabaseSession databaseSession) throws BimserverLockConflictException {
		try {
			keyValueStore.store(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), BinUtils.intToByteArray(value), databaseSession);
		} catch (BimserverDatabaseException e) {
			LOGGER.error("", e);
		}
	}

	public long readLong(String key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		byte[] bytes = keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession);
		if (bytes == null) {
			return 1;
		} else {
			return BinUtils.byteArrayToLong(bytes);
		}
	}

	public int readInt(String key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		byte[] bytes = keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession);
		if (bytes == null) {
			return 1;
		} else {
			return BinUtils.byteArrayToInt(bytes);
		}
	}

	public int readInt(String key, DatabaseSession databaseSession, int defaultValue) throws BimserverLockConflictException, BimserverDatabaseException {
		byte[] bytes = keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession);
		if (bytes == null) {
			return defaultValue;
		} else {
			return BinUtils.byteArrayToInt(bytes);
		}
	}

	public Date readDate(String key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		long readLong = readLong(key, databaseSession);
		if (readLong == -1) {
			return null;
		}
		return new Date(readLong);
	}

	public void save(String key, Date date, DatabaseSession databaseSession) throws BimserverLockConflictException {
		save(key, date.getTime(), databaseSession);
	}

	public boolean readBoolean(String key, boolean defaultValue, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		byte[] bytes = keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession);
		if (bytes == null) {
			return defaultValue;
		} else {
			return BinUtils.byteArrayToBoolean(bytes);
		}
	}

	public boolean has(String key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		return keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession) != null;
	}

	public byte[] readByteArray(String key, DatabaseSession databaseSession) throws BimserverLockConflictException, BimserverDatabaseException {
		return keyValueStore.get(REGISTRY_TABLE, key.getBytes(Charsets.UTF_8), databaseSession);
	}
}