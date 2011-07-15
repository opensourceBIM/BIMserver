package org.bimserver.unittests;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.LocalDevPluginLoader;
import org.bimserver.ServerInfo.ServerState;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.DatabaseRestartRequiredException;
import org.bimserver.database.berkeley.DatabaseInitException;
import org.bimserver.pb.Service.AddProjectRequest;
import org.bimserver.pb.Service.AddProjectResponse;
import org.bimserver.pb.Service.AddUserRequest;
import org.bimserver.pb.Service.AddUserResponse;
import org.bimserver.pb.Service.ChangePasswordRequest;
import org.bimserver.pb.Service.ChangePasswordResponse;
import org.bimserver.pb.Service.CheckinSyncRequest;
import org.bimserver.pb.Service.CheckinSyncResponse;
import org.bimserver.pb.Service.CheckoutRequest;
import org.bimserver.pb.Service.DownloadRequest;
import org.bimserver.pb.Service.DownloadResponse;
import org.bimserver.pb.Service.GetAllProjectsRequest;
import org.bimserver.pb.Service.GetAllProjectsResponse;
import org.bimserver.pb.Service.GetAllRevisionsOfProjectRequest;
import org.bimserver.pb.Service.GetAllRevisionsOfProjectResponse;
import org.bimserver.pb.Service.GetDownloadDataRequest;
import org.bimserver.pb.Service.GetDownloadDataResponse;
import org.bimserver.pb.Service.GetProjectsByNameRequest;
import org.bimserver.pb.Service.GetProjectsByNameResponse;
import org.bimserver.pb.Service.GetRevisionSummaryRequest;
import org.bimserver.pb.Service.GetRevisionSummaryResponse;
import org.bimserver.pb.Service.LoginRequest;
import org.bimserver.pb.Service.LoginResponse;
import org.bimserver.pb.Service.SDownloadResult;
import org.bimserver.pb.Service.SRevision;
import org.bimserver.pb.Service.SRevisionSummary;
import org.bimserver.pb.Service.SRevisionSummaryContainer;
import org.bimserver.pb.Service.SRevisionSummaryType;
import org.bimserver.pb.Service.ServiceInterface;
import org.bimserver.pb.Service.ServiceInterface.BlockingInterface;
import org.bimserver.plugins.PluginException;
import org.bimserver.shared.LocalDevelopmentResourceFetcher;
import org.bimserver.shared.ServerException;
import org.bimserver.shared.UserException;
import org.bimserver.tests.TestFile;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ByteString;
import com.google.protobuf.ServiceException;
import com.googlecode.protobuf.socketrpc.RpcChannels;
import com.googlecode.protobuf.socketrpc.SocketRpcConnectionFactories;
import com.googlecode.protobuf.socketrpc.SocketRpcController;

public class TestProtocolBuffersInterface {
	private static String username = "test" + new Random().nextInt() + "@bimserver.org";
	private static String password = "test";
	private static BimServer bimServer;
	private static String projectName = "Test" + new Random().nextInt();

	@BeforeClass
	public static void initClass() {
		try {
			// Create a BIMserver
			bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());

			// Load plugins
			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());

			// Start
			bimServer.start();

