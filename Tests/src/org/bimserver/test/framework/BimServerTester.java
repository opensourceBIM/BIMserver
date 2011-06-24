package org.bimserver.test.framework;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.pb.ProtocolBuffersServiceInterfaceImplementation;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.ServiceInterface;
import org.bimserver.test.framework.TestResult.ResultCode;
import org.bimserver.tests.HtmlWriter;
import org.bimserver.utils.Formatters;

public class BimServerTester {
	private final HtmlWriter htmlWriter = new HtmlWriter(new File("result.html"));
	private final ExecutorService executorService = new ThreadPoolExecutor(1, 1, Long.MAX_VALUE, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
	private final CompletionService<TestResult> completionService = new ExecutorCompletionService<TestResult>(executorService);
	private final Map<Long, String> userIds = new HashMap<Long, String>();
	private final List<Long> projectIds = new ArrayList<Long>();
	private File ifcFilesSourceDir;

	public static void main(String[] args) {
		if (args.length > 0) {
			String action = args[0];
			if (action.equalsIgnoreCase("test")) {
				new BimServerTester(new File(args[1])).start();
			}
		} else {
//			new BimServerTester(new File("C:\\Users\\Ruben\\Documents\\My Dropbox\\Logic Labs\\Projecten\\TNO\\ifc selected")).start();
			new BimServerTester(new File("C:\\Users\\Ruben\\Documents\\My Dropbox\\Logic Labs\\Projecten\\TNO\\ifc selected")).test(new File("C:\\Users\\Ruben\\Workspaces\\BIMserver\\TestData\\data\\AC11-Institute-Var-2-IFC.ifc"));
		}
	}

	public BimServerTester(File testFilesDir) {
		ifcFilesSourceDir = testFilesDir;
	}

	private ServiceInterface createProtocolBuffersClient(String address) {
		return new ProtocolBuffersServiceInterfaceImplementation(address, 8020);
	}
	
	public ServiceInterface createSoapClient(final String address) {
		ServiceInterface service;
		JaxWsProxyFactoryBean cpfb = new JaxWsProxyFactoryBean();
		cpfb.setServiceClass(ServiceInterface.class);
		cpfb.setAddress(address);
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("mtom-enabled", Boolean.TRUE);
		cpfb.setProperties(properties);

		service = (ServiceInterface) cpfb.create();

		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(service);
//		client.getInInterceptors().add(new LoggingInInterceptor(ConsoleAppender.getPrintWriter()));
//		client.getOutInterceptors().add(new LoggingOutInterceptor(ConsoleAppender.getPrintWriter()));
		HTTPConduit http = (HTTPConduit) client.getConduit();
		((BindingProvider) service).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		http.getClient().setConnectionTimeout(360000);
		http.getClient().setAllowChunking(false);
		http.getClient().setReceiveTimeout(320000);
		return service;
	}

	private void start() {
		htmlWriter.startTable("File", "Size", "Exec. Time", "Result Code", "Result Description");
		File[] listFiles = ifcFilesSourceDir.listFiles();
		Set<File> files = new TreeSet<File>(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		for (final File file : listFiles) {
			if (file.getName().endsWith(".ifc")) {
				files.add(file);
			}
		}
		for (final File file : files) {
			completionService.submit(new Callable<TestResult>() {
				@Override
				public TestResult call() throws Exception {
					return test(file);
				}
			});
		}
		try {
			Future<TestResult> take = completionService.take();
			while (take != null) {
				TestResult result = take.get();
				htmlWriter.addRow(result.getFile().getName(), Formatters.bytesToString(result.getFile().length()), result.getTotalTime() / 1000000 + " ms", ""
						+ result.getResultCode(), result.getDescription());
				take = completionService.take();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		htmlWriter.endTable();
		htmlWriter.close();
	}

	private TestResult test(File sourceFile) {
		Random random = new Random();

		ServiceInterface client = createProtocolBuffersClient("localhost");
//		ServiceInterface client = createSoapClient("http://localhost:8082/soap");

		TestResult testResult = new TestResult(sourceFile);

		int nr = random.nextInt(100000000);
		String projectName = "project " + nr;
		try {
			client.login("admin@bimserver.org", "admin");
		} catch (ServiceException e) {
			testResult.setDescription(e.getFullMessage());
			testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
			return testResult;
		}
		long userId = 0;
		if (random.nextBoolean() || userIds.size() < 3) {
			String username = nr + "@bimserver.org";
			String name = "user " + nr;
			String password = "password";
			try {
				userId = client.addUser(username, name, SUserType.USER, false);
				client.changePassword(userId, "", password);
				userIds.put(userId, username);
			} catch (ServiceException e) {
				testResult.setDescription(e.getFullMessage());
				testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
				try {
					client.logout();
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
				return testResult;
			}
		} else {
			userId = (Long) userIds.keySet().toArray()[userIds.size()-1];
		}

		long projectId = 0;
		if (random.nextInt(5) == 1 || projectIds.size() < 3) {
			try {
				SProject sProject = client.addProject(projectName);
				projectIds.add(sProject.getOid());
				projectId = sProject.getOid();
			} catch (ServiceException e) {
				testResult.setDescription(e.getFullMessage());
				testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
				try {
					client.logout();
				} catch (ServiceException e1) {
					e1.printStackTrace();
				}
				return testResult;
			}
		} else {
			projectId = projectIds.get(random.nextInt(projectIds.size()));
		}
		try {
			client.addUserToProject(userId, projectId);
		} catch (ServiceException e) {
			testResult.setDescription(e.getFullMessage());
			testResult.setResultCode(ResultCode.OTHER_SERVER_ERROR);
			try {
				client.logout();
			} catch (ServiceException e1) {
				e1.printStackTrace();
			}
			return testResult;
		}
		try {
			client.login(userIds.get(userId), "password");
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		try {
			client.checkinSync(projectId, sourceFile.getName(), sourceFile.length(), new DataHandler(new FileDataSource(sourceFile)), false);
			testResult.setResultCode(ResultCode.OKE);
			testResult.setDescription("Checkin successfull");
		} catch (ServiceException e) {
			testResult.setDescription(e.getFullMessage());
			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
		} catch (SOAPFaultException e) {
			testResult.setDescription(e.getMessage());
			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
		} catch (Exception e) {
			testResult.setDescription(e.getMessage());
			testResult.setResultCode(ResultCode.SERVER_COMMIT_ERROR);
		}
		try {
			client.logout();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return testResult;
	}
}