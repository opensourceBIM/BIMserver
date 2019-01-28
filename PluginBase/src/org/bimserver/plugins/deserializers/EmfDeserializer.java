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

public abstract class EmfDeserializer implements Deserializer {

	private PackageMetaData packageMetaData;
	
	public void init(PackageMetaData packageMetaData) {
		this.packageMetaData = packageMetaData;
	}

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public abstract IfcModelInterface read(InputStream in, String filename, long fileSize, ByteProgressReporter progressReporter) throws DeserializeException;

//	public IfcModelInterface read(InputStream in, String filename, long fileSize) throws DeserializeException {
//		return read(in, filename, fileSize, null);
//	}
//	
//	@Override
//	public IfcModelInterface read(Path file, ByteProgressReporter progressReporter) throws DeserializeException {
//		try (FileInputStream fileInputStream = new FileInputStream(file.toFile())) {
//			return read(fileInputStream, file.getFileName().toString(), file.toFile().length(), progressReporter);
//		} catch (IOException e) {
//			throw new DeserializeException(e);
//		}
//	}
//	
//	public IfcModelInterface read(Path file) throws DeserializeException {
//		return read(file, null);
//	}
}