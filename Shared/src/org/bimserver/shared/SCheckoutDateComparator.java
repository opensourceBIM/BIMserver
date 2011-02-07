package org.bimserver.shared;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SCheckout;

public class SCheckoutDateComparator implements Comparator<SCheckout> {

	private final boolean ascending;

	public SCheckoutDateComparator(boolean ascending) {
		this.ascending = ascending;
	}
	
	@Override
	public int compare(SCheckout o1, SCheckout o2) {
		if (ascending) {
			return o1.getDate().compareTo(o2.getDate());
		} else {
			return o2.getDate().compareTo(o1.getDate());
		}
	}
}