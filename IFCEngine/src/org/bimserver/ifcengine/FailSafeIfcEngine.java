package org.bimserver.ifcengine;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.bimserver.ifcengine.jvm.IfcEngineServer;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailSafeIfcEngine implements IfcEngine {
	private static final Logger LOGGER = LoggerFactory.getLogger(FailSafeIfcEngine.class);
	private Process process;
	private DataInputStream in;
	private DataOutputStream out;
	private InputStream err;
	private final File schemaFile;
	private final File nativeBaseDir;
	private boolean useSecondJvm = true;
	private final String classPath;
	private final File tempDir;

	public FailSafeIfcEngine(File schemaFile, File nativeBaseDir, File tempDir, String classPath) throws IfcEngineException {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.tempDir = tempDir;
		this.classPath = classPath;
		if (useSecondJvm) {
			startJvm();
		} else {
			startLocal();
		}
	}

	private void startLocal() {
		try {
			PipedInputStream pipedInputStream = new PipedInputStream();
			PipedOutputStream pipedOutputStream = new PipedOutputStream(pipedInputStream);
			IfcEngineServer ifcEngineServer = new IfcEngineServer(schemaFile.getAbsolutePath(), pipedInputStream, pipedOutputStream);
			in = new DataInputStream(new BufferedInputStream(pipedInputStream));
			out = new DataOutputStream(new BufferedOutputStream(pipedOutputStream));
			ifcEngineServer.start();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void startJvm() {
		try {
			if (!tempDir.exists()) {
				tempDir.mkdir();
			}
			StringBuilder command = new StringBuilder("java");
			if (nativeBaseDir.toString().contains(" ")) {
				command.append(" -Djna.library.path=\"" + nativeBaseDir.toString() + "\"");
			} else {
				command.append(" -Djna.library.path=" + nativeBaseDir.toString());
			}
			if (tempDir.getAbsolutePath().toString().contains(" ")) {
				command.append(" -Djava.io.tmpdir=\"" + tempDir.getAbsolutePath().toString() + "\"");
			} else {
				command.append(" -Djava.io.tmpdir=" + tempDir.getAbsolutePath().toString());
			}
			command.append(" -classpath ");
			command.append("\"");
			command.append(System.getProperty("java.class.path"));
			command.append(File.pathSeparator);
			if (classPath != null) {
				File file = new File(classPath);
				if (file.isDirectory()) {
					for (File subFile : file.listFiles()) {
						if (subFile.getName().endsWith(".jar")) {
							command.append(subFile.getAbsolutePath() + File.pathSeparator);
						}
					}
				}
				command.append(classPath + File.pathSeparator);
			}
			command.append("\"");
			command.append(" -Xmx512m");
			command.append(" org.bimserver.ifcengine.jvm.IfcEngineServer");
			if (schemaFile.getAbsolutePath().contains(" ")) {
				command.append(" \"" + schemaFile.getAbsolutePath() + "\"");
			} else {
				command.append(" " + schemaFile.getAbsolutePath());
			}
			LOGGER.error(command.toString());
			process = Runtime.getRuntime().exec(command.toString());
			in = new DataInputStream(new BufferedInputStream(process.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(process.getOutputStream()));
			err = process.getErrorStream();
			startErrorHandler();
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	private void startErrorHandler() {
		Runnable runnable = new Runnable(){
			@Override
			public void run() {
				byte[] buffer = new byte[1024];
				int red;
				try {
					red = err.read(buffer);
					while (red != -1) {
						LOGGER.error(new String(buffer, 0, red));
						red = err.read(buffer);
					}
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}};
		Thread thread = new Thread(runnable);
		thread.start();
	}

	public synchronized IfcEngineModelImpl openModel(File ifcFile) throws IfcEngineException {
		writeCommand(Command.OPEN_MODEL);
		writeUTF(ifcFile.getAbsolutePath());
		flush();
		int modelId = readInt();
		return new IfcEngineModelImpl(this, modelId);
	}

	public synchronized IfcEngineModelImpl openModel(InputStream inputStream, int size) throws IfcEngineException {
		writeCommand(Command.OPEN_MODEL_STREAMING);
		try {
			out.writeInt(size);
			int total = 0;
			while (total < size) {
				byte[] buffer = new byte[1024];
				int red = inputStream.read(buffer);
				if (red == -1) {
					break;
				}
				out.write(buffer, 0, red);
				total += red;
			}
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
		flush();
		int modelId = readInt();
		return new IfcEngineModelImpl(this, modelId);
	}

	public int readInt() throws IfcEngineException {
		try {
			return in.readInt();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void flush() throws IfcEngineException {
		try {
			out.flush();
		} catch (IOException e) {
//			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	void writeUTF(String value) throws IfcEngineException {
		try {
			out.writeUTF(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeCommand(Command command) throws IfcEngineException {
		try {
			out.writeByte(command.getId());
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public synchronized void close() {
		if (process != null) {
			try {
				writeCommand(Command.CLOSE);
				flush();
			} catch (IfcEngineException e) {
				LOGGER.error("", e);
			}
			process.destroy();
		}
	}

	public void writeInt(int value) throws IfcEngineException {
		try {
			out.writeInt(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeBoolean(boolean value) throws IfcEngineException {
		try {
			out.writeBoolean(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public float readFloat() throws IfcEngineException {
		try {
			return in.readFloat();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public String readString() throws IfcEngineException {
		try {
			return in.readUTF();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeDouble(double d) throws IfcEngineException {
		try {
			out.writeDouble(d);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public long readLong() throws IfcEngineException {
		try {
			return in.readLong();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public IfcEngineModelImpl openModel(byte[] bytes) throws IfcEngineException {
		return openModel(new ByteArrayInputStream(bytes), bytes.length);
	}
}