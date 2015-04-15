package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.Query.Deep;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.Revision;

public class DownloadParameters extends LongActionKey {
	public enum DownloadType {
		DOWNLOAD_REVISION, DOWNLOAD_BY_OIDS, DOWNLOAD_BY_GUIDS, DOWNLOAD_OF_TYPE, DOWNLOAD_PROJECTS, DOWNLOAD_COMPARE, DOWNLOAD_QUERY, DOWNLOAD_BY_NAMES, DOWNLOAD_JSON_QUERY
	};

	private final DownloadType downloadType;
	private final BimServer bimServer;

	private Set<Long> roids;
	private boolean includeAllSubtypes;
	private Set<Long> oids;
	private Set<String> guids;
	private Set<String> names;
	private String jsonQuery;
	private Set<String> classNames;
	private long modelCompareIdentifier;
	private CompareType compareType;
	private long ignoreUoid = -1;
	private String code;
	private long qeid;
	private long serializerOid;
	private boolean useObjectIDM;
	private Deep deep;
	private String schema;

	public DownloadParameters(BimServer bimServer, DownloadType downloadType) {
		this.bimServer = bimServer;
		this.downloadType = downloadType;
	}
	
	public void setSerializerOid(long serializerOid) {
		this.serializerOid = serializerOid;
	}
	
	public long getSerializerOid() {
		return serializerOid;
	}

	public long getIgnoreUoid() {
		return ignoreUoid;
	}

