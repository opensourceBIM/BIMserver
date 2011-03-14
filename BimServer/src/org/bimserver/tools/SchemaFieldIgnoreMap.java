package org.bimserver.tools;

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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import nl.tue.buildingsmart.express.dictionary.Attribute;
import nl.tue.buildingsmart.express.dictionary.EntityDefinition;
import nl.tue.buildingsmart.express.dictionary.InverseAttribute;
import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.ifc.ClassDefinition;
import org.bimserver.ifc.FieldDefinition;
import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.PackageDefinition;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaFieldIgnoreMap extends FieldIgnoreMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaFieldIgnoreMap.class);
	
	public static void main(String[] args) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		Set<EPackage> packages = new HashSet<EPackage>();
		packages.add(Ifc2x3Package.eINSTANCE);
		new SchemaFieldIgnoreMap(packages, schema);
	}
	
	public SchemaFieldIgnoreMap(Set<? extends EPackage> packages, SchemaDefinition schema) {
		super(packages);
		ArrayList<EntityDefinition> entities = schema.getEntities();
		PackageDefinition packageDefinition = new PackageDefinition();
		for (EntityDefinition entity : entities) {
			ClassDefinition classDefinition = new ClassDefinition();
			classDefinition.setName(entity.getName());
			packageDefinition.getClassDefinitions().add(classDefinition);
			for (Attribute attribute : entity.getAttributes(true)) {
				if (attribute instanceof InverseAttribute) {
					FieldDefinition fieldDefinition = new FieldDefinition();
					fieldDefinition.setName(attribute.getName());
					classDefinition.getFieldDefinitions().add(fieldDefinition);
					generalSet.add(new StructuralFeatureIdentifier(entity.getName(), attribute.getName()));
				}
			}
		}
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PackageDefinition.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(packageDefinition, new FileOutputStream("ignore.xml"));
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
	}
}