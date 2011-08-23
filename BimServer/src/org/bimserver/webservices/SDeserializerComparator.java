package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SDeserializer;

public class SDeserializerComparator implements Comparator<SDeserializer> {

	@Override
	public int compare(SDeserializer o1, SDeserializer o2) {
		return o1.getName().compareTo(o2.getName());
	}
}