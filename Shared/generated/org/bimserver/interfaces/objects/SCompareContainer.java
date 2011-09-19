package org.bimserver.interfaces.objects;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.bimserver.shared.meta.SBase;
import org.bimserver.shared.meta.SClass;
import org.bimserver.shared.meta.SField;

@XmlRootElement
public class SCompareContainer implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("CompareContainer");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("type", java.lang.String.class));
		sClass.addField(new SField("items", SCompareItem.class, true));
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
	private java.lang.String type;
	private List<SCompareItem> items = new ArrayList<SCompareItem>();
	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}
	public List<SCompareItem> getItems() {
		return items;
	}

	public void setItems(List<SCompareItem> items) {
		this.items = items;
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
		SCompareContainer other = (SCompareContainer) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}