package org.bimserver.longaction;

/******************************************************************************
 * Copyright (C) 2009-2018  BIMserver.org
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.BimServer;
import org.bimserver.cache.DownloadDescriptor;
import org.bimserver.cache.NewDiskCacheOutputStream;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.OldQuery;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.database.queries.om.JsonQueryObjectModelConverter;
import org.bimserver.database.queries.om.Query;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.serializers.CacheStoringStreamingSerializerDataSource;
import org.bimserver.plugins.serializers.DoneListener;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializerDataSource;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.plugins.serializers.Writer;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Joiner;

public class LongStreamingDownloadAction extends LongAction<StreamingDownloadKey>{

	private static final Logger LOGGER = LoggerFactory.getLogger(LongStreamingDownloadAction.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private StreamingSerializer serializer;
	private MessagingStreamingSerializer messagingStreamingSerializer;
	private String filename;
	private SCheckoutResult checkoutResult = new SCheckoutResult();
	private DownloadDescriptor downloadDescriptor;

	public LongStreamingDownloadAction(BimServer bimServer, String username, String userUsername, Authorization authorization, Long serializerOid, String jsonQuery, Set<Long> roids) {
		super(bimServer, username, userUsername, authorization);

		checkoutResult.setSerializerOid(serializerOid);
		
		setProgressTopic(bimServer.getNotificationsManager().createProgressTopic(SProgressTopicType.DOWNLOAD, "Download"));
		
		DatabaseSession databaseSession = getBimServer().getDatabase().createSession();
		try {
			PackageMetaData packageMetaData = null;
			ProjectInfo projectInfo = new ProjectInfo();
			
			// TODO projectinfo should contain info for multiple projects/revisions, not just one
			
			List<String> projectNames = new ArrayList<>();
			for (Long roid : roids) {
				Revision revision = databaseSession.get(roid, OldQuery.getDefault());
				ConcreteRevision concreteRevision = revision.getConcreteRevisions().get(0);
				projectInfo.setMinBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMinBounds()));
				projectInfo.setMaxBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMaxBounds()));
				projectInfo.setName("" + roids.iterator().next());
				packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
				projectNames.add(revision.getProject().getName() + "." + revision.getId());
				break;
			}
			
			this.filename = Joiner.on("-").join(projectNames);

			PluginConfiguration serializerPluginConfiguration = databaseSession.get(serializerOid, OldQuery.getDefault());
			org.bimserver.plugins.PluginConfiguration pluginConfiguration = new org.bimserver.plugins.PluginConfiguration(serializerPluginConfiguration.getSettings());
			if (serializerPluginConfiguration == null) {
				LOGGER.info("No serializer config found");
			} else {
				Plugin plugin = getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				
				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
				ObjectNode queryObject = OBJECT_MAPPER.readValue(jsonQuery, ObjectNode.class);
				Query query = converter.parseJson("query", (ObjectNode) queryObject);
				
				downloadDescriptor = new DownloadDescriptor(packageMetaData, jsonQuery, roids, query, serializerOid, this.filename);
				
				if (getBimServer().getNewDiskCacheManager().contains(downloadDescriptor)) {
					DataSource dataSource = getBimServer().getNewDiskCacheManager().get(downloadDescriptor);
					checkoutResult.setFile(new DataHandler(dataSource));
					
					changeActionState(ActionState.STARTED, "Done preparing", -1);
				} else {
					if (query.isDoubleBuffer()) {
						Query newQuery = new Query(packageMetaData);
						QueryPart newQueryPart = newQuery.createQueryPart();
						QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, getBimServer(), query, roids, packageMetaData);
						HashMapVirtualObject next = queryObjectProvider.next();
						while (next != null) {
							newQueryPart.addOid(next.getOid());
							next = queryObjectProvider.next();
						}
						query = newQuery;
					}
					// TODO passing a databasesession here, make sure it will be closed!!
					QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, getBimServer(), query, roids, packageMetaData);
					if (plugin instanceof MessagingStreamingSerializerPlugin) {
						MessagingStreamingSerializerPlugin serializerPlugin = (MessagingStreamingSerializerPlugin)plugin;
						messagingStreamingSerializer = serializerPlugin.createSerializer(pluginConfiguration);
						
						messagingStreamingSerializer.init(queryObjectProvider, projectInfo, getBimServer().getPluginManager(), packageMetaData);
						
						changeActionState(ActionState.STARTED, "Done preparing", -1);
					} else if (plugin instanceof StreamingSerializerPlugin) {
						StreamingSerializerPlugin streamingSerializerPlugin = (StreamingSerializerPlugin)plugin;
						serializer = streamingSerializerPlugin.createSerializer(pluginConfiguration);
						
						serializer.init(queryObjectProvider, projectInfo, null, getBimServer().getPluginManager(), packageMetaData);
						
						changeActionState(ActionState.STARTED, "Done preparing", -1);
					} else {
						LOGGER.error("Unimplemented " + plugin);
					}
				}
			}
		} catch (Throwable e) {
			LOGGER.error("", e);
			error(e);
		}
	}

	@Override
	public String getDescription() {
		return "Streaming download";
	}

	@Override
	public void execute() {

	}

	public SCheckoutResult getCheckoutResult() throws SerializerException {
		if (checkoutResult.getFile() != null) {
			// already populated by cached file
			return checkoutResult;
		}
		if (serializer == null) {
			if (messagingStreamingSerializer == null) {
				throw new SerializerException("No serializer");
			} else {
				DataSource dataSource = new MessagingStreamingDataSource(messagingStreamingSerializer);
				checkoutResult.setFile(new DataHandler(dataSource));
			}
		} else {
			if (getBimServer().getNewDiskCacheManager().isEnabled()) {
				NewDiskCacheOutputStream diskCacheOutputStream = getBimServer().getNewDiskCacheManager().startCaching(downloadDescriptor);
				CacheStoringStreamingSerializerDataSource cacheStoringEmfSerializerDataSource = new CacheStoringStreamingSerializerDataSource(serializer, diskCacheOutputStream, new DoneListener() {
					@Override
					public void done() {
						changeActionState(ActionState.FINISHED, "Done", 100);
					}
				}); 
				checkoutResult.setFile(new DataHandler(cacheStoringEmfSerializerDataSource));
			} else {
				StreamingSerializerDataSource streamingSerializerDataSource = new StreamingSerializerDataSource(filename, serializer, new DoneListener() {
					@Override
					public void done() {
						changeActionState(ActionState.FINISHED, "Done", 100);
					}
				});
				checkoutResult.setFile(new DataHandler(streamingSerializerDataSource));
			}
		}
		return checkoutResult;
	}

	public Writer getMessagingStreamingSerializer() {
		return messagingStreamingSerializer;
	}
}