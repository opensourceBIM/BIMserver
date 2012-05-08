package org.bimserver.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ClassDefinition {
	@XmlAttribute(name="name")
	private String name;

	@XmlAttribute(name="include")
	private boolean include = true;

	@XmlAttribute(name="followInverses")
	private boolean followInverses = false;
	
	@XmlAttribute(name="followNonInverses")
	private boolean followNonInverses = true;
	
	@XmlAttribute(name="origin")
	private String origin;
	
	@XmlElement(name="FieldDefinition")
	private List<FieldDefinition> fieldDefinitions = new ArrayList<FieldDefinition>();

	public ClassDefinition() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}

	public boolean isInclude() {
		return include;
	}

	public void setInclude(boolean include) {
		this.include = include;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public boolean isFollowNonInverses() {
		return followNonInverses;
	}

	public void setFollowNonInverses(boolean followNonInverses) {
		this.followNonInverses = followNonInverses;
	}

	public boolean isFollowInverses() {
		return followInverses;
	}

	public void setFollowInverses(boolean followInverses) {
		this.followInverses = followInverses;
	}
}
