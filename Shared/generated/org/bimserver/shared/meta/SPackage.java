package org.bimserver.shared.meta;

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

import java.util.*;
import org.bimserver.shared.meta.SClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SPackage {
	private static final Logger LOGGER = LoggerFactory.getLogger(SPackage.class);

	private static final SPackage sPackage = new SPackage();
	private final Map<String, SClass> sClasses = new HashMap<String, SClass>();

	static {
		getInstance().init();
	}

	private void init() {
			try {
	
		Class.forName("org.bimserver.interfaces.objects.SUserType");
		Class.forName("org.bimserver.interfaces.objects.SSIPrefix");
		Class.forName("org.bimserver.interfaces.objects.SObjectState");
		Class.forName("org.bimserver.interfaces.objects.SProject");
		Class.forName("org.bimserver.interfaces.objects.SUser");
		Class.forName("org.bimserver.interfaces.objects.SClash");
		Class.forName("org.bimserver.interfaces.objects.SEidClash");
		Class.forName("org.bimserver.interfaces.objects.SGuidClash");
		Class.forName("org.bimserver.interfaces.objects.SClashDetectionSettings");
		Class.forName("org.bimserver.interfaces.objects.SRevision");
		Class.forName("org.bimserver.interfaces.objects.SConcreteRevision");
		Class.forName("org.bimserver.interfaces.objects.SGeoTag");
		Class.forName("org.bimserver.interfaces.objects.SCheckout");
		Class.forName("org.bimserver.interfaces.objects.SSettings");
		Class.forName("org.bimserver.interfaces.objects.SSerializer");
		Class.forName("org.bimserver.interfaces.objects.SObjectIDM");
		Class.forName("org.bimserver.interfaces.objects.SMergeIdentifier");
		Class.forName("org.bimserver.interfaces.objects.SIfcEngine");
		Class.forName("org.bimserver.interfaces.objects.SPlugin");
		Class.forName("org.bimserver.interfaces.objects.SDeserializer");
		Class.forName("org.bimserver.interfaces.objects.SCheckinResult");
		Class.forName("org.bimserver.interfaces.objects.SDownloadResult");
		Class.forName("org.bimserver.interfaces.objects.SCheckoutResult");
		Class.forName("org.bimserver.interfaces.objects.SDataValue");
		Class.forName("org.bimserver.interfaces.objects.SDataObject");
		Class.forName("org.bimserver.interfaces.objects.SUserSession");
		Class.forName("org.bimserver.interfaces.objects.SMigration");
		Class.forName("org.bimserver.interfaces.objects.SReferenceDataValue");
		Class.forName("org.bimserver.interfaces.objects.SListDataValue");
		Class.forName("org.bimserver.interfaces.objects.SSimpleDataValue");
		Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationItem");
		Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationCategory");
		Class.forName("org.bimserver.interfaces.objects.SDatabaseInformation");
		Class.forName("org.bimserver.interfaces.objects.SSerializerPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryType");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryContainer");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummary");
		Class.forName("org.bimserver.interfaces.objects.SPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SLongAction");
		Class.forName("org.bimserver.interfaces.objects.SLongCheckinAction");
		Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SCompareIdentifier");
		Class.forName("org.bimserver.interfaces.objects.SCompareType");
		Class.forName("org.bimserver.interfaces.objects.SCompareItem");
		Class.forName("org.bimserver.interfaces.objects.SObjectAdded");
		Class.forName("org.bimserver.interfaces.objects.SObjectRemoved");
		Class.forName("org.bimserver.interfaces.objects.SObjectModified");
		Class.forName("org.bimserver.interfaces.objects.SCompareContainer");
		Class.forName("org.bimserver.interfaces.objects.SCompareResult");
		Class.forName("org.bimserver.interfaces.objects.SActionState");
		Class.forName("org.bimserver.interfaces.objects.SLongActionState");
		Class.forName("org.bimserver.interfaces.objects.SNotification");
		Class.forName("org.bimserver.interfaces.objects.SNewProjectNotification");
		Class.forName("org.bimserver.interfaces.objects.SNewRevisionNotification");
		Class.forName("org.bimserver.interfaces.objects.SCompileResult");
		Class.forName("org.bimserver.interfaces.objects.SRunResult");
		Class.forName("org.bimserver.interfaces.objects.SServerState");
		Class.forName("org.bimserver.interfaces.objects.SServerInfo");
		Class.forName("org.bimserver.interfaces.objects.SVersion");
		Class.forName("org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SCheckinStatus");
		Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchemaType");
		Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchema");
		Class.forName("org.bimserver.interfaces.objects.SExtendedData");
		Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SQueryEngine");
		Class.forName("org.bimserver.interfaces.objects.SAccessMethod");
		Class.forName("org.bimserver.interfaces.objects.SLogAction");
		Class.forName("org.bimserver.interfaces.objects.SServerLog");
		Class.forName("org.bimserver.interfaces.objects.SNewUserAdded");
		Class.forName("org.bimserver.interfaces.objects.SNewProjectAdded");
		Class.forName("org.bimserver.interfaces.objects.SRevisionBranched");
		Class.forName("org.bimserver.interfaces.objects.SNewRevisionAdded");
		Class.forName("org.bimserver.interfaces.objects.SNewCheckoutAdded");
		Class.forName("org.bimserver.interfaces.objects.SSettingsSaved");
		Class.forName("org.bimserver.interfaces.objects.SUserAddedToProject");
		Class.forName("org.bimserver.interfaces.objects.SNewObjectIDMUploaded");
		Class.forName("org.bimserver.interfaces.objects.SDownload");
		Class.forName("org.bimserver.interfaces.objects.SUserRemovedFromProject");
		Class.forName("org.bimserver.interfaces.objects.SProjectDeleted");
		Class.forName("org.bimserver.interfaces.objects.SUserDeleted");
		Class.forName("org.bimserver.interfaces.objects.SPasswordReset");
		Class.forName("org.bimserver.interfaces.objects.SDatabaseCreated");
		Class.forName("org.bimserver.interfaces.objects.SServerStarted");
		Class.forName("org.bimserver.interfaces.objects.SProjectUpdated");
		Class.forName("org.bimserver.interfaces.objects.SUserUndeleted");
		Class.forName("org.bimserver.interfaces.objects.SProjectUndeleted");
		Class.forName("org.bimserver.interfaces.objects.SRevisionUpdated");
		Class.forName("org.bimserver.interfaces.objects.SGeoTagUpdated");
		Class.forName("org.bimserver.interfaces.objects.SClashDetectionSettingsUpdated");
		Class.forName("org.bimserver.interfaces.objects.SPasswordChanged");
		Class.forName("org.bimserver.interfaces.objects.SUserChanged");
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		}
	}

	public static SPackage getInstance() {
		return sPackage;
	}

	public void addSClass(SClass sClass) {
		sClasses.put(sClass.getName(), sClass);
	}

	public SClass getSClass(String name) {
		return sClasses.get(name);
	}
}