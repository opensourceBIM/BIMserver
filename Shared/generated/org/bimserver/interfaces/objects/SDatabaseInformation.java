package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

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
		sClass.addField(new SField("categories", SDatabaseInformationCategory.class, true));
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
	
	public Object sGet(SField sField) {
		if (sField.getName().equals("numberOfProjects")) {
			return getNumberOfProjects();
		}
		if (sField.getName().equals("numberOfUsers")) {
			return getNumberOfUsers();
		}
		if (sField.getName().equals("numberOfRevisions")) {
			return getNumberOfRevisions();
		}
		if (sField.getName().equals("numberOfCheckouts")) {
			return getNumberOfCheckouts();
		}
		if (sField.getName().equals("databaseSizeInBytes")) {
			return getDatabaseSizeInBytes();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("created")) {
			return getCreated();
		}
		if (sField.getName().equals("location")) {
			return getLocation();
		}
		if (sField.getName().equals("schemaVersion")) {
			return getSchemaVersion();
		}
		if (sField.getName().equals("categories")) {
			return getCategories();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
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
	private List<SDatabaseInformationCategory> categories = new ArrayList<SDatabaseInformationCategory>();
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
	public List<SDatabaseInformationCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SDatabaseInformationCategory> categories) {
		this.categories = categories;
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