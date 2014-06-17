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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class EmfSerializer implements Serializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmfSerializer.class);
	protected IfcModelInterface model;
	private Mode mode;
	private ProjectInfo projectInfo;
	private PluginManager pluginManager;
	private RenderEnginePlugin renderEnginePlugin;
	private boolean normalizeOids;
	private int expressIdCounter = 1;
	private PackageMetaData packageMetaData;

	protected static enum Mode {
		HEADER, BODY, FOOTER, FINISHED
	}

	public void init(IfcModelInterface model, ProjectInfo projectInfo, PluginManager pluginManager, RenderEnginePlugin renderEnginePlugin, PackageMetaData packageMetaData, boolean normalizeOids) throws SerializerException {
		this.model = model;
		this.projectInfo = projectInfo;
		this.renderEnginePlugin = renderEnginePlugin;
		this.packageMetaData = packageMetaData;
		this.normalizeOids = normalizeOids;
		this.pluginManager = pluginManager;
		reset();
	}

	public PackageMetaData getPackageMetaData() {
		return packageMetaData;
	}
	
	public RenderEnginePlugin getRenderEnginePlugin() {
		return renderEnginePlugin;
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

	protected int getExpressId(IdEObject object) {
		if (normalizeOids && object.getExpressId() == -1) {
			((IdEObjectImpl)object).setExpressId(expressIdCounter ++);
		}
		return object.getExpressId();
	}
	
	public byte[] getBytes() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			writeToOutputStream(outputStream);
		} catch (SerializerException e) {
			LOGGER.error("", e);
		}
		return outputStream.toByteArray();
	}

	public InputStream getInputStream() throws IOException {
		reset();
		return new SerializerInputstream(this);
	}

	/*
	 * The serializer must implement this method and write data to the
	 * outputstream. This call can be called multiple times by the BIMserver.
	 * The implementation must return true when data has been written, or false
	 * when no data has been written (this will stop the serialization).
	 */
	protected abstract boolean write(OutputStream outputStream) throws SerializerException;

	public void writeToOutputStream(OutputStream outputStream) throws SerializerException {
		boolean result = write(outputStream);
		while (result) {
			result = write(outputStream);
		}
	}

	public void writeToFile(File file) throws SerializerException {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			writeToOutputStream(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
	}

	public IfcModelInterface getModel() {
		return model;
	}

	public PluginManager getPluginManager() {
		return pluginManager;
	}
}