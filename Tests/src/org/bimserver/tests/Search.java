package org.bimserver.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.utils.PathUtils;

public class Search {
	public static void main(String[] args) {
		new Search().start();
	}

	private void start() {
		Path file = Paths.get("C:\\Users\\Ruben de Laat\\Dropbox\\Logic Labs\\Clients\\TNO\\ifc selected");
		final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ExecutorService executorService = new ThreadPoolExecutor(8, 8, 1000L, TimeUnit.MINUTES, queue);
		try {
			for (final Path f : PathUtils.list(file)) {
				Runnable runnable = new Runnable(){
					@Override
					public void run() {
						try {
							Scanner scanner = new Scanner(f.toFile());
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
		} catch (IOException e1) {
			e1.printStackTrace();
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
