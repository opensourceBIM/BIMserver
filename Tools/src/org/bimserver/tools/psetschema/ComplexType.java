package org.bimserver.tools.psetschema;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.bimserver.tools.ifctocsv.PropertyDef;
import org.bimserver.tools.ifctocsv.PropertyDef.ValueDef;
import org.bimserver.tools.ifctocsv.PropertyType;
import org.bimserver.tools.ifctocsv.PropertyType.TypeComplexProperty;

public class ComplexType extends PropertyTypeDefinition {

	private TypeComplexProperty typeComplexProperty;
	private List<PropertyDefinition> properties = new ArrayList<PropertyDefinition>();

	public ComplexType(TypeComplexProperty typeComplexProperty) {
		this.typeComplexProperty = typeComplexProperty;
	}

	public List<PropertyDefinition> getProperties() {
		return properties;
	}
	
	@Override
	public String toString() {
		for (PropertyDef propertyDef : typeComplexProperty.getPropertyDef()) {
			PropertyDefinition propertyDefinition = new PropertyDefinition();
			for (JAXBElement<?> el : propertyDef.getNameOrValueDefOrDefinition()) {
				Object val = el.getValue();
				if (val instanceof PropertyType) {
					PropertyType propertyType = (PropertyType) val;
					if (propertyType.getTypeComplexProperty() != null) {
						propertyDefinition.setType(new ComplexType(propertyType.getTypeComplexProperty()));
					} else if (propertyType.getTypePropertyBoundedValue() != null) {
						propertyDefinition.setType(new BoundedValue(propertyType.getTypePropertyBoundedValue()));
					} else if (propertyType.getTypePropertyEnumeratedValue() != null) {
						propertyDefinition.setType(new EnumeratedValue(propertyType.getTypePropertyEnumeratedValue()));
					} else if (propertyType.getTypePropertyListValue() != null) {
						propertyDefinition.setType(new ListValue(propertyType.getTypePropertyListValue().getListValue()));
					} else if (propertyType.getTypePropertyReferenceValue() != null) {
						propertyDefinition.setType(new ReferenceValue(propertyType.getTypePropertyReferenceValue()));
					} else if (propertyType.getTypePropertySingleValue() != null) {
						propertyDefinition.setType(new SingleValue(propertyType.getTypePropertySingleValue()));
					} else if (propertyType.getTypePropertyTableValue() != null) {
						propertyDefinition.setType(new TableValue(propertyType.getTypePropertyTableValue()));
					}
				} else if (val instanceof String) {
					String str = (String) val;
					if (el.getName().toString().equals("Name")) {
						propertyDefinition.setName(str);
					} else if (el.getName().toString().equals("Definition")) {
						propertyDefinition.setDefinition(str);
					} else {
						System.out.println(el.getName().toString());
					}
				} else if (val instanceof ValueDef) {
//					ValueDef valueDef = (ValueDef) val;
					if (el.getName().toString().equals("ValueDef")) {

					} else {
						System.out.println(el.getName().toString());
					}
				} else {
					System.out.println(el.getName().toString());
				}
			}
			properties.add(propertyDefinition);
		}
		return "complex: " + typeComplexProperty.getName();
	}
}