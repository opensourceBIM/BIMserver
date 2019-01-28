package org.bimserver.validationreport;

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

import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import org.bimserver.emf.IdEObject;

public class ValidationMetaData {

	private IdEObject ifcProject;
	private String remoteReference;
	private XMLGregorianCalendar fileDate;
	private String fileName;

	public void setIfcProject(IdEObject ifcProject) {
		this.ifcProject = ifcProject;
	}
	
	public IdEObject getIfcProject() {
		return ifcProject;
	}

	public void setFileDate(XMLGregorianCalendar fileDate) {
		this.fileDate = fileDate;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setRemoteReference(String remoteReference) {
		this.remoteReference = remoteReference;
	}
	
	public String getFileName() {
		return fileName;
	}

	public XMLGregorianCalendar getFileDate() {
		return fileDate;
	}

	public String getRemoteReference() {
		return remoteReference;
	}
}
