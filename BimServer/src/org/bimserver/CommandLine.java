package org.bimserver;

import java.util.Map;
import java.util.Scanner;

public class CommandLine extends Thread {
	private final Server server;

	public CommandLine(Server server) {
		setName("CommandLine");
		setDaemon(true);
		this.server = server;
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("exit")) {
				server.stop();
				return;
			} else if (line.equalsIgnoreCase("dump")) {
				System.out.println("Dumping all thread's track traces...");
				System.out.println();
				Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
				for (Thread t : allStackTraces.keySet()) {
					System.out.println(t.getName());
					StackTraceElement[] stackTraceElements = allStackTraces.get(t);
					for (StackTraceElement stackTraceElement : stackTraceElements) {
						System.out.println("\t" + stackTraceElement.getClassName() + ":" + stackTraceElement.getLineNumber() + "." + stackTraceElement.getMethodName());
					}
					System.out.println();
				}
				System.out.println("Done printing stack traces");
				System.out.println();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}