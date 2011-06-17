package org.bimserver;

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

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.bimserver.plugins.guidanceproviders.FieldIgnoreMap;
import org.bimserver.plugins.schema.Attribute;
import org.bimserver.plugins.schema.EntityDefinition;
import org.bimserver.plugins.schema.InverseAttribute;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.ClassDefinition;
import org.bimserver.plugins.serializers.FieldDefinition;
import org.bimserver.plugins.serializers.PackageDefinition;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaFieldIgnoreMap extends FieldIgnoreMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchemaFieldIgnoreMap.class);
	private PackageDefinition packageDefinition;
	
	public SchemaFieldIgnoreMap(Set<? extends EPackage> packages, SchemaDefinition schema) {
		super(packages);
		ArrayList<EntityDefinition> entities = schema.getEntities();
		packageDefinition = new PackageDefinition();
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
	}
	
	public void write(OutputStream outputStream) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(PackageDefinition.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(packageDefinition, outputStream);
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
	}
}