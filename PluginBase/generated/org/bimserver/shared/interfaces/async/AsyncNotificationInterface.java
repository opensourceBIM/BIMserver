package org.bimserver.shared.interfaces.async;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.NotificationInterface;

public class AsyncNotificationInterface {

	private final ExecutorService executorService;
	private final NotificationInterface syncService;

	public AsyncNotificationInterface(NotificationInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface ClosedProgressOnProjectTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ClosedProgressOnRevisionTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ClosedProgressOnServerTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewExtendedDataCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewProgressOnProjectTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewProgressOnRevisionTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewProgressOnServerTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewProgressTopicCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewProjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewRevisionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface NewUserCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ProgressCallback {
		void success();
		void error(Throwable e);
	}
	


	public void closedProgressOnProjectTopic(final java.lang.Long poid, final java.lang.Long topicId, final ClosedProgressOnProjectTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.closedProgressOnProjectTopic(poid, topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void closedProgressOnRevisionTopic(final java.lang.Long poid, final java.lang.Long roid, final java.lang.Long topicId, final ClosedProgressOnRevisionTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.closedProgressOnRevisionTopic(poid, roid, topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void closedProgressOnServerTopic(final java.lang.Long topicId, final ClosedProgressOnServerTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.closedProgressOnServerTopic(topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newExtendedData(final java.lang.Long roid, final java.lang.Long edid, final NewExtendedDataCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newExtendedData(roid, edid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newProgressOnProjectTopic(final java.lang.Long poid, final java.lang.Long topicId, final NewProgressOnProjectTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newProgressOnProjectTopic(poid, topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newProgressOnRevisionTopic(final java.lang.Long poid, final java.lang.Long roid, final java.lang.Long topicId, final NewProgressOnRevisionTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newProgressOnRevisionTopic(poid, roid, topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newProgressOnServerTopic(final java.lang.Long topicId, final NewProgressOnServerTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newProgressOnServerTopic(topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newProgressTopic(final java.lang.Long topicId, final NewProgressTopicCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newProgressTopic(topicId);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newProject(final java.lang.Long poid, final NewProjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newProject(poid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newRevision(final java.lang.Long poid, final java.lang.Long roid, final NewRevisionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newRevision(poid, roid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void newUser(final java.lang.Long uoid, final NewUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.newUser(uoid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void progress(final java.lang.Long topicId, final org.bimserver.interfaces.objects.SLongActionState state, final ProgressCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.progress(topicId, state);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}