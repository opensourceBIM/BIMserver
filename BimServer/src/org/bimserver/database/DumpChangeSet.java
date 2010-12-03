package org.bimserver.database;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.bimserver.shared.Addition;
import org.bimserver.shared.AttributeReferencePair;
import org.bimserver.shared.AttributeValuePair;
import org.bimserver.shared.ChangeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumpChangeSet {
	private static final Logger LOGGER = LoggerFactory.getLogger(DumpChangeSet.class);
	
	public static void main(String[] args) {
		ChangeSet changeSet = new ChangeSet();
		Addition addition1 = new Addition("IfcWindow");
		addition1.setOid(123L);
		addition1.addAttribute(new AttributeValuePair("field1", 555));
		addition1.addAttribute(new AttributeValuePair("field2", "bkaat"));
		changeSet.addAddition(addition1);
		
		Addition addition2 = new Addition("IfcWall");
		AttributeReferencePair attributeValuePair = new AttributeReferencePair();
		attributeValuePair.setName("test");
		attributeValuePair.setOid(123);
		addition2.addAttribute(attributeValuePair);
		changeSet.addAddition(addition2);
		
//		Modification modification = new Modification();
//		modification.setClassName("IfcTest");
//		modification.setOid(123);
//		AttributeValuePair attributeValuePair2 = new AttributeValuePair();
//		attributeValuePair.setName("test");
//		attributeValuePair.setOid(123);
//		modification.getat(attributeValuePair2);
//		AttributeValuePair attributeValuePair3 = new AttributeValuePair();
//		modification.addAttribute(attributeValuePair3);
//		changeSet.addModification(modification);
		
//		Removal removal = new Removal("IfcWindow", 100);
//		changeSet.addRemoval(removal);
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ChangeSet.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(changeSet, new FileOutputStream("changeset.xml"));
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			unmarshaller.unmarshal(new FileInputStream("changeset.xml"));
		} catch (JAXBException e) {
			LOGGER.error("", e);
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}
