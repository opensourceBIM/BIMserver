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
package org.bimserver.models.store.impl;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.Deserializer;
import org.bimserver.models.store.EService;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.ModelCompare;
import org.bimserver.models.store.ModelMerger;
import org.bimserver.models.store.ObjectIDM;
import org.bimserver.models.store.QueryEngine;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.UserSettings;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getObjectIDMs <em>Object ID Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getIfcEngines <em>Ifc Engines</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDeserializers <em>Deserializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getQueryengines <em>Queryengines</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getModelmergers <em>Modelmergers</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getModelcompares <em>Modelcompares</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultModelMerger <em>Default Model Merger</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultModelCompare <em>Default Model Compare</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultQueryEngine <em>Default Query Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultIfcEngine <em>Default Ifc Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultSerializer <em>Default Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getDefaultObjectIDM <em>Default Object IDM</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.UserSettingsImpl#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserSettingsImpl extends IdEObjectImpl implements UserSettings {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UserSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.USER_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Serializer> getSerializers() {
		return (EList<Serializer>) eGet(StorePackage.Literals.USER_SETTINGS__SERIALIZERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ObjectIDM> getObjectIDMs() {
		return (EList<ObjectIDM>) eGet(StorePackage.Literals.USER_SETTINGS__OBJECT_ID_MS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcEngine> getIfcEngines() {
		return (EList<IfcEngine>) eGet(StorePackage.Literals.USER_SETTINGS__IFC_ENGINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Deserializer> getDeserializers() {
		return (EList<Deserializer>) eGet(StorePackage.Literals.USER_SETTINGS__DESERIALIZERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<QueryEngine> getQueryengines() {
		return (EList<QueryEngine>) eGet(StorePackage.Literals.USER_SETTINGS__QUERYENGINES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ModelMerger> getModelmergers() {
		return (EList<ModelMerger>) eGet(StorePackage.Literals.USER_SETTINGS__MODELMERGERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ModelCompare> getModelcompares() {
		return (EList<ModelCompare>) eGet(StorePackage.Literals.USER_SETTINGS__MODELCOMPARES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelMerger getDefaultModelMerger() {
		return (ModelMerger) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_MODEL_MERGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultModelMerger(ModelMerger newDefaultModelMerger) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_MODEL_MERGER, newDefaultModelMerger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelCompare getDefaultModelCompare() {
		return (ModelCompare) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_MODEL_COMPARE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultModelCompare(ModelCompare newDefaultModelCompare) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_MODEL_COMPARE, newDefaultModelCompare);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEngine getDefaultQueryEngine() {
		return (QueryEngine) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_QUERY_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultQueryEngine(QueryEngine newDefaultQueryEngine) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_QUERY_ENGINE, newDefaultQueryEngine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEngine getDefaultIfcEngine() {
		return (IfcEngine) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_IFC_ENGINE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultIfcEngine(IfcEngine newDefaultIfcEngine) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_IFC_ENGINE, newDefaultIfcEngine);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Serializer getDefaultSerializer() {
		return (Serializer) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_SERIALIZER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultSerializer(Serializer newDefaultSerializer) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_SERIALIZER, newDefaultSerializer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectIDM getDefaultObjectIDM() {
		return (ObjectIDM) eGet(StorePackage.Literals.USER_SETTINGS__DEFAULT_OBJECT_IDM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultObjectIDM(ObjectIDM newDefaultObjectIDM) {
		eSet(StorePackage.Literals.USER_SETTINGS__DEFAULT_OBJECT_IDM, newDefaultObjectIDM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<EService> getServices() {
		return (EList<EService>) eGet(StorePackage.Literals.USER_SETTINGS__SERVICES, true);
	}

} //UserSettingsImpl
