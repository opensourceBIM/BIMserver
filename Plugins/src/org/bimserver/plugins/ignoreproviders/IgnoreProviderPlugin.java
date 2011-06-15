package org.bimserver.plugins.ignoreproviders;

import org.bimserver.plugins.Plugin;

public interface IgnoreProviderPlugin extends Plugin {
	IgnoreProvider getIgnoreProvider();
}