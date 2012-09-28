package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SLogAction;

public class SLogComparator implements Comparator<SLogAction> {

	private boolean ascending;

	public SLogComparator(boolean ascending) {
		this.ascending = ascending;
	}

	@Override
	public int compare(SLogAction o1, SLogAction o2) {
		return o1.getDate().compareTo(o2.getDate()) * (ascending ? 1 : -1);
	}
}
