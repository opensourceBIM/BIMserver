package org.bimserver.webservices.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.bimserver.BimServerImporter;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.client.json.JsonBimServerClientFactory;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.OperationType;
import org.bimserver.database.actions.AddExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.AddExtendedDataToProjectDatabaseAction;
import org.bimserver.database.actions.AddExtendedDataToRevisionDatabaseAction;
import org.bimserver.database.actions.AddLocalServiceToProjectDatabaseAction;
import org.bimserver.database.actions.AddModelCheckerDatabaseAction;
import org.bimserver.database.actions.AddModelCheckerToProjectDatabaseAction;
import org.bimserver.database.actions.AddNewServiceToProjectDatabaseAction;
import org.bimserver.database.actions.AddProjectDatabaseAction;
import org.bimserver.database.actions.AddServiceToProjectDatabaseAction;
import org.bimserver.database.actions.AddUserDatabaseAction;
import org.bimserver.database.actions.AddUserToExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.AddUserToProjectDatabaseAction;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.BranchToExistingProjectDatabaseAction;
import org.bimserver.database.actions.BranchToNewProjectDatabaseAction;
import org.bimserver.database.actions.ChangeUserTypeDatabaseAction;
import org.bimserver.database.actions.CheckinDatabaseAction;
import org.bimserver.database.actions.CloneToNewProjectDatabaseAction;
import org.bimserver.database.actions.CompareDatabaseAction;
import org.bimserver.database.actions.DeleteProjectDatabaseAction;
import org.bimserver.database.actions.DeleteServiceDatabaseAction;
import org.bimserver.database.actions.DeleteUserDatabaseAction;
import org.bimserver.database.actions.GetAllAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllCheckoutsOfRevisionDatabaseAction;
import org.bimserver.database.actions.GetAllExtendedDataSchemasDatabaseAction;
import org.bimserver.database.actions.GetAllModelCheckersDatabaseAction;
import org.bimserver.database.actions.GetAllNewServicesOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetAllNonAuthorizedUsersOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllProjectsSmallDatabaseAction;
import org.bimserver.database.actions.GetAllReadableProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRelatedProjectsDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsByUserDatabaseAction;
import org.bimserver.database.actions.GetAllRevisionsOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllServicesOfProjectDatabaseAction;
import org.bimserver.database.actions.GetAllUsersDatabaseAction;
import org.bimserver.database.actions.GetAllWritableProjectsDatabaseAction;
import org.bimserver.database.actions.GetAreaDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesDatabaseAction;
import org.bimserver.database.actions.GetAvailableClassesInRevisionDatabaseAction;
import org.bimserver.database.actions.GetCheckinWarningsDatabaseAction;
import org.bimserver.database.actions.GetCheckoutWarningsDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByIdDatabaseAction;
import org.bimserver.database.actions.GetDeserializerByNameDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataByIdDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataSchemaByIdDatabaseAction;
import org.bimserver.database.actions.GetExtendedDataSchemaByNameDatabaseAction;
import org.bimserver.database.actions.GetGeoTagDatabaseAction;
import org.bimserver.database.actions.GetGeometryInfoDatabaseAction;
import org.bimserver.database.actions.GetIfcHeaderDatabaseAction;
import org.bimserver.database.actions.GetModelCheckerOidDatabaseAction;
import org.bimserver.database.actions.GetNrPrimitivesDatabaseAction;
import org.bimserver.database.actions.GetNrPrimitivesTotalDatabaseAction;
import org.bimserver.database.actions.GetOidByGuidDatabaseAction;
import org.bimserver.database.actions.GetProjectByPoidDatabaseAction;
import org.bimserver.database.actions.GetProjectByUuidDatabaseAction;
import org.bimserver.database.actions.GetProjectsByNameDatabaseAction;
import org.bimserver.database.actions.GetProjectsOfUserDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByIdDatabaseAction;
import org.bimserver.database.actions.GetQueryEngineByNameDatabaseAction;
import org.bimserver.database.actions.GetRevisionDatabaseAction;
import org.bimserver.database.actions.GetRevisionSummaryDatabaseAction;
import org.bimserver.database.actions.GetSerializerByContentTypeDatabaseAction;
import org.bimserver.database.actions.GetSerializerByIdDatabaseAction;
import org.bimserver.database.actions.GetSerializerByNameDatabaseAction;
import org.bimserver.database.actions.GetSubProjectByNameDatabaseAction;
import org.bimserver.database.actions.GetSubProjectsDatabaseAction;
import org.bimserver.database.actions.GetTopLevelProjectByNameDatabaseAction;
import org.bimserver.database.actions.GetUserByUoidDatabaseAction;
import org.bimserver.database.actions.GetUserByUserNameDatabaseAction;
import org.bimserver.database.actions.GetVolumeDatabaseAction;
import org.bimserver.database.actions.RegenerateGeometryDatabaseAction;
import org.bimserver.database.actions.RemoveModelCheckerFromProjectDatabaseAction;
import org.bimserver.database.actions.RemoveNewServiceFromProjectDatabaseAction;
import org.bimserver.database.actions.RemoveServiceFromProjectDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromExtendedDataSchemaDatabaseAction;
import org.bimserver.database.actions.RemoveUserFromProjectDatabaseAction;
import org.bimserver.database.actions.SetRevisionTagDatabaseAction;
import org.bimserver.database.actions.StreamingCheckinDatabaseAction;
import org.bimserver.database.actions.UndeleteProjectDatabaseAction;
import org.bimserver.database.actions.UndeleteUserDatabaseAction;
import org.bimserver.database.actions.UpdateGeoTagDatabaseAction;
import org.bimserver.database.actions.UpdateModelCheckerDatabaseAction;
import org.bimserver.database.actions.UpdateProjectDatabaseAction;
import org.bimserver.database.actions.UpdateRevisionDatabaseAction;
import org.bimserver.database.actions.UploadFileDatabaseAction;
import org.bimserver.database.actions.UserHasCheckinRightsDatabaseAction;
import org.bimserver.database.actions.UserHasRightsDatabaseAction;
import org.bimserver.database.actions.ValidateModelCheckerDatabaseAction;
import org.bimserver.database.queries.om.DefaultQueries;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.emf.Schema;
import org.bimserver.geometry.accellerator.Node;
import org.bimserver.geometry.accellerator.NodeCounter;
import org.bimserver.geometry.accellerator.Octree;
import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SAction;
import org.bimserver.interfaces.objects.SBounds;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SDensity;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataAddedToRevision;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGeometryInfo;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SLongCheckinActionState;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SNewService;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.STile;
import org.bimserver.interfaces.objects.STrigger;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.interfaces.objects.SVector3f;
import org.bimserver.longaction.CannotBeScheduledException;
import org.bimserver.longaction.DownloadParameters;
import org.bimserver.longaction.DownloadParameters.DownloadType;
import org.bimserver.longaction.LongAction;
import org.bimserver.longaction.LongBranchAction;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckoutAction;
import org.bimserver.longaction.LongCopyAction;
import org.bimserver.longaction.LongDownloadAction;
import org.bimserver.longaction.LongDownloadOrCheckoutAction;
import org.bimserver.longaction.LongGenericAction;
import org.bimserver.longaction.LongStreamingCheckinAction;
import org.bimserver.longaction.LongStreamingDownloadAction;
import org.bimserver.mail.EmailMessage;
import org.bimserver.mail.MailSystem;
import org.bimserver.models.geometry.Bounds;
import org.bimserver.models.geometry.Vector3f;
import org.bimserver.models.log.LogAction;
import org.bimserver.models.store.Action;
import org.bimserver.models.store.CheckinRevision;
import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.DeserializerPluginConfiguration;
import org.bimserver.models.store.ExtendedData;
import org.bimserver.models.store.ExtendedDataSchema;
import org.bimserver.models.store.File;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.ModelCheckerInstance;
import org.bimserver.models.store.NewService;
import org.bimserver.models.store.OAuthAuthorizationCode;
import org.bimserver.models.store.OAuthServer;
import org.bimserver.models.store.ObjectState;
import org.bimserver.models.store.PluginBundleVersion;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.RevisionSummary;
import org.bimserver.models.store.SerializerPluginConfiguration;
import org.bimserver.models.store.Service;
import org.bimserver.models.store.ServiceDescriptor;
import org.bimserver.models.store.StoreExtendedData;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.bimserver.models.store.UserSettings;
import org.bimserver.models.store.UserType;
import org.bimserver.notifications.NewExtendedDataOnRevisionNotification;
import org.bimserver.notifications.NewRevisionNotification;
import org.bimserver.notifications.ProgressOnProjectTopic;
import org.bimserver.notifications.ProgressTopic;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.IfcSchemaDeterminer;
import org.bimserver.plugins.deserializers.StreamingDeserializer;
import org.bimserver.plugins.deserializers.StreamingDeserializerPlugin;
import org.bimserver.plugins.queryengine.QueryEnginePlugin;
import org.bimserver.plugins.serializers.ExtendedDataSource;
import org.bimserver.plugins.serializers.MessagingSerializerPlugin;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.plugins.services.BimServerClientInterface;
import org.bimserver.shared.BimServerClientFactory;
import org.bimserver.shared.compare.CompareWriter;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.utils.MultiplexingInputStream;
import org.bimserver.utils.NetUtils;
import org.bimserver.webservices.CheckoutComparator;
import org.bimserver.webservices.SNewServiceComparator;
import org.bimserver.webservices.SProjectComparator;
import org.bimserver.webservices.SRevisionComparator;
import org.bimserver.webservices.SServiceComparator;
import org.bimserver.webservices.SUserComparator;
import org.bimserver.webservices.ServiceMap;
import org.bimserver.webservices.authorization.ExplicitRightsAuthorization;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.eclipse.emf.common.util.EList;
import org.opensourcebim.bcf.BcfException;
import org.opensourcebim.bcf.BcfFile;
import org.opensourcebim.bcf.ReadOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;

