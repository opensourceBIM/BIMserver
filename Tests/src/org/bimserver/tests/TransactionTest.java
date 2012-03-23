package org.bimserver.tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

public class TransactionTest {
	public static void main(String[] args) {
		new TransactionTest().start();
	}

	private void start() {
		EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setCachePercent(25);
		envConfig.setAllowCreate(true);
		envConfig.setTransactional(true);
		envConfig.setTxnTimeout(5, TimeUnit.SECONDS);
		envConfig.setLockTimeout(5, TimeUnit.SECONDS);

		File envHome = new File("test");
		envHome.mkdir();
		Environment environment = new Environment(envHome, envConfig);
		
		TransactionConfig transactionConfig = new TransactionConfig();
		transactionConfig.setReadCommitted(true);

		CursorConfig cursorConfig = new CursorConfig();
		cursorConfig.setReadCommitted(true);
		
		DatabaseConfig databaseConfig = new DatabaseConfig();
		databaseConfig.setAllowCreate(true);
		databaseConfig.setDeferredWrite(false);
		databaseConfig.setTransactional(true);
		databaseConfig.setSortedDuplicates(false);
		Database database = environment.openDatabase(null, "test", databaseConfig);
		
		Transaction transaction1 = environment.beginTransaction(null, transactionConfig);
		database.put(transaction1, new DatabaseEntry(new byte[]{1}), new DatabaseEntry(new byte[]{1}));
		
		Transaction transaction2 = environment.beginTransaction(null, transactionConfig);
		OperationStatus operationStatus = database.get(transaction2, new DatabaseEntry(new byte[]{1}), new DatabaseEntry(), LockMode.DEFAULT);
		System.out.println(operationStatus);
		transaction2.commit();
		
		transaction1.commit();
	}
}
