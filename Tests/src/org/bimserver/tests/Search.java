package org.bimserver.tests;

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
