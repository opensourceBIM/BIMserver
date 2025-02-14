package org.bimserver.shared.meta;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
	
		Class.forName("org.bimserver.interfaces.objects.SGeometryInfo");
		Class.forName("org.bimserver.interfaces.objects.SVector3f");
		Class.forName("org.bimserver.interfaces.objects.SBounds");
		Class.forName("org.bimserver.interfaces.objects.SBuffer");
		Class.forName("org.bimserver.interfaces.objects.SGeometryData");
		Class.forName("org.bimserver.interfaces.objects.SVector4f");
		Class.forName("org.bimserver.interfaces.objects.SColorPack");
		Class.forName("org.bimserver.interfaces.objects.SAccessMethod");
		Class.forName("org.bimserver.interfaces.objects.SLogAction");
		Class.forName("org.bimserver.interfaces.objects.SServerLog");
		Class.forName("org.bimserver.interfaces.objects.SProjectRelated");
		Class.forName("org.bimserver.interfaces.objects.SCheckoutRelated");
		Class.forName("org.bimserver.interfaces.objects.SRevisionRelated");
		Class.forName("org.bimserver.interfaces.objects.SUserRelated");
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
		Class.forName("org.bimserver.interfaces.objects.SPasswordChanged");
		Class.forName("org.bimserver.interfaces.objects.SUserChanged");
		Class.forName("org.bimserver.interfaces.objects.SExtendedDataAddedToRevision");
		Class.forName("org.bimserver.interfaces.objects.SExtendedDataAddedToProject");
		Class.forName("org.bimserver.interfaces.objects.SRemoteServiceCalled");
		Class.forName("org.bimserver.interfaces.objects.SUserType");
		Class.forName("org.bimserver.interfaces.objects.SSIPrefix");
		Class.forName("org.bimserver.interfaces.objects.SObjectState");
		Class.forName("org.bimserver.interfaces.objects.SProject");
		Class.forName("org.bimserver.interfaces.objects.SUser");
		Class.forName("org.bimserver.interfaces.objects.SRevision");
		Class.forName("org.bimserver.interfaces.objects.SConcreteRevision");
		Class.forName("org.bimserver.interfaces.objects.SGeoTag");
		Class.forName("org.bimserver.interfaces.objects.SCheckout");
		Class.forName("org.bimserver.interfaces.objects.SServerSettings");
		Class.forName("org.bimserver.interfaces.objects.SUserSettings");
		Class.forName("org.bimserver.interfaces.objects.SPluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SSerializerPluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginConfiguration");
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
		Class.forName("org.bimserver.interfaces.objects.SPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryType");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryContainer");
		Class.forName("org.bimserver.interfaces.objects.SRevisionSummary");
		Class.forName("org.bimserver.interfaces.objects.SLongAction");
		Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SCompareType");
		Class.forName("org.bimserver.interfaces.objects.SCompareItem");
		Class.forName("org.bimserver.interfaces.objects.SObjectAdded");
		Class.forName("org.bimserver.interfaces.objects.SObjectRemoved");
		Class.forName("org.bimserver.interfaces.objects.SObjectModified");
		Class.forName("org.bimserver.interfaces.objects.SCompareContainer");
		Class.forName("org.bimserver.interfaces.objects.SCompareResult");
		Class.forName("org.bimserver.interfaces.objects.SActionState");
		Class.forName("org.bimserver.interfaces.objects.SLongActionState");
		Class.forName("org.bimserver.interfaces.objects.SServerState");
		Class.forName("org.bimserver.interfaces.objects.SServerInfo");
		Class.forName("org.bimserver.interfaces.objects.SVersion");
		Class.forName("org.bimserver.interfaces.objects.SFile");
		Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchema");
		Class.forName("org.bimserver.interfaces.objects.SExtendedData");
		Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SWebModulePluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SModelMergerPluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SModelComparePluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.STrigger");
		Class.forName("org.bimserver.interfaces.objects.SProfileDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SServiceDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SService");
		Class.forName("org.bimserver.interfaces.objects.SToken");
		Class.forName("org.bimserver.interfaces.objects.SInternalServicePluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SServiceInterface");
		Class.forName("org.bimserver.interfaces.objects.SServiceMethod");
		Class.forName("org.bimserver.interfaces.objects.SServiceSimpleType");
		Class.forName("org.bimserver.interfaces.objects.SServiceField");
		Class.forName("org.bimserver.interfaces.objects.SServiceType");
		Class.forName("org.bimserver.interfaces.objects.SServiceParameter");
		Class.forName("org.bimserver.interfaces.objects.SPrimitiveEnum");
		Class.forName("org.bimserver.interfaces.objects.STypeDefinition");
		Class.forName("org.bimserver.interfaces.objects.SObjectDefinition");
		Class.forName("org.bimserver.interfaces.objects.SPrimitiveDefinition");
		Class.forName("org.bimserver.interfaces.objects.SArrayDefinition");
		Class.forName("org.bimserver.interfaces.objects.SParameterDefinition");
		Class.forName("org.bimserver.interfaces.objects.SType");
		Class.forName("org.bimserver.interfaces.objects.SObjectType");
		Class.forName("org.bimserver.interfaces.objects.SPrimitiveType");
		Class.forName("org.bimserver.interfaces.objects.SLongType");
		Class.forName("org.bimserver.interfaces.objects.SByteArrayType");
		Class.forName("org.bimserver.interfaces.objects.SDoubleType");
		Class.forName("org.bimserver.interfaces.objects.SStringType");
		Class.forName("org.bimserver.interfaces.objects.SBooleanType");
		Class.forName("org.bimserver.interfaces.objects.SArrayType");
		Class.forName("org.bimserver.interfaces.objects.SParameter");
		Class.forName("org.bimserver.interfaces.objects.SNotifictionResultEnum");
		Class.forName("org.bimserver.interfaces.objects.SImmediateNotificationResult");
		Class.forName("org.bimserver.interfaces.objects.SRemoteServiceUpdate");
		Class.forName("org.bimserver.interfaces.objects.SPercentageChange");
		Class.forName("org.bimserver.interfaces.objects.SSystemInfo");
		Class.forName("org.bimserver.interfaces.objects.SJavaInfo");
		Class.forName("org.bimserver.interfaces.objects.SBimServerInfo");
		Class.forName("org.bimserver.interfaces.objects.SProgressTopicType");
		Class.forName("org.bimserver.interfaces.objects.SProjectSmall");
		Class.forName("org.bimserver.interfaces.objects.SIfcHeader");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultItem");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultHeader");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultType");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultLine");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerResult");
		Class.forName("org.bimserver.interfaces.objects.SModelCheckerInstance");
		Class.forName("org.bimserver.interfaces.objects.SSmtpProtocol");
		Class.forName("org.bimserver.interfaces.objects.SMessagingSerializerPluginConfiguration");
		Class.forName("org.bimserver.interfaces.objects.SMetrics");
		Class.forName("org.bimserver.interfaces.objects.SInterfaceMetric");
		Class.forName("org.bimserver.interfaces.objects.SMethodMetric");
		Class.forName("org.bimserver.interfaces.objects.SPluginBundleVersion");
		Class.forName("org.bimserver.interfaces.objects.SPluginBundleType");
		Class.forName("org.bimserver.interfaces.objects.SPluginType");
		Class.forName("org.bimserver.interfaces.objects.SPluginBundle");
		Class.forName("org.bimserver.interfaces.objects.SPluginInformation");
		Class.forName("org.bimserver.interfaces.objects.SOAuthServer");
		Class.forName("org.bimserver.interfaces.objects.SOAuthAuthorizationCode");
		Class.forName("org.bimserver.interfaces.objects.SAuthorization");
		Class.forName("org.bimserver.interfaces.objects.SSingleProjectAuthorization");
		Class.forName("org.bimserver.interfaces.objects.SNewServiceDescriptor");
		Class.forName("org.bimserver.interfaces.objects.SFormatSerializerMap");
		Class.forName("org.bimserver.interfaces.objects.SAction");
		Class.forName("org.bimserver.interfaces.objects.SStoreExtendedData");
		Class.forName("org.bimserver.interfaces.objects.SCheckinRevision");
		Class.forName("org.bimserver.interfaces.objects.SServiceStatus");
		Class.forName("org.bimserver.interfaces.objects.SNewService");
		Class.forName("org.bimserver.interfaces.objects.SRunServiceAuthorization");
		Class.forName("org.bimserver.interfaces.objects.SDensityCollection");
		Class.forName("org.bimserver.interfaces.objects.SDensity");
		Class.forName("org.bimserver.interfaces.objects.SLongCheckinActionState");
		Class.forName("org.bimserver.interfaces.objects.STile");
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