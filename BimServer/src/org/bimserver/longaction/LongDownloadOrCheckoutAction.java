package org.bimserver.longaction;

import org.bimserver.shared.LongActionState;
import org.bimserver.shared.SCheckoutResult;

public abstract class LongDownloadOrCheckoutAction extends LongAction {

	public LongDownloadOrCheckoutAction() {
		super();
	}

	public abstract SCheckoutResult getCheckoutResult();
	
	public abstract LongActionState getState();

}
