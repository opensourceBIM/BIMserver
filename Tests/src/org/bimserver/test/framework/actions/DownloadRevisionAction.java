package org.bimserver.test.framework.actions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class DownloadRevisionAction extends Action {

	private final String serializerName;

	public DownloadRevisionAction(TestFramework testFramework) {
		super(testFramework);
		this.serializerName = null;
	}
	
	public DownloadRevisionAction(TestFramework testFramework, String serializerName) {
		super(testFramework);
		this.serializerName = serializerName;
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException, PublicInterfaceNotFoundException {
		SProject project = virtualUser.getRandomProject();
		if (project != null) {
			if (project.getLastRevisionId() != -1) {
				SSerializerPluginConfiguration serializer = null;
				if (serializerName != null) {
					serializer = virtualUser.getBimServerClient().getBimsie1ServiceInterface().getSerializerByName(serializerName);
				} else {
					List<SSerializerPluginConfiguration> allSerializers = virtualUser.getBimServerClient().getPluginInterface().getAllSerializers(true);
					serializer = allSerializers.get(nextInt(allSerializers.size()));
				}
				boolean sync = nextBoolean();
				virtualUser.getActionResults().setText("Downloading revision " + project.getLastRevisionId() + " of project " + project.getName() + " with serializer " + serializer.getName() + " sync: " + sync);
				SRevision revision = virtualUser.getBimServerClient().getBimsie1ServiceInterface().getRevision(project.getLastRevisionId());
				long topicId = virtualUser.getBimServerClient().getBimsie1ServiceInterface().download(project.getLastRevisionId(), serializer.getOid(), true, sync);
				SActionState state = virtualUser.getBimServerClient().getRegistry().getProgress(topicId).getState();
				while (state != SActionState.FINISHED && state != SActionState.AS_ERROR) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					virtualUser.getLogger().info("SActionState: " + state);
					state = virtualUser.getBimServerClient().getRegistry().getProgress(topicId).getState();
				}
				virtualUser.getLogger().info("Done preparing download, downloading");
				try {
					InputStream downloadData = virtualUser.getBimServerClient().getDownloadData(topicId, serializer.getOid());
					if (downloadData != null) {
						PluginConfiguration pluginConfiguration = new PluginConfiguration(virtualUser.getBimServerClient().getPluginInterface().getPluginSettings(serializer.getOid()));
						String filename = project.getName() + "." + revision.getId() + "." + pluginConfiguration.getString(SerializerPlugin.EXTENSION);
						Path resolve = getTestFramework().getTestConfiguration().getOutputFolder().resolve(filename);
						OutputStream outputStream = Files.newOutputStream(resolve);
						try {
							IOUtils.copy(downloadData, outputStream);
						} finally {
							outputStream.close();
						}
						virtualUser.getLogger().info(filename + " downloaded");
					} else {
						virtualUser.getLogger().warn("Downloaddata = null...");
					}
				} catch (IOException e) {
					virtualUser.getLogger().error("", e);
				}
			}
		}
	}

	@Override
	public int getWeight() {
		return 5;
	}
}