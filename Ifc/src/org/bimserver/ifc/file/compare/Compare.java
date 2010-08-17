package org.bimserver.ifc.file.compare;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.bimserver.ifc.FieldIgnoreMap;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.ifc.emf.Ifc2x3.Ifc2x3Package;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Compare {
	private final Set<EObject> comparing = new HashSet<EObject>();
	private final FieldIgnoreMap fieldIgnoreMap;

	public Compare(FieldIgnoreMap fieldIgnoreMap) {
		this.fieldIgnoreMap = fieldIgnoreMap;
	}
	
	public CompareResult compare(IfcModel model1, IfcModel model2) {
		CompareResult result = new CompareResult();
		try {
			IfcDatabase database1 = new IfcDatabase(model1, fieldIgnoreMap);
			database1.buildGuidIndex();
			IfcDatabase database2 = new IfcDatabase(model2, fieldIgnoreMap);
			database2.buildGuidIndex();

			for (EClassifier eClassifier : Ifc2x3Package.eINSTANCE.getEClassifiers()) {
				if (eClassifier instanceof EClass && Ifc2x3Package.eINSTANCE.getIfcRoot().isSuperTypeOf((EClass) eClassifier)) {
					EClass eClass = (EClass)eClassifier;
					for (String guid : database1.getGuids(eClass)) {
						EObject eObject1 = database1.getByGuid(eClass, guid);
						EObject eObject2 = database2.getByGuid(eClass, guid);
						compareEObjects(eClass, eObject1, eObject2, result);
					}
					for (String guid : database2.getGuids(eClass)) {
						EObject eObject1 = database1.getByGuid(eClass, guid);
						EObject eObject2 = database2.getByGuid(eClass, guid);
						compareEObjects(eClass, eObject1, eObject2, result);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void compareEObjects(EClass originalQueryClass, EObject eObject1, EObject eObject2, CompareResult result) {
		if (eObject1 == null && eObject2 == null) {
			return;
		}
		if (eObject1 == null && eObject2 != null) {
			result.add(eObject2, CompareResult.Type.ADDED);
			return;
		}
		if (eObject1 != null && eObject2 == null) {
			result.add(eObject1, CompareResult.Type.DELETED);
			return;
		}
		if (eObject1.eClass() != eObject2.eClass()) {
			return;
		}
		EClass eClass = eObject1.eClass();
		if (comparing.contains(eObject1)) {
			return;
		}
		comparing.add(eObject1);
		for (EStructuralFeature eStructuralFeature : eClass.getEAllStructuralFeatures()) {
			if (!fieldIgnoreMap.shouldIgnoreField(originalQueryClass, eClass, eStructuralFeature)) {
				Object value1 = eObject1.eGet(eStructuralFeature);
				Object value2 = eObject2.eGet(eStructuralFeature);
//				System.err.println("v1 " + value1);
//				System.err.println("v2 " + value2);
//				System.err.println(eClass.getName() + "." + eStructuralFeature.getName());
				if (eStructuralFeature.getUpperBound() == -1 || eStructuralFeature.getUpperBound() > 1) {
					List<?> list1 = (EList<?>) value1;
					List<?> list2 = (EList<?>) value2;
					if (list1.size() == list2.size()) {
						Iterator<?> iterator = list2.iterator();
						for (Object o1 : list1) {
							Object o2 = iterator.next();
							if (o1 instanceof EObject && o2 instanceof EObject) {
								compareEObjects(originalQueryClass, (EObject) o1, (EObject) o2, result);
							}
						}
					} else {
//						System.out.println("different " + eClass.getName() + "." + eStructuralFeature.getName() + " " + list1.size() + " " + list2.size());
					}
				} else {
					if (eStructuralFeature.getEType() instanceof EClass) {
						if (Ifc2x3Package.eINSTANCE.getWrappedValue().isSuperTypeOf((EClass) eStructuralFeature.getEType())) {
							EClass subClass = (EClass) eStructuralFeature.getEType();
							if (value1 == null && value2 == null) {
							} else if (value1 == null && value2 != null) {
							} else if (value1 != null && value2 == null) {
							} else {
								Object realVal1 = ((EObject) value1).eGet(subClass.getEStructuralFeature("wrappedValue"));
								Object realVal2 = ((EObject) value2).eGet(subClass.getEStructuralFeature("wrappedValue"));
								if (realVal1.equals(realVal2)) {
								} else {
//									System.out.println("different " + eClass.getName() + "." + eStructuralFeature.getName() + " " + realVal1 + " " + realVal2);
								}
							}
						} else {
							compareEObjects(originalQueryClass, (EObject) value1, (EObject) value2, result);
						}
					}
				}
			}
		}
	}
}