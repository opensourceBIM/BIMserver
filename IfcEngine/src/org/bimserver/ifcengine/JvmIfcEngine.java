package org.bimserver.ifcengine;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

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

public class JvmIfcEngine implements IfcEngine {
	private static final Logger LOGGER = LoggerFactory.getLogger(JvmIfcEngine.class);
	private Process process;
	private DataInputStream in;
	private DataOutputStream out;
	private InputStream err;
	private final File schemaFile;
	private final File nativeBaseDir;
	private boolean useSecondJvm = true;
	private final String classPath;
	private final File tempDir;
	private volatile IfcEngineException lastException;

	public JvmIfcEngine(File schemaFile, File nativeBaseDir, File tempDir, String classPath) throws IfcEngineException {
		this.schemaFile = schemaFile;
		this.nativeBaseDir = nativeBaseDir;
		this.tempDir = tempDir;
		this.classPath = classPath;
	}

	public void init() throws IfcEngineException {
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
			IfcEngineServer ifcEngineServer = new IfcEngineServer(schemaFile.getAbsolutePath(), pipedInputStream, pipedOutputStream, null);
			in = new DataInputStream(new BufferedInputStream(pipedInputStream));
			out = new DataOutputStream(new BufferedOutputStream(pipedOutputStream));
			ifcEngineServer.start();
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public void startJvm() throws IfcEngineException {
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
			String mem = "512m";
			if (Runtime.getRuntime().maxMemory() == Long.MAX_VALUE) {
			} else {
				int megs = (int) (Runtime.getRuntime().maxMemory() / 2000000);
				if (megs > 1024) {
					megs = 1024;
				}
				mem = String.valueOf(megs + "m");
			}
			command.append(" -Xmx" + mem);
			command.append(" -Xms" + mem);
			
			// THIS IS ONLY A TEMPORARY FIX FOR Eclipse 3.7.2/Java7
			command.append(" -XX:-UseSplitVerifier");
			
			command.append(" org.bimserver.ifcengine.jvm.IfcEngineServer");
			if (schemaFile.getAbsolutePath().contains(" ")) {
				command.append(" \"" + schemaFile.getAbsolutePath() + "\"");
			} else {
				command.append(" " + schemaFile.getAbsolutePath());
			}
			LOGGER.info(command.toString());
			process = Runtime.getRuntime().exec(command.toString());
			in = new DataInputStream(new BufferedInputStream(process.getInputStream()));
			out = new DataOutputStream(new BufferedOutputStream(process.getOutputStream()));
			err = process.getErrorStream();
			startErrorHandler();
			Thread thread = new Thread(){
				@Override
				public void run() {
					int result;
					try {
						result = process.waitFor();
						if (result != 0) {
							lastException = new IfcEngineException("Process ended with errorcode: " + result);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			thread.start();
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new IfcEngineException(e);
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
		Thread thread = new Thread(runnable, "FailSafeIfcEngine ErrorHandler");
		thread.start();
	}

	public synchronized JvmIfcEngineModel openModel(File ifcFile) throws IfcEngineException {
		checkRunning();
		writeCommand(Command.OPEN_MODEL);
		writeUTF(ifcFile.getAbsolutePath());
		flush();
		int modelId = readInt();
		return new JvmIfcEngineModel(this, modelId);
	}

	public synchronized JvmIfcEngineModel openModel(InputStream inputStream, int size) throws IfcEngineException {
		checkRunning();
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
		return new JvmIfcEngineModel(this, modelId);
	}

	private void checkRunning() throws IfcEngineException {
		if (lastException != null) {
			throw lastException;
		}
	}
	
	public int readInt() throws IfcEngineException {
		checkRunning();
		try {
			return in.readInt();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void flush() throws IfcEngineException {
		checkRunning();
		try {
			out.flush();
		} catch (IOException e) {
//			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	void writeUTF(String value) throws IfcEngineException {
		checkRunning();
		try {
			out.writeUTF(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeCommand(Command command) throws IfcEngineException {
		checkRunning();
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
		checkRunning();
		try {
			out.writeInt(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeBoolean(boolean value) throws IfcEngineException {
		checkRunning();
		try {
			out.writeBoolean(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public float readFloat() throws IfcEngineException {
		checkRunning();
		try {
			return in.readFloat();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public String readString() throws IfcEngineException {
		checkRunning();
		try {
			return in.readUTF();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public void writeDouble(double d) throws IfcEngineException {
		checkRunning();
		try {
			out.writeDouble(d);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public long readLong() throws IfcEngineException {
		checkRunning();
		try {
			return in.readLong();
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}

	public JvmIfcEngineModel openModel(byte[] bytes) throws IfcEngineException {
		checkRunning();
		return openModel(new ByteArrayInputStream(bytes), bytes.length);
	}

	public void writeLong(long value) throws IfcEngineException {
		checkRunning();
		try {
			out.writeLong(value);
		} catch (IOException e) {
			throw new IfcEngineException("Unknown IFC Engine error");
		}
	}
}