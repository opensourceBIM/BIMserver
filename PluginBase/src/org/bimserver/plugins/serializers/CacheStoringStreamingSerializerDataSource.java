package org.bimserver.plugins.serializers;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.utils.MultiplexingOutputStream;

public class CacheStoringStreamingSerializerDataSource extends ExtendedDataSource {

	private RemovableFileOutputStream diskCacheOutputStream;
	private StreamingSerializer serializer;
	private DoneListener doneListener;
	private String name;

	public CacheStoringStreamingSerializerDataSource(StreamingSerializer serializer, RemovableFileOutputStream diskCacheOutputStream, DoneListener doneListener, String name) {
		this.serializer = serializer;
		this.diskCacheOutputStream = diskCacheOutputStream;
		this.doneListener = doneListener;
		this.name = name;
	}
	
	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws Exception {
		MultiplexingOutputStream multiplexer = null;
		boolean closed = false;
		try {
			multiplexer = new MultiplexingOutputStream(outputStream, diskCacheOutputStream);
			serializer.writeToOutputStream(multiplexer);
			doneListener.done();
		} catch (Exception e) {
			if (multiplexer != null) {
				RemovableFileOutputStream diskCache = (RemovableFileOutputStream) multiplexer.getB();
				multiplexer.getA().close();
				diskCache.cancel();
			}
			closed = true;
			throw e;
		} finally {
			if (!closed && multiplexer != null) {
				multiplexer.close();
			}
		}
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return serializer.getInputStream();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}
}