package org.bimserver.tools.generators;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public class GenerateUtils {
	public static String makeGetter(EStructuralFeature eStructuralFeature) {
		StringBuilder sb = new StringBuilder();
		if (eStructuralFeature.getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			sb.append("is");
		} else {
			sb.append("get");
		}
		sb.append(firstLetterUpperCase(eStructuralFeature.getName()));
		if (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany()) {
			sb.append("Id");
		}
		return sb.toString();
	}
	
	public static String makeSetter(EStructuralFeature eStructuralFeature) {
		StringBuilder sb = new StringBuilder();
		sb.append("set" + firstLetterUpperCase(eStructuralFeature.getName()));
		if (eStructuralFeature instanceof EReference && !eStructuralFeature.isMany()) {
			sb.append("Id");
		}
		return sb.toString();
	}

	private static String firstLetterUpperCase(String in) {
		return in.substring(0, 1).toUpperCase() + in.substring(1);
	}
}