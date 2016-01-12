package org.bimserver.ifcgeometryremover;

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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.ReferenceCounter;
import org.bimserver.ifc.ReferenceCounter.Reference;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IfcDoc;
import org.bimserver.shared.exceptions.PluginException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class IfcGeometryRemover {
	private PluginManager pluginManager;
	private IfcDoc ifcDoc;
	private MetaDataManager metaDataManager;
	private ReferenceCounter referenceCounter;

	public IfcGeometryRemover() {
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			ifcDoc = new IfcDoc(new File("C:\\Users\\Ruben\\git\\BootstrapBIM\\BootstrapBIM\\docs\\R2x3_TC1"));
			metaDataManager = new MetaDataManager(null);
			metaDataManager.addEPackage(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public void removeGeometry(Path inputFile, Path outputFile) {
		IfcModelInterface model = readModel(inputFile);

		referenceCounter = new ReferenceCounter(model);
		referenceCounter.updateReferences();
		new IslandIdentifier(model).dump();

		remove(ifcDoc.getClassNames("ifcgeometryresource").iterator(), model);
		remove(ifcDoc.getClassNames("ifcgeometricmodelresource").iterator(), model);
		remove(ifcDoc.getClassNames("ifcgeometricconstraintresource").iterator(), model);
		
		writeModel(model, outputFile);
	}

	private void remove(Iterator<String> iterator, IfcModelInterface model) {
		Set<IdEObject> toRemove = new HashSet<IdEObject>();
		while (iterator.hasNext()) {
			String classname = iterator.next();
			EClassifier eClassifier = metaDataManager.getPackageMetaData("ifc2x3tc1").getEClassifierCaseInsensitive(classname);
			if (eClassifier instanceof EClass) {
				toRemove.addAll(model.getAllWithSubTypes((EClass)eClassifier));
			}
		}
		Iterator<IdEObject> iterator2 = toRemove.iterator();
		while (iterator2.hasNext()) {
			IdEObject objectToRemove = iterator2.next();
			Set<Reference> referencesTo = referenceCounter.getReferencesTo(objectToRemove);
			if (referencesTo != null) {
				for (Reference reference : referencesTo) {
					if (reference.geteReference().isMany()) {
						List<?> list = (List<?>)reference.getIdEObject().eGet(reference.geteReference());
						list.remove(reference.getReferredObject());
					} else {
						reference.getIdEObject().eUnset(reference.geteReference());
					}
				}
			}
			model.remove(objectToRemove);
		}
	}

	private void writeModel(IfcModelInterface model, Path outFile) {
		SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
		try {
			model.resetExpressIds();
			serializer.init(model, null, pluginManager, null, true);
			serializer.writeToFile(outFile, null);
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}

	public IfcModelInterface readModel(Path file) {
		try {
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			deserializerPlugin.createDeserializer(new PluginConfiguration());
//			deserializer.init(schema, null, null); // TODO
			IfcModelInterface model = null;//deserializer.read(file);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		}
		return null;
	}
}
