package org.bimserver.test.framework.actions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SActionState;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SSerializer;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CheckoutAction extends Action {

	public CheckoutAction(TestFramework testFramework) {
		super(testFramework);
		
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		if (!virtualUser.getCreatedProjects().isEmpty()) {
			SProject project = virtualUser.getRandomProject();
			if (project.getLastRevisionId() != -1) {
				List<SSerializer> allSerializers = virtualUser.getBimServerClient().getServiceInterface().getAllSerializers(true);
				SSerializer serializer = allSerializers.get(nextInt(allSerializers.size()));
				boolean sync = nextBoolean();
				virtualUser.getLogger().info("Checking out revision " + project.getLastRevisionId() + " of project " + project.getName() + " with serializer " + serializer.getName() + " sync: " + sync);
				Integer download = virtualUser.getBimServerClient().getServiceInterface().checkout(project.getLastRevisionId(), serializer.getName(), sync);
				while (virtualUser.getBimServerClient().getServiceInterface().getDownloadState(download).getState() != SActionState.FINISHED) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				virtualUser.getLogger().info("Done preparing checkout, downloading");
				SDownloadResult downloadData = virtualUser.getBimServerClient().getServiceInterface().getDownloadData(download);
				try {
					ByteArrayOutputStream data = new ByteArrayOutputStream();
					IOUtils.copy(downloadData.getFile().getInputStream(), data);
					virtualUser.getLogger().info(data.size() + " bytes downloaded");
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
