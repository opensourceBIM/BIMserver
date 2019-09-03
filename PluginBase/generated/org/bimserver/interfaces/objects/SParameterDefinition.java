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
public class SParameterDefinition implements SBase
{

	@XmlTransient
	private static SClass sClass;
	private java.lang.String name;
	private java.lang.String identifier;
	private boolean required;
	private java.lang.String description;
	private STypeDefinition type;
	private SType defaultValue;
	
	@XmlTransient
	public SClass getSClass() {
		return sClass;
	}
	
	public static void setSClass(SClass sClass) {
		SParameterDefinition.sClass = sClass;
	}

	public Object sGet(SField sField) {
		if (sField.getName().equals("name")) {
			return getName();
		}
		if (sField.getName().equals("identifier")) {
			return getIdentifier();
		}
		if (sField.getName().equals("required")) {
			return isRequired();
		}
		if (sField.getName().equals("description")) {
			return getDescription();
		}
		if (sField.getName().equals("type")) {
			return getType();
		}
		if (sField.getName().equals("defaultValue")) {
			return getDefaultValue();
		}
		throw new RuntimeException("Field " + sField.getName() + " not found");
	}

	public void sSet(SField sField, Object val) {
		if (sField.getName().equals("name")) {
			setName((String)val);
			return;
		}
		if (sField.getName().equals("identifier")) {
			setIdentifier((String)val);
			return;
		}
		if (sField.getName().equals("required")) {
			setRequired((Boolean)val);
			return;
		}
		if (sField.getName().equals("description")) {
			setDescription((String)val);
			return;
		}
		if (sField.getName().equals("type")) {
			setType((STypeDefinition)val);
			return;
		}
		if (sField.getName().equals("defaultValue")) {
			setDefaultValue((SType)val);
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
	
	public java.lang.String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}
	
	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	
	public STypeDefinition getType() {
		return type;
	}

	public void setType(STypeDefinition type) {
		this.type = type;
	}
	
	
	public SType getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(SType defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
}