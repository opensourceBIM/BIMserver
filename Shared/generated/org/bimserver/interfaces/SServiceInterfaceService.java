package org.bimserver.interfaces;


import org.bimserver.shared.meta.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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


public class SServiceInterfaceService extends org.bimserver.shared.meta.SService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SServiceInterfaceService.class);

	public SServiceInterfaceService(String sourceCode, Class<?> cl) {
		super(sourceCode, cl);
	}
	
		public void init() {
			try {
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUserType"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSIPrefix"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectState"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SProject"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SProject();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUser"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUser();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevision"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevision();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SConcreteRevision"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SConcreteRevision();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SGeoTag"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SGeoTag();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckout"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCheckout();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServerSettings"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServerSettings();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUserSettings"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUserSettings();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSerializerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSerializerPluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDeserializerPluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDownloadResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDownloadResult();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCheckoutResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCheckoutResult();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDataValue();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDataObject"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDataObject();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SUserSession"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUserSession();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SMigration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SMigration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SReferenceDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SReferenceDataValue();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SListDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SListDataValue();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSimpleDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSimpleDataValue();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationItem"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformationItem();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationCategory"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformationCategory();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDatabaseInformation"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformation();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSerializerPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSerializerPluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDeserializerPluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummaryType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryContainer"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummaryContainer();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRevisionSummary"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummary();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongAction"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongAction();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareType"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareItem"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareItem();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectAdded"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectAdded();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectRemoved"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectRemoved();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectModified"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectModified();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareContainer"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareContainer();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SCompareResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareResult();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SActionState"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongActionState"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongActionState();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServerState"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServerInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServerInfo();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SVersion"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SVersion();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchemaType"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SFile"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SFile();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchema"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SExtendedDataSchema();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SExtendedData"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SExtendedData();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SWebModulePluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SWebModulePluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SWebModulePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SWebModulePluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SModelMergerPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelMergerPluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SModelMergerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelMergerPluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SModelComparePluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelComparePluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SModelComparePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelComparePluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.STrigger"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SProfileDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SProfileDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SService"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SService();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SToken"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SToken();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServicePluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServicePluginDescriptor();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SInternalServicePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SInternalServicePluginConfiguration();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceInterface"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceInterface();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceMethod"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceMethod();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceField"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceField();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SServiceParameter"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceParameter();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPrimitiveEnum"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.STypeDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.STypeDefinition();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectDefinition();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPrimitiveDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPrimitiveDefinition();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SArrayDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SArrayDefinition();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SParameterDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SParameterDefinition();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SObjectType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPrimitiveType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPrimitiveType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SLongType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SByteArrayType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SByteArrayType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SDoubleType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDoubleType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SStringType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SStringType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SBooleanType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SBooleanType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SArrayType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SArrayType();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SParameter"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SParameter();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SNotifictionResultEnum"), null));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SImmediateNotificationResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SImmediateNotificationResult();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SRemoteServiceUpdate"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRemoteServiceUpdate();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SPercentageChange"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPercentageChange();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SSystemInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSystemInfo();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SJavaInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SJavaInfo();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SBimServerInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SBimServerInfo();
					}
				}));
				addType(new SClass(this, Class.forName("org.bimserver.interfaces.objects.SProgressTopicType"), null));
			super.init();
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}