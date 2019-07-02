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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EmfSerializer implements Serializer, StreamingReader {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializer.class);
	protected IfcModelInterface model;
	private Mode mode = Mode.HEADER;
	private ProjectInfo projectInfo;
	private boolean normalizeOids;
	private long expressIdCounter = 1;

	protected static enum Mode {
		HEADER, BODY, FOOTER, FINISHED
	}

	public void init(IfcModelInterface model, ProjectInfo projectInfo, boolean normalizeOids) throws SerializerException {
		this.model = model;
		this.projectInfo = projectInfo;
		this.normalizeOids = normalizeOids;
	}
	
	public PackageMetaData getPackageMetaData() {
		return model.getPackageMetaData();
	}
	
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	protected Mode getMode() {
		return mode;
	}

	public boolean isNormalizeOids() {
		return normalizeOids;
	}
	
	protected void setMode(Mode mode) {
		this.mode = mode;
	}

	protected long getExpressId(IdEObject object) {
		if (normalizeOids && object.getExpressId() == -1) {
			((IdEObjectImpl)object).setExpressId(expressIdCounter ++);
		}
		return object.getExpressId();
	}
	
	public byte[] getBytes() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			writeToOutputStream(outputStream, null);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return outputStream.toByteArray();
	}

	public InputStream getInputStream() throws IOException {
		return new SerializerInputstream(this);
	}

	/*
	 * The serializer must implement this method and write data to the
	 * outputstream. This call can be called multiple times by the BIMserver.
	 * The implementation must return true when data has been written, or false
	 * when no data has been written (this will stop the serialization).
	 */
	protected abstract boolean write(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException;

	public void writeToOutputStream(OutputStream outputStream, ProgressReporter progressReporter) throws SerializerException {
		boolean result = write(outputStream, progressReporter);
		while (result) {
			result = write(outputStream, progressReporter);
		}
		if(progressReporter!=null) progressReporter.update(1, 1);
	}

	public void writeToFile(Path file, ProgressReporter progressReporter) throws SerializerException {
		try {
			OutputStream outputStream = Files.newOutputStream(file);
			try {
				writeToOutputStream(outputStream, progressReporter);
			} finally {
				outputStream.close();
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public IfcModelInterface getModel() {
		return model;
	}

	@Override
	public boolean write(OutputStream out) {
		try {
			return write(out, null);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return false;
	}
}