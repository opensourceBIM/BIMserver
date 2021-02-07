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

import java.io.OutputStream;

import org.bimserver.emf.IfcModelInterface;

/**
 * @author Ruben de Laat
 *	
 * A serializer serializes model data to a stream. Serializers can only be used once (in previous versions they could be use multiple times and had a reset() method).
 */
public interface Serializer extends StreamingReader {
	/**
	 * Initialize this serializer
	 * 
	 * @param model The model that will be serialized
	 * @param projectInfo ProjectInformation that is stored in the BIMserver project
	 * @param normalizeOids Whether to normalize the oids (usually means the oid will be regenerated from 1)
	 * @throws SerializerException
	 */
	void init(IfcModelInterface model, ProjectInfo projectInfo, boolean normalizeOids) throws SerializerException;

	/**
	 * @param outputStream The stream to write to
	 * @param progressReporter An interface you can use to report progress
	 * @throws SerializerException
	 */
	void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException;
	
	/**
	 * @return Whether the results of this serializer can be cached by BIMserver, defaults to true
	 */
	default boolean allowCaching() {
		return true;
	}
}