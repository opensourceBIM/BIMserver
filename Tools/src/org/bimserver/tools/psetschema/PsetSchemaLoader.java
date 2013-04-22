package org.bimserver.tools.psetschema;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.bimserver.tools.ifctocsv.PropertyDef;
import org.bimserver.tools.ifctocsv.PropertyDef.ValueDef;
import org.bimserver.tools.ifctocsv.PropertySetDef;
import org.bimserver.tools.ifctocsv.PropertyType;

public class PsetSchemaLoader {

	public static void main(String[] args) {
		load(new File("psd"));
	}

	@SuppressWarnings("rawtypes")
	public static PsetSchema load(File baseDir) {
		PsetSchema psetSchema = new PsetSchema();
		for (File f : baseDir.listFiles()) {
			if (f.isDirectory()) {
				for (File x : f.listFiles()) {
					if (x.getName().endsWith(".xml")) {
						JAXBContext jaxbContext;
						try {
							jaxbContext = JAXBContext.newInstance(PropertySetDef.class);
							Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
							PropertySetDef propertySetDef = (PropertySetDef) unmarshaller.unmarshal(x);
							for (PropertyDef propertyDef : propertySetDef.getPropertyDefs().getPropertyDef()) {
								PropertyDefinition propertyDefinition = new PropertyDefinition();
								for (JAXBElement el : propertyDef.getNameOrValueDefOrDefinition()) {
									Object val = el.getValue();
									if (val instanceof PropertyType) {
										PropertyType propertyType = (PropertyType) val;
										if (propertyType.getTypeComplexProperty() != null) {
											propertyDefinition.setType(new ComplexType(propertyType.getTypeComplexProperty()));
										} else if (propertyType.getTypePropertyBoundedValue() != null) {
											propertyDefinition.setType(new BoundedValue(propertyType.getTypePropertyBoundedValue()));
										} else if (propertyType.getTypePropertyEnumeratedValue() != null) {
											propertyDefinition.setType(new EnumeratedValue(propertyType.getTypePropertyEnumeratedValue()));
										} else if (propertyType.getTypePropertyListValue() != null) {
											propertyDefinition.setType(new ListValue(propertyType.getTypePropertyListValue().getListValue()));
										} else if (propertyType.getTypePropertyReferenceValue() != null) {
											propertyDefinition.setType(new ReferenceValue(propertyType.getTypePropertyReferenceValue()));
										} else if (propertyType.getTypePropertySingleValue() != null) {
											propertyDefinition.setType(new SingleValue(propertyType.getTypePropertySingleValue()));
										} else if (propertyType.getTypePropertyTableValue() != null) {
											propertyDefinition.setType(new TableValue(propertyType.getTypePropertyTableValue()));
										}
									} else if (val instanceof String) {
										String str = (String) val;
										if (el.getName().toString().equals("Name")) {
											propertyDefinition.setName(str);
										} else if (el.getName().toString().equals("Definition")) {
											propertyDefinition.setDefinition(str);
										} else {
											System.out.println(el.getName().toString());
										}
									} else if (val instanceof ValueDef) {
										if (el.getName().toString().equals("ValueDef")) {
											
										} else {
											System.out.println(el.getName().toString());
										}
									} else {
										System.out.println(el.getName().toString());
									}
								}
								for (String s : propertySetDef.getApplicableClasses().getClassName()) {
									ClassDefinition classDefinition = psetSchema.addOrGetClass(s);
									if (propertyDefinition.getType() != null) {
										classDefinition.add(propertyDefinition);
									}
								}
							}
						} catch (JAXBException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return psetSchema;
	}
}