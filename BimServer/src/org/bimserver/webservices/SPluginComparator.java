package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SPluginDescriptor;

public class SPluginComparator implements Comparator<SPluginDescriptor> {

	@Override
	public int compare(SPluginDescriptor o1, SPluginDescriptor o2) {
		return o1.getName().compareTo(o2.getName());
	}
}