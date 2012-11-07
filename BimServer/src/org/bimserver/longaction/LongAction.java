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
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.plugins.Reporter;
import org.bimserver.webservices.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongAction<T extends LongActionKey> implements Reporter, ProgressListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongAction.class);
	private final GregorianCalendar start;
	private long id;
	private int progress = -1;
	private final CountDownLatch latch = new CountDownLatch(1);
	private final BimServer bimServer;
	private final String username;
	private final String userUsername;
	private ActionState actionState = ActionState.UNKNOWN;
	private GregorianCalendar stop;
	private final List<String> errors = new ArrayList<String>();
	private final List<String> warnings = new ArrayList<String>();
	private final List<String> infos = new ArrayList<String>();
	private Authorization authorization;
	private String title = "Unknown";
	private int stage = 0;

	public LongAction(BimServer bimServer, String username, String userUsername, Authorization authorization) {
		start = new GregorianCalendar();
		this.authorization = authorization;
		this.userUsername = userUsername;
		this.username = username;
		this.bimServer = bimServer;
	}

	protected void changeActionState(ActionState actiontState) {
		ActionState oldState = this.actionState;
		if (actiontState == ActionState.FINISHED) {
			stop = new GregorianCalendar();
		}
		this.actionState = actiontState;
		if (oldState != actiontState) {
			bimServer.getNotificationsManager().updateProgress(id, getState());
		}
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

	public Authorization getAuthorization() {
		return authorization;
	}

	public BimServer getBimServer() {
		return bimServer;
	}

	public abstract String getDescription();

	public abstract void init();

	public abstract void execute();

	public long getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}

	protected void done() {
		latch.countDown();
		bimServer.getNotificationsManager().updateProgress(id, getState());
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

	public void updateProgress(String title, int progress) {
		int oldProgress = this.progress;
		String oldTitle = this.title;
		this.title = title;
		this.progress = progress;
		if (progress != oldProgress || !oldTitle.equals(title)) {
			if (!title.equals(oldTitle)) {
				stage ++;
			}
			bimServer.getNotificationsManager().updateProgress(id, getState());
		}
	}

	public int getProgress() {
		return progress;
	}

	public synchronized LongActionState getState() {
		LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
		ds.setProgress(getProgress());
		ds.setState(getActionState());
		ds.setTitle(title);
		ds.setStage(stage);
		ds.getErrors().addAll(errors);
		ds.getInfos().addAll(infos);
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