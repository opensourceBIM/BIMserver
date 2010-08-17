package org.bimserver.shared;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SCheckout;

public class SCheckoutDateComparator implements Comparator<SCheckout> {

	@Override
	public int compare(SCheckout o1, SCheckout o2) {
		return o1.getDate().compareTo(o2.getDate());
	}
}