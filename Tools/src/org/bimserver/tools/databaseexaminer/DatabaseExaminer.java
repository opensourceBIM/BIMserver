package org.bimserver.tools.databaseexaminer;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.bimserver.database.berkeley.DatabaseInitException;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.EnvironmentLockedException;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.TransactionConfig;

public class DatabaseExaminer {
	private Environment environment;
	private CursorConfig cursorConfig;
	private TransactionConfig transactionConfig;

	public static void main(String[] args) {
		try {
			new DatabaseExaminer().examine(new File("database"));
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		}
	}

	private void examine(File file) throws DatabaseInitException {
		openEnvironment(file);
		for (String tableName : environment.getDatabaseNames()) {
			Database table = environment.openDatabase(null, tableName, null);
			Cursor cursor = table.openCursor(null, cursorConfig);
			try {
				int count = 0;
				while (cursor.getNext(new DatabaseEntry(), new DatabaseEntry(), LockMode.DEFAULT) == OperationStatus.SUCCESS) {
					count++;
				}
				if (count != 0) {
					System.out.println(tableName + ": " + count);
				}
			} finally {
				cursor.close();
			}
		}
	}

	private void openEnvironment(File file) throws DatabaseInitException {
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setCachePercent(30);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(true);
		envConfig.setTxnTimeout(10, TimeUnit.SECONDS);
		envConfig.setLockTimeout(2000, TimeUnit.MILLISECONDS);
		try {
			environment = new Environment(file, envConfig);
			transactionConfig = new TransactionConfig();
			transactionConfig.setReadCommitted(true);
			
			cursorConfig = new CursorConfig();
			cursorConfig.setReadCommitted(true);
		} catch (EnvironmentLockedException e) {
			String message = "Environment locked exception. Another process is using the same database, or the current user has no write access (database location: \""
					+ file.getAbsolutePath() + "\")";
			throw new DatabaseInitException(message);
		} catch (DatabaseException e) {
			String message = "A database initialisation error has occured (" + e.getMessage() + ")";
			throw new DatabaseInitException(message);
		}
	}
}
