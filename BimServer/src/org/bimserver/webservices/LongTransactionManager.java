package org.bimserver.webservices;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class LongTransactionManager {
	private final AtomicLong counter = new AtomicLong();
	private final Map<Long, LongTransaction> runningTransactions = new HashMap<Long, LongTransaction>();
	
	public synchronized LongTransaction newLongTransaction(long poid, int pid, int rid) {
		LongTransaction longTransaction = new LongTransaction(poid, pid, rid, counter.incrementAndGet());
		runningTransactions.put(longTransaction.getTid(), longTransaction);
		return longTransaction;
	}

	public LongTransaction get(Long tid) throws NoTransactionException {
		LongTransaction longTransaction = runningTransactions.get(tid);
		if (longTransaction == null) {
			throw new NoTransactionException("No transaction with tid " + tid + " could be found");
		}
		return longTransaction;
	}

	public void remove(long tid) throws NoTransactionException {
		get(tid);
		runningTransactions.remove(tid);
	}
}