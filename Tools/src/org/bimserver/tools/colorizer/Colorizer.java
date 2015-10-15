package org.bimserver.tools.colorizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcPropertySet;
import org.bimserver.models.ifc2x3tc1.IfcPropertySingleValue;
import org.bimserver.models.ifc2x3tc1.IfcRelDefinesByProperties;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcText;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Colorizer {
	private PluginManager pluginManager;
	private final Map<String, Map<String, String>> map = new HashMap<String, Map<String,String>>();

	public static void main(String[] args) {
		try {
			Colorizer colorizer = new Colorizer();
			Path baseDir = Paths.get("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\kleurtjes\\");
//			colorizer.colorize(new File(baseDir, "Compleet_Imro.ifc"), new File(baseDir, "Compleet_Imro-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "3D_Imro_new.ifc"), new File(baseDir, "3D_Imro_new-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "Compleet_Imro+Noise.ifc"), new File(baseDir, "Compleet_Imro+Noise-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "Compleet_Imro+NoiseGrouped.ifc"), new File(baseDir, "Compleet_Imro+NoiseGrouped-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "Compleet_Noise.ifc"), new File(baseDir, "Compleet_Noise-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "NoiseContourFlat_06m.ifc"), new File(baseDir, "NoiseContourFlat_06m-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "NoiseContourFlat_09m.ifc"), new File(baseDir, "NoiseContourFlat_09m-Colored.ifc"));
//			colorizer.colorize(new File(baseDir, "NoiseContourFlat_12m.ifc"), new File(baseDir, "NoiseContourFlat_12m-Colored.ifc"));
			colorizer.colorize(baseDir.resolve("3D_Imro_withId.ifc"), baseDir.resolve("3D_Imro_withId-Colored.ifc"));
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		}
	}

	public Colorizer() {
		File fXmlFile = new File("D:\\Dropbox\\Shared\\BIMserver\\IFC modellen\\kleurtjes\\3D_Imro_withId.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			NodeList featureMembers = doc.getElementsByTagName("imro:featureMember");
			for (int i=0; i<featureMembers.getLength(); i++) {
				Node item = featureMembers.item(i);
				NodeList childNodes = item.getChildNodes();
				
				String id = null;
				
				HashMap<String, String> currentMap = null;
				
				for (int x=0; x<childNodes.getLength(); x++) {
					Node item2 = childNodes.item(x);
					if  (item2.getNodeName().startsWith("imro:")) {
						NodeList childNodes2 = item2.getChildNodes();
						for (int j=0; j<childNodes2.getLength(); j++) {
							Node item3 = childNodes2.item(j);
							if (item3.getNodeName().equals("imro:identificatie")) {
								id = item3.getFirstChild().getNodeValue();
								currentMap = new HashMap<String, String>();
								map.put(id, currentMap);
							} else if (item3.getNodeName().equals("imro:maatvoeringInfo")) {
								NodeList childNodes3 = item3.getChildNodes();
								for (int p=0; p<childNodes3.getLength(); p++) {
									String waardeType = null;
									String waardeValue = null;
									Node item4 = childNodes3.item(p);
									if (item4.getNodeName().equals("imro:WaardeEnType")) {
										NodeList childNodes4 = item4.getChildNodes();
										for (int y=0; y<childNodes4.getLength(); y++) {
											Node item5 = childNodes4.item(y);
											if (item5.getNodeName().equals("imro:waarde")) {
												waardeValue = item5.getFirstChild().getNodeValue();
											} else if (item5.getNodeName().equals("imro:waardeType")) {
												waardeType = item5.getFirstChild().getNodeValue();
											}
										}
									}
									if (waardeType != null && waardeValue != null) {
										currentMap.put(waardeType, waardeValue);
									}
								}
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}

	public IfcModelInterface readModel(Path file) {
		try {
			DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
//			deserializer.init(schema); // TODO
			IfcModelInterface model = deserializer.read(file);
			return model;
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void colorize(Path inFile, Path outFile) throws IfcModelInterfaceException {
		IfcModelInterface model = readModel(inFile);
		model.fixOidCounter();
		for (IfcProduct ifcProduct : model.getAllWithSubTypes(IfcProduct.class)) {
			String name = ifcProduct.getName();
			if (name.contains("(NL.IMRO")) {
				name = name.trim();
				String code = name.substring(name.indexOf("(NL.IMRO") + 1, name.lastIndexOf(")"));
				Map<String, String> currentMap = map.get(code);
				IfcPropertySet ifcPropertySet = model.create(IfcPropertySet.class);
				ifcPropertySet.setName("IMRO");
				IfcRelDefinesByProperties ifcRelDefinesByProperties = model.create(IfcRelDefinesByProperties.class);
				ifcRelDefinesByProperties.setRelatingPropertyDefinition(ifcPropertySet);
				ifcRelDefinesByProperties.getRelatedObjects().add(ifcProduct);
				if (currentMap != null) {
					for (Entry<String, String> entry : currentMap.entrySet()) {
						IfcPropertySingleValue ifcProperty = model.create(IfcPropertySingleValue.class);
						ifcProperty.setName(entry.getKey());
						IfcText ifcText = model.create(IfcText.class);
						ifcText.setWrappedValue(entry.getValue());
						ifcProperty.setNominalValue(ifcText);
						ifcPropertySet.getHasProperties().add(ifcProperty);
						System.out.println("Adding property " + entry.getKey() + " with value " + entry.getValue() + " to object " + ifcProduct.getName() + " of type " + ifcProduct.eClass().getName());
					}
				}
			}
			if (ifcProduct.getName().contains("Noise")) {
				IfcColourRgb color = model.create(IfcColourRgb.class);
				color.setRed(0.5);
				color.setGreen(0.5);
				color.setBlue(0.5);

				modifyRepresentation(model, ifcProduct, color, 0.8);
			} else {
				String description = ifcProduct.getDescription();
				String[] split = description.split(" ");
				if (split.length == 3) {
					System.out.println("Colors found on " + ifcProduct.getName());
					IfcColourRgb color = model.create(IfcColourRgb.class);
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
						IfcStyledItem ifcStyledItem = model.create(IfcStyledItem.class);
						IfcPresentationStyleAssignment ifcPresentationStyleAssignment = model.create(IfcPresentationStyleAssignment.class);
						ifcRepresentationItem.getStyledByItem().add(ifcStyledItem);
						ifcStyledItem.getStyles().add(ifcPresentationStyleAssignment);
						IfcSurfaceStyle ifcSurfaceStyle = model.create(IfcSurfaceStyle.class);
						ifcPresentationStyleAssignment.getStyles().add(ifcSurfaceStyle);
						IfcSurfaceStyleRendering ifcSurfaceStyleRendering = model.create(IfcSurfaceStyleRendering.class);
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

	private void writeModel(IfcModelInterface model, Path outFile) {
		SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
		Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
		try {
			model.resetExpressIds();
			// TODO
			serializer.init(model, null, pluginManager, pluginManager.requireRenderEngine(), null, true);
			serializer.writeToFile(outFile, null);
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		}
	}
}
