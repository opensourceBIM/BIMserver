package org.bimserver.interfaces.objects;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/
import javax.xml.bind.annotation.XmlTransient;
import java.util.UUID;
import org.bimserver.shared.meta.*;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class SServiceParameter implements SBase
{

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String doc;
	private SServiceType type;
	private SServiceType genericType;
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SServiceParameter.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("doc")) {
			return getDoc();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("genericType")) {
			return getGenericType();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("doc")) {
			setDoc((String)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((SServiceType)val);
			return;
		}
		if (sField.getName().equals("genericType")) {
			setGenericType((SServiceType)val);
			return;
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}
	
	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getDoc() {
		return doc;
	}

	public void setDoc(java.lang.String doc) {
		this.doc = doc;
	}
	
	public SServiceType getType() {
		return type;
	}

	public void setType(SServiceType type) {
		this.type = type;
	}
	
	
	public SServiceType getGenericType() {
		return genericType;
	}

	public void setGenericType(SServiceType genericType) {
		this.genericType = genericType;
	}
	
	
}