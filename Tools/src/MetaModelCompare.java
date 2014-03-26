import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class MetaModelCompare {
	public static void main(String[] args) {
		new MetaModelCompare().start();
	}

	private void start() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();

		URI ifc2x3tc1Ecore = URI.createFileURI("../BimServer/src/org/bimserver/database/migrations/steps/IFC2X3_TC1.ecore");
		URI ifc4Ecore = URI.createFileURI("../BimServer/src/org/bimserver/database/migrations/steps/IFC4.ecore");

		Resource ifc2x3tc1 = resourceSet.getResource(ifc2x3tc1Ecore, true);
		Resource ifc4 = resourceSet.getResource(ifc4Ecore, true);
		
		for (EObject eObject1 : ifc2x3tc1.getContents()) {
			EPackage ifc2x3Package = (EPackage)eObject1;
			for (EObject eObject2 : ifc4.getContents()) {
				EPackage ifc4Package = (EPackage)eObject2;
				comparePackages(ifc2x3Package, ifc4Package);
			}
		}
	}

	private void comparePackages(EPackage ifc2x3Package, EPackage ifc4Package) {
		int removedEntity = 0;
		int addedEntity = 0;
		int removedEnumLiteral = 0;
		int addedEnumLiteral = 0;
		int removedAttribute = 0;
		int addedAttribute = 0;
		int changedType = 0;
		int changedMultiplicity = 0;
		int removedSuperClass = 0;
		int addedSuperClass = 0;
		int removedEnum = 0;
		int addedEnum = 0;
		for (EClassifier eClassifier : ifc2x3Package.getEClassifiers()) {
			if (eClassifier instanceof EEnum) {
				if (ifc4Package.getEClassifier(eClassifier.getName()) == null) {
					removedEnum++;
					System.out.println("REMOVED ENUM - " + eClassifier.getName());
				} else {
					EEnum eEnum = (EEnum)eClassifier;
					EEnum otherEnum = (EEnum)ifc4Package.getEClassifier(eClassifier.getName());
					for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
						if (otherEnum.getEEnumLiteral(eEnumLiteral.getName()) == null) {
							System.out.println("REMOVED ENUM LITERAL - " + eEnum.getName() + "." + eEnumLiteral.getName());
							removedEnumLiteral++;
						}
					}
					for (EEnumLiteral eEnumLiteral : otherEnum.getELiterals()) {
						if (eEnum.getEEnumLiteral(eEnumLiteral.getName()) == null) {
							System.out.println("ADDED ENUM LITERAL - " + eEnum.getName() + "." + eEnumLiteral.getName());
							addedEnumLiteral++;
						}
					}
				}
			} else if (eClassifier instanceof EClass) {
				if (ifc4Package.getEClassifier(eClassifier.getName()) == null) {
					removedEntity++;
					System.out.println("REMOVED ENTITY - " + eClassifier.getName());
				} else {
					EClass eClass = (EClass)eClassifier;
					EClass otherClass = (EClass)ifc4Package.getEClassifier(eClassifier.getName());
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						if (otherClass.getEStructuralFeature(eStructuralFeature.getName()) == null) {
							System.out.println("REMOVED ATTRIBUTE - " + eClass.getName() + "." + eStructuralFeature.getName());
							removedAttribute++;
						} else {
							EStructuralFeature otherFeature = otherClass.getEStructuralFeature(eStructuralFeature.getName());
							if (!eStructuralFeature.getEType().getName().equals(otherFeature.getEType().getName())) {
								System.out.println("CHANGED TYPE - " + eClass.getName() + "." + eStructuralFeature.getName() + ", " + eStructuralFeature.getEType().getName() + "->" + otherFeature.getEType().getName());
								changedType++;
							}
							if (eStructuralFeature.isMany() != otherFeature.isMany()) {
								System.out.println("MULTIPLICITY CHANGED " + eClass.getName() + "." + eStructuralFeature.getName() + ", many: " + eStructuralFeature.isMany() + "->" + otherFeature.isMany());
								changedMultiplicity++;
							}
						}
					}
					for (EClass superClass : eClass.getESuperTypes()) {
						boolean found = false;
						for (EClass otherSuperClass : otherClass.getESuperTypes()) {
							if (superClass.getName().equals(otherSuperClass.getName())) {
								found = true;
								break;
							}
						}
						if (!found) {
							System.out.println("REMOVED SUPERCLASS " + eClass.getName() + " < " + superClass.getName());
							removedSuperClass++;
						}
					}
					for (EClass superClass : otherClass.getESuperTypes()) {
						boolean found = false;
						for (EClass otherSuperClass : eClass.getESuperTypes()) {
							if (superClass.getName().equals(otherSuperClass.getName())) {
								found = true;
								break;
							}
						}
						if (!found) {
							System.out.println("ADDED SUPERCLASS " + eClass.getName() + " < " + superClass.getName());
							addedSuperClass++;
						}
					}
					for (EStructuralFeature eStructuralFeature : otherClass.getEAllStructuralFeatures()) {
						if (eClass.getEStructuralFeature(eStructuralFeature.getName()) == null) {
							System.out.println("ADDED ATTRIBUTE - " + eClass.getName() + "." + eStructuralFeature.getName());
							addedAttribute++;
						}
					}
				}
			}
		}
		for (EClassifier eClassifier : ifc4Package.getEClassifiers()) {
			if (ifc2x3Package.getEClassifier(eClassifier.getName()) == null) {
				if (eClassifier instanceof EEnum) {
					System.out.println("NEW ENUM - " + eClassifier.getName());
					addedEnum++;
				} else if (eClassifier instanceof EClass) {
					System.out.println("NEW ENTITY - " + eClassifier.getName());
					addedEntity++;
				}
			}
		}
		System.out.println();
		System.out.println("Summary:");
		System.out.println();
		System.out.println("Removed entity " + removedEntity);
		System.out.println("Added entity " + addedEntity);
		System.out.println("Removed enum literal " + removedEnumLiteral);
		System.out.println("Added enum literal " + addedEnumLiteral);
		System.out.println("Removed attribute " + removedAttribute);
		System.out.println("Added attribute " + addedAttribute);
		System.out.println("Changed attribute type " + changedType);
		System.out.println("Changed attribute multiplicity " + changedMultiplicity);
		System.out.println("Removed superclass " + removedSuperClass);
		System.out.println("Added superclass " + addedSuperClass);
		System.out.println("Removed enum " + removedEnum);
		System.out.println("Added enum " + addedEnum);
	}
}
