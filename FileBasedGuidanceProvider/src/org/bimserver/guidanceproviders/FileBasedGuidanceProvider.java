package org.bimserver.guidanceproviders;

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

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.guidanceproviders.FieldIgnoreMap;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileBasedGuidanceProvider extends FieldIgnoreMap {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileBasedGuidanceProvider.class);
	private JAXBContext jaxbContext;

	public FileBasedGuidanceProvider(Set<Ifc2x3Package> set) {
		super(set);
		URL ignoreFile = getClass().getClassLoader().getResource("ignore.xml");
		LOGGER.info("Reading general ignore list from \"" + StringUtils.getPrettyFileUrl(ignoreFile) + "\"");
		try {
			jaxbContext = JAXBContext.newInstance(PackageDefinition.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			PackageDefinition packageDefinition = (PackageDefinition) unmarshaller.unmarshal(ignoreFile);
			for (ClassDefinition classDefinition : packageDefinition.getClassDefinitions()) {
				for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
					generalSet.add(new StructuralFeatureIdentifier(classDefinition.getName(), fieldDefinition.getName()));
				}
			}
			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					URL resource = getClass().getClassLoader().getResource("ignoreexceptions/" + eClass.getName() + ".xml");
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
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PackageDefinition packageDefinition = (PackageDefinition) unmarshaller.unmarshal(resource);
		HashSet<StructuralFeatureIdentifier> hashSet = new HashSet<StructuralFeatureIdentifier>();
		specificMap.put(eClass, hashSet);
		LOGGER.info("Reading specific non-ignore list for " + eClass.getName() + " from \"" + StringUtils.getPrettyFileUrl(resource) + "\"");
		for (ClassDefinition classDefinition : packageDefinition.getClassDefinitions()) {
			for (FieldDefinition fieldDefinition : classDefinition.getFieldDefinitions()) {
				hashSet.add(new StructuralFeatureIdentifier(classDefinition.getName(), fieldDefinition.getName()));
			}
		}
	}
}