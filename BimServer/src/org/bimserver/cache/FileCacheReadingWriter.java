package org.bimserver.cache;

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

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.Writer;
import org.bimserver.servlets.ReusableLittleEndianDataOutputStream;
import org.bimserver.utils.GrowingByteBuffer;

import com.google.common.io.ByteStreams;

public class FileCacheReadingWriter implements Writer, Closeable {

	private Path file;
	private DataInputStream inputStream;
	private int nextSize = -1;
	private byte[] buffer;

	public FileCacheReadingWriter(Path file) {
		this.file = file;
		try {
			inputStream = new DataInputStream(new BufferedInputStream(Files.newInputStream(file)));
			nextSize = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		if (outputStream instanceof ReusableLittleEndianDataOutputStream) {
			ReusableLittleEndianDataOutputStream reusableLittleEndianDataOutputStream = (ReusableLittleEndianDataOutputStream)outputStream;
			reusableLittleEndianDataOutputStream.ensureExtraCapacity(nextSize);
			GrowingByteBuffer growingByteBuffer = reusableLittleEndianDataOutputStream.getGrowingByteBuffer();
			ByteBuffer targetBuffer = growingByteBuffer.getByteBuffer();
			inputStream.readFully(targetBuffer.array(), targetBuffer.position(), nextSize);
			targetBuffer.position(targetBuffer.position() + nextSize);
			nextSize = inputStream.readInt();
			return nextSize != -1;
		} else {
			if (buffer == null || nextSize > buffer.length) {
				buffer = new byte[nextSize];
			}
			ByteStreams.readFully(inputStream, buffer, 0, nextSize);
			outputStream.write(buffer, 0, nextSize);
			nextSize = inputStream.readInt();
			return nextSize != -1;
		}
	}

	public void setName(String fileNameWithoutExtension) {
	}

	@Override
	public void close() throws IOException {
		inputStream.close();
	}
}
