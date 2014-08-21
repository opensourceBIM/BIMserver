package org.bimserver.ifcgeometryremover;

import java.io.File;
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
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IfcDoc;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class IfcGeometryRemover {
	private PluginManager pluginManager;
	private IfcDoc ifcDoc;
	private MetaDataManager metaDataManager;
	private ReferenceCounter referenceCounter;

	public IfcGeometryRemover() {
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			ifcDoc = new IfcDoc(new File("C:\\Users\\Ruben\\git\\BootstrapBIM\\BootstrapBIM\\docs\\R2x3_TC1"));
			metaDataManager = new MetaDataManager(null);
			metaDataManager.addEPackage(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public void removeGeometry(File inputFile, File outputFile) {
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
			EClassifier eClassifier = metaDataManager.getEPackage("ifc2x3tc1").getEClassifierCaseInsensitive(classname);
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

	private void writeModel(IfcModelInterface model, File outFile) {
		SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
		try {
			model.resetExpressIds();
			serializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), null, true);
			serializer.writeToFile(outFile, null);
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public IfcModelInterface readModel(File file) {
		try {
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
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
