package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SCheckinResult implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("CheckinResult");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("revisionId", long.class));
		sClass.addField(new SField("rid", int.class));
		sClass.addField(new SField("projectId", long.class));
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
	private long revisionId;
	private int rid;
	private long projectId;
	public long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(long revisionId) {
		this.revisionId = revisionId;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
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
		SCheckinResult other = (SCheckinResult) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}