package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.shared.SPlugin;

public class SPluginComparator implements Comparator<SPlugin> {

	@Override
	public int compare(SPlugin o1, SPlugin o2) {
		return o1.getName().compareTo(o2.getName());
	}
}