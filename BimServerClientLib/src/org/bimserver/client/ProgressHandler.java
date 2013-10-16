package org.bimserver.client;

import org.bimserver.interfaces.objects.SLongActionState;

public interface ProgressHandler {
	void progress(SLongActionState state);
}
