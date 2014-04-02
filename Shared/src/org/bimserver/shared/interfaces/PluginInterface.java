package org.bimserver.shared.interfaces;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDeserializerPluginDescriptor;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SModelCheckerPluginDescriptor;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginDescriptor;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SServicePluginDescriptor;
import org.bimserver.interfaces.objects.SWebModulePluginConfiguration;
import org.bimserver.interfaces.objects.SWebModulePluginDescriptor;
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

	@WebMethod(action="getDefaultObjectIDM")
	SObjectIDMPluginConfiguration getDefaultObjectIDM() throws ServerException, UserException;

	@WebMethod(action="setDefaultRenderEngine")
	void setDefaultRenderEngine(
		@WebParam(name = "oid", partName = "setDefaultRenderEngine.oid") Long oid) throws UserException, ServerException;

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

	@WebMethod(action="setDefaultObjectIDM")
	void setDefaultObjectIDM(
		@WebParam(name = "oid", partName = "setDefaultObjectIDM.oid") Long oid) throws UserException, ServerException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializerPluginDescriptors")
	List<SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws ServerException, UserException;

	@WebMethod(action = "getPluginDescriptor")
	SPluginDescriptor getPluginDescriptor(
		@WebParam(name = "oid", partName = "getPluginDescriptor.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllWebModulePluginDescriptors")
	List<SWebModulePluginDescriptor> getAllWebModulePluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @return List of all SerializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllRenderEnginePluginDescriptors")
	List<SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all DeserializerPluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllDeserializerPluginDescriptors")
	List<SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all QueryEnginePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllQueryEnginePluginDescriptors")
	List<SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all getAllServicePluginDescriptors
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllServicePluginDescriptors")
	List<SServicePluginDescriptor> getAllServicePluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @return List of all SModelComparePluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelComparePluginDescriptors")
	List<SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SModelComparePluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelCheckerPluginDescriptors")
	List<SModelCheckerPluginDescriptor> getAllModelCheckerPluginDescriptors() throws ServerException, UserException;

	/**
	 * @return List of all SModelMergerPluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllModelMergerPluginDescriptors")
	List<SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws ServerException, UserException;
	
	/**
	 * @param serializerName Name of the Serializer
	 * @return Serializer
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getWebModuleByName")
	SWebModulePluginConfiguration getWebModuleByName(
		@WebParam(name = "name", partName = "getWebModuleByName.name") String name) throws ServerException, UserException;
	
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
	 * @param onlyEnabled Whether to only include enabled serializers
	 * @return A list of Serializers
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllSerializersForRoids")
	List<SSerializerPluginConfiguration> getAllSerializersForRoids(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializersForRoids.onlyEnabled") Boolean onlyEnabled,
		@WebParam(name = "roids", partName = "getAllSerializersForRoids.roids") Set<Long> roids) throws ServerException, UserException;

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
	void addSerializer(
		@WebParam(name = "serializer", partName = "addSerializer.serializer") SSerializerPluginConfiguration serializer) throws ServerException, UserException;

	/**
	 * @param renderEngine RenderEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addRenderEngine")
	void addRenderEngine(
		@WebParam(name = "renderEngine", partName = "addRenderEngine.renderEngine") SRenderEnginePluginConfiguration renderEngine) throws ServerException, UserException;

	/**
	 * @param queryEngine QueryEngine to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addQueryEngine")
	void addQueryEngine(
		@WebParam(name = "queryEngine", partName = "addQueryEngine.queryEngine") SQueryEnginePluginConfiguration queryEngine) throws ServerException, UserException;

	/**
	 * @param modelMerger ModelMerger to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelMerger")
	void addModelMerger(
		@WebParam(name = "modelMerger", partName = "addModelMerger.modelMerger") SModelMergerPluginConfiguration modelMerger) throws ServerException, UserException;

	/**
	 * @param modelCompare ModelCompare to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addModelCompare")
	void addModelCompare(
		@WebParam(name = "modelCompare", partName = "addModelCompare.modelCompare") SModelComparePluginConfiguration modelCompare) throws ServerException, UserException;

	/**
	 * @param deserializer Deserializer to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDeserializer")
	void addDeserializer(
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
	 * @param onlyEnabled Whether to include only enabled ObjectIDMs
	 * @return A list of ObjectIDMs
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllObjectIDMs")
	List<SObjectIDMPluginConfiguration> getAllObjectIDMs(
		@WebParam(name = "onlyEnabled", partName = "getAllSerializers.onlyEnabled") Boolean onlyEnabled) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMById")
	SObjectIDMPluginConfiguration getObjectIDMById(
		@WebParam(name = "oid", partName = "getObjectIDMById.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to add
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addObjectIDM")
	void addObjectIDM(
		@WebParam(name = "objectIDM", partName = "addObjectIDM.objectIDM") SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException;
	
	/**
	 * @param objectIDM The ObjectIDM to update
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "updateObjectIDM")
	void updateObjectIDM(
		@WebParam(name = "objectIDM", partName = "updateObjectIDM.objectIDM") SObjectIDMPluginConfiguration objectIDM) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the ObjectIDM to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteObjectIDM")
	void deleteObjectIDM(
		@WebParam(name = "oid", partName = "deleteObjectIDM.oid") Long oid) throws ServerException, UserException;

	/**
	 * @param sid ObjectID of the Serializer to delete
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "deleteSerializer")
	void deleteSerializer(
		@WebParam(name = "sid", partName = "deleteSerializer.sid") Long sid) throws ServerException, UserException;

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

	/**
	 * @param objectIDMName Name of the ObjectIDM
	 * @return ObjectIDM
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getObjectIDMByName")
	SObjectIDMPluginConfiguration getObjectIDMByName(
		@WebParam(name = "objectIDMName", partName = "getObjectIDMByName.objectIDMName") String objectIDMName) throws ServerException, UserException;

	@WebMethod(action = "getPluginObjectDefinition")
	SObjectDefinition getPluginObjectDefinition(
		@WebParam(name = "oid", partName = "getPluginObjectDefinition.oid") Long oid) throws ServerException, UserException;

	@WebMethod(action = "setPluginSettings")
	void setPluginSettings(
		@WebParam(name = "poid", partName = "setPluginSettings.poid") Long poid, 
		@WebParam(name = "settings", partName = "setPluginSettings.settings") SObjectType settings) throws ServerException, UserException;

	@WebMethod(action = "getPluginSettings")
	SObjectType getPluginSettings(
		@WebParam(name = "poid", partName = "getPluginSettings.poid") Long poid) throws ServerException, UserException;
	
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
	 * @param contentType The ContentType
	 * @return Serializer supporting the given ContentType
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerByPluginClassName")
	SSerializerPluginConfiguration getSerializerByPluginClassName(
		@WebParam(name = "pluginClassName", partName = "getSerializerByPluginClassName.pluginClassName") String pluginClassName) throws ServerException, UserException;
	
	/**
	 * @param type The type
	 * @return SSerializerPluginDescriptor
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getSerializerPluginDescriptor")
	SSerializerPluginDescriptor getSerializerPluginDescriptor(
		@WebParam(name = "type", partName = "getSerializerPluginDescriptor.type") String type) throws ServerException, UserException;
	
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
	void addInternalService(
		@WebParam(name = "internalService", partName = "addInternalService.internalService") SInternalServicePluginConfiguration internalService) throws ServerException, UserException;
	
	@WebMethod(action="deleteInternalService")
	void deleteInternalService(
		@WebParam(name = "oid", partName = "deleteInternalService.oid") Long oid) throws ServerException, UserException;
	
	@WebMethod(action="getAllInternalServices")
	List<SInternalServicePluginConfiguration> getAllInternalServices(
		@WebParam(name = "onlyEnabled", partName = "getAllInternalServices.onlyEnabled") Boolean onlyEnabled) throws UserException, ServerException;
	
	/**
	 * @return A list of available IDMPlugins
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getAllObjectIDMPluginDescriptors")
	List<SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws ServerException, UserException;
}