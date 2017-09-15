package org.bimserver.servlets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import javax.activation.DataHandler;
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
import org.bimserver.database.OldQuery.Deep;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.ifc.BasicIfcModel;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.PluginDescriptor;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.SchemaName;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.services.ServicePlugin;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.utils.InputStreamDataSource;
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
					if (getBimServer().getServerSettingsCache().getServerSettings().isStoreServiceRuns()) {
						// When we store service runs, we can just use the streaming deserializer to stream directly to the database, after that we'll trigger the actual service
						
						// Create or find project and link user and service to project
						// Checkin stream into project
						// Trigger service
						
						ServiceInterface serviceInterface = getBimServer().getServiceFactory().get(authorization, AccessMethod.INTERNAL).get(ServiceInterface.class);
						SProject project = serviceInterface.addProject("tmp-" + new Random().nextInt(), "ifc2x3tc1");
						SDeserializerPluginConfiguration deserializer = serviceInterface.getSuggestedDeserializerForExtension("ifc", project.getOid());
						serviceInterface.checkin(project.getOid(), "Auto checkin", deserializer.getOid(), -1L, "s", new DataHandler(new InputStreamDataSource(request.getInputStream())), false, true);
						project = serviceInterface.getProjectByPoid(project.getOid());
						
						PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(project.getSchema());
						IfcModelInterface model = new BasicIfcModel(packageMetaData, null);
						try {
							Revision revision = session.get(project.getLastRevisionId(), OldQuery.getDefault());
							session.getMap(model, new OldQuery(packageMetaData, project.getId(), revision.getId(), revision.getOid(), null, Deep.NO));
						} catch (BimserverDatabaseException e) {
							e.printStackTrace();
						}
						
						BimServerBimBotsInput input = new BimServerBimBotsInput(getBimServer(), authorization.getUoid(), null, null, model);
						BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, foundService.getSettings());
						
						SExtendedData extendedData = new SExtendedData();
						SFile file = new SFile();
						file.setData(output.getData());
						file.setFilename(output.getContentDisposition());
						file.setMime(output.getContentType());
						file.setSize(output.getData().length);
						Long fileId = serviceInterface.uploadFile(file);
						extendedData.setFileId(fileId);
						extendedData.setTitle(output.getTitle());
						SExtendedDataSchema extendedDataSchema = null;
						try {
							extendedDataSchema = serviceInterface.getExtendedDataSchemaByName(output.getSchemaName().name());
						} catch (UserException e) {
							extendedDataSchema = new SExtendedDataSchema();
							extendedDataSchema.setContentType(output.getContentType());
							extendedDataSchema.setName(output.getSchemaName().name());
							serviceInterface.addExtendedDataSchema(extendedDataSchema);
						}
						extendedData.setSchemaId(extendedDataSchema.getOid());
						serviceInterface.addExtendedDataToRevision(project.getLastRevisionId(), extendedData);
						
						response.setHeader("Output-Type", output.getSchemaName().name());
						response.setHeader("Data-Title", output.getTitle());
						response.setHeader("Content-Type", output.getContentType());
						response.setHeader("Content-Disposition", output.getContentDisposition());
						response.getOutputStream().write(output.getData());
					} else {
						// When we don't store the service runs, there is no other way than to just use the old deserializer and run the service from the EMF model
						
						DeserializerPlugin deserializerPlugin = getBimServer().getPluginManager().getFirstDeserializer("ifc", Schema.IFC2X3TC1, true);
						if (deserializerPlugin == null) {
							throw new BimBotsException("No deserializer plugin found");
						}
						
						byte[] data = IOUtils.toByteArray(request.getInputStream());
						SchemaName schema = SchemaName.valueOf(inputType);
						
						Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
						PackageMetaData packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData("ifc2x3tc1");
						deserializer.init(packageMetaData);
						IfcModelInterface model = deserializer.read(new ByteArrayInputStream(data), schema.name(), data.length, null);
						
						BimServerBimBotsInput input = new BimServerBimBotsInput(getBimServer(), authorization.getUoid(), schema, data, model);
						BimBotsOutput output = bimBotsServiceInterface.runBimBot(input, foundService.getSettings());
						response.setHeader("Output-Type", output.getSchemaName().name());
						response.setHeader("Data-Title", output.getTitle());
						response.setHeader("Content-Type", output.getContentType());
						response.setHeader("Content-Disposition", output.getContentDisposition());
						response.getOutputStream().write(output.getData());
					}
				} catch (BimBotsException e) {
					e.printStackTrace();
				} catch (DeserializeException e) {
					e.printStackTrace();
				} catch (PluginException e) {
					e.printStackTrace();
				} catch (ServerException e1) {
					e1.printStackTrace();
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