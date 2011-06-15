package org.bimserver.plugins.serializers;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.plugins.PluginManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EmfSerializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializer.class);
	protected IfcModelInterface model;
	private Mode mode;
	private ProjectInfo projectInfo;
	private PluginManager pluginManager;

	protected static enum Mode {
		HEADER,
		BODY,
		FOOTER,
		FINISHED
	}

	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager) throws SerializerException {
		this.model = model;
		this.projectInfo = projectInfo;
		this.setPluginManager(pluginManager);
		reset();
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	
	protected Mode getMode() {
		return mode;
	}
	
	protected void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public byte[] getBytes() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			writeToOutputStream(outputStream);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return outputStream.toByteArray();
	}

	public InputStream getInputStream() throws IOException {
		reset();
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = new InputStream() {
			int pos = 0;
			byte[] buffer;

			@Override
			public int read(byte[] b, int off, int len) throws IOException {
				int read = 0;
				if (buffer != null && pos < buffer.length) {
					int nrToCopy = Math.min(buffer.length - pos, len);
					System.arraycopy(buffer, pos, b, off, nrToCopy);
					pos += nrToCopy;
					read += nrToCopy;
				}
				while (read < len) {
					out.reset();
					buffer = null;
					pos = 0;
					try {
						boolean write = write(out);
						if (write) {
							buffer = out.toByteArray();
							if (buffer.length > 0) {
								int nrToCopy = Math.min(buffer.length, len - read);
								System.arraycopy(buffer, pos, b, off + read, nrToCopy);
								pos += nrToCopy;
								read += nrToCopy;
							}
						} else {
							if (read != 0) {
								return read;
							} else {
								return -1;
							}
						}
					} catch (SerializerException e) {
						LOGGER.error("", e);
					}
				}
				return read;
			}
			
			@Override
			public int read() throws IOException {
				try {
					if (buffer != null && pos < buffer.length) {
						return buffer[pos++];
					} else {
						buffer = null;
						while (buffer == null) {
							out.reset();
							boolean write = write(out);
							if (write) {
								byte[] newBuffer = out.toByteArray();
								if (newBuffer.length > 0) {
									buffer = newBuffer;
									pos = 1;
									return buffer[0];
								}
							} else {
								return -1;
							}
						}
					}
				} catch (SerializerException e) {
					LOGGER.error("", e);
				}
				return 0;
			}
		};
		return in;
	}

	protected abstract void reset();

	protected abstract boolean write(OutputStream outputStream) throws SerializerException;

	public void writeToOutputStream(OutputStream outputStream) throws SerializerException {
		boolean result = write(outputStream);
		while (result) {
			result = write(outputStream);
		}
	}

	public void writeToFile(File file) throws SerializerException {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			writeToOutputStream(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public IfcModelInterface getModel() {
		return model;
	}

	public void setPluginManager(PluginManager pluginManager) {
		this.pluginManager = pluginManager;
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}
}