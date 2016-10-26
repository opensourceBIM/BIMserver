package org.bimserver.plugins;

import java.io.InputStream;

import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;

public interface MavenPluginBundle {

	InputStream getPomInputStream();
	InputStream getJarInputStream();
	PluginBundleVersionIdentifier getPluginVersionIdentifier();
	String getVersion();
	SPluginBundle getPluginBundle();
	SPluginBundleVersion getPluginBundleVersion();
}
