package org.bimserver.shared;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.NONE)
public class Addition {

	@XmlElement
	private Long oid;
	
	@XmlElement
	private String className;
	
	@XmlElements( { 
		@XmlElement(name = "AttributeReferencePair", type = AttributeReferencePair.class),
		@XmlElement(name = "AttributeNewReferencePair", type = AttributeNewReferencePair.class),
		@XmlElement(name = "AttributeValuePair", type = AttributeValuePair.class),
		@XmlElement(name = "AttributeList", type = AttributeList.class)})
	private List<AbstractAttributeValuePair> attributes = new ArrayList<AbstractAttributeValuePair>();

	public Addition() {
	}

	public Addition(String className) {
		this.className = className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setAttributes(List<AbstractAttributeValuePair> attributes) {
		this.attributes = attributes;
	}

	public String getClassName() {
		return className;
	}

	public List<AbstractAttributeValuePair> getAttributes() {
		return attributes;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public Addition addAttribute(AbstractAttributeValuePair attributeValuePair) {
		attributes.add(attributeValuePair);
		return this;
	}
}