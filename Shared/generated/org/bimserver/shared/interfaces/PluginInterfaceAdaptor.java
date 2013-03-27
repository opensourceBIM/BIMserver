package org.bimserver.shared.interfaces;

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
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.exceptions.ServerException;

public class PluginInterfaceAdaptor implements PluginInterface {

	public void addDeserializer(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer) throws UserException, ServerException {
	}
	
	public void addInternalService(org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService) throws UserException, ServerException {
	}
	
	public void addModelCompare(org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare) throws UserException, ServerException {
	}
	
	public void addModelMerger(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger) throws UserException, ServerException {
	}
	
	public void addObjectIDM(org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration objectIDM) throws UserException, ServerException {
	}
	
	public void addQueryEngine(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine) throws UserException, ServerException {
	}
	
	public void addRenderEngine(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine) throws UserException, ServerException {
	}
	
	public void addSerializer(org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer) throws UserException, ServerException {
	}
	
	public void deleteDeserializer(java.lang.Long sid) throws UserException, ServerException {
	}
	
	public void deleteInternalService(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void deleteModelCompare(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteModelMerger(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteObjectIDM(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void deleteQueryEngine(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteRenderEngine(java.lang.Long iid) throws UserException, ServerException {
	}
	
	public void deleteSerializer(java.lang.Long sid) throws UserException, ServerException {
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginConfiguration> getAllDeserializers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SInternalServicePluginConfiguration> getAllInternalServices(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelComparePluginConfiguration> getAllModelCompares(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginConfiguration> getAllModelMergers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration> getAllObjectIDMs(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration> getAllQueryEngines(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SRenderEnginePluginDescriptor> getAllRenderEnginePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration> getAllRenderEngines(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginConfiguration> getAllSerializers(java.lang.Boolean onlyEnabled) throws UserException, ServerException {
		return null;
	}
	
	public java.util.List<org.bimserver.interfaces.objects.SServicePluginDescriptor> getAllServicePluginDescriptors() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelComparePluginConfiguration getDefaultModelCompare() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SModelMergerPluginConfiguration getDefaultModelMerger() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration getDefaultObjectIDM() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getDefaultQueryEngine() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getDefaultRenderEngine() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getDefaultSerializer() throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getDeserializerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SDeserializerPluginConfiguration getDeserializerByName(java.lang.String deserializerName) throws UserException, ServerException {
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
	
	public org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration getObjectIDMById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration getObjectIDMByName(java.lang.String objectIDMName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectDefinition getPluginObjectDefinition(java.lang.String className) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SObjectType getPluginSettings(java.lang.Long poid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getQueryEngineById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration getQueryEngineByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getRenderEngineById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration getRenderEngineByName(java.lang.String name) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByContentType(java.lang.String contentType) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerById(java.lang.Long oid) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByName(java.lang.String serializerName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginConfiguration getSerializerByPluginClassName(java.lang.String pluginClassName) throws UserException, ServerException {
		return null;
	}
	
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String type) throws UserException, ServerException {
		return null;
	}
	
	public java.lang.Boolean hasActiveSerializer(java.lang.String contentType) throws UserException, ServerException {
		return null;
	}
	
	public void setDefaultModelCompare(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultModelMerger(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultObjectIDM(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultQueryEngine(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultRenderEngine(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setDefaultSerializer(java.lang.Long oid) throws UserException, ServerException {
	}
	
	public void setPluginSettings(java.lang.Long poid, org.bimserver.interfaces.objects.SObjectType settings) throws UserException, ServerException {
	}
	
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializerPluginConfiguration deserializer) throws UserException, ServerException {
	}
	
	public void updateInternalService(org.bimserver.interfaces.objects.SInternalServicePluginConfiguration internalService) throws UserException, ServerException {
	}
	
	public void updateModelCompare(org.bimserver.interfaces.objects.SModelComparePluginConfiguration modelCompare) throws UserException, ServerException {
	}
	
	public void updateModelMerger(org.bimserver.interfaces.objects.SModelMergerPluginConfiguration modelMerger) throws UserException, ServerException {
	}
	
	public void updateObjectIDM(org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration objectIDM) throws UserException, ServerException {
	}
	
	public void updateQueryEngine(org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration queryEngine) throws UserException, ServerException {
	}
	
	public void updateRenderEngine(org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration renderEngine) throws UserException, ServerException {
	}
	
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializerPluginConfiguration serializer) throws UserException, ServerException {
	}
	
}