package org.bimserver.interfaces;


import org.bimserver.shared.meta.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bimserver.shared.interfaces.PublicInterface;

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


public class SServiceInterfaceService extends org.bimserver.shared.meta.SService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SServiceInterfaceService.class);

	public SServiceInterfaceService(SServicesMap servicesMap, SourceCodeFetcher sourceCodeFetcher, Class<? extends PublicInterface> cl) {
		super(servicesMap, sourceCodeFetcher, cl);
	}
	
		public void init() {
			try {
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SUserType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSIPrefix"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectState"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SProject"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SProject();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SUser"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUser();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRevision"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevision();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SConcreteRevision"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SConcreteRevision();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SGeoTag"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SGeoTag();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCheckout"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCheckout();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServerSettings"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServerSettings();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SUserSettings"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUserSettings();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSerializerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSerializerPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDeserializerPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDownloadResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDownloadResult();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCheckoutResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCheckoutResult();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDataValue();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDataObject"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDataObject();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SUserSession"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SUserSession();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SMigration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SMigration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SReferenceDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SReferenceDataValue();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SListDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SListDataValue();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSimpleDataValue"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSimpleDataValue();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationItem"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformationItem();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDatabaseInformationCategory"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformationCategory();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDatabaseInformation"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDatabaseInformation();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginDescriptor();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummaryType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRevisionSummaryContainer"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummaryContainer();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRevisionSummary"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRevisionSummary();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SLongAction"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongAction();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCompareType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCompareItem"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareItem();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectAdded"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectAdded();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectRemoved"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectRemoved();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectModified"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectModified();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCompareContainer"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareContainer();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCompareResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCompareResult();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SActionState"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SLongActionState"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongActionState();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServerState"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServerInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServerInfo();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SVersion"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SVersion();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SFile"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SFile();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SExtendedDataSchema"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SExtendedDataSchema();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SExtendedData"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SExtendedData();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SWebModulePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SWebModulePluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelMergerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelMergerPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelComparePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelComparePluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.STrigger"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SProfileDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SProfileDescriptor();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceDescriptor();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SService"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SService();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SToken"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SToken();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SInternalServicePluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SInternalServicePluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceInterface"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceInterface();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceMethod"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceMethod();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceSimpleType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceField"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceField();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceParameter"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SServiceParameter();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPrimitiveEnum"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.STypeDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.STypeDefinition();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectDefinition();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPrimitiveDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPrimitiveDefinition();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SArrayDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SArrayDefinition();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SParameterDefinition"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SParameterDefinition();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SObjectType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SObjectType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPrimitiveType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPrimitiveType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SLongType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SByteArrayType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SByteArrayType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDoubleType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDoubleType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SStringType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SStringType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SBooleanType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SBooleanType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SArrayType"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SArrayType();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SParameter"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SParameter();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SNotifictionResultEnum"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SImmediateNotificationResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SImmediateNotificationResult();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRemoteServiceUpdate"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRemoteServiceUpdate();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPercentageChange"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPercentageChange();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSystemInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSystemInfo();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SJavaInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SJavaInfo();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SBimServerInfo"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SBimServerInfo();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SProgressTopicType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SProjectSmall"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SProjectSmall();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SIfcHeader"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SIfcHeader();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultItem"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelCheckerResultItem();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultHeader"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelCheckerResultHeader();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerResultLine"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelCheckerResultLine();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerResult"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelCheckerResult();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SModelCheckerInstance"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SModelCheckerInstance();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSmtpProtocol"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SMessagingSerializerPluginConfiguration"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SMessagingSerializerPluginConfiguration();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SMetrics"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SMetrics();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SInterfaceMetric"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SInterfaceMetric();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SMethodMetric"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SMethodMetric();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginBundleVersion"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginBundleVersion();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginBundleType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginType"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginBundle"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginBundle();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SPluginInformation"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SPluginInformation();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SOAuthServer"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SOAuthServer();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SOAuthAuthorizationCode"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SOAuthAuthorizationCode();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SAuthorization"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SAuthorization();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SSingleProjectAuthorization"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SSingleProjectAuthorization();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SNewServiceDescriptor"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SNewServiceDescriptor();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SFormatSerializerMap"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SFormatSerializerMap();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SAction"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SAction();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SStoreExtendedData"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SStoreExtendedData();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SCheckinRevision"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SCheckinRevision();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SServiceStatus"), null));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SNewService"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SNewService();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SRunServiceAuthorization"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SRunServiceAuthorization();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDensityCollection"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDensityCollection();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SDensity"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SDensity();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.SLongCheckinActionState"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.SLongCheckinActionState();
					}
				}));
				getServicesMap().addType(new SClass(getServicesMap(), Class.forName("org.bimserver.interfaces.objects.STile"), new SConstructor(){
					public Object newInstance() {
						return new org.bimserver.interfaces.objects.STile();
					}
				}));
			super.init();
		} catch (ClassNotFoundException e) {
			LOGGER.error("", e);
		}
	}
}