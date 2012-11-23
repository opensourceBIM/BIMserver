package org.bimserver.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Search {
	public static void main(String[] args) {
		new Search().start();
	}

	private void start() {
		File file = new File("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected");
		final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ExecutorService executorService = new ThreadPoolExecutor(8, 8, 1000L, TimeUnit.MINUTES, queue);
		for (final File f : file.listFiles()) {
			Runnable runnable = new Runnable(){
				@Override
				public void run() {
					try {
						Scanner scanner = new Scanner(f);
						while (scanner.hasNextLine()) {
							String line = scanner.nextLine();
							if (line.contains("SystemId")) {
								System.out.println(line);
							}
						}
						scanner.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}};
			executorService.execute(runnable);
		}
		new Thread(){
			public void run() {
				while (true) {
					System.out.println("" + queue.size());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
		try {
			executorService.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
