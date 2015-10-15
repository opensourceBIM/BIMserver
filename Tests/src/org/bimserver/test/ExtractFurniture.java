package org.bimserver.test;

import java.nio.file.Paths;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.plugins.ModelHelper;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.objectidms.HideAllInversesObjectIDM;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.utils.CollectionUtils;

public class ExtractFurniture {
	public static void main(String[] args) {
		try {
			PluginManager pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(null);
			
			MetaDataManager metaDataManager = new MetaDataManager(pluginManager);
			PackageMetaData packageMetaData = metaDataManager.getPackageMetaData("ifc2x3tc1");
			
			deserializer.init(packageMetaData);
			IfcModelInterface model = deserializer.read(Paths.get("../TestData/data/ADT-FZK-Haus-2005-2006.ifc"));
			model.fixOids(new IncrementingOidProvider());
			
			IfcFurnishingElement picknick = (IfcFurnishingElement) model.getByName(Ifc2x3tc1Package.eINSTANCE.getIfcFurnishingElement(), "Picknik Bank");

			IfcModelInterface newModel = new BasicIfcModel(packageMetaData, null);
			ModelHelper modelHelper = new ModelHelper(pluginManager.getMetaDataManager(), new HideAllInversesObjectIDM(CollectionUtils.singleSet(Ifc2x3tc1Package.eINSTANCE), pluginManager.requireSchemaDefinition("ifc2x3tc1")), newModel);
			
			modelHelper.copy(picknick, false);
			
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(null);
			serializer.init(newModel, null, pluginManager, null, packageMetaData, true);
			serializer.writeToFile(Paths.get("test.ifc"), null);
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}
}