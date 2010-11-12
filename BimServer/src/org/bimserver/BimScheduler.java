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

public class BimScheduler {
	private SchedulerFactory sf;
	private static final int CLEAN_INTERVAL = 60 * 60 * 1000; // 1 hour
	private Scheduler sched;

	public static class TokenCleaner implements Job {
		@Override
		public void execute(JobExecutionContext arg0) throws JobExecutionException {
			if (ServiceFactory.getINSTANCE() != null) {
				ServiceFactory.getINSTANCE().cleanup();
			}
		}
	}
	
	public BimScheduler() {
		try {
			Properties properties = new Properties();
			properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			properties.setProperty("org.quartz.threadPool.threadCount", "1");
			sf = new StdSchedulerFactory(properties);
			sched = sf.getScheduler();
		} catch (SchedulerException e1) {
			e1.printStackTrace();
		}
	}

	public void start() {
		try {
			JobDetail job = new JobDetail("tokenCleaner", "group1", TokenCleaner.class);
			sched.scheduleJob(job, new SimpleTrigger("tokenCleanerTrigger", "group1", SimpleTrigger.REPEAT_INDEFINITELY, CLEAN_INTERVAL));
			sched.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}