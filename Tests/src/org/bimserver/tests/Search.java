package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
