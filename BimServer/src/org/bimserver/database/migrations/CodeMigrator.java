package org.bimserver.database.migrations;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.MetaDataManager;
import org.bimserver.querycompiler.VirtualFile;
import org.bimserver.shared.NotificationInterface;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.tools.generators.DataObjectGenerator;
import org.bimserver.tools.generators.DataObjectGeneratorWrapper;
import org.bimserver.tools.generators.ProtocolBuffersGenerator;
import org.bimserver.tools.generators.SConverterGeneratorWrapper;
import org.bimserver.tools.generators.SPackageGeneratorWrapper;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ruben de Laat
 *
 *	Steps:
 *    1. Add a new migration (for example create the class Step0005 in org.bimserver.database.migrations.steps)
 *	  2. Change the TARGET_VERSION to the same number
 *    3. Run this class it's main method, this will generate an ecore file (models/models.ecore) reflecting all available migration steps combined.
 *    4. Open the models/models.genmodel file, right-click on the root node and select "Generate Model Code"
 *    5. Verify there are no compile errors, and fix those first by changing your migration code
 *    6. Generate the S-classes: Run org.bimserver.tools.generators.ServiceGenerator
 *    7. Generate the Protocol Buffers file and classes: Run org.bimserver.tools.generators.ProtocolBuffersGenerator
 *
 */

public class CodeMigrator {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeMigrator.class);
	
	public static void main(String[] args) {
		new CodeMigrator().start();
	}

	private void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		LOGGER.info("Starting code migrator...");
		Migrator migrator = new Migrator(null);
		int latestVersion = migrator.getLatestVersion();
		LOGGER.info("Migrating to version " + latestVersion);
		Schema schema = migrator.migrateSchemaTo(latestVersion);
		schema.writeToEcore(new File("models/models.ecore"));
		LOGGER.info("Model migrated to version " + latestVersion);

		LOGGER.info("Choose \"auto\" or \"manual\"");
		try {
			String type = reader.readLine();
			if (type.equalsIgnoreCase("auto")) {
				LOGGER.info("Generating EMF classes...");
				DataObjectGenerator dataObjectGenerator = new DataObjectGenerator(schema);
				VirtualFile basedir = new VirtualFile(null, null);
				VirtualFile generate = dataObjectGenerator.generate(basedir);
				generate.dumpToDir(new File("../Store/generated"));
				LOGGER.info("EMF classes successfully generated");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		LOGGER.info("Generating ServiceInterface objects...");
		DataObjectGeneratorWrapper serviceGenerator = new DataObjectGeneratorWrapper();
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EPackage ePackage : schema.getEPackages()) {
			if (!ePackage.getName().equals("ifc2x3")) {
				ePackages.add(ePackage);
			}
		}
		serviceGenerator.generateDataObjects(ePackages);
		LOGGER.info("ServiceInterface objects successfully generated");
		
		MetaDataManager metaDataManager = new MetaDataManager(ePackages);
		
		SConverterGeneratorWrapper sConverterGenerator = new SConverterGeneratorWrapper(metaDataManager);
		sConverterGenerator.generate(ePackages);
		
		LOGGER.info("Generating protocol buffers file and classes...");
		ProtocolBuffersGenerator protocolBuffersGenerator = new ProtocolBuffersGenerator();

		generateProtocolBuffersServiceInterface(protocolBuffersGenerator);
		generateNotificationInterfaceImplementation(protocolBuffersGenerator);
		
		SPackageGeneratorWrapper sPackageGeneratorWrapper = new SPackageGeneratorWrapper();
		sPackageGeneratorWrapper.generate(ePackages);
		
		LOGGER.info("Protocol buffers file and classes generated");
		LOGGER.info("");
		LOGGER.info("Migration successfull");
	}

	private void generateNotificationInterfaceImplementation(ProtocolBuffersGenerator protocolBuffersGenerator) {
		File protoFile = new File("../Builds/build/pb/notification.proto");
		File descFile = new File("../Builds/build/pb/notification.desc");
		File reflectorImplementationFile = new File("../BimServer/generated/org/bimserver/pb/NotificationInterfaceReflectorImpl.java");
		protocolBuffersGenerator.generate(NotificationInterface.class, protoFile, descFile, reflectorImplementationFile, false, "service");
		try {
			FileUtils.copyFile(protoFile, new File("../Builds/build/targets/shared/notification.proto"));
			FileUtils.copyFile(descFile, new File("../Builds/build/targets/shared/notification.desc"));
			FileUtils.copyFile(descFile, new File("../BimServerClientLib/src/notification.desc"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateProtocolBuffersServiceInterface(ProtocolBuffersGenerator protocolBuffersGenerator) {
		File protoFile = new File("../Builds/build/pb/service.proto");
		File descFile = new File("../Builds/build/pb/service.desc");
		File reflectorImplementationFile = new File("../BimServerClientLib/generated/org/bimserver/pb/ServiceInterfaceReflectorImpl.java");
		protocolBuffersGenerator.generate(ServiceInterface.class, protoFile, descFile, reflectorImplementationFile, true);
		try {
			FileUtils.copyFile(protoFile, new File("../Builds/build/targets/shared/service.proto"));
			FileUtils.copyFile(descFile, new File("../Builds/build/targets/shared/service.desc"));
			FileUtils.copyFile(descFile, new File("../BimServerClientLib/src/service.desc"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}