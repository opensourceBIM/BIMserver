package org.bimserver.emf;

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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
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

import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetaDataManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(MetaDataManager.class);
	
	private final Map<String, PackageMetaData> ePackages = new TreeMap<String, PackageMetaData>();
	private final Path tempDir;

	public MetaDataManager(Path tempDir) {
		this.tempDir = tempDir;
	}
	
	public void init(boolean suppressOutput) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(5));

		PrintStream oldErr = System.err;
		PrintStream oldOut = System.out;
		if (suppressOutput) {
			PrintStream nop = new PrintStream(new ByteArrayOutputStream());
			System.setErr(nop);
			System.setOut(nop);
		}
		
		executor.submit(new PackageLoader(this, Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1));
		executor.submit(new PackageLoader(this, Ifc4Package.eINSTANCE, Schema.IFC4));
		executor.submit(new PackageLoader(this, GeometryPackage.eINSTANCE, Schema.GEOMETRY));
		executor.submit(new PackageLoader(this, StorePackage.eINSTANCE, Schema.STORE));
		executor.submit(new PackageLoader(this, LogPackage.eINSTANCE, Schema.LOG));
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			LOGGER.error("", e);
		}

		if (suppressOutput) {
			System.setErr(oldErr);
			System.setOut(oldOut);
		}

		initDependencies();
	}

	private void initDependencies() {
		for (PackageMetaData packageMetaData : ePackages.values()) {
			for (EClassifier eClassifier : packageMetaData.getEPackage().getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass)eClassifier;
					for (EReference eReference : eClass.getEReferences()) {
						if (eReference.getEType().getEPackage() != packageMetaData.getEPackage()) {
							packageMetaData.addDependency(getPackageMetaData(eReference.getEType().getEPackage().getName()));
						}
					}
				}
			}
		}
	}

	public PackageMetaData getPackageMetaData(String schema) {
		if (schema == null) {
			throw new IllegalArgumentException("schema cannot be null");
		}
		PackageMetaData packageMetaData = ePackages.get(schema.toLowerCase());
		if (packageMetaData == null) {
			throw new RuntimeException("No PackageMetaData found for " + schema);
		}
		return packageMetaData;
	}

	public void addEPackage(EPackage ePackage, Schema schema) {
		PackageMetaData packageMetaData = new PackageMetaData(ePackage, schema, tempDir);
		synchronized (this) {
			ePackages.put(ePackage.getName().toLowerCase(), packageMetaData);
		}
	}

	public Collection<PackageMetaData> getAll() {
		return ePackages.values();
	}

	public Collection<PackageMetaData> getAllIfc() {
		Set<PackageMetaData> result = new HashSet<>();
		result.add(getPackageMetaData("Ifc2x3tc1"));
		result.add(getPackageMetaData("Ifc4"));
		return result;
	}
}