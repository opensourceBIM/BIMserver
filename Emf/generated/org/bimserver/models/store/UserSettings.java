/**
 * Copyright (C) 2011  BIMserver.org
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
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.UserSettings#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getObjectIDMs <em>Object ID Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getIfcEngines <em>Ifc Engines</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDeserializers <em>Deserializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getQueryengines <em>Queryengines</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getModelmergers <em>Modelmergers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getModelcompares <em>Modelcompares</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultModelMerger <em>Default Model Merger</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultModelCompare <em>Default Model Compare</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultQueryEngine <em>Default Query Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultIfcEngine <em>Default Ifc Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultSerializer <em>Default Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultObjectIDM <em>Default Object IDM</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getUserSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface UserSettings extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Serializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Serializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Serializers()
	 * @see org.bimserver.models.store.Serializer#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Serializer> getSerializers();

	/**
	 * Returns the value of the '<em><b>Object ID Ms</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ObjectIDM}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ObjectIDM#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object ID Ms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object ID Ms</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_ObjectIDMs()
	 * @see org.bimserver.models.store.ObjectIDM#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ObjectIDM> getObjectIDMs();

	/**
	 * Returns the value of the '<em><b>Ifc Engines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.IfcEngine}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IfcEngine#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Engines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Engines</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_IfcEngines()
	 * @see org.bimserver.models.store.IfcEngine#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<IfcEngine> getIfcEngines();

	/**
	 * Returns the value of the '<em><b>Deserializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.Deserializer}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.Deserializer#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deserializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deserializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Deserializers()
	 * @see org.bimserver.models.store.Deserializer#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<Deserializer> getDeserializers();

	/**
	 * Returns the value of the '<em><b>Queryengines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.QueryEngine}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.QueryEngine#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queryengines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queryengines</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Queryengines()
	 * @see org.bimserver.models.store.QueryEngine#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<QueryEngine> getQueryengines();

	/**
	 * Returns the value of the '<em><b>Modelmergers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ModelMerger}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ModelMerger#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelmergers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelmergers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Modelmergers()
	 * @see org.bimserver.models.store.ModelMerger#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ModelMerger> getModelmergers();

	/**
	 * Returns the value of the '<em><b>Modelcompares</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ModelCompare}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ModelCompare#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelcompares</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelcompares</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Modelcompares()
	 * @see org.bimserver.models.store.ModelCompare#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ModelCompare> getModelcompares();

	/**
	 * Returns the value of the '<em><b>Default Model Merger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Model Merger</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Model Merger</em>' reference.
	 * @see #setDefaultModelMerger(ModelMerger)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultModelMerger()
	 * @model
	 * @generated
	 */
	ModelMerger getDefaultModelMerger();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultModelMerger <em>Default Model Merger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Model Merger</em>' reference.
	 * @see #getDefaultModelMerger()
	 * @generated
	 */
	void setDefaultModelMerger(ModelMerger value);

	/**
	 * Returns the value of the '<em><b>Default Model Compare</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Model Compare</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Model Compare</em>' reference.
	 * @see #setDefaultModelCompare(ModelCompare)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultModelCompare()
	 * @model
	 * @generated
	 */
	ModelCompare getDefaultModelCompare();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultModelCompare <em>Default Model Compare</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Model Compare</em>' reference.
	 * @see #getDefaultModelCompare()
	 * @generated
	 */
	void setDefaultModelCompare(ModelCompare value);

	/**
	 * Returns the value of the '<em><b>Default Query Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Query Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Query Engine</em>' reference.
	 * @see #setDefaultQueryEngine(QueryEngine)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultQueryEngine()
	 * @model
	 * @generated
	 */
	QueryEngine getDefaultQueryEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultQueryEngine <em>Default Query Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Query Engine</em>' reference.
	 * @see #getDefaultQueryEngine()
	 * @generated
	 */
	void setDefaultQueryEngine(QueryEngine value);

	/**
	 * Returns the value of the '<em><b>Default Ifc Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Ifc Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Ifc Engine</em>' reference.
	 * @see #setDefaultIfcEngine(IfcEngine)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultIfcEngine()
	 * @model
	 * @generated
	 */
	IfcEngine getDefaultIfcEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultIfcEngine <em>Default Ifc Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Ifc Engine</em>' reference.
	 * @see #getDefaultIfcEngine()
	 * @generated
	 */
	void setDefaultIfcEngine(IfcEngine value);

	/**
	 * Returns the value of the '<em><b>Default Serializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Serializer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Serializer</em>' reference.
	 * @see #setDefaultSerializer(Serializer)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultSerializer()
	 * @model
	 * @generated
	 */
	Serializer getDefaultSerializer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultSerializer <em>Default Serializer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Serializer</em>' reference.
	 * @see #getDefaultSerializer()
	 * @generated
	 */
	void setDefaultSerializer(Serializer value);

	/**
	 * Returns the value of the '<em><b>Default Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Object IDM</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Object IDM</em>' reference.
	 * @see #setDefaultObjectIDM(ObjectIDM)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultObjectIDM()
	 * @model
	 * @generated
	 */
	ObjectIDM getDefaultObjectIDM();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultObjectIDM <em>Default Object IDM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Object IDM</em>' reference.
	 * @see #getDefaultObjectIDM()
	 * @generated
	 */
	void setDefaultObjectIDM(ObjectIDM value);

} // UserSettings
