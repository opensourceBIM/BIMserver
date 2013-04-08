package org.bimserver.tools.colorizer;

import java.io.File;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.schema.SchemaDefinition;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class Colorizer {
	private SchemaDefinition schema;
	private PluginManager pluginManager;

	public static void main(String[] args) {
		try {
			Colorizer colorizer = new Colorizer();
			File baseDir = new File("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\kleurtjes\\");
			colorizer.colorize(new File(baseDir, "Compleet_Imro.ifc"), new File(baseDir, "Compleet_Imro-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "3D_Imro_new.ifc"), new File(baseDir, "3D_Imro_new-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "Compleet_Imro+Noise.ifc"), new File(baseDir, "Compleet_Imro+Noise-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "Compleet_Imro+NoiseGrouped.ifc"), new File(baseDir, "Compleet_Imro+NoiseGrouped-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "Compleet_Noise.ifc"), new File(baseDir, "Compleet_Noise-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "NoiseContourFlat_06m.ifc"), new File(baseDir, "NoiseContourFlat_06m-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "NoiseContourFlat_09m.ifc"), new File(baseDir, "NoiseContourFlat_09m-Colored.ifc"));
			colorizer.colorize(new File(baseDir, "NoiseContourFlat_12m.ifc"), new File(baseDir, "NoiseContourFlat_12m-Colored.ifc"));
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}
	}

	public Colorizer() {
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			schema = pluginManager.requireSchemaDefinition();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public IfcModelInterface readModel(File file) {
		try {
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(schema);
			IfcModelInterface model = deserializer.read(file);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void colorize(File inFile, File outFile) throws IfcModelInterfaceException {
		IfcModelInterface model = readModel(inFile);
		model.fixOidCounter();
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			if (ifcProduct.getName().contains("Noise")) {
				IfcColourRgb color = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcColourRgb());
				color.setRed(0.5);
				color.setGreen(0.5);
				color.setBlue(0.5);

				modifyRepresentation(model, ifcProduct, color, 0.8);
			} else {
				String description = ifcProduct.getDescription();
				String[] split = description.split(" ");
				if (split.length == 3) {
					System.out.println("Colors found on " + ifcProduct.getName());
					IfcColourRgb color = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcColourRgb());
					color.setRed(Integer.parseInt(split[0]) / 255.0);
					color.setGreen(Integer.parseInt(split[1]) / 255.0);
					color.setBlue(Integer.parseInt(split[2]) / 255.0);

					modifyRepresentation(model, ifcProduct, color, 1.0);
				}
			}
		}
		writeModel(model, outFile);
	}

	private void modifyRepresentation(IfcModelInterface model, IfcProduct ifcProduct, IfcColourRgb color, double alpha) throws IfcModelInterfaceException {
		IfcProductRepresentation ifcProductRepresentation = ifcProduct.getRepresentation();
		if (ifcProductRepresentation != null) {
			for (IfcRepresentation ifcRepresentation : ifcProductRepresentation.getRepresentations()) {
				for (IfcRepresentationItem ifcRepresentationItem : ifcRepresentation.getItems()) {
					if (ifcRepresentationItem.getStyledByItem().isEmpty()) {
						IfcStyledItem ifcStyledItem = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcStyledItem());
						IfcPresentationStyleAssignment ifcPresentationStyleAssignment = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcPresentationStyleAssignment());
						ifcRepresentationItem.getStyledByItem().add(ifcStyledItem);
						ifcStyledItem.getStyles().add(ifcPresentationStyleAssignment);
						IfcSurfaceStyle ifcSurfaceStyle = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcSurfaceStyle());
						ifcPresentationStyleAssignment.getStyles().add(ifcSurfaceStyle);
						IfcSurfaceStyleRendering ifcSurfaceStyleRendering = model.create(Ifc2x3tc1Package.eINSTANCE.getIfcSurfaceStyleRendering());
						ifcSurfaceStyle.getStyles().add(ifcSurfaceStyleRendering);
						setColor(color, ifcSurfaceStyleRendering, alpha);
					} else {
						for (IfcStyledItem ifcStyledItem : ifcRepresentationItem.getStyledByItem()) {
							for (IfcPresentationStyleAssignment ifcPresentationStyleAssignment : ifcStyledItem.getStyles()) {
								for (IfcPresentationStyleSelect ifcPresentationStyleSelect : ifcPresentationStyleAssignment.getStyles()) {
									if (ifcPresentationStyleSelect instanceof IfcSurfaceStyle) {
										IfcSurfaceStyle ifcSurfaceStyle = (IfcSurfaceStyle) ifcPresentationStyleSelect;
										for (IfcSurfaceStyleElementSelect ifcSurfaceStyleElementSelect : ifcSurfaceStyle.getStyles()) {
											if (ifcSurfaceStyleElementSelect instanceof IfcSurfaceStyleRendering) {
												IfcSurfaceStyleRendering ifcSurfaceStyleRendering = (IfcSurfaceStyleRendering) ifcSurfaceStyleElementSelect;
												setColor(color, ifcSurfaceStyleRendering, alpha);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void setColor(IfcColourRgb color, IfcSurfaceStyleRendering ifcSurfaceStyleRendering, double alpha) {
		if (color != null) {
			ifcSurfaceStyleRendering.setDiffuseColour(color);
			ifcSurfaceStyleRendering.setReflectionColour(color);
			ifcSurfaceStyleRendering.setSpecularColour(color);
			ifcSurfaceStyleRendering.setSurfaceColour(color);
			ifcSurfaceStyleRendering.setTransmissionColour(color);
		}
		ifcSurfaceStyleRendering.setTransparency(alpha);
	}

	private void writeModel(IfcModelInterface model, File outFile) {
		SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
		try {
			model.resetExpressIds();
			serializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), true);
			serializer.writeToFile(outFile);
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
