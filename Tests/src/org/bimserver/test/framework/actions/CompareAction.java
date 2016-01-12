package org.bimserver.test.framework.actions;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
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

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class CompareAction extends Action {

//	private static final boolean VERBOSE = false;
	
	public CompareAction(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
//		SCompareType sCompareType = SCompareType.values()[nextInt(SCompareType.values().length)];
//		SCompareIdentifier sCompareIdentifier = SCompareIdentifier.values()[nextInt(SCompareIdentifier.values().length)];
//		SRevision revision1 = virtualUser.getRandomRevision();
//		SRevision revision2 = virtualUser.getRandomRevision();
//		if (revision1 != null && revision2 != null) {
//			getActionResults().setText("Comparing " + revision1.getId() + " with " + revision2.getId());
//			SCompareResult sCompareResult = virtualUser.getBimServerClient().getServiceInterface().compare(revision1.getOid(), revision2.getOid(), sCompareType, sCompareIdentifier);
//			if (VERBOSE) {
//				for (SCompareContainer sCompareContainer : sCompareResult.getItems()) {
//					virtualUser.getLogger().info(sCompareContainer.getType());
//					for (SCompareItem sCompareItem : sCompareContainer.getItems()) {
//						virtualUser.getLogger().info("\t" + sCompareItem);
//					}
//				}
//			}			
//		}
	}
}