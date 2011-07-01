package org.bimserver;

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
	private static final int TOKEN_CLEAN_INTERVAL_MILLIS = 60 * 60 * 1000; // 1 hour
	private static final int CLASH_DETECTION_CLEAN_INTERVAL_MILLIS = 30 * 60 * 1000; // 30 minutes
	private static final int COMPARE_RESULT_CLEAN_INTERVAL_MILLIS = 30 * 60 * 1000; // 30 minutes
	private SchedulerFactory sf;
	private Scheduler sched;

	public static class TokenCleaner implements Job {
		@Override
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			try {
				BimServer bimServer = (BimServer) (jobExecutionContext.getScheduler().getContext().get("bimserver"));
				bimServer.getServiceFactory().cleanup();
			} catch (SchedulerException e) {
				LOGGER.error("", e);
			}
		}
	}
	
	public static class ClashDetectionCacheCleaner implements Job {
		
		@Override
		public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
			try {
				BimServer bimServer = (BimServer) (jobExecutionContext.getScheduler().getContext().get("bimserver"));
				bimServer.getClashDetectionCache().cleanup();
			} catch (SchedulerException e) {
				LOGGER.error("", e);
			}
		}
	}
	
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
	
	public JobScheduler(BimServer bimServer) {
		try {
			Properties properties = new Properties();
			properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			properties.setProperty("org.quartz.threadPool.threadCount", "1");
			sf = new StdSchedulerFactory(properties);
			sched = sf.getScheduler();
			sched.getContext().put("bimserver", bimServer);
		} catch (SchedulerException e) {
			LOGGER.error("", e);
		}
	}

	public void start() {
		try {
			addRecurringJob(TokenCleaner.class, TOKEN_CLEAN_INTERVAL_MILLIS);
			addRecurringJob(ClashDetectionCacheCleaner.class, CLASH_DETECTION_CLEAN_INTERVAL_MILLIS);
			addRecurringJob(CompareResultCacheCleaner.class, COMPARE_RESULT_CLEAN_INTERVAL_MILLIS);
			sched.start();
		} catch (SchedulerException e) {
			LOGGER.error("", e);
		}
	}

	private void addRecurringJob(Class<?> class1, int intervalMillis) throws SchedulerException {
		SimpleTrigger trigger = new SimpleTrigger(class1.getSimpleName(), "group1", SimpleTrigger.REPEAT_INDEFINITELY, intervalMillis);
		JobDetail job = new JobDetail(class1.getSimpleName(), "group1", class1);
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