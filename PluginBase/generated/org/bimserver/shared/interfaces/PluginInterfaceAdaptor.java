package org.bimserver.shared.interfaces;

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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class PluginInterfaceAdaptor implements org.bimserver.shared.interfaces.PluginInterface {

	public java.lang.Long addDeserializer(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addInternalService(org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addModelCompare(org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addModelMerger(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addQueryEngine(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addRenderEngine(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Long addSerializer(org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer) throws UserException, ServerException {
		return null;
	}
	
	public void clearMavenCache() throws UserException, ServerException {
	}
	
	public void deleteDeserializer(java.lang.Long sid) throws UserException, ServerException {
	}
	
	public void deleteInternalService(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void deleteModelChecker(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteModelCompare(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteModelMerger(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deletePluginConfiguration(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void deleteQueryEngine(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteRenderEngine(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteSerializer(java.lang.Long sid) throws UserException, ServerException {
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllDeserializerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginConfiguration> getAllDeserializers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginConfiguration> getAllDeserializersForProject(java.lang.Boolean onlyEnabled, java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SInternalServicePluginConfiguration> getAllInternalServices(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SInternalServicePluginConfiguration> getAllInternalServicesOfService(java.lang.String name, java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllModelCheckerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllModelComparePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelComparePluginConfiguration> getAllModelCompares(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllModelMergerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginConfiguration> getAllModelMergers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllQueryEnginePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration> getAllQueryEngines(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllRenderEnginePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration> getAllRenderEngines(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> getAllSerializers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> getAllSerializersForPoids(java.lang.Boolean onlyEnabled, java.util.Set<java.lang.Long> poids) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> getAllSerializersForRoids(java.lang.Boolean onlyEnabled, java.util.Set<java.lang.Long> roids) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllServicePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllWebModulePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SWebModulePluginConfiguration> getAllWebModules(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginBundle> getAvailablePluginBundles() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelComparePluginConfiguration getDefaultModelCompare() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelMergerPluginConfiguration getDefaultModelMerger() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getDefaultQueryEngine() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getDefaultRenderEngine() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginDescriptor getDefaultRenderEnginePluginDescriptor() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getDefaultSerializer() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SWebModulePluginConfiguration getDefaultWebModule() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginBundleVersion getInstalledPluginBundle(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginBundle> getInstalledPluginBundles() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SInternalServicePluginConfiguration getInternalServiceById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelComparePluginConfiguration getModelCompareById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelComparePluginConfiguration getModelCompareByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelMergerPluginConfiguration getModelMergerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelMergerPluginConfiguration getModelMergerByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginBundle getPluginBundle(java.lang.String repository, java.lang.String groupId, java.lang.String artifactId) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginBundleVersion getPluginBundleVersionById(java.lang.Long pbid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginDescriptor getPluginDescriptor(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SPluginDescriptor getPluginDescriptorByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginInformation> getPluginInformation(java.lang.String repository, java.lang.String groupId, java.lang.String artifactId, java.lang.String version) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectDefinition getPluginObjectDefinition(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectType getPluginSettings(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectDefinition getPluginSystemObjectDefinition(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectType getPluginSystemSettings(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getRenderEngineById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getRenderEngineByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByPluginClassName(java.lang.String pluginClassName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SWebModulePluginConfiguration getWebModuleById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SWebModulePluginConfiguration getWebModuleByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean hasActiveSerializer(java.lang.String contentType) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean hasPreBuiltPlugins() throws UserException, ServerException {
		return null;
	}
	
	public void installPluginBundle(java.lang.String repository, java.lang.String groupId, java.lang.String artifactId, java.lang.String version, java.util.List<org.bimserver.interfaces.objects.SPluginInformation> plugins) throws UserException, ServerException {
	}
	
	public void installPluginBundleFromFile(javax.activation.DataHandler data, java.lang.Boolean installAllPluginsForAllUsers, java.lang.Boolean installAllPluginsForNewUsers) throws UserException, ServerException {
	}
	
	public void installPluginBundleFromUrl(java.lang.String url, java.lang.Boolean installAllPluginsForAllUsers, java.lang.Boolean installAllPluginsForNewUsers) throws UserException, ServerException {
	}
	
	public void installPreBuiltPlugins(java.util.List<java.lang.String> artifacts) throws UserException, ServerException {
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SWebModulePluginConfiguration> listAllWebModules() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> listPluginsInBundle(java.lang.Long pluginBundleVersionOid) throws UserException, ServerException {
		return null;
	}
	
	public void setDefaultModelCompare(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultModelMerger(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultQueryEngine(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultRenderEngine(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultSerializer(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultWebModule(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setPluginSettings(java.lang.Long poid, org.bimserver.interfaces.objects.SObjectType settings) throws UserException, ServerException {
	}
	
	public void setPluginSystemSettings(java.lang.Long poid, org.bimserver.interfaces.objects.SObjectType settings) throws UserException, ServerException {
	}
	
	public void uninstallPluginBundle(java.lang.String repository, java.lang.String groupId, java.lang.String artifactId, java.lang.String version) throws UserException, ServerException {
	}
	
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer) throws UserException, ServerException {
	}
	
	public void updateInternalService(org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService) throws UserException, ServerException {
	}
	
	public void updateModelCompare(org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare) throws UserException, ServerException {
	}
	
	public void updateModelMerger(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger) throws UserException, ServerException {
	}
	
	public void updatePluginBundle(java.lang.String repository, java.lang.String groupId, java.lang.String artifactId, java.lang.String version) throws UserException, ServerException {
	}
	
	public void updateQueryEngine(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine) throws UserException, ServerException {
	}
	
	public void updateRenderEngine(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine) throws UserException, ServerException {
	}
	
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer) throws UserException, ServerException {
	}
	
}