public class ServiceImpl extends GenericServiceImpl implements ServiceInterface {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);

	@Override
	public Long checkout(Long roid, Long serializerOid, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		getAuthorization().canDownload(roid);
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		User user = null;
		try {
			SerializerPluginConfiguration serializerPluginConfiguration = (SerializerPluginConfiguration) session.get(serializerOid, OldQuery.getDefault());
//			org.bimserver.plugins.serializers.Serializer serializer = getBimServer().getEmfSerializerFactory().get(serializerOid).createSerializer(new org.bimserver.plugins.serializers.PluginConfiguration());
			if (serializerPluginConfiguration == null) {
				throw new UserException("No serializer with id " + serializerOid + " could be found");
			}
			if (!serializerPluginConfiguration.getPluginDescriptor().getPluginClassName().equals("org.bimserver.ifc.step.serializer.Ifc4StepSerializerPlugin")
					&& !serializerPluginConfiguration.getPluginDescriptor().getPluginClassName().equals("org.bimserver.ifc.step.serializer.Ifc2x3tc1StepSerializerPlugin")) {
				throw new UserException("Only IFC allowed when checking out");
			}
			DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), DownloadType.DOWNLOAD_PROJECTS);
			downloadParameters.setRoid(roid);
			downloadParameters.setSerializerOid(serializerOid);

			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			LongDownloadOrCheckoutAction longDownloadAction = new LongCheckoutAction(getBimServer(), user.getName(), user.getUsername(), downloadParameters, getAuthorization(), getInternalAccessMethod());
			try {
				getBimServer().getLongActionManager().start(longDownloadAction);
			} catch (CannotBeScheduledException e) {
				LOGGER.error("", e);
			}
			if (sync) {
				longDownloadAction.waitForCompletion();
			}
			return longDownloadAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void terminateLongRunningAction(Long topicId) throws ServerException, UserException {
		LongAction<?> longAction = getBimServer().getLongActionManager().getLongAction(topicId);
		if (longAction != null) {
			longAction.terminate();
		} else {
			throw new UserException("No data found for topicId " + topicId);
		}
	}

	@Override
	public SDownloadResult getDownloadData(final Long topicId) throws ServerException, UserException {
		LongAction<?> longAction = getBimServer().getLongActionManager().getLongAction(topicId);
		if (longAction == null) {
			throw new UserException("No data found for topicId " + topicId);
		}
		if (longAction instanceof LongStreamingDownloadAction) {
			LongStreamingDownloadAction longStreamingDownloadAction = (LongStreamingDownloadAction) longAction;
			if (longStreamingDownloadAction.getErrors().isEmpty()) {
				SCheckoutResult result;
				try {
					result = longStreamingDownloadAction.getCheckoutResult();
				} catch (SerializerException e) {
					throw new UserException(e);
				}
				return result;
			} else {
				LOGGER.error(longStreamingDownloadAction.getErrors().get(0));
				throw new ServerException(longStreamingDownloadAction.getErrors().get(0));
			}
		} else {
			LongDownloadOrCheckoutAction longDownloadAction = (LongDownloadOrCheckoutAction) longAction;
			try {
				longDownloadAction.waitForCompletion();
				if (longDownloadAction.getErrors().isEmpty()) {
					SCheckoutResult result = longDownloadAction.getCheckoutResult();
					return result;
				} else {
					LOGGER.error(longDownloadAction.getErrors().get(0));
					throw new ServerException(longDownloadAction.getErrors().get(0));
				}
			} catch (Exception e) {
				LOGGER.error("", e);
				throw new ServerException(e);
			}
		}
	}

	public Long download(DownloadParameters downloadParameters, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		User user = null;
		for (long roid : downloadParameters.getRoids()) {
			getAuthorization().canDownload(roid);
		}
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
		} catch (BimserverDatabaseException e) {
			throw new UserException(e);
		} finally {
			session.close();
		}
		LongDownloadOrCheckoutAction longDownloadAction = new LongDownloadAction(getBimServer(), user == null ? "Unknown" : user.getName(), user == null ? "Unknown" : user.getUsername(), downloadParameters, getAuthorization(),
				getInternalAccessMethod());
		try {
			getBimServer().getLongActionManager().start(longDownloadAction);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		if (sync) {
			longDownloadAction.waitForCompletion();
		}
		return longDownloadAction.getProgressTopic().getKey().getId();
	}

	@Override
	public Long download(Set<Long> roids, String jsonQuery, Long serializerOid, Boolean sync) throws ServerException, UserException {
		try {
			String username = getAuthorization().getUsername();
			DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
			Plugin plugin = null;
			try {
				SerializerPluginConfiguration serializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getSerializerPluginConfiguration(), serializerOid, OldQuery.getDefault());
				plugin = getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
			} catch (BimserverDatabaseException e) {
				throw new UserException(e);
			} finally {
				session.close();
			}

			if (plugin instanceof StreamingSerializerPlugin || plugin instanceof MessagingStreamingSerializerPlugin) {
				LongStreamingDownloadAction longDownloadAction = new LongStreamingDownloadAction(getBimServer(), username, username, getAuthorization(), serializerOid, jsonQuery, roids);
				try {
					getBimServer().getLongActionManager().start(longDownloadAction);
				} catch (Exception e) {
					LOGGER.error("", e);
				}
				if (sync) {
					longDownloadAction.waitForCompletion();
				}
				return longDownloadAction.getProgressTopic().getKey().getId();
			} else if (plugin instanceof MessagingSerializerPlugin) {
				requireAuthenticationAndRunningServer();
				DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), DownloadType.DOWNLOAD_BY_NEW_JSON_QUERY);
				downloadParameters.setRoids(roids);
				downloadParameters.setJsonQuery(jsonQuery);
				downloadParameters.setSerializerOid(serializerOid);
				return download(downloadParameters, sync);
			} else if (plugin instanceof SerializerPlugin) {
				requireAuthenticationAndRunningServer();
				DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), DownloadType.DOWNLOAD_BY_NEW_JSON_QUERY);
				downloadParameters.setRoids(roids);
				downloadParameters.setJsonQuery(jsonQuery);
				downloadParameters.setSerializerOid(serializerOid);
				return download(downloadParameters, sync);
			} else {
				throw new UserException("Unimplemented type of plugin: " + plugin);
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByName(String serializerName) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByNameDatabaseAction(session, getInternalAccessMethod(), serializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializerPluginConfiguration getDeserializerByName(String deserializerName) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByNameDatabaseAction(session, getInternalAccessMethod(), deserializerName)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializerPluginConfiguration getDeserializerById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetDeserializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByNameDatabaseAction(session, getInternalAccessMethod(), name)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SQueryEnginePluginConfiguration getQueryEngineById(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetQueryEngineByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SSerializerPluginConfiguration getSerializerById(Long oid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SSerializerPluginConfiguration getSerializerByContentType(String contentType) throws ServerException, UserException {
		// Not checking for real authentication here because a remote service should be
		// able to use a serializer for download call
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetSerializerByContentTypeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), contentType)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(String extension, Long poid) throws ServerException, UserException {
		if (extension.startsWith(".")) {
			extension = extension.substring(1);
		}
		// Token authenticated users should also be able to call this method
		try {
			requireAuthenticationAndRunningServer();
			DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
			List<DeserializerPluginConfiguration> list = new ArrayList<>();
			try {
				Project project = session.get(poid, OldQuery.getDefault());
				UserSettings userSettings = getUserSettings(session);
				for (DeserializerPluginConfiguration deserializer : userSettings.getDeserializers()) {
					Plugin plugin = getBimServer().getPluginManager().getPlugin(deserializer.getPluginDescriptor().getIdentifier(), true);
					if (plugin instanceof DeserializerPlugin) {
						DeserializerPlugin deserializerPlugin = (DeserializerPlugin) plugin;
						if (deserializerPlugin.getSupportedSchemas().contains(Schema.valueOf(project.getSchema().toUpperCase()))) {
							if (deserializerPlugin.canHandleExtension(extension)) {
								list.add(deserializer);
							}
						}
					} else if (plugin instanceof StreamingDeserializerPlugin) {
						StreamingDeserializerPlugin streamingDeserializerPlugin = (StreamingDeserializerPlugin) plugin;
						if (streamingDeserializerPlugin.getSupportedSchemas().contains(Schema.valueOf(project.getSchema().toUpperCase()))) {
							if (streamingDeserializerPlugin.canHandleExtension(extension)) {
								list.add(deserializer);
							}
						}
					}
				}
			} finally {
				session.close();
			}
			if (list.size() == 1) {
				return getBimServer().getSConverter().convertToSObject(list.get(0));
			} else if (list.size() > 1) {
				for (DeserializerPluginConfiguration deserializerPluginConfiguration : list) {
					Plugin plugin = getBimServer().getPluginManager().getPlugin(deserializerPluginConfiguration.getPluginDescriptor().getIdentifier(), true);
					// Prefer the streaming version
					if (plugin instanceof StreamingDeserializerPlugin) {
						return getBimServer().getSConverter().convertToSObject(deserializerPluginConfiguration);
					}
				}
				// Just return the first one
				return getBimServer().getSConverter().convertToSObject(list.get(0));
			}
		} catch (Exception e) {
			return handleException(e);
		}
		return null;
	}

	@Override
	public void addExtendedDataToRevision(Long roid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ExtendedData convert = getBimServer().getSConverter().convertFromSObject(extendedData, session.create(ExtendedData.class), session);
			session.executeAndCommitAction(new AddExtendedDataToRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, getAuthorization(), convert));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SExtendedDataSchema getExtendedDataSchemaById(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByIdDatabaseAction(session, getInternalAccessMethod(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SExtendedData getExtendedData(Long oid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataByIdDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), oid)));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public SRevision getRevision(Long roid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Revision> action = new GetRevisionDatabaseAction(session, getInternalAccessMethod(), roid, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProjectAsSubProject(String projectName, Long parentPoid, String schema) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, parentPoid, schema, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long clone(Long roid, String projectName, String comment, Boolean sync) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			CloneToNewProjectDatabaseAction action = new CloneToNewProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, projectName, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongCopyAction longAction = new LongCopyAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}
	
	@Override
	public Long branchToNewProject(Long roid, String projectName, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BranchToNewProjectDatabaseAction action = new BranchToNewProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, projectName, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longAction);
			if (sync) {
				longAction.waitForCompletion();
			}
			return longAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long branchToExistingProject(Long roid, Long destPoid, String comment, Boolean sync) throws UserException, ServerException {
		requireRealUserAuthentication();
		final DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BranchToExistingProjectDatabaseAction action = new BranchToExistingProjectDatabaseAction(session, getInternalAccessMethod(), getBimServer(), getAuthorization(), roid, destPoid, comment);
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			String username = user.getName();
			String userUsername = user.getUsername();
			LongBranchAction longBranchAction = new LongBranchAction(getBimServer(), username, userUsername, getAuthorization(), action);
			getBimServer().getLongActionManager().start(longBranchAction);
			if (sync) {
				longBranchAction.waitForCompletion();
			}
			return longBranchAction.getProgressTopic().getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			SProject result = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return result;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getProjectByUuid(String uuid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetProjectByUuidDatabaseAction action = new GetProjectByUuidDatabaseAction(session, getInternalAccessMethod(), uuid, getAuthorization());
			SProject result = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			return result;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProjectSmall getProjectSmallByPoid(Long poid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetProjectByPoidDatabaseAction action = new GetProjectByPoidDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			Project project = session.executeAndCommitAction(action);
			User user = session.get(getAuthorization().getUoid(), OldQuery.getDefault());
			return GetAllProjectsSmallDatabaseAction.createSmallProject(getAuthorization(), getBimServer(), project, user);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getProjectsByName(String name) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetProjectsByNameDatabaseAction action = new GetProjectsByNameDatabaseAction(session, getInternalAccessMethod(), name, getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject getTopLevelProjectByName(String name) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetTopLevelProjectByNameDatabaseAction action = new GetTopLevelProjectByNameDatabaseAction(session, getInternalAccessMethod(), name, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Project>> action = new GetSubProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), poid);
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SExtendedData> getAllExtendedDataOfRevision(Long roid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = (Revision) session.get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			if (revision == null) {
				throw new UserException("No revision found with roid " + roid);
			}
			return getBimServer().getSConverter().convertToSListExtendedData(revision.getExtendedData());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SExtendedData> getAllExtendedDataOfRevisionAndSchema(Long roid, Long schemaId) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = (Revision) session.get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			if (revision == null) {
				throw new UserException("No revision found with roid " + roid);
			}
			EList<ExtendedData> list = revision.getExtendedData();
			List<SExtendedData> result = new ArrayList<>();
			for (ExtendedData extendedData : list) {
				if (extendedData.getSchema().getOid() == schemaId) {
					result.add(getBimServer().getSConverter().convertToSObject(extendedData));
				}
			}
			return result;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SExtendedData getLastExtendedDataOfRevisionAndSchema(Long roid, Long schemaId) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = (Revision) session.get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			if (revision == null) {
				throw new UserException("No revision found with roid " + roid);
			}
			EList<ExtendedData> list = revision.getExtendedData();
			ExtendedData last = null;
			for (ExtendedData extendedData : list) {
				if (extendedData.getSchema().getOid() == schemaId) {
					if (last == null || last.getAdded().before(extendedData.getAdded())) {
						last = extendedData;
					}
				}
			}
			if (last != null) {
				return getBimServer().getSConverter().convertToSObject(last);
			}
			return null;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean deleteProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new DeleteProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<SRevision> convertToSListRevision = getBimServer().getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SRevisionComparator(true));
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllProjects(Boolean onlyTopLevel, Boolean onlyActive) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllProjectsDatabaseAction(session, getInternalAccessMethod(), onlyTopLevel, onlyActive, getAuthorization());
			List<SProject> convertToSListProject = getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
			Collections.sort(convertToSListProject, new SProjectComparator());
			return convertToSListProject;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProjectSmall> getAllProjectsSmall() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<SProjectSmall>> action = new GetAllProjectsSmallDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization());
			return action.execute();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SProject addProject(String projectName, String schema) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Project> action = new AddProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), projectName, schema, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public SExtendedDataSchema getExtendedDataSchemaByName(String nameSpace) throws UserException, ServerException {
		// Not checking for real authentication here because a remote service should be
		// able to use an exs
		if (nameSpace == null) {
			throw new UserException("Name required");
		}
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(new GetExtendedDataSchemaByNameDatabaseAction(session, getInternalAccessMethod(), nameSpace)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public ServiceImpl(ServiceMap serviceMap) {
		super(serviceMap);
	}

	@Override
	public Long initiateCheckin(Long poid, Long deserializerOid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();

		ProgressOnProjectTopic progressTopic = getBimServer().getNotificationsManager().createProgressOnProjectTopic(getAuthorization().getUoid(), poid, SProgressTopicType.UPLOAD, "Checkin");
		long topicId = progressTopic.getKey().getId();

		try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
			Project tmpProject = tmpSession.get(poid, OldQuery.getDefault());
			if (tmpProject.getCheckinInProgress() != topicId && tmpProject.getCheckinInProgress() != 0) {
				Thread.sleep(1000);
				throw new UserException("Checkin in progress on this project (topicId: " + tmpProject.getCheckinInProgress() + "), please try again later");
			}
			tmpProject.setCheckinInProgress(topicId);
			tmpSession.store(tmpProject);
			tmpSession.commit();
		} catch (BimserverDatabaseException e) {
			// TODO
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			if (e instanceof UserException) {
				throw (UserException) e;
			}
			e.printStackTrace();
		}

		final DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			Project project = session.get(poid, OldQuery.getDefault());
			if (!getAuthorization().hasRightsOnProjectOrSuperProjects(user, project)) {
				throw new UserException("User has no rights to checkin models to this project");
			}
			if (!MailSystem.isValidEmailAddress(user.getUsername())) {
				throw new UserException("Users must have a valid e-mail address to checkin");
			}
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}

			return progressTopic.getKey().getId();
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			session.close();
		}
	}

	public SLongCheckinActionState checkinInitiatedInternal(Long topicId, final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge, Boolean sync, long newServiceId)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession readOnlySession = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) readOnlySession.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			Project project = readOnlySession.get(poid, OldQuery.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}
			username = user.getName();
			userUsername = user.getUsername();

			Path incomingFile = getIncomingFileName(fileName, null, userUsername);

			// This is where we pass the responsibility for closing the inputStream on
			return checkinInternal(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler.getInputStream(), merge, sync, readOnlySession, username, userUsername, project, incomingFile, newServiceId);
		} catch (UserException e) {
			try {
				clearCheckinInProgress(poid);
			} catch (BimserverDatabaseException | ServiceException e1) {
				LOGGER.error("", e1);
			}
			throw e;
		} catch (Throwable e) {
			try {
				clearCheckinInProgress(poid);
			} catch (BimserverDatabaseException | ServiceException e1) {
				LOGGER.error("", e1);
			}
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			readOnlySession.close();
		}
	}

	public SLongActionState checkinInitiatedInternalSync(Long topicId, final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge, Boolean sync, long newServiceId)
			throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			Project project = session.get(poid, OldQuery.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}
			username = user.getName();
			userUsername = user.getUsername();

			Path incomingFile = getIncomingFileName(fileName, null, userUsername);

			return checkinInternal(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler.getInputStream(), merge, sync, session, username, userUsername, project, incomingFile, newServiceId);
		} catch (UserException e) {
			try {
				clearCheckinInProgress(poid);
			} catch (BimserverDatabaseException | ServiceException e1) {
				LOGGER.error("", e1);
			}
			throw e;
		} catch (Throwable e) {
			try {
				clearCheckinInProgress(poid);
			} catch (BimserverDatabaseException | ServiceException e1) {
				LOGGER.error("", e1);
			}
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			session.close();
		}
	}

	private void clearCheckinInProgress(long poid) throws BimserverDatabaseException, ServiceException {
		try (DatabaseSession tmpSession = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE)) {
			Project project = tmpSession.get(poid, OldQuery.getDefault());
			project.setCheckinInProgress(0);
			tmpSession.store(project);
			tmpSession.commit();
		}
	}

	@Override
	public SLongCheckinActionState checkinInitiatedSync(Long topicId, final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge)
			throws ServerException, UserException {
		return checkinInitiatedInternal(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler, merge, true, -1);
	}

	@Override
	public Long checkinInitiatedAsync(Long topicId, final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge) throws ServerException, UserException {
		SLongActionState checkinInitiatedInternal = checkinInitiatedInternal(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler, merge, false, -1);
		return checkinInitiatedInternal.getTopicId();
	}

	private SLongCheckinActionState checkinInternal(Long topicId, final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, InputStream originalInputStream, Boolean merge, Boolean sync,
			final DatabaseSession readOnlySession, String username, String userUsername, Project project, Path file, long newServiceId)
			throws BimserverDatabaseException, IOException, DeserializeException, CannotBeScheduledException, ServiceException {

		DeserializerPluginConfiguration deserializerPluginConfiguration = readOnlySession.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, OldQuery.getDefault());
		if (deserializerPluginConfiguration == null) {
			throw new UserException("Deserializer with oid " + deserializerOid + " not found");
		} else {
			PluginBundleVersion pluginBundleVersion = deserializerPluginConfiguration.getPluginDescriptor().getPluginBundleVersion();
			Plugin plugin = getBimServer().getPluginManager().getPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
			if (plugin != null) {
				if (plugin instanceof DeserializerPlugin) {
					DeserializerPlugin deserializerPlugin = (DeserializerPlugin) plugin;
					Deserializer deserializer = deserializerPlugin.createDeserializer(getBimServer().getPluginSettingsCache().getPluginSettings(deserializerOid));
					OutputStream outputStream = Files.newOutputStream(file);
					InputStream inputStream = new MultiplexingInputStream(originalInputStream, outputStream);
					deserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData(project.getSchema()));

					IfcModelInterface model = null;
					try {
						model = deserializer.read(inputStream, fileName, fileSize, null);
					} finally {
						inputStream.close();
					}

					CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, fileName, merge, newServiceId, topicId);
					LongCheckinAction longAction = new LongCheckinAction(topicId, getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
					getBimServer().getLongActionManager().start(longAction);
					if (sync) {
						longAction.waitForCompletion();
						clearCheckinInProgress(poid);
					}
					ProgressTopic progressTopic = getBimServer().getNotificationsManager().getProgressTopic(topicId);
					return (SLongCheckinActionState) getBimServer().getSConverter().convertToSObject(progressTopic.getLastProgress());
				} else if (plugin instanceof StreamingDeserializerPlugin) {
					StreamingDeserializerPlugin streaminDeserializerPlugin = (StreamingDeserializerPlugin) plugin;
					StreamingDeserializer streamingDeserializer = streaminDeserializerPlugin.createDeserializer(getBimServer().getPluginSettingsCache().getPluginSettings(deserializerPluginConfiguration.getOid()));
					streamingDeserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData(project.getSchema()));
					RestartableInputStream restartableInputStream = new RestartableInputStream(originalInputStream, file);
					StreamingCheckinDatabaseAction checkinDatabaseAction = new StreamingCheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), comment, fileName, restartableInputStream,
							streamingDeserializer, fileSize, newServiceId, pluginBundleVersion, topicId);
					LongStreamingCheckinAction longAction = new LongStreamingCheckinAction(topicId, getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
					getBimServer().getLongActionManager().start(longAction);
					ProgressTopic progressTopic = null;
					if (sync) {
						longAction.waitForCompletion();
						progressTopic = longAction.getProgressTopic();
						clearCheckinInProgress(poid);
						SLongCheckinActionState convertToSObject = (SLongCheckinActionState) getBimServer().getSConverter().convertToSObject(progressTopic.getLastProgress());
						getBimServer().getLongActionManager().remove(progressTopic.getKey().getId());
						return convertToSObject;
					} else {
						return (SLongCheckinActionState) getBimServer().getSConverter().convertToSObject(longAction.getState());
					}
				} else {
					throw new UserException("No (enabled) (streaming) deserializer found with oid " + deserializerOid);
				}
			} else {
				throw new UserException("No (enabled) (streaming) deserializer found with oid " + deserializerOid);
			}
		}
	}

	@Override
	public SLongCheckinActionState checkinSync(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge) throws ServerException, UserException {
		Long topicId = initiateCheckin(poid, deserializerOid);
		return checkinInitiatedSync(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler, merge);
	}

	@Override
	public Long checkinAsync(final Long poid, final String comment, Long deserializerOid, Long fileSize, String fileName, DataHandler dataHandler, Boolean merge) throws ServerException, UserException {
		Long topicId = initiateCheckin(poid, deserializerOid);
		checkinInitiatedAsync(topicId, poid, comment, deserializerOid, fileSize, fileName, dataHandler, merge);
		return topicId;
	}

	private Path getIncomingFileName(String fileName, String urlString, String userUsername) throws IOException {
		Path homeDirIncoming = getBimServer().getHomeDir().resolve("incoming");
		if (!Files.isDirectory(homeDirIncoming)) {
			Files.createDirectory(homeDirIncoming);
		}

		Path userDirIncoming = homeDirIncoming.resolve(userUsername);
		if (!Files.exists(userDirIncoming)) {
			try {
				Files.createDirectory(userDirIncoming);
			} catch (FileAlreadyExistsException e) {
				// Directory was probably created in the mean time (by checking-in a file as the
				// same user)
			}
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
		if (fileName == null) {
			if (urlString != null) {
				if (urlString.contains("/")) {
					fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
				} else {
					fileName = urlString;
				}
			}
			if (fileName.contains("?")) {
				fileName = fileName.substring(0, fileName.indexOf("?"));
			}
			fileName = URLDecoder.decode(fileName, Charsets.UTF_8.name());
		} else {
			fileName = dateFormat.format(new Date()) + "-" + fileName;
		}

		if (fileName.contains(" ")) {
			fileName = fileName.replace(" ", "_");
		}
		if (fileName.contains("/")) {
			fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
		}
		if (fileName.contains("\\")) {
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
		}

		Path file = userDirIncoming.resolve(fileName);
		return file;
	}

	@Override
	public SLongCheckinActionState checkinFromUrlSync(Long poid, String comment, Long deserializerOid, String fileName, String urlString, Boolean merge) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession readOnlySession = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			Long topicId = initiateCheckin(poid, deserializerOid);

			User user = (User) readOnlySession.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			username = user.getName();
			userUsername = user.getUsername();

			Project project = readOnlySession.get(poid, OldQuery.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}

			URL url = new URL(urlString);
			URLConnection openConnection = url.openConnection();
			InputStream input = openConnection.getInputStream();

			Path incomingFile = getIncomingFileName(fileName, urlString, userUsername);

			return checkinInternal(topicId, poid, comment, deserializerOid, (long) openConnection.getContentLength(), fileName, input, merge, true, readOnlySession, username, userUsername, project, incomingFile, -1);

//			DeserializerPluginConfiguration deserializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, OldQuery.getDefault());
//			if (deserializerPluginConfiguration == null) {
//				throw new UserException("Deserializer with oid " + deserializerOid + " not found");
//			}
//			OutputStream outputStream = Files.newOutputStream(file);
//			InputStream inputStream = new MultiplexingInputStream(input, outputStream);
//			DeserializerPlugin deserializerPlugin = (DeserializerPlugin) getBimServer().getPluginManager().getPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
//			ObjectType settings = deserializerPluginConfiguration.getSettings();
//
//			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration(settings));
//			deserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
//
//			IfcModelInterface model = deserializer.read(inputStream, fileName, 0, null);
//			
//			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, fileName, merge);
//			LongCheckinAction longAction = new LongCheckinAction(-1L, getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
//			getBimServer().getLongActionManager().start(longAction);
//			if (sync) {
//				longAction.waitForCompletion();
//			}
//			return longAction.getProgressTopic().getKey().getId();
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			readOnlySession.close();
		}
	}

	@Override
	public Long checkinFromUrlAsync(Long poid, String comment, Long deserializerOid, String fileName, String urlString, Boolean merge) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		final DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		String username = "Unknown";
		String userUsername = "Unknown";
		try {
			Long topicId = initiateCheckin(poid, deserializerOid);

			User user = (User) session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			username = user.getName();
			userUsername = user.getUsername();
			Path homeDirIncoming = getBimServer().getHomeDir().resolve("incoming");
			if (!Files.isDirectory(homeDirIncoming)) {
				Files.createDirectory(homeDirIncoming);
			}
			Path userDirIncoming = homeDirIncoming.resolve(userUsername);
			if (!Files.exists(userDirIncoming)) {
				Files.createDirectory(userDirIncoming);
			}

			Project project = session.get(poid, OldQuery.getDefault());
			if (project == null) {
				throw new UserException("No project found with poid " + poid);
			}

			URL url = new URL(urlString);
			URLConnection openConnection = url.openConnection();
			InputStream input = openConnection.getInputStream();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
			if (fileName == null) {
				if (urlString.contains("/")) {
					fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
				} else {
					fileName = urlString;
				}
				if (fileName.contains("?")) {
					fileName = fileName.substring(0, fileName.indexOf("?"));
				}
				fileName = URLDecoder.decode(fileName, Charsets.UTF_8.name());
			}

			Path file = userDirIncoming.resolve(fileName);

			if (fileName.contains(" ")) {
				fileName = fileName.replace(" ", "_");
			}

			SLongCheckinActionState checkinInternal = checkinInternal(topicId, poid, comment, deserializerOid, (long) openConnection.getContentLength(), fileName, input, merge, false, session, username, userUsername, project, file, -1);
			return checkinInternal.getTopicId();
//			DeserializerPluginConfiguration deserializerPluginConfiguration = session.get(StorePackage.eINSTANCE.getDeserializerPluginConfiguration(), deserializerOid, OldQuery.getDefault());
//			if (deserializerPluginConfiguration == null) {
//				throw new UserException("Deserializer with oid " + deserializerOid + " not found");
//			}
//			OutputStream outputStream = Files.newOutputStream(file);
//			InputStream inputStream = new MultiplexingInputStream(input, outputStream);
//			DeserializerPlugin deserializerPlugin = (DeserializerPlugin) getBimServer().getPluginManager().getPlugin(deserializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
//			ObjectType settings = deserializerPluginConfiguration.getSettings();
//
//			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration(settings));
//			deserializer.init(getBimServer().getDatabase().getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
//
//			IfcModelInterface model = deserializer.read(inputStream, fileName, 0, null);
//			
//			CheckinDatabaseAction checkinDatabaseAction = new CheckinDatabaseAction(getBimServer(), null, getInternalAccessMethod(), poid, getAuthorization(), model, comment, fileName, merge);
//			LongCheckinAction longAction = new LongCheckinAction(-1L, getBimServer(), username, userUsername, getAuthorization(), checkinDatabaseAction);
//			getBimServer().getLongActionManager().start(longAction);
//			if (sync) {
//				longAction.waitForCompletion();
//			}
//			return longAction.getProgressTopic().getKey().getId();
		} catch (UserException e) {
			throw e;
		} catch (Throwable e) {
			LOGGER.error("", e);
			throw new ServerException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser addUser(String username, String name, SUserType type, Boolean selfRegistration, String resetUrl) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			if (selfRegistration) {
				requireSelfregistrationAllowed();
			} else if (!getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireRealUserAuthentication();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), username, name, getBimServer().getSConverter().convertFromSObject(type), getAuthorization(), selfRegistration,
					resetUrl);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser addUserWithPassword(String username, String password, String name, SUserType type, Boolean selfRegistration, String resetUrl) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			if (selfRegistration) {
				requireSelfregistrationAllowed();
			} else if (!getBimServer().getServerSettingsCache().getServerSettings().getAllowSelfRegistration()) {
				requireRealUserAuthentication();
			}
			BimDatabaseAction<User> action = new AddUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), username, password, name, getBimServer().getSConverter().convertFromSObject(type), getAuthorization(),
					selfRegistration, resetUrl);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean addUserToProject(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new AddUserToProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<org.bimserver.interfaces.objects.SService> getAllServicesOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<org.bimserver.models.store.Service>> action = new GetAllServicesOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<org.bimserver.interfaces.objects.SService> convertToSListRevision = getBimServer().getSConverter().convertToSListService(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SServiceComparator());
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<org.bimserver.interfaces.objects.SNewService> getAllNewServicesOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<NewService>> action = new GetAllNewServicesOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			List<SNewService> convertToSListRevision = getBimServer().getSConverter().convertToSListNewService(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SNewServiceComparator());
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, false);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfProjectDatabaseAction(session, getInternalAccessMethod(), poid, true);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllUsers() throws ServerException, UserException {
		if (getBimServer().getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin()) {
			if (getCurrentUser() == null || getCurrentUser().getUserType() != SUserType.ADMIN) {
				throw new UserException("Admin rights required to list users");
			}
		}
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<User>> action = new GetAllUsersDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			List<SUser> convertToSListUser = getBimServer().getSConverter().convertToSListUser(session.executeAndCommitAction(action));
			Collections.sort(convertToSListUser, new SUserComparator());
			return convertToSListUser;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsByUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SRevision> getAllRevisionsByUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Revision>> action = new GetAllRevisionsByUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			List<SRevision> convertToSListRevision = getBimServer().getSConverter().convertToSListRevision(session.executeAndCommitAction(action));
			Collections.sort(convertToSListRevision, new SRevisionComparator(true));
			return convertToSListRevision;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SCheckout> getAllCheckoutsOfRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<Checkout>> action = new GetAllCheckoutsOfRevisionDatabaseAction(session, getInternalAccessMethod(), roid);
			List<Checkout> list = session.executeAndCommitAction(action);
			Collections.sort(list, new CheckoutComparator());
			return getBimServer().getSConverter().convertToSListCheckout(list);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public void cleanupLongAction(Long topicId) throws UserException, ServerException {
		getBimServer().getLongActionManager().remove(topicId);
	}

	@Override
	public Long downloadCompareResults(Long serializerOid, Long roid1, Long roid2, Long mcid, SCompareType type, Boolean sync) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();

		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			SerializerPluginConfiguration serializer = session.get(serializerOid, OldQuery.getDefault());
			SerializerPlugin plugin = getBimServer().getPluginManager().getSerializerPlugin(serializer.getPluginDescriptor().getPluginClassName());
			if (!(plugin instanceof SerializerPlugin)) {
				throw new UserException("For now, downloadCompareResults can only be used with a non-streaming serializer");
			}
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}

		DownloadParameters downloadParameters = new DownloadParameters(getBimServer(), DownloadType.DOWNLOAD_COMPARE);
		downloadParameters.setModelCompareIdentifier(mcid);
		downloadParameters.setCompareType(getBimServer().getSConverter().convertFromSObject(type));
		downloadParameters.setSerializerOid(serializerOid);
		Set<Long> roids = new LinkedHashSet<>();
		roids.add(roid1);
		roids.add(roid2);
		downloadParameters.setRoids(roids);

		return download(downloadParameters, sync);
	}

	@Override
	public Boolean deleteUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new DeleteUserDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean removeUserFromProject(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new RemoveUserFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), uoid, poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<String> getAvailableClasses() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesDatabaseAction(session, getInternalAccessMethod());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllNonAuthorizedProjectsOfUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllNonAuthorizedProjectsOfUserDatabaseAction(session, getInternalAccessMethod(), uoid);
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUserName(String username) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<User> action = new GetUserByUserNameDatabaseAction(session, getInternalAccessMethod(), username);
			SUser convert = getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
			if (convert == null) {
				throw new UserException("User with username \"" + username + "\" not found");
			}
			return convert;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean undeleteUser(Long uoid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new UndeleteUserDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateProject(SProject sProject) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new UpdateProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sProject);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateRevision(SRevision sRevision) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new UpdateRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sRevision);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SCompareResult compare(Long roid1, Long roid2, SCompareType sCompareType, Long mcid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<CompareResult> action = new CompareDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), -1, roid1, roid2, getBimServer().getSConverter().convertFromSObject(sCompareType),
					mcid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SRevisionSummary getRevisionSummary(Long roid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<RevisionSummary> action = new GetRevisionSummaryDatabaseAction(session, getInternalAccessMethod(), roid);
			RevisionSummary revisionSummary = session.executeAndCommitAction(action);
			return getBimServer().getSConverter().convertToSObject(revisionSummary);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasCheckinRights(Long uoid, Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Boolean> action = new UserHasCheckinRightsDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid, poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckoutWarnings(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckoutWarningsDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Set<String> getCheckinWarnings(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<String>> action = new GetCheckinWarningsDatabaseAction(session, getInternalAccessMethod(), poid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean userHasRights(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Boolean> action = new UserHasRightsDatabaseAction(session, getInternalAccessMethod(), getCurrentUser(session).getOid(), getAuthorization(), poid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public Long getOidByGuid(Long roid, String guid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Long> action = new GetOidByGuidDatabaseAction(session, getInternalAccessMethod(), roid, guid);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SGeoTag getGeoTag(Long goid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<GeoTag> action = new GetGeoTagDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), goid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateGeoTag(SGeoTag sGeoTag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new UpdateGeoTagDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), sGeoTag);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SUser getUserByUoid(Long uoid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetUserByUoidDatabaseAction action = new GetUserByUoidDatabaseAction(session, getInternalAccessMethod(), uoid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public List<SUser> getAllNonAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		if (getBimServer().getServerSettingsCache().getServerSettings().getHideUserListForNonAdmin()) {
			if (getCurrentUser().getUserType() != SUserType.ADMIN) {
				throw new UserException("Admin rights required to list users");
			}
		}
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<User>> action = new GetAllNonAuthorizedUsersOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			return new ArrayList<SUser>(getBimServer().getSConverter().convertToSSetUser((session.executeAndCommitAction(action))));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SUser> getAllAuthorizedUsersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<User>> action = new GetAllAuthorizedUsersOfProjectDatabaseAction(session, getInternalAccessMethod(), poid);
			return new ArrayList<SUser>(getBimServer().getSConverter().convertToSSetUser(session.executeAndCommitAction(action)));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getUsersProjects(Long uoid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetProjectsOfUserDatabaseAction action = new GetProjectsOfUserDatabaseAction(session, getInternalAccessMethod(), getAuthorization(), uoid);
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void setRevisionTag(Long roid, String tag) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<String> action = new SetRevisionTagDatabaseAction(session, getInternalAccessMethod(), roid, tag);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void changeUserType(Long uoid, SUserType userType) throws ServerException, UserException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new ChangeUserTypeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getAuthorization(), uoid, userType);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	private SUser getCurrentUser(DatabaseSession databaseSession) throws UserException, ServerException {
		if (getAuthorization() == null) {
			return null;
		}
		try {
			User user = databaseSession.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(user);
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public void sendCompareEmail(SCompareType sCompareType, Long mcid, Long poid, Long roid1, Long roid2, String address) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			SUser currentUser = getCurrentUser(session);
			Revision revision1 = session.get(StorePackage.eINSTANCE.getRevision(), roid1, OldQuery.getDefault());
			Revision revision2 = session.get(StorePackage.eINSTANCE.getRevision(), roid2, OldQuery.getDefault());
			String senderName = currentUser.getName();
			String senderAddress = currentUser.getUsername();
			if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
				senderAddress = getBimServer().getServerSettingsCache().getServerSettings().getEmailSenderAddress();
			}

			EmailMessage message = getBimServer().getMailSystem().createMessage();

			try {
				InternetAddress addressFrom = new InternetAddress(senderAddress);
				addressFrom.setPersonal(senderName);
				message.setFrom(addressFrom);

				InternetAddress[] addressTo = new InternetAddress[1];
				addressTo[0] = new InternetAddress(address);
				message.setRecipients(Message.RecipientType.TO, addressTo);

				message.setSubject("BIMserver Model Comparator");
				SCompareResult compareResult = compare(roid1, roid2, sCompareType, mcid);
				String html = CompareWriter.writeCompareResult(compareResult, revision1.getId(), revision2.getId(), sCompareType, getServiceMap().getServiceInterface().getProjectByPoid(poid), false);
				message.setContent(html, "text/html");
				message.send();
			} catch (AddressException e) {
				throw new UserException(e);
			} catch (UnsupportedEncodingException e) {
				throw new UserException(e);
			} catch (MessagingException e) {
				throw new UserException(e);
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllReadableProjects() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllReadableProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProject> getAllWritableProjects() throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Set<Project>> action = new GetAllWritableProjectsDatabaseAction(session, getInternalAccessMethod(), getAuthorization());
			return getBimServer().getSConverter().convertToSListProject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			handleException(e);
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public List<String> getAvailableClassesInRevision(Long roid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<List<String>> action = new GetAvailableClassesInRevisionDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid);
			return session.executeAndCommitAction(action);
		} catch (BimserverDatabaseException e) {
			handleException(e);
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Long addExtendedDataSchema(SExtendedDataSchema extendedDataSchema) throws ServerException, UserException {
//		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ExtendedDataSchema create = session.create(ExtendedDataSchema.class);
			ExtendedDataSchema convert = getBimServer().getSConverter().convertFromSObject(extendedDataSchema, create, session);
			return session.executeAndCommitAction(new AddExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addUserToExtendedDataSchema(Long uoid, Long edsid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new AddUserToExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), uoid, edsid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeUserFromExtendedDataSchema(Long uoid, Long edsid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new RemoveUserFromExtendedDataSchemaDatabaseAction(session, getInternalAccessMethod(), uoid, edsid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addExtendedDataToProject(Long poid, SExtendedData extendedData) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ExtendedData convert = getBimServer().getSConverter().convertFromSObject(extendedData, session);
			session.executeAndCommitAction(new AddExtendedDataToProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), poid, convert, getAuthorization()));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SExtendedDataSchema> getAllExtendedDataSchemas() throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			List<SExtendedDataSchema> schemas = getBimServer().getSConverter().convertToSListExtendedDataSchema(session.executeAndCommitAction(new GetAllExtendedDataSchemasDatabaseAction(session, getInternalAccessMethod())));
			Collections.sort(schemas, new Comparator<SExtendedDataSchema>() {
				@Override
				public int compare(SExtendedDataSchema o1, SExtendedDataSchema o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			return schemas;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String getQueryEngineExample(Long qeid, String key) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getQueryEngineById(qeid);
		SPluginDescriptor pluginDescriptor = getServiceMap().getPluginInterface().getPluginDescriptor(queryEngineById.getPluginDescriptorId());
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(pluginDescriptor.getPluginClassName(), true);
		return queryEngine.getExample(key);
	}

	@Override
	public List<String> getQueryEngineExampleKeys(Long qeid) throws ServerException, UserException {
		requireRealUserAuthentication();
		SQueryEnginePluginConfiguration queryEngineById = getQueryEngineById(qeid);
		SPluginDescriptor pluginDescriptor = getServiceMap().getPluginInterface().getPluginDescriptor(queryEngineById.getPluginDescriptorId());
		QueryEnginePlugin queryEngine = getBimServer().getPluginManager().getQueryEngine(pluginDescriptor.getPluginClassName(), true);
		return new ArrayList<String>(queryEngine.getExampleKeys());
	}

	@Override
	public SServiceDescriptor getServiceDescriptor(String baseUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			try (BimServerClientFactory factory = new JsonBimServerClientFactory(baseUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(),
					getBimServer().getMetaDataManager())) {
				try (BimServerClientInterface client = factory.create()) {
					SServiceDescriptor service = client.getRemoteServiceInterface().getService(serviceIdentifier);
					if (service == null) {
						throw new UserException("No service found with identifier " + serviceIdentifier);
					}
					service.setUrl(baseUrl);
					return service;
				}
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SServiceDescriptor> getAllLocalServiceDescriptors() throws ServerException, UserException {
		Map<String, ServiceDescriptor> internalServices = getBimServer().getInternalServicesManager().getInternalServices(getAuthorization().getUoid());
		if (internalServices == null) {
			return new ArrayList<>();
		}
		return sort(getBimServer().getSConverter().convertToSListServiceDescriptor(internalServices.values()));
	}

	@Override
	public List<SServiceDescriptor> getAllServiceDescriptors() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SServiceDescriptor> sServiceDescriptors = new ArrayList<SServiceDescriptor>();
			URL url = new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/services.json");
			String content = NetUtils.getContent(url, 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray services = root.getJSONArray("services");
			for (int i = 0; i < services.length(); i++) {
				JSONObject service = services.getJSONObject(i);
				SServiceDescriptor sServiceDescriptor = new SServiceDescriptor();
				sServiceDescriptor.setName(service.getString("name"));
				sServiceDescriptor.setIdentifier(service.getString("identifier"));
				sServiceDescriptor.setDescription(service.getString("description"));
				sServiceDescriptor.setNotificationProtocol(SAccessMethod.valueOf(service.getString("notificationProtocol")));
				sServiceDescriptor.setTrigger(STrigger.valueOf(service.getString("trigger")));
				sServiceDescriptor.setUrl(service.getString("url"));
				sServiceDescriptor.setCompanyUrl(service.getString("companyUrl"));
				sServiceDescriptor.setTokenUrl(service.getString("tokenUrl"));
				sServiceDescriptor.setNewProfileUrl(service.getString("newProfileUrl"));
				sServiceDescriptor.setProviderName(service.getString("providerName"));
				sServiceDescriptor.setRegisterUrl(service.getString("registerUrl"));
				sServiceDescriptor.setAuthorizeUrl(service.getString("authorizeUrl"));

				JSONObject rights = service.getJSONObject("rights");

				sServiceDescriptor.setReadRevision(rights.has("readRevision") && rights.getBoolean("readRevision"));
				sServiceDescriptor.setReadExtendedData(rights.has("readExtendedData") ? rights.getString("readExtendedData") : null);
				sServiceDescriptor.setWriteRevision(rights.has("writeRevision") && rights.getBoolean("writeRevision"));
				sServiceDescriptor.setWriteExtendedData(rights.has("writeExtendedData") ? rights.getString("writeExtendedData") : null);
				sServiceDescriptors.add(sServiceDescriptor);
			}

			sort(sServiceDescriptors);
			return sServiceDescriptors;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private List<SServiceDescriptor> sort(List<SServiceDescriptor> sServiceDescriptors) {
		ComparatorChain comparatorChain = new ComparatorChain();
		comparatorChain.addComparator(new Comparator<SServiceDescriptor>() {
			@Override
			public int compare(SServiceDescriptor o1, SServiceDescriptor o2) {
				return o1.getProviderName().compareTo(o2.getProviderName());
			}
		});
		comparatorChain.addComparator(new Comparator<SServiceDescriptor>() {
			@Override
			public int compare(SServiceDescriptor o1, SServiceDescriptor o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		Collections.sort(sServiceDescriptors, comparatorChain);
		return sServiceDescriptors;
	}

	@Override
	public List<SExtendedDataSchema> getAllRepositoryExtendedDataSchemas(Boolean usePre) throws ServerException, UserException {
		String content = null;
		if (usePre) {
			try {
				byte[] data = getBimServer().getResourceFetcher().getData("pre/extendeddataschemas.json");
				if (data != null) {
					content = new String(data, Charsets.UTF_8);
				}
			} catch (IOException e) {
			}
		}
		try {
			if (content == null) {
				content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/extendeddataschemas.json"), 5000);
			}
			List<SExtendedDataSchema> extendedDataSchemas = new ArrayList<SExtendedDataSchema>();
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray extendedDataSchemasJson = root.getJSONArray("extendeddataschemas");
			for (int i = 0; i < extendedDataSchemasJson.length(); i++) {
				JSONObject extendedDataSchemaJson = extendedDataSchemasJson.getJSONObject(i);

				SExtendedDataSchema sExtendedDataSchema = new SExtendedDataSchema();
				sExtendedDataSchema.setName(extendedDataSchemaJson.getString("name"));
				sExtendedDataSchema.setContentType(extendedDataSchemaJson.getString("contentType"));
				sExtendedDataSchema.setUrl(extendedDataSchemaJson.getString("url"));
				sExtendedDataSchema.setDescription(extendedDataSchemaJson.getString("description"));

				extendedDataSchemas.add(sExtendedDataSchema);
			}
			return extendedDataSchemas;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SModelCheckerInstance> getAllRepositoryModelCheckers() throws ServerException, UserException {
		requireRealUserAuthentication();
		try {
			List<SModelCheckerInstance> modelCheckers = new ArrayList<SModelCheckerInstance>();
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/modelcheckers"), 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			JSONArray modelCheckersJson = root.getJSONArray("modelcheckers");
			for (int i = 0; i < modelCheckersJson.length(); i++) {
				JSONObject modelCheckerJson = modelCheckersJson.getJSONObject(i);

				SModelCheckerInstance sModelChecker = new SModelCheckerInstance();
				sModelChecker.setName(modelCheckerJson.getString("name"));
				sModelChecker.setCode(modelCheckerJson.getString("code"));
				sModelChecker.setDescription(modelCheckerJson.getString("description"));
				sModelChecker.setModelCheckerPluginClassName(modelCheckerJson.getString("modelCheckerPluginClassName"));

				modelCheckers.add(sModelChecker);
			}
			return modelCheckers;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	public org.bimserver.interfaces.objects.SService getService(Long soid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			org.bimserver.models.store.Service externalProfile = session.get(StorePackage.eINSTANCE.getService(), soid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(externalProfile);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	public org.bimserver.interfaces.objects.SNewService getNewService(Long soid) throws ServerException, UserException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			org.bimserver.models.store.NewService externalProfile = session.get(StorePackage.eINSTANCE.getNewService(), soid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(externalProfile);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addLocalServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService, Long internalServiceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			AddLocalServiceToProjectDatabaseAction action = new AddLocalServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid,
					getBimServer().getSConverter().convertFromSObject(sService, session.create(Service.class), session), internalServiceOid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addServiceToProject(Long poid, org.bimserver.interfaces.objects.SService sService) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			AddServiceToProjectDatabaseAction action = new AddServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid, getBimServer().getSConverter().convertFromSObject(sService, session), getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteService(Long oid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new DeleteServiceDatabaseAction(session, getInternalAccessMethod(), oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProfileDescriptor> getAllPublicProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		try (BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(),
				getBimServer().getMetaDataManager())) {
			try (BimServerClientInterface client = factory.create()) {
				return client.getRemoteServiceInterface().getPublicProfiles(serviceIdentifier);
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllPrivateProfiles(String notificationsUrl, String serviceIdentifier) throws ServerException, UserException {
		if (notificationsUrl == null) {
			throw new UserException("Missing notificationsUrl");
		}
		requireRealUserAuthentication();
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			try (BimServerClientFactory factory = new JsonBimServerClientFactory(notificationsUrl, getBimServer().getServicesMap(), getBimServer().getJsonSocketReflectorFactory(), getBimServer().getReflectorFactory(),
					getBimServer().getMetaDataManager())) {
				BimServerClientInterface client = factory.create();

				OAuthServer oAuthServer = session.querySingle(StorePackage.eINSTANCE.getOAuthServer_ApiUrl(), notificationsUrl);
				User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
				for (OAuthAuthorizationCode oAuthAuthorizationCode : user.getOAuthAuthorizationCodes()) {
					if (oAuthAuthorizationCode.getOauthServer() == oAuthServer) {
						return client.getRemoteServiceInterface().getPrivateProfiles(serviceIdentifier, oAuthAuthorizationCode.getCode());
					}
				}
				return null;
			}
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public List<SProfileDescriptor> getAllLocalProfiles(String serviceIdentifier) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		List<SProfileDescriptor> descriptors = new ArrayList<SProfileDescriptor>();
		try {
			SUser currentUser = getCurrentUser();
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(currentUser.getToken()));
			User user = session.querySingle(condition, User.class, OldQuery.getDefault());
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					if (serviceIdentifier.equals("" + internalServicePluginConfiguration.getOid())) {
						SProfileDescriptor sProfileDescriptor = new SProfileDescriptor();
						descriptors.add(sProfileDescriptor);

						sProfileDescriptor.setIdentifier("" + internalServicePluginConfiguration.getOid());
						sProfileDescriptor.setName(internalServicePluginConfiguration.getName());
						sProfileDescriptor.setDescription(internalServicePluginConfiguration.getDescription());
						sProfileDescriptor.setPublicProfile(false);
					}
				}
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
		return descriptors;
	}

	@Override
	public SExtendedDataSchema getExtendedDataSchemaFromRepository(String namespace) throws UserException, ServerException {
		requireRealUserAuthentication();
		try {
			String content = NetUtils.getContent(new URL(getServiceMap().get(SettingsInterface.class).getServiceRepositoryUrl() + "/extendeddataschemas?namespace=" + namespace), 5000);
			JSONObject root = new JSONObject(new JSONTokener(content));
			SExtendedDataSchema sExtendedDataSchema = new SExtendedDataSchema();
			sExtendedDataSchema.setName(root.getString("name"));
			sExtendedDataSchema.setContentType(root.getString("contentType"));
			sExtendedDataSchema.setUrl(root.getString("url"));
			return sExtendedDataSchema;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SFile getFile(Long fileId) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			org.bimserver.models.store.File file = (org.bimserver.models.store.File) session.get(StorePackage.eINSTANCE.getFile(), fileId, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(file);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SFile getFileMeta(Long fileId) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			org.bimserver.models.store.File file = (org.bimserver.models.store.File) session.get(StorePackage.eINSTANCE.getFile(), fileId, OldQuery.getDefault());
			file.setData(null);
			return getBimServer().getSConverter().convertToSObject(file);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long uploadFile(SFile file) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			File convertFromSObject = getBimServer().getSConverter().convertFromSObject(file, session.create(File.class), session);
			UploadFileDatabaseAction action = new UploadFileDatabaseAction(session, getInternalAccessMethod(), convertFromSObject);
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void triggerNewExtendedData(Long edid, Long soid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ExtendedData extendedData = (ExtendedData) session.get(StorePackage.eINSTANCE.getExtendedData(), edid, OldQuery.getDefault());
			SExtendedDataAddedToRevision newExtendedData = new SExtendedDataAddedToRevision();
			newExtendedData.setRevisionId(extendedData.getRevision().getOid());
			newExtendedData.setExtendedDataId(edid);
			getBimServer().getNotificationsManager().notify(new NewExtendedDataOnRevisionNotification(getBimServer(), edid, extendedData.getRevision().getProject().getOid(), extendedData.getRevision().getOid(), soid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void triggerNewRevision(Long roid, Long soid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = (Revision) session.get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			if (revision == null) {
				throw new UserException("No revision found for roid " + roid);
			}
			getBimServer().getNotificationsManager().notify(new NewRevisionNotification(getBimServer(), revision.getProject().getOid(), revision.getOid(), soid));
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void triggerRevisionService(Long roid, Long soid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = (Revision) session.get(StorePackage.eINSTANCE.getRevision(), roid, OldQuery.getDefault());
			if (revision == null) {
				throw new UserException("No revision found for roid " + roid);
			}
			NewService newService = session.get(StorePackage.eINSTANCE.getNewService(), soid, OldQuery.getDefault());
			if (revision.getServicesLinked().contains(newService)) {
				// We don't want no loops
				return;
			}
			String url = newService.getResourceUrl();
			SerializerPluginConfiguration serializer = newService.getSerializer();

			PackageMetaData pmd = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
			Query query = DefaultQueries.all(pmd);
			Long topicId = download(Collections.singleton(roid), new JsonQueryObjectModelConverter(pmd).toJson(query).toString(), serializer.getOid(), false);

			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(url);

			LongAction<?> longAction = getBimServer().getLongActionManager().getLongAction(topicId);
			if (longAction == null) {
				throw new UserException("No data found for topicId " + topicId);
			}
			SCheckoutResult result;
			if (longAction instanceof LongStreamingDownloadAction) {
				LongStreamingDownloadAction longStreamingDownloadAction = (LongStreamingDownloadAction) longAction;
				if (longStreamingDownloadAction.getErrors().isEmpty()) {
					try {
						result = longStreamingDownloadAction.getCheckoutResult();
					} catch (SerializerException e) {
						throw new UserException(e);
					}
				} else {
					LOGGER.error(longStreamingDownloadAction.getErrors().get(0));
					throw new ServerException(longStreamingDownloadAction.getErrors().get(0));
				}
			} else {
				LongDownloadOrCheckoutAction longDownloadAction = (LongDownloadOrCheckoutAction) longAction;
				try {
					longDownloadAction.waitForCompletion();
					if (longDownloadAction.getErrors().isEmpty()) {
						result = longDownloadAction.getCheckoutResult();
					} else {
						LOGGER.error(longDownloadAction.getErrors().get(0));
						throw new ServerException(longDownloadAction.getErrors().get(0));
					}
				} catch (Exception e) {
					LOGGER.error("", e);
					throw new ServerException(e);
				}
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			LOGGER.info("Starting serialization");

			DataSource datasource = result.getFile().getDataSource();
			if (datasource instanceof ExtendedDataSource) {
				((ExtendedDataSource) datasource).writeToOutputStream(baos, null);
			}

			LOGGER.info("Serialization done");

			if (newService.getAccessToken() != null) {
				httpPost.setHeader("Authorization", "Bearer " + newService.getAccessToken());
			}
			httpPost.setHeader("Input-Type", newService.getInput());
			httpPost.setHeader("Output-Type", newService.getOutput());
			httpPost.setEntity(new ByteArrayEntity(baos.toByteArray()));

			long start = System.nanoTime();

			CloseableHttpResponse response = httpclient.execute(httpPost);

			if (response.getStatusLine().getStatusCode() == 401) {
				throw new UserException("Remote service responded with a 401 Unauthorized");
			} else if (response.getStatusLine().getStatusCode() == 200) {
				Header[] headers = response.getHeaders("Content-Disposition");
				String filename = "unknown";
				if (headers.length > 0) {
					String contentDisposition = headers[0].getValue();
					if (contentDisposition.contains("filename=")) {
						int indexOf = contentDisposition.indexOf("filename=") + 10;
						filename = contentDisposition.substring(indexOf, contentDisposition.indexOf("\"", indexOf + 1));
					} else {
						filename = contentDisposition;
					}
				}
				Header dataTitleHeader = response.getFirstHeader("Data-Title");
				String dataTitle = newService.getName() + " Results";
				if (dataTitleHeader != null) {
					dataTitle = dataTitleHeader.getValue();
				}

				byte[] responseBytes = ByteStreams.toByteArray(response.getEntity().getContent());

				long end = System.nanoTime();

				Action action = newService.getAction();
				if (action instanceof StoreExtendedData) {
					SFile file = new SFile();
					file.setData(responseBytes);
					file.setFilename(filename);
					file.setSize(responseBytes.length);
					file.setMime(response.getHeaders("Content-Type")[0].getValue());
					Long fileId = uploadFile(file);

					SExtendedData extendedData = new SExtendedData();
					extendedData.setAdded(new Date());
					extendedData.setRevisionId(roid);
					extendedData.setTitle(dataTitle);
					extendedData.setSize(responseBytes.length);
					extendedData.setFileId(fileId);
					extendedData.setSchemaId(getExtendedDataSchemaByName(newService.getOutput()).getOid());
					extendedData.setTimeToGenerate((end - start) / 1000000);
					addExtendedDataToRevision(roid, extendedData);
				} else if (action instanceof CheckinRevision) {
					CheckinRevision checkinRevision = (CheckinRevision) action;
					Project targetProject = checkinRevision.getProject();
					String extension = filename.substring(filename.lastIndexOf(".") + 1);
					SDeserializerPluginConfiguration deserializer = getSuggestedDeserializerForExtension(extension, targetProject.getOid());

					Long checkingTopicId = initiateCheckin(targetProject.getOid(), deserializer.getOid());
					checkinInitiatedInternal(checkingTopicId, targetProject.getOid(), dataTitle, deserializer.getOid(), (long) responseBytes.length, filename, new DataHandler(new ByteArrayDataSource(responseBytes, "ifc")), false, true,
							newService.getOid());
				}
			} else {
				throw new UserException("Remote service responded with a " + response.getStatusLine());
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String shareRevision(Long roid) throws UserException, ServerException {
		ExplicitRightsAuthorization authorization = new ExplicitRightsAuthorization(getBimServer(), getCurrentUser().getOid(), -1, new long[] { roid }, -1, -1, -1);
		return authorization.asHexToken(getBimServer().getEncryptionKey());
	}

	@Override
	public SUserSettings getUserSettings() throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			User user = session.get(StorePackage.eINSTANCE.getUser(), getAuthorization().getUoid(), OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(user.getUserSettings());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SProjectSmall> getAllRelatedProjects(Long poid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetAllRelatedProjectsDatabaseAction action = new GetAllRelatedProjectsDatabaseAction(getBimServer(), session, getAuthorization(), getInternalAccessMethod(), poid);
			return action.execute();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SLogAction> getUserRelatedLogs(Long uoid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			List<LogAction> logActions = new ArrayList<LogAction>();
			User user = session.get(getAuthorization().getUoid(), OldQuery.getDefault());
			IfcModelInterface projectsModel = session.getAllOfType(StorePackage.eINSTANCE.getProject(), OldQuery.getDefault());
			logActions.addAll(user.getLogs());
			for (IdEObject idEObject : projectsModel.getValues()) {
				if (idEObject instanceof Project) {
					Project project = (Project) idEObject;
					if ((user.getUserType() == UserType.ADMIN || (project.getState() == ObjectState.ACTIVE) && getAuthorization().hasRightsOnProjectOrSuperProjectsOrSubProjects(user, project))) {
						logActions.addAll(project.getLogs());
					}
				}
			}
			Collections.sort(logActions, new Comparator<LogAction>() {
				@Override
				public int compare(LogAction o1, LogAction o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			});
			return getBimServer().getSConverter().convertToSListLogAction(logActions);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SModelCheckerInstance getModelCheckerInstance(Long mcioid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			GetModelCheckerOidDatabaseAction action = new GetModelCheckerOidDatabaseAction(session, getInternalAccessMethod(), mcioid);
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addModelChecker(SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
		requireAdminAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelCheckerInstance convert = getBimServer().getSConverter().convertFromSObject(modelCheckerInstance, session);
			return session.executeAndCommitAction(new AddModelCheckerDatabaseAction(session, getInternalAccessMethod(), convert));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelCheckerInstance> getAllModelCheckers() throws UserException, ServerException {
		requireAuthenticationAndRunningServer();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return getBimServer().getSConverter().convertToSListModelCheckerInstance(session.executeAndCommitAction(new GetAllModelCheckersDatabaseAction(session, getInternalAccessMethod())));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateModelChecker(SModelCheckerInstance modelCheckerInstance) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new UpdateModelCheckerDatabaseAction(getBimServer(), session, getInternalAccessMethod(), getBimServer().getSConverter().convertFromSObject(modelCheckerInstance, session));
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void validateModelChecker(Long oid) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Void> action = new ValidateModelCheckerDatabaseAction(getBimServer(), session, getInternalAccessMethod(), oid);
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public List<SModelCheckerInstance> getAllModelCheckersOfProject(Long poid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Project project = session.get(poid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSListModelCheckerInstance(project.getModelCheckers());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void addModelCheckerToProject(Long poid, Long modelCheckerOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			ModelCheckerInstance modelChecker = session.get(modelCheckerOid, OldQuery.getDefault());
			AddModelCheckerToProjectDatabaseAction action = new AddModelCheckerToProjectDatabaseAction(session, getInternalAccessMethod(), poid, modelChecker, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeModelCheckerFromProject(Long poid, Long modelCheckerOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new RemoveModelCheckerFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), modelCheckerOid, poid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeServiceFromProject(Long poid, Long serviceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new RemoveServiceFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), serviceOid, poid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void removeNewServiceFromProject(Long poid, Long serviceOid) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			BimDatabaseAction<Boolean> action = new RemoveNewServiceFromProjectDatabaseAction(getBimServer(), session, getInternalAccessMethod(), serviceOid, poid, getAuthorization());
			session.executeAndCommitAction(action);
		} catch (Exception e) {
			handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void importData(String address, String username, String password, String path) {
		new BimServerImporter(getBimServer(), address, username, password, path).start();
	}

	@Override
	public SIfcHeader getIfcHeader(Long croid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<SIfcHeader> action = new GetIfcHeaderDatabaseAction(getBimServer(), session, getInternalAccessMethod(), croid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Double getArea(Long roid, Long oid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Double> action = new GetAreaDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Double getVolume(Long roid, Long oid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Double> action = new GetVolumeDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SGeometryInfo getGeometryInfo(Long roid, Long oid) throws UserException, ServerException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<SGeometryInfo> action = new GetGeometryInfoDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, oid, getAuthorization());
			return session.executeAndCommitAction(action);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long getNrPrimitives(Long roid) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return new GetNrPrimitivesDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roid, getAuthorization()).execute();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long getNrPrimitivesTotal(Set<Long> roids) throws ServerException, UserException {
		requireAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			return new GetNrPrimitivesTotalDatabaseAction(getBimServer(), session, getInternalAccessMethod(), roids, getAuthorization()).execute();
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Long addNewServiceToProject(Long poid, SNewService sService, SAction sAction) throws ServerException, UserException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.POSSIBLY_WRITE);
		try {
			NewService service = (NewService) session.create(StorePackage.eINSTANCE.getNewService());
			getBimServer().getSConverter().convertFromSObject(sService, service, session);

			AddNewServiceToProjectDatabaseAction dbAction = new AddNewServiceToProjectDatabaseAction(session, getInternalAccessMethod(), poid, service, service.getAction(), getAuthorization());
			return session.executeAndCommitAction(dbAction);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public String bcfToJson(Long extendedDataId) throws ServerException, UserException {
		BcfFile bcfFile = BcfCache.INSTANCE.get(extendedDataId);
		if (bcfFile == null) {
			SExtendedData extendedData = getExtendedData(extendedDataId);
			long fileId = extendedData.getFileId();
			SFile file = getFile(fileId);
			try {
				bcfFile = BcfFile.read(new ByteArrayInputStream(file.getData()), new ReadOptions(false));
				BcfCache.INSTANCE.put(extendedDataId, bcfFile);
			} catch (BcfException e) {
				e.printStackTrace();
			}
		}
		return bcfFile.toJson().toString();
	}

	@Override
	public SProject getSubProjectByName(Long parentProjectId, String name) throws UserException, ServerException {
		requireRealUserAuthentication();
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			BimDatabaseAction<Project> action = new GetSubProjectByNameDatabaseAction(session, getInternalAccessMethod(), parentProjectId, name, getAuthorization());
			return getBimServer().getSConverter().convertToSObject(session.executeAndCommitAction(action));
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Boolean checkInternetConnection() {
		try {
			final URL url = new URL("http://www.google.com");
			final URLConnection conn = url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
			return true;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			return false;
		}
	}

	@Override
	public SVector3f getModelMaxBounds(Long roid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = session.get(roid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(revision.getLastConcreteRevision().getBounds().getMax());
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getModelBoundsForConcreteRevision(Long croid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			ConcreteRevision concreteRevision = session.get(croid, OldQuery.getDefault());
			Bounds bounds = concreteRevision.getBounds();

			Vector3f min = bounds.getMin();
			Vector3f max = bounds.getMax();

			if (concreteRevision.getMultiplierToMm() != 1f) {
				min.setX(min.getX() * concreteRevision.getMultiplierToMm());
				min.setY(min.getY() * concreteRevision.getMultiplierToMm());
				min.setZ(min.getZ() * concreteRevision.getMultiplierToMm());
				max.setX(max.getX() * concreteRevision.getMultiplierToMm());
				max.setY(max.getY() * concreteRevision.getMultiplierToMm());
				max.setZ(max.getZ() * concreteRevision.getMultiplierToMm());
			}

			return getBimServer().getSConverter().convertToSObject(bounds);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getModelBounds(Long roid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = session.get(roid, OldQuery.getDefault());
			ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
			Bounds bounds = lastConcreteRevision.getBounds();

			Vector3f min = bounds.getMin();
			Vector3f max = bounds.getMax();

			if (lastConcreteRevision.getMultiplierToMm() != 1f) {
				min.setX(min.getX() * lastConcreteRevision.getMultiplierToMm());
				min.setY(min.getY() * lastConcreteRevision.getMultiplierToMm());
				min.setZ(min.getZ() * lastConcreteRevision.getMultiplierToMm());
				max.setX(max.getX() * lastConcreteRevision.getMultiplierToMm());
				max.setY(max.getY() * lastConcreteRevision.getMultiplierToMm());
				max.setZ(max.getZ() * lastConcreteRevision.getMultiplierToMm());
			}

			return getBimServer().getSConverter().convertToSObject(bounds);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getModelBoundsUntransformed(Long roid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			Revision revision = session.get(roid, OldQuery.getDefault());
			ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
			Bounds bounds = lastConcreteRevision.getBoundsUntransformed();

			Vector3f min = bounds.getMin();
			Vector3f max = bounds.getMax();

			if (lastConcreteRevision.getMultiplierToMm() != 1f) {
				min.setX(min.getX() * lastConcreteRevision.getMultiplierToMm());
				min.setY(min.getY() * lastConcreteRevision.getMultiplierToMm());
				min.setZ(min.getZ() * lastConcreteRevision.getMultiplierToMm());
				max.setX(max.getX() * lastConcreteRevision.getMultiplierToMm());
				max.setY(max.getY() * lastConcreteRevision.getMultiplierToMm());
				max.setZ(max.getZ() * lastConcreteRevision.getMultiplierToMm());
			}

			return getBimServer().getSConverter().convertToSObject(bounds);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getModelBoundsUntransformedForConcreteRevision(Long croid) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			ConcreteRevision concreteRevision = session.get(croid, OldQuery.getDefault());
			Bounds bounds = concreteRevision.getBoundsUntransformed();

			Vector3f min = bounds.getMin();
			Vector3f max = bounds.getMax();

			if (concreteRevision.getMultiplierToMm() != 1f) {
				min.setX(min.getX() * concreteRevision.getMultiplierToMm());
				min.setY(min.getY() * concreteRevision.getMultiplierToMm());
				min.setZ(min.getZ() * concreteRevision.getMultiplierToMm());
				max.setX(max.getX() * concreteRevision.getMultiplierToMm());
				max.setY(max.getY() * concreteRevision.getMultiplierToMm());
				max.setZ(max.getZ() * concreteRevision.getMultiplierToMm());
			}

			return getBimServer().getSConverter().convertToSObject(bounds);
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getTotalBounds(Set<Long> roids) throws ServerException, UserException {
		DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY);
		try {
			double[] totalMin = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };
			double[] totalMax = new double[] { -Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE };
			for (Long roid : roids) {
				Revision revision = session.get(roid, OldQuery.getDefault());
				Bounds bounds = revision.getBoundsMm();

				if (bounds.getMin().getX() == Double.MAX_VALUE || bounds.getMin().getY() == Double.MAX_VALUE || bounds.getMin().getZ() == Double.MAX_VALUE || bounds.getMax().getX() == -Double.MAX_VALUE
						|| bounds.getMax().getY() == -Double.MAX_VALUE || bounds.getMax().getZ() == -Double.MAX_VALUE) {
					// Probably no objects or weird error, let's skip this one
					continue;
				}

				Vector3f min = bounds.getMin();
				Vector3f max = bounds.getMax();

				// TODO multiplying to mm should be an option

//				if (lastConcreteRevision.getMultiplierToMm() != 1f) {
//					min.setX(min.getX() * lastConcreteRevision.getMultiplierToMm());
//					min.setY(min.getY() * lastConcreteRevision.getMultiplierToMm());
//					min.setZ(min.getZ() * lastConcreteRevision.getMultiplierToMm());
//					max.setX(max.getX() * lastConcreteRevision.getMultiplierToMm());
//					max.setY(max.getY() * lastConcreteRevision.getMultiplierToMm());
//					max.setZ(max.getZ() * lastConcreteRevision.getMultiplierToMm());
//				}
				if (min.getX() < totalMin[0]) {
					totalMin[0] = min.getX();
				}
				if (min.getY() < totalMin[1]) {
					totalMin[1] = min.getY();
				}
				if (min.getZ() < totalMin[2]) {
					totalMin[2] = min.getZ();
				}
				if (max.getX() > totalMax[0]) {
					totalMax[0] = max.getX();
				}
				if (max.getY() > totalMax[1]) {
					totalMax[1] = max.getY();
				}
				if (max.getZ() > totalMax[2]) {
					totalMax[2] = max.getZ();
				}
			}
			SBounds sBounds = new SBounds();
			SVector3f sMin = new SVector3f();
			SVector3f sMax = new SVector3f();
			sBounds.setMin(sMin);
			sBounds.setMax(sMax);

			sMin.setX(totalMin[0]);
			sMin.setY(totalMin[1]);
			sMin.setZ(totalMin[2]);

			sMax.setX(totalMax[0]);
			sMax.setY(totalMax[1]);
			sMax.setZ(totalMax[2]);

			return sBounds;
		} catch (Exception e) {
			return handleException(e);
		} finally {
			session.close();
		}
	}

	@Override
	public SBounds getTotalUntransformedBounds(Set<Long> roids) throws ServerException, UserException {
		// TODO duplicate code with getTotalBounds
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			double[] totalMin = new double[] { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };
			double[] totalMax = new double[] { -Double.MAX_VALUE, -Double.MAX_VALUE, -Double.MAX_VALUE };
			for (Long roid : roids) {
				Revision revision = session.get(roid, OldQuery.getDefault());
				Bounds bounds = revision.getBoundsUntransformedMm();
//				ConcreteRevision lastConcreteRevision = revision.getLastConcreteRevision();
//				Bounds bounds = lastConcreteRevision.getBoundsUntransformed();

				if (bounds.getMin().getX() == Double.MAX_VALUE || bounds.getMin().getY() == Double.MAX_VALUE || bounds.getMin().getZ() == Double.MAX_VALUE || bounds.getMax().getX() == -Double.MAX_VALUE
						|| bounds.getMax().getY() == -Double.MAX_VALUE || bounds.getMax().getZ() == -Double.MAX_VALUE) {
					// Probably no objects or weird error, let's skip this one
					continue;
				}

				Vector3f min = bounds.getMin();
				Vector3f max = bounds.getMax();

				// TODO multiplying to mm should be an option

//				if (lastConcreteRevision.getMultiplierToMm() != 1d) {
//					min.setX(min.getX() * lastConcreteRevision.getMultiplierToMm());
//					min.setY(min.getY() * lastConcreteRevision.getMultiplierToMm());
//					min.setZ(min.getZ() * lastConcreteRevision.getMultiplierToMm());
//					max.setX(max.getX() * lastConcreteRevision.getMultiplierToMm());
//					max.setY(max.getY() * lastConcreteRevision.getMultiplierToMm());
//					max.setZ(max.getZ() * lastConcreteRevision.getMultiplierToMm());
//				}

				if (min.getX() < totalMin[0]) {
					totalMin[0] = min.getX();
				}
				if (min.getY() < totalMin[1]) {
					totalMin[1] = min.getY();
				}
				if (min.getZ() < totalMin[2]) {
					totalMin[2] = min.getZ();
				}
				if (max.getX() > totalMax[0]) {
					totalMax[0] = max.getX();
				}
				if (max.getY() > totalMax[1]) {
					totalMax[1] = max.getY();
				}
				if (max.getZ() > totalMax[2]) {
					totalMax[2] = max.getZ();
				}
			}
			SBounds sBounds = new SBounds();
			SVector3f sMin = new SVector3f();
			SVector3f sMax = new SVector3f();
			sBounds.setMin(sMin);
			sBounds.setMax(sMax);

			sMin.setX(totalMin[0]);
			sMin.setY(totalMin[1]);
			sMin.setZ(totalMin[2]);

			sMax.setX(totalMax[0]);
			sMax.setY(totalMax[1]);
			sMax.setZ(totalMax[2]);

			return sBounds;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SVector3f getModelMinBounds(Long roid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			Revision revision = session.get(roid, OldQuery.getDefault());
			return getBimServer().getSConverter().convertToSObject(revision.getLastConcreteRevision().getBounds().getMin());
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public Long regenerateGeometry(Long roid, Long eoid) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase(). createSession(OperationType.POSSIBLY_WRITE)) {
			Revision revision = session.get(roid, OldQuery.getDefault());
			SUser user = getCurrentUser();
			ProgressOnProjectTopic progressTopic = getBimServer().getNotificationsManager().createProgressOnProjectTopic(getAuthorization().getUoid(), revision.getProject().getOid(), SProgressTopicType.UPLOAD, "Regenerate geometry");

			RegenerateGeometryDatabaseAction action = new RegenerateGeometryDatabaseAction(getBimServer(), session, getInternalAccessMethod(), revision.getProject().getOid(), roid, getCurrentUser().getOid(), eoid);
			LongGenericAction longAction = new LongGenericAction(progressTopic.getKey().getId(), getBimServer(), user.getUsername(), user.getName(), getAuthorization(), action);
			getBimServer().getLongActionManager().start(longAction);

			return progressTopic.getKey().getId();
		} catch (Exception e) {
			return handleException(e);
		}
	}

	@Override
	public SDensity getDensityThreshold(Set<Long> roids, Long nrTriangles, Set<String> excludedTypes) throws ServerException, UserException {
		return getBimServer().getGeometryAccellerator().getDensityThreshold(roids, nrTriangles, excludedTypes);
	}

	@Override
	public List<Number> getTileCounts(Set<Long> roids, Set<String> excludedTypes, Set<Long> geometryIdsToReuse, Float minimumThreshold, Float maximumThreshold, Integer maxDepth) throws ServerException, UserException {
		Octree octree = getBimServer().getGeometryAccellerator().getOctree(roids, excludedTypes, geometryIdsToReuse, maxDepth, minimumThreshold, maximumThreshold);

		List<Number> result = new ArrayList<>();
		AtomicInteger totalObjects = new AtomicInteger(0);
		// TODO non-breath-first is probably faster, don't think it matters for the
		// client (ATM)
		octree.breathFirstCounts(minimumThreshold, maximumThreshold, new NodeCounter() {
			@Override
			public void counted(Node node, int count) {
				if (count > 0) {
					result.add(node.getId());
					result.add(count);
					totalObjects.addAndGet(count);
				}
			}
		}, maxDepth);
		return result;
	}

	@Override
	public List<STile> getTiles(Set<Long> roids, Set<String> excludedTypes, Set<Long> geometryIdsToReuse, Float minimumThreshold, Float maximumThreshold, Integer maxDepth) throws ServerException, UserException {
		Octree octree = getBimServer().getGeometryAccellerator().getOctree(roids, excludedTypes, geometryIdsToReuse, maxDepth, minimumThreshold, maximumThreshold);

		List<STile> result = new ArrayList<>();
		// TODO non-breath-first is probably faster, don't think it matters for the
		// client (ATM)
		octree.breathFirstCounts(minimumThreshold, maximumThreshold, new NodeCounter() {
			@Override
			public void counted(Node node, int count) {
				if (count > 0) {
					STile tile = new STile();
					tile.setTileId(node.getId());
					tile.setNrObjects(count);
					tile.setBounds(node.getBounds().toSBounds());
					tile.setMinBounds(node.getMinimumBounds().toSBounds());
					result.add(tile);
				}
			}
		}, maxDepth);
		return result;
	}

	@Override
	public Set<Long> getGeometryDataToReuse(Set<Long> roids, Set<String> excludedTypes, Integer trianglesToSave) {
		return getBimServer().getGeometryAccellerator().getGeometryDataToReuse(roids, excludedTypes, trianglesToSave);
	}

	public List<SBounds> listBoundingBoxes(Set<Long> roids) throws ServerException, UserException {
		try (DatabaseSession session = getBimServer().getDatabase().createSession(OperationType.READ_ONLY)) {
			List<SBounds> results = new ArrayList<>();
			Set<Region> regions = new HashSet<>();
			for (long roid : roids) {
				Revision revision = session.get(roid, OldQuery.getDefault());
				for (ConcreteRevision concreteRevision : revision.getConcreteRevisions()) {
					Bounds bounds = concreteRevision.getBounds();

					if (bounds.getMin().getX() == Double.MAX_VALUE || bounds.getMin().getY() == Double.MAX_VALUE || bounds.getMin().getZ() == Double.MAX_VALUE || bounds.getMax().getX() == -Double.MAX_VALUE
							|| bounds.getMax().getY() == -Double.MAX_VALUE || bounds.getMax().getZ() == -Double.MAX_VALUE) {
						// Probably no objects or weird error, let's skip this one
						continue;
					}

					scaleBounds(bounds, concreteRevision.getMultiplierToMm());
					boolean integrated = false;
					for (Region region : regions) {
						if (region.canAccept(bounds)) {
							region.integrate(bounds);
							integrated = true;
							break;
						}
					}
					if (!integrated) {
						Region region = new Region(bounds);
						regions.add(region);
					}
				}
			}
			for (Region region : regions) {
				results.add(region.toSBounds());
			}
			return results;
		} catch (Exception e) {
			return handleException(e);
		}
	}

	private void scaleBounds(Bounds bounds, float multiplierToMm) {
		bounds.getMin().setX(bounds.getMin().getX() * multiplierToMm);
		bounds.getMin().setY(bounds.getMin().getY() * multiplierToMm);
		bounds.getMin().setZ(bounds.getMin().getZ() * multiplierToMm);
		bounds.getMax().setX(bounds.getMax().getX() * multiplierToMm);
		bounds.getMax().setY(bounds.getMax().getY() * multiplierToMm);
		bounds.getMax().setZ(bounds.getMax().getZ() * multiplierToMm);
	}

	@Override
	public String determineIfcVersion(byte[] head, Boolean usesZip) throws UserException, ServiceException {
		try {
			if (head == null) {
				throw new UserException("head cannot be null");
			}
			StreamingDeserializerPlugin firstDeserializer = getBimServer().getPluginManager().getFirstStreamingDeserializer("ifc", Schema.IFC2X3TC1, true);
			if (firstDeserializer == null) {
				throw new UserException("No deserializer found for ifc, cannot determine schema version");
			}
			if (!(firstDeserializer instanceof IfcSchemaDeterminer)) {
				throw new UserException("Deserializer not capable of determining schema");
			}
			try {
				Schema determineSchema = ((IfcSchemaDeterminer) firstDeserializer).determineSchema(head, usesZip);
				if (determineSchema == null) {
					throw new UserException("No schema detected");
				}
				return determineSchema.name();
			} catch (DeserializeException e) {
				throw new UserException(e.getMessage(), e.getDeserializerErrorCode());
			}
		} catch (PluginException e) {
			throw new UserException(e);
		}
	}
}