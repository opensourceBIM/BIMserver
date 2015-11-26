package org.bimserver.longaction;

import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import org.bimserver.BimServer;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Revision;
import org.bimserver.plugins.Plugin;
import org.bimserver.plugins.serializers.DoneListener;
import org.bimserver.plugins.serializers.MessagingStreamingSerializer;
import org.bimserver.plugins.serializers.MessagingStreamingSerializerPlugin;
import org.bimserver.plugins.serializers.ObjectProvider;
import org.bimserver.plugins.serializers.ProjectInfo;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.StreamingSerializer;
import org.bimserver.plugins.serializers.StreamingSerializerDataSource;
import org.bimserver.plugins.serializers.StreamingSerializerPlugin;
import org.bimserver.plugins.serializers.Writer;
import org.bimserver.webservices.authorization.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongStreamingDownloadAction extends LongAction<StreamingDownloadKey>{

	private static final Logger LOGGER = LoggerFactory.getLogger(LongStreamingDownloadAction.class);
	private Long serializerOid;
	private String jsonQuery;
	private Set<Long> roids;
	private StreamingSerializer serializer;
	private MessagingStreamingSerializer messagingStreamingSerializer;

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
			
			for (Long roid : roids) {
				Revision revision = databaseSession.get(roid, Query.getDefault());
				ConcreteRevision concreteRevision = revision.getConcreteRevisions().get(0);
				projectInfo.setMinBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMinBounds()));
				projectInfo.setMaxBounds(getBimServer().getSConverter().convertToSObject(concreteRevision.getMaxBounds()));
				projectInfo.setName("" + roids.iterator().next());
				packageMetaData = getBimServer().getMetaDataManager().getPackageMetaData(revision.getProject().getSchema());
				break;
			}
			PluginConfiguration serializerPluginConfiguration = databaseSession.get(serializerOid, Query.getDefault());
			if (serializerPluginConfiguration == null) {
				LOGGER.info("No serializer config found");
			} else {
				Plugin plugin = getBimServer().getPluginManager().getPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
				if (plugin instanceof MessagingStreamingSerializerPlugin) {
					MessagingStreamingSerializerPlugin serializerPlugin = (MessagingStreamingSerializerPlugin)plugin;
					messagingStreamingSerializer = serializerPlugin.createSerializer(null);
					
					// TODO passing a databasesession here, make sure it will be closed!!
					ObjectProvider objectProvider = QueryObjectProvider.fromJsonString(databaseSession, getBimServer(), jsonQuery, roids, packageMetaData);

					messagingStreamingSerializer.init(objectProvider, projectInfo, getBimServer().getPluginManager(), packageMetaData);

					changeActionState(ActionState.STARTED, "Done preparing", -1);
				} else if (plugin instanceof StreamingSerializerPlugin) {
					StreamingSerializerPlugin streamingSerializerPlugin = (StreamingSerializerPlugin)plugin;
					serializer = streamingSerializerPlugin.createSerializer(null);
					
					// TODO passing a databasesession here, make sure it will be closed!!
					ObjectProvider objectProvider = QueryObjectProvider.fromJsonString(databaseSession, getBimServer(), jsonQuery, roids, packageMetaData);
					
					serializer.init(objectProvider, projectInfo, null, getBimServer().getPluginManager(), packageMetaData);
					
					changeActionState(ActionState.STARTED, "Done preparing", -1);
				} else {
					LOGGER.error("Unimplemented " + plugin);
				}
			}
		} catch (Exception e) {
			error(e);
		}
	}

	public SCheckoutResult getCheckoutResult() throws SerializerException {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		if (serializer == null) {
			if (messagingStreamingSerializer == null) {
				throw new SerializerException("No serializer");
			} else {
				DataSource dataSource = new MessagingStreamingDataSource(messagingStreamingSerializer);
				checkoutResult.setFile(new DataHandler(dataSource));
			}
		} else {
			checkoutResult.setFile(new DataHandler(new StreamingSerializerDataSource(serializer, new DoneListener() {
				@Override
				public void done() {
					changeActionState(ActionState.FINISHED, "Done", 100);
				}
			})));
		}
		return checkoutResult;
	}

	public Writer getMessagingStreamingSerializer() {
		return messagingStreamingSerializer;
	}
}