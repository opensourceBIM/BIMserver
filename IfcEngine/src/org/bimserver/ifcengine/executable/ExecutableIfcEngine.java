package org.bimserver.ifcengine.executable;

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
 * 
 * BIMserver software uses the IFC Engine DLL library build.
 * This binary Engine DLL is NOT open source. The IFC Engine DLL is a closed source product owned by the Netherlands Organisation for Applied Scientifc Research TNO.
 * The latest versions are available for download from http://ifcengine.com.
 * In case of none commercial use there is no license fee and redistribution of the binary is allowed as long as clearly mentioned that the IFC Engine DLL is used. The BIMserver.org software is non-commercial so users of the BIMserver software can use it free of charge.
 * Within the Open Source BIMserver software there is one exception to the normal conditions: A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact the owner at info@ifcengine.com
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bimserver.ifcengine.Command;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineModel;

public class ExecutableIfcEngine implements RenderEngine {

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
	public RenderEngineModel openModel(File ifcFile) throws RenderEngineException {
		writeCommand(Command.OPEN_MODEL);
		writeUTF(ifcFile.getAbsolutePath());
		flush();
		int modelId = readInt();
		return new ExecutableIfcEngineModel(this, modelId);
	}

	public int readInt() throws RenderEngineException {
		try {
			return inputStream.readInt();
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public void writeUTF(String string) throws RenderEngineException {
		try {
			outputStream.writeUTF(string);
		} catch (IOException e) {
			throw new RenderEngineException(e);
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
	public RenderEngineModel openModel(InputStream inputStream, int size) throws RenderEngineException {
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
			throw new RenderEngineException(e);
		}
		flush();
		int modelId = readInt();
		return new ExecutableIfcEngineModel(this, modelId);
	}

	private void write(byte[] buffer, int i, int red) throws RenderEngineException {
		try {
			outputStream.write(buffer, i, red);
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	@Override
	public RenderEngineModel openModel(byte[] bytes) throws RenderEngineException {
		return openModel(new ByteArrayInputStream(bytes), bytes.length);
	}

	@Override
	public void close() {
	}

	@Override
	public void init() throws RenderEngineException {
	}

	public void writeInt(int modelId) throws RenderEngineException {
		try {
			outputStream.writeInt(modelId);
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public String readString() throws RenderEngineException {
		try {
			return inputStream.readUTF();
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public void writeDouble(double d) throws RenderEngineException {
		try {
			outputStream.writeDouble(d);
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public float readFloat() throws RenderEngineException {
		try {
			return inputStream.readFloat();
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public long readLong() throws RenderEngineException {
		try {
			return inputStream.readLong();
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}

	public void writeBoolean(boolean postProcessing) throws RenderEngineException {
		try {
			outputStream.writeBoolean(postProcessing);
		} catch (IOException e) {
			throw new RenderEngineException(e);
		}
	}
}