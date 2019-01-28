package org.bimserver.tools.generators;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.emf.MetaDataManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;

public class DataObjectGeneratorWrapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataObjectGeneratorWrapper.class);
	private File sourceFolder = new File("../PluginBase/generated");
	private File packageFolder = new File(sourceFolder, "org" + File.separator + "bimserver" + File.separator + "interfaces" + File.separator + "objects");
	private MetaDataManager metaDataManager;

	public DataObjectGeneratorWrapper(MetaDataManager metaDataManager) {
		this.metaDataManager = metaDataManager;
	}

	public void generateDataObjects(Set<EPackage> ePackages) {
		try {
			FileUtils.forceMkdir(packageFolder);
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		ServiceInterfaceObjectGenerator dataObjectGenerator = new ServiceInterfaceObjectGenerator();
		Set<String> fileNamesCreated = new HashSet<String>();
		for (EPackage ePackage : ePackages) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass || eClassifier instanceof EEnum) {
					Object[] arguments = new Object[]{
						eClassifier,
						new ImportManager(),
						metaDataManager
					};
					String generated = dataObjectGenerator.generate(arguments);
					String fileName = "S" + eClassifier.getName() + ".java";
					fileNamesCreated.add(fileName);
					File file = new File(packageFolder, fileName);
					try {
						OutputStream fileOutputStream = new FileOutputStream(file);
						fileOutputStream.write(generated.getBytes(Charsets.UTF_8));
						fileOutputStream.close();
					} catch (FileNotFoundException e) {
						LOGGER.error("", e);
					} catch (UnsupportedEncodingException e) {
						LOGGER.error("", e);
					} catch (IOException e) {
						LOGGER.error("", e);
					}
				}
			}
		}
		for (File file : packageFolder.listFiles()) {
			if (!fileNamesCreated.contains(file.getName())) {
				file.delete();
			}
		}
	}
}