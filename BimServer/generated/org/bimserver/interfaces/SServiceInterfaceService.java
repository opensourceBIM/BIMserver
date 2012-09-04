package org.bimserver.interfaces;


import org.bimserver.shared.meta.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


public class SServiceInterfaceService extends SService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SServiceInterfaceService.class);

	public SServiceInterfaceService(Class<?> cl) {
		super(cl);
	}
	
		public void init() {
			try {
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUserType")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSIPrefix")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectState")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SProject")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUser")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SClash")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SEidClash")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SGuidClash")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SClashDetectionSettings")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevision")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SConcreteRevision")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SGeoTag")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckout")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSettings")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSerializer")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectIDM")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SMergeIdentifier")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SIfcEngine")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPlugin")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDeserializer")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckinResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDownloadResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckoutResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDataValue")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDataObject")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUserSession")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SMigration")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SReferenceDataValue")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SListDataValue")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSimpleDataValue")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationItem")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationCategory")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformation")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSerializerPluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryType")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryContainer")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummary")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongAction")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongCheckinAction")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareIdentifier")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareType")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareItem")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectAdded")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectRemoved")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectModified")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareContainer")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SActionState")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongActionState")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SNotification")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SNewProjectNotification")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SNewRevisionNotification")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompileResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRunResult")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServerState")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServerInfo")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SVersion")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckinStatus")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchemaType")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchema")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedData")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor")));
		addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SQueryEngine")));
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}