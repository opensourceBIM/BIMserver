package org.bimserver.longaction;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.bimserver.BimServer;
import org.bimserver.database.actions.ProgressListener;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.LongActionState;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.notifications.ProgressNotification;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.plugins.Reporter;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class LongAction<T extends LongActionKey> implements Reporter, ProgressListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongAction.class);
	private final GregorianCalendar start;
	private final AtomicInteger progress = new AtomicInteger(-1);
	private final CountDownLatch latch = new CountDownLatch(1);
	private final BimServer bimServer;
	private final String username;
	private final String userUsername;
	private ActionState actionState = ActionState.UNKNOWN;
	private GregorianCalendar stop;
	private final List<String> errors = new ArrayList<String>();
	private final List<String> warnings = new ArrayList<String>();
	private final List<String> infos = new ArrayList<String>();
	private final Authorization authorization;
	private String title = "Unknown";
	private int stage = 0;
	private ProgressTopic progressTopic;

	public LongAction(BimServer bimServer, String username, String userUsername, Authorization authorization) {
		start = new GregorianCalendar();
		this.authorization = authorization;
		this.userUsername = userUsername;
		this.username = username;
		this.bimServer = bimServer;
		this.actionState = ActionState.STARTED;
	}

	public void init(Thread thread) {
	}

	public void setProgressTopic(ProgressTopic progressTopic) {
		this.progressTopic = progressTopic;
	}
	
	public ProgressTopic getProgressTopic() {
		return progressTopic;
	}
	
	protected void changeActionState(ActionState actiontState, String title, int progress) {
		ActionState oldState = this.actionState;
		if (actiontState == ActionState.FINISHED) {
			stop = new GregorianCalendar();
		}
		int oldProgress = this.progress.get();
		String oldTitle = this.title;
		this.title = title;
		this.progress.set(progress);
		this.actionState = actiontState;
		if (oldState != actiontState || progress != oldProgress || !oldTitle.equals(title)) {
			if (title != null && oldTitle != null && !title.equals(oldTitle)) {
				stage++;
			}
			bimServer.getNotificationsManager().notify(new ProgressNotification(bimServer, progressTopic, getState()));
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

	public abstract void execute();

	public String getUserName() {
		return username;
	}

	protected void done() {
		bimServer.getNotificationsManager().notify(new ProgressNotification(bimServer, progressTopic, getState()));
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

	public void updateProgress(String title, int progress) {
		int oldProgress = this.progress.get();
		String oldTitle = this.title;
		this.title = title;
		this.progress.set(progress);
		if (progress != oldProgress || !oldTitle.equals(title)) {
			if (!title.equals(oldTitle)) {
				stage++;
			}
			bimServer.getNotificationsManager().notify(new ProgressNotification(bimServer, progressTopic, getState()));
		}
	}

	public void terminate() {
		LOGGER.info("Terminating long action with id " + progressTopic.getKey().getId());
//		thread.interrupt();
	}
	
	public int getProgress() {
		return progress.get();
	}

	public synchronized LongActionState getState() {
		LongActionState ds = StoreFactory.eINSTANCE.createLongActionState();
		ds.setStart(getStart().getTime());
		ds.setEnd(getStop() != null ? getStop().getTime() : null);
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
	
	public List<String> getErrors() {
		return errors;
	}
	
	@Override
	public void error(Exception error) {
		LOGGER.error("", error);
		errors.add(error.getMessage());
		stop = new GregorianCalendar();
		changeActionState(ActionState.AS_ERROR, error == null ? "Unknown Error" : error.getMessage(), 0);
	}
	
	@Override
	public void warning(String warning) {
		warnings.add(warning);
	}
	
	@Override
	public void info(String info) {
		infos.add(info);
	}

	public void stop() {
		progressTopic.remove();
	}
}