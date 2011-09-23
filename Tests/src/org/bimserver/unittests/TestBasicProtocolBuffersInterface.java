package org.bimserver.unittests;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

//import static org.junit.Assert.fail;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.util.Random;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
//import org.bimserver.BimServer;
//import org.bimserver.LocalDevPluginLoader;
//import org.bimserver.ServerInfo.ServerState;
//import org.bimserver.database.BimDatabaseException;
//import org.bimserver.database.DatabaseRestartRequiredException;
//import org.bimserver.database.berkeley.DatabaseInitException;
//import org.bimserver.pb.ServiceInterfaceImpl;
//import org.bimserver.pb.ServiceInterfaceImpl.AddProjectRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.AddProjectResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.AddUserRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.AddUserResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.ChangePasswordRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.ChangePasswordResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.CheckinSyncRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.CheckinSyncResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.CheckoutRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.DownloadRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.DownloadResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.GetAllProjectsRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.GetAllProjectsResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.GetAllRevisionsOfProjectRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.GetAllRevisionsOfProjectResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.GetDownloadDataRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.GetDownloadDataResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.GetProjectsByNameRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.GetProjectsByNameResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.GetRevisionSummaryRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.GetRevisionSummaryResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.LoginRequest;
//import org.bimserver.pb.ServiceInterfaceImpl.LoginResponse;
//import org.bimserver.pb.ServiceInterfaceImpl.SDownloadResult;
//import org.bimserver.pb.ServiceInterfaceImpl.SProject;
//import org.bimserver.pb.ServiceInterfaceImpl.SRevision;
//import org.bimserver.pb.ServiceInterfaceImpl.SRevisionSummary;
//import org.bimserver.pb.ServiceInterfaceImpl.SRevisionSummaryContainer;
//import org.bimserver.pb.ServiceInterfaceImpl.SRevisionSummaryType;
//import org.bimserver.pb.ServiceInterfaceImpl.SUserType;
//import org.bimserver.pb.ServiceInterfaceImpl.ServiceInterface.BlockingInterface;
//import org.bimserver.plugins.PluginException;
//import org.bimserver.shared.LocalDevelopmentResourceFetcher;
//import org.bimserver.shared.pb.SocketChannel;
//import org.bimserver.tests.TestFile;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import com.google.protobuf.BlockingRpcChannel;
//import com.google.protobuf.ByteString;
//import com.google.protobuf.ServiceException;
//
//public class TestBasicProtocolBuffersInterface {
//	private static String username = "test" + new Random().nextInt() + "@bimserver.org";
//	private static String password = "test";
//	private static BimServer bimServer;
//	private static String projectName = "Test" + new Random().nextInt();
//
//	@BeforeClass
//	public static void initClass() {
//		try {
//			File home = new File("home");
//			if (home.isDirectory()) {
//				FileUtils.deleteDirectory(home);
//			}
//
//			// Create a BIMserver
//			bimServer = new BimServer(new File("home"), new LocalDevelopmentResourceFetcher());
//
//			// Load plugins
//			LocalDevPluginLoader.loadPlugins(bimServer.getPluginManager());
//
//			// Start
//			bimServer.start();
//
//			// Convenience, setup the server to make sure it is in RUNNING state
//			if (bimServer.getServerInfo().getServerState() == ServerState.NOT_SETUP) {
//				bimServer.getSystemService().setup("http://localhost", "localhost", "Administrator", "admin@bimserver.org", "admin", true);
//			}
//
//			// Change a setting to normal users can create projects
//			bimServer.getSettingsManager().getSettings().setAllowUsersToCreateTopLevelProjects(true);
//		} catch (org.bimserver.shared.exceptions.ServiceException e) {
//			e.printStackTrace();
//		} catch (PluginException e) {
//			e.printStackTrace();
//		} catch (DatabaseInitException e) {
//			e.printStackTrace();
//		} catch (BimDatabaseException e) {
//			e.printStackTrace();
//		} catch (DatabaseRestartRequiredException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/*
//	 * Cleanup
//	 */
//	@AfterClass
//	public static void shutdownClass() {
//		bimServer.stop();
//	}
//
//	/*
//	 * Tests whether a user can be created and it's password reset, this user is
//	 * also used for subsequent tests
//	 */
//	@Test
//	public void testCreateUser() {
//		try {
//			SocketChannel socketChannel = new SocketChannel(new InetSocketAddress("localhost", 8020));
//			
//
//			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
//			loginRequestBuilder.setUsername("admin@bimserver.org");
//			loginRequestBuilder.setPassword("admin");
//			LoginRequest loginRequest = loginRequestBuilder.build();
//			LoginResponse loginResponse = service.login(rpcController, loginRequest);
//			if (loginResponse.getErrorMessage().equals("OKE")) {
//				if (loginResponse.getValue()) {
//					AddUserRequest.Builder addUserRequestBuilder = AddUserRequest.newBuilder();
//					addUserRequestBuilder.setUsername(username);
//					addUserRequestBuilder.setName("Test");
//					addUserRequestBuilder.setType(SUserType.USER);
//					addUserRequestBuilder.setSelfRegistration(false);
//					AddUserResponse addUserResponse = service.addUser(rpcController, addUserRequestBuilder.build());
//					if (addUserResponse.getErrorMessage().equals("OKE")) {
//						long uoid = addUserResponse.getValue();
//						ChangePasswordRequest.Builder changePasswordRequestBuilder = ChangePasswordRequest.newBuilder();
//						changePasswordRequestBuilder.setUoid(uoid);
//						changePasswordRequestBuilder.setNewPassword(password);
//						ChangePasswordResponse changePasswordResponse = service.changePassword(rpcController, changePasswordRequestBuilder.build());
//						if (changePasswordResponse.getErrorMessage().equals("OKE")) {
//						} else {
//							fail(changePasswordResponse.getErrorMessage());
//						}
//					} else {
//						fail(addUserResponse.getErrorMessage());
//					}
//				} else {
//					System.err.println("Error logging in");
//					fail("Error logging in");
//				}
//			} else {
//				fail(loginResponse.getErrorMessage());
//			}
//		} catch (ServiceException e) {
//			fail(e.getMessage());
//		}
//	}
//
//	/*
//	 * This will create a project and checkin the AC11 IFC file
//	 */
//	@Test
//	public void testUpload() {
//		try {
//			BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
//			SocketRpcController rpcController = new SocketRpcController();
//			BlockingInterface service = ServiceInterfaceImpl.ServiceInterface.newBlockingStub(rpcChannel);
//
//			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
//			loginRequestBuilder.setUsername(username);
//			loginRequestBuilder.setPassword(password);
//			LoginResponse loginResponse = service.login(rpcController, loginRequestBuilder.build());
//			if (loginResponse.getErrorMessage().equals("OKE")) {
//				AddProjectRequest.Builder addProjectRequestBuilder = AddProjectRequest.newBuilder();
//				addProjectRequestBuilder.setProjectName(projectName);
//				AddProjectResponse addProjectResponse = service.addProject(rpcController, addProjectRequestBuilder.build());
//				if (addProjectResponse.getErrorMessage().equals("OKE")) {
//					SProject project = addProjectResponse.getValue();
//					File sourceFile = TestFile.AC11.getFile();
//
//					CheckinSyncRequest.Builder checkinSyncRequestBuilder = CheckinSyncRequest.newBuilder();
//					checkinSyncRequestBuilder.setDeserializerName("IfcStepDeserializer");
//					checkinSyncRequestBuilder.setPoid(project.getOid());
//					checkinSyncRequestBuilder.setComment("test");
//					checkinSyncRequestBuilder.setFileSize(sourceFile.length());
//					checkinSyncRequestBuilder.setIfcFile(createByteString(sourceFile));
//
//					CheckinSyncResponse checkinSyncResponse = service.checkinSync(rpcController, checkinSyncRequestBuilder.build());
//					if (checkinSyncResponse.getErrorMessage().equals("OKE")) {
//
//					} else {
//						fail(checkinSyncResponse.getErrorMessage());
//					}
//				} else {
//					fail(addProjectResponse.getErrorMessage());
//				}
//			} else {
//				fail(loginResponse.getErrorMessage());
//			}
//		} catch (ServiceException e) {
//			fail(e.getMessage());
//		}
//	}
//
//	@Test
//	public void testGetProjectByName() {
//		BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
//		SocketRpcController rpcController = new SocketRpcController();
//		BlockingInterface service = ServiceInterfaceImpl.ServiceInterface.newBlockingStub(rpcChannel);
//
//		GetProjectsByNameRequest.Builder getProjectByNameRequestBuilder = GetProjectsByNameRequest.newBuilder();
//		getProjectByNameRequestBuilder.setName(projectName);
//		try {
//			GetProjectsByNameResponse getProjectByNameResponse = service.getProjectsByName(rpcController, getProjectByNameRequestBuilder.build());
//			if (getProjectByNameResponse.getErrorMessage().equals("OKE")) {
//				System.out.println(getProjectByNameResponse.getValueList().size() + " projects with name " + projectName);
//			} else {
//				fail(getProjectByNameResponse.getErrorMessage());
//			}
//		} catch (ServiceException e) {
//			fail(e.getMessage());
//		}
//	}
//
//	/*
//	 * This will list all projects, select the first project with at least one
//	 * revision and dump the names of all walls within the last revision of that
//	 * project
//	 */
//	@Test
//	public void testDump() {
//		try {
//			BlockingRpcChannel rpcChannel = RpcChannels.newBlockingRpcChannel(SocketRpcConnectionFactories.createRpcConnectionFactory("localhost", 8020));
//			SocketRpcController rpcController = new SocketRpcController();
//			BlockingInterface service = ServiceInterfaceImpl.ServiceInterface.newBlockingStub(rpcChannel);
//
//			LoginRequest.Builder loginRequestBuilder = LoginRequest.newBuilder();
//			loginRequestBuilder.setUsername(username);
//			loginRequestBuilder.setPassword(password);
//			LoginResponse loginResponse = service.login(rpcController, loginRequestBuilder.build());
//			if (loginResponse.getErrorMessage().equals("OKE")) {
//				GetAllProjectsRequest.Builder getAllProjectsRequestBuilder = GetAllProjectsRequest.newBuilder();
//				GetAllProjectsResponse getAllProjectsResponse = service.getAllProjects(rpcController, getAllProjectsRequestBuilder.build());
//				if (getAllProjectsResponse.getErrorMessage().equals("OKE")) {
//					for (SProject project : getAllProjectsResponse.getValueList()) {
//						System.out.println(project.getName());
//						if (project.getRevisionsCount() > 0) {
//							GetAllRevisionsOfProjectRequest.Builder getAllRevisionsOfProjectRequestBuilder = GetAllRevisionsOfProjectRequest.newBuilder();
//							getAllRevisionsOfProjectRequestBuilder.setPoid(project.getOid());
//							GetAllRevisionsOfProjectResponse getAllRevisionsOfProjectResponse = service.getAllRevisionsOfProject(rpcController,
//									getAllRevisionsOfProjectRequestBuilder.build());
//							if (getAllRevisionsOfProjectResponse.getErrorMessage().equals("OKE")) {
//								for (SRevision revision : getAllRevisionsOfProjectResponse.getValueList()) {
//									GetRevisionSummaryRequest.Builder getRevisionSummaryRequestBuilder = GetRevisionSummaryRequest.newBuilder();
//									getRevisionSummaryRequestBuilder.setRoid(revision.getOid());
//									GetRevisionSummaryResponse getRevisionSummaryResponse = service.getRevisionSummary(rpcController, getRevisionSummaryRequestBuilder.build());
//									if (getRevisionSummaryResponse.getErrorMessage().equals("OKE")) {
//										SRevisionSummary sRevisionSummary = getRevisionSummaryResponse.getValue();
//										for (SRevisionSummaryContainer container : sRevisionSummary.getListList()) {
//											System.out.println(container.getName());
//											for (SRevisionSummaryType type : container.getTypesList()) {
//												System.out.println("\t" + type.getName() + ": " + type.getCount());
//											}
//										}
//									} else {
//										fail(getRevisionSummaryResponse.getErrorMessage());
//									}
//
//									DownloadRequest.Builder downloadRequestBuilder = DownloadRequest.newBuilder();
//									downloadRequestBuilder.setRoid(revision.getOid());
//									downloadRequestBuilder.setSync(true);
//									downloadRequestBuilder.setFormatIdentifier("Ifc2x3");
//									DownloadResponse downloadResponse = service.download(rpcController, downloadRequestBuilder.build());
//									if (downloadResponse.getErrorMessage().equals("OKE")) {
//
//									} else {
//										fail(downloadResponse.getErrorMessage());
//									}
//
//									CheckoutRequest.Builder checkoutRequestBuilder = CheckoutRequest.newBuilder();
//									checkoutRequestBuilder.setRoid(revision.getOid());
//									checkoutRequestBuilder.setSync(true);
//									checkoutRequestBuilder.setFormatIdentifier("Ifc2x3");
//									DownloadResponse checkoutResponse = service.download(rpcController, downloadRequestBuilder.build());
//									if (checkoutResponse.getErrorMessage().equals("OKE")) {
//										GetDownloadDataRequest.Builder getDownloadDataRequestBuilder = GetDownloadDataRequest.newBuilder();
//										getDownloadDataRequestBuilder.setActionID(checkoutResponse.getValue());
//										GetDownloadDataResponse getDownloadDataResponse = service.getDownloadData(rpcController, getDownloadDataRequestBuilder.build());
//										if (getDownloadDataResponse.getErrorMessage().equals("OKE")) {
//											SDownloadResult downloadResult = getDownloadDataResponse.getValue();
//											ByteString data = downloadResult.getFile();
//											byte[] byteArray = data.toByteArray(); // This
//																					// is
//																					// the
//																					// IFC
//																					// file
//											System.out.println("Bytes: " + byteArray.length);
//										} else {
//											fail(getDownloadDataResponse.getErrorMessage());
//										}
//									} else {
//										fail(checkoutResponse.getErrorMessage());
//									}
//								}
//							} else {
//								fail(getAllRevisionsOfProjectResponse.getErrorMessage());
//							}
//						}
//					}
//				} else {
//					fail(getAllProjectsResponse.getErrorMessage());
//				}
//			} else {
//				fail(loginResponse.getErrorMessage());
//			}
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}
//
//	private ByteString createByteString(File file) {
//		try {
//			FileInputStream fis = new FileInputStream(file);
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			IOUtils.copy(fis, baos);
//			ByteString byteString = ByteString.copyFrom(baos.toByteArray());
//			fis.close();
//			return byteString;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//}