			// Convenience, setup the server to make sure it is in RUNNING state
			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
			}

			// Change a setting to normal users can create projects
			bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		} catch (PluginException e) {
			e.printStackTrace();
		} catch (DatabaseInitException e) {
			e.printStackTrace();
		} catch (BimDatabaseException e) {
			e.printStackTrace();
		} catch (DatabaseRestartRequiredException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Cleanup
	 */
	@AfterClass
	public static void shutdownClass() {
		bimServer.stop();
	}

	/*
	 * Tests whether a user can be created and it's password reset, this user is
	 * also used for subsequent tests
	 */
	@Test
	public void testCreateUser() {
		try {
			BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
			SocketRpcController rpcController = new SocketRpcController();
			BlockingInterface service = ServiceInterface.newBlockingStub(rpcChannel);

			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
			loginRequestBuilder.setUsername("admin@bimserver.org");
			loginRequestBuilder.setPassword("admin");
			LoginRequest loginRequest = loginRequestBuilder.build();
			LoginResponse loginResponse = service.login(rpcController, loginRequest);
			if (loginResponse.getErrorMessage().equals("OKE")) {
				if (loginResponse.getValue()) {
					AddUserRequest.Builder addUserRequestBuilder = AddUserRequest.newBuilder();
					addUserRequestBuilder.setUsername(username);
					addUserRequestBuilder.setName("Test");
					addUserRequestBuilder.setType(org.bimserver.pb.Service.SUserType.USER);
					addUserRequestBuilder.setSelfRegistration(false);
					AddUserResponse addUserResponse = service.addUser(rpcController, addUserRequestBuilder.build());
					if (addUserResponse.getErrorMessage().equals("OKE")) {
						long uoid = addUserResponse.getValue();
						ChangePasswordRequest.Builder changePasswordRequestBuilder = ChangePasswordRequest.newBuilder();
						changePasswordRequestBuilder.setUoid(uoid);
						changePasswordRequestBuilder.setNewPassword(password);
						ChangePasswordResponse changePasswordResponse = service.changePassword(rpcController, changePasswordRequestBuilder.build());
						if (changePasswordResponse.getErrorMessage().equals("OKE")) {
						} else {
							fail(changePasswordResponse.getErrorMessage());
						}
					} else {
						fail(addUserResponse.getErrorMessage());
					}
				} else {
					System.err.println("Error logging in");
					fail("Error logging in");
				}
			} else {
				fail(loginResponse.getErrorMessage());
			}
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
	}

	/*
	 * This will create a project and checkin the AC11 IFC file
	 */
	@Test
	public void testUpload() {
		try {
			BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
			SocketRpcController rpcController = new SocketRpcController();
			BlockingInterface service = ServiceInterface.newBlockingStub(rpcChannel);

			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
			loginRequestBuilder.setUsername(username);
			loginRequestBuilder.setPassword(password);
			LoginResponse loginResponse = service.login(rpcController, loginRequestBuilder.build());
			if (loginResponse.getErrorMessage().equals("OKE")) {
				AddProjectRequest.Builder addProjectRequestBuilder = AddProjectRequest.newBuilder();
				addProjectRequestBuilder.setProjectName(projectName);
				AddProjectResponse addProjectResponse = service.addProject(rpcController, addProjectRequestBuilder.build());
				if (addProjectResponse.getErrorMessage().equals("OKE")) {
					org.bimserver.pb.Service.SProject project = addProjectResponse.getValue();
					File sourceFile = TestFile.AC11.getFile();

					CheckinSyncRequest.Builder checkinSyncRequestBuilder = CheckinSyncRequest.newBuilder();
					checkinSyncRequestBuilder.setPoid(project.getOid());
					checkinSyncRequestBuilder.setComment("test");
					checkinSyncRequestBuilder.setFileSize(sourceFile.length());
					checkinSyncRequestBuilder.setIfcFile(createByteString(sourceFile));

					CheckinSyncResponse checkinSyncResponse = service.checkinSync(rpcController, checkinSyncRequestBuilder.build());
					if (checkinSyncResponse.getErrorMessage().equals("OKE")) {

					} else {
						fail(checkinSyncResponse.getErrorMessage());
					}
				} else {
					fail(addProjectResponse.getErrorMessage());
				}
			} else {
				fail(loginResponse.getErrorMessage());
			}
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetProjectByName() {
		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
		SocketRpcController rpcController = new SocketRpcController();
		BlockingInterface service = ServiceInterface.newBlockingStub(rpcChannel);
		
		GetProjectsByNameRequest.Builder getProjectByNameRequestBuilder = GetProjectsByNameRequest.newBuilder();
		getProjectByNameRequestBuilder.setName(projectName);
		try {
			GetProjectsByNameResponse getProjectByNameResponse = service.getProjectsByName(rpcController, getProjectByNameRequestBuilder.build());
			if (getProjectByNameResponse.getErrorMessage().equals("OKE")) {
				System.out.println(getProjectByNameResponse.getValueList().size() + " projects with name " + projectName);
			} else {
				fail(getProjectByNameResponse.getErrorMessage());
			}
		} catch (ServiceException e) {
			fail(e.getMessage());
		}
	}
	
	/*
	 * This will list all projects, select the first project with at least one
	 * revision and dump the names of all walls within the last revision of that
	 * project
	 */
	@Test
	public void testDump() {
		try {
			BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
			SocketRpcController rpcController = new SocketRpcController();
			BlockingInterface service = ServiceInterface.newBlockingStub(rpcChannel);

			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
			loginRequestBuilder.setUsername(username);
			loginRequestBuilder.setPassword(password);
			LoginResponse loginResponse = service.login(rpcController, loginRequestBuilder.build());
			if (loginResponse.getErrorMessage().equals("OKE")) {
				GetAllProjectsRequest.Builder getAllProjectsRequestBuilder = GetAllProjectsRequest.newBuilder();
				GetAllProjectsResponse getAllProjectsResponse = service.getAllProjects(rpcController, getAllProjectsRequestBuilder.build());
				if (getAllProjectsResponse.getErrorMessage().equals("OKE")) {
					for (org.bimserver.pb.Service.SProject project : getAllProjectsResponse.getValueList()) {
						System.out.println(project.getName());
						if (project.getRevisionsCount() > 0) {
							GetAllRevisionsOfProjectRequest.Builder getAllRevisionsOfProjectRequestBuilder = GetAllRevisionsOfProjectRequest.newBuilder();
							getAllRevisionsOfProjectRequestBuilder.setPoid(project.getOid());
							GetAllRevisionsOfProjectResponse getAllRevisionsOfProjectResponse = service.getAllRevisionsOfProject(rpcController, getAllRevisionsOfProjectRequestBuilder.build());
							if (getAllRevisionsOfProjectResponse.getErrorMessage().equals("OKE")) {
								for (SRevision revision : getAllRevisionsOfProjectResponse.getValueList()) {
									GetRevisionSummaryRequest.Builder getRevisionSummaryRequestBuilder = GetRevisionSummaryRequest.newBuilder();
									getRevisionSummaryRequestBuilder.setRoid(revision.getOid());
									GetRevisionSummaryResponse getRevisionSummaryResponse = service.getRevisionSummary(rpcController, getRevisionSummaryRequestBuilder.build());
									if (getRevisionSummaryResponse.getErrorMessage().equals("OKE")) {
										SRevisionSummary sRevisionSummary = getRevisionSummaryResponse.getValue();
										for (SRevisionSummaryContainer container : sRevisionSummary.getListList()) {
											System.out.println(container.getName());
											for (SRevisionSummaryType type : container.getTypesList()) {
												System.out.println("\t" + type.getName() + ": " + type.getCount());
											}
										}
									} else {
										fail(getRevisionSummaryResponse.getErrorMessage());
									}
									
									DownloadRequest.Builder downloadRequestBuilder = DownloadRequest.newBuilder();
									downloadRequestBuilder.setRoid(revision.getOid());
									downloadRequestBuilder.setSync(true);
									downloadRequestBuilder.setFormatIdentifier("Ifc2x3");
									DownloadResponse downloadResponse = service.download(rpcController, downloadRequestBuilder.build());
									if (downloadResponse.getErrorMessage().equals("OKE")) {
										
									} else {
										fail(downloadResponse.getErrorMessage());
									}

									CheckoutRequest.Builder checkoutRequestBuilder = CheckoutRequest.newBuilder();
									checkoutRequestBuilder.setRoid(revision.getOid());
									checkoutRequestBuilder.setSync(true);
									checkoutRequestBuilder.setFormatIdentifier("Ifc2x3");
									DownloadResponse checkoutResponse = service.download(rpcController, downloadRequestBuilder.build());
									if (checkoutResponse.getErrorMessage().equals("OKE")) {
										GetDownloadDataRequest.Builder getDownloadDataRequestBuilder = GetDownloadDataRequest.newBuilder();
										getDownloadDataRequestBuilder.setActionID(checkoutResponse.getValue());
										GetDownloadDataResponse getDownloadDataResponse = service.getDownloadData(rpcController, getDownloadDataRequestBuilder.build());
										if (getDownloadDataResponse.getErrorMessage().equals("OKE")) {
											SDownloadResult downloadResult = getDownloadDataResponse.getValue();
											ByteString data = downloadResult.getFile();
											byte[] byteArray = data.toByteArray(); // This is the IFC file
											System.out.println("Bytes: " + byteArray.length);
										} else {
											fail(getDownloadDataResponse.getErrorMessage());
										}
									} else {
										fail(checkoutResponse.getErrorMessage());
									}
								}
							} else {
								fail(getAllRevisionsOfProjectResponse.getErrorMessage());
							}
						}
					}
				} else {
					fail(getAllProjectsResponse.getErrorMessage());
				}
			} else {
				fail(loginResponse.getErrorMessage());
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	private ByteString createByteString(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(fis, baos);
			ByteString byteString = ByteString.copyFrom(baos.toByteArray());
			fis.close();
			return byteString;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}