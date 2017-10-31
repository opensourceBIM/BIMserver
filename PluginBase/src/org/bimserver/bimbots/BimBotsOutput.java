package org.bimserver.bimbots;

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
