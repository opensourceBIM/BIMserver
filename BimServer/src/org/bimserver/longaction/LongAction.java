package org.bimserver.longaction;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.bimserver.models.store.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongAction<T extends LongActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongAction.class);
	private Date start;
	private int id;
	private final CountDownLatch latch = new CountDownLatch(1);

	public LongAction() {
		start = new Date();
	}

	public abstract String getDescription();
	
	public abstract void init();

	public abstract void execute();

	public int getId() {
		return id;
	}

	public abstract User getUser();

	protected void done() {
		latch.countDown();
	}
	
	public void waitForCompletion() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
	}

	public Date getStart() {
		return start;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract T getKey();
}