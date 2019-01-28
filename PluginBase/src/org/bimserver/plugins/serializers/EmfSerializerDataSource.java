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

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EmfSerializerDataSource extends ExtendedDataSource {

	private final Serializer serializer;
	private String modelName;

	public EmfSerializerDataSource(Serializer serializer, String modelName) {
		this.serializer = serializer;
		this.modelName = modelName;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new SerializerInputstream(serializer);
	}

	@Override
	public String getName() {
		return modelName;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public Serializer getSerializer() {
		return serializer;
	}

	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException, IOException {
		serializer.writeToOutputStream(outputStream, progressReporter);
		try {
			outputStream.close();
		} catch (EOFException e) {
			// let this one slide
		}
	}
}