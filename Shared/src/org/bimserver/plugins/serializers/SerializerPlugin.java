package org.bimserver.plugins.serializers;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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

import java.util.Set;

import org.bimserver.emf.Schema;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.PluginConfiguration;

public interface SerializerPlugin extends Plugin {
	public static final String EXTENSION = "Extension";
	public static final String ZIP_EXTENSION = "ZipExtension";
	public static final String CONTENT_TYPE = "ContentType";

	/**
	 * @return A serializer
	 */
	Serializer createSerializer(PluginConfiguration plugin);

	/**
	 * @return Whether this plugin will be needing geometry
	 */
	boolean needsGeometry();
	
	/**
	 * @return The schema supported by this serializer
	 */
	Set<Schema> getSupportedSchemas();
}