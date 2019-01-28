package org.bimserver.plugins.deserializers;

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

import java.io.InputStream;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;

public interface Deserializer {
	/**
	 * Initialize this deserializer with the given model meta data
	 * 
	 * @param packageMetaData
	 */
	void init(PackageMetaData packageMetaData);

	/**
	 * Deserialize a stream to a model.
	 * 
	 * @param inputStream The inputstream
	 * @param fileName Name of the "file". This will usually be the original filename of the file, if there even was a file. This is mainly used to determine the content of the file, for example when uploaden IFC-ZIP files
	 * @param fileSize File size of the original file, some deserializers use this to determine memory allocations strategies
	 * @param progressReporter An interface you can report progress to
	 * @return The deserialized model
	 * @throws DeserializeException
	 */
	IfcModelInterface read(InputStream inputStream, String fileName, long fileSize, ByteProgressReporter progressReporter) throws DeserializeException;
}