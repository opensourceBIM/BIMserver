package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.util.*;
import javax.xml.bind.annotation.*;
import org.bimserver.shared.meta.*;
import javax.activation.DataHandler;

@XmlRootElement
public class SDatabaseInformationCategory implements SBase
{
	private long oid;
	private static final SClass sClass = new SClass("SDatabaseInformationCategory");
	
	static {
		sClass.addField(new SField("oid", long.class));
		sClass.addField(new SField("title", java.lang.String.class));
		sClass.addField(new SField("items", SDatabaseInformationItem.class, true));
		SPackage.getInstance().addSClass(sClass);

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

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("title")) {
			setTitle((String)val);
			return;
		}
		if (sField.getName().equals("items")) {
			setItems((List<SDatabaseInformationItem>)val);
			return;
		}
		if (sField.getName().equals("oid")) {
			setOid((Long)val);
			return;
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