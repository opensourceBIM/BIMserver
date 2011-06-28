package org.bimserver.plugins.guidanceproviders;

import org.bimserver.plugins.Plugin;

public interface GuidanceProviderPlugin extends Plugin {
	GuidanceProvider getGuidanceProvider();
	String getDefaultGuidanceProviderName();
}