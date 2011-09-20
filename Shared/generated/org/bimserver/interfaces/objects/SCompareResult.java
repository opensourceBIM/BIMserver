package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SCompareResult implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("CompareResult");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("items", SCompareContainer.class, true));
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
		if (sField.getName().equals("items")) {
			return getItems();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private List<SCompareContainer> items = new ArrayList<SCompareContainer>();
	public List<SCompareContainer> getItems() {
		return items;
	}

	public void setItems(List<SCompareContainer> items) {
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
		SCompareResult other = (SCompareResult) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}