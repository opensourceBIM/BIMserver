package org.bimserver.emf;

import java.util.Date;

public class ModelMetaData {
	private String authorizedUser;
	private String name;
	private byte[] checksum;
	private Date date;
	private int revisionId;

	public String getAuthorizedUser() {
		return authorizedUser;
	}

	public void setAuthorizedUser(String authorizedUser) {
		this.authorizedUser = authorizedUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getChecksum() {
		return checksum;
	}

	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(int revisionId) {
		this.revisionId = revisionId;
	}
}