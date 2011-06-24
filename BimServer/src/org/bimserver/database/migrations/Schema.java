package org.bimserver.database.migrations;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDeadlockException;
import org.bimserver.database.Database;
import org.bimserver.database.DatabaseSession;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Schema {
	private static final Logger LOGGER = LoggerFactory.getLogger(Schema.class);
	private final Map<String, EPackage> packages = new HashMap<String, EPackage>();
	private final Map<EClass, Set<EClass>> directSubClasses = new HashMap<EClass, Set<EClass>>();
	private final Map<EClass, Set<EClass>> indirectSubClasses = new HashMap<EClass, Set<EClass>>();
	
	private final Set<Change> changes = new LinkedHashSet<Change>();
	
	public static enum Multiplicity {
		SINGLE,
		MANY
	}

	private void initSubClasses() {
		for (EPackage ePackage : packages.values()) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					initDirectSubClasses(eClass);
					initIndirectSubClasses(eClass);
				}
			}
		}
	}

	private void initDirectSubClasses(EClass eClass) {
		HashSet<EClass> set = new HashSet<EClass>();
		directSubClasses.put(eClass, set);
		set.add(eClass);
		for (EClassifier eClassifier : eClass.getEPackage().getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass e = (EClass) eClassifier;
				if (e.getESuperTypes().contains(eClass)) {
					set.add(e);
				}
			}
		}
	}

	public Set<EPackage> getEPackages() {
		return new HashSet<EPackage>(packages.values());
	}
	
	private void initIndirectSubClasses(EClass eClass) {
		HashSet<EClass> set = new HashSet<EClass>();
		indirectSubClasses.put(eClass, set);
		set.add(eClass);
		for (EClassifier eClassifier : eClass.getEPackage().getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass e = (EClass) eClassifier;
				if (eClass.isSuperTypeOf(e)) {
					set.add(e);
				}
			}
		}
	}
	
	public EPackage getEPackage(String name) {
		return packages.get(name);
	}
	
	public EPackage createEPackage(String name) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName(name);
		ePackage.setNsPrefix(name);
		ePackage.setNsURI(name);
		packages.put(ePackage.getName(), ePackage);
		return ePackage;
	}
	
	public EEnum createEEnum(EPackage ePackage, String name) {
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		changes.add(new NewEnumChange(eEnum));
		ePackage.getEClassifiers().add(eEnum);
		eEnum.setName(name);
		return eEnum;
	}
	
	public EEnumLiteral createEEnumLiteral(EEnum eEnum, String name, int value) {
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		eEnumLiteral.setValue(value);
		eEnum.getELiterals().add(eEnumLiteral);
		eEnumLiteral.setName(name);
		return eEnumLiteral;
	}

	public EEnumLiteral createEEnumLiteral(EEnum eEnum, String name) {
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		if (eEnum.getELiterals().size() == 0) {
			eEnumLiteral.setValue(0);
		} else {
			int largestValue = Integer.MIN_VALUE;
			for (EEnumLiteral existingLiteral : eEnum.getELiterals()) {
				if (existingLiteral.getValue() > largestValue) {
					largestValue = existingLiteral.getValue();
				}
			}
			eEnumLiteral.setValue(largestValue + 1);
		}
		eEnum.getELiterals().add(eEnumLiteral);
		eEnumLiteral.setName(name);
		return eEnumLiteral;
	}

	public EClass createEClass(EPackage ePackage, String name, EClass... superClasses) {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(name);
		changes.add(new NewClassChange(eClass));
		for (EClass superClass : superClasses) {
			eClass.getESuperTypes().add(superClass);
		}
		ePackage.getEClassifiers().add(eClass);
		return eClass;
	}

	public EAttribute createEAttribute(EClass eClass, String name, EDataType eDataType, Multiplicity multiplicity) {
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		eAttribute.setName(name);
		if (multiplicity == Multiplicity.MANY) {
			eAttribute.setUpperBound(-1);
		}
		if (!isNew(eClass)) {
			changes.add(new NewAttributeChange(this, eAttribute));
		}
		eAttribute.setEType(eDataType);
		eClass.getEStructuralFeatures().add(eAttribute);
		return eAttribute;
	}

	private boolean isNew(EClass eClass) {
		for (Change change : changes) {
			if (change instanceof NewClassChange) {
				NewClassChange newClassChange = (NewClassChange)change;
				if (newClassChange.getEClass() == eClass) {
					return true;
				}
			}
		}
		return false;
	}

	public EReference createEReference(EClass eClass, String name, EClass type, Multiplicity multiplicity) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName(name);
		if (multiplicity == Multiplicity.MANY) {
			eReference.setUpperBound(-1);
		}
		eReference.setEType(type);
		eClass.getEStructuralFeatures().add(eReference);
		return eReference;
	}
	
	public void writeToEcore(File file) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
        for (EPackage ePackage : packages.values()) {
            resource.getContents().add(ePackage);
        }
        try {
            resource.save(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void upgradeDatabase(Database database, int version, DatabaseSession databaseSession) {
		LOGGER.info("Upgrading database to version " + version);
		initSubClasses();
		for (Change change : changes) {
			try {
				change.change(database, databaseSession);
			} catch (NotImplementedException e) {
				LOGGER.error("", e);
			} catch (BimDatabaseException e) {
				LOGGER.error("", e);
			}
		}
		try {
			database.setDatabaseVersion(version, databaseSession);
		} catch (BimDeadlockException e) {
			LOGGER.error("", e);
		}
	}

	public EClass getEClass(String packageName, String name) {
		return (EClass) packages.get(packageName).getEClassifier(name);
	}

	public void clearUpdates() {
		changes.clear();
	}

	@SuppressWarnings("rawtypes")
	public void loadEcore(InputStream inputStream) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        Resource resource = resourceSet.createResource(URI.createURI("ifc2x3.ecore"));
        try {
			resource.load(inputStream, new HashMap());
			for (EObject eObject : resource.getContents()) {
				if (eObject instanceof EPackage) {
					EPackage ePackage = (EPackage)eObject;
					addEPackage(ePackage);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addEPackage(EPackage ePackage) {
		packages.put(ePackage.getName(), ePackage);
		changes.add(new NewPackageChange(ePackage));
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass)eClassifier;
				addEClass(eClass);
			}
		}
	}

	private void addEClass(EClass eClass) {
		changes.add(new NewClassChange(eClass));
	}

	public Set<EClass> getSubClasses(EClass eClass) {
		return indirectSubClasses.get(eClass);
	}

	public EDataType getEEnum(String packageName, String enumName) {
		return (EEnum) packages.get(packageName).getEClassifier(enumName);
	}
}