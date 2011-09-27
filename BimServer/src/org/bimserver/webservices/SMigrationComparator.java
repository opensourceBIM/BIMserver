package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SMigration;

public class SMigrationComparator implements Comparator<SMigration> {

	@Override
	public int compare(SMigration o1, SMigration o2) {
		return o1.getNumber() - o2.getNumber();
	}
}
