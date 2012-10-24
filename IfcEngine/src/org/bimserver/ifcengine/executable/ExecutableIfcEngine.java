package org.bimserver.ifcengine.executable;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineModel;

public class ExecutableIfcEngine implements IfcEngine {

	private LoggingDataOutputStream outputStream;
	private LoggingDataInputStream inputStream;

	public ExecutableIfcEngine(File schemaFile, File executableLocation, File tmp, String classPath) {
		try {
			Process process = Runtime.getRuntime().exec(executableLocation + File.separator + "engine.exe");
			LogWriter logWriter = new LogWriter(new File("log.txt"));
			outputStream = new LoggingDataOutputStream(process.getOutputStream(), logWriter);
			inputStream = new LoggingDataInputStream(process.getInputStream(), logWriter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IfcEngineModel openModel(File ifcFile) throws IfcEngineException {
		writeCommand(Command.OPEN_MODEL);
		writeUTF(ifcFile.getAbsolutePath());
		flush();
		int modelId = readInt();
		return new ExecutableIfcEngineModel(this, modelId);
	}

	public int readInt() throws IfcEngineException {
		try {
			return inputStream.readInt();
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public void writeUTF(String string) throws IfcEngineException {
		try {
			outputStream.writeUTF(string);
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public void flush() {
		try {
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeCommand(Command command) {
		try {
			outputStream.writeByte(command.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IfcEngineModel openModel(InputStream inputStream, int size) throws IfcEngineException {
		writeCommand(Command.OPEN_MODEL_STREAMING);
		try {
			writeInt(size);
			int total = 0;
			while (total < size) {
				byte[] buffer = new byte[1024];
				int red = inputStream.read(buffer);
				if (red == -1) {
					break;
				}
				write(buffer, 0, red);
				total += red;
			}
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
		flush();
		int modelId = readInt();
		return new ExecutableIfcEngineModel(this, modelId);
	}

	private void write(byte[] buffer, int i, int red) throws IfcEngineException {
		try {
			outputStream.write(buffer, i, red);
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	@Override
	public IfcEngineModel openModel(byte[] bytes) throws IfcEngineException {
		return openModel(new ByteArrayInputStream(bytes), bytes.length);
	}

	@Override
	public void close() {
	}

	@Override
	public void init() throws IfcEngineException {
	}

	public void writeInt(int modelId) throws IfcEngineException {
		try {
			outputStream.writeInt(modelId);
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public String readString() throws IfcEngineException {
		try {
			return inputStream.readUTF();
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public void writeDouble(double d) throws IfcEngineException {
		try {
			outputStream.writeDouble(d);
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public float readFloat() throws IfcEngineException {
		try {
			return inputStream.readFloat();
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public long readLong() throws IfcEngineException {
		try {
			return inputStream.readLong();
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}

	public void writeBoolean(boolean postProcessing) throws IfcEngineException {
		try {
			outputStream.writeBoolean(postProcessing);
		} catch (IOException e) {
			throw new IfcEngineException(e);
		}
	}
}