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

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class ModelPopulation {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelPopulation.class);
	private HashMap<Integer, EntityInstance> instances;
	// hashmap of all instances sorted by type name;
	private HashMap<String, Vector<EntityInstance>> typeNameMap;
	private SchemaDefinition schema;
	private Part21Parser parser;
	private File schemaFile;
	private String entityPrefixString = "ENTITY_";

	public ModelPopulation(FileInputStream input) {

		parser = new Part21Parser(input);

	}

	public SchemaDefinition getSchema() {
		return schema;
	}

	public void setSchema(SchemaDefinition schema) {
		this.schema = schema;
		if (this.parser != null)
			this.parser.setSchema(schema);
	}

	public File getSchemaFile() {
		return schemaFile;
	}

	public void setSchemaFile(File schemaFile) {
		this.schemaFile = schemaFile;
		parser.setSchemaFile(schemaFile);
	}

	public void load() {
		try {
			parser.setModel(this);
			parser.init();
			parser.syntax();
			this.setInstances(parser.getInstances());
			buildTypeNameMap();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			LOGGER.error("", e);
		}
	}

	public HashMap<Integer, EntityInstance> getInstances() {
		return instances;
	}

	public void setInstances(HashMap<Integer, EntityInstance> instances) {
		this.instances = instances;
	}

	public EntityInstance getEntity(Integer id) {
		return instances.get(id);
	}

	private void buildTypeNameMap() {
		typeNameMap = new HashMap<String, Vector<EntityInstance>>();
		for (Iterator instKeyIter = instances.keySet().iterator(); instKeyIter.hasNext();) {
			EntityInstance inst = instances.get(instKeyIter.next());

			String typeName = inst.getEntityDefinition().getName();
			if (!typeNameMap.containsKey(typeName)) {
				typeNameMap.put(typeName, new Vector<EntityInstance>());
			}
			typeNameMap.get(typeName).add(inst);
		}
	}

	public Vector<EntityInstance> getInstancesOfType(String typeName) {
		return getInstancesOfType(typeName, false);
	}

	/**
	 * Given an (abstract) supertype recursively descends down the subtype axis
	 * until the first layer first layer of concrete types is found and returns
	 * all instances
	 * 
	 * @param typeName
	 *            the (abstract) type name
	 * @return a vector of EntityInstances of possible various (concrete) types
	 */
	public Vector<EntityInstance> getInstancesOfFirstNonAbstractTypes(String typeName) {
		Vector<EntityInstance> instances = new Vector<EntityInstance>();
		EntityDefinition ent = schema.getEnitiesBN().get(typeName.toUpperCase());
		if (!ent.isInstantiable()) {
			for (EntityDefinition subEnt : ent.getSubtypes()) {
				Vector<EntityInstance> tmp = getInstancesOfFirstNonAbstractTypes(subEnt.getName());
				instances.addAll(tmp);
			}

		} else {
			Vector<EntityInstance> tmp = getInstancesOfType(ent.getName());
			instances.addAll(tmp);

		}

		return instances;
	}

	public Vector<EntityInstance> getInstancesOfType(String typeName, boolean includeSubClasses) {
		// get the direct instances
		System.out.println("checking:" + typeName);
		// typeName=typeName.toUpperCase();
		Vector<EntityInstance> instances = typeNameMap.get(typeName);
		if (includeSubClasses) {
			// recurse into subtypes and get respective instances
			EntityDefinition ent = schema.getEnitiesBN().get(typeName.toUpperCase());
			for (EntityDefinition subClass : ent.getSubtypes()) {
				Vector<EntityInstance> subClassInstances = getInstancesOfType(subClass.getName(), includeSubClasses);
				if (subClassInstances != null) {
					if (instances == null)
						instances = new Vector<EntityInstance>();
					instances.addAll(subClassInstances);
				}
			}
		}

		if (instances == null)
			instances = new Vector<EntityInstance>();
		return instances;
	}

	public String getEntityPrefix() {
		// TODO Auto-generated method stub
		return entityPrefixString;
	}
}
