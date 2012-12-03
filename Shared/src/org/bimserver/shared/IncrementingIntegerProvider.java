package org.bimserver.shared;

import org.bimserver.emf.OidProvider;
import org.eclipse.emf.ecore.EClass;

public class IncrementingIntegerProvider implements OidProvider<Integer> {

	private int counter = 0;
	
	@Override
	public Integer newOid(EClass eClass) {
		return counter++;
	}
}
