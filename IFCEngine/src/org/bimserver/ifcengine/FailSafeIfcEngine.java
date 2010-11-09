package org.bimserver.ifcengine;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bimserver.shared.ResourceFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailSafeIfcEngine {
	private static final Logger LOGGER = LoggerFactory.getLogger(FailSafeIfcEngine.class);
	private DataInputStream in;
	private DataOutputStream out;
	private IfcEngineProcess engineProces;

	public FailSafeIfcEngine(final File schemaFile, final File nativeBaseDir, ResourceFetcher resourceFetcher) throws IfcEngineException {
		engineProces = new IfcEngineProcess(this, schemaFile, nativeBaseDir, resourceFetcher);
		engineProces.start();
		engineProces.waitForConnection();
		in = new DataInputStream(new BufferedInputStream(engineProces.getInputStream()));
		out = new DataOutputStream(new BufferedOutputStream(engineProces.getOutputStream()));
	}

	public synchronized IfcEngineModel openModel(File ifcFile) throws IfcEngineException {
		writeCommand(Command.OPEN_MODEL);
		writeUTF(ifcFile.getAbsolutePath());
		flush();
		int modelId = readInt();
		return new IfcEngineModel(this, modelId);
	}

	public synchronized IfcEngineModel openModel(InputStream inputStream, int size) throws IfcEngineException {
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
		return new IfcEngineModel(this, modelId);
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
			throw new IfcEngineException("Unknown IFC Engine error");
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
		if (engineProces != null) {
			try {
				writeCommand(Command.CLOSE);
				flush();
			} catch (IfcEngineException e) {
				LOGGER.error("", e);
			}
			engineProces.shutdown();
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

	public synchronized void engineStopped() {
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

	public IfcEngineModel openModel(byte[] bytes) throws IfcEngineException {
		return openModel(new ByteArrayInputStream(bytes), bytes.length);
	}
}