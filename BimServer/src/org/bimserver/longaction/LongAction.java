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

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.bimserver.BimServer;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.Reporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongAction<T extends LongActionKey> implements Reporter {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongAction.class);
	private final GregorianCalendar start;
	private int id;
	private int progress;
	private final CountDownLatch latch = new CountDownLatch(1);
	private final BimServer bimServer;
	private final String username;
	private final String userUsername;
	private final long uoid;
	private ActionState actionState = ActionState.UNKNOWN;
	private GregorianCalendar stop;
	private final List<String> errors = new ArrayList<String>();
	private final List<String> warnings = new ArrayList<String>();
	private final List<String> infos = new ArrayList<String>();

	public LongAction(BimServer bimServer, String username, String userUsername, long uoid) {
		start = new GregorianCalendar();
		this.userUsername = userUsername;
		this.uoid = uoid;
		this.username = username;
		this.bimServer = bimServer;
	}

	protected void changeActionState(ActionState actiontState) {
		if (actiontState == ActionState.FINISHED) {
			stop = new GregorianCalendar();
		}
		this.actionState = actiontState;
	}

	public GregorianCalendar getStop() {
		return stop;
	}
	
	public ActionState getActionState() {
		return this.actionState;
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

	public GregorianCalendar getStart() {
		return start;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void updateProgress(int progress) {
		this.progress = progress;
	}

	public int getProgress() {
		return progress;
	}

	public synchronized LongActionState getState() {
		LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
		ds.setProgress(getProgress());
		ds.setState(getActionState());
		ds.getErrors().addAll(errors);
		ds.getWarnings().addAll(warnings);
		if (getActionState() == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		return ds;
	}
	
	@Override
	public void error(String error) {
		errors.add(error);
	}
	
	@Override
	public void warning(String warning) {
		warnings.add(warning);
	}
	
	@Override
	public void info(String info) {
		infos.add(info);
	}
}