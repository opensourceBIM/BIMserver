//package org.bimserver.tests;
//
///******************************************************************************
// * (c) Copyright bimserver.org 2009
// * Licensed under GNU GPLv3
// * http://www.gnu.org/licenses/gpl-3.0.txt
// * For more information mail to license@bimserver.org
// *
// * Bimserver.org is free software: you can redistribute it and/or modify 
// * it under the terms of the GNU General Public License as published by 
// * the Free Software Foundation, either version 3 of the License, or
// * (at your option) any later version.
// *
// * Bimserver.org is distributed in the hope that it will be useful, but 
// * WITHOUT ANY WARRANTY; without even the implied warranty of 
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
// * General Public License for more details.
// *
// * You should have received a copy of the GNU General Public License a 
// * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
// *****************************************************************************/
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.Callable;
//import java.util.concurrent.CompletionService;
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.ExecutorCompletionService;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Future;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//import javax.activation.DataHandler;
//import javax.activation.FileDataSource;
//import javax.xml.ws.soap.SOAPFaultException;
//
//import nl.tue.buildingsmart.emf.DerivedReader;
//import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;
//import nl.tue.buildingsmart.express.parser.ExpressSchemaParser;
//
//import org.apache.cxf.frontend.ClientProxy;
//import org.apache.cxf.frontend.ClientProxyFactoryBean;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.bimserver.ifc.file.reader.IfcFileReader;
//import org.bimserver.interfaces.objects.SProject;
//import org.bimserver.shared.ServiceInterface;
//import org.bimserver.shared.Token;
//import org.bimserver.shared.UserException;
//import org.bimserver.tests.TestResult.ResultCode;
//import org.bimserver.utils.Formatters;
//
//public class BimServerTester {
//	private final HtmlWriter htmlWriter = new HtmlWriter(new File("result.html"));
//	private SchemaDefinition schema;
//	private ExecutorService executorService = new ThreadPoolExecutor(3, 3, Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingDeque<Runnable>());
//	private CompletionService<TestResult> completionService = new ExecutorCompletionService<TestResult>(executorService);
//	private File ifcFilesSourceDir;
//	private final List<Integer> userIds = new ArrayList<Integer>();
//	private final List<Integer> projectIds = new ArrayList<Integer>();
//
//	public static void main(String[] args) {
//		if (args.length > 0) {
//			String action = args[0];
//			if (action.equalsIgnoreCase("test")) {
//				new BimServerTester(new File(args[1])).start();
//			}
//		} else {
//			new BimServerTester(new File("G:\\ifc selected")).start();
//		}
//	}
//
//	public BimServerTester(File testFilesDir) {
//		ifcFilesSourceDir = testFilesDir;
//	}
//
//	private void start() {
//		ExpressSchemaParser schemaParser = new ExpressSchemaParser(IfcFileReader.DEFAULT_SCHEMA_FILE);
//		schemaParser.parse();
//		schema = schemaParser.getSchema();
//		try {
//			new DerivedReader(IfcFileReader.DEFAULT_SCHEMA_FILE, schema);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		htmlWriter.startTable("File", "Size", "Exec. Time", "Result Code", "Result Description");
//		for (final File file : ifcFilesSourceDir.listFiles()) {
//			if (file.getName().endsWith(".ifc")) {
//				completionService.submit(new Callable<TestResult>() {
//					@Override
//					public TestResult call() throws Exception {
//						return test(file);
//					}
//				});
//			}
//		}
////		File[] files = new File[]{TestFile.REVIT_QUANTITIES.getFile(), TestFile.BATHROOM.getFile(), TestFile.MERGE_TEST_SOURCE_FILE.getFile()};
////		for (final File file : files) {
////			if (file.getName().endsWith(".ifc")) {
////				completionService.submit(new Callable<TestResult>() {
////					@Override
////					public TestResult call() throws Exception {
////						return test(file);
////					}
////				});
////			}
////		}
//		try {
//			Future<TestResult> take = completionService.take();
//			while (take != null) {
//				TestResult result = take.get();
//				htmlWriter.addRow(result.getFile().getName(), Formatters.bytesToString(result.getFile().length()), result.getTotalTime() / 1000000 + " ms", "" + result.getResultCode(), result.getDescription());
//				take = completionService.take();
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
//		htmlWriter.endTable();
//		htmlWriter.close();
//	}
//
//	private TestResult test(File sourceFile) {
//		Random random = new Random();
//		ClientProxyFactoryBean clientProxyFactoryBean = new ClientProxyFactoryBean();
//		clientProxyFactoryBean.setServiceClass(ServiceInterface.class);
//		clientProxyFactoryBean.setAddress("http://localhost:8081/bimserver/services/anonymous");
////		clientProxyFactoryBean.setAddress("http://192.168.5.34:8080/bimserver-0.2RC1/services/anonymous");
//		ServiceInterface client = (ServiceInterface) clientProxyFactoryBean.create();
//
//		HTTPConduit http = (HTTPConduit) ClientProxy.getClient(client).getConduit();
//		http.getClient().setConnectionTimeout(3600000); // 1 hour
//		http.getClient().setAllowChunking(false);
//		http.getClient().setReceiveTimeout(3600000); // 1 hour
//
//		TestResult testResult = new TestResult(sourceFile);
//
//		String projectName = "project " + random.nextInt();
//		Token token = null;
//		try {
//			token = client.login("admin", "admin");
//		} catch (UserException e) {
//			testResult.setDescription(e.getMessage());
//			testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
//			return testResult;
//		}
//		int userId = 0;
//		if (random.nextBoolean() || userIds.size() < 3) {
//			String username1 = "user" + random.nextInt();
//			String password1 = "password";
//			try {
//				userId = client.addUser(token, username1, password1, username1);
//				userIds.add(userId);
//			} catch (UserException e) {
//				testResult.setDescription(e.getMessage());
//				testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
//				logout(client, token);
//				return testResult;
//			}
//		} else {
//			userId = userIds.get(random.nextInt(userIds.size()));
//		}
//
//		int projectId = 0;
//		if (random.nextBoolean() || projectIds.size() < 3) {
//			try {
//				SProject sProject = client.addProject(token, projectName);
//				projectIds.add(sProject.getId());
//			} catch (UserException e) {
//				testResult.setDescription(e.getMessage());
//				testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
//				logout(client, token);
//				return testResult;
//			}
//		} else {
//			projectId = projectIds.get(random.nextInt(projectIds.size()));
//		}
//		try {
//			client.addUserToProject(token, userId, projectId);
//		} catch (UserException e) {
//			testResult.setDescription(e.getMessage());
//			testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
//			logout(client, token);
//			return testResult;
//		}
//
//		try {
//			client.checkin(token, projectId, sourceFile.getName(), sourceFile.length(), new DataHandler(new FileDataSource(sourceFile)));
//			testResult.setResultCode(ResultCode.OKE);
//			testResult.setDescription("OKE");
//		} catch (UserException e) {
//			testResult.setDescription(e.getUserMessage());
//			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
//		} catch (SOAPFaultException e) {
//			testResult.setDescription(e.getMessage());
//			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
//		} catch (Exception e) {
//			testResult.setDescription(e.getMessage());
//			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
//		}
//		logout(client, token);
//		return testResult;
//	}
//
//	private void logout(ServiceInterface client, Token token) {
//		client.logout(token);
//	}
//}