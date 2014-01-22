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
import java.util.Iterator;

/**
 * Holds the definitions of <code>TYPEs</code>(see {@link BaseType} and its
 * implementations), <code>ENTITY</code>s (see {@link EntityDefinition}) and
 * their <code>ATTRIBUTE</code>s (see {@link Attribute} as defined in a ISO
 * 10303 <code>EXPRESS</code> schema. </br>
 * 
 * @author Jakob Beetz
 * 
 */
@SuppressWarnings("all")
public class SchemaDefinition implements Schema {

	/**
	 * the name of the schema
	 */
	private String name;

	/**
	 * a map of all {@link EntityDefinition}s by their UPPERCASE names as keys
	 * in this schema
	 */
	private HashMap<String, EntityDefinition> entitiesBN = new HashMap<String, EntityDefinition>();
	/**
	 * a list of all {@link EntityDefinition}s in this schema
	 */
	private ArrayList<EntityDefinition> entities = new ArrayList<EntityDefinition>();

	/**
	 * a hash map of all EXPRESS <code>TYPE</code> definitions in this schema
	 * with the UPPERCASE name of the type as its keys
	 */
	private HashMap<String, DefinedType> typesBN = new HashMap<String, DefinedType>();

	/**
	 * a List of all EXPRESS <code>TYPE</code> definitions in this schema
	 */

	private ArrayList<DefinedType> types = new ArrayList<DefinedType>();

	/**
	 * hash map of an ordered list of all parents of an <code>ENTITY</code>
	 * definition. First element is the direct supertype, last the root
	 * supertype
	 */
	private HashMap<EntityDefinition, ArrayList<EntityDefinition>> parents = new HashMap<EntityDefinition, ArrayList<EntityDefinition>>();

	/**
	 * hash map of all relations that are defined in the EXPRESS
	 * <code>ATTRIBUTE</code>s defined locally to a given
	 * {@link EntityDefinition}. </br> <b>Note:</b>ArrayList does not include
	 * relations to other entities defined in supertypes
	 */
	private HashMap<EntityDefinition, ArrayList<EntityDefinition>> entityRelations = new HashMap<EntityDefinition, ArrayList<EntityDefinition>>();

	/**
	 * @param ent
	 *            the {@link EntityDefinition} to be added to the schema
	 * @return true if adding the definition to the schema succeeded
	 * 
	 */
	public boolean addEntity(EntityDefinition ent) {
		// TODO exception handling
		String entName = ent.getName();
		entities.add(ent);
		entitiesBN.put(entName.toUpperCase(), ent);

		return true;
	}

	/**
	 * @param type
	 *            the {@link DefinedType} to be added to the total list of types
	 *            defined in this schema
	 * @return true if successfully added the type definition
	 */
	public boolean addType(DefinedType type) {
		types.add(type);
		typesBN.put(type.getName().toUpperCase(), type);
		return true;
	}

	public DefinedType getTypeBN(String name) {
		return typesBN.get(name.toUpperCase());
	}

	public void constructEntityRelationsMap() {
		entityRelations.clear();
		Iterator ei = entities.iterator();
		while (ei.hasNext()) {
			EntityDefinition ent = (EntityDefinition) ei.next();
			if (!ent.getAttributes().isEmpty()) {
				Iterator ai = ent.getAttributes().iterator();
				while (ai.hasNext()) {
					Attribute at = (Attribute) ai.next();
					if (at instanceof ExplicitAttribute) {
						BaseType bt = ((ExplicitAttribute) at).getDomain();
						if (bt instanceof EntityDefinition) {
							ArrayList<EntityDefinition> rels = entityRelations.get(ent);
							if (rels == null) {
								entityRelations.put(ent, new ArrayList<EntityDefinition>());
								rels = entityRelations.get(ent);
							}
							rels.add((EntityDefinition) bt);
						}

					}
				}
			}
		}
	}

	public void constructHirarchyMap() {
		parents.clear();
		this.parents = new HashMap<EntityDefinition, ArrayList<EntityDefinition>>();
		Iterator ei = entities.iterator();
		while (ei.hasNext()) {
			EntityDefinition ent = (EntityDefinition) ei.next();
			if (!ent.getSupertypes().isEmpty()) {
				Iterator iter = ent.getSupertypes().iterator();

				while (iter.hasNext()) {
					EntityDefinition parent = (EntityDefinition) iter.next();
					if (parents.get(parent) == null)
						parents.put(parent, new ArrayList<EntityDefinition>());
					ArrayList<EntityDefinition> children = parents.get(parent);
					children.add(ent);
					parent.addSubtype(ent);
					// System.out.println("adding "+ent.getName()+ " to "+
					// parent.getName());
				}

			}
		}

	}

	/**
	 * 
	 * @param name
	 * @return a BaseType with the given Name (can be a TYPE or an ENTITY)
	 */
	public BaseType getBaseTypeBN(String name) {
		BaseType bt;
		bt = typesBN.get(name.toUpperCase());
		if (bt == null)
			bt = entitiesBN.get(name.toUpperCase());
		if (bt == null && name.equalsIgnoreCase("real"))
			return new RealType();
		if (bt == null && name.equalsIgnoreCase("integer"))
			return new IntegerType();
		if (bt == null && name.equalsIgnoreCase("binary"))
			return new BinaryType();
		if (bt == null && name.equalsIgnoreCase("string"))
			return new StringType();
		if (bt == null && name.equalsIgnoreCase("logical"))
			return new LogicalType();

		return bt;
	}

	public EntityDefinition getEntityBN(String name) {
		return entitiesBN.get(name.toUpperCase());
	}

	public EntityDefinition getEntityBNNoCaseConvert(String name) {
		return entitiesBN.get(name);
	}

	public HashMap<String, EntityDefinition> getEnitiesBN() {
		return entitiesBN;
	}

	public void setEnitiesBN(HashMap<String, EntityDefinition> enitiesBN) {
		this.entitiesBN = enitiesBN;
	}

	public ArrayList<EntityDefinition> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<EntityDefinition> entities) {
		this.entities = entities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, DefinedType> getTypesBN() {
		return typesBN;
	}

	public void setTypesBN(HashMap<String, DefinedType> types) {
		this.typesBN = types;
	}

	public ArrayList<DefinedType> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<DefinedType> typesBN) {
		this.types = typesBN;
	}

	public SchemaDefinition(String name) throws Exception {
		super();
		this.name = name;

	}

	public SchemaDefinition() {
		super();
	}

	public HashMap<EntityDefinition, ArrayList<EntityDefinition>> getParents() {
		return parents;
	}

	public ArrayList<EntityDefinition> getEntityChildren(EntityDefinition ent) {
		return parents.get(ent);
	}

	public ArrayList<EntityDefinition> getEntityRelations(EntityDefinition ent) {

		if (entityRelations.get(ent) == null)
			return new ArrayList<EntityDefinition>();
		else
			return entityRelations.get(ent);
	}

	// TODO add rules and external schemas
}
