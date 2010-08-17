package org.bimserver;

import java.util.Properties;

import org.bimserver.services.TokenManager;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class BimScheduler {
	private SchedulerFactory sf;
	private static final int CLEAN_INTERVAL = 60 * 60 * 1000; // 1 hour
	private Scheduler sched;

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
			JobDetail job = new JobDetail("tokenManagerCleaner", "group1", TokenManager.class);
			sched.scheduleJob(job, new SimpleTrigger("tokenManagerCleanerTrigger", "group1", SimpleTrigger.REPEAT_INDEFINITELY, CLEAN_INTERVAL));
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