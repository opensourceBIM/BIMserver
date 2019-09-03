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
public class SServiceInterface implements SBase
{

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String nameSpace;
	private java.lang.String simpleName;
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SServiceInterface.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("nameSpace")) {
			return getNameSpace();
		}
		if (sField.getName().equals("simpleName")) {
			return getSimpleName();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("nameSpace")) {
			setNameSpace((String)val);
			return;
		}
		if (sField.getName().equals("simpleName")) {
			setSimpleName((String)val);
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
	
	public java.lang.String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(java.lang.String nameSpace) {
		this.nameSpace = nameSpace;
	}
	
	public java.lang.String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(java.lang.String simpleName) {
		this.simpleName = simpleName;
	}
	
}