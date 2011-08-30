package org.bimserver.pb;

import java.util.*;
import com.google.protobuf.*;
import org.bimserver.utils.*;
import org.bimserver.pb.Service.*;
import com.google.protobuf.BlockingRpcChannel;
import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;
import com.googlecode.protobuf.socketrpc.SocketRpcController;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;

@SuppressWarnings("unused")
public class ProtocolBuffersServiceInterfaceImplementation implements org.bimserver.shared.ServiceInterface {

	private BlockingInterface service;

	private SocketRpcController rpcController;

	public ProtocolBuffersServiceInterfaceImplementation(String address, int port) {
		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory(address, port));
		rpcController = new SocketRpcController();
		service = ServiceInterface.newBlockingStub(rpcChannel);
	}

	public org.bimserver.shared.SCompareResult compare(java.lang.Long roid1, java.lang.Long roid2, org.bimserver.shared.SCompareResult.SCompareType sCompareType, org.bimserver.shared.SCompareResult.SCompareIdentifier sCompareIdentifier) {
		try {
			CompareRequest.Builder requestBuilder = CompareRequest.newBuilder();
			requestBuilder.setRoid1(roid1);
			requestBuilder.setRoid2(roid2);
			requestBuilder.setSCompareType(Service.SCompareType.values()[sCompareType.ordinal()]);
			requestBuilder.setSCompareIdentifier(Service.SCompareIdentifier.values()[sCompareIdentifier.ordinal()]);
			CompareRequest request = requestBuilder.build();
			CompareResponse response = service.compare(rpcController, request);
			org.bimserver.shared.SCompareResult realResult = new org.bimserver.shared.SCompareResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void setup(java.lang.String siteAddress, java.lang.String smtpServer, java.lang.String adminName, java.lang.String adminUsername, java.lang.String adminPassword, java.lang.Boolean createAnonymousUser) {
		try {
			SetupRequest.Builder requestBuilder = SetupRequest.newBuilder();
			requestBuilder.setSiteAddress(siteAddress);
			requestBuilder.setSmtpServer(smtpServer);
			requestBuilder.setAdminName(adminName);
			requestBuilder.setAdminUsername(adminUsername);
			requestBuilder.setAdminPassword(adminPassword);
			requestBuilder.setCreateAnonymousUser(createAnonymousUser);
			SetupRequest request = requestBuilder.build();
			service.setup(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Long createObject(java.lang.String className) {
		try {
			CreateObjectRequest.Builder requestBuilder = CreateObjectRequest.newBuilder();
			requestBuilder.setClassName(className);
			CreateObjectRequest request = requestBuilder.build();
			CreateObjectResponse response = service.createObject(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0L;
	}

	public void removeAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer index) {
		try {
			RemoveAttributeRequest.Builder requestBuilder = RemoveAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setIndex(index);
			RemoveAttributeRequest request = requestBuilder.build();
			service.removeAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Integer checkout(java.lang.Long roid, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			CheckoutRequest.Builder requestBuilder = CheckoutRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			CheckoutRequest request = requestBuilder.build();
			CheckoutResponse response = service.checkout(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.util.Set<org.bimserver.shared.SMigration> getMigrations() {
		try {
			GetMigrationsRequest.Builder requestBuilder = GetMigrationsRequest.newBuilder();
			GetMigrationsRequest request = requestBuilder.build();
			GetMigrationsResponse response = service.getMigrations(rpcController, request);
			java.util.Set<org.bimserver.shared.SMigration> realResult = new HashSet<org.bimserver.shared.SMigration>();
			List<Service.SMigration> originalList = response.getValueList();
			for (Service.SMigration val : originalList) {
				org.bimserver.shared.SMigration v = new org.bimserver.shared.SMigration();
				v.setNumber(val.getNumber());
				v.setDescription(val.getDescription());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() {
		try {
			GetAccessMethodRequest.Builder requestBuilder = GetAccessMethodRequest.newBuilder();
			GetAccessMethodRequest request = requestBuilder.build();
			GetAccessMethodResponse response = service.getAccessMethod(rpcController, request);
			return null;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() {
		try {
			IsSettingSendConfirmationEmailAfterRegistrationRequest.Builder requestBuilder = IsSettingSendConfirmationEmailAfterRegistrationRequest.newBuilder();
			IsSettingSendConfirmationEmailAfterRegistrationRequest request = requestBuilder.build();
			IsSettingSendConfirmationEmailAfterRegistrationResponse response = service.isSettingSendConfirmationEmailAfterRegistration(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean sendConfirmationEmailAfterRegistration) {
		try {
			SetSettingSendConfirmationEmailAfterRegistrationRequest.Builder requestBuilder = SetSettingSendConfirmationEmailAfterRegistrationRequest.newBuilder();
			requestBuilder.setSendConfirmationEmailAfterRegistration(sendConfirmationEmailAfterRegistration);
			SetSettingSendConfirmationEmailAfterRegistrationRequest request = requestBuilder.build();
			service.setSettingSendConfirmationEmailAfterRegistration(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Integer checkoutLastRevision(java.lang.Long poid, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			CheckoutLastRevisionRequest.Builder requestBuilder = CheckoutLastRevisionRequest.newBuilder();
			requestBuilder.setPoid(poid);
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			CheckoutLastRevisionRequest request = requestBuilder.build();
			CheckoutLastRevisionResponse response = service.checkoutLastRevision(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.Long> oids, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			DownloadByOidsRequest.Builder requestBuilder = DownloadByOidsRequest.newBuilder();
			for (java.lang.Long val : roids) {
				Long v = val;
				requestBuilder.addRoids(v);
			}
			for (java.lang.Long val : oids) {
				Long v = val;
				requestBuilder.addOids(v);
			}
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			DownloadByOidsRequest request = requestBuilder.build();
			DownloadByOidsResponse response = service.downloadByOids(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.lang.Integer downloadOfType(java.lang.Long roid, java.lang.String className, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			DownloadOfTypeRequest.Builder requestBuilder = DownloadOfTypeRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setClassName(className);
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			DownloadOfTypeRequest request = requestBuilder.build();
			DownloadOfTypeResponse response = service.downloadOfType(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> guids, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			DownloadByGuidsRequest.Builder requestBuilder = DownloadByGuidsRequest.newBuilder();
			for (java.lang.Long val : roids) {
				Long v = val;
				requestBuilder.addRoids(v);
			}
			for (java.lang.String val : guids) {
				String v = val;
				requestBuilder.addGuids(v);
			}
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			DownloadByGuidsRequest request = requestBuilder.build();
			DownloadByGuidsResponse response = service.downloadByGuids(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.lang.Integer downloadProjects(java.util.Set<java.lang.Long> roids, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			DownloadProjectsRequest.Builder requestBuilder = DownloadProjectsRequest.newBuilder();
			for (java.lang.Long val : roids) {
				Long v = val;
				requestBuilder.addRoids(v);
			}
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			DownloadProjectsRequest request = requestBuilder.build();
			DownloadProjectsResponse response = service.downloadProjects(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public org.bimserver.shared.SDownloadResult getDownloadData(java.lang.Integer actionID) {
		try {
			GetDownloadDataRequest.Builder requestBuilder = GetDownloadDataRequest.newBuilder();
			requestBuilder.setActionID(actionID);
			GetDownloadDataRequest request = requestBuilder.build();
			GetDownloadDataResponse response = service.getDownloadData(rpcController, request);
			org.bimserver.shared.SDownloadResult realResult = new org.bimserver.shared.SDownloadResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.LongActionState getDownloadState(java.lang.Integer actionID) {
		try {
			GetDownloadStateRequest.Builder requestBuilder = GetDownloadStateRequest.newBuilder();
			requestBuilder.setActionID(actionID);
			GetDownloadStateRequest request = requestBuilder.build();
			GetDownloadStateResponse response = service.getDownloadState(rpcController, request);
			org.bimserver.shared.LongActionState realResult = new org.bimserver.shared.LongActionState();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void changeUserType(java.lang.Long uoid, org.bimserver.interfaces.objects.SUserType userType) {
		try {
			ChangeUserTypeRequest.Builder requestBuilder = ChangeUserTypeRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			requestBuilder.setUserType(Service.SUserType.values()[userType.ordinal()]);
			ChangeUserTypeRequest request = requestBuilder.build();
			service.changeUserType(rpcController, request);
		} catch (Exception e) {}
	}

	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String projectName, java.lang.Long parentPoid) {
		try {
			AddProjectAsSubProjectRequest.Builder requestBuilder = AddProjectAsSubProjectRequest.newBuilder();
			requestBuilder.setProjectName(projectName);
			requestBuilder.setParentPoid(parentPoid);
			AddProjectAsSubProjectRequest request = requestBuilder.build();
			AddProjectAsSubProjectResponse response = service.addProjectAsSubProject(rpcController, request);
			org.bimserver.interfaces.objects.SProject realResult = new org.bimserver.interfaces.objects.SProject();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void updateProject(org.bimserver.interfaces.objects.SProject sProject) {
		try {
			UpdateProjectRequest.Builder requestBuilder = UpdateProjectRequest.newBuilder();
			Service.SProject.Builder newVal = SProject.newBuilder();
			newVal.setName(sProject.getName());
			newVal.setId(sProject.getId());
			newVal.setState(SObjectState.values()[sProject.getState().ordinal()]);
			newVal.setDescription(sProject.getDescription());
			for (java.lang.Long o : sProject.getSubProjects()) {
				newVal.addSubProjects(o);
			}
			for (java.lang.Long o : sProject.getHasAuthorizedUsers()) {
				newVal.addHasAuthorizedUsers(o);
			}
			for (java.lang.Long o : sProject.getConcreteRevisions()) {
				newVal.addConcreteRevisions(o);
			}
			newVal.setLastConcreteRevisionId(sProject.getLastConcreteRevisionId());
			newVal.setLastRevisionId(sProject.getLastRevisionId());
			newVal.setCreatedDate(sProject.getCreatedDate().getTime());
			newVal.setCreatedById(sProject.getCreatedById());
			newVal.setClashDetectionSettingsId(sProject.getClashDetectionSettingsId());
			newVal.setExportLengthMeasurePrefix(SSIPrefix.values()[sProject.getExportLengthMeasurePrefix().ordinal()]);
			newVal.setOid(sProject.getOid());
			for (java.lang.Long o : sProject.getRevisions()) {
				newVal.addRevisions(o);
			}
			for (java.lang.Long o : sProject.getCheckouts()) {
				newVal.addCheckouts(o);
			}
			newVal.setGeoTagId(sProject.getGeoTagId());
			newVal.setParentId(sProject.getParentId());
			requestBuilder.setSProject(newVal.build());
			UpdateProjectRequest request = requestBuilder.build();
			service.updateProject(rpcController, request);
		} catch (Exception e) {}
	}

	public void updateRevision(org.bimserver.interfaces.objects.SRevision sRevision) {
		try {
			UpdateRevisionRequest.Builder requestBuilder = UpdateRevisionRequest.newBuilder();
			Service.SRevision.Builder newVal = SRevision.newBuilder();
			newVal.setId(sRevision.getId());
			newVal.setState(SCheckinState.values()[sRevision.getState().ordinal()]);
			newVal.setSize(sRevision.getSize());
			newVal.setDate(sRevision.getDate().getTime());
			newVal.setComment(sRevision.getComment());
			newVal.setTag(sRevision.getTag());
			for (java.lang.Long o : sRevision.getLastClashes()) {
				newVal.addLastClashes(o);
			}
			for (java.lang.Long o : sRevision.getConcreteRevisions()) {
				newVal.addConcreteRevisions(o);
			}
			newVal.setLastConcreteRevisionId(sRevision.getLastConcreteRevisionId());
			newVal.setOid(sRevision.getOid());
			for (java.lang.Long o : sRevision.getCheckouts()) {
				newVal.addCheckouts(o);
			}
			newVal.setUserId(sRevision.getUserId());
			newVal.setProjectId(sRevision.getProjectId());
			newVal.setLastError(sRevision.getLastError());
			newVal.setBmi(sRevision.getBmi());
			newVal.setNrClashes(sRevision.getNrClashes());
			newVal.setLaid(sRevision.getLaid());
			requestBuilder.setSRevision(newVal.build());
			UpdateRevisionRequest request = requestBuilder.build();
			service.updateRevision(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean addUserToProject(java.lang.Long uoid, java.lang.Long poid) {
		try {
			AddUserToProjectRequest.Builder requestBuilder = AddUserToProjectRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			requestBuilder.setPoid(poid);
			AddUserToProjectRequest request = requestBuilder.build();
			AddUserToProjectResponse response = service.addUserToProject(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.lang.Boolean removeUserFromProject(java.lang.Long uoid, java.lang.Long poid) {
		try {
			RemoveUserFromProjectRequest.Builder requestBuilder = RemoveUserFromProjectRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			requestBuilder.setPoid(poid);
			RemoveUserFromProjectRequest request = requestBuilder.build();
			RemoveUserFromProjectResponse response = service.removeUserFromProject(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.lang.Boolean deleteProject(java.lang.Long poid) {
		try {
			DeleteProjectRequest.Builder requestBuilder = DeleteProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			DeleteProjectRequest request = requestBuilder.build();
			DeleteProjectResponse response = service.deleteProject(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() {
		try {
			GetAllProjectsRequest.Builder requestBuilder = GetAllProjectsRequest.newBuilder();
			GetAllProjectsRequest request = requestBuilder.build();
			GetAllProjectsResponse response = service.getAllProjects(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() {
		try {
			GetAllReadableProjectsRequest.Builder requestBuilder = GetAllReadableProjectsRequest.newBuilder();
			GetAllReadableProjectsRequest request = requestBuilder.build();
			GetAllReadableProjectsResponse response = service.getAllReadableProjects(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long poid) {
		try {
			GetAllRevisionsOfProjectRequest.Builder requestBuilder = GetAllRevisionsOfProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetAllRevisionsOfProjectRequest request = requestBuilder.build();
			GetAllRevisionsOfProjectResponse response = service.getAllRevisionsOfProject(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SRevision> realResult = new ArrayList<org.bimserver.interfaces.objects.SRevision>();
			List<Service.SRevision> originalList = response.getValueList();
			for (Service.SRevision val : originalList) {
				org.bimserver.interfaces.objects.SRevision v = new org.bimserver.interfaces.objects.SRevision();
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SCheckinState.values()[val.getState().ordinal()]);
				v.setSize(val.getSize());
				v.setDate(new Date(val.getDate()));
				v.setComment(val.getComment());
				v.setTag(val.getTag());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				v.setLastError(val.getLastError());
				v.setBmi(val.getBmi());
				v.setNrClashes(val.getNrClashes());
				v.setLaid(val.getLaid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long poid) {
		try {
			GetAllCheckoutsOfProjectRequest.Builder requestBuilder = GetAllCheckoutsOfProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetAllCheckoutsOfProjectRequest request = requestBuilder.build();
			GetAllCheckoutsOfProjectResponse response = service.getAllCheckoutsOfProject(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SCheckout> realResult = new ArrayList<org.bimserver.interfaces.objects.SCheckout>();
			List<Service.SCheckout> originalList = response.getValueList();
			for (Service.SCheckout val : originalList) {
				org.bimserver.interfaces.objects.SCheckout v = new org.bimserver.interfaces.objects.SCheckout();
				v.setDate(new Date(val.getDate()));
				v.setRevisionId(val.getRevisionId());
				v.setCheckinId(val.getCheckinId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long uoid) {
		try {
			GetAllRevisionsByUserRequest.Builder requestBuilder = GetAllRevisionsByUserRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			GetAllRevisionsByUserRequest request = requestBuilder.build();
			GetAllRevisionsByUserResponse response = service.getAllRevisionsByUser(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SRevision> realResult = new ArrayList<org.bimserver.interfaces.objects.SRevision>();
			List<Service.SRevision> originalList = response.getValueList();
			for (Service.SRevision val : originalList) {
				org.bimserver.interfaces.objects.SRevision v = new org.bimserver.interfaces.objects.SRevision();
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SCheckinState.values()[val.getState().ordinal()]);
				v.setSize(val.getSize());
				v.setDate(new Date(val.getDate()));
				v.setComment(val.getComment());
				v.setTag(val.getTag());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				v.setLastError(val.getLastError());
				v.setBmi(val.getBmi());
				v.setNrClashes(val.getNrClashes());
				v.setLaid(val.getLaid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long uoid) {
		try {
			GetAllCheckoutsByUserRequest.Builder requestBuilder = GetAllCheckoutsByUserRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			GetAllCheckoutsByUserRequest request = requestBuilder.build();
			GetAllCheckoutsByUserResponse response = service.getAllCheckoutsByUser(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SCheckout> realResult = new ArrayList<org.bimserver.interfaces.objects.SCheckout>();
			List<Service.SCheckout> originalList = response.getValueList();
			for (Service.SCheckout val : originalList) {
				org.bimserver.interfaces.objects.SCheckout v = new org.bimserver.interfaces.objects.SCheckout();
				v.setDate(new Date(val.getDate()));
				v.setRevisionId(val.getRevisionId());
				v.setCheckinId(val.getCheckinId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long roid) {
		try {
			GetAllCheckoutsOfRevisionRequest.Builder requestBuilder = GetAllCheckoutsOfRevisionRequest.newBuilder();
			requestBuilder.setRoid(roid);
			GetAllCheckoutsOfRevisionRequest request = requestBuilder.build();
			GetAllCheckoutsOfRevisionResponse response = service.getAllCheckoutsOfRevision(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SCheckout> realResult = new ArrayList<org.bimserver.interfaces.objects.SCheckout>();
			List<Service.SCheckout> originalList = response.getValueList();
			for (Service.SCheckout val : originalList) {
				org.bimserver.interfaces.objects.SCheckout v = new org.bimserver.interfaces.objects.SCheckout();
				v.setDate(new Date(val.getDate()));
				v.setRevisionId(val.getRevisionId());
				v.setCheckinId(val.getCheckinId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long poid) {
		try {
			GetProjectByPoidRequest.Builder requestBuilder = GetProjectByPoidRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetProjectByPoidRequest request = requestBuilder.build();
			GetProjectByPoidResponse response = service.getProjectByPoid(rpcController, request);
			org.bimserver.interfaces.objects.SProject realResult = new org.bimserver.interfaces.objects.SProject();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<java.lang.String> getAvailableClasses() {
		try {
			GetAvailableClassesRequest.Builder requestBuilder = GetAvailableClassesRequest.newBuilder();
			GetAvailableClassesRequest request = requestBuilder.build();
			GetAvailableClassesResponse response = service.getAvailableClasses(rpcController, request);
			java.util.List<java.lang.String> realResult = new ArrayList<java.lang.String>();
			List<String> originalList = response.getValueList();
			for (String val : originalList) {
				realResult.add(val);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.DatabaseInformation getDatabaseInformation() {
		try {
			GetDatabaseInformationRequest.Builder requestBuilder = GetDatabaseInformationRequest.newBuilder();
			GetDatabaseInformationRequest request = requestBuilder.build();
			GetDatabaseInformationResponse response = service.getDatabaseInformation(rpcController, request);
			org.bimserver.shared.DatabaseInformation realResult = new org.bimserver.shared.DatabaseInformation();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.Date getLastDatabaseReset() {
		try {
			GetLastDatabaseResetRequest.Builder requestBuilder = GetLastDatabaseResetRequest.newBuilder();
			GetLastDatabaseResetRequest request = requestBuilder.build();
			GetLastDatabaseResetResponse response = service.getLastDatabaseReset(rpcController, request);
			java.util.Date realResult = new java.util.Date();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SUser getLoggedInUser() {
		try {
			GetLoggedInUserRequest.Builder requestBuilder = GetLoggedInUserRequest.newBuilder();
			GetLoggedInUserRequest request = requestBuilder.build();
			GetLoggedInUserResponse response = service.getLoggedInUser(rpcController, request);
			org.bimserver.interfaces.objects.SUser realResult = new org.bimserver.interfaces.objects.SUser();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean changePassword(java.lang.Long uoid, java.lang.String oldPassword, java.lang.String newPassword) {
		try {
			ChangePasswordRequest.Builder requestBuilder = ChangePasswordRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			requestBuilder.setOldPassword(oldPassword);
			requestBuilder.setNewPassword(newPassword);
			ChangePasswordRequest request = requestBuilder.build();
			ChangePasswordResponse response = service.changePassword(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String username) {
		try {
			GetUserByUserNameRequest.Builder requestBuilder = GetUserByUserNameRequest.newBuilder();
			requestBuilder.setUsername(username);
			GetUserByUserNameRequest request = requestBuilder.build();
			GetUserByUserNameResponse response = service.getUserByUserName(rpcController, request);
			org.bimserver.interfaces.objects.SUser realResult = new org.bimserver.interfaces.objects.SUser();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean undeleteProject(java.lang.Long poid) {
		try {
			UndeleteProjectRequest.Builder requestBuilder = UndeleteProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			UndeleteProjectRequest request = requestBuilder.build();
			UndeleteProjectResponse response = service.undeleteProject(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public org.bimserver.shared.SRevisionSummary getRevisionSummary(java.lang.Long roid) {
		try {
			GetRevisionSummaryRequest.Builder requestBuilder = GetRevisionSummaryRequest.newBuilder();
			requestBuilder.setRoid(roid);
			GetRevisionSummaryRequest request = requestBuilder.build();
			GetRevisionSummaryResponse response = service.getRevisionSummary(rpcController, request);
			org.bimserver.shared.SRevisionSummary realResult = new org.bimserver.shared.SRevisionSummary();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean userHasCheckinRights(java.lang.Long poid) {
		try {
			UserHasCheckinRightsRequest.Builder requestBuilder = UserHasCheckinRightsRequest.newBuilder();
			requestBuilder.setPoid(poid);
			UserHasCheckinRightsRequest request = requestBuilder.build();
			UserHasCheckinRightsResponse response = service.userHasCheckinRights(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long poid) {
		try {
			GetCheckoutWarningsRequest.Builder requestBuilder = GetCheckoutWarningsRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetCheckoutWarningsRequest request = requestBuilder.build();
			GetCheckoutWarningsResponse response = service.getCheckoutWarnings(rpcController, request);
			java.util.Set<java.lang.String> realResult = new HashSet<java.lang.String>();
			List<String> originalList = response.getValueList();
			for (String val : originalList) {
				realResult.add(val);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean userHasRights(java.lang.Long poid) {
		try {
			UserHasRightsRequest.Builder requestBuilder = UserHasRightsRequest.newBuilder();
			requestBuilder.setPoid(poid);
			UserHasRightsRequest request = requestBuilder.build();
			UserHasRightsResponse response = service.userHasRights(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public org.bimserver.shared.SDataObject getDataObjectByOid(java.lang.Long roid, java.lang.Long oid, java.lang.String className) {
		try {
			GetDataObjectByOidRequest.Builder requestBuilder = GetDataObjectByOidRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			GetDataObjectByOidRequest request = requestBuilder.build();
			GetDataObjectByOidResponse response = service.getDataObjectByOid(rpcController, request);
			org.bimserver.shared.SDataObject realResult = new org.bimserver.shared.SDataObject();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.SDataObject getDataObjectByGuid(java.lang.Long roid, java.lang.String guid) {
		try {
			GetDataObjectByGuidRequest.Builder requestBuilder = GetDataObjectByGuidRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setGuid(guid);
			GetDataObjectByGuidRequest request = requestBuilder.build();
			GetDataObjectByGuidResponse response = service.getDataObjectByGuid(rpcController, request);
			org.bimserver.shared.SDataObject realResult = new org.bimserver.shared.SDataObject();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.shared.SDataObject> getDataObjectsByType(java.lang.Long roid, java.lang.String className) {
		try {
			GetDataObjectsByTypeRequest.Builder requestBuilder = GetDataObjectsByTypeRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setClassName(className);
			GetDataObjectsByTypeRequest request = requestBuilder.build();
			GetDataObjectsByTypeResponse response = service.getDataObjectsByType(rpcController, request);
			java.util.List<org.bimserver.shared.SDataObject> realResult = new ArrayList<org.bimserver.shared.SDataObject>();
			List<Service.SDataObject> originalList = response.getValueList();
			for (Service.SDataObject val : originalList) {
				org.bimserver.shared.SDataObject v = new org.bimserver.shared.SDataObject();
				v.setName(val.getName());
				v.setType(val.getType());
				v.setOid(val.getOid());
				v.setGuid(val.getGuid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SGuidClash> findClashesByGuid(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) {
		try {
			FindClashesByGuidRequest.Builder requestBuilder = FindClashesByGuidRequest.newBuilder();
			Service.SClashDetectionSettings.Builder newVal = SClashDetectionSettings.newBuilder();
			for (java.lang.Long o : sClashDetectionSettings.getProjects()) {
				newVal.addProjects(o);
			}
			for (java.lang.String o : sClashDetectionSettings.getIgnoredClasses()) {
				newVal.addIgnoredClasses(o);
			}
			newVal.setOid(sClashDetectionSettings.getOid());
			for (java.lang.Long o : sClashDetectionSettings.getRevisions()) {
				newVal.addRevisions(o);
			}
			newVal.setMargin(sClashDetectionSettings.getMargin());
			requestBuilder.setSClashDetectionSettings(newVal.build());
			FindClashesByGuidRequest request = requestBuilder.build();
			FindClashesByGuidResponse response = service.findClashesByGuid(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SGuidClash> realResult = new ArrayList<org.bimserver.interfaces.objects.SGuidClash>();
			List<Service.SGuidClash> originalList = response.getValueList();
			for (Service.SGuidClash val : originalList) {
				org.bimserver.interfaces.objects.SGuidClash v = new org.bimserver.interfaces.objects.SGuidClash();
				v.setGuid1(val.getGuid1());
				v.setGuid2(val.getGuid2());
				v.setOid(val.getOid());
				v.setRevision1Id(val.getRevision1Id());
				v.setRevision2Id(val.getRevision2Id());
				v.setName1(val.getName1());
				v.setName2(val.getName2());
				v.setType1(val.getType1());
				v.setType2(val.getType2());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SEidClash> findClashesByEid(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) {
		try {
			FindClashesByEidRequest.Builder requestBuilder = FindClashesByEidRequest.newBuilder();
			Service.SClashDetectionSettings.Builder newVal = SClashDetectionSettings.newBuilder();
			for (java.lang.Long o : sClashDetectionSettings.getProjects()) {
				newVal.addProjects(o);
			}
			for (java.lang.String o : sClashDetectionSettings.getIgnoredClasses()) {
				newVal.addIgnoredClasses(o);
			}
			newVal.setOid(sClashDetectionSettings.getOid());
			for (java.lang.Long o : sClashDetectionSettings.getRevisions()) {
				newVal.addRevisions(o);
			}
			newVal.setMargin(sClashDetectionSettings.getMargin());
			requestBuilder.setSClashDetectionSettings(newVal.build());
			FindClashesByEidRequest request = requestBuilder.build();
			FindClashesByEidResponse response = service.findClashesByEid(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SEidClash> realResult = new ArrayList<org.bimserver.interfaces.objects.SEidClash>();
			List<Service.SEidClash> originalList = response.getValueList();
			for (Service.SEidClash val : originalList) {
				org.bimserver.interfaces.objects.SEidClash v = new org.bimserver.interfaces.objects.SEidClash();
				v.setEid1(val.getEid1());
				v.setEid2(val.getEid2());
				v.setOid(val.getOid());
				v.setRevision1Id(val.getRevision1Id());
				v.setRevision2Id(val.getRevision2Id());
				v.setName1(val.getName1());
				v.setName2(val.getName2());
				v.setType1(val.getType1());
				v.setType2(val.getType2());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SClash> getLastClashes(java.lang.Long roid) {
		try {
			GetLastClashesRequest.Builder requestBuilder = GetLastClashesRequest.newBuilder();
			requestBuilder.setRoid(roid);
			GetLastClashesRequest request = requestBuilder.build();
			GetLastClashesResponse response = service.getLastClashes(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SClash> realResult = new ArrayList<org.bimserver.interfaces.objects.SClash>();
			List<Service.SClash> originalList = response.getValueList();
			for (Service.SClash val : originalList) {
				org.bimserver.interfaces.objects.SClash v = new org.bimserver.interfaces.objects.SClash();
				v.setRevision1Id(val.getRevision1Id());
				v.setRevision2Id(val.getRevision2Id());
				v.setName1(val.getName1());
				v.setName2(val.getName2());
				v.setType1(val.getType1());
				v.setType2(val.getType2());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.SCheckinResult branchToNewProject(java.lang.Long roid, java.lang.String projectName, java.lang.String comment) {
		try {
			BranchToNewProjectRequest.Builder requestBuilder = BranchToNewProjectRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setProjectName(projectName);
			requestBuilder.setComment(comment);
			BranchToNewProjectRequest request = requestBuilder.build();
			BranchToNewProjectResponse response = service.branchToNewProject(rpcController, request);
			org.bimserver.shared.SCheckinResult realResult = new org.bimserver.shared.SCheckinResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.SCheckinResult branchToExistingProject(java.lang.Long roid, java.lang.Long destPoid, java.lang.String comment) {
		try {
			BranchToExistingProjectRequest.Builder requestBuilder = BranchToExistingProjectRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setDestPoid(destPoid);
			requestBuilder.setComment(comment);
			BranchToExistingProjectRequest request = requestBuilder.build();
			BranchToExistingProjectResponse response = service.branchToExistingProject(rpcController, request);
			org.bimserver.shared.SCheckinResult realResult = new org.bimserver.shared.SCheckinResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SClashDetectionSettings getClashDetectionSettings(java.lang.Long cdsoid) {
		try {
			GetClashDetectionSettingsRequest.Builder requestBuilder = GetClashDetectionSettingsRequest.newBuilder();
			requestBuilder.setCdsoid(cdsoid);
			GetClashDetectionSettingsRequest request = requestBuilder.build();
			GetClashDetectionSettingsResponse response = service.getClashDetectionSettings(rpcController, request);
			org.bimserver.interfaces.objects.SClashDetectionSettings realResult = new org.bimserver.interfaces.objects.SClashDetectionSettings();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void updateClashDetectionSettings(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings) {
		try {
			UpdateClashDetectionSettingsRequest.Builder requestBuilder = UpdateClashDetectionSettingsRequest.newBuilder();
			Service.SClashDetectionSettings.Builder newVal = SClashDetectionSettings.newBuilder();
			for (java.lang.Long o : sClashDetectionSettings.getProjects()) {
				newVal.addProjects(o);
			}
			for (java.lang.String o : sClashDetectionSettings.getIgnoredClasses()) {
				newVal.addIgnoredClasses(o);
			}
			newVal.setOid(sClashDetectionSettings.getOid());
			for (java.lang.Long o : sClashDetectionSettings.getRevisions()) {
				newVal.addRevisions(o);
			}
			newVal.setMargin(sClashDetectionSettings.getMargin());
			requestBuilder.setSClashDetectionSettings(newVal.build());
			UpdateClashDetectionSettingsRequest request = requestBuilder.build();
			service.updateClashDetectionSettings(rpcController, request);
		} catch (Exception e) {}
	}

	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long uoid) {
		try {
			GetUserByUoidRequest.Builder requestBuilder = GetUserByUoidRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			GetUserByUoidRequest request = requestBuilder.build();
			GetUserByUoidResponse response = service.getUserByUoid(rpcController, request);
			org.bimserver.interfaces.objects.SUser realResult = new org.bimserver.interfaces.objects.SUser();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SUser getAnonymousUser() {
		try {
			GetAnonymousUserRequest.Builder requestBuilder = GetAnonymousUserRequest.newBuilder();
			GetAnonymousUserRequest request = requestBuilder.build();
			GetAnonymousUserResponse response = service.getAnonymousUser(rpcController, request);
			org.bimserver.interfaces.objects.SUser realResult = new org.bimserver.interfaces.objects.SUser();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long uoid) {
		try {
			GetUsersProjectsRequest.Builder requestBuilder = GetUsersProjectsRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			GetUsersProjectsRequest request = requestBuilder.build();
			GetUsersProjectsResponse response = service.getUsersProjects(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String name) {
		try {
			GetProjectsByNameRequest.Builder requestBuilder = GetProjectsByNameRequest.newBuilder();
			requestBuilder.setName(name);
			GetProjectsByNameRequest request = requestBuilder.build();
			GetProjectsByNameResponse response = service.getProjectsByName(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void setRevisionTag(java.lang.Long roid, java.lang.String tag) {
		try {
			SetRevisionTagRequest.Builder requestBuilder = SetRevisionTagRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setTag(tag);
			SetRevisionTagRequest request = requestBuilder.build();
			service.setRevisionTag(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long poid) {
		try {
			GetSubProjectsRequest.Builder requestBuilder = GetSubProjectsRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetSubProjectsRequest request = requestBuilder.build();
			GetSubProjectsResponse response = service.getSubProjects(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void setExportTypeEnabled(java.lang.String resultTypeName, java.lang.Boolean unknown) {
		try {
			SetExportTypeEnabledRequest.Builder requestBuilder = SetExportTypeEnabledRequest.newBuilder();
			requestBuilder.setResultTypeName(resultTypeName);
			requestBuilder.setUnknown(unknown);
			SetExportTypeEnabledRequest request = requestBuilder.build();
			service.setExportTypeEnabled(rpcController, request);
		} catch (Exception e) {}
	}

	public org.bimserver.interfaces.objects.SUser getCurrentUser() {
		try {
			GetCurrentUserRequest.Builder requestBuilder = GetCurrentUserRequest.newBuilder();
			GetCurrentUserRequest request = requestBuilder.build();
			GetCurrentUserResponse response = service.getCurrentUser(rpcController, request);
			org.bimserver.interfaces.objects.SUser realResult = new org.bimserver.interfaces.objects.SUser();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void loginAnonymous() {
		try {
			LoginAnonymousRequest.Builder requestBuilder = LoginAnonymousRequest.newBuilder();
			LoginAnonymousRequest request = requestBuilder.build();
			service.loginAnonymous(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.Date getActiveSince() {
		try {
			GetActiveSinceRequest.Builder requestBuilder = GetActiveSinceRequest.newBuilder();
			GetActiveSinceRequest request = requestBuilder.build();
			GetActiveSinceResponse response = service.getActiveSince(rpcController, request);
			java.util.Date realResult = new java.util.Date();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.Date getLastActive() {
		try {
			GetLastActiveRequest.Builder requestBuilder = GetLastActiveRequest.newBuilder();
			GetLastActiveRequest request = requestBuilder.build();
			GetLastActiveResponse response = service.getLastActive(rpcController, request);
			java.util.Date realResult = new java.util.Date();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.Token getCurrentToken() {
		try {
			GetCurrentTokenRequest.Builder requestBuilder = GetCurrentTokenRequest.newBuilder();
			GetCurrentTokenRequest request = requestBuilder.build();
			GetCurrentTokenResponse response = service.getCurrentToken(rpcController, request);
			org.bimserver.shared.Token realResult = new org.bimserver.shared.Token();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void requestPasswordChange(java.lang.Long uoid) {
		try {
			RequestPasswordChangeRequest.Builder requestBuilder = RequestPasswordChangeRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			RequestPasswordChangeRequest request = requestBuilder.build();
			service.requestPasswordChange(rpcController, request);
		} catch (Exception e) {}
	}

	public void validateAccount(java.lang.Long uoid, java.lang.String token, java.lang.String password) {
		try {
			ValidateAccountRequest.Builder requestBuilder = ValidateAccountRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			requestBuilder.setToken(token);
			requestBuilder.setPassword(password);
			ValidateAccountRequest request = requestBuilder.build();
			service.validateAccount(rpcController, request);
		} catch (Exception e) {}
	}

	public void sendClashesEmail(org.bimserver.interfaces.objects.SClashDetectionSettings sClashDetectionSettings, java.lang.Long poid, java.util.Set<java.lang.String> addressesTo) {
		try {
			SendClashesEmailRequest.Builder requestBuilder = SendClashesEmailRequest.newBuilder();
			Service.SClashDetectionSettings.Builder newVal = SClashDetectionSettings.newBuilder();
			for (java.lang.Long o : sClashDetectionSettings.getProjects()) {
				newVal.addProjects(o);
			}
			for (java.lang.String o : sClashDetectionSettings.getIgnoredClasses()) {
				newVal.addIgnoredClasses(o);
			}
			newVal.setOid(sClashDetectionSettings.getOid());
			for (java.lang.Long o : sClashDetectionSettings.getRevisions()) {
				newVal.addRevisions(o);
			}
			newVal.setMargin(sClashDetectionSettings.getMargin());
			requestBuilder.setSClashDetectionSettings(newVal.build());
			requestBuilder.setPoid(poid);
			for (java.lang.String val : addressesTo) {
				String v = val;
				requestBuilder.addAddressesTo(v);
			}
			SendClashesEmailRequest request = requestBuilder.build();
			service.sendClashesEmail(rpcController, request);
		} catch (Exception e) {}
	}

	public void sendCompareEmail(org.bimserver.shared.SCompareResult.SCompareType sCompareType, org.bimserver.shared.SCompareResult.SCompareIdentifier sCompareIdentifier, java.lang.Long poid, java.lang.Long roid1, java.lang.Long roid2, java.lang.String address) {
		try {
			SendCompareEmailRequest.Builder requestBuilder = SendCompareEmailRequest.newBuilder();
			requestBuilder.setSCompareType(Service.SCompareType.values()[sCompareType.ordinal()]);
			requestBuilder.setSCompareIdentifier(Service.SCompareIdentifier.values()[sCompareIdentifier.ordinal()]);
			requestBuilder.setPoid(poid);
			requestBuilder.setRoid1(roid1);
			requestBuilder.setRoid2(roid2);
			requestBuilder.setAddress(address);
			SendCompareEmailRequest request = requestBuilder.build();
			service.sendCompareEmail(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.String getSettingCustomLogoAddress() {
		try {
			GetSettingCustomLogoAddressRequest.Builder requestBuilder = GetSettingCustomLogoAddressRequest.newBuilder();
			GetSettingCustomLogoAddressRequest request = requestBuilder.build();
			GetSettingCustomLogoAddressResponse response = service.getSettingCustomLogoAddress(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public java.lang.String getSettingHeaderAddition() {
		try {
			GetSettingHeaderAdditionRequest.Builder requestBuilder = GetSettingHeaderAdditionRequest.newBuilder();
			GetSettingHeaderAdditionRequest request = requestBuilder.build();
			GetSettingHeaderAdditionResponse response = service.getSettingHeaderAddition(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public java.lang.String getSettingFooterAddition() {
		try {
			GetSettingFooterAdditionRequest.Builder requestBuilder = GetSettingFooterAdditionRequest.newBuilder();
			GetSettingFooterAdditionRequest request = requestBuilder.build();
			GetSettingFooterAdditionResponse response = service.getSettingFooterAddition(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingCustomLogoAddress(java.lang.String customLogoAddress) {
		try {
			SetSettingCustomLogoAddressRequest.Builder requestBuilder = SetSettingCustomLogoAddressRequest.newBuilder();
			requestBuilder.setCustomLogoAddress(customLogoAddress);
			SetSettingCustomLogoAddressRequest request = requestBuilder.build();
			service.setSettingCustomLogoAddress(rpcController, request);
		} catch (Exception e) {}
	}

	public void setSettingHeaderAddition(java.lang.String headerAddition) {
		try {
			SetSettingHeaderAdditionRequest.Builder requestBuilder = SetSettingHeaderAdditionRequest.newBuilder();
			requestBuilder.setHeaderAddition(headerAddition);
			SetSettingHeaderAdditionRequest request = requestBuilder.build();
			service.setSettingHeaderAddition(rpcController, request);
		} catch (Exception e) {}
	}

	public void setSettingFooterAddition(java.lang.String footerAddition) {
		try {
			SetSettingFooterAdditionRequest.Builder requestBuilder = SetSettingFooterAdditionRequest.newBuilder();
			requestBuilder.setFooterAddition(footerAddition);
			SetSettingFooterAdditionRequest request = requestBuilder.build();
			service.setSettingFooterAddition(rpcController, request);
		} catch (Exception e) {}
	}

	public void setSettingMergeIdentifier(org.bimserver.interfaces.objects.SMergeIdentifier mergeIdentifier) {
		try {
			SetSettingMergeIdentifierRequest.Builder requestBuilder = SetSettingMergeIdentifierRequest.newBuilder();
			requestBuilder.setMergeIdentifier(Service.SMergeIdentifier.values()[mergeIdentifier.ordinal()]);
			SetSettingMergeIdentifierRequest request = requestBuilder.build();
			service.setSettingMergeIdentifier(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.String getSettingEmailSenderAddress() {
		try {
			GetSettingEmailSenderAddressRequest.Builder requestBuilder = GetSettingEmailSenderAddressRequest.newBuilder();
			GetSettingEmailSenderAddressRequest request = requestBuilder.build();
			GetSettingEmailSenderAddressResponse response = service.getSettingEmailSenderAddress(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingEmailSenderAddress(java.lang.String emailSenderAddress) {
		try {
			SetSettingEmailSenderAddressRequest.Builder requestBuilder = SetSettingEmailSenderAddressRequest.newBuilder();
			requestBuilder.setEmailSenderAddress(emailSenderAddress);
			SetSettingEmailSenderAddressRequest request = requestBuilder.build();
			service.setSettingEmailSenderAddress(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.String getSettingEnabledExportTypes() {
		try {
			GetSettingEnabledExportTypesRequest.Builder requestBuilder = GetSettingEnabledExportTypesRequest.newBuilder();
			GetSettingEnabledExportTypesRequest request = requestBuilder.build();
			GetSettingEnabledExportTypesResponse response = service.getSettingEnabledExportTypes(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingEnabledExportTypes(java.util.Set<java.lang.String> enabledExportTypeNames) {
		try {
			SetSettingEnabledExportTypesRequest.Builder requestBuilder = SetSettingEnabledExportTypesRequest.newBuilder();
			for (java.lang.String val : enabledExportTypeNames) {
				String v = val;
				requestBuilder.addEnabledExportTypeNames(v);
			}
			SetSettingEnabledExportTypesRequest request = requestBuilder.build();
			service.setSettingEnabledExportTypes(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.String getSettingSiteAddress() {
		try {
			GetSettingSiteAddressRequest.Builder requestBuilder = GetSettingSiteAddressRequest.newBuilder();
			GetSettingSiteAddressRequest request = requestBuilder.build();
			GetSettingSiteAddressResponse response = service.getSettingSiteAddress(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingSiteAddress(java.lang.String siteAddress) {
		try {
			SetSettingSiteAddressRequest.Builder requestBuilder = SetSettingSiteAddressRequest.newBuilder();
			requestBuilder.setSiteAddress(siteAddress);
			SetSettingSiteAddressRequest request = requestBuilder.build();
			service.setSettingSiteAddress(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.String getSettingSmtpServer() {
		try {
			GetSettingSmtpServerRequest.Builder requestBuilder = GetSettingSmtpServerRequest.newBuilder();
			GetSettingSmtpServerRequest request = requestBuilder.build();
			GetSettingSmtpServerResponse response = service.getSettingSmtpServer(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingSmtpServer(java.lang.String smtpServer) {
		try {
			SetSettingSmtpServerRequest.Builder requestBuilder = SetSettingSmtpServerRequest.newBuilder();
			requestBuilder.setSmtpServer(smtpServer);
			SetSettingSmtpServerRequest request = requestBuilder.build();
			service.setSettingSmtpServer(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingAutoTestClashes() {
		try {
			IsSettingAutoTestClashesRequest.Builder requestBuilder = IsSettingAutoTestClashesRequest.newBuilder();
			IsSettingAutoTestClashesRequest request = requestBuilder.build();
			IsSettingAutoTestClashesResponse response = service.isSettingAutoTestClashes(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingAutoTestClashes(java.lang.Boolean autoTestClashes) {
		try {
			SetSettingAutoTestClashesRequest.Builder requestBuilder = SetSettingAutoTestClashesRequest.newBuilder();
			requestBuilder.setAutoTestClashes(autoTestClashes);
			SetSettingAutoTestClashesRequest request = requestBuilder.build();
			service.setSettingAutoTestClashes(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingIntelligentMerging() {
		try {
			IsSettingIntelligentMergingRequest.Builder requestBuilder = IsSettingIntelligentMergingRequest.newBuilder();
			IsSettingIntelligentMergingRequest request = requestBuilder.build();
			IsSettingIntelligentMergingResponse response = service.isSettingIntelligentMerging(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingIntelligentMerging(java.lang.Boolean intelligentMerging) {
		try {
			SetSettingIntelligentMergingRequest.Builder requestBuilder = SetSettingIntelligentMergingRequest.newBuilder();
			requestBuilder.setIntelligentMerging(intelligentMerging);
			SetSettingIntelligentMergingRequest request = requestBuilder.build();
			service.setSettingIntelligentMerging(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingCacheOutputFiles() {
		try {
			IsSettingCacheOutputFilesRequest.Builder requestBuilder = IsSettingCacheOutputFilesRequest.newBuilder();
			IsSettingCacheOutputFilesRequest request = requestBuilder.build();
			IsSettingCacheOutputFilesResponse response = service.isSettingCacheOutputFiles(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingCacheOutputFiles(java.lang.Boolean cacheOutputFiles) {
		try {
			SetSettingCacheOutputFilesRequest.Builder requestBuilder = SetSettingCacheOutputFilesRequest.newBuilder();
			requestBuilder.setCacheOutputFiles(cacheOutputFiles);
			SetSettingCacheOutputFilesRequest request = requestBuilder.build();
			service.setSettingCacheOutputFiles(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.List<org.bimserver.shared.SUserSession> getActiveUserSessions() {
		try {
			GetActiveUserSessionsRequest.Builder requestBuilder = GetActiveUserSessionsRequest.newBuilder();
			GetActiveUserSessionsRequest request = requestBuilder.build();
			GetActiveUserSessionsResponse response = service.getActiveUserSessions(rpcController, request);
			java.util.List<org.bimserver.shared.SUserSession> realResult = new ArrayList<org.bimserver.shared.SUserSession>();
			List<Service.SUserSession> originalList = response.getValueList();
			for (Service.SUserSession val : originalList) {
				org.bimserver.shared.SUserSession v = new org.bimserver.shared.SUserSession();
				v.setName(val.getName());
				v.setType(org.bimserver.interfaces.objects.SUserType.values()[val.getType().ordinal()]);
				v.setAccessMethod(org.bimserver.interfaces.objects.SAccessMethod.values()[val.getAccessMethod().ordinal()]);
				v.setActiveSince(new Date(val.getActiveSince()));
				v.setLastActive(new Date(val.getLastActive()));
				v.setUoid(val.getUoid());
				v.setUsername(val.getUsername());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.shared.SLongAction> getActiveLongActions() {
		try {
			GetActiveLongActionsRequest.Builder requestBuilder = GetActiveLongActionsRequest.newBuilder();
			GetActiveLongActionsRequest request = requestBuilder.build();
			GetActiveLongActionsResponse response = service.getActiveLongActions(rpcController, request);
			java.util.List<org.bimserver.shared.SLongAction> realResult = new ArrayList<org.bimserver.shared.SLongAction>();
			List<Service.SLongAction> originalList = response.getValueList();
			for (Service.SLongAction val : originalList) {
				org.bimserver.shared.SLongAction v = new org.bimserver.shared.SLongAction();
				v.setName(val.getName());
				v.setIdentification(val.getIdentification());
				v.setUsername(val.getUsername());
				v.setUserOid(val.getUserOid());
				v.setStart(new Date(val.getStart()));
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void migrateDatabase() {
		try {
			MigrateDatabaseRequest.Builder requestBuilder = MigrateDatabaseRequest.newBuilder();
			MigrateDatabaseRequest request = requestBuilder.build();
			service.migrateDatabase(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean unknown) {
		try {
			GetAllSerializersRequest.Builder requestBuilder = GetAllSerializersRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			GetAllSerializersRequest request = requestBuilder.build();
			GetAllSerializersResponse response = service.getAllSerializers(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SSerializer> realResult = new ArrayList<org.bimserver.interfaces.objects.SSerializer>();
			List<Service.SSerializer> originalList = response.getValueList();
			for (Service.SSerializer val : originalList) {
				org.bimserver.interfaces.objects.SSerializer v = new org.bimserver.interfaces.objects.SSerializer();
				v.setName(val.getName());
				v.setClassName(val.getClassName());
				v.setExtension(val.getExtension());
				v.setContentType(val.getContentType());
				v.setDescription(val.getDescription());
				v.setGuidanceProviderId(val.getGuidanceProviderId());
				v.setSettingsId(val.getSettingsId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getEnabledSerializers() {
		try {
			GetEnabledSerializersRequest.Builder requestBuilder = GetEnabledSerializersRequest.newBuilder();
			GetEnabledSerializersRequest request = requestBuilder.build();
			GetEnabledSerializersResponse response = service.getEnabledSerializers(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SSerializer> realResult = new ArrayList<org.bimserver.interfaces.objects.SSerializer>();
			List<Service.SSerializer> originalList = response.getValueList();
			for (Service.SSerializer val : originalList) {
				org.bimserver.interfaces.objects.SSerializer v = new org.bimserver.interfaces.objects.SSerializer();
				v.setName(val.getName());
				v.setClassName(val.getClassName());
				v.setExtension(val.getExtension());
				v.setContentType(val.getContentType());
				v.setDescription(val.getDescription());
				v.setGuidanceProviderId(val.getGuidanceProviderId());
				v.setSettingsId(val.getSettingsId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getEnabledDeserializers() {
		try {
			GetEnabledDeserializersRequest.Builder requestBuilder = GetEnabledDeserializersRequest.newBuilder();
			GetEnabledDeserializersRequest request = requestBuilder.build();
			GetEnabledDeserializersResponse response = service.getEnabledDeserializers(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SDeserializer> realResult = new ArrayList<org.bimserver.interfaces.objects.SDeserializer>();
			List<Service.SDeserializer> originalList = response.getValueList();
			for (Service.SDeserializer val : originalList) {
				org.bimserver.interfaces.objects.SDeserializer v = new org.bimserver.interfaces.objects.SDeserializer();
				v.setName(val.getName());
				v.setClassName(val.getClassName());
				v.setDescription(val.getDescription());
				v.setSettingsId(val.getSettingsId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long unknown) {
		try {
			GetSerializerByIdRequest.Builder requestBuilder = GetSerializerByIdRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			GetSerializerByIdRequest request = requestBuilder.build();
			GetSerializerByIdResponse response = service.getSerializerById(rpcController, request);
			org.bimserver.interfaces.objects.SSerializer realResult = new org.bimserver.interfaces.objects.SSerializer();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void addSerializer(org.bimserver.interfaces.objects.SSerializer unknown) {
		try {
			AddSerializerRequest.Builder requestBuilder = AddSerializerRequest.newBuilder();
			Service.SSerializer.Builder newVal = SSerializer.newBuilder();
			newVal.setName(unknown.getName());
			newVal.setClassName(unknown.getClassName());
			newVal.setExtension(unknown.getExtension());
			newVal.setContentType(unknown.getContentType());
			newVal.setDescription(unknown.getDescription());
			newVal.setGuidanceProviderId(unknown.getGuidanceProviderId());
			newVal.setSettingsId(unknown.getSettingsId());
			newVal.setOid(unknown.getOid());
			requestBuilder.setUnknown(newVal.build());
			AddSerializerRequest request = requestBuilder.build();
			service.addSerializer(rpcController, request);
		} catch (Exception e) {}
	}

	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer unknown) {
		try {
			UpdateSerializerRequest.Builder requestBuilder = UpdateSerializerRequest.newBuilder();
			Service.SSerializer.Builder newVal = SSerializer.newBuilder();
			newVal.setName(unknown.getName());
			newVal.setClassName(unknown.getClassName());
			newVal.setExtension(unknown.getExtension());
			newVal.setContentType(unknown.getContentType());
			newVal.setDescription(unknown.getDescription());
			newVal.setGuidanceProviderId(unknown.getGuidanceProviderId());
			newVal.setSettingsId(unknown.getSettingsId());
			newVal.setOid(unknown.getOid());
			requestBuilder.setUnknown(newVal.build());
			UpdateSerializerRequest request = requestBuilder.build();
			service.updateSerializer(rpcController, request);
		} catch (Exception e) {}
	}

	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer unknown) {
		try {
			UpdateDeserializerRequest.Builder requestBuilder = UpdateDeserializerRequest.newBuilder();
			Service.SDeserializer.Builder newVal = SDeserializer.newBuilder();
			newVal.setName(unknown.getName());
			newVal.setClassName(unknown.getClassName());
			newVal.setDescription(unknown.getDescription());
			newVal.setSettingsId(unknown.getSettingsId());
			newVal.setOid(unknown.getOid());
			requestBuilder.setUnknown(newVal.build());
			UpdateDeserializerRequest request = requestBuilder.build();
			service.updateDeserializer(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider> getAllGuidanceProviders() {
		try {
			GetAllGuidanceProvidersRequest.Builder requestBuilder = GetAllGuidanceProvidersRequest.newBuilder();
			GetAllGuidanceProvidersRequest request = requestBuilder.build();
			GetAllGuidanceProvidersResponse response = service.getAllGuidanceProviders(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SGuidanceProvider> realResult = new ArrayList<org.bimserver.interfaces.objects.SGuidanceProvider>();
			List<Service.SGuidanceProvider> originalList = response.getValueList();
			for (Service.SGuidanceProvider val : originalList) {
				org.bimserver.interfaces.objects.SGuidanceProvider v = new org.bimserver.interfaces.objects.SGuidanceProvider();
				v.setName(val.getName());
				v.setClassName(val.getClassName());
				v.setSettingsId(val.getSettingsId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SGuidanceProvider getGuidanceProviderById(java.lang.Long unknown) {
		try {
			GetGuidanceProviderByIdRequest.Builder requestBuilder = GetGuidanceProviderByIdRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			GetGuidanceProviderByIdRequest request = requestBuilder.build();
			GetGuidanceProviderByIdResponse response = service.getGuidanceProviderById(rpcController, request);
			org.bimserver.interfaces.objects.SGuidanceProvider realResult = new org.bimserver.interfaces.objects.SGuidanceProvider();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void addGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider unknown) {
		try {
			AddGuidanceProviderRequest.Builder requestBuilder = AddGuidanceProviderRequest.newBuilder();
			Service.SGuidanceProvider.Builder newVal = SGuidanceProvider.newBuilder();
			newVal.setName(unknown.getName());
			newVal.setClassName(unknown.getClassName());
			newVal.setSettingsId(unknown.getSettingsId());
			for (java.lang.Long o : unknown.getSerializers()) {
				newVal.addSerializers(o);
			}
			newVal.setOid(unknown.getOid());
			requestBuilder.setUnknown(newVal.build());
			AddGuidanceProviderRequest request = requestBuilder.build();
			service.addGuidanceProvider(rpcController, request);
		} catch (Exception e) {}
	}

	public void updateGuidanceProvider(org.bimserver.interfaces.objects.SGuidanceProvider unknown) {
		try {
			UpdateGuidanceProviderRequest.Builder requestBuilder = UpdateGuidanceProviderRequest.newBuilder();
			Service.SGuidanceProvider.Builder newVal = SGuidanceProvider.newBuilder();
			newVal.setName(unknown.getName());
			newVal.setClassName(unknown.getClassName());
			newVal.setSettingsId(unknown.getSettingsId());
			for (java.lang.Long o : unknown.getSerializers()) {
				newVal.addSerializers(o);
			}
			newVal.setOid(unknown.getOid());
			requestBuilder.setUnknown(newVal.build());
			UpdateGuidanceProviderRequest request = requestBuilder.build();
			service.updateGuidanceProvider(rpcController, request);
		} catch (Exception e) {}
	}

	public void deleteGuidanceProvider(java.lang.Long unknown) {
		try {
			DeleteGuidanceProviderRequest.Builder requestBuilder = DeleteGuidanceProviderRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			DeleteGuidanceProviderRequest request = requestBuilder.build();
			service.deleteGuidanceProvider(rpcController, request);
		} catch (Exception e) {}
	}

	public void deleteSerializer(java.lang.Long unknown) {
		try {
			DeleteSerializerRequest.Builder requestBuilder = DeleteSerializerRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			DeleteSerializerRequest request = requestBuilder.build();
			service.deleteSerializer(rpcController, request);
		} catch (Exception e) {}
	}

	public void deleteDeserializer(java.lang.Long unknown) {
		try {
			DeleteDeserializerRequest.Builder requestBuilder = DeleteDeserializerRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			DeleteDeserializerRequest request = requestBuilder.build();
			service.deleteDeserializer(rpcController, request);
		} catch (Exception e) {}
	}

	public org.bimserver.interfaces.objects.SMergeIdentifier getSettingMergeIdentifier() {
		try {
			GetSettingMergeIdentifierRequest.Builder requestBuilder = GetSettingMergeIdentifierRequest.newBuilder();
			GetSettingMergeIdentifierRequest request = requestBuilder.build();
			GetSettingMergeIdentifierResponse response = service.getSettingMergeIdentifier(rpcController, request);
			return null;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String serializerName) {
		try {
			GetSerializerByNameRequest.Builder requestBuilder = GetSerializerByNameRequest.newBuilder();
			requestBuilder.setSerializerName(serializerName);
			GetSerializerByNameRequest request = requestBuilder.build();
			GetSerializerByNameResponse response = service.getSerializerByName(rpcController, request);
			org.bimserver.interfaces.objects.SSerializer realResult = new org.bimserver.interfaces.objects.SSerializer();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String deserializerName) {
		try {
			GetDeserializerByNameRequest.Builder requestBuilder = GetDeserializerByNameRequest.newBuilder();
			requestBuilder.setDeserializerName(deserializerName);
			GetDeserializerByNameRequest request = requestBuilder.build();
			GetDeserializerByNameResponse response = service.getDeserializerByName(rpcController, request);
			org.bimserver.interfaces.objects.SDeserializer realResult = new org.bimserver.interfaces.objects.SDeserializer();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean hasActiveSerializer(java.lang.String unknown) {
		try {
			HasActiveSerializerRequest.Builder requestBuilder = HasActiveSerializerRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			HasActiveSerializerRequest request = requestBuilder.build();
			HasActiveSerializerResponse response = service.hasActiveSerializer(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.util.List<org.bimserver.shared.SPlugin> getAllPlugins() {
		try {
			GetAllPluginsRequest.Builder requestBuilder = GetAllPluginsRequest.newBuilder();
			GetAllPluginsRequest request = requestBuilder.build();
			GetAllPluginsResponse response = service.getAllPlugins(rpcController, request);
			java.util.List<org.bimserver.shared.SPlugin> realResult = new ArrayList<org.bimserver.shared.SPlugin>();
			List<Service.SPlugin> originalList = response.getValueList();
			for (Service.SPlugin val : originalList) {
				org.bimserver.shared.SPlugin v = new org.bimserver.shared.SPlugin();
				v.setName(val.getName());
				v.setLocation(val.getLocation());
				v.setState(org.bimserver.shared.SPlugin.SPluginState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void disablePlugin(java.lang.String unknown) {
		try {
			DisablePluginRequest.Builder requestBuilder = DisablePluginRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			DisablePluginRequest request = requestBuilder.build();
			service.disablePlugin(rpcController, request);
		} catch (Exception e) {}
	}

	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String contentType) {
		try {
			GetSerializerByContentTypeRequest.Builder requestBuilder = GetSerializerByContentTypeRequest.newBuilder();
			requestBuilder.setContentType(contentType);
			GetSerializerByContentTypeRequest request = requestBuilder.build();
			GetSerializerByContentTypeResponse response = service.getSerializerByContentType(rpcController, request);
			org.bimserver.interfaces.objects.SSerializer realResult = new org.bimserver.interfaces.objects.SSerializer();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void startTransaction(java.lang.Integer pid) {
		try {
			StartTransactionRequest.Builder requestBuilder = StartTransactionRequest.newBuilder();
			requestBuilder.setPid(pid);
			StartTransactionRequest request = requestBuilder.build();
			service.startTransaction(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Long commitTransaction() {
		try {
			CommitTransactionRequest.Builder requestBuilder = CommitTransactionRequest.newBuilder();
			CommitTransactionRequest request = requestBuilder.build();
			CommitTransactionResponse response = service.commitTransaction(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0L;
	}

	public void abortTransaction() {
		try {
			AbortTransactionRequest.Builder requestBuilder = AbortTransactionRequest.newBuilder();
			AbortTransactionRequest request = requestBuilder.build();
			service.abortTransaction(rpcController, request);
		} catch (Exception e) {}
	}

	public void setStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) {
		try {
			SetStringAttributeRequest.Builder requestBuilder = SetStringAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			SetStringAttributeRequest request = requestBuilder.build();
			service.setStringAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void setFloatAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, float value) {
		try {
			SetFloatAttributeRequest.Builder requestBuilder = SetFloatAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			SetFloatAttributeRequest request = requestBuilder.build();
			service.setFloatAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void setEnumAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) {
		try {
			SetEnumAttributeRequest.Builder requestBuilder = SetEnumAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			SetEnumAttributeRequest request = requestBuilder.build();
			service.setEnumAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void setIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) {
		try {
			SetIntegerAttributeRequest.Builder requestBuilder = SetIntegerAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			SetIntegerAttributeRequest request = requestBuilder.build();
			service.setIntegerAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void setBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) {
		try {
			SetBooleanAttributeRequest.Builder requestBuilder = SetBooleanAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			SetBooleanAttributeRequest request = requestBuilder.build();
			service.setBooleanAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void unsetAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName) {
		try {
			UnsetAttributeRequest.Builder requestBuilder = UnsetAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			UnsetAttributeRequest request = requestBuilder.build();
			service.unsetAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void unsetReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName) {
		try {
			UnsetReferenceRequest.Builder requestBuilder = UnsetReferenceRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setReferenceName(referenceName);
			UnsetReferenceRequest request = requestBuilder.build();
			service.unsetReference(rpcController, request);
		} catch (Exception e) {}
	}

	public void addStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) {
		try {
			AddStringAttributeRequest.Builder requestBuilder = AddStringAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			AddStringAttributeRequest request = requestBuilder.build();
			service.addStringAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void addFloatAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, float value) {
		try {
			AddFloatAttributeRequest.Builder requestBuilder = AddFloatAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			AddFloatAttributeRequest request = requestBuilder.build();
			service.addFloatAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void addIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) {
		try {
			AddIntegerAttributeRequest.Builder requestBuilder = AddIntegerAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			AddIntegerAttributeRequest request = requestBuilder.build();
			service.addIntegerAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void addBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) {
		try {
			AddBooleanAttributeRequest.Builder requestBuilder = AddBooleanAttributeRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setAttributeName(attributeName);
			requestBuilder.setValue(value);
			AddBooleanAttributeRequest request = requestBuilder.build();
			service.addBooleanAttribute(rpcController, request);
		} catch (Exception e) {}
	}

	public void removeReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Integer index) {
		try {
			RemoveReferenceRequest.Builder requestBuilder = RemoveReferenceRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setReferenceName(referenceName);
			requestBuilder.setIndex(index);
			RemoveReferenceRequest request = requestBuilder.build();
			service.removeReference(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.Date getServerStartTime() {
		try {
			GetServerStartTimeRequest.Builder requestBuilder = GetServerStartTimeRequest.newBuilder();
			GetServerStartTimeRequest request = requestBuilder.build();
			GetServerStartTimeResponse response = service.getServerStartTime(rpcController, request);
			java.util.Date realResult = new java.util.Date();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean unknown) {
		try {
			GetAllDeserializersRequest.Builder requestBuilder = GetAllDeserializersRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			GetAllDeserializersRequest request = requestBuilder.build();
			GetAllDeserializersResponse response = service.getAllDeserializers(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SDeserializer> realResult = new ArrayList<org.bimserver.interfaces.objects.SDeserializer>();
			List<Service.SDeserializer> originalList = response.getValueList();
			for (Service.SDeserializer val : originalList) {
				org.bimserver.interfaces.objects.SDeserializer v = new org.bimserver.interfaces.objects.SDeserializer();
				v.setName(val.getName());
				v.setClassName(val.getClassName());
				v.setDescription(val.getDescription());
				v.setSettingsId(val.getSettingsId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long goid) {
		try {
			GetGeoTagRequest.Builder requestBuilder = GetGeoTagRequest.newBuilder();
			requestBuilder.setGoid(goid);
			GetGeoTagRequest request = requestBuilder.build();
			GetGeoTagResponse response = service.getGeoTag(rpcController, request);
			org.bimserver.interfaces.objects.SGeoTag realResult = new org.bimserver.interfaces.objects.SGeoTag();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag sGeoTag) {
		try {
			UpdateGeoTagRequest.Builder requestBuilder = UpdateGeoTagRequest.newBuilder();
			Service.SGeoTag.Builder newVal = SGeoTag.newBuilder();
			for (java.lang.Long o : sGeoTag.getProjects()) {
				newVal.addProjects(o);
			}
			newVal.setDirectionAngle(sGeoTag.getDirectionAngle());
			newVal.setOid(sGeoTag.getOid());
			newVal.setY(sGeoTag.getY());
			newVal.setX(sGeoTag.getX());
			newVal.setZ(sGeoTag.getZ());
			newVal.setEpsg(sGeoTag.getEpsg());
			requestBuilder.setSGeoTag(newVal.build());
			UpdateGeoTagRequest request = requestBuilder.build();
			service.updateGeoTag(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isLoggedIn() {
		try {
			IsLoggedInRequest.Builder requestBuilder = IsLoggedInRequest.newBuilder();
			IsLoggedInRequest request = requestBuilder.build();
			IsLoggedInResponse response = service.isLoggedIn(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() {
		try {
			GetLogsRequest.Builder requestBuilder = GetLogsRequest.newBuilder();
			GetLogsRequest request = requestBuilder.build();
			GetLogsResponse response = service.getLogs(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SLogAction> realResult = new ArrayList<org.bimserver.interfaces.objects.SLogAction>();
			List<Service.SLogAction> originalList = response.getValueList();
			for (Service.SLogAction val : originalList) {
				org.bimserver.interfaces.objects.SLogAction v = new org.bimserver.interfaces.objects.SLogAction();
				v.setDate(new Date(val.getDate()));
				v.setAccessMethod(org.bimserver.interfaces.objects.SAccessMethod.values()[val.getAccessMethod().ordinal()]);
				v.setExecutorId(val.getExecutorId());
				v.setOid(val.getOid());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void enablePlugin(java.lang.String unknown) {
		try {
			EnablePluginRequest.Builder requestBuilder = EnablePluginRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			EnablePluginRequest request = requestBuilder.build();
			service.enablePlugin(rpcController, request);
		} catch (Exception e) {}
	}

	public void removeObject(java.lang.String className, java.lang.Long oid) {
		try {
			RemoveObjectRequest.Builder requestBuilder = RemoveObjectRequest.newBuilder();
			requestBuilder.setClassName(className);
			requestBuilder.setOid(oid);
			RemoveObjectRequest request = requestBuilder.build();
			service.removeObject(rpcController, request);
		} catch (Exception e) {}
	}

	public void setReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) {
		try {
			SetReferenceRequest.Builder requestBuilder = SetReferenceRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setReferenceName(referenceName);
			requestBuilder.setReferenceOid(referenceOid);
			requestBuilder.setReferenceClassName(referenceClassName);
			SetReferenceRequest request = requestBuilder.build();
			service.setReference(rpcController, request);
		} catch (Exception e) {}
	}

	public void addReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) {
		try {
			AddReferenceRequest.Builder requestBuilder = AddReferenceRequest.newBuilder();
			requestBuilder.setOid(oid);
			requestBuilder.setClassName(className);
			requestBuilder.setReferenceName(referenceName);
			requestBuilder.setReferenceOid(referenceOid);
			requestBuilder.setReferenceClassName(referenceClassName);
			AddReferenceRequest request = requestBuilder.build();
			service.addReference(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long uoid) {
		try {
			GetAllNonAuthorizedProjectsOfUserRequest.Builder requestBuilder = GetAllNonAuthorizedProjectsOfUserRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			GetAllNonAuthorizedProjectsOfUserRequest request = requestBuilder.build();
			GetAllNonAuthorizedProjectsOfUserResponse response = service.getAllNonAuthorizedProjectsOfUser(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SProject> realResult = new ArrayList<org.bimserver.interfaces.objects.SProject>();
			List<Service.SProject> originalList = response.getValueList();
			for (Service.SProject val : originalList) {
				org.bimserver.interfaces.objects.SProject v = new org.bimserver.interfaces.objects.SProject();
				v.setName(val.getName());
				v.setId(val.getId());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setDescription(val.getDescription());
				v.setLastConcreteRevisionId(val.getLastConcreteRevisionId());
				v.setLastRevisionId(val.getLastRevisionId());
				v.setCreatedDate(new Date(val.getCreatedDate()));
				v.setCreatedById(val.getCreatedById());
				v.setClashDetectionSettingsId(val.getClashDetectionSettingsId());
				v.setExportLengthMeasurePrefix(org.bimserver.interfaces.objects.SSIPrefix.values()[val.getExportLengthMeasurePrefix().ordinal()]);
				v.setOid(val.getOid());
				v.setGeoTagId(val.getGeoTagId());
				v.setParentId(val.getParentId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long poid) {
		try {
			GetAllNonAuthorizedUsersOfProjectRequest.Builder requestBuilder = GetAllNonAuthorizedUsersOfProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetAllNonAuthorizedUsersOfProjectRequest request = requestBuilder.build();
			GetAllNonAuthorizedUsersOfProjectResponse response = service.getAllNonAuthorizedUsersOfProject(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SUser> realResult = new ArrayList<org.bimserver.interfaces.objects.SUser>();
			List<Service.SUser> originalList = response.getValueList();
			for (Service.SUser val : originalList) {
				org.bimserver.interfaces.objects.SUser v = new org.bimserver.interfaces.objects.SUser();
				v.setName(val.getName());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setCreatedById(val.getCreatedById());
				v.setValidationToken(val.getValidationToken());
				v.setValidationTokenCreated(new Date(val.getValidationTokenCreated()));
				v.setOid(val.getOid());
				v.setPassword(val.getPassword());
				v.setCreatedOn(new Date(val.getCreatedOn()));
				v.setUserType(org.bimserver.interfaces.objects.SUserType.values()[val.getUserType().ordinal()]);
				v.setUsername(val.getUsername());
				v.setLastSeen(new Date(val.getLastSeen()));
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long poid) {
		try {
			GetAllAuthorizedUsersOfProjectRequest.Builder requestBuilder = GetAllAuthorizedUsersOfProjectRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetAllAuthorizedUsersOfProjectRequest request = requestBuilder.build();
			GetAllAuthorizedUsersOfProjectResponse response = service.getAllAuthorizedUsersOfProject(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SUser> realResult = new ArrayList<org.bimserver.interfaces.objects.SUser>();
			List<Service.SUser> originalList = response.getValueList();
			for (Service.SUser val : originalList) {
				org.bimserver.interfaces.objects.SUser v = new org.bimserver.interfaces.objects.SUser();
				v.setName(val.getName());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setCreatedById(val.getCreatedById());
				v.setValidationToken(val.getValidationToken());
				v.setValidationTokenCreated(new Date(val.getValidationTokenCreated()));
				v.setOid(val.getOid());
				v.setPassword(val.getPassword());
				v.setCreatedOn(new Date(val.getCreatedOn()));
				v.setUserType(org.bimserver.interfaces.objects.SUserType.values()[val.getUserType().ordinal()]);
				v.setUsername(val.getUsername());
				v.setLastSeen(new Date(val.getLastSeen()));
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long poid) {
		try {
			GetAllCheckoutsOfProjectAndSubProjectsRequest.Builder requestBuilder = GetAllCheckoutsOfProjectAndSubProjectsRequest.newBuilder();
			requestBuilder.setPoid(poid);
			GetAllCheckoutsOfProjectAndSubProjectsRequest request = requestBuilder.build();
			GetAllCheckoutsOfProjectAndSubProjectsResponse response = service.getAllCheckoutsOfProjectAndSubProjects(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SCheckout> realResult = new ArrayList<org.bimserver.interfaces.objects.SCheckout>();
			List<Service.SCheckout> originalList = response.getValueList();
			for (Service.SCheckout val : originalList) {
				org.bimserver.interfaces.objects.SCheckout v = new org.bimserver.interfaces.objects.SCheckout();
				v.setDate(new Date(val.getDate()));
				v.setRevisionId(val.getRevisionId());
				v.setCheckinId(val.getCheckinId());
				v.setOid(val.getOid());
				v.setUserId(val.getUserId());
				v.setProjectId(val.getProjectId());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.String getSettingRegistrationAddition() {
		try {
			GetSettingRegistrationAdditionRequest.Builder requestBuilder = GetSettingRegistrationAdditionRequest.newBuilder();
			GetSettingRegistrationAdditionRequest request = requestBuilder.build();
			GetSettingRegistrationAdditionResponse response = service.getSettingRegistrationAddition(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public void setSettingRegistrationAddition(java.lang.String registrationAddition) {
		try {
			SetSettingRegistrationAdditionRequest.Builder requestBuilder = SetSettingRegistrationAdditionRequest.newBuilder();
			requestBuilder.setRegistrationAddition(registrationAddition);
			SetSettingRegistrationAdditionRequest request = requestBuilder.build();
			service.setSettingRegistrationAddition(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingAllowSelfRegistration() {
		try {
			IsSettingAllowSelfRegistrationRequest.Builder requestBuilder = IsSettingAllowSelfRegistrationRequest.newBuilder();
			IsSettingAllowSelfRegistrationRequest request = requestBuilder.build();
			IsSettingAllowSelfRegistrationResponse response = service.isSettingAllowSelfRegistration(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) {
		try {
			SetSettingAllowSelfRegistrationRequest.Builder requestBuilder = SetSettingAllowSelfRegistrationRequest.newBuilder();
			requestBuilder.setAllowSelfRegistration(allowSelfRegistration);
			SetSettingAllowSelfRegistrationRequest request = requestBuilder.build();
			service.setSettingAllowSelfRegistration(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() {
		try {
			IsSettingAllowUsersToCreateTopLevelProjectsRequest.Builder requestBuilder = IsSettingAllowUsersToCreateTopLevelProjectsRequest.newBuilder();
			IsSettingAllowUsersToCreateTopLevelProjectsRequest request = requestBuilder.build();
			IsSettingAllowUsersToCreateTopLevelProjectsResponse response = service.isSettingAllowUsersToCreateTopLevelProjects(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean allowUsersToCreateTopLevelProjects) {
		try {
			SetSettingAllowUsersToCreateTopLevelProjectsRequest.Builder requestBuilder = SetSettingAllowUsersToCreateTopLevelProjectsRequest.newBuilder();
			requestBuilder.setAllowUsersToCreateTopLevelProjects(allowUsersToCreateTopLevelProjects);
			SetSettingAllowUsersToCreateTopLevelProjectsRequest request = requestBuilder.build();
			service.setSettingAllowUsersToCreateTopLevelProjects(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingCheckinMergingEnabled() {
		try {
			IsSettingCheckinMergingEnabledRequest.Builder requestBuilder = IsSettingCheckinMergingEnabledRequest.newBuilder();
			IsSettingCheckinMergingEnabledRequest request = requestBuilder.build();
			IsSettingCheckinMergingEnabledResponse response = service.isSettingCheckinMergingEnabled(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) {
		try {
			SetSettingCheckinMergingEnabledRequest.Builder requestBuilder = SetSettingCheckinMergingEnabledRequest.newBuilder();
			requestBuilder.setCheckinMergingEnabled(checkinMergingEnabled);
			SetSettingCheckinMergingEnabledRequest request = requestBuilder.build();
			service.setSettingCheckinMergingEnabled(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() {
		try {
			IsSettingShowVersionUpgradeAvailableRequest.Builder requestBuilder = IsSettingShowVersionUpgradeAvailableRequest.newBuilder();
			IsSettingShowVersionUpgradeAvailableRequest request = requestBuilder.build();
			IsSettingShowVersionUpgradeAvailableResponse response = service.isSettingShowVersionUpgradeAvailable(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean showVersionUpgradeAvailable) {
		try {
			SetSettingShowVersionUpgradeAvailableRequest.Builder requestBuilder = SetSettingShowVersionUpgradeAvailableRequest.newBuilder();
			requestBuilder.setShowVersionUpgradeAvailable(showVersionUpgradeAvailable);
			SetSettingShowVersionUpgradeAvailableRequest request = requestBuilder.build();
			service.setSettingShowVersionUpgradeAvailable(rpcController, request);
		} catch (Exception e) {}
	}

	public java.util.Set<org.bimserver.shared.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() {
		try {
			GetAllSerializerPluginDescriptorsRequest.Builder requestBuilder = GetAllSerializerPluginDescriptorsRequest.newBuilder();
			GetAllSerializerPluginDescriptorsRequest request = requestBuilder.build();
			GetAllSerializerPluginDescriptorsResponse response = service.getAllSerializerPluginDescriptors(rpcController, request);
			java.util.Set<org.bimserver.shared.SSerializerPluginDescriptor> realResult = new HashSet<org.bimserver.shared.SSerializerPluginDescriptor>();
			List<Service.SSerializerPluginDescriptor> originalList = response.getValueList();
			for (Service.SSerializerPluginDescriptor val : originalList) {
				org.bimserver.shared.SSerializerPluginDescriptor v = new org.bimserver.shared.SSerializerPluginDescriptor();
				v.setPluginClassName(val.getPluginClassName());
				v.setDefaultName(val.getDefaultName());
				v.setDefaultExtension(val.getDefaultExtension());
				v.setDefaultContentType(val.getDefaultContentType());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String unknown) {
		try {
			GetSerializerPluginDescriptorRequest.Builder requestBuilder = GetSerializerPluginDescriptorRequest.newBuilder();
			requestBuilder.setUnknown(unknown);
			GetSerializerPluginDescriptorRequest request = requestBuilder.build();
			GetSerializerPluginDescriptorResponse response = service.getSerializerPluginDescriptor(rpcController, request);
			org.bimserver.shared.SSerializerPluginDescriptor realResult = new org.bimserver.shared.SSerializerPluginDescriptor();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.util.Set<org.bimserver.shared.SGuidanceProviderPluginDescriptor> getAllGuidanceProviderPluginDescriptors() {
		try {
			GetAllGuidanceProviderPluginDescriptorsRequest.Builder requestBuilder = GetAllGuidanceProviderPluginDescriptorsRequest.newBuilder();
			GetAllGuidanceProviderPluginDescriptorsRequest request = requestBuilder.build();
			GetAllGuidanceProviderPluginDescriptorsResponse response = service.getAllGuidanceProviderPluginDescriptors(rpcController, request);
			java.util.Set<org.bimserver.shared.SGuidanceProviderPluginDescriptor> realResult = new HashSet<org.bimserver.shared.SGuidanceProviderPluginDescriptor>();
			List<Service.SGuidanceProviderPluginDescriptor> originalList = response.getValueList();
			for (Service.SGuidanceProviderPluginDescriptor val : originalList) {
				org.bimserver.shared.SGuidanceProviderPluginDescriptor v = new org.bimserver.shared.SGuidanceProviderPluginDescriptor();
				v.setClassName(val.getClassName());
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean login(java.lang.String username, java.lang.String password) {
		try {
			LoginRequest.Builder requestBuilder = LoginRequest.newBuilder();
			requestBuilder.setUsername(username);
			requestBuilder.setPassword(password);
			LoginRequest request = requestBuilder.build();
			LoginResponse response = service.login(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.lang.String ping(java.lang.String in) {
		try {
			PingRequest.Builder requestBuilder = PingRequest.newBuilder();
			requestBuilder.setIn(in);
			PingRequest request = requestBuilder.build();
			PingResponse response = service.ping(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean autologin(java.lang.String username, java.lang.String hash) {
		try {
			AutologinRequest.Builder requestBuilder = AutologinRequest.newBuilder();
			requestBuilder.setUsername(username);
			requestBuilder.setHash(hash);
			AutologinRequest request = requestBuilder.build();
			AutologinResponse response = service.autologin(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public org.bimserver.shared.SCheckinResult checkinSync(java.lang.Long poid, java.lang.String comment, java.lang.String deserializerName, java.lang.Long fileSize, javax.activation.DataHandler ifcFile, java.lang.Boolean merge) {
		try {
			CheckinSyncRequest.Builder requestBuilder = CheckinSyncRequest.newBuilder();
			requestBuilder.setPoid(poid);
			requestBuilder.setComment(comment);
			requestBuilder.setDeserializerName(deserializerName);
			requestBuilder.setFileSize(fileSize);
			ByteString bs = ByteString.copyFrom(BinUtils.readInputStream(ifcFile.getInputStream()));
			requestBuilder.setIfcFile(bs);
			requestBuilder.setMerge(merge);
			CheckinSyncRequest request = requestBuilder.build();
			CheckinSyncResponse response = service.checkinSync(rpcController, request);
			org.bimserver.shared.SCheckinResult realResult = new org.bimserver.shared.SCheckinResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.shared.SCheckinResult checkinAsync(java.lang.Long poid, java.lang.String comment, java.lang.String deserializerName, java.lang.Long fileSize, javax.activation.DataHandler ifcFile, java.lang.Boolean merge) {
		try {
			CheckinAsyncRequest.Builder requestBuilder = CheckinAsyncRequest.newBuilder();
			requestBuilder.setPoid(poid);
			requestBuilder.setComment(comment);
			requestBuilder.setDeserializerName(deserializerName);
			requestBuilder.setFileSize(fileSize);
			ByteString bs = ByteString.copyFrom(BinUtils.readInputStream(ifcFile.getInputStream()));
			requestBuilder.setIfcFile(bs);
			requestBuilder.setMerge(merge);
			CheckinAsyncRequest request = requestBuilder.build();
			CheckinAsyncResponse response = service.checkinAsync(rpcController, request);
			org.bimserver.shared.SCheckinResult realResult = new org.bimserver.shared.SCheckinResult();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Integer download(java.lang.Long roid, java.lang.String formatIdentifier, java.lang.Boolean sync) {
		try {
			DownloadRequest.Builder requestBuilder = DownloadRequest.newBuilder();
			requestBuilder.setRoid(roid);
			requestBuilder.setFormatIdentifier(formatIdentifier);
			requestBuilder.setSync(sync);
			DownloadRequest request = requestBuilder.build();
			DownloadResponse response = service.download(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0;
	}

	public java.lang.Long addUser(java.lang.String username, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration) {
		try {
			AddUserRequest.Builder requestBuilder = AddUserRequest.newBuilder();
			requestBuilder.setUsername(username);
			requestBuilder.setName(name);
			requestBuilder.setType(Service.SUserType.values()[type.ordinal()]);
			requestBuilder.setSelfRegistration(selfRegistration);
			AddUserRequest request = requestBuilder.build();
			AddUserResponse response = service.addUser(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return 0L;
	}

	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String projectName) {
		try {
			AddProjectRequest.Builder requestBuilder = AddProjectRequest.newBuilder();
			requestBuilder.setProjectName(projectName);
			AddProjectRequest request = requestBuilder.build();
			AddProjectResponse response = service.addProject(rpcController, request);
			org.bimserver.interfaces.objects.SProject realResult = new org.bimserver.interfaces.objects.SProject();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public java.lang.Boolean deleteUser(java.lang.Long uoid) {
		try {
			DeleteUserRequest.Builder requestBuilder = DeleteUserRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			DeleteUserRequest request = requestBuilder.build();
			DeleteUserResponse response = service.deleteUser(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() {
		try {
			GetAllUsersRequest.Builder requestBuilder = GetAllUsersRequest.newBuilder();
			GetAllUsersRequest request = requestBuilder.build();
			GetAllUsersResponse response = service.getAllUsers(rpcController, request);
			java.util.List<org.bimserver.interfaces.objects.SUser> realResult = new ArrayList<org.bimserver.interfaces.objects.SUser>();
			List<Service.SUser> originalList = response.getValueList();
			for (Service.SUser val : originalList) {
				org.bimserver.interfaces.objects.SUser v = new org.bimserver.interfaces.objects.SUser();
				v.setName(val.getName());
				v.setState(org.bimserver.interfaces.objects.SObjectState.values()[val.getState().ordinal()]);
				v.setCreatedById(val.getCreatedById());
				v.setValidationToken(val.getValidationToken());
				v.setValidationTokenCreated(new Date(val.getValidationTokenCreated()));
				v.setOid(val.getOid());
				v.setPassword(val.getPassword());
				v.setCreatedOn(new Date(val.getCreatedOn()));
				v.setUserType(org.bimserver.interfaces.objects.SUserType.values()[val.getUserType().ordinal()]);
				v.setUsername(val.getUsername());
				v.setLastSeen(new Date(val.getLastSeen()));
				realResult.add(v);
			}
		return realResult;
		} catch (Exception e) {}
		return null;
	}

	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long roid) {
		try {
			GetRevisionRequest.Builder requestBuilder = GetRevisionRequest.newBuilder();
			requestBuilder.setRoid(roid);
			GetRevisionRequest request = requestBuilder.build();
			GetRevisionResponse response = service.getRevision(rpcController, request);
			org.bimserver.interfaces.objects.SRevision realResult = new org.bimserver.interfaces.objects.SRevision();
			return realResult;
		} catch (Exception e) {}
		return null;
	}

	public void logout() {
		try {
			LogoutRequest.Builder requestBuilder = LogoutRequest.newBuilder();
			LogoutRequest request = requestBuilder.build();
			service.logout(rpcController, request);
		} catch (Exception e) {}
	}

	public java.lang.Boolean undeleteUser(java.lang.Long uoid) {
		try {
			UndeleteUserRequest.Builder requestBuilder = UndeleteUserRequest.newBuilder();
			requestBuilder.setUoid(uoid);
			UndeleteUserRequest request = requestBuilder.build();
			UndeleteUserResponse response = service.undeleteUser(rpcController, request);
			return response.getValue();
		} catch (Exception e) {}
		return false;
	}

}
