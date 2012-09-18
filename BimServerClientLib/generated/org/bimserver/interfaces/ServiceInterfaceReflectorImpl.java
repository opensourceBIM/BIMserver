package org.bimserver.interfaces;

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
import org.bimserver.shared.Reflector;

import org.bimserver.shared.KeyValuePair;

@SuppressWarnings("unchecked")
public class ServiceInterfaceReflectorImpl implements org.bimserver.shared.ServiceInterface {

private Reflector reflector;

	public ServiceInterfaceReflectorImpl (Reflector reflector) {this.reflector = reflector;}
	public java.util.List<org.bimserver.interfaces.objects.SExternalServer> getRepositoryServers() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SExternalServer>) reflector.callMethod("ServiceInterface", "getRepositoryServers", java.util.List.class);
	}
	public void setDefaultModelMerger(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultModelMerger", void.class, new KeyValuePair("arg0", arg0));
	}
	public org.bimserver.interfaces.objects.SVersion getLatestVersion() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getLatestVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByName(java.lang.String serializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByName", org.bimserver.interfaces.objects.SSerializer.class, new KeyValuePair("serializerName", serializerName));
	}
	public java.lang.String getServiceRepositoryUrl() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getServiceRepositoryUrl", java.lang.String.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SModelComparePluginDescriptor> getAllModelComparePluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SModelComparePluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllModelComparePluginDescriptors", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor> getAllQueryEnginePluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllQueryEnginePluginDescriptors", java.util.List.class);
	}
	public void updateIfcEngine(org.bimserver.interfaces.objects.SIfcEngine ifcEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateIfcEngine", void.class, new KeyValuePair("ifcEngine", ifcEngine));
	}
	public void addDeserializer(org.bimserver.interfaces.objects.SDeserializer deserializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addDeserializer", void.class, new KeyValuePair("deserializer", deserializer));
	}
	public void deleteDeserializer(java.lang.Long sid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteDeserializer", void.class, new KeyValuePair("sid", sid));
	}
	public java.lang.String getSettingSiteAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSiteAddress", java.lang.String.class);
	}
	public void updateSerializer(org.bimserver.interfaces.objects.SSerializer serializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateSerializer", void.class, new KeyValuePair("serializer", serializer));
	}
	public void setBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setBooleanAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllProjects", java.util.List.class);
	}
	public void setSettingHeaderAddition(java.lang.String headerAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingHeaderAddition", void.class, new KeyValuePair("headerAddition", headerAddition));
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerByContentType(java.lang.String contentType) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerByContentType", org.bimserver.interfaces.objects.SSerializer.class, new KeyValuePair("contentType", contentType));
	}
	public java.util.List<org.bimserver.interfaces.objects.SLongAction> getActiveLongActions() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLongAction>) reflector.callMethod("ServiceInterface", "getActiveLongActions", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SUser getUserByUserName(java.lang.String username) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUserName", org.bimserver.interfaces.objects.SUser.class, new KeyValuePair("username", username));
	}
	public void updateModelCompare(org.bimserver.interfaces.objects.SModelCompare modelCompare) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateModelCompare", void.class, new KeyValuePair("modelCompare", modelCompare));
	}
	public org.bimserver.interfaces.objects.SGeoTag getGeoTag(java.lang.Long goid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SGeoTag) reflector.callMethod("ServiceInterface", "getGeoTag", org.bimserver.interfaces.objects.SGeoTag.class, new KeyValuePair("goid", goid));
	}
	public void removeObject(java.lang.String className, java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeObject", void.class, new KeyValuePair("className", className), new KeyValuePair("oid", oid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjects(java.lang.Long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjects", java.util.List.class, new KeyValuePair("arg0", arg0));
	}
	public void updateProject(org.bimserver.interfaces.objects.SProject sProject) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateProject", void.class, new KeyValuePair("sProject", sProject));
	}
	public org.bimserver.interfaces.objects.SUser validateAccount(java.lang.Long uoid, java.lang.String token, java.lang.String password) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "validateAccount", org.bimserver.interfaces.objects.SUser.class, new KeyValuePair("uoid", uoid), new KeyValuePair("token", token), new KeyValuePair("password", password));
	}
	public void setup(java.lang.String siteAddress, java.lang.String smtpServer, java.lang.String smtpSender, java.lang.String adminName, java.lang.String adminUsername, java.lang.String adminPassword) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setup", void.class, new KeyValuePair("siteAddress", siteAddress), new KeyValuePair("smtpServer", smtpServer), new KeyValuePair("smtpSender", smtpSender), new KeyValuePair("adminName", adminName), new KeyValuePair("adminUsername", adminUsername), new KeyValuePair("adminPassword", adminPassword));
	}
	public void removeAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer index) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("index", index));
	}
	public void addIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addIntegerAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public void setDoubleAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Double value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDoubleAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDM> getAllObjectIDMs(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SObjectIDM>) reflector.callMethod("ServiceInterface", "getAllObjectIDMs", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public java.util.List<org.bimserver.interfaces.objects.SQueryEngine> getAllQueryEngines(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SQueryEngine>) reflector.callMethod("ServiceInterface", "getAllQueryEngines", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public void changeUserType(java.lang.Long uoid, org.bimserver.interfaces.objects.SUserType userType) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "changeUserType", void.class, new KeyValuePair("uoid", uoid), new KeyValuePair("userType", userType));
	}
	public void close() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "close", void.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SDataObject> getDataObjectsByType(java.lang.Long roid, java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDataObject>) reflector.callMethod("ServiceInterface", "getDataObjectsByType", java.util.List.class, new KeyValuePair("roid", roid), new KeyValuePair("className", className));
	}
	public org.bimserver.shared.Token getCurrentToken() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.shared.Token) reflector.callMethod("ServiceInterface", "getCurrentToken", org.bimserver.shared.Token.class);
	}
	public org.bimserver.interfaces.objects.SVersion getVersion() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SVersion) reflector.callMethod("ServiceInterface", "getVersion", org.bimserver.interfaces.objects.SVersion.class);
	}
	public java.lang.String getSettingCustomLogoAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingCustomLogoAddress", java.lang.String.class);
	}
	public java.lang.Boolean isLoggedIn() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isLoggedIn", java.lang.Boolean.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProjectAndSubProjects(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProjectAndSubProjects", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public void addUserToExtendedDataSchema(java.lang.Long uoid, java.lang.Long edsid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addUserToExtendedDataSchema", void.class, new KeyValuePair("uoid", uoid), new KeyValuePair("edsid", edsid));
	}
	public org.bimserver.interfaces.objects.SUser addUser(java.lang.String username, java.lang.String name, org.bimserver.interfaces.objects.SUserType type, java.lang.Boolean selfRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "addUser", org.bimserver.interfaces.objects.SUser.class, new KeyValuePair("username", username), new KeyValuePair("name", name), new KeyValuePair("type", type), new KeyValuePair("selfRegistration", selfRegistration));
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllAuthorizedUsersOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllAuthorizedUsersOfProject", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getUsersProjects(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getUsersProjects", java.util.List.class, new KeyValuePair("uoid", uoid));
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByOid(java.lang.Long roid, java.lang.Long oid, java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByOid", org.bimserver.interfaces.objects.SDataObject.class, new KeyValuePair("roid", roid), new KeyValuePair("oid", oid), new KeyValuePair("className", className));
	}
	public void addExtendedDataToProject(java.lang.Long poid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addExtendedDataToProject", void.class, new KeyValuePair("poid", poid), new KeyValuePair("extendedData", extendedData));
	}
	public void addExtendedDataSchema(org.bimserver.interfaces.objects.SExtendedDataSchema extendedDataSchema) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addExtendedDataSchema", void.class, new KeyValuePair("extendedDataSchema", extendedDataSchema));
	}
	public java.lang.String getRemoteAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getRemoteAddress", java.lang.String.class);
	}
	public org.bimserver.interfaces.objects.SServerInfo getServerInfo() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SServerInfo) reflector.callMethod("ServiceInterface", "getServerInfo", org.bimserver.interfaces.objects.SServerInfo.class);
	}
	public void logout() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "logout", void.class);
	}
	public void setDefaultObjectIDM(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultObjectIDM", void.class, new KeyValuePair("arg0", arg0));
	}
	public org.bimserver.interfaces.objects.SProject addProject(java.lang.String projectName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProject", org.bimserver.interfaces.objects.SProject.class, new KeyValuePair("projectName", projectName));
	}
	public java.util.List<java.lang.String> getAvailableClasses() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClasses", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToExistingProject(java.lang.Long roid, java.lang.Long destPoid, java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToExistingProject", org.bimserver.interfaces.objects.SCheckinResult.class, new KeyValuePair("roid", roid), new KeyValuePair("destPoid", destPoid), new KeyValuePair("comment", comment));
	}
	public java.lang.Integer downloadQuery(java.lang.Long roid, java.lang.Long qeid, java.lang.String code, java.lang.Boolean sync, java.lang.String serializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadQuery", java.lang.Integer.class, new KeyValuePair("roid", roid), new KeyValuePair("qeid", qeid), new KeyValuePair("code", code), new KeyValuePair("sync", sync), new KeyValuePair("serializerName", serializerName));
	}
	public void addModelMerger(org.bimserver.interfaces.objects.SModelMerger modelMerger) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addModelMerger", void.class, new KeyValuePair("modelMerger", modelMerger));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getProjectsByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getProjectsByName", java.util.List.class, new KeyValuePair("name", name));
	}
	public java.lang.String getSuggestedDeserializerForExtension(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSuggestedDeserializerForExtension", java.lang.String.class, new KeyValuePair("arg0", arg0));
	}
	public org.bimserver.interfaces.objects.SExtendedDataSchema getExtendedDataSchemaById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SExtendedDataSchema) reflector.callMethod("ServiceInterface", "getExtendedDataSchemaById", org.bimserver.interfaces.objects.SExtendedDataSchema.class, new KeyValuePair("oid", oid));
	}
	public org.bimserver.interfaces.objects.SQueryEngine getDefaultQueryEngine() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SQueryEngine) reflector.callMethod("ServiceInterface", "getDefaultQueryEngine", org.bimserver.interfaces.objects.SQueryEngine.class);
	}
	public void setSettingSendConfirmationEmailAfterRegistration(java.lang.Boolean sendConfirmationEmailAfterRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSendConfirmationEmailAfterRegistration", void.class, new KeyValuePair("sendConfirmationEmailAfterRegistration", sendConfirmationEmailAfterRegistration));
	}
	public java.util.List<org.bimserver.interfaces.objects.SModelMerger> getAllModelMergers(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SModelMerger>) reflector.callMethod("ServiceInterface", "getAllModelMergers", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginDescriptor> getAllModelMergerPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SModelMergerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllModelMergerPluginDescriptors", java.util.List.class);
	}
	public java.lang.String getProtocolBuffersFile() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getProtocolBuffersFile", java.lang.String.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllReadableProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllReadableProjects", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SObjectIDM getObjectIDMById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SObjectIDM) reflector.callMethod("ServiceInterface", "getObjectIDMById", org.bimserver.interfaces.objects.SObjectIDM.class, new KeyValuePair("oid", oid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor> getAllIfcEnginePluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllIfcEnginePluginDescriptors", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SModelMerger getModelMergerById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelMerger) reflector.callMethod("ServiceInterface", "getModelMergerById", org.bimserver.interfaces.objects.SModelMerger.class, new KeyValuePair("oid", oid));
	}
	public void deleteModelCompare(java.lang.Long iid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteModelCompare", void.class, new KeyValuePair("iid", iid));
	}
	public void setSettingProtocolBuffersPort(java.lang.Integer port) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingProtocolBuffersPort", void.class, new KeyValuePair("port", port));
	}
	public void updateDeserializer(org.bimserver.interfaces.objects.SDeserializer deserializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateDeserializer", void.class, new KeyValuePair("deserializer", deserializer));
	}
	public org.bimserver.interfaces.objects.SProject getProjectByPoid(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "getProjectByPoid", org.bimserver.interfaces.objects.SProject.class, new KeyValuePair("poid", poid));
	}
	public java.lang.String getSettingHeaderAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingHeaderAddition", java.lang.String.class);
	}
	public java.lang.Integer downloadCompareResults(java.lang.String serializerName, java.lang.Long roid1, java.lang.Long roid2, java.lang.Long mcid, org.bimserver.interfaces.objects.SCompareType type, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadCompareResults", java.lang.Integer.class, new KeyValuePair("serializerName", serializerName), new KeyValuePair("roid1", roid1), new KeyValuePair("roid2", roid2), new KeyValuePair("mcid", mcid), new KeyValuePair("type", type), new KeyValuePair("sync", sync));
	}
	public java.lang.Boolean hasActiveSerializer(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "hasActiveSerializer", java.lang.Boolean.class, new KeyValuePair("arg0", arg0));
	}
	public java.lang.String getServerLog() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getServerLog", java.lang.String.class);
	}
	public org.bimserver.interfaces.objects.SQueryEngine getQueryEngineById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SQueryEngine) reflector.callMethod("ServiceInterface", "getQueryEngineById", org.bimserver.interfaces.objects.SQueryEngine.class, new KeyValuePair("oid", oid));
	}
	public void deleteModelMerger(java.lang.Long iid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteModelMerger", void.class, new KeyValuePair("iid", iid));
	}
	public void addReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addReference", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("referenceName", referenceName), new KeyValuePair("referenceOid", referenceOid), new KeyValuePair("referenceClassName", referenceClassName));
	}
	public void startTransaction(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "startTransaction", void.class, new KeyValuePair("poid", poid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SExternalProfile> getRemoteProfiles(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SExternalProfile>) reflector.callMethod("ServiceInterface", "getRemoteProfiles", java.util.List.class, new KeyValuePair("arg0", arg0));
	}
	public void addDoubleAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Double value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addDoubleAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public void deleteSerializer(java.lang.Long sid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteSerializer", void.class, new KeyValuePair("sid", sid));
	}
	public java.util.List<java.lang.String> getAvailableClassesInRevision(java.lang.Long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getAvailableClassesInRevision", java.util.List.class, new KeyValuePair("arg0", arg0));
	}
	public java.util.List<org.bimserver.interfaces.objects.SMigration> getMigrations() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SMigration>) reflector.callMethod("ServiceInterface", "getMigrations", java.util.List.class);
	}
	public java.lang.String getSettingRegistrationAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingRegistrationAddition", java.lang.String.class);
	}
	public java.util.Set<java.lang.String> getCheckinWarnings(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("ServiceInterface", "getCheckinWarnings", java.util.Set.class, new KeyValuePair("poid", poid));
	}
	public java.lang.Boolean undeleteUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteUser", java.lang.Boolean.class, new KeyValuePair("uoid", uoid));
	}
	public org.bimserver.interfaces.objects.SUser getCurrentUser() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getCurrentUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public void setStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setStringAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public void setSettingSmtpServer(java.lang.String smtpServer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSmtpServer", void.class, new KeyValuePair("smtpServer", smtpServer));
	}
	public java.lang.Integer downloadByTypes(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> classNames, java.lang.String serializerName, java.lang.Boolean includeAllSubtypes, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByTypes", java.lang.Integer.class, new KeyValuePair("roids", roids), new KeyValuePair("classNames", classNames), new KeyValuePair("serializerName", serializerName), new KeyValuePair("includeAllSubtypes", includeAllSubtypes), new KeyValuePair("sync", sync));
	}
	public org.bimserver.interfaces.objects.SObjectIDM getDefaultObjectIDM() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SObjectIDM) reflector.callMethod("ServiceInterface", "getDefaultObjectIDM", org.bimserver.interfaces.objects.SObjectIDM.class);
	}
	public void migrateDatabase() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "migrateDatabase", void.class);
	}
	public void setRevisionTag(java.lang.Long roid, java.lang.String tag) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setRevisionTag", void.class, new KeyValuePair("roid", roid), new KeyValuePair("tag", tag));
	}
	public java.lang.Boolean isSettingAllowSelfRegistration() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowSelfRegistration", java.lang.Boolean.class);
	}
	public void requestPasswordChange(java.lang.String username) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "requestPasswordChange", void.class, new KeyValuePair("username", username));
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor> getAllDeserializerPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllDeserializerPluginDescriptors", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SIfcEngine getDefaultIfcEngine() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SIfcEngine) reflector.callMethod("ServiceInterface", "getDefaultIfcEngine", org.bimserver.interfaces.objects.SIfcEngine.class);
	}
	public java.util.Date getLastDatabaseReset() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastDatabaseReset", java.util.Date.class);
	}
	public void deleteObjectIDM(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteObjectIDM", void.class, new KeyValuePair("oid", oid));
	}
	public java.lang.Boolean isSettingCheckinMergingEnabled() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCheckinMergingEnabled", java.lang.Boolean.class);
	}
	public java.lang.Integer downloadByOids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.Long> oids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByOids", java.lang.Integer.class, new KeyValuePair("roids", roids), new KeyValuePair("oids", oids), new KeyValuePair("serializerName", serializerName), new KeyValuePair("sync", sync));
	}
	public java.lang.Boolean upgradePossible() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "upgradePossible", java.lang.Boolean.class);
	}
	public java.lang.Integer downloadByGuids(java.util.Set<java.lang.Long> roids, java.util.Set<java.lang.String> guids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadByGuids", java.lang.Integer.class, new KeyValuePair("roids", roids), new KeyValuePair("guids", guids), new KeyValuePair("serializerName", serializerName), new KeyValuePair("sync", sync));
	}
	public void setSettingRegistrationAddition(java.lang.String registrationAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingRegistrationAddition", void.class, new KeyValuePair("registrationAddition", registrationAddition));
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllNonAuthorizedUsersOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedUsersOfProject", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public java.lang.Boolean deleteUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteUser", java.lang.Boolean.class, new KeyValuePair("uoid", uoid));
	}
	public org.bimserver.interfaces.objects.SSerializerPluginDescriptor getSerializerPluginDescriptor(java.lang.String type) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializerPluginDescriptor) reflector.callMethod("ServiceInterface", "getSerializerPluginDescriptor", org.bimserver.interfaces.objects.SSerializerPluginDescriptor.class, new KeyValuePair("type", type));
	}
	public java.util.Set<java.lang.String> getCheckoutWarnings(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Set<java.lang.String>) reflector.callMethod("ServiceInterface", "getCheckoutWarnings", java.util.Set.class, new KeyValuePair("poid", poid));
	}
	public java.lang.Long createObject(java.lang.String className) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "createObject", java.lang.Long.class, new KeyValuePair("className", className));
	}
	public void setSettingEmailSenderAddress(java.lang.String emailSenderAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingEmailSenderAddress", void.class, new KeyValuePair("emailSenderAddress", emailSenderAddress));
	}
	public void setDefaultModelCompare(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultModelCompare", void.class, new KeyValuePair("arg0", arg0));
	}
	public void setIntegerAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Integer value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setIntegerAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.lang.Integer downloadRevisions(java.util.Set<java.lang.Long> roids, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "downloadRevisions", java.lang.Integer.class, new KeyValuePair("roids", roids), new KeyValuePair("serializerName", serializerName), new KeyValuePair("sync", sync));
	}
	public org.bimserver.interfaces.objects.SIfcEngine getIfcEngineByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SIfcEngine) reflector.callMethod("ServiceInterface", "getIfcEngineByName", org.bimserver.interfaces.objects.SIfcEngine.class, new KeyValuePair("name", name));
	}
	public void updateQueryEngine(org.bimserver.interfaces.objects.SQueryEngine queryEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateQueryEngine", void.class, new KeyValuePair("queryEngine", queryEngine));
	}
	public void setSettingCacheOutputFiles(java.lang.Boolean cacheOutputFiles) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCacheOutputFiles", void.class, new KeyValuePair("cacheOutputFiles", cacheOutputFiles));
	}
	public java.util.List<java.lang.String> getQueryEngineExampleKeys(java.lang.Long qeid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<java.lang.String>) reflector.callMethod("ServiceInterface", "getQueryEngineExampleKeys", java.util.List.class, new KeyValuePair("qeid", qeid));
	}
	public org.bimserver.interfaces.objects.SRevisionSummary getRevisionSummary(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevisionSummary) reflector.callMethod("ServiceInterface", "getRevisionSummary", org.bimserver.interfaces.objects.SRevisionSummary.class, new KeyValuePair("roid", roid));
	}
	public java.lang.Boolean deleteProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "deleteProject", java.lang.Boolean.class, new KeyValuePair("poid", poid));
	}
	public void setDefaultSerializer(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultSerializer", void.class, new KeyValuePair("arg0", arg0));
	}
	public void setSettingCheckinMergingEnabled(java.lang.Boolean checkinMergingEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCheckinMergingEnabled", void.class, new KeyValuePair("checkinMergingEnabled", checkinMergingEnabled));
	}
	public void enablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "enablePlugin", void.class, new KeyValuePair("arg0", arg0));
	}
	public java.util.List<org.bimserver.interfaces.objects.SUserSession> getActiveUserSessions() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUserSession>) reflector.callMethod("ServiceInterface", "getActiveUserSessions", java.util.List.class);
	}
	public void addProfileToProject(long arg0, org.bimserver.interfaces.objects.SExternalProfile arg1) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addProfileToProject", void.class, new KeyValuePair("arg0", arg0), new KeyValuePair("arg1", arg1));
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsOfProject", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public java.lang.String getSettingSmtpServer() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingSmtpServer", java.lang.String.class);
	}
	public java.lang.Boolean userHasCheckinRights(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasCheckinRights", java.lang.Boolean.class, new KeyValuePair("poid", poid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProject", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public java.lang.String getQueryEngineExample(java.lang.Long qeid, java.lang.String key) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getQueryEngineExample", java.lang.String.class, new KeyValuePair("qeid", qeid), new KeyValuePair("key", key));
	}
	public void addObjectIDM(org.bimserver.interfaces.objects.SObjectIDM objectIDM) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addObjectIDM", void.class, new KeyValuePair("objectIDM", objectIDM));
	}
	public org.bimserver.interfaces.objects.SIfcEngine getIfcEngineById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SIfcEngine) reflector.callMethod("ServiceInterface", "getIfcEngineById", org.bimserver.interfaces.objects.SIfcEngine.class, new KeyValuePair("oid", oid));
	}
	public java.lang.Boolean isSettingCacheOutputFiles() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingCacheOutputFiles", java.lang.Boolean.class);
	}
	public void unsetAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "unsetAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName));
	}
	public void setSettingFooterAddition(java.lang.String footerAddition) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingFooterAddition", void.class, new KeyValuePair("footerAddition", footerAddition));
	}
	public void setSettingHideUserListForNonAdmin(java.lang.Boolean hideUserListForNonAdmin) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingHideUserListForNonAdmin", void.class, new KeyValuePair("hideUserListForNonAdmin", hideUserListForNonAdmin));
	}
	public org.bimserver.interfaces.objects.SUser getUserByUoid(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getUserByUoid", org.bimserver.interfaces.objects.SUser.class, new KeyValuePair("uoid", uoid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getSubProjects(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getSubProjects", java.util.List.class, new KeyValuePair("poid", poid));
	}
	public void setSettingAllowUsersToCreateTopLevelProjects(java.lang.Boolean allowUsersToCreateTopLevelProjects) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingAllowUsersToCreateTopLevelProjects", void.class, new KeyValuePair("allowUsersToCreateTopLevelProjects", allowUsersToCreateTopLevelProjects));
	}
	public void setDefaultQueryEngine(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultQueryEngine", void.class, new KeyValuePair("arg0", arg0));
	}
	public java.lang.Boolean isSettingAllowUsersToCreateTopLevelProjects() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingAllowUsersToCreateTopLevelProjects", java.lang.Boolean.class);
	}
	public java.lang.Integer checkout(java.lang.Long roid, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkout", java.lang.Integer.class, new KeyValuePair("roid", roid), new KeyValuePair("serializerName", serializerName), new KeyValuePair("sync", sync));
	}
	public java.util.List<org.bimserver.interfaces.objects.SDeserializer> getAllDeserializers(java.lang.Boolean oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SDeserializer>) reflector.callMethod("ServiceInterface", "getAllDeserializers", java.util.List.class, new KeyValuePair("oid", oid));
	}
	public org.bimserver.interfaces.objects.SObjectIDM getObjectIDMByName(java.lang.String objectIDMName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SObjectIDM) reflector.callMethod("ServiceInterface", "getObjectIDMByName", org.bimserver.interfaces.objects.SObjectIDM.class, new KeyValuePair("objectIDMName", objectIDMName));
	}
	public void setHttpCallback(java.lang.Long uoid, java.lang.String address) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setHttpCallback", void.class, new KeyValuePair("uoid", uoid), new KeyValuePair("address", address));
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerByName(java.lang.String deserializerName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerByName", org.bimserver.interfaces.objects.SDeserializer.class, new KeyValuePair("deserializerName", deserializerName));
	}
	public void addModelCompare(org.bimserver.interfaces.objects.SModelCompare modelCompare) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addModelCompare", void.class, new KeyValuePair("modelCompare", modelCompare));
	}
	public java.util.List<org.bimserver.interfaces.objects.SModelCompare> getAllModelCompares(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SModelCompare>) reflector.callMethod("ServiceInterface", "getAllModelCompares", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public java.lang.Integer getSettingProtocolBuffersPort() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "getSettingProtocolBuffersPort", java.lang.Integer.class);
	}
	public org.bimserver.interfaces.objects.SDownloadResult getDownloadData(java.lang.Integer actionId) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDownloadResult) reflector.callMethod("ServiceInterface", "getDownloadData", org.bimserver.interfaces.objects.SDownloadResult.class, new KeyValuePair("actionId", actionId));
	}
	public void updateRevision(org.bimserver.interfaces.objects.SRevision sRevision) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateRevision", void.class, new KeyValuePair("sRevision", sRevision));
	}
	public org.bimserver.interfaces.objects.SUser getLoggedInUser() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SUser) reflector.callMethod("ServiceInterface", "getLoggedInUser", org.bimserver.interfaces.objects.SUser.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema> getAllExtendedDataSchemas() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SExtendedDataSchema>) reflector.callMethod("ServiceInterface", "getAllExtendedDataSchemas", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SModelCompare getDefaultModelCompare() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelCompare) reflector.callMethod("ServiceInterface", "getDefaultModelCompare", org.bimserver.interfaces.objects.SModelCompare.class);
	}
	public org.bimserver.interfaces.objects.SLongActionState getDownloadState(java.lang.Integer actionId) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SLongActionState) reflector.callMethod("ServiceInterface", "getDownloadState", org.bimserver.interfaces.objects.SLongActionState.class, new KeyValuePair("actionId", actionId));
	}
	public void updateGeoTag(org.bimserver.interfaces.objects.SGeoTag sGeoTag) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateGeoTag", void.class, new KeyValuePair("sGeoTag", sGeoTag));
	}
	public java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor> getAllPlugins() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllPlugins", java.util.List.class);
	}
	public java.lang.String ping(java.lang.String in) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "ping", java.lang.String.class, new KeyValuePair("in", in));
	}
	public void removeReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Integer index) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeReference", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("referenceName", referenceName), new KeyValuePair("index", index));
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializer> getAllSerializers(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializer>) reflector.callMethod("ServiceInterface", "getAllSerializers", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsOfRevision(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsOfRevision", java.util.List.class, new KeyValuePair("roid", roid));
	}
	public void addQueryEngine(org.bimserver.interfaces.objects.SQueryEngine queryEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addQueryEngine", void.class, new KeyValuePair("queryEngine", queryEngine));
	}
	public org.bimserver.interfaces.objects.SSerializer getSerializerById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getSerializerById", org.bimserver.interfaces.objects.SSerializer.class, new KeyValuePair("oid", oid));
	}
	public java.lang.Integer checkoutLastRevision(java.lang.Long poid, java.lang.String serializerName, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkoutLastRevision", java.lang.Integer.class, new KeyValuePair("poid", poid), new KeyValuePair("serializerName", serializerName), new KeyValuePair("sync", sync));
	}
	public java.lang.String getSettingEmailSenderAddress() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingEmailSenderAddress", java.lang.String.class);
	}
	public org.bimserver.interfaces.objects.SCheckinResult getCheckinState(java.lang.Integer actionID) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "getCheckinState", org.bimserver.interfaces.objects.SCheckinResult.class, new KeyValuePair("actionID", actionID));
	}
	public org.bimserver.interfaces.objects.SModelMerger getModelMergerByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelMerger) reflector.callMethod("ServiceInterface", "getModelMergerByName", org.bimserver.interfaces.objects.SModelMerger.class, new KeyValuePair("name", name));
	}
	public void disablePlugin(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "disablePlugin", void.class, new KeyValuePair("arg0", arg0));
	}
	public void sendCompareEmail(org.bimserver.interfaces.objects.SCompareType sCompareType, java.lang.Long mcid, java.lang.Long poid, java.lang.Long roid1, java.lang.Long roid2, java.lang.String address) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "sendCompareEmail", void.class, new KeyValuePair("sCompareType", sCompareType), new KeyValuePair("mcid", mcid), new KeyValuePair("poid", poid), new KeyValuePair("roid1", roid1), new KeyValuePair("roid2", roid2), new KeyValuePair("address", address));
	}
	public java.lang.Boolean login(java.lang.String username, java.lang.String password) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "login", java.lang.Boolean.class, new KeyValuePair("username", username), new KeyValuePair("password", password));
	}
	public java.lang.Boolean undeleteProject(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "undeleteProject", java.lang.Boolean.class, new KeyValuePair("poid", poid));
	}
	public java.lang.Long commitTransaction(java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Long) reflector.callMethod("ServiceInterface", "commitTransaction", java.lang.Long.class, new KeyValuePair("comment", comment));
	}
	public org.bimserver.interfaces.objects.SCheckinResult branchToNewProject(java.lang.Long roid, java.lang.String projectName, java.lang.String comment) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCheckinResult) reflector.callMethod("ServiceInterface", "branchToNewProject", org.bimserver.interfaces.objects.SCheckinResult.class, new KeyValuePair("roid", roid), new KeyValuePair("projectName", projectName), new KeyValuePair("comment", comment));
	}
	public java.util.List<org.bimserver.interfaces.objects.SProject> getAllNonAuthorizedProjectsOfUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SProject>) reflector.callMethod("ServiceInterface", "getAllNonAuthorizedProjectsOfUser", java.util.List.class, new KeyValuePair("uoid", uoid));
	}
	public void addExtendedDataToRevision(java.lang.Long roid, org.bimserver.interfaces.objects.SExtendedData extendedData) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addExtendedDataToRevision", void.class, new KeyValuePair("roid", roid), new KeyValuePair("extendedData", extendedData));
	}
	public void addIfcEngine(org.bimserver.interfaces.objects.SIfcEngine ifcEngine) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addIfcEngine", void.class, new KeyValuePair("ifcEngine", ifcEngine));
	}
	public org.bimserver.interfaces.objects.SModelMerger getDefaultModelMerger() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelMerger) reflector.callMethod("ServiceInterface", "getDefaultModelMerger", org.bimserver.interfaces.objects.SModelMerger.class);
	}
	public org.bimserver.interfaces.objects.SModelCompare getModelCompareByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelCompare) reflector.callMethod("ServiceInterface", "getModelCompareByName", org.bimserver.interfaces.objects.SModelCompare.class, new KeyValuePair("name", name));
	}
	public void setSettingCustomLogoAddress(java.lang.String customLogoAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingCustomLogoAddress", void.class, new KeyValuePair("customLogoAddress", customLogoAddress));
	}
	public org.bimserver.interfaces.objects.SRevision getRevision(java.lang.Long roid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SRevision) reflector.callMethod("ServiceInterface", "getRevision", org.bimserver.interfaces.objects.SRevision.class, new KeyValuePair("roid", roid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SUser> getAllUsers() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SUser>) reflector.callMethod("ServiceInterface", "getAllUsers", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SRevision> getAllRevisionsByUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SRevision>) reflector.callMethod("ServiceInterface", "getAllRevisionsByUser", java.util.List.class, new KeyValuePair("uoid", uoid));
	}
	public org.bimserver.interfaces.objects.SExternalProfile getExternalProfile(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SExternalProfile) reflector.callMethod("ServiceInterface", "getExternalProfile", org.bimserver.interfaces.objects.SExternalProfile.class, new KeyValuePair("arg0", arg0));
	}
	public void addBooleanAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.Boolean value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addBooleanAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.lang.Boolean autologin(java.lang.String username, java.lang.String hash) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "autologin", java.lang.Boolean.class, new KeyValuePair("username", username), new KeyValuePair("hash", hash));
	}
	public java.lang.Boolean isSettingShowVersionUpgradeAvailable() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingShowVersionUpgradeAvailable", java.lang.Boolean.class);
	}
	public void setSettingAllowSelfRegistration(java.lang.Boolean allowSelfRegistration) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingAllowSelfRegistration", void.class, new KeyValuePair("allowSelfRegistration", allowSelfRegistration));
	}
	public java.util.List<org.bimserver.interfaces.objects.SIfcEngine> getAllIfcEngines(java.lang.Boolean onlyEnabled) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SIfcEngine>) reflector.callMethod("ServiceInterface", "getAllIfcEngines", java.util.List.class, new KeyValuePair("onlyEnabled", onlyEnabled));
	}
	public java.lang.Boolean isSettingHideUserListForNonAdmin() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingHideUserListForNonAdmin", java.lang.Boolean.class);
	}
	public void setEnumAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setEnumAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.lang.Boolean userHasRights(java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "userHasRights", java.lang.Boolean.class, new KeyValuePair("poid", poid));
	}
	public org.bimserver.interfaces.objects.SQueryEngine getQueryEngineByName(java.lang.String name) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SQueryEngine) reflector.callMethod("ServiceInterface", "getQueryEngineByName", org.bimserver.interfaces.objects.SQueryEngine.class, new KeyValuePair("name", name));
	}
	public org.bimserver.interfaces.objects.SExternalServer getExternalServer(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SExternalServer) reflector.callMethod("ServiceInterface", "getExternalServer", org.bimserver.interfaces.objects.SExternalServer.class, new KeyValuePair("arg0", arg0));
	}
	public org.bimserver.interfaces.objects.SDataObject getDataObjectByGuid(java.lang.Long roid, java.lang.String guid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDataObject) reflector.callMethod("ServiceInterface", "getDataObjectByGuid", org.bimserver.interfaces.objects.SDataObject.class, new KeyValuePair("roid", roid), new KeyValuePair("guid", guid));
	}
	public void setSettingShowVersionUpgradeAvailable(java.lang.Boolean showVersionUpgradeAvailable) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingShowVersionUpgradeAvailable", void.class, new KeyValuePair("showVersionUpgradeAvailable", showVersionUpgradeAvailable));
	}
	public void setReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName, java.lang.Long referenceOid, java.lang.String referenceClassName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setReference", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("referenceName", referenceName), new KeyValuePair("referenceOid", referenceOid), new KeyValuePair("referenceClassName", referenceClassName));
	}
	public org.bimserver.interfaces.objects.SExtendedData getExtendedData(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SExtendedData) reflector.callMethod("ServiceInterface", "getExtendedData", org.bimserver.interfaces.objects.SExtendedData.class, new KeyValuePair("oid", oid));
	}
	public void deleteIfcEngine(java.lang.Long iid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteIfcEngine", void.class, new KeyValuePair("iid", iid));
	}
	public void updateModelMerger(org.bimserver.interfaces.objects.SModelMerger modelMerger) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateModelMerger", void.class, new KeyValuePair("modelMerger", modelMerger));
	}
	public org.bimserver.interfaces.objects.SDeserializer getDeserializerById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDeserializer) reflector.callMethod("ServiceInterface", "getDeserializerById", org.bimserver.interfaces.objects.SDeserializer.class, new KeyValuePair("oid", oid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor> getAllSerializerPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SSerializerPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllSerializerPluginDescriptors", java.util.List.class);
	}
	public org.bimserver.interfaces.objects.SDatabaseInformation getDatabaseInformation() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SDatabaseInformation) reflector.callMethod("ServiceInterface", "getDatabaseInformation", org.bimserver.interfaces.objects.SDatabaseInformation.class);
	}
	public void setDefaultIfcEngine(long arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setDefaultIfcEngine", void.class, new KeyValuePair("arg0", arg0));
	}
	public void deleteQueryEngine(java.lang.Long iid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "deleteQueryEngine", void.class, new KeyValuePair("iid", iid));
	}
	public java.lang.Integer checkin(java.lang.Long poid, java.lang.String comment, java.lang.String deserializerName, java.lang.Long fileSize, javax.activation.DataHandler ifcFile, java.lang.Boolean merge, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "checkin", java.lang.Integer.class, new KeyValuePair("poid", poid), new KeyValuePair("comment", comment), new KeyValuePair("deserializerName", deserializerName), new KeyValuePair("fileSize", fileSize), new KeyValuePair("ifcFile", ifcFile), new KeyValuePair("merge", merge), new KeyValuePair("sync", sync));
	}
	public java.lang.Integer download(java.lang.Long roid, java.lang.String serializerName, java.lang.Boolean showOwn, java.lang.Boolean sync) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Integer) reflector.callMethod("ServiceInterface", "download", java.lang.Integer.class, new KeyValuePair("roid", roid), new KeyValuePair("serializerName", serializerName), new KeyValuePair("showOwn", showOwn), new KeyValuePair("sync", sync));
	}
	public void removeUserFromExtendedDataSchema(java.lang.Long uoid, java.lang.Long edsid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "removeUserFromExtendedDataSchema", void.class, new KeyValuePair("uoid", uoid), new KeyValuePair("edsid", edsid));
	}
	public void updateObjectIDM(org.bimserver.interfaces.objects.SObjectIDM objectIDM) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "updateObjectIDM", void.class, new KeyValuePair("objectIDM", objectIDM));
	}
	public void addStringAttribute(java.lang.Long oid, java.lang.String className, java.lang.String attributeName, java.lang.String value) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addStringAttribute", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("attributeName", attributeName), new KeyValuePair("value", value));
	}
	public java.lang.Boolean removeUserFromProject(java.lang.Long uoid, java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "removeUserFromProject", java.lang.Boolean.class, new KeyValuePair("uoid", uoid), new KeyValuePair("poid", poid));
	}
	public java.util.List<org.bimserver.interfaces.objects.SLogAction> getLogs() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SLogAction>) reflector.callMethod("ServiceInterface", "getLogs", java.util.List.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SCheckout> getAllCheckoutsByUser(java.lang.Long uoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SCheckout>) reflector.callMethod("ServiceInterface", "getAllCheckoutsByUser", java.util.List.class, new KeyValuePair("uoid", uoid));
	}
	public java.lang.Boolean addUserToProject(java.lang.Long uoid, java.lang.Long poid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "addUserToProject", java.lang.Boolean.class, new KeyValuePair("uoid", uoid), new KeyValuePair("poid", poid));
	}
	public java.util.Date getServerStartTime() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getServerStartTime", java.util.Date.class);
	}
	public java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor> getAllObjectIDMPluginDescriptors() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.List<org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor>) reflector.callMethod("ServiceInterface", "getAllObjectIDMPluginDescriptors", java.util.List.class);
	}
	public java.lang.String getSettingFooterAddition() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.String) reflector.callMethod("ServiceInterface", "getSettingFooterAddition", java.lang.String.class);
	}
	public java.lang.Boolean changePassword(java.lang.Long uoid, java.lang.String oldPassword, java.lang.String newPassword) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "changePassword", java.lang.Boolean.class, new KeyValuePair("uoid", uoid), new KeyValuePair("oldPassword", oldPassword), new KeyValuePair("newPassword", newPassword));
	}
	public java.util.Date getActiveSince() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getActiveSince", java.util.Date.class);
	}
	public void unsetReference(java.lang.Long oid, java.lang.String className, java.lang.String referenceName) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "unsetReference", void.class, new KeyValuePair("oid", oid), new KeyValuePair("className", className), new KeyValuePair("referenceName", referenceName));
	}
	public void addSerializer(org.bimserver.interfaces.objects.SSerializer serializer) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "addSerializer", void.class, new KeyValuePair("serializer", serializer));
	}
	public void setSettingSiteAddress(java.lang.String siteAddress) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setSettingSiteAddress", void.class, new KeyValuePair("siteAddress", siteAddress));
	}
	public java.lang.Boolean isSettingSendConfirmationEmailAfterRegistration() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.lang.Boolean) reflector.callMethod("ServiceInterface", "isSettingSendConfirmationEmailAfterRegistration", java.lang.Boolean.class);
	}
	public void abortTransaction() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "abortTransaction", void.class);
	}
	public org.bimserver.interfaces.objects.SSerializer getDefaultSerializer() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SSerializer) reflector.callMethod("ServiceInterface", "getDefaultSerializer", org.bimserver.interfaces.objects.SSerializer.class);
	}
	public void setServiceRepositoryUrl(java.lang.String arg0) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		reflector.callMethod("ServiceInterface", "setServiceRepositoryUrl", void.class, new KeyValuePair("arg0", arg0));
	}
	public java.util.Date getLastActive() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (java.util.Date) reflector.callMethod("ServiceInterface", "getLastActive", java.util.Date.class);
	}
	public org.bimserver.interfaces.objects.SModelCompare getModelCompareById(java.lang.Long oid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SModelCompare) reflector.callMethod("ServiceInterface", "getModelCompareById", org.bimserver.interfaces.objects.SModelCompare.class, new KeyValuePair("oid", oid));
	}
	public org.bimserver.interfaces.objects.SCompareResult compare(java.lang.Long roid1, java.lang.Long roid2, org.bimserver.interfaces.objects.SCompareType sCompareType, java.lang.Long mcid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SCompareResult) reflector.callMethod("ServiceInterface", "compare", org.bimserver.interfaces.objects.SCompareResult.class, new KeyValuePair("roid1", roid1), new KeyValuePair("roid2", roid2), new KeyValuePair("sCompareType", sCompareType), new KeyValuePair("mcid", mcid));
	}
	public org.bimserver.interfaces.objects.SAccessMethod getAccessMethod() throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SAccessMethod) reflector.callMethod("ServiceInterface", "getAccessMethod", org.bimserver.interfaces.objects.SAccessMethod.class);
	}
	public org.bimserver.interfaces.objects.SProject addProjectAsSubProject(java.lang.String projectName, java.lang.Long parentPoid) throws org.bimserver.shared.exceptions.UserException, org.bimserver.shared.exceptions.ServerException {
		return (org.bimserver.interfaces.objects.SProject) reflector.callMethod("ServiceInterface", "addProjectAsSubProject", org.bimserver.interfaces.objects.SProject.class, new KeyValuePair("projectName", projectName), new KeyValuePair("parentPoid", parentPoid));
	}
}
