package org.bimserver.longaction;

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
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class LongStreamingDownloadAction extends LongAction<StreamingDownloadKey>{

	private static final Logger LOGGER = LoggerFactory.getLogger(LongStreamingDownloadAction.class);
	private Long serializerOid;
	private String jsonQuery;
	private Set<Long> roids;
	private StreamingSerializer serializer;
	private MessagingStreamingSerializer messagingStreamingSerializer;
	private String filename;
	private SCheckoutResult checkoutResult = new SCheckoutResult();
	private DownloadDescriptor downloadDescriptor;

	public LongStreamingDownloadAction(BimServer bimServer, String username, String userUsername, Authorization authorization, Long serializerOid, String jsonQuery, Set<Long> roids) {
		super(bimServer, username, userUsername, authorization);
		this.serializerOid = serializerOid;
		this.jsonQuery = jsonQuery;
		this.roids = roids;
		
		setProgressTopic(bimServer.getNotificationsManager().createProgressTopic(SProgressTopicType.DOWNLOAD, "Download"));
	}

	@Override
	public String getDescription() {
		return "description";
	}

	@Override
	public void execute() {
		DatabaseSession databaseSession = getBimServer().getDatabase().createSession();
		try {
			PackageMetaData packageMetaData = null;
			ProjectInfo projectInfo = new ProjectInfo();
			
			// TODO projectinfo should contain info for multiple projects/revisions, not just one
			
			StringBuilder filename = new StringBuilder();
			for (Long roid : roids) {
				Revision revision = databaseSession.get(roid, OldQuery.getDefault());
				ConcreteRevision concreteRevision = revision.getConcreteRevisions().get(0);
				projectInfo.setMinBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMinBounds()));
				projectInfo.setMaxBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMaxBounds()));
				projectInfo.setName("" + roids.iterator().next());
				packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
				filename.append(revision.getProject().getName());
				break;
			}
			
			this.filename = filename.toString();

			PluginConfiguration serializerPluginConfiguration = databaseSession.get(serializerOid, OldQuery.getDefault());
			if (serializerPluginConfiguration == null) {
				LOGGER.info("No serializer config found");
			} else {
				Plugin plugin = getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				
				JsonQueryObjectModelConverter converter = new JsonQueryObjectModelConverter(packageMetaData);
				ObjectNode queryObject = new ObjectMapper().readValue(jsonQuery, ObjectNode.class);
				Query query = converter.parseJson("query", (ObjectNode) queryObject);
				
				downloadDescriptor = new DownloadDescriptor(roids, query, serializerOid, this.filename);
				
				if (getBimServer().getNewDiskCacheManager().contains(downloadDescriptor)) {
					DataSource dataSource = getBimServer().getNewDiskCacheManager().get(downloadDescriptor);
					checkoutResult.setFile(new DataHandler(dataSource));
					
					changeActionState(ActionState.STARTED, "Done preparing", -1);
				} else {
					// TODO passing a databasesession here, make sure it will be closed!!
					QueryObjectProvider queryObjectProvider = new QueryObjectProvider(databaseSession, getBimServer(), query, roids, packageMetaData);
					if (plugin instanceof MessagingStreamingSerializerPlugin) {
						MessagingStreamingSerializerPlugin serializerPlugin = (MessagingStreamingSerializerPlugin)plugin;
						messagingStreamingSerializer = serializerPlugin.createSerializer(null);
						
						messagingStreamingSerializer.init(queryObjectProvider, projectInfo, getBimServer().getPluginManager(), packageMetaData);
						
						changeActionState(ActionState.STARTED, "Done preparing", -1);
					} else if (plugin instanceof StreamingSerializerPlugin) {
						StreamingSerializerPlugin streamingSerializerPlugin = (StreamingSerializerPlugin)plugin;
						serializer = streamingSerializerPlugin.createSerializer(null);
						
						serializer.init(queryObjectProvider, projectInfo, null, getBimServer().getPluginManager(), packageMetaData);
						
						changeActionState(ActionState.STARTED, "Done preparing", -1);
					} else {
						LOGGER.error("Unimplemented " + plugin);
					}
				}
			}
		} catch (Exception e) {
			error(e);
		}
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