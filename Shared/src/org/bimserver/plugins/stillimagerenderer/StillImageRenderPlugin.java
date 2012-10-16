package org.bimserver.plugins.stillimagerenderer;

import org.bimserver.plugins.Plugin;

public interface StillImageRenderPlugin extends Plugin {
	StillImageRenderer create();
}
