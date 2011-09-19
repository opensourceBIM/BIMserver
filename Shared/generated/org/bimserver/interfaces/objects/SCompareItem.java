package org.bimserver.interfaces.objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SCompareItem implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("CompareItem");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("dataObjectId", SDataObject.class));
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
	private SDataObject dataObject;
	public SDataObject getDataObject() {
		return dataObject;
	}

	public void setDataObject(SDataObject dataObject) {
		this.dataObject = dataObject;
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
		SCompareItem other = (SCompareItem) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}