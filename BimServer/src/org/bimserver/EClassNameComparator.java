package org.bimserver;

import java.util.Comparator;

import org.eclipse.emf.ecore.EClass;

public class EClassNameComparator implements Comparator<EClass> {

	@Override
	public int compare(EClass o1, EClass o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
