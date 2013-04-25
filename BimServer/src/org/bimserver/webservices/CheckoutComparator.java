package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.models.store.Checkout;

public class CheckoutComparator implements Comparator<Checkout> {

	@Override
	public int compare(Checkout o1, Checkout o2) {
		return o1.getDate().compareTo(o2.getDate());
	}
}