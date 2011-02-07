package org.bimserver.shared;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

public class DatabaseInformation {
	private int numberOfProjects;
	private int numberOfUsers;
	private int numberOfRevisions;
	private int numberOfCheckouts;
	private long databaseSizeInBytes;
	private String type;
	private Date created;
	private final Map<String, Map<String, String>> genericLines = new TreeMap<String, Map<String, String>>();
	private String location;
	private int schemaVersion;

	public long getDatabaseSizeInBytes() {
		return databaseSizeInBytes;
	}

	public void setDatabaseSizeInBytes(long databaseSizeInBytes) {
		this.databaseSizeInBytes = databaseSizeInBytes;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void addGenericLine(String title, String key, String value) {
		if (!genericLines.containsKey(title)) {
			genericLines.put(title, new HashMap<String, String>());
		}
		genericLines.get(title).put(key, value);
	}
	
	public Map<String, Map<String, String>> getGenericLines() {
		return genericLines;
	}

	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public int getSchemaVersion() {
		return schemaVersion;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getCreated() {
		return created;
	}
}