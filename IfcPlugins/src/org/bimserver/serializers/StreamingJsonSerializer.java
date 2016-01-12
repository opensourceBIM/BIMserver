package org.bimserver.serializers;

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

import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.SharedJsonStreamingSerializer;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.PluginManagerInterface;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingSerializer;

public class StreamingJsonSerializer implements StreamingSerializer {

	private ObjectProvider objectProvider;
	private ProjectInfo projectInfo;
	private IfcHeader ifcHeader;
	private PluginManagerInterface pluginManager;
	private PackageMetaData packageMetaData;

	@Override
	public void init(ObjectProvider objectProvider, ProjectInfo projectInfo, IfcHeader ifcHeader, PluginManagerInterface pluginManager, PackageMetaData packageMetaData) throws SerializerException {
		this.objectProvider = objectProvider;
		this.projectInfo = projectInfo;
		this.ifcHeader = ifcHeader;
		this.pluginManager = pluginManager;
		this.packageMetaData = packageMetaData;
	}

	@Override
	public void writeToOutputStream(OutputStream outputStream) throws SerializerException, BimserverDatabaseException {
		SharedJsonStreamingSerializer sharedJsonStreamingSerializer = new SharedJsonStreamingSerializer(objectProvider, ifcHeader, true);
		
		boolean result = sharedJsonStreamingSerializer.write(outputStream);
		while (result) {
			result = sharedJsonStreamingSerializer.write(outputStream);
		}
	}

	@Override
	public InputStream getInputStream() {
		return null;
	}
}