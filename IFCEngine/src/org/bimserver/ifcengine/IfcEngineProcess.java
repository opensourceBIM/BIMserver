package org.bimserver.ifcengine;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

import org.bimserver.shared.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IfcEngineProcess extends Thread {
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcEngineProcess.class);
	private Process process;
	private final File nativeBaseDir;
	private final File schemaFile;
	private final FailSafeIfcEngine failSafeIfcEngine;
	private final ResourceFetcher resourceFetcher;
	private boolean running;
	private CountDownLatch countDownLatch = new CountDownLatch(1);

	public IfcEngineProcess(FailSafeIfcEngine failSafeIfcEngine, File schemaFile, File nativeBaseDir, ResourceFetcher resourceFetcher) {
		this.failSafeIfcEngine = failSafeIfcEngine;
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.resourceFetcher = resourceFetcher;
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
			addBinDir(new File(".." + File.separator + "IFCEngine" + File.separator + "bin"), command);
			addBinDir(new File(".." + File.separator + "Store" + File.separator + "bin"), command);
			addBinDir(new File(".." + File.separator + "Ifc" + File.separator + "bin"), command);
			addBinDir(new File(".." + File.separator + "Emf" + File.separator + "bin"), command);
			command.append(addJar("logging/slf4j-log4j12-1.6.0.jar"));
			command.append(addJar("logging/slf4j-api-1.6.0.jar"));
			command.append(addJar("logging/log4j-1.2.16.jar"));
			command.append(addJar("bimserver.jar"));
			command.append(addJar("jna.jar"));
			command.append(addJar("emf/org.eclipse.emf_2.5.0.v200906151043.jar"));
			command.append(addJar("emf/org.eclipse.emf.common_2.5.0.v200906151043.jar"));
			command.append(addJar("emf/org.eclipse.emf.ecore_2.5.0.v200906151043.jar"));
			command.append(addJar("emf/org.eclipse.emf.ecore.xmi_2.5.0.v200906151043.jar"));
			command.append(" -Xmx512m");
			command.append(" org.bimserver.ifcengine.IfcEngineServer");
			if (schemaFile.getAbsolutePath().contains(" ")) {
				command.append(" \"" + schemaFile.getAbsolutePath() + "\"");
			} else {
				command.append(" " + schemaFile.getAbsolutePath());
			}
			LOGGER.info(command.toString());
			process = Runtime.getRuntime().exec(command.toString());
			countDownLatch.countDown();
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
	
	private void addBinDir(File binFile, StringBuilder command) {
		if (binFile.exists()) {
			// For local development
			if (binFile.getAbsolutePath().contains(" ")) {
				command.append("\"" + binFile.getAbsolutePath() + "\"" + File.pathSeparator);
			} else {
				command.append(binFile.getAbsolutePath() + File.pathSeparator);
			}
		}
	}

	private String addJar(String string) throws UnsupportedEncodingException, URISyntaxException {
		URL resource = resourceFetcher.getResource("lib/" + string);
		if (resource == null) {
			resource = resourceFetcher.getResource("lib/" + string.substring(string.indexOf("/") + 1));
		}
		if (resource != null) {
			File file = new File(resource.toURI());
			String fileString = file.getAbsolutePath();
			if (fileString.contains(" ")) {
				return "\"" + fileString + "\"" + File.pathSeparator;
			} else {
				return fileString + File.pathSeparator;
			}
		}
		return "";
	}

	public void shutdown() {
		running = false;
		process.destroy();
		interrupt();
	}

	public InputStream getInputStream() {
		return process.getInputStream();
	}

	public OutputStream getOutputStream() {
		return process.getOutputStream();
	}
}