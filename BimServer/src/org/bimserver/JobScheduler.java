package org.bimserver;

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

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobScheduler.class);
	private static final int COMPARE_RESULT_CLEAN_INTERVAL_MILLIS = 30 * 60 * 1000; // 30 minutes
	private static final int LONG_ACTION_MANAGER_CLEANUP_INTERVAL_MILLIS = 1 * 60 * 1000; // 1 minute
	private SchedulerFactory sf;
	private Scheduler sched;

	public static class CompareResultCacheCleaner implements Job {
		@Override
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			try {
				BimServer bimServer = (BimServer) (jobExecutionContext.getScheduler().getContext().get("bimserver"));
				bimServer.getCompareCache().cleanup();
			} catch (SchedulerException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public static class LongActionManagerCleaner implements Job {
		@Override
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			try {
				BimServer bimServer = (BimServer) (jobExecutionContext.getScheduler().getContext().get("bimserver"));
				bimServer.getLongActionManager().cleanup();
			} catch (SchedulerException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public JobScheduler(BimServer bimServer) {
		try {
			Properties properties = new Properties();
			String instanceName = "UniqueName" + Math.random();
			properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			properties.setProperty("org.quartz.threadPool.threadCount", "1");
			properties.setProperty(StdSchedulerFactory.PROP_SCHED_INSTANCE_NAME, instanceName);
			sf = new StdSchedulerFactory(properties);
			sched = sf.getScheduler();
			sched.getContext().put("bimserver", bimServer);
		} catch (SchedulerException e) {
			LOGGER.error("", e);
		}
	}

	public void start() {
		try {
			addRecurringJob(CompareResultCacheCleaner.class, COMPARE_RESULT_CLEAN_INTERVAL_MILLIS);
			addRecurringJob(LongActionManagerCleaner.class, LONG_ACTION_MANAGER_CLEANUP_INTERVAL_MILLIS);
			sched.start();
		} catch (SchedulerException e) {
			LOGGER.error("", e);
		}
	}

	private void addRecurringJob(Class<? extends Job> class1, int intervalMillis) throws SchedulerException {
		SimpleTrigger trigger = newTrigger().withIdentity("group1", class1.getSimpleName()).withSchedule(simpleSchedule().withIntervalInMilliseconds(intervalMillis).repeatForever()).build();
		JobDetail job = newJob(class1).withIdentity("group1", class1.getSimpleName()).build();
		sched.scheduleJob(job, trigger);
	}

	public void close() {
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			LOGGER.error("", e);
		}
	}
}