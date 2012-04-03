package org.bimserver.longaction;

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

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.bimserver.BimServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongAction<T extends LongActionKey> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongAction.class);
	private final Date start;
	private int id;
	private int progress;
	private final CountDownLatch latch = new CountDownLatch(1);
	private final BimServer bimServer;
	private final String username;
	private final String userUsername;
	private final long uoid;

	public LongAction(BimServer bimServer, String username, String userUsername, long uoid) {
		start = new Date();
		this.userUsername = userUsername;
		this.uoid = uoid;
		this.username = username;
		this.bimServer = bimServer;
	}

	public String getUserUsername() {
		return userUsername;
	}
	
	public long getUoid() {
		return uoid;
	}
	
	public BimServer getBimServer() {
		return bimServer;
	}
	
	public abstract String getDescription();
	
	public abstract void init();

	public abstract void execute();

	public int getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}

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
	
	public void updateProgress(int progress) {
		this.progress = progress;
	}
	
	public int getProgress() {
		return progress;
	}
}