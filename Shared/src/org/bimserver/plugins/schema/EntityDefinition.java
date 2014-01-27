package org.bimserver.plugins.schema;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EntityDefinition extends NamedType {
	// store each supertype in both a list and a hashtable for convenience
	private ArrayList<EntityDefinition> supertypes = new ArrayList<EntityDefinition>();
	private HashMap<String, EntityDefinition> supertypesBN = new HashMap<String, EntityDefinition>();
	// store each attribute in both a list and a hashtable for convenience
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private HashMap<String, Attribute> attributesBN = new HashMap<String, Attribute>();

	private HashMap<String, Attribute> attributesPlusSuperBN;
	private ArrayList<Attribute> attributesPlusSuper;

	private ArrayList<EntityDefinition> subtypes = new ArrayList<EntityDefinition>();
	private final Map<String, DerivedAttribute2> derivedAttributes = new HashMap<String, DerivedAttribute2>();
	private final Set<String> derivedAttributesOverride = new HashSet<String>();
	boolean complex;
	boolean instantiable;
	boolean independent;

	public EntityDefinition(String name) {
		super(name);
	}

	public boolean isDerived(String name) {
		return derivedAttributes.containsKey(name);
	}

	public String toString() {
		return this.getName();
	}

	public boolean addAttribute(Attribute a) {
		a.setParent_entity(this);
		attributes.add(a);
		attributesBN.put(a.getName(), a);
		return true;
	}

	public void addDerived(DerivedAttribute2 attribute, boolean firstOccurance) {
		if (!derivedAttributes.containsKey(attribute.getName())) {
			derivedAttributes.put(attribute.getName(), attribute);
		} else {
			if (firstOccurance) {
				derivedAttributes.put(attribute.getName(), attribute);
			}
		}
		for (EntityDefinition entityDefinition : supertypes) {
			if (entityDefinition.getAttributeBNWithSuper(attribute.getName()) != null) {
				derivedAttributesOverride.add(attribute.getName());
			}
		}
		doSubtypes(attribute);
	}

	private void doSubtypes(DerivedAttribute2 attribute) {
		for (EntityDefinition entityDefinition : subtypes) {
			entityDefinition.addDerived(new DerivedAttribute2(attribute.getName(), attribute.getType(), attribute.getExpressCode(), attribute.isCollection(), true), false);
			entityDefinition.doSubtypes(attribute);
		}
	}
	
	public Attribute getAttributeBN(String name) {
		return attributesBN.get(name);
	}

	public Attribute getAttributeBNWithSuper(String name) {
		if (attributesBN.containsKey(name)) {
			return attributesBN.get(name);
		}
		if (attributesPlusSuperBN == null) {
			getAttributesCached(true);
		}
		if (attributesPlusSuperBN.containsKey(name)) {
			return attributesPlusSuperBN.get(name);
		}
		return null;
	}

	public boolean addSupertype(EntityDefinition parent) {
		supertypes.add(parent);
		supertypesBN.put(parent.getName(), parent);
		return true;
	}

	public ArrayList<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * returns all Attirbutes of this ENTITY. Optionally also returns all
	 * inherited Attributes from the parents
	 * 
	 * @param returnInherited
	 *            if true also returns inherited attributs
	 * @return
	 */
	public ArrayList<Attribute> getAttributes(boolean returnInherited) {
		if (!returnInherited)
			return this.getAttributes();
		else {
			ArrayList<Attribute> tempAttribs = new ArrayList<Attribute>();
			Iterator<EntityDefinition> parentIter = this.getSupertypes().iterator();
			while (parentIter.hasNext()) {
				tempAttribs = parentIter.next().getAttributes(true);
			}
			Iterator<Attribute> attribIter = this.getAttributes().iterator();
			while (attribIter.hasNext())
				tempAttribs.add(attribIter.next());
			return tempAttribs;
		}
	}

	public ArrayList<Attribute> getAttributesCached(boolean returnInherited) {
		if (!returnInherited)
			return this.getAttributes();
		else {
			if (attributesPlusSuper == null) {
				attributesPlusSuper = getAttributes(true);
				attributesPlusSuperBN = new HashMap<String, Attribute>();
				for (Attribute attribute : attributesPlusSuper) {
					attributesPlusSuperBN.put(attribute.getName(), attribute);
				}
			}
			return attributesPlusSuper;
		}
	}

	public void setAttributes(ArrayList<Attribute> attributes) {
		this.attributes = attributes;
	}

	public HashMap<String, Attribute> getAttributesBN() {
		return attributesBN;
	}

	public void setAttributesBN(HashMap<String, Attribute> attributesBN) {
		this.attributesBN = attributesBN;
	}

	public ArrayList<EntityDefinition> getSupertypes() {
		return supertypes;
	}

	public void setSupertypes(ArrayList<EntityDefinition> supertypes) {
		this.supertypes = supertypes;
	}

	public HashMap<String, EntityDefinition> getSupertypesBN() {
		return supertypesBN;
	}

	public void setSupertypesBN(HashMap<String, EntityDefinition> supertypesBN) {
		this.supertypesBN = supertypesBN;
	}

	public ArrayList<EntityDefinition> getSubtypes() {
		if (this.subtypes == null)
			this.subtypes = new ArrayList<EntityDefinition>();
		return subtypes;
	}

	public void setSubtypes(ArrayList<EntityDefinition> subtypes) {
		this.subtypes = subtypes;
	}

	public void addSubtype(EntityDefinition subClass) {
		this.subtypes.add(subClass);
	}

	public boolean isInstantiable() {
		return instantiable;
	}

	public void setInstantiable(boolean instantiable) {
		this.instantiable = instantiable;
	}
	
	public Map<String, DerivedAttribute2> getDerivedAttributes() {
		return derivedAttributes;
	}

	public boolean isDerivedOverride(String name) {
		return derivedAttributesOverride.contains(name);
	}
}