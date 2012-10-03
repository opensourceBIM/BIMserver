package org.bimserver.webservices;

import java.util.Comparator;

import org.bimserver.interfaces.objects.SPluginConfiguration;

public class SPluginConfigurationComparator implements Comparator<SPluginConfiguration> {

	@Override
	public int compare(SPluginConfiguration o1, SPluginConfiguration o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
