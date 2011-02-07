package org.bimserver.shared;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SLogAction;

public class SLogActionDateComparator implements Comparator<SLogAction>{

	@Override
	public int compare(SLogAction o1, SLogAction o2) {
		return -o1.getDate().compareTo(o2.getDate());
	}
}