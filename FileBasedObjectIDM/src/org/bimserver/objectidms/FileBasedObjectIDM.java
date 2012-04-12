package org.bimserver.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.net.URL;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginContext;
import org.bimserver.plugins.objectidms.FieldIgnoreMap;
import org.bimserver.plugins.objectidms.StructuralFeatureIdentifier;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileBasedObjectIDM extends FieldIgnoreMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileBasedObjectIDM.class);
	private JAXBContext jaxbContext;

	public FileBasedObjectIDM(Set<Ifc2x3Package> set, PluginContext pluginContext) {
		super(set);
		URL ignoreFile = pluginContext.getResourceAsUrl("ignore.xml");
		LOGGER.info("Reading general ignore list from \"" + StringUtils.getPrettyFileUrl(ignoreFile) + "\"");
		try {
			jaxbContext = JAXBContext.newInstance(PackageDefinition.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PackageDefinition packageDefinition = (PackageDefinition) unmarshaller.unmarshal(ignoreFile);
			for (ClassDefinition classDefinition : packageDefinition.getClassDefinitions()) {
				for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
					addToGeneralIgnoreSet(new StructuralFeatureIdentifier(classDefinition.getName(), fieldDefinition.getName()));
				}
			}
			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					URL resource = pluginContext.getResourceAsUrl(eClass.getName() + ".xml");
					if (resource != null) {
						processResource(eClass, resource);
					}
				}
			}
		} catch (JAXBException e) {
			LOGGER.error("", e);
		}
	}
	
	private void processResource(EClass eClass, URL resource) throws JAXBException {
		LOGGER.info("Reading specific non-ignore list for " + eClass.getName() + " from \"" + StringUtils.getPrettyFileUrl(resource) + "\"");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PackageDefinition packageDefinition = (PackageDefinition) unmarshaller.unmarshal(resource);
		for (ClassDefinition classDefinition : packageDefinition.getClassDefinitions()) {
			for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
				addToSpecificIncludeMap(eClass, new StructuralFeatureIdentifier(classDefinition.getName(), fieldDefinition.getName()));
			}
		}
	}
}