package org.bimserver.longaction;

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

import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.ProgressReporter;
import org.bimserver.plugins.serializers.SerializerException;

public class MessagingStreamingDataSource extends ExtendedDataSource {

	private MessagingStreamingSerializer messagingStreamingSerializer;

	public MessagingStreamingDataSource(MessagingStreamingSerializer messagingStreamingSerializer) {
		this.messagingStreamingSerializer = messagingStreamingSerializer;
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new MessagingSerializerInputstream(messagingStreamingSerializer);
	}
	
	@Override
	public String getName() {
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		return null;
	}

	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException {
		while(messagingStreamingSerializer.writeMessage(outputStream, progressReporter)) {
		}
	}
}