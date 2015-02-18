package org.bimserver.plugins.deserializers;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

	public IfcModelInterface read(InputStream in, String filename, long fileSize) throws DeserializeException {
		return read(in, filename, fileSize, null);
	}
	
	@Override
	public IfcModelInterface read(File file, ByteProgressReporter progressReporter) throws DeserializeException {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(file);
			try {
				return read(fileInputStream, file.getName(), file.length(), progressReporter);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			throw new DeserializeException(e);
		}
	}
	
	public IfcModelInterface read(File file) throws DeserializeException {
		return read(file, null);
	}
}