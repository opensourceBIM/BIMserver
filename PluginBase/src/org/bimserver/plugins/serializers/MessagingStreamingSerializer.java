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
import java.io.OutputStream;

import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginManagerInterface;

public interface MessagingStreamingSerializer extends Writer {
	void init(ObjectProvider objectProvider, ProjectInfo projectInfo, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException;
	/**
	 * @param outputStream This is where you write your messages to
	 * @param progressReporter Report any available progress to the progressReporter
	 * @return true if there are more messages, false if there are no more
	 * @throws IOException
	 * @throws SerializerException 
	 */
	boolean writeMessage(OutputStream outputStream, ProgressReporter progressReporter) throws IOException, SerializerException;
}