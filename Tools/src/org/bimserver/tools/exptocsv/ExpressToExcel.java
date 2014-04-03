package org.bimserver.tools.exptocsv;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.bimserver.emf.MetaDataException;
import org.bimserver.emf.MetaDataManager;
import org.bimserver.emf.Schema;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.shared.IfcDoc;
import org.bimserver.tools.psetschema.ClassDefinition;
import org.bimserver.tools.psetschema.ComplexType;
import org.bimserver.tools.psetschema.PropertyDefinition;
import org.bimserver.tools.psetschema.PropertyTypeDefinition;
import org.bimserver.tools.psetschema.PsetSchema;
import org.bimserver.tools.psetschema.PsetSchemaLoader;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class ExpressToExcel {
	private PsetSchema psetSchema;
	private IfcDoc ifcDoc;
	private WritableCellFormat times;
	private int row;

	public static void main(String[] args) {
		try {
			new ExpressToExcel().export(new File("ifc2x3tc1.xls"));
		} catch (MetaDataException e) {
			e.printStackTrace();
		}
	}

	private void export(File file) throws MetaDataException {
		psetSchema = PsetSchemaLoader.load(new File("psd"));
		ifcDoc = new IfcDoc(new File("C:\\Users\\Ruben de Laat\\Downloads\\IFC2x3_TC1_HTML_distribution-pset_errata\\R2x3_TC1"));

	    WorkbookSettings wbSettings = new WorkbookSettings();

	    wbSettings.setLocale(new Locale("en", "EN"));
	    
	    WritableWorkbook workbook = null;
		try {
		    // Lets create a times font
		    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		    // Define the cell format
		    times = new WritableCellFormat(times10pt);
		    // Lets automatically wrap the cells
		    times.setWrap(false);

		    MetaDataManager metaDataManager = new MetaDataManager(null);
		    metaDataManager.addEPackage(Ifc2x3tc1Package.eINSTANCE, Schema.IFC2X3TC1);
		    
			workbook = Workbook.createWorkbook(file, wbSettings);
			int i=0;
			for (String domain : ifcDoc.getDomains()) {
				// Determine if there is at least one type eligible
				int x =0;
				for (String className : ifcDoc.getClassNames(domain)) {
					EClassifier eClassifier = metaDataManager.getEPackage("ifc2x3tc1").getEClassifierCaseInsensitive(className);
					if (eClassifier instanceof EClass) {
						EClass eClass = (EClass)eClassifier;
						if (Ifc2x3tc1Package.eINSTANCE.getIfcProduct().isSuperTypeOf(eClass)) {
							x++;
						}
					}
				}

				if (x > 0) {
					row = 0;
					WritableSheet excelSheet = workbook.createSheet(domain, i);
					for (String className : ifcDoc.getClassNames(domain)) {
						EClassifier eClassifier = metaDataManager.getEPackage("ifc2x3tc1").getEClassifierCaseInsensitive(className);
						if (eClassifier instanceof EClass) {
							EClass eClass = (EClass)eClassifier;
							if (Ifc2x3tc1Package.eINSTANCE.getIfcProduct().isSuperTypeOf(eClass)) {
								dumpType(0, excelSheet, eClass);
							}
						}
					}
					i++;
				}
			}
			workbook.write();
			workbook.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	private void dumpType(int indent, WritableSheet excelSheet, EClass eClass) throws RowsExceededException, WriteException {
		excelSheet.addCell(new Label(indent, row++, eClass.getName(), times));

		for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
			if (feature.getEAnnotation("hidden") == null && feature.getEAnnotation("inverse") == null && !feature.getName().equals("OwnerHistory")) {
				boolean extend = feature.getEType() instanceof EClass && indent < 2;
				excelSheet.addCell(new Label(indent + 1, row++, feature.getName() + (extend ? "" : " (" + convertType(feature.getEType()) + ")"), times));
				if (extend) {
					dumpType(indent + 2, excelSheet, (EClass)feature.getEType());
				}
			}
		}
		ClassDefinition psetClassifier = psetSchema.getClass(eClass.getName());
		if (psetClassifier != null) {
			for (PropertyDefinition propertyDefinition : psetClassifier.getPropertyDefinitions()) {
				excelSheet.addCell(new Label(indent + 1, row++, propertyDefinition.getName() + " (" + propertyDefinition.getDefinition() + ")", times));
				PropertyTypeDefinition type = propertyDefinition.getType();
				if (type instanceof ComplexType) {
					ComplexType complexType = (ComplexType)type;
					for (PropertyDefinition propertyDefinition2 : complexType.getProperties()) {
						excelSheet.addCell(new Label(indent + 2, row++, propertyDefinition2.getName() + " (" + propertyDefinition2.getDefinition() + ")", times));
					}
				}
			}
		}
	}

	private String convertType(EClassifier type) {
		if (type == EcorePackage.eINSTANCE.getEDouble() || type == EcorePackage.eINSTANCE.getEDoubleObject()) {
			return "double";
		} else if (type == EcorePackage.eINSTANCE.getEInt() || type == EcorePackage.eINSTANCE.getEIntegerObject()) {
			return "int";
		} else if (type == EcorePackage.eINSTANCE.getEBoolean() || type == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return "boolean";
		} else if (type == EcorePackage.eINSTANCE.getEByteArray()) {
			return "bytearray";
		} else if (type == EcorePackage.eINSTANCE.getELong() || type == EcorePackage.eINSTANCE.getELongObject()) {
			return "long";
		} else if (type == EcorePackage.eINSTANCE.getEString()) {
			return "string";
		} else if (type instanceof EEnum) {
			return "enum";
		}
		return type.getName();
	}
}