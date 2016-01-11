package org.bimserver.plugins.serializers;

import java.io.EOFException;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.utils.MultiplexingOutputStream;

public class CacheStoringStreamingSerializerDataSource extends ExtendedDataSource {

	private RemovableFileOutputStream diskCacheOutputStream;
	private StreamingSerializer serializer;
	private DoneListener doneListener;

	public CacheStoringStreamingSerializerDataSource(StreamingSerializer serializer, RemovableFileOutputStream diskCacheOutputStream, DoneListener doneListener) {
		this.serializer = serializer;
		this.diskCacheOutputStream = diskCacheOutputStream;
		this.doneListener = doneListener;
	}
	
	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException, IOException {
		try {
			MultiplexingOutputStream multiplexer = new MultiplexingOutputStream(outputStream, diskCacheOutputStream);
			serializer.writeToOutputStream(multiplexer);
			try {
				multiplexer.close();
			} catch (EOFException e) {
				// let this one slide
			}
			doneListener.done();
		} catch (Exception e) {
			e.printStackTrace();
			diskCacheOutputStream.remove();
		}
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
}