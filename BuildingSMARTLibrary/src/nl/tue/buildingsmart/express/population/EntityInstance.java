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
import java.util.HashMap;

import org.bimserver.plugins.schema.EntityDefinition;

/**
 * @author Jakob Beetz j.beetz@tue.nl
 *         <p>
 *         The EntityInstance gives access to an EXPRESS entity instance
 *         generated i.e. by reading in a SPFF / p21 file.
 *         </p>
 *         </p>
 *         <p>
 *         Depending on the type of the EntityInstance that can be retrieved
 *         with the getEntityDefinition() function, the attributes can be
 *         retrieved as an ArrayList or by their name.
 *         </p>
 * 
 *         <p>
 *         Member functions that have a "BN" in their name, e.g.
 *         "getAttributeValueBN" take a string argument to get a certain
 *         attribute value by its name according to the schema definition.
 *         (Roughly oriented at SDAI)
 *         </p>
 */
public class EntityInstance {
	private int id; // the #number of the part 21 file this instance is
					// identified with
	private EntityDefinition entDef;
	private ArrayList<AttributeInstance> attributes;
	private ArrayList<EntityInstance> references;
	private HashMap<String, AttributeInstance> attributeMap;
	private int numAttribues = 0;
	private ModelPopulation model;

	public EntityInstance(ModelPopulation model, int id) {
		this.setId(id);
		setModel(model);
		attributes = new ArrayList<AttributeInstance>();
		references = new ArrayList<EntityInstance>();
		attributeMap = new HashMap<String, AttributeInstance>();
	}

	/**
	 * <strong>disscuraged to call this and operate on the attributes
	 * directly</strong>
	 * 
	 * @return the list of attributes for this EntityInstance
	 */
	public ArrayList<AttributeInstance> getAttributes() {
		return attributes;
	}

	public void addAttribute(AttributeInstance attribute) {
		attributes.add(attribute);
		attribute.setAttributeOf(this);
		attributeMap.put(attribute.getAttributeType().getName(), attribute);
		numAttribues = attributes.size();
	}

	public void setAttributes(ArrayList<AttributeInstance> attributes) {
		this.attributes = attributes;
		for (int i = 0; i < attributes.size(); i++) {
			attributeMap.put(attributes.get(i).getAttributeType().getName(), attributes.get(i));
		}

	}

	public EntityDefinition getEntityDefinition() {
		return entDef;
	}

	public void setEntityDefinition(EntityDefinition entDef) {
		this.entDef = entDef;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<EntityInstance> getReferneces() {
		return references;
	}

	public void addReference(EntityInstance instance) {
		references.add(instance);
	}

	public void setReferneces(ArrayList<EntityInstance> referneces) {
		this.references = referneces;
	}

	/**
	 * get an attribute of this EntityInstance by its name an return its value
	 * as an Object. Possible object types include EntityInstance, literal
	 * values or aggregate types.
	 * 
	 * @param attributeName
	 * @return the value of the attribute as an object
	 */
	public Object getAttributeValueBN(String attributeName) {
		/*
		 * boolean found = false; AttributeInstance attrib = null;
		 * Iterator<AttributeInstance> attribIter=attributes.iterator(); while
		 * (!found && attribIter.hasNext()){ attrib = attribIter.next(); if
		 * (attrib.getAttributeType().getName().equals(attributeName)) found =
		 * true;
		 * 
		 * }
		 */

		AttributeInstance attrib = attributeMap.get(attributeName);
		if (attrib != null)
			return attrib.getValue();
		else
			return null;

	}

	/**
	 * get an attribute value by its name and return the value as a string
	 * 
	 * @param attributeName
	 * @return a string representation of the Value of the attribute
	 */
	public String getAttributeValueBNasString(String attributeName) {
		return (String) getAttributeValueBN(attributeName);

	}

	/**
	 * get the number of attributes of this instance
	 * 
	 * @return the number of attributes
	 */
	public int getNumAttribues() {
		return numAttribues;
	}

	/**
	 * Try to get the attribute by its name and return it as an EntityInstance
	 * 
	 * @param attributeName
	 * @return the EntityInstance or null if its not an EntityInstance but a
	 *         e.g. a literal or an Aggregate
	 */
	public EntityInstance getAttributeValueBNasEntityInstance(String attributeName) {
		AttributeInstance attr = attributeMap.get(attributeName);
		// if (attr.hasEntityInstanceValue())
		if (attr != null)
			return attr.getEntityInstanceValue();
		else
			return null;
	}

	/**
	 * @param attributeName
	 *            the case-sensitive name of the AttributeInstance to retrieve
	 * @return
	 */
	public ArrayList<EntityInstance> getAttributeValueBNasEntityInstanceList(String attributeName) {
		AttributeInstance attr = attributeMap.get(attributeName);
		if (attr != null)
			return attr.getEntityList();
		else
			return null;
	}

	public ModelPopulation getModel() {
		return model;
	}

	public void setModel(ModelPopulation model) {
		this.model = model;
	}
}
