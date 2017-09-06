package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.bimbots.BimBotsException;
import org.bimserver.bimbots.BimBotsOutput;
import org.bimserver.bimbots.BimBotsServiceInterface;
import org.bimserver.bimbots.BimServerBimBotsInput;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.SchemaName;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.webservices.authorization.AuthenticationException;
import org.bimserver.webservices.authorization.Authorization;

public class ServiceRunnerServlet extends SubServlet {

	public ServiceRunnerServlet(BimServer bimServer, ServletContext servletContext) {
		super(bimServer, servletContext);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		String token = null;
		if (token == null) {
			token = request.getHeader("token");
		}
		
		String serviceName = request.getRequestURI();
		if (serviceName.startsWith("/services/")) {
			serviceName = serviceName.substring(10);
		}
		long serviceOid = Long.parseLong(serviceName);
		
		String inputType = request.getHeader("Input-Type");
		
		try (DatabaseSession session = getBimServer().getDatabase().createSession()) {
			Authorization authorization = Authorization.fromToken(getBimServer().getEncryptionKey(), token);
			User user = session.get(authorization.getUoid(), OldQuery.getDefault());
			if (user == null) {
				throw new UserException("No user found with uoid " + authorization.getUoid());
			}
			if (user.getState() == ObjectState.DELETED) {
				throw new UserException("User has been deleted");
			}
			InternalServicePluginConfiguration foundService = null;
			UserSettings userSettings = user.getUserSettings();
			for (InternalServicePluginConfiguration internalServicePluginConfiguration : userSettings.getServices()) {
				if (internalServicePluginConfiguration.getOid() == serviceOid) {
					foundService = internalServicePluginConfiguration;
					break;
				}
			}
			if (foundService == null) {
				throw new ServletException("Service \"" + serviceName + "\" not found for this user");
			}
			PluginDescriptor pluginDescriptor = foundService.getPluginDescriptor();
			ServicePlugin servicePlugin = getBimServer().getPluginManager().getServicePlugin(pluginDescriptor.getPluginClassName(), true);
			if (servicePlugin instanceof BimBotsServiceInterface) {
				BimBotsServiceInterface bimBotsServiceInterface = (BimBotsServiceInterface)servicePlugin;
				try {
					BimServerBimBotsInput input = new BimServerBimBotsInput(getBimServer(), authorization.getUoid(), SchemaName.valueOf(inputType), IOUtils.toByteArray(request.getInputStream()));
					BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, foundService.getSettings());
					response.setHeader("Output-Type", output.getSchemaName().name());
					response.setHeader("Data-Title", output.getTitle());
					response.setHeader("Content-Type", output.getContentType());
					response.setHeader("Content-Disposition", output.getContentDisposition());
					response.getOutputStream().write(output.getData());
				} catch (BimBotsException e) {
					e.printStackTrace();
				}
			} else {
				throw new ServletException("Service \"" + serviceName + "\" does not implement the BimBotsServiceInterface");
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (UserException e) {
			e.printStackTrace();
		}
	}
}