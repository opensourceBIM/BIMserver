package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SDatabaseInformation implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("DatabaseInformation");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("numberOfProjects", int.class));
		sClass.addField(new SField("numberOfUsers", int.class));
		sClass.addField(new SField("numberOfRevisions", int.class));
		sClass.addField(new SField("numberOfCheckouts", int.class));
		sClass.addField(new SField("databaseSizeInBytes", long.class));
		sClass.addField(new SField("type", java.lang.String.class));
		sClass.addField(new SField("created", java.util.Date.class));
		sClass.addField(new SField("location", java.lang.String.class));
		sClass.addField(new SField("schemaVersion", int.class));
		sClass.addField(new SField("genericLines", java.lang.String.class));
	}
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	public SClass getSClass() {
		return sClass;
	}
	private int numberOfProjects;
	private int numberOfUsers;
	private int numberOfRevisions;
	private int numberOfCheckouts;
	private long databaseSizeInBytes;
	private java.lang.String type;
	private java.util.Date created;
	private java.lang.String location;
	private int schemaVersion;
	private java.lang.String genericLines;
	public int getNumberOfProjects() {
		return numberOfProjects;
	}

	public void setNumberOfProjects(int numberOfProjects) {
		this.numberOfProjects = numberOfProjects;
	}
	public int getNumberOfUsers() {
		return numberOfUsers;
	}

	public void setNumberOfUsers(int numberOfUsers) {
		this.numberOfUsers = numberOfUsers;
	}
	public int getNumberOfRevisions() {
		return numberOfRevisions;
	}

	public void setNumberOfRevisions(int numberOfRevisions) {
		this.numberOfRevisions = numberOfRevisions;
	}
	public int getNumberOfCheckouts() {
		return numberOfCheckouts;
	}

	public void setNumberOfCheckouts(int numberOfCheckouts) {
		this.numberOfCheckouts = numberOfCheckouts;
	}
	public long getDatabaseSizeInBytes() {
		return databaseSizeInBytes;
	}

	public void setDatabaseSizeInBytes(long databaseSizeInBytes) {
		this.databaseSizeInBytes = databaseSizeInBytes;
	}
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.util.Date getCreated() {
		return created;
	}

	public void setCreated(java.util.Date created) {
		this.created = created;
	}
	public java.lang.String getLocation() {
		return location;
	}

	public void setLocation(java.lang.String location) {
		this.location = location;
	}
	public int getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public java.lang.String getGenericLines() {
		return genericLines;
	}

	public void setGenericLines(java.lang.String genericLines) {
		this.genericLines = genericLines;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (oid ^ (oid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SDatabaseInformation other = (SDatabaseInformation) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}