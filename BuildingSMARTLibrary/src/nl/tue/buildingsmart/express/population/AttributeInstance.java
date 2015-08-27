package nl.tue.buildingsmart.express.population;

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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.Vector;

import org.bimserver.plugins.schema.ExplicitAttribute;

@SuppressWarnings("all")
public class AttributeInstance {
	private EntityInstance attributeOf;
	private ExplicitAttribute attributeType;
	private Object value;
	private String p21Header = "";

	public final static String REAL = "REAL";
	public final static String ENTITY_INSTANCE_NAME = "ENTITY_INSTANCE_NAME";
	public final static String STRING = "STRING";

	public AttributeInstance() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return attributeType.getName() + ":" + this.getStringValue();
	}

	public EntityInstance getAttributeOf() {
		return attributeOf;
	}

	public void setAttributeOf(EntityInstance attributeOf) {
		this.attributeOf = attributeOf;
	}

	public ExplicitAttribute getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(ExplicitAttribute attributeType) {
		this.attributeType = attributeType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {

		this.value = value;
	}

	public String getStringValue() {
		return this.value.toString();
	}

	/**
	 * @return whether or not this points to one or more entity instances
	 */
	public boolean hasEntityInstanceValue() {
		if (this.value instanceof String) {
			String stringVal = (String) value;
			if (stringVal.startsWith("#"))
				return true;
		}
		if (this.getValue() instanceof Vector) {
			Vector values = (Vector) getValue();
			for (int i = 0; i < values.size(); i++) {
				String stringVal = (String) values.get(i);
				if (stringVal.startsWith("#")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @return returns the Instance value of this attribute, null if no Entity
	 *         Instance if found
	 */
	public EntityInstance getEntityInstanceValue() {
		if (this.value instanceof String) {
			String stringVal = (String) value;
			if (stringVal.startsWith("#")) {
				ModelPopulation pop = this.getAttributeOf().getModel();
				return pop.getEntity(new Integer(stringVal.substring(1, stringVal.length())));
			}

		}
		return null;
	}

	public ArrayList<EntityInstance> getEntityList() {
		ArrayList<EntityInstance> list = new ArrayList<EntityInstance>();
		if (this.getValue() instanceof Vector) {
			Vector values = (Vector) getValue();
			for (int i = 0; i < values.size(); i++) {
				String stringVal = (String) values.get(i);
				if (stringVal.startsWith("#")) {
					ModelPopulation pop = this.getAttributeOf().getModel();
					list.add(pop.getEntity(new Integer(stringVal.substring(1, stringVal.length()))));
				}
			}
		} else if (this.value instanceof String) {
			String stringVal = (String) value;
			if (stringVal.startsWith("#")) {
				ModelPopulation pop = this.getAttributeOf().getModel();
				list.add(pop.getEntity(new Integer(stringVal.substring(1, stringVal.length()))));
			}

		}
		return list;
	}

	/**
	 * gets the type information of this attribute such as
	 * "ENTITY_INSTANCE_NAME", "REAL" etc
	 * 
	 * @return the String value of an instance name
	 */
	public String getP21Header() {
		return p21Header;
	}

	public void setP21Header(String header) {
		p21Header = header;
	}
}
