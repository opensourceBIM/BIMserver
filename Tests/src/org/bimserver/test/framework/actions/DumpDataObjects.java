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

import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.interfaces.objects.SDataValue;
import org.bimserver.interfaces.objects.SListDataValue;
import org.bimserver.interfaces.objects.SReferenceDataValue;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSimpleDataValue;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.test.framework.TestFramework;
import org.bimserver.test.framework.VirtualUser;

public class DumpDataObjects extends Action {

	private boolean verbose = false;
	
	public DumpDataObjects(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SRevision revision = virtualUser.getRandomRevision();
		if (revision != null) {
			List<SDataObject> dataObjects = virtualUser.getBimServerClient().getServiceInterface().getDataObjects(revision.getOid());
			virtualUser.getLogger().info(dataObjects.size() + " dataobjects");
			if (verbose) {
				for (SDataObject dataObject : dataObjects) {
					virtualUser.getLogger().info(dataObject.getType() + " " + dataObject.getOid());
					for (SDataValue dataValue : dataObject.getValues()) {
						dumpValue(virtualUser, dataValue);
					}
				}
			}
		}
	}

	private void dumpValue(VirtualUser virtualUser, SDataValue dataValue) {
		if (dataValue instanceof SSimpleDataValue) {
			SSimpleDataValue simpleDataValue = (SSimpleDataValue) dataValue;
			virtualUser.getLogger().info("\t" + simpleDataValue.getFieldName() + " = " + simpleDataValue.getStringValue());
		} else if (dataValue instanceof SReferenceDataValue) {
			SReferenceDataValue referenceDataValue = (SReferenceDataValue) dataValue;
			virtualUser.getLogger().info("\t" + referenceDataValue.getFieldName() + " = " + referenceDataValue.getOid());
		} else if (dataValue instanceof SListDataValue) {
			SListDataValue listDataValue = (SListDataValue) dataValue;
			for (SDataValue listValue : listDataValue.getValues()) {
				dumpValue(virtualUser, listValue);
			}
		} else {
			virtualUser.getLogger().error("Unknown type: " + dataValue.getClass().getSimpleName());
		}
	}
}