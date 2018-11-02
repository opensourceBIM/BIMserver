package org.bimserver.validationreport;

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
