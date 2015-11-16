package org.bimserver.longaction;

import java.util.Set;

import javax.activation.DataHandler;

import org.bimserver.BimServer;
import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.Query;
import org.bimserver.database.queries.QueryObjectProvider;
import org.bimserver.emf.PackageMetaData;
import org.bimserver.interfaces.objects.SCheckoutResult;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.models.store.ActionState;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.MessagingSerializerPluginConfiguration;
import org.bimserver.models.store.PluginConfiguration;
import org.bimserver.models.store.Revision;
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

public class LongStreamingDownloadAction extends LongAction<StreamingDownloadKey>{

	private Long serializerOid;
	private String jsonQuery;
	private Set<Long> roids;
	private StreamingSerializer serializer;
	private MessagingStreamingSerializer createSerializer;

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
				
			} else {
				if (serializerPluginConfiguration instanceof MessagingSerializerPluginConfiguration) {
					MessagingStreamingSerializerPlugin serializerPlugin = getBimServer().getPluginManager().getMessagingStreamingSerializerPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
					createSerializer = serializerPlugin.createSerializer(null);
					
					// TODO passing a databasesession here, make sure it will be closed!!
					ObjectProvider objectProvider = new QueryObjectProvider(databaseSession, getBimServer(), jsonQuery, roids);

					
					createSerializer.init(objectProvider, projectInfo, getBimServer().getPluginManager(), packageMetaData);

					changeActionState(ActionState.STARTED, "Done preparing", -1);
				} else {
					StreamingSerializerPlugin serializerPlugin = getBimServer().getPluginManager().getStreamingSerializerPlugin(serializerPluginConfiguration.getPluginDescriptor().getPluginClassName(), true);
					serializer = serializerPlugin.createSerializer(null);
					
					// TODO passing a databasesession here, make sure it will be closed!!
					ObjectProvider objectProvider = new QueryObjectProvider(databaseSession, getBimServer(), jsonQuery, roids);
					
					serializer.init(objectProvider, projectInfo, null, getBimServer().getPluginManager(), packageMetaData);
					
					changeActionState(ActionState.STARTED, "Done preparing", -1);
				}
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		}
	}

	public SCheckoutResult getCheckoutResult() {
		SCheckoutResult checkoutResult = new SCheckoutResult();
		
		checkoutResult.setFile(new DataHandler(new StreamingSerializerDataSource(serializer, new DoneListener() {
			@Override
			public void done() {
				changeActionState(ActionState.FINISHED, "Done", 100);
			}
		})));
		
		return checkoutResult;
	}

	public Writer getMessagingStreamingSerializer() {
		return createSerializer;
	}
}