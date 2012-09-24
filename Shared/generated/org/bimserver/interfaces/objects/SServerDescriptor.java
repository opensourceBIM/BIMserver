package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import javax.xml.bind.annotation.XmlTransient;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SServerDescriptor implements SBase
{

	@XmlTransient
	private static SClass sClass;
	
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SServerDescriptor.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("title")) {
			return getTitle();
		}
		if (sField.getName().equals("url")) {
			return getUrl();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("title")) {
			setTitle((String)val);
			return;
		}
		if (sField.getName().equals("url")) {
			setUrl((String)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	private java.lang.String title;
	private java.lang.String url;
	private java.lang.String description;
	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getUrl() {
		return url;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
}