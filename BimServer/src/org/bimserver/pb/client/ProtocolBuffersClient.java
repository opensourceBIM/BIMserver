package org.bimserver.pb.client;

import org.bimserver.pb.Service.DownloadRequest;
import org.bimserver.pb.Service.DownloadResponse;
import org.bimserver.pb.Service.GetAllProjectsRequest;
import org.bimserver.pb.Service.GetAllProjectsResponse;
import org.bimserver.pb.Service.GetDownloadDataRequest;
import org.bimserver.pb.Service.GetDownloadDataResponse;
import org.bimserver.pb.Service.GetRevisionRequest;
import org.bimserver.pb.Service.GetRevisionResponse;
import org.bimserver.pb.Service.LoginRequest;
import org.bimserver.pb.Service.LoginResponse;
import org.bimserver.pb.Service.ResultType;
import org.bimserver.pb.Service.SDownloadResult;
import org.bimserver.pb.Service.SProject;
import org.bimserver.pb.Service.ServiceInterface;
import org.bimserver.pb.Service.GetAllProjectsRequest.Builder;
import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ByteString;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class ProtocolBuffersClient {
	private SocketRpcController rpcController;
	private BlockingInterface service;

	public static void main(String[] args) {
		new ProtocolBuffersClient().start();
	}

	private void start() {
		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
		rpcController = new SocketRpcController();

		service = ServiceInterface.newBlockingStub(rpcChannel);
		try {
			login("admin@logic-labs.nl", "admin");
			SProject firstProject = getAllProjects();
			for (long roid : firstProject.getRevisionsList()) {
				System.out.println(roid);
				getRevision(roid);
				downloadRevision(roid);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		    
		if (rpcController.failed()) {
		  System.err.println(String.format("Rpc failed %s : %s", rpcController.errorReason(),
		      rpcController.errorText()));
		}
	}

	private String downloadRevision(long roid) {
		org.bimserver.pb.Service.DownloadRequest.Builder downloadRequestBuilder = DownloadRequest.newBuilder();
		downloadRequestBuilder.setRoid(roid);
		downloadRequestBuilder.setResultType(ResultType.O3D_JSON);
		downloadRequestBuilder.setSync(true);
		DownloadRequest downloadRequest = downloadRequestBuilder.build();
		try {
			DownloadResponse downloadResponse = service.download(rpcController, downloadRequest);
			if (downloadResponse != null) {
				String downloadId = downloadResponse.getValue();
				
				org.bimserver.pb.Service.GetDownloadDataRequest.Builder getDownloadDataRequestBuilder = GetDownloadDataRequest.newBuilder();
				getDownloadDataRequestBuilder.setActionID(downloadId);
				GetDownloadDataRequest getDownloadDataRequest = getDownloadDataRequestBuilder.build();
				
				GetDownloadDataResponse getDownloadDataResponse = service.getDownloadData(rpcController, getDownloadDataRequest);
				if (getDownloadDataResponse != null) {
					SDownloadResult sDownloadResult = getDownloadDataResponse.getValue();
					ByteString file = sDownloadResult.getFile();
					System.out.println(file.size());
				}
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void getRevision(long roid) throws ServiceException {
		org.bimserver.pb.Service.GetRevisionRequest.Builder getRevisionRequestBuilder = GetRevisionRequest.newBuilder();
		getRevisionRequestBuilder.setRoid(roid);
		GetRevisionRequest getRevisionRequest = getRevisionRequestBuilder.build();
		
		GetRevisionResponse getRevisionResponse = service.getRevision(rpcController, getRevisionRequest);
		System.out.println(getRevisionResponse.getValue().getSize());
	}

	private SProject getAllProjects() throws ServiceException {
		Builder getAllProjectsRequestBuilder = GetAllProjectsRequest.newBuilder();
		GetAllProjectsRequest getAllProjectsRequest = getAllProjectsRequestBuilder.build();
		
		GetAllProjectsResponse getAllProjectsResponse = service.getAllProjects(rpcController, getAllProjectsRequest);
		SProject firstProject = null;
		if (getAllProjectsResponse != null) {
			for (SProject sProject : getAllProjectsResponse.getValueList()) {
				if (firstProject == null) {
					firstProject = sProject;
				}
				System.out.println(sProject.getName());
			}
		}
		return firstProject;
	}

	private void login(String username, String password) throws ServiceException {
		LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
		loginRequestBuilder.setUsername(username);
		loginRequestBuilder.setPassword(password);
		LoginRequest loginRequest = loginRequestBuilder.build();
		LoginResponse loginResponse = service.login(rpcController, loginRequest);
		if (loginResponse != null && loginResponse.getValue()) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Error logging in");
		}
	}
}