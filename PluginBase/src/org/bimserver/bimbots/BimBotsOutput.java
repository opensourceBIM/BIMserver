package org.bimserver.bimbots;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import org.bimserver.plugins.SchemaName;

public class BimBotsOutput {
	private String schemaName;
	private byte[] data;
	private String contentDisposition;
	private String contentType;
	private String title;

	public BimBotsOutput(SchemaName schemaName, byte[] data) {
		this.schemaName = schemaName.name();
		this.data = data;
	}
	
	public BimBotsOutput(String schemaName, byte[] data) {
		this.schemaName = schemaName;
		this.data = data;
	}
	
	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public String getContentType() {
		return contentType;
	}

	public String getTitle() {
		return title;
	}
	
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
