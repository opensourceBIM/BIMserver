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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;

public class FileInputStreamDataSource extends ExtendedDataSource {

	private final Path file;
	private String name;
	private InputStream inputStream;
	
	public FileInputStreamDataSource(Path file) {
		this.file = file;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		if (inputStream != null) {
			inputStream.close();
		}
		inputStream = Files.newInputStream(file);
		return inputStream;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long size() {
		try {
			return Files.size(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException, IOException, BimserverDatabaseException {
		copy(getInputStream(), outputStream, progressReporter, Files.size(file));
	}
	
	private long copy(InputStream input, OutputStream output, ProgressReporter progressReporter, long totalSize) throws IOException {
		byte[] buffer = new byte[4096];
        long count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
            progressReporter.update(count, totalSize);
        }
        return count;
	}
}