package org.bimserver.database.migrations;

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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.shared.InterfaceList;
import org.bimserver.shared.interfaces.PublicInterface;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.meta.SService;
import org.bimserver.shared.meta.SServicesMap;
import org.bimserver.shared.meta.SourceCodeFetcher;
import org.bimserver.shared.reflector.RealtimeReflectorFactoryBuilder;
import org.bimserver.tools.generators.AdaptorGeneratorWrapper;
import org.bimserver.tools.generators.AsyncServiceGeneratorWrapper;
import org.bimserver.tools.generators.DataObjectGeneratorWrapper;
import org.bimserver.tools.generators.ProtocolBuffersGenerator;
import org.bimserver.tools.generators.SConverterGeneratorWrapper;
import org.bimserver.tools.generators.SPackageGeneratorWrapper;
import org.bimserver.tools.generators.SServiceGeneratorWrapper;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Ruben de Laat
 * 
 *         Steps: 
 *         1. Add a new migration (for example create the class Step0005 in org.bimserver.database.migrations.steps) 
 *         2. Change the TARGET_VERSION to the same number 
 *         3. Run this class it's main method, this will generate an ecore file (models/models.ecore) reflecting all available migration steps combined. 
 *         4. Open the models/models.genmodel file, right-click on the root node and select "Generate Model Code" 
 *         5. Verify there are no compile errors, and fix those first by changing your migration code
 */

public class CodeMigrator {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeMigrator.class);
	private ProtocolBuffersGenerator protocolBuffersGenerator;
	private List<SService> knownServices = new ArrayList<SService>();
	private List<String> knownShortNames = new ArrayList<String>();
	private SServicesMap servicesMap = new SServicesMap();

	public static void main(String[] args) {
		new CodeMigrator().start();
	}

	private void start() {
		LOGGER.info("Starting code migrator...");
		Migrator migrator = new Migrator(null);
		int latestVersion = migrator.getLatestVersion();
		LOGGER.info("Migrating to version " + latestVersion);
		Schema schema = migrator.migrateSchemaTo(latestVersion);
		schema.writeToEcore(new File("models/models.ecore"));
		LOGGER.info("Model migrated to version " + latestVersion);

		LOGGER.info("Generating ServiceInterface objects...");
		DataObjectGeneratorWrapper serviceGenerator = new DataObjectGeneratorWrapper();
		Set<EPackage> ePackages = new HashSet<EPackage>();
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			pluginManager.setMetaDataManager(metaDataManager);
			metaDataManager.init();
			for (EPackage ePackage : schema.getEPackages()) {
				if (!ePackage.getName().equals("ifc2x3tc1") && !ePackage.getName().equals("ifc4") && !ePackage.getName().equals("geometry")) {
					ePackages.add(ePackage);
				}
			}
			serviceGenerator.generateDataObjects(ePackages);
			LOGGER.info("ServiceInterface objects successfully generated");

			SConverterGeneratorWrapper sConverterGenerator = new SConverterGeneratorWrapper(metaDataManager);
			sConverterGenerator.generate(ePackages);

			SServiceGeneratorWrapper serviceGeneratorWrapper = new SServiceGeneratorWrapper();
			serviceGeneratorWrapper.generate(ServiceInterface.class, StorePackage.eINSTANCE);

			LOGGER.info("Generating protocol buffers file and classes...");
			protocolBuffersGenerator = new ProtocolBuffersGenerator();

			for (Class<? extends PublicInterface> clazz : InterfaceList.getInterfaces()) {
				SService service = new SService(servicesMap, new SourceCodeFetcher() {
					@Override
					public String get(Class<?> clazz) {
						File javaFile = new File("../Shared/src/" + clazz.getName().replace(".", "/") + ".java");
						try {
							return FileUtils.readFileToString(javaFile);
						} catch (IOException e) {
							return null;
						}
					}
				} , clazz);
				servicesMap.add(service);
			}
			servicesMap.initialize();
			for (SService service : servicesMap.list()) {
				AdaptorGeneratorWrapper adaptorGeneratorWrapper = new AdaptorGeneratorWrapper();
				adaptorGeneratorWrapper.generate(service.getInterfaceClass(), service);
				AsyncServiceGeneratorWrapper asyncServiceGeneratorWrapper = new AsyncServiceGeneratorWrapper();
				asyncServiceGeneratorWrapper.generate(service.getInterfaceClass(), service);
				File protoFile = new File("../BimServerClientLib/src/org/bimserver/client/protocolbuffers/" + service.getInterfaceClass().getSimpleName() + ".proto");
				File descFile = new File("../BimServerClientLib/src/org/bimserver/client/protocolbuffers/" + service.getInterfaceClass().getSimpleName() + ".desc");
				protocolBuffersGenerator.generate(service.getInterfaceClass(), protoFile, descFile, this.knownServices.isEmpty(), service, knownShortNames);
				this.knownServices.add(service);
				this.knownShortNames.add(service.getInterfaceClass().getSimpleName());
			}

			SPackageGeneratorWrapper sPackageGeneratorWrapper = new SPackageGeneratorWrapper();
			sPackageGeneratorWrapper.generate(ePackages);

			LOGGER.info("Protocol buffers file and classes generated");

			RealtimeReflectorFactoryBuilder reflectorBuilder = new RealtimeReflectorFactoryBuilder(InterfaceList.createSServicesMap(), new File("../Shared/genclasses"));
			reflectorBuilder.newReflectorFactory();
			
			LOGGER.info("");
			LOGGER.info("Migration successfull");
		} catch (PluginException e1) {
			e1.printStackTrace();
		}
	}
}