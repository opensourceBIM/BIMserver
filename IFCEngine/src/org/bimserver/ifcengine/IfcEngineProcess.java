package org.bimserver.ifcengine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcEngineProcess extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcEngineProcess.class);
	private Process process;
	private final File nativeBaseDir;
	private final File schemaFile;
	private final FailSafeIfcEngine failSafeIfcEngine;
	private boolean running;
	private CountDownLatch countDownLatch = new CountDownLatch(1);

	public IfcEngineProcess(FailSafeIfcEngine failSafeIfcEngine, File schemaFile, File nativeBaseDir) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		setName("EngineProces");
		setDaemon(true);
	}

	public void run() {
		running = true;
		try {
			File tmp = new File("tmp");
			if (!tmp.exists()) {
				tmp.mkdir();
			}
			StringBuilder command = new StringBuilder("java");
			command.append(" -Djna.library.path=" + nativeBaseDir.toString() + File.separator + System.getProperty("sun.arch.data.model"));
			if (tmp.getAbsolutePath().toString().contains(" ")) {
				command.append(" -Djava.io.tmpdir=\"" + tmp.getAbsolutePath().toString() + "\"");
			} else {
				command.append(" -Djava.io.tmpdir=" + tmp.getAbsolutePath().toString());
			}
			command.append(" -classpath ");
			String[] classpath = System.getProperty("java.class.path").split(File.pathSeparator);
			for (String s : classpath) {
				if (s.contains(" ")) {
					command.append("\"" + s + "\"");
				} else {
					command.append(s);
				}
				command.append(File.pathSeparator);
			}
			if (command.substring(command.length()-1).equals(File.pathSeparator)) {
				command.delete(command.length()-1, command.length());
			}
			command.append(" -Xmx512m");
			command.append(" org.bimserver.ifcengine.jvm.IfcEngineServer");
			if (schemaFile.getAbsolutePath().contains(" ")) {
				command.append(" \"" + schemaFile.getAbsolutePath() + "\"");
			} else {
				command.append(" " + schemaFile.getAbsolutePath());
			}
			LOGGER.info(command.toString());
			process = Runtime.getRuntime().exec(command.toString());
			countDownLatch.countDown();
			final InputStream errorStream = getErrorStream();
			Runnable errorReader = new Runnable(){
				@Override
				public void run() {
					while (true) {
						try {
							while (errorStream.available() > 0) {
								byte[] buffer = new byte[1024];
								int red = errorStream.read(buffer);
								while (red != -1) {
									System.err.print(new String(buffer, 0, red, "UTF-8"));
									red = errorStream.read(buffer);
								}
							}
						} catch (IOException e) {
							LOGGER.error("", e);
						}
					}
				}};
			new Thread(errorReader).start();
			process.waitFor();
			failSafeIfcEngine.engineStopped();
		} catch (Exception e) {
			if (running) {
				LOGGER.error("", e);
			}
		}
	}

	public void waitForConnection() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}
	}

	public void shutdown() {
		running = false;
		process.destroy();
		interrupt();
	}

	public InputStream getErrorStream() {
		return process.getErrorStream();
	}
	
	public InputStream getInputStream() {
		return process.getInputStream();
	}

	public OutputStream getOutputStream() {
		return process.getOutputStream();
	}
}