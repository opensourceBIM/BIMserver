package org.bimserver.test.framework.actions;

import java.util.List;

import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class UpdateRevisionAction extends Action {

	public UpdateRevisionAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SProject project = virtualUser.getRandomProject();
		if (project != null) {
			List<Long> revisions = project.getRevisions();
			if (!revisions.isEmpty()) {
				Long revisionId = revisions.get(nextInt(revisions.size()));
				SRevision revision = virtualUser.getBimServerClient().getServiceInterface().getRevision(revisionId);
				revision.setTag(randomString());
				virtualUser.getLogger().info("Updating revision " + revision.getOid());
				virtualUser.getBimServerClient().getServiceInterface().updateRevision(revision);
			}
		}
	}
}
