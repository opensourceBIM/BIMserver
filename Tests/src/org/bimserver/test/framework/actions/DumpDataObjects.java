package org.bimserver.test.framework.actions;

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

	public DumpDataObjects(TestFramework testFramework) {
		super(testFramework);
	}

	@Override
	public void execute(VirtualUser virtualUser) throws ServerException, UserException {
		SRevision revision = virtualUser.getRandomRevision();
		List<SDataObject> dataObjects = virtualUser.getBimServerClient().getServiceInterface().getDataObjects(revision.getOid());
		for (SDataObject dataObject : dataObjects) {
			virtualUser.getLogger().info(dataObject.getType() + " " + dataObject.getOid());
			for (SDataValue dataValue : dataObject.getValues()) {
				dumpValue(virtualUser, dataValue);
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