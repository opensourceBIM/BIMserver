package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SSerializer;

public class SSerializerComparator implements Comparator<SSerializer> {

	@Override
	public int compare(SSerializer o1, SSerializer o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
