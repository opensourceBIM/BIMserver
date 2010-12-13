package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SDownload extends SLogAction
{
	private long oid;
	
	public long getOid() {
		return oid;
	}
	
	public void setOid(long oid) {
		this.oid = oid;
	}
	private long revisionId;
	private java.lang.String type;
	private boolean zipped;
	public long getRevisionId() {
		return revisionId;
	}

	public void setRevisionId(long revisionId) {
		this.revisionId = revisionId;
	}
	

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	public boolean isZipped() {
		return zipped;
	}

	public void setZipped(boolean zipped) {
		this.zipped = zipped;
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
		SDownload other = (SDownload) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}