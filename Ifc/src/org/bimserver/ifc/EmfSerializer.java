package org.bimserver.ifc;

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

import javax.activation.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EmfSerializer implements DataSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializer.class);
	protected final IfcModel model;
	private final String fileName;

	protected static enum SimpleMode {
		BUSY,
		DONE;
	}

	public EmfSerializer(String fileName, IfcModel model) {
		this.fileName = fileName;
		this.model = model;
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
	
	@Override
	public InputStream getInputStream() throws IOException {
		InputStream in = new InputStream() {
			byte[] buffer = new byte[0];
			int position;
			
			//TODO: Implement the other two read methods, to increase performance

//			@Override
//			public int read(byte[] b, int off, int len) throws IOException {
//				if (position < buffer.length) {
//					int min = Math.min(len, buffer.length - position);
//					System.arraycopy(buffer, position, b, off, min);
//					return min;
//				}
//				try {
//					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//					int write = write(outputStream);
//					buffer = new byte[0];
//					while (write != -1 && buffer.length == 0) {
//						position = 0;
//						buffer = outputStream.toByteArray();
//						if (buffer.length > 0) {
//							return buffer[position++];
//						}
//						write = write(outputStream);
//					}
//				} catch (SerializerException e) {
//					LOGGER.error("", e);
//				}
//			}
			
			@Override
			public synchronized int read() throws IOException {
				try {
					if (position < buffer.length) {
						return buffer[position++];
					}
					try {
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						int write = write(outputStream);
						buffer = new byte[0];
						while (write != -1 && buffer.length == 0) {
							position = 0;
							buffer = outputStream.toByteArray();
							if (buffer.length > 0) {
								return buffer[position++];
							}
							write = write(outputStream);
						}
					} catch (SerializerException e) {
						LOGGER.error("", e);
					}
				} catch (Exception e) {
					LOGGER.error("", e);
				}
				return -1;
			}
		};
		return in;
	}

	@Override
	public String getName() {
		return fileName;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	protected abstract int write(OutputStream outputStream) throws SerializerException;

	public void writeToOutputStream(OutputStream outputStream) throws SerializerException {
		int result = write(outputStream);
		while (result != -1) {
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
}