	public void setCompareType(CompareType compareType) {
		this.compareType = compareType;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	public void setNames(Set<String> names) {
		this.names = names;
	}

	public void setJsonQuery(String jsonQuery) {
		this.jsonQuery = jsonQuery;
	}
	
	public String getId() {
		// TODO the ID is used to determine the name on disk, no equals check can be done as the original DownloadParameter object is not available, 
		// therefore (not easily recognizable) collisions might occur. Better to just write all data to a string and maybe hash with a bigger key size than 'int'
		return String.valueOf(((long) hashCode()) + (long) Integer.MAX_VALUE);
	}

	public Set<Long> getRoids() {
		return roids;
	}

	public void setRoids(Set<Long> roids) {
		this.roids = roids;
	}

	public Long getRoid() {
		if (roids == null) {
			return null;
		}
		Iterator<Long> iterator = roids.iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}

	public void setRoid(Long roid) {
		this.roids = new HashSet<Long>();
		roids.add(roid);
	}

	public Set<Long> getOids() {
		return oids;
	}

	public void setOids(Set<Long> oids) {
		this.oids = oids;
	}

	public long getModelCompareIdentifier() {
		return modelCompareIdentifier;
	}

	public CompareType getCompareType() {
		return compareType;
	}

	public Set<String> getGuids() {
		return guids;
	}

	public void setGuids(Set<String> guids) {
		this.guids = guids;
	}

	public Set<String> getClassNames() {
		return classNames;
	}

	public void setClassNames(Set<String> classNames) {
		this.classNames = classNames;
	}

	public DownloadType getDownloadType() {
		return downloadType;
	}

	private String getRoidsString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Long roid : roids) {
			sb.append(roid + "-");
			i++;
			if (i > 5) {
				break;
			}
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

	private String getOidsString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Long oid : oids) {
			sb.append(oid + "-");
			i++;
			if (i > 5) {
				break;
			}
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

	private String getGuidsString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (String guid : guids) {
			sb.append(guid + "-");
			i++;
			if (i > 5) {
				break;
			}
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

	/*
	 * Changed the .hashCode methods on the enums to .name() (which is consistent between JVM restarts)
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classNames == null) ? 0 : classNames.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((compareType == null) ? 0 : compareType.name().hashCode());
		result = prime * result + ((deep == null) ? 0 : deep.hashCode());
		result = prime * result + ((downloadType == null) ? 0 : downloadType.name().hashCode());
		result = prime * result + ((guids == null) ? 0 : guids.hashCode());
		result = prime * result + (int) (ignoreUoid ^ (ignoreUoid >>> 32));
		result = prime * result + (includeAllSubtypes ? 1231 : 1237);
		result = prime * result + ((jsonQuery == null) ? 0 : jsonQuery.hashCode());
		result = prime * result + (int) (modelCompareIdentifier ^ (modelCompareIdentifier >>> 32));
		result = prime * result + ((names == null) ? 0 : names.hashCode());
		result = prime * result + ((oids == null) ? 0 : oids.hashCode());
		result = prime * result + (int) (qeid ^ (qeid >>> 32));
		result = prime * result + ((roids == null) ? 0 : roids.hashCode());
		result = prime * result + (int) (serializerOid ^ (serializerOid >>> 32));
		result = prime * result + (useObjectIDM ? 1231 : 1237);
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
		DownloadParameters other = (DownloadParameters) obj;
		if (classNames == null) {
			if (other.classNames != null)
				return false;
		} else if (!classNames.equals(other.classNames))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (compareType != other.compareType)
			return false;
		if (deep != other.deep)
			return false;
		if (downloadType != other.downloadType)
			return false;
		if (guids == null) {
			if (other.guids != null)
				return false;
		} else if (!guids.equals(other.guids))
			return false;
		if (ignoreUoid != other.ignoreUoid)
			return false;
		if (includeAllSubtypes != other.includeAllSubtypes)
			return false;
		if (jsonQuery == null) {
			if (other.jsonQuery != null)
				return false;
		} else if (!jsonQuery.equals(other.jsonQuery))
			return false;
		if (modelCompareIdentifier != other.modelCompareIdentifier)
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (oids == null) {
			if (other.oids != null)
				return false;
		} else if (!oids.equals(other.oids))
			return false;
		if (qeid != other.qeid)
			return false;
		if (roids == null) {
			if (other.roids != null)
				return false;
		} else if (!roids.equals(other.roids))
			return false;
		if (serializerOid != other.serializerOid)
			return false;
		if (useObjectIDM != other.useObjectIDM)
			return false;
		return true;
	}

	private String getNamesString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (String name : names) {
			sb.append(name + "-");
			i++;
			if (i > 5) {
				break;
			}
		}
		if (sb.length() > 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}
	
	public String getFileName() {
		String extension = bimServer.getSerializerFactory().getExtension(serializerOid);
		return getFileNameWithoutExtension() + "." + extension;
	}

	public String getFileNameWithoutExtension() {
		switch (downloadType) {
		case DOWNLOAD_REVISION:
			return getRoidsString();
		case DOWNLOAD_BY_GUIDS:
			return getRoidsString() + "-" + getGuidsString();
		case DOWNLOAD_BY_NAMES:
			return getRoidsString() + "-" + getNamesString();
		case DOWNLOAD_BY_OIDS:
			return getRoidsString() + "-" + getOidsString();
		case DOWNLOAD_OF_TYPE:
			return getRoidsString() + "-" + classNames;
		case DOWNLOAD_PROJECTS:
			DatabaseSession session = bimServer.getDatabase().createSession();
			StringBuilder fileName = new StringBuilder();
			for (long roid : roids) {
				Revision revision;
				try {
					revision = session.get(session.getEClassForName("store", "Revision"), roid, Query.getDefault());
					for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
						fileName.append(concreteRevision.getProject().getName() + "-");
					}
				} catch (BimserverDatabaseException e) {
					e.printStackTrace();
				}
			}
			fileName.delete(fileName.length() - 1, fileName.length());
			return fileName.toString();
		case DOWNLOAD_COMPARE:
			return "compare";
		case DOWNLOAD_JSON_QUERY:
			return getRoidsString();
		case DOWNLOAD_QUERY:
			return "query";
		}
		return "unknown";
	}
	
	public boolean isIncludeAllSubtypes() {
		return includeAllSubtypes;
	}

	public void setIncludeAllSubtypes(boolean includeAllSubtypes) {
		this.includeAllSubtypes = includeAllSubtypes;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public long getQeid() {
		return qeid;
	}

	public void setQeid(long qeid) {
		this.qeid = qeid;
	}

	public void setModelCompareIdentifier(long modelCompareIdentifier) {
		this.modelCompareIdentifier = modelCompareIdentifier;
	}

	public boolean getUseObjectIDM() {
		return useObjectIDM;
	}
	
	public void setUseObjectIDM(Boolean useObjectIDM) {
		this.useObjectIDM = useObjectIDM;
	}

	public Deep getDeep() {
		return deep;
	}

	public void setDeep(Deep deep) {
		this.deep = deep;
	}
	
	public Set<String> getNames() {
		return names;
	}

	public String getJsonQuery() {
		return jsonQuery;
	}

	public String getSchema() {
		return schema;
	}
}