package org.bimserver.pb.client;

import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;

public class RpcControllerImpl implements RpcController {

	@Override
	public String errorText() {
		return null;
	}

	@Override
	public boolean failed() {
		return false;
	}

	@Override
	public boolean isCanceled() {
		return false;
	}

	@Override
	public void notifyOnCancel(RpcCallback<Object> callback) {
		
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void setFailed(String reason) {
		
	}

	@Override
	public void startCancel() {
		
	}
}