package org.bimserver.interfaces.objects;

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SDatabaseInformationCategory implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("DatabaseInformationCategory");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("title", java.lang.String.class));
		sClass.addField(new SField("items", SDatabaseInformationItem.class, true));
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
		if (sField.getName().equals("title")) {
			return getTitle();
		}
		if (sField.getName().equals("items")) {
			return getItems();
		}
		if (sField.getName().equals("oid")) {
			return getOid();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String title;
	private List<SDatabaseInformationItem> items = new ArrayList<SDatabaseInformationItem>();
	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public List<SDatabaseInformationItem> getItems() {
		return items;
	}

	public void setItems(List<SDatabaseInformationItem> items) {
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
		SDatabaseInformationCategory other = (SDatabaseInformationCategory) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
}