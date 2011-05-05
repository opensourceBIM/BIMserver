package org.bimserver.shared;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class SDownloadResult {
	@XmlMimeType("application/octet-stream")
	private DataHandler file;

	@XmlElement	
	private String projectName;
	
	@XmlElement
	private int revisionNr;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getRevisionNr() {
		return revisionNr;
	}

	public void setRevisionNr(int revisionNr) {
		this.revisionNr = revisionNr;
	}

	public DataHandler getFile() {
		return file;
	}

	public void setFile(DataHandler ifcFile) {
		this.file = ifcFile;
	}
}