package org.bimserver.emf;

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

import java.util.Date;

import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.models.store.IfcHeader;

public class ModelMetaData {
	private String authorizedUser;
	private String name;
	private byte[] checksum;
	private Date date;
	private int revisionId;
	private IfcHeader ifcHeader;
	private SVector3f minBounds;
	private SVector3f maxBounds;

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

	public IfcHeader getIfcHeader() {
		return ifcHeader;
	}
	
	public void setIfcHeader(IfcHeader ifcHeader) {
		this.ifcHeader = ifcHeader;
	}

	public SVector3f getMinBounds() {
		return minBounds;
	}

	public void setMinBounds(SVector3f minBounds) {
		this.minBounds = minBounds;
	}

	public SVector3f getMaxBounds() {
		return maxBounds;
	}

	public void setMaxBounds(SVector3f maxBounds) {
		this.maxBounds = maxBounds;
	}
}