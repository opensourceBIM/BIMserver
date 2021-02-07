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

import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlMimeType;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SPluginBundle;
import org.bimserver.interfaces.objects.SPluginBundleVersion;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SPluginInformation;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SWebModulePluginConfiguration;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

@WebService(name = "PluginInterface", targetNamespace="org.bimserver")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface PluginInterface extends PublicInterface {
	@WebMethod(action="getDefaultWebModule")
	SWebModulePluginConfiguration getDefaultWebModule() throws ServerException, UserException;

	@WebMethod(action="getDefaultRenderEngine")
	SRenderEnginePluginConfiguration getDefaultRenderEngine() throws ServerException, UserException;

	@WebMethod(action="getDefaultQueryEngine")
	SQueryEnginePluginConfiguration getDefaultQueryEngine() throws ServerException, UserException;

	@WebMethod(action="getDefaultModelCompare")
	SModelComparePluginConfiguration getDefaultModelCompare() throws ServerException, UserException;

	@WebMethod(action="getDefaultModelMerger")
	SModelMergerPluginConfiguration getDefaultModelMerger() throws ServerException, UserException;

	@WebMethod(action="getDefaultSerializer")
	SSerializerPluginConfiguration getDefaultSerializer() throws ServerException, UserException;

	@WebMethod(action="setDefaultRenderEngine")
	void setDefaultRenderEngine(
		@WebParam(name = "oid", partName = "setDefaultRenderEngine.oid") Long oid) throws UserException, ServerException;

	/**
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializersForRoids")
	List<SSerializerPluginConfiguration> getAllSerializersForRoids(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializersForRoids.onlyEnabled") Boolean onlyEnabled,
		@WebParam(name = "roids", partName = "getAllSerializersForRoids.roids") Set<Long> roids) throws ServerException, UserException;

	@WebMethod(action = "getAllSerializersForPoids")
	List<SSerializerPluginConfiguration> getAllSerializersForPoids(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializersForPoids.onlyEnabled") Boolean onlyEnabled, 
		@WebParam(name = "poids", partName = "getAllSerializersForPoids.poids") Set<Long> poids) throws ServerException, UserException;
	
	@WebMethod(action="setDefaultWebModule")
	void setDefaultWebModule(
			@WebParam(name = "oid", partName = "setDefaultWebModule.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultQueryEngine")
	void setDefaultQueryEngine(
		@WebParam(name = "oid", partName = "setDefaultQueryEngine.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultModelCompare")
	void setDefaultModelCompare(
		@WebParam(name = "oid", partName = "setDefaultModelCompare.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultModelMerger")
	void setDefaultModelMerger(
		@WebParam(name = "oid", partName = "setDefaultModelMerger.oid") Long oid) throws UserException, ServerException;

	@WebMethod(action="setDefaultSerializer")
	void setDefaultSerializer(
		@WebParam(name = "oid", partName = "setDefaultSerializer.oid") Long oid) throws UserException, ServerException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializerPluginDescriptors")
	List<SPluginDescriptor> getAllSerializerPluginDescriptors() throws ServerException, UserException;

	@WebMethod(action = "getPluginDescriptor")
	SPluginDescriptor getPluginDescriptor(
		@WebParam(name = "oid", partName = "getPluginDescriptor.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action = "getPluginDescriptorByName")
	SPluginDescriptor getPluginDescriptorByName(
		@WebParam(name = "name", partName = "getPluginDescriptorByName.name") String name) throws ServerException, UserException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWebModulePluginDescriptors")
	List<SPluginDescriptor> getAllWebModulePluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRenderEnginePluginDescriptors")
	List<SPluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return Return the default render engine plugin descriptor, this is the one used to set as the default render engine for new users
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDefaultRenderEnginePluginDescriptor")
	SPluginDescriptor getDefaultRenderEnginePluginDescriptor() throws ServerException, UserException;

	/**
	 * @return List of all DeserializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializerPluginDescriptors")
	List<SPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all QueryEnginePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllQueryEnginePluginDescriptors")
	List<SPluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all getAllServicePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllServicePluginDescriptors")
	List<SPluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @return List of all SModelComparePluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelComparePluginDescriptors")
	List<SPluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SModelComparePluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelCheckerPluginDescriptors")
	List<SPluginDescriptor> getAllModelCheckerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SModelMergerPluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelMergerPluginDescriptors")
	List<SPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @param name Name of the WebModule
	 * @return WebModule
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getWebModuleByName")
	SWebModulePluginConfiguration getWebModuleByName(
		@WebParam(name = "name", partName = "getWebModuleByName.name") String name) throws ServerException, UserException;

	@WebMethod(action = "listAllWebModules")
	List<SWebModulePluginConfiguration> listAllWebModules() throws ServerException, UserException;
	
	/**
	 * @param name Name of the RenderEngine
	 * @return RenderEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRenderEngineByName")
	SRenderEnginePluginConfiguration getRenderEngineByName(
		@WebParam(name = "name", partName = "getRenderEngineByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name Name of the ModelMerger
	 * @return SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelMergerByName")
	SModelMergerPluginConfiguration getModelMergerByName(
		@WebParam(name = "name", partName = "getModelMergerByName.name") String name) throws ServerException, UserException;

	/**
	 * @param name Name of the ModelCompare
	 * @return SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelCompareByName")
	SModelComparePluginConfiguration getModelCompareByName(
		@WebParam(name = "name", partName = "getModelCompareByName.name") String name) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializers")
	List<SSerializerPluginConfiguration> getAllSerializers(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled IFC engines
	 * @return A list of RenderEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRenderEngines")
	List<SRenderEnginePluginConfiguration> getAllRenderEngines(
		@WebParam(name = "onlyEnabled", partName = "getAllRenderEngines.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled IFC engines
	 * @return A list of RenderEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWebModules")
	List<SWebModulePluginConfiguration> getAllWebModules(
		@WebParam(name = "onlyEnabled", partName = "getAllWebModules.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled query engines
	 * @return A list of QueryEngines
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllQueryEngines")
	List<SQueryEnginePluginConfiguration> getAllQueryEngines(
		@WebParam(name = "onlyEnabled", partName = "getAllQueryEngines.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled model mergers
	 * @return A list of SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelMergers")
	List<SModelMergerPluginConfiguration> getAllModelMergers(
		@WebParam(name = "onlyEnabled", partName = "getAllModelMergers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled model compare
	 * @return A list of SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelCompares")
	List<SModelComparePluginConfiguration> getAllModelCompares(
		@WebParam(name = "onlyEnabled", partName = "getAllModelCompares.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the RenderEngine
	 * @return RenderEngine
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getRenderEngineById")
	SRenderEnginePluginConfiguration getRenderEngineById(
		@WebParam(name = "oid", partName = "getRenderEngineById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ModelMerger
	 * @return SModelMerger
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelMergerById")
	SModelMergerPluginConfiguration getModelMergerById(
		@WebParam(name = "oid", partName = "getModelMergerById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the ModelCompare
	 * @return SModelCompare
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getModelCompareById")
	SModelComparePluginConfiguration getModelCompareById(
		@WebParam(name = "oid", partName = "getModelCompareById.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the Deserializer
	 * @return Deserializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getWebModuleById")
	SWebModulePluginConfiguration getWebModuleById(
		@WebParam(name = "oid", partName = "getWebModuleById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param serializer Serializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addSerializer")
	Long addSerializer(
		@WebParam(name = "serializer", partName = "addSerializer.serializer") SSerializerPluginConfiguration serializer) throws ServerException, UserException;

	/**
	 * @param renderEngine RenderEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addRenderEngine")
	Long addRenderEngine(
		@WebParam(name = "renderEngine", partName = "addRenderEngine.renderEngine") SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException;

	/**
	 * @param queryEngine QueryEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addQueryEngine")
	Long addQueryEngine(
		@WebParam(name = "queryEngine", partName = "addQueryEngine.queryEngine") SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException;

	/**
	 * @param modelMerger ModelMerger to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelMerger")
	Long addModelMerger(
		@WebParam(name = "modelMerger", partName = "addModelMerger.modelMerger") SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException;

	/**
	 * @param modelCompare ModelCompare to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelCompare")
	Long addModelCompare(
		@WebParam(name = "modelCompare", partName = "addModelCompare.modelCompare") SModelComparePluginConfiguration modelCompare) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDeserializer")
	Long addDeserializer(
		@WebParam(name = "deserializer", partName = "addDeserializer.deserializer") SDeserializerPluginConfiguration deserializer) throws ServerException, UserException;

	/**
	 * @param serializer Serializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateSerializer")
	void updateSerializer(
		@WebParam(name = "serializer", partName = "updateSerializer.serializer") SSerializerPluginConfiguration serializer) throws ServerException, UserException;

	/**
	 * @param renderEngine RenderEngine to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateRenderEngine")
	void updateRenderEngine(
		@WebParam(name = "renderEngine", partName = "updateRenderEngine.renderEngine") SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException;

	/**
	 * @param queryEngine QueryEngine to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateQueryEngine")
	void updateQueryEngine(
		@WebParam(name = "queryEngine", partName = "updateQueryEngine.queryEngine") SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException;

	/**
	 * @param modelMerger ModelMerger to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateModelMerger")
	void updateModelMerger(
		@WebParam(name = "modelMerger", partName = "updateModelMerger.modelMerger") SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException;

	/**
	 * @param modelCompare ModelCompare to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateModelCompare")
	void updateModelCompare(
		@WebParam(name = "modelCompare", partName = "updateModelCompare.modelCompare") SModelComparePluginConfiguration modelCompare) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateDeserializer")
	void updateDeserializer(
		@WebParam(name = "deserializer", partName = "updateDeserializer.deserializer") SDeserializerPluginConfiguration deserializer) throws ServerException, UserException;
	
	/**
	 * @param sid ObjectID of the Serializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(
		@WebParam(name = "sid", partName = "deleteSerializer.sid") Long sid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the Serializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deletePluginConfiguration")
	void deletePluginConfiguration(
		@WebParam(name = "oid", partName = "deletePluginConfiguration.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param iid ObjectID of the RenderEngine to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteRenderEngine")
	void deleteRenderEngine(
		@WebParam(name = "iid", partName = "deleteRenderEngine.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the ModelMerger to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteModelMerger")
	void deleteModelMerger(
		@WebParam(name = "iid", partName = "deleteModelMerger.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the ModelCompare to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteModelCompare")
	void deleteModelCompare(
		@WebParam(name = "iid", partName = "deleteModelCompare.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the ModelCompare to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteModelChecker")
	void deleteModelChecker(
			@WebParam(name = "iid", partName = "deleteModelChecker.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param iid ObjectID of the QueryEngine to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteQueryEngine")
	void deleteQueryEngine(
		@WebParam(name = "iid", partName = "deleteQueryEngine.iid") Long iid) throws ServerException, UserException;

	/**
	 * @param sid ObjectID of the Deserializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteDeserializer")
	void deleteDeserializer(
		@WebParam(name = "sid", partName = "deleteDeserializer.sid") Long sid) throws ServerException, UserException;

	@WebMethod(action = "getPluginObjectDefinition")
	SObjectDefinition getPluginObjectDefinition(
		@WebParam(name = "oid", partName = "getPluginObjectDefinition.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action = "getPluginSystemObjectDefinition")
	SObjectDefinition getPluginSystemObjectDefinition(
		@WebParam(name = "oid", partName = "getPluginSystemObjectDefinition.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action = "setPluginSettings")
	void setPluginSettings(
		@WebParam(name = "poid", partName = "setPluginSettings.poid") Long poid, 
		@WebParam(name = "settings", partName = "setPluginSettings.settings") SObjectType settings) throws ServerException, UserException;

	@WebMethod(action = "setPluginSystemSettings")
	void setPluginSystemSettings(
			@WebParam(name = "poid", partName = "setPluginSystemSettings.poid") Long poid, 
			@WebParam(name = "settings", partName = "setPluginSystemSettings.settings") SObjectType settings) throws ServerException, UserException;

	@WebMethod(action = "getPluginSettings")
	SObjectType getPluginSettings(
		@WebParam(name = "poid", partName = "getPluginSettings.poid") Long poid) throws ServerException, UserException;

	@WebMethod(action = "getPluginSystemSettings")
	SObjectType getPluginSystemSettings(
		@WebParam(name = "poid", partName = "getPluginSystemSettings.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param onlyEnabled Whether to only include enabled deserializers
	 * @return A list of all available deserializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializers")
	List<SDeserializerPluginConfiguration> getAllDeserializers(
		@WebParam(name = "onlyEnabled", partName = "getAllDeserializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param onlyEnabled Whether to only include enabled deserializers
	 * @return A list of all available deserializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializersForProject")
	List<SDeserializerPluginConfiguration> getAllDeserializersForProject (
		@WebParam(name = "onlyEnabled", partName = "getAllDeserializersForProject.onlyEnabled") Boolean onlyEnabled,
		@WebParam(name = "poid", partName = "getAllDeserializersForProject.poid") Long poid) throws ServerException, UserException;

	/**
	 * @param pluginClassName The name of the plugin class
	 * @return Serializer implementing given plugin class
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByPluginClassName")
	SSerializerPluginConfiguration getSerializerByPluginClassName(
		@WebParam(name = "pluginClassName", partName = "getSerializerByPluginClassName.pluginClassName") String pluginClassName) throws ServerException, UserException;

	/**
	 * @param contentType Content type
	 * @return Whether there is an active Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "hasActiveSerializer")
	Boolean hasActiveSerializer(
		@WebParam(name = "contentType", partName = "hasActiveSerializer.contentType") String contentType) throws ServerException, UserException;
	
	@WebMethod(action="getInternalServiceById")
	SInternalServicePluginConfiguration getInternalServiceById(
		@WebParam(name = "oid", partName = "getEServiceById.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="updateInternalService")
	void updateInternalService(
		@WebParam(name = "internalService", partName = "updateInternalService.internalService") SInternalServicePluginConfiguration internalService) throws ServerException, UserException;
	
	@WebMethod(action="addInternalService")
	Long addInternalService(
		@WebParam(name = "internalService", partName = "addInternalService.internalService") SInternalServicePluginConfiguration internalService) throws ServerException, UserException;
	
	@WebMethod(action="deleteInternalService")
	void deleteInternalService(
		@WebParam(name = "oid", partName = "deleteInternalService.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="getAllInternalServices")
	List<SInternalServicePluginConfiguration> getAllInternalServices(
		@WebParam(name = "onlyEnabled", partName = "getAllInternalServices.onlyEnabled") Boolean onlyEnabled) throws UserException, ServerException;

	@WebMethod(action="getAllInternalServicesOfService")
	List<SInternalServicePluginConfiguration> getAllInternalServicesOfService(
		@WebParam(name = "name", partName = "getAllInternalServicesOfService.name") String name,
		@WebParam(name = "onlyEnabled", partName = "getAllInternalServicesOfService.onlyEnabled") Boolean onlyEnabled) throws UserException, ServerException;
	
	@WebMethod(action = "getAvailablePluginBundles")
	List<SPluginBundle> getAvailablePluginBundles() throws UserException, ServerException;

	@WebMethod(action = "getPluginBundle")
	SPluginBundle getPluginBundle(
		@WebParam(name = "repository", partName = "getPluginBundle.repository") String repository, 
		@WebParam(name = "groupId", partName = "getPluginBundle.groupId") String groupId, 
		@WebParam(name = "artifactId", partName = "getPluginBundle.artifactId") String artifactId) throws UserException, ServerException;

	@WebMethod(action = "getPluginBundleVersionById")
	SPluginBundleVersion getPluginBundleVersionById(
		@WebParam(name = "pbid", partName = "getPluginBundleVersionById.pbid") Long pbid) throws UserException, ServerException;

	@WebMethod(action = "getInstalledPluginBundles")
	List<SPluginBundle> getInstalledPluginBundles() throws UserException, ServerException;

	@WebMethod(action = "getInstalledPluginBundle")
	SPluginBundleVersion getInstalledPluginBundle(
		@WebParam(name = "oid", partName = "getInstalledPluginBundle.oid") Long oid) throws UserException, ServerException;
	
	@WebMethod(action = "installPluginBundle")
	void installPluginBundle(
		@WebParam(name = "repository", partName = "installPluginBundle.repository") String repository, 
		@WebParam(name = "groupId", partName = "installPluginBundle.groupId") String groupId, 
		@WebParam(name = "artifactId", partName = "installPluginBundle.artifactId") String artifactId, 
		@WebParam(name = "version", partName = "installPluginBundle.version") String version,
		@WebParam(name = "plugins", partName = "installPluginBundle.plugins") List<SPluginInformation> plugins) throws UserException, ServerException;

	@WebMethod(action = "installPluginBundleFromFile")
	void installPluginBundleFromFile(
		@WebParam(name = "data", partName = "installPluginBundleFromFile.data") @XmlMimeType("application/octet-stream") DataHandler data,
		@WebParam(name = "installAllPluginsForAllUsers", partName = "installPluginBundleFromFile.installAllPluginsForAllUsers") Boolean installAllPluginsForAllUsers, 
		@WebParam(name = "installAllPluginsForNewUsers", partName = "installPluginBundleFromFile.installAllPluginsForNewUsers") Boolean installAllPluginsForNewUsers) throws UserException, ServerException;

	@WebMethod(action = "installPluginBundleFromUrl")
	void installPluginBundleFromUrl(
		@WebParam(name = "url", partName = "installPluginBundleFromUrl.url") String url,
		@WebParam(name = "installAllPluginsForAllUsers", partName = "installPluginBundleFromUrl.installAllPluginsForAllUsers") Boolean installAllPluginsForAllUsers, 
		@WebParam(name = "installAllPluginsForNewUsers", partName = "installPluginBundleFromUrl.installAllPluginsForNewUsers") Boolean installAllPluginsForNewUsers) throws UserException, ServerException;

	@WebMethod(action = "uninstallPluginBundle")
	void uninstallPluginBundle(
		@WebParam(name = "repository", partName = "uninstallPluginBundle.repository") String repository, 
		@WebParam(name = "groupId", partName = "uninstallPluginBundle.groupId") String groupId, 
		@WebParam(name = "artifactId", partName = "uninstallPluginBundle.artifactId") String artifactId, 
		@WebParam(name = "version", partName = "uninstallPluginBundle.version") String version) throws UserException, ServerException;

	@WebMethod(action = "updatePluginBundle")
	void updatePluginBundle(
		@WebParam(name = "repository", partName = "uninstallPluginBundle.repository") String repository, 
		@WebParam(name = "groupId", partName = "uninstallPluginBundle.groupId") String groupId, 
		@WebParam(name = "artifactId", partName = "uninstallPluginBundle.artifactId") String artifactId, 
		@WebParam(name = "version", partName = "uninstallPluginBundle.version") String version) throws UserException, ServerException;
	
	@WebMethod(action = "getPluginInformation")
	List<SPluginInformation> getPluginInformation(
		@WebParam(name = "repository", partName = "getPluginInformation.repository") String repository, 
		@WebParam(name = "groupId", partName = "getPluginInformation.groupId") String groupId, 
		@WebParam(name = "artifactId", partName = "getPluginInformation.artifactId") String artifactId, 
		@WebParam(name = "version", partName = "getPluginInformation.version") String version) throws UserException, ServerException;
	
	/**
	 * Removes the maven cache, can be useful if you don't want to wait the default update period (which is 1 day) for new plugins
	 * 
	 * @throws UserException
	 * @throws ServerException
	 */
	@WebMethod(action = "clearMavenCache")
	void clearMavenCache() throws UserException, ServerException;
	
	@WebMethod(action = "listPluginsInBundle")
	List<SPluginDescriptor> listPluginsInBundle(@WebParam(name = "pluginBundleVersionOid", partName = "listPluginsInBundle.pluginBundleVersionOid") Long pluginBundleVersionOid) throws ServerException, UserException;
	
	@WebMethod(action = "hasPreBuiltPlugins")
	Boolean hasPreBuiltPlugins() throws UserException, ServerException;
	
	@WebMethod(action = "installPreBuiltPlugins")
	void installPreBuiltPlugins(@WebParam(name = "artifacts", partName = "installPreBuiltPlugins.artifacts") List<String> artifacts) throws UserException, ServerException;
}