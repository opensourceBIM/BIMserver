package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

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